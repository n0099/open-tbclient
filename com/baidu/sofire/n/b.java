package com.baidu.sofire.n;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.j.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class b implements com.baidu.sofire.j.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f45290a;

    /* renamed from: b  reason: collision with root package name */
    public a f45291b;

    public b() {
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
    public final void a(Context context, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, cVar) == null) {
            this.f45290a = context;
            a aVar = new a();
            this.f45291b = aVar;
            aVar.f45286c = null;
            aVar.f45287d = null;
            aVar.f45288e = null;
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                aVar.f45285b = cls;
                aVar.f45284a = cls.newInstance();
            } catch (Exception unused) {
            }
            try {
                aVar.f45286c = aVar.f45285b.getMethod("getOAID", Context.class);
            } catch (Exception unused2) {
            }
            try {
                aVar.f45287d = aVar.f45285b.getMethod("getVAID", Context.class);
            } catch (Exception unused3) {
            }
            try {
                aVar.f45288e = aVar.f45285b.getMethod("getAAID", Context.class);
            } catch (Exception unused4) {
            }
        }
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.f45291b;
            Context context = this.f45290a;
            if (TextUtils.isEmpty(aVar.f45289f)) {
                aVar.f45289f = aVar.a(context, aVar.f45286c);
            }
            return aVar.f45289f;
        }
        return (String) invokeV.objValue;
    }
}
