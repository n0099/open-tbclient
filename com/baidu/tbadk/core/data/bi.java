package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bi extends a implements com.baidu.adp.widget.ListView.m {
    public bj dqA;
    public boolean dqo = false;
    public boolean dqp = false;
    public boolean dqq = false;
    public boolean dqr = false;
    public boolean dqs = false;
    public boolean dqt = false;
    public boolean dqu = false;
    public boolean dqv = false;
    public boolean dqw = false;
    public boolean dqx = false;
    public boolean dqy = false;
    public boolean dqz = false;
    public int dqB = 0;
    public int dqC = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.dqA == null) {
            return null;
        }
        if (this.dqA.aMq()) {
            if (this.dqA.aKV() != null) {
                return bj.dqV;
            }
            return bj.dqE;
        }
        int aKz = this.dqA.aKz();
        if (this.dqA.aKV() != null && this.dqA.aMj()) {
            return bj.drn;
        }
        if (this.dqA.threadType == 63) {
            bj bjVar = this.dqA;
            return bj.drg;
        } else if (this.dqA.threadType == 64) {
            bj bjVar2 = this.dqA;
            return bj.drh;
        } else if (this.dqA.threadType == 65) {
            bj bjVar3 = this.dqA;
            return bj.dqR;
        } else if (this.dqA.aKX() != null && this.dqA.threadType == 60) {
            return bj.dqY;
        } else {
            if (this.dqA.aKX() != null && this.dqA.threadType == 49) {
                return bj.dqW;
            }
            if (this.dqA.threadType == 51) {
                return bj.dqX;
            }
            if (aKz == 2 || aKz == 1) {
                return bj.dqD;
            }
            if (this.dqA.aKV() != null && this.dqA.aLO() && !this.dqA.aLG()) {
                return bj.drm;
            }
            if (this.dqA.isShareThread && this.dqA.dto != null) {
                if (this.dqA.dto.dpg) {
                    if (this.dqA.dto.videoInfo != null) {
                        return bj.drc;
                    }
                    if (this.dqA.dto.aJt()) {
                        return bj.drb;
                    }
                    return bj.dra;
                }
                return bj.dqZ;
            } else if (this.dqA.aLI()) {
                bj bjVar4 = this.dqA;
                return bj.drj.get() ? bj.dsB : bj.dqE;
            } else if (this.dqA.aLp() && this.dqA.aLo() == 1) {
                bj bjVar5 = this.dqA;
                return bj.drj.get() ? bj.dsJ : bj.dqE;
            } else if (this.dqA.isLinkThread()) {
                return bj.dqT;
            } else {
                if (this.dqA.aMi()) {
                    return this.dqA.aKm() != null ? bj.drf : bj.dre;
                } else if (this.dqo) {
                    return bj.dqI;
                } else {
                    if (this.dqp) {
                        return bj.dqJ;
                    }
                    if (this.dqq) {
                        return bj.dqK;
                    }
                    if (this.dqr) {
                        return bj.dqL;
                    }
                    if (this.dqs) {
                        return bj.dqM;
                    }
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
                        return bj.dqV;
                    }
                    if (this.dqA.aKH()) {
                        if (this.dqx) {
                            return bj.drd;
                        }
                        return bj.dqU;
                    } else if (this.dqy) {
                        return bj.dri;
                    } else {
                        if (this.dqz) {
                            return bj.dqS;
                        }
                        return bj.dqE;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aIw() {
        return this.dqA;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aIy() {
        if (this.dqA == null || this.dqA.feedBackReasonMap == null || this.dqA.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aIw().getTid());
        alVar.setFid(aIw().getFid());
        alVar.setFeedBackReasonMap(this.dqA.feedBackReasonMap);
        alVar.doY = this.dqA.mRecomAbTag;
        alVar.weight = this.dqA.mRecomWeight;
        alVar.extra = this.dqA.mRecomExtra;
        alVar.source = this.dqA.mRecomSource;
        alVar.doZ = this.dqA.doZ;
        alVar.cardType = this.dqA.aMD();
        return alVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aIx() {
        return this.dqA.dsU;
    }
}
