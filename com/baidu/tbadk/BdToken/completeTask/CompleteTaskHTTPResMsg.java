package com.baidu.tbadk.BdToken.completeTask;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pi4;
import com.squareup.wire.Wire;
import tbclient.CompleteTask.CompleteTaskResIdl;
import tbclient.CompleteTask.DataRes;
import tbclient.Error;
/* loaded from: classes2.dex */
public class CompleteTaskHTTPResMsg extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pi4 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompleteTaskHTTPResMsg() {
        super(CmdConfigHttp.CMD_COMPLETE_TASK);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public pi4 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData : (pi4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        CompleteTaskResIdl completeTaskResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (completeTaskResIdl = (CompleteTaskResIdl) new Wire(new Class[0]).parseFrom(bArr, CompleteTaskResIdl.class)) == null) {
            return;
        }
        Error error = completeTaskResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(completeTaskResIdl.error.usermsg);
        }
        if (completeTaskResIdl.data != null) {
            pi4 pi4Var = new pi4();
            this.mData = pi4Var;
            pi4Var.c = completeTaskResIdl.data.show_type.intValue();
            this.mData.d = completeTaskResIdl.data.ahead_type.intValue();
            pi4 pi4Var2 = this.mData;
            DataRes dataRes = completeTaskResIdl.data;
            pi4Var2.e = dataRes.message;
            pi4Var2.f = dataRes.btn_text;
            pi4Var2.g = dataRes.btn_confirm;
            pi4Var2.h = dataRes.btn_cancel;
            pi4Var2.i = dataRes.toast_duration.intValue();
            pi4 pi4Var3 = this.mData;
            DataRes dataRes2 = completeTaskResIdl.data;
            pi4Var3.j = dataRes2.img_url;
            pi4Var3.k = dataRes2.url;
            pi4Var3.l = dataRes2.schema;
            pi4Var3.m = dataRes2.token;
            pi4Var3.a = dataRes2.activity_id.intValue();
            this.mData.b = completeTaskResIdl.data.mission_id.intValue();
            pi4 pi4Var4 = this.mData;
            DataRes dataRes3 = completeTaskResIdl.data;
            pi4Var4.o = dataRes3.btn_color;
            pi4Var4.p = dataRes3.message_color;
            pi4Var4.q = dataRes3.btn_text_color;
            pi4Var4.r = dataRes3.interface_type.intValue();
            this.mData.n = completeTaskResIdl.data.opacity.doubleValue();
            this.mData.x = completeTaskResIdl.data.is_not_complete.intValue();
        }
    }
}
