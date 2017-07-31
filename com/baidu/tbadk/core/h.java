package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class h {
    private static h TC;
    private int TD = 1;
    private int mIsAbstractOn = 1;
    private int TE = 0;
    private int TF = 0;
    private String forumName = null;
    private boolean TG = true;
    private int mViewImageQuality = 0;

    public static h oX() {
        h hVar;
        if (TC == null) {
            synchronized (h.class) {
                if (TC == null) {
                    TC = new h();
                }
                hVar = TC;
            }
            return hVar;
        }
        return TC;
    }

    private h() {
    }

    public void initSetting() {
        this.TE = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.TD = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.TG = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bw(int i) {
        this.TD = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int oY() {
        return this.TD;
    }

    public boolean oZ() {
        if (this.TD == 0) {
            if (i.hs()) {
                return true;
            }
        } else if (this.TD == 1) {
            return true;
        }
        return false;
    }

    public void bx(int i) {
        if (this.TE != i) {
            this.TE = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("image_quality", i);
        }
    }

    public int pa() {
        this.TE = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.TE;
    }

    public void by(int i) {
        if (this.TF != i) {
            this.TF = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int pb() {
        this.TF = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.TF;
    }

    public void cu(String str) {
        this.forumName = str;
    }

    public String pc() {
        return this.forumName;
    }

    public boolean pd() {
        return this.TG;
    }

    public void aj(boolean z) {
        if (this.TG != z) {
            this.TG = z;
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
        return this.TD == 0 || this.TE == 0 || this.mViewImageQuality == 0;
    }
}
