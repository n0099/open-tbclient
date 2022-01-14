package c.a.t0.s1.m;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.collection.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.r.k;
import c.a.s0.s0.i;
import c.a.s0.t.j.h;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import protobuf.NewpushRepair;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static b r;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f22167b;

    /* renamed from: c  reason: collision with root package name */
    public int f22168c;

    /* renamed from: d  reason: collision with root package name */
    public int f22169d;

    /* renamed from: e  reason: collision with root package name */
    public List<GroupUpdateMessage> f22170e;

    /* renamed from: f  reason: collision with root package name */
    public int f22171f;

    /* renamed from: g  reason: collision with root package name */
    public long f22172g;

    /* renamed from: h  reason: collision with root package name */
    public int f22173h;

    /* renamed from: i  reason: collision with root package name */
    public final BdUniqueId f22174i;

    /* renamed from: j  reason: collision with root package name */
    public final Handler f22175j;
    public LongSparseArray<Long> k;
    public LongSparseArray<Long> l;
    public final c.a.d.c.e.c.k.a m;
    public boolean n;
    public final c.a.d.c.g.c o;
    public final CustomMessageListener p;
    public final CustomMessageListener q;

    /* loaded from: classes8.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                c.a.s0.t.j.e.j().m();
                b.l().w();
            }
        }
    }

    /* renamed from: c.a.t0.s1.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1370b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1370b(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                b.l().o();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements c.a.d.c.e.c.k.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.d.c.e.c.k.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.d.c.e.c.k.a
        public boolean b(int i2, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str)) == null) {
                this.a.C();
                return false;
            }
            return invokeIL.booleanValue;
        }

        @Override // c.a.d.c.e.c.k.a
        public void c(c.a.d.f.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            }
        }

        @Override // c.a.d.c.e.c.k.a
        public void d(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) {
            }
        }

        @Override // c.a.d.c.e.c.k.a
        public void g(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
                this.a.B();
                c.a.d.c.e.c.f.a().c(map);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) || socketResponsedMessage == null) {
                return;
            }
            if (socketResponsedMessage.getCmd() == 1003) {
                if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                    this.a.x();
                }
            } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (responseOnlineMessage.getError() != 0) {
                    return;
                }
                this.a.f22170e = responseOnlineMessage.getGroupInfos();
                if (c.a.t0.s1.k.b.o().z()) {
                    this.a.o();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    this.a.D();
                } else {
                    this.a.E();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (this.a.k != null) {
                    this.a.k.clear();
                }
                if (this.a.l != null) {
                    this.a.l.clear();
                }
                this.a.f22170e = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
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

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                int i2 = message.what;
                if (i2 == 2) {
                    b.l().f22175j.removeMessages(2);
                    b.l().u();
                } else if (i2 != 3) {
                } else {
                    b.l().f22175j.removeMessages(3);
                    if (b.l().f22173h == 3) {
                        b.l().t();
                    } else {
                        b.l().u();
                    }
                    b.l().f22175j.sendMessageDelayed(b.l().f22175j.obtainMessage(3), b.l().f22168c);
                }
            }
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1165415073, "Lc/a/t0/s1/m/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1165415073, "Lc/a/t0/s1/m/b;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2008017));
        MessageManager.getInstance().registerListener(new C1370b(2016002));
        r = null;
    }

    public b() {
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
        this.a = 900000;
        this.f22167b = 360000;
        this.f22168c = 360000;
        this.f22169d = 0;
        this.f22171f = 0;
        this.f22172g = 0L;
        this.f22173h = 0;
        this.f22174i = BdUniqueId.gen();
        this.f22175j = new g(null);
        this.k = null;
        this.l = null;
        this.m = new c(this);
        this.o = new d(this, 0);
        this.p = new e(this, 2001011);
        this.q = new f(this, 2005016);
    }

    public static synchronized b l() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (b.class) {
                if (r == null) {
                    r = new b();
                }
                bVar = r;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 == 1) {
                if (this.f22169d != 2) {
                    this.f22169d = 1;
                }
            } else if (i2 == 3 || i2 == 2) {
                this.f22169d = 2;
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            j();
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j();
            i();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l().f22168c = l().a;
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f22168c = this.f22167b;
        }
    }

    public final void h() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (i2 = this.f22169d) == 0) {
            return;
        }
        if (i2 == 1) {
            r(0L, 0L, 0L);
        } else {
            u();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f22175j.removeMessages(3);
            this.f22175j.removeMessages(2);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f22169d = 0;
        }
    }

    public final MessageSyncMessage k(LongSparseArray<Long> longSparseArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, longSparseArray, i2)) == null) {
            MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
            messageSyncMessage.setTag(this.f22174i);
            if (longSparseArray != null && longSparseArray.size() > 0) {
                messageSyncMessage.setGroupMids(longSparseArray);
                NewpushRepair makeNewpushRepair = MessageUtils.makeNewpushRepair(longSparseArray);
                if (makeNewpushRepair != null) {
                    messageSyncMessage.setNewpushRepire(makeNewpushRepair);
                }
            } else {
                messageSyncMessage.setGroupMids(c.a.t0.s1.k.b.o().r());
            }
            messageSyncMessage.setForTimer(this.n);
            LocalViewSize.ImageSize msgBPicMaxSize = LocalViewSize.getInstance().getMsgBPicMaxSize();
            if (msgBPicMaxSize != null) {
                messageSyncMessage.setWidth(msgBPicMaxSize.width);
                messageSyncMessage.setHeight(msgBPicMaxSize.height);
            }
            LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.getInstance().getMsgSPicMaxSize();
            if (msgSPicMaxSize != null) {
                messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
                messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
            }
            messageSyncMessage.setSyncTypeString(String.valueOf(i2));
            return messageSyncMessage;
        }
        return (MessageSyncMessage) invokeLI.objValue;
    }

    public void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            if (context != null) {
                MessageManager.getInstance().registerListener(this.p);
                MessageManager.getInstance().registerListener(this.q);
                h.j().p(this.m);
                MessageManager.getInstance().registerListener(1003, this.o);
                MessageManager.getInstance().registerListener(1001, this.o);
                MessageManager.getInstance().registerListener(202101, this.o);
                w();
                return;
            }
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f22170e == null) {
            return;
        }
        boolean z = false;
        LongSparseArray<Long> r2 = c.a.t0.s1.k.b.o().r();
        if (r2 == null) {
            this.f22170e = null;
            return;
        }
        Iterator<GroupUpdateMessage> it = this.f22170e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            GroupUpdateMessage next = it.next();
            if (next != null && r2.get(next.getGroupId()) != null) {
                if (r2.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                    z = true;
                    break;
                }
            }
        }
        this.f22173h = 3;
        if (z) {
            Handler handler = this.f22175j;
            handler.sendMessage(handler.obtainMessage(3));
        } else {
            l().f22175j.sendMessageDelayed(l().f22175j.obtainMessage(3), l().f22168c);
        }
        this.f22170e = null;
    }

    public final void p(LongSparseArray<Long> longSparseArray, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, longSparseArray, i2) == null) {
            if (MessageManager.getInstance().getSocketClient().s() > 10) {
                i.b(false, true, false);
                Handler handler = this.f22175j;
                handler.sendMessageDelayed(handler.obtainMessage(2), 2000L);
                return;
            }
            boolean u = MessageManager.getInstance().getSocketClient().u(202003, this.f22174i);
            int t = MessageManager.getInstance().getSocketClient().t(202003);
            if (!u && t <= 0) {
                j();
                LongSparseArray<Long> longSparseArray2 = null;
                if (longSparseArray != null && longSparseArray.size() > 0) {
                    longSparseArray2 = new LongSparseArray<>();
                    for (int i3 = 0; i3 < longSparseArray.size(); i3++) {
                        long keyAt = longSparseArray.keyAt(i3);
                        longSparseArray2.put(keyAt, Long.valueOf(longSparseArray.get(keyAt).longValue()));
                    }
                }
                MessageSyncMessage k = k(longSparseArray2, i2);
                if (i2 == 3 || i2 == 2) {
                    k.setNewpushRepire(c.a.t0.s1.k.b.o().s());
                }
                MessageManager.getInstance().sendMessage(k);
                i.b(true, false, false);
                if (i2 == 3 || i2 == 1 || i2 == 2) {
                    LongSparseArray<Long> longSparseArray3 = this.k;
                    if (longSparseArray3 != null) {
                        longSparseArray3.clear();
                    }
                    LongSparseArray<Long> longSparseArray4 = this.l;
                    if (longSparseArray4 != null) {
                        longSparseArray4.clear();
                        return;
                    }
                    return;
                }
                return;
            }
            i.b(false, false, true);
            A(i2);
        }
    }

    public synchronized void q(LongSparseArray<Long> longSparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, longSparseArray) == null) {
            synchronized (this) {
                if (longSparseArray != null) {
                    if (longSparseArray.size() != 0) {
                        this.n = false;
                        this.f22173h = 4;
                        this.f22175j.removeMessages(3);
                        l().f22175j.sendMessageDelayed(l().f22175j.obtainMessage(3), l().f22168c);
                        p(longSparseArray, 4);
                    }
                }
            }
        }
    }

    public void r(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            s(j2, j3, j4, false);
        }
    }

    public synchronized void s(long j2, long j3, long j4, boolean z) {
        long longValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                this.f22171f++;
                this.n = false;
                this.f22173h = 1;
                this.f22175j.removeMessages(3);
                l().f22175j.sendMessageDelayed(l().f22175j.obtainMessage(3), l().f22168c);
                if (this.k == null) {
                    LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
                    this.k = longSparseArray;
                    longSparseArray.clear();
                }
                if (this.l == null) {
                    this.l = new LongSparseArray<>();
                }
                LongSparseArray<Long> r2 = c.a.t0.s1.k.b.o().r();
                if (0 != j2) {
                    Long l = r2.get(j2);
                    Long l2 = this.k.get(j2);
                    if (l == null) {
                        longValue = (l2 != null && l2.longValue() < j3) ? l2.longValue() : j3;
                    } else {
                        longValue = l.longValue();
                    }
                    if (longValue > 0) {
                        this.k.put(j2, Long.valueOf(longValue));
                    }
                }
                if (this.k != null && this.k.size() > 0) {
                    for (int i2 = 0; i2 < this.k.size(); i2++) {
                        long keyAt = this.k.keyAt(i2);
                        Long l3 = r2.get(keyAt);
                        if (l3 != null && l3.longValue() > 0) {
                            this.k.put(keyAt, l3);
                        }
                    }
                }
                if (!z) {
                    if (j2 > 0 && j3 > 0) {
                        if (this.l.get(j2) == null) {
                            this.l.put(j2, Long.valueOf(j3));
                        } else {
                            long longValue2 = this.l.get(j2).longValue();
                            if (longValue2 <= j3) {
                                longValue2 = j3;
                            }
                            this.l.put(j2, Long.valueOf(longValue2));
                        }
                    }
                    int size = this.k.size();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < size; i3++) {
                        long keyAt2 = this.k.keyAt(i3);
                        if (this.k.valueAt(i3).longValue() >= (this.l.get(keyAt2) != null ? this.l.get(keyAt2).longValue() : 0L)) {
                            arrayList.add(Long.valueOf(j2));
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        this.k.remove(((Long) it.next()).longValue());
                    }
                }
                if (this.k.size() == 0) {
                    j();
                    this.l.clear();
                    return;
                }
                p(this.k, 1);
            }
        }
    }

    public synchronized void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                v(3);
            }
        }
    }

    public synchronized void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this) {
                v(2);
            }
        }
    }

    public final synchronized void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            synchronized (this) {
                this.n = true;
                this.f22173h = i2;
                p(null, i2);
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
            if (socketGetMsgStratgy.length == 2) {
                z(socketGetMsgStratgy[0] * 1000);
                y(socketGetMsgStratgy[1] * 1000);
            }
        }
    }

    public final synchronized void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.f22172g < 180000) {
                    return;
                }
                PushCountMessage pushCountMessage = new PushCountMessage();
                pushCountMessage.setPusherCount(this.f22171f);
                pushCountMessage.setUpFlowSize(c.a.d.f.r.h.j().p());
                pushCountMessage.setDownFlowSize(c.a.d.f.r.h.j().i());
                pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
                MessageManager.getInstance().sendMessage(pushCountMessage);
                this.f22172g = System.currentTimeMillis();
                this.f22171f = 0;
                c.a.d.f.r.h.j().d();
                c.a.d.f.r.h.j().e();
                TbadkCoreApplication.getInst().clearEnterForeCount();
            }
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.a = i2;
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f22167b = i2;
    }
}
