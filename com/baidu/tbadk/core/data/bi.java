package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bi extends a implements com.baidu.adp.widget.ListView.m {
    public bj cRt;
    public boolean cRi = false;
    public boolean cRj = false;
    public boolean cRk = false;
    public boolean cRl = false;
    public boolean cRm = false;
    public boolean cRn = false;
    public boolean cRo = false;
    public boolean cRp = false;
    public boolean cRq = false;
    public boolean cRr = false;
    public boolean cRs = false;
    public int cRu = 0;
    public int cRv = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cRt == null) {
            return null;
        }
        if (this.cRt.aEc()) {
            if (this.cRt.aCI() != null) {
                return bj.cRN;
            }
            return bj.cRx;
        }
        int aCm = this.cRt.aCm();
        if (this.cRt.aCI() != null && this.cRt.aDV()) {
            return bj.cSf;
        }
        if (this.cRt.threadType == 63) {
            bj bjVar = this.cRt;
            return bj.cRY;
        } else if (this.cRt.threadType == 64) {
            bj bjVar2 = this.cRt;
            return bj.cRZ;
        } else if (this.cRt.threadType == 65) {
            bj bjVar3 = this.cRt;
            return bj.cRK;
        } else if (this.cRt.aCK() != null && this.cRt.threadType == 60) {
            return bj.cRQ;
        } else {
            if (this.cRt.aCK() != null && this.cRt.threadType == 49) {
                return bj.cRO;
            }
            if (this.cRt.threadType == 51) {
                return bj.cRP;
            }
            if (aCm == 2 || aCm == 1) {
                return bj.cRw;
            }
            if (this.cRt.aCI() != null && this.cRt.aDB() && !this.cRt.aDt()) {
                return bj.cSe;
            }
            if (this.cRt.isShareThread && this.cRt.cUe != null) {
                if (this.cRt.cUe.cQa) {
                    if (this.cRt.cUe.videoInfo != null) {
                        return bj.cRU;
                    }
                    if (this.cRt.cUe.aBg()) {
                        return bj.cRT;
                    }
                    return bj.cRS;
                }
                return bj.cRR;
            } else if (this.cRt.aDv()) {
                bj bjVar4 = this.cRt;
                return bj.cSb.get() ? bj.cTr : bj.cRx;
            } else if (this.cRt.aDc() && this.cRt.aDb() == 1) {
                bj bjVar5 = this.cRt;
                return bj.cSb.get() ? bj.cTz : bj.cRx;
            } else if (this.cRt.isLinkThread()) {
                return bj.cRL;
            } else {
                if (this.cRt.aDU()) {
                    return this.cRt.aBZ() != null ? bj.cRX : bj.cRW;
                } else if (this.cRi) {
                    return bj.cRB;
                } else {
                    if (this.cRj) {
                        return bj.cRC;
                    }
                    if (this.cRk) {
                        return bj.cRD;
                    }
                    if (this.cRl) {
                        return bj.cRE;
                    }
                    if (this.cRm) {
                        return bj.cRF;
                    }
                    if (this.cRn) {
                        return bj.cRG;
                    }
                    if (this.cRo) {
                        return bj.cRH;
                    }
                    if (this.cRp) {
                        return bj.cRI;
                    }
                    if (this.cRq) {
                        return bj.cRN;
                    }
                    if (this.cRt.aCu()) {
                        if (this.cRr) {
                            return bj.cRV;
                        }
                        return bj.cRM;
                    } else if (this.cRs) {
                        return bj.cSa;
                    } else {
                        return bj.cRx;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aAj() {
        return this.cRt;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aAl() {
        if (this.cRt == null || this.cRt.feedBackReasonMap == null || this.cRt.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aAj().getTid());
        alVar.setFid(aAj().getFid());
        alVar.setFeedBackReasonMap(this.cRt.feedBackReasonMap);
        alVar.cPS = this.cRt.mRecomAbTag;
        alVar.weight = this.cRt.mRecomWeight;
        alVar.extra = this.cRt.mRecomExtra;
        alVar.source = this.cRt.mRecomSource;
        alVar.cPT = this.cRt.cPT;
        alVar.cardType = this.cRt.aEp();
        return alVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aAk() {
        return this.cRt.cTK;
    }
}
