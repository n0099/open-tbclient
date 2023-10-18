package com.baidu.mobads.sdk.internal;

import android.content.SharedPreferences;
import android.os.Handler;
import com.baidu.mobads.sdk.internal.bx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cf extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ bx.c b;
    public final /* synthetic */ Handler c;
    public final /* synthetic */ bx d;

    public cf(bx bxVar, bx.c cVar, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bxVar, cVar, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = bxVar;
        this.b = cVar;
        this.c = handler;
    }

    @Override // com.baidu.mobads.sdk.internal.h
    public Object i() {
        InterceptResult invokeV;
        br brVar;
        SharedPreferences m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                synchronized (bx.class) {
                    this.d.b(this.b, this.c);
                }
                m = this.d.m();
                SharedPreferences.Editor edit = m.edit();
                edit.putString(bx.d, this.d.a());
                edit.apply();
                return null;
            } catch (Throwable th) {
                brVar = this.d.z;
                brVar.a(bx.a, th);
                return null;
            }
        }
        return invokeV.objValue;
    }
}
