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
        List<s.a> iV = s.iV(cVar.boI);
        if (iV == null || iV.size() <= 0) {
            return null;
        }
        int i2 = 0;
        Iterator<s.a> it = iV.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            s.a next = it.next();
            AlaWheatInfoData aY = aY(next.uk, next.name);
            if (aY != null) {
                arrayList.add(aY);
                if (aY.locationCenterX > 0.0f) {
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

    public static AlaWheatInfoData aY(String str, String str2) {
        AlaWheatInfoData jp = com.baidu.live.aq.a.aam().jp(str);
        if (jp == null) {
            if (com.baidu.live.aq.a.aam().jn(str)) {
                AlaWheatInfoData aan = com.baidu.live.aq.a.aam().aan();
                aan.locationCenterX = 0.0f;
                return aan;
            }
            AlaWheatInfoData alaWheatInfoData = new AlaWheatInfoData();
            alaWheatInfoData.locationCenterX = 0.0f;
            alaWheatInfoData.userName = str2;
            return alaWheatInfoData;
        }
        return jp;
    }
}
