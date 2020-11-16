package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bw extends a implements com.baidu.adp.widget.ListView.q {
    public bx evQ;
    public boolean eBx = false;
    public boolean eBy = false;
    public boolean eBz = false;
    public boolean eBA = false;
    public boolean eBB = false;
    public boolean eBC = false;
    public boolean eBD = false;
    public boolean eBE = false;
    public boolean eBF = false;
    public boolean eBG = false;
    public boolean eBH = false;
    public boolean eBI = false;
    public boolean eBJ = false;
    public boolean eBK = false;
    public boolean eBL = false;
    public boolean eBM = false;
    public boolean eBN = false;
    public int eBO = 0;
    public int eBP = 0;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.evQ == null) {
            return null;
        }
        if (this.evQ.bnt()) {
            if (this.evQ.blU() != null) {
                return bx.eCo;
            }
            return bx.eBR;
        }
        int blx = this.evQ.blx();
        if (this.evQ.threadType == 63) {
            bx bxVar = this.evQ;
            return bx.eCA;
        } else if (this.evQ.threadType == 64) {
            bx bxVar2 = this.evQ;
            return bx.eCB;
        } else if (this.evQ.threadType == 65) {
            bx bxVar3 = this.evQ;
            return bx.eCg;
        } else if (this.evQ.blW() != null && this.evQ.threadType == 60) {
            return bx.eCr;
        } else {
            if (this.evQ.blW() != null && this.evQ.threadType == 49) {
                return bx.eCp;
            }
            if (this.evQ.blW() != null && this.evQ.threadType == 67) {
                return bx.eCs;
            }
            if (this.evQ.threadType == 51) {
                return bx.eCq;
            }
            if (blx == 2 || blx == 1) {
                return bx.eBQ;
            }
            if (this.evQ.blU() != null && this.evQ.bmR() && !this.evQ.bmJ()) {
                return bx.eCG;
            }
            if (this.evQ.isShareThread && this.evQ.eEF != null) {
                if (this.evQ.eEF.eAi) {
                    if (this.evQ.eEF.videoInfo != null) {
                        return bx.eCw;
                    }
                    if (this.evQ.eEF.bkk()) {
                        return bx.eCv;
                    }
                    return bx.eCu;
                }
                return bx.eCt;
            } else if (this.evQ.bmL()) {
                bx bxVar4 = this.evQ;
                return bx.eCD.get() ? bx.eDS : bx.eBR;
            } else if (this.evQ.bmq() && this.evQ.bmp() == 1) {
                bx bxVar5 = this.evQ;
                return bx.eCD.get() ? bx.eEa : bx.eBR;
            } else if (this.evQ.isLinkThread()) {
                return bx.eCm;
            } else {
                if (this.evQ.bnl()) {
                    return this.evQ.blk() != null ? bx.eCz : bx.eCy;
                } else if (this.eBN) {
                    return bx.eBW;
                } else {
                    if (this.eBx) {
                        return bx.eBX;
                    }
                    if (this.eBy) {
                        return bx.eBY;
                    }
                    if (this.eBz) {
                        return bx.eBZ;
                    }
                    if (this.eBA) {
                        return bx.eCa;
                    }
                    if (this.eBB) {
                        return bx.eCb;
                    }
                    if (this.eBC) {
                        return bx.eCc;
                    }
                    if (this.eBD) {
                        return bx.eCd;
                    }
                    if (this.eBE) {
                        return bx.eCe;
                    }
                    if (this.eBF) {
                        return bx.eCo;
                    }
                    if (this.evQ.blF()) {
                        if (this.eBG) {
                            return bx.eCx;
                        }
                        return bx.eCn;
                    } else if (this.eBH) {
                        return bx.eCC;
                    } else {
                        if (this.eBI) {
                            return bx.eCh;
                        }
                        if (this.eBJ) {
                            return bx.eCi;
                        }
                        if (this.eBK) {
                            return bx.eCj;
                        }
                        if (this.eBL) {
                            return bx.eCk;
                        }
                        if (this.eBM) {
                            return bx.eCl;
                        }
                        return bx.eBR;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bx bjd() {
        return this.evQ;
    }

    @Override // com.baidu.tbadk.core.data.a
    public as bjf() {
        if (this.evQ == null || this.evQ.feedBackReasonMap == null || this.evQ.feedBackReasonMap.size() <= 0) {
            return null;
        }
        as asVar = new as();
        asVar.setTid(bjd().getTid());
        asVar.setFid(bjd().getFid());
        asVar.setNid(bjd().getNid());
        asVar.setFeedBackReasonMap(this.evQ.feedBackReasonMap);
        asVar.ezX = this.evQ.ezX;
        asVar.abTag = this.evQ.mRecomAbTag;
        asVar.weight = this.evQ.mRecomWeight;
        asVar.extra = this.evQ.mRecomExtra;
        asVar.source = this.evQ.mRecomSource;
        asVar.eAb = this.evQ.eAb;
        asVar.cardType = this.evQ.bnD();
        return asVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bje() {
        return this.evQ.eEl;
    }
}
