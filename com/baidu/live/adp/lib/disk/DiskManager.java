package com.baidu.live.adp.lib.disk;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.asynctask.BdAsyncTaskParallel;
import com.baidu.live.adp.lib.disk.ops.DiskFileOperate;
/* loaded from: classes10.dex */
public class DiskManager {
    private static final int DISK_TASK_MAX_NUM_ROM = 5;
    private static final int DISK_TASK_MAX_NUM_SDCARD = 10;
    public static final int SUB_FOLDERS_NUM = 100;
    private BdAsyncTaskParallel mBdAsyncTaskParallelRom;
    private BdAsyncTaskParallel mBdAsyncTaskParallelSdCard;
    private DiskFileFactory mDiskFileFactory;
    private static BdUniqueId sSdCardTags = BdUniqueId.gen();
    private static BdUniqueId sRomTags = BdUniqueId.gen();
    private static volatile DiskManager sInstance = null;

    public static DiskManager getInstance() {
        if (sInstance == null) {
            synchronized (DiskManager.class) {
                if (sInstance == null) {
                    sInstance = new DiskManager();
                }
            }
        }
        return sInstance;
    }

    private DiskManager() {
        this.mDiskFileFactory = null;
        this.mBdAsyncTaskParallelSdCard = null;
        this.mBdAsyncTaskParallelRom = null;
        this.mBdAsyncTaskParallelSdCard = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.mBdAsyncTaskParallelRom = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.mDiskFileFactory = new DiskFileFactory();
    }

    public void initial(String str) {
        this.mDiskFileFactory.setApplicationPath(str);
    }

    public boolean call(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean call = new DiskWorker(this.mDiskFileFactory, diskFileOperate).call();
        diskFileOperate.callback(call);
        return call;
    }

    public boolean asyncCall(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.isSdCard()) {
            return doAsyncCall(diskFileOperate, sSdCardTags, this.mBdAsyncTaskParallelSdCard, 10);
        }
        return doAsyncCall(diskFileOperate, sRomTags, this.mBdAsyncTaskParallelRom, 5);
    }

    private boolean doAsyncCall(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel, int i) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.getOperateType() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(bdUniqueId) < diskFileOperate.getTrySuccessWeight() + i) {
            return asyncCallImpl(diskFileOperate, bdUniqueId, bdAsyncTaskParallel);
        }
        return false;
    }

    public void cancelAsyncCall(DiskFileOperate diskFileOperate) {
        String buildKey = buildKey(diskFileOperate);
        if (buildKey != null) {
            BdAsyncTask.removeAllTask(sSdCardTags, buildKey);
            BdAsyncTask.removeAllTask(sRomTags, buildKey);
        }
    }

    private String buildKey(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return null;
        }
        if (diskFileOperate.getPath() == null) {
            return diskFileOperate.getName() + "|" + diskFileOperate.hashCode();
        }
        return diskFileOperate.getPath() + "/" + diskFileOperate.getName() + "|" + diskFileOperate.hashCode();
    }

    private boolean asyncCallImpl(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel) {
        DiskFileTask diskFileTask = new DiskFileTask(this.mDiskFileFactory, diskFileOperate);
        diskFileTask.setTag(bdUniqueId);
        diskFileTask.setParallel(bdAsyncTaskParallel);
        diskFileTask.setPriority(4);
        diskFileTask.setKey(buildKey(diskFileOperate));
        diskFileTask.execute(new DiskFileOperate[0]);
        return true;
    }
}
