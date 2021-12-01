package com.alipay.security.mobile.module.http;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static c f31501d;

    /* renamed from: e  reason: collision with root package name */
    public static DataReportResult f31502e;
    public transient /* synthetic */ FieldHolder $fh;
    public w a;

    /* renamed from: b  reason: collision with root package name */
    public BugTrackMessageService f31503b;

    /* renamed from: c  reason: collision with root package name */
    public DataReportService f31504c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1133367685, "Lcom/alipay/security/mobile/module/http/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1133367685, "Lcom/alipay/security/mobile/module/http/c;");
        }
    }

    public c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f31503b = null;
        this.f31504c = null;
        aa aaVar = new aa();
        aaVar.a(str);
        h hVar = new h(context);
        this.a = hVar;
        this.f31503b = (BugTrackMessageService) hVar.a(BugTrackMessageService.class, aaVar);
        this.f31504c = (DataReportService) this.a.a(DataReportService.class, aaVar);
    }

    public static synchronized c a(Context context, String str) {
        InterceptResult invokeLL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            synchronized (c.class) {
                if (f31501d == null) {
                    f31501d = new c(context, str);
                }
                cVar = f31501d;
            }
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    @Override // com.alipay.security.mobile.module.http.a
    public DataReportResult a(DataReportRequest dataReportRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dataReportRequest)) == null) {
            if (dataReportRequest == null) {
                return null;
            }
            if (this.f31504c != null) {
                f31502e = null;
                new Thread(new b(this, dataReportRequest)).start();
                for (int i2 = 300000; f31502e == null && i2 >= 0; i2 -= 50) {
                    Thread.sleep(50L);
                }
            }
            return f31502e;
        }
        return (DataReportResult) invokeL.objValue;
    }

    @Override // com.alipay.security.mobile.module.http.a
    public boolean logCollect(String str) {
        InterceptResult invokeL;
        BugTrackMessageService bugTrackMessageService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (com.alipay.security.mobile.module.a.a.a(str) || (bugTrackMessageService = this.f31503b) == null) {
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
        return invokeL.booleanValue;
    }
}
