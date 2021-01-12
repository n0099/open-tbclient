package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class by extends a implements com.baidu.adp.widget.ListView.n {
    public bz eHK;
    public boolean eNF = false;
    public boolean eNG = false;
    public boolean eNH = false;
    public boolean eNI = false;
    public boolean eNJ = false;
    public boolean eNK = false;
    public boolean eNL = false;
    public boolean eNM = false;
    public boolean eNN = false;
    public boolean eNO = false;
    public boolean eNP = false;
    public boolean eNQ = false;
    public boolean eNR = false;
    public boolean eNS = false;
    public boolean eNT = false;
    public boolean eNU = false;
    public boolean eNV = false;
    public boolean eNW = false;
    public int eNX = 0;
    public int eNY = 0;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.eHK == null) {
            return null;
        }
        if (this.eHK.bpp()) {
            if (this.eHK.bnO() != null) {
                return bz.eOy;
            }
            return bz.eOa;
        }
        int bns = this.eHK.bns();
        if (this.eHK.threadType == 63) {
            bz bzVar = this.eHK;
            return bz.eOK;
        } else if (this.eHK.threadType == 64) {
            bz bzVar2 = this.eHK;
            return bz.eOL;
        } else if (this.eHK.threadType == 65) {
            bz bzVar3 = this.eHK;
            return bz.eOp;
        } else if (this.eHK.bnQ() != null && this.eHK.threadType == 60) {
            return bz.eOB;
        } else {
            if (this.eHK.bnQ() != null && this.eHK.threadType == 49) {
                return bz.eOz;
            }
            if (this.eHK.bnQ() != null && this.eHK.threadType == 67) {
                return bz.eOC;
            }
            if (this.eHK.threadType == 51) {
                return bz.eOA;
            }
            if (bns == 2 || bns == 1) {
                return bz.eNZ;
            }
            if (this.eHK.bnO() != null && this.eHK.boN() && !this.eHK.boE()) {
                return bz.eOQ;
            }
            if (this.eHK.isShareThread && this.eHK.eQQ != null) {
                if (this.eHK.eQQ.eMn) {
                    if (this.eHK.eQQ.videoInfo != null) {
                        return bz.eOG;
                    }
                    if (this.eHK.eQQ.bme()) {
                        return bz.eOF;
                    }
                    return bz.eOE;
                }
                return bz.eOD;
            } else if (this.eHK.boG()) {
                bz bzVar4 = this.eHK;
                return bz.eON.get() ? bz.eQd : bz.eOa;
            } else if (this.eHK.bol() && this.eHK.bok() == 1) {
                bz bzVar5 = this.eHK;
                return bz.eON.get() ? bz.eQl : bz.eOa;
            } else if (this.eHK.isLinkThread()) {
                return bz.eOw;
            } else {
                if (this.eHK.bph()) {
                    return this.eHK.bnf() != null ? bz.eOJ : bz.eOI;
                } else if (this.eHK.eRU != null && this.eHK.eRU.dKX()) {
                    return (this.eHK.eRU.dKW() == null && this.eHK.eRU.dKY()) ? AdvertAppInfo.eIZ : AdvertAppInfo.eJa;
                } else if (this.eNW) {
                    return bz.eOf;
                } else {
                    if (this.eNF) {
                        return bz.eOg;
                    }
                    if (this.eNG) {
                        return bz.eOh;
                    }
                    if (this.eNH) {
                        return bz.eOi;
                    }
                    if (this.eNI) {
                        return bz.eOj;
                    }
                    if (this.eNJ) {
                        return bz.eOk;
                    }
                    if (this.eNK) {
                        return bz.eOl;
                    }
                    if (this.eNL) {
                        return bz.eOm;
                    }
                    if (this.eNM) {
                        return bz.eOn;
                    }
                    if (this.eNN) {
                        return bz.eOy;
                    }
                    if (this.eNO) {
                        return bz.eOR;
                    }
                    if (this.eHK.bnA()) {
                        if (this.eNP) {
                            return bz.eOH;
                        }
                        return bz.eOx;
                    } else if (this.eNQ) {
                        return bz.eOM;
                    } else {
                        if (this.eNR) {
                            return bz.eOq;
                        }
                        if (this.eNS) {
                            return bz.eOr;
                        }
                        if (this.eNT) {
                            return bz.eOs;
                        }
                        if (this.eNU) {
                            return bz.eOt;
                        }
                        if (this.eNV) {
                            return bz.eOu;
                        }
                        return bz.eOa;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bz bkV() {
        return this.eHK;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at bkX() {
        if (this.eHK == null || this.eHK.feedBackReasonMap == null || this.eHK.feedBackReasonMap.size() <= 0) {
            return null;
        }
        at atVar = new at();
        atVar.setTid(bkV().getTid());
        atVar.setFid(bkV().getFid());
        atVar.setNid(bkV().blV());
        atVar.setFeedBackReasonMap(this.eHK.feedBackReasonMap);
        atVar.eMc = this.eHK.eMc;
        atVar.abTag = this.eHK.mRecomAbTag;
        atVar.weight = this.eHK.mRecomWeight;
        atVar.extra = this.eHK.mRecomExtra;
        atVar.source = this.eHK.mRecomSource;
        atVar.eMg = this.eHK.eMg;
        atVar.cardType = this.eHK.bpz();
        return atVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bkW() {
        return this.eHK.eQw;
    }
}
