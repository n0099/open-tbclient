package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class i {
    private static i aeU;
    private int mIsAbstractOn = 1;
    private int aeV = 0;
    private int aeW = 0;
    private String forumName = null;
    private boolean aeX = true;
    private int mViewImageQuality = 0;

    public static i uj() {
        i iVar;
        if (aeU == null) {
            synchronized (i.class) {
                if (aeU == null) {
                    aeU = new i();
                }
                iVar = aeU;
            }
            return iVar;
        }
        return aeU;
    }

    private i() {
    }

    public void initSetting() {
        this.aeV = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.aeX = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public int uk() {
        this.aeV = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.aeV;
    }

    public void bJ(int i) {
        if (this.aeW != i) {
            this.aeW = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int ul() {
        this.aeW = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.aeW;
    }

    public void ds(String str) {
        this.forumName = str;
    }

    public String um() {
        return this.forumName;
    }

    public boolean un() {
        return this.aeX;
    }

    public void au(boolean z) {
        if (this.aeX != z) {
            this.aeX = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bK(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            aq.Az().AH();
            aq.Az().AI();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
