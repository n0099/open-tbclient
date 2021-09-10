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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f29849a;

    /* renamed from: b  reason: collision with root package name */
    public String f29850b;

    /* renamed from: c  reason: collision with root package name */
    public int f29851c;

    /* renamed from: d  reason: collision with root package name */
    public int f29852d;

    /* renamed from: e  reason: collision with root package name */
    public long f29853e;

    /* renamed from: f  reason: collision with root package name */
    public long f29854f;

    /* renamed from: g  reason: collision with root package name */
    public long f29855g;

    /* renamed from: h  reason: collision with root package name */
    public long f29856h;

    /* renamed from: i  reason: collision with root package name */
    public long f29857i;

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
        this.f29851c = -14;
        this.f29852d = -1;
        this.f29853e = -1L;
        this.f29854f = -1L;
        this.f29855g = -1L;
        this.f29856h = -1L;
        this.f29857i = -1L;
        this.f29849a = str;
        this.f29855g = System.nanoTime() / 1000;
        this.f29854f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (exc instanceof SocketTimeoutException) {
                this.f29851c = -1;
            } else if (exc instanceof UnknownHostException) {
                this.f29851c = -2;
            } else if (exc instanceof ConnectException) {
                this.f29851c = -5;
            } else if (exc instanceof ProtocolException) {
                this.f29851c = -3;
            } else if (exc instanceof BindException) {
                this.f29851c = -4;
            } else if (exc instanceof SSLHandshakeException) {
                this.f29851c = -8;
            } else if (exc instanceof SSLProtocolException) {
                this.f29851c = -9;
            } else if (exc instanceof RemoteException) {
                this.f29851c = -13;
            } else if (exc instanceof NoRouteToHostException) {
                this.f29851c = -6;
            } else if (exc instanceof PortUnreachableException) {
                this.f29851c = -7;
            } else if (exc instanceof SSLKeyException) {
                this.f29851c = -10;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                this.f29851c = -11;
            } else {
                this.f29851c = -14;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f29856h = (System.nanoTime() / 1000) - this.f29855g;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f29857i = (System.nanoTime() / 1000) - this.f29855g;
        }
    }

    public void d(TurbonetEngine turbonetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, turbonetEngine) == null) {
            String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.f29849a, this.f29850b, Integer.valueOf(this.f29851c), Integer.valueOf(this.f29852d), Long.valueOf(this.f29853e), Long.valueOf(this.f29854f), Long.valueOf(this.f29856h), Long.valueOf(this.f29857i));
            turbonetEngine.g(this.f29849a, this.f29850b, this.f29851c, this.f29852d, this.f29853e, this.f29854f, this.f29856h, this.f29857i);
        }
    }
}
