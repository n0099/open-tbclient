package com.baidu.card;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class al {
    public static final int aiG = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    public static final int aiH = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
    public static final int aiI = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
    private static final int aiJ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
    private static final int aiK = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    public static final int aiL = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0);
    boolean aiM = false;
    int aiN = aiJ;
    int aiO = aiK;
    int aiP = aiL;
    int aiQ = aiG;
    int aiR = 0;
    int aiS = aiH;
    int aiT = aiI;
    int aiU = R.color.CAM_X0205;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al() {
        aM(com.baidu.tbadk.a.d.bkA());
    }

    public void bz(int i) {
        this.aiN = i;
    }

    public void bA(int i) {
        this.aiQ = i;
    }

    public void bB(int i) {
        this.aiR = i;
    }

    public void bC(int i) {
        this.aiS = i;
    }

    public void bD(int i) {
        this.aiT = i;
    }

    private void aM(boolean z) {
        if (z) {
            this.aiS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);
            this.aiT = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);
        }
    }
}
