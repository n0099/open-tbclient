package c.a.p0.a.r0;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
public class f extends c.a.p0.a.k2.f.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static List<String> f8303e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f8304a;

    /* renamed from: b  reason: collision with root package name */
    public String f8305b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.p0.a.k2.f.d f8306c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.p0.a.k2.f.e f8307d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(828242351, "Lc/a/p0/a/r0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(828242351, "Lc/a/p0/a/r0/f;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        f8303e = arrayList;
        arrayList.add("ascii");
        f8303e.add("base64");
        f8303e.add("binary");
        f8303e.add("hex");
        f8303e.add("utf-8");
        f8303e.add("utf8");
        f8303e.add("latin1");
        f8303e.add("ucs2");
        f8303e.add("ucs-2");
        f8303e.add("utf16le");
        f8303e.add("utf-16le");
    }

    public f(Context context, String str, @NonNull c.a.p0.a.k2.f.d dVar) {
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
        this.f8304a = context;
        this.f8305b = str;
        this.f8306c = dVar;
        this.f8307d = dVar.d();
    }

    public c A(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            c v = n.v(str, n.D("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
            if (v != null) {
                return v;
            }
            c v2 = n.v(str2, n.D("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (v2 != null) {
                return v2;
            }
            if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                return d(-1, "fail permission denied, open " + str2);
            }
            String I = n.I(str);
            if (!this.f8306c.j(I, true)) {
                return d(-4, n.D("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            if (!n.R(str2)) {
                return d(-4, n.D("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            if (m(str2)) {
                return d(-1, n.D("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            String g2 = g(I);
            String g3 = g(str2);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, n.D("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            if (TextUtils.isEmpty(g3)) {
                return d(-1, n.D("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            File file = new File(g2);
            if (!file.exists()) {
                return d(-1, n.D("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            if (!g2.endsWith(".zip")) {
                return d(-1, "fail unzip failed");
            }
            if (!file.isFile()) {
                return d(-1, n.D("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            File file2 = new File(g3);
            if (!file2.exists()) {
                file2.mkdirs();
            } else if (file2.isFile()) {
                return d(-1, "fail unzip failed");
            }
            List<String> m = n.m(g3, true);
            if (!c.a.p0.t.d.T(g2, g3)) {
                return d(-1, "fail unzip failed");
            }
            if (str2.startsWith(a.USER_DATA_PATH)) {
                List<String> m2 = n.m(g3, true);
                ArrayList arrayList = new ArrayList(m2.size());
                long j2 = 0;
                for (String str3 : m2) {
                    if (!m.contains(str3)) {
                        arrayList.add(str3);
                        j2 += n.x(str3);
                    }
                }
                if (this.f8307d.a(j2)) {
                    n.g(arrayList);
                    return d(-1, p());
                }
                this.f8307d.b(j2);
            }
            return d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
        }
        return (c) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:92:0x01bd */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:99:0x01b0 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0164 A[Catch: all -> 0x01ac, Exception -> 0x01af, TryCatch #6 {Exception -> 0x01af, all -> 0x01ac, blocks: (B:56:0x0124, B:58:0x012e, B:60:0x0136, B:63:0x0148, B:65:0x0150, B:68:0x0154, B:70:0x015c, B:72:0x0164, B:74:0x017d, B:73:0x016f, B:80:0x0190), top: B:100:0x0122 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x016f A[Catch: all -> 0x01ac, Exception -> 0x01af, TryCatch #6 {Exception -> 0x01af, all -> 0x01ac, blocks: (B:56:0x0124, B:58:0x012e, B:60:0x0136, B:63:0x0148, B:65:0x0150, B:68:0x0154, B:70:0x015c, B:72:0x0164, B:74:0x017d, B:73:0x016f, B:80:0x0190), top: B:100:0x0122 }] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c B(String str, Object obj, String str2, boolean z) {
        InterceptResult invokeCommon;
        int length;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        String str3;
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, obj, str2, Boolean.valueOf(z)})) != null) {
            return (c) invokeCommon.objValue;
        }
        c n = n(str);
        if (n != null) {
            return n;
        }
        if (obj == null) {
            return d(-1, "The argument must be string or arrayBuffer");
        }
        int length2 = (a.USER_DATA_PATH + File.separator).length();
        if (!n.R(str)) {
            return d(-4, "fail permission denied, open " + str.substring(length2));
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
        ?? r14 = str5;
        if (!isEmpty2) {
            boolean equals = "binary".equals(str5.toLowerCase());
            String str6 = str5;
            if (equals) {
                str6 = "latin1";
            }
            boolean contains = f8303e.contains(str6.toLowerCase());
            r14 = str6;
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
            return d(-1, "fail no such file or directory " + str.substring(length2));
        }
        long j2 = 0;
        if (!z2) {
            String str7 = (String) obj;
            if (!TextUtils.isEmpty(str7)) {
                length = str7.getBytes().length;
                j2 = length;
                if (!this.f8306c.d().a(j2)) {
                    return d(-1, p());
                }
                File file = new File(g2);
                if (file.exists() && file.isDirectory()) {
                    return d(-1, " fail illegal operation on a directory, open " + str);
                }
                long length3 = file.length();
                c d2 = d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                BufferedWriter bufferedWriter2 = null;
                try {
                    try {
                        try {
                            if (!z2) {
                                if (!TextUtils.isEmpty((String) obj) && TextUtils.equals("base64", r14)) {
                                    byte[] decode = Base64.decode((String) obj, 2);
                                    FileOutputStream fileOutputStream3 = new FileOutputStream(file, z);
                                    fileOutputStream3.write(decode);
                                    fileOutputStream3.flush();
                                    fileOutputStream2 = fileOutputStream3;
                                } else {
                                    String[] s = n.s((String) obj, r14);
                                    try {
                                        if (s != null && s.length == 2) {
                                            str3 = s[0];
                                            str4 = s[1];
                                            bufferedWriter = new BufferedWriter(!TextUtils.isEmpty(str4) ? new OutputStreamWriter(new FileOutputStream(file, z)) : new OutputStreamWriter(new FileOutputStream(file, z), str4.toLowerCase()));
                                            bufferedWriter.write(str3);
                                            bufferedWriter.flush();
                                            fileOutputStream2 = null;
                                            bufferedWriter2 = bufferedWriter;
                                        }
                                        bufferedWriter.write(str3);
                                        bufferedWriter.flush();
                                        fileOutputStream2 = null;
                                        bufferedWriter2 = bufferedWriter;
                                    } catch (Exception unused) {
                                        r14 = 0;
                                        bufferedWriter2 = bufferedWriter;
                                        d2 = d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                                        fileOutputStream = r14;
                                        c.a.p0.t.d.d(bufferedWriter2);
                                        c.a.p0.t.d.d(fileOutputStream);
                                        return d2;
                                    } catch (Throwable th) {
                                        th = th;
                                        r14 = 0;
                                        bufferedWriter2 = bufferedWriter;
                                        c.a.p0.t.d.d(bufferedWriter2);
                                        c.a.p0.t.d.d(r14);
                                        throw th;
                                    }
                                    str3 = "";
                                    bufferedWriter = new BufferedWriter(!TextUtils.isEmpty(str4) ? new OutputStreamWriter(new FileOutputStream(file, z)) : new OutputStreamWriter(new FileOutputStream(file, z), str4.toLowerCase()));
                                }
                            } else {
                                byte[] bArr = (byte[]) obj;
                                FileOutputStream fileOutputStream4 = new FileOutputStream(g2, z);
                                fileOutputStream4.write(bArr);
                                fileOutputStream4.flush();
                                fileOutputStream2 = fileOutputStream4;
                            }
                            if (z) {
                                this.f8307d.b(j2);
                                fileOutputStream = fileOutputStream2;
                            } else {
                                this.f8307d.b(j2 - length3);
                                fileOutputStream = fileOutputStream2;
                            }
                        } catch (Exception unused2) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception unused3) {
                    r14 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    r14 = 0;
                }
                c.a.p0.t.d.d(bufferedWriter2);
                c.a.p0.t.d.d(fileOutputStream);
                return d2;
            }
        }
        if (z2) {
            length = ((byte[]) obj).length;
            j2 = length;
        }
        if (!this.f8306c.d().a(j2)) {
        }
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
            c v = n.v(str, str3, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            return v != null ? v : B(str, obj, str2, false);
        }
        return (c) invokeCommon.objValue;
    }

    public c a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            c v = n.v(str, z ? "path must be a string" : n.C("fail no such file or directory ", "access", str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
            if (v != null) {
                return v;
            }
            String I = n.I(str);
            if (!this.f8306c.j(I, true)) {
                return d(-4, n.C("fail no such file or directory ", "access", str, null));
            }
            String g2 = g(I);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str);
            } else if (!new File(g2).exists()) {
                return d(-1, n.C("fail no such file or directory ", "access", str, null));
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
            c v = n.v(str, n.C("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
            if (v != null) {
                return v;
            }
            String I = n.I(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return d(-1, "fail sdcard not mounted ");
            }
            c n = n(I);
            if (n != null) {
                return n;
            }
            if (obj == null) {
                return d(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
            }
            String g2 = g(I);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str);
            }
            File file = new File(g2);
            if (!file.exists()) {
                return d(-1, n.C("fail no such file or directory ", "open", str, null));
            }
            if (file.isDirectory()) {
                return d(-1, "fail illegal operation on a directory, open " + str);
            }
            return B(I, obj, str2, true);
        }
        return (c) invokeCommon.objValue;
    }

    public c c(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, str, str2, z)) == null) {
            c v = n.v(str, "srcPath must be a string", " The argument must be string");
            if (v != null) {
                return v;
            }
            c v2 = n.v(str2, "destPath must be a string", " The argument must be string");
            if (v2 != null) {
                return v2;
            }
            String I = n.I(str);
            boolean z2 = true;
            if (!this.f8306c.j(I, true)) {
                return d(-4, n.C("fail no such file or directory ", "copyFile", str, null));
            }
            String I2 = n.I(str2);
            if (!n.R(I2)) {
                return d(-4, n.C("fail permission denied, open ", "copyFile", str2, null));
            }
            c n = n(I2);
            if (n != null) {
                return n;
            }
            String g2 = g(I);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str);
            }
            File file = new File(g2);
            if (file.exists() && file.isFile()) {
                c h2 = h(I2, false);
                if (h2 != null) {
                    h2.f8174b = n.C("fail no such file or directory ", "copyFile", str2, null);
                    return h2;
                } else if (I2.endsWith(File.separator)) {
                    return d(-1, n.C("fail permission denied, ", "copyFile", str, str2));
                } else {
                    String g3 = g(I2);
                    if (TextUtils.isEmpty(g3)) {
                        return d(-1, "fail no such file or directory " + str2);
                    }
                    File file2 = new File(g3);
                    if (file2.exists() && file2.isDirectory()) {
                        if (k(file2.listFiles())) {
                            return d(-1, n.C("fail permission denied, ", "copyFile", str, str2));
                        }
                        try {
                            file2.delete();
                        } catch (Exception unused) {
                            return d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                        }
                    }
                    long x = n.x(g2);
                    z2 = (I.equals(I2) || I.startsWith(a.USER_DATA_PATH)) ? false : false;
                    if (z2 && this.f8307d.a(x)) {
                        return d(-1, p());
                    }
                    c w = !I.equals(I2) ? w(I, I2) : d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                    if (z2 && w != null && w.f8173a == 0) {
                        this.f8307d.b(x);
                    }
                    return w;
                }
            }
            return d(-1, n.C("fail no such file or directory ", "copyFile", str, null));
        }
        return (c) invokeLLZ.objValue;
    }

    public final c d(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, str)) == null) {
            c cVar = new c();
            cVar.f8173a = i2;
            cVar.f8174b = str;
            return cVar;
        }
        return (c) invokeIL.objValue;
    }

    public c e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            c v = n.v(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (v != null) {
                return v;
            }
            String I = n.I(str);
            if (!this.f8306c.j(I, true)) {
                return d(-4, "fail file not exist");
            }
            String g2 = g(I);
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
            d2.f8177e = file.exists() ? file.length() : 0L;
            d2.f8179g = file.exists() ? c.a.p0.t.f.b(file, false) : null;
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
                cVar.f8173a = -1;
                cVar.f8174b = "fail no such file or directory " + str;
                return cVar;
            }
            String g2 = g(str);
            if (TextUtils.isEmpty(str)) {
                c cVar2 = new c();
                cVar2.f8173a = -1;
                cVar2.f8174b = "fail no such file or directory " + str;
                return cVar2;
            }
            File file = new File(g2);
            if (!file.exists()) {
                c cVar3 = new c();
                cVar3.f8173a = -1;
                cVar3.f8174b = "fail no such file or directory " + str;
                return cVar3;
            } else if (!z || file.isFile()) {
                return null;
            } else {
                c cVar4 = new c();
                cVar4.f8173a = -1;
                cVar4.f8174b = "fail no such file or directory " + str;
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
                return str.startsWith(WebGLImageLoader.BDFILE) ? this.f8306c.i(str) : "";
            }
            if (this.f8305b.endsWith(File.separator)) {
                String str3 = this.f8305b;
                str2 = str3.substring(0, str3.length() - 1);
            } else {
                str2 = this.f8305b;
            }
            this.f8305b = str2;
            return this.f8305b + str.substring(13);
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
            String f2 = this.f8306c.f();
            String g2 = g(a.USER_DATA_PATH);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "path must be a string");
            }
            ArrayList arrayList = new ArrayList();
            for (String str : n.m(g2, false)) {
                File file = new File(str);
                d dVar = new d();
                long j2 = 0;
                dVar.createTime = file.exists() ? file.lastModified() : 0L;
                String absolutePath = file.getAbsolutePath();
                if (file.exists() && !TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(f2) && absolutePath.startsWith(f2)) {
                    dVar.filePath = this.f8306c.g(absolutePath);
                }
                if (file.exists()) {
                    j2 = file.length();
                }
                dVar.size = j2;
                arrayList.add(dVar);
            }
            c d2 = d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            d2.f8178f = arrayList;
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
                    Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
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
            d2.f8176d = jVar;
            d2.f8174b = NewBindCardEntry.BING_CARD_SUCCESS_MSG;
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
            if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
                return null;
            }
            return d2;
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
            c v = n.v(str, str2, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            if (v != null) {
                return v;
            }
            c n = n(str);
            if (n != null) {
                return n;
            }
            if (!n.R(str)) {
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
            String l = c.a.p0.t.d.l(this.f8307d.getMaxSize());
            return String.format("fail file size over %s", (TextUtils.isEmpty(l) || TextUtils.equals(l, FileUtils.UNKNOW)) ? "" : "");
        }
        return (String) invokeV.objValue;
    }

    public c q(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048595, this, str, str2, z)) == null) {
            c v = n.v(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
            if (v != null) {
                return v;
            }
            String I = n.I(str);
            if (!this.f8306c.j(I, true)) {
                return d(-1, "fail permission denied, open " + str);
            }
            c f2 = f(I, true);
            if (f2 != null) {
                f2.f8174b = n.C("fail no such file or directory ", "open", str, null);
                return f2;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (!isEmpty) {
                str2 = str2.toLowerCase();
                if ("binary".equals(str2)) {
                    str2 = "latin1";
                }
            }
            if (!isEmpty && !f8303e.contains(str2)) {
                return d(-1, "fail Error: Unknown encoding: " + str2);
            }
            String g2 = g(I);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str);
            }
            File file = new File(g2);
            byte[] bArr = new byte[0];
            c d2 = d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            try {
                String str3 = "";
                if (TextUtils.isEmpty(str2)) {
                    bArr = n.o(g2);
                } else if ("base64".equals(str2)) {
                    bArr = n.o(g2);
                    if (bArr.length != 0) {
                        str3 = Base64.encodeToString(bArr, 2);
                    }
                } else if ("hex".equals(str2)) {
                    str3 = n.l(g2);
                } else {
                    str3 = r(new FileInputStream(file), str2);
                }
                if (TextUtils.isEmpty(str2)) {
                    d2.f8180h = bArr;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str3);
                    d2.f8175c = arrayList;
                }
                return d2;
            } catch (Exception e2) {
                e2.printStackTrace();
                return d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
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
            c.a.p0.t.d.d(fileInputStream);
        }
    }

    public c s(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048597, this, str, z)) == null) {
            c v = n.v(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            if (v != null) {
                return v;
            }
            String I = n.I(str);
            if (!n.S(I)) {
                return d(-4, "fail permission denied, open " + str);
            }
            String g2 = g(I);
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
                        if (file2 != null && file2.exists()) {
                            arrayList.add(c.a.p0.t.d.q(file2.getAbsolutePath()));
                        }
                    }
                }
                c d2 = d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                d2.f8175c = arrayList;
                return d2;
            }
        }
        return (c) invokeLZ.objValue;
    }

    public c t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            c v = n.v(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Object;");
            if (v != null) {
                return v;
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
                long x = n.x(g2);
                try {
                    if (!file.delete()) {
                        return d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    }
                    this.f8307d.b(-x);
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
            c v = n.v(str, z ? "oldPath must be a string" : n.C("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (v != null) {
                return v;
            }
            c v2 = n.v(str2, z ? "newPath must be a string" : n.C("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
            if (v2 != null) {
                return v2;
            }
            String I = n.I(str);
            c n = n(I);
            if (n != null) {
                n.f8174b = n.C("fail permission denied, ", "rename", str, str2);
                return n;
            }
            String I2 = n.I(str2);
            c n2 = n(I2);
            if (n2 != null) {
                n2.f8174b = n.C("fail permission denied, ", "rename", str, str2);
                return n2;
            }
            c f2 = f(I, false);
            if (f2 != null) {
                f2.f8174b = n.C("fail no such file or directory ", "rename", str, str2);
                return f2;
            } else if (n.R(I) && n.R(I2)) {
                c h2 = h(I2, false);
                if (h2 != null) {
                    h2.f8174b = n.C("fail no such file or directory ", "rename", str, str2);
                    return h2;
                }
                String g2 = g(I);
                if (TextUtils.isEmpty(g2)) {
                    return d(-1, "fail no such file or directory " + str);
                }
                String g3 = g(I2);
                if (TextUtils.isEmpty(g3)) {
                    return d(-1, "fail no such file or directory " + str2);
                }
                File file = new File(g2);
                File file2 = new File(g3);
                boolean exists = file2.exists();
                if (n.Q(file, file2) && (!file.isDirectory() || exists || !m(g3))) {
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
                return d(-4, n.C("fail permission denied, ", "rename", str, str2));
            }
        }
        return (c) invokeLLZ.objValue;
    }

    public c v(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        String str2;
        boolean i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z2) {
                str2 = "dirPath must be a string";
            } else {
                str2 = "fail permission denied, open " + str;
            }
            c v = n.v(str, str2, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            if (v != null) {
                return v;
            }
            c n = n(str);
            if (n != null) {
                return n;
            }
            if (!n.S(str)) {
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
                            i2 = file.delete();
                        } else {
                            i2 = c.a.p0.t.d.i(file);
                        }
                        if (!i2) {
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

    /* JADX WARN: Removed duplicated region for block: B:49:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c w(String str, String str2) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, str, str2)) == null) {
            String g2 = g(str);
            String g3 = g(str2);
            FileInputStream fileInputStream2 = null;
            if (TextUtils.isEmpty(g2)) {
                return d(-1, n.C("fail no such file or directory ", null, str, null));
            }
            if (TextUtils.isEmpty(g3)) {
                return d(-1, n.C("fail no such file or directory ", null, str2, null));
            }
            c d2 = d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            try {
                File file = new File(g3);
                fileInputStream = new FileInputStream(new File(g2));
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                }
                c.a.p0.t.d.d(fileInputStream);
                c.a.p0.t.d.d(fileOutputStream);
                if (!TextUtils.isEmpty(str2)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str2);
                    d2.f8175c = arrayList;
                } else {
                    d2.f8174b = com.baidu.pass.biometrics.face.liveness.b.a.g0;
                    d2.f8173a = -1;
                }
                return d2;
            } catch (IOException e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                try {
                    e.printStackTrace();
                    c d3 = d(-1, com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    c.a.p0.t.d.d(fileInputStream2);
                    c.a.p0.t.d.d(fileOutputStream);
                    if (!TextUtils.isEmpty("")) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(str2);
                        d2.f8175c = arrayList2;
                    } else {
                        d2.f8174b = com.baidu.pass.biometrics.face.liveness.b.a.g0;
                        d2.f8173a = -1;
                    }
                    return d3;
                } catch (Throwable th3) {
                    th = th3;
                    c.a.p0.t.d.d(fileInputStream2);
                    c.a.p0.t.d.d(fileOutputStream);
                    if (TextUtils.isEmpty("")) {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(str2);
                        d2.f8175c = arrayList3;
                    } else {
                        d2.f8174b = com.baidu.pass.biometrics.face.liveness.b.a.g0;
                        d2.f8173a = -1;
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream2 = fileInputStream;
                c.a.p0.t.d.d(fileInputStream2);
                c.a.p0.t.d.d(fileOutputStream);
                if (TextUtils.isEmpty("")) {
                }
                throw th;
            }
        }
        return (c) invokeLL.objValue;
    }

    public c x(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048602, this, str, str2, z)) == null) {
            c v = n.v(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
            if (v != null) {
                return v;
            }
            String I = n.I(str2);
            if (TextUtils.isEmpty(I)) {
                I = a.USER_DATA_PATH + File.separator + c.a.p0.t.d.q(str);
            }
            if (!I.startsWith(a.USER_DATA_PATH)) {
                return d(-1, n.C("fail permission denied, open ", null, str2, null));
            }
            if (!this.f8306c.l(str)) {
                return d(-4, "fail it is not a tempFilePath");
            }
            c h2 = h(I, false);
            if (h2 != null) {
                return h2;
            }
            c h3 = h(str, false);
            if (h3 != null) {
                return h3;
            }
            String g2 = g(I);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str2);
            }
            File file = new File(g2);
            if (!a.USER_DATA_PATH.equals(I) && (!file.exists() || !file.isDirectory())) {
                c f2 = f(str, true);
                if (f2 != null) {
                    f2.f8174b = "fail no such file or directory ";
                    return f2;
                }
                String g3 = g(str);
                if (TextUtils.isEmpty(g3)) {
                    return d(-1, "fail no such file or directory " + str);
                }
                long x = n.x(g3);
                if (this.f8307d.a(x)) {
                    return d(-1, p());
                }
                if (I.startsWith(a.USER_DATA_PATH) && !n.O(I) && !n.O(str)) {
                    c h4 = h(I, false);
                    if (h4 != null) {
                        return h4;
                    }
                    c n = n(I);
                    if (n != null) {
                        return n;
                    }
                    c w = w(str, I);
                    if (w != null && w.f8173a == 0) {
                        this.f8307d.b(x);
                        if (TextUtils.isEmpty(str)) {
                            return d(-1, n.C("fail no such file or directory ", null, str, null));
                        }
                        File file2 = new File(g3);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(I);
                        w.f8175c = arrayList;
                        w.f8174b = NewBindCardEntry.BING_CARD_SUCCESS_MSG;
                    }
                    return w;
                }
                return d(-1, n.C("fail permission denied, open ", null, str2, null));
            }
            return d(-1, n.C("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
        }
        return (c) invokeLLZ.objValue;
    }

    public c y(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048603, this, str, z)) == null) {
            c v = n.v(str, z ? "path must be a string" : n.C("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
            if (v != null) {
                return v;
            }
            if (!this.f8306c.l(str) && !this.f8306c.b(str)) {
                return d(-1, "fail permission denied, open " + str);
            }
            c f2 = f(str, false);
            if (f2 != null) {
                return f2;
            }
            j jVar = new j();
            String g2 = g(str);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, n.C("fail no such file or directory ", null, str, null));
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
            c v = n.v(str, z ? "filePath must be a string" : n.C("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
            if (v != null) {
                return v;
            }
            if (!n.S(str)) {
                return d(-4, n.C("fail permission denied, open ", null, str, null));
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
                return d(-1, n.C("fail no such file or directory ", null, str, null));
            }
            File file = new File(g2);
            if (file.isDirectory()) {
                return d(-1, n.C("fail operation not permitted ", "unlink", str, null));
            }
            long x = n.x(g2);
            try {
                if (file.delete()) {
                    this.f8307d.b(-x);
                    return d(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                }
                return d(-1, n.C(com.baidu.pass.biometrics.face.liveness.b.a.g0, null, str, null));
            } catch (Exception unused) {
                return d(-1, n.C(com.baidu.pass.biometrics.face.liveness.b.a.g0, null, str, null));
            }
        }
        return (c) invokeLZ.objValue;
    }
}
