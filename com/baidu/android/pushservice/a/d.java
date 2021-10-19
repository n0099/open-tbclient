package com.baidu.android.pushservice.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f36926a;

    /* renamed from: b  reason: collision with root package name */
    public c f36927b;

    public d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36927b = cVar;
    }

    public static d a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            b.a(context).b(context);
            e b2 = b.a(context).b(str);
            if (b2 != null && !TextUtils.isEmpty(b2.f36917b)) {
                d dVar = new d(c.f36923a);
                dVar.f36926a = b2;
                return dVar;
            }
            m.a("ClientTypeInfo*BBind* isRegisteredClientByAppid not PushClient! appid=" + str, context);
            return new d(c.f36924b);
        }
        return (d) invokeLL.objValue;
    }

    public c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36927b : (c) invokeV.objValue;
    }
}
