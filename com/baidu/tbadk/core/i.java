package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class i {
    private static i aIi;
    private int aIj = 1;
    private int mIsAbstractOn = 1;
    private int aIk = 0;
    private int aIl = 0;
    private String forumName = null;
    private boolean aIm = true;
    private int mViewImageQuality = 0;

    public static i wB() {
        i iVar;
        if (aIi == null) {
            synchronized (i.class) {
                if (aIi == null) {
                    aIi = new i();
                }
                iVar = aIi;
            }
            return iVar;
        }
        return aIi;
    }

    private i() {
    }

    public void initSetting() {
        this.aIk = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.aIj = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.aIm = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void ez(int i) {
        this.aIj = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int wC() {
        return this.aIj;
    }

    public boolean wD() {
        if (this.aIj == 0) {
            if (j.oJ()) {
                return true;
            }
        } else if (this.aIj == 1) {
            return true;
        }
        return false;
    }

    public int wE() {
        this.aIk = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.aIk;
    }

    public void eA(int i) {
        if (this.aIl != i) {
            this.aIl = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int wF() {
        this.aIl = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.aIl;
    }

    public void cz(String str) {
        this.forumName = str;
    }

    public String wG() {
        return this.forumName;
    }

    public boolean wH() {
        return this.aIm;
    }

    public void aP(boolean z) {
        if (this.aIm != z) {
            this.aIm = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void eB(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            an.CS().Da();
            an.CS().Db();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
