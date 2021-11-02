package b.a.p0.f.i.k.d;

import b.a.p0.f.i.k.d.d;
import b.a.p0.f.i.k.f.e;
import b.a.p0.f.i.r.g;
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
    public final ExecutorService f9806a;

    /* renamed from: b  reason: collision with root package name */
    public final e f9807b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f9808c;

    /* renamed from: d  reason: collision with root package name */
    public final a f9809d;

    /* renamed from: e  reason: collision with root package name */
    public long f9810e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f9811f;

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
        this.f9810e = System.currentTimeMillis();
        this.f9811f = new AtomicBoolean(false);
        this.f9806a = executorService;
        this.f9807b = eVar;
        this.f9808c = downloadInfo;
        this.f9809d = aVar;
    }

    @Override // b.a.p0.f.i.k.d.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f9808c.getProgress() == this.f9808c.getSize()) {
            this.f9808c.setPackageName(g.d(AppRuntime.getAppContext(), this.f9808c.getPath()));
            this.f9808c.setStatus(DownloadState.DOWNLOADED.value());
            this.f9807b.b(this.f9808c);
            a aVar = this.f9809d;
            if (aVar != null) {
                aVar.e(this.f9808c);
            }
        }
    }

    @Override // b.a.p0.f.i.k.d.d.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f9811f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f9811f.get()) {
                this.f9811f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f9810e > 1000) {
                    this.f9807b.b(this.f9808c);
                    this.f9810e = currentTimeMillis;
                }
                this.f9811f.set(false);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f9806a.submit(new d(this.f9807b, this.f9808c, this));
        }
    }
}
