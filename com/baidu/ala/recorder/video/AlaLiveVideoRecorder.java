package com.baidu.ala.recorder.video;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.recorder.IFaceUnityOperator;
import com.baidu.ala.recorder.RecorderCallback;
import com.baidu.ala.recorder.video.IVideoRecorder;
import com.baidu.ala.recorder.video.camera.AlaCameraRecorder;
import com.baidu.ala.recorder.video.camera.ICameraStatusHandler;
import com.baidu.ala.recorder.video.screen.AlaScreenRecorder;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AlaLiveVideoRecorder implements IFaceUnityOperator, IVideoRecorder, ICameraStatusHandler {
    private Context mContext;
    private RecorderHandler mHandler;
    private IVideoRecorder mRealRecorder;

    public AlaLiveVideoRecorder(Context context) {
        this.mHandler = null;
        this.mContext = context;
        this.mHandler = new RecorderHandler(Looper.getMainLooper());
    }

    public void init(VideoRecorderType videoRecorderType, VideoBeautyType videoBeautyType) {
        if (videoRecorderType == VideoRecorderType.CAMERA) {
            this.mRealRecorder = new AlaCameraRecorder(this.mContext, this.mHandler, videoBeautyType != null, videoBeautyType);
        } else if (videoRecorderType == VideoRecorderType.SCREEN) {
            AlaScreenRecorder alaScreenRecorder = AlaScreenRecorder.getInstance();
            alaScreenRecorder.init(this.mContext, this.mHandler);
            this.mRealRecorder = alaScreenRecorder;
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void startRecord() {
        if (this.mRealRecorder != null) {
            this.mRealRecorder.startRecord();
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void stopRecord() {
        if (this.mRealRecorder != null) {
            this.mRealRecorder.stopRecord();
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void setVideoDataCallback(IVideoRecorder.IVideoDataCallBack iVideoDataCallBack) {
        if (this.mRealRecorder != null) {
            this.mRealRecorder.setVideoDataCallback(iVideoDataCallBack);
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void setRecorderCallback(RecorderCallback recorderCallback) {
        if (this.mRealRecorder != null) {
            this.mRealRecorder.setRecorderCallback(recorderCallback);
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public VideoFormat getVideoFormat() {
        return this.mRealRecorder != null ? this.mRealRecorder.getVideoFormat() : VideoFormat.RGBA;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public int getOutputWidth() {
        if (this.mRealRecorder != null) {
            return this.mRealRecorder.getOutputWidth();
        }
        return 0;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public int getOutputHeight() {
        if (this.mRealRecorder != null) {
            return this.mRealRecorder.getOutputHeight();
        }
        return 0;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public boolean isVideoThreadRun() {
        if (this.mRealRecorder != null) {
            return this.mRealRecorder.isVideoThreadRun();
        }
        return false;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public boolean isForeBackgroundSwitchEnable() {
        if (this.mRealRecorder != null) {
            return this.mRealRecorder.isForeBackgroundSwitchEnable();
        }
        return false;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public View getPreview() {
        if (this.mRealRecorder == null) {
            return null;
        }
        return this.mRealRecorder.getPreview();
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void release() {
        if (this.mRealRecorder != null) {
            this.mRealRecorder.release();
            this.mRealRecorder = null;
        }
        this.mContext = null;
        if (this.mHandler != null) {
            this.mHandler.setRecorderCallback(null);
        }
        this.mHandler = null;
    }

    public void sendStreamState(int i, boolean z, int i2, boolean z2) {
        if (this.mHandler != null) {
            this.mHandler.sendStreamState(i, z, i2, z2);
        }
    }

    public void sendLostRate(double d) {
        if (this.mHandler != null) {
            this.mHandler.sendLostRate(d);
        }
    }

    public void sendDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
        if (this.mHandler != null) {
            this.mHandler.sendDebugInfo(alaLiveDebugInfo);
        }
    }

    public RecorderHandler getRecorderHandler() {
        return this.mHandler;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void switchCamera() {
        if (this.mRealRecorder instanceof ICameraStatusHandler) {
            ((ICameraStatusHandler) this.mRealRecorder).switchCamera();
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public boolean isBackCamera() {
        if (this.mRealRecorder instanceof ICameraStatusHandler) {
            return ((ICameraStatusHandler) this.mRealRecorder).isBackCamera();
        }
        return false;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void switchFlashingLight() {
        if (this.mRealRecorder instanceof ICameraStatusHandler) {
            ((ICameraStatusHandler) this.mRealRecorder).switchFlashingLight();
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public boolean isFlashingLightOpen() {
        if (this.mRealRecorder instanceof ICameraStatusHandler) {
            return ((ICameraStatusHandler) this.mRealRecorder).isFlashingLightOpen();
        }
        return false;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void setBeauty(int i) {
        if (this.mRealRecorder instanceof ICameraStatusHandler) {
            ((ICameraStatusHandler) this.mRealRecorder).setBeauty(i);
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public int hasBeauty() {
        if (this.mRealRecorder instanceof ICameraStatusHandler) {
            return ((ICameraStatusHandler) this.mRealRecorder).hasBeauty();
        }
        return -1;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public int getDisplayRotate() {
        if (this.mRealRecorder instanceof ICameraStatusHandler) {
            return ((ICameraStatusHandler) this.mRealRecorder).getDisplayRotate();
        }
        return 0;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder, com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.mRealRecorder != null) {
            this.mRealRecorder.setVideoConfig(alaLiveVideoConfig);
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public int getBitRate() {
        if (this.mRealRecorder != null) {
            return this.mRealRecorder.getBitRate();
        }
        return 0;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void startGetDataToSend() {
        if (this.mRealRecorder != null) {
            this.mRealRecorder.startGetDataToSend();
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onEffectItemSelected(String str) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).onEffectItemSelected(str);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onStickerItemSelected(Object obj) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).onStickerItemSelected(obj);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onGiftEffectItemSelected(String str) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).onGiftEffectItemSelected(str);
        } else if (this.mHandler != null) {
            this.mHandler.sendError(7, str);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFilterSelected(String str) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).onFilterSelected(str);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onBlurLevelSelected(int i) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).onBlurLevelSelected(i);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onColorLevelSelected(float f) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).onColorLevelSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onCheekThinSelected(float f) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).onCheekThinSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onEnlargeEyeSelected(float f) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).onEnlargeEyeSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFaceShapeSelected(int i) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).onFaceShapeSelected(i);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFaceShapeLevelSelected(float f) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).onFaceShapeLevelSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onRedLevelSelected(float f) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).onRedLevelSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onChinSelected(float f) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).onChinSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onNoseSelected(float f) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).onNoseSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public boolean hasAdvancedBeauty() {
        if (this.mRealRecorder == null || !(this.mRealRecorder instanceof AlaCameraRecorder)) {
            return false;
        }
        return ((AlaCameraRecorder) this.mRealRecorder).hasAdvancedBeauty();
    }

    public void setPushMirror(boolean z) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).setPushMirror(z);
        }
    }

    public boolean isPushMirror() {
        if (this.mRealRecorder == null || !(this.mRealRecorder instanceof AlaCameraRecorder)) {
            return false;
        }
        return ((AlaCameraRecorder) this.mRealRecorder).isPushMirror();
    }

    public void setCameraLooper(Looper looper) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).setCameraLooper(looper);
        }
    }

    public void setPreviewFps(int i) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).setPreviewFps(i);
        }
    }

    public void setDefBeautyParams(HashMap<String, Object> hashMap) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).setDefBeautyParams(hashMap);
        }
    }

    public void onBeautyChanged(float f, HashMap<String, Object> hashMap) {
        if (this.mRealRecorder != null && (this.mRealRecorder instanceof AlaCameraRecorder)) {
            ((AlaCameraRecorder) this.mRealRecorder).onBeautyChanged(f, hashMap);
        }
    }
}
