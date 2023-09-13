package com.baidu.download;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.boxdownload.IBoxDownloadListener;
import com.baidu.searchbox.download.callback.IDownloadListener;
import com.baidu.searchbox.download.model.StopStatus;
import com.baidu.tieba.y10;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BoxDownloadManagerImpl$2 implements IDownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ y10 this$0;
    public final /* synthetic */ IBoxDownloadListener val$downloadListener;

    @Override // com.baidu.searchbox.download.callback.IDownloadListener
    public void onProgressChanged(Uri uri, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, uri, i) == null) {
        }
    }

    public BoxDownloadManagerImpl$2(y10 y10Var, IBoxDownloadListener iBoxDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y10Var, iBoxDownloadListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = y10Var;
        this.val$downloadListener = iBoxDownloadListener;
    }

    @Override // com.baidu.searchbox.download.callback.IDownloadListener
    public void onPause(Uri uri, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, uri, i) == null) {
            this.val$downloadListener.onPause(uri, i);
        }
    }

    @Override // com.baidu.searchbox.download.callback.IDownloadListener
    public void onProgress(Uri uri, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{uri, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.val$downloadListener.onProgress(uri, j, j2);
        }
    }

    @Override // com.baidu.searchbox.download.callback.IDownloadListener
    public void onStopped(StopStatus stopStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, stopStatus) == null) {
            this.val$downloadListener.onStopped();
        }
    }

    @Override // com.baidu.searchbox.download.callback.IDownloadListener
    public void onSuccess(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uri) == null) {
            this.val$downloadListener.onSuccess(uri);
        }
    }
}
