package com.baidu.pyramid.runtime.multiprocess;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import c.a.k0.b.a.e;
import c.a.k0.b.a.f;
import c.a.k0.b.a.g;
import c.a.k0.b.a.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.multiprocess.components.ServerProvider;
import com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class IPCServiceManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile IPCServiceManagerAidl a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f39183b;

    /* renamed from: c  reason: collision with root package name */
    public static IPCServiceManagerAidlImpl f39184c;

    /* renamed from: d  reason: collision with root package name */
    public static ContentProviderClient f39185d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class IPCServiceManagerAidlImpl extends IPCServiceManagerAidl.Stub {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public IPCServiceManagerAidlImpl() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
        public void addService(String str, IBinder iBinder, boolean z) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, str, iBinder, z) == null) {
                h.a(str, iBinder, z);
            }
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
        public IBinder getService(String str) throws RemoteException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? h.d(str) : (IBinder) invokeL.objValue;
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
        public boolean removeService(String str) throws RemoteException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? h.e(str) : invokeL.booleanValue;
        }

        public /* synthetic */ IPCServiceManagerAidlImpl(a aVar) {
            this();
        }
    }

    /* loaded from: classes10.dex */
    public static class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f39186h;

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
            this.f39186h = str;
        }

        @Override // c.a.k0.b.a.f
        public IBinder c() throws RemoteException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? IPCServiceManager.g().getService(this.f39186h) : (IBinder) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: h  reason: collision with root package name */
        public static final Uri f39187h;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-662622722, "Lcom/baidu/pyramid/runtime/multiprocess/IPCServiceManager$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-662622722, "Lcom/baidu/pyramid/runtime/multiprocess/IPCServiceManager$b;");
                    return;
                }
            }
            f39187h = Uri.parse("content://" + ServerProvider.getCoreProviderAuthority() + "/ipc_manager/method/get_service_handler");
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // c.a.k0.b.a.f
        public IBinder c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ContentResolver contentResolver = e.a().getContentResolver();
                JSONObject jSONObject = new JSONObject();
                Bundle f2 = f(contentResolver, jSONObject);
                if (f2 == null) {
                    f2 = i(contentResolver, jSONObject);
                }
                if (jSONObject.length() != 0) {
                    g.c(jSONObject.toString());
                }
                if (f2 == null) {
                    return null;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    return f2.getBinder("service");
                }
                f2.setClassLoader(BindlerHolder.class.getClassLoader());
                BindlerHolder bindlerHolder = (BindlerHolder) f2.getParcelable("service");
                if (bindlerHolder != null) {
                    return bindlerHolder.getBinder();
                }
                return null;
            }
            return (IBinder) invokeV.objValue;
        }

        public final Bundle d(ContentResolver contentResolver, Uri uri, JSONObject jSONObject) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, contentResolver, uri, jSONObject)) == null) {
                try {
                    return contentResolver.call(uri, "_get_service_handler", (String) null, (Bundle) null);
                } catch (Exception e2) {
                    try {
                        jSONObject.put("useContentResolverCall", g.a(e2));
                    } catch (JSONException unused) {
                    }
                    IPCServiceManager.h("getServicerBinder", e2);
                    return null;
                }
            }
            return (Bundle) invokeLLL.objValue;
        }

        public final Bundle e(ContentResolver contentResolver, Uri uri, JSONObject jSONObject) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, contentResolver, uri, jSONObject)) == null) {
                try {
                    return contentResolver.query(uri, null, null, null, null).getExtras();
                } catch (Exception e2) {
                    try {
                        jSONObject.put("useContentResolverQuery", g.a(e2));
                    } catch (JSONException unused) {
                    }
                    IPCServiceManager.h("getServicerBinder", e2);
                    return null;
                }
            }
            return (Bundle) invokeLLL.objValue;
        }

        public final Bundle f(ContentResolver contentResolver, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, contentResolver, jSONObject)) == null) {
                Bundle bundle = null;
                int i2 = 0;
                while (true) {
                    if (i2 >= 2) {
                        break;
                    }
                    ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(ServerProvider.getCoreProviderAuthority());
                    if (acquireUnstableContentProviderClient != null && (bundle = g(acquireUnstableContentProviderClient, jSONObject)) == null) {
                        bundle = h(acquireUnstableContentProviderClient, jSONObject);
                    }
                    if (bundle != null) {
                        IPCServiceManager.f39185d = acquireUnstableContentProviderClient;
                        break;
                    }
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                    i2++;
                }
                return bundle;
            }
            return (Bundle) invokeLL.objValue;
        }

        public final Bundle g(ContentProviderClient contentProviderClient, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, contentProviderClient, jSONObject)) == null) {
                try {
                    if (Build.VERSION.SDK_INT >= 17) {
                        return contentProviderClient.call("_get_service_handler", null, null);
                    }
                } catch (Exception e2) {
                    try {
                        jSONObject.put("useProviderClientCall", g.a(e2));
                    } catch (JSONException unused) {
                    }
                    IPCServiceManager.h("getServicerBinder", e2);
                }
                return null;
            }
            return (Bundle) invokeLL.objValue;
        }

        public final Bundle h(ContentProviderClient contentProviderClient, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, contentProviderClient, jSONObject)) == null) {
                try {
                    return contentProviderClient.query(f39187h, null, null, null, null).getExtras();
                } catch (Exception e2) {
                    try {
                        jSONObject.put("useProviderClientQuery", g.a(e2));
                    } catch (JSONException unused) {
                    }
                    IPCServiceManager.h("getServicerBinder", e2);
                    return null;
                }
            }
            return (Bundle) invokeLL.objValue;
        }

        public final Bundle i(ContentResolver contentResolver, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, contentResolver, jSONObject)) == null) {
                Bundle bundle = null;
                for (int i2 = 0; i2 < 2; i2++) {
                    bundle = d(contentResolver, f39187h, jSONObject);
                    if (bundle == null) {
                        bundle = e(contentResolver, f39187h, jSONObject);
                    }
                    if (bundle != null) {
                        break;
                    }
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
                return bundle;
            }
            return (Bundle) invokeLL.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1572493116, "Lcom/baidu/pyramid/runtime/multiprocess/IPCServiceManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1572493116, "Lcom/baidu/pyramid/runtime/multiprocess/IPCServiceManager;");
                return;
            }
        }
        f39183b = new b(null);
    }

    public static void c(String str, IBinder iBinder, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, str, iBinder, z) == null) {
            try {
                g().addService(str, iBinder, z);
            } catch (RemoteException e2) {
                h("MultiProcess", e2);
                g.b(e2);
            }
        }
    }

    public static Bundle d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Bundle bundle = new Bundle();
            if (Build.VERSION.SDK_INT >= 18) {
                bundle.putBinder("service", e());
            } else {
                bundle.putParcelable("service", new BindlerHolder(e()));
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public static IPCServiceManagerAidlImpl e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f39184c == null) {
                f39184c = new IPCServiceManagerAidlImpl(null);
            }
            return f39184c;
        }
        return (IPCServiceManagerAidlImpl) invokeV.objValue;
    }

    public static IBinder f(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, str, z)) == null) {
            if (z) {
                return new a(str);
            }
            try {
                return g().getService(str);
            } catch (RemoteException e2) {
                h("MultiProcess", e2);
                g.b(e2);
                return null;
            }
        }
        return (IBinder) invokeLZ.objValue;
    }

    public static IPCServiceManagerAidl g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            IPCServiceManagerAidl iPCServiceManagerAidl = a;
            if (iPCServiceManagerAidl != null) {
                return iPCServiceManagerAidl;
            }
            IPCServiceManagerAidl asInterface = IPCServiceManagerAidl.Stub.asInterface(f39183b);
            a = asInterface;
            return asInterface;
        }
        return (IPCServiceManagerAidl) invokeV.objValue;
    }

    public static void h(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, exc) == null) {
        }
    }
}
