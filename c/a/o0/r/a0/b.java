package c.a.o0.r.a0;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import c.a.d.f.p.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f10497b;

    /* renamed from: c  reason: collision with root package name */
    public String f10498c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10499d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f10500e;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MessageQueue.IdleHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f10501b;

        public a(b bVar, MessageQueue.IdleHandler idleHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, idleHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10501b = bVar;
            this.a = idleHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10501b.e(this.a);
            }
        }
    }

    /* renamed from: c.a.o0.r.a0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0821b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1621886826, "Lc/a/o0/r/a0/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1621886826, "Lc/a/o0/r/a0/b$b;");
                    return;
                }
            }
            a = new b();
        }
    }

    public b() {
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
        this.f10497b = 0;
        this.f10499d = false;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C0821b.a : (b) invokeV.objValue;
    }

    public final Handler b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f10500e == null) {
                this.f10500e = new Handler(Looper.getMainLooper());
            }
            return this.f10500e;
        }
        return (Handler) invokeV.objValue;
    }

    public void c(ActivityManager.AppTask appTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appTask) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(false) || Build.VERSION.SDK_INT < 23 || appTask == null || appTask.getTaskInfo() == null || appTask.getTaskInfo().baseActivity == null || appTask.getTaskInfo().topActivity == null || appTask.getTaskInfo().baseIntent == null) {
                return;
            }
            String dataString = appTask.getTaskInfo().baseIntent.getDataString();
            if (SpeedRuntimeProvider.SCHEMA_ACTIVITY_NAME.equals(appTask.getTaskInfo().baseActivity.getClassName()) && SpeedRuntimeProvider.SCHEMA_ACTIVITY_NAME.equals(appTask.getTaskInfo().topActivity.getClassName())) {
                this.f10497b = !m.isEmpty(dataString) ? 1 : 0;
                this.f10498c = dataString;
            } else if ("com.baidu.tieba.yunpush.YunPushProxyActivity".equals(appTask.getTaskInfo().baseActivity.getClassName()) && "com.baidu.tieba.yunpush.YunPushProxyActivity".equals(appTask.getTaskInfo().topActivity.getClassName())) {
                this.f10497b = m.isEmpty(dataString) ? 0 : 2;
                this.f10498c = dataString;
            } else {
                this.f10497b = 0;
            }
            this.a = this.f10497b != 0;
        }
    }

    public void d(Intent intent) {
        ComponentName component;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(false) || intent == null || (component = intent.getComponent()) == null) {
                return;
            }
            String dataString = intent.getDataString();
            if (SpeedRuntimeProvider.SCHEMA_ACTIVITY_NAME.equals(component.getClassName())) {
                this.f10497b = !m.isEmpty(dataString) ? 1 : 0;
                this.f10498c = dataString;
            } else if ("com.baidu.tieba.yunpush.YunPushProxyActivity".equals(component.getClassName())) {
                this.f10497b = m.isEmpty(dataString) ? 0 : 2;
                this.f10498c = dataString;
            } else {
                this.f10497b = 0;
            }
            this.a = this.f10497b != 0;
        }
    }

    public void e(MessageQueue.IdleHandler idleHandler) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, idleHandler) == null) || idleHandler == null || this.f10499d) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            b().post(new a(this, idleHandler));
            return;
        }
        Looper.myQueue().addIdleHandler(idleHandler);
        this.f10499d = true;
    }
}
