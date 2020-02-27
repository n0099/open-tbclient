package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class ar {
    private static ar daw = null;
    private boolean mIsWifiCache = false;
    private boolean dax = false;
    private int mPostImageSize = 1500;
    private String mUrlQuality = String.valueOf(45);

    public static ar aGB() {
        if (daw == null) {
            synchronized (ar.class) {
                if (daw == null) {
                    daw = new ar();
                }
            }
        }
        return daw;
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

    public void fM(boolean z) {
        this.dax = z;
    }

    public boolean aGC() {
        return this.dax;
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
        if (com.baidu.tbadk.core.i.azM().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.azM().getViewImageQuality() != 1 : !this.mIsWifiCache) {
            z = false;
        }
        fM(z);
    }

    public void updateUrlQuality() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.azM().getViewImageQuality() == 0) {
            if (getIsWifi()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.azM().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.mUrlQuality = valueOf;
    }

    public void updatePostImageSize() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.azM().getUploadImageQuality()) {
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

    public static boolean aGD() {
        return m.checkSD() && com.baidu.adp.gif.c.fj();
    }
}
