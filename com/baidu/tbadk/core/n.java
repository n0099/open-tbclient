package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class n {
    private static n OR;
    private int OS = 1;
    private int mIsAbstractOn = 1;
    private int OT = 0;
    private boolean OV = true;
    private int mViewImageQuality = 0;

    public static n qc() {
        n nVar;
        if (OR == null) {
            synchronized (n.class) {
                if (OR == null) {
                    OR = new n();
                }
                nVar = OR;
            }
            return nVar;
        }
        return OR;
    }

    private n() {
    }

    public void initSetting() {
        this.OT = com.baidu.tbadk.core.sharedPref.b.sl().getInt("image_quality", 0);
        this.OS = com.baidu.tbadk.core.sharedPref.b.sl().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.sl().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.sl().getInt("view_image_quality", 0);
        this.OV = com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("show_images", true);
    }

    public void bf(int i) {
        this.OS = i;
        com.baidu.tbadk.core.sharedPref.b.sl().putInt("new_display_photo", i);
    }

    public int qd() {
        return this.OS;
    }

    public boolean qe() {
        if (this.OS == 0) {
            if (com.baidu.adp.lib.util.k.iY()) {
                return true;
            }
        } else if (this.OS == 1) {
            return true;
        }
        return false;
    }

    public void bg(int i) {
        if (this.OT != i) {
            this.OT = i;
            com.baidu.tbadk.core.sharedPref.b.sl().putInt("image_quality", i);
        }
    }

    public int qf() {
        this.OT = com.baidu.tbadk.core.sharedPref.b.sl().getInt("image_quality", 0);
        return this.OT;
    }

    public boolean qg() {
        return this.OV;
    }

    public void ac(boolean z) {
        if (this.OV != z) {
            this.OV = z;
            com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("show_images", z);
        }
    }

    public void bh(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.sl().putInt("view_image_quality", i);
            bc.tB().tI();
            bc.tB().tJ();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void ad(boolean z) {
        if (z) {
            bf(0);
            bg(0);
            ac(true);
            bh(0);
            return;
        }
        bf(1);
        bg(1);
        ac(true);
        bh(1);
    }

    public boolean qh() {
        return this.OS == 0 || this.OT == 0 || this.mViewImageQuality == 0;
    }
}
