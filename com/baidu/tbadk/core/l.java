package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class l {
    private static l Sx;
    private int Sy = 1;
    private int mIsAbstractOn = 1;
    private int Sz = 0;
    private int SA = 0;
    private String forumName = null;
    private boolean SB = true;
    private int mViewImageQuality = 0;

    public static l oQ() {
        l lVar;
        if (Sx == null) {
            synchronized (l.class) {
                if (Sx == null) {
                    Sx = new l();
                }
                lVar = Sx;
            }
            return lVar;
        }
        return Sx;
    }

    private l() {
    }

    public void initSetting() {
        this.Sz = com.baidu.tbadk.core.sharedPref.b.uo().getInt("image_quality", 0);
        this.Sy = com.baidu.tbadk.core.sharedPref.b.uo().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.uo().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.uo().getInt("view_image_quality", 0);
        this.SB = com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("show_images", true);
    }

    public void bu(int i) {
        this.Sy = i;
        com.baidu.tbadk.core.sharedPref.b.uo().putInt("new_display_photo", i);
    }

    public int oR() {
        return this.Sy;
    }

    public boolean oS() {
        if (this.Sy == 0) {
            if (com.baidu.adp.lib.util.i.hf()) {
                return true;
            }
        } else if (this.Sy == 1) {
            return true;
        }
        return false;
    }

    public void bv(int i) {
        if (this.Sz != i) {
            this.Sz = i;
            com.baidu.tbadk.core.sharedPref.b.uo().putInt("image_quality", i);
        }
    }

    public int oT() {
        this.Sz = com.baidu.tbadk.core.sharedPref.b.uo().getInt("image_quality", 0);
        return this.Sz;
    }

    public void bw(int i) {
        if (this.SA != i) {
            this.SA = i;
            com.baidu.tbadk.core.sharedPref.b.uo().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int oU() {
        this.SA = com.baidu.tbadk.core.sharedPref.b.uo().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.SA;
    }

    public void bW(String str) {
        this.forumName = str;
    }

    public String oV() {
        return this.forumName;
    }

    public boolean oW() {
        return this.SB;
    }

    public void aj(boolean z) {
        if (this.SB != z) {
            this.SB = z;
            com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("show_images", z);
        }
    }

    public void bx(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.uo().putInt("view_image_quality", i);
            av.vD().vK();
            av.vD().vL();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void ak(boolean z) {
        if (z) {
            bu(0);
            bv(0);
            aj(true);
            bx(0);
            return;
        }
        bu(1);
        bv(1);
        aj(true);
        bx(1);
    }

    public boolean oX() {
        return this.Sy == 0 || this.Sz == 0 || this.mViewImageQuality == 0;
    }
}
