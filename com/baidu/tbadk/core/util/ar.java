package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class ar {
    private static ar cWu = null;
    private boolean mIsWifiCache = false;
    private boolean cWv = false;
    private int mPostImageSize = 1500;
    private String mUrlQuality = String.valueOf(45);

    public static ar aEq() {
        if (cWu == null) {
            synchronized (ar.class) {
                if (cWu == null) {
                    cWu = new ar();
                }
            }
        }
        return cWu;
    }

    public ar() {
        updateNetworkStatusCache();
        updateAll();
    }

    private void updateAll() {
        updateFrsShowBigImage();
        updateUrlQuality();
        updatePostImageSize();
    }

    public void fF(boolean z) {
        this.cWv = z;
    }

    public boolean aEr() {
        return this.cWv;
    }

    public void setNetworkIsWifi(boolean z) {
        this.mIsWifiCache = z;
        updateAll();
    }

    private void updateNetworkStatusCache() {
        this.mIsWifiCache = com.baidu.adp.lib.util.j.isWifiNet();
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

    public void updateFrsShowBigImage() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.axy().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.axy().getViewImageQuality() != 1 : !this.mIsWifiCache) {
            z = false;
        }
        fF(z);
    }

    public void updateUrlQuality() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.axy().getViewImageQuality() == 0) {
            if (getIsWifi()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.axy().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.mUrlQuality = valueOf;
    }

    public void updatePostImageSize() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.axy().getUploadImageQuality()) {
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

    public static boolean aEs() {
        return m.checkSD() && com.baidu.adp.gif.c.fi();
    }
}
