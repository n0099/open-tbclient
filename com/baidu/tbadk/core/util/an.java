package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class an {
    private static an agS = null;
    private boolean agT = false;
    private boolean agU = false;
    private int agV = TbConfig.POST_IMAGE_SMALL;
    private String agW = String.valueOf(45);

    public static an vl() {
        if (agS == null) {
            synchronized (an.class) {
                agS = new an();
            }
        }
        return agS;
    }

    public an() {
        vo();
        vm();
    }

    private void vm() {
        vs();
        vt();
        vu();
    }

    public void aC(boolean z) {
        this.agU = z;
    }

    public boolean vn() {
        return this.agU;
    }

    public void aD(boolean z) {
        this.agT = z;
        vm();
    }

    private void vo() {
        this.agT = com.baidu.adp.lib.util.j.hi();
    }

    public boolean vp() {
        return this.agT;
    }

    public String vq() {
        return this.agW;
    }

    public int vr() {
        vu();
        return this.agV;
    }

    public void vs() {
        boolean z = true;
        if (com.baidu.tbadk.core.h.oM().getViewImageQuality() != 0 ? com.baidu.tbadk.core.h.oM().getViewImageQuality() != 1 : !this.agT) {
            z = false;
        }
        aC(z);
    }

    public void vt() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.h.oM().getViewImageQuality() == 0) {
            if (vp()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.h.oM().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.agW = valueOf;
    }

    public void vu() {
        int i = 2000;
        switch (com.baidu.tbadk.core.h.oM().oP()) {
            case 0:
                if (!vp()) {
                    i = 600;
                    break;
                }
                break;
            case 1:
                break;
            case 2:
                i = 1800;
                break;
            case 3:
                i = 600;
                break;
            default:
                i = 1800;
                break;
        }
        this.agV = i;
    }

    public static boolean vv() {
        return k.dG() && com.baidu.adp.gif.c.dF();
    }
}
