package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class m {
    private static m TF;
    private int TG = 1;
    private int mIsAbstractOn = 1;
    private int TH = 0;
    private boolean TI = true;
    private int mViewImageQuality = 0;

    public static m rd() {
        m mVar;
        if (TF == null) {
            synchronized (m.class) {
                if (TF == null) {
                    TF = new m();
                }
                mVar = TF;
            }
            return mVar;
        }
        return TF;
    }

    private m() {
    }

    public void initSetting() {
        this.TH = com.baidu.tbadk.core.sharedPref.b.ts().getInt("image_quality", 0);
        this.TG = com.baidu.tbadk.core.sharedPref.b.ts().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.ts().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.ts().getInt("view_image_quality", 0);
        this.TI = com.baidu.tbadk.core.sharedPref.b.ts().getBoolean("show_images", true);
    }

    public void bo(int i) {
        this.TG = i;
        com.baidu.tbadk.core.sharedPref.b.ts().putInt("new_display_photo", i);
    }

    public int re() {
        return this.TG;
    }

    public boolean rf() {
        if (this.TG == 0) {
            if (com.baidu.adp.lib.util.i.iP()) {
                return true;
            }
        } else if (this.TG == 1) {
            return true;
        }
        return false;
    }

    public void bp(int i) {
        if (this.TH != i) {
            this.TH = i;
            com.baidu.tbadk.core.sharedPref.b.ts().putInt("image_quality", i);
        }
    }

    public int rg() {
        this.TH = com.baidu.tbadk.core.sharedPref.b.ts().getInt("image_quality", 0);
        return this.TH;
    }

    public boolean rh() {
        return this.TI;
    }

    public void ae(boolean z) {
        if (this.TI != z) {
            this.TI = z;
            com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("show_images", z);
        }
    }

    public void bq(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.ts().putInt("view_image_quality", i);
            ar.uE().uL();
            ar.uE().uM();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void af(boolean z) {
        if (z) {
            bo(0);
            bp(0);
            ae(true);
            bq(0);
            return;
        }
        bo(1);
        bp(1);
        ae(true);
        bq(1);
    }

    public boolean ri() {
        return this.TG == 0 || this.TH == 0 || this.mViewImageQuality == 0;
    }
}
