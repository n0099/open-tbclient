package b.a.s0.b;

import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.TurbonetEngine;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f28624a;

    /* renamed from: b  reason: collision with root package name */
    public String f28625b;

    /* renamed from: c  reason: collision with root package name */
    public int f28626c;

    /* renamed from: d  reason: collision with root package name */
    public int f28627d;

    /* renamed from: e  reason: collision with root package name */
    public long f28628e;

    /* renamed from: f  reason: collision with root package name */
    public long f28629f;

    /* renamed from: g  reason: collision with root package name */
    public long f28630g;

    /* renamed from: h  reason: collision with root package name */
    public long f28631h;

    /* renamed from: i  reason: collision with root package name */
    public long f28632i;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28626c = -14;
        this.f28627d = -1;
        this.f28628e = -1L;
        this.f28629f = -1L;
        this.f28630g = -1L;
        this.f28631h = -1L;
        this.f28632i = -1L;
        this.f28624a = str;
        this.f28630g = System.nanoTime() / 1000;
        this.f28629f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (exc instanceof SocketTimeoutException) {
                this.f28626c = -1;
            } else if (exc instanceof UnknownHostException) {
                this.f28626c = -2;
            } else if (exc instanceof ConnectException) {
                this.f28626c = -5;
            } else if (exc instanceof ProtocolException) {
                this.f28626c = -3;
            } else if (exc instanceof BindException) {
                this.f28626c = -4;
            } else if (exc instanceof SSLHandshakeException) {
                this.f28626c = -8;
            } else if (exc instanceof SSLProtocolException) {
                this.f28626c = -9;
            } else if (exc instanceof RemoteException) {
                this.f28626c = -13;
            } else if (exc instanceof NoRouteToHostException) {
                this.f28626c = -6;
            } else if (exc instanceof PortUnreachableException) {
                this.f28626c = -7;
            } else if (exc instanceof SSLKeyException) {
                this.f28626c = -10;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                this.f28626c = -11;
            } else {
                this.f28626c = -14;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f28631h = (System.nanoTime() / 1000) - this.f28630g;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f28632i = (System.nanoTime() / 1000) - this.f28630g;
        }
    }

    public void d(TurbonetEngine turbonetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, turbonetEngine) == null) {
            String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.f28624a, this.f28625b, Integer.valueOf(this.f28626c), Integer.valueOf(this.f28627d), Long.valueOf(this.f28628e), Long.valueOf(this.f28629f), Long.valueOf(this.f28631h), Long.valueOf(this.f28632i));
            turbonetEngine.g(this.f28624a, this.f28625b, this.f28626c, this.f28627d, this.f28628e, this.f28629f, this.f28631h, this.f28632i);
        }
    }
}
