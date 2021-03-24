package com.baidu.searchbox.afx.decode;

import android.app.ActivityManager;
import android.content.pm.ConfigurationInfo;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnReportListener;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.PlaySuccessInfo;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.kwai.video.player.misc.IMediaFormat;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class VideoPlayer {
    public static final int DEFAULT_FPS = 25;
    public static final int MEDIA_INFO_EXTRA_NONE = 0;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final String TAG = "VideoPlayer";
    public static final boolean VERBOSE = false;
    public long mDurationUs;
    public FrameCallback mFrameCallback;
    public GLTextureView mGLTextureView;
    public volatile boolean mIsPauseRequested;
    public volatile boolean mIsStopRequested;
    public boolean mLoop;
    public MediaCodec mMediaDecoder;
    public MediaExtractor mMediaExtractor;
    public OnInfoListener mOnInfoListener;
    public Surface mOutputSurface;
    public int mVideoHeight;
    public int mVideoWidth;
    public MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
    public int mFps = 25;
    public volatile long mStartFrameTimeUs = 0;
    public volatile int mPlayFrames = Integer.MAX_VALUE;

    /* loaded from: classes2.dex */
    public interface FrameCallback {
        void loopReset();

        void preRender(long j);

        void reset();
    }

    /* loaded from: classes2.dex */
    public interface OnInfoListener {
        boolean onInfo(VideoPlayer videoPlayer, int i, int i2);
    }

    /* loaded from: classes2.dex */
    public static class PlayTask implements Runnable {
        public static final int MSG_PLAY_ERROR = 1;
        public static final int MSG_PLAY_STOPPED = 0;
        public LocalHandler mLocalHandler;
        public VideoPlayer mPlayer;
        public String mPrepareTime;
        public final Object mStopLock = new Object();
        public boolean mStopped = false;
        public Thread mThread;

        /* loaded from: classes2.dex */
        public static class LocalHandler extends Handler {
            public OnVideoEndedListener mOnEndedListener;
            public OnVideoErrorListener mOnErrorListener;
            public OnReportListener mOnReportListener;

            public LocalHandler(OnVideoEndedListener onVideoEndedListener, OnVideoErrorListener onVideoErrorListener, OnReportListener onReportListener) {
                this.mOnEndedListener = onVideoEndedListener;
                this.mOnErrorListener = onVideoErrorListener;
                this.mOnReportListener = onReportListener;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    String str = (String) message.obj;
                    OnVideoEndedListener onVideoEndedListener = this.mOnEndedListener;
                    if (onVideoEndedListener != null) {
                        onVideoEndedListener.onVideoEnded();
                    }
                    if (this.mOnReportListener != null) {
                        this.mOnReportListener.onSuccess(new PlaySuccessInfo(null, String.valueOf(System.currentTimeMillis() / 1000), str));
                    }
                } else if (i != 1) {
                } else {
                    String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                    OnReportListener onReportListener = this.mOnReportListener;
                    if (onReportListener != null) {
                        onReportListener.onError(new ErrorInfo(16, ErrorInfo.VIDEO_PLAY_SOURCE_ERROR_ERRORMSG, (Exception) message.obj, null, null, null, valueOf));
                    }
                    OnVideoErrorListener onVideoErrorListener = this.mOnErrorListener;
                    if (onVideoErrorListener != null) {
                        onVideoErrorListener.onError(new ErrorInfo(16, ErrorInfo.VIDEO_PLAY_SOURCE_ERROR_ERRORMSG, (Exception) message.obj, null, null, null, valueOf));
                    }
                }
            }
        }

        public PlayTask(VideoPlayer videoPlayer, OnVideoEndedListener onVideoEndedListener, OnVideoErrorListener onVideoErrorListener, OnReportListener onReportListener) {
            this.mPlayer = videoPlayer;
            this.mLocalHandler = new LocalHandler(onVideoEndedListener, onVideoErrorListener, onReportListener);
        }

        public void execute() {
            Thread thread = new Thread(this, "VideoPlayer$PlayTask");
            this.mThread = thread;
            thread.start();
        }

        public void release() {
            this.mPlayer = null;
            LocalHandler localHandler = this.mLocalHandler;
            if (localHandler != null) {
                localHandler.mOnEndedListener = null;
                this.mLocalHandler.mOnErrorListener = null;
                this.mLocalHandler.mOnReportListener = null;
                this.mLocalHandler = null;
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            LocalHandler localHandler;
            try {
                try {
                    this.mPrepareTime = String.valueOf(System.currentTimeMillis() / 1000);
                    this.mPlayer.play();
                    synchronized (this.mStopLock) {
                        this.mStopped = true;
                        this.mStopLock.notifyAll();
                    }
                    localHandler = this.mLocalHandler;
                    if (localHandler == null) {
                        return;
                    }
                } catch (Exception e2) {
                    boolean sendMessage = this.mLocalHandler != null ? this.mLocalHandler.sendMessage(this.mLocalHandler.obtainMessage(1, e2)) : false;
                    synchronized (this.mStopLock) {
                        this.mStopped = true;
                        this.mStopLock.notifyAll();
                        if (sendMessage || (localHandler = this.mLocalHandler) == null) {
                            return;
                        }
                    }
                }
                localHandler.sendMessage(localHandler.obtainMessage(0, this.mPrepareTime));
            } catch (Throwable th) {
                synchronized (this.mStopLock) {
                    this.mStopped = true;
                    this.mStopLock.notifyAll();
                    LocalHandler localHandler2 = this.mLocalHandler;
                    if (localHandler2 != null) {
                        localHandler2.sendMessage(localHandler2.obtainMessage(0, this.mPrepareTime));
                    }
                    throw th;
                }
            }
        }

        public void waitForStop() {
            synchronized (this.mStopLock) {
                while (!this.mStopped) {
                    try {
                        this.mStopLock.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r27v0, resolved type: android.media.MediaExtractor */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x017a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0150  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doExtract(MediaExtractor mediaExtractor, int i, MediaCodec mediaCodec, FrameCallback frameCallback) {
        ByteBuffer[] byteBufferArr;
        boolean z;
        int dequeueInputBuffer;
        GLTextureView gLTextureView = this.mGLTextureView;
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        long j = -1;
        ?? r10 = 0;
        long j2 = -1;
        int i2 = 1;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = true;
        while (!z2) {
            if (this.mIsStopRequested) {
                this.mIsPauseRequested = r10;
                this.mIsStopRequested = r10;
                return;
            }
            if (this.mIsPauseRequested) {
                synchronized (this) {
                    if (this.mIsPauseRequested) {
                        if (frameCallback != null) {
                            frameCallback.reset();
                        }
                        try {
                            wait();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            if (z3 || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) < 0) {
                byteBufferArr = inputBuffers;
                i2 = i2;
            } else {
                if (j2 == j) {
                    j2 = System.nanoTime();
                }
                long j3 = j2;
                int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], r10);
                if (readSampleData < 0) {
                    byteBufferArr = inputBuffers;
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                    i2 = i2;
                    j2 = j3;
                    z3 = true;
                    z4 = true;
                } else {
                    int i3 = i2;
                    byteBufferArr = inputBuffers;
                    if (mediaExtractor.getSampleTrackIndex() != i) {
                        Log.w(TAG, "WEIRD: got sample from track " + mediaExtractor.getSampleTrackIndex() + ", expected " + i);
                    }
                    if (z4 && i3 == this.mPlayFrames + 1) {
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        i2 = i3;
                        j2 = j3;
                        z3 = true;
                    } else {
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                        i2 = i3 + 1;
                        mediaExtractor.advance();
                        j2 = j3;
                    }
                }
            }
            if (!z2) {
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(this.mBufferInfo, 10000L);
                if (dequeueOutputBuffer != -1 && dequeueOutputBuffer != -3) {
                    if (dequeueOutputBuffer == -2) {
                        mediaCodec.getOutputFormat();
                    } else if (dequeueOutputBuffer >= 0) {
                        if (j2 != 0) {
                            System.nanoTime();
                            j2 = 0;
                        }
                        if ((this.mBufferInfo.flags & 4) == 0) {
                            z = false;
                        } else if (this.mLoop) {
                            z = true;
                        } else {
                            z = false;
                            z2 = true;
                        }
                        boolean z6 = this.mBufferInfo.size != 0;
                        if (z6 && frameCallback != null) {
                            frameCallback.preRender(this.mBufferInfo.presentationTimeUs);
                        }
                        if (gLTextureView != null) {
                            gLTextureView.requestRender();
                            OnInfoListener onInfoListener = this.mOnInfoListener;
                            if (onInfoListener != null && z5) {
                                onInfoListener.onInfo(this, 3, 0);
                                z5 = false;
                                mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z6);
                                if (gLTextureView != null) {
                                    gLTextureView.requestRender();
                                }
                                if (!z) {
                                    mediaExtractor.seekTo(this.mStartFrameTimeUs, 2);
                                    mediaCodec.flush();
                                    if (frameCallback != null) {
                                        frameCallback.loopReset();
                                    }
                                    i2 = 1;
                                    z3 = false;
                                }
                            }
                        }
                        mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z6);
                        if (gLTextureView != null) {
                        }
                        if (!z) {
                        }
                    } else {
                        throw new RuntimeException("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                    }
                }
            }
            inputBuffers = byteBufferArr;
            r10 = 0;
            j = -1;
        }
    }

    private void onDataSourceSet(MediaExtractor mediaExtractor) {
        int selectVideoTrackIndex = selectVideoTrackIndex(mediaExtractor);
        if (selectVideoTrackIndex >= 0) {
            mediaExtractor.selectTrack(selectVideoTrackIndex);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(selectVideoTrackIndex);
            this.mVideoWidth = trackFormat.getInteger("width");
            this.mVideoHeight = trackFormat.getInteger("height");
            this.mDurationUs = trackFormat.getLong("durationUs");
            try {
                this.mFps = trackFormat.getInteger("frame-rate");
                return;
            } catch (Exception e2) {
                Log.e(TAG, "get frame rate (FPS) failed.", e2);
                return;
            }
        }
        throw new RuntimeException("No video track found in source file.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() throws IOException {
        MediaExtractor mediaExtractor = this.mMediaExtractor;
        MediaCodec mediaCodec = this.mMediaDecoder;
        int selectVideoTrackIndex = selectVideoTrackIndex(mediaExtractor);
        if (selectVideoTrackIndex >= 0) {
            mediaExtractor.selectTrack(selectVideoTrackIndex);
            if (mediaCodec == null) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(selectVideoTrackIndex);
                MediaCodec createDecoderByType = MediaCodec.createDecoderByType(trackFormat.getString(IMediaFormat.KEY_MIME));
                Surface surface = this.mOutputSurface;
                if (surface != null) {
                    createDecoderByType.configure(trackFormat, surface, (MediaCrypto) null, 0);
                    createDecoderByType.start();
                    this.mMediaDecoder = createDecoderByType;
                    mediaCodec = createDecoderByType;
                } else {
                    throw new IllegalStateException("The output surface is not prepared.");
                }
            }
            doExtract(mediaExtractor, selectVideoTrackIndex, mediaCodec, this.mFrameCallback);
            mediaExtractor.seekTo(0L, 2);
            mediaCodec.flush();
            FrameCallback frameCallback = this.mFrameCallback;
            if (frameCallback != null) {
                frameCallback.reset();
                return;
            }
            return;
        }
        throw new RuntimeException("No video track found in source file.");
    }

    public static int selectVideoTrackIndex(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            if (mediaExtractor.getTrackFormat(i).getString(IMediaFormat.KEY_MIME).startsWith(FileUtils.VIDEO_FILE_START)) {
                return i;
            }
        }
        return -1;
    }

    public long getDuration() {
        return this.mDurationUs / 1000;
    }

    public int getFps() {
        return this.mFps;
    }

    public String getGlVersion() {
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        GLTextureView gLTextureView = this.mGLTextureView;
        if (gLTextureView == null || (activityManager = (ActivityManager) gLTextureView.getContext().getSystemService("activity")) == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null) {
            return null;
        }
        return deviceConfigurationInfo.getGlEsVersion();
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public void release() {
        MediaCodec mediaCodec = this.mMediaDecoder;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                this.mMediaDecoder.release();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.mMediaDecoder = null;
        }
        MediaExtractor mediaExtractor = this.mMediaExtractor;
        if (mediaExtractor != null) {
            try {
                mediaExtractor.release();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.mMediaExtractor = null;
        }
        Surface surface = this.mOutputSurface;
        if (surface != null) {
            try {
                surface.release();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            this.mOutputSurface = null;
        }
        this.mGLTextureView = null;
        this.mStartFrameTimeUs = 0L;
        this.mPlayFrames = Integer.MAX_VALUE;
    }

    public void requestPause() {
        this.mIsPauseRequested = true;
    }

    public void requestResume() {
        this.mIsPauseRequested = false;
        synchronized (this) {
            notifyAll();
        }
    }

    public void requestStop() {
        this.mIsStopRequested = true;
    }

    public void setDataSource(String str) throws IOException {
        setDataSource(new File(str));
    }

    public void setFrameCallback(FrameCallback frameCallback) {
        this.mFrameCallback = frameCallback;
    }

    public void setGLTextureView(GLTextureView gLTextureView) {
        this.mGLTextureView = gLTextureView;
    }

    public void setLoopSection(long j, long j2) {
        this.mStartFrameTimeUs = 1000 * j;
        double d2 = j2 - j;
        Double.isNaN(d2);
        double d3 = this.mFps;
        Double.isNaN(d3);
        this.mPlayFrames = ((int) ((d2 / 1000.0d) * d3)) + 1;
    }

    public void setLooping(boolean z) {
        this.mLoop = z;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setSurface(Surface surface) {
        this.mOutputSurface = surface;
    }

    public void setDataSource(File file) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                setDataSource(fileInputStream2.getFD());
                try {
                    fileInputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void setLoopSection(long j) {
        double d2 = this.mDurationUs;
        Double.isNaN(d2);
        setLoopSection(j, (long) (d2 / 1000.0d));
    }

    public void setLoopSection(int i, int i2) {
        double d2 = this.mFps;
        Double.isNaN(d2);
        double d3 = i;
        Double.isNaN(d3);
        this.mStartFrameTimeUs = (long) ((1000.0d / d2) * d3 * 1000.0d);
        this.mPlayFrames = (i2 - i) + 1;
    }

    public void setLoopSection(int i) {
        double d2 = this.mDurationUs;
        Double.isNaN(d2);
        double d3 = this.mFps;
        Double.isNaN(d3);
        setLoopSection(i, (int) ((d2 / 1000000.0d) * d3));
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.mMediaExtractor = mediaExtractor;
        mediaExtractor.setDataSource(fileDescriptor);
        onDataSourceSet(this.mMediaExtractor);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.mMediaExtractor = mediaExtractor;
        mediaExtractor.setDataSource(fileDescriptor, j, j2);
        onDataSourceSet(this.mMediaExtractor);
    }
}
