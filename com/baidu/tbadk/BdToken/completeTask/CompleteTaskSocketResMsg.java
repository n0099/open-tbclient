package com.baidu.tbadk.BdToken.completeTask;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rj4;
import com.squareup.wire.Wire;
import tbclient.CompleteTask.CompleteTaskResIdl;
import tbclient.CompleteTask.DataRes;
import tbclient.Error;
/* loaded from: classes2.dex */
public class CompleteTaskSocketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rj4 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompleteTaskSocketResMsg() {
        super(309627);
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

    public rj4 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData : (rj4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
            rj4 rj4Var = new rj4();
            this.mData = rj4Var;
            rj4Var.c = completeTaskResIdl.data.show_type.intValue();
            this.mData.d = completeTaskResIdl.data.ahead_type.intValue();
            rj4 rj4Var2 = this.mData;
            DataRes dataRes = completeTaskResIdl.data;
            rj4Var2.e = dataRes.message;
            rj4Var2.f = dataRes.btn_text;
            rj4Var2.g = dataRes.btn_confirm;
            rj4Var2.h = dataRes.btn_cancel;
            rj4Var2.i = dataRes.toast_duration.intValue();
            rj4 rj4Var3 = this.mData;
            DataRes dataRes2 = completeTaskResIdl.data;
            rj4Var3.j = dataRes2.img_url;
            rj4Var3.k = dataRes2.url;
            rj4Var3.l = dataRes2.schema;
            rj4Var3.m = dataRes2.token;
            rj4Var3.a = dataRes2.activity_id.intValue();
            this.mData.b = completeTaskResIdl.data.mission_id.intValue();
            rj4 rj4Var4 = this.mData;
            DataRes dataRes3 = completeTaskResIdl.data;
            rj4Var4.o = dataRes3.btn_color;
            rj4Var4.p = dataRes3.message_color;
            rj4Var4.q = dataRes3.btn_text_color;
            rj4Var4.r = dataRes3.interface_type.intValue();
            this.mData.n = completeTaskResIdl.data.opacity.doubleValue();
            this.mData.x = completeTaskResIdl.data.is_not_complete.intValue();
        }
    }
}
