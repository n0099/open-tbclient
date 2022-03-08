package com.baidu.mobstat;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class w implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z a;

    /* renamed from: b  reason: collision with root package name */
    public Object f35546b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f35547c;

    public w(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = z.a;
        if (obj != null) {
            if ("com.baidu.bottom.remote.BPStretegyController2".equals(obj.getClass().getName())) {
                this.f35546b = obj;
                this.f35547c = obj.getClass();
                return;
            }
            throw new IllegalArgumentException("class isn't com.baidu.bottom.remote.BPStretegyController2");
        }
        throw new IllegalArgumentException("proxy is null.");
    }

    @Override // com.baidu.mobstat.a
    public void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject) == null) {
            try {
                a(new Object[]{context, jSONObject}, "startDataAnynalyze", new Class[]{Context.class, JSONObject.class});
            } catch (Exception e2) {
                bb.c().b(e2);
                this.a.a(context, jSONObject);
            }
        }
    }

    @Override // com.baidu.mobstat.a
    public void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) {
            try {
                a(new Object[]{context, str}, "saveRemoteSign", new Class[]{Context.class, String.class});
            } catch (Exception e2) {
                bb.c().b(e2);
                this.a.b(context, str);
            }
        }
    }

    @Override // com.baidu.mobstat.a
    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
            try {
                a(new Object[]{context, str}, "saveRemoteConfig2", new Class[]{Context.class, String.class});
            } catch (Exception e2) {
                bb.c().b(e2);
                this.a.a(context, str);
            }
        }
    }

    @Override // com.baidu.mobstat.a
    public boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            try {
                return ((Boolean) a(new Object[]{context}, "canStartService", new Class[]{Context.class})).booleanValue();
            } catch (Exception e2) {
                bb.c().b(e2);
                return this.a.b(context);
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mobstat.a
    public void a(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, context, j2) == null) {
            try {
                a(new Object[]{context, Long.valueOf(j2)}, "setLastUpdateTime", new Class[]{Context.class, Long.TYPE});
            } catch (Exception e2) {
                bb.c().b(e2);
                this.a.a(context, j2);
            }
        }
    }

    @Override // com.baidu.mobstat.a
    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            try {
                return ((Boolean) a(new Object[]{context}, "needUpdate", new Class[]{Context.class})).booleanValue();
            } catch (Exception e2) {
                bb.c().b(e2);
                return this.a.a(context);
            }
        }
        return invokeL.booleanValue;
    }

    private <T> T a(Object[] objArr, String str, Class<?>[] clsArr) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, objArr, str, clsArr)) == null) ? (T) this.f35547c.getMethod(str, clsArr).invoke(this.f35546b, objArr) : (T) invokeLLL.objValue;
    }
}
