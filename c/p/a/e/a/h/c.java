package c.p.a.e.a.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import c.p.a.e.a.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f35030e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f35031f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f35032g;

        public a(Context context, DownloadInfo downloadInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, downloadInfo, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35030e = context;
            this.f35031f = downloadInfo;
            this.f35032g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.f u = c.p.a.e.a.e.G().u();
                c.p.a.e.b.f.e i2 = c.p.a.e.b.g.a.H(this.f35030e).i(this.f35031f.getId());
                if (u == null && i2 == null) {
                    return;
                }
                File file = new File(this.f35031f.getSavePath(), this.f35031f.getName());
                if (file.exists()) {
                    try {
                        PackageInfo i3 = c.p.a.e.a.d.i(this.f35031f, file);
                        if (i3 != null) {
                            String packageName = (this.f35032g == 1 || TextUtils.isEmpty(this.f35031f.getPackageName())) ? i3.packageName : this.f35031f.getPackageName();
                            if (u != null) {
                                u.b(this.f35031f.getId(), 1, packageName, -3, this.f35031f.getDownloadTime());
                            }
                            if (i2 != null) {
                                i2.a(1, this.f35031f, packageName, "");
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, downloadInfo) == null) {
            b(downloadInfo);
        }
    }

    public static void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, downloadInfo) == null) {
            Context n = c.p.a.e.b.g.e.n();
            boolean z = true;
            if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || c.p.a.e.a.d.K(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) && c.p.a.e.b.j.a.d(downloadInfo.getId()).b("auto_install_when_resume", 0) != 1) {
                z = false;
            }
            c.p.a.e.b.g.e.A0().execute(new a(n, downloadInfo, z ? c.p.a.e.a.d.d(n, downloadInfo.getId(), false) : 2));
        }
    }
}
