package com.baidu.ala.liveroom.messages;

import alaim.AlaMgetLiveStatus.AlaMgetLiveStatusResIdl;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.ala.AlaCmdConfigSocket;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaMGetLiveStatusSocketResponseMessage extends SocketResponsedMessage {
    private List<Long> mCloseIds;
    private long mInterval;

    public AlaMGetLiveStatusSocketResponseMessage() {
        super(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2);
    }

    public List<Long> getClosedIds() {
        return this.mCloseIds;
    }

    public long getInterval() {
        return this.mInterval;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        AlaMgetLiveStatusResIdl alaMgetLiveStatusResIdl = (AlaMgetLiveStatusResIdl) new Wire(new Class[0]).parseFrom(bArr, AlaMgetLiveStatusResIdl.class);
        setError(alaMgetLiveStatusResIdl.error.errorno.intValue());
        setErrorString(alaMgetLiveStatusResIdl.error.usermsg);
        if (getError() == 0 && alaMgetLiveStatusResIdl.data != null && alaMgetLiveStatusResIdl.data.close_live != null) {
            this.mInterval = alaMgetLiveStatusResIdl.data.interval.longValue();
            this.mCloseIds = new ArrayList(alaMgetLiveStatusResIdl.data.close_live);
        }
    }
}
