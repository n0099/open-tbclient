package com.baidu.nps.main.manager;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.hook.component.ProtectActivity;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.invoke.InvokeException;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.nps.runtime.InitException;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d71;
import com.repackage.e71;
import com.repackage.n61;
import com.repackage.o61;
import com.repackage.r61;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class NPSManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NPS-NPSManager";
    public static NPSManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Bundle> mBundleMap;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ IInvokeCallback c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Class e;
        public final /* synthetic */ NPSManager f;

        public a(NPSManager nPSManager, String str, String str2, IInvokeCallback iInvokeCallback, int i, Class cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSManager, str, str2, iInvokeCallback, Integer.valueOf(i), cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = nPSManager;
            this.a = str;
            this.b = str2;
            this.c = iInvokeCallback;
            this.d = i;
            this.e = cls;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
                    int prepareBundle = NPSPackageManager.getInstance().prepareBundle(this.a, this.d);
                    if (prepareBundle != 41) {
                        if (e71.a()) {
                            Log.i(NPSManager.TAG, "loadClazz, retCode=" + prepareBundle);
                        }
                        this.c.onResult(prepareBundle, Constant.MSG.retMsgBundleNotReady(prepareBundle), null);
                        return;
                    }
                    NPSPackageManager.getInstance().recordBundleRunning(this.a);
                    Bundle bundleInternal = this.f.getBundleInternal(this.a);
                    if (bundleInternal == null) {
                        if (e71.a()) {
                            Log.i(NPSManager.TAG, "loadClazz, retCode=5");
                        }
                        this.c.onResult(5, Constant.MSG.retMsgInvalidPkg(this.a), null);
                        return;
                    }
                    try {
                        Class loadClass = bundleInternal.loadClass(this.b, this.e);
                        n61.a().b().recordInvokeResult(14, bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), Constant.MSG.retMsgSuccess());
                        if (e71.a()) {
                            Log.i(NPSManager.TAG, "loadClazz, retCode=14");
                        }
                        this.c.onResult(14, Constant.MSG.retMsgSuccess(), loadClass);
                        return;
                    } catch (InvokeException e) {
                        n61.a().b().recordInvokeResult(e.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e.errMsg());
                        if (e71.a()) {
                            Log.i(NPSManager.TAG, "loadClazz, retCode=" + e.errCode());
                        }
                        this.c.onResult(e.errCode(), e.errMsg(), null);
                        return;
                    } catch (InitException e2) {
                        n61.a().b().recordInvokeResult(e2.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e2.errMsg());
                        if (e71.a()) {
                            Log.i(NPSManager.TAG, "loadClazz, retCode=" + e2.errCode());
                        }
                        this.c.onResult(e2.errCode(), e2.errMsg(), null);
                        return;
                    }
                }
                if (e71.a()) {
                    Log.i(NPSManager.TAG, "loadClazz, retCode=5");
                }
                this.c.onResult(5, Constant.MSG.retMsgErrParam(this.a, this.b), null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NPSManager this$0;

        public b(NPSManager nPSManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = nPSManager;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                System.exit(0);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1196011219, "Lcom/baidu/nps/main/manager/NPSManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1196011219, "Lcom/baidu/nps/main/manager/NPSManager;");
                return;
            }
        }
        sInstance = new NPSManager();
    }

    public NPSManager() {
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
        this.mBundleMap = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Bundle getBundleInternal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            synchronized (this) {
                Bundle bundle = this.mBundleMap.get(str);
                if (bundle != null) {
                    return bundle;
                }
                BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo(str);
                if (bundleInfo == null) {
                    return null;
                }
                Bundle bundle2 = new Bundle(bundleInfo);
                this.mBundleMap.put(str, bundle2);
                return bundle2;
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static NPSManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? sInstance : (NPSManager) invokeV.objValue;
    }

    private boolean isBundleRunning(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) ? NPSPackageManager.getInstance().isBundleRunning(str) : invokeL.booleanValue;
    }

    private Class loadClazzInternal(String str, String str2, Class cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, this, str, str2, cls)) == null) {
            Bundle bundleInternal = getBundleInternal(str);
            if (bundleInternal == null) {
                return null;
            }
            return bundleInternal.loadClass(str2, cls);
        }
        return (Class) invokeLLL.objValue;
    }

    private void registerRestartReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            ContextHolder.getApplicationContext().registerReceiver(new b(this), new IntentFilter(d71.a));
        }
    }

    private void statisticClassNotFind(String str, InvokeException invokeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, str, invokeException) == null) {
            try {
                n61.a().b().recordException(2, invokeException.toString(), str);
            } catch (Exception unused) {
            }
        }
    }

    public Bundle getBundle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? getBundleInternal(str) : (Bundle) invokeL.objValue;
    }

    public synchronized void init(Context context, Configurations configurations) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, configurations) == null) {
            synchronized (this) {
                init(context, configurations, true);
            }
        }
    }

    public Activity instantiateActivity(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Class loadComponentClass = loadComponentClass(str);
            if (loadComponentClass == null) {
                return null;
            }
            try {
                return (Activity) loadComponentClass.newInstance();
            } catch (Exception unused) {
                return null;
            }
        }
        return (Activity) invokeL.objValue;
    }

    public ContentProvider instantiateProvider(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            Class loadClazzInternal = loadClazzInternal(str, str2, ContentProvider.class);
            if (loadClazzInternal == null) {
                return null;
            }
            try {
                return (ContentProvider) loadClazzInternal.newInstance();
            } catch (Exception unused) {
                return null;
            }
        }
        return (ContentProvider) invokeLL.objValue;
    }

    public BroadcastReceiver instantiateReceiver(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Class loadComponentClass = loadComponentClass(str);
            if (loadComponentClass == null) {
                return null;
            }
            try {
                return (BroadcastReceiver) loadComponentClass.newInstance();
            } catch (Exception unused) {
                return null;
            }
        }
        return (BroadcastReceiver) invokeL.objValue;
    }

    public Service instantiateService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            Class loadComponentClass = loadComponentClass(str);
            if (loadComponentClass == null) {
                return null;
            }
            try {
                return (Service) loadComponentClass.newInstance();
            } catch (Exception unused) {
                return null;
            }
        }
        return (Service) invokeL.objValue;
    }

    @Deprecated
    public Object invoke(String str, String str2, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, str, str2, objArr)) == null) {
            int prepareBundle = NPSPackageManager.getInstance().prepareBundle(str);
            if (prepareBundle == 41) {
                NPSPackageManager.getInstance().recordBundleRunning(str);
                Bundle bundleInternal = getBundleInternal(str);
                if (bundleInternal == null) {
                    return null;
                }
                return bundleInternal.invoke(str2, objArr);
            }
            throw new RuntimeException("invoke error retcode=" + prepareBundle);
        }
        return invokeLLL.objValue;
    }

    public void loadClazz(String str, String str2, Class cls, IInvokeCallback iInvokeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, str, str2, cls, iInvokeCallback) == null) {
            loadClazz(str, str2, cls, 0, iInvokeCallback);
        }
    }

    public Class loadComponentClass(String str) {
        InterceptResult invokeL;
        Bundle bundleInternal;
        Class cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            String packageNameFromComponent = NPSPackageManager.getInstance().getPackageNameFromComponent(str);
            if (TextUtils.isEmpty(packageNameFromComponent) || (bundleInternal = getBundleInternal(packageNameFromComponent)) == null) {
                return null;
            }
            try {
                cls = bundleInternal.loadClass(str);
            } catch (InvokeException e) {
                if (1 == r61.b().a(str)) {
                    statisticClassNotFind(str, e);
                    cls = ProtectActivity.class;
                } else {
                    throw e;
                }
            }
            NPSPackageManager.getInstance().recordBundleRunning(packageNameFromComponent);
            return cls;
        }
        return (Class) invokeL.objValue;
    }

    public void loadClazz(String str, String str2, Class cls, int i, IInvokeCallback iInvokeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, cls, Integer.valueOf(i), iInvokeCallback}) == null) {
            o61.a().b().run(new a(this, str, str2, iInvokeCallback, i, cls));
        }
    }

    public synchronized void init(Context context, Configurations configurations, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, context, configurations, z) == null) {
            synchronized (this) {
                e71.b(configurations.debug);
                registerRestartReceiver();
                if (z) {
                    NPSPackageManager.getInstance().init();
                }
            }
        }
    }

    public LoadResult loadClazz(String str, String str2, Class cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, str, str2, cls)) == null) {
            LoadResult loadResult = new LoadResult();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                int prepareBundle = NPSPackageManager.getInstance().prepareBundle(str);
                if (prepareBundle != 41) {
                    loadResult.setRet(prepareBundle, Constant.MSG.retMsgBundleNotReady(prepareBundle), null);
                    return loadResult;
                }
                NPSPackageManager.getInstance().recordBundleRunning(str);
                Bundle bundleInternal = getBundleInternal(str);
                if (bundleInternal == null) {
                    loadResult.setRet(5, Constant.MSG.retMsgInvalidPkg(str), null);
                    return loadResult;
                }
                try {
                    Class loadClass = bundleInternal.loadClass(str2, cls);
                    n61.a().b().recordInvokeResult(14, bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), Constant.MSG.retMsgSuccess());
                    loadResult.setRet(14, Constant.MSG.retMsgSuccess(), loadClass);
                    return loadResult;
                } catch (InvokeException e) {
                    n61.a().b().recordInvokeResult(e.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e.errMsg());
                    loadResult.setRet(e.errCode(), e.errMsg(), null);
                    return loadResult;
                } catch (InitException e2) {
                    n61.a().b().recordInvokeResult(e2.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e2.errMsg());
                    loadResult.setRet(e2.errCode(), e2.errMsg(), null);
                    return loadResult;
                }
            }
            loadResult.setRet(5, Constant.MSG.retMsgErrParam(str, str2), null);
            return loadResult;
        }
        return (LoadResult) invokeLLL.objValue;
    }

    public void invoke(String str, String str2, IInvokeCallback iInvokeCallback, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, iInvokeCallback, objArr) == null) {
            if (iInvokeCallback != null) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    int prepareBundle = NPSPackageManager.getInstance().prepareBundle(str);
                    if (prepareBundle != 41) {
                        iInvokeCallback.onResult(prepareBundle, Constant.MSG.retMsgBundleNotReady(prepareBundle), null);
                        return;
                    }
                    NPSPackageManager.getInstance().recordBundleRunning(str);
                    Bundle bundleInternal = getBundleInternal(str);
                    if (bundleInternal == null) {
                        iInvokeCallback.onResult(5, Constant.MSG.retMsgInvalidPkg(str), null);
                        return;
                    }
                    try {
                        Object invoke = bundleInternal.invoke(str2, objArr);
                        n61.a().b().recordInvokeResult(14, bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), Constant.MSG.retMsgSuccess());
                        iInvokeCallback.onResult(14, Constant.MSG.retMsgSuccess(), invoke);
                        return;
                    } catch (InvokeException e) {
                        n61.a().b().recordInvokeResult(e.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e.errMsg());
                        iInvokeCallback.onResult(e.errCode(), e.errMsg(), null);
                        return;
                    } catch (InitException e2) {
                        n61.a().b().recordInvokeResult(e2.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e2.errMsg());
                        iInvokeCallback.onResult(e2.errCode(), e2.errMsg(), null);
                        return;
                    }
                }
                iInvokeCallback.onResult(5, Constant.MSG.retMsgErrParam(str, str2), null);
                return;
            }
            throw new IllegalArgumentException("param callback should not be null!");
        }
    }
}
