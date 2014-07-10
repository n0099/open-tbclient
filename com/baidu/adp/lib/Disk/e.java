package com.baidu.adp.lib.Disk;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        AtomicInteger atomicInteger;
        switch (message.what) {
            case 1:
                atomicInteger = this.a.f;
                atomicInteger.decrementAndGet();
                if (message.obj == null || !(message.obj instanceof DiskFileOperate)) {
                    return;
                }
                this.a.e((DiskFileOperate) message.obj);
                return;
            default:
                return;
        }
    }
}
