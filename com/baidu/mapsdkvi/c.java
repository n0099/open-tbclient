package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f26933b;

    /* renamed from: c  reason: collision with root package name */
    public int f26934c;

    public c(NetworkInfo networkInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {networkInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = networkInfo.getTypeName();
        this.f26933b = networkInfo.getType();
        int i3 = d.a[networkInfo.getState().ordinal()];
        if (i3 == 1) {
            this.f26934c = 2;
        } else if (i3 != 2) {
            this.f26934c = 0;
        } else {
            this.f26934c = 1;
        }
    }
}
