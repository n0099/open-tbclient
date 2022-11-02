package com.baidu.searchbox.v8engine.net;

import com.baidu.mobstat.Config;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@NotProguard
/* loaded from: classes2.dex */
public class NetRequestSettings {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mEnableEncodingInNetThread;
    public boolean mEnableEncodingUsingGURLLibrary;
    public boolean mLoadDoNotSendCookies;
    public boolean mShouldNeverClearReferer;
    public int mTimeout;
    public long mUploadDataLimit;

    public NetRequestSettings() {
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
        this.mTimeout = 60000;
        this.mUploadDataLimit = Config.FULL_TRACE_LOG_LIMIT;
        this.mLoadDoNotSendCookies = false;
        this.mShouldNeverClearReferer = false;
        this.mEnableEncodingInNetThread = false;
        this.mEnableEncodingUsingGURLLibrary = false;
    }
}
