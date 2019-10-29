package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bg extends a implements com.baidu.adp.widget.ListView.m {
    public bh cbq;
    public boolean cbg = false;
    public boolean cbh = false;
    public boolean cbi = false;
    public boolean cbj = false;
    public boolean cbk = false;
    public boolean cbl = false;
    public boolean cbm = false;
    public boolean cbn = false;
    public boolean cbo = false;
    public boolean cbp = false;
    public int cbr = 0;
    public int cbs = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cbq == null) {
            return null;
        }
        if (this.cbq.akt()) {
            if (this.cbq.aiX() != null) {
                return bh.cbI;
            }
            return bh.cbu;
        }
        int aiB = this.cbq.aiB();
        if (this.cbq.aiX() != null && this.cbq.akk()) {
            return bh.cbX;
        }
        if (this.cbq.threadType == 63) {
            bh bhVar = this.cbq;
            return bh.cbQ;
        } else if (this.cbq.threadType == 64) {
            bh bhVar2 = this.cbq;
            return bh.cbR;
        } else if (this.cbq.aiZ() != null && this.cbq.threadType == 60) {
            return bh.cbL;
        } else {
            if (this.cbq.aiZ() != null && this.cbq.threadType == 49) {
                return bh.cbJ;
            }
            if (this.cbq.threadType == 51) {
                return bh.cbK;
            }
            if (aiB == 2 || aiB == 1) {
                return bh.cbt;
            }
            if (this.cbq.aiX() != null && this.cbq.ajL() && !this.cbq.ajD()) {
                return bh.cbW;
            }
            if (this.cbq.isShareThread) {
                return bh.cbM;
            }
            if (this.cbq.ajF()) {
                bh bhVar3 = this.cbq;
                return bh.cbT.get() ? bh.cdh : bh.cbu;
            } else if (this.cbq.ajr() && this.cbq.ajq() == 1) {
                bh bhVar4 = this.cbq;
                return bh.cbT.get() ? bh.cdp : bh.cbu;
            } else if (this.cbq.isLinkThread()) {
                return bh.cbG;
            } else {
                if (this.cbq.akj()) {
                    return this.cbq.aip() != null ? bh.cbP : bh.cbO;
                } else if (this.cbg) {
                    return bh.cby;
                } else {
                    if (this.cbh) {
                        return bh.cbz;
                    }
                    if (this.cbi) {
                        return bh.cbA;
                    }
                    if (this.cbj) {
                        return bh.cbB;
                    }
                    if (this.cbk) {
                        return bh.cbC;
                    }
                    if (this.cbl) {
                        return bh.cbD;
                    }
                    if (this.cbm) {
                        return bh.cbE;
                    }
                    if (this.cbn) {
                        return bh.cbI;
                    }
                    if (this.cbq.aiJ()) {
                        if (this.cbo) {
                            return bh.cbN;
                        }
                        return bh.cbH;
                    } else if (this.cbp) {
                        return bh.cbS;
                    } else {
                        return bh.cbu;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bh agI() {
        return this.cbq;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj agK() {
        if (this.cbq.feedBackReasonMap == null || this.cbq.feedBackReasonMap.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(agI().getTid());
        ajVar.setFid(agI().getFid());
        ajVar.setFeedBackReasonMap(this.cbq.feedBackReasonMap);
        return ajVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String agJ() {
        return this.cbq.cdG;
    }
}
