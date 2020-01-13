package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bi extends a implements com.baidu.adp.widget.ListView.m {
    public bj cNb;
    public boolean cMQ = false;
    public boolean cMR = false;
    public boolean cMS = false;
    public boolean cMT = false;
    public boolean cMU = false;
    public boolean cMV = false;
    public boolean cMW = false;
    public boolean cMX = false;
    public boolean cMY = false;
    public boolean cMZ = false;
    public boolean cNa = false;
    public int cNc = 0;
    public int cNd = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cNb == null) {
            return null;
        }
        if (this.cNb.aBK()) {
            if (this.cNb.aAo() != null) {
                return bj.cNv;
            }
            return bj.cNf;
        }
        int azS = this.cNb.azS();
        if (this.cNb.aAo() != null && this.cNb.aBC()) {
            return bj.cNN;
        }
        if (this.cNb.threadType == 63) {
            bj bjVar = this.cNb;
            return bj.cNG;
        } else if (this.cNb.threadType == 64) {
            bj bjVar2 = this.cNb;
            return bj.cNH;
        } else if (this.cNb.threadType == 65) {
            bj bjVar3 = this.cNb;
            return bj.cNs;
        } else if (this.cNb.aAq() != null && this.cNb.threadType == 60) {
            return bj.cNy;
        } else {
            if (this.cNb.aAq() != null && this.cNb.threadType == 49) {
                return bj.cNw;
            }
            if (this.cNb.threadType == 51) {
                return bj.cNx;
            }
            if (azS == 2 || azS == 1) {
                return bj.cNe;
            }
            if (this.cNb.aAo() != null && this.cNb.aBi() && !this.cNb.aBa()) {
                return bj.cNM;
            }
            if (this.cNb.isShareThread && this.cNb.cPN != null) {
                if (this.cNb.cPN.cLI) {
                    if (this.cNb.cPN.videoInfo != null) {
                        return bj.cNC;
                    }
                    if (this.cNb.cPN.ayL()) {
                        return bj.cNB;
                    }
                    return bj.cNA;
                }
                return bj.cNz;
            } else if (this.cNb.aBc()) {
                bj bjVar4 = this.cNb;
                return bj.cNJ.get() ? bj.cPa : bj.cNf;
            } else if (this.cNb.aAI() && this.cNb.aAH() == 1) {
                bj bjVar5 = this.cNb;
                return bj.cNJ.get() ? bj.cPi : bj.cNf;
            } else if (this.cNb.isLinkThread()) {
                return bj.cNt;
            } else {
                if (this.cNb.aBB()) {
                    return this.cNb.azF() != null ? bj.cNF : bj.cNE;
                } else if (this.cMQ) {
                    return bj.cNj;
                } else {
                    if (this.cMR) {
                        return bj.cNk;
                    }
                    if (this.cMS) {
                        return bj.cNl;
                    }
                    if (this.cMT) {
                        return bj.cNm;
                    }
                    if (this.cMU) {
                        return bj.cNn;
                    }
                    if (this.cMV) {
                        return bj.cNo;
                    }
                    if (this.cMW) {
                        return bj.cNp;
                    }
                    if (this.cMX) {
                        return bj.cNq;
                    }
                    if (this.cMY) {
                        return bj.cNv;
                    }
                    if (this.cNb.aAa()) {
                        if (this.cMZ) {
                            return bj.cND;
                        }
                        return bj.cNu;
                    } else if (this.cNa) {
                        return bj.cNI;
                    } else {
                        return bj.cNf;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj axQ() {
        return this.cNb;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al axS() {
        if (this.cNb == null || this.cNb.feedBackReasonMap == null || this.cNb.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(axQ().getTid());
        alVar.setFid(axQ().getFid());
        alVar.setFeedBackReasonMap(this.cNb.feedBackReasonMap);
        alVar.cLA = this.cNb.mRecomAbTag;
        alVar.weight = this.cNb.mRecomWeight;
        alVar.extra = this.cNb.mRecomExtra;
        alVar.source = this.cNb.mRecomSource;
        alVar.cLB = this.cNb.cLB;
        alVar.cardType = this.cNb.aBY();
        return alVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String axR() {
        return this.cNb.cPt;
    }
}
