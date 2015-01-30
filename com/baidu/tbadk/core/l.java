package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
public class l {
    private static l CM;
    private int CO = 1;
    private int mIsAbstractOn = 1;
    private int CP = 0;
    private boolean CQ = true;
    private int mViewImageQuality = 0;

    public static l mc() {
        l lVar;
        if (CM == null) {
            synchronized (l.class) {
                if (CM == null) {
                    CM = new l();
                }
                lVar = CM;
            }
            return lVar;
        }
        return CM;
    }

    private l() {
    }

    public void initSetting() {
        this.CP = com.baidu.tbadk.core.sharedPref.b.oj().getInt("image_quality", 0);
        this.CO = com.baidu.tbadk.core.sharedPref.b.oj().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.oj().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.oj().getInt("view_image_quality", 0);
        this.CQ = com.baidu.tbadk.core.sharedPref.b.oj().getBoolean("show_images", true);
    }

    public void bj(int i) {
        this.CO = i;
        com.baidu.tbadk.core.sharedPref.b.oj().putInt("new_display_photo", i);
    }

    public int md() {
        return this.CO;
    }

    public boolean me() {
        if (this.CO == 0) {
            if (com.baidu.adp.lib.util.i.fg()) {
                return true;
            }
        } else if (this.CO == 1) {
            return true;
        }
        return false;
    }

    public void bk(int i) {
        if (this.CP != i) {
            this.CP = i;
            com.baidu.tbadk.core.sharedPref.b.oj().putInt("image_quality", i);
        }
    }

    public int mf() {
        this.CP = com.baidu.tbadk.core.sharedPref.b.oj().getInt("image_quality", 0);
        return this.CP;
    }

    public boolean mg() {
        return this.CQ;
    }

    public void ac(boolean z) {
        if (this.CQ != z) {
            this.CQ = z;
            com.baidu.tbadk.core.sharedPref.b.oj().putBoolean("show_images", z);
        }
    }

    public void bl(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.oj().putInt("view_image_quality", i);
            bg.pI().pP();
            bg.pI().pQ();
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

    public boolean mh() {
        return this.CO == 0 || this.CP == 0 || this.mViewImageQuality == 0;
    }
}
