package com.alipay.security.mobile.module.http;

import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DataReportRequest f2126a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f2127b;

    public c(b bVar, DataReportRequest dataReportRequest) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, dataReportRequest};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2127b = bVar;
        this.f2126a = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        DataReportResult dataReportResult;
        DataReportResult dataReportResult2;
        DataReportService dataReportService;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                dataReportService = this.f2127b.f2125c;
                DataReportResult unused = b.f2122e = dataReportService.reportData(this.f2126a);
            } catch (Throwable th) {
                DataReportResult unused2 = b.f2122e = new DataReportResult();
                dataReportResult = b.f2122e;
                dataReportResult.success = false;
                dataReportResult2 = b.f2122e;
                dataReportResult2.resultCode = "static data rpc upload error, " + com.alipay.security.mobile.module.a.a.a(th);
                new StringBuilder("rpc failed:").append(com.alipay.security.mobile.module.a.a.a(th));
            }
        }
    }
}
