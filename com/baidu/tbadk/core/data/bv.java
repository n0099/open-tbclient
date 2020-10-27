package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bv extends AbsThreadDataSupport implements com.baidu.adp.widget.ListView.q {
    public bw erH;
    public boolean exo = false;
    public boolean exp = false;
    public boolean exq = false;
    public boolean exr = false;
    public boolean exs = false;
    public boolean exu = false;
    public boolean exv = false;
    public boolean exw = false;
    public boolean exx = false;
    public boolean exy = false;
    public boolean exz = false;
    public boolean exA = false;
    public boolean exB = false;
    public boolean exC = false;
    public boolean exD = false;
    public boolean exE = false;
    public boolean exF = false;
    public int exG = 0;
    public int exH = 0;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.erH == null) {
            return null;
        }
        if (this.erH.blP()) {
            if (this.erH.bks() != null) {
                return bw.eyg;
            }
            return bw.exJ;
        }
        int bjV = this.erH.bjV();
        if (this.erH.threadType == 63) {
            bw bwVar = this.erH;
            return bw.eyt;
        } else if (this.erH.threadType == 64) {
            bw bwVar2 = this.erH;
            return bw.eyu;
        } else if (this.erH.threadType == 65) {
            bw bwVar3 = this.erH;
            return bw.exX;
        } else if (this.erH.bku() != null && this.erH.threadType == 60) {
            return bw.eyj;
        } else {
            if (this.erH.bku() != null && this.erH.threadType == 49) {
                return bw.eyh;
            }
            if (this.erH.bku() != null && this.erH.threadType == 67) {
                return bw.eyk;
            }
            if (this.erH.threadType == 51) {
                return bw.eyi;
            }
            if (bjV == 2 || bjV == 1) {
                return bw.exI;
            }
            if (this.erH.bks() != null && this.erH.bln() && !this.erH.blf()) {
                return bw.eyz;
            }
            if (this.erH.isShareThread && this.erH.eAy != null) {
                if (this.erH.eAy.evY) {
                    if (this.erH.eAy.videoInfo != null) {
                        return bw.eyp;
                    }
                    if (this.erH.eAy.biI()) {
                        return bw.eyo;
                    }
                    return bw.eyn;
                }
                return bw.eyl;
            } else if (this.erH.blh()) {
                bw bwVar4 = this.erH;
                return bw.eyw.get() ? bw.ezL : bw.exJ;
            } else if (this.erH.bkO() && this.erH.bkN() == 1) {
                bw bwVar5 = this.erH;
                return bw.eyw.get() ? bw.ezT : bw.exJ;
            } else if (this.erH.isLinkThread()) {
                return bw.eyd;
            } else {
                if (this.erH.blH()) {
                    return this.erH.bjI() != null ? bw.eys : bw.eyr;
                } else if (this.exF) {
                    return bw.exN;
                } else {
                    if (this.exo) {
                        return bw.exO;
                    }
                    if (this.exp) {
                        return bw.exP;
                    }
                    if (this.exq) {
                        return bw.exQ;
                    }
                    if (this.exr) {
                        return bw.exR;
                    }
                    if (this.exs) {
                        return bw.exS;
                    }
                    if (this.exu) {
                        return bw.exT;
                    }
                    if (this.exv) {
                        return bw.exU;
                    }
                    if (this.exw) {
                        return bw.exV;
                    }
                    if (this.exx) {
                        return bw.eyg;
                    }
                    if (this.erH.bkd()) {
                        if (this.exy) {
                            return bw.eyq;
                        }
                        return bw.eyf;
                    } else if (this.exz) {
                        return bw.eyv;
                    } else {
                        if (this.exA) {
                            return bw.exY;
                        }
                        if (this.exB) {
                            return bw.exZ;
                        }
                        if (this.exC) {
                            return bw.eya;
                        }
                        if (this.exD) {
                            return bw.eyb;
                        }
                        if (this.exE) {
                            return bw.eyc;
                        }
                        return bw.exJ;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bhz() {
        return this.erH;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bhB() {
        if (this.erH == null || this.erH.feedBackReasonMap == null || this.erH.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bhz().getTid());
        arVar.setFid(bhz().getFid());
        arVar.setNid(bhz().getNid());
        arVar.setFeedBackReasonMap(this.erH.feedBackReasonMap);
        arVar.evN = this.erH.evN;
        arVar.abTag = this.erH.mRecomAbTag;
        arVar.weight = this.erH.mRecomWeight;
        arVar.extra = this.erH.mRecomExtra;
        arVar.source = this.erH.mRecomSource;
        arVar.evR = this.erH.evR;
        arVar.cardType = this.erH.blZ();
        return arVar;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bhA() {
        return this.erH.eAe;
    }
}
