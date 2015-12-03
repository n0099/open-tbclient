package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ay {
    private static ay aci = null;
    private boolean acj = false;
    private boolean ack = false;
    private int acl = TbConfig.POST_IMAGE_SMALL;
    private String acm = String.valueOf(45);

    public static ay vq() {
        if (aci == null) {
            synchronized (ay.class) {
                aci = new ay();
            }
        }
        return aci;
    }

    public ay() {
        vt();
        vr();
    }

    private void vr() {
        vx();
        vy();
        vz();
    }

    public void au(boolean z) {
        this.ack = z;
    }

    public boolean vs() {
        return this.ack;
    }

    public void av(boolean z) {
        this.acj = z;
        vr();
    }

    private void vt() {
        this.acj = com.baidu.adp.lib.util.i.iQ();
    }

    public boolean vu() {
        return this.acj;
    }

    public String vv() {
        return this.acm;
    }

    public int vw() {
        vz();
        return this.acl;
    }

    public void vx() {
        boolean z = true;
        if (com.baidu.tbadk.core.m.rh().getViewImageQuality() != 0 ? com.baidu.tbadk.core.m.rh().getViewImageQuality() != 1 : !this.acj) {
            z = false;
        }
        au(z);
    }

    public void vy() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.m.rh().getViewImageQuality() == 0) {
            if (vu()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.m.rh().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.acm = valueOf;
    }

    public void vz() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.m.rh().rk()) {
            case 0:
                if (!vu()) {
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
        this.acl = i;
    }

    public static boolean vA() {
        return n.fi() && com.baidu.adp.gif.e.fh();
    }
}
