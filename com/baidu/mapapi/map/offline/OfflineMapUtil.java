package com.baidu.mapapi.map.offline;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.n;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class OfflineMapUtil {
    public static MKOLSearchRecord getSearchRecordFromLocalCityInfo(n nVar) {
        if (nVar == null) {
            return null;
        }
        MKOLSearchRecord mKOLSearchRecord = new MKOLSearchRecord();
        mKOLSearchRecord.cityID = nVar.a;
        mKOLSearchRecord.cityName = nVar.b;
        mKOLSearchRecord.cityType = nVar.d;
        long j = 0;
        if (nVar.a() != null) {
            ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
            Iterator<n> it = nVar.a().iterator();
            while (it.hasNext()) {
                n next = it.next();
                arrayList.add(getSearchRecordFromLocalCityInfo(next));
                j += next.c;
                mKOLSearchRecord.childCities = arrayList;
            }
        }
        if (mKOLSearchRecord.cityType == 1) {
            mKOLSearchRecord.dataSize = j;
        } else {
            mKOLSearchRecord.dataSize = nVar.c;
        }
        return mKOLSearchRecord;
    }

    public static MKOLUpdateElement getUpdatElementFromLocalMapElement(q qVar) {
        if (qVar == null) {
            return null;
        }
        MKOLUpdateElement mKOLUpdateElement = new MKOLUpdateElement();
        mKOLUpdateElement.cityID = qVar.a;
        mKOLUpdateElement.cityName = qVar.b;
        GeoPoint geoPoint = qVar.g;
        if (geoPoint != null) {
            mKOLUpdateElement.geoPt = CoordUtil.mc2ll(geoPoint);
        }
        mKOLUpdateElement.level = qVar.e;
        int i = qVar.i;
        mKOLUpdateElement.ratio = i;
        int i2 = qVar.h;
        mKOLUpdateElement.serversize = i2;
        if (i == 100) {
            mKOLUpdateElement.size = i2;
        } else {
            mKOLUpdateElement.size = (i2 / 100) * i;
        }
        mKOLUpdateElement.status = qVar.l;
        mKOLUpdateElement.update = qVar.j;
        return mKOLUpdateElement;
    }
}
