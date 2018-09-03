package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class i {
    private static i acs;
    private int act = 1;
    private int mIsAbstractOn = 1;
    private int acu = 0;
    private int acv = 0;
    private String forumName = null;
    private boolean acw = true;
    private int mViewImageQuality = 0;

    public static i td() {
        i iVar;
        if (acs == null) {
            synchronized (i.class) {
                if (acs == null) {
                    acs = new i();
                }
                iVar = acs;
            }
            return iVar;
        }
        return acs;
    }

    private i() {
    }

    public void initSetting() {
        this.acu = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.act = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.acw = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bz(int i) {
        this.act = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int te() {
        return this.act;
    }

    public boolean tf() {
        if (this.act == 0) {
            if (j.jF()) {
                return true;
            }
        } else if (this.act == 1) {
            return true;
        }
        return false;
    }

    public int tg() {
        this.acu = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.acu;
    }

    public void bA(int i) {
        if (this.acv != i) {
            this.acv = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int th() {
        this.acv = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.acv;
    }

    public void da(String str) {
        this.forumName = str;
    }

    public String ti() {
        return this.forumName;
    }

    public boolean tj() {
        return this.acw;
    }

    public void al(boolean z) {
        if (this.acw != z) {
            this.acw = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bB(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            ar.zu().zC();
            ar.zu().zD();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
