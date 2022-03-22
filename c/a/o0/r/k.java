package c.a.o0.r;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity;
import com.baidu.adp.plugin.pluginBase.PluginAdpBaseFragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.currentpagetype.CurrentPageTypeEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes2.dex */
public class k implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Stack<WeakReference<Activity>> a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10603b;

    public k() {
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
        this.a = new Stack<>();
        this.f10603b = true;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = null;
            for (int size = this.a.size() - 1; size >= 0; size--) {
                WeakReference<Activity> weakReference = this.a.get(size);
                if (weakReference != null && weakReference.get() != null) {
                    Activity activity = weakReference.get();
                    if (activity instanceof c.a.o0.r.e0.a) {
                        str = ((c.a.o0.r.e0.a) activity).getLatestRelatedFid();
                        if (!m.isEmpty(str)) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = null;
            for (int size = this.a.size() - 1; size >= 0; size--) {
                WeakReference<Activity> weakReference = this.a.get(size);
                if (weakReference != null && weakReference.get() != null) {
                    Activity activity = weakReference.get();
                    if (activity instanceof c.a.o0.r.e0.a) {
                        str = ((c.a.o0.r.e0.a) activity).getLatestRelatedTid();
                        if (!m.isEmpty(str)) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public final void c(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) || activity == null) {
            return;
        }
        String name = activity.getClass().getName();
        if (!c.a.o0.r.a0.c.a().d() || SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) || "com.baidu.tieba.yunpush.YunPushProxyActivity".equals(name) || SpeedRuntimeProvider.SCHEMA_ACTIVITY_NAME.equals(name)) {
            return;
        }
        if (SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name) && MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
            c.a.o0.r.a0.c.a().k(true);
            return;
        }
        c.a.o0.r.a0.c.a().h(c.a.o0.r.a0.c.a().b(), name);
    }

    public final void d(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, activity) == null) || activity == null) {
            return;
        }
        String name = activity.getClass().getName();
        if (!c.a.o0.r.a0.c.a().d() || SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) || "com.baidu.tieba.yunpush.YunPushProxyActivity".equals(name) || SpeedRuntimeProvider.SCHEMA_ACTIVITY_NAME.equals(name)) {
            return;
        }
        if (SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name) && MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
            c.a.o0.r.a0.c.a().l(true);
        } else {
            c.a.o0.r.a0.c.a().g(name);
        }
    }

    public final void e(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, activity) == null) && activity != null && PermissionUtil.isAgreePrivacyPolicy()) {
            if (activity.getClass().getName().equals(n.v())) {
                CurrentPageTypeHelper.PageType pageType = CurrentPageTypeHelper.PageType.OTHER;
                if (TbWebViewActivity.class.isAssignableFrom(activity.getClass())) {
                    pageType = CurrentPageTypeHelper.PageType.WEB;
                } else if (activity.getClass().getName().contains(SwanAppActivity.TAG)) {
                    pageType = CurrentPageTypeHelper.PageType.SMART_APP;
                } else if (activity.getClass().getName().contains("FlutterPageActivity")) {
                    pageType = CurrentPageTypeHelper.PageType.FLUTTER;
                } else if (activity.getClass().getName().contains("NewSquareSearchActivity")) {
                    pageType = CurrentPageTypeHelper.PageType.NATIVE_WEB;
                } else if (BaseActivity.class.isAssignableFrom(activity.getClass()) || BaseFragmentActivity.class.isAssignableFrom(activity.getClass()) || PluginAdpBaseActivity.class.isAssignableFrom(activity.getClass()) || PluginAdpBaseFragmentActivity.class.isAssignableFrom(activity.getClass())) {
                    pageType = CurrentPageTypeHelper.PageType.NATIVE;
                }
                c.a.o0.j0.h.i(new CurrentPageTypeEvent(pageType));
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, activity, bundle) == null) || activity == null) {
            return;
        }
        if (c.a.o0.r.h0.a.q().u() && activity != null && TbadkCoreApplication.getInst().isMainProcess(false) && activity.getClass().getPackage().getName().startsWith("com.baidu.tieba")) {
            if (this.f10603b && c.a.o0.r.h0.a.q().o() >= c.a.o0.r.h0.a.q().r() && !activity.getClass().getSimpleName().equals("MainTabActivity")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(activity).createNormalCfg(2)));
                activity.finish();
                return;
            }
            c.a.o0.r.h0.a.q().x();
        }
        String name = activity.getClass().getName();
        if (!SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) && !SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name)) {
            c.a.d.e.a.b().d();
        }
        this.a.push(new WeakReference<>(activity));
        if (!PermissionUtil.isAgreePrivacyPolicy() && activity != null && !activity.getClass().getSimpleName().equals("LogoActivity") && activity.getClass().getPackage().getName().startsWith("com.baidu.tieba") && TbadkCoreApplication.getInst().isMainProcess(false) && !TbSingleton.getInstance().isBrowseMode()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(activity, activity.getIntent())));
            activity.finish();
        }
        if (c.a.o0.i0.g.c.b().e(name)) {
            c.a.o0.i0.g.c.b().a();
        } else if (c.a.o0.i0.g.c.b().h(activity)) {
            c.a.o0.i0.g.c.b().c();
            if (c.a.o0.i0.g.c.b().g(name)) {
                c.a.o0.i0.g.c.b().l(true);
            }
        } else if (c.a.o0.i0.g.c.b().f(name)) {
            c.a.o0.i0.g.c.b().o();
            if (!c.a.o0.i0.g.c.b().g(name)) {
                c.a.o0.i0.g.c.b().l(false);
            } else {
                c.a.o0.i0.g.c.b().l(true);
            }
        }
        this.f10603b = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            int size = this.a.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                WeakReference<Activity> weakReference = this.a.get(size);
                if (weakReference != null && weakReference.get() != null && weakReference.get() == activity) {
                    this.a.remove(weakReference);
                    break;
                }
                size--;
            }
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (activity == null || currentActivity == null || !c.a.o0.i0.g.c.b().h(activity) || c.a.o0.i0.g.c.b().h(currentActivity)) {
                return;
            }
            c.a.o0.i0.g.c.b().o();
            if (c.a.o0.i0.g.c.b().g(currentActivity.getClass().getName())) {
                return;
            }
            c.a.o0.i0.g.c.b().l(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
            if (activity != null) {
                if (!activity.getClass().getSimpleName().equals("LogoActivity")) {
                    c.a.o0.a.e.C().F(UtilHelper.isActivityStartFromScheme(activity));
                }
                String name = activity.getClass().getName();
                if (c.a.o0.i0.g.c.b().e(name)) {
                    c.a.o0.i0.g.c.b().a();
                } else if (c.a.o0.i0.g.c.b().h(activity)) {
                    c.a.o0.i0.g.c.b().c();
                    if (c.a.o0.i0.g.c.b().g(name)) {
                        c.a.o0.i0.g.c.b().l(true);
                    }
                }
            }
            e(activity);
            d(activity);
            c(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, activity) == null) {
            TbadkCoreApplication.getInst().setStartType(1);
            if (TbadkCoreApplication.getInst().isMainProcess(false) && this.a.size() == 1) {
                c.a.o0.r.h0.a.q().g();
            }
        }
    }
}
