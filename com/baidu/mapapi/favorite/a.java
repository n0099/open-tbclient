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
        favoritePoiInfo.f6771a = favSyncPoi.f7534a;
        favoritePoiInfo.f6772b = favSyncPoi.f7535b;
        Point point = favSyncPoi.f7536c;
        double d2 = point.y;
        Double.isNaN(d2);
        double d3 = point.x;
        Double.isNaN(d3);
        favoritePoiInfo.f6773c = new LatLng(d2 / 1000000.0d, d3 / 1000000.0d);
        favoritePoiInfo.f6775e = favSyncPoi.f7538e;
        favoritePoiInfo.f6776f = favSyncPoi.f7539f;
        favoritePoiInfo.f6774d = favSyncPoi.f7537d;
        favoritePoiInfo.f6777g = Long.parseLong(favSyncPoi.f7541h);
        return favoritePoiInfo;
    }

    public static FavoritePoiInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.PLATFORM_TYPE);
        if (optJSONObject != null) {
            int optInt = optJSONObject.optInt("x");
            double optInt2 = optJSONObject.optInt("y");
            Double.isNaN(optInt2);
            double d2 = optInt;
            Double.isNaN(d2);
            favoritePoiInfo.f6773c = new LatLng(optInt2 / 1000000.0d, d2 / 1000000.0d);
        }
        favoritePoiInfo.f6772b = jSONObject.optString("uspoiname");
        favoritePoiInfo.f6777g = Long.parseLong(jSONObject.optString("addtimesec"));
        favoritePoiInfo.f6774d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
        favoritePoiInfo.f6776f = jSONObject.optString("uspoiuid");
        favoritePoiInfo.f6775e = jSONObject.optString("ncityid");
        favoritePoiInfo.f6771a = jSONObject.optString("key");
        return favoritePoiInfo;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        String str;
        if (favoritePoiInfo == null || favoritePoiInfo.f6773c == null || (str = favoritePoiInfo.f6772b) == null || str.equals("")) {
            return null;
        }
        FavSyncPoi favSyncPoi = new FavSyncPoi();
        favSyncPoi.f7535b = favoritePoiInfo.f6772b;
        LatLng latLng = favoritePoiInfo.f6773c;
        favSyncPoi.f7536c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
        favSyncPoi.f7537d = favoritePoiInfo.f6774d;
        favSyncPoi.f7538e = favoritePoiInfo.f6775e;
        favSyncPoi.f7539f = favoritePoiInfo.f6776f;
        favSyncPoi.i = false;
        return favSyncPoi;
    }
}
