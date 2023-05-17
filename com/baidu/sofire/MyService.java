package com.baidu.sofire;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.a.b;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.b.c;
import com.baidu.sofire.b.i;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.k.u;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.DelayTB;
/* loaded from: classes4.dex */
public class MyService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public static long b;
    public static final /* synthetic */ int c = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Intent b;
        public final /* synthetic */ MyService c;

        public a(MyService myService, String str, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myService, str, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = myService;
            this.a = str;
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.c.a++;
                    if (this.c.getPackageName().equals(this.a)) {
                        MyService myService = this.c;
                        MyService.a(myService, myService.getClassLoader(), this.b);
                        this.c.a();
                    } else if ("teac".equals(this.b.getAction())) {
                        int intExtra = this.b.getIntExtra("plugin_id", 100041);
                        String stringExtra = this.b.getStringExtra("target_method");
                        if (TextUtils.isEmpty(stringExtra)) {
                            this.c.a();
                            return;
                        }
                        c.a(intExtra, stringExtra, (Callback) null, new Class[]{Intent.class}, this.b);
                        this.c.a();
                    } else {
                        i iVar = i.g;
                        if (iVar == null) {
                            this.c.a();
                            return;
                        }
                        ApkInfo b = iVar.b(this.a);
                        if (b == null) {
                            this.c.a();
                            return;
                        }
                        MyService.a(this.c, b.classLoader, this.b);
                        this.c.a();
                    }
                } catch (Throwable unused) {
                    int i = b.a;
                    MyService myService2 = this.c;
                    int i2 = MyService.c;
                    myService2.a();
                }
            }
        }
    }

    public MyService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.a--;
                if (this.a <= 0) {
                    this.a = 0;
                    stopSelf();
                }
            } catch (Throwable unused) {
                int i = b.a;
            }
        }
    }

    public static void a(MyService myService, ClassLoader classLoader, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, myService, classLoader, intent) == null) {
            myService.getClass();
            try {
                Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
                loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), Context.class, Intent.class).invoke(loadClass.newInstance(), myService.getApplicationContext(), intent);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, intent, i, i2)) == null) {
            if (intent == null) {
                return 2;
            }
            try {
                Bundle bundleExtra = intent.getBundleExtra("bundle");
                if (bundleExtra != null) {
                    String[] stringArray = bundleExtra.getStringArray("appkey");
                    int i3 = bundleExtra.getInt("key");
                    int i4 = bundleExtra.getInt(DelayTB.DELAY);
                    if (stringArray != null && stringArray.length == 2 && !TextUtils.isEmpty(stringArray[0]) && !TextUtils.isEmpty(stringArray[1])) {
                        c.a(getApplicationContext(), i4, stringArray[0], stringArray[1], i3);
                        return 2;
                    }
                }
                String stringExtra = intent.getStringExtra("from_plugin_package");
                if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(intent.getAction())) {
                    a();
                } else {
                    long j = b;
                    if ("teac".equals(intent.getAction())) {
                        b = System.currentTimeMillis();
                        if (System.currentTimeMillis() - j < 3000) {
                            return 2;
                        }
                    }
                    u.a(getApplicationContext()).a(new a(this, stringExtra, intent));
                }
            } catch (Throwable unused) {
                int i5 = b.a;
            }
            return 2;
        }
        return invokeLII.intValue;
    }
}
