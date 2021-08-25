package c.a.b0.g.b;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Xml;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.c.a.g;
import c.a.b0.i.e;
import c.a.b0.i.i;
import c.a.b0.i.j;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IPackageDownloadCallback;
import com.baidu.nps.interfa.IPackageGetCallback;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final String f1894d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f1895e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f1896f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f1897g;

    /* renamed from: h  reason: collision with root package name */
    public static a f1898h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1899a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, BundleInfo> f1900b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f1901c;

    /* renamed from: c.a.b0.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0022a implements IPackageGetCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f1902a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f1903b;

        public C0022a(a aVar, d dVar, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1902a = dVar;
            this.f1903b = countDownLatch;
        }

        @Override // com.baidu.nps.interfa.IPackageGetCallback
        public void onBundleInfoGetFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                d dVar = this.f1902a;
                dVar.f1918a = i2;
                dVar.f1919b = new ArrayList();
                this.f1903b.countDown();
            }
        }

        @Override // com.baidu.nps.interfa.IPackageGetCallback
        public void onBundleInfoGetSuccess(List<IBundleInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                d dVar = this.f1902a;
                dVar.f1918a = 0;
                if (list == null) {
                    list = new ArrayList<>();
                }
                dVar.f1919b = list;
                this.f1903b.countDown();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements IPackageDownloadCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f1904a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f1905b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f1906c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BundleInfo f1907d;

        /* renamed from: c.a.b0.g.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0023a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f1908e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f1909f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f1910g;

            public RunnableC0023a(b bVar, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1910g = bVar;
                this.f1908e = str;
                this.f1909f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Context context = this.f1910g.f1904a;
                    File g2 = c.a.b0.i.c.g(context, this.f1908e + ".apk");
                    if (g2.exists()) {
                        g2.delete();
                    }
                    boolean z = false;
                    try {
                        z = new File(this.f1909f).renameTo(g2);
                    } catch (Exception unused) {
                    }
                    if (z) {
                        this.f1910g.f1905b.f1918a = 2;
                    } else {
                        this.f1910g.f1905b.f1918a = 11;
                    }
                    this.f1910g.f1906c.countDown();
                }
            }
        }

        /* renamed from: c.a.b0.g.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0024b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f1911e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f1912f;

            public RunnableC0024b(b bVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1912f = bVar;
                this.f1911e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f1912f;
                    bVar.f1905b.f1918a = this.f1911e;
                    bVar.f1906c.countDown();
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f1913e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f1914f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f1915g;

            public c(b bVar, long j2, long j3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Long.valueOf(j2), Long.valueOf(j3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1915g = bVar;
                this.f1913e = j2;
                this.f1914f = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f1915g.f1904a.getContentResolver().notifyChange(j.c(this.f1915g.f1907d.getPackageName(), this.f1913e, this.f1914f), null);
                }
            }
        }

        public b(a aVar, Context context, d dVar, CountDownLatch countDownLatch, BundleInfo bundleInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, dVar, countDownLatch, bundleInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1904a = context;
            this.f1905b = dVar;
            this.f1906c = countDownLatch;
            this.f1907d = bundleInfo;
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onPackageDownloadFail(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
                g.a().b().run(new RunnableC0024b(this, i2));
            }
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onPackageDownloadSuccess(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                g.a().b().run(new RunnableC0023a(this, str, str2));
            }
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onProgress(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                g.a().b().run(new c(this, j2, j3));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BundleInfo f1916e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f1917f;

        public c(a aVar, BundleInfo bundleInfo, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bundleInfo, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1916e = bundleInfo;
            this.f1917f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            Throwable th;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    File file = new File(ContextHolder.getApplicationContext().getCacheDir(), "nps");
                    file.mkdirs();
                    File file2 = new File(file, "ext_nps_upgradle_application");
                    if (file2.exists() && file2.length() > 1048576) {
                        file2.delete();
                        file2.createNewFile();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("v_c", this.f1916e.getVersionCode());
                    jSONObject.put("name", this.f1916e.getPackageName());
                    jSONObject.put("upgrade", this.f1916e.getUpdateV());
                    jSONObject.put("f_u", this.f1916e.needForceUpdate());
                    jSONObject.put("f_b", this.f1916e.isForbidden());
                    jSONObject.put("visible", this.f1916e.isVisible());
                    try {
                        fileOutputStream = new FileOutputStream(file2, true);
                    } catch (Throwable th2) {
                        fileOutputStream = null;
                        th = th2;
                    }
                    try {
                        fileOutputStream.write(jSONObject.toString().getBytes());
                        fileOutputStream.write(this.f1917f.getBytes());
                        fileOutputStream.write(String.valueOf(System.currentTimeMillis()).getBytes());
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException | Exception unused2) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f1918a;

        /* renamed from: b  reason: collision with root package name */
        public List<IBundleInfo> f1919b;

        public d() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1652898326, "Lc/a/b0/g/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1652898326, "Lc/a/b0/g/b/a;");
                return;
            }
        }
        f1894d = "nps" + File.separator + "preset";
        f1895e = f1894d + File.separator + "info";
        f1896f = f1894d + File.separator + "bundle";
        f1897g = 4;
        f1898h = new a();
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
                return;
            }
        }
        this.f1899a = false;
        this.f1900b = new HashMap();
        this.f1901c = new HashSet();
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f1898h : (a) invokeV.objValue;
    }

    public final void a(File file, boolean z) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, file, z) == null) || !file.exists() || file.isFile() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (listFiles[i2].isFile()) {
                listFiles[i2].delete();
            } else {
                a(listFiles[i2], true);
            }
        }
        if (z) {
            file.delete();
        }
    }

    public int b(BundleInfo bundleInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundleInfo, i2)) == null) {
            d dVar = new d();
            dVar.f1918a = 2;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Application applicationContext = ContextHolder.getApplicationContext();
            c.a.b0.c.a.c.a().b().downloadBundle(bundleInfo, c.a.b0.i.c.h(applicationContext).getAbsolutePath(), i2, new b(this, applicationContext, dVar, countDownLatch, bundleInfo));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
            return dVar.f1918a;
        }
        return invokeLI.intValue;
    }

    public d c(List<IBundleInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            d dVar = new d();
            dVar.f1918a = 0;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            c.a.b0.c.a.c.a().b().getBundleInfo(list, new C0022a(this, dVar, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < stackTrace.length; i2++) {
                sb.append(stackTrace[i2].getClassName());
                sb.append(":");
                sb.append(stackTrace[i2].getMethodName());
                sb.append(";");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public synchronized Map<String, BundleInfo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (this.f1899a) {
                    return this.f1900b;
                }
                try {
                    try {
                        InputStream open = ContextHolder.getApplicationContext().getAssets().open(f1895e + File.separator + "preset.json");
                        StringBuilder sb = new StringBuilder();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Xml.Encoding.UTF_8.toString()), 8192);
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        }
                        this.f1900b = l(new JSONArray(sb.toString()));
                        this.f1899a = true;
                    } catch (JSONException e2) {
                        if (c.a.b0.i.b.a()) {
                            String str = "e=" + e2.getMessage();
                        }
                    }
                } catch (IOException e3) {
                    if (c.a.b0.i.b.a()) {
                        String str2 = "e=" + e3.getMessage();
                    }
                }
                return this.f1900b;
            }
        }
        return (Map) invokeV.objValue;
    }

    public int g(BundleInfo bundleInfo, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundleInfo, file)) == null) {
            try {
                n(bundleInfo, e());
            } catch (Exception unused) {
            }
            Application applicationContext = ContextHolder.getApplicationContext();
            PackageInfo a2 = e.a(file.getAbsolutePath(), 128);
            if (a2 == null) {
                return 8;
            }
            if (TextUtils.equals(bundleInfo.getPackageName(), a2.packageName)) {
                if (c.a.b0.c.a.e.a().b().checkSignature(bundleInfo.getPackageName(), i.a(file.getAbsolutePath()))) {
                    c.a.b0.i.c.f(applicationContext, bundleInfo.getPackageName()).mkdirs();
                    File e2 = c.a.b0.i.c.e(applicationContext, bundleInfo.getPackageName());
                    e2.mkdirs();
                    File d2 = c.a.b0.i.c.d(applicationContext, bundleInfo.getPackageName() + ".apk");
                    if (!c.a.b0.i.c.b(file, d2)) {
                        if (d2.exists()) {
                            d2.delete();
                            return 11;
                        }
                        return 11;
                    }
                    a(e2, false);
                    if (!i(d2.getAbsolutePath(), e2.getAbsolutePath())) {
                        if (d2.exists()) {
                            d2.delete();
                            return 12;
                        }
                        return 12;
                    } else if (file.exists()) {
                        file.delete();
                        return 13;
                    } else {
                        return 13;
                    }
                }
                return 10;
            }
            return 9;
        }
        return invokeLL.intValue;
    }

    public int h(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bundleInfo)) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            File g2 = c.a.b0.i.c.g(applicationContext, System.currentTimeMillis() + ".apk");
            if (g2.exists()) {
                g2.delete();
            }
            String apkPath = bundleInfo.getApkPath();
            if (TextUtils.isEmpty(apkPath)) {
                return 6;
            }
            File file = new File(apkPath);
            if (file.exists()) {
                if (c.a.b0.i.c.b(file, g2)) {
                    return g(bundleInfo, g2);
                }
                return 11;
            }
            return 7;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, IF, INVOKE, IF, IF] complete} */
    public final boolean i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            String str3 = Build.CPU_ABI;
            String str4 = Build.CPU_ABI2;
            try {
                ZipFile zipFile = new ZipFile(str);
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                boolean z = false;
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String name = nextElement.getName();
                    if (name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && name.endsWith(".so")) {
                        int lastIndexOf = name.lastIndexOf("/");
                        String substring = name.substring(f1897g, lastIndexOf);
                        if (str3.equals(substring)) {
                            z = true;
                        } else if (str4.equals(substring) && !z) {
                        }
                        InputStream inputStream = null;
                        String substring2 = name.substring(lastIndexOf);
                        File file = new File(str2, substring2 + System.currentTimeMillis());
                        File file2 = new File(str2, substring2);
                        try {
                            inputStream = zipFile.getInputStream(nextElement);
                            if (!c.a.b0.i.c.c(inputStream, file)) {
                                if (file.exists()) {
                                    file.delete();
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                return false;
                            }
                            if (file2.exists()) {
                                file2.delete();
                            }
                            file.renameTo(file2);
                            if (file.exists()) {
                                file.delete();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                        } catch (IOException unused3) {
                            if (file.exists()) {
                                file.delete();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused4) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            if (file.exists()) {
                                file.delete();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused5) {
                                }
                            }
                            throw th;
                        }
                    }
                }
                try {
                    zipFile.close();
                } catch (IOException unused6) {
                }
                return true;
            } catch (IOException unused7) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public int j(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundleInfo)) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            File g2 = c.a.b0.i.c.g(applicationContext, System.currentTimeMillis() + ".apk");
            if (g2.exists()) {
                g2.delete();
            }
            if (c.a.b0.i.c.a(applicationContext, f1896f + File.separator + bundleInfo.getPackageName() + ".apk", g2.getAbsolutePath())) {
                return g(bundleInfo, g2);
            }
            return 11;
        }
        return invokeL.intValue;
    }

    public synchronized boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return this.f1901c.contains(str);
            }
        }
        return invokeL.booleanValue;
    }

    public final Map<String, BundleInfo> l(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jSONArray)) == null) {
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    BundleInfo bundleInfo = new BundleInfo();
                    bundleInfo.setPackageName(jSONObject.optString(EmotionResourceInfo.JSON_KEY_PKG_NAME));
                    bundleInfo.setMd5(jSONObject.optString(PackageTable.MD5));
                    bundleInfo.setType(2);
                    bundleInfo.setVersionCode(jSONObject.optInt("version_code"));
                    bundleInfo.setName(jSONObject.optString("name"));
                    bundleInfo.setDescription(jSONObject.optString("description"));
                    bundleInfo.setIconUrl(jSONObject.optString("icon_url"));
                    hashMap.put(bundleInfo.getPackageName(), bundleInfo);
                } catch (JSONException unused) {
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public synchronized void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f1901c.add(str);
            }
        }
    }

    public final void n(BundleInfo bundleInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bundleInfo, str) == null) {
            g.a().b().run(new c(this, bundleInfo, str));
        }
    }
}
