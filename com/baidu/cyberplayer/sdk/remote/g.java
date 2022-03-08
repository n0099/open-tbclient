package com.baidu.cyberplayer.sdk.remote;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.l;
import com.baidu.cyberplayer.sdk.remote.c;
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
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c f32198b;

    /* renamed from: c  reason: collision with root package name */
    public String f32199c;

    /* renamed from: d  reason: collision with root package name */
    public int f32200d;

    /* renamed from: e  reason: collision with root package name */
    public Class<?> f32201e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f32202f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<WeakReference<b>> f32203g;

    /* renamed from: h  reason: collision with root package name */
    public ServiceConnection f32204h;

    /* renamed from: i  reason: collision with root package name */
    public IBinder.DeathRecipient f32205i;

    /* loaded from: classes4.dex */
    public static class a extends c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RemotePlayerService a;

        /* renamed from: b  reason: collision with root package name */
        public CyberPlayerManager.GetNetHandleListener f32206b;

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
            this.f32206b = null;
            this.a = remotePlayerService;
            CyberPlayerManager.GetNetHandleListener getNetHandleListener = new CyberPlayerManager.GetNetHandleListener(this) { // from class: com.baidu.cyberplayer.sdk.remote.g.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.GetNetHandleListener
                public Long getKerNetHandle() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        RemotePlayerService remotePlayerService2 = this.a.a;
                        if (remotePlayerService2 != null) {
                            return Long.valueOf(remotePlayerService2.getPCDNNetHandle());
                        }
                        return 0L;
                    }
                    return (Long) invokeV.objValue;
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.GetNetHandleListener
                public Long getPcdnNetHandle() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        RemotePlayerService remotePlayerService2 = this.a.a;
                        if (remotePlayerService2 != null) {
                            return Long.valueOf(remotePlayerService2.getKernelNetHandle());
                        }
                        return 0L;
                    }
                    return (Long) invokeV.objValue;
                }
            };
            this.f32206b = getNetHandleListener;
            if (getNetHandleListener != null) {
                CyberPlayerManager.setNetHandleListener(getNetHandleListener);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public IBinder a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (CyberPlayerManager.isCoreLoaded(1)) {
                    return new com.baidu.cyberplayer.sdk.extractor.c(this.a);
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
                    return new f(i2, this.a);
                }
                CyberLog.w("RemotePlayer", "RemotePlayer has not load kernel, create failed!");
                return null;
            }
            return (IBinder) invokeI.objValue;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public void a(String str, String str2, String str3, int i2, int i3, int i4, String str4, int i5, int i6, int i7, int i8, PrefetchOptions prefetchOptions) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str4, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), prefetchOptions}) == null) {
                if (i2 == 1) {
                    CyberLog.i("RemotePlayer", "RemotePlayer prefetch");
                    com.baidu.cyberplayer.sdk.d.l();
                    com.baidu.cyberplayer.sdk.d.m();
                    CyberPlayerManager.prefetch(str, str2, str3, i3, i4, null, str4, i5, i6, i7, i8, prefetchOptions);
                } else if (i2 == 2) {
                    CyberLog.i("RemotePlayer", "RemotePlayer preconnect");
                    CyberPlayerManager.preconnect(str, str2, str3, i4, null, str4, i5, i6, i7, i8);
                }
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

    /* loaded from: classes4.dex */
    public interface b {
        void a();
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32202f = new Object();
        this.f32203g = new ArrayList<>();
        this.f32204h = new ServiceConnection(this) { // from class: com.baidu.cyberplayer.sdk.remote.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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
                this.a = this;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                    CyberLog.i("RemotePlayer", "RemotePlayer service connected");
                    this.a.f32198b = c.a.a(iBinder);
                    try {
                        this.a.f32198b.asBinder().linkToDeath(this.a.f32205i, 0);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        this.a.f32198b = null;
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                    CyberLog.e("RemotePlayer", "RemotePlayer service disconnected");
                    this.a.f32198b = null;
                }
            }
        };
        this.f32205i = new IBinder.DeathRecipient(this) { // from class: com.baidu.cyberplayer.sdk.remote.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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
                this.a = this;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    CyberLog.i("RemotePlayer", "RemotePlayer service binder died");
                    if (this.a.f32198b != null) {
                        this.a.f32198b.asBinder().unlinkToDeath(this.a.f32205i, 0);
                        this.a.f32198b = null;
                    }
                    synchronized (this.a.f32202f) {
                        Iterator it = this.a.f32203g.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) ((WeakReference) it.next()).get();
                            if (bVar != null) {
                                bVar.a();
                            } else {
                                it.remove();
                            }
                        }
                    }
                    g gVar = this.a;
                    gVar.a(gVar.f32201e, this.a.f32199c, this.a.f32200d, CyberPlayerManager.getInstallOpts());
                }
            }
        };
    }

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                a = new g();
            }
            return a;
        }
        return (g) invokeV.objValue;
    }

    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            c cVar = this.f32198b;
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
            c cVar = this.f32198b;
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
            synchronized (this.f32202f) {
                this.f32203g.add(new WeakReference<>(bVar));
            }
        }
    }

    public void a(Class<?> cls, String str, int i2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(1048579, this, cls, str, i2, map) == null) || cls == null) {
            return;
        }
        CyberLog.i("RemotePlayer", "RemotePlayer connect service");
        this.f32201e = cls;
        this.f32199c = str;
        this.f32200d = i2;
        Intent intent = new Intent(CyberPlayerManager.getApplicationContext(), this.f32201e);
        intent.putExtra("clientID", this.f32199c);
        intent.putExtra("installType", this.f32200d);
        intent.putExtra("installOpts", (Serializable) map);
        boolean z = false;
        try {
            z = CyberPlayerManager.getApplicationContext().bindService(intent, this.f32204h, 1);
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
            c cVar = this.f32198b;
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
            c cVar = this.f32198b;
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
            synchronized (this.f32202f) {
                Iterator<WeakReference<b>> it = this.f32203g.iterator();
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
            c cVar = this.f32198b;
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
