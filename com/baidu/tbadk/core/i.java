package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class i {
    private static i bvu;
    private int mIsAbstractOn = 1;
    private int bvv = 0;
    private int bvw = 0;
    private String forumName = null;
    private boolean bvx = true;
    private int mViewImageQuality = 0;

    public static i Wy() {
        i iVar;
        if (bvu == null) {
            synchronized (i.class) {
                if (bvu == null) {
                    bvu = new i();
                }
                iVar = bvu;
            }
            return iVar;
        }
        return bvu;
    }

    private i() {
    }

    public void initSetting() {
        this.bvv = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.bvx = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public int Wz() {
        this.bvv = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.bvv;
    }

    public void fZ(int i) {
        if (this.bvw != i) {
            this.bvw = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int WA() {
        this.bvw = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.bvw;
    }

    public void kT(String str) {
        this.forumName = str;
    }

    public String WB() {
        return this.forumName;
    }

    public boolean WC() {
        return this.bvx;
    }

    public void dg(boolean z) {
        if (this.bvx != z) {
            this.bvx = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void ga(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            ar.adp().adx();
            ar.adp().ady();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
