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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static FavoritePoiInfo a(FavSyncPoi favSyncPoi) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, favSyncPoi)) == null) {
            if (favSyncPoi == null || favSyncPoi.f7609c == null || favSyncPoi.f7608b.equals("")) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            favoritePoiInfo.f6827a = favSyncPoi.f7607a;
            favoritePoiInfo.f6828b = favSyncPoi.f7608b;
            Point point = favSyncPoi.f7609c;
            favoritePoiInfo.f6829c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
            favoritePoiInfo.f6831e = favSyncPoi.f7611e;
            favoritePoiInfo.f6832f = favSyncPoi.f7612f;
            favoritePoiInfo.f6830d = favSyncPoi.f7610d;
            favoritePoiInfo.f6833g = Long.parseLong(favSyncPoi.f7614h);
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
                favoritePoiInfo.f6829c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.f6828b = jSONObject.optString("uspoiname");
            favoritePoiInfo.f6833g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.f6830d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f6832f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.f6831e = jSONObject.optString("ncityid");
            favoritePoiInfo.f6827a = jSONObject.optString("key");
            return favoritePoiInfo;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, favoritePoiInfo)) == null) {
            if (favoritePoiInfo == null || favoritePoiInfo.f6829c == null || (str = favoritePoiInfo.f6828b) == null || str.equals("")) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            favSyncPoi.f7608b = favoritePoiInfo.f6828b;
            LatLng latLng = favoritePoiInfo.f6829c;
            favSyncPoi.f7609c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
            favSyncPoi.f7610d = favoritePoiInfo.f6830d;
            favSyncPoi.f7611e = favoritePoiInfo.f6831e;
            favSyncPoi.f7612f = favoritePoiInfo.f6832f;
            favSyncPoi.f7615i = false;
            return favSyncPoi;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
