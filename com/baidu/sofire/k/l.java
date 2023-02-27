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
/* loaded from: classes3.dex */
public class l {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public transient /* synthetic */ FieldHolder $fh;

    public l() {
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
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (TextUtils.isEmpty(a)) {
                l lVar = new l();
                String b = lVar.b(context);
                boolean z5 = true;
                if (TextUtils.isEmpty(b)) {
                    b = lVar.d(context);
                    if (TextUtils.isEmpty(b)) {
                        b = lVar.c(context);
                        if (TextUtils.isEmpty(b)) {
                            b = "1|" + j.a(UUID.randomUUID().toString());
                            z = true;
                            z2 = true;
                            z3 = true;
                            if (!z || TextUtils.isEmpty(lVar.b(context))) {
                                com.baidu.sofire.j.a.a(context).b(b);
                            }
                            if (!z2 || TextUtils.isEmpty(lVar.d(context))) {
                                if (!q.d && q.b(context)) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    Settings.System.putString(context.getContentResolver(), "com.q.zi.i", b);
                                }
                            }
                            if (lVar.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && (z3 || TextUtils.isEmpty(lVar.c(context)))) {
                                FileWriter fileWriter = null;
                                try {
                                    if (Build.VERSION.SDK_INT < 29) {
                                        if (!q.e || !q.b(context)) {
                                            z5 = false;
                                        }
                                        if (z5) {
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
                            com.baidu.sofire.j.a.a(context).b(b);
                            if (!z2) {
                            }
                            if (!q.d) {
                            }
                            z4 = false;
                            if (z4) {
                            }
                            if (lVar.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
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
                com.baidu.sofire.j.a.a(context).b(b);
                if (!z2) {
                }
                if (!q.d) {
                }
                z4 = false;
                if (z4) {
                }
                if (lVar.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                }
                a = b;
            }
            return a;
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

    public String b(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            try {
                com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                String string = a2.c.getString("rpnewuidn", "");
                if (TextUtils.isEmpty(string)) {
                    str = "";
                } else {
                    str = new String(f.a(com.baidu.sofire.j.a.k, Base64.decode(string, 10), true), "UTF-8");
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                String string2 = a2.c.getString("rpnewuid", "");
                if (TextUtils.isEmpty(string2)) {
                    return "";
                }
                a2.b(string2);
                return string2;
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033 A[Catch: all -> 0x0038, TRY_LEAVE, TryCatch #0 {all -> 0x0038, blocks: (B:7:0x0009, B:9:0x000d, B:15:0x0019, B:18:0x0022, B:20:0x0033), top: B:28:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(Context context) {
        InterceptResult invokeL;
        boolean z;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (context != null) {
                try {
                } catch (Throwable unused) {
                    int i = com.baidu.sofire.a.b.a;
                }
                if (q.c && q.b(context)) {
                    z = true;
                    if (z || !a(context, com.kuaishou.weapon.p0.h.i)) {
                        return "";
                    }
                    file = new File(Environment.getExternalStorageDirectory(), ".zp/.icosc");
                    if (file.exists()) {
                        return a(file);
                    }
                    return "";
                }
            }
            z = false;
            if (z) {
                return "";
            }
            file = new File(Environment.getExternalStorageDirectory(), ".zp/.icosc");
            if (file.exists()) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public final boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            try {
                if (context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001a A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {all -> 0x0023, blocks: (B:7:0x000b, B:9:0x000f, B:14:0x001a), top: B:25:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String d(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (context != null) {
                try {
                    try {
                        if (q.b && q.b(context)) {
                            z = true;
                            if (z) {
                                return "";
                            }
                            return ApiReplaceUtil.getString(context.getContentResolver(), "com.q.zi.i");
                        }
                    } catch (Throwable unused) {
                        int i = com.baidu.sofire.a.b.a;
                        return null;
                    }
                } catch (Throwable unused2) {
                    int i2 = com.baidu.sofire.a.b.a;
                    return "";
                }
            }
            z = false;
            if (z) {
            }
        } else {
            return (String) invokeL.objValue;
        }
    }
}
