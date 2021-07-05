package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.b.b;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d extends com.baidu.mapsdkplatform.comapi.synchronization.c.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7798a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HistoryTraceQueryOptions f7799b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f7800c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b.a f7801d;

    public d(b.a aVar, int i2, HistoryTraceQueryOptions historyTraceQueryOptions, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Integer.valueOf(i2), historyTraceQueryOptions, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7801d = aVar;
        this.f7798a = i2;
        this.f7799b = historyTraceQueryOptions;
        this.f7800c = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(c.a aVar) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (c.a.f7834e == aVar || c.a.f7831b == aVar || c.a.f7832c == aVar || c.a.f7833d == aVar) {
                i2 = b.f7792g;
                if (i2 <= 2) {
                    this.f7801d.a(this.f7800c, this.f7798a, this.f7799b);
                    i3 = b.f7792g;
                    int unused = b.f7792g = i3 + 1;
                }
            }
            i4 = b.f7792g;
            if (2 < i4) {
                this.f7801d.a(aVar, this.f7798a);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String str2 = b.f7788a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "Request success, the result = " + str);
            this.f7801d.a(3, str, this.f7798a, this.f7799b);
            int unused = b.f7792g = 0;
        }
    }
}
