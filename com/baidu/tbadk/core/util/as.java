package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class as {
    private static as dVa = null;
    private boolean mIsWifiCache = false;
    private boolean dVb = false;
    private int mPostImageSize = 1500;
    private String mUrlQuality = String.valueOf(45);

    public static as aWR() {
        if (dVa == null) {
            synchronized (as.class) {
                if (dVa == null) {
                    dVa = new as();
                }
            }
        }
        return dVa;
    }

    public as() {
        updateNetworkStatusCache();
        updateAll();
    }

    private void updateAll() {
        updateFrsShowBigImage();
        updateUrlQuality();
        updatePostImageSize();
    }

    public void hl(boolean z) {
        this.dVb = z;
    }

    public boolean aWS() {
        return this.dVb;
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
        if (com.baidu.tbadk.core.k.aPA().getViewImageQuality() != 0 ? com.baidu.tbadk.core.k.aPA().getViewImageQuality() != 1 : !this.mIsWifiCache) {
            z = false;
        }
        hl(z);
    }

    public void updateUrlQuality() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.k.aPA().getViewImageQuality() == 0) {
            if (getIsWifi()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.k.aPA().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.mUrlQuality = valueOf;
    }

    public void updatePostImageSize() {
        int i = 2000;
        switch (com.baidu.tbadk.core.k.aPA().getUploadImageQuality()) {
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

    public static boolean aWT() {
        return n.checkSD() && com.baidu.adp.gif.c.kg();
    }
}
