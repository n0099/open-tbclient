package com.baidu.ala.downloader;

import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class WrapDownloadData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ST_FILE_DOWNLOADED = 3;
    public static final int ST_FILE_DOWNLOAD_FAILED = 5;
    public static final int ST_FILE_PRE_DOWNLOAD = 1;
    public static final int ST_FILE_UNZIP_SUCC = 4;
    public static final int ST_FILE_UPDATE_PROGRESS = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadData data;
    public int status;

    public WrapDownloadData() {
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
}
