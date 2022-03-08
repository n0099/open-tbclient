package com.baidu.searchbox.bddownload;

import android.net.Uri;
import android.util.SparseArray;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.IdentifiedTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.download.DownloadStrategy;
import com.baidu.searchbox.bddownload.core.listener.DownloadListener;
import com.baidu.searchbox.bddownload.core.priority.PriorityStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public class DownloadTask extends IdentifiedTask implements Comparable<DownloadTask> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean autoCallbackToUIThread;
    @Nullable
    public final Integer connectionCount;
    @NonNull
    public final File directoryFile;
    public final boolean filenameFromResponse;
    @NonNull
    public final DownloadStrategy.FilenameHolder filenameHolder;
    public final int flushBufferSize;
    public final Map<String, List<String>> headerMapFields;
    public final int id;
    @Nullable
    public BreakpointInfo info;
    @Nullable
    public final Boolean isPreAllocateLength;
    public volatile SparseArray<Object> keyTagMap;
    public final AtomicLong lastCallbackProcessTimestamp;
    public volatile DownloadListener listener;
    public final int minIntervalMillisCallbackProcess;
    public final boolean passIfAlreadyCompleted;
    public final PriorityStrategy.Priority priority;
    @NonNull
    public final File providedPathFile;
    public final int readBufferSize;
    @Nullable
    public String redirectLocation;
    public SpeedCalculator speedCalculator;
    public final int syncBufferIntervalMills;
    public final int syncBufferSize;
    public Object tag;
    @Nullable
    public File targetFile;
    public final Uri uri;
    @NonNull
    public final String url;
    public final boolean wifiRequired;

    /* loaded from: classes4.dex */
    public static class TaskHideWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public TaskHideWrapper() {
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

        public static long getLastCallbackProcessTs(DownloadTask downloadTask) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, downloadTask)) == null) ? downloadTask.getLastCallbackProcessTs() : invokeL.longValue;
        }

        public static void setBreakpointInfo(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, downloadTask, breakpointInfo) == null) {
                downloadTask.setBreakpointInfo(breakpointInfo);
            }
        }

        public static void setLastCallbackProcessTs(DownloadTask downloadTask, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(65539, null, downloadTask, j2) == null) {
                downloadTask.setLastCallbackProcessTs(j2);
            }
        }

        public static void setSpeedIncreaseBytes(DownloadTask downloadTask, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, downloadTask, j2) == null) {
                downloadTask.setSpeedIncreaseBytes(j2);
            }
        }
    }

    public DownloadTask(String str, Uri uri, PriorityStrategy.Priority priority, int i2, int i3, int i4, int i5, boolean z, int i6, Map<String, List<String>> map, @Nullable String str2, boolean z2, boolean z3, Boolean bool, @Nullable Integer num, @Nullable Boolean bool2) {
        Boolean bool3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, uri, priority, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Integer.valueOf(i6), map, str2, Boolean.valueOf(z2), Boolean.valueOf(z3), bool, num, bool2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String str3 = str2;
        this.url = str;
        this.uri = uri;
        this.priority = priority;
        this.readBufferSize = i2;
        this.flushBufferSize = i3;
        this.syncBufferSize = i4;
        this.syncBufferIntervalMills = i5;
        this.autoCallbackToUIThread = z;
        this.minIntervalMillisCallbackProcess = i6;
        this.headerMapFields = map;
        this.lastCallbackProcessTimestamp = new AtomicLong();
        this.passIfAlreadyCompleted = z2;
        this.wifiRequired = z3;
        this.connectionCount = num;
        this.isPreAllocateLength = bool2;
        if (Util.isUriFileScheme(uri)) {
            File file = new File(uri.getPath());
            if (bool != null) {
                if (bool.booleanValue()) {
                    if (file.exists() && file.isFile()) {
                        throw new IllegalArgumentException("If you want filename from response please make sure you provide path is directory " + file.getPath());
                    }
                    if (!Util.isEmpty(str2)) {
                        Util.w("DownloadTask", "Discard filename[" + str3 + "] because you set filenameFromResponse=true");
                        str3 = null;
                    }
                    this.directoryFile = file;
                } else if (file.exists() && file.isDirectory() && Util.isEmpty(str2)) {
                    throw new IllegalArgumentException("If you don't want filename from response please make sure you have already provided valid filename or not directory path " + file.getPath());
                } else if (Util.isEmpty(str2)) {
                    str3 = file.getName();
                    this.directoryFile = Util.getParentFile(file);
                } else {
                    this.directoryFile = file;
                }
                bool3 = bool;
            } else if (file.exists() && file.isDirectory()) {
                bool3 = Boolean.TRUE;
                this.directoryFile = file;
            } else {
                bool3 = Boolean.FALSE;
                if (file.exists()) {
                    if (!Util.isEmpty(str2) && !file.getName().equals(str3)) {
                        throw new IllegalArgumentException("Uri already provided filename!");
                    }
                    str3 = file.getName();
                    this.directoryFile = Util.getParentFile(file);
                } else if (Util.isEmpty(str2)) {
                    str3 = file.getName();
                    this.directoryFile = Util.getParentFile(file);
                } else {
                    this.directoryFile = file;
                }
            }
            this.filenameFromResponse = bool3.booleanValue();
        } else {
            this.filenameFromResponse = false;
            this.directoryFile = new File(uri.getPath());
        }
        if (Util.isEmpty(str3)) {
            this.filenameHolder = new DownloadStrategy.FilenameHolder();
            this.providedPathFile = this.directoryFile;
        } else {
            this.filenameHolder = new DownloadStrategy.FilenameHolder(str3);
            File file2 = new File(this.directoryFile, str3);
            this.targetFile = file2;
            this.providedPathFile = file2;
        }
        this.speedCalculator = new SpeedCalculator();
        this.id = BdDownload.with().breakpointStore().findOrCreateId(this);
    }

    public static void enqueue(DownloadTask[] downloadTaskArr, DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, downloadTaskArr, downloadListener) == null) {
            for (DownloadTask downloadTask : downloadTaskArr) {
                downloadTask.listener = downloadListener;
            }
            BdDownload.with().downloadDispatcher().enqueue(downloadTaskArr);
        }
    }

    public static MockTaskForCompare mockTaskForCompare(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) ? new MockTaskForCompare(i2) : (MockTaskForCompare) invokeI.objValue;
    }

    public synchronized DownloadTask addTag(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, obj)) == null) {
            synchronized (this) {
                if (this.keyTagMap == null) {
                    synchronized (this) {
                        if (this.keyTagMap == null) {
                            this.keyTagMap = new SparseArray<>();
                        }
                    }
                }
                this.keyTagMap.put(i2, obj);
            }
            return this;
        }
        return (DownloadTask) invokeIL.objValue;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BdDownload.with().downloadDispatcher().cancel(this);
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof DownloadTask) {
                DownloadTask downloadTask = (DownloadTask) obj;
                if (downloadTask.id == this.id) {
                    return true;
                }
                return compareIgnoreId(downloadTask);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void execute(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadListener) == null) {
            this.listener = downloadListener;
            BdDownload.with().downloadDispatcher().execute(this);
        }
    }

    public int getConnectionCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BreakpointInfo breakpointInfo = this.info;
            if (breakpointInfo == null) {
                return 0;
            }
            return breakpointInfo.getBlockCount();
        }
        return invokeV.intValue;
    }

    @Nullable
    public File getFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String str = this.filenameHolder.get();
            if (str == null) {
                return null;
            }
            if (this.targetFile == null) {
                this.targetFile = new File(this.directoryFile, str);
            }
            return this.targetFile;
        }
        return (File) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
    @Nullable
    public String getFilename() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.filenameHolder.get() : (String) invokeV.objValue;
    }

    public DownloadStrategy.FilenameHolder getFilenameHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.filenameHolder : (DownloadStrategy.FilenameHolder) invokeV.objValue;
    }

    public int getFlushBufferSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.flushBufferSize : invokeV.intValue;
    }

    @Nullable
    public Map<String, List<String>> getHeaderMapFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.headerMapFields : (Map) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.id : invokeV.intValue;
    }

    @Nullable
    public BreakpointInfo getInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.info == null) {
                this.info = BdDownload.with().breakpointStore().get(this.id);
            }
            return this.info;
        }
        return (BreakpointInfo) invokeV.objValue;
    }

    public long getLastCallbackProcessTs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.lastCallbackProcessTimestamp.get() : invokeV.longValue;
    }

    public long getLastSeconds() {
        InterceptResult invokeV;
        BreakpointInfo breakpointInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            long instantBytesPerSecondAndFlush = this.speedCalculator.getInstantBytesPerSecondAndFlush();
            if (instantBytesPerSecondAndFlush > 0 && (breakpointInfo = this.info) != null) {
                return breakpointInfo.getLastLength() / instantBytesPerSecondAndFlush;
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public DownloadListener getListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.listener : (DownloadListener) invokeV.objValue;
    }

    public int getMinIntervalMillisCallbackProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.minIntervalMillisCallbackProcess : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
    @NonNull
    public File getParentFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.directoryFile : (File) invokeV.objValue;
    }

    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.priority.ordinal() : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
    @NonNull
    public File getProvidedPathFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.providedPathFile : (File) invokeV.objValue;
    }

    public int getReadBufferSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.readBufferSize : invokeV.intValue;
    }

    @Nullable
    public String getRedirectLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.redirectLocation : (String) invokeV.objValue;
    }

    @Nullable
    public Integer getSetConnectionCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.connectionCount : (Integer) invokeV.objValue;
    }

    @Nullable
    public Boolean getSetPreAllocateLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.isPreAllocateLength : (Boolean) invokeV.objValue;
    }

    public int getSyncBufferIntervalMills() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.syncBufferIntervalMills : invokeV.intValue;
    }

    public int getSyncBufferSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.syncBufferSize : invokeV.intValue;
    }

    public Object getTag(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            if (this.keyTagMap == null) {
                return null;
            }
            return this.keyTagMap.get(i2);
        }
        return invokeI.objValue;
    }

    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.uri : (Uri) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
    @NonNull
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return (this.url + this.providedPathFile.toString() + this.filenameHolder.get()).hashCode();
        }
        return invokeV.intValue;
    }

    public boolean isAutoCallbackToUIThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.autoCallbackToUIThread : invokeV.booleanValue;
    }

    public boolean isFilenameFromResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.filenameFromResponse : invokeV.booleanValue;
    }

    public boolean isPassIfAlreadyCompleted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.passIfAlreadyCompleted : invokeV.booleanValue;
    }

    public boolean isWifiRequired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.wifiRequired : invokeV.booleanValue;
    }

    @NonNull
    public MockTaskForCompare mock(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) ? new MockTaskForCompare(i2, this) : (MockTaskForCompare) invokeI.objValue;
    }

    public synchronized void removeTag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            synchronized (this) {
                if (this.keyTagMap != null) {
                    this.keyTagMap.remove(i2);
                }
            }
        }
    }

    public void replaceListener(@NonNull DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, downloadListener) == null) {
            this.listener = downloadListener;
        }
    }

    public void setBreakpointInfo(@NonNull BreakpointInfo breakpointInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, breakpointInfo) == null) {
            this.info = breakpointInfo;
        }
    }

    public void setLastCallbackProcessTs(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048618, this, j2) == null) {
            this.lastCallbackProcessTimestamp.set(j2);
        }
    }

    public void setRedirectLocation(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.redirectLocation = str;
        }
    }

    public void setSpeedIncreaseBytes(long j2) {
        SpeedCalculator speedCalculator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048620, this, j2) == null) || (speedCalculator = this.speedCalculator) == null) {
            return;
        }
        speedCalculator.downloading(j2);
    }

    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, obj) == null) {
            this.tag = obj;
        }
    }

    public void setTags(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, downloadTask) == null) {
            this.tag = downloadTask.tag;
            this.keyTagMap = downloadTask.keyTagMap;
        }
    }

    public Builder toBuilder(String str, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048624, this, str, uri)) == null) {
            Builder passIfAlreadyCompleted = new Builder(str, uri).setPriority(this.priority).setReadBufferSize(this.readBufferSize).setFlushBufferSize(this.flushBufferSize).setSyncBufferSize(this.syncBufferSize).setConnectionCount(1).setSyncBufferIntervalMillis(this.syncBufferIntervalMills).setAutoCallbackToUIThread(this.autoCallbackToUIThread).setMinIntervalMillisCallbackProcess(this.minIntervalMillisCallbackProcess).setHeaderMapFields(this.headerMapFields).setPassIfAlreadyCompleted(this.passIfAlreadyCompleted);
            if (Util.isUriFileScheme(uri) && !new File(uri.getPath()).isFile() && Util.isUriFileScheme(this.uri) && this.filenameHolder.get() != null && !new File(this.uri.getPath()).getName().equals(this.filenameHolder.get())) {
                passIfAlreadyCompleted.setFilename(this.filenameHolder.get());
            }
            return passIfAlreadyCompleted;
        }
        return (Builder) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return super.toString() + "@" + this.id + "@" + this.url + "@" + this.directoryFile.toString() + "/" + this.filenameHolder.get();
        }
        return (String) invokeV.objValue;
    }

    public static void cancel(DownloadTask[] downloadTaskArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, downloadTaskArr) == null) {
            BdDownload.with().downloadDispatcher().cancel(downloadTaskArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadTask)) == null) ? PriorityStrategy.compareTaskPriority(downloadTask, this) : invokeL.intValue;
    }

    public Object getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.tag : invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final boolean DEFAULT_AUTO_CALLBACK_TO_UI_THREAD = true;
        public static final int DEFAULT_FLUSH_BUFFER_SIZE = 16384;
        public static final boolean DEFAULT_IS_WIFI_REQUIRED = false;
        public static final int DEFAULT_MIN_INTERVAL_MILLIS_CALLBACK_PROCESS = 3000;
        public static final boolean DEFAULT_PASS_IF_ALREADY_COMPLETED = true;
        public static final int DEFAULT_READ_BUFFER_SIZE = 4096;
        public static final int DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS = 2000;
        public static final int DEFAULT_SYNC_BUFFER_SIZE = 65536;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean autoCallbackToUIThread;
        public Integer connectionCount;
        public String filename;
        public int flushBufferSize;
        public volatile Map<String, List<String>> headerMapFields;
        public Boolean isFilenameFromResponse;
        public Boolean isPreAllocateLength;
        public boolean isWifiRequired;
        public int minIntervalMillisCallbackProcess;
        public boolean passIfAlreadyCompleted;
        public PriorityStrategy.Priority priority;
        public int readBufferSize;
        public int syncBufferIntervalMillis;
        public int syncBufferSize;
        @NonNull
        public final Uri uri;
        @NonNull
        public final String url;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@NonNull String str, @NonNull String str2, @Nullable String str3) {
            this(str, Uri.fromFile(new File(str2)));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (Uri) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            if (Util.isEmpty(str3)) {
                this.isFilenameFromResponse = Boolean.TRUE;
            } else {
                this.filename = str3;
            }
        }

        public synchronized void addHeader(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                synchronized (this) {
                    if (this.headerMapFields == null) {
                        this.headerMapFields = new HashMap();
                    }
                    List<String> list = this.headerMapFields.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.headerMapFields.put(str, list);
                    }
                    list.add(str2);
                }
            }
        }

        public DownloadTask build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new DownloadTask(this.url, this.uri, this.priority, this.readBufferSize, this.flushBufferSize, this.syncBufferSize, this.syncBufferIntervalMillis, this.autoCallbackToUIThread, this.minIntervalMillisCallbackProcess, this.headerMapFields, this.filename, this.passIfAlreadyCompleted, this.isWifiRequired, this.isFilenameFromResponse, this.connectionCount, this.isPreAllocateLength) : (DownloadTask) invokeV.objValue;
        }

        public Builder setAutoCallbackToUIThread(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.autoCallbackToUIThread = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setConnectionCount(@IntRange(from = 1) int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.connectionCount = Integer.valueOf(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setFilename(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.filename = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFilenameFromResponse(@Nullable Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bool)) == null) {
                if (Util.isUriFileScheme(this.uri)) {
                    this.isFilenameFromResponse = bool;
                    return this;
                }
                throw new IllegalArgumentException("Uri isn't file scheme we can't let filename from response");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFlushBufferSize(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                if (i2 >= 0) {
                    this.flushBufferSize = i2;
                    return this;
                }
                throw new IllegalArgumentException("Value must be positive!");
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setHeaderMapFields(Map<String, List<String>> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, map)) == null) {
                this.headerMapFields = map;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMinIntervalMillisCallbackProcess(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.minIntervalMillisCallbackProcess = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setPassIfAlreadyCompleted(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.passIfAlreadyCompleted = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setPreAllocateLength(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.isPreAllocateLength = Boolean.valueOf(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setPriority(PriorityStrategy.Priority priority) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, priority)) == null) {
                this.priority = priority;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setReadBufferSize(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                if (i2 >= 0) {
                    this.readBufferSize = i2;
                    return this;
                }
                throw new IllegalArgumentException("Value must be positive!");
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSyncBufferIntervalMillis(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                if (i2 >= 0) {
                    this.syncBufferIntervalMillis = i2;
                    return this;
                }
                throw new IllegalArgumentException("Value must be positive!");
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSyncBufferSize(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                if (i2 >= 0) {
                    this.syncBufferSize = i2;
                    return this;
                }
                throw new IllegalArgumentException("Value must be positive!");
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setWifiRequired(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
                this.isWifiRequired = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder(@NonNull String str, @NonNull File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, file};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.priority = PriorityStrategy.Priority.DEFAULT;
            this.readBufferSize = 4096;
            this.flushBufferSize = 16384;
            this.syncBufferSize = 65536;
            this.syncBufferIntervalMillis = 2000;
            this.autoCallbackToUIThread = true;
            this.minIntervalMillisCallbackProcess = 3000;
            this.passIfAlreadyCompleted = true;
            this.isWifiRequired = false;
            this.url = str;
            this.uri = Uri.fromFile(file);
        }

        public Builder(@NonNull String str, @NonNull Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.priority = PriorityStrategy.Priority.DEFAULT;
            this.readBufferSize = 4096;
            this.flushBufferSize = 16384;
            this.syncBufferSize = 65536;
            this.syncBufferIntervalMillis = 2000;
            this.autoCallbackToUIThread = true;
            this.minIntervalMillisCallbackProcess = 3000;
            this.passIfAlreadyCompleted = true;
            this.isWifiRequired = false;
            this.url = str;
            this.uri = uri;
            if (Util.isUriContentScheme(uri)) {
                this.filename = Util.getFilenameFromContentUri(uri);
            }
        }
    }

    public void enqueue(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadListener) == null) {
            this.listener = downloadListener;
            BdDownload.with().downloadDispatcher().enqueue(this);
        }
    }

    public synchronized void removeTag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            synchronized (this) {
                this.tag = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class MockTaskForCompare extends IdentifiedTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final String filename;
        public final int id;
        @NonNull
        public final File parentFile;
        @NonNull
        public final File providedPathFile;
        @NonNull
        public final String url;

        public MockTaskForCompare(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.id = i2;
            this.url = "";
            File file = IdentifiedTask.EMPTY_FILE;
            this.providedPathFile = file;
            this.filename = null;
            this.parentFile = file;
        }

        @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
        @Nullable
        public String getFilename() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.filename : (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
        public int getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.id : invokeV.intValue;
        }

        @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
        @NonNull
        public File getParentFile() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.parentFile : (File) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
        @NonNull
        public File getProvidedPathFile() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.providedPathFile : (File) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.bddownload.core.IdentifiedTask
        @NonNull
        public String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.url : (String) invokeV.objValue;
        }

        public MockTaskForCompare(int i2, @NonNull DownloadTask downloadTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), downloadTask};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.id = i2;
            this.url = downloadTask.url;
            this.parentFile = downloadTask.getParentFile();
            this.providedPathFile = downloadTask.providedPathFile;
            this.filename = downloadTask.getFilename();
        }
    }

    public Builder toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? toBuilder(this.url, this.uri) : (Builder) invokeV.objValue;
    }
}
