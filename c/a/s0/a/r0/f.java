package c.a.s0.a.r0;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.r0.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends c.a.s0.a.o2.f.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static List<String> f8820f;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f8821b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.s0.a.o2.f.d f8822c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.s0.a.o2.f.e f8823d;

    /* renamed from: e  reason: collision with root package name */
    public final String f8824e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(238701836, "Lc/a/s0/a/r0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(238701836, "Lc/a/s0/a/r0/f;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        f8820f = arrayList;
        arrayList.add("ascii");
        f8820f.add("base64");
        f8820f.add("binary");
        f8820f.add("hex");
        f8820f.add("utf-8");
        f8820f.add("utf8");
        f8820f.add("latin1");
        f8820f.add("ucs2");
        f8820f.add("ucs-2");
        f8820f.add("utf16le");
        f8820f.add("utf-16le");
    }

    public f(Context context, String str, @NonNull c.a.s0.a.o2.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f8821b = str;
        this.f8822c = dVar;
        this.f8823d = dVar.d();
        this.f8824e = new File(this.f8822c.f(), "record.pro").getAbsolutePath();
    }

    public c A(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            c x = n.x(str, n.G("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
            if (x != null) {
                return x;
            }
            c x2 = n.x(str2, n.G("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (x2 != null) {
                return x2;
            }
            if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                return d(-1, "fail permission denied, open " + str2);
            }
            String L = n.L(str);
            if (!this.f8822c.j(L, true)) {
                return d(-4, n.G("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            if (!n.V(str2)) {
                return d(-4, n.G("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            if (m(str2)) {
                return d(-1, n.G("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            String g2 = g(L);
            String g3 = g(str2);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, n.G("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            if (TextUtils.isEmpty(g3)) {
                return d(-1, n.G("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            File file = new File(g2);
            if (!file.exists()) {
                return d(-1, n.G("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            if (!g2.endsWith(".zip")) {
                return d(-1, "fail unzip failed");
            }
            if (!file.isFile()) {
                return d(-1, n.G("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            File file2 = new File(g3);
            if (!file2.exists()) {
                file2.mkdirs();
            } else if (file2.isFile()) {
                return d(-1, "fail unzip failed");
            }
            List<String> o = n.o(g3, true);
            if (!c.a.s0.w.d.U(g2, g3)) {
                return d(-1, "fail unzip failed");
            }
            if (str2.startsWith(a.USER_DATA_PATH)) {
                List<String> o2 = n.o(g3, true);
                ArrayList arrayList = new ArrayList(o2.size());
                long j2 = 0;
                for (String str3 : o2) {
                    if (!o.contains(str3)) {
                        arrayList.add(str3);
                        j2 += n.A(str3);
                    }
                }
                if (this.f8823d.a(j2)) {
                    n.i(arrayList);
                    return d(-1, p());
                }
                this.f8823d.b(j2);
            }
            return d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
        }
        return (c) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:102:0x01d2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:95:0x01df */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0155 A[Catch: all -> 0x01ce, Exception -> 0x01d1, TRY_LEAVE, TryCatch #5 {Exception -> 0x01d1, all -> 0x01ce, blocks: (B:44:0x00f5, B:46:0x00ff, B:48:0x0107, B:50:0x0117, B:53:0x0126, B:56:0x0133, B:58:0x013b, B:61:0x013f, B:63:0x0147, B:65:0x0155, B:68:0x0164, B:70:0x016c, B:72:0x0185, B:71:0x0177, B:78:0x0199, B:80:0x01a5, B:83:0x01b4), top: B:103:0x00f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0164 A[Catch: all -> 0x01ce, Exception -> 0x01d1, TRY_ENTER, TryCatch #5 {Exception -> 0x01d1, all -> 0x01ce, blocks: (B:44:0x00f5, B:46:0x00ff, B:48:0x0107, B:50:0x0117, B:53:0x0126, B:56:0x0133, B:58:0x013b, B:61:0x013f, B:63:0x0147, B:65:0x0155, B:68:0x0164, B:70:0x016c, B:72:0x0185, B:71:0x0177, B:78:0x0199, B:80:0x01a5, B:83:0x01b4), top: B:103:0x00f3 }] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v35 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c B(String str, Object obj, String str2, boolean z) {
        InterceptResult invokeCommon;
        FileOutputStream fileOutputStream;
        long length;
        FileOutputStream fileOutputStream2;
        String str3;
        long length2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, obj, str2, Boolean.valueOf(z)})) == null) {
            c n = n(str);
            if (n != null) {
                return n;
            }
            if (obj == null) {
                return d(-1, "The argument must be string or arrayBuffer");
            }
            int length3 = (a.USER_DATA_PATH + File.separator).length();
            if (!n.V(str)) {
                return d(-4, "fail permission denied, open " + str.substring(length3));
            }
            boolean z2 = obj instanceof byte[];
            String str4 = "utf-8";
            String str5 = str2;
            if (!z2) {
                boolean isEmpty = TextUtils.isEmpty(str2);
                str5 = str2;
                if (isEmpty) {
                    str5 = "utf-8";
                }
            }
            boolean isEmpty2 = TextUtils.isEmpty(str5);
            ?? r13 = str5;
            if (!isEmpty2) {
                boolean equals = "binary".equals(str5.toLowerCase());
                String str6 = str5;
                if (equals) {
                    str6 = "latin1";
                }
                boolean contains = f8820f.contains(str6.toLowerCase());
                r13 = str6;
                if (!contains) {
                    return d(-1, "fail invalid encoding \"" + str6 + "\"");
                }
            }
            c h2 = h(str, false);
            if (h2 != null) {
                return h2;
            }
            String g2 = g(str);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str.substring(length3));
            }
            File file = new File(g2);
            if (file.exists() && file.isDirectory()) {
                return d(-1, " fail illegal operation on a directory, open " + str);
            }
            long z3 = n.z(file);
            c d2 = d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    try {
                        if (!z2) {
                            if (!TextUtils.isEmpty((String) obj) && TextUtils.equals("base64", r13)) {
                                byte[] decode = Base64.decode((String) obj, 2);
                                length = decode.length;
                                if (this.f8823d.a(length)) {
                                    c d3 = d(-1, p());
                                    c.a.s0.w.d.d(null);
                                    c.a.s0.w.d.d(null);
                                    return d3;
                                }
                                FileOutputStream fileOutputStream3 = new FileOutputStream(file, z);
                                fileOutputStream3.write(decode);
                                fileOutputStream3.flush();
                                fileOutputStream2 = fileOutputStream3;
                            } else {
                                String[] u = n.u((String) obj, r13);
                                if (u != null && u.length == 2) {
                                    str3 = u[0];
                                    str4 = u[1];
                                    length2 = str3.getBytes().length;
                                    if (!this.f8823d.a(length2)) {
                                        c d4 = d(-1, p());
                                        c.a.s0.w.d.d(null);
                                        c.a.s0.w.d.d(null);
                                        return d4;
                                    }
                                    BufferedWriter bufferedWriter2 = new BufferedWriter(TextUtils.isEmpty(str4) ? new OutputStreamWriter(new FileOutputStream(file, z)) : new OutputStreamWriter(new FileOutputStream(file, z), str4.toLowerCase()));
                                    try {
                                        bufferedWriter2.write(str3);
                                        bufferedWriter2.flush();
                                        length = length2;
                                        fileOutputStream2 = null;
                                        bufferedWriter = bufferedWriter2;
                                    } catch (Exception unused) {
                                        r13 = 0;
                                        bufferedWriter = bufferedWriter2;
                                        d2 = d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                                        fileOutputStream = r13;
                                        c.a.s0.w.d.d(bufferedWriter);
                                        c.a.s0.w.d.d(fileOutputStream);
                                        return d2;
                                    } catch (Throwable th) {
                                        th = th;
                                        r13 = 0;
                                        bufferedWriter = bufferedWriter2;
                                        c.a.s0.w.d.d(bufferedWriter);
                                        c.a.s0.w.d.d(r13);
                                        throw th;
                                    }
                                }
                                str3 = "";
                                length2 = str3.getBytes().length;
                                if (!this.f8823d.a(length2)) {
                                }
                            }
                        } else {
                            byte[] bArr = (byte[]) obj;
                            length = bArr.length;
                            if (this.f8823d.a(length)) {
                                c d5 = d(-1, p());
                                c.a.s0.w.d.d(null);
                                c.a.s0.w.d.d(null);
                                return d5;
                            }
                            FileOutputStream fileOutputStream4 = new FileOutputStream(g2, z);
                            fileOutputStream4.write(bArr);
                            fileOutputStream4.flush();
                            fileOutputStream2 = fileOutputStream4;
                        }
                        if (z) {
                            this.f8823d.b(length);
                            fileOutputStream = fileOutputStream2;
                        } else {
                            this.f8823d.b(length - z3);
                            fileOutputStream = fileOutputStream2;
                        }
                    } catch (Exception unused2) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused3) {
                r13 = 0;
            } catch (Throwable th3) {
                th = th3;
                r13 = 0;
            }
            c.a.s0.w.d.d(bufferedWriter);
            c.a.s0.w.d.d(fileOutputStream);
            return d2;
        }
        return (c) invokeCommon.objValue;
    }

    public c C(boolean z, String str, Object obj, String str2) {
        InterceptResult invokeCommon;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, obj, str2})) == null) {
            if (z) {
                str3 = "filePath must be a string";
            } else {
                str3 = "fail permission denied, open " + str;
            }
            c x = n.x(str, str3, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            return x != null ? x : B(str, obj, str2, false);
        }
        return (c) invokeCommon.objValue;
    }

    public c a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            if (n.S(str)) {
                return d(-1, "fail permission denied, open " + str);
            }
            c x = n.x(str, z ? "path must be a string" : n.F("fail no such file or directory ", "access", str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
            if (x != null) {
                return x;
            }
            String L = n.L(str);
            if (!this.f8822c.j(L, true)) {
                return d(-4, n.F("fail no such file or directory ", "access", str, null));
            }
            String g2 = g(L);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str);
            } else if (!new File(g2).exists()) {
                return d(-1, n.F("fail no such file or directory ", "access", str, null));
            } else {
                return d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            }
        }
        return (c) invokeLZ.objValue;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, obj, str2, Boolean.valueOf(z)})) == null) {
            c x = n.x(str, n.F("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
            if (x != null) {
                return x;
            }
            String L = n.L(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return d(-1, "fail sdcard not mounted ");
            }
            c n = n(L);
            if (n != null) {
                return n;
            }
            if (obj == null) {
                return d(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
            }
            String g2 = g(L);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str);
            }
            File file = new File(g2);
            if (!file.exists()) {
                return d(-1, n.F("fail no such file or directory ", "open", str, null));
            }
            if (file.isDirectory()) {
                return d(-1, "fail illegal operation on a directory, open " + str);
            }
            return B(L, obj, str2, true);
        }
        return (c) invokeCommon.objValue;
    }

    public c c(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, str, str2, z)) == null) {
            if (n.S(str)) {
                return d(-1, "fail permission denied, open " + str);
            } else if (n.S(str2)) {
                return d(-1, "fail permission denied, open " + str2);
            } else {
                c x = n.x(str, "srcPath must be a string", " The argument must be string");
                if (x != null) {
                    return x;
                }
                c x2 = n.x(str2, "destPath must be a string", " The argument must be string");
                if (x2 != null) {
                    return x2;
                }
                String L = n.L(str);
                boolean z2 = true;
                if (!this.f8822c.j(L, true)) {
                    return d(-4, n.F("fail no such file or directory ", "copyFile", str, null));
                }
                String L2 = n.L(str2);
                if (!n.V(L2)) {
                    return d(-4, n.F("fail permission denied, open ", "copyFile", str2, null));
                }
                c n = n(L2);
                if (n != null) {
                    return n;
                }
                String g2 = g(L);
                if (TextUtils.isEmpty(g2)) {
                    return d(-1, "fail no such file or directory " + str);
                }
                File file = new File(g2);
                if (file.exists() && file.isFile()) {
                    c h2 = h(L2, false);
                    if (h2 != null) {
                        h2.f8692b = n.F("fail no such file or directory ", "copyFile", str2, null);
                        return h2;
                    } else if (L2.endsWith(File.separator)) {
                        return d(-1, n.F("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        String g3 = g(L2);
                        if (TextUtils.isEmpty(g3)) {
                            return d(-1, "fail no such file or directory " + str2);
                        }
                        File file2 = new File(g3);
                        if (file2.exists() && file2.isDirectory()) {
                            if (k(file2.listFiles())) {
                                return d(-1, n.F("fail permission denied, ", "copyFile", str, str2));
                            }
                            try {
                                file2.delete();
                            } catch (Exception unused) {
                                return d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                            }
                        }
                        long A = n.A(g2);
                        z2 = (L.equals(L2) || L.startsWith(a.USER_DATA_PATH)) ? false : false;
                        if (z2 && this.f8823d.a(A)) {
                            return d(-1, p());
                        }
                        c w = !L.equals(L2) ? w(L, L2) : d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                        if (z2 && w != null && w.a == 0) {
                            this.f8823d.b(A);
                        }
                        return w;
                    }
                }
                return d(-1, n.F("fail no such file or directory ", "copyFile", str, null));
            }
        }
        return (c) invokeLLZ.objValue;
    }

    public final c d(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, str)) == null) {
            c cVar = new c();
            cVar.a = i2;
            cVar.f8692b = str;
            return cVar;
        }
        return (c) invokeIL.objValue;
    }

    public c e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            c x = n.x(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (x != null) {
                return x;
            }
            String L = n.L(str);
            if (!this.f8822c.j(L, true)) {
                return d(-4, "fail file not exist");
            }
            String g2 = g(L);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str);
            }
            File file = new File(g2);
            if (!file.exists()) {
                return d(-1, "fail file not exist");
            }
            if (file.isDirectory()) {
                return d(-1, "fail " + str + " is directory");
            }
            c d2 = d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            d2.f8695e = file.exists() ? file.length() : 0L;
            d2.f8697g = file.exists() ? c.a.s0.w.f.b(file, false) : null;
            return d2;
        }
        return (c) invokeL.objValue;
    }

    public final c f(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                c cVar = new c();
                cVar.a = -1;
                cVar.f8692b = "fail no such file or directory " + str;
                return cVar;
            }
            String g2 = g(str);
            if (TextUtils.isEmpty(str)) {
                c cVar2 = new c();
                cVar2.a = -1;
                cVar2.f8692b = "fail no such file or directory " + str;
                return cVar2;
            }
            File file = new File(g2);
            if (!file.exists()) {
                c cVar3 = new c();
                cVar3.a = -1;
                cVar3.f8692b = "fail no such file or directory " + str;
                return cVar3;
            } else if (!z || file.isFile()) {
                return null;
            } else {
                c cVar4 = new c();
                cVar4.a = -1;
                cVar4.f8692b = "fail no such file or directory " + str;
                return cVar4;
            }
        }
        return (c) invokeLZ.objValue;
    }

    public final String g(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (!str.startsWith("bdfile://code")) {
                return str.startsWith(WebGLImageLoader.BDFILE) ? this.f8822c.i(str) : "";
            }
            if (this.f8821b.endsWith(File.separator)) {
                String str3 = this.f8821b;
                str2 = str3.substring(0, str3.length() - 1);
            } else {
                str2 = this.f8821b;
            }
            this.f8821b = str2;
            return this.f8821b + str.substring(13);
        }
        return (String) invokeL.objValue;
    }

    public final c h(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) {
            if (str.endsWith(File.separator)) {
                str = str.substring(0, str.length() - 1);
            }
            String g2 = g(str);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str);
            } else if (g2.contains(File.separator)) {
                File file = new File(g2.substring(0, g2.lastIndexOf(File.separator)));
                if (z) {
                    return null;
                }
                if (!file.exists() || (file.exists() && file.isFile())) {
                    return d(-1, "fail no such file or directory " + str);
                }
                return null;
            } else {
                return null;
            }
        }
        return (c) invokeLZ.objValue;
    }

    public c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String g2 = g(a.USER_DATA_PATH);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "path must be a string");
            }
            String f2 = this.f8822c.f();
            ArrayList arrayList = new ArrayList();
            for (String str : n.o(g2, false)) {
                if (!TextUtils.equals(str, this.f8824e)) {
                    File file = new File(str);
                    d dVar = new d();
                    dVar.createTime = file.exists() ? file.lastModified() : 0L;
                    String absolutePath = file.getAbsolutePath();
                    if (file.exists() && !TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(f2) && absolutePath.startsWith(f2)) {
                        dVar.filePath = this.f8822c.g(absolutePath);
                    }
                    dVar.size = file.exists() ? file.length() : 0L;
                    arrayList.add(dVar);
                }
            }
            c d2 = d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            d2.f8696f = arrayList;
            return d2;
        }
        return (c) invokeV.objValue;
    }

    public final c j(String str, j jVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, jVar)) == null) {
            String g2 = g(str);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str);
            }
            File file = new File(g2);
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    jVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                    jVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                    jVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                    jVar.size = Os.lstat(file.getAbsolutePath()).st_size;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                }
            } else {
                try {
                    Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField(UrlOcrConfig.IdCardKey.OS);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(null);
                    Object invoke = obj.getClass().getMethod("lstat", String.class).invoke(obj, file.getAbsolutePath());
                    Field declaredField2 = invoke.getClass().getDeclaredField("st_atime");
                    if (!declaredField2.isAccessible()) {
                        declaredField2.setAccessible(true);
                    }
                    jVar.lastAccessedTime = declaredField2.getLong(invoke);
                    Field declaredField3 = invoke.getClass().getDeclaredField("st_mtime");
                    if (!declaredField3.isAccessible()) {
                        declaredField3.setAccessible(true);
                    }
                    jVar.lastModifiedTime = declaredField3.getLong(invoke);
                    Field declaredField4 = invoke.getClass().getDeclaredField("st_mode");
                    if (!declaredField4.isAccessible()) {
                        declaredField4.setAccessible(true);
                    }
                    jVar.mode = declaredField4.getInt(invoke);
                    Field declaredField5 = invoke.getClass().getDeclaredField("st_size");
                    if (!declaredField5.isAccessible()) {
                        declaredField5.setAccessible(true);
                    }
                    jVar.size = declaredField5.getLong(invoke);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                }
            }
            c d2 = d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            d2.f8694d = jVar;
            d2.f8692b = NewBindCardEntry.BING_CARD_SUCCESS_MSG;
            return d2;
        }
        return (c) invokeLL.objValue;
    }

    public final boolean k(File[] fileArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, fileArr)) == null) ? (fileArr == null || fileArr.length == 0) ? false : true : invokeL.booleanValue;
    }

    public final boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (TextUtils.isEmpty(str) || !str.contains(".")) {
                return false;
            }
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.contains(File.separator)) {
                return l(str.substring(str.lastIndexOf(File.separator) + 1));
            }
            return l(str);
        }
        return invokeL.booleanValue;
    }

    public final c n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            c d2 = d(-1, "fail permission denied, open " + str);
            if (TextUtils.isEmpty(str) || n.S(str) || !str.startsWith(a.USER_DATA_PATH)) {
                return d2;
            }
            return null;
        }
        return (c) invokeL.objValue;
    }

    public c o(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        String str2;
        boolean mkdir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z2) {
                str2 = "dirPath must be a string";
            } else {
                str2 = "fail permission denied, open " + str;
            }
            c x = n.x(str, str2, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            if (x != null) {
                return x;
            }
            c n = n(str);
            if (n != null) {
                return n;
            }
            if (!n.V(str)) {
                return d(-4, "fail permission denied, open " + str);
            }
            String g2 = g(str);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str);
            }
            c h2 = h(str, z);
            if (h2 != null) {
                return h2;
            }
            File file = new File(g2);
            if (file.exists()) {
                return d(-1, "fail file already exists " + str);
            }
            try {
                if (z) {
                    mkdir = file.mkdirs();
                } else {
                    mkdir = file.mkdir();
                }
                if (!mkdir) {
                    return d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                }
                return d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            } catch (Exception unused) {
                return d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
            }
        }
        return (c) invokeCommon.objValue;
    }

    public final String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            String n = c.a.s0.w.d.n(this.f8823d.getMaxSize());
            return String.format("fail file size over %s", (TextUtils.isEmpty(n) || TextUtils.equals(n, FileUtils.UNKNOW)) ? "" : "");
        }
        return (String) invokeV.objValue;
    }

    public c q(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048595, this, str, str2, z)) == null) {
            c x = n.x(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
            if (x != null) {
                return x;
            }
            String L = n.L(str);
            if (!this.f8822c.j(L, true)) {
                return d(-1, "fail permission denied, open " + str);
            } else if (n.S(str)) {
                return d(-1, "fail permission denied, open " + str);
            } else {
                c f2 = f(L, true);
                if (f2 != null) {
                    f2.f8692b = n.F("fail no such file or directory ", "open", str, null);
                    return f2;
                }
                boolean isEmpty = TextUtils.isEmpty(str2);
                if (!isEmpty) {
                    str2 = str2.toLowerCase();
                    if ("binary".equals(str2)) {
                        str2 = "latin1";
                    }
                }
                if (!isEmpty && !f8820f.contains(str2)) {
                    return d(-1, "fail Error: Unknown encoding: " + str2);
                }
                String g2 = g(L);
                if (TextUtils.isEmpty(g2)) {
                    return d(-1, "fail no such file or directory " + str);
                }
                File file = new File(g2);
                byte[] bArr = new byte[0];
                c d2 = d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                try {
                    String str3 = "";
                    if (TextUtils.isEmpty(str2)) {
                        bArr = n.q(g2);
                    } else if ("base64".equals(str2)) {
                        bArr = n.q(g2);
                        if (bArr.length != 0) {
                            str3 = Base64.encodeToString(bArr, 2);
                        }
                    } else if ("hex".equals(str2)) {
                        str3 = n.n(g2);
                    } else {
                        str3 = r(new FileInputStream(file), str2);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        d2.f8698h = bArr;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str3);
                        d2.f8693c = arrayList;
                    }
                    return d2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                }
            }
        }
        return (c) invokeLLZ.objValue;
    }

    public final String r(FileInputStream fileInputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048596, this, fileInputStream, str)) != null) {
            return (String) invokeLL.objValue;
        }
        if (fileInputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(TextUtils.isEmpty(str) ? new InputStreamReader(fileInputStream) : new InputStreamReader(fileInputStream, str));
            char[] cArr = new char[1024];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    sb.append(cArr, 0, read);
                } else {
                    return sb.toString();
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        } finally {
            c.a.s0.w.d.d(fileInputStream);
        }
    }

    public c s(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048597, this, str, z)) == null) {
            c x = n.x(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            if (x != null) {
                return x;
            }
            String L = n.L(str);
            if (!n.W(L)) {
                return d(-4, "fail permission denied, open " + str);
            }
            String g2 = g(L);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str);
            }
            File file = new File(g2);
            if (!file.exists()) {
                return d(-1, "fail no such file or directory " + str);
            } else if (!file.isDirectory()) {
                return d(-1, "fail no such file or directory " + str);
            } else {
                File[] listFiles = file.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2 != null && file2.exists() && !TextUtils.equals(file2.getAbsolutePath(), this.f8824e)) {
                            arrayList.add(c.a.s0.w.d.s(file2.getAbsolutePath()));
                        }
                    }
                }
                c d2 = d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                d2.f8693c = arrayList;
                return d2;
            }
        }
        return (c) invokeLZ.objValue;
    }

    public c t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            c x = n.x(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Object;");
            if (x != null) {
                return x;
            }
            if (n(str) != null) {
                return d(-4, "fail file not exist");
            }
            String g2 = g(str);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str);
            }
            File file = new File(g2);
            if (file.exists() && !file.isDirectory()) {
                long A = n.A(g2);
                try {
                    if (!file.delete()) {
                        return d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    }
                    this.f8823d.b(-A);
                    return d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                } catch (Exception unused) {
                    return d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                }
            }
            return d(-1, "fail file not exist");
        }
        return (c) invokeL.objValue;
    }

    public c u(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048599, this, str, str2, z)) == null) {
            if (n.S(str)) {
                return d(-1, "fail permission denied, open " + str);
            } else if (n.S(str2)) {
                return d(-1, "fail permission denied, open " + str2);
            } else {
                c x = n.x(str, z ? "oldPath must be a string" : n.F("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
                if (x != null) {
                    return x;
                }
                c x2 = n.x(str2, z ? "newPath must be a string" : n.F("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
                if (x2 != null) {
                    return x2;
                }
                String L = n.L(str);
                c n = n(L);
                if (n != null) {
                    n.f8692b = n.F("fail permission denied, ", "rename", str, str2);
                    return n;
                }
                String L2 = n.L(str2);
                c n2 = n(L2);
                if (n2 != null) {
                    n2.f8692b = n.F("fail permission denied, ", "rename", str, str2);
                    return n2;
                }
                c f2 = f(L, false);
                if (f2 != null) {
                    f2.f8692b = n.F("fail no such file or directory ", "rename", str, str2);
                    return f2;
                } else if (n.V(L) && n.V(L2)) {
                    c h2 = h(L2, false);
                    if (h2 != null) {
                        h2.f8692b = n.F("fail no such file or directory ", "rename", str, str2);
                        return h2;
                    }
                    String g2 = g(L);
                    if (TextUtils.isEmpty(g2)) {
                        return d(-1, "fail no such file or directory " + str);
                    }
                    String g3 = g(L2);
                    if (TextUtils.isEmpty(g3)) {
                        return d(-1, "fail no such file or directory " + str2);
                    }
                    File file = new File(g2);
                    File file2 = new File(g3);
                    boolean exists = file2.exists();
                    if (n.U(file, file2) && (!file.isDirectory() || exists || !m(g3))) {
                        try {
                            if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                                return d(-1, "fail rename failed");
                            }
                            return d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                        } catch (Exception unused) {
                            return d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                        }
                    }
                    return d(-1, "fail rename failed");
                } else {
                    return d(-4, n.F("fail permission denied, ", "rename", str, str2));
                }
            }
        }
        return (c) invokeLLZ.objValue;
    }

    public c v(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        String str2;
        boolean f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z2) {
                str2 = "dirPath must be a string";
            } else {
                str2 = "fail permission denied, open " + str;
            }
            c x = n.x(str, str2, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            if (x != null) {
                return x;
            }
            c n = n(str);
            if (n != null) {
                return n;
            }
            if (!n.W(str)) {
                return d(-4, "fail permission denied, open " + str);
            }
            String g2 = g(str);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str);
            }
            File file = new File(g2);
            if (file.exists() && !file.isFile()) {
                boolean k = k(file.listFiles());
                try {
                    if (z || !k) {
                        if (!z) {
                            long z3 = n.z(file);
                            f2 = file.delete();
                            if (f2) {
                                this.f8823d.b(-z3);
                            }
                        } else {
                            n.b bVar = new n.b();
                            f2 = n.f(file, bVar);
                            this.f8823d.b(-bVar.a);
                        }
                        if (!f2) {
                            return d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                        }
                        return d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                    }
                    return d(-1, "fail directory not empty ");
                } catch (Exception unused) {
                    return d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                }
            }
            return d(-1, "fail no such file or directory " + str);
        }
        return (c) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c w(String str, String str2) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048601, this, str, str2)) != null) {
            return (c) invokeLL.objValue;
        }
        if (n.S(str)) {
            return d(-1, "fail permission denied, open " + str);
        }
        String g2 = g(str);
        String g3 = g(str2);
        FileInputStream fileInputStream = null;
        if (TextUtils.isEmpty(g2)) {
            return d(-1, n.F("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(g3)) {
            return d(-1, n.F("fail no such file or directory ", null, str2, null));
        }
        c d2 = d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
        try {
            File file = new File(g3);
            FileInputStream fileInputStream2 = new FileInputStream(new File(g2));
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    c.a.s0.w.d.d(fileInputStream2);
                    c.a.s0.w.d.d(fileOutputStream);
                    if (!TextUtils.isEmpty(str2)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str2);
                        d2.f8693c = arrayList;
                    } else {
                        d2.f8692b = com.baidu.pass.biometrics.face.liveness.b.a.g0;
                        d2.a = -1;
                    }
                    return d2;
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        c d3 = d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                        c.a.s0.w.d.d(fileInputStream);
                        c.a.s0.w.d.d(fileOutputStream);
                        if (!TextUtils.isEmpty("")) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(str2);
                            d2.f8693c = arrayList2;
                        } else {
                            d2.f8692b = com.baidu.pass.biometrics.face.liveness.b.a.g0;
                            d2.a = -1;
                        }
                        return d3;
                    } catch (Throwable th) {
                        th = th;
                        c.a.s0.w.d.d(fileInputStream);
                        c.a.s0.w.d.d(fileOutputStream);
                        if (TextUtils.isEmpty("")) {
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(str2);
                            d2.f8693c = arrayList3;
                        } else {
                            d2.f8692b = com.baidu.pass.biometrics.face.liveness.b.a.g0;
                            d2.a = -1;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    c.a.s0.w.d.d(fileInputStream);
                    c.a.s0.w.d.d(fileOutputStream);
                    if (TextUtils.isEmpty("")) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public c x(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048602, this, str, str2, z)) == null) {
            c x = n.x(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
            if (x != null) {
                return x;
            }
            String L = n.L(str2);
            if (TextUtils.isEmpty(L)) {
                L = a.USER_DATA_PATH + File.separator + c.a.s0.w.d.s(str);
            }
            if (!L.startsWith(a.USER_DATA_PATH)) {
                return d(-1, n.F("fail permission denied, open ", null, str2, null));
            }
            if (!this.f8822c.l(str)) {
                return d(-4, "fail it is not a tempFilePath");
            }
            c h2 = h(L, false);
            if (h2 != null) {
                return h2;
            }
            c h3 = h(str, false);
            if (h3 != null) {
                return h3;
            }
            String g2 = g(L);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str2);
            }
            File file = new File(g2);
            if (!a.USER_DATA_PATH.equals(L) && (!file.exists() || !file.isDirectory())) {
                c f2 = f(str, true);
                if (f2 != null) {
                    f2.f8692b = "fail no such file or directory ";
                    return f2;
                }
                String g3 = g(str);
                if (TextUtils.isEmpty(g3)) {
                    return d(-1, "fail no such file or directory " + str);
                }
                long A = n.A(g3);
                if (this.f8823d.a(A)) {
                    return d(-1, p());
                }
                if (L.startsWith(a.USER_DATA_PATH) && !n.R(L) && !n.R(str)) {
                    c h4 = h(L, false);
                    if (h4 != null) {
                        return h4;
                    }
                    c n = n(L);
                    if (n != null) {
                        return n;
                    }
                    c w = w(str, L);
                    if (w != null && w.a == 0) {
                        this.f8823d.b(A);
                        if (TextUtils.isEmpty(str)) {
                            return d(-1, n.F("fail no such file or directory ", null, str, null));
                        }
                        File file2 = new File(g3);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(L);
                        w.f8693c = arrayList;
                        w.f8692b = NewBindCardEntry.BING_CARD_SUCCESS_MSG;
                    }
                    return w;
                }
                return d(-1, n.F("fail permission denied, open ", null, str2, null));
            }
            return d(-1, n.F("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
        }
        return (c) invokeLLZ.objValue;
    }

    public c y(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048603, this, str, z)) == null) {
            c x = n.x(str, z ? "path must be a string" : n.F("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
            if (x != null) {
                return x;
            }
            if (!this.f8822c.l(str) && !this.f8822c.b(str)) {
                return d(-1, "fail permission denied, open " + str);
            }
            c f2 = f(str, false);
            if (f2 != null) {
                return f2;
            }
            j jVar = new j();
            String g2 = g(str);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, n.F("fail no such file or directory ", null, str, null));
            }
            File file = new File(g2);
            jVar.a(file.isDirectory());
            jVar.b(file.isFile());
            return j(str, jVar);
        }
        return (c) invokeLZ.objValue;
    }

    public c z(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048604, this, str, z)) == null) {
            c x = n.x(str, z ? "filePath must be a string" : n.F("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
            if (x != null) {
                return x;
            }
            if (!n.W(str)) {
                return d(-4, n.F("fail permission denied, open ", null, str, null));
            }
            c f2 = f(str, false);
            if (f2 != null) {
                return f2;
            }
            c n = n(str);
            if (n != null) {
                return n;
            }
            String g2 = g(str);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, n.F("fail no such file or directory ", null, str, null));
            }
            File file = new File(g2);
            if (file.isDirectory()) {
                return d(-1, n.F("fail operation not permitted ", "unlink", str, null));
            }
            long A = n.A(g2);
            try {
                if (file.delete()) {
                    this.f8823d.b(-A);
                    return d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                }
                return d(-1, n.F(com.baidu.pass.biometrics.face.liveness.b.a.g0, null, str, null));
            } catch (Exception unused) {
                return d(-1, n.F(com.baidu.pass.biometrics.face.liveness.b.a.g0, null, str, null));
            }
        }
        return (c) invokeLZ.objValue;
    }
}
