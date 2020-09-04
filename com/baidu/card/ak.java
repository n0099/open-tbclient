package com.baidu.card;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ak {
    public static final int agT = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private static final int agU = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds12);
    public static final int agV = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15);
    int agX;
    boolean agW = false;
    int agY = 0;
    int agZ = agV;
    int aha = agT;
    int ahb = 0;
    int ahc = agT;
    int ahd = agT;
    int ahe = R.color.cp_bg_line_e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak() {
        this.agX = agU;
        this.agX = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), com.baidu.tbadk.a.b.a.aL(R.dimen.tbds5, R.dimen.tbds20));
    }

    public void br(int i) {
        this.agX = i;
    }

    public void bs(int i) {
        this.agY = i;
    }

    public void bt(int i) {
        this.agZ = i;
    }

    public void bu(int i) {
        this.aha = i;
    }

    public void bv(int i) {
        this.ahb = i;
    }

    public void bw(int i) {
        this.ahc = i;
    }

    public void bx(int i) {
        this.ahd = i;
    }

    public void setBackgroundResource(int i) {
        this.ahe = i;
    }
}
