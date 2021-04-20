package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.UIMsg;
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
    public static final String f7699a = "r";

    /* renamed from: c  reason: collision with root package name */
    public static r f7700c;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comjni.map.basemap.a f7701b;

    /* renamed from: d  reason: collision with root package name */
    public w f7702d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f7703e;

    public static r a() {
        if (f7700c == null) {
            r rVar = new r();
            f7700c = rVar;
            rVar.g();
        }
        return f7700c;
    }

    private void g() {
        h();
        this.f7702d = new w();
        s sVar = new s(this);
        this.f7703e = sVar;
        MessageCenter.registMessage(UIMsg.m_AppUI.V_WM_VDATAENGINE, sVar);
    }

    private void h() {
        Context context = BMapManager.getContext();
        EnvironmentUtilities.initAppDirectory(context);
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = new com.baidu.mapsdkplatform.comjni.map.basemap.a();
        this.f7701b = aVar;
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
        this.f7701b.a(str2 + "/a/", str4, str6, appSecondCachePath + "/tmp/", str5, str2 + "/a/", null, 0, str2 + "/idrres/", SysOSUtil.getScreenSizeX(), SysOSUtil.getScreenSizeY(), SysOSUtil.getDensityDpi(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, 0);
        this.f7701b.d();
    }

    public ArrayList<q> a(String str) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        JSONArray optJSONArray;
        if (!str.equals("") && (aVar = this.f7701b) != null) {
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
                for (int i = 0; i < optJSONArray.length(); i++) {
                    q qVar = new q();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    int optInt = jSONObject2.optInt("id");
                    if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                        qVar.f7694a = optInt;
                        qVar.f7695b = jSONObject2.optString("name");
                        qVar.f7696c = jSONObject2.optInt("mapsize");
                        qVar.f7697d = jSONObject2.optInt("cty");
                        if (jSONObject2.has("child")) {
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray("child");
                            ArrayList<q> arrayList2 = new ArrayList<>();
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                q qVar2 = new q();
                                JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
                                qVar2.f7694a = optJSONObject.optInt("id");
                                qVar2.f7695b = optJSONObject.optString("name");
                                qVar2.f7696c = optJSONObject.optInt("mapsize");
                                qVar2.f7697d = optJSONObject.optInt("cty");
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
        w wVar = this.f7702d;
        if (wVar != null) {
            wVar.a(vVar);
        }
    }

    public boolean a(int i) {
        if (this.f7701b == null || i < 0) {
            return false;
        }
        if (i <= 2000 || i == 2912 || i == 2911 || i == 9000) {
            return this.f7701b.d(i);
        }
        return false;
    }

    public boolean a(boolean z, boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7701b;
        if (aVar == null) {
            return false;
        }
        return aVar.a(z, z2);
    }

    public void b() {
        MessageCenter.unregistMessage(UIMsg.m_AppUI.V_WM_VDATAENGINE, this.f7703e);
        this.f7701b.b(BMapManager.getContext().hashCode());
        f7700c = null;
    }

    public void b(v vVar) {
        w wVar = this.f7702d;
        if (wVar != null) {
            wVar.b(vVar);
        }
    }

    public boolean b(int i) {
        if (this.f7701b == null || i < 0) {
            return false;
        }
        if (i <= 2000 || i == 2912 || i == 2911 || i == 9000) {
            return this.f7701b.a(i, false, 0);
        }
        return false;
    }

    public ArrayList<q> c() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7701b;
        if (aVar == null) {
            return null;
        }
        String m = aVar.m();
        ArrayList<q> arrayList = new ArrayList<>();
        try {
            JSONArray optJSONArray = new JSONObject(m).optJSONArray(ActionJsonData.TAG_DATASET);
            for (int i = 0; i < optJSONArray.length(); i++) {
                q qVar = new q();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                qVar.f7694a = optJSONObject.optInt("id");
                qVar.f7695b = optJSONObject.optString("name");
                qVar.f7696c = optJSONObject.optInt("mapsize");
                qVar.f7697d = optJSONObject.optInt("cty");
                if (optJSONObject.has("child")) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("child");
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        q qVar2 = new q();
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        qVar2.f7694a = optJSONObject2.optInt("id");
                        qVar2.f7695b = optJSONObject2.optString("name");
                        qVar2.f7696c = optJSONObject2.optInt("mapsize");
                        qVar2.f7697d = optJSONObject2.optInt("cty");
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

    public boolean c(int i) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7701b;
        if (aVar == null || i < 0) {
            return false;
        }
        return aVar.b(i, false, 0);
    }

    public ArrayList<q> d() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7701b;
        ArrayList<q> arrayList = null;
        if (aVar == null) {
            return null;
        }
        String a2 = aVar.a("");
        ArrayList<q> arrayList2 = new ArrayList<>();
        try {
            JSONArray optJSONArray = new JSONObject(a2).optJSONArray(ActionJsonData.TAG_DATASET);
            int i = 0;
            while (i < optJSONArray.length()) {
                q qVar = new q();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                int optInt = optJSONObject.optInt("id");
                if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                    qVar.f7694a = optInt;
                    qVar.f7695b = optJSONObject.optString("name");
                    qVar.f7696c = optJSONObject.optInt("mapsize");
                    qVar.f7697d = optJSONObject.optInt("cty");
                    if (optJSONObject.has("child")) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("child");
                        ArrayList<q> arrayList3 = new ArrayList<>();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            q qVar2 = new q();
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                            try {
                                qVar2.f7694a = optJSONObject2.optInt("id");
                                qVar2.f7695b = optJSONObject2.optString("name");
                                qVar2.f7696c = optJSONObject2.optInt("mapsize");
                                qVar2.f7697d = optJSONObject2.optInt("cty");
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
                i++;
                arrayList = null;
            }
            return arrayList2;
        } catch (JSONException unused3) {
            return arrayList;
        } catch (Exception unused4) {
            return arrayList;
        }
    }

    public boolean d(int i) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7701b;
        if (aVar == null) {
            return false;
        }
        return aVar.b(0, true, i);
    }

    public ArrayList<u> e() {
        String l;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7701b;
        if (aVar != null && (l = aVar.l()) != null && !l.equals("")) {
            ArrayList<u> arrayList = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(l);
                if (jSONObject.length() == 0) {
                    return null;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray(ActionJsonData.TAG_DATASET);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    u uVar = new u();
                    t tVar = new t();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    tVar.f7705a = optJSONObject.optInt("id");
                    tVar.f7706b = optJSONObject.optString("name");
                    tVar.f7707c = optJSONObject.optString("pinyin");
                    tVar.f7712h = optJSONObject.optInt("mapoldsize");
                    tVar.i = optJSONObject.optInt("ratio");
                    tVar.l = optJSONObject.optInt("status");
                    tVar.f7711g = new GeoPoint(optJSONObject.optInt("y"), optJSONObject.optInt("x"));
                    boolean z = true;
                    if (optJSONObject.optInt("up") != 1) {
                        z = false;
                    }
                    tVar.j = z;
                    tVar.f7709e = optJSONObject.optInt("lev");
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

    public boolean e(int i) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7701b;
        if (aVar == null || i < 0) {
            return false;
        }
        return aVar.b(i, false);
    }

    public boolean f(int i) {
        if (this.f7701b == null || i < 0) {
            return false;
        }
        if (i <= 2000 || i == 2912 || i == 2911 || i == 9000) {
            return this.f7701b.a(i, false);
        }
        return false;
    }

    public u g(int i) {
        String e2;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7701b;
        if (aVar != null && i >= 0 && (e2 = aVar.e(i)) != null && !e2.equals("")) {
            u uVar = new u();
            t tVar = new t();
            try {
                JSONObject jSONObject = new JSONObject(e2);
                if (jSONObject.length() == 0) {
                    return null;
                }
                int optInt = jSONObject.optInt("id");
                if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                    tVar.f7705a = optInt;
                    tVar.f7706b = jSONObject.optString("name");
                    tVar.f7707c = jSONObject.optString("pinyin");
                    tVar.f7708d = jSONObject.optString("headchar");
                    tVar.f7712h = jSONObject.optInt("mapoldsize");
                    tVar.i = jSONObject.optInt("ratio");
                    tVar.l = jSONObject.optInt("status");
                    tVar.f7711g = new GeoPoint(jSONObject.optInt("y"), jSONObject.optInt("x"));
                    boolean z = true;
                    if (jSONObject.optInt("up") != 1) {
                        z = false;
                    }
                    tVar.j = z;
                    tVar.f7709e = jSONObject.optInt("lev");
                    if (tVar.j) {
                        tVar.k = jSONObject.optInt("mapsize");
                    } else {
                        tVar.k = 0;
                    }
                    tVar.f7710f = jSONObject.optInt("ver");
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
