package com.baidu.ala.dumixar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.MediaCodec;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.baidu.ala.dumixar.utils.BitmapUtils;
import com.baidu.ala.dumixar.videofilter.VideoFilter;
import com.baidu.ala.dumixar.videofilter.VideoRGBA2NV21Filter;
import com.baidu.ala.recorder.video.gles.EglCore;
import com.baidu.ala.recorder.video.gles.WindowSurface;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes6.dex */
public class EGLTextureReader implements ITextureReader {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_UPDATE_PIC_INTERVAL = 200;
    private static final String TAG = "EGLTextureReader";
    private Context mContext;
    private boolean mHasSetup;
    private volatile OnFilteredFrameUpdateListener mOnFrameUpdateCallback;
    private OnTextureUpdateListener mOnTextureUpdataCallback;
    private int mOutputHeight;
    private int mOutputWidth;
    private volatile String mPauseImgPath;
    private volatile Surface mSurface;
    private int mInputWidth = 0;
    private int mInputHeight = 0;
    private OnPixelReadCallback mCallback = null;
    private WorkThread mWorkThread = null;
    private EGLContext mSharedEGLContext = null;
    private volatile boolean isEncodingVideo = true;
    private boolean isEncodingVideoFlipH = false;
    private volatile boolean isPixelOutput = true;
    private boolean isPixelOutputFlipH = false;
    private boolean isPixelOutputFlipV = true;
    private volatile boolean mIsPicStreaming = false;
    private volatile long mEpochTimeInNs = -1;

    /* loaded from: classes6.dex */
    public interface OnPixelReadCallback {
        void onPixelRead(byte[] bArr, int i, int i2);
    }

    public EGLTextureReader(Context context, int i, int i2) {
        this.mOutputWidth = 0;
        this.mOutputHeight = 0;
        this.mHasSetup = false;
        this.mContext = context;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
        this.mHasSetup = false;
    }

