package com.baidu.searchbox.bddownload.core.download;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class BreakpointLocalCheck {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean dirty;
    public boolean fileExist;
    public final BreakpointInfo info;
    public boolean infoRight;
    public boolean outputStreamSupport;
    public final long responseInstanceLength;
    public final DownloadTask task;

    public BreakpointLocalCheck(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadTask, breakpointInfo, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.task = downloadTask;
        this.info = breakpointInfo;
        this.responseInstanceLength = j;
    }

    public void check() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.fileExist = isFileExistToResume();
            this.infoRight = isInfoRightToResume();
            boolean isOutputStreamSupportResume = isOutputStreamSupportResume();
            this.outputStreamSupport = isOutputStreamSupportResume;
            this.dirty = (this.infoRight && this.fileExist && isOutputStreamSupportResume) ? false : true;
        }
    }

    @NonNull
    public ResumeFailedCause getCauseOrThrow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!this.infoRight) {
                return ResumeFailedCause.INFO_DIRTY;
            }
            if (!this.fileExist) {
                return ResumeFailedCause.FILE_NOT_EXIST;
            }
            if (!this.outputStreamSupport) {
                return ResumeFailedCause.OUTPUT_STREAM_NOT_SUPPORT;
            }
            throw new IllegalStateException("No cause find with dirty: " + this.dirty);
        }
        return (ResumeFailedCause) invokeV.objValue;
    }

    public boolean isDirty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.dirty : invokeV.booleanValue;
    }

    public boolean isFileExistToResume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Uri uri = this.task.getUri();
            if (Util.isUriContentScheme(uri)) {
                return Util.getSizeFromContentUri(uri) > 0;
            }
            File file = this.task.getFile();
            return file != null && file.exists();
        }
        return invokeV.booleanValue;
    }

    public boolean isInfoRightToResume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int blockCount = this.info.getBlockCount();
            if (blockCount <= 0 || this.info.isChunked() || this.info.getFile() == null) {
                return false;
            }
            if (this.info.getFile().equals(this.task.getFile()) && this.info.getFile().length() <= this.info.getTotalLength()) {
                if (this.responseInstanceLength <= 0 || this.info.getTotalLength() == this.responseInstanceLength) {
                    for (int i2 = 0; i2 < blockCount; i2++) {
                        if (this.info.getBlock(i2).getContentLength() <= 0) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isOutputStreamSupportResume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (BdDownload.with().outputStreamFactory().supportSeek()) {
                return true;
            }
            return this.info.getBlockCount() == 1 && !BdDownload.with().processFileStrategy().isPreAllocateLength(this.task);
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "fileExist[" + this.fileExist + "] infoRight[" + this.infoRight + "] outputStreamSupport[" + this.outputStreamSupport + "] " + super.toString();
        }
        return (String) invokeV.objValue;
    }
}
