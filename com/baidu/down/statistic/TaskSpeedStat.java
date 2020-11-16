package com.baidu.down.statistic;

import android.content.Context;
import com.baidu.down.utils.IdentityManager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class TaskSpeedStat {
    public long did;
    public String docid;
    private List<ThreadSpeedStat> mSpeedStatThreadList;
    public long startTimeMillis;
    public int status;
    public boolean speedStatEnable = false;
    public long startWriteTimeMillis = -1;
    public long endWriteTimeMillis = -1;

    public void addThreadSpeedStat(ThreadSpeedStat threadSpeedStat) {
        if (!this.mSpeedStatThreadList.contains(threadSpeedStat)) {
            this.mSpeedStatThreadList.add(threadSpeedStat);
        }
    }

    public List<ThreadSpeedStat> getSpeedStatThreadList() {
        return this.mSpeedStatThreadList;
    }

    public void initThreadSpeedStat(boolean z) {
        this.speedStatEnable = z;
        this.mSpeedStatThreadList = new ArrayList();
        this.startTimeMillis = System.currentTimeMillis();
    }

    public String generateCqid(Context context) {
        return IdentityManager.getInstance(context).getEncodedUid() + this.docid + this.did + System.currentTimeMillis();
    }
}
