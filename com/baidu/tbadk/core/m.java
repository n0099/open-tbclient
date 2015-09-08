package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class m {
    private static m TG;
    private int TH = 1;
    private int mIsAbstractOn = 1;
    private int TI = 0;
    private boolean TJ = true;
    private int mViewImageQuality = 0;

    public static m rb() {
        m mVar;
        if (TG == null) {
            synchronized (m.class) {
                if (TG == null) {
                    TG = new m();
                }
                mVar = TG;
            }
            return mVar;
        }
        return TG;
    }

    private m() {
    }

    public void initSetting() {
        this.TI = com.baidu.tbadk.core.sharedPref.b.tx().getInt("image_quality", 0);
        this.TH = com.baidu.tbadk.core.sharedPref.b.tx().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.tx().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.tx().getInt("view_image_quality", 0);
        this.TJ = com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("show_images", true);
    }

    public void bo(int i) {
        this.TH = i;
        com.baidu.tbadk.core.sharedPref.b.tx().putInt("new_display_photo", i);
    }

    public int rc() {
        return this.TH;
    }

    public boolean rd() {
        if (this.TH == 0) {
            if (com.baidu.adp.lib.util.i.iM()) {
                return true;
            }
        } else if (this.TH == 1) {
            return true;
        }
        return false;
    }

    public void bp(int i) {
        if (this.TI != i) {
            this.TI = i;
            com.baidu.tbadk.core.sharedPref.b.tx().putInt("image_quality", i);
        }
    }

    public int re() {
        this.TI = com.baidu.tbadk.core.sharedPref.b.tx().getInt("image_quality", 0);
        return this.TI;
    }

    public boolean rf() {
        return this.TJ;
    }

    public void ae(boolean z) {
        if (this.TJ != z) {
            this.TJ = z;
            com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("show_images", z);
        }
    }

    public void bq(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.tx().putInt("view_image_quality", i);
            ar.uK().uR();
            ar.uK().uS();
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

    public boolean rg() {
        return this.TH == 0 || this.TI == 0 || this.mViewImageQuality == 0;
    }
}
