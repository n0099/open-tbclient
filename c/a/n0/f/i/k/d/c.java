package c.a.n0.f.i.k.d;

import c.a.n0.f.i.k.d.d;
import c.a.n0.f.i.k.f.e;
import c.a.n0.f.i.r.g;
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

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f10311a;

    /* renamed from: b  reason: collision with root package name */
    public final e f10312b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f10313c;

    /* renamed from: d  reason: collision with root package name */
    public final a f10314d;

    /* renamed from: e  reason: collision with root package name */
    public long f10315e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f10316f;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10315e = System.currentTimeMillis();
        this.f10316f = new AtomicBoolean(false);
        this.f10311a = executorService;
        this.f10312b = eVar;
        this.f10313c = downloadInfo;
        this.f10314d = aVar;
    }

    @Override // c.a.n0.f.i.k.d.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f10313c.getProgress() == this.f10313c.getSize()) {
            this.f10313c.setPackageName(g.d(AppRuntime.getAppContext(), this.f10313c.getPath()));
            this.f10313c.setStatus(DownloadState.DOWNLOADED.value());
            this.f10312b.b(this.f10313c);
            a aVar = this.f10314d;
            if (aVar != null) {
                aVar.e(this.f10313c);
            }
        }
    }

    @Override // c.a.n0.f.i.k.d.d.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f10316f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f10316f.get()) {
                this.f10316f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f10315e > 1000) {
                    this.f10312b.b(this.f10313c);
                    this.f10315e = currentTimeMillis;
                }
                this.f10316f.set(false);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f10311a.submit(new d(this.f10312b, this.f10313c, this));
        }
    }
}
