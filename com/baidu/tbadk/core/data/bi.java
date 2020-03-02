package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bi extends a implements com.baidu.adp.widget.ListView.m {
    public bj cRf;
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
    public boolean cRe = false;
    public int cRg = 0;
    public int cRh = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cRf == null) {
            return null;
        }
        if (this.cRf.aDY()) {
            if (this.cRf.aCF() != null) {
                return bj.cRz;
            }
            return bj.cRj;
        }
        int aCj = this.cRf.aCj();
        if (this.cRf.aCF() != null && this.cRf.aDR()) {
            return bj.cRR;
        }
        if (this.cRf.threadType == 63) {
            bj bjVar = this.cRf;
            return bj.cRK;
        } else if (this.cRf.threadType == 64) {
            bj bjVar2 = this.cRf;
            return bj.cRL;
        } else if (this.cRf.threadType == 65) {
            bj bjVar3 = this.cRf;
            return bj.cRw;
        } else if (this.cRf.aCH() != null && this.cRf.threadType == 60) {
            return bj.cRC;
        } else {
            if (this.cRf.aCH() != null && this.cRf.threadType == 49) {
                return bj.cRA;
            }
            if (this.cRf.threadType == 51) {
                return bj.cRB;
            }
            if (aCj == 2 || aCj == 1) {
                return bj.cRi;
            }
            if (this.cRf.aCF() != null && this.cRf.aDx() && !this.cRf.aDp()) {
                return bj.cRQ;
            }
            if (this.cRf.isShareThread && this.cRf.cTQ != null) {
                if (this.cRf.cTQ.cPM) {
                    if (this.cRf.cTQ.videoInfo != null) {
                        return bj.cRG;
                    }
                    if (this.cRf.cTQ.aBd()) {
                        return bj.cRF;
                    }
                    return bj.cRE;
                }
                return bj.cRD;
            } else if (this.cRf.aDr()) {
                bj bjVar4 = this.cRf;
                return bj.cRN.get() ? bj.cTd : bj.cRj;
            } else if (this.cRf.aCZ() && this.cRf.aCY() == 1) {
                bj bjVar5 = this.cRf;
                return bj.cRN.get() ? bj.cTl : bj.cRj;
            } else if (this.cRf.isLinkThread()) {
                return bj.cRx;
            } else {
                if (this.cRf.aDQ()) {
                    return this.cRf.aBW() != null ? bj.cRJ : bj.cRI;
                } else if (this.cQU) {
                    return bj.cRn;
                } else {
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
                        return bj.cRu;
                    }
                    if (this.cRc) {
                        return bj.cRz;
                    }
                    if (this.cRf.aCr()) {
                        if (this.cRd) {
                            return bj.cRH;
                        }
                        return bj.cRy;
                    } else if (this.cRe) {
                        return bj.cRM;
                    } else {
                        return bj.cRj;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aAg() {
        return this.cRf;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aAi() {
        if (this.cRf == null || this.cRf.feedBackReasonMap == null || this.cRf.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aAg().getTid());
        alVar.setFid(aAg().getFid());
        alVar.setFeedBackReasonMap(this.cRf.feedBackReasonMap);
        alVar.cPE = this.cRf.mRecomAbTag;
        alVar.weight = this.cRf.mRecomWeight;
        alVar.extra = this.cRf.mRecomExtra;
        alVar.source = this.cRf.mRecomSource;
        alVar.cPF = this.cRf.cPF;
        alVar.cardType = this.cRf.aEl();
        return alVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aAh() {
        return this.cRf.cTw;
    }
}
