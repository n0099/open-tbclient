package c.a.n0.h.a.c.d;

import c.a.n0.h.a.c.d.d;
import c.a.n0.h.a.c.f.e;
import c.a.n0.h.a.k.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class c implements d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExecutorService a;

    /* renamed from: b  reason: collision with root package name */
    public final e f8328b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f8329c;

    /* renamed from: d  reason: collision with root package name */
    public final a f8330d;

    /* renamed from: e  reason: collision with root package name */
    public long f8331e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f8332f;

    /* loaded from: classes.dex */
    public interface a {
        void e(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, e eVar, DownloadInfo downloadInfo, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService, eVar, downloadInfo, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8331e = System.currentTimeMillis();
        this.f8332f = new AtomicBoolean(false);
        this.a = executorService;
        this.f8328b = eVar;
        this.f8329c = downloadInfo;
        this.f8330d = aVar;
    }

    @Override // c.a.n0.h.a.c.d.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f8329c.getProgress() == this.f8329c.getSize()) {
            this.f8329c.setPackageName(g.d(AppRuntime.getAppContext(), this.f8329c.getPath()));
            this.f8329c.setStatus(DownloadState.DOWNLOADED.value());
            this.f8328b.b(this.f8329c);
            a aVar = this.f8330d;
            if (aVar != null) {
                aVar.e(this.f8329c);
            }
        }
    }

    @Override // c.a.n0.h.a.c.d.d.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f8332f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f8332f.get()) {
                this.f8332f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f8331e > 1000) {
                    this.f8328b.b(this.f8329c);
                    this.f8331e = currentTimeMillis;
                }
                this.f8332f.set(false);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.submit(new d(this.f8328b, this.f8329c, this));
        }
    }
}
