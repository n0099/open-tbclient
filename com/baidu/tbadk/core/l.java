package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class l {
    private static l yQ;
    private int yR = 1;
    private int mIsAbstractOn = 1;
    private int yS = 0;
    private boolean yT = true;
    private int mViewImageQuality = 0;

    public static l js() {
        l lVar;
        if (yQ == null) {
            synchronized (l.class) {
                if (yQ == null) {
                    yQ = new l();
                }
                lVar = yQ;
            }
            return lVar;
        }
        return yQ;
    }

    private l() {
    }

    public void initSetting() {
        this.yS = com.baidu.tbadk.core.sharedPref.b.lk().getInt("image_quality", 0);
        this.yR = com.baidu.tbadk.core.sharedPref.b.lk().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.lk().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.lk().getInt("view_image_quality", 0);
        this.yT = com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("show_images", true);
    }

    public void aI(int i) {
        this.yR = i;
        com.baidu.tbadk.core.sharedPref.b.lk().putInt("new_display_photo", i);
    }

    public int jt() {
        return this.yR;
    }

    public boolean ju() {
        if (this.yR == 0) {
            if (com.baidu.adp.lib.util.j.fi()) {
                return true;
            }
        } else if (this.yR == 1) {
            return true;
        }
        return false;
    }

    public void aJ(int i) {
        if (this.yS != i) {
            this.yS = i;
            com.baidu.tbadk.core.sharedPref.b.lk().putInt("image_quality", i);
        }
    }

    public int jv() {
        this.yS = com.baidu.tbadk.core.sharedPref.b.lk().getInt("image_quality", 0);
        return this.yS;
    }

    public boolean jw() {
        return this.yT;
    }

    public void M(boolean z) {
        if (this.yT != z) {
            this.yT = z;
            com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("show_images", z);
        }
    }

    public void aK(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.lk().putInt("view_image_quality", i);
            ba.mD().mK();
            ba.mD().mL();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void N(boolean z) {
        if (z) {
            aI(0);
            aJ(0);
            M(true);
            aK(0);
            return;
        }
        aI(1);
        aJ(1);
        M(true);
        aK(1);
    }

    public boolean jx() {
        return this.yR == 0 || this.yS == 0 || this.mViewImageQuality == 0;
    }
}
