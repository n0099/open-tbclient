package com.baidu.ala.liveroom.messages;

import alaim.AlaMgetLiveStatus.AlaMgetLiveStatusReqIdl;
import alaim.AlaMgetLiveStatus.DataReq;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaMGetLiveStatusRequestMessage extends NetMessage {
    private long mAudienceCount;
    private List<Long> mIds;
    private List<Object> mOriginDatas;

    public AlaMGetLiveStatusRequestMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2);
        this.mOriginDatas = new ArrayList();
    }

    public void setListIds(List<Long> list) {
        this.mIds = list;
    }

    public void setAudienceCount(long j) {
        this.mAudienceCount = j;
    }

    public void setOriginData(List<Object> list) {
        if (!v.isEmpty(list)) {
            this.mOriginDatas.clear();
            this.mOriginDatas.addAll(list);
        }
    }

    public List<Object> getOrignData() {
        return this.mOriginDatas;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.live_ids = this.mIds;
        builder.audience_count = Long.valueOf(this.mAudienceCount);
        if (z) {
            t.a(builder, true);
        }
        AlaMgetLiveStatusReqIdl.Builder builder2 = new AlaMgetLiveStatusReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
