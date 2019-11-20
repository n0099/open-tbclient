package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bg extends a implements com.baidu.adp.widget.ListView.m {
    public bh caz;
    public boolean cap = false;
    public boolean caq = false;
    public boolean car = false;
    public boolean cas = false;
    public boolean cat = false;
    public boolean cau = false;
    public boolean cav = false;
    public boolean caw = false;
    public boolean cax = false;
    public boolean cay = false;
    public int caA = 0;
    public int caB = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.caz == null) {
            return null;
        }
        if (this.caz.akr()) {
            if (this.caz.aiV() != null) {
                return bh.caR;
            }
            return bh.caD;
        }
        int aiz = this.caz.aiz();
        if (this.caz.aiV() != null && this.caz.aki()) {
            return bh.cbg;
        }
        if (this.caz.threadType == 63) {
            bh bhVar = this.caz;
            return bh.caZ;
        } else if (this.caz.threadType == 64) {
            bh bhVar2 = this.caz;
            return bh.cba;
        } else if (this.caz.aiX() != null && this.caz.threadType == 60) {
            return bh.caU;
        } else {
            if (this.caz.aiX() != null && this.caz.threadType == 49) {
                return bh.caS;
            }
            if (this.caz.threadType == 51) {
                return bh.caT;
            }
            if (aiz == 2 || aiz == 1) {
                return bh.caC;
            }
            if (this.caz.aiV() != null && this.caz.ajJ() && !this.caz.ajB()) {
                return bh.cbf;
            }
            if (this.caz.isShareThread) {
                return bh.caV;
            }
            if (this.caz.ajD()) {
                bh bhVar3 = this.caz;
                return bh.cbc.get() ? bh.ccp : bh.caD;
            } else if (this.caz.ajp() && this.caz.ajo() == 1) {
                bh bhVar4 = this.caz;
                return bh.cbc.get() ? bh.ccy : bh.caD;
            } else if (this.caz.isLinkThread()) {
                return bh.caP;
            } else {
                if (this.caz.akh()) {
                    return this.caz.ain() != null ? bh.caY : bh.caX;
                } else if (this.cap) {
                    return bh.caH;
                } else {
                    if (this.caq) {
                        return bh.caI;
                    }
                    if (this.car) {
                        return bh.caJ;
                    }
                    if (this.cas) {
                        return bh.caK;
                    }
                    if (this.cat) {
                        return bh.caL;
                    }
                    if (this.cau) {
                        return bh.caM;
                    }
                    if (this.cav) {
                        return bh.caN;
                    }
                    if (this.caw) {
                        return bh.caR;
                    }
                    if (this.caz.aiH()) {
                        if (this.cax) {
                            return bh.caW;
                        }
                        return bh.caQ;
                    } else if (this.cay) {
                        return bh.cbb;
                    } else {
                        return bh.caD;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bh agG() {
        return this.caz;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj agI() {
        if (this.caz.feedBackReasonMap == null || this.caz.feedBackReasonMap.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(agG().getTid());
        ajVar.setFid(agG().getFid());
        ajVar.setFeedBackReasonMap(this.caz.feedBackReasonMap);
        return ajVar;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String agH() {
        return this.caz.ccP;
    }
}
