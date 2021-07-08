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
/* loaded from: classes3.dex */
public final class b implements com.baidu.sofire.j.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f10475a;

    /* renamed from: b  reason: collision with root package name */
    public a f10476b;

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
            this.f10475a = context;
            a aVar = new a();
            this.f10476b = aVar;
            aVar.f10471c = null;
            aVar.f10472d = null;
            aVar.f10473e = null;
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                aVar.f10470b = cls;
                aVar.f10469a = cls.newInstance();
            } catch (Exception e2) {
                Log.d("IdentifierManager", "reflect exception!", e2);
            }
            try {
                aVar.f10471c = aVar.f10470b.getMethod("getOAID", Context.class);
            } catch (Exception e3) {
                Log.d("IdentifierManager", "reflect exception!", e3);
            }
            try {
                aVar.f10472d = aVar.f10470b.getMethod("getVAID", Context.class);
            } catch (Exception e4) {
                Log.d("IdentifierManager", "reflect exception!", e4);
            }
            try {
                aVar.f10473e = aVar.f10470b.getMethod("getAAID", Context.class);
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
            a aVar = this.f10476b;
            Context context = this.f10475a;
            if (TextUtils.isEmpty(aVar.f10474f)) {
                aVar.f10474f = aVar.a(context, aVar.f10471c);
            }
            return aVar.f10474f;
        }
        return (String) invokeV.objValue;
    }
}
