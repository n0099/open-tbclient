package com.baidu.ala.liveroom.messages;

import alaim.AlaMgetLiveStatus.AlaMgetLiveStatusResIdl;
import alaim.AlaMgetLiveStatus.DataRes;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class AlaMGetLiveStatusHttpResponseMessage extends HttpResponsedMessage {
    public List<Long> mClosedIds;
    public long mInterval;

    public AlaMGetLiveStatusHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS);
    }

    public List<Long> getClosedIds() {
        return this.mClosedIds;
    }

    public long getInterval() {
        return this.mInterval;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        AlaMgetLiveStatusResIdl alaMgetLiveStatusResIdl = (AlaMgetLiveStatusResIdl) new Wire(new Class[0]).parseFrom(bArr, AlaMgetLiveStatusResIdl.class);
        setError(alaMgetLiveStatusResIdl.error.errorno.intValue());
        setErrorString(alaMgetLiveStatusResIdl.error.usermsg);
        if (getError() != 0 || (dataRes = alaMgetLiveStatusResIdl.data) == null || dataRes.close_live == null) {
            return;
        }
        this.mInterval = dataRes.interval.longValue();
        this.mClosedIds = new ArrayList(alaMgetLiveStatusResIdl.data.close_live);
    }
}
