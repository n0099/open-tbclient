package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class h {
    private static h TH;
    private int TI = 1;
    private int mIsAbstractOn = 1;
    private int TJ = 0;
    private int TK = 0;
    private String forumName = null;
    private boolean TL = true;
    private int mViewImageQuality = 0;

    public static h oY() {
        h hVar;
        if (TH == null) {
            synchronized (h.class) {
                if (TH == null) {
                    TH = new h();
                }
                hVar = TH;
            }
            return hVar;
        }
        return TH;
    }

    private h() {
    }

    public void initSetting() {
        this.TJ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.TI = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.TL = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bz(int i) {
        this.TI = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int oZ() {
        return this.TI;
    }

    public boolean pa() {
        if (this.TI == 0) {
            if (j.hi()) {
                return true;
            }
        } else if (this.TI == 1) {
            return true;
        }
        return false;
    }

    public int pb() {
        this.TJ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.TJ;
    }

    public void bA(int i) {
        if (this.TK != i) {
            this.TK = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int pc() {
        this.TK = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.TK;
    }

    public void cs(String str) {
        this.forumName = str;
    }

    public String pd() {
        return this.forumName;
    }

    public boolean pe() {
        return this.TL;
    }

    public void ai(boolean z) {
        if (this.TL != z) {
            this.TL = z;
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
