package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class i {
    private static i bDz;
    private int mIsAbstractOn = 1;
    private int bDA = 0;
    private int bDB = 0;
    private String forumName = null;
    private boolean bDC = true;
    private int mViewImageQuality = 0;

    public static i aca() {
        i iVar;
        if (bDz == null) {
            synchronized (i.class) {
                if (bDz == null) {
                    bDz = new i();
                }
                iVar = bDz;
            }
            return iVar;
        }
        return bDz;
    }

    private i() {
    }

    public void initSetting() {
        this.bDA = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("image_quality", 0);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("view_image_quality", 0);
        this.bDC = com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("show_images", true);
    }

    public int acb() {
        this.bDA = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("image_quality", 0);
        return this.bDA;
    }

    public void gO(int i) {
        if (this.bDB != i) {
            this.bDB = i;
            com.baidu.tbadk.core.sharedPref.b.ahO().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int acc() {
        this.bDB = com.baidu.tbadk.core.sharedPref.b.ahO().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.bDB;
    }

    public void mi(String str) {
        this.forumName = str;
    }

    public String acd() {
        return this.forumName;
    }

    public boolean ace() {
        return this.bDC;
    }

    public void dF(boolean z) {
        if (this.bDC != z) {
            this.bDC = z;
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("show_images", z);
        }
    }

    public void gP(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.ahO().putInt("view_image_quality", i);
            as.ajo().ajw();
            as.ajo().ajx();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
