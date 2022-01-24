package c.a.u0.b;

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
    public String f26322b;

    /* renamed from: c  reason: collision with root package name */
    public int f26323c;

    /* renamed from: d  reason: collision with root package name */
    public int f26324d;

    /* renamed from: e  reason: collision with root package name */
    public long f26325e;

    /* renamed from: f  reason: collision with root package name */
    public long f26326f;

    /* renamed from: g  reason: collision with root package name */
    public long f26327g;

    /* renamed from: h  reason: collision with root package name */
    public long f26328h;

    /* renamed from: i  reason: collision with root package name */
    public long f26329i;

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
        this.f26323c = -14;
        this.f26324d = -1;
        this.f26325e = -1L;
        this.f26326f = -1L;
        this.f26327g = -1L;
        this.f26328h = -1L;
        this.f26329i = -1L;
        this.a = str;
        this.f26327g = System.nanoTime() / 1000;
        this.f26326f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (exc instanceof SocketTimeoutException) {
                this.f26323c = -1;
            } else if (exc instanceof UnknownHostException) {
                this.f26323c = -2;
            } else if (exc instanceof ConnectException) {
                this.f26323c = -5;
            } else if (exc instanceof ProtocolException) {
                this.f26323c = -3;
            } else if (exc instanceof BindException) {
                this.f26323c = -4;
            } else if (exc instanceof SSLHandshakeException) {
                this.f26323c = -8;
            } else if (exc instanceof SSLProtocolException) {
                this.f26323c = -9;
            } else if (exc instanceof RemoteException) {
                this.f26323c = -13;
            } else if (exc instanceof NoRouteToHostException) {
                this.f26323c = -6;
            } else if (exc instanceof PortUnreachableException) {
                this.f26323c = -7;
            } else if (exc instanceof SSLKeyException) {
                this.f26323c = -10;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                this.f26323c = -11;
            } else {
                this.f26323c = -14;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26328h = (System.nanoTime() / 1000) - this.f26327g;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26329i = (System.nanoTime() / 1000) - this.f26327g;
        }
    }

    public void d(TurbonetEngine turbonetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, turbonetEngine) == null) {
            String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.a, this.f26322b, Integer.valueOf(this.f26323c), Integer.valueOf(this.f26324d), Long.valueOf(this.f26325e), Long.valueOf(this.f26326f), Long.valueOf(this.f26328h), Long.valueOf(this.f26329i));
            turbonetEngine.g(this.a, this.f26322b, this.f26323c, this.f26324d, this.f26325e, this.f26326f, this.f26328h, this.f26329i);
        }
    }
}
