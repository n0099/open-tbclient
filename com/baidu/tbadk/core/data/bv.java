package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bv extends AbsThreadDataSupport implements com.baidu.adp.widget.ListView.q {
    public bw eji;
    public boolean eoR = false;
    public boolean eoS = false;
    public boolean eoT = false;
    public boolean eoU = false;
    public boolean eoV = false;
    public boolean eoW = false;
    public boolean eoX = false;
    public boolean eoY = false;
    public boolean eoZ = false;
    public boolean epa = false;
    public boolean epb = false;
    public boolean epc = false;
    public boolean epd = false;
    public boolean epe = false;
    public boolean epf = false;
    public boolean epg = false;
    public boolean eph = false;
    public int epi = 0;
    public int epj = 0;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.eji == null) {
            return null;
        }
        if (this.eji.bjW()) {
            if (this.eji.biz() != null) {
                return bw.epH;
            }
            return bw.epl;
        }
        int bic = this.eji.bic();
        if (this.eji.threadType == 63) {
            bw bwVar = this.eji;
            return bw.epS;
        } else if (this.eji.threadType == 64) {
            bw bwVar2 = this.eji;
            return bw.epT;
        } else if (this.eji.threadType == 65) {
            bw bwVar3 = this.eji;
            return bw.epz;
        } else if (this.eji.biB() != null && this.eji.threadType == 60) {
            return bw.epK;
        } else {
            if (this.eji.biB() != null && this.eji.threadType == 49) {
                return bw.epI;
            }
            if (this.eji.threadType == 51) {
                return bw.epJ;
            }
            if (bic == 2 || bic == 1) {
                return bw.epk;
            }
            if (this.eji.biz() != null && this.eji.bju() && !this.eji.bjm()) {
                return bw.epY;
            }
            if (this.eji.isShareThread && this.eji.erY != null) {
                if (this.eji.erY.enA) {
                    if (this.eji.erY.videoInfo != null) {
                        return bw.epO;
                    }
                    if (this.eji.erY.bgP()) {
                        return bw.epN;
                    }
                    return bw.epM;
                }
                return bw.epL;
            } else if (this.eji.bjo()) {
                bw bwVar4 = this.eji;
                return bw.epV.get() ? bw.erk : bw.epl;
            } else if (this.eji.biV() && this.eji.biU() == 1) {
                bw bwVar5 = this.eji;
                return bw.epV.get() ? bw.ert : bw.epl;
            } else if (this.eji.isLinkThread()) {
                return bw.epF;
            } else {
                if (this.eji.bjO()) {
                    return this.eji.bhP() != null ? bw.epR : bw.epQ;
                } else if (this.eph) {
                    return bw.epp;
                } else {
                    if (this.eoR) {
                        return bw.epq;
                    }
                    if (this.eoS) {
                        return bw.epr;
                    }
                    if (this.eoT) {
                        return bw.eps;
                    }
                    if (this.eoU) {
                        return bw.ept;
                    }
                    if (this.eoV) {
                        return bw.epu;
                    }
                    if (this.eoW) {
                        return bw.epv;
                    }
                    if (this.eoX) {
                        return bw.epw;
                    }
                    if (this.eoY) {
                        return bw.epx;
                    }
                    if (this.eoZ) {
                        return bw.epH;
                    }
                    if (this.eji.bik()) {
                        if (this.epa) {
                            return bw.epP;
                        }
                        return bw.epG;
                    } else if (this.epb) {
                        return bw.epU;
                    } else {
                        if (this.epc) {
                            return bw.epA;
                        }
                        if (this.epd) {
                            return bw.epB;
                        }
                        if (this.epe) {
                            return bw.epC;
                        }
                        if (this.epf) {
                            return bw.epD;
                        }
                        if (this.epg) {
                            return bw.epE;
                        }
                        return bw.epl;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bfG() {
        return this.eji;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bfI() {
        if (this.eji == null || this.eji.feedBackReasonMap == null || this.eji.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bfG().getTid());
        arVar.setFid(bfG().getFid());
        arVar.setNid(bfG().getNid());
        arVar.setFeedBackReasonMap(this.eji.feedBackReasonMap);
        arVar.eno = this.eji.eno;
        arVar.abTag = this.eji.mRecomAbTag;
        arVar.weight = this.eji.mRecomWeight;
        arVar.extra = this.eji.mRecomExtra;
        arVar.source = this.eji.mRecomSource;
        arVar.ens = this.eji.ens;
        arVar.cardType = this.eji.bkg();
        return arVar;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bfH() {
        return this.eji.erE;
    }
}
