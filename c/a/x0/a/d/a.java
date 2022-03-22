package c.a.x0.a.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.a.e.c;
import c.a.x0.c.a;
import c.a.x0.c.d;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f22036d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f22037e;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;

    /* renamed from: b  reason: collision with root package name */
    public File f22038b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f22039c;

    /* renamed from: c.a.x0.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1628a implements c.a.x0.a.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f22040b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f22041c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f22042d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f22043e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f22044f;

        public C1628a(a aVar, File file, c cVar, String str, String str2, JSONObject jSONObject, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, file, cVar, str, str2, jSONObject, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            this.f22040b = cVar;
            this.f22041c = str;
            this.f22042d = str2;
            this.f22043e = jSONObject;
            this.f22044f = str3;
        }

        @Override // c.a.x0.a.e.a
        public void a(c.a.x0.a.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null && aVar.c()) {
                    if (a.f22036d) {
                        Log.d("VoyagerFileManager", "bos upload success");
                    }
                    if (this.a.exists()) {
                        this.a.delete();
                    }
                    c cVar = this.f22040b;
                    if (cVar != null) {
                        cVar.d(this.f22041c, this.f22042d, this.f22043e);
                    }
                } else if (aVar != null) {
                    int a = aVar.a();
                    String b2 = aVar.b();
                    if (a.f22036d) {
                        Log.d("VoyagerFileManager", "bos upload fail: error code = " + a + ", error message: " + b2);
                    }
                    c cVar2 = this.f22040b;
                    if (cVar2 != null) {
                        cVar2.c(this.f22044f, a, b2, this.f22043e);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f22045b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ File f22046c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.x0.a.e.a f22047d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22048e;

        public b(a aVar, String str, String str2, File file, c.a.x0.a.e.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, file, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22048e = aVar;
            this.a = str;
            this.f22045b = str2;
            this.f22046c = file;
            this.f22047d = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22048e.m(this.a, this.f22045b, this.f22046c, this.f22047d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1361061124, "Lc/a/x0/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1361061124, "Lc/a/x0/a/d/a;");
                return;
            }
        }
        f22036d = AppConfig.isDebug();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        j();
        this.f22039c = new ThreadPoolExecutor(1, 1, 600000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f22037e == null) {
                synchronized (a.class) {
                    if (f22037e == null) {
                        f22037e = new a();
                    }
                }
            }
            return f22037e;
        }
        return (a) invokeV.objValue;
    }

    public void c(c.a.x0.a.h.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, cVar) == null) {
            String j = aVar.j();
            String a = aVar.a();
            if (TextUtils.isEmpty(j) || TextUtils.isEmpty(a)) {
                return;
            }
            File file = new File(this.a, j);
            JSONObject c2 = aVar.c();
            if (file.exists()) {
                if (f22036d) {
                    Log.d("VoyagerFileManager", "retry: " + j + " exists and upload");
                }
                k(j, a, file, c2, cVar);
                return;
            }
            d(aVar, cVar);
        }
    }

    public void d(c.a.x0.a.h.a aVar, c cVar) {
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, cVar) == null) {
            String j = aVar.j();
            String a = aVar.a();
            if (TextUtils.isEmpty(j) || TextUtils.isEmpty(a)) {
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
                        cVar.a(j, jSONObject);
                        return;
                    }
                    File file = new File(str);
                    if (!file.exists()) {
                        cVar.a(j, jSONObject);
                        return;
                    } else {
                        i = new File(this.a, j);
                        c.a.x0.c.c.a(file, i);
                    }
                } else {
                    long e2 = aVar.e();
                    if (e2 == 0) {
                        e2 = c.a.x0.a.b.b.f().d(a);
                    }
                    i = i(j, g2, e2, jSONObject);
                }
                File file2 = i;
                if (file2 != null && file2.exists()) {
                    k(j, a, file2, jSONObject, cVar);
                    return;
                } else {
                    cVar.b(j, jSONObject);
                    return;
                }
            }
            cVar.a(j, jSONObject);
        }
    }

    public void e(String str, String str2, String str3, File file, String str4, boolean z, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, file, str4, Boolean.valueOf(z), jSONObject}) == null) {
            try {
                JSONObject b2 = c.a.x0.c.b.b(file, str4, str2, str3, z);
                jSONObject.put(str, b2);
                if (f22036d) {
                    Log.d("VoyagerFileManager", "generateMetaInfo path " + str + " fileMeta ：" + b2);
                }
            } catch (JSONException e2) {
                if (f22036d) {
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

    public File i(String str, ArrayList<String> arrayList, long j, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        String str2;
        File file;
        String str3;
        Iterator<String> it;
        File file2;
        String str4;
        boolean z;
        String str5;
        File file3;
        String str6;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, arrayList, Long.valueOf(j), jSONObject})) == null) {
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            JSONObject jSONObject2 = jSONObject == null ? new JSONObject() : jSONObject;
            Iterator<String> it2 = arrayList.iterator();
            long j2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    str2 = "VoyagerFileManager";
                    file = null;
                    str3 = " not exist";
                    break;
                }
                String next = it2.next();
                if (!TextUtils.isEmpty(next)) {
                    if (next.startsWith("external:")) {
                        next = next.replace("external:", AppRuntime.getAppContext().getExternalFilesDir(null).getParent() + File.separatorChar);
                    } else if (next.startsWith("internal:")) {
                        next = next.replace("internal:", AppRuntime.getAppContext().getApplicationInfo().dataDir + File.separator);
                    }
                    String str8 = next;
                    if (str8.contains("../")) {
                        e(str8, "4", str8 + " error", null, null, true, jSONObject2);
                    } else {
                        File file4 = new File(str8);
                        if (!file4.exists()) {
                            e(str8, "1", str8 + " not exist", null, null, true, jSONObject2);
                        } else {
                            if (f22036d) {
                                Log.d("VoyagerFileManager", "path: " + str8);
                            }
                            if (file4.isFile()) {
                                long length = file4.length() + j2;
                                if (f22036d) {
                                    Log.d("VoyagerFileManager", "total file size: " + length);
                                    Log.d("VoyagerFileManager", "max file size: " + j);
                                }
                                if (length > j) {
                                    file = null;
                                    e(str8, "3", str8 + " size exceed maxFileSize ", null, null, true, jSONObject2);
                                    str3 = " not exist";
                                    str2 = "VoyagerFileManager";
                                    break;
                                }
                                file = null;
                                StringBuilder sb = new StringBuilder(d.c(file4.getAbsolutePath().getBytes(), true));
                                sb.append("_");
                                sb.append(file4.getName());
                                arrayList2.add(new a.C1630a(file4, sb.toString()));
                                file2 = file4;
                                str4 = str8;
                                it = it2;
                                z = true;
                                str3 = " not exist";
                                e(str8, "0", str8 + " success", file2, sb.toString(), true, jSONObject2);
                                if (f22036d) {
                                    Log.d("VoyagerFileManager", "zip name: " + ((Object) sb));
                                }
                                str5 = "VoyagerFileManager";
                                j2 = length;
                            } else {
                                it = it2;
                                file2 = file4;
                                str4 = str8;
                                file = null;
                                str3 = " not exist";
                                z = true;
                                str5 = "VoyagerFileManager";
                            }
                            if (file2.isDirectory()) {
                                ArrayList arrayList3 = new ArrayList();
                                File file5 = file2;
                                c.a.x0.c.c.e(file5, arrayList3);
                                if (arrayList3.size() != 0) {
                                    boolean z2 = false;
                                    Iterator it3 = arrayList3.iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            file3 = file5;
                                            str6 = str5;
                                            break;
                                        }
                                        String str9 = (String) it3.next();
                                        if (!TextUtils.isEmpty(str9)) {
                                            File file6 = new File(str9);
                                            if (file6.exists()) {
                                                j2 += file6.length();
                                                if (j2 > j) {
                                                    file3 = file5;
                                                    str6 = str5;
                                                    e(str4, "3", file5.getPath() + "size exceed maxFileSize ", null, null, true, jSONObject2);
                                                    z2 = true;
                                                    break;
                                                }
                                            }
                                            file5 = file5;
                                            str5 = str5;
                                        }
                                    }
                                    if (z2) {
                                        str2 = str6;
                                        break;
                                    }
                                    File file7 = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "/store/");
                                    String c2 = d.c(file3.getAbsolutePath().getBytes(), z);
                                    File file8 = new File(file7, c2 + ".zip");
                                    if (f22036d) {
                                        str7 = str6;
                                        Log.d(str7, "inner path: " + file7.getAbsolutePath());
                                        Log.d(str7, "inner path md5: " + c2);
                                        Log.d(str7, "inner zip out file: " + file8.getAbsolutePath());
                                    } else {
                                        str7 = str6;
                                    }
                                    if (!file7.exists()) {
                                        file7.mkdir();
                                    }
                                    if (file8.exists()) {
                                        file8.delete();
                                    }
                                    if (c.a.x0.c.c.h(file3, file8.getAbsolutePath())) {
                                        if (f22036d) {
                                            Log.d(str7, "inner zip out file: " + file8.getName());
                                        }
                                        arrayList2.add(new a.C1630a(file8, file8.getName(), z));
                                        e(str4, "0", "success", file8, file8.getPath(), false, jSONObject2);
                                    } else {
                                        StringBuilder sb2 = new StringBuilder();
                                        String str10 = str4;
                                        sb2.append(str10);
                                        sb2.append("copy error");
                                        e(str10, "2", sb2.toString(), null, null, false, jSONObject2);
                                    }
                                }
                            }
                            it2 = it;
                        }
                    }
                }
            }
            File file9 = new File(this.f22038b, "filemeta_" + str + ".log");
            try {
                file9.createNewFile();
                c.a.x0.c.c.g(jSONObject2.toString(), file9);
            } catch (IOException e2) {
                if (f22036d) {
                    e2.printStackTrace();
                }
            }
            if (file9.exists()) {
                arrayList2.add(new a.C1630a(file9, file9.getName(), true));
            }
            if (f22036d) {
                Log.d(str2, "start generate out zip file");
            }
            File file10 = new File(this.a, str);
            try {
                if (file10.exists()) {
                    file10.delete();
                }
                file10.createNewFile();
            } catch (IOException e3) {
                if (f22036d) {
                    e3.printStackTrace();
                }
            }
            if (arrayList2.size() > 0) {
                c.a.x0.c.a.a(file10, arrayList2);
                File file11 = new File(file10.getAbsolutePath());
                if (f22036d) {
                    Log.d(str2, "out put File: " + file11.getAbsolutePath());
                }
                return file11;
            }
            e(file10.getAbsolutePath(), "1", file10.getPath() + str3, null, null, true, jSONObject2);
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
            this.f22038b = file2;
            if (file2.exists()) {
                return;
            }
            this.f22038b.mkdirs();
        }
    }

    public final void k(String str, String str2, File file, JSONObject jSONObject, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, file, jSONObject, cVar) == null) {
            String str3 = str + ".zip";
            String createObjectKey = BOSUploader.getInstance().createObjectKey(str2, str3);
            if (f22036d) {
                Log.d("VoyagerFileManager", "bos object key is : " + createObjectKey);
            }
            l(str2, str3, file, new C1628a(this, file, cVar, str3, createObjectKey, jSONObject, str));
        }
    }

    public final void l(String str, String str2, File file, c.a.x0.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, file, aVar) == null) {
            this.f22039c.execute(new b(this, str, str2, file, aVar));
        }
    }

    public final void m(@NonNull String str, @NonNull String str2, @NonNull File file, c.a.x0.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, str, str2, file, aVar) == null) {
            BOSResponseEntity uploadFileSync = BOSUploader.getInstance().uploadFileSync(str, str2, file);
            c.a.x0.a.f.a aVar2 = new c.a.x0.a.f.a(uploadFileSync.isSuccess(), uploadFileSync.getErrorCode(), uploadFileSync.getMessage());
            if (aVar != null) {
                aVar.a(aVar2);
            }
        }
    }
}
