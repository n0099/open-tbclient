package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8041a = "f";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f8042c = true;

    /* renamed from: d  reason: collision with root package name */
    public static int f8043d = 1;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.d.d f8044b = new com.baidu.mapsdkplatform.comapi.synchronization.d.d();

    public f(HistoryTraceQueryOptions historyTraceQueryOptions) {
        a(historyTraceQueryOptions);
    }

    public static void a(int i2) {
        f8043d = i2;
    }

    private void a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        this.f8044b.a("order_id", b(historyTraceQueryOptions));
        this.f8044b.a("original_order_id", historyTraceQueryOptions.getOrderId().toLowerCase());
        this.f8044b.a("company", historyTraceQueryOptions.getUserId());
        this.f8044b.a("order_attr", historyTraceQueryOptions.getDriverId());
        this.f8044b.a("track_status", String.valueOf(historyTraceQueryOptions.getQueryOrderState()));
        this.f8044b.a("status", String.valueOf(historyTraceQueryOptions.getCurrentOrderState()));
        if (CoordType.BD09LL != SDKInitializer.getCoordType() && CoordType.GCJ02 == SDKInitializer.getCoordType()) {
            this.f8044b.a("coord_type", "gcj02");
        } else {
            this.f8044b.a("coord_type", "bd09ll");
        }
        this.f8044b.a("page_index", String.valueOf(f8043d));
        f8043d = 1;
        this.f8044b.a("page_size", "5000");
        this.f8044b.a("is_processed", "1");
        b();
    }

    private String b(HistoryTraceQueryOptions historyTraceQueryOptions) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(historyTraceQueryOptions.getUserId().toLowerCase());
        stringBuffer.append("-");
        stringBuffer.append(historyTraceQueryOptions.getOrderId().toLowerCase());
        stringBuffer.append("-");
        stringBuffer.append("9sc87244121ip32590fq234mn6641tx7".toLowerCase());
        String a2 = com.baidu.mapsdkplatform.comapi.synchronization.d.c.a(stringBuffer.toString());
        String str = f8041a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(str, "The orderId = " + stringBuffer.toString() + "; result = " + a2);
        return a2;
    }

    private void b() {
        String authToken = SyncSysInfo.getAuthToken();
        if (authToken == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8041a, "Token is null, permission check again");
            int permissionCheck = PermissionCheck.permissionCheck();
            if (permissionCheck != 0) {
                String str = f8041a;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "Permission check result is: " + permissionCheck);
                return;
            }
            authToken = SyncSysInfo.getAuthToken();
        }
        this.f8044b.a("token", authToken);
    }

    private String c() {
        return f8042c ? g.a() : g.b();
    }

    public String a() {
        StringBuffer stringBuffer = new StringBuffer(this.f8044b.a());
        stringBuffer.append(SyncSysInfo.getPhoneInfo());
        String signMD5String = AppMD5.getSignMD5String(stringBuffer.toString());
        stringBuffer.append("&sign=");
        stringBuffer.append(signMD5String);
        StringBuffer stringBuffer2 = new StringBuffer(c());
        stringBuffer2.append("?");
        stringBuffer2.append(stringBuffer);
        return stringBuffer2.toString();
    }
}
