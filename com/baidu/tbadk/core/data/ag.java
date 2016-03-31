package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.PushStatus;
/* loaded from: classes.dex */
public class ag {
    private List<ah> Ui;
    private int mStatus;

    public int getStatus() {
        return this.mStatus;
    }

    public void a(PushStatus pushStatus) {
        if (pushStatus != null) {
            this.mStatus = pushStatus.status.intValue();
            this.Ui = new ArrayList();
            int size = pushStatus.types.size();
            for (int i = 0; i < size; i++) {
                ah ahVar = new ah();
                ahVar.a(pushStatus.types.get(i));
                this.Ui.add(ahVar);
            }
        }
    }
}
