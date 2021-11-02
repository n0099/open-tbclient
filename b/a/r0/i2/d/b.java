package b.a.r0.i2.d;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.t.c.m;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f17968d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0916b f17969a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f17970b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f17971c;

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<m> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    m data = customMessage.getData();
                    String e2 = data.e();
                    if (data.getType() == 0 && TextUtils.isEmpty(e2)) {
                        if (data.f() != null) {
                            data.f().b(null);
                        }
                        return null;
                    } else if (data.getType() == 4) {
                        l.M(TbadkCoreApplication.getInst(), "验证失败，请您稍后再试");
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

    /* renamed from: b.a.r0.i2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0916b {
        void a(m.c cVar);
    }

    /* loaded from: classes4.dex */
    public static class c implements InterfaceC0916b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public m f17972a;

        public c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17972a = mVar;
        }

        @Override // b.a.r0.i2.d.b.InterfaceC0916b
        public void a(m.c cVar) {
            m mVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || (mVar = this.f17972a) == null || mVar.f() == null) {
                return;
            }
            this.f17972a.f().b(cVar);
        }
    }

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
                return;
            }
        }
        this.f17970b = new AtomicBoolean(false);
        this.f17971c = new AtomicBoolean(false);
    }

    public static b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f17968d == null) {
                synchronized (b.class) {
                    if (f17968d == null) {
                        f17968d = new b();
                    }
                }
            }
            return f17968d;
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

    public void a(m.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (this.f17969a != null) {
                if (cVar == null) {
                    cVar = new m.c(false);
                }
                this.f17969a.a(cVar);
            }
            this.f17969a = null;
            this.f17970b.set(false);
        }
    }

    public void b(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
            a(new m.a(z, str));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            a(new m.c(z));
        }
    }

    public void d(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) {
            b.a.r0.i2.d.c.i().k(null);
            a(new m.b(z, str));
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            a(new m.c(false));
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

    public final void i(m mVar, InterfaceC0916b interfaceC0916b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, mVar, interfaceC0916b) == null) {
            q(interfaceC0916b);
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (mVar != null && session != null) {
                if (mVar.getType() == 0) {
                    j(mVar.e());
                    return;
                } else if (mVar.getType() == 1) {
                    l(session.bduss);
                    return;
                } else if (mVar.getType() == 2) {
                    k(session.bduss);
                    return;
                } else if (mVar.getType() == 3) {
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
            intent.setFlags(268435456);
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
            intent.addFlags(268435456);
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
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
            Intent intent = new Intent(context, RemindActivity.class);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public final void p() {
        b.a.q0.t.a.b b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = b.a.q0.s.l.c.e();
            }
            if (currentAccountObj != null && (!TextUtils.isEmpty(currentAccountObj.getAccount()) || !TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                b.a.q0.s.l.c.c(currentAccountObj.getID());
                if (ReloginManager.g().i() && !TextUtils.isEmpty(currentAccountObj.getID()) && (b2 = b.a.q0.t.a.a.b()) != null) {
                    b2.c(currentAccountObj);
                }
                ReloginManager.g().f(null);
                return;
            }
            Handler handler = TbadkCoreApplication.getInst().handler;
            handler.sendMessage(handler.obtainMessage(1));
        }
    }

    public void q(InterfaceC0916b interfaceC0916b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, interfaceC0916b) == null) {
            this.f17969a = interfaceC0916b;
        }
    }

    public void r(m mVar, InterfaceC0916b interfaceC0916b) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, mVar, interfaceC0916b) == null) && this.f17971c.compareAndSet(false, true)) {
            if (this.f17970b.compareAndSet(false, true)) {
                try {
                    i(mVar, interfaceC0916b);
                } catch (Exception e2) {
                    BdStatisticsManager.getInstance().error("passloaderror", 0L, (String) null, "Exception", e2.toString());
                    this.f17970b.set(false);
                }
            } else if (!h()) {
                try {
                    i(mVar, interfaceC0916b);
                } catch (Exception unused) {
                    this.f17970b.set(false);
                }
            }
            this.f17971c.set(false);
        }
    }
}
