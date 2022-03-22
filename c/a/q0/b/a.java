package c.a.q0.b;

import android.os.RemoteException;
import android.util.Log;
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
    public String f21013b;

    /* renamed from: c  reason: collision with root package name */
    public int f21014c;

    /* renamed from: d  reason: collision with root package name */
    public int f21015d;

    /* renamed from: e  reason: collision with root package name */
    public long f21016e;

    /* renamed from: f  reason: collision with root package name */
    public long f21017f;

    /* renamed from: g  reason: collision with root package name */
    public long f21018g;

    /* renamed from: h  reason: collision with root package name */
    public long f21019h;
    public long i;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21014c = -14;
        this.f21015d = -1;
        this.f21016e = -1L;
        this.f21017f = -1L;
        this.f21018g = -1L;
        this.f21019h = -1L;
        this.i = -1L;
        this.a = str;
        this.f21018g = System.nanoTime() / 1000;
        this.f21017f = System.currentTimeMillis();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (exc instanceof SocketTimeoutException) {
                this.f21014c = -1;
            } else if (exc instanceof UnknownHostException) {
                this.f21014c = -2;
            } else if (exc instanceof ConnectException) {
                this.f21014c = -5;
            } else if (exc instanceof ProtocolException) {
                this.f21014c = -3;
            } else if (exc instanceof BindException) {
                this.f21014c = -4;
            } else if (exc instanceof SSLHandshakeException) {
                this.f21014c = -8;
            } else if (exc instanceof SSLProtocolException) {
                this.f21014c = -9;
            } else if (exc instanceof RemoteException) {
                this.f21014c = -13;
            } else if (exc instanceof NoRouteToHostException) {
                this.f21014c = -6;
            } else if (exc instanceof PortUnreachableException) {
                this.f21014c = -7;
            } else if (exc instanceof SSLKeyException) {
                this.f21014c = -10;
            } else if (exc instanceof SSLPeerUnverifiedException) {
                this.f21014c = -11;
            } else {
                this.f21014c = -14;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21019h = (System.nanoTime() / 1000) - this.f21018g;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.i = (System.nanoTime() / 1000) - this.f21018g;
        }
    }

    public void d(TurbonetEngine turbonetEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, turbonetEngine) == null) {
            Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.a, this.f21013b, Integer.valueOf(this.f21014c), Integer.valueOf(this.f21015d), Long.valueOf(this.f21016e), Long.valueOf(this.f21017f), Long.valueOf(this.f21019h), Long.valueOf(this.i)));
            turbonetEngine.g(this.a, this.f21013b, this.f21014c, this.f21015d, this.f21016e, this.f21017f, this.f21019h, this.i);
        }
    }
}
