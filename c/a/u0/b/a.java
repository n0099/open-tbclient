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
    public String f27097b;

    /* renamed from: c  reason: collision with root package name */
    public int f27098c;

    /* renamed from: d  reason: collision with root package name */
    public int f27099d;

    /* renamed from: e  reason: collision with root package name */
    public long f27100e;

    /* renamed from: f  reason: collision with root package name */
    public long f27101f;

    /* renamed from: g  reason: collision with root package name */
    public long f27102g;

    /* renamed from: h  reason: collision with root package name */
    public long f27103h;

    /* renamed from: i  reason: collision with root package name */
    public long f27104i;

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
        this.f27098c = -14;
        this.f27099d = -1;
        this.f27100e = -1L;
        this.f27101f = -1L;
        this.f27102g = -1L;
        this.f27103h = -1L;
        this.f27104i = -1L;
        this.a = str;
        this.f27102g = System.nanoTime() / 1000;
        this.f27101f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (exc instanceof SocketTimeoutException) {
                this.f27098c = -1;
            } else if (exc instanceof UnknownHostException) {
                this.f27098c = -2;
            } else if (exc instanceof ConnectException) {
                this.f27098c = -5;
            } else if (exc instanceof ProtocolException) {
                this.f27098c = -3;
            } else if (exc instanceof BindException) {
                this.f27098c = -4;
            } else if (exc instanceof SSLHandshakeException) {
                this.f27098c = -8;
            } else if (exc instanceof SSLProtocolException) {
                this.f27098c = -9;
            } else if (exc instanceof RemoteException) {
                this.f27098c = -13;
            } else if (exc instanceof NoRouteToHostException) {
                this.f27098c = -6;
            } else if (exc instanceof PortUnreachableException) {
                this.f27098c = -7;
            } else if (exc instanceof SSLKeyException) {
                this.f27098c = -10;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                this.f27098c = -11;
            } else {
                this.f27098c = -14;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f27103h = (System.nanoTime() / 1000) - this.f27102g;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f27104i = (System.nanoTime() / 1000) - this.f27102g;
        }
    }

    public void d(TurbonetEngine turbonetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, turbonetEngine) == null) {
            String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.a, this.f27097b, Integer.valueOf(this.f27098c), Integer.valueOf(this.f27099d), Long.valueOf(this.f27100e), Long.valueOf(this.f27101f), Long.valueOf(this.f27103h), Long.valueOf(this.f27104i));
            turbonetEngine.g(this.a, this.f27097b, this.f27098c, this.f27099d, this.f27100e, this.f27101f, this.f27103h, this.f27104i);
        }
    }
}
