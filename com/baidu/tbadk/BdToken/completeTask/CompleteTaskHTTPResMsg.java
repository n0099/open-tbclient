package com.baidu.tbadk.BdToken.completeTask;

import c.a.p0.a.d0.a;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.CompleteTask.CompleteTaskResIdl;
import tbclient.CompleteTask.DataRes;
import tbclient.Error;
/* loaded from: classes6.dex */
public class CompleteTaskHTTPResMsg extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompleteTaskHTTPResMsg() {
        super(CmdConfigHttp.CMD_COMPLETE_TASK);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        CompleteTaskResIdl completeTaskResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (completeTaskResIdl = (CompleteTaskResIdl) new Wire(new Class[0]).parseFrom(bArr, CompleteTaskResIdl.class)) == null) {
            return;
        }
        Error error = completeTaskResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(completeTaskResIdl.error.usermsg);
        }
        if (completeTaskResIdl.data != null) {
            a aVar = new a();
            this.mData = aVar;
            aVar.f12547c = completeTaskResIdl.data.show_type.intValue();
            this.mData.f12548d = completeTaskResIdl.data.ahead_type.intValue();
            a aVar2 = this.mData;
            DataRes dataRes = completeTaskResIdl.data;
            aVar2.f12549e = dataRes.message;
            aVar2.f12550f = dataRes.btn_text;
            aVar2.f12551g = dataRes.btn_confirm;
            aVar2.f12552h = dataRes.btn_cancel;
            aVar2.f12553i = dataRes.toast_duration.intValue();
            a aVar3 = this.mData;
            DataRes dataRes2 = completeTaskResIdl.data;
            aVar3.f12554j = dataRes2.img_url;
            aVar3.k = dataRes2.url;
            aVar3.l = dataRes2.schema;
            aVar3.m = dataRes2.token;
            aVar3.f12545a = dataRes2.activity_id.intValue();
            this.mData.f12546b = completeTaskResIdl.data.mission_id.intValue();
            a aVar4 = this.mData;
            DataRes dataRes3 = completeTaskResIdl.data;
            aVar4.o = dataRes3.btn_color;
            aVar4.p = dataRes3.message_color;
            aVar4.q = dataRes3.btn_text_color;
            aVar4.r = dataRes3.interface_type.intValue();
            this.mData.n = completeTaskResIdl.data.opacity.doubleValue();
            this.mData.x = completeTaskResIdl.data.is_not_complete.intValue();
        }
    }
}
