package com.alipay.security.mobile.module.http;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: d  reason: collision with root package name */
    public static b f2085d;

    /* renamed from: e  reason: collision with root package name */
    public static DataReportResult f2086e;

    /* renamed from: a  reason: collision with root package name */
    public w f2087a;

    /* renamed from: b  reason: collision with root package name */
    public BugTrackMessageService f2088b;

    /* renamed from: c  reason: collision with root package name */
    public DataReportService f2089c;

    public b(Context context, String str) {
        this.f2087a = null;
        this.f2088b = null;
        this.f2089c = null;
        aa aaVar = new aa();
        aaVar.a(str);
        h hVar = new h(context);
        this.f2087a = hVar;
        this.f2088b = (BugTrackMessageService) hVar.a(BugTrackMessageService.class, aaVar);
        this.f2089c = (DataReportService) this.f2087a.a(DataReportService.class, aaVar);
    }

    public static synchronized b a(Context context, String str) {
        b bVar;
        synchronized (b.class) {
            if (f2085d == null) {
                f2085d = new b(context, str);
            }
            bVar = f2085d;
        }
        return bVar;
    }

    @Override // com.alipay.security.mobile.module.http.a
    public DataReportResult a(DataReportRequest dataReportRequest) {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.f2089c != null) {
            f2086e = null;
            new Thread(new c(this, dataReportRequest)).start();
            for (int i = 300000; f2086e == null && i >= 0; i -= 50) {
                Thread.sleep(50L);
            }
        }
        return f2086e;
    }

    @Override // com.alipay.security.mobile.module.http.a
    public boolean a(String str) {
        BugTrackMessageService bugTrackMessageService;
        if (com.alipay.security.mobile.module.a.a.a(str) || (bugTrackMessageService = this.f2088b) == null) {
            return false;
        }
        String str2 = null;
        try {
            str2 = bugTrackMessageService.logCollect(com.alipay.security.mobile.module.a.a.f(str));
        } catch (Throwable unused) {
        }
        if (com.alipay.security.mobile.module.a.a.a(str2)) {
            return false;
        }
        return ((Boolean) new JSONObject(str2).get("success")).booleanValue();
    }
}
