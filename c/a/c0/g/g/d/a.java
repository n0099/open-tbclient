package c.a.c0.g.g.d;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.c0.g.g.c;
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

    /* renamed from: c.a.c0.g.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0060a extends DownloadSpeedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f1990e;

        /* renamed from: f  reason: collision with root package name */
        public String f1991f;

        /* renamed from: g  reason: collision with root package name */
        public long f1992g;

        /* renamed from: h  reason: collision with root package name */
        public c f1993h;

        public C0060a(c cVar) {
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
            this.f1993h = cVar;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void blockEnd(@NonNull DownloadTask downloadTask, int i2, BlockInfo blockInfo, @NonNull SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, downloadTask, i2, blockInfo, speedCalculator) == null) {
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectEnd(@NonNull DownloadTask downloadTask, int i2, int i3, @NonNull Map<String, List<String>> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{downloadTask, Integer.valueOf(i2), Integer.valueOf(i3), map}) == null) {
                String str = "Connect End " + i2;
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectStart(@NonNull DownloadTask downloadTask, int i2, @NonNull Map<String, List<String>> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, i2, map) == null) {
                String str = "Connect Start " + i2;
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void infoReady(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, boolean z, @NonNull ListenerSpeedAssistExtend.Listener4SpeedModel listener4SpeedModel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{downloadTask, breakpointInfo, Boolean.valueOf(z), listener4SpeedModel}) == null) {
                long totalLength = breakpointInfo.getTotalLength();
                this.f1990e = totalLength;
                this.f1991f = Util.humanReadableBytes(totalLength, true);
                this.f1993h.c(this.f1990e, downloadTask.getFile());
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void progress(@NonNull DownloadTask downloadTask, long j2, @NonNull SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{downloadTask, Long.valueOf(j2), speedCalculator}) == null) {
                String str = (Util.humanReadableBytes(j2, true) + "/" + this.f1991f) + "(" + speedCalculator.speed() + SmallTailInfo.EMOTION_SUFFIX;
                this.f1992g = j2;
                this.f1993h.a(downloadTask.getId(), j2, this.f1990e);
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void progressBlock(@NonNull DownloadTask downloadTask, int i2, long j2, @NonNull SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{downloadTask, Integer.valueOf(i2), Long.valueOf(j2), speedCalculator}) == null) {
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc, @NonNull SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048582, this, downloadTask, endCause, exc, speedCalculator) == null) {
                downloadTask.removeTag();
                if (endCause == EndCause.COMPLETED) {
                    this.f1993h.b(downloadTask.getId());
                } else if (endCause == EndCause.CANCELED) {
                    this.f1993h.d(downloadTask.getId(), (int) ((this.f1992g / this.f1990e) * 100.0d));
                } else if (endCause == EndCause.ERROR) {
                    this.f1993h.onError();
                } else {
                    this.f1993h.onError();
                }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        AppRuntimeInit.onApplicationattachBaseContext((Application) c.a.c0.e.a.b());
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public int a(String str, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, cVar)) == null) {
            DownloadTask build = new DownloadTask.Builder(str, c.a.c0.g.i.c.a(c.a.c0.e.a.b())).setPassIfAlreadyCompleted(false).build();
            C0060a c0060a = new C0060a(cVar);
            if (build.getTag() != null) {
                build.cancel();
            }
            build.enqueue(c0060a);
            build.setTag("mark-task-started");
            c.a.c0.u.c.e(this.a, Integer.valueOf(build.getId()), build);
            return build.getId();
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void b(int i2) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (downloadTask = (DownloadTask) c.a.c0.u.c.b(this.a, Integer.valueOf(i2))) == null || downloadTask.getTag() == null) {
            return;
        }
        downloadTask.cancel();
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void c(int i2, String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, str, cVar) == null) {
            DownloadTask downloadTask = (DownloadTask) c.a.c0.u.c.b(this.a, Integer.valueOf(i2));
            if (downloadTask != null && StatusUtil.getStatus(downloadTask) == StatusUtil.Status.IDLE) {
                downloadTask.setTag("mark-task-started");
                downloadTask.enqueue(new C0060a(cVar));
                return;
            }
            a(str, cVar);
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
        }
    }
}
