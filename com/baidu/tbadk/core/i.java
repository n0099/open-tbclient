package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class i {
    private static i bvs;
    private int mIsAbstractOn = 1;
    private int bvt = 0;
    private int bvu = 0;
    private String forumName = null;
    private boolean bvv = true;
    private int mViewImageQuality = 0;

    public static i Wy() {
        i iVar;
        if (bvs == null) {
            synchronized (i.class) {
                if (bvs == null) {
                    bvs = new i();
                }
                iVar = bvs;
            }
            return iVar;
        }
        return bvs;
    }

    private i() {
    }

    public void initSetting() {
        this.bvt = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.bvv = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public int Wz() {
        this.bvt = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.bvt;
    }

    public void fZ(int i) {
        if (this.bvu != i) {
            this.bvu = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int WA() {
        this.bvu = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.bvu;
    }

    public void kT(String str) {
        this.forumName = str;
    }

    public String WB() {
        return this.forumName;
    }

    public boolean WC() {
        return this.bvv;
    }

    public void dg(boolean z) {
        if (this.bvv != z) {
            this.bvv = z;
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
