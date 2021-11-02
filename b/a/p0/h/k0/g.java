package b.a.p0.h.k0;

import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes4.dex */
public final class g extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f10498e;

    /* renamed from: f  reason: collision with root package name */
    public DatagramSocket f10499f;

    /* renamed from: g  reason: collision with root package name */
    public int f10500g;

    /* renamed from: h  reason: collision with root package name */
    public k f10501h;

    /* renamed from: i  reason: collision with root package name */
    public a f10502i;
    public ArrayList<JsFunction> j;
    public ArrayList<JsFunction> k;
    public ArrayList<JsFunction> l;
    public ArrayList<JsFunction> m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(JSRuntime jsRuntime) {
        super(jsRuntime);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsRuntime};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(jsRuntime, "jsRuntime");
        this.f10498e = "%s:fail %s";
        this.f10501h = new k();
        this.f10502i = new a();
        this.j = new ArrayList<>();
        this.k = new ArrayList<>();
        this.l = new ArrayList<>();
        this.m = new ArrayList<>();
    }

    public final int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            for (int i2 = 49152; i2 <= 65535; i2++) {
                try {
                    this.f10499f = new DatagramSocket(i2);
                    w(i2);
                    return i2;
                } catch (Throwable unused) {
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final DatagramSocket B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10499f : (DatagramSocket) invokeV.objValue;
    }

    public final void C(String method, String error) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, method, error) == null) {
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(error, "error");
            Iterator<JsFunction> it = this.l.iterator();
            while (it.hasNext()) {
                x(it.next(), method, error);
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Iterator<JsFunction> it = this.k.iterator();
            while (it.hasNext()) {
                it.next().call();
            }
        }
    }

    public final b.a.p0.a.y.b.a E(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jsObject)) == null) {
            b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
            return F != null ? F : new b.a.p0.a.y.b.a();
        }
        return (b.a.p0.a.y.b.a) invokeL.objValue;
    }

    public final void F(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || j.f10506c.c(this)) {
            return;
        }
        try {
            if (!this.f10501h.a().offer(new b(new DatagramPacket(cVar.b(), cVar.d(), cVar.c(), InetAddress.getByName(cVar.a()), cVar.e()), this))) {
                C("send", "send queue is full");
                return;
            }
            if (!this.f10501h.b()) {
                this.f10501h.c(true);
                this.f10501h.start();
            }
            if (this.f10502i.a()) {
                return;
            }
            this.f10502i.b(true);
            this.f10502i.c(this);
            D();
            this.f10502i.start();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public final int bind(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 != -1 && !j.f10506c.d(i2)) {
                try {
                    this.f10499f = new DatagramSocket(i2);
                    w(i2);
                    return i2;
                } catch (Throwable unused) {
                    return A();
                }
            }
            return A();
        }
        return invokeI.intValue;
    }

    @JavascriptInterface
    public final void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                DatagramSocket datagramSocket = this.f10499f;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                this.f10501h.c(false);
                this.f10501h.interrupt();
                this.f10502i.b(false);
                this.f10502i.interrupt();
                j.f10506c.e(this);
                Iterator<JsFunction> it = this.m.iterator();
                while (it.hasNext()) {
                    it.next().call("success");
                }
            } catch (Throwable unused) {
                C(IntentConfig.CLOSE, "close failed");
            }
        }
    }

    @JavascriptInterface
    public final void offCloseCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.m.remove(b.a.p0.h.d.c.a.e(b.a.p0.a.y.b.a.F(jsObject)).f10345a);
        }
    }

    @JavascriptInterface
    public final void offErrorCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.l.remove(b.a.p0.h.d.c.a.e(b.a.p0.a.y.b.a.F(jsObject)).f10345a);
        }
    }

    @JavascriptInterface
    public final void offListeningCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.k.remove(b.a.p0.h.d.c.a.e(b.a.p0.a.y.b.a.F(jsObject)).f10345a);
        }
    }

    @JavascriptInterface
    public final void offMessageCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.j.remove(b.a.p0.h.d.c.a.e(b.a.p0.a.y.b.a.F(jsObject)).f10345a);
        }
    }

    @JavascriptInterface
    public final void onCloseCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            b.a.p0.a.y.b.a E = E(jsObject);
            if (E != null) {
                this.m.add(b.a.p0.h.d.c.a.e(E).f10345a);
            }
        }
    }

    @JavascriptInterface
    public final void onErrorCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            b.a.p0.a.y.b.a E = E(jsObject);
            if (E != null) {
                this.l.add(b.a.p0.h.d.c.a.e(E).f10345a);
            }
        }
    }

    @JavascriptInterface
    public final void onListeningCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.k.add(b.a.p0.h.d.c.a.e(b.a.p0.a.y.b.a.F(jsObject)).f10345a);
        }
    }

    @JavascriptInterface
    public final void onMessageCallback(JsObject jsObject) {
        b.a.p0.a.y.b.a E;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            if (j.f10506c.c(this) || (E = E(jsObject)) == null) {
                return;
            }
            this.j.add(b.a.p0.h.d.c.a.e(E).f10345a);
        }
    }

    @JavascriptInterface
    public final void send(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
            c cVar = new c();
            String C = F.C("address", "");
            Intrinsics.checkNotNullExpressionValue(C, "jsObjectMap.optString(PARAM_ADDRESS, \"\")");
            cVar.f(C);
            String B = F.B("message");
            if (B == null || B.length() == 0) {
                byte[] buffer = F.s("message").buffer();
                if (buffer != null) {
                    cVar.h(F.r(CloudStabilityUBCUtils.KEY_LENGTH, buffer.length));
                    cVar.i(F.q("offset"));
                    cVar.g(buffer);
                }
            } else {
                Charset charset = Charsets.UTF_8;
                if (B != null) {
                    byte[] bytes = B.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    cVar.g(bytes);
                    Charset charset2 = Charsets.UTF_8;
                    if (B == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    byte[] bytes2 = B.getBytes(charset2);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                    cVar.h(bytes2.length);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            cVar.j(F.r(ClientCookie.PORT_ATTR, -1));
            if (cVar.e() == -1) {
                C("send", "port is empty");
                return;
            }
            if (cVar.a().length() == 0) {
                C("send", "address is empty");
            } else {
                F(cVar);
            }
        }
    }

    public final void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            j.f10506c.a(i2);
            this.f10500g = i2;
        }
    }

    public final void x(JsFunction jsFunction, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, jsFunction, str, str2) == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(this.f10498e, Arrays.copyOf(new Object[]{str, str2}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            if (jsFunction != null) {
                jsFunction.call(new d(format));
            }
        }
    }

    public final void y(DatagramPacket dp) {
        byte[] address;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dp) == null) {
            Intrinsics.checkNotNullParameter(dp, "dp");
            try {
                byte[] bArr = new byte[dp.getLength()];
                System.arraycopy(dp.getData(), dp.getOffset(), bArr, 0, dp.getLength());
                InetAddress address2 = dp.getAddress();
                String str = (address2 == null || (address = address2.getAddress()) == null || address.length != 4) ? "IPv6" : "IPv4";
                Iterator<JsFunction> it = this.j.iterator();
                while (it.hasNext()) {
                    String inetAddress = dp.getAddress().toString();
                    Intrinsics.checkNotNullExpressionValue(inetAddress, "dp.address.toString()");
                    it.next().call(new e(bArr, new f(inetAddress, dp.getLength(), dp.getPort(), str)));
                }
            } catch (Throwable unused) {
                Iterator<JsFunction> it2 = this.l.iterator();
                while (it2.hasNext()) {
                    x(it2.next(), "onMessage", "receive failed");
                }
            }
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f10500g : invokeV.intValue;
    }
}
