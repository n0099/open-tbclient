package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bg extends a implements com.baidu.adp.widget.ListView.m {
    public bh threadData;
    public boolean bJz = false;
    public boolean bJA = false;
    public boolean bJB = false;
    public boolean bJC = false;
    public boolean bJD = false;
    public boolean bJE = false;
    public boolean bJF = false;
    public boolean bJG = false;
    public boolean bJH = false;
    public boolean bJI = false;
    public int bJJ = 0;
    public int bJK = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return null;
        }
        if (this.threadData.agq()) {
            if (this.threadData.aeT() != null) {
                return bh.bKa;
            }
            return bh.bJM;
        }
        int aex = this.threadData.aex();
        if (this.threadData.aeT() != null && this.threadData.agh()) {
            return bh.bKp;
        }
        if (this.threadData.threadType == 63) {
            bh bhVar = this.threadData;
            return bh.bKi;
        } else if (this.threadData.threadType == 64) {
            bh bhVar2 = this.threadData;
            return bh.bKj;
        } else if (this.threadData.aeV() != null && this.threadData.threadType == 60) {
            return bh.bKd;
        } else {
            if (this.threadData.aeV() != null && this.threadData.threadType == 49) {
                return bh.bKb;
            }
            if (this.threadData.threadType == 51) {
                return bh.bKc;
            }
            if (aex == 2 || aex == 1) {
                return bh.bJL;
            }
            if (this.threadData.aeT() != null && this.threadData.afI() && !this.threadData.afz()) {
                return bh.bKo;
            }
            if (this.threadData.isShareThread) {
                return bh.bKe;
            }
            if (this.threadData.afB()) {
                bh bhVar3 = this.threadData;
                return bh.bKl.get() ? bh.bLy : bh.bJM;
            } else if (this.threadData.afn() && this.threadData.afm() == 1) {
                bh bhVar4 = this.threadData;
                return bh.bKl.get() ? bh.bLG : bh.bJM;
            } else if (this.threadData.isLinkThread()) {
                return bh.bJY;
            } else {
                if (this.threadData.agg()) {
                    return this.threadData.ael() != null ? bh.bKh : bh.bKg;
                } else if (this.bJz) {
                    return bh.bJQ;
                } else {
                    if (this.bJA) {
                        return bh.bJR;
                    }
                    if (this.bJB) {
                        return bh.bJS;
                    }
                    if (this.bJC) {
                        return bh.bJT;
                    }
                    if (this.bJD) {
                        return bh.bJU;
                    }
                    if (this.bJE) {
                        return bh.bJV;
                    }
                    if (this.bJF) {
                        return bh.bJW;
                    }
                    if (this.bJG) {
                        return bh.bKa;
                    }
                    if (this.threadData.aeF()) {
                        if (this.bJH) {
                            return bh.bKf;
                        }
                        return bh.bJZ;
                    } else if (this.bJI) {
                        return bh.bKk;
                    } else {
                        return bh.bJM;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bh acC() {
        return this.threadData;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj acE() {
        if (this.threadData.bIk == null || this.threadData.bIk.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(acC().getTid());
        ajVar.setFid(acC().getFid());
        ajVar.b(this.threadData.bIk);
        return ajVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String acD() {
        return this.threadData.bLX;
    }
}
