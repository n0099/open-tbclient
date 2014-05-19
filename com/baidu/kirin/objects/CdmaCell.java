package com.baidu.kirin.objects;
/* loaded from: classes.dex */
public class CdmaCell extends SCell {
    public int networkId;
    public int stationId;
    public int systemId;

    @Override // com.baidu.kirin.objects.SCell
    public String toString() {
        return this.cellType + "," + this.MCCMNC + "," + this.MCC + "," + this.MNC + "" + this.stationId + "," + this.networkId + "," + this.systemId;
    }
}
