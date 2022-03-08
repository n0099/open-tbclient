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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f25865b;

    /* renamed from: c  reason: collision with root package name */
    public int f25866c;

    /* renamed from: d  reason: collision with root package name */
    public int f25867d;

    /* renamed from: e  reason: collision with root package name */
    public long f25868e;

    /* renamed from: f  reason: collision with root package name */
    public long f25869f;

    /* renamed from: g  reason: collision with root package name */
    public long f25870g;

    /* renamed from: h  reason: collision with root package name */
    public long f25871h;

    /* renamed from: i  reason: collision with root package name */
    public long f25872i;

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
        this.f25866c = -14;
        this.f25867d = -1;
        this.f25868e = -1L;
        this.f25869f = -1L;
        this.f25870g = -1L;
        this.f25871h = -1L;
        this.f25872i = -1L;
        this.a = str;
        this.f25870g = System.nanoTime() / 1000;
        this.f25869f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (exc instanceof SocketTimeoutException) {
                this.f25866c = -1;
            } else if (exc instanceof UnknownHostException) {
                this.f25866c = -2;
            } else if (exc instanceof ConnectException) {
                this.f25866c = -5;
            } else if (exc instanceof ProtocolException) {
                this.f25866c = -3;
            } else if (exc instanceof BindException) {
                this.f25866c = -4;
            } else if (exc instanceof SSLHandshakeException) {
                this.f25866c = -8;
            } else if (exc instanceof SSLProtocolException) {
                this.f25866c = -9;
            } else if (exc instanceof RemoteException) {
                this.f25866c = -13;
            } else if (exc instanceof NoRouteToHostException) {
                this.f25866c = -6;
            } else if (exc instanceof PortUnreachableException) {
                this.f25866c = -7;
            } else if (exc instanceof SSLKeyException) {
                this.f25866c = -10;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                this.f25866c = -11;
            } else {
                this.f25866c = -14;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25871h = (System.nanoTime() / 1000) - this.f25870g;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25872i = (System.nanoTime() / 1000) - this.f25870g;
        }
    }

    public void d(TurbonetEngine turbonetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, turbonetEngine) == null) {
            String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.a, this.f25865b, Integer.valueOf(this.f25866c), Integer.valueOf(this.f25867d), Long.valueOf(this.f25868e), Long.valueOf(this.f25869f), Long.valueOf(this.f25871h), Long.valueOf(this.f25872i));
            turbonetEngine.g(this.a, this.f25865b, this.f25866c, this.f25867d, this.f25868e, this.f25869f, this.f25871h, this.f25872i);
        }
    }
}
