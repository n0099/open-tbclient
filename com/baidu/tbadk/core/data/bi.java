package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bi extends a implements com.baidu.adp.widget.ListView.m {
    public bj cMR;
    public boolean cMG = false;
    public boolean cMH = false;
    public boolean cMI = false;
    public boolean cMJ = false;
    public boolean cMK = false;
    public boolean cML = false;
    public boolean cMM = false;
    public boolean cMN = false;
    public boolean cMO = false;
    public boolean cMP = false;
    public boolean cMQ = false;
    public int cMS = 0;
    public int cMT = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cMR == null) {
            return null;
        }
        if (this.cMR.aBr()) {
            if (this.cMR.azV() != null) {
                return bj.cNl;
            }
            return bj.cMV;
        }
        int azz = this.cMR.azz();
        if (this.cMR.azV() != null && this.cMR.aBj()) {
            return bj.cND;
        }
        if (this.cMR.threadType == 63) {
            bj bjVar = this.cMR;
            return bj.cNw;
        } else if (this.cMR.threadType == 64) {
            bj bjVar2 = this.cMR;
            return bj.cNx;
        } else if (this.cMR.threadType == 65) {
            bj bjVar3 = this.cMR;
            return bj.cNi;
        } else if (this.cMR.azX() != null && this.cMR.threadType == 60) {
            return bj.cNo;
        } else {
            if (this.cMR.azX() != null && this.cMR.threadType == 49) {
                return bj.cNm;
            }
            if (this.cMR.threadType == 51) {
                return bj.cNn;
            }
            if (azz == 2 || azz == 1) {
                return bj.cMU;
            }
            if (this.cMR.azV() != null && this.cMR.aAP() && !this.cMR.aAH()) {
                return bj.cNC;
            }
            if (this.cMR.isShareThread && this.cMR.cPD != null) {
                if (this.cMR.cPD.cLy) {
                    if (this.cMR.cPD.videoInfo != null) {
                        return bj.cNs;
                    }
                    if (this.cMR.cPD.ays()) {
                        return bj.cNr;
                    }
                    return bj.cNq;
                }
                return bj.cNp;
            } else if (this.cMR.aAJ()) {
                bj bjVar4 = this.cMR;
                return bj.cNz.get() ? bj.cOQ : bj.cMV;
            } else if (this.cMR.aAp() && this.cMR.aAo() == 1) {
                bj bjVar5 = this.cMR;
                return bj.cNz.get() ? bj.cOY : bj.cMV;
            } else if (this.cMR.isLinkThread()) {
                return bj.cNj;
            } else {
                if (this.cMR.aBi()) {
                    return this.cMR.azm() != null ? bj.cNv : bj.cNu;
                } else if (this.cMG) {
                    return bj.cMZ;
                } else {
                    if (this.cMH) {
                        return bj.cNa;
                    }
                    if (this.cMI) {
                        return bj.cNb;
                    }
                    if (this.cMJ) {
                        return bj.cNc;
                    }
                    if (this.cMK) {
                        return bj.cNd;
                    }
                    if (this.cML) {
                        return bj.cNe;
                    }
                    if (this.cMM) {
                        return bj.cNf;
                    }
                    if (this.cMN) {
                        return bj.cNg;
                    }
                    if (this.cMO) {
                        return bj.cNl;
                    }
                    if (this.cMR.azH()) {
                        if (this.cMP) {
                            return bj.cNt;
                        }
                        return bj.cNk;
                    } else if (this.cMQ) {
                        return bj.cNy;
                    } else {
                        return bj.cMV;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj axx() {
        return this.cMR;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al axz() {
        if (this.cMR == null || this.cMR.feedBackReasonMap == null || this.cMR.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(axx().getTid());
        alVar.setFid(axx().getFid());
        alVar.setFeedBackReasonMap(this.cMR.feedBackReasonMap);
        alVar.cLq = this.cMR.mRecomAbTag;
        alVar.weight = this.cMR.mRecomWeight;
        alVar.extra = this.cMR.mRecomExtra;
        alVar.source = this.cMR.mRecomSource;
        alVar.cLr = this.cMR.cLr;
        alVar.cardType = this.cMR.aBF();
        return alVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String axy() {
        return this.cMR.cPj;
    }
}
