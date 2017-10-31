package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class h {
    private static h Td;
    private int Te = 1;
    private int mIsAbstractOn = 1;
    private int Tf = 0;
    private int Tg = 0;
    private String forumName = null;
    private boolean Th = true;
    private int mViewImageQuality = 0;

    public static h oT() {
        h hVar;
        if (Td == null) {
            synchronized (h.class) {
                if (Td == null) {
                    Td = new h();
                }
                hVar = Td;
            }
            return hVar;
        }
        return Td;
    }

    private h() {
    }

    public void initSetting() {
        this.Tf = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.Te = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.Th = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void by(int i) {
        this.Te = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int oU() {
        return this.Te;
    }

    public boolean oV() {
        if (this.Te == 0) {
            if (j.hi()) {
                return true;
            }
        } else if (this.Te == 1) {
            return true;
        }
        return false;
    }

    public int oW() {
        this.Tf = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.Tf;
    }

    public void bz(int i) {
        if (this.Tg != i) {
            this.Tg = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int oX() {
        this.Tg = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.Tg;
    }

    public void cs(String str) {
        this.forumName = str;
    }

    public String oY() {
        return this.forumName;
    }

    public boolean oZ() {
        return this.Th;
    }

    public void ai(boolean z) {
        if (this.Th != z) {
            this.Th = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bA(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            an.vs().vA();
            an.vs().vB();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }
}
