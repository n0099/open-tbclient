package com.baidu.mapapi.favorite;

import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static FavoritePoiInfo a(FavSyncPoi favSyncPoi) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, favSyncPoi)) == null) {
            if (favSyncPoi == null || favSyncPoi.f40032c == null || favSyncPoi.f40031b.equals("")) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            favoritePoiInfo.f39250a = favSyncPoi.f40030a;
            favoritePoiInfo.f39251b = favSyncPoi.f40031b;
            Point point = favSyncPoi.f40032c;
            favoritePoiInfo.f39252c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
            favoritePoiInfo.f39254e = favSyncPoi.f40034e;
            favoritePoiInfo.f39255f = favSyncPoi.f40035f;
            favoritePoiInfo.f39253d = favSyncPoi.f40033d;
            favoritePoiInfo.f39256g = Long.parseLong(favSyncPoi.f40037h);
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
                favoritePoiInfo.f39252c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.f39251b = jSONObject.optString("uspoiname");
            favoritePoiInfo.f39256g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.f39253d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f39255f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.f39254e = jSONObject.optString("ncityid");
            favoritePoiInfo.f39250a = jSONObject.optString("key");
            return favoritePoiInfo;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, favoritePoiInfo)) == null) {
            if (favoritePoiInfo == null || favoritePoiInfo.f39252c == null || (str = favoritePoiInfo.f39251b) == null || str.equals("")) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            favSyncPoi.f40031b = favoritePoiInfo.f39251b;
            LatLng latLng = favoritePoiInfo.f39252c;
            favSyncPoi.f40032c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
            favSyncPoi.f40033d = favoritePoiInfo.f39253d;
            favSyncPoi.f40034e = favoritePoiInfo.f39254e;
            favSyncPoi.f40035f = favoritePoiInfo.f39255f;
            favSyncPoi.f40038i = false;
            return favSyncPoi;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
