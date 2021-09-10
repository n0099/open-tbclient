package com.baidu.nps.main.manager;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.c.a.f;
import c.a.b0.c.a.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class NPSManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NPS-NPSManager";
    public static NPSManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Bundle> mBundleMap;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43915e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43916f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IInvokeCallback f43917g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43918h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Class f43919i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ NPSManager f43920j;

        public a(NPSManager nPSManager, String str, String str2, IInvokeCallback iInvokeCallback, int i2, Class cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSManager, str, str2, iInvokeCallback, Integer.valueOf(i2), cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43920j = nPSManager;
            this.f43915e = str;
            this.f43916f = str2;
            this.f43917g = iInvokeCallback;
            this.f43918h = i2;
            this.f43919i = cls;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.f43915e) && !TextUtils.isEmpty(this.f43916f)) {
                    int prepareBundle = NPSPackageManager.getInstance().prepareBundle(this.f43915e, this.f43918h);
                    if (prepareBundle != 41) {
                        if (c.a.b0.i.b.a()) {
                            String str = "loadClazz, retCode=" + prepareBundle;
                        }
                        this.f43917g.onResult(prepareBundle, Constant.MSG.retMsgBundleNotReady(prepareBundle), null);
                        return;
                    }
                    NPSPackageManager.getInstance().recordBundleRunning(this.f43915e);
                    Bundle bundleInternal = this.f43920j.getBundleInternal(this.f43915e);
                    if (bundleInternal == null) {
                        c.a.b0.i.b.a();
                        this.f43917g.onResult(5, Constant.MSG.retMsgInvalidPkg(this.f43915e), null);
                        return;
                    }
                    try {
                        Class loadClass = bundleInternal.loadClass(this.f43916f, this.f43919i);
                        f.a().b().recordInvokeResult(14, bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), Constant.MSG.retMsgSuccess());
                        c.a.b0.i.b.a();
                        this.f43917g.onResult(14, Constant.MSG.retMsgSuccess(), loadClass);
                        return;
                    } catch (InvokeException e2) {
                        f.a().b().recordInvokeResult(e2.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e2.errMsg());
                        if (c.a.b0.i.b.a()) {
                            String str2 = "loadClazz, retCode=" + e2.errCode();
                        }
                        this.f43917g.onResult(e2.errCode(), e2.errMsg(), null);
                        return;
                    } catch (InitException e3) {
                        f.a().b().recordInvokeResult(e3.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e3.errMsg());
                        if (c.a.b0.i.b.a()) {
                            String str3 = "loadClazz, retCode=" + e3.errCode();
                        }
                        this.f43917g.onResult(e3.errCode(), e3.errMsg(), null);
                        return;
                    }
                }
                c.a.b0.i.b.a();
                this.f43917g.onResult(5, Constant.MSG.retMsgErrParam(this.f43915e, this.f43916f), null);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) ? NPSPackageManager.getInstance().isBundleRunning(str) : invokeL.booleanValue;
    }

    private Class loadClazzInternal(String str, String str2, Class cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, str, str2, cls)) == null) {
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
            ContextHolder.getApplicationContext().registerReceiver(new b(this), new IntentFilter(c.a.b0.i.a.f1930a));
        }
    }

    private void statisticClassNotFind(String str, InvokeException invokeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, str, invokeException) == null) {
            try {
                f.a().b().recordException(2, invokeException.toString(), str);
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
            } catch (InvokeException e2) {
                if (1 == c.a.b0.e.a.b().a(str)) {
                    statisticClassNotFind(str, e2);
                    cls = ProtectActivity.class;
                } else {
                    throw e2;
                }
            }
            NPSPackageManager.getInstance().recordBundleRunning(packageNameFromComponent);
            return cls;
        }
        return (Class) invokeL.objValue;
    }

    public void loadClazz(String str, String str2, Class cls, int i2, IInvokeCallback iInvokeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, cls, Integer.valueOf(i2), iInvokeCallback}) == null) {
            g.a().b().run(new a(this, str, str2, iInvokeCallback, i2, cls));
        }
    }

    public synchronized void init(Context context, Configurations configurations, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, context, configurations, z) == null) {
            synchronized (this) {
                c.a.b0.i.b.b(configurations.debug);
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
                    f.a().b().recordInvokeResult(14, bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), Constant.MSG.retMsgSuccess());
                    loadResult.setRet(14, Constant.MSG.retMsgSuccess(), loadClass);
                    return loadResult;
                } catch (InvokeException e2) {
                    f.a().b().recordInvokeResult(e2.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e2.errMsg());
                    loadResult.setRet(e2.errCode(), e2.errMsg(), null);
                    return loadResult;
                } catch (InitException e3) {
                    f.a().b().recordInvokeResult(e3.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e3.errMsg());
                    loadResult.setRet(e3.errCode(), e3.errMsg(), null);
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
                        f.a().b().recordInvokeResult(14, bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), Constant.MSG.retMsgSuccess());
                        iInvokeCallback.onResult(14, Constant.MSG.retMsgSuccess(), invoke);
                        return;
                    } catch (InvokeException e2) {
                        f.a().b().recordInvokeResult(e2.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e2.errMsg());
                        iInvokeCallback.onResult(e2.errCode(), e2.errMsg(), null);
                        return;
                    } catch (InitException e3) {
                        f.a().b().recordInvokeResult(e3.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e3.errMsg());
                        iInvokeCallback.onResult(e3.errCode(), e3.errMsg(), null);
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
