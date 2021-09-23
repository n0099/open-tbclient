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
            if (favSyncPoi == null || favSyncPoi.f42200c == null || favSyncPoi.f42199b.equals("")) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            favoritePoiInfo.f41390a = favSyncPoi.f42198a;
            favoritePoiInfo.f41391b = favSyncPoi.f42199b;
            Point point = favSyncPoi.f42200c;
            favoritePoiInfo.f41392c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
            favoritePoiInfo.f41394e = favSyncPoi.f42202e;
            favoritePoiInfo.f41395f = favSyncPoi.f42203f;
            favoritePoiInfo.f41393d = favSyncPoi.f42201d;
            favoritePoiInfo.f41396g = Long.parseLong(favSyncPoi.f42205h);
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
                favoritePoiInfo.f41392c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.f41391b = jSONObject.optString("uspoiname");
            favoritePoiInfo.f41396g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.f41393d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f41395f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.f41394e = jSONObject.optString("ncityid");
            favoritePoiInfo.f41390a = jSONObject.optString("key");
            return favoritePoiInfo;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, favoritePoiInfo)) == null) {
            if (favoritePoiInfo == null || favoritePoiInfo.f41392c == null || (str = favoritePoiInfo.f41391b) == null || str.equals("")) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            favSyncPoi.f42199b = favoritePoiInfo.f41391b;
            LatLng latLng = favoritePoiInfo.f41392c;
            favSyncPoi.f42200c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
            favSyncPoi.f42201d = favoritePoiInfo.f41393d;
            favSyncPoi.f42202e = favoritePoiInfo.f41394e;
            favSyncPoi.f42203f = favoritePoiInfo.f41395f;
            favSyncPoi.f42206i = false;
            return favSyncPoi;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
