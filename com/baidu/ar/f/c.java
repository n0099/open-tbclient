package com.baidu.ar.f;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.f.a;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements com.baidu.ar.lua.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public a.InterfaceC1768a wg;

    public c(Context context) {
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
        this.mContext = context.getApplicationContext();
    }

    public static void c(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("id", 10000);
            hashMap.put("max_acc", Float.valueOf(f5));
            ARPMessage.getInstance().sendMessage(1902, hashMap);
        }
    }

    @Override // com.baidu.ar.lua.c
    public void a(int i2, int i3, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, hashMap) == null) && i2 == 1901 && hashMap != null) {
            int a = com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1);
            if (a == 10001) {
                b.q(this.mContext).b(this.wg);
            } else if (a == 10002) {
                b.q(this.mContext).stop();
            } else if (a != 10004) {
            } else {
                b.q(this.mContext).S(true);
            }
        }
    }

    public void b(com.baidu.ar.lua.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.wg = new a.InterfaceC1768a(this) { // from class: com.baidu.ar.f.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c wh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.wh = this;
                }

                @Override // com.baidu.ar.f.a.InterfaceC1768a
                public void b(float f2, float f3, float f4, float f5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                        com.baidu.ar.h.b.aS("acc  x " + f2 + " , y : " + f3 + " , z " + f4);
                        StatisticApi.onEvent(StatisticConstants.MODEL_PHONE_SHAKE);
                        c.c(f2, f3, f4, f5);
                    }
                }

                @Override // com.baidu.ar.f.a.InterfaceC1768a
                public void destroy() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }
            };
            bVar.c(this);
        }
    }

    @Override // com.baidu.ar.lua.c
    public List<Integer> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Arrays.asList(1901) : (List) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.q(this.mContext).destroy();
            this.wg = null;
            this.mContext = null;
        }
    }

    public void reset() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (context = this.mContext) == null) {
            return;
        }
        try {
            b.q(context).stop();
        } catch (Throwable unused) {
        }
    }
}
