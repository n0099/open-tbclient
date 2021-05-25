package com.baidu.nps.main.manager;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.baidu.nps.main.invoke.IInvoker;
import com.baidu.nps.main.invoke.InvokeException;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.utils.ContextHolder;
import d.a.z.h.a;
import d.a.z.i.c;
import d.a.z.i.e;
/* loaded from: classes2.dex */
public class Bundle {
    public static final String CLAZZ_SUFFIX_INVOKER = ".Invoker";
    public static final String EXTRA_KEY_CLAZZ = "clazz";
    public static final String EXTRA_KEY_PKG = "pkg";
    public static final String METHOD_VALUE_BIND_PROVIDER = "bind_provider_impl";
    public static final String SCHEME_CONTENT = "content";
    public BundleInfo mBundleInfo;
    public IInvoker mInvoker;
    public a mRuntime;

    public Bundle(BundleInfo bundleInfo) {
        this.mBundleInfo = bundleInfo;
    }

    private boolean bindProviders() {
        Application applicationContext = ContextHolder.getApplicationContext();
        PackageInfo a2 = e.a(c.d(applicationContext, this.mBundleInfo.getPackageName() + ".apk").getAbsolutePath(), 138);
        if (a2 == null) {
            return false;
        }
        ProviderInfo[] providerInfoArr = a2.providers;
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

    private synchronized boolean initIfNeed() {
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

    @Deprecated
    private synchronized boolean instantiateInvokerIfNeed() {
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

    public BundleInfo getBundleInfo() {
        return this.mBundleInfo;
    }

    public ClassLoader getClassloader() {
        return this.mRuntime.c();
    }

    public Resources getResources(Resources resources, Resources resources2) {
        return getResources(resources);
    }

    @Deprecated
    public Object invoke(String str, Object... objArr) {
        instantiateInvokerIfNeed();
        IInvoker iInvoker = this.mInvoker;
        if (iInvoker != null) {
            return iInvoker.invoke(str, objArr);
        }
        throw new InvokeException(19, "invoker is null");
    }

    public Class loadClass(String str) {
        return loadClass(str, null);
    }

    public Resources getResources(Resources resources) {
        return this.mRuntime.d(resources);
    }

    public Class loadClass(String str, Class cls) {
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
}
