package com.baidu.live.yuyingift.yuyinhousegift;

import android.content.Context;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.utils.s;
import com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
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
        List<s.a> hK = s.hK(cVar.bjV);
        if (hK == null || hK.size() <= 0) {
            return null;
        }
        int i2 = 0;
        Iterator<s.a> it = hK.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            s.a next = it.next();
            AlaWheatInfoData aX = aX(next.uk, next.name);
            if (aX != null) {
                arrayList.add(aX);
                if (aX.locationCenterX > 0.0f) {
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

    public static AlaWheatInfoData aX(String str, String str2) {
        AlaWheatInfoData ie = com.baidu.live.aq.a.Wu().ie(str);
        if (ie == null) {
            if (com.baidu.live.aq.a.Wu().ic(str)) {
                AlaWheatInfoData Wv = com.baidu.live.aq.a.Wu().Wv();
                Wv.locationCenterX = 0.0f;
                return Wv;
            }
            AlaWheatInfoData alaWheatInfoData = new AlaWheatInfoData();
            alaWheatInfoData.locationCenterX = 0.0f;
            alaWheatInfoData.userName = str2;
            return alaWheatInfoData;
        }
        return ie;
    }
}
