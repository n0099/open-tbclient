package com.baidu.lcp.sdk.connect;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ms;
import com.baidu.tieba.o50;
import com.baidu.tieba.t40;
import com.baidu.tieba.u40;
import com.baidu.tieba.v40;
import com.baidu.tieba.z40;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes3.dex */
public class QuicMessageHandler extends u40 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile QuicMessageHandler q;
    public transient /* synthetic */ FieldHolder $fh;
    public DatagramSocket b;
    public z40 c;
    public e d;
    public LinkedBlockingQueue<byte[]> e;
    public HashMap<Long, byte[]> f;
    public f g;
    public HandlerThread h;
    public Handler i;
    public final AtomicBoolean j;
    public final AtomicBoolean k;
    public boolean l;
    public final Object m;
    public final Object n;
    public HashMap<Long, d> o;
    public IQuicStreamRxDataListener p;

    /* loaded from: classes3.dex */
    public interface IQuicStreamRxDataListener {
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-179316196, "Lcom/baidu/lcp/sdk/connect/QuicMessageHandler;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-179316196, "Lcom/baidu/lcp/sdk/connect/QuicMessageHandler;");
        }
    }

    public native String bdQuicVersion();

    public native int closeQuicheConnect();

    @Override // com.baidu.tieba.u40
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? "quic" : (String) invokeV.objValue;
    }

    public native String getSession();

    public native int initConnect(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str3, boolean z);

    public native boolean quicheConnIsClosed();

    public native boolean quicheConnIsEstablished(boolean z);

    public native int quicheConnOccurError();

    public native void quicheConnOnTimeout();

    public native long[] quicheGetReadyStream();

    public native long[] quicheGetWriteableStream();

    public native long quicheMaxIdleTimeOut();

    public native void quicheReceiveMessageByStream(long j, IQuicStreamRxDataListener iQuicStreamRxDataListener);

    public native long[] quicheSendMessageByStream(byte[] bArr, int i);

    public native long quicheSendMessageByStreamId(long j, byte[] bArr, int i);

    public native String quicheVersion();

    public native void transFormReceiveData(byte[] bArr, int i);

    public native byte[] transFormSendData();

    /* loaded from: classes3.dex */
    public class a implements IQuicStreamRxDataListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(QuicMessageHandler quicMessageHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quicMessageHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QuicMessageHandler a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(QuicMessageHandler quicMessageHandler, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quicMessageHandler, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = quicMessageHandler;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i == 1) {
                    DatagramSocket datagramSocket = (DatagramSocket) message.obj;
                    if (datagramSocket != null && datagramSocket.isConnected()) {
                        o50.b("QuicMessageHandler", "Establish :: UdpSocket receive data Timeout, send again");
                        if (!this.a.k.get()) {
                            synchronized (this.a.n) {
                                this.a.quicheConnOnTimeout();
                            }
                            this.a.H(datagramSocket);
                        }
                    } else {
                        o50.b("QuicMessageHandler", "Establish :: UdpSocket receive data Timeout, but socket unavailable");
                    }
                } else if (i == 2) {
                    if (this.a.N()) {
                        o50.b("QuicMessageHandler", "UDPSocketThread :: UdpSocket receive data Timeout, send again");
                        if (!this.a.j.get()) {
                            synchronized (this.a.n) {
                                this.a.quicheConnOnTimeout();
                            }
                            this.a.J(false);
                        }
                    } else {
                        o50.b("QuicMessageHandler", "UDPSocketThread :: UdpSocket receive data Timeout, but socket closed");
                    }
                }
                if (this.a.E()) {
                    o50.b("QuicMessageHandler", "TimeOut :: quiche connection closed");
                    if (this.a.d != null) {
                        this.a.d.a();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;
        public long b;

        public d(QuicMessageHandler quicMessageHandler, byte[] bArr, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quicMessageHandler, bArr, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bArr;
            this.b = j;
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.lcp.sdk.connect.QuicMessageHandler.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                QuicMessageHandler.z().G();
                this.a.a();
            }
        }

        @Override // com.baidu.lcp.sdk.connect.QuicMessageHandler.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                QuicMessageHandler.z().G();
                this.a.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QuicMessageHandler a;

        public f(QuicMessageHandler quicMessageHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quicMessageHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = quicMessageHandler;
            setName("LCP-UDP-Thread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr;
            DatagramPacket datagramPacket;
            int i;
            long[] jArr;
            long[] jArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    super.run();
                    while (this.a.N() && !this.a.j.get() && !isInterrupted()) {
                        try {
                            bArr = new byte[1500];
                            datagramPacket = new DatagramPacket(bArr, 1500);
                            o50.f("QuicMessageHandler", "UDPSocketThread :: loop UDP Socket receive() blocked method again");
                            this.a.b.receive(datagramPacket);
                            this.a.i.removeMessages(2);
                            o50.f("QuicMessageHandler", " ");
                            o50.a("QuicMessageHandler", "quic Timeout handler remove ");
                            o50.f("QuicMessageHandler", "UDPSocketThread :: notify UDP Socket receive() method");
                        } catch (Exception e) {
                            o50.b("QuicMessageHandler", "UDPSocketThread read io exception = " + e.getMessage());
                            if (!this.a.j.get()) {
                                if (this.a.d != null) {
                                    o50.a("QuicMessageHandler", "connection close for UDPSocketThread read io exception");
                                    this.a.d.a();
                                    return;
                                }
                                return;
                            }
                            synchronized (this.a.m) {
                                this.a.m.notifyAll();
                            }
                        }
                        if (datagramPacket.getData() != null && datagramPacket.getData().length != 0) {
                            int length = datagramPacket.getLength();
                            byte[] copyOf = Arrays.copyOf(bArr, length);
                            synchronized (this.a.n) {
                                if (!this.a.j.get() && copyOf != null && copyOf.length > 0 && length > 0) {
                                    this.a.transFormReceiveData(copyOf, length);
                                    o50.d("QuicMessageHandler", "Receive data size = " + length);
                                }
                            }
                            synchronized (this.a.n) {
                                if (!this.a.j.get()) {
                                    i = this.a.quicheConnOccurError();
                                } else {
                                    i = -1001;
                                }
                            }
                            if (!this.a.j.get() && i != -1001) {
                                o50.b("QuicMessageHandler", "quiche occur connection perr error");
                                if (this.a.d != null) {
                                    if (i == 0) {
                                        o50.a("QuicMessageHandler", "connection should close， connClosedByPerrError");
                                        this.a.d.b();
                                        return;
                                    }
                                    o50.a("QuicMessageHandler", "connection should close for perr occur error, handle it now");
                                    this.a.d.a();
                                    return;
                                }
                                return;
                            } else if (!this.a.j.get() && this.a.E()) {
                                o50.b("QuicMessageHandler", "quiche connection has closed, we did`t catch it, handle it now");
                                if (this.a.d != null) {
                                    o50.a("QuicMessageHandler", "quiche connection has closed, handle it now");
                                    this.a.d.a();
                                    return;
                                }
                                return;
                            } else if (!this.a.j.get() && this.a.D(this.a.l)) {
                                synchronized (this.a.n) {
                                    jArr = null;
                                    if (!this.a.j.get()) {
                                        jArr2 = this.a.quicheGetWriteableStream();
                                    } else {
                                        jArr2 = null;
                                    }
                                }
                                if (jArr2 != null && jArr2.length > 0) {
                                    for (long j : jArr2) {
                                        if (!this.a.j.get() && this.a.B(j)) {
                                            return;
                                        }
                                    }
                                    synchronized (this.a.m) {
                                        this.a.m.notifyAll();
                                        o50.a("QuicMessageHandler", "quiche get handle  writeable streams done, notify");
                                    }
                                } else {
                                    o50.b("QuicMessageHandler", "quiche get writeable [streams].len is 0 ");
                                }
                                synchronized (this.a.n) {
                                    if (!this.a.j.get()) {
                                        jArr = this.a.quicheGetReadyStream();
                                    }
                                }
                                if (jArr != null && jArr.length > 0) {
                                    for (long j2 : jArr) {
                                        synchronized (this.a.n) {
                                            if (!this.a.j.get()) {
                                                this.a.quicheReceiveMessageByStream(j2, this.a.p);
                                            }
                                        }
                                    }
                                } else {
                                    o50.b("QuicMessageHandler", "quiche get gquic_readable [streams].len is 0 ");
                                }
                                if (!this.a.j.get()) {
                                    this.a.J(false);
                                }
                            } else if (!this.a.j.get() && this.a.d != null) {
                                o50.a("QuicMessageHandler", "quiche connection has closed for unEstablished");
                                this.a.d.a();
                                return;
                            } else {
                                return;
                            }
                        }
                        if (!this.a.j.get()) {
                            this.a.J(false);
                        }
                    }
                } catch (Throwable th) {
                    o50.b("QuicMessageHandler", "UDPSocketThread occur exception: " + th.getMessage());
                    if (!this.a.j.get() && this.a.d != null) {
                        o50.a("QuicMessageHandler", "connIsClosed UDPSocketThread occur exception");
                        this.a.d.a();
                        return;
                    }
                    synchronized (this.a.m) {
                        this.a.m.notifyAll();
                    }
                }
            }
        }
    }

    public QuicMessageHandler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new LinkedBlockingQueue<>();
        this.f = new HashMap<>();
        this.j = new AtomicBoolean(false);
        this.k = new AtomicBoolean(false);
        this.l = false;
        this.m = new Object();
        this.n = new Object();
        this.o = new HashMap<>();
        this.p = new a(this);
        HandlerThread handlerThread = new HandlerThread("quick-packet-timeout-thread");
        this.h = handlerThread;
        handlerThread.start();
        this.i = new b(this, this.h.getLooper());
    }

    public final boolean D(boolean z) {
        InterceptResult invokeZ;
        boolean quicheConnIsEstablished;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            synchronized (this.n) {
                quicheConnIsEstablished = quicheConnIsEstablished(z);
            }
            return quicheConnIsEstablished;
        }
        return invokeZ.booleanValue;
    }

    public void K(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.d = eVar;
        }
    }

    @Override // com.baidu.tieba.u40
    public void f(v40 v40Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, v40Var) == null) && (v40Var instanceof z40)) {
            this.c = (z40) v40Var;
        }
    }

    @Override // com.baidu.tieba.u40
    public v40 h(String str, int i) throws SocketException, UnknownHostException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, str, i)) == null) {
            return M(str, i);
        }
        return (v40) invokeLI.objValue;
    }

    public static QuicMessageHandler z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (q == null) {
                synchronized (QuicMessageHandler.class) {
                    if (q == null) {
                        q = new QuicMessageHandler();
                    }
                }
            }
            return q;
        }
        return (QuicMessageHandler) invokeV.objValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return D(this.l);
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        boolean quicheConnIsClosed;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this.n) {
                quicheConnIsClosed = quicheConnIsClosed();
            }
            return quicheConnIsClosed;
        }
        return invokeV.booleanValue;
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            DatagramSocket datagramSocket = this.b;
            if (datagramSocket != null && datagramSocket.isConnected() && C()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u40
    public v40 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.c;
        }
        return (v40) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u40
    public boolean c() {
        InterceptResult invokeV;
        DatagramSocket datagramSocket;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            z40 z40Var = this.c;
            if (z40Var != null && (datagramSocket = z40Var.c) != null && datagramSocket.isConnected() && C()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u40
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return L(this.c);
        }
        return invokeV.booleanValue;
    }

    public final byte[] A(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            byte[] bArr = dVar.a;
            long j = dVar.b;
            int length = (int) (bArr.length - j);
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, (int) j, bArr2, 0, length);
            o50.a("QuicMessageHandler", "getWriteableStreamData  newByte.len " + length);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u40
    public void a(v40 v40Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, v40Var) == null) {
            if (v40Var != null) {
                if (v40Var instanceof z40) {
                    if (((z40) v40Var).c.hashCode() == this.c.c.hashCode()) {
                        o50.e("QuicMessageHandler", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                        return;
                    } else {
                        g();
                        return;
                    }
                }
                return;
            }
            g();
        }
    }

    public final boolean B(long j) throws Exception {
        InterceptResult invokeJ;
        long quicheSendMessageByStreamId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (!this.o.containsKey(Long.valueOf(j))) {
                o50.a("QuicMessageHandler", "handleWriteableStream  partialResponseHashMap not contain streadId " + j);
                return false;
            }
            d dVar = this.o.get(Long.valueOf(j));
            byte[] A = A(dVar);
            int length = A.length;
            if (length <= 0) {
                return false;
            }
            synchronized (this.n) {
                quicheSendMessageByStreamId = quicheSendMessageByStreamId(j, A, length);
            }
            o50.a("QuicMessageHandler", "handleWriteableStream, streamId: " + j + "length: " + length + " sendDataLen " + quicheSendMessageByStreamId);
            if (quicheSendMessageByStreamId > 0) {
                if (quicheSendMessageByStreamId < length) {
                    dVar.b += quicheSendMessageByStreamId;
                    o50.a("QuicMessageHandler", "handleWriteableStream, sendDataLen < length, streamId is " + j + " new wirtten flag is " + dVar.b);
                } else {
                    long j2 = dVar.b + quicheSendMessageByStreamId;
                    int length2 = dVar.a.length;
                    o50.a("QuicMessageHandler", "handleWriteableStream, streamId:" + j + " totalLen is " + j2 + " partialResponse.body.length is " + length2);
                    if (j2 == length2) {
                        dVar.a = null;
                        this.o.remove(Long.valueOf(j));
                    }
                }
                return false;
            } else if (quicheSendMessageByStreamId != -1001) {
                return false;
            } else {
                e eVar = this.d;
                if (eVar != null) {
                    eVar.a();
                    return true;
                }
                throw new IOException("call back method is null");
            }
        }
        return invokeJ.booleanValue;
    }

    public boolean H(DatagramSocket datagramSocket) {
        byte[] transFormSendData;
        long quicheMaxIdleTimeOut;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, datagramSocket)) == null) {
            while (true) {
                if (this.k.get()) {
                    break;
                }
                o50.a("QuicMessageHandler", "Establish :: send init byteCmd start : find package we should send");
                synchronized (this.n) {
                    transFormSendData = transFormSendData();
                }
                if (transFormSendData != null) {
                    o50.d("QuicMessageHandler", "Establish :: Send data size = " + transFormSendData.length);
                    try {
                        DatagramPacket datagramPacket = new DatagramPacket(transFormSendData, transFormSendData.length);
                        if (datagramSocket != null && datagramSocket.isConnected()) {
                            datagramSocket.send(datagramPacket);
                            o50.b("QuicMessageHandler", "UDP Socket send init data success");
                        }
                    } catch (Exception e2) {
                        o50.b("QuicMessageHandler", "UDP Socket send occur error, " + e2.getMessage());
                        return false;
                    }
                } else {
                    o50.f("QuicMessageHandler", "sendByteCmd end: quic have no send data and break loop native method transFormSendData()");
                    o50.f("QuicMessageHandler", " ");
                    synchronized (this.n) {
                        quicheMaxIdleTimeOut = quicheMaxIdleTimeOut();
                    }
                    o50.b("QuicMessageHandler", "UDP Socket sendInitPacket timeOut = " + quicheMaxIdleTimeOut);
                    quicheMaxIdleTimeOut = (quicheMaxIdleTimeOut <= 0 || quicheMaxIdleTimeOut > 10000) ? 10L : 10L;
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = datagramSocket;
                    this.i.sendMessageDelayed(obtain, quicheMaxIdleTimeOut);
                    o50.b("QuicMessageHandler", "UDP Socket sendInitPacket loop end, " + quicheMaxIdleTimeOut);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void J(boolean z) {
        byte[] transFormSendData;
        long quicheMaxIdleTimeOut;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            o50.a("QuicMessageHandler", "sendByteCmd start");
            while (!this.j.get()) {
                o50.a("QuicMessageHandler", "sendByteCmd start : find package we should send");
                synchronized (this.n) {
                    transFormSendData = transFormSendData();
                }
                if (transFormSendData != null) {
                    o50.d("QuicMessageHandler", "Send data size = " + transFormSendData.length);
                    try {
                        DatagramPacket datagramPacket = new DatagramPacket(transFormSendData, transFormSendData.length);
                        if (this.b != null && this.b.isConnected()) {
                            this.b.send(datagramPacket);
                            o50.b("QuicMessageHandler", "UDP Socket send stream data success");
                        } else {
                            o50.b("QuicMessageHandler", "UDP Socket send occur error, mSocket is null or mSocket is closed");
                            if (!this.j.get() || !z) {
                                if (this.d != null) {
                                    o50.a("QuicMessageHandler", "connection close for UDPSocketThread read io exception");
                                    this.d.a();
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        o50.b("QuicMessageHandler", "UDP Socket send occur error, " + e2.getMessage());
                        if (!this.j.get() || !z) {
                            if (this.d != null) {
                                o50.a("QuicMessageHandler", "connection close for UDPSocketThread read io exception");
                                this.d.a();
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    o50.f("QuicMessageHandler", "sendByteCmd end: quic have no send data and break loop native method transFormSendData()");
                    o50.f("QuicMessageHandler", " ");
                    synchronized (this.n) {
                        quicheMaxIdleTimeOut = quicheMaxIdleTimeOut();
                    }
                    o50.b("QuicMessageHandler", "UDP Socket sendPacketCmd timeOut = " + quicheMaxIdleTimeOut);
                    if (quicheMaxIdleTimeOut <= 0) {
                        quicheMaxIdleTimeOut = 10;
                    }
                    this.i.sendEmptyMessageDelayed(2, quicheMaxIdleTimeOut);
                    o50.b("QuicMessageHandler", "UDP Socket sendPacketCmd loop end, " + quicheMaxIdleTimeOut);
                    return;
                }
            }
        }
    }

    public final boolean F(String str, String str2) {
        InterceptResult invokeLL;
        int initConnect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            o50.a("QuicMessageHandler", "quicheInit");
            synchronized (this.n) {
                initConnect = initConnect(str, str2, 150000, 4096, 4096, 20971520, 1310720, 1310720, 1310720, 4096, 4096, null, false);
            }
            if (initConnect < 0) {
                o50.a("QuicMessageHandler", "connIsClosed quicheInit fail");
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Handler handler = this.i;
            if (handler != null) {
                handler.removeMessages(1);
                this.i.removeMessages(2);
            }
            synchronized (this.m) {
                this.m.notifyAll();
                o50.a("QuicMessageHandler", "removeTimeOutCallback, lock.notifyAll();");
            }
            this.e.clear();
            this.f.clear();
            this.o.clear();
        }
    }

    @Override // com.baidu.tieba.u40
    public DataInputStream e() throws EOFException, IOException, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            byte[] take = this.e.take();
            int length = take.length;
            o50.a("QuicMessageHandler", "SocketRead, requestBody size is " + length);
            return new DataInputStream(new ByteArrayInputStream(take));
        }
        return (DataInputStream) invokeV.objValue;
    }

    public long[] I(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr)) == null) {
            long[] jArr = null;
            if (bArr != null && bArr.length > 0) {
                synchronized (this.n) {
                    if (!this.j.get()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        o50.b("QuicMessageHandler", "quicheSendMessageByStream start ");
                        long[] quicheSendMessageByStream = quicheSendMessageByStream(bArr, bArr.length);
                        o50.b("QuicMessageHandler", "quicheSendMessageByStream end,  spend " + (System.currentTimeMillis() - currentTimeMillis) + ms.c);
                        jArr = quicheSendMessageByStream;
                    }
                }
                if (!this.j.get()) {
                    J(false);
                }
            }
            return jArr;
        }
        return (long[]) invokeL.objValue;
    }

    public final boolean L(z40 z40Var) {
        InterceptResult invokeL;
        int closeQuicheConnect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, z40Var)) == null) {
            boolean z = false;
            try {
                o50.a("QuicMessageHandler", "quic socket close start");
                if (this.i != null) {
                    this.i.removeMessages(1);
                    this.i.removeMessages(2);
                }
                this.j.set(true);
                this.k.set(true);
                this.l = false;
                synchronized (this.n) {
                    closeQuicheConnect = closeQuicheConnect();
                    w();
                }
                o50.a("QuicMessageHandler", "quiche connection close result is " + closeQuicheConnect);
                synchronized (this.m) {
                    this.m.notifyAll();
                    o50.a("QuicMessageHandler", "socketClose, lock.notifyAll();");
                }
                z = true;
            } catch (Exception e2) {
                o50.c("QuicMessageHandler", "quic socket close occur exception:", e2);
            }
            this.e.clear();
            this.f.clear();
            this.o.clear();
            return z;
        }
        return invokeL.booleanValue;
    }

    public final v40 M(String str, int i) throws SocketException, UnknownHostException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i)) == null) {
            this.b = y(str, i);
            z40 z40Var = new z40();
            if (this.b == null) {
                return z40Var;
            }
            this.j.set(false);
            f fVar = new f(this);
            this.g = fVar;
            fVar.start();
            z40Var.c = this.b;
            Boolean bool = Boolean.TRUE;
            z40Var.a = bool;
            z40Var.b = bool;
            return z40Var;
        }
        return (v40) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.u40
    public void i(t40 t40Var) throws IOException {
        boolean z;
        DatagramSocket datagramSocket;
        String str;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, t40Var) == null) {
            boolean z2 = true;
            if (t40Var != null && t40Var.a != null && (datagramSocket = this.b) != null && datagramSocket.isConnected() && !E() && C() && !this.j.get()) {
                int length = t40Var.a.length;
                o50.a("QuicMessageHandler", " ");
                o50.a("QuicMessageHandler", "SocketWrite, requestBody size is " + length);
                long[] I = I(t40Var.a);
                StringBuilder sb = new StringBuilder();
                sb.append("SocketWrite, sendMessageByStream ");
                if (I != null) {
                    str = Arrays.toString(I);
                } else {
                    str = StringUtil.NULL_STRING;
                }
                sb.append(str);
                o50.a("QuicMessageHandler", sb.toString());
                if (I != null && I.length >= 2) {
                    long j = I[0];
                    long j2 = I[1];
                    if (j2 >= 0) {
                        if (j2 < length) {
                            this.o.put(Long.valueOf(j), new d(this, t40Var.a, j2));
                            o50.a("QuicMessageHandler", "SocketWrite, sendDataLen < length, streamId is " + j + " sendDataLen is " + j2 + " sendLen is  " + length);
                            synchronized (this.m) {
                                try {
                                    try {
                                        o50.a("QuicMessageHandler", "SocketWrite, lock.wait");
                                        this.m.wait();
                                    } catch (InterruptedException unused) {
                                        throw new IOException("udp socket write lock wait interrupted");
                                    }
                                } finally {
                                }
                            }
                            return;
                        }
                        return;
                    } else if (j2 == -1001 && (eVar = this.d) != null) {
                        eVar.a();
                        return;
                    } else {
                        throw new IOException("udp socket write occur error, code is " + j2);
                    }
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SocketWrite fail ,  mSocket == null is ");
            if (this.b == null) {
                z = true;
            } else {
                z = false;
            }
            sb2.append(z);
            sb2.append("mSocket.isConnected() is ");
            DatagramSocket datagramSocket2 = this.b;
            sb2.append((datagramSocket2 == null || !datagramSocket2.isConnected()) ? false : false);
            o50.a("QuicMessageHandler", sb2.toString());
        }
    }

    public final boolean x(DatagramSocket datagramSocket) {
        InterceptResult invokeL;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, datagramSocket)) == null) {
            o50.a("QuicMessageHandler", "connect establish");
            if (!this.k.get()) {
                z = H(datagramSocket);
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            while (datagramSocket != null && datagramSocket.isConnected() && !this.k.get()) {
                try {
                    byte[] bArr = new byte[1500];
                    DatagramPacket datagramPacket = new DatagramPacket(bArr, 1500);
                    o50.f("QuicMessageHandler", "Establish :: loop UDP Socket receive() blocked method again");
                    datagramSocket.receive(datagramPacket);
                    this.i.removeMessages(1);
                    o50.f("QuicMessageHandler", " ");
                    o50.a("QuicMessageHandler", "Establish :: quic Timeout handler remove ");
                    o50.f("QuicMessageHandler", "Establish :: notify UDP Socket receive() method");
                    if (datagramPacket.getData() != null && datagramPacket.getData().length != 0) {
                        int length = datagramPacket.getLength();
                        byte[] copyOf = Arrays.copyOf(bArr, length);
                        synchronized (this.n) {
                            if (!this.k.get() && copyOf != null && copyOf.length > 0 && length > 0) {
                                transFormReceiveData(copyOf, length);
                                o50.d("QuicMessageHandler", "Receive data size = " + length);
                            }
                        }
                        synchronized (this.n) {
                            if (!this.k.get()) {
                                i = quicheConnOccurError();
                            } else {
                                i = -1001;
                            }
                        }
                        if (i != -1001) {
                            o50.b("QuicMessageHandler", "Establish :: quiche occur connection perr error");
                            return false;
                        } else if (!this.k.get() && E()) {
                            o50.b("QuicMessageHandler", "Establish :: quiche connection has closed, we did`t catch it, handle it now");
                            return false;
                        } else if (!this.k.get() && D(this.l) && !this.l) {
                            o50.f("QuicMessageHandler", "=========== quiche connection Established, happy for success ===========");
                            this.l = true;
                            this.k.getAndSet(true);
                            return true;
                        } else if (!this.k.get()) {
                            H(datagramSocket);
                        }
                    }
                    if (!this.k.get()) {
                        H(datagramSocket);
                    }
                } catch (Exception e2) {
                    o50.b("QuicMessageHandler", "Establish :: read io exception = " + e2.getMessage());
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w() {
        DatagramSocket datagramSocket;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            o50.a("QuicMessageHandler", "closeSocket");
            f fVar = this.g;
            if (fVar != null && fVar.isAlive()) {
                this.g.interrupt();
                this.g = null;
                o50.a("QuicMessageHandler", "mUDPSocketThread.interrupt();");
            }
            z40 z40Var = this.c;
            if (z40Var != null && (datagramSocket = z40Var.c) != null) {
                datagramSocket.close();
                this.c.c.disconnect();
                this.c.c = null;
                o50.a("QuicMessageHandler", "currentSocketState.socket.close() ");
            }
            DatagramSocket datagramSocket2 = this.b;
            if (datagramSocket2 != null) {
                datagramSocket2.close();
                this.b.disconnect();
                this.b = null;
                o50.a("QuicMessageHandler", "mSocket  close()");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
        r7 = r4.getHostAddress();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DatagramSocket y(String str, int i) throws UnknownHostException, SocketException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048618, this, str, i)) == null) {
            synchronized (this.n) {
                w();
            }
            if (str.contains(PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE)) {
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    if (allByName != null && allByName.length > 0) {
                        int length = allByName.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            }
                            InetAddress inetAddress = allByName[i2];
                            if (inetAddress instanceof Inet4Address) {
                                break;
                            }
                            i2++;
                        }
                    }
                } catch (Exception e2) {
                    o50.c("QuicMessageHandler", "resolve host for ip by local dns is fail, ", e2);
                }
            }
            if (!F(str, String.valueOf(i))) {
                return null;
            }
            InetAddress byName = InetAddress.getByName(str);
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.connect(byName, i);
            if (!datagramSocket.isConnected()) {
                o50.a("QuicMessageHandler", "createSocket not connected");
                return null;
            }
            this.k.set(false);
            if (!x(datagramSocket)) {
                o50.a("QuicMessageHandler", "handShark occur error");
                return null;
            }
            return datagramSocket;
        }
        return (DatagramSocket) invokeLI.objValue;
    }
}
