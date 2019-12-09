package com.baidu.sapi2.share;

import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import java.util.Collections;
/* loaded from: classes2.dex */
class d implements Runnable {
    final /* synthetic */ IBinder a;
    final /* synthetic */ ServiceConnection b;
    final /* synthetic */ e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar, IBinder iBinder, ServiceConnection serviceConnection) {
        this.c = eVar;
        this.a = iBinder;
        this.b = serviceConnection;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // java.lang.Runnable
    public void run() {
        SapiConfiguration sapiConfiguration;
        SapiConfiguration sapiConfiguration2;
        try {
            this.a.transact(0, SapiShareClient.a(new ShareModel(ShareEvent.INVALIDATE, null, Collections.singletonList(this.c.b.c)), false), Parcel.obtain(), 0);
        } catch (Throwable th) {
            try {
                Log.e(th);
                try {
                    sapiConfiguration2 = SapiShareClient.i;
                    sapiConfiguration2.context.unbindService(this.b);
                } catch (Throwable th2) {
                    Log.e(th2);
                }
            } finally {
                try {
                    sapiConfiguration = SapiShareClient.i;
                    sapiConfiguration.context.unbindService(this.b);
                } catch (Throwable th3) {
                    Log.e(th3);
                }
            }
        }
        this.c.b.a.remove(0);
        if (!this.c.b.a.isEmpty()) {
            e eVar = this.c;
            eVar.b.b.post(eVar.a);
            return;
        }
        this.c.b.d.quit();
    }
}
