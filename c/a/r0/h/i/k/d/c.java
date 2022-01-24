package c.a.r0.h.i.k.d;

import c.a.r0.h.i.k.d.d;
import c.a.r0.h.i.k.f.e;
import c.a.r0.h.i.s.g;
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
    public final e f10618b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f10619c;

    /* renamed from: d  reason: collision with root package name */
    public final a f10620d;

    /* renamed from: e  reason: collision with root package name */
    public long f10621e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f10622f;

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
        this.f10621e = System.currentTimeMillis();
        this.f10622f = new AtomicBoolean(false);
        this.a = executorService;
        this.f10618b = eVar;
        this.f10619c = downloadInfo;
        this.f10620d = aVar;
    }

    @Override // c.a.r0.h.i.k.d.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f10619c.getProgress() == this.f10619c.getSize()) {
            this.f10619c.setPackageName(g.d(AppRuntime.getAppContext(), this.f10619c.getPath()));
            this.f10619c.setStatus(DownloadState.DOWNLOADED.value());
            this.f10618b.b(this.f10619c);
            a aVar = this.f10620d;
            if (aVar != null) {
                aVar.e(this.f10619c);
            }
        }
    }

    @Override // c.a.r0.h.i.k.d.d.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f10622f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f10622f.get()) {
                this.f10622f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f10621e > 1000) {
                    this.f10618b.b(this.f10619c);
                    this.f10621e = currentTimeMillis;
                }
                this.f10622f.set(false);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.submit(new d(this.f10618b, this.f10619c, this));
        }
    }
}
