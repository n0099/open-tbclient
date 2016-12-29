package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class l {
    private static l Oi;
    private int Oj = 1;
    private int mIsAbstractOn = 1;
    private int Ok = 0;
    private int Ol = 0;
    private String forumName = null;
    private boolean Om = true;
    private int mViewImageQuality = 0;

    public static l oJ() {
        l lVar;
        if (Oi == null) {
            synchronized (l.class) {
                if (Oi == null) {
                    Oi = new l();
                }
                lVar = Oi;
            }
            return lVar;
        }
        return Oi;
    }

    private l() {
    }

    public void initSetting() {
        this.Ok = com.baidu.tbadk.core.sharedPref.b.tW().getInt("image_quality", 0);
        this.Oj = com.baidu.tbadk.core.sharedPref.b.tW().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.tW().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.tW().getInt("view_image_quality", 0);
        this.Om = com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("show_images", true);
    }

    public void bB(int i) {
        this.Oj = i;
        com.baidu.tbadk.core.sharedPref.b.tW().putInt("new_display_photo", i);
    }

    public int oK() {
        return this.Oj;
    }

    public boolean oL() {
        if (this.Oj == 0) {
            if (com.baidu.adp.lib.util.i.gn()) {
                return true;
            }
        } else if (this.Oj == 1) {
            return true;
        }
        return false;
    }

    public void bC(int i) {
        if (this.Ok != i) {
            this.Ok = i;
            com.baidu.tbadk.core.sharedPref.b.tW().putInt("image_quality", i);
        }
    }

    public int oM() {
        this.Ok = com.baidu.tbadk.core.sharedPref.b.tW().getInt("image_quality", 0);
        return this.Ok;
    }

    public void bD(int i) {
        if (this.Ol != i) {
            this.Ol = i;
            com.baidu.tbadk.core.sharedPref.b.tW().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int oN() {
        this.Ol = com.baidu.tbadk.core.sharedPref.b.tW().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.Ol;
    }

    public void cf(String str) {
        this.forumName = str;
    }

    public String oO() {
        return this.forumName;
    }

    public boolean oP() {
        return this.Om;
    }

    public void ak(boolean z) {
        if (this.Om != z) {
            this.Om = z;
            com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("show_images", z);
        }
    }

    public void bE(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.tW().putInt("view_image_quality", i);
            aw.vm().vt();
            aw.vm().vu();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void al(boolean z) {
        if (z) {
            bB(0);
            bC(0);
            ak(true);
            bE(0);
            return;
        }
        bB(1);
        bC(1);
        ak(true);
        bE(1);
    }

    public boolean oQ() {
        return this.Oj == 0 || this.Ok == 0 || this.mViewImageQuality == 0;
    }
}
