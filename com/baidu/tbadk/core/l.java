package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class l {
    private static l Oj;
    private int Ok = 1;
    private int mIsAbstractOn = 1;
    private int Ol = 0;
    private int Om = 0;
    private String forumName = null;
    private boolean On = true;
    private int mViewImageQuality = 0;

    public static l oH() {
        l lVar;
        if (Oj == null) {
            synchronized (l.class) {
                if (Oj == null) {
                    Oj = new l();
                }
                lVar = Oj;
            }
            return lVar;
        }
        return Oj;
    }

    private l() {
    }

    public void initSetting() {
        this.Ol = com.baidu.tbadk.core.sharedPref.b.uh().getInt("image_quality", 0);
        this.Ok = com.baidu.tbadk.core.sharedPref.b.uh().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.uh().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.uh().getInt("view_image_quality", 0);
        this.On = com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("show_images", true);
    }

    public void bA(int i) {
        this.Ok = i;
        com.baidu.tbadk.core.sharedPref.b.uh().putInt("new_display_photo", i);
    }

    public int oI() {
        return this.Ok;
    }

    public boolean oJ() {
        if (this.Ok == 0) {
            if (com.baidu.adp.lib.util.i.gn()) {
                return true;
            }
        } else if (this.Ok == 1) {
            return true;
        }
        return false;
    }

    public void bB(int i) {
        if (this.Ol != i) {
            this.Ol = i;
            com.baidu.tbadk.core.sharedPref.b.uh().putInt("image_quality", i);
        }
    }

    public int oK() {
        this.Ol = com.baidu.tbadk.core.sharedPref.b.uh().getInt("image_quality", 0);
        return this.Ol;
    }

    public void bC(int i) {
        if (this.Om != i) {
            this.Om = i;
            com.baidu.tbadk.core.sharedPref.b.uh().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int oL() {
        this.Om = com.baidu.tbadk.core.sharedPref.b.uh().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.Om;
    }

    public void cd(String str) {
        this.forumName = str;
    }

    public String oM() {
        return this.forumName;
    }

    public boolean oN() {
        return this.On;
    }

    public void ai(boolean z) {
        if (this.On != z) {
            this.On = z;
            com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("show_images", z);
        }
    }

    public void bD(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.uh().putInt("view_image_quality", i);
            ba.vy().vF();
            ba.vy().vG();
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

    public boolean oO() {
        return this.Ok == 0 || this.Ol == 0 || this.mViewImageQuality == 0;
    }
}
