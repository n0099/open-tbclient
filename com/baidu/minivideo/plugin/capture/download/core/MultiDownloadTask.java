package com.baidu.minivideo.plugin.capture.download.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.download.base.DownloadTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class MultiDownloadTask extends DownloadTaskImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public int getResponseCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 206;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public void insertIntoDB(ThreadRecord threadRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadRecord) == null) {
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public void updateDB(ThreadRecord threadRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, threadRecord) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiDownloadTask(DownloadInfo downloadInfo, ThreadRecord threadRecord, DownloadTask.OnDownloadListener onDownloadListener) {
        super(downloadInfo, threadRecord, onDownloadListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadInfo, threadRecord, onDownloadListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DownloadInfo) objArr2[0], (ThreadRecord) objArr2[1], (DownloadTask.OnDownloadListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public RandomAccessFile getFile(File file, String str, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{file, str, Long.valueOf(j)})) == null) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
            randomAccessFile.seek(j);
            return randomAccessFile;
        }
        return (RandomAccessFile) invokeCommon.objValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public Map getHttpHeaders(ThreadRecord threadRecord) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadRecord)) == null) {
            HashMap hashMap = new HashMap();
            long start = threadRecord.getStart() + threadRecord.getFinished();
            long end = threadRecord.getEnd();
            hashMap.put("Range", "bytes=" + start + "-" + end);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.core.DownloadTaskImpl
    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return MultiDownloadTask.class.getSimpleName();
        }
        return (String) invokeV.objValue;
    }
}
