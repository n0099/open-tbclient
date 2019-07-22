package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bf extends a implements com.baidu.adp.widget.ListView.m {
    public boolean bIW = false;
    public boolean bIX = false;
    public boolean bIY = false;
    public boolean bIZ = false;
    public boolean bJa = false;
    public boolean bJb = false;
    public boolean bJc = false;
    public boolean bJd = false;
    public boolean bJe = false;
    public boolean bJf = false;
    public int bJg = 0;
    public int bJh = 0;
    public bg threadData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return null;
        }
        if (this.threadData.agl()) {
            if (this.threadData.aeO() != null) {
                return bg.bJx;
            }
            return bg.bJj;
        }
        int aes = this.threadData.aes();
        if (this.threadData.aeO() != null && this.threadData.agc()) {
            return bg.bJM;
        }
        if (this.threadData.threadType == 63) {
            bg bgVar = this.threadData;
            return bg.bJF;
        } else if (this.threadData.threadType == 64) {
            bg bgVar2 = this.threadData;
            return bg.bJG;
        } else if (this.threadData.aeQ() != null && this.threadData.threadType == 60) {
            return bg.bJA;
        } else {
            if (this.threadData.aeQ() != null && this.threadData.threadType == 49) {
                return bg.bJy;
            }
            if (this.threadData.threadType == 51) {
                return bg.bJz;
            }
            if (aes == 2 || aes == 1) {
                return bg.bJi;
            }
            if (this.threadData.aeO() != null && this.threadData.afD() && !this.threadData.afu()) {
                return bg.bJL;
            }
            if (this.threadData.isShareThread) {
                return bg.bJB;
            }
            if (this.threadData.afw()) {
                bg bgVar3 = this.threadData;
                return bg.bJI.get() ? bg.bKV : bg.bJj;
            } else if (this.threadData.afi() && this.threadData.afh() == 1) {
                bg bgVar4 = this.threadData;
                return bg.bJI.get() ? bg.bLd : bg.bJj;
            } else if (this.threadData.isLinkThread()) {
                return bg.bJv;
            } else {
                if (this.threadData.agb()) {
                    return this.threadData.aeg() != null ? bg.bJE : bg.bJD;
                } else if (this.bIW) {
                    return bg.bJn;
                } else {
                    if (this.bIX) {
                        return bg.bJo;
                    }
                    if (this.bIY) {
                        return bg.bJp;
                    }
                    if (this.bIZ) {
                        return bg.bJq;
                    }
                    if (this.bJa) {
                        return bg.bJr;
                    }
                    if (this.bJb) {
                        return bg.bJs;
                    }
                    if (this.bJc) {
                        return bg.bJt;
                    }
                    if (this.bJd) {
                        return bg.bJx;
                    }
                    if (this.threadData.aeA()) {
                        if (this.bJe) {
                            return bg.bJC;
                        }
                        return bg.bJw;
                    } else if (this.bJf) {
                        return bg.bJH;
                    } else {
                        return bg.bJj;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bg acx() {
        return this.threadData;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj acz() {
        if (this.threadData.bHL == null || this.threadData.bHL.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(acx().getTid());
        ajVar.setFid(acx().getFid());
        ajVar.b(this.threadData.bHL);
        return ajVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String acy() {
        return this.threadData.bLu;
    }
}
