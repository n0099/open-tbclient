package com.baidu.searchbox.aperf.bosuploader;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.Closeables;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class STSManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long RETRY_TIME_LIMIT_HOUR;
    public static final String STS_FILE = ".sts";
    public static final String STS_FILE_PATH = "stsfile";
    public static final String TAG = "STSManager";
    public static final HashMap<String, STSInfo> infoMap;
    public static HashMap<String, Long> retryTime;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-186508794, "Lcom/baidu/searchbox/aperf/bosuploader/STSManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-186508794, "Lcom/baidu/searchbox/aperf/bosuploader/STSManager;");
                return;
            }
        }
        infoMap = new HashMap<>();
        retryTime = new HashMap<>();
        RETRY_TIME_LIMIT_HOUR = TimeUnit.MINUTES.toMillis(20L);
    }

    public STSManager() {
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

    public static boolean checkRetry(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            long longValue = retryTime.containsKey(str) ? retryTime.get(str).longValue() : 0L;
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - longValue) > RETRY_TIME_LIMIT_HOUR) {
                retryTime.put(str, Long.valueOf(currentTimeMillis));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static STSInfo getCurrentStsInfo(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            STSInfo sTSInfo = infoMap.get(str);
            if (sTSInfo == null && (sTSInfo = loadStsFromFile(str)) != null) {
                synchronized (infoMap) {
                    infoMap.put(str, sTSInfo);
                }
            }
            return ContentUtil.checkStsValid(sTSInfo) ? sTSInfo : retryGetStsInfo(str);
        }
        return (STSInfo) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0074 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    public static STSInfo loadStsFromFile(String str) {
        InterceptResult invokeL;
        Throwable th;
        FileInputStream fileInputStream;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                try {
                    file = new File(AppRuntime.getAppContext().getFilesDir(), STS_FILE_PATH);
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely((Closeable) str);
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                str = 0;
                Closeables.closeSafely((Closeable) str);
                throw th;
            }
            if (!file.exists()) {
                Closeables.closeSafely((Closeable) null);
                return null;
            }
            File file2 = new File(file, ".sts_" + ((String) str) + ".log");
            if (!file2.exists()) {
                Closeables.closeSafely((Closeable) null);
                return null;
            } else if (!file2.isFile()) {
                Closeables.closeSafely((Closeable) null);
                return null;
            } else {
                fileInputStream = new FileInputStream(file2);
                try {
                    String readFromFileInputStream = FileUtil.readFromFileInputStream(fileInputStream);
                    if (!TextUtils.isEmpty(readFromFileInputStream)) {
                        STSInfo createSTSInfo = ContentUtil.createSTSInfo(readFromFileInputStream);
                        Closeables.closeSafely(fileInputStream);
                        return createSTSInfo;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    e.getMessage();
                    Closeables.closeSafely(fileInputStream);
                    return null;
                }
                Closeables.closeSafely(fileInputStream);
                return null;
            }
        }
        return (STSInfo) invokeL.objValue;
    }

    public static STSInfo retryGetStsInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            STSInfo bosStsInfo = BOSTokenRequest.getBosStsInfo(str);
            if (bosStsInfo != null) {
                synchronized (infoMap) {
                    infoMap.put(str, bosStsInfo);
                }
                writeStsInfoToFile(str, bosStsInfo.getOrigin());
                return bosStsInfo;
            }
            return null;
        }
        return (STSInfo) invokeL.objValue;
    }

    public static void writeStsInfoToFile(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), STS_FILE_PATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileUtil.writeDataToFile(new File(file, ".sts_" + str + ".log"), str2);
        }
    }
}
