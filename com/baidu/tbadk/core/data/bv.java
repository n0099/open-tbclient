package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bv extends AbsThreadDataSupport implements com.baidu.adp.widget.ListView.q {
    public bw dUW;
    public boolean eaC = false;
    public boolean eaD = false;
    public boolean eaE = false;
    public boolean eaF = false;
    public boolean eaG = false;
    public boolean eaH = false;
    public boolean eaI = false;
    public boolean eaJ = false;
    public boolean eaK = false;
    public boolean eaL = false;
    public boolean eaM = false;
    public boolean eaN = false;
    public boolean eaO = false;
    public boolean eaP = false;
    public boolean eaQ = false;
    public boolean eaR = false;
    public boolean eaS = false;
    public int eaT = 0;
    public int eaU = 0;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dUW == null) {
            return null;
        }
        if (this.dUW.bgt()) {
            if (this.dUW.beW() != null) {
                return bw.ebs;
            }
            return bw.eaW;
        }
        int bez = this.dUW.bez();
        if (this.dUW.threadType == 63) {
            bw bwVar = this.dUW;
            return bw.ebD;
        } else if (this.dUW.threadType == 64) {
            bw bwVar2 = this.dUW;
            return bw.ebE;
        } else if (this.dUW.threadType == 65) {
            bw bwVar3 = this.dUW;
            return bw.ebk;
        } else if (this.dUW.beY() != null && this.dUW.threadType == 60) {
            return bw.ebv;
        } else {
            if (this.dUW.beY() != null && this.dUW.threadType == 49) {
                return bw.ebt;
            }
            if (this.dUW.threadType == 51) {
                return bw.ebu;
            }
            if (bez == 2 || bez == 1) {
                return bw.eaV;
            }
            if (this.dUW.beW() != null && this.dUW.bfR() && !this.dUW.bfJ()) {
                return bw.ebJ;
            }
            if (this.dUW.isShareThread && this.dUW.edI != null) {
                if (this.dUW.edI.dZm) {
                    if (this.dUW.edI.videoInfo != null) {
                        return bw.ebz;
                    }
                    if (this.dUW.edI.bdm()) {
                        return bw.eby;
                    }
                    return bw.ebx;
                }
                return bw.ebw;
            } else if (this.dUW.bfL()) {
                bw bwVar4 = this.dUW;
                return bw.ebG.get() ? bw.ecV : bw.eaW;
            } else if (this.dUW.bfs() && this.dUW.bfr() == 1) {
                bw bwVar5 = this.dUW;
                return bw.ebG.get() ? bw.edd : bw.eaW;
            } else if (this.dUW.isLinkThread()) {
                return bw.ebq;
            } else {
                if (this.dUW.bgl()) {
                    return this.dUW.bem() != null ? bw.ebC : bw.ebB;
                } else if (this.eaS) {
                    return bw.eba;
                } else {
                    if (this.eaC) {
                        return bw.ebb;
                    }
                    if (this.eaD) {
                        return bw.ebc;
                    }
                    if (this.eaE) {
                        return bw.ebd;
                    }
                    if (this.eaF) {
                        return bw.ebe;
                    }
                    if (this.eaG) {
                        return bw.ebf;
                    }
                    if (this.eaH) {
                        return bw.ebg;
                    }
                    if (this.eaI) {
                        return bw.ebh;
                    }
                    if (this.eaJ) {
                        return bw.ebi;
                    }
                    if (this.eaK) {
                        return bw.ebs;
                    }
                    if (this.dUW.beH()) {
                        if (this.eaL) {
                            return bw.ebA;
                        }
                        return bw.ebr;
                    } else if (this.eaM) {
                        return bw.ebF;
                    } else {
                        if (this.eaN) {
                            return bw.ebl;
                        }
                        if (this.eaO) {
                            return bw.ebm;
                        }
                        if (this.eaP) {
                            return bw.ebn;
                        }
                        if (this.eaQ) {
                            return bw.ebo;
                        }
                        if (this.eaR) {
                            return bw.ebp;
                        }
                        return bw.eaW;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        return this.dUW;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bcg() {
        if (this.dUW == null || this.dUW.feedBackReasonMap == null || this.dUW.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bce().getTid());
        arVar.setFid(bce().getFid());
        arVar.setNid(bce().getNid());
        arVar.setFeedBackReasonMap(this.dUW.feedBackReasonMap);
        arVar.dZb = this.dUW.dZb;
        arVar.abTag = this.dUW.mRecomAbTag;
        arVar.weight = this.dUW.mRecomWeight;
        arVar.extra = this.dUW.mRecomExtra;
        arVar.source = this.dUW.mRecomSource;
        arVar.dZf = this.dUW.dZf;
        arVar.cardType = this.dUW.bgD();
        return arVar;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bcf() {
        return this.dUW.edo;
    }
}
