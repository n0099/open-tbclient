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
    public static final String f7975a = "a";

    /* renamed from: d  reason: collision with root package name */
    public static Set<Integer> f7976d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public static List<JNIBaseMap> f7977e = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f7978b = 0;

    /* renamed from: c  reason: collision with root package name */
    public JNIBaseMap f7979c;

    public a() {
        this.f7979c = null;
        this.f7979c = new JNIBaseMap();
    }

    public static int a(long j, int i2, int i3, int i4) {
        return JNIBaseMap.MapProc(j, i2, i3, i4);
    }

    public static List<JNIBaseMap> b() {
        return f7977e;
    }

    public static void b(long j, boolean z) {
        JNIBaseMap.SetMapCustomEnable(j, z);
    }

    public long a() {
        return this.f7978b;
    }

    public long a(int i2, int i3, String str) {
        return this.f7979c.AddLayer(this.f7978b, i2, i3, str);
    }

    public String a(int i2, int i3) {
        return this.f7979c.ScrPtToGeoPoint(this.f7978b, i2, i3);
    }

    public String a(int i2, int i3, int i4, int i5) {
        return this.f7979c.GetNearlyObjID(this.f7978b, i2, i3, i4, i5);
    }

    public String a(String str) {
        return this.f7979c.OnSchcityGet(this.f7978b, str);
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        this.f7979c.setCustomTrafficColor(this.f7978b, j, j2, j3, j4, z);
    }

    public void a(long j, boolean z) {
        this.f7979c.ShowLayers(this.f7978b, j, z);
    }

    public void a(Bundle bundle) {
        this.f7979c.SetMapStatus(this.f7978b, bundle);
    }

    public void a(String str, Bundle bundle) {
        this.f7979c.SaveScreenToLocal(this.f7978b, str, bundle);
    }

    public void a(boolean z) {
        this.f7979c.ShowSatelliteMap(this.f7978b, z);
    }

    public void a(Bundle[] bundleArr) {
        this.f7979c.addOverlayItems(this.f7978b, bundleArr, bundleArr.length);
    }

    public boolean a(int i2) {
        this.f7978b = f7977e.size() == 0 ? this.f7979c.Create() : this.f7979c.CreateDuplicate(f7977e.get(0).f7974a);
        JNIBaseMap jNIBaseMap = this.f7979c;
        jNIBaseMap.f7974a = this.f7978b;
        f7977e.add(jNIBaseMap);
        f7976d.add(Integer.valueOf(i2));
        this.f7979c.SetCallback(this.f7978b, null);
        return true;
    }

    public boolean a(int i2, boolean z) {
        return this.f7979c.OnRecordReload(this.f7978b, i2, z);
    }

    public boolean a(int i2, boolean z, int i3) {
        return this.f7979c.OnRecordStart(this.f7978b, i2, z, i3);
    }

    public boolean a(long j) {
        return this.f7979c.LayersIsShow(this.f7978b, j);
    }

    public boolean a(long j, long j2) {
        return this.f7979c.SwitchLayer(this.f7978b, j, j2);
    }

    public boolean a(String str, String str2) {
        return this.f7979c.SwitchBaseIndoorMapFloor(this.f7978b, str, str2);
    }

    public boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return this.f7979c.Init(this.f7978b, str, str2, str3, str4, str5, str6, str7, i2, str8, i3, i4, i5, i6, i7, i8, i9);
    }

    public boolean a(boolean z, boolean z2) {
        return this.f7979c.OnRecordImport(this.f7978b, z, z2);
    }

    public int[] a(int[] iArr, int i2, int i3) {
        return this.f7979c.GetScreenBuf(this.f7978b, iArr, i2, i3);
    }

    public String b(int i2, int i3) {
        return this.f7979c.GeoPtToScrPoint(this.f7978b, i2, i3);
    }

    public void b(long j) {
        this.f7979c.UpdateLayers(this.f7978b, j);
    }

    public void b(Bundle bundle) {
        this.f7979c.setMapStatusLimits(this.f7978b, bundle);
    }

    public void b(boolean z) {
        this.f7979c.ShowHotMap(this.f7978b, z);
    }

    public boolean b(int i2) {
        this.f7979c.Release(this.f7978b);
        f7977e.remove(this.f7979c);
        f7976d.remove(Integer.valueOf(i2));
        this.f7978b = 0L;
        return true;
    }

    public boolean b(int i2, boolean z) {
        return this.f7979c.OnRecordRemove(this.f7978b, i2, z);
    }

    public boolean b(int i2, boolean z, int i3) {
        return this.f7979c.OnRecordSuspend(this.f7978b, i2, z, i3);
    }

    public float c(Bundle bundle) {
        return this.f7979c.GetZoomToBound(this.f7978b, bundle);
    }

    public int c(int i2) {
        return this.f7979c.SetMapControlMode(this.f7978b, i2);
    }

    public void c() {
        this.f7979c.OnPause(this.f7978b);
    }

    public void c(boolean z) {
        this.f7979c.ShowTrafficMap(this.f7978b, z);
    }

    public boolean c(long j) {
        return this.f7979c.cleanSDKTileDataCache(this.f7978b, j);
    }

    public void d() {
        this.f7979c.OnResume(this.f7978b);
    }

    public void d(long j) {
        this.f7979c.ClearLayer(this.f7978b, j);
    }

    public void d(boolean z) {
        this.f7979c.enableDrawHouseHeight(this.f7978b, z);
    }

    public boolean d(int i2) {
        return this.f7979c.OnRecordAdd(this.f7978b, i2);
    }

    public boolean d(Bundle bundle) {
        return this.f7979c.updateSDKTile(this.f7978b, bundle);
    }

    public String e(int i2) {
        return this.f7979c.OnRecordGetAt(this.f7978b, i2);
    }

    public String e(long j) {
        return this.f7979c.getCompassPosition(this.f7978b, j);
    }

    public void e() {
        this.f7979c.OnBackground(this.f7978b);
    }

    public void e(boolean z) {
        this.f7979c.ShowBaseIndoorMap(this.f7978b, z);
    }

    public boolean e(Bundle bundle) {
        return this.f7979c.addtileOverlay(this.f7978b, bundle);
    }

    public void f() {
        this.f7979c.OnForeground(this.f7978b);
    }

    public void f(Bundle bundle) {
        this.f7979c.addOneOverlayItem(this.f7978b, bundle);
    }

    public void g() {
        this.f7979c.ResetImageRes(this.f7978b);
    }

    public void g(Bundle bundle) {
        this.f7979c.updateOneOverlayItem(this.f7978b, bundle);
    }

    public Bundle h() {
        return this.f7979c.GetMapStatus(this.f7978b);
    }

    public void h(Bundle bundle) {
        this.f7979c.removeOneOverlayItem(this.f7978b, bundle);
    }

    public Bundle i() {
        return this.f7979c.getMapStatusLimits(this.f7978b);
    }

    public Bundle j() {
        return this.f7979c.getDrawingMapStatus(this.f7978b);
    }

    public boolean k() {
        return this.f7979c.GetBaiduHotMapCityInfo(this.f7978b);
    }

    public String l() {
        return this.f7979c.OnRecordGetAll(this.f7978b);
    }

    public String m() {
        return this.f7979c.OnHotcityGet(this.f7978b);
    }

    public void n() {
        this.f7979c.PostStatInfo(this.f7978b);
    }

    public boolean o() {
        return this.f7979c.isDrawHouseHeightEnable(this.f7978b);
    }

    public void p() {
        this.f7979c.clearHeatMapLayerCache(this.f7978b);
    }

    public MapBaseIndoorMapInfo q() {
        JSONArray optJSONArray;
        String str = this.f7979c.getfocusedBaseIndoorMapInfo(this.f7978b);
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
        return this.f7979c.IsBaseIndoorMapMode(this.f7978b);
    }

    public void s() {
        this.f7979c.setBackgroundTransparent(this.f7978b);
    }

    public void t() {
        this.f7979c.resetBackgroundTransparent(this.f7978b);
    }

    public float[] u() {
        JNIBaseMap jNIBaseMap = this.f7979c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getProjectionMatrix(this.f7978b, fArr, 16);
        return fArr;
    }

    public float[] v() {
        JNIBaseMap jNIBaseMap = this.f7979c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getViewMatrix(this.f7978b, fArr, 16);
        return fArr;
    }
}
