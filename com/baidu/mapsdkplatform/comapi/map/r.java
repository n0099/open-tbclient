package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7715a = "r";

    /* renamed from: c  reason: collision with root package name */
    public static r f7716c;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comjni.map.basemap.a f7717b;

    /* renamed from: d  reason: collision with root package name */
    public w f7718d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f7719e;

    public static r a() {
        if (f7716c == null) {
            r rVar = new r();
            f7716c = rVar;
            rVar.g();
        }
        return f7716c;
    }

    private void g() {
        h();
        this.f7718d = new w();
        s sVar = new s(this);
        this.f7719e = sVar;
        MessageCenter.registMessage(65289, sVar);
    }

    private void h() {
        Context context = BMapManager.getContext();
        EnvironmentUtilities.initAppDirectory(context);
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = new com.baidu.mapsdkplatform.comjni.map.basemap.a();
        this.f7717b = aVar;
        aVar.a(context.hashCode());
        String moduleFileName = SysOSUtil.getModuleFileName();
        String appSDCardPath = EnvironmentUtilities.getAppSDCardPath();
        String appCachePath = EnvironmentUtilities.getAppCachePath();
        String appSecondCachePath = EnvironmentUtilities.getAppSecondCachePath();
        int mapTmpStgMax = EnvironmentUtilities.getMapTmpStgMax();
        int domTmpStgMax = EnvironmentUtilities.getDomTmpStgMax();
        int itsTmpStgMax = EnvironmentUtilities.getItsTmpStgMax();
        String str = SysOSUtil.getDensityDpi() >= 180 ? "/h/" : "/l/";
        String str2 = moduleFileName + "/cfg";
        String str3 = appSDCardPath + "/vmp";
        String str4 = str3 + str;
        String str5 = str3 + str;
        String str6 = appCachePath + "/tmp/";
        this.f7717b.a(str2 + "/a/", str4, str6, appSecondCachePath + "/tmp/", str5, str2 + "/a/", null, 0, str2 + "/idrres/", SysOSUtil.getScreenSizeX(), SysOSUtil.getScreenSizeY(), SysOSUtil.getDensityDpi(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, 0);
        this.f7717b.d();
    }

    public ArrayList<q> a(String str) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        JSONArray optJSONArray;
        if (!str.equals("") && (aVar = this.f7717b) != null) {
            String a2 = aVar.a(str);
            if (a2 == null || a2.equals("")) {
                return null;
            }
            ArrayList<q> arrayList = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(a2);
                if (jSONObject.length() == 0 || (optJSONArray = jSONObject.optJSONArray(ActionJsonData.TAG_DATASET)) == null) {
                    return null;
                }
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    q qVar = new q();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    int optInt = jSONObject2.optInt("id");
                    if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                        qVar.f7710a = optInt;
                        qVar.f7711b = jSONObject2.optString("name");
                        qVar.f7712c = jSONObject2.optInt("mapsize");
                        qVar.f7713d = jSONObject2.optInt("cty");
                        if (jSONObject2.has("child")) {
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray("child");
                            ArrayList<q> arrayList2 = new ArrayList<>();
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                q qVar2 = new q();
                                JSONObject optJSONObject = optJSONArray2.optJSONObject(i3);
                                qVar2.f7710a = optJSONObject.optInt("id");
                                qVar2.f7711b = optJSONObject.optString("name");
                                qVar2.f7712c = optJSONObject.optInt("mapsize");
                                qVar2.f7713d = optJSONObject.optInt("cty");
                                arrayList2.add(qVar2);
                            }
                            qVar.a(arrayList2);
                        }
                        arrayList.add(qVar);
                    }
                }
                return arrayList;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void a(v vVar) {
        w wVar = this.f7718d;
        if (wVar != null) {
            wVar.a(vVar);
        }
    }

    public boolean a(int i2) {
        if (this.f7717b == null || i2 < 0) {
            return false;
        }
        if (i2 <= 2000 || i2 == 2912 || i2 == 2911 || i2 == 9000) {
            return this.f7717b.d(i2);
        }
        return false;
    }

    public boolean a(boolean z, boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7717b;
        if (aVar == null) {
            return false;
        }
        return aVar.a(z, z2);
    }

    public void b() {
        MessageCenter.unregistMessage(65289, this.f7719e);
        this.f7717b.b(BMapManager.getContext().hashCode());
        f7716c = null;
    }

    public void b(v vVar) {
        w wVar = this.f7718d;
        if (wVar != null) {
            wVar.b(vVar);
        }
    }

    public boolean b(int i2) {
        if (this.f7717b == null || i2 < 0) {
            return false;
        }
        if (i2 <= 2000 || i2 == 2912 || i2 == 2911 || i2 == 9000) {
            return this.f7717b.a(i2, false, 0);
        }
        return false;
    }

    public ArrayList<q> c() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7717b;
        if (aVar == null) {
            return null;
        }
        String m = aVar.m();
        ArrayList<q> arrayList = new ArrayList<>();
        try {
            JSONArray optJSONArray = new JSONObject(m).optJSONArray(ActionJsonData.TAG_DATASET);
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                q qVar = new q();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                qVar.f7710a = optJSONObject.optInt("id");
                qVar.f7711b = optJSONObject.optString("name");
                qVar.f7712c = optJSONObject.optInt("mapsize");
                qVar.f7713d = optJSONObject.optInt("cty");
                if (optJSONObject.has("child")) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("child");
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        q qVar2 = new q();
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                        qVar2.f7710a = optJSONObject2.optInt("id");
                        qVar2.f7711b = optJSONObject2.optString("name");
                        qVar2.f7712c = optJSONObject2.optInt("mapsize");
                        qVar2.f7713d = optJSONObject2.optInt("cty");
                        arrayList2.add(qVar2);
                    }
                    qVar.a(arrayList2);
                }
                arrayList.add(qVar);
            }
            return arrayList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean c(int i2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7717b;
        if (aVar == null || i2 < 0) {
            return false;
        }
        return aVar.b(i2, false, 0);
    }

    public ArrayList<q> d() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7717b;
        ArrayList<q> arrayList = null;
        if (aVar == null) {
            return null;
        }
        String a2 = aVar.a("");
        ArrayList<q> arrayList2 = new ArrayList<>();
        try {
            JSONArray optJSONArray = new JSONObject(a2).optJSONArray(ActionJsonData.TAG_DATASET);
            int i2 = 0;
            while (i2 < optJSONArray.length()) {
                q qVar = new q();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                int optInt = optJSONObject.optInt("id");
                if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                    qVar.f7710a = optInt;
                    qVar.f7711b = optJSONObject.optString("name");
                    qVar.f7712c = optJSONObject.optInt("mapsize");
                    qVar.f7713d = optJSONObject.optInt("cty");
                    if (optJSONObject.has("child")) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("child");
                        ArrayList<q> arrayList3 = new ArrayList<>();
                        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            q qVar2 = new q();
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                            try {
                                qVar2.f7710a = optJSONObject2.optInt("id");
                                qVar2.f7711b = optJSONObject2.optString("name");
                                qVar2.f7712c = optJSONObject2.optInt("mapsize");
                                qVar2.f7713d = optJSONObject2.optInt("cty");
                                arrayList3.add(qVar2);
                            } catch (JSONException unused) {
                                return null;
                            } catch (Exception unused2) {
                                return null;
                            }
                        }
                        qVar.a(arrayList3);
                    }
                    arrayList2.add(qVar);
                }
                i2++;
                arrayList = null;
            }
            return arrayList2;
        } catch (JSONException unused3) {
            return arrayList;
        } catch (Exception unused4) {
            return arrayList;
        }
    }

    public boolean d(int i2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7717b;
        if (aVar == null) {
            return false;
        }
        return aVar.b(0, true, i2);
    }

    public ArrayList<u> e() {
        String l;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7717b;
        if (aVar != null && (l = aVar.l()) != null && !l.equals("")) {
            ArrayList<u> arrayList = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(l);
                if (jSONObject.length() == 0) {
                    return null;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray(ActionJsonData.TAG_DATASET);
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    u uVar = new u();
                    t tVar = new t();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    tVar.f7721a = optJSONObject.optInt("id");
                    tVar.f7722b = optJSONObject.optString("name");
                    tVar.f7723c = optJSONObject.optString("pinyin");
                    tVar.f7728h = optJSONObject.optInt("mapoldsize");
                    tVar.f7729i = optJSONObject.optInt("ratio");
                    tVar.l = optJSONObject.optInt("status");
                    tVar.f7727g = new GeoPoint(optJSONObject.optInt("y"), optJSONObject.optInt("x"));
                    boolean z = true;
                    if (optJSONObject.optInt("up") != 1) {
                        z = false;
                    }
                    tVar.j = z;
                    tVar.f7725e = optJSONObject.optInt("lev");
                    if (tVar.j) {
                        tVar.k = optJSONObject.optInt("mapsize");
                    } else {
                        tVar.k = 0;
                    }
                    uVar.a(tVar);
                    arrayList.add(uVar);
                }
                return arrayList;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public boolean e(int i2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7717b;
        if (aVar == null || i2 < 0) {
            return false;
        }
        return aVar.b(i2, false);
    }

    public boolean f(int i2) {
        if (this.f7717b == null || i2 < 0) {
            return false;
        }
        if (i2 <= 2000 || i2 == 2912 || i2 == 2911 || i2 == 9000) {
            return this.f7717b.a(i2, false);
        }
        return false;
    }

    public u g(int i2) {
        String e2;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7717b;
        if (aVar != null && i2 >= 0 && (e2 = aVar.e(i2)) != null && !e2.equals("")) {
            u uVar = new u();
            t tVar = new t();
            try {
                JSONObject jSONObject = new JSONObject(e2);
                if (jSONObject.length() == 0) {
                    return null;
                }
                int optInt = jSONObject.optInt("id");
                if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                    tVar.f7721a = optInt;
                    tVar.f7722b = jSONObject.optString("name");
                    tVar.f7723c = jSONObject.optString("pinyin");
                    tVar.f7724d = jSONObject.optString("headchar");
                    tVar.f7728h = jSONObject.optInt("mapoldsize");
                    tVar.f7729i = jSONObject.optInt("ratio");
                    tVar.l = jSONObject.optInt("status");
                    tVar.f7727g = new GeoPoint(jSONObject.optInt("y"), jSONObject.optInt("x"));
                    boolean z = true;
                    if (jSONObject.optInt("up") != 1) {
                        z = false;
                    }
                    tVar.j = z;
                    tVar.f7725e = jSONObject.optInt("lev");
                    if (tVar.j) {
                        tVar.k = jSONObject.optInt("mapsize");
                    } else {
                        tVar.k = 0;
                    }
                    tVar.f7726f = jSONObject.optInt("ver");
                    uVar.a(tVar);
                    return uVar;
                }
                return null;
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }
}
