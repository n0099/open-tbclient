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
    public final ExecutorService f10593a;

    /* renamed from: b  reason: collision with root package name */
    public final e f10594b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f10595c;

    /* renamed from: d  reason: collision with root package name */
    public final a f10596d;

    /* renamed from: e  reason: collision with root package name */
    public long f10597e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f10598f;

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
        this.f10597e = System.currentTimeMillis();
        this.f10598f = new AtomicBoolean(false);
        this.f10593a = executorService;
        this.f10594b = eVar;
        this.f10595c = downloadInfo;
        this.f10596d = aVar;
    }

    @Override // c.a.p0.f.i.k.d.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f10595c.getProgress() == this.f10595c.getSize()) {
            this.f10595c.setPackageName(g.d(AppRuntime.getAppContext(), this.f10595c.getPath()));
            this.f10595c.setStatus(DownloadState.DOWNLOADED.value());
            this.f10594b.b(this.f10595c);
            a aVar = this.f10596d;
            if (aVar != null) {
                aVar.e(this.f10595c);
            }
        }
    }

    @Override // c.a.p0.f.i.k.d.d.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f10598f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f10598f.get()) {
                this.f10598f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f10597e > 1000) {
                    this.f10594b.b(this.f10595c);
                    this.f10597e = currentTimeMillis;
                }
                this.f10598f.set(false);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f10593a.submit(new d(this.f10594b, this.f10595c, this));
        }
    }
}
