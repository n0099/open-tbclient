package c.a.t0.b;

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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f26473b;

    /* renamed from: c  reason: collision with root package name */
    public int f26474c;

    /* renamed from: d  reason: collision with root package name */
    public int f26475d;

    /* renamed from: e  reason: collision with root package name */
    public long f26476e;

    /* renamed from: f  reason: collision with root package name */
    public long f26477f;

    /* renamed from: g  reason: collision with root package name */
    public long f26478g;

    /* renamed from: h  reason: collision with root package name */
    public long f26479h;

    /* renamed from: i  reason: collision with root package name */
    public long f26480i;

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
        this.f26474c = -14;
        this.f26475d = -1;
        this.f26476e = -1L;
        this.f26477f = -1L;
        this.f26478g = -1L;
        this.f26479h = -1L;
        this.f26480i = -1L;
        this.a = str;
        this.f26478g = System.nanoTime() / 1000;
        this.f26477f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (exc instanceof SocketTimeoutException) {
                this.f26474c = -1;
            } else if (exc instanceof UnknownHostException) {
                this.f26474c = -2;
            } else if (exc instanceof ConnectException) {
                this.f26474c = -5;
            } else if (exc instanceof ProtocolException) {
                this.f26474c = -3;
            } else if (exc instanceof BindException) {
                this.f26474c = -4;
            } else if (exc instanceof SSLHandshakeException) {
                this.f26474c = -8;
            } else if (exc instanceof SSLProtocolException) {
                this.f26474c = -9;
            } else if (exc instanceof RemoteException) {
                this.f26474c = -13;
            } else if (exc instanceof NoRouteToHostException) {
                this.f26474c = -6;
            } else if (exc instanceof PortUnreachableException) {
                this.f26474c = -7;
            } else if (exc instanceof SSLKeyException) {
                this.f26474c = -10;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                this.f26474c = -11;
            } else {
                this.f26474c = -14;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26479h = (System.nanoTime() / 1000) - this.f26478g;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26480i = (System.nanoTime() / 1000) - this.f26478g;
        }
    }

    public void d(TurbonetEngine turbonetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, turbonetEngine) == null) {
            String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.a, this.f26473b, Integer.valueOf(this.f26474c), Integer.valueOf(this.f26475d), Long.valueOf(this.f26476e), Long.valueOf(this.f26477f), Long.valueOf(this.f26479h), Long.valueOf(this.f26480i));
            turbonetEngine.g(this.a, this.f26473b, this.f26474c, this.f26475d, this.f26476e, this.f26477f, this.f26479h, this.f26480i);
        }
    }
}
