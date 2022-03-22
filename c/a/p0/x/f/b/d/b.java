package c.a.p0.x.f.b.d;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.e;
import c.a.p0.l3.a0;
import c.a.p0.x.g.d;
import c.a.p0.x.g.g.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class b extends c.a.p0.x.g.g.a<c.a.p0.x.g.g.b, AdDownloadData> implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public PermissionJudgePolicy f20599c;

    /* renamed from: d  reason: collision with root package name */
    public final d f20600d;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2020946397, "Lc/a/p0/x/f/b/d/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2020946397, "Lc/a/p0/x/f/b/d/b$a;");
                    return;
                }
            }
            int[] iArr = new int[DownloadStatus.values().length];
            a = iArr;
            try {
                iArr[DownloadStatus.STATUS_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DownloadStatus.STATUS_DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DownloadStatus.STATUS_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[DownloadStatus.STATUS_SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[DownloadStatus.STATUS_INSTALL_SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.p0.x.g.g.b bVar, @NonNull AdDownloadData adDownloadData) {
        super(bVar, adDownloadData);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, adDownloadData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.p0.x.g.g.b) objArr2[0], (IDownloadModel) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20600d = new d(this, adDownloadData);
    }

    @Override // c.a.p0.x.g.g.a, c.a.p0.x.g.g.c
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.a(i);
            if (g().getContentLength() <= 1) {
                AdDownloadData g2 = g();
                long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(g2.adId(), 0L);
                g2.setContentLength(Math.max(g().getContentLength(), j));
                this.f20600d.d(j);
            }
        }
    }

    @Override // c.a.p0.x.g.g.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k();
            this.f20600d.a();
        }
    }

    @Override // c.a.p0.x.g.g.a, c.a.p0.x.g.g.c
    public void d(@NonNull DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadStatus) == null) {
            super.d(downloadStatus);
            if (downloadStatus == DownloadStatus.STATUS_SUCCESS || downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
                g().setFakePercent(0);
                g().setPercent(0);
            }
        }
    }

    @Override // c.a.p0.x.g.g.c
    public void e(@NonNull AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adDownloadData) == null) {
            super.i(adDownloadData);
        }
    }

    @Override // c.a.p0.x.g.g.a
    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.j(i);
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (h() == null || !(h().getRealView().getContext() instanceof Activity) || c.a.p0.a.h().u()) {
                return true;
            }
            if (this.f20599c == null) {
                this.f20599c = new PermissionJudgePolicy();
            }
            this.f20599c.clearRequestPermissionList();
            this.f20599c.appendRequestPermission((Activity) h().getRealView().getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
            return !this.f20599c.startRequestPermission((Activity) h().getRealView().getContext());
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.x.g.g.a
    /* renamed from: o */
    public void l(AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adDownloadData) == null) {
            if (adDownloadData == null) {
                if (e.e()) {
                    throw new IllegalArgumentException("data is null when switch status");
                }
                return;
            }
            DownloadStatus currentState = adDownloadData.getCurrentState();
            DownloadCacheKey h2 = c.a.p0.x.g.e.d().h(adDownloadData.adId());
            int i = a.a[currentState.ordinal()];
            if (i == 1) {
                if (h2 != null && n()) {
                    c.a.p0.x.g.e.d().m(h2, null);
                    this.f20600d.a();
                }
            } else if (i == 2) {
                c.a.p0.x.g.e.d().f(adDownloadData.adId());
            } else if (i == 3) {
                if (n()) {
                    c.a.p0.x.g.e.d().k(adDownloadData.adId());
                    this.f20600d.a();
                }
            } else if (i != 4) {
                if (i != 5) {
                    if (e.e()) {
                        throw new IllegalStateException("Invalid status, add more test");
                    }
                    return;
                }
                c.a.p0.x.g.e.d().p(h().getRealView().getContext(), adDownloadData.pkgName());
                adDownloadData.setFakePercent(0);
                adDownloadData.setPercent(0);
            } else if (h2 != null && n()) {
                String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
                boolean n = (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) ? false : c.a.p0.x.g.e.d().n(h().getRealView().getContext(), h2, adDownloadData.extra().getDownloadFilePath());
                if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists() || !n) {
                    adDownloadData.extra().setStatus(DownloadStatus.STATUS_NONE);
                    l(adDownloadData);
                }
                adDownloadData.setFakePercent(0);
                adDownloadData.setPercent(0);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.x.g.g.a
    /* renamed from: p */
    public void m(@NonNull AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, adDownloadData) == null) {
            if (a0.r(adDownloadData.getPkgName())) {
                adDownloadData.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                return;
            }
            String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
            if (TextUtils.isEmpty(downloadFilePath) && !TextUtils.isEmpty(adDownloadData.adId())) {
                downloadFilePath = c.a.p0.l3.b.h(adDownloadData.adId());
            }
            if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) {
                return;
            }
            adDownloadData.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        }
    }
}
