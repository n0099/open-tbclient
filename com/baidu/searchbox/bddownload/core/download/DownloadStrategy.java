package com.baidu.searchbox.bddownload.core.download;

import android.net.ConnectivityManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.utils.Constants;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.exception.NetworkPolicyException;
import com.baidu.searchbox.bddownload.core.exception.ResumeFailedException;
import com.baidu.searchbox.bddownload.core.exception.ServerCanceledException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class DownloadStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long FOUR_CONNECTION_UPPER_LIMIT = 104857600;
    public static final long ONE_CONNECTION_UPPER_LIMIT = 1048576;
    public static final String TAG = "DownloadStrategy";
    public static final long THREE_CONNECTION_UPPER_LIMIT = 52428800;
    public static final Pattern TMP_FILE_NAME_PATTERN;
    public static final long TWO_CONNECTION_UPPER_LIMIT = 5242880;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean isHasAccessNetworkStatePermission;
    public ConnectivityManager manager;

    public boolean isServerCanceled(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i == 206 || i == 200) {
                return i == 200 && z;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public long reuseIdledSameInfoThresholdBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? Constants.TEST_SPEED_THRESHOLD_DEFAULT : invokeV.longValue;
    }

    /* loaded from: classes2.dex */
    public class FilenameHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile String filename;
        public final boolean filenameProvidedByConstruct;

        public FilenameHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.filenameProvidedByConstruct = false;
        }

        public String get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.filename;
            }
            return (String) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.filename == null) {
                    return 0;
                }
                return this.filename.hashCode();
            }
            return invokeV.intValue;
        }

        public boolean isFilenameProvidedByConstruct() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.filenameProvidedByConstruct;
            }
            return invokeV.booleanValue;
        }

        public FilenameHolder(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.filename = str;
            this.filenameProvidedByConstruct = true;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (super.equals(obj)) {
                    return true;
                }
                if (!(obj instanceof FilenameHolder)) {
                    return false;
                }
                if (this.filename == null) {
                    if (((FilenameHolder) obj).filename == null) {
                        return true;
                    }
                    return false;
                }
                return this.filename.equals(((FilenameHolder) obj).filename);
            }
            return invokeL.booleanValue;
        }

        public void set(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.filename = str;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class ResumeAvailableResponseCheck {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int blockIndex;
        public DownloadConnection.Connected connected;
        public BreakpointInfo info;

        public ResumeAvailableResponseCheck(DownloadConnection.Connected connected, int i, BreakpointInfo breakpointInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {connected, Integer.valueOf(i), breakpointInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.connected = connected;
            this.info = breakpointInfo;
            this.blockIndex = i;
        }

        public void inspect() throws IOException {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BlockInfo block = this.info.getBlock(this.blockIndex);
                int responseCode = this.connected.getResponseCode();
                String responseHeaderField = this.connected.getResponseHeaderField(Util.ETAG);
                DownloadStrategy downloadStrategy = BdDownload.with().downloadStrategy();
                boolean z2 = true;
                if (block.getCurrentOffset() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                ResumeFailedCause preconditionFailedCause = downloadStrategy.getPreconditionFailedCause(responseCode, z, this.info, responseHeaderField);
                if (preconditionFailedCause == null) {
                    DownloadStrategy downloadStrategy2 = BdDownload.with().downloadStrategy();
                    if (block.getCurrentOffset() == 0) {
                        z2 = false;
                    }
                    if (!downloadStrategy2.isServerCanceled(responseCode, z2)) {
                        return;
                    }
                    throw new ServerCanceledException(responseCode, block.getCurrentOffset());
                }
                throw new ResumeFailedException(preconditionFailedCause);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1825566402, "Lcom/baidu/searchbox/bddownload/core/download/DownloadStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1825566402, "Lcom/baidu/searchbox/bddownload/core/download/DownloadStrategy;");
                return;
            }
        }
        TMP_FILE_NAME_PATTERN = Pattern.compile(".*\\\\|/([^\\\\|/|?]*)\\??");
    }

    public DownloadStrategy() {
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
        this.isHasAccessNetworkStatePermission = null;
        this.manager = null;
    }

    public int determineBlockCount(DownloadTask downloadTask, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, downloadTask, j)) == null) {
            if (downloadTask.getSetConnectionCount() != null) {
                return downloadTask.getSetConnectionCount().intValue();
            }
            if (j < 5242880) {
                return 1;
            }
            if (j < 52428800) {
                return 2;
            }
            if (j < 104857600) {
                return 3;
            }
            return 4;
        }
        return invokeLJ.intValue;
    }

    public String determineFilename(String str, DownloadTask downloadTask) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, downloadTask)) == null) {
            if (Util.isEmpty(str)) {
                String url = downloadTask.getUrl();
                Matcher matcher = TMP_FILE_NAME_PATTERN.matcher(url);
                String str2 = null;
                while (matcher.find()) {
                    str2 = matcher.group(1);
                }
                if (Util.isEmpty(str2)) {
                    str2 = Util.md5(url);
                }
                if (str2 != null) {
                    return str2;
                }
                throw new IOException("Can't find valid filename.");
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public ResumeFailedCause getPreconditionFailedCause(int i, boolean z, BreakpointInfo breakpointInfo, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), breakpointInfo, str})) == null) {
            String etag = breakpointInfo.getEtag();
            if (i == 412) {
                return ResumeFailedCause.RESPONSE_PRECONDITION_FAILED;
            }
            if (!Util.isEmpty(etag) && !Util.isEmpty(str) && !str.equals(etag)) {
                return ResumeFailedCause.RESPONSE_ETAG_CHANGED;
            }
            if (i == 201 && z) {
                return ResumeFailedCause.RESPONSE_CREATED_RANGE_NOT_FROM_0;
            }
            if (i == 205 && z) {
                return ResumeFailedCause.RESPONSE_RESET_RANGE_NOT_FROM_0;
            }
            return null;
        }
        return (ResumeFailedCause) invokeCommon.objValue;
    }

    public boolean inspectAnotherSameInfo(DownloadTask downloadTask, BreakpointInfo breakpointInfo, long j) {
        InterceptResult invokeCommon;
        BreakpointStore breakpointStore;
        BreakpointInfo findAnotherInfoFromCompare;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{downloadTask, breakpointInfo, Long.valueOf(j)})) == null) {
            if (!downloadTask.isFilenameFromResponse() || (findAnotherInfoFromCompare = (breakpointStore = BdDownload.with().breakpointStore()).findAnotherInfoFromCompare(downloadTask, breakpointInfo)) == null) {
                return false;
            }
            breakpointStore.remove(findAnotherInfoFromCompare.getId());
            if (findAnotherInfoFromCompare.getTotalOffset() <= BdDownload.with().downloadStrategy().reuseIdledSameInfoThresholdBytes()) {
                return false;
            }
            if ((findAnotherInfoFromCompare.getEtag() != null && !findAnotherInfoFromCompare.getEtag().equals(breakpointInfo.getEtag())) || findAnotherInfoFromCompare.getTotalLength() != j || findAnotherInfoFromCompare.getFile() == null || !findAnotherInfoFromCompare.getFile().exists()) {
                return false;
            }
            breakpointInfo.reuseBlocks(findAnotherInfoFromCompare);
            Util.d(TAG, "Reuse another same info: " + breakpointInfo);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void inspectFilenameFromResume(String str, DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, downloadTask) == null) && Util.isEmpty(downloadTask.getFilename())) {
            downloadTask.getFilenameHolder().set(str);
        }
    }

    public void inspectNetworkAvailable() throws UnknownHostException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.isHasAccessNetworkStatePermission == null) {
                this.isHasAccessNetworkStatePermission = Boolean.valueOf(Util.checkPermission("android.permission.ACCESS_NETWORK_STATE"));
            }
            if (!this.isHasAccessNetworkStatePermission.booleanValue()) {
                return;
            }
            if (this.manager == null) {
                this.manager = (ConnectivityManager) BdDownload.with().context().getSystemService("connectivity");
            }
            if (Util.isNetworkAvailable(this.manager)) {
                return;
            }
            throw new UnknownHostException("network is not available!");
        }
    }

    public void inspectNetworkOnWifi(DownloadTask downloadTask) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadTask) == null) {
            if (this.isHasAccessNetworkStatePermission == null) {
                this.isHasAccessNetworkStatePermission = Boolean.valueOf(Util.checkPermission("android.permission.ACCESS_NETWORK_STATE"));
            }
            if (!downloadTask.isWifiRequired()) {
                return;
            }
            if (this.isHasAccessNetworkStatePermission.booleanValue()) {
                if (this.manager == null && BdDownload.with().context() != null) {
                    this.manager = (ConnectivityManager) BdDownload.with().context().getSystemService("connectivity");
                }
                if (!Util.isNetworkNotOnWifiType(this.manager)) {
                    return;
                }
                throw new NetworkPolicyException();
            }
            throw new IOException("required for access network state but don't have the permission of Manifest.permission.ACCESS_NETWORK_STATE, please declare this permission first on your AndroidManifest, so we can handle the case of downloading required wifi state.");
        }
    }

    public boolean isUseMultiBlock(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (!BdDownload.with().outputStreamFactory().supportSeek()) {
                return false;
            }
            return z;
        }
        return invokeZ.booleanValue;
    }

    public boolean validFilenameFromStore(DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, downloadTask)) == null) {
            String responseFilename = BdDownload.with().breakpointStore().getResponseFilename(downloadTask.getUrl());
            if (responseFilename == null) {
                return false;
            }
            downloadTask.getFilenameHolder().set(responseFilename);
            return true;
        }
        return invokeL.booleanValue;
    }

    public ResumeAvailableResponseCheck resumeAvailableResponseCheck(DownloadConnection.Connected connected, int i, BreakpointInfo breakpointInfo) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048585, this, connected, i, breakpointInfo)) == null) {
            return new ResumeAvailableResponseCheck(connected, i, breakpointInfo);
        }
        return (ResumeAvailableResponseCheck) invokeLIL.objValue;
    }

    public synchronized void validFilenameFromResponse(String str, DownloadTask downloadTask, BreakpointInfo breakpointInfo) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, downloadTask, breakpointInfo) == null) {
            synchronized (this) {
                if (Util.isEmpty(downloadTask.getFilename())) {
                    String determineFilename = determineFilename(str, downloadTask);
                    if (Util.isEmpty(downloadTask.getFilename()) && Util.isEmpty(downloadTask.getFilename())) {
                        downloadTask.getFilenameHolder().set(determineFilename);
                        breakpointInfo.getFilenameHolder().set(determineFilename);
                    }
                }
            }
        }
    }

    public void validInfoOnCompleted(DownloadTask downloadTask, DownloadStore downloadStore) {
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, downloadTask, downloadStore) == null) {
            BreakpointInfo afterCompleted = downloadStore.getAfterCompleted(downloadTask.getId());
            if (afterCompleted == null) {
                afterCompleted = new BreakpointInfo(downloadTask.getId(), downloadTask.getUrl(), downloadTask.getParentFile(), downloadTask.getFilename());
                if (Util.isUriContentScheme(downloadTask.getUri())) {
                    length = Util.getSizeFromContentUri(downloadTask.getUri());
                } else {
                    File file = downloadTask.getFile();
                    if (file == null) {
                        length = 0;
                        Util.w(TAG, "file is not ready on valid info for task on complete state " + downloadTask);
                    } else {
                        length = file.length();
                    }
                }
                long j = length;
                afterCompleted.addBlock(new BlockInfo(0L, j, j));
            }
            DownloadTask.TaskHideWrapper.setBreakpointInfo(downloadTask, afterCompleted);
        }
    }
}
