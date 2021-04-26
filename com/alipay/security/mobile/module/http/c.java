package com.alipay.security.mobile.module.http;

import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DataReportRequest f2076a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f2077b;

    public c(b bVar, DataReportRequest dataReportRequest) {
        this.f2077b = bVar;
        this.f2076a = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        DataReportResult dataReportResult;
        DataReportResult dataReportResult2;
        DataReportService dataReportService;
        try {
            dataReportService = this.f2077b.f2075c;
            DataReportResult unused = b.f2072e = dataReportService.reportData(this.f2076a);
        } catch (Throwable th) {
            DataReportResult unused2 = b.f2072e = new DataReportResult();
            dataReportResult = b.f2072e;
            dataReportResult.success = false;
            dataReportResult2 = b.f2072e;
            dataReportResult2.resultCode = "static data rpc upload error, " + com.alipay.security.mobile.module.a.a.a(th);
            new StringBuilder("rpc failed:").append(com.alipay.security.mobile.module.a.a.a(th));
        }
    }
}
