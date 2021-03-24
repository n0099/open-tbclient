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
    public static final String f7897a = "a";

    /* renamed from: d  reason: collision with root package name */
    public static Set<Integer> f7898d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public static List<JNIBaseMap> f7899e = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f7900b = 0;

    /* renamed from: c  reason: collision with root package name */
    public JNIBaseMap f7901c;

    public a() {
        this.f7901c = null;
        this.f7901c = new JNIBaseMap();
    }

    public static int a(long j, int i, int i2, int i3) {
        return JNIBaseMap.MapProc(j, i, i2, i3);
    }

    public static List<JNIBaseMap> b() {
        return f7899e;
    }

    public static void b(long j, boolean z) {
        JNIBaseMap.SetMapCustomEnable(j, z);
    }

    public long a() {
        return this.f7900b;
    }

    public long a(int i, int i2, String str) {
        return this.f7901c.AddLayer(this.f7900b, i, i2, str);
    }

    public String a(int i, int i2) {
        return this.f7901c.ScrPtToGeoPoint(this.f7900b, i, i2);
    }

    public String a(int i, int i2, int i3, int i4) {
        return this.f7901c.GetNearlyObjID(this.f7900b, i, i2, i3, i4);
    }

    public String a(String str) {
        return this.f7901c.OnSchcityGet(this.f7900b, str);
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        this.f7901c.setCustomTrafficColor(this.f7900b, j, j2, j3, j4, z);
    }

    public void a(long j, boolean z) {
        this.f7901c.ShowLayers(this.f7900b, j, z);
    }

    public void a(Bundle bundle) {
        this.f7901c.SetMapStatus(this.f7900b, bundle);
    }

    public void a(String str, Bundle bundle) {
        this.f7901c.SaveScreenToLocal(this.f7900b, str, bundle);
    }

    public void a(boolean z) {
        this.f7901c.ShowSatelliteMap(this.f7900b, z);
    }

    public void a(Bundle[] bundleArr) {
        this.f7901c.addOverlayItems(this.f7900b, bundleArr, bundleArr.length);
    }

    public boolean a(int i) {
        this.f7900b = (f7899e.size() == 0 || !f7898d.contains(Integer.valueOf(i))) ? this.f7901c.Create() : this.f7901c.CreateDuplicate(f7899e.get(0).f7896a);
        JNIBaseMap jNIBaseMap = this.f7901c;
        jNIBaseMap.f7896a = this.f7900b;
        f7899e.add(jNIBaseMap);
        f7898d.add(Integer.valueOf(i));
        this.f7901c.SetCallback(this.f7900b, null);
        return true;
    }

    public boolean a(int i, boolean z) {
        return this.f7901c.OnRecordReload(this.f7900b, i, z);
    }

    public boolean a(int i, boolean z, int i2) {
        return this.f7901c.OnRecordStart(this.f7900b, i, z, i2);
    }

    public boolean a(long j) {
        return this.f7901c.LayersIsShow(this.f7900b, j);
    }

    public boolean a(long j, long j2) {
        return this.f7901c.SwitchLayer(this.f7900b, j, j2);
    }

    public boolean a(String str, String str2) {
        return this.f7901c.SwitchBaseIndoorMapFloor(this.f7900b, str, str2);
    }

    public boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return this.f7901c.Init(this.f7900b, str, str2, str3, str4, str5, str6, str7, i != 0 ? String.valueOf(i) : null, str8, i2, i3, i4, i5, i6, i7, i8);
    }

    public boolean a(boolean z, boolean z2) {
        return this.f7901c.OnRecordImport(this.f7900b, z, z2);
    }

    public int[] a(int[] iArr, int i, int i2) {
        return this.f7901c.GetScreenBuf(this.f7900b, iArr, i, i2);
    }

    public String b(int i, int i2) {
        return this.f7901c.GeoPtToScrPoint(this.f7900b, i, i2);
    }

    public void b(long j) {
        this.f7901c.UpdateLayers(this.f7900b, j);
    }

    public void b(Bundle bundle) {
        this.f7901c.setMapStatusLimits(this.f7900b, bundle);
    }

    public void b(boolean z) {
        this.f7901c.ShowHotMap(this.f7900b, z);
    }

    public boolean b(int i) {
        this.f7901c.Release(this.f7900b);
        f7899e.remove(this.f7901c);
        f7898d.remove(Integer.valueOf(i));
        return true;
    }

    public boolean b(int i, boolean z) {
        return this.f7901c.OnRecordRemove(this.f7900b, i, z);
    }

    public boolean b(int i, boolean z, int i2) {
        return this.f7901c.OnRecordSuspend(this.f7900b, i, z, i2);
    }

    public float c(Bundle bundle) {
        return this.f7901c.GetZoomToBound(this.f7900b, bundle);
    }

    public int c(int i) {
        return this.f7901c.SetMapControlMode(this.f7900b, i);
    }

    public void c() {
        this.f7901c.OnPause(this.f7900b);
    }

    public void c(boolean z) {
        this.f7901c.ShowTrafficMap(this.f7900b, z);
    }

    public boolean c(long j) {
        return this.f7901c.cleanSDKTileDataCache(this.f7900b, j);
    }

    public void d() {
        this.f7901c.OnResume(this.f7900b);
    }

    public void d(long j) {
        this.f7901c.ClearLayer(this.f7900b, j);
    }

    public void d(boolean z) {
        this.f7901c.enableDrawHouseHeight(this.f7900b, z);
    }

    public boolean d(int i) {
        return this.f7901c.OnRecordAdd(this.f7900b, i);
    }

    public boolean d(Bundle bundle) {
        return this.f7901c.updateSDKTile(this.f7900b, bundle);
    }

    public String e(int i) {
        return this.f7901c.OnRecordGetAt(this.f7900b, i);
    }

    public String e(long j) {
        return this.f7901c.getCompassPosition(this.f7900b, j);
    }

    public void e() {
        this.f7901c.OnBackground(this.f7900b);
    }

    public void e(boolean z) {
        this.f7901c.ShowBaseIndoorMap(this.f7900b, z);
    }

    public boolean e(Bundle bundle) {
        return this.f7901c.addtileOverlay(this.f7900b, bundle);
    }

    public void f() {
        this.f7901c.OnForeground(this.f7900b);
    }

    public void f(Bundle bundle) {
        this.f7901c.addOneOverlayItem(this.f7900b, bundle);
    }

    public void g() {
        this.f7901c.ResetImageRes(this.f7900b);
    }

    public void g(Bundle bundle) {
        this.f7901c.updateOneOverlayItem(this.f7900b, bundle);
    }

    public Bundle h() {
        return this.f7901c.GetMapStatus(this.f7900b);
    }

    public void h(Bundle bundle) {
        this.f7901c.removeOneOverlayItem(this.f7900b, bundle);
    }

    public Bundle i() {
        return this.f7901c.getMapStatusLimits(this.f7900b);
    }

    public Bundle j() {
        return this.f7901c.getDrawingMapStatus(this.f7900b);
    }

    public boolean k() {
        return this.f7901c.GetBaiduHotMapCityInfo(this.f7900b);
    }

    public String l() {
        return this.f7901c.OnRecordGetAll(this.f7900b);
    }

    public String m() {
        return this.f7901c.OnHotcityGet(this.f7900b);
    }

    public void n() {
        this.f7901c.PostStatInfo(this.f7900b);
    }

    public boolean o() {
        return this.f7901c.isDrawHouseHeightEnable(this.f7900b);
    }

    public void p() {
        this.f7901c.clearHeatMapLayerCache(this.f7900b);
    }

    public MapBaseIndoorMapInfo q() {
        JSONArray optJSONArray;
        String str = this.f7901c.getfocusedBaseIndoorMapInfo(this.f7900b);
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
        return this.f7901c.IsBaseIndoorMapMode(this.f7900b);
    }

    public void s() {
        this.f7901c.setBackgroundTransparent(this.f7900b);
    }

    public void t() {
        this.f7901c.resetBackgroundTransparent(this.f7900b);
    }

    public float[] u() {
        JNIBaseMap jNIBaseMap = this.f7901c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getProjectionMatrix(this.f7900b, fArr, 16);
        return fArr;
    }

    public float[] v() {
        JNIBaseMap jNIBaseMap = this.f7901c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getViewMatrix(this.f7900b, fArr, 16);
        return fArr;
    }
}
