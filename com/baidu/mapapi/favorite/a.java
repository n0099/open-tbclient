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
            if (favSyncPoi == null || favSyncPoi.f41920c == null || favSyncPoi.f41919b.equals("")) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            favoritePoiInfo.f41110a = favSyncPoi.f41918a;
            favoritePoiInfo.f41111b = favSyncPoi.f41919b;
            Point point = favSyncPoi.f41920c;
            favoritePoiInfo.f41112c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
            favoritePoiInfo.f41114e = favSyncPoi.f41922e;
            favoritePoiInfo.f41115f = favSyncPoi.f41923f;
            favoritePoiInfo.f41113d = favSyncPoi.f41921d;
            favoritePoiInfo.f41116g = Long.parseLong(favSyncPoi.f41925h);
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
                favoritePoiInfo.f41112c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.f41111b = jSONObject.optString("uspoiname");
            favoritePoiInfo.f41116g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.f41113d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f41115f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.f41114e = jSONObject.optString("ncityid");
            favoritePoiInfo.f41110a = jSONObject.optString("key");
            return favoritePoiInfo;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, favoritePoiInfo)) == null) {
            if (favoritePoiInfo == null || favoritePoiInfo.f41112c == null || (str = favoritePoiInfo.f41111b) == null || str.equals("")) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            favSyncPoi.f41919b = favoritePoiInfo.f41111b;
            LatLng latLng = favoritePoiInfo.f41112c;
            favSyncPoi.f41920c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
            favSyncPoi.f41921d = favoritePoiInfo.f41113d;
            favSyncPoi.f41922e = favoritePoiInfo.f41114e;
            favSyncPoi.f41923f = favoritePoiInfo.f41115f;
            favSyncPoi.f41926i = false;
            return favSyncPoi;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
