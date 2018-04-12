package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class i {
    private static i UO;
    private int UQ = 1;
    private int mIsAbstractOn = 1;
    private int UR = 0;
    private int US = 0;
    private String forumName = null;
    private boolean UT = true;
    private int mViewImageQuality = 0;

    public static i pY() {
        i iVar;
        if (UO == null) {
            synchronized (i.class) {
                if (UO == null) {
                    UO = new i();
                }
                iVar = UO;
            }
            return iVar;
        }
        return UO;
    }

    private i() {
    }

    public void initSetting() {
        this.UR = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.UQ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.UT = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bx(int i) {
        this.UQ = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int pZ() {
        return this.UQ;
    }

    public boolean qa() {
        if (this.UQ == 0) {
            if (j.gQ()) {
                return true;
            }
        } else if (this.UQ == 1) {
            return true;
        }
        return false;
    }

    public int qb() {
        this.UR = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.UR;
    }

    public void by(int i) {
        if (this.US != i) {
            this.US = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int qc() {
        this.US = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.US;
    }

    public void cC(String str) {
        this.forumName = str;
    }

    public String qd() {
        return this.forumName;
    }

    public boolean qe() {
        return this.UT;
    }

    public void al(boolean z) {
        if (this.UT != z) {
            this.UT = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bz(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            ap.vQ().vY();
            ap.vQ().vZ();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
