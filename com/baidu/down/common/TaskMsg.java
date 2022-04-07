package com.baidu.down.common;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class TaskMsg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long _id;
    public DownDetail downDetail;
    public String errorStr;
    public String etag;
    public int failType;
    public String filePath;
    public long fileSize;
    public String progressMap;
    public int status;
    public String strRedownload;
    public boolean supportRange;
    public String thumnailpath;
    public long transferedSize;
    public long transferedSpeed;
    public String uKey;
    public String url;

    public TaskMsg() {
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
        this.failType = -1;
        this.url = "";
    }
}
