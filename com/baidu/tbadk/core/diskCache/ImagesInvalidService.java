package com.baidu.tbadk.core.diskCache;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ImagesInvalidService extends BdBaseService {
    public static final int DELAY_TIMES = 10000;
    private static final long FILE_VALID_TIME = 259200000;
    public static final int START_SERVICE = 1;
    private DiskFileOperate mDiskFileOperate = null;

    public static void setSuccess(boolean z) {
        ImagesInvalidServiceStatic.al(z);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mDiskFileOperate = new a(TbConfig.IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES);
        d.fp().c(this.mDiskFileOperate);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        d.fp().d(this.mDiskFileOperate);
        this.mDiskFileOperate = null;
    }
}
