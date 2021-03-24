package com.baidu.tbadk.core.bigday;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import d.b.b.e.d.l;
import d.b.h0.r.n.a;
import java.util.ArrayList;
import tbclient.Error;
import tbclient.GetBigday.BigdayInfo;
import tbclient.GetBigday.DataRes;
import tbclient.GetBigday.GetBigdayResIdl;
/* loaded from: classes3.dex */
public class GetBigdayInfoHttpResMessage extends HttpResponsedMessage {
    public ArrayList<a> bigdayInfos;

    public GetBigdayInfoHttpResMessage() {
        super(CmdConfigHttp.CMD_GET_BIGDAY_INFO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
        if (bArr == null) {
            return;
        }
        l<byte[]> d2 = d.b.h0.r.r.a.f().d("tb.bigday_datas");
        d2.remove("tb.bigday_datas");
        d2.g("tb.bigday_datas", bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
        if (getBigdayResIdl != null) {
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
}
