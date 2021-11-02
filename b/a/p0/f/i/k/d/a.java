package b.a.p0.f.i.k.d;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.f.i.k.d.c;
import b.a.p0.f.i.k.f.e;
import b.a.p0.f.i.r.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class a implements b.a.p0.f.i.k.f.d, c.a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static a k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f9788a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f9789b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f9790c;

    /* renamed from: d  reason: collision with root package name */
    public final List<DownloadInfo> f9791d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f9792e;

    /* renamed from: f  reason: collision with root package name */
    public final e f9793f;

    /* renamed from: g  reason: collision with root package name */
    public final b.a.p0.f.i.k.f.b f9794g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a.p0.f.i.k.c.a f9795h;

    /* renamed from: i  reason: collision with root package name */
    public ConcurrentHashMap<Uri, BroadcastReceiver> f9796i;
    public ConcurrentHashMap<Uri, Timer> j;

    /* renamed from: b.a.p0.f.i.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0520a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a this$0;
        public final /* synthetic */ d val$listener;
        public final /* synthetic */ String val$packageName;
        public final /* synthetic */ Uri val$uri;

        public C0520a(a aVar, String str, d dVar, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, dVar, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = aVar;
            this.val$packageName = str;
            this.val$listener = dVar;
            this.val$uri = uri;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String dataString;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && (dataString = intent.getDataString()) != null && dataString.endsWith(this.val$packageName)) {
                this.val$listener.a(Boolean.TRUE);
                this.this$0.l(context, this.val$uri);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9797e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f9798f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Uri f9799g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f9800h;

        public b(a aVar, d dVar, Context context, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar, context, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9800h = aVar;
            this.f9797e = dVar;
            this.f9798f = context;
            this.f9799g = uri;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9797e.a(Boolean.FALSE);
                this.f9800h.l(this.f9798f, this.f9799g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Timer f9801e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f9802f;

        public c(a aVar, Timer timer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, timer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9802f = aVar;
            this.f9801e = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Map.Entry entry : this.f9802f.f9796i.entrySet()) {
                    a aVar = this.f9802f;
                    aVar.l(aVar.f9792e, (Uri) entry.getKey());
                }
                this.f9801e.cancel();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        public void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
            }
        }
    }

    public a(Context context, b.a.p0.f.i.k.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9796i = new ConcurrentHashMap<>();
        this.j = new ConcurrentHashMap<>();
        this.f9792e = context;
        if (aVar == null) {
            this.f9795h = new b.a.p0.f.i.k.c.a();
        } else {
            this.f9795h = aVar;
        }
        if (this.f9795h.a() == null) {
            this.f9794g = new b.a.p0.f.i.k.e.a(context, this.f9795h);
        } else {
            this.f9794g = this.f9795h.a();
        }
        this.f9791d = new ArrayList();
        this.f9790c = new ConcurrentHashMap<>();
        this.f9794g.b();
        this.f9789b = Executors.newFixedThreadPool(this.f9795h.b());
        this.f9793f = new b.a.p0.f.i.k.d.b(this.f9794g);
    }

    public static synchronized b.a.p0.f.i.k.f.d m(Context context, b.a.p0.f.i.k.c.a aVar) {
        InterceptResult invokeLL;
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, aVar)) == null) {
            synchronized (a.class) {
                if (k == null) {
                    k = new a(context, aVar);
                }
                aVar2 = k;
            }
            return aVar2;
        }
        return (b.a.p0.f.i.k.f.d) invokeLL.objValue;
    }

    @Override // b.a.p0.f.i.k.f.d
    public synchronized void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) {
            synchronized (this) {
                if (n()) {
                    p(downloadInfo);
                }
            }
        }
    }

    @Override // b.a.p0.f.i.k.f.d
    public synchronized void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
            synchronized (this) {
                if (downloadInfo == null) {
                    return;
                }
                downloadInfo.setStatus(DownloadState.DELETED.value());
                this.f9790c.remove(downloadInfo.getId());
                this.f9791d.remove(downloadInfo);
                this.f9794g.delete(downloadInfo);
                this.f9793f.b(downloadInfo);
                new File(downloadInfo.getPath()).delete();
            }
        }
    }

    @Override // b.a.p0.f.i.k.f.d
    public synchronized void c(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) {
            synchronized (this) {
                this.f9791d.add(downloadInfo);
                p(downloadInfo);
            }
        }
    }

    @Override // b.a.p0.f.i.k.f.d
    public synchronized void d(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadInfo) == null) {
            synchronized (this) {
                if (n()) {
                    o(downloadInfo);
                }
            }
        }
    }

    @Override // b.a.p0.f.i.k.f.d
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                k();
                if (this.f9794g != null) {
                    this.f9794g.close();
                }
                if (this.f9789b != null) {
                    this.f9789b.shutdownNow();
                    this.f9789b = null;
                }
                k = null;
            }
        }
    }

    @Override // b.a.p0.f.i.k.d.c.a
    public synchronized void e(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, downloadInfo) == null) {
            synchronized (this) {
                g.c(downloadInfo.getPath(), false);
                this.f9790c.remove(downloadInfo.getId());
                this.f9791d.remove(downloadInfo);
                q();
            }
        }
    }

    @Override // b.a.p0.f.i.k.f.d
    @AnyThread
    public synchronized void f(@NonNull String str, @NonNull Uri uri, @NonNull d<Boolean> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, uri, dVar) == null) {
            synchronized (this) {
                Context appContext = AppRuntime.getAppContext();
                if (g.a(appContext, str)) {
                    dVar.a(Boolean.TRUE);
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addDataScheme("package");
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                C0520a c0520a = new C0520a(this, str, dVar, uri);
                appContext.registerReceiver(c0520a, intentFilter);
                Timer timer = new Timer();
                timer.schedule(new b(this, dVar, appContext, uri), 60000L);
                this.f9796i.put(uri, c0520a);
                this.j.put(uri, timer);
            }
        }
    }

    @Override // b.a.p0.f.i.k.f.d
    public synchronized DownloadInfo g(String str) {
        InterceptResult invokeL;
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                downloadInfo = null;
                Iterator<DownloadInfo> it = this.f9791d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DownloadInfo next = it.next();
                    if (next.getId().equals(str)) {
                        downloadInfo = next;
                        break;
                    }
                }
                if (downloadInfo == null) {
                    downloadInfo = this.f9794g.c(str);
                }
            }
            return downloadInfo;
        }
        return (DownloadInfo) invokeL.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Timer timer = new Timer();
            timer.schedule(new c(this, timer), 60000L);
        }
    }

    public final void l(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, uri) == null) {
            BroadcastReceiver remove = this.f9796i.remove(uri);
            if (remove != null) {
                context.unregisterReceiver(remove);
            }
            Timer remove2 = this.j.remove(uri);
            if (remove2 != null) {
                remove2.cancel();
            }
        }
    }

    public synchronized boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.f9788a > 500) {
                    this.f9788a = System.currentTimeMillis();
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void o(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, downloadInfo) == null) {
            downloadInfo.setStatus(DownloadState.DOWNLOAD_PAUSED.value());
            this.f9790c.remove(downloadInfo.getId());
            this.f9793f.b(downloadInfo);
            q();
        }
    }

    public final void p(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, downloadInfo) == null) {
            if (this.f9790c.size() >= this.f9795h.b()) {
                downloadInfo.setStatus(DownloadState.WAIT.value());
                this.f9793f.b(downloadInfo);
                return;
            }
            b.a.p0.f.i.k.d.c cVar = new b.a.p0.f.i.k.d.c(this.f9789b, this.f9793f, downloadInfo, this);
            this.f9790c.put(downloadInfo.getId(), cVar);
            downloadInfo.setStatus(DownloadState.PREPARE_DOWNLOAD.value());
            this.f9793f.b(downloadInfo);
            cVar.c();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (DownloadInfo downloadInfo : this.f9791d) {
                if (downloadInfo.getStatus() == DownloadState.WAIT.value()) {
                    p(downloadInfo);
                    return;
                }
            }
        }
    }
}
