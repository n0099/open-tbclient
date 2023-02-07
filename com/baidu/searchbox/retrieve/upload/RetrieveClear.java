package com.baidu.searchbox.retrieve.upload;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class RetrieveClear {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "RetrieveClear";
    public transient /* synthetic */ FieldHolder $fh;
    public final String mOldZipRootPath;
    public final String mZipRootPath;

    /* renamed from: com.baidu.searchbox.retrieve.upload.RetrieveClear$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class RetrieveClearSingle {
        public static /* synthetic */ Interceptable $ic;
        public static final RetrieveClear INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1665489654, "Lcom/baidu/searchbox/retrieve/upload/RetrieveClear$RetrieveClearSingle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1665489654, "Lcom/baidu/searchbox/retrieve/upload/RetrieveClear$RetrieveClearSingle;");
                    return;
                }
            }
            INSTANCE = new RetrieveClear(null);
        }

        public RetrieveClearSingle() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-359426881, "Lcom/baidu/searchbox/retrieve/upload/RetrieveClear;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-359426881, "Lcom/baidu/searchbox/retrieve/upload/RetrieveClear;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public static RetrieveClear getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return RetrieveClearSingle.INSTANCE;
        }
        return (RetrieveClear) invokeV.objValue;
    }

    public void autoClearCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (DEBUG) {
                Log.v(TAG, "Retrieve Auto Clear Cache .");
            }
            deleteFolder(this.mOldZipRootPath);
            deleteFolder(this.mZipRootPath);
        }
    }

    public long calculateCacheSize() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            File file = new File(this.mOldZipRootPath);
            if (!file.exists() || !file.isDirectory()) {
                return 0L;
            }
            return 0 + getDirectorySize(file);
        }
        return invokeV.longValue;
    }

    public void manualClearCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (DEBUG) {
                Log.v(TAG, "Retrieve Manual Clear Cache .");
            }
            deleteFolder(this.mOldZipRootPath);
        }
    }

    public RetrieveClear() {
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
        this.mOldZipRootPath = AppRuntime.getAppContext().getApplicationInfo().dataDir + UploadHelper.LOG_FILE_FETCH_ZIP_PATH + File.separator;
        this.mZipRootPath = AppRuntime.getAppContext().getCacheDir().getAbsolutePath() + UploadHelper.LOG_FILE_FETCH_ZIP_PATH + File.separator;
    }

    public /* synthetic */ RetrieveClear(AnonymousClass1 anonymousClass1) {
        this();
    }

    private boolean deleteFolder(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            File file = new File(str);
            if (!file.exists()) {
                return false;
            }
            if (file.isFile()) {
                return deleteFile(str);
            }
            return deleteDirectory(str);
        }
        return invokeL.booleanValue;
    }

    private boolean deleteDirectory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            File file = new File(str);
            if (!file.exists() || !file.isDirectory()) {
                return false;
            }
            File[] listFiles = file.listFiles();
            boolean z = true;
            if (listFiles == null) {
                return true;
            }
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    z = deleteFile(file2.getAbsolutePath());
                } else {
                    z = deleteDirectory(file2.getAbsolutePath());
                }
                if (!z) {
                    break;
                }
            }
            if (!z) {
                return false;
            }
            if (DEBUG) {
                Log.v(TAG, "RetrieveClear delete Directory : " + str);
            }
            return file.delete();
        }
        return invokeL.booleanValue;
    }

    private boolean deleteFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                if (DEBUG) {
                    Log.v(TAG, "RetrieveClear delete File : " + str);
                }
                return file.delete();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public long getDirectorySize(File file) throws IOException {
        InterceptResult invokeL;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return file.length();
            }
            long j = 0;
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    length = getDirectorySize(file2);
                } else {
                    length = file2.length();
                }
                j += length;
            }
            return j;
        }
        return invokeL.longValue;
    }
}
