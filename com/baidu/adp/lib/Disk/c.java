package com.baidu.adp.lib.Disk;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<DiskFileOperate, Integer, DiskFileOperate> {
    private DiskFileOperate mDiskFileOperate;
    private b rv;
    private volatile e rw = null;

    public c(b bVar, DiskFileOperate diskFileOperate) {
        this.rv = null;
        this.mDiskFileOperate = null;
        if (bVar == null || diskFileOperate == null) {
            throw new InvalidParameterException("DiskFileTask parameter null");
        }
        this.rv = bVar;
        this.mDiskFileOperate = diskFileOperate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public DiskFileOperate doInBackground(DiskFileOperate... diskFileOperateArr) {
        this.rw = new e(this.rv, this.mDiskFileOperate);
        this.rw.dI();
        return this.mDiskFileOperate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(DiskFileOperate diskFileOperate) {
        super.onPostExecute(diskFileOperate);
        if (diskFileOperate != null) {
            this.mDiskFileOperate.p(diskFileOperate.isSuccess());
        } else {
            this.mDiskFileOperate.p(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        this.mDiskFileOperate.p(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.rw != null) {
            this.rw.cancel();
        }
    }
}
