package com.baidu.ar.auth;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.k;
import com.baidu.ar.h.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class l implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<String> kc;
    public long kd;

    public l(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.kc = arrayList;
        if (fVar != null) {
            List<String> list = fVar.jK;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.kd = fVar.jP;
        }
    }

    @Override // com.baidu.ar.auth.k
    public void a(k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Context context, String[] strArr) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, strArr)) == null) {
            String aT = com.baidu.ar.h.l.aT(context.getPackageName());
            if (this.kd > 0) {
                long[] a = m.a(10, 50L);
                if (a[0] != 1) {
                    com.baidu.ar.h.b.b("ARAuth", "time err. " + a[1]);
                } else if (a[1] > this.kd) {
                    z = false;
                    boolean z2 = !z && this.kc.contains(aT);
                    if (strArr != null && strArr.length >= 1) {
                        if (z) {
                            strArr[0] = "license已经过期";
                        } else if (!z2) {
                            StringBuilder sb = new StringBuilder();
                            Iterator<String> it = this.kc.iterator();
                            while (it.hasNext()) {
                                sb.append(it.next() + ",");
                            }
                            strArr[0] = String.format("包名不符，MD5正确值：%s 现为：%s", sb.toString(), aT);
                        }
                    }
                    return z2;
                }
            }
            z = true;
            if (z) {
            }
            if (strArr != null) {
                if (z) {
                }
            }
            return z2;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.ar.auth.k
    public void doAuth(Context context, IAuthCallback iAuthCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, iAuthCallback) == null) {
            String[] strArr = new String[1];
            r.a(new Runnable(this, iAuthCallback, a(context, strArr), strArr) { // from class: com.baidu.ar.auth.l.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IAuthCallback jl;
                public final /* synthetic */ boolean ke;
                public final /* synthetic */ String[] kf;
                public final /* synthetic */ l kg;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iAuthCallback, Boolean.valueOf(r8), strArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.kg = this;
                    this.jl = iAuthCallback;
                    this.ke = r8;
                    this.kf = strArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IAuthCallback iAuthCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (iAuthCallback2 = this.jl) == null) {
                        return;
                    }
                    if (this.ke) {
                        iAuthCallback2.onSuccess();
                    } else {
                        iAuthCallback2.onError(this.kf[0], 0);
                    }
                }
            }, 0L);
        }
    }
}
