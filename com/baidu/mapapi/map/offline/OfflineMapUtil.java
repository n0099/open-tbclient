package com.baidu.mapapi.map.offline;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class OfflineMapUtil {
    public static MKOLSearchRecord getSearchRecordFromLocalCityInfo(q qVar) {
        q next;
        if (qVar == null) {
            return null;
        }
        MKOLSearchRecord mKOLSearchRecord = new MKOLSearchRecord();
        mKOLSearchRecord.cityID = qVar.f7694a;
        mKOLSearchRecord.cityName = qVar.f7695b;
        mKOLSearchRecord.cityType = qVar.f7697d;
        long j = 0;
        if (qVar.a() != null) {
            ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
            Iterator<q> it = qVar.a().iterator();
            while (it.hasNext()) {
                arrayList.add(getSearchRecordFromLocalCityInfo(it.next()));
                j += next.f7696c;
                mKOLSearchRecord.childCities = arrayList;
            }
        }
        if (mKOLSearchRecord.cityType != 1) {
            j = qVar.f7696c;
        }
        mKOLSearchRecord.dataSize = j;
        return mKOLSearchRecord;
    }

    public static MKOLUpdateElement getUpdatElementFromLocalMapElement(t tVar) {
        if (tVar == null) {
            return null;
        }
        MKOLUpdateElement mKOLUpdateElement = new MKOLUpdateElement();
        mKOLUpdateElement.cityID = tVar.f7705a;
        mKOLUpdateElement.cityName = tVar.f7706b;
        GeoPoint geoPoint = tVar.f7711g;
        if (geoPoint != null) {
            mKOLUpdateElement.geoPt = CoordUtil.mc2ll(geoPoint);
        }
        mKOLUpdateElement.level = tVar.f7709e;
        int i = tVar.i;
        mKOLUpdateElement.ratio = i;
        int i2 = tVar.f7712h;
        mKOLUpdateElement.serversize = i2;
        if (i != 100) {
            i2 = (i2 / 100) * i;
        }
        mKOLUpdateElement.size = i2;
        mKOLUpdateElement.status = tVar.l;
        mKOLUpdateElement.update = tVar.j;
        return mKOLUpdateElement;
    }
}
