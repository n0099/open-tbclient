package c.a.y0.k.f;

import android.os.Handler;
import com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public class c implements c.a.y0.k.e.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Executor a;

    /* loaded from: classes3.dex */
    public class a implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f26734e;

        public a(c cVar, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26734e = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.f26734e.post(runnable);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final c.a.y0.k.e.c f26735e;

        /* renamed from: f  reason: collision with root package name */
        public final c.a.y0.k.e.a f26736f;

        public b(c.a.y0.k.e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26735e = cVar;
            this.f26736f = cVar.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                switch (this.f26735e.h()) {
                    case 102:
                        c.a.y0.r.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                        this.f26736f.c();
                        return;
                    case 103:
                        c.a.y0.r.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.f26735e.e() + " acceptRanges: " + this.f26735e.i());
                        this.f26736f.b(this.f26735e.e(), this.f26735e.i());
                        return;
                    case 104:
                        c.a.y0.r.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.f26735e.d() + " length: " + this.f26735e.e() + " percent: " + this.f26735e.f());
                        this.f26736f.g(this.f26735e.d(), this.f26735e.e(), this.f26735e.f());
                        return;
                    case 105:
                        c.a.y0.r.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.f26735e.g());
                        if (this.f26735e.b()) {
                            return;
                        }
                        this.f26735e.l(true);
                        this.f26736f.a(this.f26735e.g());
                        return;
                    case 106:
                        c.a.y0.r.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                        this.f26736f.e();
                        return;
                    case 107:
                        c.a.y0.r.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                        this.f26736f.d();
                        return;
                    case 108:
                        c.a.y0.r.i.c(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.f26735e.c().getCause());
                        this.f26736f.f((DownloadException) this.f26735e.c());
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public c(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this, handler);
    }

    @Override // c.a.y0.k.e.d
    public void a(c.a.y0.k.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.a.execute(new b(cVar));
        }
    }
}
