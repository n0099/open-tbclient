package com.baidu.kirin.objects;
/* loaded from: classes.dex */
public class GsmCell extends SCell {
    public int CID;
    public int LAC;

    @Override // com.baidu.kirin.objects.SCell
    public String toString() {
        return this.cellType + "," + this.MCCMNC + "," + this.MCC + "," + this.MNC + "" + this.LAC + "," + this.CID;
    }
}
