package com.baidu.sofire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.PluginloaderHub;
import com.baidu.sofire.core.PluginloaderIntentFilter;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.ThreadPoolManager;
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
    public Callback initCallback;
    public boolean mIsOnlyNetSelf;
    public long mLastDoNetChangeTime;
    public long mSetNetOnlyTime;

    public MyReceiver() {
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
        this.initCallback = new Callback(this) { // from class: com.baidu.sofire.MyReceiver.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MyReceiver this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.sofire.ac.Callback
            public Object onEnd(Object... objArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, objArr)) == null) ? super.onEnd(objArr) : invokeL.objValue;
            }
        };
        this.mIsOnlyNetSelf = false;
        this.mSetNetOnlyTime = 0L;
        this.mLastDoNetChangeTime = 0L;
    }

    public static void callDistinction(ClassLoader classLoader, Intent intent, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, classLoader, intent, context) == null) {
            try {
                Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
                loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
            } catch (Throwable unused) {
            }
        }
    }

    public static void callanddoAction(Context context, Intent intent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, context, intent, z) == null) {
            ThreadPoolManager.getInstance(context).execute(new Runnable(intent, context, z) { // from class: com.baidu.sofire.MyReceiver.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ Intent val$intent;
                public final /* synthetic */ boolean val$isOnlyNetSelf;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {intent, context, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$intent = intent;
                    this.val$context = context;
                    this.val$isOnlyNetSelf = z;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    boolean z2;
                    ApkInfo apkInfoByPackageName;
                    List<ApkInfo> allLoadedPlugins;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if ("r".equals(this.val$intent.getStringExtra("t"))) {
                                String stringExtra = this.val$intent.getStringExtra("c");
                                Intent intent2 = new Intent();
                                intent2.putExtra("t", "r");
                                intent2.putExtra("c", stringExtra);
                                AwakeReceiver.onReceiveAwakeMessage(this.val$context, intent2);
                            }
                            String action = this.val$intent.getAction();
                            if (this.val$isOnlyNetSelf && "android.net.conn.CONNECTIVITY_CHANGE".equals(action) && CommonMethods.isNetworkAvailable(this.val$context) && U.sMonitorNetworkWhenUpgradeNoNet) {
                                ThreadPoolManager.getInstance(this.val$context).executeCore(new U(this.val$context.getApplicationContext(), 3, false));
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (this.val$isOnlyNetSelf && "android.net.conn.CONNECTIVITY_CHANGE".equals(action) && CommonMethods.sNeedCheckConnectivity && !z2 && CommonMethods.isWifiAvailable(this.val$context)) {
                                ThreadPoolManager.getInstance(this.val$context).executeCore(new U(this.val$context.getApplicationContext(), 3, false));
                            }
                            if (this.val$isOnlyNetSelf) {
                                return;
                            }
                            String stringExtra2 = this.val$intent.getStringExtra("from_plugin_package");
                            if (TextUtils.isEmpty(stringExtra2)) {
                                PluginloaderHub peekInstance = PluginloaderHub.peekInstance();
                                if (peekInstance == null || (allLoadedPlugins = peekInstance.getAllLoadedPlugins()) == null) {
                                    return;
                                }
                                for (int i = 0; i < allLoadedPlugins.size(); i++) {
                                    ApkInfo apkInfo = allLoadedPlugins.get(i);
                                    if (apkInfo.intentFilters != null) {
                                        for (int i2 = 0; i2 < apkInfo.intentFilters.size(); i2++) {
                                            PluginloaderIntentFilter pluginloaderIntentFilter = apkInfo.intentFilters.get(i2);
                                            if (pluginloaderIntentFilter.intentFilter.match(this.val$intent.getAction(), this.val$intent.getType(), this.val$intent.getScheme(), this.val$intent.getData(), this.val$intent.getCategories(), "PIF") >= 0) {
                                                Class<?> loadClass = apkInfo.classLoader.loadClass(pluginloaderIntentFilter.targetClass);
                                                loadClass.getDeclaredMethod(pluginloaderIntentFilter.targetMethod, Context.class, Intent.class).invoke(loadClass.newInstance(), this.val$context.getApplicationContext(), this.val$intent);
                                            }
                                        }
                                    }
                                }
                            } else if (this.val$context.getPackageName().equals(stringExtra2)) {
                                MyReceiver.callDistinction(this.val$context.getClassLoader(), this.val$intent, this.val$context);
                            } else {
                                PluginloaderHub peekInstance2 = PluginloaderHub.peekInstance();
                                if (peekInstance2 == null || (apkInfoByPackageName = peekInstance2.getApkInfoByPackageName(stringExtra2)) == null) {
                                    return;
                                }
                                MyReceiver.callDistinction(apkInfoByPackageName.classLoader, this.val$intent, this.val$context);
                            }
                        } catch (Throwable th) {
                            CommonMethods.handleNuLException(th);
                        }
                    }
                }
            });
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
            return;
        }
        try {
            if (!this.mIsOnlyNetSelf || System.currentTimeMillis() - this.mSetNetOnlyTime >= 2000) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    if (System.currentTimeMillis() - this.mLastDoNetChangeTime < 100 || !CommonMethods.isNetworkAvailable(context)) {
                        return;
                    }
                    this.mLastDoNetChangeTime = System.currentTimeMillis();
                }
                callanddoAction(context.getApplicationContext(), intent, this.mIsOnlyNetSelf);
            }
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
    }

    public MyReceiver setOnlyNetSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                this.mSetNetOnlyTime = System.currentTimeMillis();
                this.mIsOnlyNetSelf = true;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return this;
        }
        return (MyReceiver) invokeV.objValue;
    }
}
