package com.baidu.mapapi.favorite;

import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static FavoritePoiInfo a(FavSyncPoi favSyncPoi) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, favSyncPoi)) == null) {
            if (favSyncPoi == null || favSyncPoi.f42027c == null || favSyncPoi.f42026b.equals("")) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            favoritePoiInfo.f41217a = favSyncPoi.f42025a;
            favoritePoiInfo.f41218b = favSyncPoi.f42026b;
            Point point = favSyncPoi.f42027c;
            favoritePoiInfo.f41219c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
            favoritePoiInfo.f41221e = favSyncPoi.f42029e;
            favoritePoiInfo.f41222f = favSyncPoi.f42030f;
            favoritePoiInfo.f41220d = favSyncPoi.f42028d;
            favoritePoiInfo.f41223g = Long.parseLong(favSyncPoi.f42032h);
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
                favoritePoiInfo.f41219c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.f41218b = jSONObject.optString("uspoiname");
            favoritePoiInfo.f41223g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.f41220d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f41222f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.f41221e = jSONObject.optString("ncityid");
            favoritePoiInfo.f41217a = jSONObject.optString("key");
            return favoritePoiInfo;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, favoritePoiInfo)) == null) {
            if (favoritePoiInfo == null || favoritePoiInfo.f41219c == null || (str = favoritePoiInfo.f41218b) == null || str.equals("")) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            favSyncPoi.f42026b = favoritePoiInfo.f41218b;
            LatLng latLng = favoritePoiInfo.f41219c;
            favSyncPoi.f42027c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
            favSyncPoi.f42028d = favoritePoiInfo.f41220d;
            favSyncPoi.f42029e = favoritePoiInfo.f41221e;
            favSyncPoi.f42030f = favoritePoiInfo.f41222f;
            favSyncPoi.f42033i = false;
            return favSyncPoi;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
