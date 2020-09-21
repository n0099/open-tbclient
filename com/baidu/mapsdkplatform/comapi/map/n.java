package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {
    private static final String a = n.class.getSimpleName();
    private static n c;
    private AppBaseMap b;
    private s d;
    private Handler e;

    private n() {
    }

    public static n a() {
        if (c == null) {
            c = new n();
            c.g();
        }
        return c;
    }

    private void g() {
        h();
        this.d = new s();
        this.e = new o(this);
        MessageCenter.registMessage(65289, this.e);
    }

    private void h() {
        EnvironmentUtilities.initAppDirectory(BMapManager.getContext());
        this.b = new AppBaseMap();
        this.b.Create();
        String moduleFileName = SysOSUtil.getModuleFileName();
        String appSDCardPath = EnvironmentUtilities.getAppSDCardPath();
        String appCachePath = EnvironmentUtilities.getAppCachePath();
        String appSecondCachePath = EnvironmentUtilities.getAppSecondCachePath();
        int mapTmpStgMax = EnvironmentUtilities.getMapTmpStgMax();
        int domTmpStgMax = EnvironmentUtilities.getDomTmpStgMax();
        int itsTmpStgMax = EnvironmentUtilities.getItsTmpStgMax();
        int ssgTmpStgMax = EnvironmentUtilities.getSsgTmpStgMax();
        String str = com.baidu.platform.comapi.util.SysOSUtil.getInstance().getDensityDPI() >= 180 ? "/h/" : "/l/";
        String str2 = moduleFileName + "/cfg";
        String str3 = appSDCardPath + "/vmp";
        this.b.Init(str2 + "/a/", str2 + "/idrres/", str3 + str, appCachePath + "/tmp/", appSecondCachePath + "/tmp/", str3 + str, str2 + "/a/", com.baidu.platform.comapi.util.SysOSUtil.getInstance().getScreenWidth(), com.baidu.platform.comapi.util.SysOSUtil.getInstance().getScreenHeight(), com.baidu.platform.comapi.util.SysOSUtil.getInstance().getDensityDPI(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, ssgTmpStgMax, false, false);
        this.b.OnResume();
    }

    public ArrayList<m> a(String str) {
        String OnSchcityGet;
        JSONArray optJSONArray;
        if (str.equals("") || this.b == null || (OnSchcityGet = this.b.OnSchcityGet(str)) == null || OnSchcityGet.equals("")) {
            return null;
        }
        ArrayList<m> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(OnSchcityGet);
            if (jSONObject == null || jSONObject.length() == 0 || (optJSONArray = jSONObject.optJSONArray("dataset")) == null) {
                return null;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                m mVar = new m();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                int optInt = jSONObject2.optInt("id");
                if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                    mVar.a = optInt;
                    mVar.b = jSONObject2.optString("name");
                    mVar.c = jSONObject2.optInt("mapsize");
                    mVar.d = jSONObject2.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                    if (jSONObject2.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD)) {
                        JSONArray optJSONArray2 = jSONObject2.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
                        ArrayList<m> arrayList2 = new ArrayList<>();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            m mVar2 = new m();
                            JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
                            mVar2.a = optJSONObject.optInt("id");
                            mVar2.b = optJSONObject.optString("name");
                            mVar2.c = optJSONObject.optInt("mapsize");
                            mVar2.d = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                            arrayList2.add(mVar2);
                        }
                        mVar.a(arrayList2);
                    }
                    arrayList.add(mVar);
                }
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(r rVar) {
        if (this.d != null) {
            this.d.a(rVar);
        }
    }

    public boolean a(int i) {
        if (this.b == null || i < 0) {
            return false;
        }
        if (i <= 2000 || i == 2912 || i == 2911 || i == 9000) {
            return this.b.OnRecordAdd(i);
        }
        return false;
    }

    public boolean a(boolean z, boolean z2) {
        if (this.b == null) {
            return false;
        }
        return this.b.OnRecordImport(z, z2);
    }

    public void b() {
        MessageCenter.unregistMessage(65289, this.e);
        this.b.Release();
        c = null;
    }

    public void b(r rVar) {
        if (this.d != null) {
            this.d.b(rVar);
        }
    }

    public boolean b(int i) {
        if (this.b == null || i < 0) {
            return false;
        }
        if (i <= 2000 || i == 2912 || i == 2911 || i == 9000) {
            return this.b.OnRecordStart(i, false, 0);
        }
        return false;
    }

    public ArrayList<m> c() {
        if (this.b == null) {
            return null;
        }
        String OnHotcityGet = this.b.OnHotcityGet();
        ArrayList<m> arrayList = new ArrayList<>();
        try {
            JSONArray optJSONArray = new JSONObject(OnHotcityGet).optJSONArray("dataset");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    m mVar = new m();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    mVar.a = optJSONObject.optInt("id");
                    mVar.b = optJSONObject.optString("name");
                    mVar.c = optJSONObject.optInt("mapsize");
                    mVar.d = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                    if (optJSONObject.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD)) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
                        ArrayList<m> arrayList2 = new ArrayList<>();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            m mVar2 = new m();
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                            mVar2.a = optJSONObject2.optInt("id");
                            mVar2.b = optJSONObject2.optString("name");
                            mVar2.c = optJSONObject2.optInt("mapsize");
                            mVar2.d = optJSONObject2.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                            arrayList2.add(mVar2);
                        }
                        mVar.a(arrayList2);
                    }
                    arrayList.add(mVar);
                }
                return arrayList;
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean c(int i) {
        if (this.b == null || i < 0) {
            return false;
        }
        return this.b.OnRecordSuspend(i, false, 0);
    }

    public ArrayList<m> d() {
        if (this.b == null) {
            return null;
        }
        String OnSchcityGet = this.b.OnSchcityGet("");
        ArrayList<m> arrayList = new ArrayList<>();
        try {
            JSONArray optJSONArray = new JSONObject(OnSchcityGet).optJSONArray("dataset");
            for (int i = 0; i < optJSONArray.length(); i++) {
                m mVar = new m();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                int optInt = optJSONObject.optInt("id");
                if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                    mVar.a = optInt;
                    mVar.b = optJSONObject.optString("name");
                    mVar.c = optJSONObject.optInt("mapsize");
                    mVar.d = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                    if (optJSONObject.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD)) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
                        ArrayList<m> arrayList2 = new ArrayList<>();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            m mVar2 = new m();
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                            mVar2.a = optJSONObject2.optInt("id");
                            mVar2.b = optJSONObject2.optString("name");
                            mVar2.c = optJSONObject2.optInt("mapsize");
                            mVar2.d = optJSONObject2.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                            arrayList2.add(mVar2);
                        }
                        mVar.a(arrayList2);
                    }
                    arrayList.add(mVar);
                }
            }
            return arrayList;
        } catch (JSONException e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public boolean d(int i) {
        if (this.b == null) {
            return false;
        }
        return this.b.OnRecordSuspend(0, true, i);
    }

    public ArrayList<q> e() {
        String OnRecordGetAll;
        if (this.b == null || (OnRecordGetAll = this.b.OnRecordGetAll()) == null || OnRecordGetAll.equals("")) {
            return null;
        }
        ArrayList<q> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(OnRecordGetAll);
            if (jSONObject.length() != 0) {
                JSONArray optJSONArray = jSONObject.optJSONArray("dataset");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    q qVar = new q();
                    p pVar = new p();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    pVar.a = optJSONObject.optInt("id");
                    pVar.b = optJSONObject.optString("name");
                    pVar.c = optJSONObject.optString("pinyin");
                    pVar.h = optJSONObject.optInt("mapoldsize");
                    pVar.i = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_RATION);
                    pVar.l = optJSONObject.optInt("status");
                    pVar.g = new GeoPoint(optJSONObject.optInt("y"), optJSONObject.optInt("x"));
                    pVar.j = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_UPDATE) == 1;
                    pVar.e = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_LEVEL);
                    if (pVar.j) {
                        pVar.k = optJSONObject.optInt("mapsize");
                    } else {
                        pVar.k = 0;
                    }
                    qVar.a(pVar);
                    arrayList.add(qVar);
                }
                return arrayList;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean e(int i) {
        if (this.b == null || i < 0) {
            return false;
        }
        return this.b.OnRecordRemove(i, false);
    }

    public boolean f(int i) {
        if (this.b == null || i < 0) {
            return false;
        }
        if (i <= 2000 || i == 2912 || i == 2911 || i == 9000) {
            return this.b.OnRecordReload(i, false);
        }
        return false;
    }

    public q g(int i) {
        String OnRecordGetAt;
        q qVar = null;
        if (this.b == null || i < 0 || (OnRecordGetAt = this.b.OnRecordGetAt(i)) == null || OnRecordGetAt.equals("")) {
            return null;
        }
        q qVar2 = new q();
        p pVar = new p();
        try {
            JSONObject jSONObject = new JSONObject(OnRecordGetAt);
            if (jSONObject.length() != 0) {
                int optInt = jSONObject.optInt("id");
                if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                    pVar.a = optInt;
                    pVar.b = jSONObject.optString("name");
                    pVar.c = jSONObject.optString("pinyin");
                    pVar.d = jSONObject.optString("headchar");
                    pVar.h = jSONObject.optInt("mapoldsize");
                    pVar.i = jSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_RATION);
                    pVar.l = jSONObject.optInt("status");
                    pVar.g = new GeoPoint(jSONObject.optInt("y"), jSONObject.optInt("x"));
                    pVar.j = jSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_UPDATE) == 1;
                    pVar.e = jSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_LEVEL);
                    if (pVar.j) {
                        pVar.k = jSONObject.optInt("mapsize");
                    } else {
                        pVar.k = 0;
                    }
                    pVar.f = jSONObject.optInt("ver");
                    qVar2.a(pVar);
                    qVar = qVar2;
                    return qVar;
                }
                return null;
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return qVar;
        }
    }
}
