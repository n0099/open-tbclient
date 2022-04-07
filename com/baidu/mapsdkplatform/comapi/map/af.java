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
/* loaded from: classes2.dex */
public class af {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.mapsdkplatform.comjni.map.basemap.a a;

    public af(com.baidu.mapsdkplatform.comjni.map.basemap.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
    }

    public Point a(GeoPoint geoPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, geoPoint)) == null) {
            if (geoPoint == null) {
                return null;
            }
            Point point = new Point(0, 0);
            String b = this.a.b((int) geoPoint.getLongitudeE6(), (int) geoPoint.getLatitudeE6());
            if (b != null && !b.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(b);
                    point.x = jSONObject.getInt("scrx");
                    point.y = jSONObject.getInt("scry");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return point;
        }
        return (Point) invokeL.objValue;
    }

    public GeoPoint a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
            String a = this.a.a(i, i2);
            if (a != null && !a.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(a);
                    geoPoint.setLongitudeE6(jSONObject.getInt("geox"));
                    geoPoint.setLatitudeE6(jSONObject.getInt("geoy"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return geoPoint;
        }
        return (GeoPoint) invokeII.objValue;
    }
}
