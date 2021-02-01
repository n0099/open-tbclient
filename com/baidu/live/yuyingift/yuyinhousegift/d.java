package com.baidu.live.yuyingift.yuyinhousegift;

import android.content.Context;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.utils.s;
import com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public abstract class d {
    protected Context mContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<YuyinGiftItemView> x(com.baidu.live.yuyingift.a.c cVar) {
        int i;
        ArrayList<AlaWheatInfoData> arrayList = new ArrayList();
        List<s.a> m22if = s.m22if(cVar.bno);
        if (m22if == null || m22if.size() <= 0) {
            return null;
        }
        int i2 = 0;
        Iterator<s.a> it = m22if.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            s.a next = it.next();
            AlaWheatInfoData aW = aW(next.uk, next.name);
            if (aW != null) {
                arrayList.add(aW);
                if (aW.locationCenterX > 0.0f) {
                    i++;
                }
            }
            i2 = i;
        }
        ArrayList arrayList2 = new ArrayList();
        for (AlaWheatInfoData alaWheatInfoData : arrayList) {
            if (i <= 0 || alaWheatInfoData.locationCenterX != 0.0f) {
                YuyinGiftItemView yuyinGiftItemView = new YuyinGiftItemView(this.mContext);
                yuyinGiftItemView.setWheatInfoData(alaWheatInfoData);
                yuyinGiftItemView.G(cVar);
                arrayList2.add(yuyinGiftItemView);
            }
        }
        return arrayList2;
    }

    public static AlaWheatInfoData aW(String str, String str2) {
        AlaWheatInfoData iK = com.baidu.live.ao.a.Yj().iK(str);
        if (iK == null) {
            if (com.baidu.live.ao.a.Yj().iI(str)) {
                AlaWheatInfoData Yl = com.baidu.live.ao.a.Yj().Yl();
                Yl.locationCenterX = 0.0f;
                return Yl;
            }
            AlaWheatInfoData alaWheatInfoData = new AlaWheatInfoData();
            alaWheatInfoData.locationCenterX = 0.0f;
            alaWheatInfoData.userName = str2;
            return alaWheatInfoData;
        }
        return iK;
    }
}
