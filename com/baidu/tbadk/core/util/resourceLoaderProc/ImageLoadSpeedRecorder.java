package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import d.a.c.e.p.j;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes3.dex */
public class ImageLoadSpeedRecorder {
    public static final int LOWEST_SPEED_FOR_PARALLEL = 20;
    public static final int QUEUE_SIZE = 5;
    public static ImageLoadSpeedRecorder _speedRecorder;
    public Queue<LoadSpeedRecordItem> mSpeedRecordQueue = new LinkedList();
    public BdAsyncTaskParallel mTaskSerial = null;
    public BdAsyncTaskParallel mTaskParallelThree = null;
    public float mAverageSpeed = 0.0f;

    /* loaded from: classes3.dex */
    public class LoadSpeedRecordItem {
        public int downloadSize;
        public long timeCosts;

        public LoadSpeedRecordItem() {
            this.downloadSize = 0;
            this.timeCosts = 0L;
        }
    }

    public static ImageLoadSpeedRecorder sharedInstance() {
        if (_speedRecorder == null) {
            _speedRecorder = new ImageLoadSpeedRecorder();
        }
        return _speedRecorder;
    }

    public synchronized void addSpeedRecordItem(int i2, long j) {
        LoadSpeedRecordItem loadSpeedRecordItem = new LoadSpeedRecordItem();
        loadSpeedRecordItem.downloadSize = i2;
        loadSpeedRecordItem.timeCosts = j;
        this.mSpeedRecordQueue.offer(loadSpeedRecordItem);
        if (this.mSpeedRecordQueue.size() > 5) {
            this.mSpeedRecordQueue.poll();
        }
        if (speedRedordAvilable()) {
            int i3 = 0;
            for (LoadSpeedRecordItem loadSpeedRecordItem2 : this.mSpeedRecordQueue) {
                if (j > 0) {
                    i3 = (int) (i3 + (loadSpeedRecordItem2.downloadSize / loadSpeedRecordItem2.timeCosts));
                }
            }
            this.mAverageSpeed = i3 / 5;
        }
    }

    public BdAsyncTaskParallel getAsyncTaskParallel() {
        if (j.v()) {
            if (speedRedordAvilable() && this.mAverageSpeed < 20.0f) {
                if (this.mTaskSerial == null) {
                    this.mTaskSerial = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
                }
                return this.mTaskSerial;
            }
            if (this.mTaskParallelThree == null) {
                this.mTaskParallelThree = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
            }
            return this.mTaskParallelThree;
        }
        return null;
    }

    public boolean speedRedordAvilable() {
        return this.mSpeedRecordQueue.size() == 5;
    }
}
