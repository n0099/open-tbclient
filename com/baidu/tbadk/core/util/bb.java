package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bb {
    private static bb abM = null;
    private boolean abN = false;
    private boolean abO = false;
    private int abP = TbConfig.POST_IMAGE_SMALL;
    private String abQ = String.valueOf(45);

    public static bb vk() {
        if (abM == null) {
            synchronized (bb.class) {
                abM = new bb();
            }
        }
        return abM;
    }

    public bb() {
        vn();
        vl();
    }

    private void vl() {
        vr();
        vs();
        vt();
    }

    public void aB(boolean z) {
        this.abO = z;
    }

    public boolean vm() {
        return this.abO;
    }

    public void aC(boolean z) {
        this.abN = z;
        vl();
    }

    private void vn() {
        this.abN = com.baidu.adp.lib.util.i.gn();
    }

    public boolean vo() {
        return this.abN;
    }

    public String vp() {
        return this.abQ;
    }

    public int vq() {
        vt();
        return this.abP;
    }

    public void vr() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.oG().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.oG().getViewImageQuality() != 1 : !this.abN) {
            z = false;
        }
        aB(z);
    }

    public void vs() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.oG().getViewImageQuality() == 0) {
            if (vo()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.oG().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.abQ = valueOf;
    }

    public void vt() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.oG().oJ()) {
            case 0:
                if (!vo()) {
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
        this.abP = i;
    }

    public static boolean vu() {
        return m.cA() && com.baidu.adp.gif.e.cz();
    }
}
