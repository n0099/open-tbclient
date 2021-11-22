package b.o.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
/* loaded from: classes6.dex */
public class b2 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Info f34093e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f34094f;

    public b2(WDownLoadService wDownLoadService, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wDownLoadService, info};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34094f = wDownLoadService;
        this.f34093e = info;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Info info = this.f34093e;
            WDownLoadService wDownLoadService = this.f34094f;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(m1.win_wdownload_download_finish), this.f34094f.getString(m1.win_wdownload_download_finish), 100);
        }
    }
}
