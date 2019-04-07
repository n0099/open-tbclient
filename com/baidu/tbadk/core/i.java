package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class i {
    private static i bvx;
    private int mIsAbstractOn = 1;
    private int bvy = 0;
    private int bvz = 0;
    private String forumName = null;
    private boolean bvA = true;
    private int mViewImageQuality = 0;

    public static i Wv() {
        i iVar;
        if (bvx == null) {
            synchronized (i.class) {
                if (bvx == null) {
                    bvx = new i();
                }
                iVar = bvx;
            }
            return iVar;
        }
        return bvx;
    }

    private i() {
    }

    public void initSetting() {
        this.bvy = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.bvA = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public int Ww() {
        this.bvy = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.bvy;
    }

    public void fY(int i) {
        if (this.bvz != i) {
            this.bvz = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int Wx() {
        this.bvz = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.bvz;
    }

    public void kU(String str) {
        this.forumName = str;
    }

    public String Wy() {
        return this.forumName;
    }

    public boolean Wz() {
        return this.bvA;
    }

    public void dg(boolean z) {
        if (this.bvA != z) {
            this.bvA = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void fZ(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            ar.adm().adu();
            ar.adm().adv();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
