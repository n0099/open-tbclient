package com.baidu.live.yuyingift.widget.wheatlist;

import com.baidu.live.data.AlaWheatInfoData;
/* loaded from: classes11.dex */
public class d implements Cloneable {
    public AlaWheatInfoData cbu;
    public String posName;

    public d(AlaWheatInfoData alaWheatInfoData, String str) {
        this.cbu = alaWheatInfoData;
        this.posName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Zr */
    public d clone() {
        d dVar = null;
        try {
            dVar = (d) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (dVar != null && this.cbu != null) {
            dVar.cbu = (AlaWheatInfoData) this.cbu.clone();
        }
        return dVar;
    }
}
