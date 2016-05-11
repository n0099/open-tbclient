package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.PushStatus;
/* loaded from: classes.dex */
public class ai {
    private List<aj> Pe;
    private int mStatus;

    public int getStatus() {
        return this.mStatus;
    }

    public void a(PushStatus pushStatus) {
        if (pushStatus != null) {
            this.mStatus = pushStatus.status.intValue();
            this.Pe = new ArrayList();
            int size = pushStatus.types.size();
            for (int i = 0; i < size; i++) {
                aj ajVar = new aj();
                ajVar.a(pushStatus.types.get(i));
                this.Pe.add(ajVar);
            }
        }
    }
}
