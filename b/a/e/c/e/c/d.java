package b.a.e.c.e.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, SocketResponsedMessage, SocketResponsedMessage> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f1483f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f1484a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.e.c.e.c.j.c f1485b;

    /* renamed from: c  reason: collision with root package name */
    public e f1486c;

    /* renamed from: d  reason: collision with root package name */
    public int f1487d;

    /* renamed from: e  reason: collision with root package name */
    public SocketMessageTask f1488e;

    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SocketResponsedMessage f1489a;

        /* renamed from: b  reason: collision with root package name */
        public e f1490b;

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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1499867338, "Lb/a/e/c/e/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1499867338, "Lb/a/e/c/e/c/d;");
                return;
            }
        }
        f1483f = BdUniqueId.gen();
    }

    public d(b.a.e.c.e.c.j.c cVar, e eVar, a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, eVar, aVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1484a = null;
        this.f1485b = null;
        this.f1486c = null;
        this.f1487d = 0;
        this.f1488e = null;
        this.f1485b = cVar;
        this.f1486c = eVar;
        this.f1484a = aVar;
        this.f1487d = i2;
        if (eVar != null) {
            try {
                this.f1488e = eVar.t();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f1488e == null) {
            this.f1488e = (SocketMessageTask) MessageManager.getInstance().findTask(this.f1485b.f1530a.b());
        }
        setTag(f1483f);
        setPriority(4);
        SocketMessageTask socketMessageTask = this.f1488e;
        if (socketMessageTask != null) {
            setKey(String.valueOf(socketMessageTask.getCmd()));
            setParallel(this.f1488e.getParallel());
        }
    }

    public static BdUniqueId e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f1483f : (BdUniqueId) invokeV.objValue;
    }

    public final void b(SocketResponsedMessage socketResponsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) || this.f1484a == null) {
            return;
        }
        boolean c2 = c(socketResponsedMessage, this.f1486c);
        b bVar = new b();
        bVar.f1489a = socketResponsedMessage;
        if (!c2) {
            bVar.f1490b = this.f1486c;
        }
        this.f1484a.a(bVar);
    }

    public final boolean c(SocketResponsedMessage socketResponsedMessage, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage, eVar)) == null) {
            if (this.f1487d == 0 || eVar == null || socketResponsedMessage != null) {
                return true;
            }
            i.b("unpacker", eVar.k(), eVar.m() == null ? -1L : eVar.m().getClientLogID(), this.f1487d, "checkresponsedMessage", h.l, "ack cont responsed");
            return false;
        }
        return invokeLL.booleanValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:26:0x0059
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.adp.framework.message.SocketResponsedMessage doInBackground(java.lang.String... r52) {
        /*
            r51 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = b.a.e.c.e.c.d.$ic
            if (r0 != 0) goto L32a
        L4:
            r1 = r51
            java.lang.String r0 = "other"
            b.a.e.c.e.c.j.c r2 = r1.f1485b
            r3 = 0
            if (r2 != 0) goto Le
            return r3
        Le:
            b.a.e.c.e.c.e r5 = r1.f1486c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L289
            r6 = 0
            if (r5 == 0) goto L1f
            b.a.e.c.e.c.e r5 = r1.f1486c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L19
            long r8 = r5.m     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L19
            goto L20
        L19:
            r35 = r0
            r2 = r3
            r0 = 0
            goto L28e
        L1f:
            r8 = r6
        L20:
            b.a.e.c.e.c.e r5 = r1.f1486c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L289
            if (r5 == 0) goto L29
            b.a.e.c.e.c.e r5 = r1.f1486c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L19
            long r10 = r5.n     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L19
            goto L2a
        L29:
            r10 = r6
        L2a:
            long r12 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L289
            b.a.e.c.e.c.j.c r5 = r1.f1485b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L289
            b.a.e.c.e.c.j.a r5 = r5.f1530a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L289
            int r5 = r5.b()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L289
            b.a.e.c.e.c.j.c r14 = r1.f1485b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L284
            b.a.e.c.e.c.j.a r14 = r14.f1530a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L284
            boolean r19 = r14.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L284
            b.a.e.c.e.c.j.c r14 = r1.f1485b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L284
            int r15 = r14.f1533d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L284
            b.a.e.c.e.c.j.b r14 = b.a.e.c.e.c.j.b.f()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L284
            b.a.e.c.e.c.j.c r2 = r1.f1485b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L284
            r14.d(r2)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L284
            long r20 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27f
            r14 = 301001(0x497c9, float:4.21792E-40)
            if (r5 != r14) goto L5e
            java.lang.String r0 = "frs"
        L56:
            r30 = r0
            goto L8f
        L59:
            r35 = r0
            r0 = r5
            goto L28e
        L5e:
            r14 = 302001(0x49bb1, float:4.23194E-40)
            if (r5 != r14) goto L66
            java.lang.String r0 = "pb"
            goto L56
        L66:
            r14 = 309264(0x4b810, float:4.33371E-40)
            if (r5 != r14) goto L6e
            java.lang.String r0 = "home_page"
            goto L56
        L6e:
            r14 = 303011(0x49fa3, float:4.24609E-40)
            if (r5 != r14) goto L76
            java.lang.String r0 = "enter_forum"
            goto L56
        L76:
            r14 = 303012(0x49fa4, float:4.2461E-40)
            if (r5 != r14) goto L7f
            java.lang.String r0 = "user_center"
            goto L56
        L7f:
            r14 = 303002(0x49f9a, float:4.24596E-40)
            if (r5 != r14) goto L87
            java.lang.String r0 = "person_center_post"
            goto L56
        L87:
            r14 = 309647(0x4b98f, float:4.33908E-40)
            if (r5 != r14) goto L56
            java.lang.String r0 = "person_center_dynamic"
            goto L56
        L8f:
            b.a.e.c.e.c.e r0 = r1.f1486c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            if (r0 == 0) goto Ld2
            b.a.e.c.e.c.e r0 = r1.f1486c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcd
            com.baidu.adp.framework.message.SocketMessage r0 = r0.m()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcd
            long r16 = r0.getStartTime()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcd
            b.a.e.c.e.c.e r14 = r1.f1486c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcd
            long r22 = r14.s()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcd
            long r16 = r22 - r16
            long r24 = r12 - r22
            int r14 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r14 <= 0) goto Lbb
            long r26 = r8 - r22
            int r14 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r14 < 0) goto Lb8
            long r6 = r10 - r22
            long r8 = r10 - r8
            long r10 = r12 - r10
            goto Lc1
        Lb8:
            r8 = r6
            r10 = r8
            goto Lbf
        Lbb:
            r8 = r6
            r10 = r8
            r26 = r10
        Lbf:
            r6 = r24
        Lc1:
            long r12 = r20 - r12
            r33 = r8
            r31 = r26
            r8 = r6
            r6 = r16
            r17 = r0
            goto Ldb
        Lcd:
            r0 = r5
        Lce:
            r35 = r30
            goto L28e
        Ld2:
            r17 = r3
            r8 = r6
            r10 = r8
            r12 = r10
            r31 = r12
            r33 = r31
        Ldb:
            int r0 = r2.f1532c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            if (r0 != 0) goto Le6
            int r0 = r2.f1533d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcd
            byte[] r14 = r2.f1531b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcd
            int r14 = r14.length     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcd
            if (r0 == r14) goto Lec
        Le6:
            int r0 = r2.f1533d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            if (r0 > 0) goto Lf0
            r2.f1531b = r3     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcd
        Lec:
            r0 = r3
            r16 = r15
            goto L150
        Lf0:
            b.a.e.c.e.c.j.c r0 = r1.f1485b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            b.a.e.c.e.c.j.a r0 = r0.f1530a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            boolean r0 = r0.e()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            if (r0 == 0) goto L137
            byte[] r0 = r2.f1531b     // Catch: java.lang.Exception -> L12c
            int r14 = r2.f1532c     // Catch: java.lang.Exception -> L12c
            byte r3 = b.a.e.c.e.c.j.a.f1520g     // Catch: java.lang.Exception -> L12c
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0, r14, r3)     // Catch: java.lang.Exception -> L12c
            short r0 = r0.getShort()     // Catch: java.lang.Exception -> L12c
            byte r3 = b.a.e.c.e.c.j.a.f1520g     // Catch: java.lang.Exception -> L12c
            int r3 = r3 + r0
            java.nio.ByteBuffer r14 = java.nio.ByteBuffer.allocateDirect(r0)     // Catch: java.lang.Exception -> L12c
            byte[] r4 = r2.f1531b     // Catch: java.lang.Exception -> L12c
            r16 = r15
            int r15 = r2.f1532c     // Catch: java.lang.Exception -> L12c
            byte r18 = b.a.e.c.e.c.j.a.f1520g     // Catch: java.lang.Exception -> L12c
            int r15 = r15 + r18
            java.nio.ByteBuffer r0 = r14.put(r4, r15, r0)     // Catch: java.lang.Exception -> L12c
            byte[] r0 = r0.array()     // Catch: java.lang.Exception -> L12c
            int r4 = r2.f1532c     // Catch: java.lang.Exception -> L12c
            int r4 = r4 + r3
            r2.f1532c = r4     // Catch: java.lang.Exception -> L12c
            int r4 = r2.f1533d     // Catch: java.lang.Exception -> L12c
            int r4 = r4 - r3
            r2.f1533d = r4     // Catch: java.lang.Exception -> L12c
            goto L13a
        L12c:
            com.baidu.adp.framework.client.socket.coder.CoderException r0 = new com.baidu.adp.framework.client.socket.coder.CoderException     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L134
            int r3 = b.a.e.c.e.c.h.f1514d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L134
            r0.<init>(r3)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L134
            throw r0     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L134
        L134:
            r0 = r5
            goto L27c
        L137:
            r16 = r15
            r0 = 0
        L13a:
            int r3 = r2.f1533d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocateDirect(r3)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            byte[] r4 = r2.f1531b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            int r14 = r2.f1532c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            int r15 = r2.f1533d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            java.nio.ByteBuffer r3 = r3.put(r4, r14, r15)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            byte[] r3 = r3.array()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            r2.f1531b = r3     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
        L150:
            b.a.e.c.e.c.j.b r14 = b.a.e.c.e.c.j.b.f()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            byte[] r3 = r2.f1531b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            com.baidu.adp.framework.task.SocketMessageTask r4 = r1.f1488e     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            r35 = r2
            r2 = r16
            r15 = r5
            r16 = r3
            r18 = r4
            com.baidu.adp.framework.message.SocketResponsedMessage r3 = r14.b(r15, r16, r17, r18, r19)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            if (r3 == 0) goto L19e
            if (r0 == 0) goto L19e
            r3.decodeExtraDataInBackGround(r5, r0)     // Catch: java.lang.Exception -> L16d
            goto L19e
        L16d:
            b.a.e.e.r.h r0 = b.a.e.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L199
            java.lang.String r16 = r0.q()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L199
            r17 = 0
            r18 = 0
            b.a.e.e.r.h r0 = b.a.e.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L199
            long r19 = r0.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L199
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r14 = r30
            r15 = r5
            b.a.e.e.n.l.a.a(r14, r15, r16, r17, r18, r19, r21, r23, r25, r27, r29)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L199
            com.baidu.adp.framework.client.socket.coder.CoderException r0 = new com.baidu.adp.framework.client.socket.coder.CoderException     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L199
            int r2 = b.a.e.c.e.c.h.f1514d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L199
            r0.<init>(r2)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L199
            throw r0     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L199
        L199:
            r0 = r5
            r2 = r35
            goto Lce
        L19e:
            long r14 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L270
            long r14 = r14 - r20
            if (r3 == 0) goto L246
            b.a.e.c.e.c.e r0 = r1.f1486c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L270
            if (r0 == 0) goto L1e9
            b.a.e.c.e.c.j.c r0 = r1.f1485b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e1
            if (r0 == 0) goto L1e9
            long r16 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e1
            b.a.e.c.e.c.e r0 = r1.f1486c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e1
            long r18 = r0.s()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e1
            r36 = r5
            long r4 = r16 - r18
            r3.setCostTime(r4)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e3
            b.a.e.c.e.c.e r0 = r1.f1486c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e3
            int r0 = r0.o()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e3
            r3.setRetry(r0)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e3
            b.a.e.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e3
            r0.f1561a = r6     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e3
            b.a.e.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e3
            r0.f1563c = r8     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e3
            b.a.e.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e3
            r6 = r31
            r0.f1564d = r6     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e3
            b.a.e.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e3
            r4 = r33
            r0.f1565e = r4     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e3
            b.a.e.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e3
            r0.f1568h = r10     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e3
            goto L1ef
        L1e1:
            r36 = r5
        L1e3:
            r2 = r35
            r0 = r36
            goto Lce
        L1e9:
            r36 = r5
            r6 = r31
            r4 = r33
        L1ef:
            r3.setDownSize(r2)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L241
            b.a.e.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L241
            r0.f1567g = r14     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L241
            b.a.e.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L241
            r0.f1566f = r12     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L241
            b.a.e.c.e.c.j.c r0 = r1.f1485b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L241
            b.a.e.c.e.c.j.a r0 = r0.f1530a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L241
            int r0 = r0.h()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L241
            long r10 = (long) r0     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L241
            r3.sequenceID = r10     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L241
            r2 = r35
            byte[] r0 = r2.f1531b     // Catch: java.lang.Exception -> L211
            r10 = r36
            r3.beforeDispatchInBackGround(r10, r0)     // Catch: java.lang.Exception -> L20f
            goto L21b
        L20f:
            r0 = move-exception
            goto L214
        L211:
            r0 = move-exception
            r10 = r36
        L214:
            java.lang.String r0 = r0.getMessage()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L273
            com.baidu.adp.lib.util.BdLog.e(r0)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L273
        L21b:
            b.a.e.e.r.h r0 = b.a.e.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L273
            java.lang.String r16 = r0.q()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L273
            r17 = 1
            r18 = 0
            b.a.e.e.r.h r0 = b.a.e.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L273
            long r19 = r0.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L273
            r29 = 0
            r11 = r14
            r14 = r30
            r15 = r10
            r21 = r8
            r23 = r11
            r25 = r6
            r27 = r4
            b.a.e.e.n.l.a.a(r14, r15, r16, r17, r18, r19, r21, r23, r25, r27, r29)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L273
            goto L26d
        L241:
            r2 = r35
            r10 = r36
            goto L273
        L246:
            r10 = r5
            r2 = r35
            b.a.e.e.r.h r0 = b.a.e.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L273
            java.lang.String r16 = r0.q()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L273
            r17 = 0
            r18 = 0
            b.a.e.e.r.h r0 = b.a.e.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L273
            long r19 = r0.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L273
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r14 = r30
            r15 = r10
            b.a.e.e.n.l.a.a(r14, r15, r16, r17, r18, r19, r21, r23, r25, r27, r29)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L273
        L26d:
            r5 = r10
            goto L306
        L270:
            r10 = r5
            r2 = r35
        L273:
            r0 = r10
            goto Lce
        L276:
            r10 = r5
            r2 = r35
            goto L27b
        L27a:
            r10 = r5
        L27b:
            r0 = r10
        L27c:
            r35 = r30
            goto L28d
        L27f:
            r10 = r5
            r35 = r0
            r0 = r10
            goto L28d
        L284:
            r10 = r5
            r35 = r0
            r0 = r10
            goto L28c
        L289:
            r35 = r0
            r0 = 0
        L28c:
            r2 = 0
        L28d:
            r3 = 0
        L28e:
            r4 = -100
            b.a.e.c.e.c.e r6 = r1.f1486c
            if (r6 == 0) goto L2a4
            com.baidu.adp.framework.message.SocketMessage r6 = r6.m()
            if (r6 == 0) goto L2a4
            b.a.e.c.e.c.e r4 = r1.f1486c
            com.baidu.adp.framework.message.SocketMessage r4 = r4.m()
            long r4 = r4.getClientLogID()
        L2a4:
            r12 = r4
            com.baidu.adp.lib.stats.BdStatisticsManager r6 = com.baidu.adp.lib.stats.BdStatisticsManager.getInstance()
            int r4 = r1.f1487d
            java.lang.String r10 = java.lang.String.valueOf(r4)
            r4 = 4
            java.lang.Object[] r11 = new java.lang.Object[r4]
            java.lang.String r4 = "cmd"
            r5 = 0
            r11[r5] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r5 = 1
            r11[r5] = r4
            r4 = 2
            java.lang.String r5 = "seqid"
            r11[r4] = r5
            r4 = 3
            int r5 = r1.f1487d
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r11[r4] = r5
            java.lang.String r7 = "im"
            r8 = r12
            r6.error(r7, r8, r10, r11)
            int r8 = r1.f1487d
            int r10 = b.a.e.c.e.c.h.k
            java.lang.String r4 = "unpacker"
            java.lang.String r9 = "unpacktask"
            java.lang.String r11 = "onBinaryMesssage decodebody error"
            r5 = r0
            r6 = r12
            b.a.e.c.e.c.i.b(r4, r5, r6, r8, r9, r10, r11)
            b.a.e.e.r.h r4 = b.a.e.e.r.h.j()
            java.lang.String r37 = r4.q()
            r38 = 0
            r39 = 0
            b.a.e.e.r.h r4 = b.a.e.e.r.h.j()
            long r40 = r4.g()
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r36 = r0
            b.a.e.e.n.l.a.a(r35, r36, r37, r38, r39, r40, r42, r44, r46, r48, r50)
        L306:
            if (r3 == 0) goto L30f
            long r6 = java.lang.System.currentTimeMillis()
            r3.setStartTime(r6)
        L30f:
            r4 = 1
            com.baidu.adp.framework.message.SocketResponsedMessage[] r0 = new com.baidu.adp.framework.message.SocketResponsedMessage[r4]
            r4 = 0
            r0[r4] = r3
            r1.publishProgress(r0)
            if (r3 == 0) goto L328
            byte[] r0 = r2.f1531b     // Catch: java.lang.Exception -> L320
            r3.afterDispatchInBackGround(r5, r0)     // Catch: java.lang.Exception -> L320
            goto L328
        L320:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.baidu.adp.lib.util.BdLog.e(r0)
        L328:
            r2 = 0
            return r2
        L32a:
            r49 = r0
            r50 = 1048578(0x100002, float:1.469371E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r49.invokeL(r50, r51, r52)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            com.baidu.adp.framework.message.SocketResponsedMessage r1 = (com.baidu.adp.framework.message.SocketResponsedMessage) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.e.c.e.c.d.doInBackground(java.lang.String[]):com.baidu.adp.framework.message.SocketResponsedMessage");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public void onProgressUpdate(SocketResponsedMessage... socketResponsedMessageArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, socketResponsedMessageArr) == null) {
            if (socketResponsedMessageArr != null && socketResponsedMessageArr.length > 0) {
                b(socketResponsedMessageArr[0]);
            } else {
                b(null);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onCancelled();
            b(null);
        }
    }
}
