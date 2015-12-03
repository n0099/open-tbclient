package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class m {
    private static m TJ;
    private int TK = 1;
    private int mIsAbstractOn = 1;
    private int TL = 0;
    private int TM = 0;
    private String forumName = null;
    private boolean TO = true;
    private int mViewImageQuality = 0;

    public static m rh() {
        m mVar;
        if (TJ == null) {
            synchronized (m.class) {
                if (TJ == null) {
                    TJ = new m();
                }
                mVar = TJ;
            }
            return mVar;
        }
        return TJ;
    }

    private m() {
    }

    public void initSetting() {
        this.TL = com.baidu.tbadk.core.sharedPref.b.tZ().getInt("image_quality", 0);
        this.TK = com.baidu.tbadk.core.sharedPref.b.tZ().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.tZ().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.tZ().getInt("view_image_quality", 0);
        this.TO = com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("show_images", true);
    }

    public void bq(int i) {
        this.TK = i;
        com.baidu.tbadk.core.sharedPref.b.tZ().putInt("new_display_photo", i);
    }

    public int ri() {
        return this.TK;
    }

    public boolean rj() {
        if (this.TK == 0) {
            if (com.baidu.adp.lib.util.i.iQ()) {
                return true;
            }
        } else if (this.TK == 1) {
            return true;
        }
        return false;
    }

    public void br(int i) {
        if (this.TL != i) {
            this.TL = i;
            com.baidu.tbadk.core.sharedPref.b.tZ().putInt("image_quality", i);
        }
    }

    public int rk() {
        this.TL = com.baidu.tbadk.core.sharedPref.b.tZ().getInt("image_quality", 0);
        return this.TL;
    }

    public void bs(int i) {
        if (this.TM != i) {
            this.TM = i;
            com.baidu.tbadk.core.sharedPref.b.tZ().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int rl() {
        this.TM = com.baidu.tbadk.core.sharedPref.b.tZ().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.TM;
    }

    public void cg(String str) {
        this.forumName = str;
    }

    public String rm() {
        return this.forumName;
    }

    public boolean rn() {
        return this.TO;
    }

    public void ag(boolean z) {
        if (this.TO != z) {
            this.TO = z;
            com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("show_images", z);
        }
    }

    public void bt(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.tZ().putInt("view_image_quality", i);
            ay.vq().vx();
            ay.vq().vy();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void ah(boolean z) {
        if (z) {
            bq(0);
            br(0);
            ag(true);
            bt(0);
            return;
        }
        bq(1);
        br(1);
        ag(true);
        bt(1);
    }

    public boolean ro() {
        return this.TK == 0 || this.TL == 0 || this.mViewImageQuality == 0;
    }
}
