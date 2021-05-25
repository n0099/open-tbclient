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
    public static final String f7932a = "a";

    /* renamed from: d  reason: collision with root package name */
    public static Set<Integer> f7933d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public static List<JNIBaseMap> f7934e = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f7935b = 0;

    /* renamed from: c  reason: collision with root package name */
    public JNIBaseMap f7936c;

    public a() {
        this.f7936c = null;
        this.f7936c = new JNIBaseMap();
    }

    public static int a(long j, int i2, int i3, int i4) {
        return JNIBaseMap.MapProc(j, i2, i3, i4);
    }

    public static List<JNIBaseMap> b() {
        return f7934e;
    }

    public static void b(long j, boolean z) {
        JNIBaseMap.SetMapCustomEnable(j, z);
    }

    public long a() {
        return this.f7935b;
    }

    public long a(int i2, int i3, String str) {
        return this.f7936c.AddLayer(this.f7935b, i2, i3, str);
    }

    public String a(int i2, int i3) {
        return this.f7936c.ScrPtToGeoPoint(this.f7935b, i2, i3);
    }

    public String a(int i2, int i3, int i4, int i5) {
        return this.f7936c.GetNearlyObjID(this.f7935b, i2, i3, i4, i5);
    }

    public String a(String str) {
        return this.f7936c.OnSchcityGet(this.f7935b, str);
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        this.f7936c.setCustomTrafficColor(this.f7935b, j, j2, j3, j4, z);
    }

    public void a(long j, boolean z) {
        this.f7936c.ShowLayers(this.f7935b, j, z);
    }

    public void a(Bundle bundle) {
        this.f7936c.SetMapStatus(this.f7935b, bundle);
    }

    public void a(String str, Bundle bundle) {
        this.f7936c.SaveScreenToLocal(this.f7935b, str, bundle);
    }

    public void a(boolean z) {
        this.f7936c.ShowSatelliteMap(this.f7935b, z);
    }

    public void a(Bundle[] bundleArr) {
        this.f7936c.addOverlayItems(this.f7935b, bundleArr, bundleArr.length);
    }

    public boolean a(int i2) {
        this.f7935b = f7934e.size() == 0 ? this.f7936c.Create() : this.f7936c.CreateDuplicate(f7934e.get(0).f7931a);
        JNIBaseMap jNIBaseMap = this.f7936c;
        jNIBaseMap.f7931a = this.f7935b;
        f7934e.add(jNIBaseMap);
        f7933d.add(Integer.valueOf(i2));
        this.f7936c.SetCallback(this.f7935b, null);
        return true;
    }

    public boolean a(int i2, boolean z) {
        return this.f7936c.OnRecordReload(this.f7935b, i2, z);
    }

    public boolean a(int i2, boolean z, int i3) {
        return this.f7936c.OnRecordStart(this.f7935b, i2, z, i3);
    }

    public boolean a(long j) {
        return this.f7936c.LayersIsShow(this.f7935b, j);
    }

    public boolean a(long j, long j2) {
        return this.f7936c.SwitchLayer(this.f7935b, j, j2);
    }

    public boolean a(String str, String str2) {
        return this.f7936c.SwitchBaseIndoorMapFloor(this.f7935b, str, str2);
    }

    public boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return this.f7936c.Init(this.f7935b, str, str2, str3, str4, str5, str6, str7, i2, str8, i3, i4, i5, i6, i7, i8, i9);
    }

    public boolean a(boolean z, boolean z2) {
        return this.f7936c.OnRecordImport(this.f7935b, z, z2);
    }

    public int[] a(int[] iArr, int i2, int i3) {
        return this.f7936c.GetScreenBuf(this.f7935b, iArr, i2, i3);
    }

    public String b(int i2, int i3) {
        return this.f7936c.GeoPtToScrPoint(this.f7935b, i2, i3);
    }

    public void b(long j) {
        this.f7936c.UpdateLayers(this.f7935b, j);
    }

    public void b(Bundle bundle) {
        this.f7936c.setMapStatusLimits(this.f7935b, bundle);
    }

    public void b(boolean z) {
        this.f7936c.ShowHotMap(this.f7935b, z);
    }

    public boolean b(int i2) {
        this.f7936c.Release(this.f7935b);
        f7934e.remove(this.f7936c);
        f7933d.remove(Integer.valueOf(i2));
        this.f7935b = 0L;
        return true;
    }

    public boolean b(int i2, boolean z) {
        return this.f7936c.OnRecordRemove(this.f7935b, i2, z);
    }

    public boolean b(int i2, boolean z, int i3) {
        return this.f7936c.OnRecordSuspend(this.f7935b, i2, z, i3);
    }

    public float c(Bundle bundle) {
        return this.f7936c.GetZoomToBound(this.f7935b, bundle);
    }

    public int c(int i2) {
        return this.f7936c.SetMapControlMode(this.f7935b, i2);
    }

    public void c() {
        this.f7936c.OnPause(this.f7935b);
    }

    public void c(boolean z) {
        this.f7936c.ShowTrafficMap(this.f7935b, z);
    }

    public boolean c(long j) {
        return this.f7936c.cleanSDKTileDataCache(this.f7935b, j);
    }

    public void d() {
        this.f7936c.OnResume(this.f7935b);
    }

    public void d(long j) {
        this.f7936c.ClearLayer(this.f7935b, j);
    }

    public void d(boolean z) {
        this.f7936c.enableDrawHouseHeight(this.f7935b, z);
    }

    public boolean d(int i2) {
        return this.f7936c.OnRecordAdd(this.f7935b, i2);
    }

    public boolean d(Bundle bundle) {
        return this.f7936c.updateSDKTile(this.f7935b, bundle);
    }

    public String e(int i2) {
        return this.f7936c.OnRecordGetAt(this.f7935b, i2);
    }

    public String e(long j) {
        return this.f7936c.getCompassPosition(this.f7935b, j);
    }

    public void e() {
        this.f7936c.OnBackground(this.f7935b);
    }

    public void e(boolean z) {
        this.f7936c.ShowBaseIndoorMap(this.f7935b, z);
    }

    public boolean e(Bundle bundle) {
        return this.f7936c.addtileOverlay(this.f7935b, bundle);
    }

    public void f() {
        this.f7936c.OnForeground(this.f7935b);
    }

    public void f(Bundle bundle) {
        this.f7936c.addOneOverlayItem(this.f7935b, bundle);
    }

    public void g() {
        this.f7936c.ResetImageRes(this.f7935b);
    }

    public void g(Bundle bundle) {
        this.f7936c.updateOneOverlayItem(this.f7935b, bundle);
    }

    public Bundle h() {
        return this.f7936c.GetMapStatus(this.f7935b);
    }

    public void h(Bundle bundle) {
        this.f7936c.removeOneOverlayItem(this.f7935b, bundle);
    }

    public Bundle i() {
        return this.f7936c.getMapStatusLimits(this.f7935b);
    }

    public Bundle j() {
        return this.f7936c.getDrawingMapStatus(this.f7935b);
    }

    public boolean k() {
        return this.f7936c.GetBaiduHotMapCityInfo(this.f7935b);
    }

    public String l() {
        return this.f7936c.OnRecordGetAll(this.f7935b);
    }

    public String m() {
        return this.f7936c.OnHotcityGet(this.f7935b);
    }

    public void n() {
        this.f7936c.PostStatInfo(this.f7935b);
    }

    public boolean o() {
        return this.f7936c.isDrawHouseHeightEnable(this.f7935b);
    }

    public void p() {
        this.f7936c.clearHeatMapLayerCache(this.f7935b);
    }

    public MapBaseIndoorMapInfo q() {
        JSONArray optJSONArray;
        String str = this.f7936c.getfocusedBaseIndoorMapInfo(this.f7935b);
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
        return this.f7936c.IsBaseIndoorMapMode(this.f7935b);
    }

    public void s() {
        this.f7936c.setBackgroundTransparent(this.f7935b);
    }

    public void t() {
        this.f7936c.resetBackgroundTransparent(this.f7935b);
    }

    public float[] u() {
        JNIBaseMap jNIBaseMap = this.f7936c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getProjectionMatrix(this.f7935b, fArr, 16);
        return fArr;
    }

    public float[] v() {
        JNIBaseMap jNIBaseMap = this.f7936c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getViewMatrix(this.f7935b, fArr, 16);
        return fArr;
    }
}
