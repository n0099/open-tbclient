package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class i {
    private static i aIj;
    private int aIk = 1;
    private int mIsAbstractOn = 1;
    private int aIl = 0;
    private int aIm = 0;
    private String forumName = null;
    private boolean aIn = true;
    private int mViewImageQuality = 0;

    public static i wB() {
        i iVar;
        if (aIj == null) {
            synchronized (i.class) {
                if (aIj == null) {
                    aIj = new i();
                }
                iVar = aIj;
            }
            return iVar;
        }
        return aIj;
    }

    private i() {
    }

    public void initSetting() {
        this.aIl = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.aIk = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.aIn = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void ey(int i) {
        this.aIk = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int wC() {
        return this.aIk;
    }

    public boolean wD() {
        if (this.aIk == 0) {
            if (j.oK()) {
                return true;
            }
        } else if (this.aIk == 1) {
            return true;
        }
        return false;
    }

    public int wE() {
        this.aIl = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.aIl;
    }

    public void ez(int i) {
        if (this.aIm != i) {
            this.aIm = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int wF() {
        this.aIm = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.aIm;
    }

    public void cz(String str) {
        this.forumName = str;
    }

    public String wG() {
        return this.forumName;
    }

    public boolean wH() {
        return this.aIn;
    }

    public void aQ(boolean z) {
        if (this.aIn != z) {
            this.aIn = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void eA(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            an.CK().CS();
            an.CK().CT();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
