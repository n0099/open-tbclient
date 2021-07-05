package com.baidu.sofire.m;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class c implements com.baidu.sofire.j.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f10440a;

    /* renamed from: b  reason: collision with root package name */
    public String f10441b;

    /* renamed from: c  reason: collision with root package name */
    public Context f10442c;

    /* renamed from: d  reason: collision with root package name */
    public a f10443d;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.sofire.j.b
    public final void a(Context context, com.baidu.sofire.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, cVar) == null) {
            this.f10440a = new b(context);
            this.f10442c = context;
            if ("1".equals(com.baidu.sofire.o.a.a("persist.sys.identifierid.supported", "0"))) {
                this.f10443d = new a(this);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.f10443d);
            }
        }
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.f10441b)) {
                this.f10441b = this.f10440a.a();
            }
            return this.f10441b;
        }
        return (String) invokeV.objValue;
    }
}
