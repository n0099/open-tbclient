package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class i {
    private static i acN;
    private int acO = 1;
    private int mIsAbstractOn = 1;
    private int acP = 0;
    private int acQ = 0;
    private String forumName = null;
    private boolean acR = true;
    private int mViewImageQuality = 0;

    public static i tt() {
        i iVar;
        if (acN == null) {
            synchronized (i.class) {
                if (acN == null) {
                    acN = new i();
                }
                iVar = acN;
            }
            return iVar;
        }
        return acN;
    }

    private i() {
    }

    public void initSetting() {
        this.acP = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.acO = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.acR = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bx(int i) {
        this.acO = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int tu() {
        return this.acO;
    }

    public boolean tv() {
        if (this.acO == 0) {
            if (j.jE()) {
                return true;
            }
        } else if (this.acO == 1) {
            return true;
        }
        return false;
    }

    public int tw() {
        this.acP = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.acP;
    }

    public void by(int i) {
        if (this.acQ != i) {
            this.acQ = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int tx() {
        this.acQ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.acQ;
    }

    public void dc(String str) {
        this.forumName = str;
    }

    public String ty() {
        return this.forumName;
    }

    public boolean tz() {
        return this.acR;
    }

    public void ao(boolean z) {
        if (this.acR != z) {
            this.acR = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bz(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            ar.zF().zN();
            ar.zF().zO();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
