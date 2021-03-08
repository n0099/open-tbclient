package com.baidu.live.yuyingift.widget.wheatlist;

import com.baidu.live.data.AlaWheatInfoData;
/* loaded from: classes10.dex */
public class d implements Cloneable {
    public AlaWheatInfoData ccV;
    public String posName;

    public d(AlaWheatInfoData alaWheatInfoData, String str) {
        this.ccV = alaWheatInfoData;
        this.posName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Zu */
    public d clone() {
        d dVar = null;
        try {
            dVar = (d) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (dVar != null && this.ccV != null) {
            dVar.ccV = (AlaWheatInfoData) this.ccV.clone();
        }
        return dVar;
    }
}
