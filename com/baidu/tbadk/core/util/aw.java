package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aw {
    private static aw abP = null;
    private boolean abQ = false;
    private boolean abR = false;
    private int abS = TbConfig.POST_IMAGE_SMALL;
    private String abT = String.valueOf(45);

    public static aw vm() {
        if (abP == null) {
            synchronized (aw.class) {
                abP = new aw();
            }
        }
        return abP;
    }

    public aw() {
        vp();
        vn();
    }

    private void vn() {
        vt();
        vu();
        vv();
    }

    public void aF(boolean z) {
        this.abR = z;
    }

    public boolean vo() {
        return this.abR;
    }

    public void aG(boolean z) {
        this.abQ = z;
        vn();
    }

    private void vp() {
        this.abQ = com.baidu.adp.lib.util.i.gn();
    }

    public boolean vq() {
        return this.abQ;
    }

    public String vr() {
        return this.abT;
    }

    public int vs() {
        vv();
        return this.abS;
    }

    public void vt() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.oJ().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.oJ().getViewImageQuality() != 1 : !this.abQ) {
            z = false;
        }
        aF(z);
    }

    public void vu() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.oJ().getViewImageQuality() == 0) {
            if (vq()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.oJ().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.abT = valueOf;
    }

    public void vv() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.oJ().oM()) {
            case 0:
                if (!vq()) {
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
        this.abS = i;
    }

    public static boolean vw() {
        return m.cA() && com.baidu.adp.gif.e.cz();
    }
}
