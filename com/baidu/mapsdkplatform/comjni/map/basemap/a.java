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
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7933a = "a";

    /* renamed from: d  reason: collision with root package name */
    public static Set<Integer> f7934d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public static List<JNIBaseMap> f7935e = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f7936b = 0;

    /* renamed from: c  reason: collision with root package name */
    public JNIBaseMap f7937c;

    public a() {
        this.f7937c = null;
        this.f7937c = new JNIBaseMap();
    }

    public static int a(long j, int i, int i2, int i3) {
        return JNIBaseMap.MapProc(j, i, i2, i3);
    }

    public static List<JNIBaseMap> b() {
        return f7935e;
    }

    public static void b(long j, boolean z) {
        JNIBaseMap.SetMapCustomEnable(j, z);
    }

    public long a() {
        return this.f7936b;
    }

    public long a(int i, int i2, String str) {
        return this.f7937c.AddLayer(this.f7936b, i, i2, str);
    }

    public String a(int i, int i2) {
        return this.f7937c.ScrPtToGeoPoint(this.f7936b, i, i2);
    }

    public String a(int i, int i2, int i3, int i4) {
        return this.f7937c.GetNearlyObjID(this.f7936b, i, i2, i3, i4);
    }

    public String a(String str) {
        return this.f7937c.OnSchcityGet(this.f7936b, str);
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        this.f7937c.setCustomTrafficColor(this.f7936b, j, j2, j3, j4, z);
    }

    public void a(long j, boolean z) {
        this.f7937c.ShowLayers(this.f7936b, j, z);
    }

    public void a(Bundle bundle) {
        this.f7937c.SetMapStatus(this.f7936b, bundle);
    }

    public void a(String str, Bundle bundle) {
        this.f7937c.SaveScreenToLocal(this.f7936b, str, bundle);
    }

    public void a(boolean z) {
        this.f7937c.ShowSatelliteMap(this.f7936b, z);
    }

    public void a(Bundle[] bundleArr) {
        this.f7937c.addOverlayItems(this.f7936b, bundleArr, bundleArr.length);
    }

    public boolean a(int i) {
        this.f7936b = (f7935e.size() == 0 || !f7934d.contains(Integer.valueOf(i))) ? this.f7937c.Create() : this.f7937c.CreateDuplicate(f7935e.get(0).f7932a);
        JNIBaseMap jNIBaseMap = this.f7937c;
        jNIBaseMap.f7932a = this.f7936b;
        f7935e.add(jNIBaseMap);
        f7934d.add(Integer.valueOf(i));
        this.f7937c.SetCallback(this.f7936b, null);
        return true;
    }

    public boolean a(int i, boolean z) {
        return this.f7937c.OnRecordReload(this.f7936b, i, z);
    }

    public boolean a(int i, boolean z, int i2) {
        return this.f7937c.OnRecordStart(this.f7936b, i, z, i2);
    }

    public boolean a(long j) {
        return this.f7937c.LayersIsShow(this.f7936b, j);
    }

    public boolean a(long j, long j2) {
        return this.f7937c.SwitchLayer(this.f7936b, j, j2);
    }

    public boolean a(String str, String str2) {
        return this.f7937c.SwitchBaseIndoorMapFloor(this.f7936b, str, str2);
    }

    public boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return this.f7937c.Init(this.f7936b, str, str2, str3, str4, str5, str6, str7, i != 0 ? String.valueOf(i) : null, str8, i2, i3, i4, i5, i6, i7, i8);
    }

    public boolean a(boolean z, boolean z2) {
        return this.f7937c.OnRecordImport(this.f7936b, z, z2);
    }

    public int[] a(int[] iArr, int i, int i2) {
        return this.f7937c.GetScreenBuf(this.f7936b, iArr, i, i2);
    }

    public String b(int i, int i2) {
        return this.f7937c.GeoPtToScrPoint(this.f7936b, i, i2);
    }

    public void b(long j) {
        this.f7937c.UpdateLayers(this.f7936b, j);
    }

    public void b(Bundle bundle) {
        this.f7937c.setMapStatusLimits(this.f7936b, bundle);
    }

    public void b(boolean z) {
        this.f7937c.ShowHotMap(this.f7936b, z);
    }

    public boolean b(int i) {
        this.f7937c.Release(this.f7936b);
        f7935e.remove(this.f7937c);
        f7934d.remove(Integer.valueOf(i));
        return true;
    }

    public boolean b(int i, boolean z) {
        return this.f7937c.OnRecordRemove(this.f7936b, i, z);
    }

    public boolean b(int i, boolean z, int i2) {
        return this.f7937c.OnRecordSuspend(this.f7936b, i, z, i2);
    }

    public float c(Bundle bundle) {
        return this.f7937c.GetZoomToBound(this.f7936b, bundle);
    }

    public int c(int i) {
        return this.f7937c.SetMapControlMode(this.f7936b, i);
    }

    public void c() {
        this.f7937c.OnPause(this.f7936b);
    }

    public void c(boolean z) {
        this.f7937c.ShowTrafficMap(this.f7936b, z);
    }

    public boolean c(long j) {
        return this.f7937c.cleanSDKTileDataCache(this.f7936b, j);
    }

    public void d() {
        this.f7937c.OnResume(this.f7936b);
    }

    public void d(long j) {
        this.f7937c.ClearLayer(this.f7936b, j);
    }

    public void d(boolean z) {
        this.f7937c.enableDrawHouseHeight(this.f7936b, z);
    }

    public boolean d(int i) {
        return this.f7937c.OnRecordAdd(this.f7936b, i);
    }

    public boolean d(Bundle bundle) {
        return this.f7937c.updateSDKTile(this.f7936b, bundle);
    }

    public String e(int i) {
        return this.f7937c.OnRecordGetAt(this.f7936b, i);
    }

    public String e(long j) {
        return this.f7937c.getCompassPosition(this.f7936b, j);
    }

    public void e() {
        this.f7937c.OnBackground(this.f7936b);
    }

    public void e(boolean z) {
        this.f7937c.ShowBaseIndoorMap(this.f7936b, z);
    }

    public boolean e(Bundle bundle) {
        return this.f7937c.addtileOverlay(this.f7936b, bundle);
    }

    public void f() {
        this.f7937c.OnForeground(this.f7936b);
    }

    public void f(Bundle bundle) {
        this.f7937c.addOneOverlayItem(this.f7936b, bundle);
    }

    public void g() {
        this.f7937c.ResetImageRes(this.f7936b);
    }

    public void g(Bundle bundle) {
        this.f7937c.updateOneOverlayItem(this.f7936b, bundle);
    }

    public Bundle h() {
        return this.f7937c.GetMapStatus(this.f7936b);
    }

    public void h(Bundle bundle) {
        this.f7937c.removeOneOverlayItem(this.f7936b, bundle);
    }

    public Bundle i() {
        return this.f7937c.getMapStatusLimits(this.f7936b);
    }

    public Bundle j() {
        return this.f7937c.getDrawingMapStatus(this.f7936b);
    }

    public boolean k() {
        return this.f7937c.GetBaiduHotMapCityInfo(this.f7936b);
    }

    public String l() {
        return this.f7937c.OnRecordGetAll(this.f7936b);
    }

    public String m() {
        return this.f7937c.OnHotcityGet(this.f7936b);
    }

    public void n() {
        this.f7937c.PostStatInfo(this.f7936b);
    }

    public boolean o() {
        return this.f7937c.isDrawHouseHeightEnable(this.f7936b);
    }

    public void p() {
        this.f7937c.clearHeatMapLayerCache(this.f7936b);
    }

    public MapBaseIndoorMapInfo q() {
        JSONArray optJSONArray;
        String str = this.f7937c.getfocusedBaseIndoorMapInfo(this.f7936b);
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
        return this.f7937c.IsBaseIndoorMapMode(this.f7936b);
    }

    public void s() {
        this.f7937c.setBackgroundTransparent(this.f7936b);
    }

    public void t() {
        this.f7937c.resetBackgroundTransparent(this.f7936b);
    }

    public float[] u() {
        JNIBaseMap jNIBaseMap = this.f7937c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getProjectionMatrix(this.f7936b, fArr, 16);
        return fArr;
    }

    public float[] v() {
        JNIBaseMap jNIBaseMap = this.f7937c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getViewMatrix(this.f7936b, fArr, 16);
        return fArr;
    }
}
