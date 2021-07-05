package com.baidu.sofire.n;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.j.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class b implements com.baidu.sofire.j.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f10458a;

    /* renamed from: b  reason: collision with root package name */
    public a f10459b;

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
            this.f10458a = context;
            a aVar = new a();
            this.f10459b = aVar;
            aVar.f10454c = null;
            aVar.f10455d = null;
            aVar.f10456e = null;
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                aVar.f10453b = cls;
                aVar.f10452a = cls.newInstance();
            } catch (Exception e2) {
                Log.d("IdentifierManager", "reflect exception!", e2);
            }
            try {
                aVar.f10454c = aVar.f10453b.getMethod("getOAID", Context.class);
            } catch (Exception e3) {
                Log.d("IdentifierManager", "reflect exception!", e3);
            }
            try {
                aVar.f10455d = aVar.f10453b.getMethod("getVAID", Context.class);
            } catch (Exception e4) {
                Log.d("IdentifierManager", "reflect exception!", e4);
            }
            try {
                aVar.f10456e = aVar.f10453b.getMethod("getAAID", Context.class);
            } catch (Exception e5) {
                Log.d("IdentifierManager", "reflect exception!", e5);
            }
        }
    }

    @Override // com.baidu.sofire.j.b
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.f10459b;
            Context context = this.f10458a;
            if (TextUtils.isEmpty(aVar.f10457f)) {
                aVar.f10457f = aVar.a(context, aVar.f10454c);
            }
            return aVar.f10457f;
        }
        return (String) invokeV.objValue;
    }
}
