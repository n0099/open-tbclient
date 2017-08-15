package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class h {
    private static h TE;
    private int TF = 1;
    private int mIsAbstractOn = 1;
    private int TG = 0;
    private int TH = 0;
    private String forumName = null;
    private boolean TI = true;
    private int mViewImageQuality = 0;

    public static h oX() {
        h hVar;
        if (TE == null) {
            synchronized (h.class) {
                if (TE == null) {
                    TE = new h();
                }
                hVar = TE;
            }
            return hVar;
        }
        return TE;
    }

    private h() {
    }

    public void initSetting() {
        this.TG = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.TF = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.TI = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bw(int i) {
        this.TF = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int oY() {
        return this.TF;
    }

    public boolean oZ() {
        if (this.TF == 0) {
            if (i.hs()) {
                return true;
            }
        } else if (this.TF == 1) {
            return true;
        }
        return false;
    }

    public void bx(int i) {
        if (this.TG != i) {
            this.TG = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("image_quality", i);
        }
    }

    public int pa() {
        this.TG = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.TG;
    }

    public void by(int i) {
        if (this.TH != i) {
            this.TH = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int pb() {
        this.TH = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.TH;
    }

    public void cu(String str) {
        this.forumName = str;
    }

    public String pc() {
        return this.forumName;
    }

    public boolean pd() {
        return this.TI;
    }

    public void aj(boolean z) {
        if (this.TI != z) {
            this.TI = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bz(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            am.vQ().vX();
            am.vQ().vY();
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

    public boolean pe() {
        return this.TF == 0 || this.TG == 0 || this.mViewImageQuality == 0;
    }
}
