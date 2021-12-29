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
            if (favSyncPoi == null || favSyncPoi.f37004c == null || favSyncPoi.f37003b.equals("")) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            favoritePoiInfo.a = favSyncPoi.a;
            favoritePoiInfo.f36377b = favSyncPoi.f37003b;
            Point point = favSyncPoi.f37004c;
            favoritePoiInfo.f36378c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
            favoritePoiInfo.f36380e = favSyncPoi.f37006e;
            favoritePoiInfo.f36381f = favSyncPoi.f37007f;
            favoritePoiInfo.f36379d = favSyncPoi.f37005d;
            favoritePoiInfo.f36382g = Long.parseLong(favSyncPoi.f37009h);
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
                favoritePoiInfo.f36378c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.f36377b = jSONObject.optString("uspoiname");
            favoritePoiInfo.f36382g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.f36379d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f36381f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.f36380e = jSONObject.optString("ncityid");
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
            if (favoritePoiInfo == null || favoritePoiInfo.f36378c == null || (str = favoritePoiInfo.f36377b) == null || str.equals("")) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            favSyncPoi.f37003b = favoritePoiInfo.f36377b;
            LatLng latLng = favoritePoiInfo.f36378c;
            favSyncPoi.f37004c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
            favSyncPoi.f37005d = favoritePoiInfo.f36379d;
            favSyncPoi.f37006e = favoritePoiInfo.f36380e;
            favSyncPoi.f37007f = favoritePoiInfo.f36381f;
            favSyncPoi.f37010i = false;
            return favSyncPoi;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
