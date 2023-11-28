package com.baidu.android.pushservice.ach.e;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d c;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public Context b;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = context.getApplicationContext();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new b());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.b(context)) {
                this.a = cVar;
                return;
            }
        }
    }

    public static d a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? (d) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15952, null, context) : (d) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15951, this, null);
        }
    }

    public void a(Service service, Intent intent, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{service, intent, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15946, this, service, intent, Integer.valueOf(i), Boolean.valueOf(z));
        }
    }
}
