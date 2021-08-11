package c.a.a0.h;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView;
import c.a.a0.c.a.d;
import c.a.a0.c.a.h;
import c.a.a0.h.c.b;
import c.a.a0.i.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.runtime.InitException;
import com.baidu.nps.runtime.resources.ResourcesHookUtil;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BundleInfo f1677a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.a0.h.b.a f1678b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1679c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.a0.h.c.a f1680d;

    public a(BundleInfo bundleInfo) {
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
        this.f1679c = false;
        this.f1680d = null;
        if (a(bundleInfo)) {
            this.f1677a = bundleInfo;
            return;
        }
        throw new InitException(22, "bad param bundleInfo:" + bundleInfo.toString());
    }

    public static a b(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bundleInfo)) == null) {
            a aVar = new a(bundleInfo);
            aVar.e();
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public final boolean a(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundleInfo)) == null) {
            if (bundleInfo == null || TextUtils.isEmpty(bundleInfo.getPackageName())) {
                return false;
            }
            Application applicationContext = ContextHolder.getApplicationContext();
            StringBuilder sb = new StringBuilder();
            sb.append(bundleInfo.getPackageName());
            sb.append(".apk");
            return c.d(applicationContext, sb.toString()).exists();
        }
        return invokeL.booleanValue;
    }

    public ClassLoader c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1678b : (ClassLoader) invokeV.objValue;
    }

    public synchronized Resources d(Resources resources) {
        InterceptResult invokeL;
        c.a.a0.h.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resources)) == null) {
            synchronized (this) {
                Application applicationContext = ContextHolder.getApplicationContext();
                String absolutePath = c.d(applicationContext, this.f1677a.getPackageName() + ".apk").getAbsolutePath();
                AssetManager assets = resources.getAssets();
                if (ResourcesHookUtil.hookAssets(assets, absolutePath)) {
                    if (this.f1680d == null || this.f1680d.getAssets().hashCode() != assets.hashCode()) {
                        this.f1680d = new c.a.a0.h.c.a(assets, resources.getDisplayMetrics(), resources.getConfiguration(), resources);
                    }
                    aVar = this.f1680d;
                } else {
                    throw new InitException(21, "resources hook error");
                }
            }
            return aVar;
        }
        return (Resources) invokeL.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f()) {
                if (!g()) {
                    throw new InitException(20, "resources init error");
                }
                return;
            }
            throw new InitException(16, "class loader init error");
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            this.f1678b = new c.a.a0.h.b.a(c.d(applicationContext, this.f1677a.getPackageName() + ".apk").getAbsolutePath(), c.f(applicationContext, this.f1677a.getPackageName()).getAbsolutePath(), c.e(applicationContext, this.f1677a.getPackageName()).getAbsolutePath(), applicationContext);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final synchronized boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                try {
                    Application applicationContext = ContextHolder.getApplicationContext();
                    Resources a2 = d.c().a();
                    Resources b2 = d.c().b();
                    Resources[] d2 = d.c().d();
                    if (!this.f1679c) {
                        h(applicationContext);
                        this.f1679c = true;
                    }
                    String absolutePath = c.d(applicationContext, this.f1677a.getPackageName() + ".apk").getAbsolutePath();
                    ResourcesHookUtil.hookResources(a2, absolutePath);
                    ResourcesHookUtil.hookResources(b2, absolutePath);
                    if (d2 != null) {
                        for (Resources resources : d2) {
                            ResourcesHookUtil.hookResources(resources, absolutePath);
                        }
                    }
                } catch (Exception unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                h.a().c();
                try {
                    new WebView(context);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            new b(context, countDownLatch).sendMessage(Message.obtain());
            try {
                countDownLatch.await();
            } catch (Exception unused2) {
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? super.toString() : (String) invokeV.objValue;
    }
}
