package com.baidu.mapsdkplatform.comapi.map;

import android.graphics.Point;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class af {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comjni.map.basemap.a f42269a;

    public af(com.baidu.mapsdkplatform.comjni.map.basemap.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42269a = aVar;
    }

    public Point a(GeoPoint geoPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, geoPoint)) == null) {
            if (geoPoint == null) {
                return null;
            }
            Point point = new Point(0, 0);
            String b2 = this.f42269a.b((int) geoPoint.getLongitudeE6(), (int) geoPoint.getLatitudeE6());
            if (b2 != null && !b2.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(b2);
                    point.x = jSONObject.getInt("scrx");
                    point.y = jSONObject.getInt("scry");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return point;
        }
        return (Point) invokeL.objValue;
    }

    public GeoPoint a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
            String a2 = this.f42269a.a(i2, i3);
            if (a2 != null && !a2.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(a2);
                    geoPoint.setLongitudeE6(jSONObject.getInt("geox"));
                    geoPoint.setLatitudeE6(jSONObject.getInt("geoy"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return geoPoint;
        }
        return (GeoPoint) invokeII.objValue;
    }
}
