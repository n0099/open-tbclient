package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class i {
    private static i acK;
    private int acL = 1;
    private int mIsAbstractOn = 1;
    private int acM = 0;
    private int acN = 0;
    private String forumName = null;
    private boolean acO = true;
    private int mViewImageQuality = 0;

    public static i tt() {
        i iVar;
        if (acK == null) {
            synchronized (i.class) {
                if (acK == null) {
                    acK = new i();
                }
                iVar = acK;
            }
            return iVar;
        }
        return acK;
    }

    private i() {
    }

    public void initSetting() {
        this.acM = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.acL = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.acO = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void by(int i) {
        this.acL = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int tu() {
        return this.acL;
    }

    public boolean tv() {
        if (this.acL == 0) {
            if (j.jE()) {
                return true;
            }
        } else if (this.acL == 1) {
            return true;
        }
        return false;
    }

    public int tw() {
        this.acM = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.acM;
    }

    public void bz(int i) {
        if (this.acN != i) {
            this.acN = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int tx() {
        this.acN = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.acN;
    }

    public void da(String str) {
        this.forumName = str;
    }

    public String ty() {
        return this.forumName;
    }

    public boolean tz() {
        return this.acO;
    }

    public void ao(boolean z) {
        if (this.acO != z) {
            this.acO = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bA(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            aq.zq().zy();
            aq.zq().zz();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
