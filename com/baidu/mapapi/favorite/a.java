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
            if (favSyncPoi == null || favSyncPoi.f36848c == null || favSyncPoi.f36847b.equals("")) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            favoritePoiInfo.a = favSyncPoi.a;
            favoritePoiInfo.f36221b = favSyncPoi.f36847b;
            Point point = favSyncPoi.f36848c;
            favoritePoiInfo.f36222c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
            favoritePoiInfo.f36224e = favSyncPoi.f36850e;
            favoritePoiInfo.f36225f = favSyncPoi.f36851f;
            favoritePoiInfo.f36223d = favSyncPoi.f36849d;
            favoritePoiInfo.f36226g = Long.parseLong(favSyncPoi.f36853h);
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
                favoritePoiInfo.f36222c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.f36221b = jSONObject.optString("uspoiname");
            favoritePoiInfo.f36226g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.f36223d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f36225f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.f36224e = jSONObject.optString("ncityid");
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
            if (favoritePoiInfo == null || favoritePoiInfo.f36222c == null || (str = favoritePoiInfo.f36221b) == null || str.equals("")) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            favSyncPoi.f36847b = favoritePoiInfo.f36221b;
            LatLng latLng = favoritePoiInfo.f36222c;
            favSyncPoi.f36848c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
            favSyncPoi.f36849d = favoritePoiInfo.f36223d;
            favSyncPoi.f36850e = favoritePoiInfo.f36224e;
            favSyncPoi.f36851f = favoritePoiInfo.f36225f;
            favSyncPoi.f36854i = false;
            return favSyncPoi;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
