package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.be;
/* loaded from: classes.dex */
public class n {
    private static n Ov;
    private int Ow = 1;
    private int mIsAbstractOn = 1;
    private int Ox = 0;
    private boolean Oy = true;
    private int mViewImageQuality = 0;

    public static n px() {
        n nVar;
        if (Ov == null) {
            synchronized (n.class) {
                if (Ov == null) {
                    Ov = new n();
                }
                nVar = Ov;
            }
            return nVar;
        }
        return Ov;
    }

    private n() {
    }

    public void initSetting() {
        this.Ox = com.baidu.tbadk.core.sharedPref.b.rB().getInt("image_quality", 0);
        this.Ow = com.baidu.tbadk.core.sharedPref.b.rB().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.rB().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.rB().getInt("view_image_quality", 0);
        this.Oy = com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("show_images", true);
    }

    public void bi(int i) {
        this.Ow = i;
        com.baidu.tbadk.core.sharedPref.b.rB().putInt("new_display_photo", i);
    }

    public int py() {
        return this.Ow;
    }

    public boolean pz() {
        if (this.Ow == 0) {
            if (com.baidu.adp.lib.util.k.iI()) {
                return true;
            }
        } else if (this.Ow == 1) {
            return true;
        }
        return false;
    }

    public void bj(int i) {
        if (this.Ox != i) {
            this.Ox = i;
            com.baidu.tbadk.core.sharedPref.b.rB().putInt("image_quality", i);
        }
    }

    public int pA() {
        this.Ox = com.baidu.tbadk.core.sharedPref.b.rB().getInt("image_quality", 0);
        return this.Ox;
    }

    public boolean pB() {
        return this.Oy;
    }

    public void Y(boolean z) {
        if (this.Oy != z) {
            this.Oy = z;
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
        return this.Ow == 0 || this.Ox == 0 || this.mViewImageQuality == 0;
    }
}
