package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cm extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ cl b;

    public cm(cl clVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {clVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = clVar;
    }

    @Override // com.baidu.mobads.sdk.internal.h
    public Object i() {
        String a;
        String a2;
        Context context;
        String a3;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return invokeV.objValue;
        }
        try {
            a = this.b.a(cl.n);
            a2 = this.b.a(cl.o);
            if (!TextUtils.isEmpty(a)) {
                ci a4 = ci.a();
                context = this.b.k;
                a4.a(context);
                a3 = this.b.a(cl.m);
                a4.a(a3, a, a2);
                this.b.g();
                return null;
            }
            return null;
        } catch (Exception e) {
            br.a().a(e);
            return null;
        }
    }
}
