package c.a.o0.f.i.k.d;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.f.i.k.d.c;
import c.a.o0.f.i.k.f.e;
import c.a.o0.f.i.r.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
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
public final class a implements c.a.o0.f.i.k.f.d, c.a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static a k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f10538a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f10539b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f10540c;

    /* renamed from: d  reason: collision with root package name */
    public final List<DownloadInfo> f10541d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f10542e;

    /* renamed from: f  reason: collision with root package name */
    public final e f10543f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.o0.f.i.k.f.b f10544g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.o0.f.i.k.c.a f10545h;

    /* renamed from: i  reason: collision with root package name */
    public ConcurrentHashMap<Uri, BroadcastReceiver> f10546i;

    /* renamed from: j  reason: collision with root package name */
    public ConcurrentHashMap<Uri, Timer> f10547j;

    /* renamed from: c.a.o0.f.i.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0523a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a this$0;
        public final /* synthetic */ d val$listener;
        public final /* synthetic */ String val$packageName;
        public final /* synthetic */ Uri val$uri;

        public C0523a(a aVar, String str, d dVar, Uri uri) {
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
        public final /* synthetic */ d f10548e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f10549f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Uri f10550g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f10551h;

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
            this.f10551h = aVar;
            this.f10548e = dVar;
            this.f10549f = context;
            this.f10550g = uri;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10548e.a(Boolean.FALSE);
                this.f10551h.l(this.f10549f, this.f10550g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Timer f10552e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10553f;

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
            this.f10553f = aVar;
            this.f10552e = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Map.Entry entry : this.f10553f.f10546i.entrySet()) {
                    a aVar = this.f10553f;
                    aVar.l(aVar.f10542e, (Uri) entry.getKey());
                }
                this.f10552e.cancel();
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

    public a(Context context, c.a.o0.f.i.k.c.a aVar) {
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
        this.f10546i = new ConcurrentHashMap<>();
        this.f10547j = new ConcurrentHashMap<>();
        this.f10542e = context;
        if (aVar == null) {
            this.f10545h = new c.a.o0.f.i.k.c.a();
        } else {
            this.f10545h = aVar;
        }
        if (this.f10545h.a() == null) {
            this.f10544g = new c.a.o0.f.i.k.e.a(context, this.f10545h);
        } else {
            this.f10544g = this.f10545h.a();
        }
        this.f10541d = new ArrayList();
        this.f10540c = new ConcurrentHashMap<>();
        this.f10544g.b();
        this.f10539b = Executors.newFixedThreadPool(this.f10545h.b());
        this.f10543f = new c.a.o0.f.i.k.d.b(this.f10544g);
    }

    public static synchronized c.a.o0.f.i.k.f.d m(Context context, c.a.o0.f.i.k.c.a aVar) {
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
        return (c.a.o0.f.i.k.f.d) invokeLL.objValue;
    }

    @Override // c.a.o0.f.i.k.f.d
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

    @Override // c.a.o0.f.i.k.f.d
    public synchronized void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
            synchronized (this) {
                if (downloadInfo == null) {
                    return;
                }
                downloadInfo.setStatus(DownloadState.DELETED.value());
                this.f10540c.remove(downloadInfo.getId());
                this.f10541d.remove(downloadInfo);
                this.f10544g.d(downloadInfo);
                this.f10543f.b(downloadInfo);
                new File(downloadInfo.getPath()).delete();
            }
        }
    }

    @Override // c.a.o0.f.i.k.f.d
    public synchronized void c(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) {
            synchronized (this) {
                this.f10541d.add(downloadInfo);
                p(downloadInfo);
            }
        }
    }

    @Override // c.a.o0.f.i.k.f.d
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

    @Override // c.a.o0.f.i.k.f.d
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                k();
                if (this.f10544g != null) {
                    this.f10544g.close();
                }
                if (this.f10539b != null) {
                    this.f10539b.shutdownNow();
                    this.f10539b = null;
                }
                k = null;
            }
        }
    }

    @Override // c.a.o0.f.i.k.d.c.a
    public synchronized void e(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, downloadInfo) == null) {
            synchronized (this) {
                g.c(downloadInfo.getPath(), false);
                this.f10540c.remove(downloadInfo.getId());
                this.f10541d.remove(downloadInfo);
                q();
            }
        }
    }

    @Override // c.a.o0.f.i.k.f.d
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
                intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                C0523a c0523a = new C0523a(this, str, dVar, uri);
                appContext.registerReceiver(c0523a, intentFilter);
                Timer timer = new Timer();
                timer.schedule(new b(this, dVar, appContext, uri), 60000L);
                this.f10546i.put(uri, c0523a);
                this.f10547j.put(uri, timer);
            }
        }
    }

    @Override // c.a.o0.f.i.k.f.d
    public synchronized DownloadInfo g(String str) {
        InterceptResult invokeL;
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                downloadInfo = null;
                Iterator<DownloadInfo> it = this.f10541d.iterator();
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
                    downloadInfo = this.f10544g.c(str);
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
            BroadcastReceiver remove = this.f10546i.remove(uri);
            if (remove != null) {
                context.unregisterReceiver(remove);
            }
            Timer remove2 = this.f10547j.remove(uri);
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
                if (System.currentTimeMillis() - this.f10538a > 500) {
                    this.f10538a = System.currentTimeMillis();
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
            this.f10540c.remove(downloadInfo.getId());
            this.f10543f.b(downloadInfo);
            q();
        }
    }

    public final void p(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, downloadInfo) == null) {
            if (this.f10540c.size() >= this.f10545h.b()) {
                downloadInfo.setStatus(DownloadState.WAIT.value());
                this.f10543f.b(downloadInfo);
                return;
            }
            c.a.o0.f.i.k.d.c cVar = new c.a.o0.f.i.k.d.c(this.f10539b, this.f10543f, downloadInfo, this);
            this.f10540c.put(downloadInfo.getId(), cVar);
            downloadInfo.setStatus(DownloadState.PREPARE_DOWNLOAD.value());
            this.f10543f.b(downloadInfo);
            cVar.c();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (DownloadInfo downloadInfo : this.f10541d) {
                if (downloadInfo.getStatus() == DownloadState.WAIT.value()) {
                    p(downloadInfo);
                    return;
                }
            }
        }
    }
}
