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
    public d.a f1973b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<e> f1974c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<e> f1975d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedList<e> f1976e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.d.c.e.c.k.a f1977f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1978g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.c.e.c.b f1979h;
    public long i;
    public int j;

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((MessageManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1973b = null;
        this.f1974c = new LinkedList<>();
        this.f1975d = new LinkedList<>();
        this.f1976e = new LinkedList<>();
        this.f1977f = null;
        this.f1978g = true;
        this.f1979h = null;
        this.i = 0L;
        this.j = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.f1973b = new a(this);
    }

    public void A(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
            return;
        }
        if (eVar.v()) {
            eVar.h();
            c.j(this.f1975d, this.f1974c, eVar);
            return;
        }
        c.n(eVar, this.f1975d);
    }

    public void B(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && eVar.i() && eVar.p() < eVar.l()) {
                c.j(this.f1974c, this.f1976e, eVar);
                c.a.d.c.e.c.b bVar = this.f1979h;
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
        c.n(eVar, this.f1974c);
        c.n(eVar, this.f1975d);
        c.n(eVar, this.f1976e);
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
                c.h(eVar, this.f1975d);
                F();
            }
        }
    }

    public final void F() {
        e f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (f2 = c.f(this.f1975d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            i.c("queue", f2.m(), 0, "sendNext", h.r, "");
            BdSocketLinkService.startService(false, "send message");
        } else if (!this.f1978g || f2.n() <= -3) {
            BdSocketLinkService.sendMessage(f2);
        }
    }

    public void G(c.a.d.c.e.c.k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f1977f = aVar;
        }
    }

    public void H(c.a.d.c.e.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f1979h = bVar;
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean z = this.f1978g;
            this.f1978g = false;
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
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (aVar = this.f1977f) == null) {
            return;
        }
        aVar.a(str);
    }

    @Override // c.a.d.c.e.c.k.a
    public boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, str)) == null) {
            c.a.d.c.e.c.k.a aVar = this.f1977f;
            if (aVar != null) {
                aVar.b(i, str);
            }
            c.a.d.c.e.c.b bVar = this.f1979h;
            if (bVar != null) {
                bVar.a();
            }
            if (n.C() && !c.a(this.f1976e) && !c.a(this.f1975d) && !c.a(this.f1974c) && BdSocketLinkService.isAvailable()) {
                c.b(this.f1974c);
                c.i(this.f1975d, this.f1976e);
                c.i(this.f1975d, this.f1974c);
                while (true) {
                    e k = c.k(this.f1975d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    w(k, h.o, null);
                }
                if (c.q(this.f1975d) > 0) {
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
            c.a.d.c.e.c.k.a aVar = this.f1977f;
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
        this.i = System.currentTimeMillis();
        try {
            c.a.d.c.e.c.j.c c2 = c.a.d.c.e.c.j.b.f().c(bArr);
            this.j = 0;
            int b2 = c2.a.b();
            int h2 = c2.a.h();
            i.a("queue", b2, h2, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            e p = p(b2, h2);
            if (p != null) {
                p.m = kVar.f2423b;
                p.n = kVar.f2424c;
            }
            if (this.f1979h != null) {
                if (c2.a.b() == this.f1979h.c() && c.i(this.f1975d, this.f1976e)) {
                    F();
                }
                this.f1979h.e();
            }
            if (h2 == 0 || (p != null && p.k() == b2)) {
                new d(c2, p, this.f1973b, h2).execute(new String[0]);
            } else if (p != null) {
                w(p, h.A, null);
            }
            c.a.d.c.e.c.k.a aVar = this.f1977f;
            if (aVar != null) {
                aVar.d(kVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            int q = c.a.d.f.n.m.a.o().q("alert_protobuf", 2);
            int i = this.j + 1;
            this.j = i;
            if (i >= q) {
                BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
            }
            i.a("queue", 0, 0, "onBinaryMesssage", h.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // c.a.d.c.b
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    @Override // c.a.d.c.e.c.k.a
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, map) == null) {
            f.a().c(map);
            c.a.d.c.e.c.b bVar = this.f1979h;
            if (bVar != null) {
                bVar.e();
            }
            this.f1978g = true;
            i.a("queue", 0, 0, "onConnected", h.y, "Queue blocked");
            c.a.d.c.e.c.k.a aVar = this.f1977f;
            if (aVar != null) {
                aVar.g(map);
            }
        }
    }

    @Override // c.a.d.c.b
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i, bdUniqueId) == null) {
            c.m(this.f1974c, i, bdUniqueId);
            c.m(this.f1975d, i, bdUniqueId);
            c.m(this.f1976e, i, bdUniqueId);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            k(this.f1974c);
            k(this.f1975d);
            k(this.f1976e);
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
                int i = b.a[dupLicateMode.ordinal()];
                if (i == 1) {
                    c.o(this.f1975d, cmd);
                    c.o(this.f1974c, cmd);
                    c.o(this.f1976e, cmd);
                    return false;
                } else if (i == 2) {
                    c.o(this.f1975d, cmd);
                    return false;
                } else if (i != 3) {
                    return false;
                } else {
                    return c.e(this.f1975d, cmd) || c.e(this.f1974c, cmd) || c.e(this.f1976e, cmd);
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
            return c.d(this.f1975d, aVar, socketMessage.getCmd()) || c.d(this.f1974c, aVar, socketMessage.getCmd()) || c.d(this.f1976e, aVar, socketMessage.getCmd());
        }
        return invokeL.booleanValue;
    }

    public final e p(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048599, this, i, i2)) == null) {
            if (i2 != 0) {
                e p = c.p(i2, this.f1974c);
                if (p == null && (p = c.p(i2, this.f1976e)) == null && (p = c.p(i2, this.f1975d)) == null) {
                    i.a("queue", i, i2, "findSenderData", h.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                i.a("queue", i, i2, "findSenderData", h.v, "received ack message");
                return p;
            }
            return null;
        }
        return (e) invokeII.objValue;
    }

    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.i : invokeV.longValue;
    }

    public c.a.d.c.e.c.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f1979h : (c.a.d.c.e.c.b) invokeV.objValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? BdAsyncTask.getTaskNum(d.e()) : invokeV.intValue;
    }

    public int t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) ? BdAsyncTask.getTaskNum(String.valueOf(i), d.e()) : invokeI.intValue;
    }

    public boolean u(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048604, this, i, bdUniqueId)) == null) ? c.c(this.f1975d, i, bdUniqueId) || c.c(this.f1974c, i, bdUniqueId) || c.c(this.f1976e, i, bdUniqueId) : invokeIL.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? BdSocketLinkService.isOpen() && !this.f1978g && BdSocketLinkService.isAvailable() : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048606, this, eVar, i, str) == null) || eVar == null || eVar.m() == null) {
            return;
        }
        int cmd = eVar.m().getCmd();
        int q = eVar.q();
        i.c("queue", eVar.m(), q, "onMessageSendFail", i, str + " retryTime-" + eVar.p());
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
            socketResponsedMessage.setError(i);
            if (str == null) {
                socketResponsedMessage.setErrorString(h.i(i));
            } else {
                socketResponsedMessage.setErrorString(str);
            }
            socketResponsedMessage.setOrginalMessage(eVar.m());
            i.c("queue", eVar.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
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
        e eVar = bVar.f1965b;
        if (eVar != null) {
            w(eVar, h.f1981c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        i.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
        l(socketResponsedMessage);
    }

    public void y(int i, e eVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048608, this, i, eVar) == null) {
            if (i == 2) {
                if (eVar.r() != null) {
                    i2 = eVar.r().getErrorCode();
                } else {
                    i2 = h.i;
                }
            } else {
                i2 = h.n;
            }
            String i3 = h.i(i2);
            D(eVar);
            w(eVar, i2, i3);
        }
    }

    public void z(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, eVar) == null) {
        }
    }
}
