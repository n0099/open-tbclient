package com.baidu.platform.comapi.wnplatform.b;

import android.os.Bundle;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comjni.bikenavi.JNIGuidanceControl;
/* loaded from: classes4.dex */
public class a extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    int f4397a;

    /* renamed from: b  reason: collision with root package name */
    private JNIGuidanceControl f4398b;
    private long c;
    private boolean d;

    public a() {
        this.f4398b = null;
        this.c = 0L;
        this.d = false;
        this.c = b.a().B().c();
        if (this.c != 0) {
            this.f4398b = new JNIGuidanceControl();
        }
        this.d = false;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a(true);
        this.f4398b = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        if (this.f4398b != null) {
            this.f4397a = iArr.length;
            String[] strArr = new String[this.f4397a];
            String[] strArr2 = new String[this.f4397a];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = "";
            }
            for (int i2 = 0; i2 < strArr2.length; i2++) {
                strArr2[i2] = "";
            }
            return this.f4398b.setNaviNodes(this.c, iArr, iArr2, iArr3, iArr4, strArr, strArr2);
        }
        return false;
    }

    public int a() {
        return this.f4397a;
    }

    public int b() {
        if (this.f4398b != null) {
            return this.f4398b.getTrafficFacilitiesNum(this.c);
        }
        return 0;
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (this.f4398b != null) {
            return this.f4398b.getTrafficFacilities(this.c, iArr, iArr2, iArr3);
        }
        return false;
    }

    public boolean b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (this.f4398b != null) {
            return this.f4398b.getViaNaviNodes(this.c, iArr, iArr2, iArr3);
        }
        return false;
    }

    public int a(int i, int i2, int i3, byte[] bArr) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.calcRoute", "" + bArr);
        if (this.f4398b != null) {
            return this.f4398b.CalcRoute(this.c, i, i2, i3, bArr);
        }
        return 0;
    }

    public Bundle a(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getRoutePlanResult", "" + i);
        Bundle bundle = new Bundle();
        if (this.f4398b.GetRouteResult(this.c, i, bundle)) {
            return bundle;
        }
        return null;
    }

    public void c() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.resumeReRouteCalcRoute", "");
        if (this.f4398b != null) {
            this.f4398b.ResumeReRouteCalcRoute(this.c);
        }
    }

    public int d() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getCurCorrectDirection", "");
        if (this.f4398b != null) {
            return this.f4398b.GetCurCorrectDirection(this.c);
        }
        return 0;
    }

    public void a(double d, double d2, double d3, double d4, double d5, double d6) {
        if (this.f4398b != null) {
            this.f4398b.UpdateSensor(this.c, d, d2, d3, d4, d5, d6);
        }
    }

    public void a(boolean z) {
        if (this.f4398b != null) {
            this.f4398b.SetBrowseStatus(this.c, z);
        }
    }

    public GeoPoint e() {
        GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
        int[] iArr = {0};
        int[] iArr2 = {0};
        if (a(iArr, iArr2) && iArr[0] != 0 && iArr2[0] != 0) {
            geoPoint.setLongitudeE6(iArr[0]);
            geoPoint.setLatitudeE6(iArr2[0]);
            return geoPoint;
        }
        return b.a().P().b();
    }

    public boolean b(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setRotateMode", "" + i);
        if (this.f4398b != null) {
            return this.f4398b.SetRotateMode(this.c, i);
        }
        return false;
    }

    public boolean a(int[] iArr, int[] iArr2) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getShowPoint", "" + iArr.toString() + " " + iArr2.toString());
        if (this.f4398b != null) {
            return this.f4398b.GetCarPoint(this.c, iArr, iArr2);
        }
        return false;
    }

    public boolean f() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.isBrowseStatus", "");
        if (this.f4398b != null) {
            return this.f4398b.IsBrowseStatus(this.c);
        }
        return false;
    }

    public boolean g() {
        return this.d;
    }

    public boolean h() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.startRouteGuide", "");
        if (this.f4398b != null) {
            this.d = true;
            return this.f4398b.StartRouteGuide(this.c);
        }
        return false;
    }

    public boolean i() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.stopRouteGuide", "");
        if (this.f4398b != null) {
            return this.f4398b.StopRouteGuide(this.c);
        }
        return false;
    }

    public boolean j() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.resumeRouteGuide", "");
        if (this.f4398b != null) {
            return this.f4398b.ResumeRouteGuide(this.c);
        }
        return false;
    }

    public boolean k() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.pauseRouteGuide", "");
        if (this.f4398b != null) {
            return this.f4398b.PauseRouteGuide(this.c);
        }
        return false;
    }

    public boolean a(Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getSimpleGuideInfo", "" + bundle.toString());
        if (this.f4398b != null) {
            return this.f4398b.GetSimpleMapInfo(this.c, bundle);
        }
        return false;
    }

    public boolean c(int i) {
        if (this.f4398b != null) {
            return this.f4398b.SetLocateMode(this.c, i);
        }
        return false;
    }

    public boolean a(double d, double d2, float f, float f2, float f3, float f4, String str, String str2, int i, int i2) {
        if (this.f4398b != null) {
            return this.f4398b.TriggerGPSDataChange(this.c, d, d2, f, f2, f3, f4, str, str2, i, i2);
        }
        return false;
    }

    public byte[] l() {
        return null;
    }

    public boolean a(String str) {
        if (this.f4398b != null) {
            return this.f4398b.SetNetStatistics(this.c, str);
        }
        return false;
    }

    public void d(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setGuideTextMaxWordCnt", "");
        if (this.f4398b != null) {
            this.f4398b.SetGuideTextMaxWordCnt(this.c, i);
        }
    }

    public boolean a(int i, int i2, Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getStepGuideText", "");
        if (this.f4398b != null) {
            return this.f4398b.GetGuideParagraph(this.c, i, i2, bundle);
        }
        return false;
    }

    public void e(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setRouteStepFocus", "");
        if (this.f4398b != null) {
            this.f4398b.SetParagraphFocus(this.c, i);
        }
    }

    public Bundle m() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getNaviRouteBoundWithNoMargin", "");
        Bundle bundle = new Bundle();
        if (this.f4398b != null) {
            this.f4398b.GetNaviRouteBoundWithNoMargin(this.c, bundle);
        }
        return bundle;
    }

    public Bundle f(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getParagraphBound", "");
        Bundle bundle = new Bundle();
        if (this.f4398b != null) {
            this.f4398b.GetParagraphBound(this.c, i, bundle);
        }
        return bundle;
    }

    public Bundle n() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getFirstParagraph", "");
        Bundle bundle = new Bundle();
        if (this.f4398b != null) {
            this.f4398b.GetFirstParagraph(this.c, bundle);
        }
        return bundle;
    }

    public void a(int i, int i2, int i3) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setVehiclePos", " " + i + " " + i2 + " " + i3);
        if (this.f4398b != null) {
            this.f4398b.SetVehiclePos(this.c, i, i2, i3);
        }
    }

    public void o() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.PrepareRouteGuide", "");
        if (this.f4398b != null) {
            this.f4398b.PrepareRouteGuide(this.c);
        }
    }

    public void g(int i) {
        if (this.f4398b != null) {
            this.f4398b.SetNaviType(this.c, i);
        }
    }

    public void h(int i) {
        if (this.f4398b != null) {
            this.f4398b.setNaviMode(this.c, i);
        }
    }

    public void b(Bundle bundle) {
        if (this.f4398b != null) {
            this.f4398b.GetTravelData(this.c, bundle);
        }
    }

    public boolean i(int i) {
        if (this.f4398b != null) {
            return this.f4398b.setOriNaviOverlooking(this.c, i);
        }
        return false;
    }

    public boolean c(Bundle bundle) {
        if (this.f4398b != null) {
            return this.f4398b.getCurViaPoiPanoImage(this.c, bundle);
        }
        return false;
    }

    public void b(boolean z) {
        if (this.f4398b != null) {
            this.f4398b.needShowPoiPanoImage(this.c, z);
        }
    }

    public void p() {
        if (this.f4398b != null) {
            this.f4398b.registerGetLaunchSystemTime(this.c);
        }
    }

    public void c(boolean z) {
        if (this.f4398b != null) {
            this.f4398b.ShowNPCModel(this.c, z);
        }
    }

    public void a(int i, int i2) {
        if (this.f4398b != null) {
            this.f4398b.setARRouteResID(this.c, i, i2);
        }
    }
}
