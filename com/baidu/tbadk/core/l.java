package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class l {
    private static l Nt;
    private int Nu = 1;
    private int mIsAbstractOn = 1;
    private int Nv = 0;
    private int Nw = 0;
    private String forumName = null;
    private boolean Nx = true;
    private int mViewImageQuality = 0;

    public static l oC() {
        l lVar;
        if (Nt == null) {
            synchronized (l.class) {
                if (Nt == null) {
                    Nt = new l();
                }
                lVar = Nt;
            }
            return lVar;
        }
        return Nt;
    }

    private l() {
    }

    public void initSetting() {
        this.Nv = com.baidu.tbadk.core.sharedPref.b.tQ().getInt("image_quality", 0);
        this.Nu = com.baidu.tbadk.core.sharedPref.b.tQ().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.tQ().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.tQ().getInt("view_image_quality", 0);
        this.Nx = com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("show_images", true);
    }

    public void bA(int i) {
        this.Nu = i;
        com.baidu.tbadk.core.sharedPref.b.tQ().putInt("new_display_photo", i);
    }

    public int oD() {
        return this.Nu;
    }

    public boolean oE() {
        if (this.Nu == 0) {
            if (com.baidu.adp.lib.util.i.gl()) {
                return true;
            }
        } else if (this.Nu == 1) {
            return true;
        }
        return false;
    }

    public void bB(int i) {
        if (this.Nv != i) {
            this.Nv = i;
            com.baidu.tbadk.core.sharedPref.b.tQ().putInt("image_quality", i);
        }
    }

    public int oF() {
        this.Nv = com.baidu.tbadk.core.sharedPref.b.tQ().getInt("image_quality", 0);
        return this.Nv;
    }

    public void bC(int i) {
        if (this.Nw != i) {
            this.Nw = i;
            com.baidu.tbadk.core.sharedPref.b.tQ().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int oG() {
        this.Nw = com.baidu.tbadk.core.sharedPref.b.tQ().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.Nw;
    }

    public void cd(String str) {
        this.forumName = str;
    }

    public String oH() {
        return this.forumName;
    }

    public boolean oI() {
        return this.Nx;
    }

    public void ak(boolean z) {
        if (this.Nx != z) {
            this.Nx = z;
            com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("show_images", z);
        }
    }

    public void bD(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.tQ().putInt("view_image_quality", i);
            au.vg().vn();
            au.vg().vo();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void al(boolean z) {
        if (z) {
            bA(0);
            bB(0);
            ak(true);
            bD(0);
            return;
        }
        bA(1);
        bB(1);
        ak(true);
        bD(1);
    }

    public boolean oJ() {
        return this.Nu == 0 || this.Nv == 0 || this.mViewImageQuality == 0;
    }
}
