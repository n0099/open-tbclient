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
/* loaded from: classes2.dex */
public abstract class ci extends cf implements ce, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public cg a;
    public URI b;
    public Socket d;
    public InputStream e;
    public OutputStream f;
    public Proxy g;
    public Thread h;
    public cj i;
    public Map j;
    public CountDownLatch k;
    public CountDownLatch l;
    public int m;

    /* renamed from: com.baidu.mobstat.ci$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
        }
    }

    public abstract void a(int i, String str, boolean z);

    public abstract void a(df dfVar);

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

    @Override // com.baidu.mobstat.ch
    public final void b(ce ceVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, ceVar) == null) {
        }
    }

    public void b(cw cwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cwVar) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci a;

        public a(ci ciVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ciVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ciVar;
        }

        public /* synthetic */ a(ci ciVar, AnonymousClass1 anonymousClass1) {
            this(ciVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Thread.currentThread().setName("WebsocketWriteThread");
                while (!Thread.interrupted()) {
                    try {
                        ByteBuffer byteBuffer = (ByteBuffer) this.a.a.d.take();
                        this.a.f.write(byteBuffer.array(), 0, byteBuffer.limit());
                        this.a.f.flush();
                    } catch (IOException unused) {
                        this.a.a.b();
                        return;
                    } catch (InterruptedException unused2) {
                        return;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581659020, "Lcom/baidu/mobstat/ci;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581659020, "Lcom/baidu/mobstat/ci;");
                return;
            }
        }
        c = !ci.class.desiredAssertionStatus();
    }

    @Override // com.baidu.mobstat.ce
    public InetSocketAddress a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.a();
        }
        return (InetSocketAddress) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.h == null) {
                Thread thread = new Thread(this);
                this.h = thread;
                thread.start();
                return;
            }
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
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
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.h != null) {
            this.a.a(1000);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.a.e();
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.a.f();
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.a.d();
        }
        return invokeV.booleanValue;
    }

    public ci(URI uri, cj cjVar, Map map, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, cjVar, map, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.a = null;
        this.d = null;
        this.g = Proxy.NO_PROXY;
        this.k = new CountDownLatch(1);
        this.l = new CountDownLatch(1);
        this.m = 0;
        if (uri != null) {
            if (cjVar != null) {
                this.b = uri;
                this.i = cjVar;
                this.j = map;
                this.m = i;
                this.a = new cg(this, cjVar);
                return;
            }
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
        throw new IllegalArgumentException();
    }

    @Override // com.baidu.mobstat.ch
    public InetSocketAddress c(ce ceVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, ceVar)) == null) {
            Socket socket = this.d;
            if (socket != null) {
                return (InetSocketAddress) socket.getLocalSocketAddress();
            }
            return null;
        }
        return (InetSocketAddress) invokeL.objValue;
    }

    private int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int port = this.b.getPort();
            if (port == -1) {
                String scheme = this.b.getScheme();
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

    private void i() throws cp {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            String rawPath = this.b.getRawPath();
            String rawQuery = this.b.getRawQuery();
            rawPath = (rawPath == null || rawPath.length() == 0) ? "/" : "/";
            if (rawQuery != null) {
                rawPath = rawPath + "?" + rawQuery;
            }
            int h = h();
            StringBuilder sb = new StringBuilder();
            sb.append(this.b.getHost());
            if (h != 80) {
                str = ":" + h;
            } else {
                str = "";
            }
            sb.append(str);
            String sb2 = sb.toString();
            db dbVar = new db();
            dbVar.a(rawPath);
            dbVar.a("Host", sb2);
            Map map = this.j;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    dbVar.a((String) entry.getKey(), (String) entry.getValue());
                }
            }
            this.a.a((cz) dbVar);
        }
    }

    @Override // com.baidu.mobstat.ch
    public void a(ce ceVar, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, ceVar, i, str) == null) {
            a(i, str);
        }
    }

    @Override // com.baidu.mobstat.ch
    public final void a(ce ceVar, int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{ceVar, Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            Thread thread = this.h;
            if (thread != null) {
                thread.interrupt();
            }
            try {
                if (this.d != null) {
                    this.d.close();
                }
            } catch (IOException e) {
                a(this, e);
            }
            a(i, str, z);
            this.k.countDown();
            this.l.countDown();
        }
    }

    @Override // com.baidu.mobstat.cf, com.baidu.mobstat.ch
    public void a(ce ceVar, cw cwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, ceVar, cwVar) == null) {
            b(cwVar);
        }
    }

    @Override // com.baidu.mobstat.ch
    public final void a(ce ceVar, dd ddVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, ceVar, ddVar) == null) {
            a((df) ddVar);
            this.k.countDown();
        }
    }

    @Override // com.baidu.mobstat.ch
    public final void a(ce ceVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, ceVar, exc) == null) {
            a(exc);
        }
    }

    @Override // com.baidu.mobstat.ch
    public final void a(ce ceVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ceVar, str) == null) {
            a(str);
        }
    }

    @Override // com.baidu.mobstat.ch
    public final void a(ce ceVar, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, ceVar, byteBuffer) == null) {
            a(byteBuffer);
        }
    }

    @Override // com.baidu.mobstat.ce
    public void a(cw cwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cwVar) == null) {
            this.a.a(cwVar);
        }
    }

    public void a(Socket socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, socket) == null) {
            if (this.d == null) {
                this.d = socket;
                return;
            }
            throw new IllegalStateException("socket has already been set");
        }
    }

    public void a(byte[] bArr) throws NotYetConnectedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bArr) == null) {
            this.a.a(bArr);
        }
    }

    @Override // com.baidu.mobstat.ch
    public void b(ce ceVar, int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{ceVar, Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            b(i, str, z);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            try {
                if (this.d == null) {
                    this.d = new Socket(this.g);
                } else if (this.d.isClosed()) {
                    throw new IOException();
                }
                if (!this.d.isBound()) {
                    this.d.connect(new InetSocketAddress(this.b.getHost(), h()), this.m);
                }
                this.e = this.d.getInputStream();
                this.f = this.d.getOutputStream();
                i();
                Thread thread = new Thread(new a(this, null));
                this.h = thread;
                thread.start();
                byte[] bArr = new byte[cg.b];
                while (!g() && !f() && (read = this.e.read(bArr)) != -1) {
                    try {
                        this.a.a(ByteBuffer.wrap(bArr, 0, read));
                    } catch (IOException unused) {
                        this.a.b();
                    } catch (RuntimeException e) {
                        a(e);
                        this.a.b(1006, e.getMessage());
                    }
                }
                this.a.b();
                if (!c && !this.d.isClosed()) {
                    throw new AssertionError();
                }
            } catch (Exception e2) {
                a(this.a, e2);
                this.a.b(-1, e2.getMessage());
            }
        }
    }
}
