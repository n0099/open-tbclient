package com.baidu.cyberplayer.sdk.remote;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.l;
import com.baidu.cyberplayer.sdk.remote.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f39230a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile g f39231b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c f39232c;

    /* renamed from: d  reason: collision with root package name */
    public String f39233d;

    /* renamed from: e  reason: collision with root package name */
    public int f39234e;

    /* renamed from: f  reason: collision with root package name */
    public Class<?> f39235f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f39236g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<WeakReference<b>> f39237h;

    /* renamed from: i  reason: collision with root package name */
    public ServiceConnection f39238i;

    /* renamed from: j  reason: collision with root package name */
    public IBinder.DeathRecipient f39239j;

    /* loaded from: classes5.dex */
    public static class a extends c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RemotePlayerService f39242a;

        public a(RemotePlayerService remotePlayerService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {remotePlayerService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39242a = remotePlayerService;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public IBinder a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (CyberPlayerManager.isCoreLoaded(1)) {
                    return new com.baidu.cyberplayer.sdk.extractor.c(this.f39242a);
                }
                CyberLog.w("RemotePlayer", "RemoteExtractor has not load kernel, create failed!");
                return null;
            }
            return (IBinder) invokeV.objValue;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public IBinder a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (CyberPlayerManager.isCoreLoaded(1)) {
                    return new f(i2, this.f39242a);
                }
                CyberLog.w("RemotePlayer", "RemotePlayer has not load kernel, create failed!");
                return null;
            }
            return (IBinder) invokeI.objValue;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public void a(String str, String str2, String str3, int i2, int i3, int i4, String str4, int i5, int i6, int i7, int i8, PrefetchOptions prefetchOptions) {
            RemotePlayerService remotePlayerService;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str4, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), prefetchOptions}) == null) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        CyberLog.i("RemotePlayer", "RemotePlayer preconnect");
                        CyberPlayerManager.preconnect(str, str2, str3, i4, null, str4, i5, i6, i7, i8);
                        return;
                    }
                    return;
                }
                CyberLog.i("RemotePlayer", "RemotePlayer prefetch");
                if (!g.f39230a && (remotePlayerService = this.f39242a) != null) {
                    long kernelNetHandle = remotePlayerService.getKernelNetHandle();
                    if (kernelNetHandle != 0 && com.baidu.cyberplayer.sdk.d.c(kernelNetHandle) == 0) {
                        boolean unused = g.f39230a = true;
                    }
                }
                CyberPlayerManager.prefetch(str, str2, str3, i3, i4, null, str4, i5, i6, i7, i8, prefetchOptions);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? CyberPlayerManager.hasCacheFile(str) : invokeL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                l.a().a(str);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(924970853, "Lcom/baidu/cyberplayer/sdk/remote/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(924970853, "Lcom/baidu/cyberplayer/sdk/remote/g;");
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f39236g = new Object();
        this.f39237h = new ArrayList<>();
        this.f39238i = new ServiceConnection(this) { // from class: com.baidu.cyberplayer.sdk.remote.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f39240a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f39240a = this;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                    CyberLog.i("RemotePlayer", "RemotePlayer service connected");
                    this.f39240a.f39232c = c.a.a(iBinder);
                    try {
                        this.f39240a.f39232c.asBinder().linkToDeath(this.f39240a.f39239j, 0);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        this.f39240a.f39232c = null;
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                    CyberLog.e("RemotePlayer", "RemotePlayer service disconnected");
                    this.f39240a.f39232c = null;
                }
            }
        };
        this.f39239j = new IBinder.DeathRecipient(this) { // from class: com.baidu.cyberplayer.sdk.remote.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f39241a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f39241a = this;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    CyberLog.i("RemotePlayer", "RemotePlayer service binder died");
                    if (this.f39241a.f39232c != null) {
                        this.f39241a.f39232c.asBinder().unlinkToDeath(this.f39241a.f39239j, 0);
                        this.f39241a.f39232c = null;
                    }
                    synchronized (this.f39241a.f39236g) {
                        Iterator it = this.f39241a.f39237h.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) ((WeakReference) it.next()).get();
                            if (bVar != null) {
                                bVar.a();
                            } else {
                                it.remove();
                            }
                        }
                    }
                    g gVar = this.f39241a;
                    gVar.a(gVar.f39235f, this.f39241a.f39233d, this.f39241a.f39234e, CyberPlayerManager.getInstallOpts());
                }
            }
        };
    }

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f39231b == null) {
                f39231b = new g();
            }
            return f39231b;
        }
        return (g) invokeV.objValue;
    }

    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            c cVar = this.f39232c;
            if (cVar == null) {
                return -1;
            }
            try {
                return cVar.a(str) ? 1 : 0;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public IBinder a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            c cVar = this.f39232c;
            if (cVar != null) {
                try {
                    return cVar.a(i2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (IBinder) invokeI.objValue;
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            synchronized (this.f39236g) {
                this.f39237h.add(new WeakReference<>(bVar));
            }
        }
    }

    public void a(Class<?> cls, String str, int i2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(1048579, this, cls, str, i2, map) == null) || cls == null) {
            return;
        }
        CyberLog.i("RemotePlayer", "RemotePlayer connect service");
        this.f39235f = cls;
        this.f39233d = str;
        this.f39234e = i2;
        Intent intent = new Intent(CyberPlayerManager.getApplicationContext(), this.f39235f);
        intent.putExtra("clientID", this.f39233d);
        intent.putExtra("installType", this.f39234e);
        intent.putExtra("installOpts", (Serializable) map);
        boolean z = false;
        try {
            z = CyberPlayerManager.getApplicationContext().bindService(intent, this.f39238i, 1);
        } catch (Exception unused) {
            CyberLog.e("RemotePlayer", "Failed binding to service!");
        }
        if (z) {
            return;
        }
        CyberLog.i("RemotePlayer", "Failed binding to service! need retry!");
    }

    public boolean a(String str, String str2, String str3, int i2, int i3, int i4, String str4, int i5, int i6, int i7, int i8, PrefetchOptions prefetchOptions) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str4, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), prefetchOptions})) == null) {
            c cVar = this.f39232c;
            if (cVar == null) {
                return false;
            }
            try {
                cVar.a(str, str2, str3, i2, i3, i4, str4, i5, i6, i7, i8, prefetchOptions);
                return true;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public IBinder b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.f39232c;
            if (cVar != null) {
                try {
                    return cVar.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (IBinder) invokeV.objValue;
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            synchronized (this.f39236g) {
                Iterator<WeakReference<b>> it = this.f39237h.iterator();
                while (it.hasNext()) {
                    b bVar2 = it.next().get();
                    if (bVar2 == null || bVar2.equals(bVar)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            c cVar = this.f39232c;
            if (cVar == null) {
                return false;
            }
            try {
                cVar.b(str);
                return true;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
