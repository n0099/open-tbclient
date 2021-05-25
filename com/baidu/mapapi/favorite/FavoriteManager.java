package com.baidu.mapapi.favorite;

import android.util.Log;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.mapsdkplatform.comapi.map.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FavoriteManager {

    /* renamed from: a  reason: collision with root package name */
    public static FavoriteManager f6752a;

    /* renamed from: b  reason: collision with root package name */
    public static com.baidu.mapsdkplatform.comapi.favrite.a f6753b;

    public static FavoriteManager getInstance() {
        if (f6752a == null) {
            f6752a = new FavoriteManager();
        }
        return f6752a;
    }

    public int add(FavoritePoiInfo favoritePoiInfo) {
        String str;
        if (f6753b == null) {
            str = "you may have not call init method!";
        } else if (favoritePoiInfo != null && favoritePoiInfo.f6756c != null) {
            String str2 = favoritePoiInfo.f6755b;
            if (str2 == null || str2.equals("")) {
                Log.e("baidumapsdk", "poiName can not be null or empty!");
                return -1;
            }
            FavSyncPoi a2 = a.a(favoritePoiInfo);
            int a3 = f6753b.a(a2.f7535b, a2);
            if (a3 == 1) {
                favoritePoiInfo.f6754a = a2.f7534a;
                favoritePoiInfo.f6760g = Long.parseLong(a2.f7541h);
            }
            return a3;
        } else {
            str = "object or pt can not be null!";
        }
        Log.e("baidumapsdk", str);
        return 0;
    }

    public boolean clearAllFavPois() {
        com.baidu.mapsdkplatform.comapi.favrite.a aVar = f6753b;
        if (aVar == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        }
        return aVar.c();
    }

    public boolean deleteFavPoi(String str) {
        if (f6753b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        } else if (str == null || str.equals("")) {
            return false;
        } else {
            return f6753b.a(str);
        }
    }

    public void destroy() {
        com.baidu.mapsdkplatform.comapi.favrite.a aVar = f6753b;
        if (aVar != null) {
            aVar.b();
            f6753b = null;
            BMapManager.destroy();
            i.b();
        }
    }

    public List<FavoritePoiInfo> getAllFavPois() {
        JSONArray optJSONArray;
        com.baidu.mapsdkplatform.comapi.favrite.a aVar = f6753b;
        if (aVar == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        }
        String f2 = aVar.f();
        if (f2 != null && !f2.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(f2);
                if (jSONObject.optInt("favpoinum") != 0 && (optJSONArray = jSONObject.optJSONArray("favcontents")) != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        if (jSONObject2 != null) {
                            arrayList.add(a.a(jSONObject2));
                        }
                    }
                    return arrayList;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public FavoritePoiInfo getFavPoi(String str) {
        FavSyncPoi b2;
        if (f6753b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        } else if (str == null || str.equals("") || (b2 = f6753b.b(str)) == null) {
            return null;
        } else {
            return a.a(b2);
        }
    }

    public void init() {
        if (f6753b == null) {
            i.a();
            BMapManager.init();
            f6753b = com.baidu.mapsdkplatform.comapi.favrite.a.a();
        }
    }

    public boolean updateFavPoi(String str, FavoritePoiInfo favoritePoiInfo) {
        String str2;
        if (f6753b == null) {
            str2 = "you may have not call init method!";
        } else if (str == null || str.equals("") || favoritePoiInfo == null) {
            return false;
        } else {
            if (favoritePoiInfo == null || favoritePoiInfo.f6756c == null) {
                str2 = "object or pt can not be null!";
            } else {
                String str3 = favoritePoiInfo.f6755b;
                if (str3 != null && !str3.equals("")) {
                    favoritePoiInfo.f6754a = str;
                    return f6753b.b(str, a.a(favoritePoiInfo));
                }
                str2 = "poiName can not be null or empty!";
            }
        }
        Log.e("baidumapsdk", str2);
        return false;
    }
}
