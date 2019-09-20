package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class i {
    private static i bDX;
    private int mIsAbstractOn = 1;
    private int bDY = 0;
    private int bDZ = 0;
    private String forumName = null;
    private boolean bEa = true;
    private int mViewImageQuality = 0;

    public static i ace() {
        i iVar;
        if (bDX == null) {
            synchronized (i.class) {
                if (bDX == null) {
                    bDX = new i();
                }
                iVar = bDX;
            }
            return iVar;
        }
        return bDX;
    }

    private i() {
    }

    public void initSetting() {
        this.bDY = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("image_quality", 0);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("view_image_quality", 0);
        this.bEa = com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("show_images", true);
    }

    public int acf() {
        this.bDY = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("image_quality", 0);
        return this.bDY;
    }

    public void gP(int i) {
        if (this.bDZ != i) {
            this.bDZ = i;
            com.baidu.tbadk.core.sharedPref.b.ahU().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int acg() {
        this.bDZ = com.baidu.tbadk.core.sharedPref.b.ahU().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.bDZ;
    }

    public void mk(String str) {
        this.forumName = str;
    }

    public String ach() {
        return this.forumName;
    }

    public boolean aci() {
        return this.bEa;
    }

    public void dF(boolean z) {
        if (this.bEa != z) {
            this.bEa = z;
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("show_images", z);
        }
    }

    public void gQ(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.ahU().putInt("view_image_quality", i);
            ar.ajw().ajE();
            ar.ajw().ajF();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
