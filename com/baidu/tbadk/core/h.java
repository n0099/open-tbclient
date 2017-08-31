package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class h {
    private static h SI;
    private int SJ = 1;
    private int mIsAbstractOn = 1;
    private int SK = 0;
    private int SL = 0;
    private String forumName = null;
    private boolean SM = true;
    private int mViewImageQuality = 0;

    public static h oS() {
        h hVar;
        if (SI == null) {
            synchronized (h.class) {
                if (SI == null) {
                    SI = new h();
                }
                hVar = SI;
            }
            return hVar;
        }
        return SI;
    }

    private h() {
    }

    public void initSetting() {
        this.SK = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.SJ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.SM = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bw(int i) {
        this.SJ = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int oT() {
        return this.SJ;
    }

    public boolean oU() {
        if (this.SJ == 0) {
            if (i.hj()) {
                return true;
            }
        } else if (this.SJ == 1) {
            return true;
        }
        return false;
    }

    public void bx(int i) {
        if (this.SK != i) {
            this.SK = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("image_quality", i);
        }
    }

    public int oV() {
        this.SK = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.SK;
    }

    public void by(int i) {
        if (this.SL != i) {
            this.SL = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int oW() {
        this.SL = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.SL;
    }

    public void cn(String str) {
        this.forumName = str;
    }

    public String oX() {
        return this.forumName;
    }

    public boolean oY() {
        return this.SM;
    }

    public void aj(boolean z) {
        if (this.SM != z) {
            this.SM = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bz(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            an.vO().vV();
            an.vO().vW();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void ak(boolean z) {
        if (z) {
            bw(0);
            bx(0);
            aj(true);
            bz(0);
            return;
        }
        bw(1);
        bx(1);
        aj(true);
        bz(1);
    }

    public boolean oZ() {
        return this.SJ == 0 || this.SK == 0 || this.mViewImageQuality == 0;
    }
}
