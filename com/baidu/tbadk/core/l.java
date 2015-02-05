package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
public class l {
    private static l CJ;
    private int CK = 1;
    private int mIsAbstractOn = 1;
    private int CL = 0;
    private boolean CM = true;
    private int mViewImageQuality = 0;

    public static l lV() {
        l lVar;
        if (CJ == null) {
            synchronized (l.class) {
                if (CJ == null) {
                    CJ = new l();
                }
                lVar = CJ;
            }
            return lVar;
        }
        return CJ;
    }

    private l() {
    }

    public void initSetting() {
        this.CL = com.baidu.tbadk.core.sharedPref.b.oc().getInt("image_quality", 0);
        this.CK = com.baidu.tbadk.core.sharedPref.b.oc().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.oc().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.oc().getInt("view_image_quality", 0);
        this.CM = com.baidu.tbadk.core.sharedPref.b.oc().getBoolean("show_images", true);
    }

    public void bj(int i) {
        this.CK = i;
        com.baidu.tbadk.core.sharedPref.b.oc().putInt("new_display_photo", i);
    }

    public int lW() {
        return this.CK;
    }

    public boolean lX() {
        if (this.CK == 0) {
            if (com.baidu.adp.lib.util.i.fg()) {
                return true;
            }
        } else if (this.CK == 1) {
            return true;
        }
        return false;
    }

    public void bk(int i) {
        if (this.CL != i) {
            this.CL = i;
            com.baidu.tbadk.core.sharedPref.b.oc().putInt("image_quality", i);
        }
    }

    public int lY() {
        this.CL = com.baidu.tbadk.core.sharedPref.b.oc().getInt("image_quality", 0);
        return this.CL;
    }

    public boolean lZ() {
        return this.CM;
    }

    public void ac(boolean z) {
        if (this.CM != z) {
            this.CM = z;
            com.baidu.tbadk.core.sharedPref.b.oc().putBoolean("show_images", z);
        }
    }

    public void bl(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.oc().putInt("view_image_quality", i);
            bg.pB().pI();
            bg.pB().pJ();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void ad(boolean z) {
        if (z) {
            bj(0);
            bk(0);
            ac(true);
            bl(0);
            return;
        }
        bj(1);
        bk(1);
        ac(true);
        bl(1);
    }

    public boolean ma() {
        return this.CK == 0 || this.CL == 0 || this.mViewImageQuality == 0;
    }
}
