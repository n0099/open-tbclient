package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class m {
    private static m Ts;
    private int Tt = 1;
    private int mIsAbstractOn = 1;
    private int Tu = 0;
    private boolean Tv = true;
    private int mViewImageQuality = 0;

    public static m qX() {
        m mVar;
        if (Ts == null) {
            synchronized (m.class) {
                if (Ts == null) {
                    Ts = new m();
                }
                mVar = Ts;
            }
            return mVar;
        }
        return Ts;
    }

    private m() {
    }

    public void initSetting() {
        this.Tu = com.baidu.tbadk.core.sharedPref.b.tu().getInt("image_quality", 0);
        this.Tt = com.baidu.tbadk.core.sharedPref.b.tu().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.tu().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.tu().getInt("view_image_quality", 0);
        this.Tv = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("show_images", true);
    }

    public void bo(int i) {
        this.Tt = i;
        com.baidu.tbadk.core.sharedPref.b.tu().putInt("new_display_photo", i);
    }

    public int qY() {
        return this.Tt;
    }

    public boolean qZ() {
        if (this.Tt == 0) {
            if (com.baidu.adp.lib.util.i.iN()) {
                return true;
            }
        } else if (this.Tt == 1) {
            return true;
        }
        return false;
    }

    public void bp(int i) {
        if (this.Tu != i) {
            this.Tu = i;
            com.baidu.tbadk.core.sharedPref.b.tu().putInt("image_quality", i);
        }
    }

    public int ra() {
        this.Tu = com.baidu.tbadk.core.sharedPref.b.tu().getInt("image_quality", 0);
        return this.Tu;
    }

    public boolean rb() {
        return this.Tv;
    }

    public void ae(boolean z) {
        if (this.Tv != z) {
            this.Tv = z;
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("show_images", z);
        }
    }

    public void bq(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.tu().putInt("view_image_quality", i);
            as.uI().uP();
            as.uI().uQ();
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

    public boolean rc() {
        return this.Tt == 0 || this.Tu == 0 || this.mViewImageQuality == 0;
    }
}
