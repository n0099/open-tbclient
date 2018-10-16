package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class i {
    private static i ajR;
    private int mIsAbstractOn = 1;
    private int ajS = 0;
    private int ajT = 0;
    private String forumName = null;
    private boolean ajU = true;
    private int mViewImageQuality = 0;

    public static i ws() {
        i iVar;
        if (ajR == null) {
            synchronized (i.class) {
                if (ajR == null) {
                    ajR = new i();
                }
                iVar = ajR;
            }
            return iVar;
        }
        return ajR;
    }

    private i() {
    }

    public void initSetting() {
        this.ajS = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.ajU = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public int wt() {
        this.ajS = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.ajS;
    }

    public void bU(int i) {
        if (this.ajT != i) {
            this.ajT = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int wu() {
        this.ajT = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.ajT;
    }

    public void dI(String str) {
        this.forumName = str;
    }

    public String wv() {
        return this.forumName;
    }

    public boolean ww() {
        return this.ajU;
    }

    public void aF(boolean z) {
        if (this.ajU != z) {
            this.ajU = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bV(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            aq.CG().CO();
            aq.CG().CP();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
