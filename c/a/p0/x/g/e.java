package c.a.p0.x.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.j.f.i;
import c.a.p0.l3.a0;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<DownloadCacheKey, c.a.p0.x.g.h.a> a;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final e a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1021343520, "Lc/a/p0/x/g/e$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1021343520, "Lc/a/p0/x/g/e$b;");
                    return;
                }
            }
            a = new e(null);
        }
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (e) invokeV.objValue;
    }

    public c.a.p0.x.g.h.a a(DownloadCacheKey downloadCacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadCacheKey)) == null) ? this.a.get(downloadCacheKey) : (c.a.p0.x.g.h.a) invokeL.objValue;
    }

    @NonNull
    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadCacheKey)) == null) {
            AdDownloadData a2 = c.a.p0.x.g.b.c().a(downloadCacheKey);
            if (a2 == null) {
                AdDownloadData f2 = new AdDownloadData.b(downloadCacheKey).f();
                c.a.p0.x.g.b.c().d(downloadCacheKey, f2);
                return f2;
            }
            return a2;
        }
        return (AdDownloadData) invokeL.objValue;
    }

    public c.a.p0.x.g.g.c c(@NonNull i<?> iVar, @NonNull c.a.p0.x.g.g.b bVar, @NonNull AdDownloadData adDownloadData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, iVar, bVar, adDownloadData)) == null) {
            if (c.a.p0.a.h().y()) {
                return new c.a.p0.x.f.b.d.a(bVar, iVar, adDownloadData);
            }
            return new c.a.p0.x.f.b.d.b(bVar, adDownloadData);
        }
        return (c.a.p0.x.g.g.c) invokeLLL.objValue;
    }

    public void e(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        AdDownloadData adDownloadData = null;
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : c.a.p0.x.g.b.c().b(str).entrySet()) {
            AdDownloadData value = entry.getValue();
            if (value != null) {
                value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                adDownloadData = value;
            }
        }
        for (c.a.p0.x.g.h.a aVar : l(str)) {
            if (aVar != null && aVar.l() != 4) {
                aVar.k(4);
                aVar.g();
            }
        }
        c.a.p0.l3.b.b(str);
        f.g().j(context, adDownloadData);
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            c.a.p0.x.g.i.a.a.get().a(str);
            g(c.a.p0.x.g.b.c().a(h(str)), 702);
        }
    }

    public void g(@NonNull AdDownloadData adDownloadData, int i) {
        DownloadCacheKey h2;
        c.a.p0.x.g.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, adDownloadData, i) == null) || (h2 = h(adDownloadData.adId())) == null || (aVar = this.a.get(h2)) == null) {
            return;
        }
        aVar.j(i, adDownloadData.getPkgName(), adDownloadData.getExtInfo(), adDownloadData);
    }

    @Nullable
    public DownloadCacheKey h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (Map.Entry<DownloadCacheKey, c.a.p0.x.g.h.a> entry : this.a.entrySet()) {
                if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                    return entry.getKey();
                }
            }
            return null;
        }
        return (DownloadCacheKey) invokeL.objValue;
    }

    @Nullable
    public DownloadCacheKey i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (Map.Entry<DownloadCacheKey, c.a.p0.x.g.h.a> entry : this.a.entrySet()) {
                if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                    return entry.getKey();
                }
            }
            return null;
        }
        return (DownloadCacheKey) invokeL.objValue;
    }

    public void j(@NonNull DownloadCacheKey downloadCacheKey, c.a.p0.x.g.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadCacheKey, dVar) == null) {
            c.a.p0.x.g.h.a aVar = this.a.get(downloadCacheKey);
            if (aVar == null) {
                aVar = new c.a.p0.x.g.h.a(downloadCacheKey);
                this.a.put(downloadCacheKey, aVar);
            }
            if (dVar != null) {
                aVar.e(dVar);
            }
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            c.a.p0.x.g.i.a.a.get().d(str);
            g(c.a.p0.x.g.b.c().a(h(str)), IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH);
        }
    }

    public final Set<c.a.p0.x.g.h.a> l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            HashSet hashSet = new HashSet(this.a.size());
            if (TextUtils.isEmpty(str)) {
                return hashSet;
            }
            for (Map.Entry<DownloadCacheKey, c.a.p0.x.g.h.a> entry : this.a.entrySet()) {
                if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                    hashSet.add(entry.getValue());
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public String m(@NonNull DownloadCacheKey downloadCacheKey, @Nullable c.a.p0.x.g.h.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, downloadCacheKey, dVar)) == null) {
            if (dVar != null) {
                j(downloadCacheKey, dVar);
            }
            AdDownloadData a2 = c.a.p0.x.g.b.c().a(downloadCacheKey);
            c.a.p0.x.g.i.a.a.get().b(downloadCacheKey, a2);
            g(a2, 701);
            return downloadCacheKey.mAdId;
        }
        return (String) invokeLL.objValue;
    }

    public boolean n(Context context, DownloadCacheKey downloadCacheKey, @NonNull String str) {
        InterceptResult invokeLLL;
        AdDownloadData a2;
        DownloadCacheKey downloadCacheKey2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, context, downloadCacheKey, str)) == null) {
            boolean b2 = a0.b(str);
            if (!b2) {
                c.a.p0.l3.b.c(new File(str));
            }
            if (downloadCacheKey != null && (a2 = c.a.p0.x.g.b.c().a(downloadCacheKey)) != null) {
                if (TextUtils.isEmpty(a2.pkgName())) {
                    a2.setupPkgName(c.a.p0.x.g.a.a(context, str));
                }
                if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                    downloadCacheKey.mPackageName = a2.pkgName();
                }
                c.a.p0.x.g.h.a aVar = this.a.get(downloadCacheKey);
                if (aVar != null && (downloadCacheKey2 = aVar.f20618c) != null && TextUtils.isEmpty(downloadCacheKey2.mPackageName)) {
                    aVar.f20618c.mPackageName = a2.pkgName();
                }
                a2.extra().setPercentAndStatus(100, DownloadStatus.STATUS_SUCCESS);
                a2.extra().setDownloadPath(str);
                g(a2, 705);
            }
            return b2;
        }
        return invokeLLL.booleanValue;
    }

    public boolean o(String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) ? n(TbadkCoreApplication.getInst(), h(str), str2) : invokeLL.booleanValue;
    }

    public boolean p(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, context, str)) == null) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : c.a.p0.x.g.b.c().b(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                    g(value, 706);
                }
            }
            return c.a.p0.x.g.a.c(context, str);
        }
        return invokeLL.booleanValue;
    }

    public void q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, context, str) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : c.a.p0.x.g.b.c().b(str).entrySet()) {
            AdDownloadData value = entry.getValue();
            if (value != null) {
                value.extra().setStatus(DownloadStatus.STATUS_NONE);
            }
        }
        for (c.a.p0.x.g.h.a aVar : l(str)) {
            if (aVar != null && aVar.l() != 0) {
                aVar.k(0);
                aVar.h();
            }
        }
    }

    public void r(DownloadCacheKey downloadCacheKey, c.a.p0.x.g.h.d dVar) {
        c.a.p0.x.g.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, downloadCacheKey, dVar) == null) || (aVar = this.a.get(downloadCacheKey)) == null) {
            return;
        }
        aVar.i(dVar);
    }

    public e() {
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
        this.a = new HashMap();
        f.g().k();
    }
}
