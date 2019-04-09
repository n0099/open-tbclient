package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bf extends a implements com.baidu.adp.widget.ListView.m {
    public boolean bAJ = false;
    public boolean bAK = false;
    public boolean bAL = false;
    public boolean bAM = false;
    public boolean bAN = false;
    public boolean bAO = false;
    public boolean bAP = false;
    public boolean bAQ = false;
    public int bAR = 0;
    public int bAS = 0;
    public bg threadData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return null;
        }
        if (this.threadData.aaC()) {
            if (this.threadData.Zf() != null) {
                return bg.bBh;
            }
            return bg.bAU;
        }
        int YJ = this.threadData.YJ();
        if (this.threadData.Zf() != null && this.threadData.aat()) {
            return bg.bBv;
        }
        if (this.threadData.threadType == 63) {
            bg bgVar = this.threadData;
            return bg.bBp;
        } else if (this.threadData.threadType == 64) {
            bg bgVar2 = this.threadData;
            return bg.bBq;
        } else if (this.threadData.Zh() != null && this.threadData.threadType == 60) {
            return bg.bBk;
        } else {
            if (this.threadData.Zh() != null && this.threadData.threadType == 49) {
                return bg.bBi;
            }
            if (this.threadData.threadType == 51) {
                return bg.bBj;
            }
            if (YJ == 2 || YJ == 1) {
                return bg.bAT;
            }
            if (this.threadData.Zf() != null && this.threadData.ZU() && !this.threadData.ZL()) {
                return bg.bBu;
            }
            if (this.threadData.YR() && this.threadData.Zf() != null && !this.threadData.ZL()) {
                return bg.bBm;
            }
            if (this.threadData.isShareThread) {
                return bg.bBl;
            }
            if (this.threadData.ZN()) {
                bg bgVar3 = this.threadData;
                return bg.bBr.get() ? bg.bCE : bg.bAU;
            } else if (this.threadData.Zz() && this.threadData.Zy() == 1) {
                bg bgVar4 = this.threadData;
                return bg.bBr.get() ? bg.bCM : bg.bAU;
            } else if (this.threadData.isLinkThread()) {
                return bg.bBf;
            } else {
                if (this.threadData.YR()) {
                    return bg.bBg;
                }
                if (this.threadData.aas()) {
                    return this.threadData.Yx() != null ? bg.bBo : bg.bBn;
                } else if (this.bAJ) {
                    return bg.bAY;
                } else {
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
                        return bg.bBe;
                    }
                    if (this.bAQ) {
                        return bg.bBh;
                    }
                    return bg.bAU;
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
        if (this.threadData.bzy == null || this.threadData.bzy.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(WO().getTid());
        ajVar.setFid(WO().getFid());
        ajVar.b(this.threadData.bzy);
        return ajVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String WP() {
        return this.threadData.bDd;
    }
}
