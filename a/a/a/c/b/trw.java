package a.a.a.c.b;

import android.os.Handler;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class trw implements d.a.l.b.c.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Executor f1449a;

    /* loaded from: classes.dex */
    public static class bv implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.a.l.b.c.b f1450a;

        /* renamed from: b  reason: collision with root package name */
        public final d.a.l.b.c.a f1451b;

        public bv(d.a.l.b.c.b bVar) {
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
            this.f1450a = bVar;
            this.f1451b = bVar.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                switch (this.f1450a.h()) {
                    case 102:
                        d.a.l.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                        this.f1451b.onConnecting();
                        return;
                    case 103:
                        d.a.l.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.f1450a.e() + " acceptRanges: " + this.f1450a.i());
                        this.f1451b.onConnected(this.f1450a.e(), this.f1450a.i());
                        return;
                    case 104:
                        d.a.l.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.f1450a.d() + " length: " + this.f1450a.e() + " percent: " + this.f1450a.f());
                        this.f1451b.onProgress(this.f1450a.d(), this.f1450a.e(), this.f1450a.f());
                        return;
                    case 105:
                        d.a.l.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.f1450a.g());
                        if (this.f1450a.b()) {
                            return;
                        }
                        this.f1450a.l(true);
                        this.f1451b.onCompleted(this.f1450a.g());
                        return;
                    case 106:
                        d.a.l.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                        this.f1451b.onDownloadPaused();
                        return;
                    case 107:
                        d.a.l.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                        this.f1451b.onDownloadCanceled();
                        return;
                    case 108:
                        d.a.l.b.d.c.b(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.f1450a.c().getCause());
                        this.f1451b.onFailed((DownloadException) this.f1450a.c());
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public trw(Handler handler) {
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
        this.f1449a = new we(this, handler);
    }

    @Override // d.a.l.b.c.c
    public void post(d.a.l.b.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f1449a.execute(new bv(bVar));
        }
    }
}
