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
/* loaded from: classes8.dex */
public class OfflineMapUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OfflineMapUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            mKOLSearchRecord.cityName = qVar.f36480b;
            mKOLSearchRecord.cityType = qVar.f36482d;
            long j2 = 0;
            if (qVar.a() != null) {
                ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
                Iterator<q> it = qVar.a().iterator();
                while (it.hasNext()) {
                    arrayList.add(getSearchRecordFromLocalCityInfo(it.next()));
                    j2 += next.f36481c;
                    mKOLSearchRecord.childCities = arrayList;
                }
            }
            if (mKOLSearchRecord.cityType != 1) {
                j2 = qVar.f36481c;
            }
            mKOLSearchRecord.dataSize = j2;
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
            mKOLUpdateElement.cityName = tVar.f36488b;
            GeoPoint geoPoint = tVar.f36493g;
            if (geoPoint != null) {
                mKOLUpdateElement.geoPt = CoordUtil.mc2ll(geoPoint);
            }
            mKOLUpdateElement.level = tVar.f36491e;
            int i2 = tVar.f36495i;
            mKOLUpdateElement.ratio = i2;
            int i3 = tVar.f36494h;
            mKOLUpdateElement.serversize = i3;
            if (i2 != 100) {
                i3 = (i3 / 100) * i2;
            }
            mKOLUpdateElement.size = i3;
            mKOLUpdateElement.status = tVar.l;
            mKOLUpdateElement.update = tVar.f36496j;
            return mKOLUpdateElement;
        }
        return (MKOLUpdateElement) invokeL.objValue;
    }
}
