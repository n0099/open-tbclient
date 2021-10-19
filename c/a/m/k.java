package c.a.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.system.Os;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.m.d.a.g;
import c.a.m.f;
import com.android.internal.http.multipart.Part;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
/* loaded from: classes.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f4047a;

    /* renamed from: b  reason: collision with root package name */
    public f f4048b;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i2)) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        Os.chmod(str, i2);
                        return true;
                    } catch (Exception e2) {
                        c.a.m.i.c.c(e2);
                        return false;
                    }
                }
                return true;
            }
            return invokeLI.booleanValue;
        }
    }

    public k(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4047a = context;
        this.f4048b = fVar;
    }

    public static void g(String str, String str2) {
        File file;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file3 = new File(file2, ".cuid");
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            byte[] a2 = g.a();
            fileWriter.write(f.b.a(c.a.m.d.a.c.c(a2, a2, (str + "=" + str2).getBytes()), "utf-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    public static void l(String str) {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
            File file3 = new File(file2, ".cuid2");
            try {
                if (file2.exists() && !file2.isDirectory()) {
                    Random random = new Random();
                    File parentFile = file2.getParentFile();
                    String name = file2.getName();
                    do {
                        file = new File(parentFile, name + random.nextInt() + ".tmp");
                    } while (file.exists());
                    file2.renameTo(file);
                    file.delete();
                }
                file2.mkdirs();
                FileWriter fileWriter = new FileWriter(file3, false);
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException | Exception unused) {
            }
        }
    }

    public final j a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            List<e> h2 = this.f4048b.h(context);
            j jVar = null;
            if (h2 != null) {
                String str = com.baidu.fsg.face.base.b.c.f39845g;
                File filesDir = context.getFilesDir();
                if (!com.baidu.fsg.face.base.b.c.f39845g.equals(filesDir.getName())) {
                    String str2 = "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath();
                    str = filesDir.getName();
                }
                for (e eVar : h2) {
                    if (!eVar.f4028d) {
                        File file = new File(new File(eVar.f4025a.dataDir, str), "libcuid.so");
                        if (file.exists() && (jVar = j.e(c.a.m.i.c.a(file))) != null) {
                            break;
                        }
                    }
                }
            }
            return jVar;
        }
        return (j) invokeL.objValue;
    }

    public j b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            j a2 = a(this.f4047a);
            if (a2 == null) {
                a2 = j.e(k("com.baidu.deviceid.v2"));
            }
            boolean j2 = j("android.permission.READ_EXTERNAL_STORAGE");
            if (a2 == null && j2) {
                a2 = f();
            }
            if (a2 == null) {
                a2 = i();
            }
            boolean z = false;
            if (a2 == null && j2) {
                z = true;
                a2 = n(m(""));
            }
            if (!z) {
                m("");
            }
            if (a2 != null) {
                a2.k();
            }
            return a2;
        }
        return (j) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (r0 == null) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0064, code lost:
        if (r2 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0095, code lost:
        if (r2 == null) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(j jVar) {
        boolean d2;
        boolean j2;
        j n;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar) == null) {
            File file = new File(this.f4047a.getFilesDir(), "libcuid.so");
            String h2 = jVar.h();
            if (file.exists()) {
                j e2 = j.e(c.a.m.i.c.a(file));
                if (e2 != null) {
                    if (e2.k()) {
                        h(e2.h());
                    }
                }
                d2 = d();
                if (d2) {
                    String k = k("com.baidu.deviceid.v2");
                    if (!TextUtils.isEmpty(k)) {
                        j e3 = j.e(k);
                        if (e3 != null) {
                            if (e3.k()) {
                                e("com.baidu.deviceid.v2", e3.h());
                            }
                        }
                    }
                    e("com.baidu.deviceid.v2", h2);
                }
                j2 = j("android.permission.WRITE_EXTERNAL_STORAGE");
                if (j2) {
                    if (new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2").exists()) {
                        j f2 = f();
                        if (f2 != null) {
                            if (f2.k()) {
                                h2 = f2.h();
                            }
                        }
                    }
                    l(h2);
                }
                if (d2) {
                    String k2 = k("bd_setting_i");
                    if (j.c(TextUtils.isEmpty(k2) ? 0 : k2.length())) {
                        str = "O";
                    } else {
                        str = j.d(k2) ? "0" : "0";
                    }
                    e("bd_setting_i", str);
                }
                if (j2 || !new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid").exists() || (n = n(m(""))) == null || !n.k()) {
                    return;
                }
                g(n.f4044b, n.f4043a);
                return;
            }
            h(h2);
            d2 = d();
            if (d2) {
            }
            j2 = j("android.permission.WRITE_EXTERNAL_STORAGE");
            if (j2) {
            }
            if (d2) {
            }
            if (j2) {
            }
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? j("android.permission.WRITE_SETTINGS") : invokeV.booleanValue;
    }

    public final boolean e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            try {
                return Settings.System.putString(this.f4047a.getContentResolver(), str, str2);
            } catch (Exception e2) {
                c.a.m.i.c.c(e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final j f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (file.exists()) {
                return j.e(c.a.m.i.c.a(file));
            }
            return null;
        }
        return (j) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @SuppressLint({"NewApi"})
    public final boolean h(String str) {
        InterceptResult invokeL;
        int i2;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            int i3 = (!DeviceId.sDataCuidInfoShable || Build.VERSION.SDK_INT >= 24) ? 0 : 1;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    fileOutputStream = this.f4047a.openFileOutput("libcuid.so", i3);
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.flush();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            c.a.m.i.c.c(e2);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (i3 == 0 && DeviceId.sDataCuidInfoShable) {
                            i2 = 436;
                            file = new File(this.f4047a.getFilesDir(), "libcuid.so");
                        } else if (!DeviceId.sDataCuidInfoShable) {
                            i2 = 432;
                            file = new File(this.f4047a.getFilesDir(), "libcuid.so");
                        }
                        return a.a(file.getAbsolutePath(), i2);
                    }
                    return true;
                } catch (Exception e3) {
                    c.a.m.i.c.c(e3);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                            c.a.m.i.c.c(e4);
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                        c.a.m.i.c.c(e5);
                    }
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }

    public final j i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? j.a(k("com.baidu.deviceid"), k("bd_setting_i")) : (j) invokeV.objValue;
    }

    public final boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? this.f4047a.checkPermission(str, Process.myPid(), Process.myUid()) == 0 : invokeL.booleanValue;
    }

    public final String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            try {
                return Settings.System.getString(this.f4047a.getContentResolver(), str);
            } catch (Exception e2) {
                c.a.m.i.c.c(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? "0" : (String) invokeL.objValue;
    }

    public final j n(String str) {
        InterceptResult invokeL;
        String str2;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            String str3 = "";
            File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
            if (!file.exists()) {
                file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append(Part.CRLF);
                }
                bufferedReader.close();
                byte[] a2 = g.a();
                split = new String(c.a.m.d.a.c.d(a2, a2, f.b.b(sb.toString().getBytes()))).split("=");
            } catch (FileNotFoundException | IOException | Exception unused) {
            }
            if (split != null && split.length == 2) {
                str2 = split[0];
                try {
                    str3 = split[1];
                } catch (FileNotFoundException | IOException | Exception unused2) {
                }
                return j.a(str3, str2);
            }
            str2 = "";
            return j.a(str3, str2);
        }
        return (j) invokeL.objValue;
    }
}
