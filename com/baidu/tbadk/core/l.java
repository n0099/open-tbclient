package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
public class l {
    private static l LU;
    private int LV = 1;
    private int mIsAbstractOn = 1;
    private int LW = 0;
    private int LX = 0;
    private String forumName = null;
    private boolean LY = true;
    private int mViewImageQuality = 0;

    public static l nL() {
        l lVar;
        if (LU == null) {
            synchronized (l.class) {
                if (LU == null) {
                    LU = new l();
                }
                lVar = LU;
            }
            return lVar;
        }
        return LU;
    }

    private l() {
    }

    public void initSetting() {
        this.LW = com.baidu.tbadk.core.sharedPref.b.sN().getInt("image_quality", 0);
        this.LV = com.baidu.tbadk.core.sharedPref.b.sN().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.sN().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.sN().getInt("view_image_quality", 0);
        this.LY = com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("show_images", true);
    }

    public void bn(int i) {
        this.LV = i;
        com.baidu.tbadk.core.sharedPref.b.sN().putInt("new_display_photo", i);
    }

    public int nM() {
        return this.LV;
    }

    public boolean nN() {
        if (this.LV == 0) {
            if (com.baidu.adp.lib.util.i.fr()) {
                return true;
            }
        } else if (this.LV == 1) {
            return true;
        }
        return false;
    }

    public void bo(int i) {
        if (this.LW != i) {
            this.LW = i;
            com.baidu.tbadk.core.sharedPref.b.sN().putInt("image_quality", i);
        }
    }

    public int nO() {
        this.LW = com.baidu.tbadk.core.sharedPref.b.sN().getInt("image_quality", 0);
        return this.LW;
    }

    public void bp(int i) {
        if (this.LX != i) {
            this.LX = i;
            com.baidu.tbadk.core.sharedPref.b.sN().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int nP() {
        this.LX = com.baidu.tbadk.core.sharedPref.b.sN().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.LX;
    }

    public void cc(String str) {
        this.forumName = str;
    }

    public String nQ() {
        return this.forumName;
    }

    public boolean nR() {
        return this.LY;
    }

    public void ag(boolean z) {
        if (this.LY != z) {
            this.LY = z;
            com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("show_images", z);
        }
    }

    public void bq(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.sN().putInt("view_image_quality", i);
            bb.ue().um();
            bb.ue().un();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void ah(boolean z) {
        if (z) {
            bn(0);
            bo(0);
            ag(true);
            bq(0);
            return;
        }
        bn(1);
        bo(1);
        ag(true);
        bq(1);
    }

    public boolean nS() {
        return this.LV == 0 || this.LW == 0 || this.mViewImageQuality == 0;
    }
}
