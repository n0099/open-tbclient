package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
public class l {
    private static l TJ;
    private int TK = 1;
    private int mIsAbstractOn = 1;
    private int TL = 0;
    private int TM = 0;
    private String forumName = null;
    private boolean TO = true;
    private int mViewImageQuality = 0;

    public static l rn() {
        l lVar;
        if (TJ == null) {
            synchronized (l.class) {
                if (TJ == null) {
                    TJ = new l();
                }
                lVar = TJ;
            }
            return lVar;
        }
        return TJ;
    }

    private l() {
    }

    public void initSetting() {
        this.TL = com.baidu.tbadk.core.sharedPref.b.uO().getInt("image_quality", 0);
        this.TK = com.baidu.tbadk.core.sharedPref.b.uO().getInt("new_display_photo", 1);
        this.mIsAbstractOn = com.baidu.tbadk.core.sharedPref.b.uO().getInt("new_abstract_state", 0);
        this.mViewImageQuality = com.baidu.tbadk.core.sharedPref.b.uO().getInt("view_image_quality", 0);
        this.TO = com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("show_images", true);
    }

    public void bw(int i) {
        this.TK = i;
        com.baidu.tbadk.core.sharedPref.b.uO().putInt("new_display_photo", i);
    }

    public int ro() {
        return this.TK;
    }

    public boolean rp() {
        if (this.TK == 0) {
            if (com.baidu.adp.lib.util.i.ja()) {
                return true;
            }
        } else if (this.TK == 1) {
            return true;
        }
        return false;
    }

    public void bz(int i) {
        if (this.TL != i) {
            this.TL = i;
            com.baidu.tbadk.core.sharedPref.b.uO().putInt("image_quality", i);
        }
    }

    public int rq() {
        this.TL = com.baidu.tbadk.core.sharedPref.b.uO().getInt("image_quality", 0);
        return this.TL;
    }

    public void bA(int i) {
        if (this.TM != i) {
            this.TM = i;
            com.baidu.tbadk.core.sharedPref.b.uO().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", i);
        }
    }

    public int rr() {
        this.TM = com.baidu.tbadk.core.sharedPref.b.uO().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "add_image_water", 0);
        return this.TM;
    }

    public void ch(String str) {
        this.forumName = str;
    }

    public String rs() {
        return this.forumName;
    }

    public boolean rt() {
        return this.TO;
    }

    public void ae(boolean z) {
        if (this.TO != z) {
            this.TO = z;
            com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("show_images", z);
        }
    }

    public void bB(int i) {
        if (this.mViewImageQuality != i) {
            this.mViewImageQuality = i;
            com.baidu.tbadk.core.sharedPref.b.uO().putInt("view_image_quality", i);
            ax.wg().wn();
            ax.wg().wo();
        }
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void af(boolean z) {
        if (z) {
            bw(0);
            bz(0);
            ae(true);
            bB(0);
            return;
        }
        bw(1);
        bz(1);
        ae(true);
        bB(1);
    }

    public boolean ru() {
        return this.TK == 0 || this.TL == 0 || this.mViewImageQuality == 0;
    }
}
