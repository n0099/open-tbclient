package b.a.r0.r.d.b.d;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.r0.a3.z;
import b.a.r0.r.e.d;
import b.a.r0.r.e.e;
import b.a.r0.r.e.g.b;
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
/* loaded from: classes5.dex */
public class a extends b.a.r0.r.e.g.a<b, AdDownloadData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public PermissionJudgePolicy f24492c;

    /* renamed from: d  reason: collision with root package name */
    public final d f24493d;

    /* renamed from: b.a.r0.r.d.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C1189a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24494a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1204055495, "Lb/a/r0/r/d/b/d/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1204055495, "Lb/a/r0/r/d/b/d/a$a;");
                    return;
                }
            }
            int[] iArr = new int[DownloadStatus.values().length];
            f24494a = iArr;
            try {
                iArr[DownloadStatus.STATUS_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24494a[DownloadStatus.STATUS_DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24494a[DownloadStatus.STATUS_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24494a[DownloadStatus.STATUS_SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f24494a[DownloadStatus.STATUS_INSTALL_SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b bVar, @NonNull AdDownloadData adDownloadData) {
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
                super((b) objArr2[0], (IDownloadModel) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24493d = new d(this, adDownloadData);
    }

    @Override // b.a.r0.r.e.g.a
    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.g(i2);
            if (c().getContentLength() <= 1) {
                AdDownloadData c2 = c();
                long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(c2.adId(), 0L);
                c2.setContentLength(Math.max(c().getContentLength(), j));
                this.f24493d.d(j);
            }
        }
    }

    @Override // b.a.r0.r.e.g.a
    public void h(@NonNull DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadStatus) == null) {
            super.h(downloadStatus);
            if (downloadStatus == DownloadStatus.STATUS_SUCCESS || downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
                c().setFakePercent(0);
                c().setPercent(0);
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (d() == null || !(d().getRealView().getContext() instanceof Activity) || b.a.r0.a.h().u()) {
                return true;
            }
            if (this.f24492c == null) {
                this.f24492c = new PermissionJudgePolicy();
            }
            this.f24492c.clearRequestPermissionList();
            this.f24492c.appendRequestPermission((Activity) d().getRealView().getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
            return !this.f24492c.startRequestPermission((Activity) d().getRealView().getContext());
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            i();
            this.f24493d.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.r.e.g.a
    /* renamed from: n */
    public void j(AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, adDownloadData) == null) || adDownloadData == null) {
            return;
        }
        DownloadStatus currentState = adDownloadData.getCurrentState();
        DownloadCacheKey g2 = e.c().g(adDownloadData.adId());
        int i2 = C1189a.f24494a[currentState.ordinal()];
        if (i2 == 1) {
            if (g2 != null && l()) {
                e.c().l(g2, null);
                this.f24493d.a();
            }
        } else if (i2 == 2) {
            e.c().e(adDownloadData.adId());
        } else if (i2 == 3) {
            if (l()) {
                e.c().j(adDownloadData.adId());
                this.f24493d.a();
            }
        } else if (i2 != 4) {
            if (i2 != 5) {
                return;
            }
            e.c().o(d().getRealView().getContext(), adDownloadData.pkgName());
            adDownloadData.setFakePercent(0);
            adDownloadData.setPercent(0);
        } else if (g2 != null && l()) {
            String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
            boolean m = (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) ? false : e.c().m(d().getRealView().getContext(), g2, adDownloadData.extra().getDownloadFilePath());
            if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists() || !m) {
                adDownloadData.extra().setStatus(DownloadStatus.STATUS_NONE);
                j(adDownloadData);
            }
            adDownloadData.setFakePercent(0);
            adDownloadData.setPercent(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.r.e.g.a
    /* renamed from: o */
    public void k(@NonNull AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adDownloadData) == null) {
            if (z.q(adDownloadData.getPkgName())) {
                adDownloadData.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                return;
            }
            String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
            if (TextUtils.isEmpty(downloadFilePath) && !TextUtils.isEmpty(adDownloadData.adId())) {
                downloadFilePath = b.a.r0.a3.b.h(adDownloadData.adId());
            }
            if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) {
                return;
            }
            adDownloadData.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        }
    }
}
