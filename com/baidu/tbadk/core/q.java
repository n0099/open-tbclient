package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class q {
    private static q SR;
    private int SS = 1;
    private int mIsAbstractOn = 1;
    private int ST = 0;
    private int SU = 0;
    private String forumName = null;
    private boolean SV = true;
    private int mViewImageQuality = 0;

    public static q po() {
        q qVar;
        if (SR == null) {
            synchronized (q.class) {
                if (SR == null) {
                    SR = new q();
                }
                qVar = SR;
            }
            return qVar;
        }
        return SR;
    }

    private q() {
    }

    public void initSetting() {
        this.ST = com.baidu.tbadk.core.sharedPref.b.uL().getInt("image_quality", 0);
        this.SS = com.baidu.tbadk.core.sharedPref.b.uL().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.uL().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.uL().getInt("view_image_quality", 0);
        this.SV = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("show_images", true);
    }

    public void bx(int i) {
        this.SS = i;
        com.baidu.tbadk.core.sharedPref.b.uL().putInt("new_display_photo", i);
    }

    public int pp() {
        return this.SS;
    }

    public boolean pq() {
        if (this.SS == 0) {
            if (com.baidu.adp.lib.util.i.hl()) {
                return true;
            }
        } else if (this.SS == 1) {
            return true;
        }
        return false;
    }

    public void by(int i) {
        if (this.ST != i) {
            this.ST = i;
            com.baidu.tbadk.core.sharedPref.b.uL().putInt("image_quality", i);
        }
    }

    public int pr() {
        this.ST = com.baidu.tbadk.core.sharedPref.b.uL().getInt("image_quality", 0);
        return this.ST;
    }

    public void bz(int i) {
        if (this.SU != i) {
            this.SU = i;
            com.baidu.tbadk.core.sharedPref.b.uL().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int ps() {
        this.SU = com.baidu.tbadk.core.sharedPref.b.uL().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.SU;
    }

    public void cd(String str) {
        this.forumName = str;
    }

    public String pt() {
        return this.forumName;
    }

    public boolean pu() {
        return this.SV;
    }

    public void al(boolean z) {
        if (this.SV != z) {
            this.SV = z;
            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("show_images", z);
        }
    }

    public void bA(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.uL().putInt("view_image_quality", i);
            av.wa().wh();
            av.wa().wi();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void am(boolean z) {
        if (z) {
            bx(0);
            by(0);
            al(true);
            bA(0);
            return;
        }
        bx(1);
        by(1);
        al(true);
        bA(1);
    }

    public boolean pv() {
        return this.SS == 0 || this.ST == 0 || this.mViewImageQuality == 0;
    }
}
