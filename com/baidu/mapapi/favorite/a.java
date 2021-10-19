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
            if (favSyncPoi == null || favSyncPoi.f42204c == null || favSyncPoi.f42203b.equals("")) {
                return null;
            }
            FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
            favoritePoiInfo.f41394a = favSyncPoi.f42202a;
            favoritePoiInfo.f41395b = favSyncPoi.f42203b;
            Point point = favSyncPoi.f42204c;
            favoritePoiInfo.f41396c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
            favoritePoiInfo.f41398e = favSyncPoi.f42206e;
            favoritePoiInfo.f41399f = favSyncPoi.f42207f;
            favoritePoiInfo.f41397d = favSyncPoi.f42205d;
            favoritePoiInfo.f41400g = Long.parseLong(favSyncPoi.f42209h);
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
                favoritePoiInfo.f41396c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
            }
            favoritePoiInfo.f41395b = jSONObject.optString("uspoiname");
            favoritePoiInfo.f41400g = Long.parseLong(jSONObject.optString("addtimesec"));
            favoritePoiInfo.f41397d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
            favoritePoiInfo.f41399f = jSONObject.optString("uspoiuid");
            favoritePoiInfo.f41398e = jSONObject.optString("ncityid");
            favoritePoiInfo.f41394a = jSONObject.optString("key");
            return favoritePoiInfo;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, favoritePoiInfo)) == null) {
            if (favoritePoiInfo == null || favoritePoiInfo.f41396c == null || (str = favoritePoiInfo.f41395b) == null || str.equals("")) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            favSyncPoi.f42203b = favoritePoiInfo.f41395b;
            LatLng latLng = favoritePoiInfo.f41396c;
            favSyncPoi.f42204c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
            favSyncPoi.f42205d = favoritePoiInfo.f41397d;
            favSyncPoi.f42206e = favoritePoiInfo.f41398e;
            favSyncPoi.f42207f = favoritePoiInfo.f41399f;
            favSyncPoi.f42210i = false;
            return favSyncPoi;
        }
        return (FavSyncPoi) invokeL.objValue;
    }
}
