package c.a.s0.a.p0.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.a1.d;
import c.a.s0.a.o2.g.h;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8422b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f8423c;

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
            this.f8422b = str;
            this.f8423c = str2;
        }

        @Override // c.a.s0.a.a1.d.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.e0.d.k("DebugDependencyControl", "debug扩展库下载失败 url=" + this.f8423c);
                if (this.a == null || TextUtils.isEmpty(this.f8422b)) {
                    return;
                }
                this.a.handleSchemeDispatchCallback(this.f8422b, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        }

        @Override // c.a.s0.a.a1.d.c
        public void onProgressChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // c.a.s0.a.a1.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a != null && !TextUtils.isEmpty(this.f8422b)) {
                    File j2 = b.j();
                    c.a.s0.a.e0.d.k("DebugDependencyControl", "debug扩展库下载成功 file=" + j2.getAbsolutePath());
                    Pair d2 = b.d(j2);
                    if (((Boolean) d2.first).booleanValue()) {
                        if (!b.o((File) d2.second)) {
                            c.a.s0.a.e0.d.k("DebugDependencyControl", "debug扩展库解压失败 file=" + j2.getAbsolutePath());
                            this.a.handleSchemeDispatchCallback(this.f8422b, UnitedSchemeUtility.wrapCallbackParams(1001, "debug扩展库解压失败").toString());
                            return;
                        }
                        b.n(true);
                        this.a.handleSchemeDispatchCallback(this.f8422b, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                        return;
                    }
                    c.a.s0.a.e0.d.k("DebugDependencyControl", "debug扩展库解密失败 file=" + j2.getAbsolutePath());
                    this.a.handleSchemeDispatchCallback(this.f8422b, UnitedSchemeUtility.wrapCallbackParams(1001, "debug扩展库解密失败").toString());
                    return;
                }
                c.a.s0.a.e0.d.k("DebugDependencyControl", "debug扩展库下载成功 handler=" + this.a + " cb=" + this.f8422b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-15818089, "Lc/a/s0/a/p0/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-15818089, "Lc/a/s0/a/p0/f/b;");
                return;
            }
        }
        a = "190d49fefe87b97c6b8adeebd11fc227".getBytes(StandardCharsets.UTF_8);
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            for (File file : l()) {
                c.a.s0.w.d.j(file);
            }
        }
    }

    public static Pair<Boolean, File> d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            if (file != null && file.exists()) {
                File g2 = g();
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileOutputStream fileOutputStream = new FileOutputStream(g2);
                    byte[] bArr = new byte[16];
                    fileInputStream.skip(10L);
                    fileInputStream.read(bArr, 0, 10);
                    fileInputStream.skip(5L);
                    fileInputStream.read(bArr, 10, 6);
                    fileInputStream.skip(3L);
                    byte[] bArr2 = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr2);
                    g2.deleteOnExit();
                    g2.createNewFile();
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(a, "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(2, secretKeySpec, ivParameterSpec);
                    fileOutputStream.write(cipher.doFinal(bArr2));
                    fileOutputStream.flush();
                    c.a.s0.w.d.L(file);
                    Pair<Boolean, File> pair = new Pair<>(Boolean.TRUE, g2);
                    fileOutputStream.close();
                    fileInputStream.close();
                    return pair;
                } catch (Exception e2) {
                    c.a.s0.a.e0.d.l("DebugDependencyControl", "debug扩展库解密失败: ", e2);
                    return new Pair<>(Boolean.FALSE, null);
                }
            }
            return new Pair<>(Boolean.FALSE, null);
        }
        return (Pair) invokeL.objValue;
    }

    public static synchronized void e(@NonNull String str, @Nullable CallbackHandler callbackHandler, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, callbackHandler, str2) == null) {
            synchronized (b.class) {
                if (TextUtils.isEmpty(str)) {
                    c.a.s0.a.e0.d.k("DebugDependencyControl", "download url is empty");
                } else {
                    c.a.s0.a.a1.d.G(str, new a(callbackHandler, str2, str));
                }
            }
        }
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? c.a.s0.a.a1.d.r() : (String) invokeV.objValue;
    }

    public static File g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new File(f(), "dependency_decrypt.zip") : (File) invokeV.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return f() + File.separator + str + File.separator + "debug_dependency";
        }
        return (String) invokeL.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return f() + File.separator + "temp_unzip";
        }
        return (String) invokeV.objValue;
    }

    public static File j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? new File(f(), "dependency.zip") : (File) invokeV.objValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? h.a().getBoolean("debugDependency", false) : invokeV.booleanValue;
    }

    @NonNull
    public static List<File> l() {
        InterceptResult invokeV;
        File[] C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (File file : c.a.s0.w.d.C(new File(f()))) {
                if (file.isDirectory()) {
                    File[] C2 = c.a.s0.w.d.C(file);
                    int length = C2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            File file2 = C2[i2];
                            if (file2.isDirectory() && "debug_dependency".equals(file2.getName())) {
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

    public static String m(@NonNull File file) {
        InterceptResult invokeL;
        String str;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, file)) == null) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length == 1 && listFiles[0].isDirectory()) {
                c.a.s0.w.d.e(listFiles[0], file);
                c.a.s0.w.d.L(listFiles[0]);
            }
            try {
                str = new JSONObject(c.a.s0.w.d.E(new File(file, "swan-package.json"))).getString("name");
            } catch (JSONException e2) {
                e2.printStackTrace();
                str = "";
            }
            return TextUtils.isEmpty(str) ? "unknown" : str;
        }
        return (String) invokeL.objValue;
    }

    public static void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            h.a().putBoolean("debugDependency", z);
        }
    }

    public static boolean o(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, file)) == null) {
            boolean z = false;
            if (file != null && file.exists()) {
                File file2 = new File(i());
                c.a.s0.w.d.l(file2);
                if (c.a.s0.w.d.U(file.getAbsolutePath(), file2.getAbsolutePath())) {
                    File file3 = new File(h(m(file2)));
                    if (file3.exists()) {
                        c.a.s0.w.d.L(file3);
                    }
                    file3.mkdirs();
                    c.a.s0.w.d.e(file2, file3);
                    c.a.s0.w.d.L(file2);
                    c.a.s0.w.d.L(file);
                    z = true;
                }
                c.a.s0.a.e0.d.k("DebugDependencyControl", "debug扩展库解压结果: unzipSuccess=" + z);
                return z;
            }
            c.a.s0.a.e0.d.k("DebugDependencyControl", "debug扩展库压缩包不存在");
            return false;
        }
        return invokeL.booleanValue;
    }
}
