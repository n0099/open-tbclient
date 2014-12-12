package com.baidu.tbadk.core.diskCache;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.g.j;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ImagesInvalidService extends BdBaseService {
    private static final int DELAY_TIMES = 10000;
    private static final long FILE_VALID_TIME = 259200000;
    private static final int START_SERVICE = 1;
    private DiskFileOperate mDiskFileOperate = null;
    private static boolean sIsSuccess = false;
    private static Handler sHandler = new a();

    static {
        MessageManager.getInstance().registerListener(new b(2001011));
    }

    public static void setSuccess(boolean z) {
        sIsSuccess = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startService() {
        j.f(BdBaseApplication.getInst().getContext(), new Intent(BdBaseApplication.getInst().getContext(), ImagesInvalidService.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void stopService() {
        j.g(BdBaseApplication.getInst().getContext(), new Intent(BdBaseApplication.getInst().getContext(), ImagesInvalidService.class));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mDiskFileOperate = new c(TbConfig.IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES);
        d.bO().c(this.mDiskFileOperate);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        d.bO().d(this.mDiskFileOperate);
        this.mDiskFileOperate = null;
    }
}
