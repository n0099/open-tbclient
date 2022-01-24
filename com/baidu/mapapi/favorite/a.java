package com.baidu.mapapi.favorite;

import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static FavoritePoiInfo a(FavSyncPoi favSyncPoi) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, favSyncPoi)) == null) {
            if (favSyncPoi == null || favSyncPoi.f35815c == null || favSyncPoi.f35814b.equals("")) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            favoritePoiInfo.a = favSyncPoi.a;
            favoritePoiInfo.f35211b = favSyncPoi.f35814b;
            Point point = favSyncPoi.f35815c;
            favoritePoiInfo.f35212c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
            favoritePoiInfo.f35214e = favSyncPoi.f35817e;
            favoritePoiInfo.f35215f = favSyncPoi.f35818f;
            favoritePoiInfo.f35213d = favSyncPoi.f35816d;
            favoritePoiInfo.f35216g = Long.parseLong(favSyncPoi.f35820h);
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
                favoritePoiInfo.f35212c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.f35211b = jSONObject.optString("uspoiname");
            favoritePoiInfo.f35216g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.f35213d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f35215f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.f35214e = jSONObject.optString("ncityid");
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
            if (favoritePoiInfo == null || favoritePoiInfo.f35212c == null || (str = favoritePoiInfo.f35211b) == null || str.equals("")) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            favSyncPoi.f35814b = favoritePoiInfo.f35211b;
            LatLng latLng = favoritePoiInfo.f35212c;
            favSyncPoi.f35815c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
            favSyncPoi.f35816d = favoritePoiInfo.f35213d;
            favSyncPoi.f35817e = favoritePoiInfo.f35214e;
            favSyncPoi.f35818f = favoritePoiInfo.f35215f;
            favSyncPoi.f35821i = false;
            return favSyncPoi;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
