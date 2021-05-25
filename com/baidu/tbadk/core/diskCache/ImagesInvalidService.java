package com.baidu.tbadk.core.diskCache;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import d.a.c.e.a.d;
import java.io.File;
/* loaded from: classes3.dex */
public class ImagesInvalidService extends BdBaseService {
    public static final int DELAY_TIMES = 10000;
    public static final long FILE_VALID_TIME = 259200000;
    public static final int START_SERVICE = 1;
    public DiskFileOperate mDiskFileOperate = null;

    /* loaded from: classes3.dex */
    public static class a extends DiskFileOperate implements d.a.c.e.a.a {
        public a(String str, String str2, DiskFileOperate.Action action) {
            super(str, str2, action);
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            d.a.m0.r.t.a.g();
            ImagesInvalidReceiver.broadcast(z);
        }

        @Override // d.a.c.e.a.a
        public boolean compare(File file) {
            return file != null && file.lastModified() + 259200000 < System.currentTimeMillis();
        }
    }

    public static void setSuccess(boolean z) {
        d.a.m0.r.t.a.e(z);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mDiskFileOperate = new a("images", null, DiskFileOperate.Action.DELETE_FILES);
        d.g().a(this.mDiskFileOperate);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        d.g().e(this.mDiskFileOperate);
        this.mDiskFileOperate = null;
    }
}
