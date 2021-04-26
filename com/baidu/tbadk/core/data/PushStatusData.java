package com.baidu.tbadk.core.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.PushStatus;
/* loaded from: classes3.dex */
public class PushStatusData implements Serializable {
    public static final int STATUS_ALREADY_PUSH = 2;
    public static final int STATUS_NOT_PUSH = 1;
    public List<PushTypeData> mPushTypeDatas;
    public int mStatus;

    public List<PushTypeData> getPushTypeDatas() {
        return this.mPushTypeDatas;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void parserProtobuf(PushStatus pushStatus) {
        if (pushStatus == null) {
            return;
        }
        this.mStatus = pushStatus.status.intValue();
        this.mPushTypeDatas = new ArrayList();
        int size = pushStatus.types.size();
        for (int i2 = 0; i2 < size; i2++) {
            PushTypeData pushTypeData = new PushTypeData();
            pushTypeData.parserProtobuf(pushStatus.types.get(i2));
            this.mPushTypeDatas.add(pushTypeData);
        }
    }

    public void setStatus(int i2) {
        this.mStatus = i2;
    }
}
