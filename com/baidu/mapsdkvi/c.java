package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f8040a;

    /* renamed from: b  reason: collision with root package name */
    public int f8041b;

    /* renamed from: c  reason: collision with root package name */
    public int f8042c;

    public c(NetworkInfo networkInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {networkInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8040a = networkInfo.getTypeName();
        this.f8041b = networkInfo.getType();
        int i4 = d.f8043a[networkInfo.getState().ordinal()];
        if (i4 == 1) {
            this.f8042c = 2;
        } else if (i4 != 2) {
            this.f8042c = 0;
        } else {
            this.f8042c = 1;
        }
    }
}
