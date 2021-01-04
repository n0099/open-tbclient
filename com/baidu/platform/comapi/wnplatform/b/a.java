package com.baidu.platform.comapi.wnplatform.b;

import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.e.c;
import com.baidu.platform.comapi.wnplatform.e.d;
import com.baidu.platform.comjni.bikenavi.JNIGuidanceControl;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.List;
/* loaded from: classes15.dex */
public class a extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    int f4611a;

    /* renamed from: b  reason: collision with root package name */
    private JNIGuidanceControl f4612b;
    private long c;
    private boolean d;

    public a() {
        this.f4612b = null;
        this.c = 0L;
        this.d = false;
        this.c = b.a().E().c();
        if (this.c != 0) {
            this.f4612b = new JNIGuidanceControl();
        }
        this.d = false;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a(true);
        this.f4612b = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        if (this.f4612b != null) {
            this.f4611a = iArr.length;
            String[] strArr = new String[this.f4611a];
            String[] strArr2 = new String[this.f4611a];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = "";
            }
            for (int i2 = 0; i2 < strArr2.length; i2++) {
                strArr2[i2] = "";
            }
            return this.f4612b.setNaviNodes(this.c, iArr, iArr2, iArr3, iArr4, strArr, strArr2, null, null);
        }
        return false;
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, String[] strArr, String[] strArr2) {
        if (this.f4612b != null) {
            this.f4611a = iArr.length;
            return this.f4612b.setNaviNodes(this.c, iArr, iArr2, iArr3, iArr4, strArr, strArr2, null, null);
        }
        return false;
    }

    public int a() {
        return this.f4611a;
    }

    public int b() {
        if (this.f4612b != null) {
        }
        return 0;
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (this.f4612b != null) {
            Bundle bundle = new Bundle();
            bundle.putIntArray("type", iArr3);
            bundle.putIntArray("x", iArr);
            bundle.putIntArray("y", iArr2);
            return this.f4612b.getTrafficFacilities(this.c, bundle);
        }
        return false;
    }

    public boolean b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (this.f4612b != null) {
            Bundle bundle = new Bundle();
            bundle.putIntArray("x", iArr);
            bundle.putIntArray("y", iArr2);
            bundle.putIntArray("serial", iArr3);
            return this.f4612b.getViaNaviNodes(this.c, bundle);
        }
        return false;
    }

    public int a(int i, int i2, int i3, int i4, byte[] bArr) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.calcRoute", "" + bArr);
        if (this.f4612b != null) {
            return this.f4612b.calcRoute(this.c, i, i2, i3, bArr);
        }
        return 0;
    }

    public int a(String str) {
        if (this.f4612b != null) {
            return this.f4612b.SearchRoutePlan(this.c, str);
        }
        return 0;
    }

    public com.baidu.platform.comapi.wnplatform.e.a a(int i) {
        byte[] GetProtobufResult;
        c cVar;
        if (this.f4612b == null || (GetProtobufResult = this.f4612b.GetProtobufResult(this.c, i)) == null) {
            return null;
        }
        try {
            List<MessageMicro> a2 = d.a(GetProtobufResult);
            cVar = a2.size() >= 1 ? new c(0, 31, a2) : null;
        } catch (IOException e) {
            cVar = null;
        }
        return cVar;
    }

    public Bundle b(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getRoutePlanResult", "" + i);
        Bundle bundle = new Bundle();
        if (this.f4612b.getRouteResult(this.c, i, bundle)) {
            return bundle;
        }
        return null;
    }

    public void c() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.resumeReRouteCalcRoute", "");
        if (this.f4612b != null) {
            this.f4612b.resumeReRouteCalcRoute(this.c);
        }
    }

    public int d() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getCurCorrectDirection", "");
        if (this.f4612b != null) {
            return this.f4612b.getCurCorrectDirection(this.c);
        }
        return 0;
    }

    public void a(double d, double d2, double d3, double d4, double d5, double d6) {
        if (this.f4612b != null) {
            this.f4612b.updateSensor(this.c, d, d2, d3, d4, d5, d6);
        }
    }

    public void a(boolean z) {
        if (this.f4612b != null) {
            this.f4612b.setBrowseStatus(this.c, z);
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
        return b.a().S().b();
    }

    public boolean c(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setRotateMode", "" + i);
        if (this.f4612b != null) {
            return this.f4612b.setRotateMode(this.c, i);
        }
        return false;
    }

    public boolean a(int[] iArr, int[] iArr2) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getShowPoint", "" + iArr.toString() + " " + iArr2.toString());
        if (this.f4612b != null) {
            return this.f4612b.getCarPoint(this.c, iArr, iArr2);
        }
        return false;
    }

    public boolean f() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.isBrowseStatus", "");
        if (this.f4612b != null) {
            return this.f4612b.isBrowseStatus(this.c);
        }
        return false;
    }

    public boolean g() {
        return this.d;
    }

    public boolean h() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.startRouteGuide", "");
        if (this.f4612b != null) {
            this.d = true;
            return this.f4612b.startRouteGuide(this.c);
        }
        return false;
    }

    public boolean i() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.stopRouteGuide", "");
        if (this.f4612b != null) {
            return this.f4612b.stopRouteGuide(this.c);
        }
        return false;
    }

    public boolean j() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.resumeRouteGuide", "");
        if (this.f4612b != null) {
            return this.f4612b.resumeRouteGuide(this.c);
        }
        return false;
    }

    public boolean k() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.pauseRouteGuide", "");
        if (this.f4612b != null) {
            return this.f4612b.pauseRouteGuide(this.c);
        }
        return false;
    }

    public boolean a(Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getSimpleGuideInfo", "" + bundle.toString());
        if (this.f4612b != null) {
            return this.f4612b.getSimpleMapInfo(this.c, bundle);
        }
        return false;
    }

    public boolean d(int i) {
        if (this.f4612b != null) {
            return this.f4612b.setLocateMode(this.c, i);
        }
        return false;
    }

    public boolean a(double d, double d2, float f, float f2, float f3, float f4, String str, String str2, int i, int i2) {
        if (this.f4612b != null) {
            return this.f4612b.triggerGPSDataChange(this.c, d, d2, f, f2, f3, f4, str, str2, i, i2, 0, 0, 0, 0.0f);
        }
        return false;
    }

    public byte[] l() {
        return null;
    }

    public boolean b(String str) {
        if (this.f4612b != null) {
            return this.f4612b.setNetStatistics(this.c, str);
        }
        return false;
    }

    public void e(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setGuideTextMaxWordCnt", "");
        if (this.f4612b != null) {
            this.f4612b.setGuideTextMaxWordCnt(this.c, i);
        }
    }

    public boolean a(int i, int i2, Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getStepGuideText", "");
        if (this.f4612b != null) {
            return this.f4612b.getGuideParagraph(this.c, i, i2, bundle);
        }
        return false;
    }

    public void f(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setRouteStepFocus", "");
        if (this.f4612b != null) {
            this.f4612b.setParagraphFocus(this.c, i);
        }
    }

    public Bundle m() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getNaviRouteBoundWithNoMargin", "");
        Bundle bundle = new Bundle();
        if (this.f4612b == null || !this.f4612b.getNaviRouteBoundWithNoMargin(this.c, bundle)) {
            return null;
        }
        return bundle;
    }

    public Bundle g(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getParagraphBound", "");
        Bundle bundle = new Bundle();
        if (this.f4612b != null) {
            this.f4612b.getParagraphBound(this.c, i, bundle);
        }
        return bundle;
    }

    public Bundle n() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getFirstParagraph", "");
        Bundle bundle = new Bundle();
        if (this.f4612b != null) {
            this.f4612b.getFirstParagraph(this.c, bundle);
        }
        return bundle;
    }

    public void a(int i, int i2, int i3, String str, String str2) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setVehiclePos", " " + i + " " + i2 + " " + i3);
        if (this.f4612b != null) {
            this.f4612b.setVehiclePos(this.c, i, i2, i3, str, str2);
        }
    }

    public void o() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.PrepareRouteGuide", "");
        if (this.f4612b != null) {
            this.f4612b.prepareRouteGuide(this.c);
        }
    }

    public void h(int i) {
        if (this.f4612b != null) {
            this.f4612b.setNaviType(this.c, i);
        }
    }

    public void i(int i) {
        if (this.f4612b != null) {
            this.f4612b.setNaviMode(this.c, i);
        }
    }

    public void b(Bundle bundle) {
        if (this.f4612b != null) {
            this.f4612b.getTravelData(this.c, bundle);
        }
    }

    public boolean j(int i) {
        if (this.f4612b != null) {
            return this.f4612b.setOriNaviOverlooking(this.c, i);
        }
        return false;
    }

    public boolean c(Bundle bundle) {
        if (this.f4612b != null) {
            return this.f4612b.getCurViaPoiPanoImage(this.c, bundle);
        }
        return false;
    }

    public void b(boolean z) {
        if (this.f4612b != null) {
            this.f4612b.needShowPoiPanoImage(this.c, z);
        }
    }

    public void p() {
        if (this.f4612b != null) {
            this.f4612b.registerGetLaunchSystemTime(this.c);
        }
    }

    public void a(String str, String str2) {
        if (this.f4612b != null) {
            this.f4612b.showFloor(this.c, str, str2);
        }
    }

    public boolean q() {
        if (this.f4612b == null) {
            return false;
        }
        return this.f4612b.isEngineIndoorNaviDefine(this.c);
    }

    public void c(boolean z) {
        if (this.f4612b != null) {
            this.f4612b.supportIndoorNavi(this.c, z);
        }
    }

    public void d(boolean z) {
        if (this.f4612b != null) {
            this.f4612b.showNPCModel(this.c, z);
        }
    }

    public void a(int i, int i2) {
        if (this.f4612b != null) {
            this.f4612b.setARRouteResID(this.c, i, i2);
        }
    }
}
