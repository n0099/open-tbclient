package com.baidu.tbadk.core.diskCache;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class ImagesInvalidService extends Service {
    private static boolean a = false;
    private static Handler b = new a();
    private DiskFileOperate c = null;

    static {
        MessageManager.getInstance().registerListener(new b(MessageTypes.CMD_BACKGROUND_SWTICH));
    }

    public static void a(boolean z) {
        a = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        com.baidu.adp.lib.f.c.a(com.baidu.adp.base.a.getInst(), new Intent(com.baidu.adp.base.a.getInst(), ImagesInvalidService.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        com.baidu.adp.lib.f.c.b(com.baidu.adp.base.a.getInst(), new Intent(com.baidu.adp.base.a.getInst(), ImagesInvalidService.class));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        BdLog.d("start delete invalde images");
        this.c = new c(TbConfig.IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES);
        d.a().b(this.c);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BdLog.d("stop delete invalde images");
        d.a().c(this.c);
        this.c = null;
    }
}
