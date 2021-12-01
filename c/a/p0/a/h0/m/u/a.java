package c.a.p0.a.h0.m.u;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a1.d;
import c.a.p0.a.a1.g.a;
import c.a.p0.a.k;
import c.a.p0.a.n2.j;
import c.a.p0.a.n2.n;
import c.a.p0.a.u2.e;
import c.a.p0.a.z2.j0;
import c.a.p0.a.z2.q;
import c.a.p0.a.z2.q0;
import c.a.p0.a.z2.w;
import c.a.p0.q.f.f;
import c.a.p0.q.i.g;
import c.a.p0.q.i.h;
import c.a.p0.w.d;
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
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f5836b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.h0.m.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0299a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0299a() {
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
                File filesDir = AppRuntime.getAppContext().getFilesDir();
                d.j(new File(filesDir, "aiapps_zip"));
                d.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                for (File file2 : listFiles) {
                    long lastModified = file2.lastModified();
                    if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                        d.L(file2);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5837b;

        /* renamed from: c  reason: collision with root package name */
        public String f5838c;

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
            this.a = 0;
            this.f5837b = false;
            this.f5838c = "";
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(976089670, "Lc/a/p0/a/h0/m/u/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(976089670, "Lc/a/p0/a/h0/m/u/a;");
                return;
            }
        }
        a = k.a;
        f5836b = false;
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

    public static c.a.p0.a.u2.a a(ReadableByteChannel readableByteChannel, String str, f fVar) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, fVar)) == null) {
            if (readableByteChannel == null) {
                c.a.p0.a.u2.a aVar = new c.a.p0.a.u2.a();
                aVar.k(11L);
                aVar.i(2300L);
                aVar.f("empty source");
                e.a().f(aVar);
                if (a) {
                    String str2 = "checkPkgZipSign err: " + aVar;
                }
                return aVar;
            }
            fVar.n("670", "aiapp_aps_check_sign_start_timestamp");
            fVar.n("770", "na_pms_start_check_sign");
            if (j0.d(readableByteChannel, str, new c.a.p0.a.z2.b1.c())) {
                fVar.n("670", "aiapp_aps_check_sign_end_timestamp");
                fVar.n("770", "na_pms_end_check_sign");
                return null;
            }
            c.a.p0.a.u2.a aVar2 = new c.a.p0.a.u2.a();
            aVar2.k(11L);
            aVar2.i(2300L);
            aVar2.f("check zip file sign fail.");
            e.a().f(aVar2);
            if (a) {
                String str3 = "checkPkgZipSign err: " + aVar2;
            }
            return aVar2;
        }
        return (c.a.p0.a.u2.a) invokeLLL.objValue;
    }

    public static boolean b(@Nullable c.a.p0.q.i.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fVar)) == null) {
            if (fVar == null || TextUtils.isEmpty(fVar.a)) {
                return false;
            }
            File file = new File(fVar.a);
            return file.exists() && file.isFile() && file.delete();
        }
        return invokeL.booleanValue;
    }

    @AnyThread
    public static void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || f5836b) {
            return;
        }
        synchronized (a.class) {
            if (f5836b) {
                return;
            }
            f5836b = true;
            q.k(new RunnableC0299a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? d.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? c.a.p0.a.c1.b.g().c() : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? c.a.p0.a.c1.b.g().c() : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? d.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? d.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.a.p0.a.c1.b.g().c() : (String) invokeV.objValue;
    }

    public static boolean j(c.a.p0.q.i.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            int i2 = bVar.a;
            return i2 == 1013 || i2 == 1015;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, gVar) == null) || pMSAppInfo == null || gVar == null) {
            return;
        }
        pMSAppInfo.copyMainPkgInfo(gVar);
        if (gVar.f10718h == 1) {
            pMSAppInfo.setOrientation(c.a.p0.a.c1.b.i().v(gVar.f10717g, gVar.f10719i));
        } else {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, hVar) == null) || pMSAppInfo == null || hVar == null) {
            return;
        }
        pMSAppInfo.copySubPkgInfo(hVar);
        if (hVar.f10718h == 0) {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static c.a.p0.a.u2.a m(c.a.p0.q.i.f fVar, f fVar2) {
        InterceptResult invokeLL;
        File i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, fVar, fVar2)) == null) {
            if (fVar == null) {
                c.a.p0.a.u2.a aVar = new c.a.p0.a.u2.a();
                aVar.k(11L);
                aVar.i(2320L);
                aVar.f("pkg info is empty");
                e.a().f(aVar);
                return aVar;
            }
            File file = new File(fVar.a);
            int i3 = fVar.f10718h;
            if (i3 == 1) {
                i2 = c.a.p0.a.c1.b.g().a(fVar.f10717g, String.valueOf(fVar.f10719i));
                if (i2 == null) {
                    c.a.p0.a.u2.a aVar2 = new c.a.p0.a.u2.a();
                    aVar2.k(11L);
                    aVar2.i(2320L);
                    aVar2.f("获取解压目录失败");
                    e.a().f(aVar2);
                    return aVar2;
                } else if (a) {
                    String str = "bundleZipFile:" + file;
                }
            } else if (i3 == 0) {
                i2 = d.e.i(fVar.f10717g, String.valueOf(fVar.f10719i));
            } else {
                c.a.p0.a.u2.a aVar3 = new c.a.p0.a.u2.a();
                aVar3.k(11L);
                aVar3.i(2320L);
                aVar3.f("pkh category illegal");
                e.a().f(aVar3);
                return aVar3;
            }
            if (!file.exists()) {
                c.a.p0.a.u2.a aVar4 = new c.a.p0.a.u2.a();
                aVar4.k(11L);
                aVar4.i(2320L);
                aVar4.f("解压失败：包不存在");
                e.a().f(aVar4);
                return aVar4;
            } else if (i2.isFile() && !i2.delete()) {
                c.a.p0.a.e0.d.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i2.getAbsolutePath());
                c.a.p0.a.u2.a aVar5 = new c.a.p0.a.u2.a();
                aVar5.k(11L);
                aVar5.i(2320L);
                aVar5.f("解压失败：解压目录被文件占用，且无法删除");
                e.a().f(aVar5);
                return aVar5;
            } else if (!i2.exists() && !i2.mkdirs()) {
                if (a) {
                    String str2 = "解压失败：解压文件夹创建失败 " + i2.getAbsolutePath();
                }
                c.a.p0.a.u2.a aVar6 = new c.a.p0.a.u2.a();
                aVar6.k(11L);
                aVar6.i(2320L);
                aVar6.f("解压失败：解压文件夹创建失败");
                e.a().f(aVar6);
                return aVar6;
            } else {
                if (a) {
                    String str3 = "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i2.getPath();
                }
                if (n(file, i2, fVar2).f5837b) {
                    return null;
                }
                b n = n(file, i2, fVar2);
                if (n.f5837b) {
                    j.a(fVar2, fVar.f10718h, true);
                    return null;
                }
                j.a(fVar2, fVar.f10718h, false);
                c.a.p0.a.e0.d.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i2.getAbsolutePath());
                c.a.p0.w.d.L(i2);
                c.a.p0.a.u2.a aVar7 = new c.a.p0.a.u2.a();
                int i4 = n.a;
                if (i4 == 0) {
                    aVar7.k(11L);
                    aVar7.i(2320L);
                    aVar7.f("unzip failed");
                } else if (i4 != 1 && i4 != 2) {
                    aVar7.k(4L);
                    aVar7.i(7L);
                    aVar7.f("Unkown bundle type");
                } else {
                    aVar7.k(11L);
                    aVar7.i(2330L);
                    aVar7.f("decryt failed:" + n.f5838c + ", PkgType=" + n.a);
                }
                e.a().f(aVar7);
                return aVar7;
            }
        }
        return (c.a.p0.a.u2.a) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull f fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, fVar)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            a.c j2 = c.a.p0.a.a1.g.a.j(file);
            int i2 = 0;
            if (j2.f4234b != -1) {
                fVar.n("670", "package_start_decrypt");
                fVar.n("770", "na_package_start_decrypt");
                a.b d2 = c.a.p0.a.a1.g.a.d(j2.a, file2, j2.f4234b);
                fVar.n("670", "package_end_decrypt");
                fVar.n("770", "na_package_end_decrypt");
                bVar.f5837b = d2.a;
                bVar.f5838c = d2.f4233b;
                i2 = j2.f4234b;
                bVar.a = i2;
            } else {
                bVar.a = 0;
                fVar.n("670", "package_start_unzip");
                fVar.n("770", "na_package_start_unzip");
                boolean U = c.a.p0.w.d.U(file.getPath(), file2.getPath());
                bVar.f5837b = U;
                if (U) {
                    boolean B = c.a.p0.w.d.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.f5837b = B;
                    if (!B) {
                        c.a.p0.a.n2.s.d dVar = new c.a.p0.a.n2.s.d();
                        c.a.p0.a.u2.a aVar = new c.a.p0.a.u2.a();
                        aVar.k(4L);
                        aVar.i(52L);
                        dVar.p(aVar);
                        dVar.l("path", file2.getAbsolutePath());
                        dVar.l("eMsg", "unzip files not match zip content");
                        dVar.l("decryptType", String.valueOf(j2.f4234b));
                        dVar.l("stack", q0.z(30));
                        n.R(dVar);
                    }
                }
                fVar.n("670", "package_end_unzip");
                fVar.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                c.a.p0.a.a1.g.a.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i2);
            c.a.p0.q.f.j.a(fVar, bundle, "event_download_package_type");
            return bVar;
        }
        return (b) invokeLLL.objValue;
    }

    public static void o(@Nullable PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
            c.a.p0.a.e2.a.c.u(pMSAppInfo.appId, "", w.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            c.a.p0.a.e2.a.c.t("", w.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            c.a.p0.a.e2.a.c.s(pMSAppInfo.appId, w.d(pMSAppInfo.domains));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            return;
        }
        c.a.p0.a.e2.a.c.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
    }
}
