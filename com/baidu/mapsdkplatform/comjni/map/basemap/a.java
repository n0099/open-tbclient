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
    public static final String f7898a = "a";

    /* renamed from: d  reason: collision with root package name */
    public static Set<Integer> f7899d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public static List<JNIBaseMap> f7900e = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f7901b = 0;

    /* renamed from: c  reason: collision with root package name */
    public JNIBaseMap f7902c;

    public a() {
        this.f7902c = null;
        this.f7902c = new JNIBaseMap();
    }

    public static int a(long j, int i, int i2, int i3) {
        return JNIBaseMap.MapProc(j, i, i2, i3);
    }

    public static List<JNIBaseMap> b() {
        return f7900e;
    }

    public static void b(long j, boolean z) {
        JNIBaseMap.SetMapCustomEnable(j, z);
    }

    public long a() {
        return this.f7901b;
    }

    public long a(int i, int i2, String str) {
        return this.f7902c.AddLayer(this.f7901b, i, i2, str);
    }

    public String a(int i, int i2) {
        return this.f7902c.ScrPtToGeoPoint(this.f7901b, i, i2);
    }

    public String a(int i, int i2, int i3, int i4) {
        return this.f7902c.GetNearlyObjID(this.f7901b, i, i2, i3, i4);
    }

    public String a(String str) {
        return this.f7902c.OnSchcityGet(this.f7901b, str);
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        this.f7902c.setCustomTrafficColor(this.f7901b, j, j2, j3, j4, z);
    }

    public void a(long j, boolean z) {
        this.f7902c.ShowLayers(this.f7901b, j, z);
    }

    public void a(Bundle bundle) {
        this.f7902c.SetMapStatus(this.f7901b, bundle);
    }

    public void a(String str, Bundle bundle) {
        this.f7902c.SaveScreenToLocal(this.f7901b, str, bundle);
    }

    public void a(boolean z) {
        this.f7902c.ShowSatelliteMap(this.f7901b, z);
    }

    public void a(Bundle[] bundleArr) {
        this.f7902c.addOverlayItems(this.f7901b, bundleArr, bundleArr.length);
    }

    public boolean a(int i) {
        this.f7901b = (f7900e.size() == 0 || !f7899d.contains(Integer.valueOf(i))) ? this.f7902c.Create() : this.f7902c.CreateDuplicate(f7900e.get(0).f7897a);
        JNIBaseMap jNIBaseMap = this.f7902c;
        jNIBaseMap.f7897a = this.f7901b;
        f7900e.add(jNIBaseMap);
        f7899d.add(Integer.valueOf(i));
        this.f7902c.SetCallback(this.f7901b, null);
        return true;
    }

    public boolean a(int i, boolean z) {
        return this.f7902c.OnRecordReload(this.f7901b, i, z);
    }

    public boolean a(int i, boolean z, int i2) {
        return this.f7902c.OnRecordStart(this.f7901b, i, z, i2);
    }

    public boolean a(long j) {
        return this.f7902c.LayersIsShow(this.f7901b, j);
    }

    public boolean a(long j, long j2) {
        return this.f7902c.SwitchLayer(this.f7901b, j, j2);
    }

    public boolean a(String str, String str2) {
        return this.f7902c.SwitchBaseIndoorMapFloor(this.f7901b, str, str2);
    }

    public boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return this.f7902c.Init(this.f7901b, str, str2, str3, str4, str5, str6, str7, i != 0 ? String.valueOf(i) : null, str8, i2, i3, i4, i5, i6, i7, i8);
    }

    public boolean a(boolean z, boolean z2) {
        return this.f7902c.OnRecordImport(this.f7901b, z, z2);
    }

    public int[] a(int[] iArr, int i, int i2) {
        return this.f7902c.GetScreenBuf(this.f7901b, iArr, i, i2);
    }

    public String b(int i, int i2) {
        return this.f7902c.GeoPtToScrPoint(this.f7901b, i, i2);
    }

    public void b(long j) {
        this.f7902c.UpdateLayers(this.f7901b, j);
    }

    public void b(Bundle bundle) {
        this.f7902c.setMapStatusLimits(this.f7901b, bundle);
    }

    public void b(boolean z) {
        this.f7902c.ShowHotMap(this.f7901b, z);
    }

    public boolean b(int i) {
        this.f7902c.Release(this.f7901b);
        f7900e.remove(this.f7902c);
        f7899d.remove(Integer.valueOf(i));
        return true;
    }

    public boolean b(int i, boolean z) {
        return this.f7902c.OnRecordRemove(this.f7901b, i, z);
    }

    public boolean b(int i, boolean z, int i2) {
        return this.f7902c.OnRecordSuspend(this.f7901b, i, z, i2);
    }

    public float c(Bundle bundle) {
        return this.f7902c.GetZoomToBound(this.f7901b, bundle);
    }

    public int c(int i) {
        return this.f7902c.SetMapControlMode(this.f7901b, i);
    }

    public void c() {
        this.f7902c.OnPause(this.f7901b);
    }

    public void c(boolean z) {
        this.f7902c.ShowTrafficMap(this.f7901b, z);
    }

    public boolean c(long j) {
        return this.f7902c.cleanSDKTileDataCache(this.f7901b, j);
    }

    public void d() {
        this.f7902c.OnResume(this.f7901b);
    }

    public void d(long j) {
        this.f7902c.ClearLayer(this.f7901b, j);
    }

    public void d(boolean z) {
        this.f7902c.enableDrawHouseHeight(this.f7901b, z);
    }

    public boolean d(int i) {
        return this.f7902c.OnRecordAdd(this.f7901b, i);
    }

    public boolean d(Bundle bundle) {
        return this.f7902c.updateSDKTile(this.f7901b, bundle);
    }

    public String e(int i) {
        return this.f7902c.OnRecordGetAt(this.f7901b, i);
    }

    public String e(long j) {
        return this.f7902c.getCompassPosition(this.f7901b, j);
    }

    public void e() {
        this.f7902c.OnBackground(this.f7901b);
    }

    public void e(boolean z) {
        this.f7902c.ShowBaseIndoorMap(this.f7901b, z);
    }

    public boolean e(Bundle bundle) {
        return this.f7902c.addtileOverlay(this.f7901b, bundle);
    }

    public void f() {
        this.f7902c.OnForeground(this.f7901b);
    }

    public void f(Bundle bundle) {
        this.f7902c.addOneOverlayItem(this.f7901b, bundle);
    }

    public void g() {
        this.f7902c.ResetImageRes(this.f7901b);
    }

    public void g(Bundle bundle) {
        this.f7902c.updateOneOverlayItem(this.f7901b, bundle);
    }

    public Bundle h() {
        return this.f7902c.GetMapStatus(this.f7901b);
    }

    public void h(Bundle bundle) {
        this.f7902c.removeOneOverlayItem(this.f7901b, bundle);
    }

    public Bundle i() {
        return this.f7902c.getMapStatusLimits(this.f7901b);
    }

    public Bundle j() {
        return this.f7902c.getDrawingMapStatus(this.f7901b);
    }

    public boolean k() {
        return this.f7902c.GetBaiduHotMapCityInfo(this.f7901b);
    }

    public String l() {
        return this.f7902c.OnRecordGetAll(this.f7901b);
    }

    public String m() {
        return this.f7902c.OnHotcityGet(this.f7901b);
    }

    public void n() {
        this.f7902c.PostStatInfo(this.f7901b);
    }

    public boolean o() {
        return this.f7902c.isDrawHouseHeightEnable(this.f7901b);
    }

    public void p() {
        this.f7902c.clearHeatMapLayerCache(this.f7901b);
    }

    public MapBaseIndoorMapInfo q() {
        JSONArray optJSONArray;
        String str = this.f7902c.getfocusedBaseIndoorMapInfo(this.f7901b);
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
        return this.f7902c.IsBaseIndoorMapMode(this.f7901b);
    }

    public void s() {
        this.f7902c.setBackgroundTransparent(this.f7901b);
    }

    public void t() {
        this.f7902c.resetBackgroundTransparent(this.f7901b);
    }

    public float[] u() {
        JNIBaseMap jNIBaseMap = this.f7902c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getProjectionMatrix(this.f7901b, fArr, 16);
        return fArr;
    }

    public float[] v() {
        JNIBaseMap jNIBaseMap = this.f7902c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getViewMatrix(this.f7901b, fArr, 16);
        return fArr;
    }
}
