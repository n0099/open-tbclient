package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aq {
    private static aq ays = null;
    private boolean ayt = false;
    private boolean ayu = false;
    private int ayv = TbConfig.POST_IMAGE_SMALL;
    private String ayw = String.valueOf(45);

    public static aq CG() {
        if (ays == null) {
            synchronized (aq.class) {
                ays = new aq();
            }
        }
        return ays;
    }

    public aq() {
        CJ();
        CH();
    }

    private void CH() {
        CO();
        CP();
        CQ();
    }

    public void bd(boolean z) {
        this.ayu = z;
    }

    public boolean CI() {
        return this.ayu;
    }

    public void be(boolean z) {
        this.ayt = z;
        CH();
    }

    private void CJ() {
        this.ayt = com.baidu.adp.lib.util.j.kY();
    }

    public boolean CK() {
        return this.ayt;
    }

    public String CL() {
        return this.ayw;
    }

    public int CM() {
        CQ();
        return this.ayv;
    }

    public int CN() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void CO() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.ws().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.ws().getViewImageQuality() != 1 : !this.ayt) {
            z = false;
        }
        bd(z);
    }

    public void CP() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.ws().getViewImageQuality() == 0) {
            if (CK()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.ws().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.ayw = valueOf;
    }

    public void CQ() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.ws().wt()) {
            case 0:
                if (!CK()) {
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
        this.ayv = i;
    }

    public static boolean CR() {
        return l.hB() && com.baidu.adp.gif.c.hA();
    }
}
