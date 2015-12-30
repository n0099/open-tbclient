package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ay {
    private static ay acN = null;
    private boolean acO = false;
    private boolean acP = false;
    private int acQ = TbConfig.POST_IMAGE_SMALL;
    private String acR = String.valueOf(45);

    public static ay va() {
        if (acN == null) {
            synchronized (ay.class) {
                acN = new ay();
            }
        }
        return acN;
    }

    public ay() {
        vd();
        vb();
    }

    private void vb() {
        vh();
        vi();
        vj();
    }

    public void ar(boolean z) {
        this.acP = z;
    }

    public boolean vc() {
        return this.acP;
    }

    public void as(boolean z) {
        this.acO = z;
        vb();
    }

    private void vd() {
        this.acO = com.baidu.adp.lib.util.i.iR();
    }

    public boolean ve() {
        return this.acO;
    }

    public String vf() {
        return this.acR;
    }

    public int vg() {
        vj();
        return this.acQ;
    }

    public void vh() {
        boolean z = true;
        if (com.baidu.tbadk.core.m.qQ().getViewImageQuality() != 0 ? com.baidu.tbadk.core.m.qQ().getViewImageQuality() != 1 : !this.acO) {
            z = false;
        }
        ar(z);
    }

    public void vi() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.m.qQ().getViewImageQuality() == 0) {
            if (ve()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.m.qQ().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.acR = valueOf;
    }

    public void vj() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.m.qQ().qT()) {
            case 0:
                if (!ve()) {
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
        this.acQ = i;
    }

    public static boolean vk() {
        return n.fi() && com.baidu.adp.gif.e.fh();
    }
}
