package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class i {
    private static i aJs;
    private int aJt = 1;
    private int mIsAbstractOn = 1;
    private int aJu = 0;
    private int aJv = 0;
    private String forumName = null;
    private boolean aJw = true;
    private int mViewImageQuality = 0;

    public static i xo() {
        i iVar;
        if (aJs == null) {
            synchronized (i.class) {
                if (aJs == null) {
                    aJs = new i();
                }
                iVar = aJs;
            }
            return iVar;
        }
        return aJs;
    }

    private i() {
    }

    public void initSetting() {
        this.aJu = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.aJt = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.aJw = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void ey(int i) {
        this.aJt = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int xp() {
        return this.aJt;
    }

    public boolean xq() {
        if (this.aJt == 0) {
            if (j.oK()) {
                return true;
            }
        } else if (this.aJt == 1) {
            return true;
        }
        return false;
    }

    public int xr() {
        this.aJu = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.aJu;
    }

    public void ez(int i) {
        if (this.aJv != i) {
            this.aJv = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int xs() {
        this.aJv = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.aJv;
    }

    public void cK(String str) {
        this.forumName = str;
    }

    public String xt() {
        return this.forumName;
    }

    public boolean xu() {
        return this.aJw;
    }

    public void aT(boolean z) {
        if (this.aJw != z) {
            this.aJw = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void eA(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            ao.Dd().Dl();
            ao.Dd().Dm();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
