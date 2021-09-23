package c.a.r0.q.e;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.y2.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<DownloadCacheKey, c.a.r0.q.e.h.a> f24124a;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final e f24125a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1944587957, "Lc/a/r0/q/e/e$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1944587957, "Lc/a/r0/q/e/e$b;");
                    return;
                }
            }
            f24125a = new e(null);
        }
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f24125a : (e) invokeV.objValue;
    }

    public c.a.r0.q.e.h.a a(DownloadCacheKey downloadCacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadCacheKey)) == null) ? this.f24124a.get(downloadCacheKey) : (c.a.r0.q.e.h.a) invokeL.objValue;
    }

    @NonNull
    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadCacheKey)) == null) {
            AdDownloadData a2 = c.a.r0.q.e.b.c().a(downloadCacheKey);
            if (a2 == null) {
                AdDownloadData e2 = new AdDownloadData.b(downloadCacheKey).e();
                c.a.r0.q.e.b.c().d(downloadCacheKey, e2);
                return e2;
            }
            return a2;
        }
        return (AdDownloadData) invokeL.objValue;
    }

    public void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        AdDownloadData adDownloadData = null;
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : c.a.r0.q.e.b.c().b(str).entrySet()) {
            AdDownloadData value = entry.getValue();
            if (value != null) {
                value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                adDownloadData = value;
            }
        }
        for (c.a.r0.q.e.h.a aVar : k(str)) {
            if (aVar != null && aVar.l() != 4) {
                aVar.k(4);
                aVar.g();
            }
        }
        c.a.r0.y2.b.b(str);
        f.g().j(context, adDownloadData);
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            c.a.r0.q.e.i.a.f24150a.get().a(str);
            f(c.a.r0.q.e.b.c().a(g(str)), 702);
        }
    }

    public void f(@NonNull AdDownloadData adDownloadData, int i2) {
        DownloadCacheKey g2;
        c.a.r0.q.e.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, adDownloadData, i2) == null) || (g2 = g(adDownloadData.adId())) == null || (aVar = this.f24124a.get(g2)) == null) {
            return;
        }
        aVar.j(i2, adDownloadData.getPkgName(), adDownloadData.getExtInfo(), adDownloadData);
    }

    @Nullable
    public DownloadCacheKey g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (Map.Entry<DownloadCacheKey, c.a.r0.q.e.h.a> entry : this.f24124a.entrySet()) {
                if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                    return entry.getKey();
                }
            }
            return null;
        }
        return (DownloadCacheKey) invokeL.objValue;
    }

    @Nullable
    public DownloadCacheKey h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (Map.Entry<DownloadCacheKey, c.a.r0.q.e.h.a> entry : this.f24124a.entrySet()) {
                if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                    return entry.getKey();
                }
            }
            return null;
        }
        return (DownloadCacheKey) invokeL.objValue;
    }

    public void i(@NonNull DownloadCacheKey downloadCacheKey, c.a.r0.q.e.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, downloadCacheKey, dVar) == null) {
            c.a.r0.q.e.h.a aVar = this.f24124a.get(downloadCacheKey);
            if (aVar == null) {
                aVar = new c.a.r0.q.e.h.a(downloadCacheKey);
                this.f24124a.put(downloadCacheKey, aVar);
            }
            if (dVar != null) {
                aVar.e(dVar);
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            c.a.r0.q.e.i.a.f24150a.get().d(str);
            f(c.a.r0.q.e.b.c().a(g(str)), 703);
        }
    }

    public final Set<c.a.r0.q.e.h.a> k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            HashSet hashSet = new HashSet(this.f24124a.size());
            if (TextUtils.isEmpty(str)) {
                return hashSet;
            }
            for (Map.Entry<DownloadCacheKey, c.a.r0.q.e.h.a> entry : this.f24124a.entrySet()) {
                if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                    hashSet.add(entry.getValue());
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public String l(@NonNull DownloadCacheKey downloadCacheKey, @Nullable c.a.r0.q.e.h.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, downloadCacheKey, dVar)) == null) {
            if (dVar != null) {
                i(downloadCacheKey, dVar);
            }
            AdDownloadData a2 = c.a.r0.q.e.b.c().a(downloadCacheKey);
            c.a.r0.q.e.i.a.f24150a.get().b(downloadCacheKey, a2);
            f(a2, 701);
            return downloadCacheKey.mAdId;
        }
        return (String) invokeLL.objValue;
    }

    public boolean m(Context context, DownloadCacheKey downloadCacheKey, @NonNull String str) {
        InterceptResult invokeLLL;
        AdDownloadData a2;
        DownloadCacheKey downloadCacheKey2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, context, downloadCacheKey, str)) == null) {
            boolean b2 = z.b(str);
            if (!b2) {
                c.a.r0.y2.b.c(new File(str));
            }
            if (downloadCacheKey != null && (a2 = c.a.r0.q.e.b.c().a(downloadCacheKey)) != null) {
                if (TextUtils.isEmpty(a2.pkgName())) {
                    a2.setupPkgName(c.a.r0.q.e.a.a(context, str));
                }
                if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                    downloadCacheKey.mPackageName = a2.pkgName();
                }
                c.a.r0.q.e.h.a aVar = this.f24124a.get(downloadCacheKey);
                if (aVar != null && (downloadCacheKey2 = aVar.f24146c) != null && TextUtils.isEmpty(downloadCacheKey2.mPackageName)) {
                    aVar.f24146c.mPackageName = a2.pkgName();
                }
                a2.extra().setPercentAndStatus(100, DownloadStatus.STATUS_SUCCESS);
                a2.extra().setDownloadPath(str);
                f(a2, SDKLogTypeConstants.SEND_PLAY_FAIL_TYPE);
            }
            return b2;
        }
        return invokeLLL.booleanValue;
    }

    public boolean n(String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) ? m(TbadkCoreApplication.getInst(), g(str), str2) : invokeLL.booleanValue;
    }

    public boolean o(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, context, str)) == null) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : c.a.r0.q.e.b.c().b(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                    f(value, SDKLogTypeConstants.CLOSE_GAME_TYPE);
                }
            }
            return c.a.r0.q.e.a.c(context, str);
        }
        return invokeLL.booleanValue;
    }

    public void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : c.a.r0.q.e.b.c().b(str).entrySet()) {
            AdDownloadData value = entry.getValue();
            if (value != null) {
                value.extra().setStatus(DownloadStatus.STATUS_NONE);
            }
        }
        for (c.a.r0.q.e.h.a aVar : k(str)) {
            if (aVar != null && aVar.l() != 0) {
                aVar.k(0);
                aVar.h();
            }
        }
    }

    public void q(DownloadCacheKey downloadCacheKey, c.a.r0.q.e.h.d dVar) {
        c.a.r0.q.e.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, downloadCacheKey, dVar) == null) || (aVar = this.f24124a.get(downloadCacheKey)) == null) {
            return;
        }
        aVar.i(dVar);
    }

    public e() {
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
        this.f24124a = new HashMap();
        f.g().k();
    }
}
