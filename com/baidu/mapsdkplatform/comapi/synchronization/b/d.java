package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.b.b;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d extends com.baidu.mapsdkplatform.comapi.synchronization.c.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f41053a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HistoryTraceQueryOptions f41054b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f41055c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b.a f41056d;

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
        this.f41056d = aVar;
        this.f41053a = i2;
        this.f41054b = historyTraceQueryOptions;
        this.f41055c = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(c.a aVar) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (c.a.f41089e == aVar || c.a.f41086b == aVar || c.a.f41087c == aVar || c.a.f41088d == aVar) {
                i2 = b.f41047g;
                if (i2 <= 2) {
                    this.f41056d.a(this.f41055c, this.f41053a, this.f41054b);
                    i3 = b.f41047g;
                    int unused = b.f41047g = i3 + 1;
                }
            }
            i4 = b.f41047g;
            if (2 < i4) {
                this.f41056d.a(aVar, this.f41053a);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String str2 = b.f41043a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "Request success, the result = " + str);
            this.f41056d.a(3, str, this.f41053a, this.f41054b);
            int unused = b.f41047g = 0;
        }
    }
}
