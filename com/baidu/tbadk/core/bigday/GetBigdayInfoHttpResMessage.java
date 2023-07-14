package com.baidu.tbadk.core.bigday;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.m15;
import com.baidu.tieba.o55;
import com.baidu.tieba.ye;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.Error;
import tbclient.GetBigday.BigdayInfo;
import tbclient.GetBigday.DataRes;
import tbclient.GetBigday.GetBigdayResIdl;
/* loaded from: classes4.dex */
public class GetBigdayInfoHttpResMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<m15> bigdayInfos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetBigdayInfoHttpResMessage() {
        super(CmdConfigHttp.CMD_GET_BIGDAY_INFO);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.afterDispatchInBackGround(i, (int) bArr);
            if (bArr == null) {
                return;
            }
            o55.e();
            ye<byte[]> c = o55.c("tb.bigday_datas");
            c.remove("tb.bigday_datas");
            c.g("tb.bigday_datas", bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetBigdayResIdl getBigdayResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) && (getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class)) != null) {
            Error error = getBigdayResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getBigdayResIdl.error.errmsg);
            }
            DataRes dataRes = getBigdayResIdl.data;
            if (dataRes != null && dataRes.bigday_list != null) {
                this.bigdayInfos = new ArrayList<>();
                for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                    if (bigdayInfo != null) {
                        m15 m15Var = new m15();
                        m15Var.b(bigdayInfo);
                        if (m15Var.a()) {
                            this.bigdayInfos.add(m15Var);
                        }
                    }
                }
            }
        }
    }
}
