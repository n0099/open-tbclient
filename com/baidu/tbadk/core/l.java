package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class l {
    private static l Om;
    private int On = 1;
    private int mIsAbstractOn = 1;
    private int Oo = 0;
    private int Op = 0;
    private String forumName = null;
    private boolean Oq = true;
    private int mViewImageQuality = 0;

    public static l oJ() {
        l lVar;
        if (Om == null) {
            synchronized (l.class) {
                if (Om == null) {
                    Om = new l();
                }
                lVar = Om;
            }
            return lVar;
        }
        return Om;
    }

    private l() {
    }

    public void initSetting() {
        this.Oo = com.baidu.tbadk.core.sharedPref.b.um().getInt("image_quality", 0);
        this.On = com.baidu.tbadk.core.sharedPref.b.um().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.um().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.um().getInt("view_image_quality", 0);
        this.Oq = com.baidu.tbadk.core.sharedPref.b.um().getBoolean("show_images", true);
    }

    public void bA(int i) {
        this.On = i;
        com.baidu.tbadk.core.sharedPref.b.um().putInt("new_display_photo", i);
    }

    public int oK() {
        return this.On;
    }

    public boolean oL() {
        if (this.On == 0) {
            if (com.baidu.adp.lib.util.i.gn()) {
                return true;
            }
        } else if (this.On == 1) {
            return true;
        }
        return false;
    }

    public void bB(int i) {
        if (this.Oo != i) {
            this.Oo = i;
            com.baidu.tbadk.core.sharedPref.b.um().putInt("image_quality", i);
        }
    }

    public int oM() {
        this.Oo = com.baidu.tbadk.core.sharedPref.b.um().getInt("image_quality", 0);
        return this.Oo;
    }

    public void bC(int i) {
        if (this.Op != i) {
            this.Op = i;
            com.baidu.tbadk.core.sharedPref.b.um().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int oN() {
        this.Op = com.baidu.tbadk.core.sharedPref.b.um().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.Op;
    }

    public void ce(String str) {
        this.forumName = str;
    }

    public String oO() {
        return this.forumName;
    }

    public boolean oP() {
        return this.Oq;
    }

    public void ak(boolean z) {
        if (this.Oq != z) {
            this.Oq = z;
            com.baidu.tbadk.core.sharedPref.b.um().putBoolean("show_images", z);
        }
    }

    public void bD(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.um().putInt("view_image_quality", i);
            ay.vC().vJ();
            ay.vC().vK();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void al(boolean z) {
        if (z) {
            bA(0);
            bB(0);
            ak(true);
            bD(0);
            return;
        }
        bA(1);
        bB(1);
        ak(true);
        bD(1);
    }

    public boolean oQ() {
        return this.On == 0 || this.Oo == 0 || this.mViewImageQuality == 0;
    }
}
