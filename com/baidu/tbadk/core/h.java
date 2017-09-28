package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class h {
    private static h SW;
    private int SX = 1;
    private int mIsAbstractOn = 1;
    private int SY = 0;
    private int SZ = 0;
    private String forumName = null;
    private boolean Ta = true;
    private int mViewImageQuality = 0;

    public static h oT() {
        h hVar;
        if (SW == null) {
            synchronized (h.class) {
                if (SW == null) {
                    SW = new h();
                }
                hVar = SW;
            }
            return hVar;
        }
        return SW;
    }

    private h() {
    }

    public void initSetting() {
        this.SY = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.SX = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.Ta = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bA(int i) {
        this.SX = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int oU() {
        return this.SX;
    }

    public boolean oV() {
        if (this.SX == 0) {
            if (j.hi()) {
                return true;
            }
        } else if (this.SX == 1) {
            return true;
        }
        return false;
    }

    public void bB(int i) {
        if (this.SY != i) {
            this.SY = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("image_quality", i);
        }
    }

    public int oW() {
        this.SY = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.SY;
    }

    public void bC(int i) {
        if (this.SZ != i) {
            this.SZ = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int oX() {
        this.SZ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.SZ;
    }

    public void cn(String str) {
        this.forumName = str;
    }

    public String oY() {
        return this.forumName;
    }

    public boolean oZ() {
        return this.Ta;
    }

    public void ak(boolean z) {
        if (this.Ta != z) {
            this.Ta = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bD(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            an.vs().vz();
            an.vs().vA();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void al(boolean z) {
        if (z) {
            bA(0);
            bB(0);
            ak(true);
            bD(0);
            return;
        }
        bA(1);
        bB(1);
        ak(true);
        bD(1);
    }

    public boolean pa() {
        return this.SX == 0 || this.SY == 0 || this.mViewImageQuality == 0;
    }
}
