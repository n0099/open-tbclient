package com.baidu.card;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class al {
    public static final int ahG = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    public static final int ahH = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
    public static final int ahI = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
    private static final int ahJ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
    private static final int ahK = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    public static final int ahL = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0);
    boolean ahM = false;
    int ahN = ahJ;
    int ahO = ahK;
    int ahP = ahL;
    int ahQ = ahG;
    int ahR = 0;
    int ahS = ahH;
    int ahT = ahI;
    int ahU = R.color.CAM_X0205;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al() {
        aM(com.baidu.tbadk.a.d.bhw());
    }

    public void bv(int i) {
        this.ahN = i;
    }

    public void bw(int i) {
        this.ahQ = i;
    }

    public void bx(int i) {
        this.ahR = i;
    }

    public void by(int i) {
        this.ahS = i;
    }

    public void bz(int i) {
        this.ahT = i;
    }

    private void aM(boolean z) {
        if (z) {
            this.ahS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);
            this.ahT = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);
        }
    }
}
