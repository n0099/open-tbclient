package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class i {
    private static i aoI;
    private int mIsAbstractOn = 1;
    private int aoJ = 0;
    private int aoK = 0;
    private String forumName = null;
    private boolean aoL = true;
    private int mViewImageQuality = 0;

    public static i xR() {
        i iVar;
        if (aoI == null) {
            synchronized (i.class) {
                if (aoI == null) {
                    aoI = new i();
                }
                iVar = aoI;
            }
            return iVar;
        }
        return aoI;
    }

    private i() {
    }

    public void initSetting() {
        this.aoJ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.aoL = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public int xS() {
        this.aoJ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.aoJ;
    }

    public void cx(int i) {
        if (this.aoK != i) {
            this.aoK = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int xT() {
        this.aoK = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.aoK;
    }

    public void ej(String str) {
        this.forumName = str;
    }

    public String xU() {
        return this.forumName;
    }

    public boolean xV() {
        return this.aoL;
    }

    public void aX(boolean z) {
        if (this.aoL != z) {
            this.aoL = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void cy(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            aq.Ee().Em();
            aq.Ee().En();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
