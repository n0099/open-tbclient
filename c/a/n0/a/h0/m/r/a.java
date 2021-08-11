package c.a.n0.a.h0.m.r;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.a1.e;
import c.a.n0.a.a1.h.a;
import c.a.n0.a.j2.i;
import c.a.n0.a.k;
import c.a.n0.a.q2.e;
import c.a.n0.a.v2.j0;
import c.a.n0.a.v2.q;
import c.a.n0.a.v2.q0;
import c.a.n0.a.v2.w;
import c.a.n0.n.f.h;
import c.a.n0.n.h.f;
import c.a.n0.n.h.g;
import c.a.n0.t.d;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5994a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f5995b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.h0.m.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0227a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0227a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] listFiles;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.K(new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip"));
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                for (File file2 : listFiles) {
                    long lastModified = file2.lastModified();
                    if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                        d.K(file2);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f5996a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5997b;

        /* renamed from: c  reason: collision with root package name */
        public String f5998c;

        public b() {
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
            this.f5996a = 0;
            this.f5997b = false;
            this.f5998c = "";
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1987117547, "Lc/a/n0/a/h0/m/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1987117547, "Lc/a/n0/a/h0/m/r/a;");
                return;
            }
        }
        f5994a = k.f6803a;
        f5995b = false;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static c.a.n0.a.q2.a a(ReadableByteChannel readableByteChannel, String str, c.a.n0.n.f.d dVar) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, dVar)) == null) {
            if (readableByteChannel == null) {
                c.a.n0.a.q2.a aVar = new c.a.n0.a.q2.a();
                aVar.j(11L);
                aVar.h(2300L);
                aVar.e("empty source");
                e.a().f(aVar);
                if (f5994a) {
                    String str2 = "checkPkgZipSign err: " + aVar;
                }
                return aVar;
            }
            dVar.n("670", "aiapp_aps_check_sign_start_timestamp");
            dVar.n("770", "na_pms_start_check_sign");
            if (j0.d(readableByteChannel, str, new c.a.n0.a.v2.a1.c())) {
                dVar.n("670", "aiapp_aps_check_sign_end_timestamp");
                dVar.n("770", "na_pms_end_check_sign");
                return null;
            }
            c.a.n0.a.q2.a aVar2 = new c.a.n0.a.q2.a();
            aVar2.j(11L);
            aVar2.h(2300L);
            aVar2.e("check zip file sign fail.");
            e.a().f(aVar2);
            if (f5994a) {
                String str3 = "checkPkgZipSign err: " + aVar2;
            }
            return aVar2;
        }
        return (c.a.n0.a.q2.a) invokeLLL.objValue;
    }

    public static boolean b(@Nullable c.a.n0.n.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, eVar)) == null) {
            if (eVar == null || TextUtils.isEmpty(eVar.f11605a)) {
                return false;
            }
            File file = new File(eVar.f11605a);
            return file.exists() && file.isFile() && file.delete();
        }
        return invokeL.booleanValue;
    }

    @AnyThread
    public static void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || f5995b) {
            return;
        }
        synchronized (a.class) {
            if (f5995b) {
                return;
            }
            f5995b = true;
            q.j(new RunnableC0227a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? e.C0104e.h().getPath() : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? c.a.n0.a.c1.b.g().c() : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? c.a.n0.a.c1.b.g().c() : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? e.C0104e.h().getPath() : (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? e.C0104e.h().getPath() : (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.a.n0.a.c1.b.g().c() : (String) invokeV.objValue;
    }

    public static void j(PMSAppInfo pMSAppInfo, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, pMSAppInfo, fVar) == null) || pMSAppInfo == null || fVar == null) {
            return;
        }
        pMSAppInfo.copyMainPkgInfo(fVar);
        if (fVar.f11612h == 1) {
            pMSAppInfo.setOrientation(c.a.n0.a.c1.b.i().v(fVar.f11611g, fVar.f11613i));
        } else {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static void k(PMSAppInfo pMSAppInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, gVar) == null) || pMSAppInfo == null || gVar == null) {
            return;
        }
        pMSAppInfo.copySubPkgInfo(gVar);
        if (gVar.f11612h == 0) {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static c.a.n0.a.q2.a l(c.a.n0.n.h.e eVar, c.a.n0.n.f.d dVar) {
        InterceptResult invokeLL;
        File i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, eVar, dVar)) == null) {
            if (eVar == null) {
                c.a.n0.a.q2.a aVar = new c.a.n0.a.q2.a();
                aVar.j(11L);
                aVar.h(2320L);
                aVar.e("pkg info is empty");
                c.a.n0.a.q2.e.a().f(aVar);
                return aVar;
            }
            File file = new File(eVar.f11605a);
            int i3 = eVar.f11612h;
            if (i3 == 1) {
                i2 = c.a.n0.a.c1.b.g().a(eVar.f11611g, String.valueOf(eVar.f11613i));
                if (i2 == null) {
                    c.a.n0.a.q2.a aVar2 = new c.a.n0.a.q2.a();
                    aVar2.j(11L);
                    aVar2.h(2320L);
                    aVar2.e("获取解压目录失败");
                    c.a.n0.a.q2.e.a().f(aVar2);
                    return aVar2;
                } else if (f5994a) {
                    String str = "bundleZipFile:" + file;
                }
            } else if (i3 == 0) {
                i2 = e.C0104e.i(eVar.f11611g, String.valueOf(eVar.f11613i));
            } else {
                c.a.n0.a.q2.a aVar3 = new c.a.n0.a.q2.a();
                aVar3.j(11L);
                aVar3.h(2320L);
                aVar3.e("pkh category illegal");
                c.a.n0.a.q2.e.a().f(aVar3);
                return aVar3;
            }
            if (!file.exists()) {
                c.a.n0.a.q2.a aVar4 = new c.a.n0.a.q2.a();
                aVar4.j(11L);
                aVar4.h(2320L);
                aVar4.e("解压失败：包不存在");
                c.a.n0.a.q2.e.a().f(aVar4);
                return aVar4;
            } else if (i2.isFile() && !i2.delete()) {
                c.a.n0.a.e0.d.h("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i2.getAbsolutePath());
                c.a.n0.a.q2.a aVar5 = new c.a.n0.a.q2.a();
                aVar5.j(11L);
                aVar5.h(2320L);
                aVar5.e("解压失败：解压目录被文件占用，且无法删除");
                c.a.n0.a.q2.e.a().f(aVar5);
                return aVar5;
            } else if (!i2.exists() && !i2.mkdirs()) {
                if (f5994a) {
                    String str2 = "解压失败：解压文件夹创建失败 " + i2.getAbsolutePath();
                }
                c.a.n0.a.q2.a aVar6 = new c.a.n0.a.q2.a();
                aVar6.j(11L);
                aVar6.h(2320L);
                aVar6.e("解压失败：解压文件夹创建失败");
                c.a.n0.a.q2.e.a().f(aVar6);
                return aVar6;
            } else {
                if (f5994a) {
                    String str3 = "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i2.getPath();
                }
                if (m(file, i2, dVar).f5997b) {
                    return null;
                }
                b m = m(file, i2, dVar);
                if (m.f5997b) {
                    i.a(dVar, eVar.f11612h, true);
                    return null;
                }
                i.a(dVar, eVar.f11612h, false);
                c.a.n0.a.e0.d.h("PkgDownloadUtil", "解压失败后删除解压目录: " + i2.getAbsolutePath());
                d.K(i2);
                c.a.n0.a.q2.a aVar7 = new c.a.n0.a.q2.a();
                int i4 = m.f5996a;
                if (i4 == 0) {
                    aVar7.j(11L);
                    aVar7.h(2320L);
                    aVar7.e("unzip failed");
                } else if (i4 != 1 && i4 != 2) {
                    aVar7.j(4L);
                    aVar7.h(7L);
                    aVar7.e("Unkown bundle type");
                } else {
                    aVar7.j(11L);
                    aVar7.h(2330L);
                    aVar7.e("decryt failed:" + m.f5998c + ", PkgType=" + m.f5996a);
                }
                c.a.n0.a.q2.e.a().f(aVar7);
                return aVar7;
            }
        }
        return (c.a.n0.a.q2.a) invokeLL.objValue;
    }

    @NonNull
    public static b m(@NonNull File file, @NonNull File file2, @NonNull c.a.n0.n.f.d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, file, file2, dVar)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            a.b i2 = c.a.n0.a.a1.h.a.i(file);
            int i3 = 0;
            if (i2.f4249b != -1) {
                dVar.n("670", "package_start_decrypt");
                dVar.n("770", "na_package_start_decrypt");
                a.C0105a c2 = c.a.n0.a.a1.h.a.c(i2.f4248a, file2, i2.f4249b);
                dVar.n("670", "package_end_decrypt");
                dVar.n("770", "na_package_end_decrypt");
                bVar.f5997b = c2.f4246a;
                bVar.f5998c = c2.f4247b;
                i3 = i2.f4249b;
                bVar.f5996a = i3;
            } else {
                bVar.f5996a = 0;
                dVar.n("670", "package_start_unzip");
                dVar.n("770", "na_package_start_unzip");
                boolean T = d.T(file.getPath(), file2.getPath());
                bVar.f5997b = T;
                if (T) {
                    boolean A = d.A(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.f5997b = A;
                    if (!A) {
                        c.a.n0.a.j2.p.d dVar2 = new c.a.n0.a.j2.p.d();
                        c.a.n0.a.q2.a aVar = new c.a.n0.a.q2.a();
                        aVar.j(4L);
                        aVar.h(52L);
                        dVar2.p(aVar);
                        dVar2.l("path", file2.getAbsolutePath());
                        dVar2.l("eMsg", "unzip files not match zip content");
                        dVar2.l("decryptType", String.valueOf(i2.f4249b));
                        dVar2.l("stack", q0.z(30));
                        c.a.n0.a.j2.k.L(dVar2);
                    }
                }
                dVar.n("670", "package_end_unzip");
                dVar.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (f5994a) {
                c.a.n0.a.a1.h.a.g((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i3);
            h.a(dVar, bundle, "event_download_package_type");
            return bVar;
        }
        return (b) invokeLLL.objValue;
    }

    public static void n(@Nullable PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
            c.a.n0.a.b2.a.c.u(pMSAppInfo.appId, "", w.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            c.a.n0.a.b2.a.c.t("", w.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            c.a.n0.a.b2.a.c.s(pMSAppInfo.appId, w.d(pMSAppInfo.domains));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            return;
        }
        c.a.n0.a.b2.a.c.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
    }
}
