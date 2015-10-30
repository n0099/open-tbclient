package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class m {
    private static m Tt;
    private int Tu = 1;
    private int mIsAbstractOn = 1;
    private int Tv = 0;
    private boolean Tw = true;
    private int mViewImageQuality = 0;

    public static m qU() {
        m mVar;
        if (Tt == null) {
            synchronized (m.class) {
                if (Tt == null) {
                    Tt = new m();
                }
                mVar = Tt;
            }
            return mVar;
        }
        return Tt;
    }

    private m() {
    }

    public void initSetting() {
        this.Tv = com.baidu.tbadk.core.sharedPref.b.tr().getInt("image_quality", 0);
        this.Tu = com.baidu.tbadk.core.sharedPref.b.tr().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.tr().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.tr().getInt("view_image_quality", 0);
        this.Tw = com.baidu.tbadk.core.sharedPref.b.tr().getBoolean("show_images", true);
    }

    public void bo(int i) {
        this.Tu = i;
        com.baidu.tbadk.core.sharedPref.b.tr().putInt("new_display_photo", i);
    }

    public int qV() {
        return this.Tu;
    }

    public boolean qW() {
        if (this.Tu == 0) {
            if (com.baidu.adp.lib.util.i.iN()) {
                return true;
            }
        } else if (this.Tu == 1) {
            return true;
        }
        return false;
    }

    public void bp(int i) {
        if (this.Tv != i) {
            this.Tv = i;
            com.baidu.tbadk.core.sharedPref.b.tr().putInt("image_quality", i);
        }
    }

    public int qX() {
        this.Tv = com.baidu.tbadk.core.sharedPref.b.tr().getInt("image_quality", 0);
        return this.Tv;
    }

    public boolean qY() {
        return this.Tw;
    }

    public void ae(boolean z) {
        if (this.Tw != z) {
            this.Tw = z;
            com.baidu.tbadk.core.sharedPref.b.tr().putBoolean("show_images", z);
        }
    }

    public void bq(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.tr().putInt("view_image_quality", i);
            at.uG().uN();
            at.uG().uO();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void af(boolean z) {
        if (z) {
            bo(0);
            bp(0);
            ae(true);
            bq(0);
            return;
        }
        bo(1);
        bp(1);
        ae(true);
        bq(1);
    }

    public boolean qZ() {
        return this.Tu == 0 || this.Tv == 0 || this.mViewImageQuality == 0;
    }
}
