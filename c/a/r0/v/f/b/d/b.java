package c.a.r0.v.f.b.d;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.h3.z;
import c.a.r0.v.g.d;
import c.a.r0.v.g.e;
import c.a.r0.v.g.g.c;
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
/* loaded from: classes7.dex */
public class b extends c.a.r0.v.g.g.a<c.a.r0.v.g.g.b, AdDownloadData> implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public PermissionJudgePolicy f24605g;

    /* renamed from: h  reason: collision with root package name */
    public final d f24606h;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(482917281, "Lc/a/r0/v/f/b/d/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(482917281, "Lc/a/r0/v/f/b/d/b$a;");
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
    public b(@NonNull c.a.r0.v.g.g.b bVar, @NonNull AdDownloadData adDownloadData) {
        super(bVar, adDownloadData);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, adDownloadData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.r0.v.g.g.b) objArr2[0], (IDownloadModel) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24606h = new d(this, adDownloadData);
    }

    @Override // c.a.r0.v.g.g.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j();
            this.f24606h.a();
        }
    }

    @Override // c.a.r0.v.g.g.a, c.a.r0.v.g.g.c
    public void c(@NonNull DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadStatus) == null) {
            super.c(downloadStatus);
            if (downloadStatus == DownloadStatus.STATUS_SUCCESS || downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
                f().setFakePercent(0);
                f().setPercent(0);
            }
        }
    }

    @Override // c.a.r0.v.g.g.c
    public void d(@NonNull AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adDownloadData) == null) {
            super.h(adDownloadData);
        }
    }

    @Override // c.a.r0.v.g.g.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.i(i2);
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (g() == null || !(g().getRealView().getContext() instanceof Activity) || c.a.r0.a.h().u()) {
                return true;
            }
            if (this.f24605g == null) {
                this.f24605g = new PermissionJudgePolicy();
            }
            this.f24605g.clearRequestPermissionList();
            this.f24605g.appendRequestPermission((Activity) g().getRealView().getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
            return !this.f24605g.startRequestPermission((Activity) g().getRealView().getContext());
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.v.g.g.a
    /* renamed from: n */
    public void k(AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, adDownloadData) == null) || adDownloadData == null) {
            return;
        }
        DownloadStatus currentState = adDownloadData.getCurrentState();
        DownloadCacheKey h2 = e.d().h(adDownloadData.adId());
        int i2 = a.a[currentState.ordinal()];
        if (i2 == 1) {
            if (h2 != null && m()) {
                e.d().m(h2, null);
                this.f24606h.a();
            }
        } else if (i2 == 2) {
            e.d().f(adDownloadData.adId());
        } else if (i2 == 3) {
            if (m()) {
                e.d().k(adDownloadData.adId());
                this.f24606h.a();
            }
        } else if (i2 != 4) {
            if (i2 != 5) {
                return;
            }
            e.d().p(g().getRealView().getContext(), adDownloadData.pkgName());
            adDownloadData.setFakePercent(0);
            adDownloadData.setPercent(0);
        } else if (h2 != null && m()) {
            String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
            boolean n = (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) ? false : e.d().n(g().getRealView().getContext(), h2, adDownloadData.extra().getDownloadFilePath());
            if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists() || !n) {
                adDownloadData.extra().setStatus(DownloadStatus.STATUS_NONE);
                k(adDownloadData);
            }
            adDownloadData.setFakePercent(0);
            adDownloadData.setPercent(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.v.g.g.a
    /* renamed from: o */
    public void l(@NonNull AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adDownloadData) == null) {
            if (z.r(adDownloadData.getPkgName())) {
                adDownloadData.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                return;
            }
            String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
            if (TextUtils.isEmpty(downloadFilePath) && !TextUtils.isEmpty(adDownloadData.adId())) {
                downloadFilePath = c.a.r0.h3.b.h(adDownloadData.adId());
            }
            if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) {
                return;
            }
            adDownloadData.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        }
    }

    @Override // c.a.r0.v.g.g.a, c.a.r0.v.g.g.c
    public void onProgressChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onProgressChanged(i2);
            if (f().getContentLength() <= 1) {
                AdDownloadData f2 = f();
                long j2 = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(f2.adId(), 0L);
                f2.setContentLength(Math.max(f().getContentLength(), j2));
                this.f24606h.d(j2);
            }
        }
    }
}
