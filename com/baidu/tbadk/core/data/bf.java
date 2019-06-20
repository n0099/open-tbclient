package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bf extends a implements com.baidu.adp.widget.ListView.m {
    public boolean bHW = false;
    public boolean bHX = false;
    public boolean bHY = false;
    public boolean bHZ = false;
    public boolean bIa = false;
    public boolean bIb = false;
    public boolean bIc = false;
    public boolean bId = false;
    public boolean bIe = false;
    public boolean bIf = false;
    public int bIg = 0;
    public int bIh = 0;
    public bg threadData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return null;
        }
        if (this.threadData.afj()) {
            if (this.threadData.adM() != null) {
                return bg.bIx;
            }
            return bg.bIj;
        }
        int adq = this.threadData.adq();
        if (this.threadData.adM() != null && this.threadData.afa()) {
            return bg.bIM;
        }
        if (this.threadData.threadType == 63) {
            bg bgVar = this.threadData;
            return bg.bIF;
        } else if (this.threadData.threadType == 64) {
            bg bgVar2 = this.threadData;
            return bg.bIG;
        } else if (this.threadData.adO() != null && this.threadData.threadType == 60) {
            return bg.bIA;
        } else {
            if (this.threadData.adO() != null && this.threadData.threadType == 49) {
                return bg.bIy;
            }
            if (this.threadData.threadType == 51) {
                return bg.bIz;
            }
            if (adq == 2 || adq == 1) {
                return bg.bIi;
            }
            if (this.threadData.adM() != null && this.threadData.aeB() && !this.threadData.aes()) {
                return bg.bIL;
            }
            if (this.threadData.isShareThread) {
                return bg.bIB;
            }
            if (this.threadData.aeu()) {
                bg bgVar3 = this.threadData;
                return bg.bII.get() ? bg.bJV : bg.bIj;
            } else if (this.threadData.aeg() && this.threadData.aef() == 1) {
                bg bgVar4 = this.threadData;
                return bg.bII.get() ? bg.bKd : bg.bIj;
            } else if (this.threadData.isLinkThread()) {
                return bg.bIv;
            } else {
                if (this.threadData.aeZ()) {
                    return this.threadData.ade() != null ? bg.bIE : bg.bID;
                } else if (this.bHW) {
                    return bg.bIn;
                } else {
                    if (this.bHX) {
                        return bg.bIo;
                    }
                    if (this.bHY) {
                        return bg.bIp;
                    }
                    if (this.bHZ) {
                        return bg.bIq;
                    }
                    if (this.bIa) {
                        return bg.bIr;
                    }
                    if (this.bIb) {
                        return bg.bIs;
                    }
                    if (this.bIc) {
                        return bg.bIt;
                    }
                    if (this.bId) {
                        return bg.bIx;
                    }
                    if (this.threadData.ady()) {
                        if (this.bIe) {
                            return bg.bIC;
                        }
                        return bg.bIw;
                    } else if (this.bIf) {
                        return bg.bIH;
                    } else {
                        return bg.bIj;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bg abv() {
        return this.threadData;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj abx() {
        if (this.threadData.bGL == null || this.threadData.bGL.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(abv().getTid());
        ajVar.setFid(abv().getFid());
        ajVar.b(this.threadData.bGL);
        return ajVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String abw() {
        return this.threadData.bKu;
    }
}
