package com.baidu.nps.main.manager;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import c.a.e0.h.a;
import c.a.e0.i.c;
import c.a.e0.i.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.invoke.IInvoker;
import com.baidu.nps.main.invoke.InvokeException;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class Bundle {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLAZZ_SUFFIX_INVOKER = ".Invoker";
    public static final String EXTRA_KEY_CLAZZ = "clazz";
    public static final String EXTRA_KEY_PKG = "pkg";
    public static final String METHOD_VALUE_BIND_PROVIDER = "bind_provider_impl";
    public static final String SCHEME_CONTENT = "content";
    public transient /* synthetic */ FieldHolder $fh;
    public BundleInfo mBundleInfo;
    public IInvoker mInvoker;
    public a mRuntime;

    public Bundle(BundleInfo bundleInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundleInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBundleInfo = bundleInfo;
    }

    private boolean bindProviders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            PackageInfo a = e.a(c.d(applicationContext, this.mBundleInfo.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath(), 138);
            if (a == null) {
                return false;
            }
            ProviderInfo[] providerInfoArr = a.providers;
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
        return invokeV.booleanValue;
    }

    private synchronized boolean initIfNeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            synchronized (this) {
                if (this.mRuntime != null) {
                    return true;
                }
                a b2 = a.b(this.mBundleInfo);
                this.mRuntime = b2;
                if (b2 == null) {
                    return false;
                }
                bindProviders();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    private synchronized boolean instantiateInvokerIfNeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
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
                } catch (IllegalAccessException e2) {
                    throw new InvokeException(17, Log.getStackTraceString(e2));
                } catch (InstantiationException e3) {
                    throw new InvokeException(17, Log.getStackTraceString(e3));
                }
            }
        }
        return invokeV.booleanValue;
    }

    public BundleInfo getBundleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBundleInfo : (BundleInfo) invokeV.objValue;
    }

    public ClassLoader getClassloader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRuntime.c() : (ClassLoader) invokeV.objValue;
    }

    public Resources getResources(Resources resources, Resources resources2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, resources, resources2)) == null) ? getResources(resources) : (Resources) invokeLL.objValue;
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

    public Class loadClass(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? loadClass(str, null) : (Class) invokeL.objValue;
    }

    public Resources getResources(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resources)) == null) ? this.mRuntime.getResources(resources) : (Resources) invokeL.objValue;
    }

    public Class loadClass(String str, Class cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, cls)) == null) {
            initIfNeed();
            a aVar = this.mRuntime;
            if (aVar != null) {
                try {
                    if (cls == null) {
                        return aVar.c().loadClass(str);
                    }
                    return aVar.c().loadClass(str).asSubclass(cls);
                } catch (ClassNotFoundException e2) {
                    throw new InvokeException(18, Log.getStackTraceString(e2));
                }
            }
            throw new InvokeException(19, "runtime is null");
        }
        return (Class) invokeLL.objValue;
    }
}
