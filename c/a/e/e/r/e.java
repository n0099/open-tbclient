package c.a.e.e.r;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static c.a.e.e.r.b f2568a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface a {
        int a();

        String b();

        long c();

        void close() throws IOException;

        String d();

        String getLocalDns();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* loaded from: classes.dex */
    public static class b implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SocketChannel f2569a;

        /* renamed from: b  reason: collision with root package name */
        public long f2570b;

        /* renamed from: c  reason: collision with root package name */
        public String f2571c;

        /* renamed from: d  reason: collision with root package name */
        public String f2572d;

        /* renamed from: e  reason: collision with root package name */
        public String f2573e;

        public b(String str, int i2, d0 d0Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), d0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2569a = null;
            this.f2570b = 0L;
            this.f2571c = null;
            this.f2572d = null;
            this.f2573e = null;
            this.f2569a = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f2571c = inetSocketAddress.getAddress().getHostAddress();
                this.f2570b = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f2569a.socket().connect(inetSocketAddress, d0Var.e());
            this.f2569a.socket().setSoTimeout(d0Var.f());
            this.f2569a.socket().setTcpNoDelay(d0Var.g());
            this.f2572d = c.a.e.e.p.l.m();
            this.f2573e = c.a.e.e.p.l.n();
        }

        @Override // c.a.e.e.r.e.a
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.e.e.r.e.a
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2573e : (String) invokeV.objValue;
        }

        @Override // c.a.e.e.r.e.a
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2570b : invokeV.longValue;
        }

        @Override // c.a.e.e.r.e.a
        public void close() throws IOException {
            SocketChannel socketChannel;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (socketChannel = this.f2569a) == null) {
                return;
            }
            socketChannel.close();
        }

        @Override // c.a.e.e.r.e.a
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2571c : (String) invokeV.objValue;
        }

        @Override // c.a.e.e.r.e.a
        public String getLocalDns() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2572d : (String) invokeV.objValue;
        }

        @Override // c.a.e.e.r.e.a
        public boolean isConnected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                SocketChannel socketChannel = this.f2569a;
                if (socketChannel != null) {
                    return socketChannel.isConnected();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.e.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) ? this.f2569a.read(byteBuffer) : invokeL.intValue;
        }

        @Override // c.a.e.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer)) == null) ? this.f2569a.write(byteBuffer) : invokeL.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Socket f2574a;

        /* renamed from: b  reason: collision with root package name */
        public InputStream f2575b;

        /* renamed from: c  reason: collision with root package name */
        public OutputStream f2576c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f2577d;

        /* renamed from: e  reason: collision with root package name */
        public long f2578e;

        /* renamed from: f  reason: collision with root package name */
        public String f2579f;

        /* renamed from: g  reason: collision with root package name */
        public String f2580g;

        /* renamed from: h  reason: collision with root package name */
        public String f2581h;

        public c(String str, int i2, d0 d0Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), d0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2574a = null;
            this.f2575b = null;
            this.f2576c = null;
            this.f2577d = null;
            this.f2578e = 0L;
            this.f2579f = null;
            this.f2580g = null;
            this.f2581h = null;
            this.f2574a = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f2579f = inetSocketAddress.getAddress().getHostAddress();
                this.f2578e = System.currentTimeMillis() - currentTimeMillis;
            }
            this.f2574a.connect(inetSocketAddress, d0Var.e());
            this.f2574a.setSoTimeout(d0Var.f());
            this.f2574a.setTcpNoDelay(d0Var.g());
            this.f2575b = this.f2574a.getInputStream();
            this.f2576c = this.f2574a.getOutputStream();
            this.f2577d = new byte[1024];
            this.f2580g = c.a.e.e.p.l.m();
            this.f2581h = c.a.e.e.p.l.n();
        }

        @Override // c.a.e.e.r.e.a
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.e.e.r.e.a
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2581h : (String) invokeV.objValue;
        }

        @Override // c.a.e.e.r.e.a
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2578e : invokeV.longValue;
        }

        @Override // c.a.e.e.r.e.a
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                try {
                    this.f2575b.close();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                try {
                    this.f2576c.close();
                } catch (Exception e3) {
                    BdLog.e(e3.getMessage());
                }
                Socket socket = this.f2574a;
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e4) {
                        throw e4;
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        @Override // c.a.e.e.r.e.a
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2579f : (String) invokeV.objValue;
        }

        @Override // c.a.e.e.r.e.a
        public String getLocalDns() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2580g : (String) invokeV.objValue;
        }

        @Override // c.a.e.e.r.e.a
        public boolean isConnected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Socket socket = this.f2574a;
                if (socket != null) {
                    return socket.isConnected();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.e.e.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) {
                int read = this.f2575b.read(this.f2577d);
                if (read > 0) {
                    byteBuffer.put(this.f2577d, 0, read);
                }
                return read;
            }
            return invokeL.intValue;
        }

        @Override // c.a.e.e.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer)) == null) {
                int remaining = byteBuffer.remaining();
                if (remaining > 0) {
                    byte[] bArr = new byte[remaining];
                    byteBuffer.get(bArr);
                    this.f2576c.write(bArr);
                }
                return remaining;
            }
            return invokeL.intValue;
        }
    }

    public e() {
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

    public a a(String str, int i2, d0 d0Var, boolean z) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), d0Var, Boolean.valueOf(z)})) == null) {
            c.a.e.e.r.b bVar = f2568a;
            if (bVar != null) {
                return bVar.a(str, i2, d0Var);
            }
            if (z) {
                return new b(str, i2, d0Var);
            }
            return new c(str, i2, d0Var);
        }
        return (a) invokeCommon.objValue;
    }
}
