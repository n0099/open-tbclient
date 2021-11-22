package b.a.p0.a.h0.m.u;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.d;
import b.a.p0.a.a1.g.a;
import b.a.p0.a.k;
import b.a.p0.a.n2.j;
import b.a.p0.a.n2.n;
import b.a.p0.a.u2.e;
import b.a.p0.a.z2.j0;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
import b.a.p0.a.z2.w;
import b.a.p0.q.f.f;
import b.a.p0.q.i.g;
import b.a.p0.q.i.h;
import b.a.p0.w.d;
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
    public static final boolean f5901a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f5902b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.h0.m.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0243a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0243a() {
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

        /* renamed from: a  reason: collision with root package name */
        public int f5903a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5904b;

        /* renamed from: c  reason: collision with root package name */
        public String f5905c;

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
            this.f5903a = 0;
            this.f5904b = false;
            this.f5905c = "";
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1973162023, "Lb/a/p0/a/h0/m/u/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1973162023, "Lb/a/p0/a/h0/m/u/a;");
                return;
            }
        }
        f5901a = k.f6863a;
        f5902b = false;
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

    public static b.a.p0.a.u2.a a(ReadableByteChannel readableByteChannel, String str, f fVar) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, fVar)) == null) {
            if (readableByteChannel == null) {
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(11L);
                aVar.i(2300L);
                aVar.f("empty source");
                e.a().f(aVar);
                if (f5901a) {
                    String str2 = "checkPkgZipSign err: " + aVar;
                }
                return aVar;
            }
            fVar.n("670", "aiapp_aps_check_sign_start_timestamp");
            fVar.n("770", "na_pms_start_check_sign");
            if (j0.d(readableByteChannel, str, new b.a.p0.a.z2.b1.c())) {
                fVar.n("670", "aiapp_aps_check_sign_end_timestamp");
                fVar.n("770", "na_pms_end_check_sign");
                return null;
            }
            b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
            aVar2.k(11L);
            aVar2.i(2300L);
            aVar2.f("check zip file sign fail.");
            e.a().f(aVar2);
            if (f5901a) {
                String str3 = "checkPkgZipSign err: " + aVar2;
            }
            return aVar2;
        }
        return (b.a.p0.a.u2.a) invokeLLL.objValue;
    }

    public static boolean b(@Nullable b.a.p0.q.i.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fVar)) == null) {
            if (fVar == null || TextUtils.isEmpty(fVar.f11768a)) {
                return false;
            }
            File file = new File(fVar.f11768a);
            return file.exists() && file.isFile() && file.delete();
        }
        return invokeL.booleanValue;
    }

    @AnyThread
    public static void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || f5902b) {
            return;
        }
        synchronized (a.class) {
            if (f5902b) {
                return;
            }
            f5902b = true;
            q.k(new RunnableC0243a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? d.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? b.a.p0.a.c1.b.g().c() : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? b.a.p0.a.c1.b.g().c() : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? b.a.p0.a.c1.b.g().c() : (String) invokeV.objValue;
    }

    public static boolean j(b.a.p0.q.i.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            int i2 = bVar.f11762a;
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
        if (gVar.f11775h == 1) {
            pMSAppInfo.setOrientation(b.a.p0.a.c1.b.i().v(gVar.f11774g, gVar.f11776i));
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
        if (hVar.f11775h == 0) {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static b.a.p0.a.u2.a m(b.a.p0.q.i.f fVar, f fVar2) {
        InterceptResult invokeLL;
        File i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, fVar, fVar2)) == null) {
            if (fVar == null) {
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(11L);
                aVar.i(2320L);
                aVar.f("pkg info is empty");
                e.a().f(aVar);
                return aVar;
            }
            File file = new File(fVar.f11768a);
            int i3 = fVar.f11775h;
            if (i3 == 1) {
                i2 = b.a.p0.a.c1.b.g().a(fVar.f11774g, String.valueOf(fVar.f11776i));
                if (i2 == null) {
                    b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
                    aVar2.k(11L);
                    aVar2.i(2320L);
                    aVar2.f("获取解压目录失败");
                    e.a().f(aVar2);
                    return aVar2;
                } else if (f5901a) {
                    String str = "bundleZipFile:" + file;
                }
            } else if (i3 == 0) {
                i2 = d.e.i(fVar.f11774g, String.valueOf(fVar.f11776i));
            } else {
                b.a.p0.a.u2.a aVar3 = new b.a.p0.a.u2.a();
                aVar3.k(11L);
                aVar3.i(2320L);
                aVar3.f("pkh category illegal");
                e.a().f(aVar3);
                return aVar3;
            }
            if (!file.exists()) {
                b.a.p0.a.u2.a aVar4 = new b.a.p0.a.u2.a();
                aVar4.k(11L);
                aVar4.i(2320L);
                aVar4.f("解压失败：包不存在");
                e.a().f(aVar4);
                return aVar4;
            } else if (i2.isFile() && !i2.delete()) {
                b.a.p0.a.e0.d.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i2.getAbsolutePath());
                b.a.p0.a.u2.a aVar5 = new b.a.p0.a.u2.a();
                aVar5.k(11L);
                aVar5.i(2320L);
                aVar5.f("解压失败：解压目录被文件占用，且无法删除");
                e.a().f(aVar5);
                return aVar5;
            } else if (!i2.exists() && !i2.mkdirs()) {
                if (f5901a) {
                    String str2 = "解压失败：解压文件夹创建失败 " + i2.getAbsolutePath();
                }
                b.a.p0.a.u2.a aVar6 = new b.a.p0.a.u2.a();
                aVar6.k(11L);
                aVar6.i(2320L);
                aVar6.f("解压失败：解压文件夹创建失败");
                e.a().f(aVar6);
                return aVar6;
            } else {
                if (f5901a) {
                    String str3 = "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i2.getPath();
                }
                if (n(file, i2, fVar2).f5904b) {
                    return null;
                }
                b n = n(file, i2, fVar2);
                if (n.f5904b) {
                    j.a(fVar2, fVar.f11775h, true);
                    return null;
                }
                j.a(fVar2, fVar.f11775h, false);
                b.a.p0.a.e0.d.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i2.getAbsolutePath());
                b.a.p0.w.d.L(i2);
                b.a.p0.a.u2.a aVar7 = new b.a.p0.a.u2.a();
                int i4 = n.f5903a;
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
                    aVar7.f("decryt failed:" + n.f5905c + ", PkgType=" + n.f5903a);
                }
                e.a().f(aVar7);
                return aVar7;
            }
        }
        return (b.a.p0.a.u2.a) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull f fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, fVar)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            a.c j = b.a.p0.a.a1.g.a.j(file);
            int i2 = 0;
            if (j.f4025b != -1) {
                fVar.n("670", "package_start_decrypt");
                fVar.n("770", "na_package_start_decrypt");
                a.b d2 = b.a.p0.a.a1.g.a.d(j.f4024a, file2, j.f4025b);
                fVar.n("670", "package_end_decrypt");
                fVar.n("770", "na_package_end_decrypt");
                bVar.f5904b = d2.f4022a;
                bVar.f5905c = d2.f4023b;
                i2 = j.f4025b;
                bVar.f5903a = i2;
            } else {
                bVar.f5903a = 0;
                fVar.n("670", "package_start_unzip");
                fVar.n("770", "na_package_start_unzip");
                boolean U = b.a.p0.w.d.U(file.getPath(), file2.getPath());
                bVar.f5904b = U;
                if (U) {
                    boolean B = b.a.p0.w.d.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.f5904b = B;
                    if (!B) {
                        b.a.p0.a.n2.s.d dVar = new b.a.p0.a.n2.s.d();
                        b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                        aVar.k(4L);
                        aVar.i(52L);
                        dVar.p(aVar);
                        dVar.l("path", file2.getAbsolutePath());
                        dVar.l("eMsg", "unzip files not match zip content");
                        dVar.l("decryptType", String.valueOf(j.f4025b));
                        dVar.l("stack", q0.z(30));
                        n.R(dVar);
                    }
                }
                fVar.n("670", "package_end_unzip");
                fVar.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (f5901a) {
                b.a.p0.a.a1.g.a.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i2);
            b.a.p0.q.f.j.a(fVar, bundle, "event_download_package_type");
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
            b.a.p0.a.e2.a.c.u(pMSAppInfo.appId, "", w.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            b.a.p0.a.e2.a.c.t("", w.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            b.a.p0.a.e2.a.c.s(pMSAppInfo.appId, w.d(pMSAppInfo.domains));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            return;
        }
        b.a.p0.a.e2.a.c.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
    }
}