    public void setOutPutSize(int i, int i2) {
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    @Override // com.baidu.ala.dumixar.ITextureReader
    public void setup(EGLContext eGLContext) {
        if (!this.mHasSetup) {
            this.mSharedEGLContext = eGLContext;
            this.mWorkThread = new WorkThread();
            this.mWorkThread.start();
            this.mWorkThread.waitUntilReady();
            this.mHasSetup = true;
        }
    }

    @Override // com.baidu.ala.dumixar.ITextureReader
    public void release() {
        if (this.mHasSetup) {
            this.mWorkThread.release();
            try {
                this.mWorkThread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mHasSetup = false;
        }
    }

    @Override // com.baidu.ala.dumixar.ITextureReader
    public void onTextureUpdate(int i, int i2, int i3) {
        if (this.mWorkThread != null) {
            this.mWorkThread.updateTexture(i, i2, i3);
        }
        if (this.mOnTextureUpdataCallback != null) {
            this.mOnTextureUpdataCallback.onTextureUpdate(i, i2, i3);
        }
    }

    public void startPictureStreaming() {
        if (this.mWorkThread != null) {
            this.mWorkThread.startPictureStreaming();
        }
    }

    public void stopPictureStreaming() {
        if (this.mWorkThread != null) {
            this.mWorkThread.stopPictureStreaming();
        }
    }

    public void setOnTextureUpdataCallback(OnTextureUpdateListener onTextureUpdateListener) {
        this.mOnTextureUpdataCallback = onTextureUpdateListener;
    }

    public void setEncodingEnable(boolean z) {
        this.isEncodingVideo = z;
    }

    public void setEncodingFlipH(boolean z) {
        this.isEncodingVideoFlipH = z;
    }

    public void setPixelOutputEnable(boolean z) {
        this.isPixelOutput = z;
    }

    public void setPixelOutputFlipH(boolean z) {
        this.isPixelOutputFlipH = z;
    }

    public void setPixelOutputFlipV(boolean z) {
        this.isPixelOutputFlipV = z;
    }

    public void setOnPixelReadCallback(OnPixelReadCallback onPixelReadCallback) {
        this.mCallback = onPixelReadCallback;
    }

    public void setOnFilteredFrameUpdateListener(OnFilteredFrameUpdateListener onFilteredFrameUpdateListener) {
        this.mOnFrameUpdateCallback = onFilteredFrameUpdateListener;
    }

    public void setEpochTimeInNs(long j) {
        this.mEpochTimeInNs = j;
        if (this.mWorkThread != null) {
            this.mWorkThread.setPresentationStartTimeNs(j);
        }
    }

    public void setEncodeSurface(Surface surface) {
        this.mSurface = surface;
        if (this.mWorkThread != null) {
            this.mWorkThread.setEncodeSurface(surface);
        }
    }

    public void setPauseImgPath(String str) {
        this.mPauseImgPath = str;
        if (this.mWorkThread != null) {
            this.mWorkThread.setPauseImgPath(str);
        }
    }

    public boolean isPicStreaming() {
        return this.mIsPicStreaming;
    }

    public void setEncodingEnabled(boolean z) {
        this.isEncodingVideo = z;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0001 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [android.graphics.YuvImage] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.graphics.Rect] */
    public static void dumpYUVData(byte[] bArr, int i, int i2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = 0;
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + "/test.jpg");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            ?? yuvImage = new YuvImage(bArr, 17, i, i2, null);
            fileOutputStream2 = new Rect(0, 0, i, i2);
            yuvImage.compressToJpeg(fileOutputStream2, 100, fileOutputStream);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream3 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream3 != null) {
                try {
                    fileOutputStream3.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != 0) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean isExists(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    /* loaded from: classes6.dex */
    private class WorkThread extends Thread {
        private static final int CMD_ON_EXIT = 2;
        private static final int CMD_ON_PIC_TEXTURE_UPDATE = 5;
        private static final int CMD_ON_SET_PAUSE_IMG = 4;
        private static final int CMD_ON_TEXTURE_UPDATE = 1;
        private static final int MSG_SET_ENCODESURFACE = 3;
        float averageReadTime;
        float averageTrackTime;
        long debugEnd;
        long debugStart;
        private File dumpPixelFile;
        private volatile boolean isPicReading;
        private volatile boolean isReading;
        private volatile long mCurrentPresentationTimeInUs;
        private EglCore mEglCore;
        private VideoFilter mEncodeFilter;
        private volatile int mEncodeRotation;
        private volatile Surface mEncodeSurface;
        private volatile int mEncodeVideoHeight;
        private volatile int mEncodeVideoWidth;
        private WindowSurface mEncodeWindowSurface;
        private Handler mHandler;
        private boolean mIsOutputHorizonFlip;
        private EGLSurface mOfflineEGLSurface;
        private VideoFilter mOutputFilter;
        private final float[] mOutputMvpMatrix;
        private int mPauseImgTextureId;
        private int mPicHeight;
        private int mPicWidth;
        private volatile int mPixelHeight;
        private volatile int mPixelRotation;
        private volatile int mPixelWidth;
        private volatile long mPresentationStartTimeNs;
        private volatile boolean mReady;
        private Object[] mStartLock;
        int onceTime;
        long readFrameCount;
        long trackFrameCount;

        private WorkThread() {
            this.mHandler = null;
            this.isReading = false;
            this.isPicReading = false;
            this.mStartLock = new Object[0];
            this.mReady = false;
            this.mOutputFilter = null;
            this.mEncodeFilter = null;
            this.mEglCore = null;
            this.mOutputMvpMatrix = new float[16];
            this.mOfflineEGLSurface = null;
            this.debugStart = 0L;
            this.debugEnd = 0L;
            this.onceTime = 0;
            this.averageTrackTime = 0.0f;
            this.averageReadTime = 0.0f;
            this.readFrameCount = 0L;
            this.trackFrameCount = 0L;
            this.mPresentationStartTimeNs = -1L;
            this.mCurrentPresentationTimeInUs = -1L;
            this.mEncodeRotation = 0;
            this.mEncodeVideoWidth = 0;
            this.mEncodeVideoHeight = 0;
            this.mPixelRotation = 0;
            this.mPixelWidth = 0;
            this.mPixelHeight = 0;
            this.mIsOutputHorizonFlip = false;
            this.mPauseImgTextureId = -1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            this.mEglCore = new EglCore(EGLTextureReader.this.mSharedEGLContext, 1);
            this.mHandler = new Handler() { // from class: com.baidu.ala.dumixar.EGLTextureReader.WorkThread.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 1:
                            WorkThread.this.isReading = true;
                            int i = message.arg1;
                            if (!EGLTextureReader.this.mIsPicStreaming) {
                                WorkThread.this.draw(i);
                            }
                            WorkThread.this.isReading = false;
                            return;
                        case 2:
                            WorkThread.this.mReady = false;
                            WorkThread.this.destroyGLContext();
                            Log.d(EGLTextureReader.TAG, String.format("(averageTrackTime, averageReadTime) = (%f, %f)", Float.valueOf(WorkThread.this.averageTrackTime), Float.valueOf(WorkThread.this.averageReadTime)));
                            Looper.myLooper().quit();
                            return;
                        case 3:
                            WorkThread.this.setEncodeSurfaceInternal((Surface) message.obj);
                            return;
                        case 4:
                            WorkThread.this.setPauseImgPathInternal((String) message.obj);
                            return;
                        case 5:
                            WorkThread.this.isPicReading = true;
                            WorkThread.this.draw(message.arg1);
                            WorkThread.this.isPicReading = false;
                            EGLTextureReader.this.mInputWidth = WorkThread.this.mPicWidth;
                            EGLTextureReader.this.mInputHeight = WorkThread.this.mPicHeight;
                            Message obtainMessage = WorkThread.this.mHandler.obtainMessage(5);
                            obtainMessage.arg1 = WorkThread.this.mPauseImgTextureId;
                            WorkThread.this.mHandler.sendMessageDelayed(obtainMessage, 200L);
                            return;
                        default:
                            return;
                    }
                }
            };
            createGLContext();
            this.mReady = true;
            synchronized (this.mStartLock) {
                this.mStartLock.notifyAll();
            }
            Looper.loop();
        }

        private void createGLContext() {
            this.mOfflineEGLSurface = this.mEglCore.createOffscreenSurface(EGLTextureReader.this.mOutputWidth, EGLTextureReader.this.mOutputHeight);
            this.mEglCore.makeCurrent(this.mOfflineEGLSurface);
            this.mOutputFilter = new VideoRGBA2NV21Filter();
            this.mOutputFilter.init();
            this.mOutputFilter.onOutputSizeChanged(EGLTextureReader.this.mOutputWidth, EGLTextureReader.this.mOutputHeight);
            this.mEncodeFilter = new VideoFilter();
            this.mEncodeFilter.init();
            this.mEncodeFilter.onOutputSizeChanged(EGLTextureReader.this.mOutputWidth, EGLTextureReader.this.mOutputHeight);
            if (EGLTextureReader.this.mEpochTimeInNs > 0) {
                setPresentationStartTimeNs(EGLTextureReader.this.mEpochTimeInNs);
            }
            if (EGLTextureReader.this.mSurface != null) {
                setEncodeSurfaceInternal(EGLTextureReader.this.mSurface);
            }
            if (!TextUtils.isEmpty(EGLTextureReader.this.mPauseImgPath)) {
                setPauseImgPathInternal(EGLTextureReader.this.mPauseImgPath);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroyGLContext() {
            if (this.mPauseImgTextureId != 0) {
                GLES20.glDeleteTextures(1, new int[]{this.mPauseImgTextureId}, 0);
                this.mPauseImgTextureId = 0;
            }
            if (this.mOutputFilter != null) {
                this.mOutputFilter.release();
            }
            if (this.mEncodeFilter != null) {
                this.mEncodeFilter.release();
            }
            setEncodeSurfaceInternal(null);
            this.mEglCore.makeNothingCurrent();
            if (this.mOfflineEGLSurface != null) {
                this.mEglCore.releaseSurface(this.mOfflineEGLSurface);
            }
            this.mEglCore.release();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void draw(int i) {
            long j;
            this.debugStart = System.currentTimeMillis();
            long currentTimeMillis = System.currentTimeMillis();
            long nanoTime = System.nanoTime();
            if (EGLTextureReader.this.isPixelOutput && EGLTextureReader.this.mCallback != null) {
                this.mEglCore.makeCurrent(this.mOfflineEGLSurface);
                this.mOutputFilter.onOutputSizeChanged(EGLTextureReader.this.mOutputWidth, EGLTextureReader.this.mOutputHeight);
                setOutputMvpMatrix(EGLTextureReader.this.mInputWidth, EGLTextureReader.this.mOutputWidth, EGLTextureReader.this.mInputHeight, EGLTextureReader.this.mOutputHeight, this.mPixelRotation, EGLTextureReader.this.isPixelOutputFlipH, EGLTextureReader.this.isPixelOutputFlipV);
                this.mOutputFilter.setMVPMatrix(this.mOutputMvpMatrix);
                this.mOutputFilter.draw(i);
                this.mEglCore.swapBuffers(this.mOfflineEGLSurface);
                byte[] yUVData = ((VideoRGBA2NV21Filter) this.mOutputFilter).getYUVData();
                this.debugEnd = System.currentTimeMillis();
                this.onceTime = (int) (this.debugEnd - this.debugStart);
                this.readFrameCount++;
                this.averageReadTime = ((this.averageReadTime * ((float) (this.readFrameCount - 1))) + this.onceTime) / ((float) this.readFrameCount);
                this.debugStart = System.currentTimeMillis();
                if (EGLTextureReader.this.mCallback != null) {
                    EGLTextureReader.this.mCallback.onPixelRead(yUVData, EGLTextureReader.this.mOutputWidth, EGLTextureReader.this.mOutputHeight);
                }
                this.debugEnd = System.currentTimeMillis();
                this.onceTime = (int) (this.debugEnd - this.debugStart);
                if (this.onceTime > 0) {
                    long j2 = this.trackFrameCount + 1;
                    this.trackFrameCount = j2;
                    this.averageTrackTime = ((this.averageTrackTime * ((float) this.trackFrameCount)) + this.onceTime) / ((float) j2);
                }
            }
            if (EGLTextureReader.this.isEncodingVideo && EGLTextureReader.this.mOnFrameUpdateCallback != null) {
                if (this.mPresentationStartTimeNs > -1) {
                    j = nanoTime - this.mPresentationStartTimeNs;
                } else {
                    j = this.mCurrentPresentationTimeInUs * 1000;
                }
                this.mOutputFilter.onOutputSizeChanged(EGLTextureReader.this.mOutputWidth, EGLTextureReader.this.mOutputHeight);
                setOutputMvpMatrix(EGLTextureReader.this.mInputWidth, EGLTextureReader.this.mOutputWidth, EGLTextureReader.this.mInputHeight, EGLTextureReader.this.mOutputHeight, this.mPixelRotation, EGLTextureReader.this.isEncodingVideoFlipH, true);
                this.mEncodeFilter.setMVPMatrix(this.mOutputMvpMatrix);
                if (this.mEncodeWindowSurface != null) {
                    this.mEncodeWindowSurface.makeCurrent();
                    this.mEncodeFilter.draw(i, 0);
                    this.mEncodeWindowSurface.setPresentationTime(j);
                    this.mEncodeWindowSurface.swapBuffers();
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    bufferInfo.set((int) (System.currentTimeMillis() - currentTimeMillis), 0, j / 1000, 0);
                    if (EGLTextureReader.this.mOnFrameUpdateCallback != null) {
                        EGLTextureReader.this.mOnFrameUpdateCallback.onFilteredFrameUpdate(null, bufferInfo);
                    }
                }
            }
        }

        public int createTexture2DObject() {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i = iArr[0];
            GLES20.glBindTexture(3553, i);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            return i;
        }

        public void setEncodeSize(int i, int i2, int i3) {
            this.mEncodeVideoWidth = i;
            this.mEncodeVideoHeight = i2;
            this.mEncodeRotation = i3;
        }

        public void setPixelOutputSize(int i, int i2, int i3) {
            this.mPixelWidth = i;
            this.mPixelHeight = i2;
            this.mPixelRotation = i3;
        }

        public void setEncodeSurface(Surface surface) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3, 0, 0, surface));
            }
        }

        public void setPauseImgPath(String str) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(4, 0, 0, str));
            }
        }

        public void setPresentationStartTimeNs(long j) {
            this.mPresentationStartTimeNs = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEncodeSurfaceInternal(Surface surface) {
            if (this.mEncodeSurface != surface) {
                this.mEncodeSurface = surface;
                if (this.mEncodeWindowSurface != null) {
                    this.mEncodeWindowSurface.release();
                    this.mEncodeWindowSurface = null;
                }
                if (this.mEncodeSurface != null) {
                    this.mEncodeWindowSurface = new WindowSurface(this.mEglCore, this.mEncodeSurface, true);
                    this.mEncodeWindowSurface.makeCurrent();
                }
            }
        }

        public void setPauseImgPathInternal(String str) {
            if (EGLTextureReader.isExists(str) || BitmapUtils.getImageIdByName(str, EGLTextureReader.this.mContext) > 0) {
                Bitmap decodeBitmap = BitmapUtils.decodeBitmap(EGLTextureReader.this.mContext, str);
                if (this.mPauseImgTextureId > 0) {
                    GLES20.glDeleteTextures(1, new int[]{this.mPauseImgTextureId}, 0);
                    this.mPauseImgTextureId = 0;
                }
                this.mPauseImgTextureId = initImageByBitmap(decodeBitmap);
            }
        }

        private int initImageByBitmap(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                return 0;
            }
            this.mPicWidth = bitmap.getWidth();
            this.mPicHeight = bitmap.getHeight();
            int createTexture2DObject = createTexture2DObject();
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            bitmap.recycle();
            return createTexture2DObject;
        }

        private void setOutputMvpMatrix(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            Matrix.setIdentityM(this.mOutputMvpMatrix, 0);
            Matrix.scaleM(this.mOutputMvpMatrix, 0, z ? -1.0f : 1.0f, z2 ? -1.0f : 1.0f, 1.0f);
            Matrix.rotateM(this.mOutputMvpMatrix, 0, i5, 0.0f, 0.0f, 1.0f);
            if (i5 % 180 != 0) {
                int i6 = i ^ i3;
                i3 ^= i6;
                i = i6 ^ i3;
            }
            float f = i / i3;
            float f2 = i2 / i4;
            if (f > f2) {
                Matrix.scaleM(this.mOutputMvpMatrix, 0, f / f2, 1.0f, 1.0f);
            } else if (f < f2) {
                Matrix.scaleM(this.mOutputMvpMatrix, 0, 1.0f, f2 / f, 1.0f);
            }
        }

        void waitUntilReady() {
            synchronized (this.mStartLock) {
                while (!this.mReady) {
                    try {
                        this.mStartLock.wait(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        boolean updateTexture(int i, int i2, int i3) {
            if (!this.isReading) {
                if (i2 != EGLTextureReader.this.mInputWidth || i3 != EGLTextureReader.this.mInputHeight) {
                    EGLTextureReader.this.mInputWidth = i2;
                    EGLTextureReader.this.mInputHeight = i3;
                }
                Message obtainMessage = this.mHandler.obtainMessage(1);
                obtainMessage.arg1 = i;
                this.mHandler.sendMessage(obtainMessage);
                return true;
            }
            return false;
        }

        public void startPictureStreaming() {
            if (this.mPauseImgTextureId >= 0 && !this.isPicReading) {
                EGLTextureReader.this.mIsPicStreaming = true;
                EGLTextureReader.this.mInputWidth = this.mPicWidth;
                EGLTextureReader.this.mInputHeight = this.mPicHeight;
                Message obtainMessage = this.mHandler.obtainMessage(5);
                obtainMessage.arg1 = this.mPauseImgTextureId;
                this.mHandler.sendMessage(obtainMessage);
            }
        }

        public void stopPictureStreaming() {
            EGLTextureReader.this.mIsPicStreaming = false;
            this.mHandler.removeMessages(5);
        }

        void release() {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
        }
    }
}
