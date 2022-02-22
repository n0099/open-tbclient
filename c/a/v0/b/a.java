package c.a.v0.b;

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
    public String f26555b;

    /* renamed from: c  reason: collision with root package name */
    public int f26556c;

    /* renamed from: d  reason: collision with root package name */
    public int f26557d;

    /* renamed from: e  reason: collision with root package name */
    public long f26558e;

    /* renamed from: f  reason: collision with root package name */
    public long f26559f;

    /* renamed from: g  reason: collision with root package name */
    public long f26560g;

    /* renamed from: h  reason: collision with root package name */
    public long f26561h;

    /* renamed from: i  reason: collision with root package name */
    public long f26562i;

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
        this.f26556c = -14;
        this.f26557d = -1;
        this.f26558e = -1L;
        this.f26559f = -1L;
        this.f26560g = -1L;
        this.f26561h = -1L;
        this.f26562i = -1L;
        this.a = str;
        this.f26560g = System.nanoTime() / 1000;
        this.f26559f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (exc instanceof SocketTimeoutException) {
                this.f26556c = -1;
            } else if (exc instanceof UnknownHostException) {
                this.f26556c = -2;
            } else if (exc instanceof ConnectException) {
                this.f26556c = -5;
            } else if (exc instanceof ProtocolException) {
                this.f26556c = -3;
            } else if (exc instanceof BindException) {
                this.f26556c = -4;
            } else if (exc instanceof SSLHandshakeException) {
                this.f26556c = -8;
            } else if (exc instanceof SSLProtocolException) {
                this.f26556c = -9;
            } else if (exc instanceof RemoteException) {
                this.f26556c = -13;
            } else if (exc instanceof NoRouteToHostException) {
                this.f26556c = -6;
            } else if (exc instanceof PortUnreachableException) {
                this.f26556c = -7;
            } else if (exc instanceof SSLKeyException) {
                this.f26556c = -10;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                this.f26556c = -11;
            } else {
                this.f26556c = -14;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26561h = (System.nanoTime() / 1000) - this.f26560g;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26562i = (System.nanoTime() / 1000) - this.f26560g;
        }
    }

    public void d(TurbonetEngine turbonetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, turbonetEngine) == null) {
            String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.a, this.f26555b, Integer.valueOf(this.f26556c), Integer.valueOf(this.f26557d), Long.valueOf(this.f26558e), Long.valueOf(this.f26559f), Long.valueOf(this.f26561h), Long.valueOf(this.f26562i));
            turbonetEngine.g(this.a, this.f26555b, this.f26556c, this.f26557d, this.f26558e, this.f26559f, this.f26561h, this.f26562i);
        }
    }
}
