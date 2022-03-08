package com.baidu.searchbox.bddownload.core.file;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
/* loaded from: classes4.dex */
public class ProcessFileStrategy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FileLock fileLock;

    public ProcessFileStrategy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fileLock = new FileLock();
    }

    public void completeProcessStream(@NonNull MultiPointOutputStream multiPointOutputStream, @NonNull DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, multiPointOutputStream, downloadTask) == null) {
        }
    }

    @NonNull
    public MultiPointOutputStream createProcessStream(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull DownloadStore downloadStore) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask, breakpointInfo, downloadStore)) == null) ? new MultiPointOutputStream(downloadTask, breakpointInfo, downloadStore) : (MultiPointOutputStream) invokeLLL.objValue;
    }

    public void discardProcess(@NonNull DownloadTask downloadTask) throws IOException {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadTask) == null) && (file = downloadTask.getFile()) != null && file.exists() && !file.delete()) {
            throw new IOException("Delete file failed!");
        }
    }

    @NonNull
    public FileLock getFileLock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.fileLock : (FileLock) invokeV.objValue;
    }

    public boolean isPreAllocateLength(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadTask)) == null) {
            if (BdDownload.with().outputStreamFactory().supportSeek()) {
                if (downloadTask.getSetPreAllocateLength() != null) {
                    return downloadTask.getSetPreAllocateLength().booleanValue();
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
