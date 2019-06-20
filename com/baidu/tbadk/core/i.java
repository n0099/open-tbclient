package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class i {
    private static i bCC;
    private int mIsAbstractOn = 1;
    private int bCD = 0;
    private int bCE = 0;
    private String forumName = null;
    private boolean bCF = true;
    private int mViewImageQuality = 0;

    public static i abb() {
        i iVar;
        if (bCC == null) {
            synchronized (i.class) {
                if (bCC == null) {
                    bCC = new i();
                }
                iVar = bCC;
            }
            return iVar;
        }
        return bCC;
    }

    private i() {
    }

    public void initSetting() {
        this.bCD = com.baidu.tbadk.core.sharedPref.b.agM().getInt("image_quality", 0);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.agM().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.agM().getInt("view_image_quality", 0);
        this.bCF = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_images", true);
    }

    public int abc() {
        this.bCD = com.baidu.tbadk.core.sharedPref.b.agM().getInt("image_quality", 0);
        return this.bCD;
    }

    public void gK(int i) {
        if (this.bCE != i) {
            this.bCE = i;
            com.baidu.tbadk.core.sharedPref.b.agM().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int abd() {
        this.bCE = com.baidu.tbadk.core.sharedPref.b.agM().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.bCE;
    }

    public void lY(String str) {
        this.forumName = str;
    }

    public String abe() {
        return this.forumName;
    }

    public boolean abf() {
        return this.bCF;
    }

    public void dB(boolean z) {
        if (this.bCF != z) {
            this.bCF = z;
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
