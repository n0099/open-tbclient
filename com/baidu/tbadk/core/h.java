package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class h {
    private static h TG;
    private int TH = 1;
    private int mIsAbstractOn = 1;
    private int TI = 0;
    private int TJ = 0;
    private String forumName = null;
    private boolean TK = true;
    private int mViewImageQuality = 0;

    public static h oY() {
        h hVar;
        if (TG == null) {
            synchronized (h.class) {
                if (TG == null) {
                    TG = new h();
                }
                hVar = TG;
            }
            return hVar;
        }
        return TG;
    }

    private h() {
    }

    public void initSetting() {
        this.TI = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.TH = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.TK = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bz(int i) {
        this.TH = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int oZ() {
        return this.TH;
    }

    public boolean pa() {
        if (this.TH == 0) {
            if (j.hi()) {
                return true;
            }
        } else if (this.TH == 1) {
            return true;
        }
        return false;
    }

    public int pb() {
        this.TI = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.TI;
    }

    public void bA(int i) {
        if (this.TJ != i) {
            this.TJ = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int pc() {
        this.TJ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.TJ;
    }

    public void cs(String str) {
        this.forumName = str;
    }

    public String pd() {
        return this.forumName;
    }

    public boolean pe() {
        return this.TK;
    }

    public void ai(boolean z) {
        if (this.TK != z) {
            this.TK = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bB(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            an.vs().vA();
            an.vs().vB();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
