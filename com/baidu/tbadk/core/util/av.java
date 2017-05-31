package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class av {
    private static av afO = null;
    private boolean afP = false;
    private boolean afQ = false;
    private int afR = TbConfig.POST_IMAGE_SMALL;
    private String afS = String.valueOf(45);

    public static av vl() {
        if (afO == null) {
            synchronized (av.class) {
                afO = new av();
            }
        }
        return afO;
    }

    public av() {
        vo();
        vm();
    }

    private void vm() {
        vs();
        vt();
        vu();
    }

    public void aD(boolean z) {
        this.afQ = z;
    }

    public boolean vn() {
        return this.afQ;
    }

    public void aE(boolean z) {
        this.afP = z;
        vm();
    }

    private void vo() {
        this.afP = com.baidu.adp.lib.util.i.hl();
    }

    public boolean vp() {
        return this.afP;
    }

    public String vq() {
        return this.afS;
    }

    public int vr() {
        vu();
        return this.afR;
    }

    public void vs() {
        boolean z = true;
        if (com.baidu.tbadk.core.r.oN().getViewImageQuality() != 0 ? com.baidu.tbadk.core.r.oN().getViewImageQuality() != 1 : !this.afP) {
            z = false;
        }
        aD(z);
    }

    public void vt() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.r.oN().getViewImageQuality() == 0) {
            if (vp()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.r.oN().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.afS = valueOf;
    }

    public void vu() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.r.oN().oQ()) {
            case 0:
                if (!vp()) {
                    i = 600;
                    break;
                }
                break;
            case 1:
                break;
            case 2:
                i = 750;
                break;
            case 3:
                i = 600;
                break;
            default:
                i = 750;
                break;
        }
        this.afR = i;
    }

    public static boolean vv() {
        return l.dH() && com.baidu.adp.gif.e.dG();
    }
}
