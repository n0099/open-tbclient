package c.a.d.f.r;

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
    public static c.a.d.f.r.b a;
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
        public SocketChannel a;

        /* renamed from: b  reason: collision with root package name */
        public long f3149b;

        /* renamed from: c  reason: collision with root package name */
        public String f3150c;

        /* renamed from: d  reason: collision with root package name */
        public String f3151d;

        /* renamed from: e  reason: collision with root package name */
        public String f3152e;

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
            this.a = null;
            this.f3149b = 0L;
            this.f3150c = null;
            this.f3151d = null;
            this.f3152e = null;
            this.a = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f3150c = inetSocketAddress.getAddress().getHostAddress();
                this.f3149b = System.currentTimeMillis() - currentTimeMillis;
            }
            this.a.socket().connect(inetSocketAddress, d0Var.e());
            this.a.socket().setSoTimeout(d0Var.f());
            this.a.socket().setTcpNoDelay(d0Var.g());
            this.f3151d = c.a.d.f.p.n.m();
            this.f3152e = c.a.d.f.p.n.n();
        }

        @Override // c.a.d.f.r.e.a
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.r.e.a
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3152e : (String) invokeV.objValue;
        }

        @Override // c.a.d.f.r.e.a
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3149b : invokeV.longValue;
        }

        @Override // c.a.d.f.r.e.a
        public void close() throws IOException {
            SocketChannel socketChannel;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (socketChannel = this.a) == null) {
                return;
            }
            socketChannel.close();
        }

        @Override // c.a.d.f.r.e.a
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3150c : (String) invokeV.objValue;
        }

        @Override // c.a.d.f.r.e.a
        public String getLocalDns() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3151d : (String) invokeV.objValue;
        }

        @Override // c.a.d.f.r.e.a
        public boolean isConnected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                SocketChannel socketChannel = this.a;
                if (socketChannel != null) {
                    return socketChannel.isConnected();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.d.f.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) ? this.a.read(byteBuffer) : invokeL.intValue;
        }

        @Override // c.a.d.f.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer)) == null) ? this.a.write(byteBuffer) : invokeL.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Socket a;

        /* renamed from: b  reason: collision with root package name */
        public InputStream f3153b;

        /* renamed from: c  reason: collision with root package name */
        public OutputStream f3154c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f3155d;

        /* renamed from: e  reason: collision with root package name */
        public long f3156e;

        /* renamed from: f  reason: collision with root package name */
        public String f3157f;

        /* renamed from: g  reason: collision with root package name */
        public String f3158g;

        /* renamed from: h  reason: collision with root package name */
        public String f3159h;

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
            this.a = null;
            this.f3153b = null;
            this.f3154c = null;
            this.f3155d = null;
            this.f3156e = 0L;
            this.f3157f = null;
            this.f3158g = null;
            this.f3159h = null;
            this.a = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
            if (inetSocketAddress.getAddress() != null) {
                this.f3157f = inetSocketAddress.getAddress().getHostAddress();
                this.f3156e = System.currentTimeMillis() - currentTimeMillis;
            }
            this.a.connect(inetSocketAddress, d0Var.e());
            this.a.setSoTimeout(d0Var.f());
            this.a.setTcpNoDelay(d0Var.g());
            this.f3153b = this.a.getInputStream();
            this.f3154c = this.a.getOutputStream();
            this.f3155d = new byte[1024];
            this.f3158g = c.a.d.f.p.n.m();
            this.f3159h = c.a.d.f.p.n.n();
        }

        @Override // c.a.d.f.r.e.a
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.r.e.a
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3159h : (String) invokeV.objValue;
        }

        @Override // c.a.d.f.r.e.a
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3156e : invokeV.longValue;
        }

        @Override // c.a.d.f.r.e.a
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                try {
                    this.f3153b.close();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                try {
                    this.f3154c.close();
                } catch (Exception e3) {
                    BdLog.e(e3.getMessage());
                }
                Socket socket = this.a;
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

        @Override // c.a.d.f.r.e.a
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3157f : (String) invokeV.objValue;
        }

        @Override // c.a.d.f.r.e.a
        public String getLocalDns() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3158g : (String) invokeV.objValue;
        }

        @Override // c.a.d.f.r.e.a
        public boolean isConnected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Socket socket = this.a;
                if (socket != null) {
                    return socket.isConnected();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.d.f.r.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) {
                int read = this.f3153b.read(this.f3155d);
                if (read > 0) {
                    byteBuffer.put(this.f3155d, 0, read);
                }
                return read;
            }
            return invokeL.intValue;
        }

        @Override // c.a.d.f.r.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer)) == null) {
                int remaining = byteBuffer.remaining();
                if (remaining > 0) {
                    byte[] bArr = new byte[remaining];
                    byteBuffer.get(bArr);
                    this.f3154c.write(bArr);
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
            c.a.d.f.r.b bVar = a;
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
