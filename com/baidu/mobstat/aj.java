package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class aj {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final ByteBuffer f8624c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f8625a;

    /* renamed from: b  reason: collision with root package name */
    public b f8626b;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void a(String str);

        void a(boolean z);

        void b();
    }

    /* loaded from: classes3.dex */
    public class c extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ aj f8628a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(aj ajVar, Throwable th) {
            super(th.getMessage());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ajVar, th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8628a = ajVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581657129, "Lcom/baidu/mobstat/aj;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581657129, "Lcom/baidu/mobstat/aj;");
                return;
            }
        }
        f8624c = ByteBuffer.allocate(0);
    }

    public aj(URI uri, a aVar) throws c {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8625a = aVar;
        try {
            b bVar = new b(this, uri, 5000, uri.toString().startsWith("wss://") ? c() : null);
            this.f8626b = bVar;
            bVar.c();
        } catch (InterruptedException e2) {
            throw new c(this, e2);
        }
    }

    private Socket c() {
        InterceptResult invokeV;
        SSLSocketFactory sSLSocketFactory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                sSLSocketFactory = sSLContext.getSocketFactory();
            } catch (Exception unused) {
                sSLSocketFactory = null;
            }
            if (sSLSocketFactory == null) {
                return null;
            }
            try {
                return sSLSocketFactory.createSocket();
            } catch (Exception unused2) {
                return null;
            }
        }
        return (Socket) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f8626b.f() || this.f8626b.g() || this.f8626b.e()) ? false : true : invokeV.booleanValue;
    }

    public void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f8626b) == null) {
            return;
        }
        bVar.d();
    }

    /* loaded from: classes3.dex */
    public class b extends cc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ aj f8627a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(aj ajVar, URI uri, int i2, Socket socket) throws InterruptedException {
            super(uri, new cf(), null, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ajVar, uri, Integer.valueOf(i2), socket};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((URI) objArr2[0], (cd) objArr2[1], (Map) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8627a = ajVar;
            a(socket);
        }

        @Override // com.baidu.mobstat.cc
        public void a(cz czVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, czVar) == null) {
                if (bd.c().b()) {
                    bd.c().a("onOpen");
                }
                if (this.f8627a.f8625a != null) {
                    this.f8627a.f8625a.a();
                }
            }
        }

        @Override // com.baidu.mobstat.cc
        public void a(String str) {
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                if (bd.c().b()) {
                    bd.c().a("onMessage: " + str);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String str2 = null;
                try {
                    jSONObject = new JSONObject(str);
                } catch (Exception unused) {
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    return;
                }
                try {
                    str2 = jSONObject.getString("type");
                } catch (Exception unused2) {
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                if (str2.equals("deploy")) {
                    try {
                        this.f8627a.f8625a.a(((JSONObject) jSONObject.get("data")).toString());
                        return;
                    } catch (Exception unused3) {
                        return;
                    }
                }
                int i2 = -1;
                try {
                    i2 = ((Integer) ((JSONObject) jSONObject.get("data")).get("status")).intValue();
                } catch (Exception unused4) {
                }
                switch (i2) {
                    case 801020:
                        bc.c().a("autotrace: connect established");
                        am.a().a(2);
                        return;
                    case 801021:
                        bc.c().a("autotrace: connect failed, connect has been established");
                        am.a().a(5, "already connect");
                        return;
                    case 801022:
                    case 801023:
                    default:
                        return;
                    case 801024:
                        bc.c().a("autotrace: connect confirm");
                        am.a().a(3);
                        if (this.f8627a.f8625a != null) {
                            this.f8627a.f8625a.b();
                            return;
                        }
                        return;
                }
            }
        }

        @Override // com.baidu.mobstat.cc
        public void a(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                if (bd.c().b()) {
                    bd c2 = bd.c();
                    c2.a("onClose,  reason:" + str + ", remote:" + z);
                }
                bc c3 = bc.c();
                c3.a("autotrace: connect closed, server:" + z + " reason:" + str);
                am a2 = am.a();
                a2.a(5, "remote:" + z + "|reason:" + str);
                if (this.f8627a.f8625a != null) {
                    this.f8627a.f8625a.a(z);
                }
            }
        }

        @Override // com.baidu.mobstat.cc
        public void a(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) && bd.c().b()) {
                bd.c().a("onError");
            }
        }
    }

    public void a(JSONObject jSONObject) throws NotYetConnectedException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || this.f8626b == null) {
            return;
        }
        this.f8626b.a(jSONObject.toString().getBytes());
    }
}
