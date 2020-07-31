package com.baidu.card;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class aj {
    private static final int afH = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private static final int afI = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds12);
    public static final int afJ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15);
    int afL;
    boolean afK = false;
    int afM = 0;
    int afN = afJ;
    int afO = afH;
    int afP = 0;
    int afQ = afH;
    int afR = afH;
    int afS = R.color.cp_bg_line_e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj() {
        this.afL = afI;
        this.afL = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), com.baidu.tbadk.a.b.a.aE(R.dimen.tbds5, R.dimen.tbds20));
    }

    public void bm(int i) {
        this.afL = i;
    }

    public void bn(int i) {
        this.afM = i;
    }

    public void bo(int i) {
        this.afN = i;
    }

    public void bp(int i) {
        this.afO = i;
    }

    public void bq(int i) {
        this.afP = i;
    }

    public void br(int i) {
        this.afQ = i;
    }

    public void bs(int i) {
        this.afR = i;
    }

    public void setBackgroundResource(int i) {
        this.afS = i;
    }
}
