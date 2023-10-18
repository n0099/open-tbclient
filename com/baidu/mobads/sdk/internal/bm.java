package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.internal.bx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bm {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "ContainerFactoryBuilder";
    public static IXAdContainerFactory e;
    public transient /* synthetic */ FieldHolder $fh;
    public double b;
    public Context c;
    public Class<?> d;
    public br f;

    public bm(Class<?> cls, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.b = 0.1d;
        this.f = br.a();
        this.d = cls;
        this.c = context;
    }

    public IXAdContainerFactory a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (e == null) {
                try {
                    e = (IXAdContainerFactory) this.d.getDeclaredConstructor(Context.class).newInstance(this.c);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("p_ver", "9.322");
                    e.initConfig(jSONObject);
                    this.b = e.getRemoteVersion();
                    e.onTaskDistribute(az.a, MobadsPermissionSettings.getPermissionInfo());
                    e.initCommonModuleObj(q.a());
                } catch (Throwable th) {
                    this.f.b(a, th.getMessage());
                    throw new bx.a("ContainerFactory() failed, possibly API incompatible: " + th.getMessage());
                }
            }
            return e;
        }
        return (IXAdContainerFactory) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e = null;
        }
    }
}
