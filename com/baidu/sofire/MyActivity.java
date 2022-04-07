package com.baidu.sofire;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.LocalConstant;
import com.baidu.sofire.utility.ThreadPoolManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class MyActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getAwakeSource(Activity activity) {
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
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void performActive(Context context, Intent intent, WeakReference<Activity> weakReference) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, intent, weakReference) == null) {
            ThreadPoolManager.getInstance(context).execute(new Runnable(intent, weakReference, context) { // from class: com.baidu.sofire.MyActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ Intent val$srcIntent;
                public final /* synthetic */ WeakReference val$weakReference;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {intent, weakReference, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$srcIntent = intent;
                    this.val$weakReference = weakReference;
                    this.val$context = context;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            String stringExtra = this.val$srcIntent.getStringExtra("c");
                            Intent intent2 = new Intent();
                            intent2.putExtra("t", "a");
                            intent2.putExtra("c", stringExtra);
                            String awakeSource = MyActivity.getAwakeSource((Activity) this.val$weakReference.get());
                            if (awakeSource == null) {
                                awakeSource = "";
                            }
                            intent2.putExtra("source", awakeSource);
                            AwakeReceiver.onReceiveAwakeMessage(this.val$context.getApplicationContext(), intent2);
                        } catch (Throwable th) {
                            CommonMethods.handleNuLException(th);
                        }
                    }
                }
            });
        }
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
                if (LocalConstant.Ac_Action.equals(intent.getAction())) {
                    Intent intent2 = new Intent(intent);
                    intent2.setAction(LocalConstant.Ac_Action);
                    intent2.setComponent(new ComponentName(getApplicationContext().getPackageName(), MyService.class.getCanonicalName()));
                    startService(intent2);
                }
                if ("a".equals(intent.getStringExtra("t"))) {
                    performActive(getApplicationContext(), intent, new WeakReference(this));
                }
                super.onCreate(bundle);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            finish();
            LogUtil.logActivity(this, "onCreate");
        }
    }
}
