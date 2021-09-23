package com.baidu.sofire;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.f;
import com.baidu.sofire.utility.z;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.DelayTB;
/* loaded from: classes6.dex */
public class MyService extends Service {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static long f45239b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f45240a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(329095265, "Lcom/baidu/sofire/MyService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(329095265, "Lcom/baidu/sofire/MyService;");
        }
    }

    public MyService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45240a = 0;
    }

    public static /* synthetic */ int a(MyService myService) {
        int i2 = myService.f45240a;
        myService.f45240a = i2 + 1;
        return i2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, i2, i3)) == null) {
            try {
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            if (intent == null) {
                return super.onStartCommand(intent, i2, i3);
            }
            Bundle bundleExtra = intent.getBundleExtra("bundle");
            if (bundleExtra != null) {
                String[] stringArray = bundleExtra.getStringArray("appkey");
                int[] intArray = bundleExtra.getIntArray("key");
                int i4 = bundleExtra.getInt(DelayTB.DELAY);
                if (stringArray != null && stringArray.length == 2 && !TextUtils.isEmpty(stringArray[0]) && !TextUtils.isEmpty(stringArray[1])) {
                    com.baidu.sofire.core.d.a(getApplicationContext(), i4, stringArray[0], stringArray[1], intArray);
                    return super.onStartCommand(intent, i2, i3);
                }
            }
            String stringExtra = intent.getStringExtra("from_plugin_package");
            if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(intent.getAction())) {
                a();
            } else {
                long j2 = f45239b;
                if ("teac".equals(intent.getAction())) {
                    f45239b = System.currentTimeMillis();
                    if (System.currentTimeMillis() - j2 < 3000) {
                        return super.onStartCommand(intent, i2, i3);
                    }
                    if (com.baidu.sofire.utility.c.f45531j != 0 && f45239b - com.baidu.sofire.utility.c.f45531j > 5000) {
                        return super.onStartCommand(intent, i2, i3);
                    }
                }
                z.a(getApplicationContext()).a(new Runnable(this, stringExtra, intent) { // from class: com.baidu.sofire.MyService.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f45241a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Intent f45242b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ MyService f45243c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, stringExtra, intent};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i5 = newInitContext.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f45243c = this;
                        this.f45241a = stringExtra;
                        this.f45242b = intent;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                MyService.a(this.f45243c);
                                if (this.f45243c.getPackageName().equals(this.f45241a)) {
                                    MyService.a(this.f45243c, this.f45243c.getClassLoader(), this.f45242b);
                                    this.f45243c.a();
                                } else if ("teac".equals(this.f45242b.getAction())) {
                                    int intExtra = this.f45242b.getIntExtra("plugin_id", 100041);
                                    String stringExtra2 = this.f45242b.getStringExtra("target_method");
                                    if (TextUtils.isEmpty(stringExtra2)) {
                                        this.f45243c.a();
                                        return;
                                    }
                                    com.baidu.sofire.core.d.a(intExtra, stringExtra2, (Callback) null, new Class[]{Intent.class}, this.f45242b);
                                    this.f45243c.a();
                                } else {
                                    f a2 = f.a();
                                    if (a2 == null) {
                                        this.f45243c.a();
                                        return;
                                    }
                                    ApkInfo d2 = a2.d(this.f45241a);
                                    if (d2 == null) {
                                        this.f45243c.a();
                                        return;
                                    }
                                    MyService.a(this.f45243c, d2.classLoader, this.f45242b);
                                    this.f45243c.a();
                                }
                            } catch (Throwable unused2) {
                                com.baidu.sofire.utility.c.a();
                                this.f45243c.a();
                            }
                        }
                    }
                });
            }
            return super.onStartCommand(intent, i2, i3);
        }
        return invokeLII.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                this.f45240a--;
                if (this.f45240a <= 0) {
                    this.f45240a = 0;
                    stopSelf();
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    public static /* synthetic */ void a(MyService myService, ClassLoader classLoader, Intent intent) {
        try {
            Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
            loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), Context.class, Intent.class).invoke(loadClass.newInstance(), myService.getApplicationContext(), intent);
        } catch (Throwable unused) {
        }
    }
}
