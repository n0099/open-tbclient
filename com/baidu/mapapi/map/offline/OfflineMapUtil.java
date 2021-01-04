package com.baidu.mapapi.map.offline;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.m;
import com.baidu.mapsdkplatform.comapi.map.p;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes15.dex */
public class OfflineMapUtil {
    public static MKOLSearchRecord getSearchRecordFromLocalCityInfo(m mVar) {
        long j;
        m next;
        if (mVar == null) {
            return null;
        }
        MKOLSearchRecord mKOLSearchRecord = new MKOLSearchRecord();
        mKOLSearchRecord.cityID = mVar.f3186a;
        mKOLSearchRecord.cityName = mVar.f3187b;
        mKOLSearchRecord.cityType = mVar.d;
        long j2 = 0;
        if (mVar.a() != null) {
            ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
            Iterator<m> it = mVar.a().iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                arrayList.add(getSearchRecordFromLocalCityInfo(it.next()));
                j2 = next.c + j;
                mKOLSearchRecord.childCities = arrayList;
            }
        } else {
            j = 0;
        }
        if (mKOLSearchRecord.cityType == 1) {
            mKOLSearchRecord.dataSize = j;
        } else {
            mKOLSearchRecord.dataSize = mVar.c;
        }
        return mKOLSearchRecord;
    }

    public static MKOLUpdateElement getUpdatElementFromLocalMapElement(p pVar) {
        if (pVar == null) {
            return null;
        }
        MKOLUpdateElement mKOLUpdateElement = new MKOLUpdateElement();
        mKOLUpdateElement.cityID = pVar.f3191a;
        mKOLUpdateElement.cityName = pVar.f3192b;
        if (pVar.g != null) {
            mKOLUpdateElement.geoPt = CoordUtil.mc2ll(pVar.g);
        }
        mKOLUpdateElement.level = pVar.e;
        mKOLUpdateElement.ratio = pVar.i;
        mKOLUpdateElement.serversize = pVar.h;
        if (pVar.i == 100) {
            mKOLUpdateElement.size = pVar.h;
        } else {
            mKOLUpdateElement.size = (pVar.h / 100) * pVar.i;
        }
        mKOLUpdateElement.status = pVar.l;
        mKOLUpdateElement.update = pVar.j;
        return mKOLUpdateElement;
    }
}
