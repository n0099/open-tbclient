package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
public class f {
    private static final String a = f.class.getSimpleName();
    private static boolean c = true;
    private static int d = 1;
    private com.baidu.mapsdkplatform.comapi.synchronization.d.d b = new com.baidu.mapsdkplatform.comapi.synchronization.d.d();

    public f(HistoryTraceQueryOptions historyTraceQueryOptions) {
        a(historyTraceQueryOptions);
    }

    public static void a(int i) {
        d = i;
    }

    private void a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        this.b.a("order_id", b(historyTraceQueryOptions));
        this.b.a("original_order_id", historyTraceQueryOptions.getOrderId().toLowerCase());
        this.b.a("company", historyTraceQueryOptions.getUserId());
        this.b.a("order_attr", historyTraceQueryOptions.getDriverId());
        this.b.a("track_status", String.valueOf(historyTraceQueryOptions.getQueryOrderState()));
        this.b.a("status", String.valueOf(historyTraceQueryOptions.getCurrentOrderState()));
        if (CoordType.BD09LL == SDKInitializer.getCoordType()) {
            this.b.a("coord_type", "bd09ll");
        } else if (CoordType.GCJ02 == SDKInitializer.getCoordType()) {
            this.b.a("coord_type", CoordinateType.GCJ02);
        } else {
            this.b.a("coord_type", "bd09ll");
        }
        this.b.a("page_index", String.valueOf(d));
        d = 1;
        this.b.a("page_size", "5000");
        this.b.a("is_processed", "1");
        b();
    }

    private String b(HistoryTraceQueryOptions historyTraceQueryOptions) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(historyTraceQueryOptions.getUserId().toLowerCase());
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        stringBuffer.append(historyTraceQueryOptions.getOrderId().toLowerCase());
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        stringBuffer.append("9sc87244121ip32590fq234mn6641tx7".toLowerCase());
        String a2 = com.baidu.mapsdkplatform.comapi.synchronization.d.c.a(stringBuffer.toString());
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "The orderId = " + stringBuffer.toString() + "; result = " + a2);
        return a2;
    }

    private void b() {
        String authToken = SyncSysInfo.getAuthToken();
        if (authToken == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Token is null, permission check again");
            int permissionCheck = PermissionCheck.permissionCheck();
            if (permissionCheck != 0) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Permission check result is: " + permissionCheck);
                return;
            }
            authToken = SyncSysInfo.getAuthToken();
        }
        this.b.a("token", authToken);
    }

    private String c() {
        return c ? g.a() : g.b();
    }

    public String a() {
        StringBuffer stringBuffer = new StringBuffer(this.b.a());
        stringBuffer.append(SyncSysInfo.getPhoneInfo());
        stringBuffer.append("&sign=").append(AppMD5.getSignMD5String(stringBuffer.toString()));
        return new StringBuffer(c()).append("?").append(stringBuffer).toString();
    }
}
