package com.baidu.mapapi.favorite;

import android.util.Log;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.mapsdkplatform.comapi.map.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class FavoriteManager {
    private static FavoriteManager a;
    private static com.baidu.mapsdkplatform.comapi.favrite.a b;

    private FavoriteManager() {
    }

    public static FavoriteManager getInstance() {
        if (a == null) {
            a = new FavoriteManager();
        }
        return a;
    }

    public int add(FavoritePoiInfo favoritePoiInfo) {
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return 0;
        } else if (favoritePoiInfo == null || favoritePoiInfo.c == null) {
            Log.e("baidumapsdk", "object or pt can not be null!");
            return 0;
        } else if (favoritePoiInfo.b == null || favoritePoiInfo.b.equals("")) {
            Log.e("baidumapsdk", "poiName can not be null or empty!");
            return -1;
        } else {
            FavSyncPoi a2 = a.a(favoritePoiInfo);
            int a3 = b.a(a2.b, a2);
            if (a3 == 1) {
                favoritePoiInfo.a = a2.a;
                favoritePoiInfo.g = Long.parseLong(a2.h);
                return a3;
            }
            return a3;
        }
    }

    public boolean clearAllFavPois() {
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        }
        return b.c();
    }

    public boolean deleteFavPoi(String str) {
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        } else if (str == null || str.equals("")) {
            return false;
        } else {
            return b.a(str);
        }
    }

    public void destroy() {
        if (b != null) {
            b.b();
            b = null;
            BMapManager.destroy();
            j.b();
        }
    }

    public List<FavoritePoiInfo> getAllFavPois() {
        JSONArray optJSONArray;
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        }
        String f = b.f();
        if (f == null || f.equals("")) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(f);
            if (jSONObject.optInt("favpoinum") == 0 || (optJSONArray = jSONObject.optJSONArray("favcontents")) == null || optJSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    arrayList.add(a.a(jSONObject2));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public FavoritePoiInfo getFavPoi(String str) {
        FavSyncPoi b2;
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        } else if (str == null || str.equals("") || (b2 = b.b(str)) == null) {
            return null;
        } else {
            return a.a(b2);
        }
    }

    public void init() {
        if (b == null) {
            j.a();
            BMapManager.init();
            b = com.baidu.mapsdkplatform.comapi.favrite.a.a();
        }
    }

    public boolean updateFavPoi(String str, FavoritePoiInfo favoritePoiInfo) {
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        } else if (str == null || str.equals("") || favoritePoiInfo == null) {
            return false;
        } else {
            if (favoritePoiInfo == null || favoritePoiInfo.c == null) {
                Log.e("baidumapsdk", "object or pt can not be null!");
                return false;
            } else if (favoritePoiInfo.b == null || favoritePoiInfo.b.equals("")) {
                Log.e("baidumapsdk", "poiName can not be null or empty!");
                return false;
            } else {
                favoritePoiInfo.a = str;
                return b.b(str, a.a(favoritePoiInfo));
            }
        }
    }
}
