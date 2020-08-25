package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class bv extends AbsThreadDataSupport implements com.baidu.adp.widget.ListView.q {
    public bw dUS;
    public boolean eay = false;
    public boolean eaz = false;
    public boolean eaA = false;
    public boolean eaB = false;
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
    public int eaP = 0;
    public int eaQ = 0;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dUS == null) {
            return null;
        }
        if (this.dUS.bgt()) {
            if (this.dUS.beW() != null) {
                return bw.ebo;
            }
            return bw.eaS;
        }
        int bez = this.dUS.bez();
        if (this.dUS.threadType == 63) {
            bw bwVar = this.dUS;
            return bw.ebz;
        } else if (this.dUS.threadType == 64) {
            bw bwVar2 = this.dUS;
            return bw.ebA;
        } else if (this.dUS.threadType == 65) {
            bw bwVar3 = this.dUS;
            return bw.ebg;
        } else if (this.dUS.beY() != null && this.dUS.threadType == 60) {
            return bw.ebr;
        } else {
            if (this.dUS.beY() != null && this.dUS.threadType == 49) {
                return bw.ebp;
            }
            if (this.dUS.threadType == 51) {
                return bw.ebq;
            }
            if (bez == 2 || bez == 1) {
                return bw.eaR;
            }
            if (this.dUS.beW() != null && this.dUS.bfR() && !this.dUS.bfJ()) {
                return bw.ebF;
            }
            if (this.dUS.isShareThread && this.dUS.edE != null) {
                if (this.dUS.edE.dZi) {
                    if (this.dUS.edE.videoInfo != null) {
                        return bw.ebv;
                    }
                    if (this.dUS.edE.bdm()) {
                        return bw.ebu;
                    }
                    return bw.ebt;
                }
                return bw.ebs;
            } else if (this.dUS.bfL()) {
                bw bwVar4 = this.dUS;
                return bw.ebC.get() ? bw.ecR : bw.eaS;
            } else if (this.dUS.bfs() && this.dUS.bfr() == 1) {
                bw bwVar5 = this.dUS;
                return bw.ebC.get() ? bw.ecZ : bw.eaS;
            } else if (this.dUS.isLinkThread()) {
                return bw.ebm;
            } else {
                if (this.dUS.bgl()) {
                    return this.dUS.bem() != null ? bw.eby : bw.ebx;
                } else if (this.eaO) {
                    return bw.eaW;
                } else {
                    if (this.eay) {
                        return bw.eaX;
                    }
                    if (this.eaz) {
                        return bw.eaY;
                    }
                    if (this.eaA) {
                        return bw.eaZ;
                    }
                    if (this.eaB) {
                        return bw.eba;
                    }
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
                        return bw.ebo;
                    }
                    if (this.dUS.beH()) {
                        if (this.eaH) {
                            return bw.ebw;
                        }
                        return bw.ebn;
                    } else if (this.eaI) {
                        return bw.ebB;
                    } else {
                        if (this.eaJ) {
                            return bw.ebh;
                        }
                        if (this.eaK) {
                            return bw.ebi;
                        }
                        if (this.eaL) {
                            return bw.ebj;
                        }
                        if (this.eaM) {
                            return bw.ebk;
                        }
                        if (this.eaN) {
                            return bw.ebl;
                        }
                        return bw.eaS;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        return this.dUS;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bcg() {
        if (this.dUS == null || this.dUS.feedBackReasonMap == null || this.dUS.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bce().getTid());
        arVar.setFid(bce().getFid());
        arVar.setNid(bce().getNid());
        arVar.setFeedBackReasonMap(this.dUS.feedBackReasonMap);
        arVar.dYX = this.dUS.dYX;
        arVar.abTag = this.dUS.mRecomAbTag;
        arVar.weight = this.dUS.mRecomWeight;
        arVar.extra = this.dUS.mRecomExtra;
        arVar.source = this.dUS.mRecomSource;
        arVar.dZb = this.dUS.dZb;
        arVar.cardType = this.dUS.bgD();
        return arVar;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bcf() {
        return this.dUS.edk;
    }
}
