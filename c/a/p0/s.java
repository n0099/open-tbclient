package c.a.p0;

import android.app.Activity;
import android.os.Bundle;
import android.os.MessageQueue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.task.async.appcreate.InitSwanAppTask;
import com.baidu.searchbox.task.async.homeready.InitCyberPlayerTask;
import com.baidu.searchbox.task.async.homeready.MainTabLoadFinishTask;
import com.baidu.searchbox.task.sync.appcreate.InitBearTask;
import com.baidu.searchbox.task.sync.appcreate.InitPrologueAdTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class s extends c.a.o0.r.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s f18126b;

        /* renamed from: c.a.p0.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1368a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LaunchTask a;

            public RunnableC1368a(a aVar, LaunchTask launchTask) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, launchTask};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = launchTask;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.run();
                }
            }
        }

        public a(s sVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18126b = sVar;
            this.a = activity;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                SpeedStats.getInstance().onSchemeOrPushStatsEnd(this.a, c.a.o0.r.a0.b.a().f10497b == 1);
                if (c.a.p0.w2.l.a.a().d()) {
                    for (LaunchTask launchTask : this.f18126b.f()) {
                        c.a.d.e.a.b().a(launchTask.getName(), new RunnableC1368a(this, launchTask));
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    public s() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public List<LaunchTask> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new InitPrologueAdTask());
            arrayList.add(new InitBearTask());
            arrayList.add(new MainTabLoadFinishTask());
            arrayList.add(new InitCyberPlayerTask());
            arrayList.add(new InitSwanAppTask());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void g(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && activity != null && c.a.o0.r.a0.b.a().a) {
            String name = activity.getClass().getName();
            if (!c.a.o0.r.a0.c.a().d() || SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) || "com.baidu.tieba.yunpush.YunPushProxyActivity".equals(name) || SpeedRuntimeProvider.SCHEMA_ACTIVITY_NAME.equals(name)) {
                return;
            }
            c.a.o0.r.a0.b.a().e(new a(this, activity));
        }
    }

    @Override // c.a.o0.r.k, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, bundle) == null) {
            super.onActivityCreated(activity, bundle);
            g(activity);
        }
    }
}
