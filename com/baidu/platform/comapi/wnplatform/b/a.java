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
/* loaded from: classes20.dex */
public class a extends com.baidu.platform.comapi.walknavi.a {
    int a;
    private JNIGuidanceControl b;
    private long c;
    private boolean d;

    public a() {
        this.b = null;
        this.c = 0L;
        this.d = false;
        this.c = b.a().E().c();
        if (this.c != 0) {
            this.b = new JNIGuidanceControl();
        }
        this.d = false;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a(true);
        this.b = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        if (this.b != null) {
            this.a = iArr.length;
            String[] strArr = new String[this.a];
            String[] strArr2 = new String[this.a];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = "";
            }
            for (int i2 = 0; i2 < strArr2.length; i2++) {
                strArr2[i2] = "";
            }
            return this.b.setNaviNodes(this.c, iArr, iArr2, iArr3, iArr4, strArr, strArr2, null, null);
        }
        return false;
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, String[] strArr, String[] strArr2) {
        if (this.b != null) {
            this.a = iArr.length;
            return this.b.setNaviNodes(this.c, iArr, iArr2, iArr3, iArr4, strArr, strArr2, null, null);
        }
        return false;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        if (this.b != null) {
        }
        return 0;
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (this.b != null) {
            Bundle bundle = new Bundle();
            bundle.putIntArray("type", iArr3);
            bundle.putIntArray("x", iArr);
            bundle.putIntArray("y", iArr2);
            return this.b.getTrafficFacilities(this.c, bundle);
        }
        return false;
    }

    public boolean b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (this.b != null) {
            Bundle bundle = new Bundle();
            bundle.putIntArray("x", iArr);
            bundle.putIntArray("y", iArr2);
            bundle.putIntArray("serial", iArr3);
            return this.b.getViaNaviNodes(this.c, bundle);
        }
        return false;
    }

    public int a(int i, int i2, int i3, int i4, byte[] bArr) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.calcRoute", "" + bArr);
        if (this.b != null) {
            return this.b.calcRoute(this.c, i, i2, i3, bArr);
        }
        return 0;
    }

    public int a(String str) {
        if (this.b != null) {
            return this.b.SearchRoutePlan(this.c, str);
        }
        return 0;
    }

    public com.baidu.platform.comapi.wnplatform.e.a a(int i) {
        byte[] GetProtobufResult;
        c cVar;
        if (this.b == null || (GetProtobufResult = this.b.GetProtobufResult(this.c, i)) == null) {
            return null;
        }
        try {
            List<MessageMicro> a = d.a(GetProtobufResult);
            cVar = a.size() >= 1 ? new c(0, 31, a) : null;
        } catch (IOException e) {
            cVar = null;
        }
        return cVar;
    }

    public Bundle b(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getRoutePlanResult", "" + i);
        Bundle bundle = new Bundle();
        if (this.b.getRouteResult(this.c, i, bundle)) {
            return bundle;
        }
        return null;
    }

    public void c() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.resumeReRouteCalcRoute", "");
        if (this.b != null) {
            this.b.resumeReRouteCalcRoute(this.c);
        }
    }

    public int d() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getCurCorrectDirection", "");
        if (this.b != null) {
            return this.b.getCurCorrectDirection(this.c);
        }
        return 0;
    }

    public void a(double d, double d2, double d3, double d4, double d5, double d6) {
        if (this.b != null) {
            this.b.updateSensor(this.c, d, d2, d3, d4, d5, d6);
        }
    }

    public void a(boolean z) {
        if (this.b != null) {
            this.b.setBrowseStatus(this.c, z);
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
        if (this.b != null) {
            return this.b.setRotateMode(this.c, i);
        }
        return false;
    }

    public boolean a(int[] iArr, int[] iArr2) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getShowPoint", "" + iArr.toString() + " " + iArr2.toString());
        if (this.b != null) {
            return this.b.getCarPoint(this.c, iArr, iArr2);
        }
        return false;
    }

    public boolean f() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.isBrowseStatus", "");
        if (this.b != null) {
            return this.b.isBrowseStatus(this.c);
        }
        return false;
    }

    public boolean g() {
        return this.d;
    }

    public boolean h() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.startRouteGuide", "");
        if (this.b != null) {
            this.d = true;
            return this.b.startRouteGuide(this.c);
        }
        return false;
    }

    public boolean i() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.stopRouteGuide", "");
        if (this.b != null) {
            return this.b.stopRouteGuide(this.c);
        }
        return false;
    }

    public boolean j() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.resumeRouteGuide", "");
        if (this.b != null) {
            return this.b.resumeRouteGuide(this.c);
        }
        return false;
    }

    public boolean k() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.pauseRouteGuide", "");
        if (this.b != null) {
            return this.b.pauseRouteGuide(this.c);
        }
        return false;
    }

    public boolean a(Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getSimpleGuideInfo", "" + bundle.toString());
        if (this.b != null) {
            return this.b.getSimpleMapInfo(this.c, bundle);
        }
        return false;
    }

    public boolean d(int i) {
        if (this.b != null) {
            return this.b.setLocateMode(this.c, i);
        }
        return false;
    }

    public boolean a(double d, double d2, float f, float f2, float f3, float f4, String str, String str2, int i, int i2) {
        if (this.b != null) {
            return this.b.triggerGPSDataChange(this.c, d, d2, f, f2, f3, f4, str, str2, i, i2, 0, 0, 0, 0.0f);
        }
        return false;
    }

    public byte[] l() {
        return null;
    }

    public boolean b(String str) {
        if (this.b != null) {
            return this.b.setNetStatistics(this.c, str);
        }
        return false;
    }

    public void e(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setGuideTextMaxWordCnt", "");
        if (this.b != null) {
            this.b.setGuideTextMaxWordCnt(this.c, i);
        }
    }

    public boolean a(int i, int i2, Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getStepGuideText", "");
        if (this.b != null) {
            return this.b.getGuideParagraph(this.c, i, i2, bundle);
        }
        return false;
    }

    public void f(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setRouteStepFocus", "");
        if (this.b != null) {
            this.b.setParagraphFocus(this.c, i);
        }
    }

    public Bundle m() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getNaviRouteBoundWithNoMargin", "");
        Bundle bundle = new Bundle();
        if (this.b == null || !this.b.getNaviRouteBoundWithNoMargin(this.c, bundle)) {
            return null;
        }
        return bundle;
    }

    public Bundle g(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getParagraphBound", "");
        Bundle bundle = new Bundle();
        if (this.b != null) {
            this.b.getParagraphBound(this.c, i, bundle);
        }
        return bundle;
    }

    public Bundle n() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getFirstParagraph", "");
        Bundle bundle = new Bundle();
        if (this.b != null) {
            this.b.getFirstParagraph(this.c, bundle);
        }
        return bundle;
    }

    public void a(int i, int i2, int i3, String str, String str2) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setVehiclePos", " " + i + " " + i2 + " " + i3);
        if (this.b != null) {
            this.b.setVehiclePos(this.c, i, i2, i3, str, str2);
        }
    }

    public void o() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.PrepareRouteGuide", "");
        if (this.b != null) {
            this.b.prepareRouteGuide(this.c);
        }
    }

    public void h(int i) {
        if (this.b != null) {
            this.b.setNaviType(this.c, i);
        }
    }

    public void i(int i) {
        if (this.b != null) {
            this.b.setNaviMode(this.c, i);
        }
    }

    public void b(Bundle bundle) {
        if (this.b != null) {
            this.b.getTravelData(this.c, bundle);
        }
    }

    public boolean j(int i) {
        if (this.b != null) {
            return this.b.setOriNaviOverlooking(this.c, i);
        }
        return false;
    }

    public boolean c(Bundle bundle) {
        if (this.b != null) {
            return this.b.getCurViaPoiPanoImage(this.c, bundle);
        }
        return false;
    }

    public void b(boolean z) {
        if (this.b != null) {
            this.b.needShowPoiPanoImage(this.c, z);
        }
    }

    public void p() {
        if (this.b != null) {
            this.b.registerGetLaunchSystemTime(this.c);
        }
    }

    public void a(String str, String str2) {
        if (this.b != null) {
            this.b.showFloor(this.c, str, str2);
        }
    }

    public boolean q() {
        if (this.b == null) {
            return false;
        }
        return this.b.isEngineIndoorNaviDefine(this.c);
    }

    public void c(boolean z) {
        if (this.b != null) {
            this.b.supportIndoorNavi(this.c, z);
        }
    }

    public void d(boolean z) {
        if (this.b != null) {
            this.b.showNPCModel(this.c, z);
        }
    }

    public void a(int i, int i2) {
        if (this.b != null) {
            this.b.setARRouteResID(this.c, i, i2);
        }
    }
}
