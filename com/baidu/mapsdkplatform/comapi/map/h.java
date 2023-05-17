package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.commonutils.a.c;
import com.baidu.mapsdkplatform.comapi.map.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class h implements c.InterfaceC0113c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ f.a c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ f f;

    public h(f fVar, Context context, String str, f.a aVar, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, context, str, aVar, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = fVar;
        this.a = context;
        this.b = str;
        this.c = aVar;
        this.d = str2;
        this.e = str3;
    }

    @Override // com.baidu.mapsdkplatform.comapi.commonutils.a.c.InterfaceC0113c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f.a aVar = this.c;
            if (aVar != null) {
                aVar.a(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "loadStyleFile onFailed", null);
            }
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("CustomMap loadStyleFile failed");
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.commonutils.a.c.InterfaceC0113c
    public void a(File file) {
        boolean a;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) != null) {
            return;
        }
        a = this.f.a(this.a, file, this.b);
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b a3 = com.baidu.mapsdkplatform.comapi.commonutils.b.a();
            a3.a("CustomMap loadStyleFile success ret = " + a);
        }
        String str = null;
        if (!a) {
            f.a aVar = this.c;
            if (aVar != null) {
                aVar.a(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "UnZipStyleFile onFailed", null);
                return;
            }
            return;
        }
        this.f.a(this.a, this.b, this.d);
        if (this.c == null) {
            return;
        }
        a2 = this.f.a(this.e);
        if (a2) {
            str = this.e;
        }
        this.c.a(true, str);
    }
}
