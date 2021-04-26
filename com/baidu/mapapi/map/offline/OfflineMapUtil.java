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
        mKOLSearchRecord.cityID = qVar.f7970a;
        mKOLSearchRecord.cityName = qVar.f7971b;
        mKOLSearchRecord.cityType = qVar.f7973d;
        long j = 0;
        if (qVar.a() != null) {
            ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
            Iterator<q> it = qVar.a().iterator();
            while (it.hasNext()) {
                arrayList.add(getSearchRecordFromLocalCityInfo(it.next()));
                j += next.f7972c;
                mKOLSearchRecord.childCities = arrayList;
            }
        }
        if (mKOLSearchRecord.cityType != 1) {
            j = qVar.f7972c;
        }
        mKOLSearchRecord.dataSize = j;
        return mKOLSearchRecord;
    }

    public static MKOLUpdateElement getUpdatElementFromLocalMapElement(t tVar) {
        if (tVar == null) {
            return null;
        }
        MKOLUpdateElement mKOLUpdateElement = new MKOLUpdateElement();
        mKOLUpdateElement.cityID = tVar.f7981a;
        mKOLUpdateElement.cityName = tVar.f7982b;
        GeoPoint geoPoint = tVar.f7987g;
        if (geoPoint != null) {
            mKOLUpdateElement.geoPt = CoordUtil.mc2ll(geoPoint);
        }
        mKOLUpdateElement.level = tVar.f7985e;
        int i2 = tVar.f7989i;
        mKOLUpdateElement.ratio = i2;
        int i3 = tVar.f7988h;
        mKOLUpdateElement.serversize = i3;
        if (i2 != 100) {
            i3 = (i3 / 100) * i2;
        }
        mKOLUpdateElement.size = i3;
        mKOLUpdateElement.status = tVar.l;
        mKOLUpdateElement.update = tVar.j;
        return mKOLUpdateElement;
    }
}
