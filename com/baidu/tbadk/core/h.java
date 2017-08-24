package com.baidu.tbadk.core;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class h {
    private static h TF;
    private int TG = 1;
    private int mIsAbstractOn = 1;
    private int TH = 0;
    private int TI = 0;
    private String forumName = null;
    private boolean TJ = true;
    private int mViewImageQuality = 0;

    public static h oY() {
        h hVar;
        if (TF == null) {
            synchronized (h.class) {
                if (TF == null) {
                    TF = new h();
                }
                hVar = TF;
            }
            return hVar;
        }
        return TF;
    }

    private h() {
    }

    public void initSetting() {
        this.TH = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        this.TG = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("view_image_quality", 0);
        this.TJ = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_images", true);
    }

    public void bw(int i) {
        this.TG = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("new_display_photo", i);
    }

    public int oZ() {
        return this.TG;
    }

    public boolean pa() {
        if (this.TG == 0) {
            if (i.hs()) {
                return true;
            }
        } else if (this.TG == 1) {
            return true;
        }
        return false;
    }

    public void bx(int i) {
        if (this.TH != i) {
            this.TH = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("image_quality", i);
        }
    }

    public int pb() {
        this.TH = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("image_quality", 0);
        return this.TH;
    }

    public void by(int i) {
        if (this.TI != i) {
            this.TI = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
        }
    }

    public int pc() {
        this.TI = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 0);
        return this.TI;
    }

    public void cx(String str) {
        this.forumName = str;
    }

    public String pd() {
        return this.forumName;
    }

    public boolean pe() {
        return this.TJ;
    }

    public void aj(boolean z) {
        if (this.TJ != z) {
            this.TJ = z;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_images", z);
        }
    }

    public void bz(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("view_image_quality", i);
            am.vR().vY();
            am.vR().vZ();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void ak(boolean z) {
        if (z) {
            bw(0);
            bx(0);
            aj(true);
            bz(0);
            return;
        }
        bw(1);
        bx(1);
        aj(true);
        bz(1);
    }

    public boolean pf() {
        return this.TG == 0 || this.TH == 0 || this.mViewImageQuality == 0;
    }
}
