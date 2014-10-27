package com.baidu.adp.lib.Disk;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<DiskFileOperate, Integer, DiskFileOperate> {
    private b dB;
    private volatile e dC = null;
    private DiskFileOperate mDiskFileOperate;

    public c(b bVar, DiskFileOperate diskFileOperate) {
        this.dB = null;
        this.mDiskFileOperate = null;
        if (bVar == null || diskFileOperate == null) {
            throw new InvalidParameterException("DiskFileTask parameter null");
        }
        this.dB = bVar;
        this.mDiskFileOperate = diskFileOperate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public DiskFileOperate doInBackground(DiskFileOperate... diskFileOperateArr) {
        this.dC = new e(this.dB, this.mDiskFileOperate);
        this.dC.bp();
        return this.mDiskFileOperate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(DiskFileOperate diskFileOperate) {
        super.onPostExecute(diskFileOperate);
        if (diskFileOperate != null) {
            this.mDiskFileOperate.h(diskFileOperate.isSuccess());
        } else {
            this.mDiskFileOperate.h(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        this.mDiskFileOperate.h(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.dC != null) {
            this.dC.cancel();
        }
    }
}
