package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bx extends a implements com.baidu.adp.widget.ListView.q {
    public by eCR;
    public boolean eIy = false;
    public boolean eIz = false;
    public boolean eIA = false;
    public boolean eIB = false;
    public boolean eIC = false;
    public boolean eID = false;
    public boolean eIE = false;
    public boolean eIF = false;
    public boolean eIG = false;
    public boolean eIH = false;
    public boolean eII = false;
    public boolean eIJ = false;
    public boolean eIK = false;
    public boolean eIL = false;
    public boolean eIM = false;
    public boolean eIN = false;
    public boolean eIO = false;
    public int eIP = 0;
    public int eIQ = 0;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.eCR == null) {
            return null;
        }
        if (this.eCR.bqG()) {
            if (this.eCR.bph() != null) {
                return by.eJq;
            }
            return by.eIS;
        }
        int boK = this.eCR.boK();
        if (this.eCR.threadType == 63) {
            by byVar = this.eCR;
            return by.eJC;
        } else if (this.eCR.threadType == 64) {
            by byVar2 = this.eCR;
            return by.eJD;
        } else if (this.eCR.threadType == 65) {
            by byVar3 = this.eCR;
            return by.eJh;
        } else if (this.eCR.bpj() != null && this.eCR.threadType == 60) {
            return by.eJt;
        } else {
            if (this.eCR.bpj() != null && this.eCR.threadType == 49) {
                return by.eJr;
            }
            if (this.eCR.bpj() != null && this.eCR.threadType == 67) {
                return by.eJu;
            }
            if (this.eCR.threadType == 51) {
                return by.eJs;
            }
            if (boK == 2 || boK == 1) {
                return by.eIR;
            }
            if (this.eCR.bph() != null && this.eCR.bqe() && !this.eCR.bpW()) {
                return by.eJI;
            }
            if (this.eCR.isShareThread && this.eCR.eLH != null) {
                if (this.eCR.eLH.eHh) {
                    if (this.eCR.eLH.videoInfo != null) {
                        return by.eJy;
                    }
                    if (this.eCR.eLH.bnx()) {
                        return by.eJx;
                    }
                    return by.eJw;
                }
                return by.eJv;
            } else if (this.eCR.bpY()) {
                by byVar4 = this.eCR;
                return by.eJF.get() ? by.eKU : by.eIS;
            } else if (this.eCR.bpD() && this.eCR.bpC() == 1) {
                by byVar5 = this.eCR;
                return by.eJF.get() ? by.eLc : by.eIS;
            } else if (this.eCR.isLinkThread()) {
                return by.eJo;
            } else {
                if (this.eCR.bqy()) {
                    return this.eCR.box() != null ? by.eJB : by.eJA;
                } else if (this.eIO) {
                    return by.eIX;
                } else {
                    if (this.eIy) {
                        return by.eIY;
                    }
                    if (this.eIz) {
                        return by.eIZ;
                    }
                    if (this.eIA) {
                        return by.eJa;
                    }
                    if (this.eIB) {
                        return by.eJb;
                    }
                    if (this.eIC) {
                        return by.eJc;
                    }
                    if (this.eID) {
                        return by.eJd;
                    }
                    if (this.eIE) {
                        return by.eJe;
                    }
                    if (this.eIF) {
                        return by.eJf;
                    }
                    if (this.eIG) {
                        return by.eJq;
                    }
                    if (this.eCR.boS()) {
                        if (this.eIH) {
                            return by.eJz;
                        }
                        return by.eJp;
                    } else if (this.eII) {
                        return by.eJE;
                    } else {
                        if (this.eIJ) {
                            return by.eJi;
                        }
                        if (this.eIK) {
                            return by.eJj;
                        }
                        if (this.eIL) {
                            return by.eJk;
                        }
                        if (this.eIM) {
                            return by.eJl;
                        }
                        if (this.eIN) {
                            return by.eJm;
                        }
                        return by.eIS;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public by bmn() {
        return this.eCR;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at bmp() {
        if (this.eCR == null || this.eCR.feedBackReasonMap == null || this.eCR.feedBackReasonMap.size() <= 0) {
            return null;
        }
        at atVar = new at();
        atVar.setTid(bmn().getTid());
        atVar.setFid(bmn().getFid());
        atVar.setNid(bmn().getNid());
        atVar.setFeedBackReasonMap(this.eCR.feedBackReasonMap);
        atVar.eGW = this.eCR.eGW;
        atVar.abTag = this.eCR.mRecomAbTag;
        atVar.weight = this.eCR.mRecomWeight;
        atVar.extra = this.eCR.mRecomExtra;
        atVar.source = this.eCR.mRecomSource;
        atVar.eHa = this.eCR.eHa;
        atVar.cardType = this.eCR.bqQ();
        return atVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bmo() {
        return this.eCR.eLn;
    }
}
