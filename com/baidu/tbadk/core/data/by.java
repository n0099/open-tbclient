package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class by extends a implements com.baidu.adp.widget.ListView.n {
    public bz eMv;
    public boolean eSq = false;
    public boolean eSr = false;
    public boolean eSs = false;
    public boolean eSt = false;
    public boolean eSu = false;
    public boolean eSv = false;
    public boolean eSw = false;
    public boolean eSx = false;
    public boolean eSy = false;
    public boolean eSz = false;
    public boolean eSA = false;
    public boolean eSB = false;
    public boolean eSC = false;
    public boolean eSD = false;
    public boolean eSE = false;
    public boolean eSF = false;
    public boolean eSG = false;
    public boolean eSH = false;
    public int eSI = 0;
    public int eSJ = 0;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.eMv == null) {
            return null;
        }
        if (this.eMv.bti()) {
            if (this.eMv.brH() != null) {
                return bz.eTj;
            }
            return bz.eSL;
        }
        int brl = this.eMv.brl();
        if (this.eMv.threadType == 63) {
            bz bzVar = this.eMv;
            return bz.eTv;
        } else if (this.eMv.threadType == 64) {
            bz bzVar2 = this.eMv;
            return bz.eTw;
        } else if (this.eMv.threadType == 65) {
            bz bzVar3 = this.eMv;
            return bz.eTa;
        } else if (this.eMv.brJ() != null && this.eMv.threadType == 60) {
            return bz.eTm;
        } else {
            if (this.eMv.brJ() != null && this.eMv.threadType == 49) {
                return bz.eTk;
            }
            if (this.eMv.brJ() != null && this.eMv.threadType == 67) {
                return bz.eTn;
            }
            if (this.eMv.threadType == 51) {
                return bz.eTl;
            }
            if (brl == 2 || brl == 1) {
                return bz.eSK;
            }
            if (this.eMv.brH() != null && this.eMv.bsG() && !this.eMv.bsx()) {
                return bz.eTB;
            }
            if (this.eMv.isShareThread && this.eMv.eVB != null) {
                if (this.eMv.eVB.eQY) {
                    if (this.eMv.eVB.videoInfo != null) {
                        return bz.eTr;
                    }
                    if (this.eMv.eVB.bpX()) {
                        return bz.eTq;
                    }
                    return bz.eTp;
                }
                return bz.eTo;
            } else if (this.eMv.bsz()) {
                bz bzVar4 = this.eMv;
                return bz.eTy.get() ? bz.eUO : bz.eSL;
            } else if (this.eMv.bse() && this.eMv.bsd() == 1) {
                bz bzVar5 = this.eMv;
                return bz.eTy.get() ? bz.eUW : bz.eSL;
            } else if (this.eMv.isLinkThread()) {
                return bz.eTh;
            } else {
                if (this.eMv.bta()) {
                    return this.eMv.bqY() != null ? bz.eTu : bz.eTt;
                } else if (this.eMv.eWF != null && this.eMv.eWF.dOO()) {
                    return (this.eMv.eWF.dON() == null && this.eMv.eWF.dOP()) ? AdvertAppInfo.eNK : AdvertAppInfo.eNL;
                } else if (this.eSH) {
                    return bz.eSQ;
                } else {
                    if (this.eSq) {
                        return bz.eSR;
                    }
                    if (this.eSr) {
                        return bz.eSS;
                    }
                    if (this.eSs) {
                        return bz.eST;
                    }
                    if (this.eSt) {
                        return bz.eSU;
                    }
                    if (this.eSu) {
                        return bz.eSV;
                    }
                    if (this.eSv) {
                        return bz.eSW;
                    }
                    if (this.eSw) {
                        return bz.eSX;
                    }
                    if (this.eSx) {
                        return bz.eSY;
                    }
                    if (this.eSy) {
                        return bz.eTj;
                    }
                    if (this.eSz) {
                        return bz.eTC;
                    }
                    if (this.eMv.brt()) {
                        if (this.eSA) {
                            return bz.eTs;
                        }
                        return bz.eTi;
                    } else if (this.eSB) {
                        return bz.eTx;
                    } else {
                        if (this.eSC) {
                            return bz.eTb;
                        }
                        if (this.eSD) {
                            return bz.eTc;
                        }
                        if (this.eSE) {
                            return bz.eTd;
                        }
                        if (this.eSF) {
                            return bz.eTe;
                        }
                        if (this.eSG) {
                            return bz.eTf;
                        }
                        return bz.eSL;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bz boO() {
        return this.eMv;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at boQ() {
        if (this.eMv == null || this.eMv.feedBackReasonMap == null || this.eMv.feedBackReasonMap.size() <= 0) {
            return null;
        }
        at atVar = new at();
        atVar.setTid(boO().getTid());
        atVar.setFid(boO().getFid());
        atVar.setNid(boO().bpO());
        atVar.setFeedBackReasonMap(this.eMv.feedBackReasonMap);
        atVar.eQN = this.eMv.eQN;
        atVar.abTag = this.eMv.mRecomAbTag;
        atVar.weight = this.eMv.mRecomWeight;
        atVar.extra = this.eMv.mRecomExtra;
        atVar.source = this.eMv.mRecomSource;
        atVar.eQR = this.eMv.eQR;
        atVar.cardType = this.eMv.bts();
        return atVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String boP() {
        return this.eMv.eVh;
    }
}
