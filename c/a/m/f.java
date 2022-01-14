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
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
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
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c f4253b;

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
                        c.a.m.m.c.c(e2);
                        return false;
                    }
                }
                return true;
            }
            return invokeLI.booleanValue;
        }
    }

    public f(Context context, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f4253b = cVar;
    }

    public static void d(String str, String str2) {
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
            byte[] a2 = c.a.m.j.a.g.a();
            fileWriter.write(c.a.m.k.a.a(c.a.m.j.a.c.d(a2, a2, (str + "=" + str2).getBytes()), "utf-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    public static void m(String str) {
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

    public final e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? e.b(l("com.baidu.deviceid"), l("bd_setting_i")) : (e) invokeV.objValue;
    }

    public final e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            List<b> h2 = this.f4253b.h(context);
            e eVar = null;
            if (h2 != null) {
                String str = com.baidu.fsg.face.base.b.c.f34001g;
                File filesDir = context.getFilesDir();
                if (!com.baidu.fsg.face.base.b.c.f34001g.equals(filesDir.getName())) {
                    String str2 = "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath();
                    str = filesDir.getName();
                }
                for (b bVar : h2) {
                    if (!bVar.f4248d) {
                        File file = new File(new File(bVar.a.dataDir, str), "libcuid.so");
                        if (file.exists() && (eVar = e.a(c.a.m.m.c.a(file))) != null) {
                            break;
                        }
                    }
                }
            }
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
        if (r0 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r2 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0090, code lost:
        if (r2 == null) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(e eVar) {
        boolean j2;
        boolean e2;
        e k;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            File file = new File(this.a.getFilesDir(), "libcuid.so");
            String j3 = eVar.j();
            if (file.exists()) {
                e a2 = e.a(c.a.m.m.c.a(file));
                if (a2 != null) {
                    if (a2.c()) {
                        n(a2.j());
                    }
                }
                j2 = j();
                if (j2) {
                    String l = l("com.baidu.deviceid.v2");
                    if (!TextUtils.isEmpty(l)) {
                        e a3 = e.a(l);
                        if (a3 != null) {
                            if (a3.c()) {
                                h("com.baidu.deviceid.v2", a3.j());
                            }
                        }
                    }
                    h("com.baidu.deviceid.v2", j3);
                }
                e2 = e("android.permission.WRITE_EXTERNAL_STORAGE");
                if (e2) {
                    if (new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2").exists()) {
                        e f2 = f();
                        if (f2 != null) {
                            if (f2.c()) {
                                j3 = f2.j();
                            }
                        }
                    }
                    m(j3);
                }
                if (j2) {
                    String l2 = l("bd_setting_i");
                    if (e.d(TextUtils.isEmpty(l2) ? 0 : l2.length())) {
                        str = "O";
                    } else {
                        str = e.m(l2) ? "0" : "0";
                    }
                    h("bd_setting_i", str);
                }
                if (e2 || !new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid").exists() || (k = k(i(""))) == null || !k.c()) {
                    return;
                }
                d(k.f4250b, k.a);
                return;
            }
            n(j3);
            j2 = j();
            if (j2) {
            }
            e2 = e("android.permission.WRITE_EXTERNAL_STORAGE");
            if (e2) {
            }
            if (j2) {
            }
            if (e2) {
            }
        }
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.a.checkPermission(str, Process.myPid(), Process.myUid()) == 0 : invokeL.booleanValue;
    }

    public final e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (file.exists()) {
                return e.a(c.a.m.m.c.a(file));
            }
            return null;
        }
        return (e) invokeV.objValue;
    }

    public e g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            e b2 = b(this.a);
            if (b2 == null) {
                b2 = e.a(l("com.baidu.deviceid.v2"));
            }
            boolean e2 = e(s.f55248i);
            if (b2 == null && e2) {
                b2 = f();
            }
            if (b2 == null) {
                b2 = a();
            }
            boolean z = false;
            if (b2 == null && e2) {
                z = true;
                b2 = k(i(""));
            }
            if (!z) {
                i("");
            }
            if (b2 != null) {
                b2.c();
            }
            return b2;
        }
        return (e) invokeL.objValue;
    }

    public final boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            try {
                return Settings.System.putString(this.a.getContentResolver(), str, str2);
            } catch (Exception e2) {
                c.a.m.m.c.c(e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? "0" : (String) invokeL.objValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? e("android.permission.WRITE_SETTINGS") : invokeV.booleanValue;
    }

    public final e k(String str) {
        InterceptResult invokeL;
        String str2;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
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
                    sb.append("\r\n");
                }
                bufferedReader.close();
                byte[] a2 = c.a.m.j.a.g.a();
                split = new String(c.a.m.j.a.c.c(a2, a2, c.a.m.k.a.b(sb.toString().getBytes()))).split("=");
            } catch (FileNotFoundException | IOException | Exception unused) {
            }
            if (split != null && split.length == 2) {
                str2 = split[0];
                try {
                    str3 = split[1];
                } catch (FileNotFoundException | IOException | Exception unused2) {
                }
                return e.b(str3, str2);
            }
            str2 = "";
            return e.b(str3, str2);
        }
        return (e) invokeL.objValue;
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            try {
                return Settings.System.getString(this.a.getContentResolver(), str);
            } catch (Exception e2) {
                c.a.m.m.c.c(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @SuppressLint({"NewApi"})
    public final boolean n(String str) {
        InterceptResult invokeL;
        String absolutePath;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            int i3 = (!DeviceId.sDataCuidInfoShable || Build.VERSION.SDK_INT >= 24) ? 0 : 1;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    fileOutputStream = this.a.openFileOutput("libcuid.so", i3);
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.flush();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            c.a.m.m.c.c(e2);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (i3 == 0 && DeviceId.sDataCuidInfoShable) {
                            absolutePath = new File(this.a.getFilesDir(), "libcuid.so").getAbsolutePath();
                            i2 = 436;
                        } else if (!DeviceId.sDataCuidInfoShable) {
                            absolutePath = new File(this.a.getFilesDir(), "libcuid.so").getAbsolutePath();
                            i2 = 432;
                        }
                        return a.a(absolutePath, i2);
                    }
                    return true;
                } catch (Exception e3) {
                    c.a.m.m.c.c(e3);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                            c.a.m.m.c.c(e4);
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                        c.a.m.m.c.c(e5);
                    }
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }
}
