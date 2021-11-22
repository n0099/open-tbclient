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
            if (favSyncPoi == null || favSyncPoi.f40864c == null || favSyncPoi.f40863b.equals("")) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            favoritePoiInfo.f40082a = favSyncPoi.f40862a;
            favoritePoiInfo.f40083b = favSyncPoi.f40863b;
            Point point = favSyncPoi.f40864c;
            favoritePoiInfo.f40084c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
            favoritePoiInfo.f40086e = favSyncPoi.f40866e;
            favoritePoiInfo.f40087f = favSyncPoi.f40867f;
            favoritePoiInfo.f40085d = favSyncPoi.f40865d;
            favoritePoiInfo.f40088g = Long.parseLong(favSyncPoi.f40869h);
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
                favoritePoiInfo.f40084c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.f40083b = jSONObject.optString("uspoiname");
            favoritePoiInfo.f40088g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.f40085d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f40087f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.f40086e = jSONObject.optString("ncityid");
            favoritePoiInfo.f40082a = jSONObject.optString("key");
            return favoritePoiInfo;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, favoritePoiInfo)) == null) {
            if (favoritePoiInfo == null || favoritePoiInfo.f40084c == null || (str = favoritePoiInfo.f40083b) == null || str.equals("")) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            favSyncPoi.f40863b = favoritePoiInfo.f40083b;
            LatLng latLng = favoritePoiInfo.f40084c;
            favSyncPoi.f40864c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
            favSyncPoi.f40865d = favoritePoiInfo.f40085d;
            favSyncPoi.f40866e = favoritePoiInfo.f40086e;
            favSyncPoi.f40867f = favoritePoiInfo.f40087f;
            favSyncPoi.f40870i = false;
            return favSyncPoi;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
