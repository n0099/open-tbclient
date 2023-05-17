package com.baidu.platform.comapi.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final c a;
    public transient /* synthetic */ FieldHolder $fh;
    public final SharedPreferences b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1126076211, "Lcom/baidu/platform/comapi/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1126076211, "Lcom/baidu/platform/comapi/b/c;");
                return;
            }
        }
        a = new c();
    }

    public c() {
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
        this.b = com.baidu.platform.comapi.b.d().getSharedPreferences("engine_resource_sp", 0);
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            String outputDirPath = SysOSUtil.getInstance().getOutputDirPath();
            File file = new File(outputDirPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            return outputDirPath;
        }
        return (String) invokeV.objValue;
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, file) != null) || file == null) {
            return;
        }
        if (!file.isFile() && (!file.exists() || file.list() == null || file.list().length != 0)) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    a(listFiles[i]);
                    listFiles[i].delete();
                }
            }
            if (file.exists()) {
                file.delete();
                return;
            }
            return;
        }
        file.delete();
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) != null) || this.b == null) {
            return;
        }
        File file = new File(str, "shader/");
        if (!file.exists()) {
            this.b.edit().putString(TaskInfo.keyFingerprint, Build.FINGERPRINT).commit();
            return;
        }
        String string = this.b.getString(TaskInfo.keyFingerprint, "");
        if (!TextUtils.isEmpty(string) && Build.FINGERPRINT.equals(string)) {
            return;
        }
        a(file);
        if (!file.exists()) {
            this.b.edit().putString(TaskInfo.keyFingerprint, Build.FINGERPRINT).commit();
        }
    }

    private boolean a(AssetManager assetManager, byte[] bArr, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, this, assetManager, bArr, str, str2)) == null) {
            InputStream inputStream = null;
            try {
                if (!TextUtils.isEmpty(str) && str.endsWith(".dir")) {
                    String substring = str.substring(0, str.indexOf(".dir"));
                    String substring2 = str2.substring(0, str2.indexOf(".dir"));
                    String[] list = assetManager.list(substring);
                    if (list != null && list.length > 0) {
                        File file = new File(substring2);
                        if (file.exists()) {
                            file.delete();
                        }
                        file.mkdirs();
                        for (String str3 : list) {
                            if (!TextUtils.isEmpty(str3)) {
                                a(assetManager, bArr, substring + "/" + str3, substring2 + "/" + str3);
                            }
                        }
                    }
                } else {
                    inputStream = assetManager.open(str);
                    File file2 = new File(str2);
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.isDirectory()) {
                        parentFile.mkdirs();
                    }
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.createNewFile();
                    a.a(inputStream, new FileOutputStream(file2), bArr);
                }
                a.a(inputStream);
                return true;
            } catch (Exception unused) {
                a.a(null);
                return false;
            } catch (Throwable th) {
                a.a(null);
                throw th;
            }
        }
        return invokeLLLL.booleanValue;
    }

    private boolean a(File file, byte[] bArr) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, file, bArr)) == null) {
            if (file != null && file.exists() && bArr != null) {
                FileInputStream fileInputStream2 = null;
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr2 = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr2);
                    if (Arrays.equals(bArr2, bArr)) {
                        a.a(fileInputStream);
                        return false;
                    }
                    a.a(fileInputStream);
                } catch (IOException unused2) {
                    fileInputStream2 = fileInputStream;
                    a.a(fileInputStream2);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    a.a(fileInputStream2);
                    throw th;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean b(File file, byte[] bArr) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, file, bArr)) == null) {
            if (file != null && bArr != null) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream.write(bArr);
                    a.a(fileOutputStream);
                    return true;
                } catch (Exception unused2) {
                    fileOutputStream2 = fileOutputStream;
                    a.a(fileOutputStream2);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    a.a(fileOutputStream2);
                    throw th;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0065 A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000c, B:8:0x0017, B:10:0x0021, B:12:0x0031, B:13:0x004e, B:20:0x005b, B:21:0x005f, B:23:0x0065), top: B:33:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(b bVar) {
        File file;
        boolean z;
        String[] b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            synchronized (this) {
                Context d = com.baidu.platform.comapi.b.d();
                byte[] bArr = null;
                boolean z2 = false;
                boolean z3 = true;
                try {
                    String a2 = a();
                    file = new File(a2, "/ver.dat");
                    try {
                        bArr = bVar.a();
                        z = a(file, bArr);
                        if (z) {
                            try {
                                AssetManager assets = d.getAssets();
                                byte[] bArr2 = new byte[65536];
                                for (String str : bVar.b()) {
                                    z3 = a(assets, bArr2, str, a2 + "/" + str);
                                }
                            } catch (RuntimeException | Exception unused) {
                                z3 = z;
                                z = z3;
                                if (z) {
                                    z2 = b(file, bArr);
                                }
                                if (OpenLogUtil.isMapLogEnable()) {
                                }
                            }
                        }
                        a(a2);
                        z2 = z3;
                    } catch (RuntimeException | Exception unused2) {
                    }
                } catch (RuntimeException | Exception unused3) {
                    file = null;
                }
                if (z && z2) {
                    z2 = b(file, bArr);
                }
                if (OpenLogUtil.isMapLogEnable()) {
                    com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("initEngineRes firstInit = " + z + "; isInitSucceed = " + z2);
                }
            }
        }
    }
}
