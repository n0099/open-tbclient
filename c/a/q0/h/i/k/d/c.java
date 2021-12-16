package c.a.q0.h.i.k.d;

import c.a.q0.h.i.k.d.d;
import c.a.q0.h.i.k.f.e;
import c.a.q0.h.i.s.g;
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
/* loaded from: classes6.dex */
public class c implements d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExecutorService a;

    /* renamed from: b  reason: collision with root package name */
    public final e f9976b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f9977c;

    /* renamed from: d  reason: collision with root package name */
    public final a f9978d;

    /* renamed from: e  reason: collision with root package name */
    public long f9979e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f9980f;

    /* loaded from: classes6.dex */
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
        this.f9979e = System.currentTimeMillis();
        this.f9980f = new AtomicBoolean(false);
        this.a = executorService;
        this.f9976b = eVar;
        this.f9977c = downloadInfo;
        this.f9978d = aVar;
    }

    @Override // c.a.q0.h.i.k.d.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f9977c.getProgress() == this.f9977c.getSize()) {
            this.f9977c.setPackageName(g.d(AppRuntime.getAppContext(), this.f9977c.getPath()));
            this.f9977c.setStatus(DownloadState.DOWNLOADED.value());
            this.f9976b.b(this.f9977c);
            a aVar = this.f9978d;
            if (aVar != null) {
                aVar.e(this.f9977c);
            }
        }
    }

    @Override // c.a.q0.h.i.k.d.d.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f9980f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f9980f.get()) {
                this.f9980f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f9979e > 1000) {
                    this.f9976b.b(this.f9977c);
                    this.f9979e = currentTimeMillis;
                }
                this.f9980f.set(false);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.submit(new d(this.f9976b, this.f9977c, this));
        }
    }
}
