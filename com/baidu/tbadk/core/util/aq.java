package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aq {
    private static aq atH = null;
    private boolean atI = false;
    private boolean atJ = false;
    private int atK = TbConfig.POST_IMAGE_SMALL;
    private String atL = String.valueOf(45);

    public static aq Az() {
        if (atH == null) {
            synchronized (aq.class) {
                atH = new aq();
            }
        }
        return atH;
    }

    public aq() {
        AC();
        AA();
    }

    private void AA() {
        AH();
        AI();
        AJ();
    }

    public void aT(boolean z) {
        this.atJ = z;
    }

    public boolean AB() {
        return this.atJ;
    }

    public void aU(boolean z) {
        this.atI = z;
        AA();
    }

    private void AC() {
        this.atI = com.baidu.adp.lib.util.j.kL();
    }

    public boolean AD() {
        return this.atI;
    }

    public String AE() {
        return this.atL;
    }

    public int AF() {
        AJ();
        return this.atK;
    }

    public int AG() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void AH() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.uj().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.uj().getViewImageQuality() != 1 : !this.atI) {
            z = false;
        }
        aT(z);
    }

    public void AI() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.uj().getViewImageQuality() == 0) {
            if (AD()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.uj().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.atL = valueOf;
    }

    public void AJ() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.uj().uk()) {
            case 0:
                if (!AD()) {
                    i = 1500;
                    break;
                }
                break;
            case 1:
                break;
            case 2:
                i = 1800;
                break;
            case 3:
                i = 1500;
                break;
            default:
                i = 1800;
                break;
        }
        this.atK = i;
    }

    public static boolean AK() {
        return l.hk() && com.baidu.adp.gif.c.hj();
    }
}
