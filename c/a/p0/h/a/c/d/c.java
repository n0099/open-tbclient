package c.a.p0.h.a.c.d;

import c.a.p0.h.a.c.d.d;
import c.a.p0.h.a.c.f.e;
import c.a.p0.h.a.k.g;
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
/* loaded from: classes2.dex */
public class c implements d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExecutorService a;

    /* renamed from: b  reason: collision with root package name */
    public final e f9943b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f9944c;

    /* renamed from: d  reason: collision with root package name */
    public final a f9945d;

    /* renamed from: e  reason: collision with root package name */
    public long f9946e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f9947f;

    /* loaded from: classes2.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9946e = System.currentTimeMillis();
        this.f9947f = new AtomicBoolean(false);
        this.a = executorService;
        this.f9943b = eVar;
        this.f9944c = downloadInfo;
        this.f9945d = aVar;
    }

    @Override // c.a.p0.h.a.c.d.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f9944c.getProgress() == this.f9944c.getSize()) {
            this.f9944c.setPackageName(g.d(AppRuntime.getAppContext(), this.f9944c.getPath()));
            this.f9944c.setStatus(DownloadState.DOWNLOADED.value());
            this.f9943b.b(this.f9944c);
            a aVar = this.f9945d;
            if (aVar != null) {
                aVar.e(this.f9944c);
            }
        }
    }

    @Override // c.a.p0.h.a.c.d.d.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f9947f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f9947f.get()) {
                this.f9947f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f9946e > 1000) {
                    this.f9943b.b(this.f9944c);
                    this.f9946e = currentTimeMillis;
                }
                this.f9947f.set(false);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.submit(new d(this.f9943b, this.f9944c, this));
        }
    }
}
