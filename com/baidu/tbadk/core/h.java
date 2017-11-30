package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class h {
    private static h TK;
    private int TL = 1;
    private int mIsAbstractOn = 1;
    private int TM = 0;
    private int TO = 0;
    private String forumName = null;
    private boolean TP = true;
    private int mViewImageQuality = 0;

    public static h pa() {
        h hVar;
        if (TK == null) {
            synchronized (h.class) {
                if (TK == null) {
                    TK = new h();
                }
                hVar = TK;
            }
            return hVar;
        }
        return TK;
    }

    private h() {
    }

    public void initSetting() {
        this.TM = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.TL = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.TP = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bz(int i) {
        this.TL = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int pb() {
        return this.TL;
    }

    public boolean pc() {
        if (this.TL == 0) {
            if (j.hi()) {
                return true;
            }
        } else if (this.TL == 1) {
            return true;
        }
        return false;
    }

    public int pd() {
        this.TM = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.TM;
    }

    public void bA(int i) {
        if (this.TO != i) {
            this.TO = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int pe() {
        this.TO = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.TO;
    }

    public void cs(String str) {
        this.forumName = str;
    }

    public String pf() {
        return this.forumName;
    }

    public boolean pg() {
        return this.TP;
    }

    public void ai(boolean z) {
        if (this.TP != z) {
            this.TP = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bB(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            an.vv().vD();
            an.vv().vE();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
