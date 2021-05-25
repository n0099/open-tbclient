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
        if (favSyncPoi == null || favSyncPoi.f7536c == null || favSyncPoi.f7535b.equals("")) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        favoritePoiInfo.f6754a = favSyncPoi.f7534a;
        favoritePoiInfo.f6755b = favSyncPoi.f7535b;
        Point point = favSyncPoi.f7536c;
        favoritePoiInfo.f6756c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
        favoritePoiInfo.f6758e = favSyncPoi.f7538e;
        favoritePoiInfo.f6759f = favSyncPoi.f7539f;
        favoritePoiInfo.f6757d = favSyncPoi.f7537d;
        favoritePoiInfo.f6760g = Long.parseLong(favSyncPoi.f7541h);
        return favoritePoiInfo;
    }

    public static FavoritePoiInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.PLATFORM_TYPE);
        if (optJSONObject != null) {
            favoritePoiInfo.f6756c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
        }
        favoritePoiInfo.f6755b = jSONObject.optString("uspoiname");
        favoritePoiInfo.f6760g = Long.parseLong(jSONObject.optString("addtimesec"));
        favoritePoiInfo.f6757d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
        favoritePoiInfo.f6759f = jSONObject.optString("uspoiuid");
        favoritePoiInfo.f6758e = jSONObject.optString("ncityid");
        favoritePoiInfo.f6754a = jSONObject.optString("key");
        return favoritePoiInfo;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        String str;
        if (favoritePoiInfo == null || favoritePoiInfo.f6756c == null || (str = favoritePoiInfo.f6755b) == null || str.equals("")) {
            return null;
        }
        FavSyncPoi favSyncPoi = new FavSyncPoi();
        favSyncPoi.f7535b = favoritePoiInfo.f6755b;
        LatLng latLng = favoritePoiInfo.f6756c;
        favSyncPoi.f7536c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
        favSyncPoi.f7537d = favoritePoiInfo.f6757d;
        favSyncPoi.f7538e = favoritePoiInfo.f6758e;
        favSyncPoi.f7539f = favoritePoiInfo.f6759f;
        favSyncPoi.f7542i = false;
        return favSyncPoi;
    }
}
