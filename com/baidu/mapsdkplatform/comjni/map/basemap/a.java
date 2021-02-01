package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3170a = a.class.getSimpleName();
    private static Set<Integer> d = new HashSet();
    private static List<JNIBaseMap> e = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private long f3171b = 0;
    private JNIBaseMap c;

    public a() {
        this.c = null;
        this.c = new JNIBaseMap();
    }

    public static int a(long j, int i, int i2, int i3) {
        return JNIBaseMap.MapProc(j, i, i2, i3);
    }

    public static List<JNIBaseMap> b() {
        return e;
    }

    public static void b(long j, boolean z) {
        JNIBaseMap.SetMapCustomEnable(j, z);
    }

    public long a() {
        return this.f3171b;
    }

    public long a(int i, int i2, String str) {
        return this.c.AddLayer(this.f3171b, i, i2, str);
    }

    public String a(int i, int i2) {
        return this.c.ScrPtToGeoPoint(this.f3171b, i, i2);
    }

    public String a(int i, int i2, int i3, int i4) {
        return this.c.GetNearlyObjID(this.f3171b, i, i2, i3, i4);
    }

    public String a(String str) {
        return this.c.OnSchcityGet(this.f3171b, str);
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        this.c.setCustomTrafficColor(this.f3171b, j, j2, j3, j4, z);
    }

    public void a(long j, boolean z) {
        this.c.ShowLayers(this.f3171b, j, z);
    }

    public void a(Bundle bundle) {
        this.c.SetMapStatus(this.f3171b, bundle);
    }

    public void a(String str, Bundle bundle) {
        this.c.SaveScreenToLocal(this.f3171b, str, bundle);
    }

    public void a(boolean z) {
        this.c.ShowSatelliteMap(this.f3171b, z);
    }

    public void a(Bundle[] bundleArr) {
        this.c.addOverlayItems(this.f3171b, bundleArr, bundleArr.length);
    }

    public boolean a(int i) {
        if (e.size() == 0 || !d.contains(Integer.valueOf(i))) {
            this.f3171b = this.c.Create();
        } else {
            this.f3171b = this.c.CreateDuplicate(e.get(0).f3169a);
        }
        this.c.f3169a = this.f3171b;
        e.add(this.c);
        d.add(Integer.valueOf(i));
        this.c.SetCallback(this.f3171b, null);
        return true;
    }

    public boolean a(int i, boolean z) {
        return this.c.OnRecordReload(this.f3171b, i, z);
    }

    public boolean a(int i, boolean z, int i2) {
        return this.c.OnRecordStart(this.f3171b, i, z, i2);
    }

    public boolean a(long j) {
        return this.c.LayersIsShow(this.f3171b, j);
    }

    public boolean a(long j, long j2) {
        return this.c.SwitchLayer(this.f3171b, j, j2);
    }

    public boolean a(String str, String str2) {
        return this.c.SwitchBaseIndoorMapFloor(this.f3171b, str, str2);
    }

    public boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return this.c.Init(this.f3171b, str, str2, str3, str4, str5, str6, str7, i != 0 ? String.valueOf(i) : null, str8, i2, i3, i4, i5, i6, i7, i8);
    }

    public boolean a(boolean z, boolean z2) {
        return this.c.OnRecordImport(this.f3171b, z, z2);
    }

    public int[] a(int[] iArr, int i, int i2) {
        return this.c.GetScreenBuf(this.f3171b, iArr, i, i2);
    }

    public String b(int i, int i2) {
        return this.c.GeoPtToScrPoint(this.f3171b, i, i2);
    }

    public void b(long j) {
        this.c.UpdateLayers(this.f3171b, j);
    }

    public void b(Bundle bundle) {
        this.c.setMapStatusLimits(this.f3171b, bundle);
    }

    public void b(boolean z) {
        this.c.ShowHotMap(this.f3171b, z);
    }

    public boolean b(int i) {
        this.c.Release(this.f3171b);
        e.remove(this.c);
        d.remove(Integer.valueOf(i));
        return true;
    }

    public boolean b(int i, boolean z) {
        return this.c.OnRecordRemove(this.f3171b, i, z);
    }

    public boolean b(int i, boolean z, int i2) {
        return this.c.OnRecordSuspend(this.f3171b, i, z, i2);
    }

    public float c(Bundle bundle) {
        return this.c.GetZoomToBound(this.f3171b, bundle);
    }

    public int c(int i) {
        return this.c.SetMapControlMode(this.f3171b, i);
    }

    public void c() {
        this.c.OnPause(this.f3171b);
    }

    public void c(boolean z) {
        this.c.ShowTrafficMap(this.f3171b, z);
    }

    public boolean c(long j) {
        return this.c.cleanSDKTileDataCache(this.f3171b, j);
    }

    public void d() {
        this.c.OnResume(this.f3171b);
    }

    public void d(long j) {
        this.c.ClearLayer(this.f3171b, j);
    }

    public void d(boolean z) {
        this.c.enableDrawHouseHeight(this.f3171b, z);
    }

    public boolean d(int i) {
        return this.c.OnRecordAdd(this.f3171b, i);
    }

    public boolean d(Bundle bundle) {
        return this.c.updateSDKTile(this.f3171b, bundle);
    }

    public String e(int i) {
        return this.c.OnRecordGetAt(this.f3171b, i);
    }

    public String e(long j) {
        return this.c.getCompassPosition(this.f3171b, j);
    }

    public void e() {
        this.c.OnBackground(this.f3171b);
    }

    public void e(boolean z) {
        this.c.ShowBaseIndoorMap(this.f3171b, z);
    }

    public boolean e(Bundle bundle) {
        return this.c.addtileOverlay(this.f3171b, bundle);
    }

    public void f() {
        this.c.OnForeground(this.f3171b);
    }

    public void f(Bundle bundle) {
        this.c.addOneOverlayItem(this.f3171b, bundle);
    }

    public void g() {
        this.c.ResetImageRes(this.f3171b);
    }

    public void g(Bundle bundle) {
        this.c.updateOneOverlayItem(this.f3171b, bundle);
    }

    public Bundle h() {
        return this.c.GetMapStatus(this.f3171b);
    }

    public void h(Bundle bundle) {
        this.c.removeOneOverlayItem(this.f3171b, bundle);
    }

    public Bundle i() {
        return this.c.getMapStatusLimits(this.f3171b);
    }

    public Bundle j() {
        return this.c.getDrawingMapStatus(this.f3171b);
    }

    public boolean k() {
        return this.c.GetBaiduHotMapCityInfo(this.f3171b);
    }

    public String l() {
        return this.c.OnRecordGetAll(this.f3171b);
    }

    public String m() {
        return this.c.OnHotcityGet(this.f3171b);
    }

    public void n() {
        this.c.PostStatInfo(this.f3171b);
    }

    public boolean o() {
        return this.c.isDrawHouseHeightEnable(this.f3171b);
    }

    public void p() {
        this.c.clearHeatMapLayerCache(this.f3171b);
    }

    public MapBaseIndoorMapInfo q() {
        JSONArray optJSONArray;
        String str = this.c.getfocusedBaseIndoorMapInfo(this.f3171b);
        if (str == null) {
            return null;
        }
        String str2 = "";
        String str3 = new String();
        ArrayList arrayList = new ArrayList(1);
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("focusindoorid");
            str3 = jSONObject.optString("curfloor");
            optJSONArray = jSONObject.optJSONArray("floorlist");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (optJSONArray == null) {
            return null;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.get(i).toString());
        }
        return new MapBaseIndoorMapInfo(str2, str3, arrayList);
    }

    public boolean r() {
        return this.c.IsBaseIndoorMapMode(this.f3171b);
    }

    public void s() {
        this.c.setBackgroundTransparent(this.f3171b);
    }

    public void t() {
        this.c.resetBackgroundTransparent(this.f3171b);
    }

    public float[] u() {
        if (this.c == null) {
            return null;
        }
        float[] fArr = new float[16];
        this.c.getProjectionMatrix(this.f3171b, fArr, 16);
        return fArr;
    }

    public float[] v() {
        if (this.c == null) {
            return null;
        }
        float[] fArr = new float[16];
        this.c.getViewMatrix(this.f3171b, fArr, 16);
        return fArr;
    }
}
