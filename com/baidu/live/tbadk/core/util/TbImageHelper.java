package com.baidu.live.tbadk.core.util;

import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.core.TbImgSetting;
/* loaded from: classes3.dex */
public class TbImageHelper {
    private static TbImageHelper mInstance = null;
    private boolean mIsWifiCache = false;
    private boolean mFrsShowBigImage = false;
    private int mPostImageSize = 1500;
    private String mUrlQuality = String.valueOf(45);

    public static TbImageHelper getInstance() {
        if (mInstance == null) {
            synchronized (TbImageHelper.class) {
                mInstance = new TbImageHelper();
            }
        }
        return mInstance;
    }

    public TbImageHelper() {
        updateNetworkStatusCache();
        updateAll();
    }

    private void updateAll() {
        updateFrsShowBigImage();
        updateUrlQuality();
        updatePostImageSize();
    }

    public void setFrsShowBigImage(boolean z) {
        this.mFrsShowBigImage = z;
    }

    public boolean isFrsShowBigImage() {
        return this.mFrsShowBigImage;
    }

    public void setNetworkIsWifi(boolean z) {
        this.mIsWifiCache = z;
        updateAll();
    }

    private void updateNetworkStatusCache() {
        this.mIsWifiCache = BdNetTypeUtil.isWifiNet();
    }

    public boolean getIsWifi() {
        return this.mIsWifiCache;
    }

    public String getUrlQuality() {
        return this.mUrlQuality;
    }

    public int getPostImageSize() {
        updatePostImageSize();
        return this.mPostImageSize;
    }

    public int getPostImageHeightLimit() {
        return 18000;
    }

    private void updateFrsShowBigImage() {
        boolean z = true;
        if (TbImgSetting.getInstance().getViewImageQuality() != 0 ? TbImgSetting.getInstance().getViewImageQuality() != 1 : !this.mIsWifiCache) {
            z = false;
        }
        setFrsShowBigImage(z);
    }

    private void updateUrlQuality() {
        String valueOf = String.valueOf(45);
        if (TbImgSetting.getInstance().getViewImageQuality() == 0) {
            if (getIsWifi()) {
                valueOf = String.valueOf(80);
            }
        } else if (TbImgSetting.getInstance().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.mUrlQuality = valueOf;
    }

    private void updatePostImageSize() {
        int i = 2000;
        switch (TbImgSetting.getInstance().getUploadImageQuality()) {
            case 0:
                if (!getIsWifi()) {
                    i = 1500;
                    break;
                }
                break;
            case 1:
                break;
            case 2:
                i = 1800;
                break;
            case 3:
                i = 1500;
                break;
            default:
                i = 1800;
                break;
        }
        this.mPostImageSize = i;
    }
}
