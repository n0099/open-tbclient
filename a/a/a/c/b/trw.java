package a.a.a.c.b;

import android.os.Handler;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.m.b.c.a;
import d.a.m.b.c.b;
import d.a.m.b.c.c;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class trw implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Executor f1482a;

    /* loaded from: classes.dex */
    public static class bv implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final b f1483a;

        /* renamed from: b  reason: collision with root package name */
        public final a f1484b;

        public bv(b bVar) {
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
            this.f1483a = bVar;
            this.f1484b = bVar.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                switch (this.f1483a.h()) {
                    case 102:
                        d.a.m.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                        this.f1484b.onConnecting();
                        return;
                    case 103:
                        d.a.m.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.f1483a.e() + " acceptRanges: " + this.f1483a.i());
                        this.f1484b.onConnected(this.f1483a.e(), this.f1483a.i());
                        return;
                    case 104:
                        d.a.m.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.f1483a.d() + " length: " + this.f1483a.e() + " percent: " + this.f1483a.f());
                        this.f1484b.onProgress(this.f1483a.d(), this.f1483a.e(), this.f1483a.f());
                        return;
                    case 105:
                        d.a.m.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.f1483a.g());
                        if (this.f1483a.b()) {
                            return;
                        }
                        this.f1483a.l(true);
                        this.f1484b.onCompleted(this.f1483a.g());
                        return;
                    case 106:
                        d.a.m.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                        this.f1484b.onDownloadPaused();
                        return;
                    case 107:
                        d.a.m.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                        this.f1484b.onDownloadCanceled();
                        return;
                    case 108:
                        d.a.m.b.d.c.b(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.f1483a.c().getCause());
                        this.f1484b.onFailed((DownloadException) this.f1483a.c());
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
        this.f1482a = new we(this, handler);
    }

    @Override // d.a.m.b.c.c
    public void post(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f1482a.execute(new bv(bVar));
        }
    }
}
