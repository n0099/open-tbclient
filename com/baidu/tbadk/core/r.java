package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class r {
    private static r RX;
    private int RY = 1;
    private int mIsAbstractOn = 1;
    private int RZ = 0;
    private int Sa = 0;
    private String forumName = null;
    private boolean Sb = true;
    private int mViewImageQuality = 0;

    public static r oN() {
        r rVar;
        if (RX == null) {
            synchronized (r.class) {
                if (RX == null) {
                    RX = new r();
                }
                rVar = RX;
            }
            return rVar;
        }
        return RX;
    }

    private r() {
    }

    public void initSetting() {
        this.RZ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.RY = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.Sb = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bv(int i) {
        this.RY = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int oO() {
        return this.RY;
    }

    public boolean oP() {
        if (this.RY == 0) {
            if (com.baidu.adp.lib.util.i.hl()) {
                return true;
            }
        } else if (this.RY == 1) {
            return true;
        }
        return false;
    }

    public void bw(int i) {
        if (this.RZ != i) {
            this.RZ = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("image_quality", i);
        }
    }

    public int oQ() {
        this.RZ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.RZ;
    }

    public void bx(int i) {
        if (this.Sa != i) {
            this.Sa = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int oR() {
        this.Sa = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.Sa;
    }

    public void cd(String str) {
        this.forumName = str;
    }

    public String oS() {
        return this.forumName;
    }

    public boolean oT() {
        return this.Sb;
    }

    public void aj(boolean z) {
        if (this.Sb != z) {
            this.Sb = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void by(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            av.vl().vs();
            av.vl().vt();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void ak(boolean z) {
        if (z) {
            bv(0);
            bw(0);
            aj(true);
            by(0);
            return;
        }
        bv(1);
        bw(1);
        aj(true);
        by(1);
    }

    public boolean oU() {
        return this.RY == 0 || this.RZ == 0 || this.mViewImageQuality == 0;
    }
}
