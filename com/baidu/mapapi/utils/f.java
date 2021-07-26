package com.baidu.mapapi.utils;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class f implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f7537a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7538b;

    public f(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7537a = context;
        this.f7538b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread thread;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            do {
                if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                    b.a(this.f7537a);
                    b.a(this.f7538b, this.f7537a);
                }
                thread = b.v;
            } while (!thread.isInterrupted());
        }
    }
}
