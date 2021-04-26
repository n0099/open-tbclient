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
        if (favSyncPoi == null || favSyncPoi.f7839c == null || favSyncPoi.f7838b.equals("")) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        favoritePoiInfo.f7043a = favSyncPoi.f7837a;
        favoritePoiInfo.f7044b = favSyncPoi.f7838b;
        Point point = favSyncPoi.f7839c;
        favoritePoiInfo.f7045c = new LatLng(point.y / 1000000.0d, point.x / 1000000.0d);
        favoritePoiInfo.f7047e = favSyncPoi.f7841e;
        favoritePoiInfo.f7048f = favSyncPoi.f7842f;
        favoritePoiInfo.f7046d = favSyncPoi.f7840d;
        favoritePoiInfo.f7049g = Long.parseLong(favSyncPoi.f7844h);
        return favoritePoiInfo;
    }

    public static FavoritePoiInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.PLATFORM_TYPE);
        if (optJSONObject != null) {
            favoritePoiInfo.f7045c = new LatLng(optJSONObject.optInt("y") / 1000000.0d, optJSONObject.optInt("x") / 1000000.0d);
        }
        favoritePoiInfo.f7044b = jSONObject.optString("uspoiname");
        favoritePoiInfo.f7049g = Long.parseLong(jSONObject.optString("addtimesec"));
        favoritePoiInfo.f7046d = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
        favoritePoiInfo.f7048f = jSONObject.optString("uspoiuid");
        favoritePoiInfo.f7047e = jSONObject.optString("ncityid");
        favoritePoiInfo.f7043a = jSONObject.optString("key");
        return favoritePoiInfo;
    }

    public static FavSyncPoi a(FavoritePoiInfo favoritePoiInfo) {
        String str;
        if (favoritePoiInfo == null || favoritePoiInfo.f7045c == null || (str = favoritePoiInfo.f7044b) == null || str.equals("")) {
            return null;
        }
        FavSyncPoi favSyncPoi = new FavSyncPoi();
        favSyncPoi.f7838b = favoritePoiInfo.f7044b;
        LatLng latLng = favoritePoiInfo.f7045c;
        favSyncPoi.f7839c = new Point((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
        favSyncPoi.f7840d = favoritePoiInfo.f7046d;
        favSyncPoi.f7841e = favoritePoiInfo.f7047e;
        favSyncPoi.f7842f = favoritePoiInfo.f7048f;
        favSyncPoi.f7845i = false;
        return favSyncPoi;
    }
}
