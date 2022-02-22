package c.a.s0.h.i.k.d;

import c.a.s0.h.i.k.d.d;
import c.a.s0.h.i.k.f.e;
import c.a.s0.h.i.s.g;
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
    public final e f10718b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f10719c;

    /* renamed from: d  reason: collision with root package name */
    public final a f10720d;

    /* renamed from: e  reason: collision with root package name */
    public long f10721e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f10722f;

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
        this.f10721e = System.currentTimeMillis();
        this.f10722f = new AtomicBoolean(false);
        this.a = executorService;
        this.f10718b = eVar;
        this.f10719c = downloadInfo;
        this.f10720d = aVar;
    }

    @Override // c.a.s0.h.i.k.d.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f10719c.getProgress() == this.f10719c.getSize()) {
            this.f10719c.setPackageName(g.d(AppRuntime.getAppContext(), this.f10719c.getPath()));
            this.f10719c.setStatus(DownloadState.DOWNLOADED.value());
            this.f10718b.b(this.f10719c);
            a aVar = this.f10720d;
            if (aVar != null) {
                aVar.e(this.f10719c);
            }
        }
    }

    @Override // c.a.s0.h.i.k.d.d.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f10722f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f10722f.get()) {
                this.f10722f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f10721e > 1000) {
                    this.f10718b.b(this.f10719c);
                    this.f10721e = currentTimeMillis;
                }
                this.f10722f.set(false);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.submit(new d(this.f10718b, this.f10719c, this));
        }
    }
}
