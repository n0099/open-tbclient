package c.a.p0.s;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import c.a.e.e.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity;
import com.baidu.adp.plugin.pluginBase.PluginAdpBaseFragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.mutiprocess.currentpagetype.CurrentPageTypeEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class j implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && activity != null && PermissionUtil.isAgreePrivacyPolicy()) {
            if (activity.getClass().getName().equals(l.v())) {
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
                c.a.p0.h0.h.i(new CurrentPageTypeEvent(pageType));
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bundle) == null) || PermissionUtil.isAgreePrivacyPolicy() || activity == null || activity.getClass().getSimpleName().equals("LogoActivity") || !activity.getClass().getPackage().getName().startsWith("com.baidu.tieba") || !TbadkCoreApplication.getInst().isMainProcess(false) || TbSingleton.getInstance().isBrowseMode()) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(activity, activity.getIntent())));
        activity.finish();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            if (activity != null && !activity.getClass().getSimpleName().equals("LogoActivity")) {
                c.a.p0.a.e.y().A(activity);
            }
            a(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            TbadkCoreApplication.getInst().setStartType(1);
        }
    }
}
