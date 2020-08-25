package com.baidu.card;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ak {
    public static final int agR = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private static final int agS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds12);
    public static final int agT = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15);
    int agV;
    boolean agU = false;
    int agW = 0;
    int agX = agT;
    int agY = agR;
    int agZ = 0;
    int aha = agR;
    int ahb = agR;
    int ahc = R.color.cp_bg_line_e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak() {
        this.agV = agS;
        this.agV = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), com.baidu.tbadk.a.b.a.aL(R.dimen.tbds5, R.dimen.tbds20));
    }

    public void br(int i) {
        this.agV = i;
    }

    public void bs(int i) {
        this.agW = i;
    }

    public void bt(int i) {
        this.agX = i;
    }

    public void bu(int i) {
        this.agY = i;
    }

    public void bv(int i) {
        this.agZ = i;
    }

    public void bw(int i) {
        this.aha = i;
    }

    public void bx(int i) {
        this.ahb = i;
    }

    public void setBackgroundResource(int i) {
        this.ahc = i;
    }
}
