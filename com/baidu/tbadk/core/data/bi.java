package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bi extends a implements com.baidu.adp.widget.ListView.m {
    public bj dqE;
    public boolean dqs = false;
    public boolean dqt = false;
    public boolean dqu = false;
    public boolean dqv = false;
    public boolean dqw = false;
    public boolean dqx = false;
    public boolean dqy = false;
    public boolean dqz = false;
    public boolean dqA = false;
    public boolean dqB = false;
    public boolean dqC = false;
    public boolean dqD = false;
    public int dqF = 0;
    public int dqG = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.dqE == null) {
            return null;
        }
        if (this.dqE.aMo()) {
            if (this.dqE.aKT() != null) {
                return bj.dqZ;
            }
            return bj.dqI;
        }
        int aKx = this.dqE.aKx();
        if (this.dqE.aKT() != null && this.dqE.aMh()) {
            return bj.drr;
        }
        if (this.dqE.threadType == 63) {
            bj bjVar = this.dqE;
            return bj.drk;
        } else if (this.dqE.threadType == 64) {
            bj bjVar2 = this.dqE;
            return bj.drl;
        } else if (this.dqE.threadType == 65) {
            bj bjVar3 = this.dqE;
            return bj.dqV;
        } else if (this.dqE.aKV() != null && this.dqE.threadType == 60) {
            return bj.drc;
        } else {
            if (this.dqE.aKV() != null && this.dqE.threadType == 49) {
                return bj.dra;
            }
            if (this.dqE.threadType == 51) {
                return bj.drb;
            }
            if (aKx == 2 || aKx == 1) {
                return bj.dqH;
            }
            if (this.dqE.aKT() != null && this.dqE.aLM() && !this.dqE.aLE()) {
                return bj.drq;
            }
            if (this.dqE.isShareThread && this.dqE.dtt != null) {
                if (this.dqE.dtt.dpk) {
                    if (this.dqE.dtt.videoInfo != null) {
                        return bj.drg;
                    }
                    if (this.dqE.dtt.aJr()) {
                        return bj.drf;
                    }
                    return bj.dre;
                }
                return bj.drd;
            } else if (this.dqE.aLG()) {
                bj bjVar4 = this.dqE;
                return bj.drn.get() ? bj.dsF : bj.dqI;
            } else if (this.dqE.aLn() && this.dqE.aLm() == 1) {
                bj bjVar5 = this.dqE;
                return bj.drn.get() ? bj.dsN : bj.dqI;
            } else if (this.dqE.isLinkThread()) {
                return bj.dqX;
            } else {
                if (this.dqE.aMg()) {
                    return this.dqE.aKk() != null ? bj.drj : bj.dri;
                } else if (this.dqs) {
                    return bj.dqM;
                } else {
                    if (this.dqt) {
                        return bj.dqN;
                    }
                    if (this.dqu) {
                        return bj.dqO;
                    }
                    if (this.dqv) {
                        return bj.dqP;
                    }
                    if (this.dqw) {
                        return bj.dqQ;
                    }
                    if (this.dqx) {
                        return bj.dqR;
                    }
                    if (this.dqy) {
                        return bj.dqS;
                    }
                    if (this.dqz) {
                        return bj.dqT;
                    }
                    if (this.dqA) {
                        return bj.dqZ;
                    }
                    if (this.dqE.aKF()) {
                        if (this.dqB) {
                            return bj.drh;
                        }
                        return bj.dqY;
                    } else if (this.dqC) {
                        return bj.drm;
                    } else {
                        if (this.dqD) {
                            return bj.dqW;
                        }
                        return bj.dqI;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aIu() {
        return this.dqE;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aIw() {
        if (this.dqE == null || this.dqE.feedBackReasonMap == null || this.dqE.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aIu().getTid());
        alVar.setFid(aIu().getFid());
        alVar.setFeedBackReasonMap(this.dqE.feedBackReasonMap);
        alVar.dpc = this.dqE.mRecomAbTag;
        alVar.weight = this.dqE.mRecomWeight;
        alVar.extra = this.dqE.mRecomExtra;
        alVar.source = this.dqE.mRecomSource;
        alVar.dpd = this.dqE.dpd;
        alVar.cardType = this.dqE.aMB();
        return alVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aIv() {
        return this.dqE.dsY;
    }
}
