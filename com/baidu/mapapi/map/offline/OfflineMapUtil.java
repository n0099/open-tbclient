package com.baidu.mapapi.map.offline;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.m;
import com.baidu.mapsdkplatform.comapi.map.p;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes26.dex */
public class OfflineMapUtil {
    public static MKOLSearchRecord getSearchRecordFromLocalCityInfo(m mVar) {
        long j;
        m next;
        if (mVar == null) {
            return null;
        }
        MKOLSearchRecord mKOLSearchRecord = new MKOLSearchRecord();
        mKOLSearchRecord.cityID = mVar.f2235a;
        mKOLSearchRecord.cityName = mVar.b;
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
        mKOLUpdateElement.cityID = pVar.f2238a;
        mKOLUpdateElement.cityName = pVar.b;
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
