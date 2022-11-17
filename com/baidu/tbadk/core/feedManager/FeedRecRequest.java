package com.baidu.tbadk.core.feedManager;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.feedManager.PersonalizedReqIdl;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tieba.dj5;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.DataReq;
/* loaded from: classes3.dex */
public class FeedRecRequest extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int loadType;
    public int needForumlist;
    public int pn;
    public int preAdThreadCount;
    public int requestTime;
    public String sourceFrom;
    public int suggestCount;
    public int threadCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedRecRequest() {
        super(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
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
        this.requestTime = 0;
        this.sourceFrom = "";
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            int i = 1;
            dj5.c(builder, true, false, true);
            builder.need_tags = 0;
            builder.load_type = Integer.valueOf(this.loadType);
            builder.page_thread_count = Integer.valueOf(this.threadCount);
            builder.pre_ad_thread_count = Integer.valueOf(this.preAdThreadCount);
            builder.pn = Integer.valueOf(this.pn);
            builder.sug_count = Integer.valueOf(this.suggestCount);
            builder.tag_code = 0;
            builder.scr_w = Integer.valueOf(yi.l(TbadkCoreApplication.getInst()));
            builder.scr_h = Integer.valueOf(yi.j(TbadkCoreApplication.getInst()));
            builder.scr_dip = Double.valueOf(yi.i(TbadkCoreApplication.getInst()));
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i = 2;
            }
            builder.q_type = Integer.valueOf(i);
            builder.need_forumlist = Integer.valueOf(this.needForumlist);
            builder.new_net_type = Integer.valueOf(BdNetTypeUtil.netType());
            builder.new_install = Integer.valueOf(TbadkCoreApplication.getInst().checkNewUser() ? 1 : 0);
            builder.request_times = Integer.valueOf(this.requestTime);
            builder.invoke_source = this.sourceFrom;
            PersonalizedReqIdl.Builder builder2 = new PersonalizedReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public int getLoadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.loadType;
        }
        return invokeV.intValue;
    }

    public int getNeedForumlist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.needForumlist;
        }
        return invokeV.intValue;
    }

    public void setLoadType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.loadType = i;
        }
    }

    public void setNeedForumlist(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i != 1) {
                this.needForumlist = 0;
            } else {
                this.needForumlist = i;
            }
        }
    }

    public void setPn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.pn = i;
        }
    }

    public void setPreAdThreadCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.preAdThreadCount = i;
        }
    }

    public void setRequestTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.requestTime = i;
        }
    }

    public void setSourceFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.sourceFrom = str;
        }
    }

    public void setSuggestCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.suggestCount = i;
        }
    }

    public void setThreadCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (i > 0) {
                this.threadCount = i;
            } else {
                this.threadCount = 0;
            }
        }
    }
}
