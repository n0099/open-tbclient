package b.a.q0.t.j;

import android.os.Handler;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.PingMessage;
import com.baidu.tbadk.coreExtra.message.ResponsedPingMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e extends Handler implements b.a.e.c.e.c.b {
    public static /* synthetic */ Interceptable $ic;
    public static e j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f14855e;

    /* renamed from: f  reason: collision with root package name */
    public int f14856f;

    /* renamed from: g  reason: collision with root package name */
    public int f14857g;

    /* renamed from: h  reason: collision with root package name */
    public int f14858h;

    /* renamed from: i  reason: collision with root package name */
    public PingMessage f14859i;

    /* loaded from: classes4.dex */
    public class a extends b.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f14860a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14860a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) || socketResponsedMessage == null) {
                return;
            }
            this.f14860a.l(socketResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f14861a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14861a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f14861a.h((BackgroundSwitchMessage) customResponsedMessage);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1965876223, "Lb/a/q0/t/j/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1965876223, "Lb/a/q0/t/j/e;");
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14855e = 0L;
        this.f14856f = TiebaStatic.MAX_COST_VALUE;
        this.f14857g = 900000;
        this.f14858h = 900000;
        this.f14859i = null;
    }

    public static e j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (j == null) {
                synchronized (e.class) {
                    if (j == null) {
                        j = new e();
                    }
                }
            }
            return j;
        }
        return (e) invokeV.objValue;
    }

    @Override // b.a.e.c.e.c.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            removeMessages(1);
        }
    }

    @Override // b.a.e.c.e.c.b
    public boolean b(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str)) == null) {
            if ((z || System.currentTimeMillis() - this.f14855e >= 180000) && BdSocketLinkService.isOpen()) {
                this.f14855e = System.currentTimeMillis();
                MessageManager.getInstance().sendMessage(this.f14859i);
                PingMessage pingMessage = this.f14859i;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("-");
                sb.append(this.f14858h == this.f14857g ? com.alipay.sdk.widget.d.u : "fore");
                b.a.e.c.e.c.i.c("PingManager", pingMessage, 0, "send_ping", 0, sb.toString());
                return true;
            }
            return false;
        }
        return invokeZL.booleanValue;
    }

    @Override // b.a.e.c.e.c.b
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 1003;
        }
        return invokeV.intValue;
    }

    @Override // b.a.e.c.e.c.b
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (BdSocketLinkService.isClose()) {
                b.a.q0.f0.a.b(0, 0, 0, 1, 10);
                BdSocketLinkService.startService(false, str);
            } else if (BdSocketLinkService.isOpen()) {
                b(false, str);
            }
        }
    }

    @Override // b.a.e.c.e.c.b
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            removeMessages(1);
            sendMessageDelayed(obtainMessage(1), this.f14858h);
            this.f14855e = System.currentTimeMillis();
        }
    }

    public final void h(BackgroundSwitchMessage backgroundSwitchMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, backgroundSwitchMessage) == null) || backgroundSwitchMessage == null) {
            return;
        }
        if (backgroundSwitchMessage.getData().booleanValue()) {
            this.f14858h = this.f14857g;
            return;
        }
        this.f14858h = this.f14856f;
        d("switchToForeground");
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, message) == null) && message.what == 1) {
            e();
            b(true, "regular time send");
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14856f : invokeV.intValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b.a.q0.y0.b bVar = new b.a.q0.y0.b(1003);
            bVar.setResponsedClass(ResponsedPingMessage.class);
            bVar.h(false);
            bVar.setPriority(-3);
            bVar.f(SocketMessageTask.DupLicateMode.REMOVE_ME);
            bVar.e(false);
            MessageManager.getInstance().registerTask(bVar);
            this.f14859i = new PingMessage();
            m();
            a aVar = new a(this, 1003);
            MessageManager.getInstance().registerListener(new b(this, 2001011));
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    public final void l(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, responsedMessage) == null) || responsedMessage == null) {
            return;
        }
        int error = responsedMessage.getError();
        if (error == 0) {
            com.baidu.adp.framework.message.Message<?> orginalMessage = responsedMessage.getOrginalMessage();
            int i2 = b.a.q0.s.h.f13874a;
            b.a.e.c.e.c.i.c("PingManager", orginalMessage, 0, "ping_succ", i2, "costtime:" + String.valueOf(System.currentTimeMillis() - this.f14855e));
            return;
        }
        BdSocketLinkService.close(7, "ping error");
        int cmd = this.f14859i.getCmd();
        long clientLogID = this.f14859i.getClientLogID();
        b.a.e.c.e.c.i.b("PingManager", cmd, clientLogID, 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.f14855e));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int[] socketHeartBeatStratgy = TbadkCoreApplication.getInst().getSocketHeartBeatStratgy();
            if (socketHeartBeatStratgy.length == 2) {
                int i2 = socketHeartBeatStratgy[0] * 1000;
                this.f14856f = i2;
                this.f14857g = socketHeartBeatStratgy[1] * 1000;
                if (i2 < 180000) {
                    this.f14856f = TiebaStatic.MAX_COST_VALUE;
                }
                if (this.f14857g < 180000) {
                    this.f14857g = TiebaStatic.MAX_COST_VALUE;
                }
            }
        }
    }
}
