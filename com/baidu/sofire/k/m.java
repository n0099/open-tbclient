package com.baidu.sofire.k;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n30;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class m implements n30<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String[] a;
    public final /* synthetic */ boolean[] b;

    public m(String[] strArr, boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr, zArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = strArr;
        this.b = zArr;
    }

    @Override // com.baidu.tieba.n30
    public void onError(int i, Throwable th, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, th, bundle) == null) {
            try {
                this.b[0] = true;
                Object obj = o.a;
                synchronized (o.a) {
                    o.a.notifyAll();
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.os.Bundle] */
    @Override // com.baidu.tieba.n30
    public void onResult(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
            try {
                this.a[0] = str;
                this.b[0] = true;
                Object obj = o.a;
                synchronized (o.a) {
                    try {
                        o.a.notifyAll();
                    } catch (Throwable unused) {
                        int i = com.baidu.sofire.a.b.a;
                    }
                }
            } catch (Throwable unused2) {
                int i2 = com.baidu.sofire.a.b.a;
            }
        }
    }
}
