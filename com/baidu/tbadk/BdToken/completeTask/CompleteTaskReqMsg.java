package com.baidu.tbadk.BdToken.completeTask;

import android.util.Base64;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.af5;
import com.baidu.tieba.yf5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CompleteTask.CompleteTaskReqIdl;
import tbclient.CompleteTask.DataReq;
/* loaded from: classes3.dex */
public class CompleteTaskReqMsg extends NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TASK_TYPE_DEFAULT = 0;
    public static final int TASK_TYPE_SHARE = 2;
    public static final int TASK_TYPE_TIMER = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String completeId;
    public Object extra;
    public int mTaskType;
    public String mToken;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompleteTaskReqMsg(int i) {
        super(CmdConfigHttp.CMD_COMPLETE_TASK, 309627);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTaskType = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            if (z) {
                try {
                    getHttpMessage().setUserAgent(yf5.e());
                } catch (Exception unused) {
                    return null;
                }
            }
            DataReq.Builder builder = new DataReq.Builder();
            builder.shoubaicuid = TbadkCoreApplication.getInst().getCuidGalaxy2();
            if (this.completeId != null) {
                builder.compelete_id = Base64.encodeToString(this.completeId.getBytes(), 2);
            }
            if (this.mToken != null) {
                builder.token = Base64.encodeToString(this.mToken.getBytes(), 2);
            }
            af5.c(builder, true, true, false);
            CompleteTaskReqIdl.Builder builder2 = new CompleteTaskReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public int getTaskType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTaskType : invokeV.intValue;
    }

    public void setToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.mToken = str;
        }
    }
}
