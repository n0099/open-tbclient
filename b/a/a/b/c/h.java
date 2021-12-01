package b.a.a.b.c;

import android.os.Handler;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class h implements c.a.a.c.c.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Executor a;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final c.a.a.c.c.b f1033e;

        /* renamed from: f  reason: collision with root package name */
        public final c.a.a.c.c.a f1034f;

        public a(c.a.a.c.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1033e = bVar;
            this.f1034f = bVar.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                switch (this.f1033e.h()) {
                    case 102:
                        c.a.a.c.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                        this.f1034f.c();
                        return;
                    case 103:
                        c.a.a.c.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.f1033e.e() + " acceptRanges: " + this.f1033e.i());
                        this.f1034f.b(this.f1033e.e(), this.f1033e.i());
                        return;
                    case 104:
                        c.a.a.c.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.f1033e.d() + " length: " + this.f1033e.e() + " percent: " + this.f1033e.f());
                        this.f1034f.g(this.f1033e.d(), this.f1033e.e(), this.f1033e.f());
                        return;
                    case 105:
                        c.a.a.c.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.f1033e.g());
                        if (this.f1033e.b()) {
                            return;
                        }
                        this.f1033e.l(true);
                        this.f1034f.a(this.f1033e.g());
                        return;
                    case 106:
                        c.a.a.c.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                        this.f1034f.e();
                        return;
                    case 107:
                        c.a.a.c.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                        this.f1034f.d();
                        return;
                    case 108:
                        c.a.a.c.d.c.b(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.f1033e.c().getCause());
                        this.f1034f.f((DownloadException) this.f1033e.c());
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f1035e;

        public b(h hVar, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1035e = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.f1035e.post(runnable);
            }
        }
    }

    public h(Handler handler) {
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
        this.a = new b(this, handler);
    }

    @Override // c.a.a.c.c.c
    public void a(c.a.a.c.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.a.execute(new a(bVar));
        }
    }
}
