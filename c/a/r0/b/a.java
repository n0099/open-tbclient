package c.a.r0.b;

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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f29716a;

    /* renamed from: b  reason: collision with root package name */
    public String f29717b;

    /* renamed from: c  reason: collision with root package name */
    public int f29718c;

    /* renamed from: d  reason: collision with root package name */
    public int f29719d;

    /* renamed from: e  reason: collision with root package name */
    public long f29720e;

    /* renamed from: f  reason: collision with root package name */
    public long f29721f;

    /* renamed from: g  reason: collision with root package name */
    public long f29722g;

    /* renamed from: h  reason: collision with root package name */
    public long f29723h;

    /* renamed from: i  reason: collision with root package name */
    public long f29724i;

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
        this.f29718c = -14;
        this.f29719d = -1;
        this.f29720e = -1L;
        this.f29721f = -1L;
        this.f29722g = -1L;
        this.f29723h = -1L;
        this.f29724i = -1L;
        this.f29716a = str;
        this.f29722g = System.nanoTime() / 1000;
        this.f29721f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (exc instanceof SocketTimeoutException) {
                this.f29718c = -1;
            } else if (exc instanceof UnknownHostException) {
                this.f29718c = -2;
            } else if (exc instanceof ConnectException) {
                this.f29718c = -5;
            } else if (exc instanceof ProtocolException) {
                this.f29718c = -3;
            } else if (exc instanceof BindException) {
                this.f29718c = -4;
            } else if (exc instanceof SSLHandshakeException) {
                this.f29718c = -8;
            } else if (exc instanceof SSLProtocolException) {
                this.f29718c = -9;
            } else if (exc instanceof RemoteException) {
                this.f29718c = -13;
            } else if (exc instanceof NoRouteToHostException) {
                this.f29718c = -6;
            } else if (exc instanceof PortUnreachableException) {
                this.f29718c = -7;
            } else if (exc instanceof SSLKeyException) {
                this.f29718c = -10;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                this.f29718c = -11;
            } else {
                this.f29718c = -14;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f29723h = (System.nanoTime() / 1000) - this.f29722g;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f29724i = (System.nanoTime() / 1000) - this.f29722g;
        }
    }

    public void d(TurbonetEngine turbonetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, turbonetEngine) == null) {
            String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.f29716a, this.f29717b, Integer.valueOf(this.f29718c), Integer.valueOf(this.f29719d), Long.valueOf(this.f29720e), Long.valueOf(this.f29721f), Long.valueOf(this.f29723h), Long.valueOf(this.f29724i));
            turbonetEngine.g(this.f29716a, this.f29717b, this.f29718c, this.f29719d, this.f29720e, this.f29721f, this.f29723h, this.f29724i);
        }
    }
}
