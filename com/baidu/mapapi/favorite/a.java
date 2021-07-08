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
            if (favSyncPoi == null || favSyncPoi.f7626c == null || favSyncPoi.f7625b.equals("")) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            favoritePoiInfo.f6844a = favSyncPoi.f7624a;
            favoritePoiInfo.f6845b = favSyncPoi.f7625b;
            Point point = favSyncPoi.f7626c;
            favoritePoiInfo.f6846c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
            favoritePoiInfo.f6848e = favSyncPoi.f7628e;
            favoritePoiInfo.f6849f = favSyncPoi.f7629f;
            favoritePoiInfo.f6847d = favSyncPoi.f7627d;
            favoritePoiInfo.f6850g = Long.parseLong(favSyncPoi.f7631h);
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
                favoritePoiInfo.f6846c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.f6845b = jSONObject.optString("uspoiname");
            favoritePoiInfo.f6850g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.f6847d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f6849f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.f6848e = jSONObject.optString("ncityid");
            favoritePoiInfo.f6844a = jSONObject.optString("key");
            return favoritePoiInfo;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, favoritePoiInfo)) == null) {
            if (favoritePoiInfo == null || favoritePoiInfo.f6846c == null || (str = favoritePoiInfo.f6845b) == null || str.equals("")) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            favSyncPoi.f7625b = favoritePoiInfo.f6845b;
            LatLng latLng = favoritePoiInfo.f6846c;
            favSyncPoi.f7626c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
            favSyncPoi.f7627d = favoritePoiInfo.f6847d;
            favSyncPoi.f7628e = favoritePoiInfo.f6848e;
            favSyncPoi.f7629f = favoritePoiInfo.f6849f;
            favSyncPoi.f7632i = false;
            return favSyncPoi;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
