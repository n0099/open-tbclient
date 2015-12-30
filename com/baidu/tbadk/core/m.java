package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class m {
    private static m Ul;
    private int Um = 1;
    private int mIsAbstractOn = 1;
    private int Un = 0;
    private int Uo = 0;
    private String forumName = null;
    private boolean Up = true;
    private int mViewImageQuality = 0;

    public static m qQ() {
        m mVar;
        if (Ul == null) {
            synchronized (m.class) {
                if (Ul == null) {
                    Ul = new m();
                }
                mVar = Ul;
            }
            return mVar;
        }
        return Ul;
    }

    private m() {
    }

    public void initSetting() {
        this.Un = com.baidu.tbadk.core.sharedPref.b.tJ().getInt("image_quality", 0);
        this.Um = com.baidu.tbadk.core.sharedPref.b.tJ().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.tJ().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.tJ().getInt("view_image_quality", 0);
        this.Up = com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("show_images", true);
    }

    public void bj(int i) {
        this.Um = i;
        com.baidu.tbadk.core.sharedPref.b.tJ().putInt("new_display_photo", i);
    }

    public int qR() {
        return this.Um;
    }

    public boolean qS() {
        if (this.Um == 0) {
            if (com.baidu.adp.lib.util.i.iR()) {
                return true;
            }
        } else if (this.Um == 1) {
            return true;
        }
        return false;
    }

    public void bk(int i) {
        if (this.Un != i) {
            this.Un = i;
            com.baidu.tbadk.core.sharedPref.b.tJ().putInt("image_quality", i);
        }
    }

    public int qT() {
        this.Un = com.baidu.tbadk.core.sharedPref.b.tJ().getInt("image_quality", 0);
        return this.Un;
    }

    public void bl(int i) {
        if (this.Uo != i) {
            this.Uo = i;
            com.baidu.tbadk.core.sharedPref.b.tJ().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int qU() {
        this.Uo = com.baidu.tbadk.core.sharedPref.b.tJ().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.Uo;
    }

    public void ci(String str) {
        this.forumName = str;
    }

    public String qV() {
        return this.forumName;
    }

    public boolean qW() {
        return this.Up;
    }

    public void ad(boolean z) {
        if (this.Up != z) {
            this.Up = z;
            com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("show_images", z);
        }
    }

    public void bm(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.tJ().putInt("view_image_quality", i);
            ay.va().vh();
            ay.va().vi();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void ae(boolean z) {
        if (z) {
            bj(0);
            bk(0);
            ad(true);
            bm(0);
            return;
        }
        bj(1);
        bk(1);
        ad(true);
        bm(1);
    }

    public boolean qX() {
        return this.Um == 0 || this.Un == 0 || this.mViewImageQuality == 0;
    }
}
