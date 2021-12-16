package c.a.q0.a.p0.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.a1.d;
import c.a.q0.a.o2.g.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public static final File a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f7630b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7631b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7632c;

        public a(CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.f7631b = str;
            this.f7632c = str2;
        }

        @Override // c.a.q0.a.a1.d.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.e0.d.k("DebugDynamicLibControl", "debug动态库下载失败 url=" + this.f7632c);
                if (this.a == null || TextUtils.isEmpty(this.f7631b)) {
                    return;
                }
                this.a.handleSchemeDispatchCallback(this.f7631b, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        }

        @Override // c.a.q0.a.a1.d.c
        public void onProgressChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // c.a.q0.a.a1.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a != null && !TextUtils.isEmpty(this.f7631b)) {
                    File j2 = c.j();
                    c.a.q0.a.e0.d.k("DebugDynamicLibControl", "debug动态库下载成功 file=" + j2.getAbsolutePath());
                    Pair g2 = c.g(j2);
                    if (!((Boolean) g2.first).booleanValue()) {
                        c.a.q0.a.e0.d.k("DebugDynamicLibControl", "debug动态库解密失败 file=" + j2.getAbsolutePath());
                        this.a.handleSchemeDispatchCallback(this.f7631b, UnitedSchemeUtility.wrapCallbackParams(1001, "debug动态库解密失败").toString());
                        return;
                    } else if (((Boolean) c.s((File) g2.second).first).booleanValue()) {
                        c.r(true);
                        this.a.handleSchemeDispatchCallback(this.f7631b, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                        return;
                    } else {
                        c.a.q0.a.e0.d.k("DebugDynamicLibControl", "debug动态库解压失败 file=" + j2.getAbsolutePath());
                        this.a.handleSchemeDispatchCallback(this.f7631b, UnitedSchemeUtility.wrapCallbackParams(1001, "debug动态库解压失败").toString());
                        return;
                    }
                }
                c.a.q0.a.e0.d.k("DebugDynamicLibControl", "debug动态库下载成功，但是 handler=" + this.a + " cb=" + this.f7631b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-273983496, "Lc/a/q0/a/p0/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-273983496, "Lc/a/q0/a/p0/f/c;");
                return;
            }
        }
        a = c.a.q0.a.a1.d.q();
        f7630b = "rMzurs3ur83vsM7vss/vtNHwt9LwuNPx".getBytes(StandardCharsets.UTF_8);
    }

    public static File d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return new File(a.getAbsolutePath() + File.separator + str + File.separator + "debug_dynamic");
        }
        return (File) invokeL.objValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            c.a.q0.w.d.j(j());
            c.a.q0.w.d.j(k());
            for (File file : n()) {
                c.a.q0.w.d.j(file);
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            r(false);
            e();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static Pair<Boolean, File> g(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65543, null, file)) != null) {
            return (Pair) invokeL.objValue;
        }
        if (file != null && file.exists()) {
            File file2 = new File(file.getAbsolutePath() + ".zip");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[16];
                    fileInputStream.skip(10L);
                    fileInputStream.read(bArr, 0, 10);
                    fileInputStream.skip(5L);
                    fileInputStream.read(bArr, 10, 6);
                    fileInputStream.skip(3L);
                    byte[] bArr2 = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr2);
                    file2.deleteOnExit();
                    file2.createNewFile();
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(f7630b, "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(2, secretKeySpec, ivParameterSpec);
                    fileOutputStream.write(cipher.doFinal(bArr2));
                    fileOutputStream.flush();
                    Pair<Boolean, File> pair = new Pair<>(Boolean.TRUE, file2);
                    fileOutputStream.close();
                    fileInputStream.close();
                    return pair;
                } finally {
                }
            } catch (Exception e2) {
                c.a.q0.a.e0.d.l("DebugDynamicLibControl", "debug动态库解密失败: ", e2);
                return new Pair<>(Boolean.FALSE, null);
            }
        } else {
            return new Pair<>(Boolean.FALSE, null);
        }
    }

    public static synchronized void h(@NonNull String str, @Nullable CallbackHandler callbackHandler, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, callbackHandler, str2) == null) {
            synchronized (c.class) {
                if (TextUtils.isEmpty(str)) {
                    c.a.q0.a.e0.d.k("DebugDynamicLibControl", "download url is empty");
                } else {
                    c.a.q0.a.a1.d.H(str, new a(callbackHandler, str2, str));
                }
            }
        }
    }

    public static Pair<Boolean, File> i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            File d2 = d(str);
            if (d2.exists() && d2.isDirectory()) {
                return new Pair<>(Boolean.TRUE, d2);
            }
            return new Pair<>(Boolean.FALSE, null);
        }
        return (Pair) invokeL.objValue;
    }

    public static File j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? new File(c.a.q0.a.f1.c.a.d().get(0).a, "debugDynamicLib.zip") : (File) invokeV.objValue;
    }

    public static File k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? new File(c.a.q0.a.f1.c.a.d().get(0).a, "aiapps_debug_dynamic_lib") : (File) invokeV.objValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? h.a().getBoolean("KEY_SWAN_APP_DEBUG_DYNAMIC_LIB_MODE", false) : invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? l() : invokeV.booleanValue;
    }

    public static List<File> n() {
        InterceptResult invokeV;
        File[] C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (File file : c.a.q0.w.d.C(a)) {
                if (file.isDirectory()) {
                    File[] C2 = c.a.q0.w.d.C(file);
                    int length = C2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            File file2 = C2[i2];
                            if (file2.isDirectory() && "debug_dynamic".equals(file2.getName())) {
                                arrayList.add(file2);
                                break;
                            }
                            i2++;
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @NonNull
    public static List<String> o() {
        InterceptResult invokeV;
        File[] C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (File file : c.a.q0.w.d.C(a)) {
                if (file.isDirectory()) {
                    File[] C2 = c.a.q0.w.d.C(file);
                    int length = C2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            File file2 = C2[i2];
                            if (file2.isDirectory() && "debug_dynamic".equals(file2.getName())) {
                                arrayList.add(file.getName());
                                break;
                            }
                            i2++;
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            r(true);
        }
    }

    public static String q(File file) throws Exception {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, file)) == null) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length == 1 && listFiles[0].isDirectory()) {
                c.a.q0.w.d.e(listFiles[0], file);
                c.a.q0.w.d.j(listFiles[0]);
            }
            return (String) new JSONObject(c.a.q0.w.d.E(new File(file, "dynamicLib.json"))).get("name");
        }
        return (String) invokeL.objValue;
    }

    public static void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            h.a().putBoolean("KEY_SWAN_APP_DEBUG_DYNAMIC_LIB_MODE", z);
        }
    }

    public static Pair<Boolean, String> s(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, file)) == null) {
            String str = "";
            boolean z = false;
            try {
                File k2 = k();
                c.a.q0.w.d.l(k2);
                if (file.exists() && c.a.q0.w.d.U(file.getAbsolutePath(), k2.getAbsolutePath())) {
                    str = q(k2);
                    File d2 = d(str);
                    if (d2.exists()) {
                        c.a.q0.w.d.j(d2);
                    }
                    d2.mkdirs();
                    c.a.q0.w.d.e(k2, d2);
                    c.a.q0.w.d.j(k2);
                    c.a.q0.w.d.j(file);
                    z = true;
                }
            } catch (Exception e2) {
                c.a.q0.a.e0.d.k("DebugDynamicLibControl", "debug动态库解压异常: " + e2.toString());
            }
            c.a.q0.a.e0.d.k("DebugDynamicLibControl", "debug动态库解压结果: unzipSuccess=" + z + " dynamicLibName=" + str);
            return new Pair<>(Boolean.valueOf(z), str);
        }
        return (Pair) invokeL.objValue;
    }
}
