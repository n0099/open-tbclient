package com.baidu.live.yuyingift.widget.wheatlist;

import com.baidu.live.data.AlaWheatInfoData;
/* loaded from: classes11.dex */
public class d implements Cloneable {
    public AlaWheatInfoData cce;
    public String posName;

    public d(AlaWheatInfoData alaWheatInfoData, String str) {
        this.cce = alaWheatInfoData;
        this.posName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: abu */
    public d clone() {
        d dVar = null;
        try {
            dVar = (d) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (dVar != null && this.cce != null) {
            dVar.cce = (AlaWheatInfoData) this.cce.clone();
        }
        return dVar;
    }
}
