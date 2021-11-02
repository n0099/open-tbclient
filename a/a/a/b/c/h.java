package a.a.a.b.c;

import android.os.Handler;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class h implements b.a.a.c.c.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Executor f1042a;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final b.a.a.c.c.b f1043e;

        /* renamed from: f  reason: collision with root package name */
        public final b.a.a.c.c.a f1044f;

        public a(b.a.a.c.c.b bVar) {
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
            this.f1043e = bVar;
            this.f1044f = bVar.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                switch (this.f1043e.h()) {
                    case 102:
                        b.a.a.c.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                        this.f1044f.c();
                        return;
                    case 103:
                        b.a.a.c.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.f1043e.e() + " acceptRanges: " + this.f1043e.i());
                        this.f1044f.b(this.f1043e.e(), this.f1043e.i());
                        return;
                    case 104:
                        b.a.a.c.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.f1043e.d() + " length: " + this.f1043e.e() + " percent: " + this.f1043e.f());
                        this.f1044f.g(this.f1043e.d(), this.f1043e.e(), this.f1043e.f());
                        return;
                    case 105:
                        b.a.a.c.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.f1043e.g());
                        if (this.f1043e.b()) {
                            return;
                        }
                        this.f1043e.l(true);
                        this.f1044f.a(this.f1043e.g());
                        return;
                    case 106:
                        b.a.a.c.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                        this.f1044f.e();
                        return;
                    case 107:
                        b.a.a.c.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                        this.f1044f.d();
                        return;
                    case 108:
                        b.a.a.c.d.c.b(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.f1043e.c().getCause());
                        this.f1044f.f((DownloadException) this.f1043e.c());
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
        public final /* synthetic */ Handler f1045e;

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
            this.f1045e = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.f1045e.post(runnable);
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
        this.f1042a = new b(this, handler);
    }

    @Override // b.a.a.c.c.c
    public void a(b.a.a.c.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f1042a.execute(new a(bVar));
        }
    }
}
