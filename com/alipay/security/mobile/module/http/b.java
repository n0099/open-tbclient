package com.alipay.security.mobile.module.http;

import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DataReportRequest f34320a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f34321b;

    public b(c cVar, DataReportRequest dataReportRequest) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, dataReportRequest};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34321b = cVar;
        this.f34320a = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        DataReportResult dataReportResult;
        DataReportResult dataReportResult2;
        DataReportService dataReportService;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                dataReportService = this.f34321b.f34326c;
                DataReportResult unused = c.f34323e = dataReportService.reportData(this.f34320a);
            } catch (Throwable th) {
                DataReportResult unused2 = c.f34323e = new DataReportResult();
                dataReportResult = c.f34323e;
                dataReportResult.success = false;
                dataReportResult2 = c.f34323e;
                dataReportResult2.resultCode = "static data rpc upload error, " + com.alipay.security.mobile.module.a.a.a(th);
                new StringBuilder("rpc failed:").append(com.alipay.security.mobile.module.a.a.a(th));
            }
        }
    }
}
