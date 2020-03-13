package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bi extends a implements com.baidu.adp.widget.ListView.m {
    public bj cRg;
    public boolean cQV = false;
    public boolean cQW = false;
    public boolean cQX = false;
    public boolean cQY = false;
    public boolean cQZ = false;
    public boolean cRa = false;
    public boolean cRb = false;
    public boolean cRc = false;
    public boolean cRd = false;
    public boolean cRe = false;
    public boolean cRf = false;
    public int cRh = 0;
    public int cRi = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cRg == null) {
            return null;
        }
        if (this.cRg.aDY()) {
            if (this.cRg.aCF() != null) {
                return bj.cRA;
            }
            return bj.cRk;
        }
        int aCj = this.cRg.aCj();
        if (this.cRg.aCF() != null && this.cRg.aDR()) {
            return bj.cRS;
        }
        if (this.cRg.threadType == 63) {
            bj bjVar = this.cRg;
            return bj.cRL;
        } else if (this.cRg.threadType == 64) {
            bj bjVar2 = this.cRg;
            return bj.cRM;
        } else if (this.cRg.threadType == 65) {
            bj bjVar3 = this.cRg;
            return bj.cRx;
        } else if (this.cRg.aCH() != null && this.cRg.threadType == 60) {
            return bj.cRD;
        } else {
            if (this.cRg.aCH() != null && this.cRg.threadType == 49) {
                return bj.cRB;
            }
            if (this.cRg.threadType == 51) {
                return bj.cRC;
            }
            if (aCj == 2 || aCj == 1) {
                return bj.cRj;
            }
            if (this.cRg.aCF() != null && this.cRg.aDx() && !this.cRg.aDp()) {
                return bj.cRR;
            }
            if (this.cRg.isShareThread && this.cRg.cTR != null) {
                if (this.cRg.cTR.cPN) {
                    if (this.cRg.cTR.videoInfo != null) {
                        return bj.cRH;
                    }
                    if (this.cRg.cTR.aBd()) {
                        return bj.cRG;
                    }
                    return bj.cRF;
                }
                return bj.cRE;
            } else if (this.cRg.aDr()) {
                bj bjVar4 = this.cRg;
                return bj.cRO.get() ? bj.cTe : bj.cRk;
            } else if (this.cRg.aCZ() && this.cRg.aCY() == 1) {
                bj bjVar5 = this.cRg;
                return bj.cRO.get() ? bj.cTm : bj.cRk;
            } else if (this.cRg.isLinkThread()) {
                return bj.cRy;
            } else {
                if (this.cRg.aDQ()) {
                    return this.cRg.aBW() != null ? bj.cRK : bj.cRJ;
                } else if (this.cQV) {
                    return bj.cRo;
                } else {
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
                        return bj.cRu;
                    }
                    if (this.cRc) {
                        return bj.cRv;
                    }
                    if (this.cRd) {
                        return bj.cRA;
                    }
                    if (this.cRg.aCr()) {
                        if (this.cRe) {
                            return bj.cRI;
                        }
                        return bj.cRz;
                    } else if (this.cRf) {
                        return bj.cRN;
                    } else {
                        return bj.cRk;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aAg() {
        return this.cRg;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aAi() {
        if (this.cRg == null || this.cRg.feedBackReasonMap == null || this.cRg.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aAg().getTid());
        alVar.setFid(aAg().getFid());
        alVar.setFeedBackReasonMap(this.cRg.feedBackReasonMap);
        alVar.cPF = this.cRg.mRecomAbTag;
        alVar.weight = this.cRg.mRecomWeight;
        alVar.extra = this.cRg.mRecomExtra;
        alVar.source = this.cRg.mRecomSource;
        alVar.cPG = this.cRg.cPG;
        alVar.cardType = this.cRg.aEl();
        return alVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aAh() {
        return this.cRg.cTx;
    }
}
