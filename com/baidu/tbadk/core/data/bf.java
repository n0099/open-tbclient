package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bf extends a implements com.baidu.adp.widget.ListView.m {
    public boolean bAD = false;
    public boolean bAE = false;
    public boolean bAF = false;
    public boolean bAG = false;
    public boolean bAH = false;
    public boolean bAI = false;
    public boolean bAJ = false;
    public boolean bAK = false;
    public int bAL = 0;
    public int bAM = 0;
    public bg threadData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return null;
        }
        if (this.threadData.aaF()) {
            if (this.threadData.Zi() != null) {
                return bg.bBb;
            }
            return bg.bAO;
        }
        int YM = this.threadData.YM();
        if (this.threadData.Zi() != null && this.threadData.aaw()) {
            return bg.bBp;
        }
        if (this.threadData.threadType == 63) {
            bg bgVar = this.threadData;
            return bg.bBj;
        } else if (this.threadData.threadType == 64) {
            bg bgVar2 = this.threadData;
            return bg.bBk;
        } else if (this.threadData.Zk() != null && this.threadData.threadType == 60) {
            return bg.bBe;
        } else {
            if (this.threadData.Zk() != null && this.threadData.threadType == 49) {
                return bg.bBc;
            }
            if (this.threadData.threadType == 51) {
                return bg.bBd;
            }
            if (YM == 2 || YM == 1) {
                return bg.bAN;
            }
            if (this.threadData.Zi() != null && this.threadData.ZX() && !this.threadData.ZO()) {
                return bg.bBo;
            }
            if (this.threadData.YU() && this.threadData.Zi() != null && !this.threadData.ZO()) {
                return bg.bBg;
            }
            if (this.threadData.isShareThread) {
                return bg.bBf;
            }
            if (this.threadData.ZQ()) {
                bg bgVar3 = this.threadData;
                return bg.bBl.get() ? bg.bCy : bg.bAO;
            } else if (this.threadData.ZC() && this.threadData.ZB() == 1) {
                bg bgVar4 = this.threadData;
                return bg.bBl.get() ? bg.bCG : bg.bAO;
            } else if (this.threadData.isLinkThread()) {
                return bg.bAZ;
            } else {
                if (this.threadData.YU()) {
                    return bg.bBa;
                }
                if (this.threadData.aav()) {
                    return this.threadData.YA() != null ? bg.bBi : bg.bBh;
                } else if (this.bAD) {
                    return bg.bAS;
                } else {
                    if (this.bAE) {
                        return bg.bAT;
                    }
                    if (this.bAF) {
                        return bg.bAU;
                    }
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
                        return bg.bBb;
                    }
                    return bg.bAO;
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
        if (this.threadData.bzs == null || this.threadData.bzs.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(WR().getTid());
        ajVar.setFid(WR().getFid());
        ajVar.b(this.threadData.bzs);
        return ajVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String WS() {
        return this.threadData.bCX;
    }
}
