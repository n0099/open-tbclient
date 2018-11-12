package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class i {
    private static i akE;
    private int mIsAbstractOn = 1;
    private int akF = 0;
    private int akG = 0;
    private String forumName = null;
    private boolean akH = true;
    private int mViewImageQuality = 0;

    public static i wA() {
        i iVar;
        if (akE == null) {
            synchronized (i.class) {
                if (akE == null) {
                    akE = new i();
                }
                iVar = akE;
            }
            return iVar;
        }
        return akE;
    }

    private i() {
    }

    public void initSetting() {
        this.akF = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.akH = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public int wB() {
        this.akF = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.akF;
    }

    public void cj(int i) {
        if (this.akG != i) {
            this.akG = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int wC() {
        this.akG = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.akG;
    }

    public void dI(String str) {
        this.forumName = str;
    }

    public String wD() {
        return this.forumName;
    }

    public boolean wE() {
        return this.akH;
    }

    public void aV(boolean z) {
        if (this.akH != z) {
            this.akH = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void ck(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            aq.CN().CV();
            aq.CN().CW();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
