package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class h {
    private static h SJ;
    private int SK = 1;
    private int mIsAbstractOn = 1;
    private int SL = 0;
    private int SM = 0;
    private String forumName = null;
    private boolean SN = true;
    private int mViewImageQuality = 0;

    public static h oM() {
        h hVar;
        if (SJ == null) {
            synchronized (h.class) {
                if (SJ == null) {
                    SJ = new h();
                }
                hVar = SJ;
            }
            return hVar;
        }
        return SJ;
    }

    private h() {
    }

    public void initSetting() {
        this.SL = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.SK = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.SN = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bz(int i) {
        this.SK = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int oN() {
        return this.SK;
    }

    public boolean oO() {
        if (this.SK == 0) {
            if (j.hi()) {
                return true;
            }
        } else if (this.SK == 1) {
            return true;
        }
        return false;
    }

    public void bA(int i) {
        if (this.SL != i) {
            this.SL = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("image_quality", i);
        }
    }

    public int oP() {
        this.SL = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.SL;
    }

    public void bB(int i) {
        if (this.SM != i) {
            this.SM = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int oQ() {
        this.SM = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.SM;
    }

    public void cm(String str) {
        this.forumName = str;
    }

    public String oR() {
        return this.forumName;
    }

    public boolean oS() {
        return this.SN;
    }

    public void aj(boolean z) {
        if (this.SN != z) {
            this.SN = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bC(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            an.vl().vs();
            an.vl().vt();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void ak(boolean z) {
        if (z) {
            bz(0);
            bA(0);
            aj(true);
            bC(0);
            return;
        }
        bz(1);
        bA(1);
        aj(true);
        bC(1);
    }

    public boolean oT() {
        return this.SK == 0 || this.SL == 0 || this.mViewImageQuality == 0;
    }
}
