package com.baidu.tbadk.core.bigday;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.GetBigday.BigdayInfo;
import tbclient.GetBigday.GetBigdayResIdl;
/* loaded from: classes.dex */
public class GetBigdayInfoSocketResMessage extends SocketResponsedMessage {
    public ArrayList<a> bigdayInfos;

    public GetBigdayInfoSocketResMessage() {
        super(309609);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
        if (getBigdayResIdl != null) {
            if (getBigdayResIdl.error != null) {
                setError(getBigdayResIdl.error.errorno.intValue());
                setErrorString(getBigdayResIdl.error.errmsg);
            }
            if (getBigdayResIdl.data != null && getBigdayResIdl.data.bigday_list != null) {
                this.bigdayInfos = new ArrayList<>();
                for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                    if (bigdayInfo != null) {
                        a aVar = new a();
                        aVar.a(bigdayInfo);
                        if (aVar.azY()) {
                            this.bigdayInfos.add(aVar);
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
        if (bArr != null) {
            l<byte[]> sP = com.baidu.tbadk.core.c.a.aEF().sP("tb.bigday_datas");
            sP.remove("tb.bigday_datas");
            sP.setForever("tb.bigday_datas", bArr);
        }
    }
}
