package com.baidu.sofire.k;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.rp.receiver.Receiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static b c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public com.baidu.sofire.i.a b;

    public b(Context context) {
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
        this.a = context.getApplicationContext();
        this.b = new com.baidu.sofire.i.a(context);
    }

    public static synchronized b a(Context context) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b(context);
                }
                bVar = c;
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Message message = new Message();
            message.what = 2;
            this.b.a.sendMessage(message);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            com.baidu.sofire.i.a aVar = this.b;
            if (aVar.e == null) {
                aVar.e = new Receiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.b.r.p");
            aVar.c.getApplicationContext().registerReceiver(aVar.e, intentFilter, aVar.c.getPackageName() + ".permission.sofire.RECEIVE", null);
            Message message = new Message();
            message.what = 5;
            aVar.a.sendMessage(message);
        }
    }
}
