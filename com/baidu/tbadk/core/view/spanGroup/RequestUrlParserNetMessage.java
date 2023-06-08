package com.baidu.tbadk.core.view.spanGroup;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.ww5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.UrlParser.DataReq;
import tbclient.UrlParser.UrlParserReqIdl;
/* loaded from: classes4.dex */
public class RequestUrlParserNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mForumId;
    public int mLinkNum;
    public int mSpanGroupId;
    public String mUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestUrlParserNetMessage() {
        super(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSpanGroupId = 0;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.forum_id = Long.valueOf(this.mForumId);
            builder.url = this.mUrl;
            builder.link_num = Integer.valueOf(this.mLinkNum);
            ww5.a(builder, true);
            UrlParserReqIdl.Builder builder2 = new UrlParserReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mForumId;
        }
        return invokeV.longValue;
    }

    public int getLinkNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mLinkNum;
        }
        return invokeV.intValue;
    }

    public int getSpanGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mSpanGroupId;
        }
        return invokeV.intValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mUrl;
        }
        return (String) invokeV.objValue;
    }

    public void setParams(long j, int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            this.mForumId = j;
            this.mLinkNum = i;
            this.mUrl = str;
            this.mSpanGroupId = i2;
        }
    }
}
