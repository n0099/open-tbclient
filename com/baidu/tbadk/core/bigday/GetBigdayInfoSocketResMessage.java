package com.baidu.tbadk.core.bigday;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import d.a.r0.r.n.a;
import java.util.ArrayList;
import tbclient.Error;
import tbclient.GetBigday.BigdayInfo;
import tbclient.GetBigday.DataRes;
import tbclient.GetBigday.GetBigdayResIdl;
/* loaded from: classes4.dex */
public class GetBigdayInfoSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<a> bigdayInfos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetBigdayInfoSocketResMessage() {
        super(309609);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            super.afterDispatchInBackGround(i2, (int) bArr);
            if (bArr == null) {
                return;
            }
            l<byte[]> d2 = d.a.r0.r.r.a.f().d("tb.bigday_datas");
            d2.remove("tb.bigday_datas");
            d2.g("tb.bigday_datas", bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetBigdayResIdl getBigdayResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) || (getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class)) == null) {
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
                a aVar = new a();
                aVar.b(bigdayInfo);
                if (aVar.a()) {
                    this.bigdayInfos.add(aVar);
                }
            }
        }
    }
}
