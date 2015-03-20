package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.be;
/* loaded from: classes.dex */
public class n {
    private static n Ot;
    private int Ou = 1;
    private int mIsAbstractOn = 1;
    private int Ov = 0;
    private boolean Ow = true;
    private int mViewImageQuality = 0;

    public static n px() {
        n nVar;
        if (Ot == null) {
            synchronized (n.class) {
                if (Ot == null) {
                    Ot = new n();
                }
                nVar = Ot;
            }
            return nVar;
        }
        return Ot;
    }

    private n() {
    }

    public void initSetting() {
        this.Ov = com.baidu.tbadk.core.sharedPref.b.rB().getInt("image_quality", 0);
        this.Ou = com.baidu.tbadk.core.sharedPref.b.rB().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.rB().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.rB().getInt("view_image_quality", 0);
        this.Ow = com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("show_images", true);
    }

    public void bi(int i) {
        this.Ou = i;
        com.baidu.tbadk.core.sharedPref.b.rB().putInt("new_display_photo", i);
    }

    public int py() {
        return this.Ou;
    }

    public boolean pz() {
        if (this.Ou == 0) {
            if (com.baidu.adp.lib.util.k.iI()) {
                return true;
            }
        } else if (this.Ou == 1) {
            return true;
        }
        return false;
    }

    public void bj(int i) {
        if (this.Ov != i) {
            this.Ov = i;
            com.baidu.tbadk.core.sharedPref.b.rB().putInt("image_quality", i);
        }
    }

    public int pA() {
        this.Ov = com.baidu.tbadk.core.sharedPref.b.rB().getInt("image_quality", 0);
        return this.Ov;
    }

    public boolean pB() {
        return this.Ow;
    }

    public void Y(boolean z) {
        if (this.Ow != z) {
            this.Ow = z;
            com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("show_images", z);
        }
    }

    public void bk(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.rB().putInt("view_image_quality", i);
            be.sY().tf();
            be.sY().tg();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void Z(boolean z) {
        if (z) {
            bi(0);
            bj(0);
            Y(true);
            bk(0);
            return;
        }
        bi(1);
        bj(1);
        Y(true);
        bk(1);
    }

    public boolean pC() {
        return this.Ou == 0 || this.Ov == 0 || this.mViewImageQuality == 0;
    }
}
