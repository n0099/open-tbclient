package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class i {
    private static i acr;
    private int acs = 1;
    private int mIsAbstractOn = 1;
    private int act = 0;
    private int acu = 0;
    private String forumName = null;
    private boolean acv = true;
    private int mViewImageQuality = 0;

    public static i te() {
        i iVar;
        if (acr == null) {
            synchronized (i.class) {
                if (acr == null) {
                    acr = new i();
                }
                iVar = acr;
            }
            return iVar;
        }
        return acr;
    }

    private i() {
    }

    public void initSetting() {
        this.act = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.acs = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.acv = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bz(int i) {
        this.acs = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int tf() {
        return this.acs;
    }

    public boolean tg() {
        if (this.acs == 0) {
            if (j.jF()) {
                return true;
            }
        } else if (this.acs == 1) {
            return true;
        }
        return false;
    }

    public int th() {
        this.act = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.act;
    }

    public void bA(int i) {
        if (this.acu != i) {
            this.acu = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int ti() {
        this.acu = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.acu;
    }

    public void cZ(String str) {
        this.forumName = str;
    }

    public String tj() {
        return this.forumName;
    }

    public boolean tk() {
        return this.acv;
    }

    public void ak(boolean z) {
        if (this.acv != z) {
            this.acv = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bB(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            ar.zw().zE();
            ar.zw().zF();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
