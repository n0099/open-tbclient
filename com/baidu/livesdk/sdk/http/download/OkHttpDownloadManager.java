package com.baidu.livesdk.sdk.http.download;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.http.HttpRequestEntity;
import com.baidu.livesdk.api.http.download.DownloadEntity;
import com.baidu.livesdk.api.http.download.DownloadManager;
import com.baidu.livesdk.api.http.download.Downloader;
import com.baidu.livesdk.sdk.http.OkHttpRequestManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class OkHttpDownloadManager extends OkHttpRequestManager implements DownloadManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OkHttpDownloadManager() {
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

    @Override // com.baidu.livesdk.api.http.download.DownloadManager
    public Downloader getLoader(DownloadEntity downloadEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadEntity)) == null) ? getRequest((HttpRequestEntity) downloadEntity) : (Downloader) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.livesdk.sdk.http.OkHttpRequestManager
    public OkHttpDownloader createRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new OkHttpDownloader() : (OkHttpDownloader) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.livesdk.sdk.http.OkHttpRequestManager, com.baidu.livesdk.api.http.HttpRequestManager
    public OkHttpDownloader getRequest(HttpRequestEntity httpRequestEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, httpRequestEntity)) == null) ? (OkHttpDownloader) super.getRequest(httpRequestEntity) : (OkHttpDownloader) invokeL.objValue;
    }
}
