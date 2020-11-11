package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bv extends AbsThreadDataSupport implements com.baidu.adp.widget.ListView.q {
    public boolean eDg = false;
    public boolean eDh = false;
    public boolean eDi = false;
    public boolean eDj = false;
    public boolean eDk = false;
    public boolean eDl = false;
    public boolean eDm = false;
    public boolean eDn = false;
    public boolean eDo = false;
    public boolean eDp = false;
    public boolean eDq = false;
    public boolean eDr = false;
    public boolean eDs = false;
    public boolean eDt = false;
    public boolean eDu = false;
    public boolean eDv = false;
    public boolean eDw = false;
    public int eDx = 0;
    public int eDy = 0;
    public bw exA;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.exA == null) {
            return null;
        }
        if (this.exA.bop()) {
            if (this.exA.bmS() != null) {
                return bw.eDW;
            }
            return bw.eDA;
        }
        int bmv = this.exA.bmv();
        if (this.exA.threadType == 63) {
            bw bwVar = this.exA;
            return bw.eEi;
        } else if (this.exA.threadType == 64) {
            bw bwVar2 = this.exA;
            return bw.eEj;
        } else if (this.exA.threadType == 65) {
            bw bwVar3 = this.exA;
            return bw.eDO;
        } else if (this.exA.bmU() != null && this.exA.threadType == 60) {
            return bw.eDZ;
        } else {
            if (this.exA.bmU() != null && this.exA.threadType == 49) {
                return bw.eDX;
            }
            if (this.exA.bmU() != null && this.exA.threadType == 67) {
                return bw.eEa;
            }
            if (this.exA.threadType == 51) {
                return bw.eDY;
            }
            if (bmv == 2 || bmv == 1) {
                return bw.eDz;
            }
            if (this.exA.bmS() != null && this.exA.bnN() && !this.exA.bnF()) {
                return bw.eEo;
            }
            if (this.exA.isShareThread && this.exA.eGn != null) {
                if (this.exA.eGn.eBR) {
                    if (this.exA.eGn.videoInfo != null) {
                        return bw.eEe;
                    }
                    if (this.exA.eGn.bli()) {
                        return bw.eEd;
                    }
                    return bw.eEc;
                }
                return bw.eEb;
            } else if (this.exA.bnH()) {
                bw bwVar4 = this.exA;
                return bw.eEl.get() ? bw.eFA : bw.eDA;
            } else if (this.exA.bno() && this.exA.bnn() == 1) {
                bw bwVar5 = this.exA;
                return bw.eEl.get() ? bw.eFI : bw.eDA;
            } else if (this.exA.isLinkThread()) {
                return bw.eDU;
            } else {
                if (this.exA.boh()) {
                    return this.exA.bmi() != null ? bw.eEh : bw.eEg;
                } else if (this.eDw) {
                    return bw.eDE;
                } else {
                    if (this.eDg) {
                        return bw.eDF;
                    }
                    if (this.eDh) {
                        return bw.eDG;
                    }
                    if (this.eDi) {
                        return bw.eDH;
                    }
                    if (this.eDj) {
                        return bw.eDI;
                    }
                    if (this.eDk) {
                        return bw.eDJ;
                    }
                    if (this.eDl) {
                        return bw.eDK;
                    }
                    if (this.eDm) {
                        return bw.eDL;
                    }
                    if (this.eDn) {
                        return bw.eDM;
                    }
                    if (this.eDo) {
                        return bw.eDW;
                    }
                    if (this.exA.bmD()) {
                        if (this.eDp) {
                            return bw.eEf;
                        }
                        return bw.eDV;
                    } else if (this.eDq) {
                        return bw.eEk;
                    } else {
                        if (this.eDr) {
                            return bw.eDP;
                        }
                        if (this.eDs) {
                            return bw.eDQ;
                        }
                        if (this.eDt) {
                            return bw.eDR;
                        }
                        if (this.eDu) {
                            return bw.eDS;
                        }
                        if (this.eDv) {
                            return bw.eDT;
                        }
                        return bw.eDA;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bjZ() {
        return this.exA;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bkb() {
        if (this.exA == null || this.exA.feedBackReasonMap == null || this.exA.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bjZ().getTid());
        arVar.setFid(bjZ().getFid());
        arVar.setNid(bjZ().getNid());
        arVar.setFeedBackReasonMap(this.exA.feedBackReasonMap);
        arVar.eBG = this.exA.eBG;
        arVar.abTag = this.exA.mRecomAbTag;
        arVar.weight = this.exA.mRecomWeight;
        arVar.extra = this.exA.mRecomExtra;
        arVar.source = this.exA.mRecomSource;
        arVar.eBK = this.exA.eBK;
        arVar.cardType = this.exA.boz();
        return arVar;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bka() {
        return this.exA.eFT;
    }
}
