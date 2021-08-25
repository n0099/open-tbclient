package c.a.w0.k.f;

import android.os.Handler;
import com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public class c implements c.a.w0.k.e.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Executor f30648a;

    /* loaded from: classes4.dex */
    public class a implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f30649e;

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
            this.f30649e = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.f30649e.post(runnable);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final c.a.w0.k.e.c f30650e;

        /* renamed from: f  reason: collision with root package name */
        public final c.a.w0.k.e.a f30651f;

        public b(c.a.w0.k.e.c cVar) {
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
            this.f30650e = cVar;
            this.f30651f = cVar.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                switch (this.f30650e.h()) {
                    case 102:
                        c.a.w0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                        this.f30651f.c();
                        return;
                    case 103:
                        c.a.w0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.f30650e.e() + " acceptRanges: " + this.f30650e.i());
                        this.f30651f.b(this.f30650e.e(), this.f30650e.i());
                        return;
                    case 104:
                        c.a.w0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.f30650e.d() + " length: " + this.f30650e.e() + " percent: " + this.f30650e.f());
                        this.f30651f.g(this.f30650e.d(), this.f30650e.e(), this.f30650e.f());
                        return;
                    case 105:
                        c.a.w0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.f30650e.g());
                        if (this.f30650e.b()) {
                            return;
                        }
                        this.f30650e.l(true);
                        this.f30651f.a(this.f30650e.g());
                        return;
                    case 106:
                        c.a.w0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                        this.f30651f.e();
                        return;
                    case 107:
                        c.a.w0.t.i.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                        this.f30651f.d();
                        return;
                    case 108:
                        c.a.w0.t.i.c(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.f30650e.c().getCause());
                        this.f30651f.f((DownloadException) this.f30650e.c());
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
        this.f30648a = new a(this, handler);
    }

    @Override // c.a.w0.k.e.d
    public void a(c.a.w0.k.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f30648a.execute(new b(cVar));
        }
    }
}
