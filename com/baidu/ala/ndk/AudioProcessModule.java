package com.baidu.ala.ndk;

import android.content.res.AssetManager;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class AudioProcessModule {
    public static final int MUTE_FLAGS = 3;
    public static final int PAUSE_FLAGS = 1;
    public static final int RESUME_FLAGS = 2;
    private static final String TAG = AudioProcessModule.class.getSimpleName();
    public static final int UNMUTE_FLAGS = 4;
    private static AudioProcessModule mInstance;
    private long mContext = 0;
    private RenderCallback mRenderCallback = null;
    private CaptureCallback mCaptureCallback = null;

    /* loaded from: classes6.dex */
    public interface CaptureCallback {
        void onCaptureData(int i);
    }

    /* loaded from: classes6.dex */
    public interface RenderCallback {
        void onRenderData(int i);
    }

    private native int audioPlayerSetOpt(long j, int i);

    private native int audioPlayerStart(long j);

    private native int audioPlayerStop(long j);

    private native int audioRecorderSetOpt(long j, int i);

    private native int audioRecorderStart(long j);

    private native int audioRecorderStop(long j);

    private native int createAPM(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    private native int createAudioPlayer(long j, int i, int i2, int i3);

    private native int createAudioRecorder(long j, int i, int i2, int i3);

    private native int destroyAPM(long j);

    private native int destroyNative(long j);

    private native int initNative(Object obj);

    private native int setAssetManage(long j, Object obj);

    private native int setCaptureBuffer(long j, ByteBuffer byteBuffer, float f);

    private native int setRenderBuffer(long j, ByteBuffer byteBuffer, float f);

    private native int updateCaptureBuffer(long j, int[] iArr, int[] iArr2);

    private native int updateRenderBuffer(long j, int[] iArr, int[] iArr2);

    private native int updateSysInfo(long j, int i, String str);

    private AudioProcessModule() {
        init();
    }

    public static AudioProcessModule sharedInstance() {
        if (mInstance == null) {
            synchronized (AudioProcessModule.class) {
                if (mInstance == null) {
                    mInstance = new AudioProcessModule();
                }
            }
        }
        return mInstance;
    }

    public long getContext() {
        return this.mContext;
    }

    public void setRenderCallback(RenderCallback renderCallback) {
        this.mRenderCallback = renderCallback;
    }

    public void setCaptureCallback(CaptureCallback captureCallback) {
        this.mCaptureCallback = captureCallback;
    }

    private void setContext(long j) {
        this.mContext = j;
        Log.d(TAG, "setContext " + this.mContext);
    }

    private void updateCaptureInfo(int i) {
        if (this.mCaptureCallback != null) {
            this.mCaptureCallback.onCaptureData(i);
        }
    }

    private void updateRenderInfo(int i) {
        if (this.mRenderCallback != null) {
            this.mRenderCallback.onRenderData(i);
        }
    }

    private synchronized int init() {
        return initNative(this);
    }

    private synchronized int destroy() {
        Log.e(TAG, "destroy " + this.mContext);
        destroyNative(this.mContext);
        return 0;
    }

    public int updateSystemInfo(int i, String str) {
        return updateSysInfo(this.mContext, i, str);
    }

    public int setAssetManage(AssetManager assetManager) {
        return setAssetManage(this.mContext, assetManager);
    }

    public int setCaptureBuffer(ByteBuffer byteBuffer, float f) {
        return setCaptureBuffer(this.mContext, byteBuffer, f);
    }

    public int updateCaptureBuffer(int[] iArr, int[] iArr2) {
        return updateCaptureBuffer(this.mContext, iArr, iArr2);
    }

    public int setRenderBuffer(ByteBuffer byteBuffer, float f) {
        return setRenderBuffer(this.mContext, byteBuffer, f);
    }

    public int updateRenderBuffer(int[] iArr, int[] iArr2) {
        return updateRenderBuffer(this.mContext, iArr, iArr2);
    }

    public int createAudioPlayer(int i, int i2, int i3) {
        return createAudioPlayer(this.mContext, i, i2, i3);
    }

    public int audioPlayerStart() {
        return audioPlayerStart(this.mContext);
    }

    public int audioPlayerStop() {
        return audioPlayerStop(this.mContext);
    }

    public int audioPlayerSetOpt(int i) {
        return audioPlayerSetOpt(this.mContext, i);
    }

    public int createAudioRecorder(int i, int i2, int i3) {
        return createAudioRecorder(this.mContext, i, i2, i3);
    }

    public int audioRecorderStart() {
        return audioRecorderStart(this.mContext);
    }

    public int audioRecorderStop() {
        return audioRecorderStop(this.mContext);
    }

    public int audioRecorderSetOpt(int i) {
        return audioRecorderSetOpt(this.mContext, i);
    }

    public int createAudioProcessModule(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        createAPM(this.mContext, i, i2, i3, i4, i5, i6, i7);
        return 0;
    }

    public int destroyAudioProcessModule() {
        destroyAPM(this.mContext);
        return 0;
    }
}
