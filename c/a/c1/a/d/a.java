package c.a.c1.a.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.c1.a.e.c;
import c.a.c1.c.a;
import c.a.c1.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSResponseEntity;
import com.baidu.searchbox.aperf.bosuploader.BOSUploader;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f2623d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f2624e;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;

    /* renamed from: b  reason: collision with root package name */
    public File f2625b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f2626c;

    /* renamed from: c.a.c1.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0108a implements c.a.c1.a.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f2627b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f2628c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f2629d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f2630e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f2631f;

        public C0108a(a aVar, File file, c cVar, String str, String str2, JSONObject jSONObject, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, file, cVar, str, str2, jSONObject, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            this.f2627b = cVar;
            this.f2628c = str;
            this.f2629d = str2;
            this.f2630e = jSONObject;
            this.f2631f = str3;
        }

        @Override // c.a.c1.a.e.a
        public void a(c.a.c1.a.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null && aVar.c()) {
                    boolean unused = a.f2623d;
                    if (this.a.exists()) {
                        this.a.delete();
                    }
                    c cVar = this.f2627b;
                    if (cVar != null) {
                        cVar.d(this.f2628c, this.f2629d, this.f2630e);
                    }
                } else if (aVar != null) {
                    int a = aVar.a();
                    String b2 = aVar.b();
                    if (a.f2623d) {
                        String str = "bos upload fail: error code = " + a + ", error message: " + b2;
                    }
                    c cVar2 = this.f2627b;
                    if (cVar2 != null) {
                        cVar2.c(this.f2631f, a, b2, this.f2630e);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f2632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f2633f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f2634g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.c1.a.e.a f2635h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f2636i;

        public b(a aVar, String str, String str2, File file, c.a.c1.a.e.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, file, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2636i = aVar;
            this.f2632e = str;
            this.f2633f = str2;
            this.f2634g = file;
            this.f2635h = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2636i.m(this.f2632e, this.f2633f, this.f2634g, this.f2635h);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1889257778, "Lc/a/c1/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1889257778, "Lc/a/c1/a/d/a;");
                return;
            }
        }
        f2623d = AppConfig.isDebug();
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
        j();
        this.f2626c = new ThreadPoolExecutor(1, 1, 600000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f2624e == null) {
                synchronized (a.class) {
                    if (f2624e == null) {
                        f2624e = new a();
                    }
                }
            }
            return f2624e;
        }
        return (a) invokeV.objValue;
    }

    public void c(c.a.c1.a.h.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, cVar) == null) {
            String j2 = aVar.j();
            String a = aVar.a();
            if (TextUtils.isEmpty(j2) || TextUtils.isEmpty(a)) {
                return;
            }
            File file = new File(this.a, j2);
            JSONObject c2 = aVar.c();
            if (file.exists()) {
                if (f2623d) {
                    String str = "retry: " + j2 + " exists and upload";
                }
                k(j2, a, file, c2, cVar);
                return;
            }
            d(aVar, cVar);
        }
    }

    public void d(c.a.c1.a.h.a aVar, c cVar) {
        File i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, cVar) == null) {
            String j2 = aVar.j();
            String a = aVar.a();
            if (TextUtils.isEmpty(j2) || TextUtils.isEmpty(a)) {
                return;
            }
            ArrayList<String> g2 = aVar.g();
            JSONObject c2 = aVar.c();
            if (c2 == null) {
                c2 = new JSONObject();
                aVar.n(c2);
            }
            JSONObject jSONObject = c2;
            if (g2 != null && g2.size() != 0) {
                if (!aVar.l() && g2.size() == 1) {
                    String str = g2.get(0);
                    if (TextUtils.isEmpty(str)) {
                        cVar.a(j2, jSONObject);
                        return;
                    }
                    File file = new File(str);
                    if (!file.exists()) {
                        cVar.a(j2, jSONObject);
                        return;
                    } else {
                        i2 = new File(this.a, j2);
                        c.a.c1.c.c.a(file, i2);
                    }
                } else {
                    long e2 = aVar.e();
                    if (e2 == 0) {
                        e2 = c.a.c1.a.b.b.f().d(a);
                    }
                    i2 = i(j2, g2, e2, jSONObject);
                }
                File file2 = i2;
                if (file2 != null && file2.exists()) {
                    k(j2, a, file2, jSONObject, cVar);
                    return;
                } else {
                    cVar.b(j2, jSONObject);
                    return;
                }
            }
            cVar.a(j2, jSONObject);
        }
    }

    public void e(String str, String str2, String str3, File file, String str4, boolean z, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, file, str4, Boolean.valueOf(z), jSONObject}) == null) {
            try {
                JSONObject b2 = c.a.c1.c.b.b(file, str4, str2, str3, z);
                jSONObject.put(str, b2);
                if (f2623d) {
                    String str5 = "generateMetaInfo path " + str + " fileMeta ：" + b2;
                }
            } catch (JSONException e2) {
                if (f2623d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public ArrayList<File> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<File> arrayList = new ArrayList<>();
            File[] listFiles = this.a.listFiles();
            return (listFiles == null || listFiles.length <= 0) ? arrayList : new ArrayList<>(Arrays.asList(listFiles));
        }
        return (ArrayList) invokeV.objValue;
    }

    public File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (File) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0337, code lost:
        r11 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public File i(String str, ArrayList<String> arrayList, long j2, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        File file;
        String str2;
        boolean z;
        File file2;
        String str3;
        File file3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, arrayList, Long.valueOf(j2), jSONObject})) == null) {
            long j3 = j2;
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            JSONObject jSONObject2 = jSONObject == null ? new JSONObject() : jSONObject;
            Iterator<String> it = arrayList.iterator();
            long j4 = 0;
            while (true) {
                if (!it.hasNext()) {
                    file = null;
                    str2 = " not exist";
                    break;
                }
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    if (next.startsWith("external:")) {
                        next = next.replace("external:", AppRuntime.getAppContext().getExternalFilesDir(null).getParent() + File.separatorChar);
                    } else if (next.startsWith("internal:")) {
                        next = next.replace("internal:", AppRuntime.getAppContext().getApplicationInfo().dataDir + File.separator);
                    }
                    String str4 = next;
                    if (str4.contains("../")) {
                        e(str4, "4", str4 + " error", null, null, true, jSONObject2);
                    } else {
                        File file4 = new File(str4);
                        if (!file4.exists()) {
                            e(str4, "1", str4 + " not exist", null, null, true, jSONObject2);
                        } else {
                            if (f2623d) {
                                String str5 = "path: " + str4;
                            }
                            if (file4.isFile()) {
                                long length = j4 + file4.length();
                                if (f2623d) {
                                    String str6 = "total file size: " + length;
                                    String str7 = "max file size: " + j3;
                                }
                                if (length > j3) {
                                    file = null;
                                    e(str4, "3", str4 + " size exceed maxFileSize ", null, null, true, jSONObject2);
                                    str2 = " not exist";
                                    break;
                                }
                                file = null;
                                StringBuilder sb = new StringBuilder(d.c(file4.getAbsolutePath().getBytes(), true));
                                sb.append("_");
                                sb.append(file4.getName());
                                arrayList2.add(new a.C0110a(file4, sb.toString()));
                                file2 = file4;
                                str3 = str4;
                                str2 = " not exist";
                                e(str4, "0", str4 + " success", file2, sb.toString(), true, jSONObject2);
                                if (f2623d) {
                                    String str8 = "zip name: " + ((Object) sb);
                                }
                                j4 = length;
                            } else {
                                file2 = file4;
                                str3 = str4;
                                file = null;
                                str2 = " not exist";
                            }
                            if (file2.isDirectory()) {
                                ArrayList arrayList3 = new ArrayList();
                                File file5 = file2;
                                c.a.c1.c.c.e(file5, arrayList3);
                                if (arrayList3.size() == 0) {
                                    continue;
                                } else {
                                    boolean z2 = false;
                                    Iterator it2 = arrayList3.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            file3 = file5;
                                            z = true;
                                            break;
                                        }
                                        String str9 = (String) it2.next();
                                        if (!TextUtils.isEmpty(str9)) {
                                            File file6 = new File(str9);
                                            if (file6.exists()) {
                                                j4 += file6.length();
                                                if (j4 > j3) {
                                                    file3 = file5;
                                                    z = true;
                                                    e(str3, "3", file5.getPath() + "size exceed maxFileSize ", null, null, true, jSONObject2);
                                                    z2 = true;
                                                    break;
                                                }
                                            }
                                            file5 = file5;
                                            j3 = j2;
                                        }
                                    }
                                    if (z2) {
                                        break;
                                    }
                                    File file7 = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "/store/");
                                    String c2 = d.c(file3.getAbsolutePath().getBytes(), z);
                                    File file8 = new File(file7, c2 + ".zip");
                                    if (f2623d) {
                                        String str10 = "inner path: " + file7.getAbsolutePath();
                                        String str11 = "inner path md5: " + c2;
                                        String str12 = "inner zip out file: " + file8.getAbsolutePath();
                                    }
                                    if (!file7.exists()) {
                                        file7.mkdir();
                                    }
                                    if (file8.exists()) {
                                        file8.delete();
                                    }
                                    if (c.a.c1.c.c.h(file3, file8.getAbsolutePath())) {
                                        if (f2623d) {
                                            String str13 = "inner zip out file: " + file8.getName();
                                        }
                                        arrayList2.add(new a.C0110a(file8, file8.getName(), z));
                                        e(str3, "0", "success", file8, file8.getPath(), false, jSONObject2);
                                    } else {
                                        StringBuilder sb2 = new StringBuilder();
                                        String str14 = str3;
                                        sb2.append(str14);
                                        sb2.append("copy error");
                                        e(str14, "2", sb2.toString(), null, null, false, jSONObject2);
                                    }
                                }
                            }
                            j3 = j2;
                        }
                    }
                }
            }
            File file9 = new File(this.f2625b, "filemeta_" + str + ".log");
            try {
                file9.createNewFile();
                c.a.c1.c.c.g(jSONObject2.toString(), file9);
            } catch (IOException e2) {
                if (f2623d) {
                    e2.printStackTrace();
                }
            }
            if (file9.exists()) {
                arrayList2.add(new a.C0110a(file9, file9.getName(), z));
            }
            boolean z3 = f2623d;
            File file10 = new File(this.a, str);
            try {
                if (file10.exists()) {
                    file10.delete();
                }
                file10.createNewFile();
            } catch (IOException e3) {
                if (f2623d) {
                    e3.printStackTrace();
                }
            }
            if (arrayList2.size() > 0) {
                c.a.c1.c.a.a(file10, arrayList2);
                File file11 = new File(file10.getAbsolutePath());
                if (f2623d) {
                    String str15 = "out put File: " + file11.getAbsolutePath();
                }
                return file11;
            }
            e(file10.getAbsolutePath(), "1", file10.getPath() + str2, null, null, true, jSONObject2);
            return file;
        }
        return (File) invokeCommon.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            String str = AppRuntime.getAppContext().getApplicationInfo().dataDir + "/.voyager";
            File file = new File(str, "/upload/");
            this.a = file;
            if (!file.exists()) {
                this.a.mkdirs();
            }
            File file2 = new File(str, "/store/");
            this.f2625b = file2;
            if (file2.exists()) {
                return;
            }
            this.f2625b.mkdirs();
        }
    }

    public final void k(String str, String str2, File file, JSONObject jSONObject, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, file, jSONObject, cVar) == null) {
            String str3 = str + ".zip";
            String createObjectKey = BOSUploader.getInstance().createObjectKey(str2, str3);
            if (f2623d) {
                String str4 = "bos object key is : " + createObjectKey;
            }
            l(str2, str3, file, new C0108a(this, file, cVar, str3, createObjectKey, jSONObject, str));
        }
    }

    public final void l(String str, String str2, File file, c.a.c1.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, file, aVar) == null) {
            this.f2626c.execute(new b(this, str, str2, file, aVar));
        }
    }

    public final void m(@NonNull String str, @NonNull String str2, @NonNull File file, c.a.c1.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, str, str2, file, aVar) == null) {
            BOSResponseEntity uploadFileSync = BOSUploader.getInstance().uploadFileSync(str, str2, file);
            c.a.c1.a.f.a aVar2 = new c.a.c1.a.f.a(uploadFileSync.isSuccess(), uploadFileSync.getErrorCode(), uploadFileSync.getMessage());
            if (aVar != null) {
                aVar.a(aVar2);
            }
        }
    }
}
