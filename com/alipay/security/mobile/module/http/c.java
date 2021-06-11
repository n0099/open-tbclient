package com.alipay.security.mobile.module.http;

import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DataReportRequest f2089a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f2090b;

    public c(b bVar, DataReportRequest dataReportRequest) {
        this.f2090b = bVar;
        this.f2089a = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        DataReportResult dataReportResult;
        DataReportResult dataReportResult2;
        DataReportService dataReportService;
        try {
            dataReportService = this.f2090b.f2088c;
            DataReportResult unused = b.f2085e = dataReportService.reportData(this.f2089a);
        } catch (Throwable th) {
            DataReportResult unused2 = b.f2085e = new DataReportResult();
            dataReportResult = b.f2085e;
            dataReportResult.success = false;
            dataReportResult2 = b.f2085e;
            dataReportResult2.resultCode = "static data rpc upload error, " + com.alipay.security.mobile.module.a.a.a(th);
            new StringBuilder("rpc failed:").append(com.alipay.security.mobile.module.a.a.a(th));
        }
    }
}
