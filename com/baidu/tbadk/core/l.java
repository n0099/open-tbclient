package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.az;
/* loaded from: classes.dex */
public class l {
    private static l Rg;
    private int Rh = 1;
    private int mIsAbstractOn = 1;
    private int Ri = 0;
    private int Rj = 0;
    private String forumName = null;
    private boolean Rk = true;
    private int mViewImageQuality = 0;

    public static l qE() {
        l lVar;
        if (Rg == null) {
            synchronized (l.class) {
                if (Rg == null) {
                    Rg = new l();
                }
                lVar = Rg;
            }
            return lVar;
        }
        return Rg;
    }

    private l() {
    }

    public void initSetting() {
        this.Ri = com.baidu.tbadk.core.sharedPref.b.vk().getInt("image_quality", 0);
        this.Rh = com.baidu.tbadk.core.sharedPref.b.vk().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.vk().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.vk().getInt("view_image_quality", 0);
        this.Rk = com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("show_images", true);
    }

    public void bv(int i) {
        this.Rh = i;
        com.baidu.tbadk.core.sharedPref.b.vk().putInt("new_display_photo", i);
    }

    public int qF() {
        return this.Rh;
    }

    public boolean qG() {
        if (this.Rh == 0) {
            if (com.baidu.adp.lib.util.i.jg()) {
                return true;
            }
        } else if (this.Rh == 1) {
            return true;
        }
        return false;
    }

    public void bw(int i) {
        if (this.Ri != i) {
            this.Ri = i;
            com.baidu.tbadk.core.sharedPref.b.vk().putInt("image_quality", i);
        }
    }

    public int qH() {
        this.Ri = com.baidu.tbadk.core.sharedPref.b.vk().getInt("image_quality", 0);
        return this.Ri;
    }

    public void bz(int i) {
        if (this.Rj != i) {
            this.Rj = i;
            com.baidu.tbadk.core.sharedPref.b.vk().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int qI() {
        this.Rj = com.baidu.tbadk.core.sharedPref.b.vk().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.Rj;
    }

    public void ce(String str) {
        this.forumName = str;
    }

    public String qJ() {
        return this.forumName;
    }

    public boolean qK() {
        return this.Rk;
    }

    public void ad(boolean z) {
        if (this.Rk != z) {
            this.Rk = z;
            com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("show_images", z);
        }
    }

    public void bA(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.vk().putInt("view_image_quality", i);
            az.wz().wG();
            az.wz().wH();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void ae(boolean z) {
        if (z) {
            bv(0);
            bw(0);
            ad(true);
            bA(0);
            return;
        }
        bv(1);
        bw(1);
        ad(true);
        bA(1);
    }

    public boolean qL() {
        return this.Rh == 0 || this.Ri == 0 || this.mViewImageQuality == 0;
    }
}
