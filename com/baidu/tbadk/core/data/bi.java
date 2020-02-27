package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bi extends a implements com.baidu.adp.widget.ListView.m {
    public bj cRe;
    public boolean cQT = false;
    public boolean cQU = false;
    public boolean cQV = false;
    public boolean cQW = false;
    public boolean cQX = false;
    public boolean cQY = false;
    public boolean cQZ = false;
    public boolean cRa = false;
    public boolean cRb = false;
    public boolean cRc = false;
    public boolean cRd = false;
    public int cRf = 0;
    public int cRg = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cRe == null) {
            return null;
        }
        if (this.cRe.aDW()) {
            if (this.cRe.aCD() != null) {
                return bj.cRy;
            }
            return bj.cRi;
        }
        int aCh = this.cRe.aCh();
        if (this.cRe.aCD() != null && this.cRe.aDP()) {
            return bj.cRQ;
        }
        if (this.cRe.threadType == 63) {
            bj bjVar = this.cRe;
            return bj.cRJ;
        } else if (this.cRe.threadType == 64) {
            bj bjVar2 = this.cRe;
            return bj.cRK;
        } else if (this.cRe.threadType == 65) {
            bj bjVar3 = this.cRe;
            return bj.cRv;
        } else if (this.cRe.aCF() != null && this.cRe.threadType == 60) {
            return bj.cRB;
        } else {
            if (this.cRe.aCF() != null && this.cRe.threadType == 49) {
                return bj.cRz;
            }
            if (this.cRe.threadType == 51) {
                return bj.cRA;
            }
            if (aCh == 2 || aCh == 1) {
                return bj.cRh;
            }
            if (this.cRe.aCD() != null && this.cRe.aDv() && !this.cRe.aDn()) {
                return bj.cRP;
            }
            if (this.cRe.isShareThread && this.cRe.cTP != null) {
                if (this.cRe.cTP.cPL) {
                    if (this.cRe.cTP.videoInfo != null) {
                        return bj.cRF;
                    }
                    if (this.cRe.cTP.aBb()) {
                        return bj.cRE;
                    }
                    return bj.cRD;
                }
                return bj.cRC;
            } else if (this.cRe.aDp()) {
                bj bjVar4 = this.cRe;
                return bj.cRM.get() ? bj.cTc : bj.cRi;
            } else if (this.cRe.aCX() && this.cRe.aCW() == 1) {
                bj bjVar5 = this.cRe;
                return bj.cRM.get() ? bj.cTk : bj.cRi;
            } else if (this.cRe.isLinkThread()) {
                return bj.cRw;
            } else {
                if (this.cRe.aDO()) {
                    return this.cRe.aBU() != null ? bj.cRI : bj.cRH;
                } else if (this.cQT) {
                    return bj.cRm;
                } else {
                    if (this.cQU) {
                        return bj.cRn;
                    }
                    if (this.cQV) {
                        return bj.cRo;
                    }
                    if (this.cQW) {
                        return bj.cRp;
                    }
                    if (this.cQX) {
                        return bj.cRq;
                    }
                    if (this.cQY) {
                        return bj.cRr;
                    }
                    if (this.cQZ) {
                        return bj.cRs;
                    }
                    if (this.cRa) {
                        return bj.cRt;
                    }
                    if (this.cRb) {
                        return bj.cRy;
                    }
                    if (this.cRe.aCp()) {
                        if (this.cRc) {
                            return bj.cRG;
                        }
                        return bj.cRx;
                    } else if (this.cRd) {
                        return bj.cRL;
                    } else {
                        return bj.cRi;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aAe() {
        return this.cRe;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aAg() {
        if (this.cRe == null || this.cRe.feedBackReasonMap == null || this.cRe.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aAe().getTid());
        alVar.setFid(aAe().getFid());
        alVar.setFeedBackReasonMap(this.cRe.feedBackReasonMap);
        alVar.cPD = this.cRe.mRecomAbTag;
        alVar.weight = this.cRe.mRecomWeight;
        alVar.extra = this.cRe.mRecomExtra;
        alVar.source = this.cRe.mRecomSource;
        alVar.cPE = this.cRe.cPE;
        alVar.cardType = this.cRe.aEj();
        return alVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aAf() {
        return this.cRe.cTv;
    }
}
