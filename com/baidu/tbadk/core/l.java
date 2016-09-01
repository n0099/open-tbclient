package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.bb;
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

    public static l oG() {
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
        this.Ok = com.baidu.tbadk.core.sharedPref.b.tS().getInt("image_quality", 0);
        this.Oj = com.baidu.tbadk.core.sharedPref.b.tS().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.tS().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.tS().getInt("view_image_quality", 0);
        this.Om = com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("show_images", true);
    }

    public void bA(int i) {
        this.Oj = i;
        com.baidu.tbadk.core.sharedPref.b.tS().putInt("new_display_photo", i);
    }

    public int oH() {
        return this.Oj;
    }

    public boolean oI() {
        if (this.Oj == 0) {
            if (com.baidu.adp.lib.util.i.gn()) {
                return true;
            }
        } else if (this.Oj == 1) {
            return true;
        }
        return false;
    }

    public void bB(int i) {
        if (this.Ok != i) {
            this.Ok = i;
            com.baidu.tbadk.core.sharedPref.b.tS().putInt("image_quality", i);
        }
    }

    public int oJ() {
        this.Ok = com.baidu.tbadk.core.sharedPref.b.tS().getInt("image_quality", 0);
        return this.Ok;
    }

    public void bC(int i) {
        if (this.Ol != i) {
            this.Ol = i;
            com.baidu.tbadk.core.sharedPref.b.tS().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int oK() {
        this.Ol = com.baidu.tbadk.core.sharedPref.b.tS().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.Ol;
    }

    public void cd(String str) {
        this.forumName = str;
    }

    public String oL() {
        return this.forumName;
    }

    public boolean oM() {
        return this.Om;
    }

    public void ai(boolean z) {
        if (this.Om != z) {
            this.Om = z;
            com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("show_images", z);
        }
    }

    public void bD(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.tS().putInt("view_image_quality", i);
            bb.vk().vr();
            bb.vk().vs();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void aj(boolean z) {
        if (z) {
            bA(0);
            bB(0);
            ai(true);
            bD(0);
            return;
        }
        bA(1);
        bB(1);
        ai(true);
        bD(1);
    }

    public boolean oN() {
        return this.Oj == 0 || this.Ok == 0 || this.mViewImageQuality == 0;
    }
}
