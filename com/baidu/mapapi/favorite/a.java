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
        if (favSyncPoi == null || favSyncPoi.f7572c == null || favSyncPoi.f7571b.equals("")) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        favoritePoiInfo.f6807a = favSyncPoi.f7570a;
        favoritePoiInfo.f6808b = favSyncPoi.f7571b;
        Point point = favSyncPoi.f7572c;
        favoritePoiInfo.f6809c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
        favoritePoiInfo.f6811e = favSyncPoi.f7574e;
        favoritePoiInfo.f6812f = favSyncPoi.f7575f;
        favoritePoiInfo.f6810d = favSyncPoi.f7573d;
        favoritePoiInfo.f6813g = Long.parseLong(favSyncPoi.f7577h);
        return favoritePoiInfo;
    }

    public static FavoritePoiInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.PLATFORM_TYPE);
        if (optJSONObject != null) {
            favoritePoiInfo.f6809c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
        }
        favoritePoiInfo.f6808b = jSONObject.optString("uspoiname");
        favoritePoiInfo.f6813g = Long.parseLong(jSONObject.optString("addtimesec"));
        favoritePoiInfo.f6810d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
        favoritePoiInfo.f6812f = jSONObject.optString("uspoiuid");
        favoritePoiInfo.f6811e = jSONObject.optString("ncityid");
        favoritePoiInfo.f6807a = jSONObject.optString("key");
        return favoritePoiInfo;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        String str;
        if (favoritePoiInfo == null || favoritePoiInfo.f6809c == null || (str = favoritePoiInfo.f6808b) == null || str.equals("")) {
            return null;
        }
        FavSyncPoi favSyncPoi = new FavSyncPoi();
        favSyncPoi.f7571b = favoritePoiInfo.f6808b;
        LatLng latLng = favoritePoiInfo.f6809c;
        favSyncPoi.f7572c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
        favSyncPoi.f7573d = favoritePoiInfo.f6810d;
        favSyncPoi.f7574e = favoritePoiInfo.f6811e;
        favSyncPoi.f7575f = favoritePoiInfo.f6812f;
        favSyncPoi.i = false;
        return favSyncPoi;
    }
}
