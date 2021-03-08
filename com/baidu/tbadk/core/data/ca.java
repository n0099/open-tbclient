package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ca extends a implements com.baidu.adp.widget.ListView.n {
    public cb eLr;
    public boolean eRs = false;
    public boolean eRt = false;
    public boolean eRu = false;
    public boolean eRv = false;
    public boolean eRw = false;
    public boolean eRx = false;
    public boolean eRy = false;
    public boolean eRz = false;
    public boolean eRA = false;
    public boolean eRB = false;
    public boolean eRC = false;
    public boolean eRD = false;
    public boolean eRE = false;
    public boolean eRF = false;
    public boolean eRG = false;
    public boolean eRH = false;
    public boolean eRI = false;
    public boolean eRJ = false;
    public int eRK = 0;
    public int eRL = 0;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.eLr == null) {
            return null;
        }
        if (this.eLr.bpJ()) {
            if (this.eLr.boj() != null) {
                return cb.eSl;
            }
            return cb.eRN;
        }
        int bnN = this.eLr.bnN();
        if (this.eLr.threadType == 63) {
            cb cbVar = this.eLr;
            return cb.eSx;
        } else if (this.eLr.threadType == 64) {
            cb cbVar2 = this.eLr;
            return cb.eSy;
        } else if (this.eLr.threadType == 65) {
            cb cbVar3 = this.eLr;
            return cb.eSc;
        } else if (this.eLr.bol() != null && this.eLr.threadType == 60) {
            return cb.eSo;
        } else {
            if (this.eLr.bol() != null && this.eLr.threadType == 49) {
                return cb.eSm;
            }
            if (this.eLr.bol() != null && this.eLr.threadType == 67) {
                return cb.eSp;
            }
            if (this.eLr.threadType == 51) {
                return cb.eSn;
            }
            if (bnN == 2 || bnN == 1) {
                return cb.eRM;
            }
            if (this.eLr.boj() != null && this.eLr.bph() && !this.eLr.boY()) {
                return cb.eSD;
            }
            if (this.eLr.isShareThread && this.eLr.eUD != null) {
                if (this.eLr.eUD.eQa) {
                    if (this.eLr.eUD.videoInfo != null) {
                        return cb.eSt;
                    }
                    if (this.eLr.eUD.bmz()) {
                        return cb.eSs;
                    }
                    return cb.eSr;
                }
                return cb.eSq;
            } else if (this.eLr.bpa()) {
                cb cbVar4 = this.eLr;
                return cb.eSA.get() ? cb.eTQ : cb.eRN;
            } else if (this.eLr.boF() && this.eLr.boE() == 1) {
                cb cbVar5 = this.eLr;
                return cb.eSA.get() ? cb.eTY : cb.eRN;
            } else if (this.eLr.isLinkThread()) {
                return cb.eSj;
            } else {
                if (this.eLr.bpB()) {
                    return this.eLr.bnA() != null ? cb.eSw : cb.eSv;
                } else if (this.eLr.eVH != null && this.eLr.eVH.dNx()) {
                    return this.eLr.eVH.dNy() ? AdvertAppInfo.eMM : AdvertAppInfo.eMN;
                } else if (this.eRJ) {
                    return cb.eRS;
                } else {
                    if (this.eRs) {
                        return cb.eRT;
                    }
                    if (this.eRt) {
                        return cb.eRU;
                    }
                    if (this.eRu) {
                        return cb.eRV;
                    }
                    if (this.eRv) {
                        return cb.eRW;
                    }
                    if (this.eRw) {
                        return cb.eRX;
                    }
                    if (this.eRx) {
                        return cb.eRY;
                    }
                    if (this.eRy) {
                        return cb.eRZ;
                    }
                    if (this.eRz) {
                        return cb.eSa;
                    }
                    if (this.eRA) {
                        return cb.eSl;
                    }
                    if (this.eRB) {
                        return cb.eSE;
                    }
                    if (this.eLr.bnV()) {
                        if (this.eRC) {
                            return cb.eSu;
                        }
                        return cb.eSk;
                    } else if (this.eRD) {
                        return cb.eSz;
                    } else {
                        if (this.eRE) {
                            return cb.eSd;
                        }
                        if (this.eRF) {
                            return cb.eSe;
                        }
                        if (this.eRG) {
                            return cb.eSf;
                        }
                        if (this.eRH) {
                            return cb.eSg;
                        }
                        if (this.eRI) {
                            return cb.eSh;
                        }
                        return cb.eRN;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public cb blp() {
        return this.eLr;
    }

    @Override // com.baidu.tbadk.core.data.a
    public av blr() {
        if (this.eLr == null || this.eLr.feedBackReasonMap == null || this.eLr.feedBackReasonMap.size() <= 0) {
            return null;
        }
        av avVar = new av();
        avVar.setTid(blp().getTid());
        avVar.setFid(blp().getFid());
        avVar.setNid(blp().bmq());
        avVar.setFeedBackReasonMap(this.eLr.feedBackReasonMap);
        avVar.ePP = this.eLr.ePP;
        avVar.abTag = this.eLr.mRecomAbTag;
        avVar.weight = this.eLr.mRecomWeight;
        avVar.extra = this.eLr.mRecomExtra;
        avVar.source = this.eLr.mRecomSource;
        avVar.ePT = this.eLr.ePT;
        avVar.cardType = this.eLr.bpT();
        return avVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String blq() {
        return this.eLr.eUj;
    }
}
