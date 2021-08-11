package c.a.n0.f.i.k.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import c.a.n0.f.i.k.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f10308a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.n0.f.i.k.f.b f10309b;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                DownloadInfo downloadInfo = (DownloadInfo) message.obj;
                int status = downloadInfo.getStatus();
                if (downloadInfo.getDownloadListener() == null) {
                    return;
                }
                switch (C0516b.f10310a[DownloadState.convert(status).ordinal()]) {
                    case 1:
                        downloadInfo.getDownloadListener().e(downloadInfo.getProgress(), downloadInfo.getSize());
                        return;
                    case 2:
                        downloadInfo.getDownloadListener().onStart();
                        return;
                    case 3:
                        downloadInfo.getDownloadListener().d();
                        return;
                    case 4:
                        downloadInfo.getDownloadListener().f(downloadInfo.getProgress(), downloadInfo.getSize());
                        return;
                    case 5:
                        downloadInfo.getDownloadListener().a();
                        return;
                    case 6:
                        downloadInfo.getDownloadListener().b(downloadInfo.getException());
                        return;
                    case 7:
                        downloadInfo.getDownloadListener().c();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: c.a.n0.f.i.k.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0516b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10310a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1106795520, "Lc/a/n0/f/i/k/d/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1106795520, "Lc/a/n0/f/i/k/d/b$b;");
                    return;
                }
            }
            int[] iArr = new int[DownloadState.values().length];
            f10310a = iArr;
            try {
                iArr[DownloadState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10310a[DownloadState.PREPARE_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10310a[DownloadState.WAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10310a[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10310a[DownloadState.DOWNLOADED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10310a[DownloadState.DOWNLOAD_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10310a[DownloadState.DELETED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(c.a.n0.f.i.k.f.b bVar) {
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
        this.f10309b = bVar;
        this.f10308a = new a(this, Looper.getMainLooper());
    }

    @Override // c.a.n0.f.i.k.f.e
    public void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadException) == null) {
        }
    }

    @Override // c.a.n0.f.i.k.f.e
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
            if (downloadInfo.getStatus() != DownloadState.DELETED.value()) {
                this.f10309b.a(downloadInfo);
            }
            Message obtainMessage = this.f10308a.obtainMessage(downloadInfo.getId().hashCode());
            obtainMessage.obj = downloadInfo;
            obtainMessage.sendToTarget();
        }
    }
}
