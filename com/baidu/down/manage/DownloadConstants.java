package com.baidu.down.manage;

import android.provider.BaseColumns;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class DownloadConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CTRL_FLAG_AUTO_PAUSED = 2;
    public static final long CTRL_FLAG_CHECK_CONTENT_TYPE = 8;
    public static final long CTRL_FLAG_SUPPORT_RANGE = 1;
    public static final long CTRL_FLAG_WIFI_ONLY = 4;
    public static final int DOWNLOAD_PRIORITY_DEFAULT = 3;
    public static final int DOWNLOAD_THREAD_MAX_NUM = 3;
    public static final int DOWNLOAD_THREAD_MIN_NUM = 1;
    public static final boolean LOCAL_LOGVV = false;
    public static final boolean LOGV = true;
    public static final boolean LOGVV = false;
    public static final String LOG_TRACE_TAG = "core>download";
    public static final String MIMETYPE_APK = "application/vnd.android.package-archive";
    public static final String MIMETYPE_APK_PATCH = "application/com.baidu.appsearch.patch";
    public static final String MIMETYPE_GIF = "image/gif";
    public static final int PERCENT_HUNDERD = 100;
    public static final String REFER = "http://m.baidu.com";
    public static final int STATUS_DEVICE_NOT_FOUND_ERROR = 499;
    public static final int STATUS_FILE_ERROR = 492;
    public static final int STATUS_PAUSED_BY_APP = 193;
    public static final int STATUS_PENDING = 190;
    public static final int STATUS_QUEUED_FOR_WIFI = 196;
    public static final int STATUS_RUNNING = 192;
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_WAITING_FOR_NETWORK = 195;
    public static final int STATUS_WAITING_TO_RETRY = 194;
    public static final String TAG = "DownloadManager";
    public static final int VISIBILITY_VISIBLE = 0;
    public static boolean mDebug;
    public static String sDestinationDir;
    public static DestinationMode sDestinationMode;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class DestinationMode {
        public static final /* synthetic */ DestinationMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DestinationMode AUTO;
        public static final DestinationMode CUSTOM;
        public static final DestinationMode EXTERNAL_ONLY;
        public static final DestinationMode INTERNAL_ONLY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-345488526, "Lcom/baidu/down/manage/DownloadConstants$DestinationMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-345488526, "Lcom/baidu/down/manage/DownloadConstants$DestinationMode;");
                    return;
                }
            }
            AUTO = new DestinationMode("AUTO", 0);
            INTERNAL_ONLY = new DestinationMode("INTERNAL_ONLY", 1);
            EXTERNAL_ONLY = new DestinationMode("EXTERNAL_ONLY", 2);
            DestinationMode destinationMode = new DestinationMode("CUSTOM", 3);
            CUSTOM = destinationMode;
            $VALUES = new DestinationMode[]{AUTO, INTERNAL_ONLY, EXTERNAL_ONLY, destinationMode};
        }

        public DestinationMode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DestinationMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DestinationMode) Enum.valueOf(DestinationMode.class, str) : (DestinationMode) invokeL.objValue;
        }

        public static DestinationMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DestinationMode[]) $VALUES.clone() : (DestinationMode[]) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class DownloadColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_AUTO_PAUSE = "AUTO_PAUSE";
        public static final String COLUMN_CONTROL_FLAG = "CONTROL_FLAG";
        public static final String COLUMN_CURRENT_BYTES = "CURRENT_BYTES";
        public static final String COLUMN_DOWNLOAD_PRIORITY = "DOWNLOAD_PRIORITY";
        public static final String COLUMN_DOWN_DIR = "DOWN_DIR";
        public static final String COLUMN_ETAG = "ETAG";
        public static final String COLUMN_FILE_NAME = "_DATA";
        public static final String COLUMN_FROM_PARAM = "FROM_PARAM";
        public static final String COLUMN_MIME_TYPE = "MIMETYPE";
        public static final String COLUMN_NEED_N_KEY = "NOTIFICATIONNEEDED";
        public static final String COLUMN_PROGRESS_MAP = "PROGRESSMAP";
        public static final String COLUMN_REAL_URI = "REAL_URI";
        public static final String COLUMN_SAVED_PATH = "SAVED_PATH_FOR_USER";
        public static final String COLUMN_SOURCE_KEY = "SAVED_SOURCE_KEY_USER";
        public static final String COLUMN_STATUS = "STATUS";
        public static final String COLUMN_TOTAL_BYTES = "TOTAL_BYTES";
        public static final String COLUMN_URI = "URI";
        public static final String COLUMN_URI_HOST = "URI_HOST";
        public static final String FAILED_REASON = "FAILEDREASON";
        public static final String FAILED_TYPE = "FAILED_TYPE";
        public transient /* synthetic */ FieldHolder $fh;

        public DownloadColumns() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(819163103, "Lcom/baidu/down/manage/DownloadConstants;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(819163103, "Lcom/baidu/down/manage/DownloadConstants;");
        }
    }

    public DownloadConstants() {
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

    public static String getDestinationDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sDestinationDir : (String) invokeV.objValue;
    }

    public static DestinationMode getDestinationMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            DestinationMode destinationMode = sDestinationMode;
            return destinationMode != null ? destinationMode : DestinationMode.AUTO;
        }
        return (DestinationMode) invokeV.objValue;
    }

    public static boolean isStatusError(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? i2 >= 400 && i2 < 600 : invokeI.booleanValue;
    }

    public static void setDestinationDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            sDestinationDir = str;
        }
    }

    public static void setDestinationMode(DestinationMode destinationMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, destinationMode) == null) {
            sDestinationMode = destinationMode;
        }
    }
}
