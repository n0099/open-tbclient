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
import com.baidu.nps.pm.BundleConfig;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.nps.runtime.InitException;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.tieba.ae1;
import com.baidu.tieba.be1;
import com.baidu.tieba.gd1;
import com.baidu.tieba.hd1;
import com.baidu.tieba.kd1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
        public final /* synthetic */ IInvokeCallback b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ BundleConfig f;
        public final /* synthetic */ Class g;
        public final /* synthetic */ NPSManager h;

        public a(NPSManager nPSManager, String str, IInvokeCallback iInvokeCallback, String str2, int i, boolean z, BundleConfig bundleConfig, Class cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSManager, str, iInvokeCallback, str2, Integer.valueOf(i), Boolean.valueOf(z), bundleConfig, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = nPSManager;
            this.a = str;
            this.b = iInvokeCallback;
            this.c = str2;
            this.d = i;
            this.e = z;
            this.f = bundleConfig;
            this.g = cls;
        }

        @Override // java.lang.Runnable
        public void run() {
            Class loadClass;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.isEmpty(this.a)) {
                    if (be1.a()) {
                        Log.i(NPSManager.TAG, "loadBundle, retCode=5");
                    }
                    this.b.onResult(5, Constant.MSG.retMsgErrParam(this.a, this.c), null);
                    return;
                }
                int prepareBundle = NPSPackageManager.getInstance().prepareBundle(this.a, this.d, this.e, this.f);
                if (prepareBundle != 41) {
                    if (be1.a()) {
                        Log.i(NPSManager.TAG, "loadBundle, retCode=" + prepareBundle);
                    }
                    this.b.onResult(prepareBundle, Constant.MSG.retMsgBundleNotReady(prepareBundle), null);
                    return;
                }
                NPSPackageManager.getInstance().recordBundleRunning(this.a);
                Bundle bundleInternal = this.h.getBundleInternal(this.a);
                if (bundleInternal == null) {
                    if (be1.a()) {
                        Log.i(NPSManager.TAG, "loadBundle, retCode=5");
                    }
                    this.b.onResult(5, Constant.MSG.retMsgInvalidPkg(this.a), null);
                    return;
                }
                try {
                    if (TextUtils.isEmpty(this.c)) {
                        bundleInternal.loadOnly();
                        loadClass = null;
                    } else {
                        loadClass = bundleInternal.loadClass(this.c, this.g);
                    }
                    gd1.a().b().recordInvokeResult(14, bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), Constant.MSG.retMsgSuccess(), null);
                    if (be1.a()) {
                        Log.i(NPSManager.TAG, "loadBundle, retCode=14");
                    }
                    this.b.onResult(14, Constant.MSG.retMsgSuccess(), loadClass);
                } catch (InvokeException e) {
                    gd1.a().b().recordInvokeResult(e.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e.errMsg(), null);
                    if (be1.a()) {
                        Log.i(NPSManager.TAG, "loadBundle, retCode=" + e.errCode());
                    }
                    this.b.onResult(e.errCode(), e.errMsg(), null);
                } catch (InitException e2) {
                    gd1.a().b().recordInvokeResult(e2.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e2.errMsg(), null);
                    if (be1.a()) {
                        Log.i(NPSManager.TAG, "loadBundle, retCode=" + e2.errCode());
                    }
                    this.b.onResult(e2.errCode(), e2.errMsg(), null);
                }
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

    public static NPSManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return sInstance;
        }
        return (NPSManager) invokeV.objValue;
    }

    private void registerRestartReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            ContextHolder.getApplicationContext().registerReceiver(new b(this), new IntentFilter(ae1.a));
        }
    }

    private void statisticClassNotFind(String str, InvokeException invokeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, str, invokeException) == null) {
            try {
                gd1.a().b().recordException(2, invokeException.toString(), str);
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void init(Context context, Configurations configurations) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, configurations) == null) {
            synchronized (this) {
                init(context, configurations, true);
            }
        }
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

    public void loadBundleOnly(String str, IInvokeCallback iInvokeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, iInvokeCallback) == null) {
            loadBundleOnly(str, 0, iInvokeCallback);
        }
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

    private boolean isBundleRunning(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            return NPSPackageManager.getInstance().isBundleRunning(str);
        }
        return invokeL.booleanValue;
    }

    public Bundle getBundle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return getBundleInternal(str);
        }
        return (Bundle) invokeL.objValue;
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

    private void loadBundle(String str, String str2, Class cls, int i, IInvokeCallback iInvokeCallback, boolean z, BundleConfig bundleConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{str, str2, cls, Integer.valueOf(i), iInvokeCallback, Boolean.valueOf(z), bundleConfig}) == null) {
            hd1.a().b().run(new a(this, str, iInvokeCallback, str2, i, z, bundleConfig, cls));
        }
    }

    public void loadClazz(String str, String str2, Class cls, int i, IInvokeCallback iInvokeCallback, boolean z, BundleConfig bundleConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, str2, cls, Integer.valueOf(i), iInvokeCallback, Boolean.valueOf(z), bundleConfig}) == null) {
            if (TextUtils.isEmpty(str2)) {
                if (be1.a()) {
                    Log.i(TAG, "loadClazz, retCode=5");
                }
                iInvokeCallback.onResult(5, Constant.MSG.retMsgErrParam(str, str2), null);
                return;
            }
            loadBundle(str, str2, cls, i, iInvokeCallback, z, bundleConfig);
        }
    }

    private Class loadClazzInternal(String str, String str2, Class cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, this, str, str2, cls)) == null) {
            Bundle bundleInternal = getBundleInternal(str);
            if (bundleInternal == null) {
                return null;
            }
            return bundleInternal.loadClass(str2, cls);
        }
        return (Class) invokeLLL.objValue;
    }

    public synchronized void init(Context context, Configurations configurations, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, context, configurations, z) == null) {
            synchronized (this) {
                be1.b(configurations.debug);
                registerRestartReceiver();
                if (z) {
                    NPSPackageManager.getInstance().init();
                }
            }
        }
    }

    public void loadBundleOnly(String str, int i, IInvokeCallback iInvokeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, str, i, iInvokeCallback) == null) {
            loadBundle(str, null, null, i, iInvokeCallback, false, null);
        }
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
                        gd1.a().b().recordInvokeResult(14, bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), Constant.MSG.retMsgSuccess(), null);
                        iInvokeCallback.onResult(14, Constant.MSG.retMsgSuccess(), invoke);
                        return;
                    } catch (InvokeException e) {
                        gd1.a().b().recordInvokeResult(e.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e.errMsg(), null);
                        iInvokeCallback.onResult(e.errCode(), e.errMsg(), null);
                        return;
                    } catch (InitException e2) {
                        gd1.a().b().recordInvokeResult(e2.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e2.errMsg(), null);
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

    public void loadBundleOnly(String str, int i, IInvokeCallback iInvokeCallback, boolean z, BundleConfig bundleConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i), iInvokeCallback, Boolean.valueOf(z), bundleConfig}) == null) {
            loadBundle(str, null, null, i, iInvokeCallback, z, bundleConfig);
        }
    }

    public void loadClazz(String str, String str2, Class cls, int i, IInvokeCallback iInvokeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, cls, Integer.valueOf(i), iInvokeCallback}) == null) {
            loadClazz(str, str2, cls, i, iInvokeCallback, false, null);
        }
    }

    public LoadResult loadClazz(String str, String str2, Class cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, str, str2, cls)) == null) {
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
                    gd1.a().b().recordInvokeResult(14, bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), Constant.MSG.retMsgSuccess(), null);
                    loadResult.setRet(14, Constant.MSG.retMsgSuccess(), loadClass);
                    return loadResult;
                } catch (InvokeException e) {
                    gd1.a().b().recordInvokeResult(e.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e.errMsg(), null);
                    loadResult.setRet(e.errCode(), e.errMsg(), null);
                    return loadResult;
                } catch (InitException e2) {
                    gd1.a().b().recordInvokeResult(e2.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e2.errMsg(), null);
                    loadResult.setRet(e2.errCode(), e2.errMsg(), null);
                    return loadResult;
                }
            }
            loadResult.setRet(5, Constant.MSG.retMsgErrParam(str, str2), null);
            return loadResult;
        }
        return (LoadResult) invokeLLL.objValue;
    }

    public void loadClazz(String str, String str2, Class cls, IInvokeCallback iInvokeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048591, this, str, str2, cls, iInvokeCallback) == null) {
            loadClazz(str, str2, cls, 0, iInvokeCallback, false, null);
        }
    }

    public Class loadComponentClass(String str) {
        InterceptResult invokeL;
        Bundle bundleInternal;
        Class cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            String packageNameFromComponent = NPSPackageManager.getInstance().getPackageNameFromComponent(str);
            if (TextUtils.isEmpty(packageNameFromComponent) || (bundleInternal = getBundleInternal(packageNameFromComponent)) == null) {
                return null;
            }
            try {
                cls = bundleInternal.loadClass(str);
            } catch (InvokeException e) {
                if (1 == kd1.b().a(str)) {
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
}
