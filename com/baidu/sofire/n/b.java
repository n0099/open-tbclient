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
    public Context f45405a;

    /* renamed from: b  reason: collision with root package name */
    public a f45406b;

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
            this.f45405a = context;
            a aVar = new a();
            this.f45406b = aVar;
            aVar.f45401c = null;
            aVar.f45402d = null;
            aVar.f45403e = null;
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                aVar.f45400b = cls;
                aVar.f45399a = cls.newInstance();
            } catch (Exception unused) {
            }
            try {
                aVar.f45401c = aVar.f45400b.getMethod("getOAID", Context.class);
            } catch (Exception unused2) {
            }
            try {
                aVar.f45402d = aVar.f45400b.getMethod("getVAID", Context.class);
            } catch (Exception unused3) {
            }
            try {
                aVar.f45403e = aVar.f45400b.getMethod("getAAID", Context.class);
            } catch (Exception unused4) {
            }
        }
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.f45406b;
            Context context = this.f45405a;
            if (TextUtils.isEmpty(aVar.f45404f)) {
                aVar.f45404f = aVar.a(context, aVar.f45401c);
            }
            return aVar.f45404f;
        }
        return (String) invokeV.objValue;
    }
}
