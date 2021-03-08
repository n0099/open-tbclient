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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class VideoPlayer {
    private static final int DEFAULT_FPS = 25;
    public static final int MEDIA_INFO_EXTRA_NONE = 0;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    private static final String TAG = "VideoPlayer";
    private static final boolean VERBOSE = false;
    private long mDurationUs;
    private FrameCallback mFrameCallback;
    private GLTextureView mGLTextureView;
    private volatile boolean mIsPauseRequested;
    private volatile boolean mIsStopRequested;
    private boolean mLoop;
    private MediaCodec mMediaDecoder;
    private MediaExtractor mMediaExtractor;
    private OnInfoListener mOnInfoListener;
    private Surface mOutputSurface;
    private int mVideoHeight;
    private int mVideoWidth;
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
    private int mFps = 25;
    private volatile long mStartFrameTimeUs = 0;
    private volatile int mPlayFrames = Integer.MAX_VALUE;

    /* loaded from: classes4.dex */
    public interface FrameCallback {
        void loopReset();

        void preRender(long j);

        void reset();
    }

    /* loaded from: classes4.dex */
    public interface OnInfoListener {
        boolean onInfo(VideoPlayer videoPlayer, int i, int i2);
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setLoopSection(long j, long j2) {
        this.mStartFrameTimeUs = 1000 * j;
        this.mPlayFrames = ((int) (((j2 - j) / 1000.0d) * this.mFps)) + 1;
    }

    public void setLoopSection(long j) {
        setLoopSection(j, (long) (this.mDurationUs / 1000.0d));
    }

    public void setLoopSection(int i, int i2) {
        this.mStartFrameTimeUs = (long) ((1000.0d / this.mFps) * i * 1000.0d);
        this.mPlayFrames = (i2 - i) + 1;
    }

    public void setLoopSection(int i) {
        setLoopSection(i, (int) ((this.mDurationUs / 1000000.0d) * this.mFps));
    }

    public void setSurface(Surface surface) {
        this.mOutputSurface = surface;
    }

    public void setDataSource(String str) throws IOException {
        setDataSource(new File(str));
    }

    public void setDataSource(File file) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                setDataSource(fileInputStream.getFD());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        this.mMediaExtractor = new MediaExtractor();
        this.mMediaExtractor.setDataSource(fileDescriptor);
        onDataSourceSet(this.mMediaExtractor);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        this.mMediaExtractor = new MediaExtractor();
        this.mMediaExtractor.setDataSource(fileDescriptor, j, j2);
        onDataSourceSet(this.mMediaExtractor);
    }

    private void onDataSourceSet(MediaExtractor mediaExtractor) {
        int selectVideoTrackIndex = selectVideoTrackIndex(mediaExtractor);
        if (selectVideoTrackIndex < 0) {
            throw new RuntimeException("No video track found in source file.");
        }
        mediaExtractor.selectTrack(selectVideoTrackIndex);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(selectVideoTrackIndex);
        this.mVideoWidth = trackFormat.getInteger("width");
        this.mVideoHeight = trackFormat.getInteger("height");
        this.mDurationUs = trackFormat.getLong("durationUs");
        try {
            this.mFps = trackFormat.getInteger("frame-rate");
        } catch (Exception e) {
            Log.e(TAG, "get frame rate (FPS) failed.", e);
        }
    }

    public void setFrameCallback(FrameCallback frameCallback) {
        this.mFrameCallback = frameCallback;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public long getDuration() {
        return this.mDurationUs / 1000;
    }

    public int getFps() {
        return this.mFps;
    }

    public void setLooping(boolean z) {
        this.mLoop = z;
    }

    public void setGLTextureView(GLTextureView gLTextureView) {
        this.mGLTextureView = gLTextureView;
    }

    public String getGlVersion() {
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        if (this.mGLTextureView == null || (activityManager = (ActivityManager) this.mGLTextureView.getContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null) {
            return null;
        }
        return deviceConfigurationInfo.getGlEsVersion();
    }

    public void requestStop() {
        this.mIsStopRequested = true;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void play() throws IOException {
        MediaExtractor mediaExtractor = this.mMediaExtractor;
        MediaCodec mediaCodec = this.mMediaDecoder;
        int selectVideoTrackIndex = selectVideoTrackIndex(mediaExtractor);
        if (selectVideoTrackIndex < 0) {
            throw new RuntimeException("No video track found in source file.");
        }
        mediaExtractor.selectTrack(selectVideoTrackIndex);
        if (mediaCodec == null) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(selectVideoTrackIndex);
            mediaCodec = MediaCodec.createDecoderByType(trackFormat.getString(IMediaFormat.KEY_MIME));
            if (this.mOutputSurface == null) {
                throw new IllegalStateException("The output surface is not prepared.");
            }
            mediaCodec.configure(trackFormat, this.mOutputSurface, (MediaCrypto) null, 0);
            mediaCodec.start();
            this.mMediaDecoder = mediaCodec;
        }
        doExtract(mediaExtractor, selectVideoTrackIndex, mediaCodec, this.mFrameCallback);
        mediaExtractor.seekTo(0L, 2);
        mediaCodec.flush();
        if (this.mFrameCallback != null) {
            this.mFrameCallback.reset();
        }
    }

    public void release() {
        if (this.mMediaDecoder != null) {
            try {
                this.mMediaDecoder.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.mMediaDecoder.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.mMediaDecoder = null;
        }
        if (this.mMediaExtractor != null) {
            try {
                this.mMediaExtractor.release();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.mMediaExtractor = null;
        }
        if (this.mOutputSurface != null) {
            try {
                this.mOutputSurface.release();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.mOutputSurface = null;
        }
        this.mGLTextureView = null;
        this.mStartFrameTimeUs = 0L;
        this.mPlayFrames = Integer.MAX_VALUE;
    }

    private static int selectVideoTrackIndex(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            if (mediaExtractor.getTrackFormat(i).getString(IMediaFormat.KEY_MIME).startsWith("video/")) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0195  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doExtract(MediaExtractor mediaExtractor, int i, MediaCodec mediaCodec, FrameCallback frameCallback) {
        boolean z;
        long j;
        int i2;
        boolean z2;
        boolean z3;
        int dequeueInputBuffer;
        GLTextureView gLTextureView = this.mGLTextureView;
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = true;
        boolean z7 = false;
        long j2 = -1;
        int i3 = 1;
        while (!z5) {
            if (this.mIsStopRequested) {
                this.mIsPauseRequested = false;
                this.mIsStopRequested = false;
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
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if (z7 || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) < 0) {
                z = z7;
                j = j2;
                i2 = i3;
            } else {
                long nanoTime = j2 == -1 ? System.nanoTime() : j2;
                int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                if (readSampleData < 0) {
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                    z = true;
                    z4 = true;
                    j = nanoTime;
                    i2 = i3;
                } else {
                    if (mediaExtractor.getSampleTrackIndex() != i) {
                        Log.w(TAG, "WEIRD: got sample from track " + mediaExtractor.getSampleTrackIndex() + ", expected " + i);
                    }
                    if (z4 && i3 == this.mPlayFrames + 1) {
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        z = true;
                        j = nanoTime;
                        i2 = i3;
                    } else {
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                        i2 = i3 + 1;
                        mediaExtractor.advance();
                        z = z7;
                        j = nanoTime;
                    }
                }
            }
            if (z5) {
                z7 = z;
                j2 = j;
                i3 = i2;
            } else {
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(this.mBufferInfo, 10000L);
                if (dequeueOutputBuffer != -1 && dequeueOutputBuffer != -3) {
                    if (dequeueOutputBuffer == -2) {
                        mediaCodec.getOutputFormat();
                    } else if (dequeueOutputBuffer < 0) {
                        throw new RuntimeException("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                    } else {
                        if (j != 0) {
                            System.nanoTime();
                            j = 0;
                        }
                        boolean z8 = false;
                        if ((this.mBufferInfo.flags & 4) == 0) {
                            z2 = z5;
                        } else if (this.mLoop) {
                            z8 = true;
                            z2 = z5;
                        } else {
                            z2 = true;
                        }
                        boolean z9 = this.mBufferInfo.size != 0;
                        if (z9 && frameCallback != null) {
                            frameCallback.preRender(this.mBufferInfo.presentationTimeUs);
                        }
                        if (gLTextureView != null) {
                            gLTextureView.requestRender();
                            if (this.mOnInfoListener != null && z6) {
                                z3 = false;
                                this.mOnInfoListener.onInfo(this, 3, 0);
                                mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z9);
                                if (gLTextureView != null) {
                                    gLTextureView.requestRender();
                                }
                                if (z8) {
                                    z6 = z3;
                                    z5 = z2;
                                } else {
                                    i2 = 1;
                                    mediaExtractor.seekTo(this.mStartFrameTimeUs, 2);
                                    mediaCodec.flush();
                                    if (frameCallback != null) {
                                        frameCallback.loopReset();
                                    }
                                    z6 = z3;
                                    z = false;
                                    z5 = z2;
                                }
                            }
                        }
                        z3 = z6;
                        mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z9);
                        if (gLTextureView != null) {
                        }
                        if (z8) {
                        }
                    }
                }
                z7 = z;
                j2 = j;
                i3 = i2;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class PlayTask implements Runnable {
        private static final int MSG_PLAY_ERROR = 1;
        private static final int MSG_PLAY_STOPPED = 0;
        private LocalHandler mLocalHandler;
        private VideoPlayer mPlayer;
        private String mPrepareTime;
        private final Object mStopLock = new Object();
        private boolean mStopped = false;
        private Thread mThread;

        public PlayTask(VideoPlayer videoPlayer, OnVideoEndedListener onVideoEndedListener, OnVideoErrorListener onVideoErrorListener, OnReportListener onReportListener) {
            this.mPlayer = videoPlayer;
            this.mLocalHandler = new LocalHandler(onVideoEndedListener, onVideoErrorListener, onReportListener);
        }

        public void execute() {
            this.mThread = new Thread(this, "VideoPlayer$PlayTask");
            this.mThread.start();
        }

        public void release() {
            this.mPlayer = null;
            if (this.mLocalHandler == null) {
                return;
            }
            this.mLocalHandler.mOnEndedListener = null;
            this.mLocalHandler.mOnErrorListener = null;
            this.mLocalHandler.mOnReportListener = null;
            this.mLocalHandler = null;
        }

        public void waitForStop() {
            synchronized (this.mStopLock) {
                while (!this.mStopped) {
                    try {
                        this.mStopLock.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [670=6] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.mPrepareTime = String.valueOf(System.currentTimeMillis() / 1000);
                    this.mPlayer.play();
                    synchronized (this.mStopLock) {
                        this.mStopped = true;
                        this.mStopLock.notifyAll();
                    }
                    if (this.mLocalHandler != null) {
                        this.mLocalHandler.sendMessage(this.mLocalHandler.obtainMessage(0, this.mPrepareTime));
                    }
                } catch (Exception e) {
                    boolean sendMessage = this.mLocalHandler != null ? this.mLocalHandler.sendMessage(this.mLocalHandler.obtainMessage(1, e)) : false;
                    synchronized (this.mStopLock) {
                        this.mStopped = true;
                        this.mStopLock.notifyAll();
                        if (sendMessage || this.mLocalHandler == null) {
                            return;
                        }
                        this.mLocalHandler.sendMessage(this.mLocalHandler.obtainMessage(0, this.mPrepareTime));
                    }
                }
            } catch (Throwable th) {
                synchronized (this.mStopLock) {
                    this.mStopped = true;
                    this.mStopLock.notifyAll();
                    if (this.mLocalHandler != null) {
                        this.mLocalHandler.sendMessage(this.mLocalHandler.obtainMessage(0, this.mPrepareTime));
                    }
                    throw th;
                }
            }
        }

        /* loaded from: classes4.dex */
        private static class LocalHandler extends Handler {
            private OnVideoEndedListener mOnEndedListener;
            private OnVideoErrorListener mOnErrorListener;
            private OnReportListener mOnReportListener;

            public LocalHandler(OnVideoEndedListener onVideoEndedListener, OnVideoErrorListener onVideoErrorListener, OnReportListener onReportListener) {
                this.mOnEndedListener = onVideoEndedListener;
                this.mOnErrorListener = onVideoErrorListener;
                this.mOnReportListener = onReportListener;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        String str = (String) message.obj;
                        if (this.mOnEndedListener != null) {
                            this.mOnEndedListener.onVideoEnded();
                        }
                        if (this.mOnReportListener != null) {
                            this.mOnReportListener.onSuccess(new PlaySuccessInfo(null, String.valueOf(System.currentTimeMillis() / 1000), str));
                            return;
                        }
                        return;
                    case 1:
                        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                        if (this.mOnReportListener != null) {
                            this.mOnReportListener.onError(new ErrorInfo(16, ErrorInfo.VIDEO_PLAY_SOURCE_ERROR_ERRORMSG, (Exception) message.obj, null, null, null, valueOf));
                        }
                        if (this.mOnErrorListener != null) {
                            this.mOnErrorListener.onError(new ErrorInfo(16, ErrorInfo.VIDEO_PLAY_SOURCE_ERROR_ERRORMSG, (Exception) message.obj, null, null, null, valueOf));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
