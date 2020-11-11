package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class au {
    private static au eNS = null;
    private boolean mIsWifiCache = false;
    private boolean eNT = false;
    private int mPostImageSize = 1500;
    private String mUrlQuality = String.valueOf(45);

    public static au bro() {
        if (eNS == null) {
            synchronized (au.class) {
                if (eNS == null) {
                    eNS = new au();
                }
            }
        }
        return eNS;
    }

    public au() {
        updateNetworkStatusCache();
        updateAll();
    }

    private void updateAll() {
        updateFrsShowBigImage();
        updateUrlQuality();
        updatePostImageSize();
    }

    public void jd(boolean z) {
        this.eNT = z;
    }

    public boolean brp() {
        return this.eNT;
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
        if (com.baidu.tbadk.core.k.bjH().getViewImageQuality() != 0 ? com.baidu.tbadk.core.k.bjH().getViewImageQuality() != 1 : !this.mIsWifiCache) {
            z = false;
        }
        jd(z);
    }

    public void updateUrlQuality() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.k.bjH().getViewImageQuality() == 0) {
            if (getIsWifi()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.k.bjH().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.mUrlQuality = valueOf;
    }

    public void updatePostImageSize() {
        int i = 2000;
        switch (com.baidu.tbadk.core.k.bjH().getUploadImageQuality()) {
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

    public static boolean brq() {
        return n.checkSD() && com.baidu.adp.gif.c.lK();
    }
}
