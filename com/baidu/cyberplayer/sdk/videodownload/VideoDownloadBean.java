package com.baidu.cyberplayer.sdk.videodownload;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes4.dex */
public class VideoDownloadBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String createTimestamp;
    public String errorMessage;
    public String httpStatusCode;
    public String md5;
    public String mimeType;
    public String passthroughJsonStr;
    public String playUrl;
    public int progress;
    public long receivedBytes;
    public int speed;
    public int status;
    public String taskId;
    public long totalBytes;
    public String url;

    public VideoDownloadBean() {
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
