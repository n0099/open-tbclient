package com.baidu.mapapi.favorite;

import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static FavoritePoiInfo a(FavSyncPoi favSyncPoi) {
        if (favSyncPoi == null || favSyncPoi.f7537c == null || favSyncPoi.f7536b.equals("")) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        favoritePoiInfo.f6772a = favSyncPoi.f7535a;
        favoritePoiInfo.f6773b = favSyncPoi.f7536b;
        Point point = favSyncPoi.f7537c;
        favoritePoiInfo.f6774c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
        favoritePoiInfo.f6776e = favSyncPoi.f7539e;
        favoritePoiInfo.f6777f = favSyncPoi.f7540f;
        favoritePoiInfo.f6775d = favSyncPoi.f7538d;
        favoritePoiInfo.f6778g = Long.parseLong(favSyncPoi.f7542h);
        return favoritePoiInfo;
    }

    public static FavoritePoiInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.PLATFORM_TYPE);
        if (optJSONObject != null) {
            favoritePoiInfo.f6774c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
        }
        favoritePoiInfo.f6773b = jSONObject.optString("uspoiname");
        favoritePoiInfo.f6778g = Long.parseLong(jSONObject.optString("addtimesec"));
        favoritePoiInfo.f6775d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
        favoritePoiInfo.f6777f = jSONObject.optString("uspoiuid");
        favoritePoiInfo.f6776e = jSONObject.optString("ncityid");
        favoritePoiInfo.f6772a = jSONObject.optString("key");
        return favoritePoiInfo;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        String str;
        if (favoritePoiInfo == null || favoritePoiInfo.f6774c == null || (str = favoritePoiInfo.f6773b) == null || str.equals("")) {
            return null;
        }
        FavSyncPoi favSyncPoi = new FavSyncPoi();
        favSyncPoi.f7536b = favoritePoiInfo.f6773b;
        LatLng latLng = favoritePoiInfo.f6774c;
        favSyncPoi.f7537c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
        favSyncPoi.f7538d = favoritePoiInfo.f6775d;
        favSyncPoi.f7539e = favoritePoiInfo.f6776e;
        favSyncPoi.f7540f = favoritePoiInfo.f6777f;
        favSyncPoi.i = false;
        return favSyncPoi;
    }
}
