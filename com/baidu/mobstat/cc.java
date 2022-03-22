package com.baidu.mobstat;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes4.dex */
public abstract class cc extends bz implements by, Runnable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ boolean f27349c;
    public transient /* synthetic */ FieldHolder $fh;
    public ca a;

    /* renamed from: b  reason: collision with root package name */
    public URI f27350b;

    /* renamed from: d  reason: collision with root package name */
    public Socket f27351d;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f27352e;

    /* renamed from: f  reason: collision with root package name */
    public OutputStream f27353f;

    /* renamed from: g  reason: collision with root package name */
    public Proxy f27354g;

    /* renamed from: h  reason: collision with root package name */
    public Thread f27355h;
    public cd i;
    public Map<String, String> j;
    public CountDownLatch k;
    public CountDownLatch l;
    public int m;

    /* renamed from: com.baidu.mobstat.cc$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cc a;

        public a(cc ccVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ccVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ccVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Thread.currentThread().setName("WebsocketWriteThread");
                while (!Thread.interrupted()) {
                    try {
                        ByteBuffer take = this.a.a.f27345d.take();
                        this.a.f27353f.write(take.array(), 0, take.limit());
                        this.a.f27353f.flush();
                    } catch (IOException unused) {
                        this.a.a.b();
                        return;
                    } catch (InterruptedException unused2) {
                        return;
                    }
                }
            }
        }

        public /* synthetic */ a(cc ccVar, AnonymousClass1 anonymousClass1) {
            this(ccVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581658834, "Lcom/baidu/mobstat/cc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581658834, "Lcom/baidu/mobstat/cc;");
                return;
            }
        }
        f27349c = !cc.class.desiredAssertionStatus();
    }

    public cc(URI uri, cd cdVar, Map<String, String> map, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, cdVar, map, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27350b = null;
        this.a = null;
        this.f27351d = null;
        this.f27354g = Proxy.NO_PROXY;
        this.k = new CountDownLatch(1);
        this.l = new CountDownLatch(1);
        this.m = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (cdVar != null) {
            this.f27350b = uri;
            this.i = cdVar;
            this.j = map;
            this.m = i;
            this.a = new ca(this, cdVar);
            return;
        }
        throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }

    private int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int port = this.f27350b.getPort();
            if (port == -1) {
                String scheme = this.f27350b.getScheme();
                if (scheme.equals("wss")) {
                    return 443;
                }
                if (scheme.equals("ws")) {
                    return 80;
                }
                throw new RuntimeException("unknown scheme: " + scheme);
            }
            return port;
        }
        return invokeV.intValue;
    }

    private void i() throws cj {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            String rawPath = this.f27350b.getRawPath();
            String rawQuery = this.f27350b.getRawQuery();
            rawPath = (rawPath == null || rawPath.length() == 0) ? "/" : "/";
            if (rawQuery != null) {
                rawPath = rawPath + "?" + rawQuery;
            }
            int h2 = h();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f27350b.getHost());
            sb.append(h2 != 80 ? ":" + h2 : "");
            String sb2 = sb.toString();
            cv cvVar = new cv();
            cvVar.a(rawPath);
            cvVar.a("Host", sb2);
            Map<String, String> map = this.j;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    cvVar.a(entry.getKey(), entry.getValue());
                }
            }
            this.a.a((ct) cvVar);
        }
    }

    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
        }
    }

    public abstract void a(int i, String str, boolean z);

    public abstract void a(cz czVar);

    public abstract void a(Exception exc);

    public abstract void a(String str);

    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, byteBuffer) == null) {
        }
    }

    public void b(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // com.baidu.mobstat.cb
    public final void b(by byVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, byVar) == null) {
        }
    }

    public void b(cq cqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cqVar) == null) {
        }
    }

    public boolean c() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b();
            this.k.await();
            return this.a.c();
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f27355h == null) {
            return;
        }
        this.a.a(1000);
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.a.e() : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.a.f() : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.a.d() : invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            try {
                if (this.f27351d == null) {
                    this.f27351d = new Socket(this.f27354g);
                } else if (this.f27351d.isClosed()) {
                    throw new IOException();
                }
                if (!this.f27351d.isBound()) {
                    this.f27351d.connect(new InetSocketAddress(this.f27350b.getHost(), h()), this.m);
                }
                this.f27352e = this.f27351d.getInputStream();
                this.f27353f = this.f27351d.getOutputStream();
                i();
                Thread thread = new Thread(new a(this, null));
                this.f27355h = thread;
                thread.start();
                byte[] bArr = new byte[ca.f27342b];
                while (!g() && !f() && (read = this.f27352e.read(bArr)) != -1) {
                    try {
                        this.a.a(ByteBuffer.wrap(bArr, 0, read));
                    } catch (IOException unused) {
                        this.a.b();
                    } catch (RuntimeException e2) {
                        a(e2);
                        this.a.b(1006, e2.getMessage());
                    }
                }
                this.a.b();
                if (!f27349c && !this.f27351d.isClosed()) {
                    throw new AssertionError();
                }
            } catch (Exception e3) {
                a(this.a, e3);
                this.a.b(-1, e3.getMessage());
            }
        }
    }

    public void a(byte[] bArr) throws NotYetConnectedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bArr) == null) {
            this.a.a(bArr);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f27355h == null) {
                Thread thread = new Thread(this);
                this.f27355h = thread;
                thread.start();
                return;
            }
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
    }

    @Override // com.baidu.mobstat.cb
    public final void a(by byVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byVar, str) == null) {
            a(str);
        }
    }

    @Override // com.baidu.mobstat.cb
    public final void a(by byVar, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, byVar, byteBuffer) == null) {
            a(byteBuffer);
        }
    }

    @Override // com.baidu.mobstat.cb
    public InetSocketAddress c(by byVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, byVar)) == null) {
            Socket socket = this.f27351d;
            if (socket != null) {
                return (InetSocketAddress) socket.getLocalSocketAddress();
            }
            return null;
        }
        return (InetSocketAddress) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.bz, com.baidu.mobstat.cb
    public void a(by byVar, cq cqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, byVar, cqVar) == null) {
            b(cqVar);
        }
    }

    @Override // com.baidu.mobstat.cb
    public final void a(by byVar, cx cxVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, byVar, cxVar) == null) {
            a((cz) cxVar);
            this.k.countDown();
        }
    }

    @Override // com.baidu.mobstat.cb
    public void b(by byVar, int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{byVar, Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            b(i, str, z);
        }
    }

    @Override // com.baidu.mobstat.cb
    public final void a(by byVar, int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{byVar, Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            Thread thread = this.f27355h;
            if (thread != null) {
                thread.interrupt();
            }
            try {
                if (this.f27351d != null) {
                    this.f27351d.close();
                }
            } catch (IOException e2) {
                a(this, e2);
            }
            a(i, str, z);
            this.k.countDown();
            this.l.countDown();
        }
    }

    @Override // com.baidu.mobstat.cb
    public final void a(by byVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, byVar, exc) == null) {
            a(exc);
        }
    }

    @Override // com.baidu.mobstat.cb
    public void a(by byVar, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, byVar, i, str) == null) {
            a(i, str);
        }
    }

    public void a(Socket socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, socket) == null) {
            if (this.f27351d == null) {
                this.f27351d = socket;
                return;
            }
            throw new IllegalStateException("socket has already been set");
        }
    }

    @Override // com.baidu.mobstat.by
    public void a(cq cqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cqVar) == null) {
            this.a.a(cqVar);
        }
    }

    @Override // com.baidu.mobstat.by
    public InetSocketAddress a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.a() : (InetSocketAddress) invokeV.objValue;
    }
}
