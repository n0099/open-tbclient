package com.baidu.ala.liveroom.messages;

import alaim.AlaMgetLiveStatus.AlaMgetLiveStatusReqIdl;
import alaim.AlaMgetLiveStatus.DataReq;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.h0.z0.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class AlaMGetLiveStatusRequestMessage extends NetMessage {
    public long mAudienceCount;
    public List<Long> mIds;
    public List<Object> mOriginDatas;

    public AlaMGetLiveStatusRequestMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2);
        this.mOriginDatas = new ArrayList();
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.live_ids = this.mIds;
        builder.audience_count = Long.valueOf(this.mAudienceCount);
        if (z) {
            w.a(builder, true);
        }
        AlaMgetLiveStatusReqIdl.Builder builder2 = new AlaMgetLiveStatusReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public List<Object> getOrignData() {
        return this.mOriginDatas;
    }

    public void setAudienceCount(long j) {
        this.mAudienceCount = j;
    }

    public void setListIds(List<Long> list) {
        this.mIds = list;
    }

    public void setOriginData(List<Object> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.mOriginDatas.clear();
        this.mOriginDatas.addAll(list);
    }
}
