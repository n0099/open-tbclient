package com.baidu.tbadk.core.bigday;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import com.repackage.jn4;
import com.repackage.te;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.Error;
import tbclient.GetBigday.BigdayInfo;
import tbclient.GetBigday.DataRes;
import tbclient.GetBigday.GetBigdayResIdl;
/* loaded from: classes3.dex */
public class GetBigdayInfoHttpResMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<jn4> bigdayInfos;

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
            cr4.f();
            te<byte[]> d = cr4.d("tb.bigday_datas");
            d.remove("tb.bigday_datas");
            d.g("tb.bigday_datas", bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetBigdayResIdl getBigdayResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) || (getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class)) == null) {
            return;
        }
        Error error = getBigdayResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getBigdayResIdl.error.errmsg);
        }
        DataRes dataRes = getBigdayResIdl.data;
        if (dataRes == null || dataRes.bigday_list == null) {
            return;
        }
        this.bigdayInfos = new ArrayList<>();
        for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
            if (bigdayInfo != null) {
                jn4 jn4Var = new jn4();
                jn4Var.b(bigdayInfo);
                if (jn4Var.a()) {
                    this.bigdayInfos.add(jn4Var);
                }
            }
        }
    }
}
