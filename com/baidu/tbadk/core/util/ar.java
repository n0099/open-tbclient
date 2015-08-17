package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ar {
    private static ar abb = null;
    private boolean abc = false;
    private boolean abd = false;
    private int abe = TbConfig.POST_IMAGE_SMALL;
    private String abf = String.valueOf(45);

    public static ar uE() {
        if (abb == null) {
            synchronized (ar.class) {
                abb = new ar();
            }
        }
        return abb;
    }

    public ar() {
        uH();
        uF();
    }

    private void uF() {
        uL();
        uM();
        uN();
    }

    public void ar(boolean z) {
        this.abd = z;
    }

    public boolean uG() {
        return this.abd;
    }

    public void as(boolean z) {
        this.abc = z;
        uF();
    }

    private void uH() {
        this.abc = com.baidu.adp.lib.util.i.iP();
    }

    public boolean uI() {
        return this.abc;
    }

    public String uJ() {
        return this.abf;
    }

    public int uK() {
        uN();
        return this.abe;
    }

    public void uL() {
        boolean z = true;
        if (com.baidu.tbadk.core.m.rd().getViewImageQuality() != 0 ? com.baidu.tbadk.core.m.rd().getViewImageQuality() != 1 : !this.abc) {
            z = false;
        }
        ar(z);
    }

    public void uM() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.m.rd().getViewImageQuality() == 0) {
            if (uI()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.m.rd().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.abf = valueOf;
    }

    public void uN() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.m.rd().rg()) {
            case 0:
                if (!uI()) {
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
        this.abe = i;
    }

    public static boolean uO() {
        return n.fl() && com.baidu.adp.gif.e.fk();
    }
}
