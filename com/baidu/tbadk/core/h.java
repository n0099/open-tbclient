package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class h {
    private static h Sf;
    private int Sg = 1;
    private int mIsAbstractOn = 1;
    private int Sh = 0;
    private int Si = 0;
    private String forumName = null;
    private boolean Sj = true;
    private int mViewImageQuality = 0;

    public static h oN() {
        h hVar;
        if (Sf == null) {
            synchronized (h.class) {
                if (Sf == null) {
                    Sf = new h();
                }
                hVar = Sf;
            }
            return hVar;
        }
        return Sf;
    }

    private h() {
    }

    public void initSetting() {
        this.Sh = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.Sg = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.Sj = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bu(int i) {
        this.Sg = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int oO() {
        return this.Sg;
    }

    public boolean oP() {
        if (this.Sg == 0) {
            if (i.hi()) {
                return true;
            }
        } else if (this.Sg == 1) {
            return true;
        }
        return false;
    }

    public void bv(int i) {
        if (this.Sh != i) {
            this.Sh = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("image_quality", i);
        }
    }

    public int oQ() {
        this.Sh = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.Sh;
    }

    public void bw(int i) {
        if (this.Si != i) {
            this.Si = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int oR() {
        this.Si = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.Si;
    }

    public void co(String str) {
        this.forumName = str;
    }

    public String oS() {
        return this.forumName;
    }

    public boolean oT() {
        return this.Sj;
    }

    public void aj(boolean z) {
        if (this.Sj != z) {
            this.Sj = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bx(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            am.vG().vN();
            am.vG().vO();
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

    public boolean oU() {
        return this.Sg == 0 || this.Sh == 0 || this.mViewImageQuality == 0;
    }
}
