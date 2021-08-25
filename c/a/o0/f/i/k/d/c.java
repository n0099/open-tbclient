package c.a.o0.f.i.k.d;

import c.a.o0.f.i.k.d.d;
import c.a.o0.f.i.k.f.e;
import c.a.o0.f.i.r.g;
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
    public final ExecutorService f10557a;

    /* renamed from: b  reason: collision with root package name */
    public final e f10558b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f10559c;

    /* renamed from: d  reason: collision with root package name */
    public final a f10560d;

    /* renamed from: e  reason: collision with root package name */
    public long f10561e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f10562f;

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
        this.f10561e = System.currentTimeMillis();
        this.f10562f = new AtomicBoolean(false);
        this.f10557a = executorService;
        this.f10558b = eVar;
        this.f10559c = downloadInfo;
        this.f10560d = aVar;
    }

    @Override // c.a.o0.f.i.k.d.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f10559c.getProgress() == this.f10559c.getSize()) {
            this.f10559c.setPackageName(g.d(AppRuntime.getAppContext(), this.f10559c.getPath()));
            this.f10559c.setStatus(DownloadState.DOWNLOADED.value());
            this.f10558b.b(this.f10559c);
            a aVar = this.f10560d;
            if (aVar != null) {
                aVar.e(this.f10559c);
            }
        }
    }

    @Override // c.a.o0.f.i.k.d.d.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f10562f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f10562f.get()) {
                this.f10562f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f10561e > 1000) {
                    this.f10558b.b(this.f10559c);
                    this.f10561e = currentTimeMillis;
                }
                this.f10562f.set(false);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f10557a.submit(new d(this.f10558b, this.f10559c, this));
        }
    }
}
