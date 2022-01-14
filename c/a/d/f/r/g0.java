package c.a.d.f.r;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.r.e;
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
    public static long f3070g;
    public transient /* synthetic */ FieldHolder $fh;
    public final Random a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f3071b;

    /* renamed from: c  reason: collision with root package name */
    public final Looper f3072c;

    /* renamed from: d  reason: collision with root package name */
    public final e.a f3073d;

    /* renamed from: e  reason: collision with root package name */
    public final d0 f3074e;

    /* renamed from: f  reason: collision with root package name */
    public final a f3075f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1604555611, "Lc/a/d/f/r/g0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1604555611, "Lc/a/d/f/r/g0;");
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
        this.a = new Random();
        this.f3072c = looper;
        this.f3071b = handler;
        this.f3073d = aVar;
        this.f3074e = d0Var;
        this.f3075f = new a(d0Var.b() + 14, 262144);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (g0.class) {
                f3070g = 0L;
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
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (g0.class) {
                j2 = f3070g;
            }
            return j2;
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
            this.a.nextBytes(bArr);
            return c.a.d.f.p.e.j(bArr);
        }
        return (String) invokeV.objValue;
    }

    public final void f(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
            Message obtainMessage = this.f3071b.obtainMessage();
            obtainMessage.obj = obj;
            this.f3071b.sendMessage(obtainMessage);
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
                c cVar = message.obj instanceof s ? ((s) message.obj).a : null;
                this.f3075f.a();
                if (!h(message.obj)) {
                    f(new x(cVar));
                    return;
                }
                this.f3075f.e();
                if (cVar != null) {
                    f(new b0(cVar));
                }
                while (this.f3075f.g() > 0) {
                    if (this.f3073d == null) {
                        f(new n(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.f3073d.write(this.f3075f.f());
                    if (write > 0) {
                        synchronized (g0.class) {
                            f3070g += write;
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
                this.f3072c.quit();
            } catch (Exception unused) {
            }
            try {
                this.f3073d.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void j(k kVar) throws IOException, WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kVar) == null) {
            if (kVar.a.length <= this.f3074e.c()) {
                m(2, true, kVar.a);
                return;
            }
            throw new WebSocketException("message payload exceeds payload limit");
        }
    }

    public final void k(l lVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, lVar) == null) {
            this.f3075f.h("GET " + (lVar.f3096c != null ? lVar.f3095b + "?" + lVar.f3096c : lVar.f3095b) + " HTTP/1.1");
            this.f3075f.c();
            this.f3075f.h("Host: " + lVar.a);
            this.f3075f.c();
            this.f3075f.h("Upgrade: WebSocket");
            this.f3075f.c();
            this.f3075f.h("Connection: Upgrade");
            this.f3075f.c();
            this.f3075f.h("Sec-WebSocket-Key: " + e());
            this.f3075f.c();
            d0 d0Var = this.f3074e;
            if (d0Var != null && d0Var.i() != null && this.f3074e.i().length() > 0) {
                this.f3075f.h("Sec-WebSocket-Extensions: " + this.f3074e.i());
                this.f3075f.c();
            }
            String str = lVar.f3097d;
            if (str != null && !str.equals("")) {
                this.f3075f.h("Origin: " + lVar.f3097d);
                this.f3075f.c();
            }
            String[] strArr = lVar.f3098e;
            if (strArr != null && strArr.length > 0) {
                this.f3075f.h("Sec-WebSocket-Protocol: ");
                int i2 = 0;
                while (true) {
                    String[] strArr2 = lVar.f3098e;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    this.f3075f.h(strArr2[i2]);
                    this.f3075f.h(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    i2++;
                }
                this.f3075f.c();
            }
            this.f3075f.h("Sec-WebSocket-Version: 13");
            this.f3075f.c();
            List<BasicNameValuePair> list = lVar.f3099f;
            if (list != null) {
                for (BasicNameValuePair basicNameValuePair : list) {
                    this.f3075f.h(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                    this.f3075f.c();
                }
            }
            this.f3075f.c();
        }
    }

    public final void l(m mVar) throws IOException, WebSocketException {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, mVar) == null) {
            if (mVar.a > 0) {
                String str = mVar.f3100b;
                if (str == null || str.equals("")) {
                    bArr = new byte[2];
                } else {
                    byte[] bytes = mVar.f3100b.getBytes("UTF-8");
                    bArr = new byte[bytes.length + 2];
                    for (int i2 = 0; i2 < bytes.length; i2++) {
                        bArr[i2 + 2] = bytes[i2];
                    }
                }
                if (bArr.length <= 125) {
                    int i3 = mVar.a;
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
            if (z) {
                b2 = (byte) com.alipay.sdk.encrypt.a.f30864g;
                i5 = i2;
            } else {
                i5 = i2;
                b2 = 0;
            }
            this.f3075f.write((byte) (b2 | ((byte) i5)));
            byte b3 = this.f3074e.a() ? Byte.MIN_VALUE : (byte) 0;
            long j2 = i4;
            if (j2 <= 125) {
                this.f3075f.write((byte) (b3 | ((byte) j2)));
            } else if (j2 <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                this.f3075f.write((byte) (b3 | 126));
                this.f3075f.write(new byte[]{(byte) ((j2 >> 8) & 255), (byte) (j2 & 255)});
            } else {
                this.f3075f.write((byte) (b3 | ByteCompanionObject.MAX_VALUE));
                this.f3075f.write(new byte[]{(byte) ((j2 >> 56) & 255), (byte) ((j2 >> 48) & 255), (byte) ((j2 >> 40) & 255), (byte) ((j2 >> 32) & 255), (byte) ((j2 >> 24) & 255), (byte) ((j2 >> 16) & 255), (byte) ((j2 >> 8) & 255), (byte) (j2 & 255)});
            }
            if (this.f3074e.a()) {
                this.f3075f.write(0);
                this.f3075f.write(0);
                this.f3075f.write(0);
                this.f3075f.write(0);
            }
            if (j2 > 0) {
                this.f3074e.a();
                this.f3075f.write(bArr, i3, i4);
            }
        }
    }

    public final boolean o(s sVar) throws IOException, WebSocketException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, sVar)) == null) {
            byte[] e2 = sVar.a.e();
            if (e2 == null) {
                return false;
            }
            if (e2.length <= this.f3074e.c()) {
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
            byte[] bArr = tVar.a;
            if (bArr != null && bArr.length > 125) {
                throw new WebSocketException("ping payload exceeds 125 octets");
            }
            m(9, true, tVar.a);
        }
    }

    public final void q(u uVar) throws IOException, WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, uVar) == null) {
            byte[] bArr = uVar.a;
            if (bArr != null && bArr.length > 125) {
                throw new WebSocketException("pong payload exceeds 125 octets");
            }
            m(10, true, uVar.a);
        }
    }

    public final void r(w wVar) throws IOException, WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, wVar) == null) {
            if (wVar.a.length <= this.f3074e.c()) {
                m(1, true, wVar.a);
                return;
            }
            throw new WebSocketException("message payload exceeds payload limit");
        }
    }

    public final void s(c0 c0Var) throws IOException, WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, c0Var) == null) {
            byte[] bytes = c0Var.a.getBytes("UTF-8");
            if (bytes.length <= this.f3074e.c()) {
                m(1, true, bytes);
                return;
            }
            throw new WebSocketException("message payload exceeds payload limit");
        }
    }
}
