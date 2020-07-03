package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bt extends AbsThreadDataSupport implements com.baidu.adp.widget.ListView.q {
    public bu dLi;
    public boolean dKS = false;
    public boolean dKT = false;
    public boolean dKU = false;
    public boolean dKV = false;
    public boolean dKW = false;
    public boolean dKX = false;
    public boolean dKY = false;
    public boolean dKZ = false;
    public boolean dLa = false;
    public boolean dLb = false;
    public boolean dLc = false;
    public boolean dLd = false;
    public boolean dLe = false;
    public boolean dLf = false;
    public boolean dLg = false;
    public boolean dLh = false;
    public int dLj = 0;
    public int dLk = 0;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dLi == null) {
            return null;
        }
        if (this.dLi.aUe()) {
            if (this.dLi.aSH() != null) {
                return bu.dLH;
            }
            return bu.dLm;
        }
        int aSk = this.dLi.aSk();
        if (this.dLi.threadType == 63) {
            bu buVar = this.dLi;
            return bu.dLS;
        } else if (this.dLi.threadType == 64) {
            bu buVar2 = this.dLi;
            return bu.dLT;
        } else if (this.dLi.threadType == 65) {
            bu buVar3 = this.dLi;
            return bu.dLz;
        } else if (this.dLi.aSJ() != null && this.dLi.threadType == 60) {
            return bu.dLK;
        } else {
            if (this.dLi.aSJ() != null && this.dLi.threadType == 49) {
                return bu.dLI;
            }
            if (this.dLi.threadType == 51) {
                return bu.dLJ;
            }
            if (aSk == 2 || aSk == 1) {
                return bu.dLl;
            }
            if (this.dLi.aSH() != null && this.dLi.aTC() && !this.dLi.aTu()) {
                return bu.dLY;
            }
            if (this.dLi.isShareThread && this.dLi.dNX != null) {
                if (this.dLi.dNX.dJD) {
                    if (this.dLi.dNX.videoInfo != null) {
                        return bu.dLO;
                    }
                    if (this.dLi.dNX.aQX()) {
                        return bu.dLN;
                    }
                    return bu.dLM;
                }
                return bu.dLL;
            } else if (this.dLi.aTw()) {
                bu buVar4 = this.dLi;
                return bu.dLV.get() ? bu.dNk : bu.dLm;
            } else if (this.dLi.aTd() && this.dLi.aTc() == 1) {
                bu buVar5 = this.dLi;
                return bu.dLV.get() ? bu.dNs : bu.dLm;
            } else if (this.dLi.isLinkThread()) {
                return bu.dLF;
            } else {
                if (this.dLi.aTW()) {
                    return this.dLi.aRX() != null ? bu.dLR : bu.dLQ;
                } else if (this.dKS) {
                    return bu.dLq;
                } else {
                    if (this.dKT) {
                        return bu.dLr;
                    }
                    if (this.dKU) {
                        return bu.dLs;
                    }
                    if (this.dKV) {
                        return bu.dLt;
                    }
                    if (this.dKW) {
                        return bu.dLu;
                    }
                    if (this.dKX) {
                        return bu.dLv;
                    }
                    if (this.dKY) {
                        return bu.dLw;
                    }
                    if (this.dKZ) {
                        return bu.dLx;
                    }
                    if (this.dLa) {
                        return bu.dLH;
                    }
                    if (this.dLi.aSs()) {
                        if (this.dLb) {
                            return bu.dLP;
                        }
                        return bu.dLG;
                    } else if (this.dLc) {
                        return bu.dLU;
                    } else {
                        if (this.dLd) {
                            return bu.dLA;
                        }
                        if (this.dLe) {
                            return bu.dLB;
                        }
                        if (this.dLf) {
                            return bu.dLC;
                        }
                        if (this.dLg) {
                            return bu.dLD;
                        }
                        if (this.dLh) {
                            return bu.dLE;
                        }
                        return bu.dLm;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
        return this.dLi;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ap aPU() {
        if (this.dLi == null || this.dLi.feedBackReasonMap == null || this.dLi.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ap apVar = new ap();
        apVar.setTid(aPS().getTid());
        apVar.setFid(aPS().getFid());
        apVar.setNid(aPS().getNid());
        apVar.setFeedBackReasonMap(this.dLi.feedBackReasonMap);
        apVar.abTag = this.dLi.mRecomAbTag;
        apVar.weight = this.dLi.mRecomWeight;
        apVar.extra = this.dLi.mRecomExtra;
        apVar.source = this.dLi.mRecomSource;
        apVar.dJw = this.dLi.dJw;
        apVar.cardType = this.dLi.aUp();
        return apVar;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String aPT() {
        return this.dLi.dND;
    }
}
