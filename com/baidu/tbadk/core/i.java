package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class i {
    private static i UK;
    private int UL = 1;
    private int mIsAbstractOn = 1;
    private int UM = 0;
    private int UN = 0;
    private String forumName = null;
    private boolean UO = true;
    private int mViewImageQuality = 0;

    public static i pX() {
        i iVar;
        if (UK == null) {
            synchronized (i.class) {
                if (UK == null) {
                    UK = new i();
                }
                iVar = UK;
            }
            return iVar;
        }
        return UK;
    }

    private i() {
    }

    public void initSetting() {
        this.UM = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.UL = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.UO = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bw(int i) {
        this.UL = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int pY() {
        return this.UL;
    }

    public boolean pZ() {
        if (this.UL == 0) {
            if (j.gQ()) {
                return true;
            }
        } else if (this.UL == 1) {
            return true;
        }
        return false;
    }

    public int qa() {
        this.UM = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.UM;
    }

    public void bx(int i) {
        if (this.UN != i) {
            this.UN = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int qb() {
        this.UN = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.UN;
    }

    public void cC(String str) {
        this.forumName = str;
    }

    public String qc() {
        return this.forumName;
    }

    public boolean qd() {
        return this.UO;
    }

    public void al(boolean z) {
        if (this.UO != z) {
            this.UO = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void by(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            ap.vP().vX();
            ap.vP().vY();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
