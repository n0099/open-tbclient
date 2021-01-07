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
/* loaded from: classes3.dex */
public class FavoriteManager {

    /* renamed from: a  reason: collision with root package name */
    private static FavoriteManager f2779a;

    /* renamed from: b  reason: collision with root package name */
    private static com.baidu.mapsdkplatform.comapi.favrite.a f2780b;

    private FavoriteManager() {
    }

    public static FavoriteManager getInstance() {
        if (f2779a == null) {
            f2779a = new FavoriteManager();
        }
        return f2779a;
    }

    public int add(FavoritePoiInfo favoritePoiInfo) {
        if (f2780b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return 0;
        } else if (favoritePoiInfo == null || favoritePoiInfo.c == null) {
            Log.e("baidumapsdk", "object or pt can not be null!");
            return 0;
        } else if (favoritePoiInfo.f2782b == null || favoritePoiInfo.f2782b.equals("")) {
            Log.e("baidumapsdk", "poiName can not be null or empty!");
            return -1;
        } else {
            FavSyncPoi a2 = a.a(favoritePoiInfo);
            int a3 = f2780b.a(a2.f3160b, a2);
            if (a3 == 1) {
                favoritePoiInfo.f2781a = a2.f3159a;
                favoritePoiInfo.g = Long.parseLong(a2.h);
                return a3;
            }
            return a3;
        }
    }

    public boolean clearAllFavPois() {
        if (f2780b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        }
        return f2780b.c();
    }

    public boolean deleteFavPoi(String str) {
        if (f2780b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        } else if (str == null || str.equals("")) {
            return false;
        } else {
            return f2780b.a(str);
        }
    }

    public void destroy() {
        if (f2780b != null) {
            f2780b.b();
            f2780b = null;
            BMapManager.destroy();
            j.b();
        }
    }

    public List<FavoritePoiInfo> getAllFavPois() {
        JSONArray optJSONArray;
        if (f2780b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        }
        String f = f2780b.f();
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
        if (f2780b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        } else if (str == null || str.equals("") || (b2 = f2780b.b(str)) == null) {
            return null;
        } else {
            return a.a(b2);
        }
    }

    public void init() {
        if (f2780b == null) {
            j.a();
            BMapManager.init();
            f2780b = com.baidu.mapsdkplatform.comapi.favrite.a.a();
        }
    }

    public boolean updateFavPoi(String str, FavoritePoiInfo favoritePoiInfo) {
        if (f2780b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        } else if (str == null || str.equals("") || favoritePoiInfo == null) {
            return false;
        } else {
            if (favoritePoiInfo == null || favoritePoiInfo.c == null) {
                Log.e("baidumapsdk", "object or pt can not be null!");
                return false;
            } else if (favoritePoiInfo.f2782b == null || favoritePoiInfo.f2782b.equals("")) {
                Log.e("baidumapsdk", "poiName can not be null or empty!");
                return false;
            } else {
                favoritePoiInfo.f2781a = str;
                return f2780b.b(str, a.a(favoritePoiInfo));
            }
        }
    }
}
