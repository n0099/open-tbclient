package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bg extends a implements com.baidu.adp.widget.ListView.m {
    public boolean bJb = false;
    public boolean bJc = false;
    public boolean bJd = false;
    public boolean bJe = false;
    public boolean bJf = false;
    public boolean bJg = false;
    public boolean bJh = false;
    public boolean bJi = false;
    public boolean bJj = false;
    public boolean bJk = false;
    public int bJl = 0;
    public int bJm = 0;
    public bh threadData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return null;
        }
        if (this.threadData.agm()) {
            if (this.threadData.aeP() != null) {
                return bh.bJC;
            }
            return bh.bJo;
        }
        int aet = this.threadData.aet();
        if (this.threadData.aeP() != null && this.threadData.agd()) {
            return bh.bJR;
        }
        if (this.threadData.threadType == 63) {
            bh bhVar = this.threadData;
            return bh.bJK;
        } else if (this.threadData.threadType == 64) {
            bh bhVar2 = this.threadData;
            return bh.bJL;
        } else if (this.threadData.aeR() != null && this.threadData.threadType == 60) {
            return bh.bJF;
        } else {
            if (this.threadData.aeR() != null && this.threadData.threadType == 49) {
                return bh.bJD;
            }
            if (this.threadData.threadType == 51) {
                return bh.bJE;
            }
            if (aet == 2 || aet == 1) {
                return bh.bJn;
            }
            if (this.threadData.aeP() != null && this.threadData.afE() && !this.threadData.afv()) {
                return bh.bJQ;
            }
            if (this.threadData.isShareThread) {
                return bh.bJG;
            }
            if (this.threadData.afx()) {
                bh bhVar3 = this.threadData;
                return bh.bJN.get() ? bh.bLa : bh.bJo;
            } else if (this.threadData.afj() && this.threadData.afi() == 1) {
                bh bhVar4 = this.threadData;
                return bh.bJN.get() ? bh.bLi : bh.bJo;
            } else if (this.threadData.isLinkThread()) {
                return bh.bJA;
            } else {
                if (this.threadData.agc()) {
                    return this.threadData.aeh() != null ? bh.bJJ : bh.bJI;
                } else if (this.bJb) {
                    return bh.bJs;
                } else {
                    if (this.bJc) {
                        return bh.bJt;
                    }
                    if (this.bJd) {
                        return bh.bJu;
                    }
                    if (this.bJe) {
                        return bh.bJv;
                    }
                    if (this.bJf) {
                        return bh.bJw;
                    }
                    if (this.bJg) {
                        return bh.bJx;
                    }
                    if (this.bJh) {
                        return bh.bJy;
                    }
                    if (this.bJi) {
                        return bh.bJC;
                    }
                    if (this.threadData.aeB()) {
                        if (this.bJj) {
                            return bh.bJH;
                        }
                        return bh.bJB;
                    } else if (this.bJk) {
                        return bh.bJM;
                    } else {
                        return bh.bJo;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bh acy() {
        return this.threadData;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj acA() {
        if (this.threadData.bHM == null || this.threadData.bHM.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(acy().getTid());
        ajVar.setFid(acy().getFid());
        ajVar.b(this.threadData.bHM);
        return ajVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String acz() {
        return this.threadData.bLz;
    }
}
