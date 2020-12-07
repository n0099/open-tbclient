package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.platform.comapi.basestruct.Point;
import org.json.JSONObject;
/* loaded from: classes26.dex */
class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static FavoritePoiInfo a(FavSyncPoi favSyncPoi) {
        if (favSyncPoi == null || favSyncPoi.c == null || favSyncPoi.b.equals("")) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        favoritePoiInfo.f1992a = favSyncPoi.f2219a;
        favoritePoiInfo.b = favSyncPoi.b;
        favoritePoiInfo.c = new LatLng(favSyncPoi.c.y / 1000000.0d, favSyncPoi.c.x / 1000000.0d);
        favoritePoiInfo.e = favSyncPoi.e;
        favoritePoiInfo.f = favSyncPoi.f;
        favoritePoiInfo.d = favSyncPoi.d;
        favoritePoiInfo.g = Long.parseLong(favSyncPoi.h);
        return favoritePoiInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FavoritePoiInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject("pt");
        if (optJSONObject != null) {
            favoritePoiInfo.c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
        }
        favoritePoiInfo.b = jSONObject.optString("uspoiname");
        favoritePoiInfo.g = Long.parseLong(jSONObject.optString("addtimesec"));
        favoritePoiInfo.d = jSONObject.optString("addr");
        favoritePoiInfo.f = jSONObject.optString("uspoiuid");
        favoritePoiInfo.e = jSONObject.optString("ncityid");
        favoritePoiInfo.f1992a = jSONObject.optString("key");
        return favoritePoiInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        if (favoritePoiInfo == null || favoritePoiInfo.c == null || favoritePoiInfo.b == null || favoritePoiInfo.b.equals("")) {
            return null;
        }
        FavSyncPoi favSyncPoi = new FavSyncPoi();
        favSyncPoi.b = favoritePoiInfo.b;
        favSyncPoi.c = new Point((int) (favoritePoiInfo.c.longitude * 1000000.0d), (int) (favoritePoiInfo.c.latitude * 1000000.0d));
        favSyncPoi.d = favoritePoiInfo.d;
        favSyncPoi.e = favoritePoiInfo.e;
        favSyncPoi.f = favoritePoiInfo.f;
        favSyncPoi.i = false;
        return favSyncPoi;
    }
}
