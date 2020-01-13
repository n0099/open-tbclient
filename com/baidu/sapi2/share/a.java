package com.baidu.sapi2.share;

import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import java.util.Collections;
/* loaded from: classes5.dex */
class a implements Runnable {
    final /* synthetic */ IBinder a;
    final /* synthetic */ ServiceConnection b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, IBinder iBinder, ServiceConnection serviceConnection) {
        this.c = bVar;
        this.a = iBinder;
        this.b = serviceConnection;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // java.lang.Runnable
    public void run() {
        SapiConfiguration sapiConfiguration;
        SapiConfiguration sapiConfiguration2;
        try {
            ShareModel shareModel = new ShareModel(ShareEvent.VALIDATE, this.c.b.c, Collections.singletonList(this.c.b.c));
            if (this.c.b.d) {
                shareModel = new ShareModel(ShareEvent.VALIDATE);
            }
            this.a.transact(0, SapiShareClient.a(shareModel, this.c.b.d), Parcel.obtain(), 0);
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
            b bVar = this.c;
            bVar.b.b.post(bVar.a);
            return;
        }
        this.c.b.e.quit();
    }
}
