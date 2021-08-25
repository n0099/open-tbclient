package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.b.b;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d extends com.baidu.mapsdkplatform.comapi.synchronization.c.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f42225a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HistoryTraceQueryOptions f42226b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f42227c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b.a f42228d;

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
        this.f42228d = aVar;
        this.f42225a = i2;
        this.f42226b = historyTraceQueryOptions;
        this.f42227c = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(c.a aVar) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (c.a.f42261e == aVar || c.a.f42258b == aVar || c.a.f42259c == aVar || c.a.f42260d == aVar) {
                i2 = b.f42218g;
                if (i2 <= 2) {
                    this.f42228d.a(this.f42227c, this.f42225a, this.f42226b);
                    i3 = b.f42218g;
                    int unused = b.f42218g = i3 + 1;
                }
            }
            i4 = b.f42218g;
            if (2 < i4) {
                this.f42228d.a(aVar, this.f42225a);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String str2 = b.f42214a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "Request success, the result = " + str);
            this.f42228d.a(3, str, this.f42225a, this.f42226b);
            int unused = b.f42218g = 0;
        }
    }
}
