package c.a.s0.b;

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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f26089b;

    /* renamed from: c  reason: collision with root package name */
    public int f26090c;

    /* renamed from: d  reason: collision with root package name */
    public int f26091d;

    /* renamed from: e  reason: collision with root package name */
    public long f26092e;

    /* renamed from: f  reason: collision with root package name */
    public long f26093f;

    /* renamed from: g  reason: collision with root package name */
    public long f26094g;

    /* renamed from: h  reason: collision with root package name */
    public long f26095h;

    /* renamed from: i  reason: collision with root package name */
    public long f26096i;

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
        this.f26090c = -14;
        this.f26091d = -1;
        this.f26092e = -1L;
        this.f26093f = -1L;
        this.f26094g = -1L;
        this.f26095h = -1L;
        this.f26096i = -1L;
        this.a = str;
        this.f26094g = System.nanoTime() / 1000;
        this.f26093f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (exc instanceof SocketTimeoutException) {
                this.f26090c = -1;
            } else if (exc instanceof UnknownHostException) {
                this.f26090c = -2;
            } else if (exc instanceof ConnectException) {
                this.f26090c = -5;
            } else if (exc instanceof ProtocolException) {
                this.f26090c = -3;
            } else if (exc instanceof BindException) {
                this.f26090c = -4;
            } else if (exc instanceof SSLHandshakeException) {
                this.f26090c = -8;
            } else if (exc instanceof SSLProtocolException) {
                this.f26090c = -9;
            } else if (exc instanceof RemoteException) {
                this.f26090c = -13;
            } else if (exc instanceof NoRouteToHostException) {
                this.f26090c = -6;
            } else if (exc instanceof PortUnreachableException) {
                this.f26090c = -7;
            } else if (exc instanceof SSLKeyException) {
                this.f26090c = -10;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                this.f26090c = -11;
            } else {
                this.f26090c = -14;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26095h = (System.nanoTime() / 1000) - this.f26094g;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26096i = (System.nanoTime() / 1000) - this.f26094g;
        }
    }

    public void d(TurbonetEngine turbonetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, turbonetEngine) == null) {
            String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.a, this.f26089b, Integer.valueOf(this.f26090c), Integer.valueOf(this.f26091d), Long.valueOf(this.f26092e), Long.valueOf(this.f26093f), Long.valueOf(this.f26095h), Long.valueOf(this.f26096i));
            turbonetEngine.g(this.a, this.f26089b, this.f26090c, this.f26091d, this.f26092e, this.f26093f, this.f26095h, this.f26096i);
        }
    }
}
