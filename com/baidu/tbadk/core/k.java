package com.baidu.tbadk.core;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class k {
    private static k exj;
    private int mIsAbstractOn = 1;
    private int mUploadImageQuality = 0;
    private int mAddImageWater = 0;
    private String forumName = null;
    private boolean mIsShowImages = true;
    private int mViewImageQuality = 0;

    public static k bjH() {
        k kVar;
        if (exj == null) {
            synchronized (k.class) {
                if (exj == null) {
                    exj = new k();
                }
                kVar = exj;
            }
            return kVar;
        }
        return exj;
    }

    private k() {
    }

    public void initSetting() {
        this.mUploadImageQuality = com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.PREFS_IMAGE_QUALITY, 0);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.PREFS_ABSTRACT_STATE, 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.PREFS_VIEW_IMAGE_QUALITY, 0);
        this.mIsShowImages = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.PREFS_SHOW_IMAGES, true);
        if (!this.mIsShowImages) {
            this.mIsShowImages = true;
            com.baidu.tbadk.core.sharedPref.b.bqh().remove(SharedPrefConfig.PREFS_SHOW_IMAGES);
            com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.PREFS_VIEW_IMAGE_QUALITY, 0);
            this.mViewImageQuality = 0;
        }
    }

    public int getUploadImageQuality() {
        this.mUploadImageQuality = com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.PREFS_IMAGE_QUALITY, 0);
        return this.mUploadImageQuality;
    }

    public void setImageWaterType(int i) {
        if (this.mAddImageWater != i) {
            this.mAddImageWater = i;
            com.baidu.tbadk.core.sharedPref.b.bqh().putInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PREFS_ADD_IMAGE_WATER, i);
        }
    }

    public int getImageWaterType() {
        this.mAddImageWater = com.baidu.tbadk.core.sharedPref.b.bqh().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PREFS_ADD_IMAGE_WATER, 2);
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
    }

    public void nN(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.PREFS_VIEW_IMAGE_QUALITY, i);
            au.bro().updateFrsShowBigImage();
            au.bro().updateUrlQuality();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
