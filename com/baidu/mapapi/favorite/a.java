package com.baidu.mapapi.favorite;

import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static FavoritePoiInfo a(FavSyncPoi favSyncPoi) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, favSyncPoi)) == null) {
            if (favSyncPoi == null || favSyncPoi.f7652c == null || favSyncPoi.f7651b.equals("")) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            favoritePoiInfo.f6870a = favSyncPoi.f7650a;
            favoritePoiInfo.f6871b = favSyncPoi.f7651b;
            Point point = favSyncPoi.f7652c;
            favoritePoiInfo.f6872c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
            favoritePoiInfo.f6874e = favSyncPoi.f7654e;
            favoritePoiInfo.f6875f = favSyncPoi.f7655f;
            favoritePoiInfo.f6873d = favSyncPoi.f7653d;
            favoritePoiInfo.f6876g = Long.parseLong(favSyncPoi.f7657h);
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
            JSONObject optJSONObject = jSONObject.optJSONObject(Config.PLATFORM_TYPE);
            if (optJSONObject != null) {
                favoritePoiInfo.f6872c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.f6871b = jSONObject.optString("uspoiname");
            favoritePoiInfo.f6876g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.f6873d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f6875f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.f6874e = jSONObject.optString("ncityid");
            favoritePoiInfo.f6870a = jSONObject.optString("key");
            return favoritePoiInfo;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, favoritePoiInfo)) == null) {
            if (favoritePoiInfo == null || favoritePoiInfo.f6872c == null || (str = favoritePoiInfo.f6871b) == null || str.equals("")) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            favSyncPoi.f7651b = favoritePoiInfo.f6871b;
            LatLng latLng = favoritePoiInfo.f6872c;
            favSyncPoi.f7652c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
            favSyncPoi.f7653d = favoritePoiInfo.f6873d;
            favSyncPoi.f7654e = favoritePoiInfo.f6874e;
            favSyncPoi.f7655f = favoritePoiInfo.f6875f;
            favSyncPoi.f7658i = false;
            return favSyncPoi;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
