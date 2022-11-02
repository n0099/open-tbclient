package com.baidu.mapapi.favorite;

import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.basestruct.Point;
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
            if (favSyncPoi != null && favSyncPoi.c != null && !favSyncPoi.b.equals("")) {
                FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
                favoritePoiInfo.a = favSyncPoi.a;
                favoritePoiInfo.b = favSyncPoi.b;
                Point point = favSyncPoi.c;
                favoritePoiInfo.c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
                favoritePoiInfo.e = favSyncPoi.e;
                favoritePoiInfo.f = favSyncPoi.f;
                favoritePoiInfo.d = favSyncPoi.d;
                favoritePoiInfo.g = Long.parseLong(favSyncPoi.h);
                return favoritePoiInfo;
            }
            return null;
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
                favoritePoiInfo.c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.b = jSONObject.optString("uspoiname");
            favoritePoiInfo.g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.e = jSONObject.optString("ncityid");
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
            if (favoritePoiInfo != null && favoritePoiInfo.c != null && (str = favoritePoiInfo.b) != null && !str.equals("")) {
                FavSyncPoi favSyncPoi = new FavSyncPoi();
                favSyncPoi.b = favoritePoiInfo.b;
                LatLng latLng = favoritePoiInfo.c;
                favSyncPoi.c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
                favSyncPoi.d = favoritePoiInfo.d;
                favSyncPoi.e = favoritePoiInfo.e;
                favSyncPoi.f = favoritePoiInfo.f;
                favSyncPoi.i = false;
                return favSyncPoi;
            }
            return null;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
