package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class i {
    private static i aIg;
    private int aIh = 1;
    private int mIsAbstractOn = 1;
    private int aIi = 0;
    private int aIj = 0;
    private String forumName = null;
    private boolean aIk = true;
    private int mViewImageQuality = 0;

    public static i wA() {
        i iVar;
        if (aIg == null) {
            synchronized (i.class) {
                if (aIg == null) {
                    aIg = new i();
                }
                iVar = aIg;
            }
            return iVar;
        }
        return aIg;
    }

    private i() {
    }

    public void initSetting() {
        this.aIi = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.aIh = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.aIk = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void ey(int i) {
        this.aIh = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int wB() {
        return this.aIh;
    }

    public boolean wC() {
        if (this.aIh == 0) {
            if (j.oJ()) {
                return true;
            }
        } else if (this.aIh == 1) {
            return true;
        }
        return false;
    }

    public int wD() {
        this.aIi = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.aIi;
    }

    public void ez(int i) {
        if (this.aIj != i) {
            this.aIj = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int wE() {
        this.aIj = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.aIj;
    }

    public void cz(String str) {
        this.forumName = str;
    }

    public String wF() {
        return this.forumName;
    }

    public boolean wG() {
        return this.aIk;
    }

    public void aP(boolean z) {
        if (this.aIk != z) {
            this.aIk = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void eA(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            an.CJ().CR();
            an.CJ().CS();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
