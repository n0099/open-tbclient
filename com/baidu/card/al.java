package com.baidu.card;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class al {
    public static final int ahE = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private static final int ahF = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds12);
    public static final int ahG = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15);
    int ahI;
    boolean ahH = false;
    int ahJ = 0;
    int ahK = ahG;
    int ahL = ahE;
    int ahM = 0;
    int ahN = ahE;
    int ahO = ahE;
    int ahP = R.color.cp_bg_line_e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al() {
        this.ahI = ahF;
        this.ahI = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), com.baidu.tbadk.a.b.a.aL(R.dimen.tbds5, R.dimen.tbds20));
    }

    public void bv(int i) {
        this.ahI = i;
    }

    public void bw(int i) {
        this.ahJ = i;
    }

    public void bx(int i) {
        this.ahK = i;
    }

    public void by(int i) {
        this.ahL = i;
    }

    public void bz(int i) {
        this.ahM = i;
    }

    public void bA(int i) {
        this.ahN = i;
    }

    public void bB(int i) {
        this.ahO = i;
    }

    public void setBackgroundResource(int i) {
        this.ahP = i;
    }
}
