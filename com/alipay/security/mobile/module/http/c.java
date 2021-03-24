package com.alipay.security.mobile.module.http;

import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DataReportRequest f2090a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f2091b;

    public c(b bVar, DataReportRequest dataReportRequest) {
        this.f2091b = bVar;
        this.f2090a = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        DataReportResult dataReportResult;
        DataReportResult dataReportResult2;
        DataReportService dataReportService;
        try {
            dataReportService = this.f2091b.f2089c;
            DataReportResult unused = b.f2086e = dataReportService.reportData(this.f2090a);
        } catch (Throwable th) {
            DataReportResult unused2 = b.f2086e = new DataReportResult();
            dataReportResult = b.f2086e;
            dataReportResult.success = false;
            dataReportResult2 = b.f2086e;
            dataReportResult2.resultCode = "static data rpc upload error, " + com.alipay.security.mobile.module.a.a.a(th);
            new StringBuilder("rpc failed:").append(com.alipay.security.mobile.module.a.a.a(th));
        }
    }
}
