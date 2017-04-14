package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class av {
    private static av agF = null;
    private boolean agG = false;
    private boolean agH = false;
    private int agI = TbConfig.POST_IMAGE_SMALL;
    private String agJ = String.valueOf(45);

    public static av wa() {
        if (agF == null) {
            synchronized (av.class) {
                agF = new av();
            }
        }
        return agF;
    }

    public av() {
        wd();
        wb();
    }

    private void wb() {
        wh();
        wi();
        wj();
    }

    public void aG(boolean z) {
        this.agH = z;
    }

    public boolean wc() {
        return this.agH;
    }

    public void aH(boolean z) {
        this.agG = z;
        wb();
    }

    private void wd() {
        this.agG = com.baidu.adp.lib.util.i.hk();
    }

    public boolean we() {
        return this.agG;
    }

    public String wf() {
        return this.agJ;
    }

    public int wg() {
        wj();
        return this.agI;
    }

    public void wh() {
        boolean z = true;
        if (com.baidu.tbadk.core.q.po().getViewImageQuality() != 0 ? com.baidu.tbadk.core.q.po().getViewImageQuality() != 1 : !this.agG) {
            z = false;
        }
        aG(z);
    }

    public void wi() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.q.po().getViewImageQuality() == 0) {
            if (we()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.q.po().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.agJ = valueOf;
    }

    public void wj() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.q.po().pr()) {
            case 0:
                if (!we()) {
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
        this.agI = i;
    }

    public static boolean wk() {
        return l.dG() && com.baidu.adp.gif.e.dF();
    }
}
