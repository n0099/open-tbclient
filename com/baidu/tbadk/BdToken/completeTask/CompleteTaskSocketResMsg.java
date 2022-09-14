package com.baidu.tbadk.BdToken.completeTask;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.CompleteTask.CompleteTaskResIdl;
import tbclient.CompleteTask.DataRes;
import tbclient.Error;
/* loaded from: classes3.dex */
public class CompleteTaskSocketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hm4 mData;

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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            CompleteTaskResIdl completeTaskResIdl = (CompleteTaskResIdl) new Wire(new Class[0]).parseFrom(bArr, CompleteTaskResIdl.class);
            if (completeTaskResIdl != null) {
                Error error = completeTaskResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(completeTaskResIdl.error.usermsg);
                }
                if (completeTaskResIdl.data != null) {
                    hm4 hm4Var = new hm4();
                    this.mData = hm4Var;
                    hm4Var.c = completeTaskResIdl.data.show_type.intValue();
                    this.mData.d = completeTaskResIdl.data.ahead_type.intValue();
                    hm4 hm4Var2 = this.mData;
                    DataRes dataRes = completeTaskResIdl.data;
                    hm4Var2.e = dataRes.message;
                    hm4Var2.f = dataRes.btn_text;
                    hm4Var2.g = dataRes.btn_confirm;
                    hm4Var2.h = dataRes.btn_cancel;
                    hm4Var2.i = dataRes.toast_duration.intValue();
                    hm4 hm4Var3 = this.mData;
                    DataRes dataRes2 = completeTaskResIdl.data;
                    hm4Var3.j = dataRes2.img_url;
                    hm4Var3.k = dataRes2.url;
                    hm4Var3.l = dataRes2.schema;
                    hm4Var3.m = dataRes2.token;
                    hm4Var3.a = dataRes2.activity_id.intValue();
                    this.mData.b = completeTaskResIdl.data.mission_id.intValue();
                    hm4 hm4Var4 = this.mData;
                    DataRes dataRes3 = completeTaskResIdl.data;
                    hm4Var4.o = dataRes3.btn_color;
                    hm4Var4.p = dataRes3.message_color;
                    hm4Var4.q = dataRes3.btn_text_color;
                    hm4Var4.r = dataRes3.interface_type.intValue();
                    this.mData.n = completeTaskResIdl.data.opacity.doubleValue();
                    this.mData.x = completeTaskResIdl.data.is_not_complete.intValue();
                }
            }
            return completeTaskResIdl;
        }
        return invokeIL.objValue;
    }

    public hm4 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (hm4) invokeV.objValue;
    }
}
