package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bf extends a implements com.baidu.adp.widget.ListView.m {
    public boolean bAF = false;
    public boolean bAG = false;
    public boolean bAH = false;
    public boolean bAI = false;
    public boolean bAJ = false;
    public boolean bAK = false;
    public boolean bAL = false;
    public boolean bAM = false;
    public int bAN = 0;
    public int bAO = 0;
    public bg threadData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return null;
        }
        if (this.threadData.aaF()) {
            if (this.threadData.Zi() != null) {
                return bg.bBd;
            }
            return bg.bAQ;
        }
        int YM = this.threadData.YM();
        if (this.threadData.Zi() != null && this.threadData.aaw()) {
            return bg.bBr;
        }
        if (this.threadData.threadType == 63) {
            bg bgVar = this.threadData;
            return bg.bBl;
        } else if (this.threadData.threadType == 64) {
            bg bgVar2 = this.threadData;
            return bg.bBm;
        } else if (this.threadData.Zk() != null && this.threadData.threadType == 60) {
            return bg.bBg;
        } else {
            if (this.threadData.Zk() != null && this.threadData.threadType == 49) {
                return bg.bBe;
            }
            if (this.threadData.threadType == 51) {
                return bg.bBf;
            }
            if (YM == 2 || YM == 1) {
                return bg.bAP;
            }
            if (this.threadData.Zi() != null && this.threadData.ZX() && !this.threadData.ZO()) {
                return bg.bBq;
            }
            if (this.threadData.YU() && this.threadData.Zi() != null && !this.threadData.ZO()) {
                return bg.bBi;
            }
            if (this.threadData.isShareThread) {
                return bg.bBh;
            }
            if (this.threadData.ZQ()) {
                bg bgVar3 = this.threadData;
                return bg.bBn.get() ? bg.bCA : bg.bAQ;
            } else if (this.threadData.ZC() && this.threadData.ZB() == 1) {
                bg bgVar4 = this.threadData;
                return bg.bBn.get() ? bg.bCI : bg.bAQ;
            } else if (this.threadData.isLinkThread()) {
                return bg.bBb;
            } else {
                if (this.threadData.YU()) {
                    return bg.bBc;
                }
                if (this.threadData.aav()) {
                    return this.threadData.YA() != null ? bg.bBk : bg.bBj;
                } else if (this.bAF) {
                    return bg.bAU;
                } else {
                    if (this.bAG) {
                        return bg.bAV;
                    }
                    if (this.bAH) {
                        return bg.bAW;
                    }
                    if (this.bAI) {
                        return bg.bAX;
                    }
                    if (this.bAJ) {
                        return bg.bAY;
                    }
                    if (this.bAK) {
                        return bg.bAZ;
                    }
                    if (this.bAL) {
                        return bg.bBa;
                    }
                    if (this.bAM) {
                        return bg.bBd;
                    }
                    return bg.bAQ;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bg WR() {
        return this.threadData;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj WT() {
        if (this.threadData.bzu == null || this.threadData.bzu.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(WR().getTid());
        ajVar.setFid(WR().getFid());
        ajVar.b(this.threadData.bzu);
        return ajVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String WS() {
        return this.threadData.bCZ;
    }
}
