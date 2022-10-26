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
/* loaded from: classes2.dex */
public class ai {
    public static /* synthetic */ Interceptable $ic;
    public static final ByteBuffer c;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public b b;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void a(String str);

        void a(boolean z);

        void b();
    }

    /* loaded from: classes2.dex */
    public class b extends ci {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ai a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ai aiVar, URI uri, int i, Socket socket) throws InterruptedException {
            super(uri, new cl(), null, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aiVar, uri, Integer.valueOf(i), socket};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((URI) objArr2[0], (cj) objArr2[1], (Map) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aiVar;
            a(socket);
        }

        @Override // com.baidu.mobstat.ci
        public void a(int i, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                if (bc.c().b()) {
                    bc c = bc.c();
                    c.a("onClose,  reason:" + str + ", remote:" + z);
                }
                bb c2 = bb.c();
                c2.a("autotrace: connect closed, server:" + z + " reason:" + str);
                al a = al.a();
                a.a(5, "remote:" + z + "|reason:" + str);
                if (this.a.a != null) {
                    this.a.a.a(z);
                }
            }
        }

        @Override // com.baidu.mobstat.ci
        public void a(df dfVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dfVar) == null) {
                if (bc.c().b()) {
                    bc.c().a("onOpen");
                }
                if (this.a.a != null) {
                    this.a.a.a();
                }
            }
        }

        @Override // com.baidu.mobstat.ci
        public void a(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) && bc.c().b()) {
                bc.c().a("onError");
            }
        }

        @Override // com.baidu.mobstat.ci
        public void a(String str) {
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                if (bc.c().b()) {
                    bc.c().a("onMessage: " + str);
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
                        this.a.a.a(((JSONObject) jSONObject.get("data")).toString());
                        return;
                    } catch (Exception unused3) {
                        return;
                    }
                }
                int i = -1;
                try {
                    i = ((Integer) ((JSONObject) jSONObject.get("data")).get("status")).intValue();
                } catch (Exception unused4) {
                }
                switch (i) {
                    case 801020:
                        bb.c().a("autotrace: connect established");
                        al.a().a(2);
                        return;
                    case 801021:
                        bb.c().a("autotrace: connect failed, connect has been established");
                        al.a().a(5, "already connect");
                        return;
                    case 801022:
                    case 801023:
                    default:
                        return;
                    case 801024:
                        bb.c().a("autotrace: connect confirm");
                        al.a().a(3);
                        if (this.a.a != null) {
                            this.a.a.b();
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ai a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ai aiVar, Throwable th) {
            super(th.getMessage());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aiVar, th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aiVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581657098, "Lcom/baidu/mobstat/ai;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581657098, "Lcom/baidu/mobstat/ai;");
                return;
            }
        }
        c = ByteBuffer.allocate(0);
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

    public void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bVar = this.b) != null) {
            bVar.d();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.b.f() && !this.b.g() && !this.b.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ai(URI uri, a aVar) throws c {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = aVar;
        try {
            b bVar = new b(this, uri, 5000, uri.toString().startsWith("wss://") ? c() : null);
            this.b = bVar;
            bVar.c();
        } catch (InterruptedException e) {
            throw new c(this, e);
        }
    }

    public void a(JSONObject jSONObject) throws NotYetConnectedException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && this.b != null) {
            this.b.a(jSONObject.toString().getBytes());
        }
    }
}
