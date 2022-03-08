package com.baidu.mapapi.favorite;

import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static FavoritePoiInfo a(FavSyncPoi favSyncPoi) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, favSyncPoi)) == null) {
            if (favSyncPoi == null || favSyncPoi.f34424c == null || favSyncPoi.f34423b.equals("")) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            favoritePoiInfo.a = favSyncPoi.a;
            favoritePoiInfo.f33820b = favSyncPoi.f34423b;
            Point point = favSyncPoi.f34424c;
            favoritePoiInfo.f33821c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
            favoritePoiInfo.f33823e = favSyncPoi.f34426e;
            favoritePoiInfo.f33824f = favSyncPoi.f34427f;
            favoritePoiInfo.f33822d = favSyncPoi.f34425d;
            favoritePoiInfo.f33825g = Long.parseLong(favSyncPoi.f34429h);
            return favoritePoiInfo;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public static FavoritePoiInfo a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            JSONObject optJSONObject = jSONObject.optJSONObject("pt");
            if (optJSONObject != null) {
                favoritePoiInfo.f33821c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.f33820b = jSONObject.optString("uspoiname");
            favoritePoiInfo.f33825g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.f33822d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f33824f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.f33823e = jSONObject.optString("ncityid");
            favoritePoiInfo.a = jSONObject.optString("key");
            return favoritePoiInfo;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, favoritePoiInfo)) == null) {
            if (favoritePoiInfo == null || favoritePoiInfo.f33821c == null || (str = favoritePoiInfo.f33820b) == null || str.equals("")) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            favSyncPoi.f34423b = favoritePoiInfo.f33820b;
            LatLng latLng = favoritePoiInfo.f33821c;
            favSyncPoi.f34424c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
            favSyncPoi.f34425d = favoritePoiInfo.f33822d;
            favSyncPoi.f34426e = favoritePoiInfo.f33823e;
            favSyncPoi.f34427f = favoritePoiInfo.f33824f;
            favSyncPoi.f34430i = false;
            return favSyncPoi;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
