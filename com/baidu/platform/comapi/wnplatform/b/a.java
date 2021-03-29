package com.baidu.platform.comapi.wnplatform.b;

import android.os.Bundle;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comjni.bikenavi.JNIGuidanceControl;
/* loaded from: classes2.dex */
public class a extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    public int f10242a;

    /* renamed from: b  reason: collision with root package name */
    public JNIGuidanceControl f10243b;

    /* renamed from: c  reason: collision with root package name */
    public long f10244c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10245d;

    public a() {
        this.f10243b = null;
        this.f10244c = 0L;
        this.f10245d = false;
        long c2 = b.a().B().c();
        this.f10244c = c2;
        if (c2 != 0) {
            this.f10243b = new JNIGuidanceControl();
        }
        this.f10245d = false;
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        if (this.f10243b != null) {
            int length = iArr.length;
            this.f10242a = length;
            String[] strArr = new String[length];
            String[] strArr2 = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = "";
            }
            for (int i2 = 0; i2 < length; i2++) {
                strArr2[i2] = "";
            }
            return this.f10243b.setNaviNodes(this.f10244c, iArr, iArr2, iArr3, iArr4, strArr, strArr2);
        }
        return false;
    }

    public int b() {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getTrafficFacilitiesNum(this.f10244c);
        }
        return 0;
    }

    public void c() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.resumeReRouteCalcRoute", "");
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.ResumeReRouteCalcRoute(this.f10244c);
        }
    }

    public int d() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getCurCorrectDirection", "");
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.GetCurCorrectDirection(this.f10244c);
        }
        return 0;
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

    public boolean f() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.isBrowseStatus", "");
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.IsBrowseStatus(this.f10244c);
        }
        return false;
    }

    public boolean g() {
        return this.f10245d;
    }

    public boolean h() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.startRouteGuide", "");
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            this.f10245d = true;
            return jNIGuidanceControl.StartRouteGuide(this.f10244c);
        }
        return false;
    }

    public boolean i() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.stopRouteGuide", "");
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.StopRouteGuide(this.f10244c);
        }
        return false;
    }

    public boolean j() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.resumeRouteGuide", "");
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.ResumeRouteGuide(this.f10244c);
        }
        return false;
    }

    public boolean k() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.pauseRouteGuide", "");
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.PauseRouteGuide(this.f10244c);
        }
        return false;
    }

    public byte[] l() {
        return null;
    }

    public Bundle m() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getNaviRouteBoundWithNoMargin", "");
        Bundle bundle = new Bundle();
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.GetNaviRouteBoundWithNoMargin(this.f10244c, bundle);
        }
        return bundle;
    }

    public Bundle n() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getFirstParagraph", "");
        Bundle bundle = new Bundle();
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.GetFirstParagraph(this.f10244c, bundle);
        }
        return bundle;
    }

    public void o() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.PrepareRouteGuide", "");
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.PrepareRouteGuide(this.f10244c);
        }
    }

    public void p() {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.registerGetLaunchSystemTime(this.f10244c);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a(true);
        this.f10243b = null;
    }

    public void g(int i) {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.SetNaviType(this.f10244c, i);
        }
    }

    public boolean b(int[] iArr, int[] iArr2, int[] iArr3) {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getViaNaviNodes(this.f10244c, iArr, iArr2, iArr3);
        }
        return false;
    }

    public boolean c(int i) {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.SetLocateMode(this.f10244c, i);
        }
        return false;
    }

    public void d(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setGuideTextMaxWordCnt", "");
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.SetGuideTextMaxWordCnt(this.f10244c, i);
        }
    }

    public Bundle f(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getParagraphBound", "");
        Bundle bundle = new Bundle();
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.GetParagraphBound(this.f10244c, i, bundle);
        }
        return bundle;
    }

    public boolean i(int i) {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.setOriNaviOverlooking(this.f10244c, i);
        }
        return false;
    }

    public boolean b(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setRotateMode", "" + i);
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.SetRotateMode(this.f10244c, i);
        }
        return false;
    }

    public void h(int i) {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.setNaviMode(this.f10244c, i);
        }
    }

    public boolean c(Bundle bundle) {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getCurViaPoiPanoImage(this.f10244c, bundle);
        }
        return false;
    }

    public void e(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setRouteStepFocus", "");
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.SetParagraphFocus(this.f10244c, i);
        }
    }

    public int a() {
        return this.f10242a;
    }

    public void b(Bundle bundle) {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.GetTravelData(this.f10244c, bundle);
        }
    }

    public void c(boolean z) {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.ShowNPCModel(this.f10244c, z);
        }
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3) {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getTrafficFacilities(this.f10244c, iArr, iArr2, iArr3);
        }
        return false;
    }

    public void b(boolean z) {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.needShowPoiPanoImage(this.f10244c, z);
        }
    }

    public int a(int i, int i2, int i3, byte[] bArr) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.calcRoute", "" + bArr);
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.CalcRoute(this.f10244c, i, i2, i3, bArr);
        }
        return 0;
    }

    public Bundle a(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getRoutePlanResult", "" + i);
        Bundle bundle = new Bundle();
        if (this.f10243b.GetRouteResult(this.f10244c, i, bundle)) {
            return bundle;
        }
        return null;
    }

    public void a(double d2, double d3, double d4, double d5, double d6, double d7) {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.UpdateSensor(this.f10244c, d2, d3, d4, d5, d6, d7);
        }
    }

    public void a(boolean z) {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.SetBrowseStatus(this.f10244c, z);
        }
    }

    public boolean a(int[] iArr, int[] iArr2) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getShowPoint", "" + iArr.toString() + " " + iArr2.toString());
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.GetCarPoint(this.f10244c, iArr, iArr2);
        }
        return false;
    }

    public boolean a(Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getSimpleGuideInfo", "" + bundle.toString());
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.GetSimpleMapInfo(this.f10244c, bundle);
        }
        return false;
    }

    public boolean a(double d2, double d3, float f2, float f3, float f4, float f5, String str, String str2, int i, int i2) {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.TriggerGPSDataChange(this.f10244c, d2, d3, f2, f3, f4, f5, str, str2, i, i2);
        }
        return false;
    }

    public boolean a(String str) {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.SetNetStatistics(this.f10244c, str);
        }
        return false;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getStepGuideText", "");
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.GetGuideParagraph(this.f10244c, i, i2, bundle);
        }
        return false;
    }

    public void a(int i, int i2, int i3) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setVehiclePos", " " + i + " " + i2 + " " + i3);
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.SetVehiclePos(this.f10244c, i, i2, i3);
        }
    }

    public void a(int i, int i2) {
        JNIGuidanceControl jNIGuidanceControl = this.f10243b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.setARRouteResID(this.f10244c, i, i2);
        }
    }
}
