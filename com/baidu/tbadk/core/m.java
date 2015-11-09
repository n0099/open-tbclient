package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class m {
    private static m Tu;
    private int Tv = 1;
    private int mIsAbstractOn = 1;
    private int Tw = 0;
    private boolean Tx = true;
    private int mViewImageQuality = 0;

    public static m qV() {
        m mVar;
        if (Tu == null) {
            synchronized (m.class) {
                if (Tu == null) {
                    Tu = new m();
                }
                mVar = Tu;
            }
            return mVar;
        }
        return Tu;
    }

    private m() {
    }

    public void initSetting() {
        this.Tw = com.baidu.tbadk.core.sharedPref.b.tu().getInt("image_quality", 0);
        this.Tv = com.baidu.tbadk.core.sharedPref.b.tu().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.tu().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.tu().getInt("view_image_quality", 0);
        this.Tx = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("show_images", true);
    }

    public void bo(int i) {
        this.Tv = i;
        com.baidu.tbadk.core.sharedPref.b.tu().putInt("new_display_photo", i);
    }

    public int qW() {
        return this.Tv;
    }

    public boolean qX() {
        if (this.Tv == 0) {
            if (com.baidu.adp.lib.util.i.iO()) {
                return true;
            }
        } else if (this.Tv == 1) {
            return true;
        }
        return false;
    }

    public void bp(int i) {
        if (this.Tw != i) {
            this.Tw = i;
            com.baidu.tbadk.core.sharedPref.b.tu().putInt("image_quality", i);
        }
    }

    public int qY() {
        this.Tw = com.baidu.tbadk.core.sharedPref.b.tu().getInt("image_quality", 0);
        return this.Tw;
    }

    public boolean qZ() {
        return this.Tx;
    }

    public void ae(boolean z) {
        if (this.Tx != z) {
            this.Tx = z;
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("show_images", z);
        }
    }

    public void bq(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.tu().putInt("view_image_quality", i);
            at.uK().uR();
            at.uK().uS();
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

    public boolean ra() {
        return this.Tv == 0 || this.Tw == 0 || this.mViewImageQuality == 0;
    }
}
