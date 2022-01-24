package c.a.t0.b2.i;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static Application.ActivityLifecycleCallbacks a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.t0.b2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class C0978a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
                BdLog.e("activity is " + activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                BdLog.e("activity is " + activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                BdLog.e("activity is " + activity);
                if (a.b(activity)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016521, activity));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
                BdLog.e("activity is " + activity);
                if (a.b(activity) && TbadkCoreApplication.getInst().canSendForegroundMessage()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016520, activity));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
                BdLog.e("activity is " + activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
                BdLog.e("activity is " + activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
                BdLog.e("activity is " + activity);
            }
        }

        public /* synthetic */ b(C0978a c0978a) {
            this();
        }
    }

    public static boolean b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            String className = activity.getComponentName().getClassName();
            if (!className.contains("AlaMasterLiveRoomActivity") && !className.contains("LivePlayerActivity") && !className.contains("LiveShowActivity") && !className.contains("AlaLiveEndActivity") && !className.contains("LiveListActivity") && !className.contains("BuyTBeanActivity") && !className.contains("YuyinLivePlayerActivity") && !className.contains("YuyinAlaCreateLiveRoomActivity")) {
                if (className.equals("com.baidu.megapp.proxy.activity.ActivityProxy")) {
                    String stringExtra = activity.getIntent().getStringExtra("megapp_extra_target_activity");
                    if (!TextUtils.isEmpty(stringExtra) && (stringExtra.contains("AlaMasterLiveRoomActivity") || stringExtra.contains("LivePlayerActivity") || stringExtra.contains("AlaLiveEndActivity"))) {
                        return true;
                    }
                }
                if (!className.contains("com.yy.mobile") && !className.contains("com.duowan.mobile")) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void c(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, application) == null) {
            if (a == null) {
                a = new b(null);
            }
            application.registerActivityLifecycleCallbacks(a);
        }
    }
}
