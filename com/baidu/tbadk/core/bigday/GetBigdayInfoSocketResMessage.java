package com.baidu.tbadk.core.bigday;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.aw4;
import com.baidu.tieba.me;
import com.baidu.tieba.yz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.Error;
import tbclient.GetBigday.BigdayInfo;
import tbclient.GetBigday.DataRes;
import tbclient.GetBigday.GetBigdayResIdl;
/* loaded from: classes3.dex */
public class GetBigdayInfoSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<aw4> bigdayInfos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetBigdayInfoSocketResMessage() {
        super(309609);
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
            yz4.d();
            me<byte[]> b = yz4.b("tb.bigday_datas");
            b.remove("tb.bigday_datas");
            b.g("tb.bigday_datas", bArr);
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
            if (getBigdayResIdl != null) {
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
                            aw4 aw4Var = new aw4();
                            aw4Var.b(bigdayInfo);
                            if (aw4Var.a()) {
                                this.bigdayInfos.add(aw4Var);
                            }
                        }
                    }
                }
            }
            return getBigdayResIdl;
        }
        return invokeIL.objValue;
    }
}
