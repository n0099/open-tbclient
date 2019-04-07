package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bf extends a implements com.baidu.adp.widget.ListView.m {
    public boolean bAI = false;
    public boolean bAJ = false;
    public boolean bAK = false;
    public boolean bAL = false;
    public boolean bAM = false;
    public boolean bAN = false;
    public boolean bAO = false;
    public boolean bAP = false;
    public int bAQ = 0;
    public int bAR = 0;
    public bg threadData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return null;
        }
        if (this.threadData.aaC()) {
            if (this.threadData.Zf() != null) {
                return bg.bBg;
            }
            return bg.bAT;
        }
        int YJ = this.threadData.YJ();
        if (this.threadData.Zf() != null && this.threadData.aat()) {
            return bg.bBu;
        }
        if (this.threadData.threadType == 63) {
            bg bgVar = this.threadData;
            return bg.bBo;
        } else if (this.threadData.threadType == 64) {
            bg bgVar2 = this.threadData;
            return bg.bBp;
        } else if (this.threadData.Zh() != null && this.threadData.threadType == 60) {
            return bg.bBj;
        } else {
            if (this.threadData.Zh() != null && this.threadData.threadType == 49) {
                return bg.bBh;
            }
            if (this.threadData.threadType == 51) {
                return bg.bBi;
            }
            if (YJ == 2 || YJ == 1) {
                return bg.bAS;
            }
            if (this.threadData.Zf() != null && this.threadData.ZU() && !this.threadData.ZL()) {
                return bg.bBt;
            }
            if (this.threadData.YR() && this.threadData.Zf() != null && !this.threadData.ZL()) {
                return bg.bBl;
            }
            if (this.threadData.isShareThread) {
                return bg.bBk;
            }
            if (this.threadData.ZN()) {
                bg bgVar3 = this.threadData;
                return bg.bBq.get() ? bg.bCD : bg.bAT;
            } else if (this.threadData.Zz() && this.threadData.Zy() == 1) {
                bg bgVar4 = this.threadData;
                return bg.bBq.get() ? bg.bCL : bg.bAT;
            } else if (this.threadData.isLinkThread()) {
                return bg.bBe;
            } else {
                if (this.threadData.YR()) {
                    return bg.bBf;
                }
                if (this.threadData.aas()) {
                    return this.threadData.Yx() != null ? bg.bBn : bg.bBm;
                } else if (this.bAI) {
                    return bg.bAX;
                } else {
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
                        return bg.bBb;
                    }
                    if (this.bAN) {
                        return bg.bBc;
                    }
                    if (this.bAO) {
                        return bg.bBd;
                    }
                    if (this.bAP) {
                        return bg.bBg;
                    }
                    return bg.bAT;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bg WO() {
        return this.threadData;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj WQ() {
        if (this.threadData.bzx == null || this.threadData.bzx.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(WO().getTid());
        ajVar.setFid(WO().getFid());
        ajVar.b(this.threadData.bzx);
        return ajVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String WP() {
        return this.threadData.bDc;
    }
}
