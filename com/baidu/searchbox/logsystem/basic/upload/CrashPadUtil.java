package com.baidu.searchbox.logsystem.basic.upload;

import android.text.TextUtils;
import android.util.Base64;
import android.util.JsonWriter;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.logsystem.util.DebugUtil;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.searchbox.logsystem.util.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes11.dex */
public final class CrashPadUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int MAX_READ_BDMP = 102400;
    public static final int MAX_READ_EXTRA = 20480;
    public static final String TAG = "CrashPadUtil";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-829412586, "Lcom/baidu/searchbox/logsystem/basic/upload/CrashPadUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-829412586, "Lcom/baidu/searchbox/logsystem/basic/upload/CrashPadUtil;");
                return;
            }
        }
        DEBUG = LLog.sDebug;
    }

    public CrashPadUtil() {
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

    public static void createJsonExtraInfo(@NonNull File file, @NonNull JsonWriter jsonWriter) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, file, jsonWriter) == null) || file == null || !file.exists() || jsonWriter == null) {
            return;
        }
        try {
            Pair<String, Boolean> readFile = Utility.readFile(file, MAX_READ_EXTRA);
            if (readFile == null || TextUtils.isEmpty((CharSequence) readFile.first)) {
                return;
            }
            if (DEBUG) {
                DebugUtil.saveLog("json-extra : " + ((String) readFile.first));
                String str = "json-extra.size = " + ((String) readFile.first).length();
            }
            jsonWriter.name(Constant.CRASH_ENVIR).value((String) readFile.first);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void createMiniBDMPInfo(@NonNull File file, @NonNull JsonWriter jsonWriter) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, file, jsonWriter) == null) || file == null || jsonWriter == null || !file.exists()) {
            return;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e2) {
                e = e2;
                byteArrayOutputStream = null;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            int round = Math.round(76800.0f);
            int i2 = 0;
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1 || i2 >= round) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
                i2 += read;
            }
            byteArrayOutputStream.flush();
            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 11);
            if (DEBUG) {
                DebugUtil.saveLog("mini-bdmp : " + encodeToString);
            }
            jsonWriter.name(Constant.STACKTRACE_BDMP).value(encodeToString);
            Closeables.closeSafely(fileInputStream);
        } catch (Exception e4) {
            e = e4;
            fileInputStream2 = fileInputStream;
            try {
                e.printStackTrace();
                Closeables.closeSafely(fileInputStream2);
                Closeables.closeSafely(byteArrayOutputStream);
            } catch (Throwable th3) {
                th = th3;
                Closeables.closeSafely(fileInputStream2);
                Closeables.closeSafely(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream2 = fileInputStream;
            Closeables.closeSafely(fileInputStream2);
            Closeables.closeSafely(byteArrayOutputStream);
            throw th;
        }
        Closeables.closeSafely(byteArrayOutputStream);
    }
}
