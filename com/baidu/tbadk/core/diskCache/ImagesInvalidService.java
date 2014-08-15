package com.baidu.tbadk.core.diskCache;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ImagesInvalidService extends Service {
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
        com.baidu.adp.lib.e.c.a(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), ImagesInvalidService.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void stopService() {
        com.baidu.adp.lib.e.c.b(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), ImagesInvalidService.class));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mDiskFileOperate = new c(TbConfig.IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES);
        d.a().b(this.mDiskFileOperate);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        d.a().c(this.mDiskFileOperate);
        this.mDiskFileOperate = null;
    }
}
