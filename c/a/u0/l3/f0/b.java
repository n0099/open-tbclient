package c.a.u0.l3.f0;

import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b implements c.a.u0.v.g.i.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f19198d = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, DownloadCacheKey> f19199b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.u0.v.g.h.c f19200c;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.u0.l3.f0.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1191b implements c.a.u0.v.g.h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1191b(b bVar) {
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
            this.a = bVar;
        }

        @Override // c.a.u0.v.g.h.c
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                c.a.u0.v.g.h.a a = c.a.u0.v.g.e.d().a((DownloadCacheKey) this.a.f19199b.get(str));
                if (a == null) {
                    return;
                }
                a.a(str, i2);
            }
        }

        @Override // c.a.u0.v.g.h.c
        public void b(String str, StopStatus stopStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, stopStatus) == null) {
                c.a.u0.v.g.h.a a = c.a.u0.v.g.e.d().a((DownloadCacheKey) this.a.f19199b.get(str));
                if (a == null) {
                    return;
                }
                a.b(str, stopStatus);
            }
        }

        @Override // c.a.u0.v.g.h.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                c.a.u0.v.g.h.a a = c.a.u0.v.g.e.d().a((DownloadCacheKey) this.a.f19199b.get(str));
                if (a == null) {
                    return;
                }
                Toast.makeText(TbadkCoreApplication.getInst(), TbadkApplication.getInst().getResources().getString(R.string.download_start_tips), 1).show();
                a.c(str);
            }
        }

        @Override // c.a.u0.v.g.h.c
        public void d(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) {
                c.a.u0.v.g.h.a a = c.a.u0.v.g.e.d().a((DownloadCacheKey) this.a.f19199b.get(str));
                if (a == null) {
                    return;
                }
                a.d(str, i2);
            }
        }

        @Override // c.a.u0.v.g.h.c
        public void onSuccess(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
                DownloadCacheKey downloadCacheKey = (DownloadCacheKey) this.a.f19199b.get(str);
                String a = c.a.u0.v.g.a.a(TbadkCoreApplication.getInst(), str2);
                if (downloadCacheKey == null) {
                    downloadCacheKey = DownloadCacheKey.create(str, "");
                    this.a.f19199b.put(str, downloadCacheKey);
                    if (c.a.t0.s.e.e()) {
                        String unused = b.f19198d;
                    }
                }
                if (!TextUtils.isEmpty(a)) {
                    downloadCacheKey.mPackageName = a;
                }
                AdDownloadData b2 = c.a.u0.v.g.e.d().b(downloadCacheKey);
                if (!TextUtils.isEmpty(a)) {
                    b2.setupPkgName(a);
                }
                c.a.u0.v.g.h.a a2 = c.a.u0.v.g.e.d().a(downloadCacheKey);
                if (a2 == null) {
                    return;
                }
                if (c.a.u0.v.g.a.b(TbadkCoreApplication.getInst(), a)) {
                    a2.g();
                } else {
                    a2.onSuccess(str, str2);
                }
            }
        }

        public /* synthetic */ C1191b(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1111325948, "Lc/a/u0/l3/f0/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1111325948, "Lc/a/u0/l3/f0/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19199b = new HashMap();
        this.f19200c = new C1191b(this, null);
    }

    @Override // c.a.u0.v.g.i.a
    public void a(String str) {
        DownloadCacheKey downloadCacheKey;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (downloadCacheKey = this.f19199b.get(str)) == null) {
            return;
        }
        k.j().f(downloadCacheKey.mDownloadUrl, str, true);
    }

    @Override // c.a.u0.v.g.i.a
    public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadCacheKey, adDownloadData) == null) {
            this.f19199b.put(downloadCacheKey.mAdId, downloadCacheKey);
            DownloadData downloadData = new DownloadData();
            downloadData.setId(downloadCacheKey.mAdId);
            downloadData.setUrl(downloadCacheKey.mDownloadUrl);
            downloadData.setName(downloadCacheKey.mPackageName);
            downloadData.setType(12);
            downloadData.setNotifyId(k.k(downloadCacheKey.mPackageName).intValue());
            downloadData.setNeedNotify(true);
            downloadData.setNeedInvokeApk(true);
            downloadData.setPosition(0);
            if (c.a.t0.s.e.e()) {
                String str = "start download ad id:" + downloadData.getId();
                String str2 = "start download ad pkg:" + downloadData.getName();
                String str3 = "start download ad url:" + downloadData.getUrl();
            }
            k.j().u(downloadData);
        }
    }

    @Override // c.a.u0.v.g.i.a
    public c.a.u0.v.g.h.c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19200c : (c.a.u0.v.g.h.c) invokeV.objValue;
    }

    @Override // c.a.u0.v.g.i.a
    public void d(String str) {
        DownloadCacheKey downloadCacheKey;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (downloadCacheKey = this.f19199b.get(str)) == null) {
            return;
        }
        this.f19199b.put(downloadCacheKey.mAdId, downloadCacheKey);
        DownloadData downloadData = new DownloadData();
        downloadData.setId(downloadCacheKey.mAdId);
        downloadData.setUrl(downloadCacheKey.mDownloadUrl);
        downloadData.setName(downloadCacheKey.mPackageName);
        downloadData.setType(12);
        downloadData.setNotifyId(k.k(downloadData.getName()).intValue());
        downloadData.setNeedNotify(true);
        downloadData.setNeedInvokeApk(true);
        downloadData.setPosition(0);
        k.j().u(downloadData);
    }
}
