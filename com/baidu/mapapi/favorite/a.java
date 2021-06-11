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
        if (favSyncPoi == null || favSyncPoi.f7579c == null || favSyncPoi.f7578b.equals("")) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        favoritePoiInfo.f6797a = favSyncPoi.f7577a;
        favoritePoiInfo.f6798b = favSyncPoi.f7578b;
        Point point = favSyncPoi.f7579c;
        favoritePoiInfo.f6799c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
        favoritePoiInfo.f6801e = favSyncPoi.f7581e;
        favoritePoiInfo.f6802f = favSyncPoi.f7582f;
        favoritePoiInfo.f6800d = favSyncPoi.f7580d;
        favoritePoiInfo.f6803g = Long.parseLong(favSyncPoi.f7584h);
        return favoritePoiInfo;
    }

    public static FavoritePoiInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.PLATFORM_TYPE);
        if (optJSONObject != null) {
            favoritePoiInfo.f6799c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
        }
        favoritePoiInfo.f6798b = jSONObject.optString("uspoiname");
        favoritePoiInfo.f6803g = Long.parseLong(jSONObject.optString("addtimesec"));
        favoritePoiInfo.f6800d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
        favoritePoiInfo.f6802f = jSONObject.optString("uspoiuid");
        favoritePoiInfo.f6801e = jSONObject.optString("ncityid");
        favoritePoiInfo.f6797a = jSONObject.optString("key");
        return favoritePoiInfo;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        String str;
        if (favoritePoiInfo == null || favoritePoiInfo.f6799c == null || (str = favoritePoiInfo.f6798b) == null || str.equals("")) {
            return null;
        }
        FavSyncPoi favSyncPoi = new FavSyncPoi();
        favSyncPoi.f7578b = favoritePoiInfo.f6798b;
        LatLng latLng = favoritePoiInfo.f6799c;
        favSyncPoi.f7579c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
        favSyncPoi.f7580d = favoritePoiInfo.f6800d;
        favSyncPoi.f7581e = favoritePoiInfo.f6801e;
        favSyncPoi.f7582f = favoritePoiInfo.f6802f;
        favSyncPoi.f7585i = false;
        return favSyncPoi;
    }
}
