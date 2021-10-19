package com.baidu.sofire.l;

import android.content.Context;
import android.content.ServiceConnection;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f45380a;

    /* renamed from: b  reason: collision with root package name */
    public c f45381b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f45382c;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.sofire.k.c f45383d;

    /* renamed from: e  reason: collision with root package name */
    public String f45384e;

    public a(Context context, com.baidu.sofire.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45380a = null;
        this.f45380a = context;
        this.f45383d = cVar;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f45384e)) {
                if (this.f45381b != null) {
                    this.f45384e = this.f45381b.a();
                }
                return this.f45384e;
            }
            return this.f45384e;
        }
        return (String) invokeV.objValue;
    }
}
