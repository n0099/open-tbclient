package com.baidu.searchbox.bddownload.core.file;

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
/* loaded from: classes2.dex */
public class ProcessFileStrategy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FileLock fileLock;

    public void completeProcessStream(MultiPointOutputStream multiPointOutputStream, DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, multiPointOutputStream, downloadTask) == null) {
        }
    }

    public ProcessFileStrategy() {
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
        this.fileLock = new FileLock();
    }

    public FileLock getFileLock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.fileLock;
        }
        return (FileLock) invokeV.objValue;
    }

    public MultiPointOutputStream createProcessStream(DownloadTask downloadTask, BreakpointInfo breakpointInfo, DownloadStore downloadStore) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask, breakpointInfo, downloadStore)) == null) {
            return new MultiPointOutputStream(downloadTask, breakpointInfo, downloadStore);
        }
        return (MultiPointOutputStream) invokeLLL.objValue;
    }

    public void discardProcess(DownloadTask downloadTask) throws IOException {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadTask) == null) && (file = downloadTask.getFile()) != null && file.exists() && !file.delete()) {
            throw new IOException("Delete file failed!");
        }
    }

    public boolean isPreAllocateLength(DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadTask)) == null) {
            if (!BdDownload.with().outputStreamFactory().supportSeek()) {
                return false;
            }
            if (downloadTask.getSetPreAllocateLength() != null) {
                return downloadTask.getSetPreAllocateLength().booleanValue();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
