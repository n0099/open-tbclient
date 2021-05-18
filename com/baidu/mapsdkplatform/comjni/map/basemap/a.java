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
    public static final String f8032a = "a";

    /* renamed from: d  reason: collision with root package name */
    public static Set<Integer> f8033d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public static List<JNIBaseMap> f8034e = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f8035b = 0;

    /* renamed from: c  reason: collision with root package name */
    public JNIBaseMap f8036c;

    public a() {
        this.f8036c = null;
        this.f8036c = new JNIBaseMap();
    }

    public static int a(long j, int i2, int i3, int i4) {
        return JNIBaseMap.MapProc(j, i2, i3, i4);
    }

    public static List<JNIBaseMap> b() {
        return f8034e;
    }

    public static void b(long j, boolean z) {
        JNIBaseMap.SetMapCustomEnable(j, z);
    }

    public long a() {
        return this.f8035b;
    }

    public long a(int i2, int i3, String str) {
        return this.f8036c.AddLayer(this.f8035b, i2, i3, str);
    }

    public String a(int i2, int i3) {
        return this.f8036c.ScrPtToGeoPoint(this.f8035b, i2, i3);
    }

    public String a(int i2, int i3, int i4, int i5) {
        return this.f8036c.GetNearlyObjID(this.f8035b, i2, i3, i4, i5);
    }

    public String a(String str) {
        return this.f8036c.OnSchcityGet(this.f8035b, str);
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        this.f8036c.setCustomTrafficColor(this.f8035b, j, j2, j3, j4, z);
    }

    public void a(long j, boolean z) {
        this.f8036c.ShowLayers(this.f8035b, j, z);
    }

    public void a(Bundle bundle) {
        this.f8036c.SetMapStatus(this.f8035b, bundle);
    }

    public void a(String str, Bundle bundle) {
        this.f8036c.SaveScreenToLocal(this.f8035b, str, bundle);
    }

    public void a(boolean z) {
        this.f8036c.ShowSatelliteMap(this.f8035b, z);
    }

    public void a(Bundle[] bundleArr) {
        this.f8036c.addOverlayItems(this.f8035b, bundleArr, bundleArr.length);
    }

    public boolean a(int i2) {
        this.f8035b = f8034e.size() == 0 ? this.f8036c.Create() : this.f8036c.CreateDuplicate(f8034e.get(0).f8031a);
        JNIBaseMap jNIBaseMap = this.f8036c;
        jNIBaseMap.f8031a = this.f8035b;
        f8034e.add(jNIBaseMap);
        f8033d.add(Integer.valueOf(i2));
        this.f8036c.SetCallback(this.f8035b, null);
        return true;
    }

    public boolean a(int i2, boolean z) {
        return this.f8036c.OnRecordReload(this.f8035b, i2, z);
    }

    public boolean a(int i2, boolean z, int i3) {
        return this.f8036c.OnRecordStart(this.f8035b, i2, z, i3);
    }

    public boolean a(long j) {
        return this.f8036c.LayersIsShow(this.f8035b, j);
    }

    public boolean a(long j, long j2) {
        return this.f8036c.SwitchLayer(this.f8035b, j, j2);
    }

    public boolean a(String str, String str2) {
        return this.f8036c.SwitchBaseIndoorMapFloor(this.f8035b, str, str2);
    }

    public boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return this.f8036c.Init(this.f8035b, str, str2, str3, str4, str5, str6, str7, i2, str8, i3, i4, i5, i6, i7, i8, i9);
    }

    public boolean a(boolean z, boolean z2) {
        return this.f8036c.OnRecordImport(this.f8035b, z, z2);
    }

    public int[] a(int[] iArr, int i2, int i3) {
        return this.f8036c.GetScreenBuf(this.f8035b, iArr, i2, i3);
    }

    public String b(int i2, int i3) {
        return this.f8036c.GeoPtToScrPoint(this.f8035b, i2, i3);
    }

    public void b(long j) {
        this.f8036c.UpdateLayers(this.f8035b, j);
    }

    public void b(Bundle bundle) {
        this.f8036c.setMapStatusLimits(this.f8035b, bundle);
    }

    public void b(boolean z) {
        this.f8036c.ShowHotMap(this.f8035b, z);
    }

    public boolean b(int i2) {
        this.f8036c.Release(this.f8035b);
        f8034e.remove(this.f8036c);
        f8033d.remove(Integer.valueOf(i2));
        this.f8035b = 0L;
        return true;
    }

    public boolean b(int i2, boolean z) {
        return this.f8036c.OnRecordRemove(this.f8035b, i2, z);
    }

    public boolean b(int i2, boolean z, int i3) {
        return this.f8036c.OnRecordSuspend(this.f8035b, i2, z, i3);
    }

    public float c(Bundle bundle) {
        return this.f8036c.GetZoomToBound(this.f8035b, bundle);
    }

    public int c(int i2) {
        return this.f8036c.SetMapControlMode(this.f8035b, i2);
    }

    public void c() {
        this.f8036c.OnPause(this.f8035b);
    }

    public void c(boolean z) {
        this.f8036c.ShowTrafficMap(this.f8035b, z);
    }

    public boolean c(long j) {
        return this.f8036c.cleanSDKTileDataCache(this.f8035b, j);
    }

    public void d() {
        this.f8036c.OnResume(this.f8035b);
    }

    public void d(long j) {
        this.f8036c.ClearLayer(this.f8035b, j);
    }

    public void d(boolean z) {
        this.f8036c.enableDrawHouseHeight(this.f8035b, z);
    }

    public boolean d(int i2) {
        return this.f8036c.OnRecordAdd(this.f8035b, i2);
    }

    public boolean d(Bundle bundle) {
        return this.f8036c.updateSDKTile(this.f8035b, bundle);
    }

    public String e(int i2) {
        return this.f8036c.OnRecordGetAt(this.f8035b, i2);
    }

    public String e(long j) {
        return this.f8036c.getCompassPosition(this.f8035b, j);
    }

    public void e() {
        this.f8036c.OnBackground(this.f8035b);
    }

    public void e(boolean z) {
        this.f8036c.ShowBaseIndoorMap(this.f8035b, z);
    }

    public boolean e(Bundle bundle) {
        return this.f8036c.addtileOverlay(this.f8035b, bundle);
    }

    public void f() {
        this.f8036c.OnForeground(this.f8035b);
    }

    public void f(Bundle bundle) {
        this.f8036c.addOneOverlayItem(this.f8035b, bundle);
    }

    public void g() {
        this.f8036c.ResetImageRes(this.f8035b);
    }

    public void g(Bundle bundle) {
        this.f8036c.updateOneOverlayItem(this.f8035b, bundle);
    }

    public Bundle h() {
        return this.f8036c.GetMapStatus(this.f8035b);
    }

    public void h(Bundle bundle) {
        this.f8036c.removeOneOverlayItem(this.f8035b, bundle);
    }

    public Bundle i() {
        return this.f8036c.getMapStatusLimits(this.f8035b);
    }

    public Bundle j() {
        return this.f8036c.getDrawingMapStatus(this.f8035b);
    }

    public boolean k() {
        return this.f8036c.GetBaiduHotMapCityInfo(this.f8035b);
    }

    public String l() {
        return this.f8036c.OnRecordGetAll(this.f8035b);
    }

    public String m() {
        return this.f8036c.OnHotcityGet(this.f8035b);
    }

    public void n() {
        this.f8036c.PostStatInfo(this.f8035b);
    }

    public boolean o() {
        return this.f8036c.isDrawHouseHeightEnable(this.f8035b);
    }

    public void p() {
        this.f8036c.clearHeatMapLayerCache(this.f8035b);
    }

    public MapBaseIndoorMapInfo q() {
        JSONArray optJSONArray;
        String str = this.f8036c.getfocusedBaseIndoorMapInfo(this.f8035b);
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
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            arrayList.add(optJSONArray.get(i2).toString());
        }
        return new MapBaseIndoorMapInfo(str2, str3, arrayList);
    }

    public boolean r() {
        return this.f8036c.IsBaseIndoorMapMode(this.f8035b);
    }

    public void s() {
        this.f8036c.setBackgroundTransparent(this.f8035b);
    }

    public void t() {
        this.f8036c.resetBackgroundTransparent(this.f8035b);
    }

    public float[] u() {
        JNIBaseMap jNIBaseMap = this.f8036c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getProjectionMatrix(this.f8035b, fArr, 16);
        return fArr;
    }

    public float[] v() {
        JNIBaseMap jNIBaseMap = this.f8036c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getViewMatrix(this.f8035b, fArr, 16);
        return fArr;
    }
}
