package com.baidu.searchbox.bddownload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore;
import com.baidu.searchbox.bddownload.core.dispatcher.DownloadDispatcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public class StatusUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class Status {
        public static final /* synthetic */ Status[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Status COMPLETED;
        public static final Status IDLE;
        public static final Status PENDING;
        public static final Status RUNNING;
        public static final Status UNKNOWN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(849318820, "Lcom/baidu/searchbox/bddownload/StatusUtil$Status;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(849318820, "Lcom/baidu/searchbox/bddownload/StatusUtil$Status;");
                    return;
                }
            }
            PENDING = new Status("PENDING", 0);
            RUNNING = new Status(TornadoLiteRuntime.STATE_RUNNING, 1);
            COMPLETED = new Status("COMPLETED", 2);
            IDLE = new Status("IDLE", 3);
            Status status = new Status(RomUtils.UNKNOWN, 4);
            UNKNOWN = status;
            $VALUES = new Status[]{PENDING, RUNNING, COMPLETED, IDLE, status};
        }

        public Status(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Status valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Status) Enum.valueOf(Status.class, str);
            }
            return (Status) invokeL.objValue;
        }

        public static Status[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Status[]) $VALUES.clone();
            }
            return (Status[]) invokeV.objValue;
        }
    }

    public StatusUtil() {
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

    @NonNull
    public static DownloadTask createFinder(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, str3)) == null) {
            return new DownloadTask.Builder(str, str2, str3).build();
        }
        return (DownloadTask) invokeLLL.objValue;
    }

    @Nullable
    public static BreakpointInfo getCurrentInfo(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            return getCurrentInfo(createFinder(str, str2, str3));
        }
        return (BreakpointInfo) invokeLLL.objValue;
    }

    public static Status getStatus(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, str, str2, str3)) == null) {
            return getStatus(createFinder(str, str2, str3));
        }
        return (Status) invokeLLL.objValue;
    }

    public static boolean isCompleted(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, str2, str3)) == null) {
            return isCompleted(createFinder(str, str2, str3));
        }
        return invokeLLL.booleanValue;
    }

    @Nullable
    public static BreakpointInfo getCurrentInfo(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, downloadTask)) == null) {
            BreakpointStore breakpointStore = BdDownload.with().breakpointStore();
            BreakpointInfo breakpointInfo = breakpointStore.get(breakpointStore.findOrCreateId(downloadTask));
            if (breakpointInfo == null) {
                return null;
            }
            return breakpointInfo.copy();
        }
        return (BreakpointInfo) invokeL.objValue;
    }

    public static boolean isCompleted(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, downloadTask)) == null) {
            if (isCompletedOrUnknown(downloadTask) == Status.COMPLETED) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isSameTaskPendingOrRunning(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, downloadTask)) == null) {
            if (BdDownload.with().downloadDispatcher().findSameTask(downloadTask) != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static Status getStatus(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, downloadTask)) == null) {
            Status isCompletedOrUnknown = isCompletedOrUnknown(downloadTask);
            Status status = Status.COMPLETED;
            if (isCompletedOrUnknown == status) {
                return status;
            }
            DownloadDispatcher downloadDispatcher = BdDownload.with().downloadDispatcher();
            if (downloadDispatcher.isPending(downloadTask)) {
                return Status.PENDING;
            }
            if (downloadDispatcher.isRunning(downloadTask)) {
                return Status.RUNNING;
            }
            return isCompletedOrUnknown;
        }
        return (Status) invokeL.objValue;
    }

    public static Status isCompletedOrUnknown(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, downloadTask)) == null) {
            BreakpointStore breakpointStore = BdDownload.with().breakpointStore();
            BreakpointInfo breakpointInfo = breakpointStore.get(downloadTask.getId());
            String filename = downloadTask.getFilename();
            File parentFile = downloadTask.getParentFile();
            File file = downloadTask.getFile();
            if (breakpointInfo != null) {
                if (!breakpointInfo.isChunked() && breakpointInfo.getTotalLength() <= 0) {
                    return Status.UNKNOWN;
                }
                if (file != null && file.equals(breakpointInfo.getFile()) && file.exists() && breakpointInfo.getTotalOffset() == breakpointInfo.getTotalLength()) {
                    return Status.COMPLETED;
                }
                if (filename == null && breakpointInfo.getFile() != null && breakpointInfo.getFile().exists()) {
                    return Status.IDLE;
                }
                if (file != null && file.equals(breakpointInfo.getFile()) && file.exists()) {
                    return Status.IDLE;
                }
            } else if (!breakpointStore.isOnlyMemoryCache() && !breakpointStore.isFileDirty(downloadTask.getId())) {
                if (file != null && file.exists()) {
                    return Status.COMPLETED;
                }
                String responseFilename = breakpointStore.getResponseFilename(downloadTask.getUrl());
                if (responseFilename != null && new File(parentFile, responseFilename).exists()) {
                    return Status.COMPLETED;
                }
            } else {
                return Status.UNKNOWN;
            }
            return Status.UNKNOWN;
        }
        return (Status) invokeL.objValue;
    }
}
