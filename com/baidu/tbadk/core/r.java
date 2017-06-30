package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
public class r {
    private static r RS;
    private int RT = 1;
    private int mIsAbstractOn = 1;
    private int RU = 0;
    private int RV = 0;
    private String forumName = null;
    private boolean RW = true;
    private int mViewImageQuality = 0;

    public static r oK() {
        r rVar;
        if (RS == null) {
            synchronized (r.class) {
                if (RS == null) {
                    RS = new r();
                }
                rVar = RS;
            }
            return rVar;
        }
        return RS;
    }

    private r() {
    }

    public void initSetting() {
        this.RU = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.RT = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.RW = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bv(int i) {
        this.RT = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int oL() {
        return this.RT;
    }

    public boolean oM() {
        if (this.RT == 0) {
            if (com.baidu.adp.lib.util.i.hk()) {
                return true;
            }
        } else if (this.RT == 1) {
            return true;
        }
        return false;
    }

    public void bw(int i) {
        if (this.RU != i) {
            this.RU = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("image_quality", i);
        }
    }

    public int oN() {
        this.RU = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.RU;
    }

    public void bx(int i) {
        if (this.RV != i) {
            this.RV = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int oO() {
        this.RV = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.RV;
    }

    public void cj(String str) {
        this.forumName = str;
    }

    public String oP() {
        return this.forumName;
    }

    public boolean oQ() {
        return this.RW;
    }

    public void aj(boolean z) {
        if (this.RW != z) {
            this.RW = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void by(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            ax.vA().vH();
            ax.vA().vI();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void ak(boolean z) {
        if (z) {
            bv(0);
            bw(0);
            aj(true);
            by(0);
            return;
        }
        bv(1);
        bw(1);
        aj(true);
        by(1);
    }

    public boolean oR() {
        return this.RT == 0 || this.RU == 0 || this.mViewImageQuality == 0;
    }
}
