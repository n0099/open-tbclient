package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.bb;
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

    public static l nW() {
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
        this.LY = com.baidu.tbadk.core.sharedPref.b.sO().getInt("image_quality", 0);
        this.LX = com.baidu.tbadk.core.sharedPref.b.sO().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.sO().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.sO().getInt("view_image_quality", 0);
        this.Ma = com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("show_images", true);
    }

    public void bk(int i) {
        this.LX = i;
        com.baidu.tbadk.core.sharedPref.b.sO().putInt("new_display_photo", i);
    }

    public int nX() {
        return this.LX;
    }

    public boolean nY() {
        if (this.LX == 0) {
            if (com.baidu.adp.lib.util.i.fs()) {
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
            com.baidu.tbadk.core.sharedPref.b.sO().putInt("image_quality", i);
        }
    }

    public int nZ() {
        this.LY = com.baidu.tbadk.core.sharedPref.b.sO().getInt("image_quality", 0);
        return this.LY;
    }

    public void bm(int i) {
        if (this.LZ != i) {
            this.LZ = i;
            com.baidu.tbadk.core.sharedPref.b.sO().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int oa() {
        this.LZ = com.baidu.tbadk.core.sharedPref.b.sO().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.LZ;
    }

    public void cb(String str) {
        this.forumName = str;
    }

    public String ob() {
        return this.forumName;
    }

    public boolean oc() {
        return this.Ma;
    }

    public void ae(boolean z) {
        if (this.Ma != z) {
            this.Ma = z;
            com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("show_images", z);
        }
    }

    public void bn(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.sO().putInt("view_image_quality", i);
            bb.uf().um();
            bb.uf().un();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void af(boolean z) {
        if (z) {
            bk(0);
            bl(0);
            ae(true);
            bn(0);
            return;
        }
        bk(1);
        bl(1);
        ae(true);
        bn(1);
    }

    public boolean od() {
        return this.LX == 0 || this.LY == 0 || this.mViewImageQuality == 0;
    }
}
