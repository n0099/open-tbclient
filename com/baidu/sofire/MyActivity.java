package com.baidu.sofire;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.x;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class MyActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            if (activity == null) {
                return "";
            }
            try {
                Method method = Class.forName("android.app.Activity").getMethod("getActivityToken", new Class[0]);
                method.setAccessible(true);
                Object invoke = method.invoke(activity, new Object[0]);
                Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                Method method2 = cls.getMethod("getDefault", new Class[0]);
                method2.setAccessible(true);
                Object invoke2 = method2.invoke(cls, new Object[0]);
                Method method3 = invoke2.getClass().getMethod("getLaunchedFromUid", IBinder.class);
                method3.setAccessible(true);
                return activity.getPackageManager().getNameForUid(((Integer) method3.invoke(invoke2, invoke)).intValue());
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            super.attachBaseContext(context);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            try {
                Intent intent = getIntent();
                if ("teac".equals(intent.getAction())) {
                    Intent intent2 = new Intent(intent);
                    intent2.setAction("teac");
                    intent2.setComponent(new ComponentName(getApplicationContext().getPackageName(), MyService.class.getCanonicalName()));
                    startService(intent2);
                }
                if ("a".equals(intent.getStringExtra("t"))) {
                    WeakReference weakReference = new WeakReference(this);
                    Context applicationContext = getApplicationContext();
                    x.a(applicationContext).a(new Runnable(intent, weakReference, applicationContext) { // from class: com.baidu.sofire.MyActivity.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Intent f45050a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ WeakReference f45051b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ Context f45052c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {intent, weakReference, applicationContext};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f45050a = intent;
                            this.f45051b = weakReference;
                            this.f45052c = applicationContext;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    String stringExtra = this.f45050a.getStringExtra("c");
                                    Intent intent3 = new Intent();
                                    intent3.putExtra("t", "a");
                                    intent3.putExtra("c", stringExtra);
                                    String a2 = MyActivity.a((Activity) this.f45051b.get());
                                    if (a2 == null) {
                                        a2 = "";
                                    }
                                    intent3.putExtra("source", a2);
                                    a.a(this.f45052c.getApplicationContext(), intent3);
                                } catch (Throwable unused) {
                                    com.baidu.sofire.utility.c.a();
                                }
                            }
                        }
                    });
                }
                super.onCreate(bundle);
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            finish();
        }
    }
}
