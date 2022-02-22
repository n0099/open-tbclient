package c.a.d.c.e.c;

import androidx.core.view.InputDeviceCompat;
import c.a.d.c.e.c.d;
import c.a.d.f.p.n;
import c.a.d.f.r.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class g extends c.a.d.c.e.a<SocketMessage, SocketMessageTask> implements c.a.d.c.e.c.k.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public d.a f1778b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<e> f1779c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<e> f1780d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedList<e> f1781e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.d.c.e.c.k.a f1782f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1783g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.c.e.c.b f1784h;

    /* renamed from: i  reason: collision with root package name */
    public long f1785i;

    /* renamed from: j  reason: collision with root package name */
    public int f1786j;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.d.c.e.c.d.a
        public void a(d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.a.x(bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1918921129, "Lc/a/d/c/e/c/g$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1918921129, "Lc/a/d/c/e/c/g$b;");
                    return;
                }
            }
            int[] iArr = new int[SocketMessageTask.DupLicateMode.values().length];
            a = iArr;
            try {
                iArr[SocketMessageTask.DupLicateMode.REMOVE_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[SocketMessageTask.DupLicateMode.REMOVE_WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[SocketMessageTask.DupLicateMode.REMOVE_ME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(MessageManager messageManager) {
        super(messageManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((MessageManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1778b = null;
        this.f1779c = new LinkedList<>();
        this.f1780d = new LinkedList<>();
        this.f1781e = new LinkedList<>();
        this.f1782f = null;
        this.f1783g = true;
        this.f1784h = null;
        this.f1785i = 0L;
        this.f1786j = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.f1778b = new a(this);
    }

    public void A(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
            return;
        }
        if (eVar.v()) {
            eVar.h();
            c.j(this.f1780d, this.f1779c, eVar);
            return;
        }
        c.n(eVar, this.f1780d);
    }

    public void B(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && eVar.i() && eVar.p() < eVar.l()) {
                c.j(this.f1779c, this.f1781e, eVar);
                c.a.d.c.e.c.b bVar = this.f1784h;
                if (bVar != null) {
                    bVar.b(true, "timeout seq = " + eVar.q());
                }
                i.c("queue", eVar.m(), eVar.q(), "onSendTimeOut", h.t, String.valueOf(eVar.p()));
                return;
            }
            D(eVar);
            w(eVar, h.m, null);
            F();
        }
    }

    public void C(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public final void D(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) || eVar == null) {
            return;
        }
        eVar.w();
        c.n(eVar, this.f1779c);
        c.n(eVar, this.f1780d);
        c.n(eVar, this.f1781e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.c.b
    /* renamed from: E */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, socketMessage, socketMessageTask) == null) {
            n.c();
            if (socketMessage == null || socketMessageTask == null) {
                return;
            }
            if (m(socketMessage, socketMessageTask.a())) {
                i.c("queue", socketMessage, 0, "sendMessage", h.q, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.c("queue", socketMessage, 0, "sendMessage", h.z, "user manual close socket");
                eVar.a(h.z);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.c("queue", socketMessage, 0, "sendMessage", h.p, "isManualBlock message be removed");
                eVar.a(h.p);
            } else {
                i.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.h(eVar, this.f1780d);
                F();
            }
        }
    }

    public final void F() {
        e f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (f2 = c.f(this.f1780d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            i.c("queue", f2.m(), 0, "sendNext", h.r, "");
            BdSocketLinkService.startService(false, "send message");
        } else if (!this.f1783g || f2.n() <= -3) {
            BdSocketLinkService.sendMessage(f2);
        }
    }

    public void G(c.a.d.c.e.c.k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f1782f = aVar;
        }
    }

    public void H(c.a.d.c.e.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f1784h = bVar;
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean z = this.f1783g;
            this.f1783g = false;
            i.a("queue", 0, 0, "unBlockMessageQueue", h.s, "Queue block has release");
            if (z) {
                F();
            }
        }
    }

    @Override // c.a.d.c.e.c.k.a
    public void a(String str) {
        c.a.d.c.e.c.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (aVar = this.f1782f) == null) {
            return;
        }
        aVar.a(str);
    }

    @Override // c.a.d.c.e.c.k.a
    public boolean b(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, str)) == null) {
            c.a.d.c.e.c.k.a aVar = this.f1782f;
            if (aVar != null) {
                aVar.b(i2, str);
            }
            c.a.d.c.e.c.b bVar = this.f1784h;
            if (bVar != null) {
                bVar.a();
            }
            if (n.C() && !c.a(this.f1781e) && !c.a(this.f1780d) && !c.a(this.f1779c) && BdSocketLinkService.isAvailable()) {
                c.b(this.f1779c);
                c.i(this.f1780d, this.f1781e);
                c.i(this.f1780d, this.f1779c);
                while (true) {
                    e k = c.k(this.f1780d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    w(k, h.o, null);
                }
                if (c.q(this.f1780d) > 0) {
                    i.a("queue", 0, 0, "onClose", h.u, "have retry message, MessageQueue:reconnect");
                    BdSocketLinkService.startService(false, "have retry message");
                    return true;
                }
                return false;
            }
            j();
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // c.a.d.c.e.c.k.a
    public void c(c.a.d.f.r.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            F();
            c.a.d.c.e.c.k.a aVar = this.f1782f;
            if (aVar != null) {
                aVar.c(cVar);
            }
        }
    }

    @Override // c.a.d.c.e.c.k.a
    public void d(k kVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, kVar) == null) || kVar == null || (bArr = kVar.a) == null) {
            return;
        }
        this.f1785i = System.currentTimeMillis();
        try {
            c.a.d.c.e.c.j.c c2 = c.a.d.c.e.c.j.b.f().c(bArr);
            this.f1786j = 0;
            int b2 = c2.a.b();
            int h2 = c2.a.h();
            i.a("queue", b2, h2, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            e p = p(b2, h2);
            if (p != null) {
                p.m = kVar.f2281b;
                p.n = kVar.f2282c;
            }
            if (this.f1784h != null) {
                if (c2.a.b() == this.f1784h.c() && c.i(this.f1780d, this.f1781e)) {
                    F();
                }
                this.f1784h.e();
            }
            if (h2 == 0 || (p != null && p.k() == b2)) {
                new d(c2, p, this.f1778b, h2).execute(new String[0]);
            } else if (p != null) {
                w(p, h.A, null);
            }
            c.a.d.c.e.c.k.a aVar = this.f1782f;
            if (aVar != null) {
                aVar.d(kVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            int q = c.a.d.f.n.m.a.o().q("alert_protobuf", 2);
            int i2 = this.f1786j + 1;
            this.f1786j = i2;
            if (i2 >= q) {
                BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
            }
            i.a("queue", 0, 0, "onBinaryMesssage", h.f1795j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // c.a.d.c.b
    public LinkedList<SocketMessage> e(int i2, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    @Override // c.a.d.c.e.c.k.a
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, map) == null) {
            f.a().c(map);
            c.a.d.c.e.c.b bVar = this.f1784h;
            if (bVar != null) {
                bVar.e();
            }
            this.f1783g = true;
            i.a("queue", 0, 0, "onConnected", h.y, "Queue blocked");
            c.a.d.c.e.c.k.a aVar = this.f1782f;
            if (aVar != null) {
                aVar.g(map);
            }
        }
    }

    @Override // c.a.d.c.b
    public void h(int i2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i2, bdUniqueId) == null) {
            c.m(this.f1779c, i2, bdUniqueId);
            c.m(this.f1780d, i2, bdUniqueId);
            c.m(this.f1781e, i2, bdUniqueId);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            k(this.f1779c);
            k(this.f1780d);
            k(this.f1781e);
        }
    }

    public final void k(LinkedList<e> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048594, this, linkedList) != null) {
            return;
        }
        while (true) {
            e l = c.l(linkedList);
            if (l == null) {
                return;
            }
            l.w();
            w(l, h.o, null);
        }
    }

    public final void l(SocketResponsedMessage socketResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, socketResponsedMessage) == null) {
            this.a.dispatchResponsedMessage(socketResponsedMessage);
        }
    }

    public final boolean m(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, socketMessage, dupLicateMode)) == null) {
            if (socketMessage != null) {
                int cmd = socketMessage.getCmd();
                int i2 = b.a[dupLicateMode.ordinal()];
                if (i2 == 1) {
                    c.o(this.f1780d, cmd);
                    c.o(this.f1779c, cmd);
                    c.o(this.f1781e, cmd);
                    return false;
                } else if (i2 == 2) {
                    c.o(this.f1780d, cmd);
                    return false;
                } else if (i2 != 3) {
                    return false;
                } else {
                    return c.e(this.f1780d, cmd) || c.e(this.f1779c, cmd) || c.e(this.f1781e, cmd);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public LinkedList<SocketMessage> n(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeL.objValue;
    }

    public boolean o(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, socketMessage)) == null) {
            if (socketMessage == null || !(socketMessage instanceof c.a.d.c.e.c.a)) {
                return false;
            }
            c.a.d.c.e.c.a aVar = (c.a.d.c.e.c.a) socketMessage;
            return c.d(this.f1780d, aVar, socketMessage.getCmd()) || c.d(this.f1779c, aVar, socketMessage.getCmd()) || c.d(this.f1781e, aVar, socketMessage.getCmd());
        }
        return invokeL.booleanValue;
    }

    public final e p(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048599, this, i2, i3)) == null) {
            if (i3 != 0) {
                e p = c.p(i3, this.f1779c);
                if (p == null && (p = c.p(i3, this.f1781e)) == null && (p = c.p(i3, this.f1780d)) == null) {
                    i.a("queue", i2, i3, "findSenderData", h.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                i.a("queue", i2, i3, "findSenderData", h.v, "received ack message");
                return p;
            }
            return null;
        }
        return (e) invokeII.objValue;
    }

    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f1785i : invokeV.longValue;
    }

    public c.a.d.c.e.c.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f1784h : (c.a.d.c.e.c.b) invokeV.objValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? BdAsyncTask.getTaskNum(d.e()) : invokeV.intValue;
    }

    public int t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) ? BdAsyncTask.getTaskNum(String.valueOf(i2), d.e()) : invokeI.intValue;
    }

    public boolean u(int i2, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048604, this, i2, bdUniqueId)) == null) ? c.c(this.f1780d, i2, bdUniqueId) || c.c(this.f1779c, i2, bdUniqueId) || c.c(this.f1781e, i2, bdUniqueId) : invokeIL.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? BdSocketLinkService.isOpen() && !this.f1783g && BdSocketLinkService.isAvailable() : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(e eVar, int i2, String str) {
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048606, this, eVar, i2, str) == null) || eVar == null || eVar.m() == null) {
            return;
        }
        int cmd = eVar.m().getCmd();
        int q = eVar.q();
        i.c("queue", eVar.m(), q, "onMessageSendFail", i2, str + " retryTime-" + eVar.p());
        SocketMessageTask t = eVar != null ? eVar.t() : null;
        if (t == null) {
            t = (SocketMessageTask) this.a.findTask(cmd);
        }
        if (t != null && t.getResponsedClass() != null) {
            try {
                socketResponsedMessage = t.getResponsedClass().newInstance();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                try {
                    socketResponsedMessage = t.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(cmd));
                } catch (Exception e3) {
                    BdLog.e(e3.getMessage());
                }
            }
            if (socketResponsedMessage != null) {
                return;
            }
            socketResponsedMessage.setError(i2);
            if (str == null) {
                socketResponsedMessage.setErrorString(h.i(i2));
            } else {
                socketResponsedMessage.setErrorString(str);
            }
            socketResponsedMessage.setOrginalMessage(eVar.m());
            i.c("queue", eVar.m(), q, "onMessageSendFail", i2, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
            this.a.dispatchResponsedMessage(socketResponsedMessage);
            return;
        }
        socketResponsedMessage = null;
        if (socketResponsedMessage != null) {
        }
    }

    public final void x(d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, bVar) == null) || bVar == null) {
            return;
        }
        e eVar = bVar.f1767b;
        if (eVar != null) {
            w(eVar, h.f1788c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        i.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
        l(socketResponsedMessage);
    }

    public void y(int i2, e eVar) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048608, this, i2, eVar) == null) {
            if (i2 == 2) {
                if (eVar.r() != null) {
                    i3 = eVar.r().getErrorCode();
                } else {
                    i3 = h.f1794i;
                }
            } else {
                i3 = h.n;
            }
            String i4 = h.i(i3);
            D(eVar);
            w(eVar, i3, i4);
        }
    }

    public void z(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, eVar) == null) {
        }
    }
}
