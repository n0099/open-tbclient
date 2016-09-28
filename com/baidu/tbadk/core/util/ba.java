package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ba {
    private static ba abZ = null;
    private boolean aca = false;
    private boolean acb = false;
    private int acc = TbConfig.POST_IMAGE_SMALL;
    private String acd = String.valueOf(45);

    public static ba vy() {
        if (abZ == null) {
            synchronized (ba.class) {
                abZ = new ba();
            }
        }
        return abZ;
    }

    public ba() {
        vB();
        vz();
    }

    private void vz() {
        vF();
        vG();
        vH();
    }

    public void aB(boolean z) {
        this.acb = z;
    }

    public boolean vA() {
        return this.acb;
    }

    public void aC(boolean z) {
        this.aca = z;
        vz();
    }

    private void vB() {
        this.aca = com.baidu.adp.lib.util.i.gn();
    }

    public boolean vC() {
        return this.aca;
    }

    public String vD() {
        return this.acd;
    }

    public int vE() {
        vH();
        return this.acc;
    }

    public void vF() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.oH().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.oH().getViewImageQuality() != 1 : !this.aca) {
            z = false;
        }
        aB(z);
    }

    public void vG() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.oH().getViewImageQuality() == 0) {
            if (vC()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.oH().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.acd = valueOf;
    }

    public void vH() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.oH().oK()) {
            case 0:
                if (!vC()) {
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
        this.acc = i;
    }

    public static boolean vI() {
        return m.cA() && com.baidu.adp.gif.e.cz();
    }
}
