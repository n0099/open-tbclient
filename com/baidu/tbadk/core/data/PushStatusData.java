package com.baidu.tbadk.core.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.PushStatus;
/* loaded from: classes.dex */
public class PushStatusData implements Serializable {
    public static final int STATUS_ALREADY_PUSH = 2;
    public static final int STATUS_NOT_PUSH = 1;
    private List<PushTypeData> mPushTypeDatas;
    private int mStatus;

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public List<PushTypeData> getPushTypeDatas() {
        return this.mPushTypeDatas;
    }

    public void parserProtobuf(PushStatus pushStatus) {
        if (pushStatus != null) {
            this.mStatus = pushStatus.status.intValue();
            this.mPushTypeDatas = new ArrayList();
            int size = pushStatus.types.size();
            for (int i = 0; i < size; i++) {
                PushTypeData pushTypeData = new PushTypeData();
                pushTypeData.parserProtobuf(pushStatus.types.get(i));
                this.mPushTypeDatas.add(pushTypeData);
            }
        }
    }
}
