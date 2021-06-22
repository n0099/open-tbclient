package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
import d.a.c.d.c;
import d.a.c.e.p.j;
import d.a.n0.r.k;
/* loaded from: classes3.dex */
public class TbImageHelper {
    public static TbImageHelper mInstance;
    public boolean mIsWifiCache = false;
    public boolean mShowBigImage = false;
    public int mPostImageSize = 1300;
    public String mUrlQuality = String.valueOf(45);

    public TbImageHelper() {
        updateNetworkStatusCache();
        updateAll();
    }

    public static TbImageHelper getInstance() {
        if (mInstance == null) {
            synchronized (TbImageHelper.class) {
                if (mInstance == null) {
                    mInstance = new TbImageHelper();
                }
            }
        }
        return mInstance;
    }

    public static boolean isSupportGifEmotions() {
        return FileHelper.checkSD() && c.c();
    }

    private void updateAll() {
        updateFrsShowBigImage();
        updateUrlQuality();
        updatePostImageSize();
    }

    private void updateNetworkStatusCache() {
        this.mIsWifiCache = j.H();
    }

    public boolean getIsWifi() {
        return this.mIsWifiCache;
    }

    public int getPostImageHeightLimit() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public int getPostImageSize() {
        updatePostImageSize();
        return this.mPostImageSize;
    }

    public String getUrlQuality() {
        return this.mUrlQuality;
    }

    public boolean isShowBigImage() {
        return this.mShowBigImage;
    }

    public void setNetworkIsWifi(boolean z) {
        this.mIsWifiCache = z;
        updateAll();
    }

    public void setShowBigImage(boolean z) {
        this.mShowBigImage = z;
    }

    public void updateFrsShowBigImage() {
        boolean z = true;
        if (k.c().e() != 0 ? k.c().e() != 1 : !this.mIsWifiCache) {
            z = false;
        }
        setShowBigImage(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        if (getIsWifi() != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updatePostImageSize() {
        int d2 = k.c().d();
        int i2 = 1300;
        if (d2 != 0) {
            if (d2 != 1) {
                if (d2 == 2 || d2 != 3) {
                    i2 = 1800;
                }
            }
            i2 = 2000;
        }
        this.mPostImageSize = i2;
    }

    public void updateUrlQuality() {
        String valueOf = String.valueOf(45);
        if (k.c().e() == 0) {
            if (getIsWifi()) {
                valueOf = String.valueOf(80);
            }
        } else if (k.c().e() == 1) {
            valueOf = String.valueOf(80);
        }
        this.mUrlQuality = valueOf;
    }
}
