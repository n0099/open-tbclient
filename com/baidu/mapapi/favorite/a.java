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
            if (favSyncPoi == null || favSyncPoi.f42138c == null || favSyncPoi.f42137b.equals("")) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            favoritePoiInfo.f41328a = favSyncPoi.f42136a;
            favoritePoiInfo.f41329b = favSyncPoi.f42137b;
            Point point = favSyncPoi.f42138c;
            favoritePoiInfo.f41330c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
            favoritePoiInfo.f41332e = favSyncPoi.f42140e;
            favoritePoiInfo.f41333f = favSyncPoi.f42141f;
            favoritePoiInfo.f41331d = favSyncPoi.f42139d;
            favoritePoiInfo.f41334g = Long.parseLong(favSyncPoi.f42143h);
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
                favoritePoiInfo.f41330c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.f41329b = jSONObject.optString("uspoiname");
            favoritePoiInfo.f41334g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.f41331d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f41333f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.f41332e = jSONObject.optString("ncityid");
            favoritePoiInfo.f41328a = jSONObject.optString("key");
            return favoritePoiInfo;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, favoritePoiInfo)) == null) {
            if (favoritePoiInfo == null || favoritePoiInfo.f41330c == null || (str = favoritePoiInfo.f41329b) == null || str.equals("")) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            favSyncPoi.f42137b = favoritePoiInfo.f41329b;
            LatLng latLng = favoritePoiInfo.f41330c;
            favSyncPoi.f42138c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
            favSyncPoi.f42139d = favoritePoiInfo.f41331d;
            favSyncPoi.f42140e = favoritePoiInfo.f41332e;
            favSyncPoi.f42141f = favoritePoiInfo.f41333f;
            favSyncPoi.f42144i = false;
            return favSyncPoi;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
