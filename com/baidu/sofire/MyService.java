package com.baidu.sofire;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.MethodImpl;
import com.baidu.sofire.core.PluginloaderHub;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.LocalConstant;
import com.baidu.sofire.utility.ThreadPoolManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.DelayTB;
/* loaded from: classes2.dex */
public class MyService extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFULT_KEEPLIVE_PLUGIN_ID = 100041;
    public static long sLASTGETT;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int mThreadCount;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mThreadCount = 0;
    }

    public static /* synthetic */ int access$008(MyService myService) {
        int i = myService.mThreadCount;
        myService.mThreadCount = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callDistinction(ClassLoader classLoader, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, classLoader, intent) == null) {
            try {
                Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
                loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), Context.class, Intent.class).invoke(loadClass.newInstance(), getApplicationContext(), intent);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            try {
                this.mThreadCount--;
                if (this.mThreadCount <= 0) {
                    this.mThreadCount = 0;
                    stopSelf();
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
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
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, i, i2)) == null) {
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
                        MethodImpl.initDelay(getApplicationContext(), i4, stringArray[0], stringArray[1], i3);
                        return 2;
                    }
                }
                String stringExtra = intent.getStringExtra("from_plugin_package");
                if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(intent.getAction())) {
                    doEnd();
                } else {
                    long j = sLASTGETT;
                    if (LocalConstant.Ac_Action.equals(intent.getAction())) {
                        sLASTGETT = System.currentTimeMillis();
                        if (System.currentTimeMillis() - j < 3000) {
                            return 2;
                        }
                        if (CommonMethods.sSdkInitTimeStamp != 0 && sLASTGETT - CommonMethods.sSdkInitTimeStamp > 5000) {
                            return 2;
                        }
                    }
                    ThreadPoolManager.getInstance(getApplicationContext()).execute(new Runnable(this, stringExtra, intent) { // from class: com.baidu.sofire.MyService.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MyService this$0;
                        public final /* synthetic */ String val$fromPluginPackage;
                        public final /* synthetic */ Intent val$intent;

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
                            this.this$0 = this;
                            this.val$fromPluginPackage = stringExtra;
                            this.val$intent = intent;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    MyService.access$008(this.this$0);
                                    if (this.this$0.getPackageName().equals(this.val$fromPluginPackage)) {
                                        this.this$0.callDistinction(this.this$0.getClassLoader(), this.val$intent);
                                        this.this$0.doEnd();
                                    } else if (LocalConstant.Ac_Action.equals(this.val$intent.getAction())) {
                                        int intExtra = this.val$intent.getIntExtra("plugin_id", MyService.DEFULT_KEEPLIVE_PLUGIN_ID);
                                        String stringExtra2 = this.val$intent.getStringExtra("target_method");
                                        if (TextUtils.isEmpty(stringExtra2)) {
                                            this.this$0.doEnd();
                                            return;
                                        }
                                        MethodImpl.call(intExtra, stringExtra2, null, new Class[]{Intent.class}, this.val$intent);
                                        this.this$0.doEnd();
                                    } else {
                                        PluginloaderHub peekInstance = PluginloaderHub.peekInstance();
                                        if (peekInstance == null) {
                                            this.this$0.doEnd();
                                            return;
                                        }
                                        ApkInfo apkInfoByPackageName = peekInstance.getApkInfoByPackageName(this.val$fromPluginPackage);
                                        if (apkInfoByPackageName == null) {
                                            this.this$0.doEnd();
                                            return;
                                        }
                                        this.this$0.callDistinction(apkInfoByPackageName.classLoader, this.val$intent);
                                        this.this$0.doEnd();
                                    }
                                } catch (Throwable th) {
                                    CommonMethods.handleNuLException(th);
                                    this.this$0.doEnd();
                                }
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return 2;
        }
        return invokeLII.intValue;
    }
}
