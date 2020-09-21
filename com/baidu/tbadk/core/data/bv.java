package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bv extends AbsThreadDataSupport implements com.baidu.adp.widget.ListView.q {
    public bw dXg;
    public boolean ecM = false;
    public boolean ecN = false;
    public boolean ecO = false;
    public boolean ecP = false;
    public boolean ecQ = false;
    public boolean ecR = false;
    public boolean ecS = false;
    public boolean ecT = false;
    public boolean ecU = false;
    public boolean ecV = false;
    public boolean ecW = false;
    public boolean ecX = false;
    public boolean ecY = false;
    public boolean ecZ = false;
    public boolean eda = false;
    public boolean edb = false;
    public boolean edc = false;
    public int edd = 0;
    public int ede = 0;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dXg == null) {
            return null;
        }
        if (this.dXg.bhn()) {
            if (this.dXg.bfQ() != null) {
                return bw.edC;
            }
            return bw.edg;
        }
        int bft = this.dXg.bft();
        if (this.dXg.threadType == 63) {
            bw bwVar = this.dXg;
            return bw.edN;
        } else if (this.dXg.threadType == 64) {
            bw bwVar2 = this.dXg;
            return bw.edO;
        } else if (this.dXg.threadType == 65) {
            bw bwVar3 = this.dXg;
            return bw.edu;
        } else if (this.dXg.bfS() != null && this.dXg.threadType == 60) {
            return bw.edF;
        } else {
            if (this.dXg.bfS() != null && this.dXg.threadType == 49) {
                return bw.edD;
            }
            if (this.dXg.threadType == 51) {
                return bw.edE;
            }
            if (bft == 2 || bft == 1) {
                return bw.edf;
            }
            if (this.dXg.bfQ() != null && this.dXg.bgL() && !this.dXg.bgD()) {
                return bw.edT;
            }
            if (this.dXg.isShareThread && this.dXg.efS != null) {
                if (this.dXg.efS.ebw) {
                    if (this.dXg.efS.videoInfo != null) {
                        return bw.edJ;
                    }
                    if (this.dXg.efS.beg()) {
                        return bw.edI;
                    }
                    return bw.edH;
                }
                return bw.edG;
            } else if (this.dXg.bgF()) {
                bw bwVar4 = this.dXg;
                return bw.edQ.get() ? bw.eff : bw.edg;
            } else if (this.dXg.bgm() && this.dXg.bgl() == 1) {
                bw bwVar5 = this.dXg;
                return bw.edQ.get() ? bw.efn : bw.edg;
            } else if (this.dXg.isLinkThread()) {
                return bw.edA;
            } else {
                if (this.dXg.bhf()) {
                    return this.dXg.bfg() != null ? bw.edM : bw.edL;
                } else if (this.edc) {
                    return bw.edk;
                } else {
                    if (this.ecM) {
                        return bw.edl;
                    }
                    if (this.ecN) {
                        return bw.edm;
                    }
                    if (this.ecO) {
                        return bw.edn;
                    }
                    if (this.ecP) {
                        return bw.edo;
                    }
                    if (this.ecQ) {
                        return bw.edp;
                    }
                    if (this.ecR) {
                        return bw.edq;
                    }
                    if (this.ecS) {
                        return bw.edr;
                    }
                    if (this.ecT) {
                        return bw.eds;
                    }
                    if (this.ecU) {
                        return bw.edC;
                    }
                    if (this.dXg.bfB()) {
                        if (this.ecV) {
                            return bw.edK;
                        }
                        return bw.edB;
                    } else if (this.ecW) {
                        return bw.edP;
                    } else {
                        if (this.ecX) {
                            return bw.edv;
                        }
                        if (this.ecY) {
                            return bw.edw;
                        }
                        if (this.ecZ) {
                            return bw.edx;
                        }
                        if (this.eda) {
                            return bw.edy;
                        }
                        if (this.edb) {
                            return bw.edz;
                        }
                        return bw.edg;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bcY() {
        return this.dXg;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bda() {
        if (this.dXg == null || this.dXg.feedBackReasonMap == null || this.dXg.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bcY().getTid());
        arVar.setFid(bcY().getFid());
        arVar.setNid(bcY().getNid());
        arVar.setFeedBackReasonMap(this.dXg.feedBackReasonMap);
        arVar.ebl = this.dXg.ebl;
        arVar.abTag = this.dXg.mRecomAbTag;
        arVar.weight = this.dXg.mRecomWeight;
        arVar.extra = this.dXg.mRecomExtra;
        arVar.source = this.dXg.mRecomSource;
        arVar.ebp = this.dXg.ebp;
        arVar.cardType = this.dXg.bhx();
        return arVar;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bcZ() {
        return this.dXg.efy;
    }
}
