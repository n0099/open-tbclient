package com.baidu.live.liveroom.messages;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private long mAudienceCount;
    private List<Long> mIds;
    private List<Object> mOriginDatas;

    public a() {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS);
        this.mOriginDatas = new ArrayList();
        this.mAudienceCount = 0L;
    }

    public void setListIds(List<Long> list) {
        this.mIds = list;
    }

    public void setAudienceCount(long j) {
        this.mAudienceCount = j;
    }

    public void setOriginData(List<Object> list) {
        if (!ListUtils.isEmpty(list)) {
            this.mOriginDatas.clear();
            this.mOriginDatas.addAll(list);
        }
    }

    public void setParams() {
        addParam("audience_count", this.mAudienceCount);
        if (this.mIds != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.mIds.size(); i++) {
                sb.append(this.mIds.get(i));
                if (i != this.mIds.size() - 1) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            addParam("live_ids", sb.toString());
        }
    }
}
