package com.baidu.pyramid.runtime.multiprocess;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.multiprocess.components.ServerProvider;
import com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.ml1;
import com.baidu.tieba.nl1;
import com.baidu.tieba.ol1;
import com.baidu.tieba.pl1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IPCServiceManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile IPCServiceManagerAidl a;
    public static final b b;
    public static IPCServiceManagerAidlImpl c;
    public static ContentProviderClient d;
    public transient /* synthetic */ FieldHolder $fh;

    public static void h(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, exc) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public static class IPCServiceManagerAidlImpl extends IPCServiceManagerAidl.Stub {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public IPCServiceManagerAidlImpl() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ IPCServiceManagerAidlImpl(a aVar) {
            this();
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
        public IBinder getService(String str) throws RemoteException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                return pl1.d(str);
            }
            return (IBinder) invokeL.objValue;
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
        public boolean removeService(String str) throws RemoteException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                return pl1.e(str);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
        public void addService(String str, IBinder iBinder, boolean z) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, str, iBinder, z) == null) {
                pl1.a(str, iBinder, z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends nl1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String d;

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
            this.d = str;
        }

        @Override // com.baidu.tieba.nl1
        public IBinder c() throws RemoteException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return IPCServiceManager.a().getService(this.d);
            }
            return (IBinder) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends nl1 {
        public static /* synthetic */ Interceptable $ic;
        public static final Uri d;
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
            d = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + ServerProvider.f() + "/ipc_manager/method/get_service_handler");
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // com.baidu.tieba.nl1
        public IBinder c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ContentResolver contentResolver = ml1.a().getContentResolver();
                JSONObject jSONObject = new JSONObject();
                Bundle f = f(contentResolver, jSONObject);
                if (f == null) {
                    f = i(contentResolver, jSONObject);
                }
                if (jSONObject.length() != 0) {
                    ol1.c(jSONObject.toString());
                }
                if (f == null) {
                    return null;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    return f.getBinder("service");
                }
                f.setClassLoader(BindlerHolder.class.getClassLoader());
                BindlerHolder bindlerHolder = (BindlerHolder) f.getParcelable("service");
                if (bindlerHolder == null) {
                    return null;
                }
                return bindlerHolder.getBinder();
            }
            return (IBinder) invokeV.objValue;
        }

        public final Bundle d(ContentResolver contentResolver, Uri uri, JSONObject jSONObject) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, contentResolver, uri, jSONObject)) == null) {
                try {
                    return contentResolver.call(uri, "_get_service_handler", (String) null, (Bundle) null);
                } catch (Exception e) {
                    try {
                        jSONObject.put("useContentResolverCall", ol1.a(e));
                    } catch (JSONException unused) {
                    }
                    IPCServiceManager.h("getServicerBinder", e);
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
                } catch (Exception e) {
                    try {
                        jSONObject.put("useContentResolverQuery", ol1.a(e));
                    } catch (JSONException unused) {
                    }
                    IPCServiceManager.h("getServicerBinder", e);
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
                int i = 0;
                while (true) {
                    if (i >= 2) {
                        break;
                    }
                    ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(ServerProvider.f());
                    if (acquireUnstableContentProviderClient != null && (bundle = g(acquireUnstableContentProviderClient, jSONObject)) == null) {
                        bundle = h(acquireUnstableContentProviderClient, jSONObject);
                    }
                    if (bundle != null) {
                        IPCServiceManager.d = acquireUnstableContentProviderClient;
                        break;
                    }
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                    i++;
                }
                return bundle;
            }
            return (Bundle) invokeLL.objValue;
        }

        public final Bundle h(ContentProviderClient contentProviderClient, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, contentProviderClient, jSONObject)) == null) {
                try {
                    return contentProviderClient.query(d, null, null, null, null).getExtras();
                } catch (Exception e) {
                    try {
                        jSONObject.put("useProviderClientQuery", ol1.a(e));
                    } catch (JSONException unused) {
                    }
                    IPCServiceManager.h("getServicerBinder", e);
                    return null;
                }
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
                } catch (Exception e) {
                    try {
                        jSONObject.put("useProviderClientCall", ol1.a(e));
                    } catch (JSONException unused) {
                    }
                    IPCServiceManager.h("getServicerBinder", e);
                }
                return null;
            }
            return (Bundle) invokeLL.objValue;
        }

        public final Bundle i(ContentResolver contentResolver, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, contentResolver, jSONObject)) == null) {
                Bundle bundle = null;
                for (int i = 0; i < 2; i++) {
                    bundle = d(contentResolver, d, jSONObject);
                    if (bundle == null) {
                        bundle = e(contentResolver, d, jSONObject);
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
        b = new b(null);
    }

    public static /* synthetic */ IPCServiceManagerAidl a() {
        return g();
    }

    public static IPCServiceManagerAidlImpl e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (c == null) {
                c = new IPCServiceManagerAidlImpl(null);
            }
            return c;
        }
        return (IPCServiceManagerAidlImpl) invokeV.objValue;
    }

    public static IPCServiceManagerAidl g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            IPCServiceManagerAidl iPCServiceManagerAidl = a;
            if (iPCServiceManagerAidl != null) {
                return iPCServiceManagerAidl;
            }
            IPCServiceManagerAidl asInterface = IPCServiceManagerAidl.Stub.asInterface(b);
            a = asInterface;
            return asInterface;
        }
        return (IPCServiceManagerAidl) invokeV.objValue;
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
            } catch (RemoteException e) {
                h("MultiProcess", e);
                ol1.b(e);
                return null;
            }
        }
        return (IBinder) invokeLZ.objValue;
    }

    public static void c(String str, IBinder iBinder, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, str, iBinder, z) == null) {
            try {
                g().addService(str, iBinder, z);
            } catch (RemoteException e) {
                h("MultiProcess", e);
                ol1.b(e);
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
}
