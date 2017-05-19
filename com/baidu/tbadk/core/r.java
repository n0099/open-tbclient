package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class r {
    private static r Sk;
    private int Sl = 1;
    private int mIsAbstractOn = 1;
    private int Sm = 0;
    private int Sn = 0;
    private String forumName = null;
    private boolean So = true;
    private int mViewImageQuality = 0;

    public static r oV() {
        r rVar;
        if (Sk == null) {
            synchronized (r.class) {
                if (Sk == null) {
                    Sk = new r();
                }
                rVar = Sk;
            }
            return rVar;
        }
        return Sk;
    }

    private r() {
    }

    public void initSetting() {
        this.Sm = com.baidu.tbadk.core.sharedPref.b.tX().getInt("image_quality", 0);
        this.Sl = com.baidu.tbadk.core.sharedPref.b.tX().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.tX().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.tX().getInt("view_image_quality", 0);
        this.So = com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("show_images", true);
    }

    public void bu(int i) {
        this.Sl = i;
        com.baidu.tbadk.core.sharedPref.b.tX().putInt("new_display_photo", i);
    }

    public int oW() {
        return this.Sl;
    }

    public boolean oX() {
        if (this.Sl == 0) {
            if (com.baidu.adp.lib.util.i.hl()) {
                return true;
            }
        } else if (this.Sl == 1) {
            return true;
        }
        return false;
    }

    public void bv(int i) {
        if (this.Sm != i) {
            this.Sm = i;
            com.baidu.tbadk.core.sharedPref.b.tX().putInt("image_quality", i);
        }
    }

    public int oY() {
        this.Sm = com.baidu.tbadk.core.sharedPref.b.tX().getInt("image_quality", 0);
        return this.Sm;
    }

    public void bw(int i) {
        if (this.Sn != i) {
            this.Sn = i;
            com.baidu.tbadk.core.sharedPref.b.tX().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int oZ() {
        this.Sn = com.baidu.tbadk.core.sharedPref.b.tX().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.Sn;
    }

    public void cd(String str) {
        this.forumName = str;
    }

    public String pa() {
        return this.forumName;
    }

    public boolean pb() {
        return this.So;
    }

    public void ak(boolean z) {
        if (this.So != z) {
            this.So = z;
            com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("show_images", z);
        }
    }

    public void bx(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.tX().putInt("view_image_quality", i);
            av.vo().vv();
            av.vo().vw();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void al(boolean z) {
        if (z) {
            bu(0);
            bv(0);
            ak(true);
            bx(0);
            return;
        }
        bu(1);
        bv(1);
        ak(true);
        bx(1);
    }

    public boolean pc() {
        return this.Sl == 0 || this.Sm == 0 || this.mViewImageQuality == 0;
    }
}
