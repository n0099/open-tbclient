package b.d.b.e0.n;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
/* loaded from: classes6.dex */
public class e extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Method f30470c;

    /* renamed from: d  reason: collision with root package name */
    public final Method f30471d;

    /* renamed from: e  reason: collision with root package name */
    public final Method f30472e;

    /* renamed from: f  reason: collision with root package name */
    public final Class<?> f30473f;

    /* renamed from: g  reason: collision with root package name */
    public final Class<?> f30474g;

    /* loaded from: classes6.dex */
    public static class a implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f30475e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f30476f;

        /* renamed from: g  reason: collision with root package name */
        public String f30477g;

        public a(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30475e = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                String name = method.getName();
                Class<?> returnType = method.getReturnType();
                if (objArr == null) {
                    objArr = b.d.b.e0.e.f30190b;
                }
                if (name.equals("supports") && Boolean.TYPE == returnType) {
                    return Boolean.TRUE;
                }
                if (name.equals("unsupported") && Void.TYPE == returnType) {
                    this.f30476f = true;
                    return null;
                } else if (name.equals(WebSocketRequest.PARAM_KEY_PROTOCOLS) && objArr.length == 0) {
                    return this.f30475e;
                } else {
                    if ((name.equals("selectProtocol") || name.equals(InvoiceBuildActivity.EXTRA_PARAMS_TYPE)) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                        List list = (List) objArr[0];
                        int size = list.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            if (this.f30475e.contains(list.get(i2))) {
                                String str = (String) list.get(i2);
                                this.f30477g = str;
                                return str;
                            }
                        }
                        String str2 = this.f30475e.get(0);
                        this.f30477g = str2;
                        return str2;
                    } else if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                        this.f30477g = (String) objArr[0];
                        return null;
                    } else {
                        return method.invoke(this, objArr);
                    }
                }
            }
            return invokeLLL.objValue;
        }
    }

    public e(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {method, method2, method3, cls, cls2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30470c = method;
        this.f30471d = method2;
        this.f30472e = method3;
        this.f30473f = cls;
        this.f30474g = cls2;
    }

    public static g y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
                return new e(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                return null;
            }
        }
        return (g) invokeV.objValue;
    }

    @Override // b.d.b.e0.n.g
    public void a(SSLSocket sSLSocket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sSLSocket) == null) {
            try {
                this.f30472e.invoke(null, sSLSocket);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw b.d.b.e0.e.b("unable to remove alpn", e2);
            }
        }
    }

    @Override // b.d.b.e0.n.g
    public void h(SSLSocket sSLSocket, String str, List<Protocol> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sSLSocket, str, list) == null) {
            try {
                this.f30470c.invoke(null, sSLSocket, Proxy.newProxyInstance(g.class.getClassLoader(), new Class[]{this.f30473f, this.f30474g}, new a(g.b(list))));
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw b.d.b.e0.e.b("unable to set alpn", e2);
            }
        }
    }

    @Override // b.d.b.e0.n.g
    @Nullable
    public String p(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sSLSocket)) == null) {
            try {
                a aVar = (a) Proxy.getInvocationHandler(this.f30471d.invoke(null, sSLSocket));
                if (!aVar.f30476f && aVar.f30477g == null) {
                    g.m().u(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                    return null;
                } else if (aVar.f30476f) {
                    return null;
                } else {
                    return aVar.f30477g;
                }
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw b.d.b.e0.e.b("unable to get selected protocol", e2);
            }
        }
        return (String) invokeL.objValue;
    }
}
