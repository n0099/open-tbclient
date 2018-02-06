package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class i {
    private static i aJD;
    private int aJE = 1;
    private int mIsAbstractOn = 1;
    private int aJF = 0;
    private int aJG = 0;
    private String forumName = null;
    private boolean aJH = true;
    private int mViewImageQuality = 0;

    public static i xo() {
        i iVar;
        if (aJD == null) {
            synchronized (i.class) {
                if (aJD == null) {
                    aJD = new i();
                }
                iVar = aJD;
            }
            return iVar;
        }
        return aJD;
    }

    private i() {
    }

    public void initSetting() {
        this.aJF = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.aJE = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.aJH = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void ey(int i) {
        this.aJE = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int xp() {
        return this.aJE;
    }

    public boolean xq() {
        if (this.aJE == 0) {
            if (j.oK()) {
                return true;
            }
        } else if (this.aJE == 1) {
            return true;
        }
        return false;
    }

    public int xr() {
        this.aJF = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.aJF;
    }

    public void ez(int i) {
        if (this.aJG != i) {
            this.aJG = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int xs() {
        this.aJG = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.aJG;
    }

    public void cK(String str) {
        this.forumName = str;
    }

    public String xt() {
        return this.forumName;
    }

    public boolean xu() {
        return this.aJH;
    }

    public void aT(boolean z) {
        if (this.aJH != z) {
            this.aJH = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void eA(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            ao.De().Dm();
            ao.De().Dn();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
