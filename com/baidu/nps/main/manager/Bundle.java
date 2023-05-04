package com.baidu.nps.main.manager;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.invoke.IInvoker;
import com.baidu.nps.main.invoke.InvokeException;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.stub.ModuleInit;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.tieba.de1;
import com.baidu.tieba.ee1;
import com.baidu.tieba.ge1;
import com.baidu.tieba.id1;
import com.baidu.tieba.vd1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class Bundle {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLAZZ_SUFFIX_INVOKER = ".Invoker";
    public static final String EXTRA_KEY_CLAZZ = "clazz";
    public static final String EXTRA_KEY_PKG = "pkg";
    public static final String KEY_BUNDLE_INIT = "MODULE_INIT";
    public static final String METHOD_VALUE_BIND_PROVIDER = "bind_provider_impl";
    public static final String SCHEME_CONTENT = "content";
    public transient /* synthetic */ FieldHolder $fh;
    public BundleInfo mBundleInfo;
    public IInvoker mInvoker;
    public vd1 mRuntime;

    public Bundle(BundleInfo bundleInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundleInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBundleInfo = bundleInfo;
    }

    public Resources getResources(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resources)) == null) {
            return this.mRuntime.getResources(resources);
        }
        return (Resources) invokeL.objValue;
    }

    public Class loadClass(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return loadClass(str, null);
        }
        return (Class) invokeL.objValue;
    }

    private boolean bindProviders(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, packageInfo)) == null) {
            if (packageInfo == null) {
                return false;
            }
            Application applicationContext = ContextHolder.getApplicationContext();
            ProviderInfo[] providerInfoArr = packageInfo.providers;
            if (providerInfoArr != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putString("pkg", this.mBundleInfo.getPackageName());
                    bundle.putString(EXTRA_KEY_CLAZZ, providerInfo.name);
                    applicationContext.getContentResolver().call(new Uri.Builder().scheme("content").authority(providerInfo.authority).build(), METHOD_VALUE_BIND_PROVIDER, (String) null, bundle);
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean initBundle(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, packageInfo)) == null) {
            if (packageInfo == null) {
                return false;
            }
            Application applicationContext = ContextHolder.getApplicationContext();
            android.os.Bundle bundle = null;
            try {
                if (packageInfo.applicationInfo != null) {
                    bundle = packageInfo.applicationInfo.metaData;
                }
                if (bundle != null) {
                    String charSequence = bundle.getCharSequence(KEY_BUNDLE_INIT, "").toString();
                    if (!TextUtils.isEmpty(charSequence)) {
                        ((ModuleInit) this.mRuntime.c().loadClass(charSequence).newInstance()).init(applicationContext);
                        return true;
                    }
                    return true;
                }
                return true;
            } catch (Exception e) {
                id1.a().b().recordException(3, e.toString(), packageInfo.packageName);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    private synchronized boolean initIfNeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            synchronized (this) {
                if (this.mRuntime != null) {
                    return true;
                }
                vd1 b = vd1.b(this.mBundleInfo);
                this.mRuntime = b;
                if (b == null) {
                    return false;
                }
                Application applicationContext = ContextHolder.getApplicationContext();
                PackageInfo a = ge1.a(ee1.d(applicationContext, this.mBundleInfo.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath(), 138);
                initBundle(a);
                bindProviders(a);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    private synchronized boolean instantiateInvokerIfNeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            synchronized (this) {
                if (this.mInvoker != null) {
                    return true;
                }
                try {
                    Class loadClass = loadClass(this.mBundleInfo.getPackageName() + CLAZZ_SUFFIX_INVOKER, IInvoker.class);
                    if (loadClass != null) {
                        this.mInvoker = (IInvoker) loadClass.newInstance();
                    }
                    return true;
                } catch (IllegalAccessException e) {
                    throw new InvokeException(17, Log.getStackTraceString(e));
                } catch (InstantiationException e2) {
                    throw new InvokeException(17, Log.getStackTraceString(e2));
                }
            }
        }
        return invokeV.booleanValue;
    }

    public void loadOnly() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (de1.a() && this.mBundleInfo != null) {
                Log.d("Bundle", "loadOnly pkg=" + this.mBundleInfo.getPackageName());
            }
            initIfNeed();
            if (this.mRuntime != null) {
                return;
            }
            throw new InvokeException(19, "runtime is null");
        }
    }

    public BundleInfo getBundleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mBundleInfo;
        }
        return (BundleInfo) invokeV.objValue;
    }

    public ClassLoader getClassloader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mRuntime.c();
        }
        return (ClassLoader) invokeV.objValue;
    }

    public Resources getResources(Resources resources, Resources resources2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, resources, resources2)) == null) {
            return getResources(resources);
        }
        return (Resources) invokeLL.objValue;
    }

    @Deprecated
    public Object invoke(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, objArr)) == null) {
            instantiateInvokerIfNeed();
            IInvoker iInvoker = this.mInvoker;
            if (iInvoker != null) {
                return iInvoker.invoke(str, objArr);
            }
            throw new InvokeException(19, "invoker is null");
        }
        return invokeLL.objValue;
    }

    public Class loadClass(String str, Class cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, cls)) == null) {
            initIfNeed();
            vd1 vd1Var = this.mRuntime;
            if (vd1Var != null) {
                try {
                    if (cls == null) {
                        return vd1Var.c().loadClass(str);
                    }
                    return vd1Var.c().loadClass(str).asSubclass(cls);
                } catch (ClassNotFoundException e) {
                    throw new InvokeException(18, Log.getStackTraceString(e));
                }
            }
            throw new InvokeException(19, "runtime is null");
        }
        return (Class) invokeLL.objValue;
    }
}
