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
    public final /* synthetic */ int f40221a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HistoryTraceQueryOptions f40222b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f40223c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b.a f40224d;

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
        this.f40224d = aVar;
        this.f40221a = i2;
        this.f40222b = historyTraceQueryOptions;
        this.f40223c = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(c.a aVar) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (c.a.f40257e == aVar || c.a.f40254b == aVar || c.a.f40255c == aVar || c.a.f40256d == aVar) {
                i2 = b.f40215g;
                if (i2 <= 2) {
                    this.f40224d.a(this.f40223c, this.f40221a, this.f40222b);
                    i3 = b.f40215g;
                    int unused = b.f40215g = i3 + 1;
                }
            }
            i4 = b.f40215g;
            if (2 < i4) {
                this.f40224d.a(aVar, this.f40221a);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String str2 = b.f40211a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "Request success, the result = " + str);
            this.f40224d.a(3, str, this.f40221a, this.f40222b);
            int unused = b.f40215g = 0;
        }
    }
}
