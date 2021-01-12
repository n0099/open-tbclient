package com.baidu.live.yuyingift.widget.wheatlist;

import com.baidu.live.data.AlaWheatInfoData;
/* loaded from: classes10.dex */
public class d implements Cloneable {
    public AlaWheatInfoData bXr;
    public String posName;

    public d(AlaWheatInfoData alaWheatInfoData, String str) {
        this.bXr = alaWheatInfoData;
        this.posName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: XB */
    public d clone() {
        d dVar = null;
        try {
            dVar = (d) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (dVar != null && this.bXr != null) {
            dVar.bXr = (AlaWheatInfoData) this.bXr.clone();
        }
        return dVar;
    }
}
