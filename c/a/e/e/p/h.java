package c.a.e.e.p;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.IDevices;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static h f2553a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Object, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f2554a;

        /* renamed from: b  reason: collision with root package name */
        public String f2555b;

        /* renamed from: c  reason: collision with root package name */
        public StringBuilder f2556c;

        /* renamed from: d  reason: collision with root package name */
        public i f2557d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2558e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f2559f;

        public a(h hVar, String str, String str2, StringBuilder sb, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, str2, sb, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2559f = hVar;
            this.f2554a = str;
            this.f2555b = str2;
            this.f2556c = sb;
            this.f2557d = iVar;
            this.f2558e = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                boolean i2 = this.f2559f.i(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, this.f2554a, this.f2556c);
                this.f2558e = i2;
                if (i2) {
                    return null;
                }
                this.f2559f.d(this.f2555b, "".getBytes(), this.f2556c);
                return null;
            }
            return invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                super.onPostExecute(obj);
                if (this.f2556c.length() > 0) {
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    bdStatisticsManager.error("so", "load_" + this.f2554a + ".so", "", -9101, this.f2556c.toString(), new Object[0]);
                }
                i iVar = this.f2557d;
                if (iVar != null) {
                    iVar.a(this.f2558e);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1211692172, "Lc/a/e/e/p/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1211692172, "Lc/a/e/e/p/h;");
        }
    }

    public h() {
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

    public static h f() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            h hVar2 = f2553a;
            if (hVar2 == null) {
                synchronized (h.class) {
                    if (f2553a == null) {
                        f2553a = new h();
                    }
                    hVar = f2553a;
                }
                return hVar;
            }
            return hVar2;
        }
        return (h) invokeV.objValue;
    }

    public final boolean c(String str, StringBuilder sb) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sb)) == null) {
            String g2 = g(str);
            File file = new File(h(str));
            if (!file.exists()) {
                sb.append("false_file_null");
                return false;
            }
            File file2 = new File(g2);
            if (!file2.exists()) {
                sb.append("true_lib_null");
                return true;
            }
            String e2 = e(file);
            if (e2 != null && e2.equals(e(file2))) {
                sb.append("true_md5_equals");
                return true;
            }
            sb.append("false_md5_not_equals");
            file.delete();
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void d(String str, byte[] bArr, StringBuilder sb) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr, sb) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(new File(str));
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(bArr);
                c.a.e.e.m.a.d(fileOutputStream);
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                sb.append("-Error4:");
                sb.append(e.getClass().getName() + "-" + e.getMessage());
                sb.append("-");
                c.a.e.e.m.a.d(fileOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                c.a.e.e.m.a.d(fileOutputStream2);
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [long] */
    public final String e(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) {
            FileInputStream fileInputStream2 = null;
            if (file != null && file.exists()) {
                ?? length = file.length();
                try {
                    if (length > 0) {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                String b2 = q.b(fileInputStream);
                                if (!StringUtils.isNull(b2)) {
                                    b2 = b2.toLowerCase();
                                }
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    BdLog.d(e2.getMessage());
                                }
                                return b2;
                            } catch (Exception e3) {
                                e = e3;
                                BdLog.d(e.getMessage());
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e4) {
                                        BdLog.d(e4.getMessage());
                                    }
                                }
                                return null;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            fileInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e6) {
                                    BdLog.d(e6.getMessage());
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = length;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + "lib" + File.separator + "lib" + str + ".so";
        }
        return (String) invokeL.objValue;
    }

    public final String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + com.baidu.fsg.face.base.b.c.f39676g + File.separator + "lib" + str + ".so";
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0126 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.InputStream] */
    public final boolean i(String str, String str2, StringBuilder sb) {
        InterceptResult invokeLLL;
        Throwable th;
        ZipInputStream zipInputStream;
        IOException e2;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, sb)) == null) {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("lib");
            sb2.append(File.separator);
            sb2.append("x86");
            sb2.append(File.separator);
            sb2.append("lib");
            sb2.append(str2);
            ?? r4 = ".so";
            sb2.append(".so");
            arrayList.add(sb2.toString());
            arrayList.add("lib" + File.separator + IDevices.ABI_MIPS + File.separator + "lib" + str2 + ".so");
            arrayList.add("lib" + File.separator + "armeabi" + File.separator + "lib" + str2 + ".so");
            File file = new File(str);
            boolean z = false;
            if (file.exists()) {
                try {
                    try {
                        zipInputStream = new ZipInputStream(new FileInputStream(file));
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                ZipEntry nextEntry = zipInputStream.getNextEntry();
                                if (nextEntry == null) {
                                    break;
                                } else if (arrayList.contains(nextEntry.getName())) {
                                    try {
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        while (true) {
                                            try {
                                                int read = zipInputStream.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(bArr, 0, read);
                                            } catch (Exception unused) {
                                            } catch (Throwable th3) {
                                                th2 = th3;
                                                c.a.e.e.m.a.d(byteArrayOutputStream);
                                                throw th2;
                                            }
                                        }
                                        byteArrayOutputStream.flush();
                                        String h2 = h(str2);
                                        d(h2, byteArrayOutputStream.toByteArray(), sb);
                                        if (n(h2, sb)) {
                                            sb.append("-Succ5-");
                                            z = true;
                                            c.a.e.e.m.a.d(byteArrayOutputStream);
                                            break;
                                        }
                                    } catch (Exception unused2) {
                                        byteArrayOutputStream = null;
                                    } catch (Throwable th4) {
                                        byteArrayOutputStream = null;
                                        th2 = th4;
                                    }
                                    c.a.e.e.m.a.d(byteArrayOutputStream);
                                }
                            }
                        } catch (IOException e3) {
                            e2 = e3;
                            sb.append("-Error5:");
                            sb.append(e2.getClass().getName() + "-" + e2.getMessage());
                            sb.append("-");
                            c.a.e.e.m.a.c(zipInputStream);
                            return z;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        c.a.e.e.m.a.c(r4);
                        throw th;
                    }
                } catch (IOException e4) {
                    zipInputStream = null;
                    e2 = e4;
                } catch (Throwable th6) {
                    r4 = 0;
                    th = th6;
                    c.a.e.e.m.a.c(r4);
                    throw th;
                }
                c.a.e.e.m.a.c(zipInputStream);
                return z;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public boolean j(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i2)) == null) {
            StringBuilder sb = new StringBuilder();
            if (BdBaseApplication.getInst().getApp() == null || BdBaseApplication.getInst().getApp().getApplicationInfo() == null) {
                return false;
            }
            boolean z = false;
            for (int i3 = 0; i3 < i2; i3++) {
                z = l(str, sb);
                if (z) {
                    break;
                }
            }
            if (!z) {
                String h2 = h(str);
                File file = new File(h2);
                if (file.exists()) {
                    if (file.length() > 0) {
                        z = n(h2, sb);
                        if (z) {
                            sb.append("-Succ2-");
                        } else {
                            sb.append("-Error7-");
                        }
                    } else {
                        sb.append("-Error6:soSize1-");
                    }
                }
            }
            if (sb.length() > 0) {
                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                bdStatisticsManager.error("so", "load_" + str + ".so", "", -9101, sb.toString(), new Object[0]);
            }
            return z;
        }
        return invokeLI.booleanValue;
    }

    public boolean k(String str, int i2, i iVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, str, i2, iVar)) == null) {
            StringBuilder sb = new StringBuilder();
            if (BdBaseApplication.getInst().getApp() == null || BdBaseApplication.getInst().getApp().getApplicationInfo() == null) {
                return false;
            }
            boolean z = false;
            for (int i3 = 0; i3 < i2; i3++) {
                z = l(str, sb);
                if (z) {
                    break;
                }
            }
            if (!z) {
                String h2 = h(str);
                File file = new File(h2);
                if (file.exists()) {
                    if (file.length() > 0) {
                        z = n(h2, sb);
                        if (z) {
                            sb.append("-Succ2-");
                        } else {
                            sb.append("-Error7-");
                        }
                    } else {
                        sb.append("-Error6:soSize1-");
                    }
                } else {
                    a aVar = new a(this, str, h2, sb, iVar);
                    aVar.setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen()));
                    aVar.execute(new Object[0]);
                    return false;
                }
            }
            if (sb.length() > 0) {
                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                bdStatisticsManager.error("so", "load_" + str + ".so", "", -9101, sb.toString(), new Object[0]);
            }
            return z;
        }
        return invokeLIL.booleanValue;
    }

    public final boolean l(String str, StringBuilder sb) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, sb)) == null) {
            boolean n = n(g(str), sb);
            if (n) {
                return n;
            }
            try {
                System.loadLibrary(str);
                sb.append("-Succ3-");
                return true;
            } catch (Throwable th) {
                sb.append("-Error3:");
                sb.append(th.getClass().getName() + "-" + th.getMessage());
                sb.append("-");
                return n;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (BdBaseApplication.getInst().getApp() == null || BdBaseApplication.getInst().getApp().getApplicationInfo() == null) {
                return false;
            }
            boolean l = l(str, sb);
            if (!l) {
                BdStatisticsManager.getInstance().error("so", 0L, (String) null, "try", "2", "exception", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                if (c(str, sb2)) {
                    l = n(h(str), sb2);
                    if (!l) {
                        new File(h(str)).delete();
                    } else {
                        z = false;
                        BdStatisticsManager.getInstance().error("so", 0L, (String) null, "try", "3", "exception", sb2.toString(), "copyfile", Boolean.valueOf(z));
                        if (z) {
                            StringBuilder sb3 = new StringBuilder();
                            boolean i2 = i(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, str, sb3);
                            BdStatisticsManager.getInstance().error("so", 0L, (String) null, "try", "4", "exception", sb3.toString());
                            return i2;
                        }
                    }
                }
                z = true;
                BdStatisticsManager.getInstance().error("so", 0L, (String) null, "try", "3", "exception", sb2.toString(), "copyfile", Boolean.valueOf(z));
                if (z) {
                }
            }
            return l;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(String str, StringBuilder sb) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, sb)) == null) {
            if (!new File(str).exists()) {
                sb.append("-Error1:");
                sb.append(str);
                sb.append("_FileNotFound-");
            } else {
                try {
                    System.load(str);
                    return true;
                } catch (Throwable th) {
                    sb.append("-Error2:");
                    sb.append(th.getClass().getName() + "-" + th.getMessage());
                    sb.append("-");
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
