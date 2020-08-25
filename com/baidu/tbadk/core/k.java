package com.baidu.tbadk.core;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes2.dex */
public class k {
    private static k dUC;
    private int mIsAbstractOn = 1;
    private int mUploadImageQuality = 0;
    private int mAddImageWater = 0;
    private String forumName = null;
    private boolean mIsShowImages = true;
    private int mViewImageQuality = 0;

    public static k bbM() {
        k kVar;
        if (dUC == null) {
            synchronized (k.class) {
                if (dUC == null) {
                    dUC = new k();
                }
                kVar = dUC;
            }
            return kVar;
        }
        return dUC;
    }

    private k() {
    }

    public void initSetting() {
        this.mUploadImageQuality = com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.PREFS_IMAGE_QUALITY, 0);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.PREFS_ABSTRACT_STATE, 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.PREFS_VIEW_IMAGE_QUALITY, 0);
        this.mIsShowImages = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.PREFS_SHOW_IMAGES, true);
    }

    public int getUploadImageQuality() {
        this.mUploadImageQuality = com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.PREFS_IMAGE_QUALITY, 0);
        return this.mUploadImageQuality;
    }

    public void setImageWaterType(int i) {
        if (this.mAddImageWater != i) {
            this.mAddImageWater = i;
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PREFS_ADD_IMAGE_WATER, i);
        }
    }

    public int getImageWaterType() {
        this.mAddImageWater = com.baidu.tbadk.core.sharedPref.b.bik().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PREFS_ADD_IMAGE_WATER, 2);
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
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.PREFS_SHOW_IMAGES, z);
        }
    }

    public void mK(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.PREFS_VIEW_IMAGE_QUALITY, i);
            au.bjr().updateFrsShowBigImage();
            au.bjr().updateUrlQuality();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
