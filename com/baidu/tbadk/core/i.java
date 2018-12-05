package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class i {
    private static i aog;
    private int mIsAbstractOn = 1;
    private int aoh = 0;
    private int aoi = 0;
    private String forumName = null;
    private boolean aoj = true;
    private int mViewImageQuality = 0;

    public static i xE() {
        i iVar;
        if (aog == null) {
            synchronized (i.class) {
                if (aog == null) {
                    aog = new i();
                }
                iVar = aog;
            }
            return iVar;
        }
        return aog;
    }

    private i() {
    }

    public void initSetting() {
        this.aoh = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.aoj = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public int xF() {
        this.aoh = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.aoh;
    }

    public void cx(int i) {
        if (this.aoi != i) {
            this.aoi = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int xG() {
        this.aoi = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.aoi;
    }

    public void ea(String str) {
        this.forumName = str;
    }

    public String xH() {
        return this.forumName;
    }

    public boolean xI() {
        return this.aoj;
    }

    public void aW(boolean z) {
        if (this.aoj != z) {
            this.aoj = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void cy(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            aq.DR().DZ();
            aq.DR().Ea();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
