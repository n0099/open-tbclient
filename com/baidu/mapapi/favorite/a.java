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
        if (favSyncPoi == null || favSyncPoi.f7636c == null || favSyncPoi.f7635b.equals("")) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        favoritePoiInfo.f6854a = favSyncPoi.f7634a;
        favoritePoiInfo.f6855b = favSyncPoi.f7635b;
        Point point = favSyncPoi.f7636c;
        favoritePoiInfo.f6856c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
        favoritePoiInfo.f6858e = favSyncPoi.f7638e;
        favoritePoiInfo.f6859f = favSyncPoi.f7639f;
        favoritePoiInfo.f6857d = favSyncPoi.f7637d;
        favoritePoiInfo.f6860g = Long.parseLong(favSyncPoi.f7641h);
        return favoritePoiInfo;
    }

    public static FavoritePoiInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.PLATFORM_TYPE);
        if (optJSONObject != null) {
            favoritePoiInfo.f6856c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
        }
        favoritePoiInfo.f6855b = jSONObject.optString("uspoiname");
        favoritePoiInfo.f6860g = Long.parseLong(jSONObject.optString("addtimesec"));
        favoritePoiInfo.f6857d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
        favoritePoiInfo.f6859f = jSONObject.optString("uspoiuid");
        favoritePoiInfo.f6858e = jSONObject.optString("ncityid");
        favoritePoiInfo.f6854a = jSONObject.optString("key");
        return favoritePoiInfo;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        String str;
        if (favoritePoiInfo == null || favoritePoiInfo.f6856c == null || (str = favoritePoiInfo.f6855b) == null || str.equals("")) {
            return null;
        }
        FavSyncPoi favSyncPoi = new FavSyncPoi();
        favSyncPoi.f7635b = favoritePoiInfo.f6855b;
        LatLng latLng = favoritePoiInfo.f6856c;
        favSyncPoi.f7636c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
        favSyncPoi.f7637d = favoritePoiInfo.f6857d;
        favSyncPoi.f7638e = favoritePoiInfo.f6858e;
        favSyncPoi.f7639f = favoritePoiInfo.f6859f;
        favSyncPoi.f7642i = false;
        return favSyncPoi;
    }
}
