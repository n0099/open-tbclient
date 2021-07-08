package com.baidu.android.pushservice.message;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f3549a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<e> f3550b;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3550b = new LinkedList<>();
        this.f3549a = context;
    }

    public abstract e a(byte[] bArr) throws IOException;

    public LinkedList<e> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3550b : (LinkedList) invokeV.objValue;
    }

    public abstract void a(int i2, String str, byte[] bArr);

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            synchronized (this.f3550b) {
                try {
                    this.f3550b.add(eVar);
                    this.f3550b.notifyAll();
                } catch (Exception e2) {
                    new b.c(this.f3549a).a(Log.getStackTraceString(e2)).a();
                }
            }
        }
    }

    public abstract void b();

    public abstract void b(e eVar) throws Exception;

    public abstract void c();

    public abstract void d();
}
