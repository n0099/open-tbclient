package b.a.e.e.r;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.r.e;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.webSocket.WebSocketException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.SocketException;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class g0 extends Handler {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static long f2122g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Random f2123a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f2124b;

    /* renamed from: c  reason: collision with root package name */
    public final Looper f2125c;

    /* renamed from: d  reason: collision with root package name */
    public final e.a f2126d;

    /* renamed from: e  reason: collision with root package name */
    public final d0 f2127e;

    /* renamed from: f  reason: collision with root package name */
    public final a f2128f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-796999526, "Lb/a/e/e/r/g0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-796999526, "Lb/a/e/e/r/g0;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(Looper looper, Handler handler, e.a aVar, d0 d0Var) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper, handler, aVar, d0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f2123a = new Random();
        this.f2125c = looper;
        this.f2124b = handler;
        this.f2126d = aVar;
        this.f2127e = d0Var;
        this.f2128f = new a(d0Var.b() + 14, 262144);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (g0.class) {
                f2122g = 0L;
            }
        }
    }

    public boolean b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            Message obtainMessage = obtainMessage();
            obtainMessage.obj = obj;
            return sendMessage(obtainMessage);
        }
        return invokeL.booleanValue;
    }

    public long c() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (g0.class) {
                j = f2122g;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? BdBaseApplication.getInst().isDebugMode() : invokeV.booleanValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            byte[] bArr = new byte[16];
            this.f2123a.nextBytes(bArr);
            return b.a.e.e.p.c.j(bArr);
        }
        return (String) invokeV.objValue;
    }

    public final void f(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
            Message obtainMessage = this.f2124b.obtainMessage();
            obtainMessage.obj = obj;
            this.f2124b.sendMessage(obtainMessage);
        }
    }

    public void g(Object obj) throws WebSocketException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            throw new WebSocketException("unknown message received by WebSocketWriter");
        }
    }

    public boolean h(Object obj) throws IOException, WebSocketException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj instanceof s) {
                return o((s) obj);
            }
            if (obj instanceof c0) {
                s((c0) obj);
                return true;
            } else if (obj instanceof w) {
                r((w) obj);
                return true;
            } else if (obj instanceof k) {
                j((k) obj);
                return true;
            } else if (obj instanceof t) {
                p((t) obj);
                return true;
            } else if (obj instanceof u) {
                q((u) obj);
                return true;
            } else if (obj instanceof m) {
                l((m) obj);
                return true;
            } else if (obj instanceof l) {
                k((l) obj);
                return true;
            } else {
                g(obj);
                throw null;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message) == null) {
            try {
                if (message.obj == null) {
                    return;
                }
                c cVar = message.obj instanceof s ? ((s) message.obj).f2163a : null;
                this.f2128f.a();
                if (!h(message.obj)) {
                    f(new x(cVar));
                    return;
                }
                this.f2128f.e();
                if (cVar != null) {
                    f(new b0(cVar));
                }
                while (this.f2128f.g() > 0) {
                    if (this.f2126d == null) {
                        f(new n(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.f2126d.write(this.f2128f.f());
                    if (write > 0) {
                        synchronized (g0.class) {
                            f2122g += write;
                        }
                    }
                }
                if (cVar != null) {
                    f(new q(cVar));
                }
            } catch (SocketException e2) {
                f(new n(e2));
            } catch (Exception e3) {
                if (d()) {
                    e3.printStackTrace();
                }
                f(new p(e3));
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                this.f2125c.quit();
            } catch (Exception unused) {
            }
            try {
                this.f2126d.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void j(k kVar) throws IOException, WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kVar) == null) {
            if (kVar.f2149a.length <= this.f2127e.c()) {
                m(2, true, kVar.f2149a);
                return;
            }
            throw new WebSocketException("message payload exceeds payload limit");
        }
    }

    public final void k(l lVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, lVar) == null) {
            this.f2128f.h("GET " + (lVar.f2154c != null ? lVar.f2153b + "?" + lVar.f2154c : lVar.f2153b) + " HTTP/1.1");
            this.f2128f.c();
            this.f2128f.h("Host: " + lVar.f2152a);
            this.f2128f.c();
            this.f2128f.h("Upgrade: WebSocket");
            this.f2128f.c();
            this.f2128f.h("Connection: Upgrade");
            this.f2128f.c();
            this.f2128f.h("Sec-WebSocket-Key: " + e());
            this.f2128f.c();
            d0 d0Var = this.f2127e;
            if (d0Var != null && d0Var.i() != null && this.f2127e.i().length() > 0) {
                this.f2128f.h("Sec-WebSocket-Extensions: " + this.f2127e.i());
                this.f2128f.c();
            }
            String str = lVar.f2155d;
            if (str != null && !str.equals("")) {
                this.f2128f.h("Origin: " + lVar.f2155d);
                this.f2128f.c();
            }
            String[] strArr = lVar.f2156e;
            if (strArr != null && strArr.length > 0) {
                this.f2128f.h("Sec-WebSocket-Protocol: ");
                int i2 = 0;
                while (true) {
                    String[] strArr2 = lVar.f2156e;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    this.f2128f.h(strArr2[i2]);
                    this.f2128f.h(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    i2++;
                }
                this.f2128f.c();
            }
            this.f2128f.h("Sec-WebSocket-Version: 13");
            this.f2128f.c();
            List<BasicNameValuePair> list = lVar.f2157f;
            if (list != null) {
                for (BasicNameValuePair basicNameValuePair : list) {
                    this.f2128f.h(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                    this.f2128f.c();
                }
            }
            this.f2128f.c();
        }
    }

    public final void l(m mVar) throws IOException, WebSocketException {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, mVar) == null) {
            if (mVar.f2158a > 0) {
                String str = mVar.f2159b;
                if (str == null || str.equals("")) {
                    bArr = new byte[2];
                } else {
                    byte[] bytes = mVar.f2159b.getBytes("UTF-8");
                    bArr = new byte[bytes.length + 2];
                    for (int i2 = 0; i2 < bytes.length; i2++) {
                        bArr[i2 + 2] = bytes[i2];
                    }
                }
                if (bArr.length <= 125) {
                    int i3 = mVar.f2158a;
                    bArr[0] = (byte) ((i3 >> 8) & 255);
                    bArr[1] = (byte) (i3 & 255);
                    m(8, true, bArr);
                    return;
                }
                throw new WebSocketException("close payload exceeds 125 octets");
            }
            m(8, true, null);
        }
    }

    public void m(int i2, boolean z, byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), bArr}) == null) {
            if (bArr != null) {
                n(i2, z, bArr, 0, bArr.length);
            } else {
                n(i2, z, null, 0, 0);
            }
        }
    }

    public void n(int i2, boolean z, byte[] bArr, int i3, int i4) throws IOException {
        int i5;
        byte b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), bArr, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            byte b3 = ByteCompanionObject.MIN_VALUE;
            if (z) {
                b2 = (byte) com.alipay.sdk.encrypt.a.f34123g;
                i5 = i2;
            } else {
                i5 = i2;
                b2 = 0;
            }
            this.f2128f.write((byte) (b2 | ((byte) i5)));
            if (!this.f2127e.a()) {
                b3 = 0;
            }
            long j = i4;
            if (j <= 125) {
                this.f2128f.write((byte) (b3 | ((byte) j)));
            } else if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                this.f2128f.write((byte) (b3 | 126));
                this.f2128f.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (j & 255)});
            } else {
                this.f2128f.write((byte) (b3 | ByteCompanionObject.MAX_VALUE));
                this.f2128f.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (j & 255)});
            }
            if (this.f2127e.a()) {
                this.f2128f.write(0);
                this.f2128f.write(0);
                this.f2128f.write(0);
                this.f2128f.write(0);
            }
            if (j > 0) {
                this.f2127e.a();
                this.f2128f.write(bArr, i3, i4);
            }
        }
    }

    public final boolean o(s sVar) throws IOException, WebSocketException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, sVar)) == null) {
            byte[] e2 = sVar.f2163a.e();
            if (e2 == null) {
                return false;
            }
            if (e2.length <= this.f2127e.c()) {
                m(2, true, e2);
                return true;
            }
            throw new WebSocketException("message payload exceeds payload limit");
        }
        return invokeL.booleanValue;
    }

    public final void p(t tVar) throws IOException, WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tVar) == null) {
            byte[] bArr = tVar.f2164a;
            if (bArr != null && bArr.length > 125) {
                throw new WebSocketException("ping payload exceeds 125 octets");
            }
            m(9, true, tVar.f2164a);
        }
    }

    public final void q(u uVar) throws IOException, WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, uVar) == null) {
            byte[] bArr = uVar.f2165a;
            if (bArr != null && bArr.length > 125) {
                throw new WebSocketException("pong payload exceeds 125 octets");
            }
            m(10, true, uVar.f2165a);
        }
    }

    public final void r(w wVar) throws IOException, WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, wVar) == null) {
            if (wVar.f2167a.length <= this.f2127e.c()) {
                m(1, true, wVar.f2167a);
                return;
            }
            throw new WebSocketException("message payload exceeds payload limit");
        }
    }

    public final void s(c0 c0Var) throws IOException, WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, c0Var) == null) {
            byte[] bytes = c0Var.f2085a.getBytes("UTF-8");
            if (bytes.length <= this.f2127e.c()) {
                m(1, true, bytes);
                return;
            }
            throw new WebSocketException("message payload exceeds payload limit");
        }
    }
}
