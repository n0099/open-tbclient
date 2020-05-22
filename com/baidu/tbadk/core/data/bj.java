package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bj extends AbsThreadDataSupport implements com.baidu.adp.widget.ListView.o {
    public bk dEA;
    public boolean dEo = false;
    public boolean dEp = false;
    public boolean dEq = false;
    public boolean dEr = false;
    public boolean dEs = false;
    public boolean dEt = false;
    public boolean dEu = false;
    public boolean dEv = false;
    public boolean dEw = false;
    public boolean dEx = false;
    public boolean dEy = false;
    public boolean dEz = false;
    public int dEB = 0;
    public int dEC = 0;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        if (this.dEA == null) {
            return null;
        }
        if (this.dEA.aSn()) {
            if (this.dEA.aQQ() != null) {
                return bk.dEV;
            }
            return bk.dEE;
        }
        int aQs = this.dEA.aQs();
        if (this.dEA.aQQ() != null && this.dEA.aSg()) {
            return bk.dFn;
        }
        if (this.dEA.threadType == 63) {
            bk bkVar = this.dEA;
            return bk.dFg;
        } else if (this.dEA.threadType == 64) {
            bk bkVar2 = this.dEA;
            return bk.dFh;
        } else if (this.dEA.threadType == 65) {
            bk bkVar3 = this.dEA;
            return bk.dER;
        } else if (this.dEA.aQS() != null && this.dEA.threadType == 60) {
            return bk.dEY;
        } else {
            if (this.dEA.aQS() != null && this.dEA.threadType == 49) {
                return bk.dEW;
            }
            if (this.dEA.threadType == 51) {
                return bk.dEX;
            }
            if (aQs == 2 || aQs == 1) {
                return bk.dED;
            }
            if (this.dEA.aQQ() != null && this.dEA.aRL() && !this.dEA.aRD()) {
                return bk.dFm;
            }
            if (this.dEA.isShareThread && this.dEA.dHm != null) {
                if (this.dEA.dHm.dDi) {
                    if (this.dEA.dHm.videoInfo != null) {
                        return bk.dFc;
                    }
                    if (this.dEA.dHm.aPm()) {
                        return bk.dFb;
                    }
                    return bk.dFa;
                }
                return bk.dEZ;
            } else if (this.dEA.aRF()) {
                bk bkVar4 = this.dEA;
                return bk.dFj.get() ? bk.dGz : bk.dEE;
            } else if (this.dEA.aRm() && this.dEA.aRl() == 1) {
                bk bkVar5 = this.dEA;
                return bk.dFj.get() ? bk.dGH : bk.dEE;
            } else if (this.dEA.isLinkThread()) {
                return bk.dET;
            } else {
                if (this.dEA.aSf()) {
                    return this.dEA.aQf() != null ? bk.dFf : bk.dFe;
                } else if (this.dEo) {
                    return bk.dEI;
                } else {
                    if (this.dEp) {
                        return bk.dEJ;
                    }
                    if (this.dEq) {
                        return bk.dEK;
                    }
                    if (this.dEr) {
                        return bk.dEL;
                    }
                    if (this.dEs) {
                        return bk.dEM;
                    }
                    if (this.dEt) {
                        return bk.dEN;
                    }
                    if (this.dEu) {
                        return bk.dEO;
                    }
                    if (this.dEv) {
                        return bk.dEP;
                    }
                    if (this.dEw) {
                        return bk.dEV;
                    }
                    if (this.dEA.aQA()) {
                        if (this.dEx) {
                            return bk.dFd;
                        }
                        return bk.dEU;
                    } else if (this.dEy) {
                        return bk.dFi;
                    } else {
                        if (this.dEz) {
                            return bk.dES;
                        }
                        return bk.dEE;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bk aOi() {
        return this.dEA;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ak aOk() {
        if (this.dEA == null || this.dEA.feedBackReasonMap == null || this.dEA.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ak akVar = new ak();
        akVar.setTid(aOi().getTid());
        akVar.setFid(aOi().getFid());
        akVar.setNid(aOi().getNid());
        akVar.setFeedBackReasonMap(this.dEA.feedBackReasonMap);
        akVar.abTag = this.dEA.mRecomAbTag;
        akVar.weight = this.dEA.mRecomWeight;
        akVar.extra = this.dEA.mRecomExtra;
        akVar.source = this.dEA.mRecomSource;
        akVar.dDb = this.dEA.dDb;
        akVar.cardType = this.dEA.aSA();
        return akVar;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String aOj() {
        return this.dEA.dGS;
    }
}
