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
    public static final String f8220a = "a";

    /* renamed from: d  reason: collision with root package name */
    public static Set<Integer> f8221d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public static List<JNIBaseMap> f8222e = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f8223b = 0;

    /* renamed from: c  reason: collision with root package name */
    public JNIBaseMap f8224c;

    public a() {
        this.f8224c = null;
        this.f8224c = new JNIBaseMap();
    }

    public static int a(long j, int i2, int i3, int i4) {
        return JNIBaseMap.MapProc(j, i2, i3, i4);
    }

    public static List<JNIBaseMap> b() {
        return f8222e;
    }

    public static void b(long j, boolean z) {
        JNIBaseMap.SetMapCustomEnable(j, z);
    }

    public long a() {
        return this.f8223b;
    }

    public long a(int i2, int i3, String str) {
        return this.f8224c.AddLayer(this.f8223b, i2, i3, str);
    }

    public String a(int i2, int i3) {
        return this.f8224c.ScrPtToGeoPoint(this.f8223b, i2, i3);
    }

    public String a(int i2, int i3, int i4, int i5) {
        return this.f8224c.GetNearlyObjID(this.f8223b, i2, i3, i4, i5);
    }

    public String a(String str) {
        return this.f8224c.OnSchcityGet(this.f8223b, str);
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        this.f8224c.setCustomTrafficColor(this.f8223b, j, j2, j3, j4, z);
    }

    public void a(long j, boolean z) {
        this.f8224c.ShowLayers(this.f8223b, j, z);
    }

    public void a(Bundle bundle) {
        this.f8224c.SetMapStatus(this.f8223b, bundle);
    }

    public void a(String str, Bundle bundle) {
        this.f8224c.SaveScreenToLocal(this.f8223b, str, bundle);
    }

    public void a(boolean z) {
        this.f8224c.ShowSatelliteMap(this.f8223b, z);
    }

    public void a(Bundle[] bundleArr) {
        this.f8224c.addOverlayItems(this.f8223b, bundleArr, bundleArr.length);
    }

    public boolean a(int i2) {
        this.f8223b = (f8222e.size() == 0 || !f8221d.contains(Integer.valueOf(i2))) ? this.f8224c.Create() : this.f8224c.CreateDuplicate(f8222e.get(0).f8219a);
        JNIBaseMap jNIBaseMap = this.f8224c;
        jNIBaseMap.f8219a = this.f8223b;
        f8222e.add(jNIBaseMap);
        f8221d.add(Integer.valueOf(i2));
        this.f8224c.SetCallback(this.f8223b, null);
        return true;
    }

    public boolean a(int i2, boolean z) {
        return this.f8224c.OnRecordReload(this.f8223b, i2, z);
    }

    public boolean a(int i2, boolean z, int i3) {
        return this.f8224c.OnRecordStart(this.f8223b, i2, z, i3);
    }

    public boolean a(long j) {
        return this.f8224c.LayersIsShow(this.f8223b, j);
    }

    public boolean a(long j, long j2) {
        return this.f8224c.SwitchLayer(this.f8223b, j, j2);
    }

    public boolean a(String str, String str2) {
        return this.f8224c.SwitchBaseIndoorMapFloor(this.f8223b, str, str2);
    }

    public boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return this.f8224c.Init(this.f8223b, str, str2, str3, str4, str5, str6, str7, i2 != 0 ? String.valueOf(i2) : null, str8, i3, i4, i5, i6, i7, i8, i9);
    }

    public boolean a(boolean z, boolean z2) {
        return this.f8224c.OnRecordImport(this.f8223b, z, z2);
    }

    public int[] a(int[] iArr, int i2, int i3) {
        return this.f8224c.GetScreenBuf(this.f8223b, iArr, i2, i3);
    }

    public String b(int i2, int i3) {
        return this.f8224c.GeoPtToScrPoint(this.f8223b, i2, i3);
    }

    public void b(long j) {
        this.f8224c.UpdateLayers(this.f8223b, j);
    }

    public void b(Bundle bundle) {
        this.f8224c.setMapStatusLimits(this.f8223b, bundle);
    }

    public void b(boolean z) {
        this.f8224c.ShowHotMap(this.f8223b, z);
    }

    public boolean b(int i2) {
        this.f8224c.Release(this.f8223b);
        f8222e.remove(this.f8224c);
        f8221d.remove(Integer.valueOf(i2));
        return true;
    }

    public boolean b(int i2, boolean z) {
        return this.f8224c.OnRecordRemove(this.f8223b, i2, z);
    }

    public boolean b(int i2, boolean z, int i3) {
        return this.f8224c.OnRecordSuspend(this.f8223b, i2, z, i3);
    }

    public float c(Bundle bundle) {
        return this.f8224c.GetZoomToBound(this.f8223b, bundle);
    }

    public int c(int i2) {
        return this.f8224c.SetMapControlMode(this.f8223b, i2);
    }

    public void c() {
        this.f8224c.OnPause(this.f8223b);
    }

    public void c(boolean z) {
        this.f8224c.ShowTrafficMap(this.f8223b, z);
    }

    public boolean c(long j) {
        return this.f8224c.cleanSDKTileDataCache(this.f8223b, j);
    }

    public void d() {
        this.f8224c.OnResume(this.f8223b);
    }

    public void d(long j) {
        this.f8224c.ClearLayer(this.f8223b, j);
    }

    public void d(boolean z) {
        this.f8224c.enableDrawHouseHeight(this.f8223b, z);
    }

    public boolean d(int i2) {
        return this.f8224c.OnRecordAdd(this.f8223b, i2);
    }

    public boolean d(Bundle bundle) {
        return this.f8224c.updateSDKTile(this.f8223b, bundle);
    }

    public String e(int i2) {
        return this.f8224c.OnRecordGetAt(this.f8223b, i2);
    }

    public String e(long j) {
        return this.f8224c.getCompassPosition(this.f8223b, j);
    }

    public void e() {
        this.f8224c.OnBackground(this.f8223b);
    }

    public void e(boolean z) {
        this.f8224c.ShowBaseIndoorMap(this.f8223b, z);
    }

    public boolean e(Bundle bundle) {
        return this.f8224c.addtileOverlay(this.f8223b, bundle);
    }

    public void f() {
        this.f8224c.OnForeground(this.f8223b);
    }

    public void f(Bundle bundle) {
        this.f8224c.addOneOverlayItem(this.f8223b, bundle);
    }

    public void g() {
        this.f8224c.ResetImageRes(this.f8223b);
    }

    public void g(Bundle bundle) {
        this.f8224c.updateOneOverlayItem(this.f8223b, bundle);
    }

    public Bundle h() {
        return this.f8224c.GetMapStatus(this.f8223b);
    }

    public void h(Bundle bundle) {
        this.f8224c.removeOneOverlayItem(this.f8223b, bundle);
    }

    public Bundle i() {
        return this.f8224c.getMapStatusLimits(this.f8223b);
    }

    public Bundle j() {
        return this.f8224c.getDrawingMapStatus(this.f8223b);
    }

    public boolean k() {
        return this.f8224c.GetBaiduHotMapCityInfo(this.f8223b);
    }

    public String l() {
        return this.f8224c.OnRecordGetAll(this.f8223b);
    }

    public String m() {
        return this.f8224c.OnHotcityGet(this.f8223b);
    }

    public void n() {
        this.f8224c.PostStatInfo(this.f8223b);
    }

    public boolean o() {
        return this.f8224c.isDrawHouseHeightEnable(this.f8223b);
    }

    public void p() {
        this.f8224c.clearHeatMapLayerCache(this.f8223b);
    }

    public MapBaseIndoorMapInfo q() {
        JSONArray optJSONArray;
        String str = this.f8224c.getfocusedBaseIndoorMapInfo(this.f8223b);
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
        return this.f8224c.IsBaseIndoorMapMode(this.f8223b);
    }

    public void s() {
        this.f8224c.setBackgroundTransparent(this.f8223b);
    }

    public void t() {
        this.f8224c.resetBackgroundTransparent(this.f8223b);
    }

    public float[] u() {
        JNIBaseMap jNIBaseMap = this.f8224c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getProjectionMatrix(this.f8223b, fArr, 16);
        return fArr;
    }

    public float[] v() {
        JNIBaseMap jNIBaseMap = this.f8224c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getViewMatrix(this.f8223b, fArr, 16);
        return fArr;
    }
}
