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
    public String f26294b;

    /* renamed from: c  reason: collision with root package name */
    public int f26295c;

    /* renamed from: d  reason: collision with root package name */
    public int f26296d;

    /* renamed from: e  reason: collision with root package name */
    public long f26297e;

    /* renamed from: f  reason: collision with root package name */
    public long f26298f;

    /* renamed from: g  reason: collision with root package name */
    public long f26299g;

    /* renamed from: h  reason: collision with root package name */
    public long f26300h;

    /* renamed from: i  reason: collision with root package name */
    public long f26301i;

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
        this.f26295c = -14;
        this.f26296d = -1;
        this.f26297e = -1L;
        this.f26298f = -1L;
        this.f26299g = -1L;
        this.f26300h = -1L;
        this.f26301i = -1L;
        this.a = str;
        this.f26299g = System.nanoTime() / 1000;
        this.f26298f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (exc instanceof SocketTimeoutException) {
                this.f26295c = -1;
            } else if (exc instanceof UnknownHostException) {
                this.f26295c = -2;
            } else if (exc instanceof ConnectException) {
                this.f26295c = -5;
            } else if (exc instanceof ProtocolException) {
                this.f26295c = -3;
            } else if (exc instanceof BindException) {
                this.f26295c = -4;
            } else if (exc instanceof SSLHandshakeException) {
                this.f26295c = -8;
            } else if (exc instanceof SSLProtocolException) {
                this.f26295c = -9;
            } else if (exc instanceof RemoteException) {
                this.f26295c = -13;
            } else if (exc instanceof NoRouteToHostException) {
                this.f26295c = -6;
            } else if (exc instanceof PortUnreachableException) {
                this.f26295c = -7;
            } else if (exc instanceof SSLKeyException) {
                this.f26295c = -10;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                this.f26295c = -11;
            } else {
                this.f26295c = -14;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26300h = (System.nanoTime() / 1000) - this.f26299g;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26301i = (System.nanoTime() / 1000) - this.f26299g;
        }
    }

    public void d(TurbonetEngine turbonetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, turbonetEngine) == null) {
            String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.a, this.f26294b, Integer.valueOf(this.f26295c), Integer.valueOf(this.f26296d), Long.valueOf(this.f26297e), Long.valueOf(this.f26298f), Long.valueOf(this.f26300h), Long.valueOf(this.f26301i));
            turbonetEngine.g(this.a, this.f26294b, this.f26295c, this.f26296d, this.f26297e, this.f26298f, this.f26300h, this.f26301i);
        }
    }
}
