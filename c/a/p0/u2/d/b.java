package c.a.p0.u2.d;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.s.c.l;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.passaccount.app.AuthActivity;
import com.baidu.tieba.passaccount.app.RemindActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f18987d;
    public transient /* synthetic */ FieldHolder $fh;
    public InterfaceC1435b a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f18988b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f18989c;

    /* loaded from: classes2.dex */
    public static class a implements CustomMessageTask.CustomRunnable<l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<l> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    l data = customMessage.getData();
                    String e2 = data.e();
                    if (data.getType() == 0 && TextUtils.isEmpty(e2)) {
                        if (data.f() != null) {
                            data.f().b(null);
                        }
                        return null;
                    } else if (data.getType() == 4) {
                        n.N(TbadkCoreApplication.getInst(), "验证失败，请您稍后再试");
                        if (data.f() != null) {
                            data.f().b(null);
                        }
                        return null;
                    } else {
                        MessageManager.getInstance().runTask(2921332, (Class) null);
                        b.f().r(data, new c(data));
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* renamed from: c.a.p0.u2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1435b {
        void a(l.c cVar);
    }

    /* loaded from: classes2.dex */
    public static class c implements InterfaceC1435b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public l a;

        public c(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // c.a.p0.u2.d.b.InterfaceC1435b
        public void a(l.c cVar) {
            l lVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || (lVar = this.a) == null || lVar.f() == null) {
                return;
            }
            this.a.f().b(cVar);
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
        this.f18988b = new AtomicBoolean(false);
        this.f18989c = new AtomicBoolean(false);
    }

    public static b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f18987d == null) {
                synchronized (b.class) {
                    if (f18987d == null) {
                        f18987d = new b();
                    }
                }
            }
            return f18987d;
        }
        return (b) invokeV.objValue;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921372, new a());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            n();
        }
    }

    public void a(l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (this.a != null) {
                if (cVar == null) {
                    cVar = new l.c(false);
                }
                this.a.a(cVar);
            }
            this.a = null;
            this.f18988b.set(false);
        }
    }

    public void b(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
            a(new l.a(z, str));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            a(new l.c(z));
        }
    }

    public void d(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) {
            c.a.p0.u2.d.c.i().k(null);
            a(new l.b(z, str));
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            a(new l.c(false));
            if (z) {
                p();
            }
        }
    }

    public final ComponentName g() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                if (BdBaseApplication.getInst() == null || (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity")) == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.size() <= 0) {
                    return null;
                }
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (runningTaskInfo != null && runningTaskInfo.topActivity != null) {
                        return runningTaskInfo.topActivity;
                    }
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (ComponentName) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ComponentName g2 = g();
            if (g2 != null) {
                return AuthActivity.class.getName().equals(g2.getClassName()) || PassLivenessRecogActivity.class.getName().equals(g2.getClassName());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void i(l lVar, InterfaceC1435b interfaceC1435b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, lVar, interfaceC1435b) == null) {
            q(interfaceC1435b);
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (lVar != null && session != null) {
                if (lVar.getType() == 0) {
                    j(lVar.e());
                    return;
                } else if (lVar.getType() == 1) {
                    l(session.bduss);
                    return;
                } else if (lVar.getType() == 2) {
                    k(session.bduss);
                    return;
                } else if (lVar.getType() == 3) {
                    m();
                    return;
                } else {
                    return;
                }
            }
            a(null);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
            Intent intent = new Intent(context, AuthActivity.class);
            intent.putExtra(AuthActivity.EXTRA_TYPE, 0);
            intent.putExtra(AuthActivity.EXTRA_AUTH_TOKEN, str);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            context.startActivity(intent);
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
            Intent intent = new Intent(context, AuthActivity.class);
            intent.putExtra(AuthActivity.EXTRA_TYPE, 2);
            intent.putExtra("EXTRA_BDUSS", str);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            context.startActivity(intent);
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
            Intent intent = new Intent(context, AuthActivity.class);
            intent.putExtra(AuthActivity.EXTRA_TYPE, 1);
            intent.putExtra("EXTRA_BDUSS", str);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            context.startActivity(intent);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
            Intent intent = new Intent(context, RemindActivity.class);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            context.startActivity(intent);
        }
    }

    public final void p() {
        c.a.o0.s.a.b b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = c.a.o0.r.m.c.e();
            }
            if (currentAccountObj != null && (!TextUtils.isEmpty(currentAccountObj.getAccount()) || !TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                c.a.o0.r.m.c.c(currentAccountObj.getID());
                if (ReloginManager.g().i() && !TextUtils.isEmpty(currentAccountObj.getID()) && (b2 = c.a.o0.s.a.a.b()) != null) {
                    b2.c(currentAccountObj);
                }
                ReloginManager.g().f(null);
                return;
            }
            Handler handler = TbadkCoreApplication.getInst().handler;
            handler.sendMessage(handler.obtainMessage(1));
        }
    }

    public void q(InterfaceC1435b interfaceC1435b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, interfaceC1435b) == null) {
            this.a = interfaceC1435b;
        }
    }

    public void r(l lVar, InterfaceC1435b interfaceC1435b) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, lVar, interfaceC1435b) == null) && this.f18989c.compareAndSet(false, true)) {
            if (this.f18988b.compareAndSet(false, true)) {
                try {
                    i(lVar, interfaceC1435b);
                } catch (Exception e2) {
                    BdStatisticsManager.getInstance().error("passloaderror", 0L, (String) null, "Exception", e2.toString());
                    this.f18988b.set(false);
                }
            } else if (!h()) {
                try {
                    i(lVar, interfaceC1435b);
                } catch (Exception unused) {
                    this.f18988b.set(false);
                }
            }
            this.f18989c.set(false);
        }
    }
}
