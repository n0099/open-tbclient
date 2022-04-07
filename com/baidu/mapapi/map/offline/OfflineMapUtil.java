package com.baidu.mapapi.map.offline;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.t;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class OfflineMapUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OfflineMapUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static MKOLSearchRecord getSearchRecordFromLocalCityInfo(q qVar) {
        InterceptResult invokeL;
        q next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qVar)) == null) {
            if (qVar == null) {
                return null;
            }
            MKOLSearchRecord mKOLSearchRecord = new MKOLSearchRecord();
            mKOLSearchRecord.cityID = qVar.a;
            mKOLSearchRecord.cityName = qVar.b;
            mKOLSearchRecord.cityType = qVar.d;
            long j = 0;
            if (qVar.a() != null) {
                ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
                Iterator<q> it = qVar.a().iterator();
                while (it.hasNext()) {
                    arrayList.add(getSearchRecordFromLocalCityInfo(it.next()));
                    j += next.c;
                    mKOLSearchRecord.childCities = arrayList;
                }
            }
            if (mKOLSearchRecord.cityType != 1) {
                j = qVar.c;
            }
            mKOLSearchRecord.dataSize = j;
            return mKOLSearchRecord;
        }
        return (MKOLSearchRecord) invokeL.objValue;
    }

    public static MKOLUpdateElement getUpdatElementFromLocalMapElement(t tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tVar)) == null) {
            if (tVar == null) {
                return null;
            }
            MKOLUpdateElement mKOLUpdateElement = new MKOLUpdateElement();
            mKOLUpdateElement.cityID = tVar.a;
            mKOLUpdateElement.cityName = tVar.b;
            GeoPoint geoPoint = tVar.g;
            if (geoPoint != null) {
                mKOLUpdateElement.geoPt = CoordUtil.mc2ll(geoPoint);
            }
            mKOLUpdateElement.level = tVar.e;
            int i = tVar.i;
            mKOLUpdateElement.ratio = i;
            int i2 = tVar.h;
            mKOLUpdateElement.serversize = i2;
            if (i != 100) {
                i2 = (i2 / 100) * i;
            }
            mKOLUpdateElement.size = i2;
            mKOLUpdateElement.status = tVar.l;
            mKOLUpdateElement.update = tVar.j;
            return mKOLUpdateElement;
        }
        return (MKOLUpdateElement) invokeL.objValue;
    }
}
