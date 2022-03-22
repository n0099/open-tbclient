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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static FavoritePoiInfo a(FavSyncPoi favSyncPoi) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, favSyncPoi)) == null) {
            if (favSyncPoi == null || favSyncPoi.f26637c == null || favSyncPoi.f26636b.equals("")) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            favoritePoiInfo.a = favSyncPoi.a;
            favoritePoiInfo.f26094b = favSyncPoi.f26636b;
            Point point = favSyncPoi.f26637c;
            favoritePoiInfo.f26095c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
            favoritePoiInfo.f26097e = favSyncPoi.f26639e;
            favoritePoiInfo.f26098f = favSyncPoi.f26640f;
            favoritePoiInfo.f26096d = favSyncPoi.f26638d;
            favoritePoiInfo.f26099g = Long.parseLong(favSyncPoi.f26642h);
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
                favoritePoiInfo.f26095c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.f26094b = jSONObject.optString("uspoiname");
            favoritePoiInfo.f26099g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.f26096d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f26098f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.f26097e = jSONObject.optString("ncityid");
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
            if (favoritePoiInfo == null || favoritePoiInfo.f26095c == null || (str = favoritePoiInfo.f26094b) == null || str.equals("")) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            favSyncPoi.f26636b = favoritePoiInfo.f26094b;
            LatLng latLng = favoritePoiInfo.f26095c;
            favSyncPoi.f26637c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
            favSyncPoi.f26638d = favoritePoiInfo.f26096d;
            favSyncPoi.f26639e = favoritePoiInfo.f26097e;
            favSyncPoi.f26640f = favoritePoiInfo.f26098f;
            favSyncPoi.i = false;
            return favSyncPoi;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
