package c.a.a0.j.g.d;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.a0.j.g.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.SpeedCalculator;
import com.baidu.searchbox.bddownload.StatusUtil;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.listener.DownloadSpeedListener;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class a implements IAdDownloader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<Integer, DownloadTask> a;

    /* renamed from: c.a.a0.j.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0035a extends DownloadSpeedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f1283b;

        /* renamed from: c  reason: collision with root package name */
        public long f1284c;

        /* renamed from: d  reason: collision with root package name */
        public c f1285d;

        public C0035a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1285d = cVar;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void blockEnd(@NonNull DownloadTask downloadTask, int i, BlockInfo blockInfo, @NonNull SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, downloadTask, i, blockInfo, speedCalculator) == null) {
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectEnd(@NonNull DownloadTask downloadTask, int i, int i2, @NonNull Map<String, List<String>> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{downloadTask, Integer.valueOf(i), Integer.valueOf(i2), map}) == null) {
                String str = "Connect End " + i;
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectStart(@NonNull DownloadTask downloadTask, int i, @NonNull Map<String, List<String>> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, i, map) == null) {
                String str = "Connect Start " + i;
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void infoReady(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, boolean z, @NonNull ListenerSpeedAssistExtend.Listener4SpeedModel listener4SpeedModel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{downloadTask, breakpointInfo, Boolean.valueOf(z), listener4SpeedModel}) == null) {
                long totalLength = breakpointInfo.getTotalLength();
                this.a = totalLength;
                this.f1283b = Util.humanReadableBytes(totalLength, true);
                this.f1285d.b(this.a, downloadTask.getFile());
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void progress(@NonNull DownloadTask downloadTask, long j, @NonNull SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{downloadTask, Long.valueOf(j), speedCalculator}) == null) {
                String str = (Util.humanReadableBytes(j, true) + "/" + this.f1283b) + "(" + speedCalculator.speed() + SmallTailInfo.EMOTION_SUFFIX;
                this.f1284c = j;
                this.f1285d.a(downloadTask.getId(), j, this.a);
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void progressBlock(@NonNull DownloadTask downloadTask, int i, long j, @NonNull SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{downloadTask, Integer.valueOf(i), Long.valueOf(j), speedCalculator}) == null) {
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc, @NonNull SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048582, this, downloadTask, endCause, exc, speedCalculator) == null) {
                downloadTask.removeTag();
                if (endCause == EndCause.COMPLETED) {
                    this.f1285d.onSuccess(downloadTask.getId());
                } else if (endCause == EndCause.CANCELED) {
                    this.f1285d.c(downloadTask.getId(), (int) ((this.f1284c / this.a) * 100.0d));
                } else if (endCause == EndCause.ERROR) {
                    this.f1285d.onError();
                } else {
                    this.f1285d.onError();
                }
                if (!c.a.a0.a.a || exc == null) {
                    return;
                }
                Context b2 = c.a.a0.h.a.b();
                Toast.makeText(b2, "下载失败！原因：" + exc, 0).show();
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void taskStart(@NonNull DownloadTask downloadTask) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, downloadTask) == null) {
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        AppRuntimeInit.onApplicationattachBaseContext((Application) c.a.a0.h.a.b());
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public int a(String str, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, cVar)) == null) {
            DownloadTask build = new DownloadTask.Builder(str, c.a.a0.j.i.c.a(c.a.a0.h.a.b())).setPassIfAlreadyCompleted(false).build();
            C0035a c0035a = new C0035a(cVar);
            if (build.getTag() != null) {
                build.cancel();
            }
            build.enqueue(c0035a);
            build.setTag("mark-task-started");
            c.a.a0.x.c.e(this.a, Integer.valueOf(build.getId()), build);
            return build.getId();
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void b(int i) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (downloadTask = (DownloadTask) c.a.a0.x.c.b(this.a, Integer.valueOf(i))) == null || downloadTask.getTag() == null) {
            return;
        }
        downloadTask.cancel();
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void c(int i, String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, cVar) == null) {
            DownloadTask downloadTask = (DownloadTask) c.a.a0.x.c.b(this.a, Integer.valueOf(i));
            if (downloadTask != null && StatusUtil.getStatus(downloadTask) == StatusUtil.Status.IDLE) {
                downloadTask.setTag("mark-task-started");
                downloadTask.enqueue(new C0035a(cVar));
                return;
            }
            a(str, cVar);
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
        }
    }
}
