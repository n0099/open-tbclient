package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class i {
    private static i aJt;
    private int aJu = 1;
    private int mIsAbstractOn = 1;
    private int aJv = 0;
    private int aJw = 0;
    private String forumName = null;
    private boolean aJx = true;
    private int mViewImageQuality = 0;

    public static i xo() {
        i iVar;
        if (aJt == null) {
            synchronized (i.class) {
                if (aJt == null) {
                    aJt = new i();
                }
                iVar = aJt;
            }
            return iVar;
        }
        return aJt;
    }

    private i() {
    }

    public void initSetting() {
        this.aJv = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.aJu = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.aJx = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void ey(int i) {
        this.aJu = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int xp() {
        return this.aJu;
    }

    public boolean xq() {
        if (this.aJu == 0) {
            if (j.oK()) {
                return true;
            }
        } else if (this.aJu == 1) {
            return true;
        }
        return false;
    }

    public int xr() {
        this.aJv = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.aJv;
    }

    public void ez(int i) {
        if (this.aJw != i) {
            this.aJw = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int xs() {
        this.aJw = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.aJw;
    }

    public void cK(String str) {
        this.forumName = str;
    }

    public String xt() {
        return this.forumName;
    }

    public boolean xu() {
        return this.aJx;
    }

    public void aT(boolean z) {
        if (this.aJx != z) {
            this.aJx = z;
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
