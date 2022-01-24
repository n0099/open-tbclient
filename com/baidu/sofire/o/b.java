package com.baidu.sofire.o;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.k.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class b implements com.baidu.sofire.k.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public a f38530b;

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

    @Override // com.baidu.sofire.k.b
    public final void a(Context context, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, cVar) == null) {
            this.a = context;
            a aVar = new a();
            this.f38530b = aVar;
            aVar.f38526c = null;
            aVar.f38527d = null;
            aVar.f38528e = null;
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                aVar.f38525b = cls;
                aVar.a = cls.newInstance();
            } catch (Exception unused) {
            }
            try {
                aVar.f38526c = aVar.f38525b.getMethod("getOAID", Context.class);
            } catch (Exception unused2) {
            }
            try {
                aVar.f38527d = aVar.f38525b.getMethod("getVAID", Context.class);
            } catch (Exception unused3) {
            }
            try {
                aVar.f38528e = aVar.f38525b.getMethod("getAAID", Context.class);
            } catch (Exception unused4) {
            }
        }
    }

    @Override // com.baidu.sofire.k.b
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.f38530b;
            Context context = this.a;
            if (TextUtils.isEmpty(aVar.f38529f)) {
                aVar.f38529f = aVar.a(context, aVar.f38526c);
            }
            return aVar.f38529f;
        }
        return (String) invokeV.objValue;
    }
}
