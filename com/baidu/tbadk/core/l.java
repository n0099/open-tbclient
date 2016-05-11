package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.az;
/* loaded from: classes.dex */
public class l {
    private static l LW;
    private int LX = 1;
    private int mIsAbstractOn = 1;
    private int LY = 0;
    private int LZ = 0;
    private String forumName = null;
    private boolean Ma = true;
    private int mViewImageQuality = 0;

    public static l ob() {
        l lVar;
        if (LW == null) {
            synchronized (l.class) {
                if (LW == null) {
                    LW = new l();
                }
                lVar = LW;
            }
            return lVar;
        }
        return LW;
    }

    private l() {
    }

    public void initSetting() {
        this.LY = com.baidu.tbadk.core.sharedPref.b.sQ().getInt("image_quality", 0);
        this.LX = com.baidu.tbadk.core.sharedPref.b.sQ().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.sQ().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.sQ().getInt("view_image_quality", 0);
        this.Ma = com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("show_images", true);
    }

    public void bk(int i) {
        this.LX = i;
        com.baidu.tbadk.core.sharedPref.b.sQ().putInt("new_display_photo", i);
    }

    public int oc() {
        return this.LX;
    }

    public boolean od() {
        if (this.LX == 0) {
            if (com.baidu.adp.lib.util.i.fr()) {
                return true;
            }
        } else if (this.LX == 1) {
            return true;
        }
        return false;
    }

    public void bl(int i) {
        if (this.LY != i) {
            this.LY = i;
            com.baidu.tbadk.core.sharedPref.b.sQ().putInt("image_quality", i);
        }
    }

    public int oe() {
        this.LY = com.baidu.tbadk.core.sharedPref.b.sQ().getInt("image_quality", 0);
        return this.LY;
    }

    public void bm(int i) {
        if (this.LZ != i) {
            this.LZ = i;
            com.baidu.tbadk.core.sharedPref.b.sQ().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int of() {
        this.LZ = com.baidu.tbadk.core.sharedPref.b.sQ().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.LZ;
    }

    public void cc(String str) {
        this.forumName = str;
    }

    public String og() {
        return this.forumName;
    }

    public boolean oh() {
        return this.Ma;
    }

    public void ag(boolean z) {
        if (this.Ma != z) {
            this.Ma = z;
            com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("show_images", z);
        }
    }

    public void bn(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.sQ().putInt("view_image_quality", i);
            az.uf().um();
            az.uf().un();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void ah(boolean z) {
        if (z) {
            bk(0);
            bl(0);
            ag(true);
            bn(0);
            return;
        }
        bk(1);
        bl(1);
        ag(true);
        bn(1);
    }

    public boolean oi() {
        return this.LX == 0 || this.LY == 0 || this.mViewImageQuality == 0;
    }
}
