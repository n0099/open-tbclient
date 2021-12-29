package c.a.r0.j.l0;

import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.tachikoma.core.component.input.ReturnKeyType;
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
/* loaded from: classes6.dex */
public final class g extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f11310e;

    /* renamed from: f  reason: collision with root package name */
    public DatagramSocket f11311f;

    /* renamed from: g  reason: collision with root package name */
    public int f11312g;

    /* renamed from: h  reason: collision with root package name */
    public k f11313h;

    /* renamed from: i  reason: collision with root package name */
    public a f11314i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<JsFunction> f11315j;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList<JsFunction> f11316k;
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
        this.f11310e = "%s:fail %s";
        this.f11313h = new k();
        this.f11314i = new a();
        this.f11315j = new ArrayList<>();
        this.f11316k = new ArrayList<>();
        this.l = new ArrayList<>();
        this.m = new ArrayList<>();
    }

    public final int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11312g : invokeV.intValue;
    }

    public final int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i2 = 49152; i2 <= 65535; i2++) {
                try {
                    this.f11311f = new DatagramSocket(i2);
                    x(i2);
                    return i2;
                } catch (Throwable unused) {
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final DatagramSocket C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11311f : (DatagramSocket) invokeV.objValue;
    }

    public final void D(String method, String error) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, method, error) == null) {
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(error, "error");
            Iterator<JsFunction> it = this.l.iterator();
            while (it.hasNext()) {
                y(it.next(), method, error);
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Iterator<JsFunction> it = this.f11316k.iterator();
            while (it.hasNext()) {
                it.next().call();
            }
        }
    }

    public final c.a.r0.a.y.b.a F(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            c.a.r0.a.y.b.a F = c.a.r0.a.y.b.a.F(jsObject);
            return F != null ? F : new c.a.r0.a.y.b.a();
        }
        return (c.a.r0.a.y.b.a) invokeL.objValue;
    }

    public final void G(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) || j.f11318c.c(this)) {
            return;
        }
        try {
            if (!this.f11313h.a().offer(new b(new DatagramPacket(cVar.b(), cVar.d(), cVar.c(), InetAddress.getByName(cVar.a()), cVar.e()), this))) {
                D(ReturnKeyType.SEND, "send queue is full");
                return;
            }
            if (!this.f11313h.b()) {
                this.f11313h.c(true);
                this.f11313h.start();
            }
            if (this.f11314i.a()) {
                return;
            }
            this.f11314i.b(true);
            this.f11314i.c(this);
            E();
            this.f11314i.start();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public final int bind(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 != -1 && !j.f11318c.d(i2)) {
                try {
                    this.f11311f = new DatagramSocket(i2);
                    x(i2);
                    return i2;
                } catch (Throwable unused) {
                    return B();
                }
            }
            return B();
        }
        return invokeI.intValue;
    }

    @JavascriptInterface
    public final void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                DatagramSocket datagramSocket = this.f11311f;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                this.f11313h.c(false);
                this.f11313h.interrupt();
                this.f11314i.b(false);
                this.f11314i.interrupt();
                j.f11318c.e(this);
                Iterator<JsFunction> it = this.m.iterator();
                while (it.hasNext()) {
                    it.next().call("success");
                }
            } catch (Throwable unused) {
                D(IntentConfig.CLOSE, "close failed");
            }
        }
    }

    @JavascriptInterface
    public final void offCloseCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.m.remove(c.a.r0.j.d.c.a.e(c.a.r0.a.y.b.a.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void offErrorCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.l.remove(c.a.r0.j.d.c.a.e(c.a.r0.a.y.b.a.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void offListeningCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.f11316k.remove(c.a.r0.j.d.c.a.e(c.a.r0.a.y.b.a.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void offMessageCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.f11315j.remove(c.a.r0.j.d.c.a.e(c.a.r0.a.y.b.a.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void onCloseCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            c.a.r0.a.y.b.a F = F(jsObject);
            if (F != null) {
                this.m.add(c.a.r0.j.d.c.a.e(F).a);
            }
        }
    }

    @JavascriptInterface
    public final void onErrorCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            c.a.r0.a.y.b.a F = F(jsObject);
            if (F != null) {
                this.l.add(c.a.r0.j.d.c.a.e(F).a);
            }
        }
    }

    @JavascriptInterface
    public final void onListeningCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.f11316k.add(c.a.r0.j.d.c.a.e(c.a.r0.a.y.b.a.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void onMessageCallback(JsObject jsObject) {
        c.a.r0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            if (j.f11318c.c(this) || (F = F(jsObject)) == null) {
                return;
            }
            this.f11315j.add(c.a.r0.j.d.c.a.e(F).a);
        }
    }

    @JavascriptInterface
    public final void send(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            c.a.r0.a.y.b.a F = c.a.r0.a.y.b.a.F(jsObject);
            c cVar = new c();
            String C = F.C("address", "");
            Intrinsics.checkNotNullExpressionValue(C, "jsObjectMap.optString(PARAM_ADDRESS, \"\")");
            cVar.f(C);
            String B = F.B("message");
            if (B == null || B.length() == 0) {
                byte[] buffer = F.s("message").buffer();
                if (buffer != null) {
                    cVar.h(F.r("length", buffer.length));
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
                D(ReturnKeyType.SEND, "port is empty");
                return;
            }
            if (cVar.a().length() == 0) {
                D(ReturnKeyType.SEND, "address is empty");
            } else {
                G(cVar);
            }
        }
    }

    public final void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            j.f11318c.a(i2);
            this.f11312g = i2;
        }
    }

    public final void y(JsFunction jsFunction, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, jsFunction, str, str2) == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(this.f11310e, Arrays.copyOf(new Object[]{str, str2}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            if (jsFunction != null) {
                jsFunction.call(new d(format));
            }
        }
    }

    public final void z(DatagramPacket dp) {
        byte[] address;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, dp) == null) {
            Intrinsics.checkNotNullParameter(dp, "dp");
            try {
                byte[] bArr = new byte[dp.getLength()];
                System.arraycopy(dp.getData(), dp.getOffset(), bArr, 0, dp.getLength());
                InetAddress address2 = dp.getAddress();
                String str = (address2 == null || (address = address2.getAddress()) == null || address.length != 4) ? "IPv6" : "IPv4";
                Iterator<JsFunction> it = this.f11315j.iterator();
                while (it.hasNext()) {
                    String inetAddress = dp.getAddress().toString();
                    Intrinsics.checkNotNullExpressionValue(inetAddress, "dp.address.toString()");
                    it.next().call(new e(bArr, new f(inetAddress, dp.getLength(), dp.getPort(), str)));
                }
            } catch (Throwable unused) {
                Iterator<JsFunction> it2 = this.l.iterator();
                while (it2.hasNext()) {
                    y(it2.next(), "onMessage", "receive failed");
                }
            }
        }
    }
}
