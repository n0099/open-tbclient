package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class i {
    private static i bCB;
    private int mIsAbstractOn = 1;
    private int bCC = 0;
    private int bCD = 0;
    private String forumName = null;
    private boolean bCE = true;
    private int mViewImageQuality = 0;

    public static i abb() {
        i iVar;
        if (bCB == null) {
            synchronized (i.class) {
                if (bCB == null) {
                    bCB = new i();
                }
                iVar = bCB;
            }
            return iVar;
        }
        return bCB;
    }

    private i() {
    }

    public void initSetting() {
        this.bCC = com.baidu.tbadk.core.sharedPref.b.agM().getInt("image_quality", 0);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.agM().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.agM().getInt("view_image_quality", 0);
        this.bCE = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_images", true);
    }

    public int abc() {
        this.bCC = com.baidu.tbadk.core.sharedPref.b.agM().getInt("image_quality", 0);
        return this.bCC;
    }

    public void gK(int i) {
        if (this.bCD != i) {
            this.bCD = i;
            com.baidu.tbadk.core.sharedPref.b.agM().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int abd() {
        this.bCD = com.baidu.tbadk.core.sharedPref.b.agM().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.bCD;
    }

    public void lZ(String str) {
        this.forumName = str;
    }

    public String abe() {
        return this.forumName;
    }

    public boolean abf() {
        return this.bCE;
    }

    public void dB(boolean z) {
        if (this.bCE != z) {
            this.bCE = z;
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_images", z);
        }
    }

    public void gL(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.agM().putInt("view_image_quality", i);
            ar.ail().ait();
            ar.ail().aiu();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
