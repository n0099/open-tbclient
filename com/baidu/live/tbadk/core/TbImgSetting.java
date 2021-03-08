package com.baidu.live.tbadk.core;

import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
/* loaded from: classes10.dex */
public class TbImgSetting {
    private static TbImgSetting instance;
    private int mIsDisplayPhoto = 1;
    private int mIsAbstractOn = 1;
    private int mUploadImageQuality = 0;
    private int mAddImageWater = 0;
    private String forumName = null;
    private boolean mIsShowImages = true;
    private int mViewImageQuality = 0;

    public static TbImgSetting getInstance() {
        TbImgSetting tbImgSetting;
        if (instance == null) {
            synchronized (TbImgSetting.class) {
                if (instance == null) {
                    instance = new TbImgSetting();
                }
                tbImgSetting = instance;
            }
            return tbImgSetting;
        }
        return instance;
    }

    private TbImgSetting() {
    }

    public void initSetting() {
        this.mUploadImageQuality = SharedPrefHelper.getInstance().getInt(SharedPrefConfig.PREFS_IMAGE_QUALITY, 0);
        this.mIsDisplayPhoto = SharedPrefHelper.getInstance().getInt(SharedPrefConfig.DISPLAY_PHOTO, 1);
        this.mIsAbstractOn = SharedPrefHelper.getInstance().getInt(SharedPrefConfig.PREFS_ABSTRACT_STATE, 0);
        this.mViewImageQuality = SharedPrefHelper.getInstance().getInt(SharedPrefConfig.PREFS_VIEW_IMAGE_QUALITY, 0);
        this.mIsShowImages = SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.PREFS_SHOW_IMAGES, true);
    }

    public void setDisplayPhoto(int i) {
        this.mIsDisplayPhoto = i;
        SharedPrefHelper.getInstance().putInt(SharedPrefConfig.DISPLAY_PHOTO, i);
    }

    public int getDisplayPhotoStatus() {
        return this.mIsDisplayPhoto;
    }

    public boolean getDisplayPhoto() {
        if (this.mIsDisplayPhoto == 0) {
            if (BdNetTypeUtil.isWifiNet()) {
                return true;
            }
        } else if (this.mIsDisplayPhoto == 1) {
            return true;
        }
        return false;
    }

    public void setIsAbstractOn(int i) {
        this.mIsAbstractOn = i;
        SharedPrefHelper.getInstance().putInt(SharedPrefConfig.PREFS_ABSTRACT_STATE, i);
    }

    public int getIsAbstractStatus() {
        return this.mIsAbstractOn;
    }

    public boolean getIsAbstract() {
        if (this.mIsAbstractOn == 0) {
            if (BdNetTypeUtil.isWifiNet()) {
                return true;
            }
        } else if (this.mIsAbstractOn == 1) {
            return true;
        }
        return false;
    }

    public void setUploadImageQuality(int i) {
        if (this.mUploadImageQuality != i) {
            this.mUploadImageQuality = i;
            SharedPrefHelper.getInstance().putInt(SharedPrefConfig.PREFS_IMAGE_QUALITY, i);
        }
    }

    public int getUploadImageQuality() {
        this.mUploadImageQuality = SharedPrefHelper.getInstance().getInt(SharedPrefConfig.PREFS_IMAGE_QUALITY, 0);
        return this.mUploadImageQuality;
    }

    public void setImageWaterType(int i) {
        if (this.mAddImageWater != i) {
            this.mAddImageWater = i;
            SharedPrefHelper.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PREFS_ADD_IMAGE_WATER, i);
        }
    }

    public int getImageWaterType() {
        this.mAddImageWater = SharedPrefHelper.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PREFS_ADD_IMAGE_WATER, 0);
        return this.mAddImageWater;
    }

    public void setForumNameForWaterImage(String str) {
        this.forumName = str;
    }

    public String getForumNameForWaterImage() {
        return this.forumName;
    }

    public boolean isShowImages() {
        return this.mIsShowImages;
    }

    public void setShowImages(boolean z) {
        if (this.mIsShowImages != z) {
            this.mIsShowImages = z;
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.PREFS_SHOW_IMAGES, z);
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
