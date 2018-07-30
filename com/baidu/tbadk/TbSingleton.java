package com.baidu.tbadk;

import com.baidu.tbadk.c.a;
import com.baidu.tbadk.core.util.ap;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class TbSingleton {
    private static TbSingleton mInstance = null;
    private boolean isRecommendPage;
    private LinkedList<a> mVideoWatchTimeRecord;
    private long pushDialogLoopTime = ap.aqR;

    private TbSingleton() {
    }

    public static TbSingleton getInstance() {
        if (mInstance == null) {
            synchronized (TbSingleton.class) {
                if (mInstance == null) {
                    mInstance = new TbSingleton();
                }
            }
        }
        return mInstance;
    }

    public void setIsRecommendPage(boolean z) {
        this.isRecommendPage = z;
    }

    public boolean isRecommendPage() {
        return this.isRecommendPage;
    }

    public void putVideoRecord(String str, int i) {
        a aVar;
        boolean z;
        if (!ap.isEmpty(str)) {
            if (this.mVideoWatchTimeRecord == null) {
                this.mVideoWatchTimeRecord = new LinkedList<>();
            }
            int size = this.mVideoWatchTimeRecord.size();
            int i2 = size - 1;
            while (true) {
                if (i2 < 0) {
                    aVar = null;
                    z = false;
                    break;
                }
                aVar = this.mVideoWatchTimeRecord.get(i2);
                if (!str.equals(aVar.getKey())) {
                    i2--;
                } else if (aVar.getValue() != i) {
                    z = i2 == size + (-1);
                } else {
                    return;
                }
            }
            if (aVar != null) {
                aVar.setValue(i);
                if (!z) {
                    this.mVideoWatchTimeRecord.remove(aVar);
                    this.mVideoWatchTimeRecord.addLast(aVar);
                    return;
                }
                return;
            }
            a aVar2 = new a(str, i);
            if (size >= 10) {
                this.mVideoWatchTimeRecord.pollFirst();
                this.mVideoWatchTimeRecord.addLast(aVar2);
                return;
            }
            this.mVideoWatchTimeRecord.addLast(aVar2);
        }
    }

    public LinkedList<a> getVideoRecordList() {
        return this.mVideoWatchTimeRecord;
    }

    public void clearVideoRecord() {
        if (this.mVideoWatchTimeRecord != null) {
            this.mVideoWatchTimeRecord.clear();
        }
    }

    public long getPushDialogLoopTime() {
        return this.pushDialogLoopTime;
    }

    public void setPushDialogLoopTime(long j) {
        this.pushDialogLoopTime = j;
    }
}
