package com.baidu.tbadk.core;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class k {
    private static k dLu;
    private int mIsAbstractOn = 1;
    private int mUploadImageQuality = 0;
    private int mAddImageWater = 0;
    private String forumName = null;
    private boolean mIsShowImages = true;
    private int mViewImageQuality = 0;

    public static k aTv() {
        k kVar;
        if (dLu == null) {
            synchronized (k.class) {
                if (dLu == null) {
                    dLu = new k();
                }
                kVar = dLu;
            }
            return kVar;
        }
        return dLu;
    }

    private k() {
    }

    public void initSetting() {
        this.mUploadImageQuality = com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.PREFS_IMAGE_QUALITY, 0);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.PREFS_ABSTRACT_STATE, 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.PREFS_VIEW_IMAGE_QUALITY, 0);
        this.mIsShowImages = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.PREFS_SHOW_IMAGES, true);
    }

    public int getUploadImageQuality() {
        this.mUploadImageQuality = com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.PREFS_IMAGE_QUALITY, 0);
        return this.mUploadImageQuality;
    }

    public void setImageWaterType(int i) {
        if (this.mAddImageWater != i) {
            this.mAddImageWater = i;
            com.baidu.tbadk.core.sharedPref.b.aZP().putInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PREFS_ADD_IMAGE_WATER, i);
        }
    }

    public int getImageWaterType() {
        this.mAddImageWater = com.baidu.tbadk.core.sharedPref.b.aZP().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PREFS_ADD_IMAGE_WATER, 2);
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
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.PREFS_SHOW_IMAGES, z);
        }
    }

    public void kE(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.PREFS_VIEW_IMAGE_QUALITY, i);
            at.baS().updateFrsShowBigImage();
            at.baS().updateUrlQuality();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
