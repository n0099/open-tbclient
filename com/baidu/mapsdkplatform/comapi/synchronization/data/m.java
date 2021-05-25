package com.baidu.mapsdkplatform.comapi.synchronization.data;

import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mapsdkplatform.comapi.synchronization.data.f;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
/* loaded from: classes2.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7831a = "m";

    /* renamed from: e  reason: collision with root package name */
    public static boolean f7832e = true;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.d.d f7833b = new com.baidu.mapsdkplatform.comapi.synchronization.d.d();

    /* renamed from: c  reason: collision with root package name */
    public boolean f7834c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7835d = true;

    public m(f fVar) {
        a(fVar);
    }

    private void a(f fVar) {
        this.f7833b.a("order_id", b(fVar));
        this.f7833b.a("company", fVar.c());
        this.f7833b.a("order_attr", fVar.b());
        this.f7833b.a("status", String.valueOf(fVar.h()));
        this.f7833b.a("pull_type", String.valueOf(fVar.i()));
        this.f7833b.a("route_finger", fVar.d());
        this.f7833b.a("traffic_finger", fVar.e());
        this.f7833b.a("pos_num", String.valueOf(fVar.j()));
        c(fVar);
        d(fVar);
        if (this.f7834c) {
            b();
        }
    }

    private String b(f fVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(fVar.c().toLowerCase());
        stringBuffer.append("-");
        stringBuffer.append(fVar.a().toLowerCase());
        stringBuffer.append("-");
        stringBuffer.append("9sc87244121ip32590fq234mn6641tx7".toLowerCase());
        String a2 = com.baidu.mapsdkplatform.comapi.synchronization.d.c.a(stringBuffer.toString());
        String str = f7831a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(str, "The orderId = " + stringBuffer.toString() + "; result = " + a2);
        return a2;
    }

    private void b() {
        String authToken = SyncSysInfo.getAuthToken();
        if (authToken == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7831a, "Token is null, permission check again");
            int permissionCheck = PermissionCheck.permissionCheck();
            if (permissionCheck != 0) {
                String str = f7831a;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "Permission check result is: " + permissionCheck);
            }
            authToken = SyncSysInfo.getAuthToken();
        }
        this.f7833b.a("token", authToken);
    }

    private String c() {
        return f7832e ? com.baidu.mapsdkplatform.comapi.synchronization.c.f.a() : com.baidu.mapsdkplatform.comapi.synchronization.c.f.b();
    }

    private void c(f fVar) {
        f.b g2 = fVar.g();
        if (f.b.DRIVING != g2 && f.b.RIDING == g2) {
            this.f7833b.a("trip_mode", "riding");
        } else {
            this.f7833b.a("trip_mode", "driving");
        }
    }

    private void d(f fVar) {
        com.baidu.mapsdkplatform.comapi.synchronization.d.d dVar;
        String str;
        f.a f2 = fVar.f();
        if (f.a.BD09LL != f2) {
            if (f.a.BD09MC == f2) {
                dVar = this.f7833b;
                str = CoordinateType.BD09MC;
            } else if (f.a.GPS == f2) {
                dVar = this.f7833b;
                str = CoordinateType.WGS84;
            } else if (f.a.COMMON == f2) {
                dVar = this.f7833b;
                str = "gcj02";
            }
            dVar.a("coord_type", str);
            return;
        }
        this.f7833b.a("coord_type", "bd09ll");
    }

    public String a() {
        StringBuffer stringBuffer = new StringBuffer(this.f7833b.a());
        stringBuffer.append(SyncSysInfo.getPhoneInfo());
        if (this.f7835d) {
            String signMD5String = AppMD5.getSignMD5String(stringBuffer.toString());
            stringBuffer.append("&sign=");
            stringBuffer.append(signMD5String);
        }
        StringBuffer stringBuffer2 = new StringBuffer(c());
        stringBuffer2.append("?");
        stringBuffer2.append(stringBuffer);
        return stringBuffer2.toString();
    }
}
