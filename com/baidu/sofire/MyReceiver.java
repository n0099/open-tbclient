package com.baidu.sofire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.f;
import com.baidu.sofire.core.g;
import com.baidu.sofire.utility.x;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class MyReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Callback f10226a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10227b;

    /* renamed from: c  reason: collision with root package name */
    public long f10228c;

    /* renamed from: d  reason: collision with root package name */
    public long f10229d;

    public MyReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10226a = new Callback(this) { // from class: com.baidu.sofire.MyReceiver.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ MyReceiver f10230a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f10230a = this;
            }

            @Override // com.baidu.sofire.ac.Callback
            public final Object onEnd(Object... objArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, objArr)) == null) ? super.onEnd(objArr) : invokeL.objValue;
            }
        };
        this.f10227b = false;
        this.f10228c = 0L;
        this.f10229d = 0L;
    }

    public final MyReceiver a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                this.f10228c = System.currentTimeMillis();
                this.f10227b = true;
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            return this;
        }
        return (MyReceiver) invokeV.objValue;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, intent) == null) || intent == null) {
            return;
        }
        try {
            if (!this.f10227b || System.currentTimeMillis() - this.f10228c >= 2000) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    if (System.currentTimeMillis() - this.f10229d < 100 || !com.baidu.sofire.utility.c.f(context)) {
                        return;
                    }
                    this.f10229d = System.currentTimeMillis();
                }
                Context applicationContext = context.getApplicationContext();
                x.a(applicationContext).a(new Runnable(intent, applicationContext, this.f10227b) { // from class: com.baidu.sofire.MyReceiver.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Intent f10231a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Context f10232b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ boolean f10233c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {intent, applicationContext, Boolean.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f10231a = intent;
                        this.f10232b = applicationContext;
                        this.f10233c = r8;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean z;
                        ApkInfo d2;
                        List<ApkInfo> b2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (r.f7745a.equals(this.f10231a.getStringExtra("t"))) {
                                    String stringExtra = this.f10231a.getStringExtra("c");
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("t", r.f7745a);
                                    intent2.putExtra("c", stringExtra);
                                    a.a(this.f10232b, intent2);
                                }
                                String action = this.f10231a.getAction();
                                if (this.f10233c && "android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.utility.c.f(this.f10232b) && U.sMonitorNetworkWhenUpgradeNoNet) {
                                    x.a(this.f10232b).b(new U(this.f10232b.getApplicationContext(), 3, false));
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (this.f10233c && "android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.sofire.utility.c.f10471a && !z && com.baidu.sofire.utility.c.e(this.f10232b)) {
                                    x.a(this.f10232b).b(new U(this.f10232b.getApplicationContext(), 3, false));
                                }
                                if (this.f10233c) {
                                    return;
                                }
                                String stringExtra2 = this.f10231a.getStringExtra("from_plugin_package");
                                if (TextUtils.isEmpty(stringExtra2)) {
                                    f a2 = f.a();
                                    if (a2 == null || (b2 = a2.b()) == null) {
                                        return;
                                    }
                                    for (int i2 = 0; i2 < b2.size(); i2++) {
                                        ApkInfo apkInfo = b2.get(i2);
                                        if (apkInfo.intentFilters != null) {
                                            for (int i3 = 0; i3 < apkInfo.intentFilters.size(); i3++) {
                                                g gVar = apkInfo.intentFilters.get(i3);
                                                if (gVar.f10359d.match(this.f10231a.getAction(), this.f10231a.getType(), this.f10231a.getScheme(), this.f10231a.getData(), this.f10231a.getCategories(), "PIF") >= 0) {
                                                    Class<?> loadClass = apkInfo.classLoader.loadClass(gVar.f10357b);
                                                    loadClass.getDeclaredMethod(gVar.f10358c, Context.class, Intent.class).invoke(loadClass.newInstance(), this.f10232b.getApplicationContext(), this.f10231a);
                                                }
                                            }
                                        }
                                    }
                                } else if (this.f10232b.getPackageName().equals(stringExtra2)) {
                                    MyReceiver.a(this.f10232b.getClassLoader(), this.f10231a, this.f10232b);
                                } else {
                                    f a3 = f.a();
                                    if (a3 == null || (d2 = a3.d(stringExtra2)) == null) {
                                        return;
                                    }
                                    MyReceiver.a(d2.classLoader, this.f10231a, this.f10232b);
                                }
                            } catch (Throwable unused) {
                                com.baidu.sofire.utility.c.a();
                            }
                        }
                    }
                });
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    public static /* synthetic */ void a(ClassLoader classLoader, Intent intent, Context context) {
        try {
            Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
            loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
        } catch (Throwable unused) {
        }
    }
}
