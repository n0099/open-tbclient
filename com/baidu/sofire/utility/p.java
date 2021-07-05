package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;
/* loaded from: classes4.dex */
public final class p {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f10507a = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1443542115, "Lcom/baidu/sofire/utility/p;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1443542115, "Lcom/baidu/sofire/utility/p;");
        }
    }

    public p() {
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

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (TextUtils.isEmpty(f10507a)) {
                new p();
                f10507a = b(context);
            }
            return f10507a;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00dd A[Catch: all -> 0x00fd, TryCatch #4 {all -> 0x00fd, blocks: (B:35:0x00b7, B:38:0x00be, B:41:0x00c5, B:43:0x00dd, B:45:0x00e3, B:47:0x00ed, B:46:0x00ea), top: B:72:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ea A[Catch: all -> 0x00fd, TryCatch #4 {all -> 0x00fd, blocks: (B:35:0x00b7, B:38:0x00be, B:41:0x00c5, B:43:0x00dd, B:45:0x00e3, B:47:0x00ed, B:46:0x00ea), top: B:72:0x00b7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        File file;
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            String c2 = c(context);
            boolean z3 = true;
            if (TextUtils.isEmpty(c2)) {
                c2 = d(context);
                if (TextUtils.isEmpty(c2)) {
                    c2 = e(context);
                    if (TextUtils.isEmpty(c2)) {
                        String h2 = s.h(context);
                        String i2 = s.i(context);
                        if (TextUtils.isEmpty(h2) && TextUtils.isEmpty(i2)) {
                            c2 = "1|" + o.a(UUID.randomUUID().toString());
                        } else {
                            StringBuilder sb = new StringBuilder("0|");
                            sb.append(o.a(h2 + i2));
                            c2 = sb.toString();
                        }
                        z = true;
                        z2 = true;
                        if (!z3 || TextUtils.isEmpty(c(context))) {
                            com.baidu.sofire.h.a.a(context).d(c2);
                        }
                        if (!z || TextUtils.isEmpty(d(context))) {
                            a(context, "com.q.zi.i", c2);
                        }
                        if (b(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) && (z2 || TextUtils.isEmpty(e(context)))) {
                            FileWriter fileWriter2 = null;
                            try {
                                try {
                                } catch (Throwable unused) {
                                    c.a();
                                }
                            } catch (Throwable unused2) {
                            }
                            if (Build.VERSION.SDK_INT < 29 && s.e(context)) {
                                file = new File(Environment.getExternalStorageDirectory(), ".zp");
                                File file2 = new File(file, ".icosc");
                                if (!file.exists()) {
                                    if (!file.isDirectory()) {
                                        file.delete();
                                        file.mkdirs();
                                    }
                                } else {
                                    file.mkdirs();
                                }
                                fileWriter = new FileWriter(file2, false);
                                try {
                                    fileWriter.write(c2);
                                    fileWriter.flush();
                                    fileWriter.close();
                                } catch (Throwable unused3) {
                                    fileWriter2 = fileWriter;
                                    try {
                                        c.a();
                                        if (fileWriter2 != null) {
                                            fileWriter2.close();
                                        }
                                        return c2;
                                    } catch (Throwable th) {
                                        if (fileWriter2 != null) {
                                            try {
                                                fileWriter2.close();
                                            } catch (Throwable unused4) {
                                                c.a();
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        }
                        return c2;
                    }
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
                z3 = false;
            }
            z2 = false;
            if (!z3) {
            }
            com.baidu.sofire.h.a.a(context).d(c2);
            if (!z) {
            }
            a(context, "com.q.zi.i", c2);
            if (b(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                FileWriter fileWriter22 = null;
                if (Build.VERSION.SDK_INT < 29) {
                    file = new File(Environment.getExternalStorageDirectory(), ".zp");
                    File file22 = new File(file, ".icosc");
                    if (!file.exists()) {
                    }
                    fileWriter = new FileWriter(file22, false);
                    fileWriter.write(c2);
                    fileWriter.flush();
                    fileWriter.close();
                }
            }
            return c2;
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                String o = a2.o();
                if (TextUtils.isEmpty(o)) {
                    String string = a2.f10395c.getString("rpnewuid", "");
                    if (TextUtils.isEmpty(string)) {
                        return "";
                    }
                    a2.d(string);
                    return string;
                }
                return o;
            } catch (Throwable unused) {
                c.a();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                return a(context, "com.q.zi.i");
            } catch (Throwable unused) {
                c.a();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
            } catch (Throwable unused) {
                c.a();
            }
            if (s.c(context) && b(context, "android.permission.READ_EXTERNAL_STORAGE")) {
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

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            try {
                return s.b(context) ? Settings.System.getString(context.getContentResolver(), str) : "";
            } catch (Throwable unused) {
                c.a();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(File file) {
        InterceptResult invokeL;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, file)) == null) {
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
                    c.a();
                }
                return charArrayWriter2;
            } catch (Throwable unused3) {
                try {
                    c.a();
                    return null;
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused4) {
                            c.a();
                        }
                    }
                }
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, str, str2)) == null) {
            try {
                if (s.d(context)) {
                    return Settings.System.putString(context.getContentResolver(), str, str2);
                }
                return false;
            } catch (Throwable unused) {
                c.a();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            try {
                return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
            } catch (Throwable unused) {
                c.a();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
