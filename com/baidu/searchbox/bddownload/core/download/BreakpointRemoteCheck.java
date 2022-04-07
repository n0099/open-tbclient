package com.baidu.searchbox.bddownload.core.download;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.exception.DownloadSecurityException;
import com.baidu.searchbox.bddownload.core.exception.FileBusyAfterRunException;
import com.baidu.searchbox.bddownload.core.exception.ServerCanceledException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes2.dex */
public class BreakpointRemoteCheck {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean acceptRange;
    public ResumeFailedCause failedCause;
    @NonNull
    public final BreakpointInfo info;
    public long instanceLength;
    public boolean resumable;
    @NonNull
    public final DownloadTask task;

    public BreakpointRemoteCheck(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadTask, breakpointInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.task = downloadTask;
        this.info = breakpointInfo;
    }

    public void check() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!Util.isInvalidUrl(this.task.getUrl())) {
                DownloadStrategy downloadStrategy = BdDownload.with().downloadStrategy();
                ConnectTrial createConnectTrial = createConnectTrial();
                createConnectTrial.executeTrial();
                boolean isAcceptRange = createConnectTrial.isAcceptRange();
                boolean isChunked = createConnectTrial.isChunked();
                long instanceLength = createConnectTrial.getInstanceLength();
                String responseEtag = createConnectTrial.getResponseEtag();
                String responseFilename = createConnectTrial.getResponseFilename();
                int responseCode = createConnectTrial.getResponseCode();
                String responseContentType = createConnectTrial.getResponseContentType();
                downloadStrategy.validFilenameFromResponse(responseFilename, this.task, this.info);
                this.info.setChunked(isChunked);
                this.info.setEtag(responseEtag);
                this.info.setMimeType(responseContentType);
                if (!BdDownload.with().downloadDispatcher().isFileConflictAfterRun(this.task)) {
                    ResumeFailedCause preconditionFailedCause = downloadStrategy.getPreconditionFailedCause(responseCode, this.info.getTotalOffset() != 0, this.info, responseEtag);
                    boolean z = preconditionFailedCause == null;
                    this.resumable = z;
                    this.failedCause = preconditionFailedCause;
                    this.instanceLength = instanceLength;
                    this.acceptRange = isAcceptRange;
                    if (isTrialSpecialPass(responseCode, instanceLength, z)) {
                        return;
                    }
                    if (downloadStrategy.isServerCanceled(responseCode, this.info.getTotalOffset() != 0)) {
                        throw new ServerCanceledException(responseCode, this.info.getTotalOffset());
                    }
                    return;
                }
                throw FileBusyAfterRunException.SIGNAL;
            }
            throw new DownloadSecurityException("java.lang.IllegalArgumentException: Expected URL scheme 'http' or 'https' but no colon was found");
        }
    }

    public ConnectTrial createConnectTrial() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new ConnectTrial(this.task, this.info) : (ConnectTrial) invokeV.objValue;
    }

    @Nullable
    public ResumeFailedCause getCause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.failedCause : (ResumeFailedCause) invokeV.objValue;
    }

    @NonNull
    public ResumeFailedCause getCauseOrThrow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ResumeFailedCause resumeFailedCause = this.failedCause;
            if (resumeFailedCause != null) {
                return resumeFailedCause;
            }
            throw new IllegalStateException("No cause find with resumable: " + this.resumable);
        }
        return (ResumeFailedCause) invokeV.objValue;
    }

    public long getInstanceLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.instanceLength : invokeV.longValue;
    }

    public boolean isAcceptRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.acceptRange : invokeV.booleanValue;
    }

    public boolean isResumable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.resumable : invokeV.booleanValue;
    }

    public boolean isTrialSpecialPass(int i, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)})) == null) ? i == 416 && j >= 0 && z : invokeCommon.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "acceptRange[" + this.acceptRange + "] resumable[" + this.resumable + "] failedCause[" + this.failedCause + "] instanceLength[" + this.instanceLength + "] " + super.toString();
        }
        return (String) invokeV.objValue;
    }
}
