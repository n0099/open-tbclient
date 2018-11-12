package com.baidu.mapsdkplatform.comapi.synchronization.data;

import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mapsdkplatform.comapi.synchronization.data.f;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes4.dex */
public class n {
    private static final String a = n.class.getSimpleName();
    private static boolean e = true;
    private com.baidu.mapsdkplatform.comapi.synchronization.d.d b = new com.baidu.mapsdkplatform.comapi.synchronization.d.d();
    private boolean c = true;
    private boolean d = true;

    public n(f fVar) {
        a(fVar);
    }

    private void a(f fVar) {
        this.b.a("order_id", b(fVar));
        this.b.a("company", fVar.c());
        this.b.a("order_attr", fVar.b());
        this.b.a("status", String.valueOf(fVar.h()));
        this.b.a("pull_type", String.valueOf(fVar.i()));
        this.b.a("route_finger", fVar.d());
        this.b.a("traffic_finger", fVar.e());
        this.b.a("pos_num", String.valueOf(fVar.j()));
        c(fVar);
        d(fVar);
        if (this.c) {
            b();
        }
    }

    private String b(f fVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(fVar.c().toLowerCase());
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        stringBuffer.append(fVar.a().toLowerCase());
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        stringBuffer.append("9sc87244121ip32590fq234mn6641tx7".toLowerCase());
        String a2 = com.baidu.mapsdkplatform.comapi.synchronization.d.c.a(stringBuffer.toString());
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "The orderId = " + stringBuffer.toString() + "; result = " + a2);
        return a2;
    }

    private void b() {
        String authToken = SyncSysInfo.getAuthToken();
        if (authToken != null) {
            this.b.a("token", authToken);
            return;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Token is null, permission check again");
        int permissionCheck = PermissionCheck.permissionCheck();
        if (permissionCheck != 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Permission check result is: " + permissionCheck);
        }
    }

    private String c() {
        return e ? com.baidu.mapsdkplatform.comapi.synchronization.b.f.a() : com.baidu.mapsdkplatform.comapi.synchronization.b.f.b();
    }

    private void c(f fVar) {
        f.b g = fVar.g();
        if (f.b.DRIVING == g) {
            this.b.a("trip_mode", "driving");
        } else if (f.b.RIDING == g) {
            this.b.a("trip_mode", "riding");
        } else {
            this.b.a("trip_mode", "driving");
        }
    }

    private void d(f fVar) {
        f.a f = fVar.f();
        if (f.a.BD09LL == f) {
            this.b.a("coord_type", "bd09ll");
        } else if (f.a.BD09MC == f) {
            this.b.a("coord_type", CoordinateType.BD09MC);
        } else if (f.a.GPS == f) {
            this.b.a("coord_type", "wgs84");
        } else if (f.a.COMMON == f) {
            this.b.a("coord_type", "gcj02");
        } else {
            this.b.a("coord_type", "bd09ll");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        StringBuffer stringBuffer = new StringBuffer(this.b.a());
        stringBuffer.append(SyncSysInfo.getPhoneInfo());
        if (this.d) {
            stringBuffer.append("&sign=").append(AppMD5.getSignMD5String(stringBuffer.toString()));
        }
        return new StringBuffer(c()).append("?").append(stringBuffer).toString();
    }
}
