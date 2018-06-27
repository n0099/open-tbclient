package com.baidu.adp.lib.Disk;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<DiskFileOperate, Integer, DiskFileOperate> {
    private DiskFileOperate mDiskFileOperate;
    private b vX;
    private volatile e vY = null;

    public c(b bVar, DiskFileOperate diskFileOperate) {
        this.vX = null;
        this.mDiskFileOperate = null;
        if (bVar == null || diskFileOperate == null) {
            throw new InvalidParameterException("DiskFileTask parameter null");
        }
        this.vX = bVar;
        this.mDiskFileOperate = diskFileOperate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public DiskFileOperate doInBackground(DiskFileOperate... diskFileOperateArr) {
        this.vY = new e(this.vX, this.mDiskFileOperate);
        this.vY.gg();
        return this.mDiskFileOperate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(DiskFileOperate diskFileOperate) {
        super.onPostExecute(diskFileOperate);
        if (diskFileOperate != null) {
            this.mDiskFileOperate.t(diskFileOperate.isSuccess());
        } else {
            this.mDiskFileOperate.t(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        this.mDiskFileOperate.t(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.vY != null) {
            this.vY.cancel();
        }
    }
}
