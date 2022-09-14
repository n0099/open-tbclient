package com.baidu.sofire.k;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;
/* loaded from: classes2.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public transient /* synthetic */ FieldHolder $fh;

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:5|(2:7|(2:9|(6:11|(1:80)|(5:68|69|70|(1:78)(1:74)|(1:76))|18|(5:23|24|25|26|(3:29|(1:64)(1:33)|(1:35)(7:36|(2:38|(1:40))(1:63)|41|42|43|44|45))(1:28))|67)(14:81|82|(1:13)|80|(1:16)|68|69|70|(1:72)|78|(0)|18|(5:23|24|25|26|(0)(0))|67))(1:83))(1:85)|84|82|(0)|80|(0)|68|69|70|(0)|78|(0)|18|(0)|67) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0092, code lost:
        r2 = com.baidu.sofire.a.b.a;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:26:0x007b, B:28:0x007f, B:33:0x008a), top: B:83:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a A[Catch: all -> 0x0092, TRY_LEAVE, TryCatch #0 {all -> 0x0092, blocks: (B:26:0x007b, B:28:0x007f, B:33:0x008a), top: B:83:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b0 A[Catch: all -> 0x00f7, TryCatch #3 {all -> 0x00f7, blocks: (B:42:0x00a9, B:45:0x00b0, B:47:0x00b4, B:53:0x00bf, B:55:0x00d7, B:57:0x00dd, B:59:0x00e7, B:58:0x00e4), top: B:89:0x00a9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (TextUtils.isEmpty(a)) {
                k kVar = new k();
                String b = kVar.b(context);
                boolean z4 = true;
                if (TextUtils.isEmpty(b)) {
                    b = kVar.d(context);
                    if (TextUtils.isEmpty(b)) {
                        b = kVar.c(context);
                        if (TextUtils.isEmpty(b)) {
                            b = "1|" + j.a(UUID.randomUUID().toString());
                            z = true;
                            z2 = true;
                            z3 = true;
                            if (!z || TextUtils.isEmpty(kVar.b(context))) {
                                com.baidu.sofire.j.a.a(context).f(b);
                            }
                            if (!z2 || TextUtils.isEmpty(kVar.d(context))) {
                                if (!m.n && m.d(context)) {
                                    Settings.System.putString(context.getContentResolver(), "com.q.zi.i", b);
                                }
                            }
                            if (kVar.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && (z3 || TextUtils.isEmpty(kVar.c(context)))) {
                                FileWriter fileWriter = null;
                                try {
                                    if (Build.VERSION.SDK_INT < 29) {
                                        if (!m.o || !m.d(context)) {
                                            z4 = false;
                                        }
                                        if (z4) {
                                            File file = new File(Environment.getExternalStorageDirectory(), ".zp");
                                            File file2 = new File(file, ".icosc");
                                            if (file.exists()) {
                                                if (!file.isDirectory()) {
                                                    file.delete();
                                                    file.mkdirs();
                                                }
                                            } else {
                                                file.mkdirs();
                                            }
                                            FileWriter fileWriter2 = new FileWriter(file2, false);
                                            try {
                                                fileWriter2.write(b);
                                                fileWriter2.flush();
                                                fileWriter2.close();
                                            } catch (Throwable unused) {
                                                fileWriter = fileWriter2;
                                                try {
                                                    int i = com.baidu.sofire.a.b.a;
                                                    if (fileWriter != null) {
                                                        fileWriter.close();
                                                    }
                                                    a = b;
                                                    return a;
                                                } catch (Throwable th) {
                                                    if (fileWriter != null) {
                                                        try {
                                                            fileWriter.close();
                                                        } catch (Throwable unused2) {
                                                            int i2 = com.baidu.sofire.a.b.a;
                                                        }
                                                    }
                                                    throw th;
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable unused3) {
                                    int i3 = com.baidu.sofire.a.b.a;
                                }
                            }
                            a = b;
                        } else {
                            z = true;
                            z2 = true;
                            z3 = false;
                            if (!z) {
                            }
                            com.baidu.sofire.j.a.a(context).f(b);
                            if (!z2) {
                            }
                            if (!m.n && m.d(context)) {
                            }
                            if (kVar.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                                FileWriter fileWriter3 = null;
                                if (Build.VERSION.SDK_INT < 29) {
                                }
                            }
                            a = b;
                        }
                    } else {
                        z = true;
                    }
                } else {
                    z = false;
                }
                z2 = false;
                z3 = false;
                if (!z) {
                }
                com.baidu.sofire.j.a.a(context).f(b);
                if (!z2) {
                }
                if (!m.n && m.d(context)) {
                }
                if (kVar.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                }
                a = b;
            }
            return a;
        }
        return (String) invokeL.objValue;
    }

    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            try {
                com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                String string = a2.c.getString("rpnewuidn", "");
                String str = TextUtils.isEmpty(string) ? "" : new String(e.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), "UTF-8");
                if (TextUtils.isEmpty(str)) {
                    String string2 = a2.c.getString("rpnewuid", "");
                    if (TextUtils.isEmpty(string2)) {
                        return "";
                    }
                    a2.f(string2);
                    return string2;
                }
                return str;
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            try {
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
            if (m.b(context) && a(context, com.kuaishou.weapon.p0.h.i)) {
                File file = new File(Environment.getExternalStorageDirectory(), ".zp/.icosc");
                if (file.exists()) {
                    return a(file);
                }
                return "";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            try {
                try {
                    return m.c(context) ? ApiReplaceUtil.getString(context.getContentResolver(), "com.q.zi.i") : "";
                } catch (Throwable unused) {
                    int i = com.baidu.sofire.a.b.a;
                    return null;
                }
            } catch (Throwable unused2) {
                int i2 = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public final String a(File file) {
        InterceptResult invokeL;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
            try {
                fileReader = new FileReader(file);
            } catch (Throwable unused) {
                fileReader = null;
            }
            try {
                char[] cArr = new char[8192];
                CharArrayWriter charArrayWriter = new CharArrayWriter();
                while (true) {
                    int read = fileReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    charArrayWriter.write(cArr, 0, read);
                }
                String charArrayWriter2 = charArrayWriter.toString();
                try {
                    fileReader.close();
                } catch (Throwable unused2) {
                    int i = com.baidu.sofire.a.b.a;
                }
                return charArrayWriter2;
            } catch (Throwable unused3) {
                try {
                    int i2 = com.baidu.sofire.a.b.a;
                    return null;
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused4) {
                            int i3 = com.baidu.sofire.a.b.a;
                        }
                    }
                }
            }
        }
        return (String) invokeL.objValue;
    }

    public final boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            try {
                return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
