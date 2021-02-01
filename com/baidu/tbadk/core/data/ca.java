package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ca extends a implements com.baidu.adp.widget.ListView.n {
    public cb eJQ;
    public boolean ePR = false;
    public boolean ePS = false;
    public boolean ePT = false;
    public boolean ePU = false;
    public boolean ePV = false;
    public boolean ePW = false;
    public boolean ePX = false;
    public boolean ePY = false;
    public boolean ePZ = false;
    public boolean eQa = false;
    public boolean eQb = false;
    public boolean eQc = false;
    public boolean eQd = false;
    public boolean eQe = false;
    public boolean eQf = false;
    public boolean eQg = false;
    public boolean eQh = false;
    public boolean eQi = false;
    public int eQj = 0;
    public int eQk = 0;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.eJQ == null) {
            return null;
        }
        if (this.eJQ.bpH()) {
            if (this.eJQ.boh() != null) {
                return cb.eQK;
            }
            return cb.eQm;
        }
        int bnL = this.eJQ.bnL();
        if (this.eJQ.threadType == 63) {
            cb cbVar = this.eJQ;
            return cb.eQW;
        } else if (this.eJQ.threadType == 64) {
            cb cbVar2 = this.eJQ;
            return cb.eQX;
        } else if (this.eJQ.threadType == 65) {
            cb cbVar3 = this.eJQ;
            return cb.eQB;
        } else if (this.eJQ.boj() != null && this.eJQ.threadType == 60) {
            return cb.eQN;
        } else {
            if (this.eJQ.boj() != null && this.eJQ.threadType == 49) {
                return cb.eQL;
            }
            if (this.eJQ.boj() != null && this.eJQ.threadType == 67) {
                return cb.eQO;
            }
            if (this.eJQ.threadType == 51) {
                return cb.eQM;
            }
            if (bnL == 2 || bnL == 1) {
                return cb.eQl;
            }
            if (this.eJQ.boh() != null && this.eJQ.bpf() && !this.eJQ.boW()) {
                return cb.eRc;
            }
            if (this.eJQ.isShareThread && this.eJQ.eTc != null) {
                if (this.eJQ.eTc.eOz) {
                    if (this.eJQ.eTc.videoInfo != null) {
                        return cb.eQS;
                    }
                    if (this.eJQ.eTc.bmx()) {
                        return cb.eQR;
                    }
                    return cb.eQQ;
                }
                return cb.eQP;
            } else if (this.eJQ.boY()) {
                cb cbVar4 = this.eJQ;
                return cb.eQZ.get() ? cb.eSp : cb.eQm;
            } else if (this.eJQ.boD() && this.eJQ.boC() == 1) {
                cb cbVar5 = this.eJQ;
                return cb.eQZ.get() ? cb.eSx : cb.eQm;
            } else if (this.eJQ.isLinkThread()) {
                return cb.eQI;
            } else {
                if (this.eJQ.bpz()) {
                    return this.eJQ.bny() != null ? cb.eQV : cb.eQU;
                } else if (this.eJQ.eUi != null && this.eJQ.eUi.dNi()) {
                    return (this.eJQ.eUi.dNh() == null && this.eJQ.eUi.dNj()) ? AdvertAppInfo.eLl : AdvertAppInfo.eLm;
                } else if (this.eQi) {
                    return cb.eQr;
                } else {
                    if (this.ePR) {
                        return cb.eQs;
                    }
                    if (this.ePS) {
                        return cb.eQt;
                    }
                    if (this.ePT) {
                        return cb.eQu;
                    }
                    if (this.ePU) {
                        return cb.eQv;
                    }
                    if (this.ePV) {
                        return cb.eQw;
                    }
                    if (this.ePW) {
                        return cb.eQx;
                    }
                    if (this.ePX) {
                        return cb.eQy;
                    }
                    if (this.ePY) {
                        return cb.eQz;
                    }
                    if (this.ePZ) {
                        return cb.eQK;
                    }
                    if (this.eQa) {
                        return cb.eRd;
                    }
                    if (this.eJQ.bnT()) {
                        if (this.eQb) {
                            return cb.eQT;
                        }
                        return cb.eQJ;
                    } else if (this.eQc) {
                        return cb.eQY;
                    } else {
                        if (this.eQd) {
                            return cb.eQC;
                        }
                        if (this.eQe) {
                            return cb.eQD;
                        }
                        if (this.eQf) {
                            return cb.eQE;
                        }
                        if (this.eQg) {
                            return cb.eQF;
                        }
                        if (this.eQh) {
                            return cb.eQG;
                        }
                        return cb.eQm;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public cb bln() {
        return this.eJQ;
    }

    @Override // com.baidu.tbadk.core.data.a
    public av blp() {
        if (this.eJQ == null || this.eJQ.feedBackReasonMap == null || this.eJQ.feedBackReasonMap.size() <= 0) {
            return null;
        }
        av avVar = new av();
        avVar.setTid(bln().getTid());
        avVar.setFid(bln().getFid());
        avVar.setNid(bln().bmo());
        avVar.setFeedBackReasonMap(this.eJQ.feedBackReasonMap);
        avVar.eOo = this.eJQ.eOo;
        avVar.abTag = this.eJQ.mRecomAbTag;
        avVar.weight = this.eJQ.mRecomWeight;
        avVar.extra = this.eJQ.mRecomExtra;
        avVar.source = this.eJQ.mRecomSource;
        avVar.eOs = this.eJQ.eOs;
        avVar.cardType = this.eJQ.bpR();
        return avVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String blo() {
        return this.eJQ.eSI;
    }
}
