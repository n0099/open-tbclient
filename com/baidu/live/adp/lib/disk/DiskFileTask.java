package com.baidu.live.adp.lib.disk;

import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.disk.ops.DiskFileOperate;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class DiskFileTask extends BdAsyncTask<DiskFileOperate, Integer, DiskFileOperate> {
    private DiskFileFactory mDiskFileFactory;
    private DiskFileOperate mDiskFileOperate;
    private volatile DiskWorker mDiskWorker = null;

    public DiskFileTask(DiskFileFactory diskFileFactory, DiskFileOperate diskFileOperate) {
        this.mDiskFileFactory = null;
        this.mDiskFileOperate = null;
        if (diskFileFactory == null || diskFileOperate == null) {
            throw new InvalidParameterException("DiskFileTask parameter null");
        }
        this.mDiskFileFactory = diskFileFactory;
        this.mDiskFileOperate = diskFileOperate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
    public DiskFileOperate doInBackground(DiskFileOperate... diskFileOperateArr) {
        this.mDiskWorker = new DiskWorker(this.mDiskFileFactory, this.mDiskFileOperate);
        this.mDiskWorker.call();
        return this.mDiskFileOperate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
    public void onPostExecute(DiskFileOperate diskFileOperate) {
        super.onPostExecute((DiskFileTask) diskFileOperate);
        if (diskFileOperate != null) {
            this.mDiskFileOperate.callback(diskFileOperate.isSuccess());
        } else {
            this.mDiskFileOperate.callback(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        this.mDiskFileOperate.callback(false);
    }

    @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.mDiskWorker != null) {
            this.mDiskWorker.cancel();
        }
    }
}
