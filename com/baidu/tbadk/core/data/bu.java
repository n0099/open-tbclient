package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bu extends AbsThreadDataSupport implements com.baidu.adp.widget.ListView.q {
    public bv dLK;
    public boolean dRe = false;
    public boolean dRf = false;
    public boolean dRg = false;
    public boolean dRh = false;
    public boolean dRi = false;
    public boolean dRj = false;
    public boolean dRk = false;
    public boolean dRl = false;
    public boolean dRm = false;
    public boolean dRn = false;
    public boolean dRo = false;
    public boolean dRp = false;
    public boolean dRq = false;
    public boolean dRr = false;
    public boolean dRs = false;
    public boolean dRt = false;
    public int dRu = 0;
    public int dRv = 0;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dLK == null) {
            return null;
        }
        if (this.dLK.aYa()) {
            if (this.dLK.aWD() != null) {
                return bv.dRS;
            }
            return bv.dRx;
        }
        int aWg = this.dLK.aWg();
        if (this.dLK.threadType == 63) {
            bv bvVar = this.dLK;
            return bv.dSd;
        } else if (this.dLK.threadType == 64) {
            bv bvVar2 = this.dLK;
            return bv.dSe;
        } else if (this.dLK.threadType == 65) {
            bv bvVar3 = this.dLK;
            return bv.dRK;
        } else if (this.dLK.aWF() != null && this.dLK.threadType == 60) {
            return bv.dRV;
        } else {
            if (this.dLK.aWF() != null && this.dLK.threadType == 49) {
                return bv.dRT;
            }
            if (this.dLK.threadType == 51) {
                return bv.dRU;
            }
            if (aWg == 2 || aWg == 1) {
                return bv.dRw;
            }
            if (this.dLK.aWD() != null && this.dLK.aXy() && !this.dLK.aXq()) {
                return bv.dSj;
            }
            if (this.dLK.isShareThread && this.dLK.dUi != null) {
                if (this.dLK.dUi.dPP) {
                    if (this.dLK.dUi.videoInfo != null) {
                        return bv.dRZ;
                    }
                    if (this.dLK.dUi.aUT()) {
                        return bv.dRY;
                    }
                    return bv.dRX;
                }
                return bv.dRW;
            } else if (this.dLK.aXs()) {
                bv bvVar4 = this.dLK;
                return bv.dSg.get() ? bv.dTv : bv.dRx;
            } else if (this.dLK.aWZ() && this.dLK.aWY() == 1) {
                bv bvVar5 = this.dLK;
                return bv.dSg.get() ? bv.dTD : bv.dRx;
            } else if (this.dLK.isLinkThread()) {
                return bv.dRQ;
            } else {
                if (this.dLK.aXS()) {
                    return this.dLK.aVT() != null ? bv.dSc : bv.dSb;
                } else if (this.dRe) {
                    return bv.dRB;
                } else {
                    if (this.dRf) {
                        return bv.dRC;
                    }
                    if (this.dRg) {
                        return bv.dRD;
                    }
                    if (this.dRh) {
                        return bv.dRE;
                    }
                    if (this.dRi) {
                        return bv.dRF;
                    }
                    if (this.dRj) {
                        return bv.dRG;
                    }
                    if (this.dRk) {
                        return bv.dRH;
                    }
                    if (this.dRl) {
                        return bv.dRI;
                    }
                    if (this.dRm) {
                        return bv.dRS;
                    }
                    if (this.dLK.aWo()) {
                        if (this.dRn) {
                            return bv.dSa;
                        }
                        return bv.dRR;
                    } else if (this.dRo) {
                        return bv.dSf;
                    } else {
                        if (this.dRp) {
                            return bv.dRL;
                        }
                        if (this.dRq) {
                            return bv.dRM;
                        }
                        if (this.dRr) {
                            return bv.dRN;
                        }
                        if (this.dRs) {
                            return bv.dRO;
                        }
                        if (this.dRt) {
                            return bv.dRP;
                        }
                        return bv.dRx;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bv aTN() {
        return this.dLK;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public aq aTP() {
        if (this.dLK == null || this.dLK.feedBackReasonMap == null || this.dLK.feedBackReasonMap.size() <= 0) {
            return null;
        }
        aq aqVar = new aq();
        aqVar.setTid(aTN().getTid());
        aqVar.setFid(aTN().getFid());
        aqVar.setNid(aTN().getNid());
        aqVar.setFeedBackReasonMap(this.dLK.feedBackReasonMap);
        aqVar.dPE = this.dLK.dPE;
        aqVar.abTag = this.dLK.mRecomAbTag;
        aqVar.weight = this.dLK.mRecomWeight;
        aqVar.extra = this.dLK.mRecomExtra;
        aqVar.source = this.dLK.mRecomSource;
        aqVar.dPI = this.dLK.dPI;
        aqVar.cardType = this.dLK.aYk();
        return aqVar;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String aTO() {
        return this.dLK.dTO;
    }
}
