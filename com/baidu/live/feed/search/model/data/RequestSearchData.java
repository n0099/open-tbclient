package com.baidu.live.feed.search.model.data;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class RequestSearchData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String channelId;
    public String refreshIndex;
    public String refreshType;
    public String requestType;
    public String resource;
    public String sessionId;
    public String uploadIds;

    public RequestSearchData() {
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
        this.refreshIndex = "1";
        this.refreshType = "0";
        this.resource = "feed";
        this.channelId = "0";
        this.sessionId = "";
        this.uploadIds = "";
        this.requestType = "search";
    }

    public void setData(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, str2, str3, str4, str5) == null) {
            this.refreshIndex = str;
            this.refreshType = str2;
            this.sessionId = str3;
            this.uploadIds = str4;
            this.requestType = str5;
        }
    }
}
