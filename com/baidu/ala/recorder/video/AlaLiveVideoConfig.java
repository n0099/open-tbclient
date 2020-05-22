package com.baidu.ala.recorder.video;

import com.baidu.ala.recorder.video.DynamicBitRateConfig;
import com.baidu.tbadk.TbConfig;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaLiveVideoConfig {
    public static final int HW_ENCODER = 1;
    private static final int PREVIEW_HEIGHT = 1280;
    private static final int PREVIEW_WIDTH = 720;
    public static final int SW_ENCODER = 2;
    private DynamicBitRateConfig mCurrentConfig;
    private int mEncoderType;
    private DynamicBitRateConfig mHardConfig;
    private boolean mIsLandscape;
    private boolean mIsSupportDynamicBitrate;
    private boolean mIsSupportFaceStyle;
    private int mOutputHeight;
    private int mOutputWidth;
    private int mPreviewHeight;
    private int mPreviewWidth;
    private DynamicBitRateConfig mRtcConfig;
    private DynamicBitRateConfig mSoftConfig;
    private int mVideoGOP;

    public AlaLiveVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        this.mPreviewWidth = PREVIEW_WIDTH;
        this.mPreviewHeight = PREVIEW_HEIGHT;
        this.mOutputWidth = 540;
        this.mOutputHeight = TbConfig.HEAD_IMG_SIZE;
        this.mVideoGOP = 2;
        this.mEncoderType = 1;
        this.mIsLandscape = false;
        this.mIsSupportFaceStyle = true;
        this.mIsSupportDynamicBitrate = true;
        if (alaLiveVideoConfig == null) {
            throw new IllegalArgumentException("config is null!!");
        }
        this.mIsLandscape = alaLiveVideoConfig.isLandscape();
        this.mVideoGOP = alaLiveVideoConfig.getVideoGOP();
        this.mEncoderType = alaLiveVideoConfig.getEncoderType();
        this.mPreviewHeight = alaLiveVideoConfig.getPreviewHeight();
        this.mPreviewWidth = alaLiveVideoConfig.getPreviewWidth();
        this.mOutputWidth = alaLiveVideoConfig.getVideoWidth();
        this.mOutputHeight = alaLiveVideoConfig.getVideoHeight();
        this.mIsSupportFaceStyle = alaLiveVideoConfig.isSupportFaceStyle();
        this.mIsSupportDynamicBitrate = alaLiveVideoConfig.getIsSupportDynamicBitrate();
        if (alaLiveVideoConfig.mSoftConfig != null) {
            this.mSoftConfig = alaLiveVideoConfig.mSoftConfig.deepCopy();
        }
        if (alaLiveVideoConfig.mHardConfig != null) {
            this.mHardConfig = alaLiveVideoConfig.mHardConfig.deepCopy();
        }
        if (alaLiveVideoConfig.mRtcConfig != null) {
            this.mRtcConfig = alaLiveVideoConfig.mRtcConfig.deepCopy();
        }
        this.mCurrentConfig = alaLiveVideoConfig.mCurrentConfig.deepCopy();
    }

    public AlaLiveVideoConfig(List<DynamicBitRateConfig.DynamicBitRateItem> list, List<DynamicBitRateConfig.DynamicBitRateItem> list2, double d, double d2, int i, boolean z, boolean z2, int i2, int i3) {
        this.mPreviewWidth = PREVIEW_WIDTH;
        this.mPreviewHeight = PREVIEW_HEIGHT;
        this.mOutputWidth = 540;
        this.mOutputHeight = TbConfig.HEAD_IMG_SIZE;
        this.mVideoGOP = 2;
        this.mEncoderType = 1;
        this.mIsLandscape = false;
        this.mIsSupportFaceStyle = true;
        this.mIsSupportDynamicBitrate = true;
        this.mSoftConfig = new DynamicBitRateConfig(d, d2, i, list);
        if (!this.mSoftConfig.isValid()) {
            this.mSoftConfig = DynamicBitRateConfig.generateDefaultConfig(1);
        }
        this.mHardConfig = new DynamicBitRateConfig(d, d2, i, list2);
        if (!this.mHardConfig.isValid()) {
            this.mHardConfig = DynamicBitRateConfig.generateDefaultConfig(2);
        }
        this.mRtcConfig = DynamicBitRateConfig.generateDefaultConfig(3);
        this.mEncoderType = z ? 1 : 2;
        this.mIsSupportDynamicBitrate = z2;
        this.mOutputWidth = i2;
        this.mOutputHeight = i3;
        if (this.mEncoderType == 2) {
            this.mCurrentConfig = this.mSoftConfig;
        } else {
            this.mCurrentConfig = this.mHardConfig;
        }
    }

    private AlaLiveVideoConfig() {
        this.mPreviewWidth = PREVIEW_WIDTH;
        this.mPreviewHeight = PREVIEW_HEIGHT;
        this.mOutputWidth = 540;
        this.mOutputHeight = TbConfig.HEAD_IMG_SIZE;
        this.mVideoGOP = 2;
        this.mEncoderType = 1;
        this.mIsLandscape = false;
        this.mIsSupportFaceStyle = true;
        this.mIsSupportDynamicBitrate = true;
    }

    public void switchToRtcMode(int i, int i2) {
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
        this.mCurrentConfig = this.mRtcConfig;
    }

    public void switchToNormalMode(int i, int i2) {
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
        if (this.mEncoderType == 2) {
            this.mCurrentConfig = this.mSoftConfig;
        } else {
            this.mCurrentConfig = this.mHardConfig;
        }
    }

    public AlaLiveVideoConfig setPreviewWidth(int i) {
        this.mPreviewWidth = i;
        return this;
    }

    public int getPreviewWidth() {
        return this.mPreviewWidth;
    }

    public AlaLiveVideoConfig setPreviewHeight(int i) {
        this.mPreviewHeight = i;
        return this;
    }

    public int getPreviewHeight() {
        return this.mPreviewHeight;
    }

    public AlaLiveVideoConfig setOutputWidth(int i) {
        this.mOutputWidth = i;
        return this;
    }

    public AlaLiveVideoConfig setOutputHeight(int i) {
        this.mOutputHeight = i;
        return this;
    }

    public int getVideoWidth() {
        return this.mOutputWidth;
    }

    public int getVideoHeight() {
        return this.mOutputHeight;
    }

    public int getBitStream() {
        if (this.mCurrentConfig != null) {
            return this.mCurrentConfig.getCurrentBitRate();
        }
        return 0;
    }

    public AlaLiveVideoConfig setIsLandscape(boolean z) {
        this.mIsLandscape = z;
        return this;
    }

    public boolean isLandscape() {
        return this.mIsLandscape;
    }

    public AlaLiveVideoConfig setSupportFaceStyle(boolean z) {
        this.mIsSupportFaceStyle = z;
        return this;
    }

    public boolean isSupportFaceStyle() {
        return this.mIsSupportFaceStyle;
    }

    public int getVideoFPS() {
        if (this.mCurrentConfig != null) {
            return this.mCurrentConfig.getCurrentFps();
        }
        return 15;
    }

    public void setVideoGOP(int i) {
        if (i > 0 && i < 5) {
            this.mVideoGOP = i;
        }
    }

    public int getVideoGOP() {
        return this.mVideoGOP;
    }

    public int getEncoderType() {
        return this.mEncoderType;
    }

    public boolean getIsSupportDynamicBitrate() {
        return this.mIsSupportDynamicBitrate;
    }

    public DynamicBitRateConfig getCurrentBitRateConfig() {
        return this.mCurrentConfig;
    }

    public DynamicBitRateConfig getRtcBitRateConfig() {
        return this.mRtcConfig;
    }

    public DynamicBitRateConfig getHardBitrateConfig() {
        return this.mHardConfig;
    }

    public DynamicBitRateConfig getSoftBitrateConfig() {
        return this.mSoftConfig;
    }

    public static boolean isUpdateBitrate(AlaLiveVideoConfig alaLiveVideoConfig, AlaLiveVideoConfig alaLiveVideoConfig2) {
        int currentBitRate = (alaLiveVideoConfig == null || alaLiveVideoConfig.getCurrentBitRateConfig() == null) ? 0 : alaLiveVideoConfig.getCurrentBitRateConfig().getCurrentBitRate();
        int currentBitRate2 = (alaLiveVideoConfig2 == null || alaLiveVideoConfig2.getCurrentBitRateConfig() == null) ? 0 : alaLiveVideoConfig2.getCurrentBitRateConfig().getCurrentBitRate();
        return (alaLiveVideoConfig == null || alaLiveVideoConfig2 == null || alaLiveVideoConfig.getVideoWidth() != alaLiveVideoConfig2.getVideoWidth() || alaLiveVideoConfig.getVideoHeight() != alaLiveVideoConfig2.getVideoHeight() || alaLiveVideoConfig.getPreviewWidth() != alaLiveVideoConfig2.getPreviewWidth() || alaLiveVideoConfig.getPreviewHeight() != alaLiveVideoConfig2.getPreviewHeight() || currentBitRate == currentBitRate2 || currentBitRate == 0 || currentBitRate2 == 0) ? false : true;
    }

    public static boolean isEqual(AlaLiveVideoConfig alaLiveVideoConfig, AlaLiveVideoConfig alaLiveVideoConfig2) {
        int currentBitRate;
        if (alaLiveVideoConfig != null) {
            try {
                if (alaLiveVideoConfig.getCurrentBitRateConfig() != null) {
                    currentBitRate = alaLiveVideoConfig.getCurrentBitRateConfig().getCurrentBitRate();
                    int currentBitRate2 = (alaLiveVideoConfig2 != null || alaLiveVideoConfig2.getCurrentBitRateConfig() == null) ? 0 : alaLiveVideoConfig2.getCurrentBitRateConfig().getCurrentBitRate();
                    if (alaLiveVideoConfig == null && alaLiveVideoConfig2 != null && alaLiveVideoConfig.getVideoWidth() == alaLiveVideoConfig2.getVideoWidth() && alaLiveVideoConfig.getVideoHeight() == alaLiveVideoConfig2.getVideoHeight() && alaLiveVideoConfig.getPreviewWidth() == alaLiveVideoConfig2.getPreviewWidth()) {
                        return alaLiveVideoConfig.getPreviewHeight() == alaLiveVideoConfig2.getPreviewHeight() && currentBitRate == currentBitRate2 && currentBitRate != 0 && currentBitRate2 != 0;
                    }
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        currentBitRate = 0;
        if (alaLiveVideoConfig2 != null) {
        }
        return alaLiveVideoConfig == null ? false : false;
    }
}
