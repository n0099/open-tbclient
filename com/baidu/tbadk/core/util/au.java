package com.baidu.tbadk.core.util;
/* loaded from: classes2.dex */
public class au {
    private static au ele = null;
    private boolean mIsWifiCache = false;
    private boolean elf = false;
    private int mPostImageSize = 1500;
    private String mUrlQuality = String.valueOf(45);

    public static au bjr() {
        if (ele == null) {
            synchronized (au.class) {
                if (ele == null) {
                    ele = new au();
                }
            }
        }
        return ele;
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

    public void in(boolean z) {
        this.elf = z;
    }

    public boolean bjs() {
        return this.elf;
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
        if (com.baidu.tbadk.core.k.bbM().getViewImageQuality() != 0 ? com.baidu.tbadk.core.k.bbM().getViewImageQuality() != 1 : !this.mIsWifiCache) {
            z = false;
        }
        in(z);
    }

    public void updateUrlQuality() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.k.bbM().getViewImageQuality() == 0) {
            if (getIsWifi()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.k.bbM().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.mUrlQuality = valueOf;
    }

    public void updatePostImageSize() {
        int i = 2000;
        switch (com.baidu.tbadk.core.k.bbM().getUploadImageQuality()) {
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

    public static boolean bjt() {
        return n.checkSD() && com.baidu.adp.gif.c.lF();
    }
}
