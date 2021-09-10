package c.a.p0.f.i.k.d;

import c.a.p0.f.i.k.d.d;
import c.a.p0.f.i.k.f.e;
import c.a.p0.f.i.r.g;
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
    public final ExecutorService f10585a;

    /* renamed from: b  reason: collision with root package name */
    public final e f10586b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f10587c;

    /* renamed from: d  reason: collision with root package name */
    public final a f10588d;

    /* renamed from: e  reason: collision with root package name */
    public long f10589e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f10590f;

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
        this.f10589e = System.currentTimeMillis();
        this.f10590f = new AtomicBoolean(false);
        this.f10585a = executorService;
        this.f10586b = eVar;
        this.f10587c = downloadInfo;
        this.f10588d = aVar;
    }

    @Override // c.a.p0.f.i.k.d.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f10587c.getProgress() == this.f10587c.getSize()) {
            this.f10587c.setPackageName(g.d(AppRuntime.getAppContext(), this.f10587c.getPath()));
            this.f10587c.setStatus(DownloadState.DOWNLOADED.value());
            this.f10586b.b(this.f10587c);
            a aVar = this.f10588d;
            if (aVar != null) {
                aVar.e(this.f10587c);
            }
        }
    }

    @Override // c.a.p0.f.i.k.d.d.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f10590f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f10590f.get()) {
                this.f10590f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f10589e > 1000) {
                    this.f10586b.b(this.f10587c);
                    this.f10589e = currentTimeMillis;
                }
                this.f10590f.set(false);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f10585a.submit(new d(this.f10586b, this.f10587c, this));
        }
    }
}
