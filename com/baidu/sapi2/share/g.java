package com.baidu.sapi2.share;

import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.share.m;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.HashMap;
/* loaded from: classes19.dex */
class g implements Runnable {
    final /* synthetic */ IBinder a;
    final /* synthetic */ ServiceConnection b;
    final /* synthetic */ h c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar, IBinder iBinder, ServiceConnection serviceConnection) {
        this.c = hVar;
        this.a = iBinder;
        this.b = serviceConnection;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // java.lang.Runnable
    public void run() {
        SapiConfiguration sapiConfiguration;
        SapiConfiguration sapiConfiguration2;
        SapiContext sapiContext;
        SapiConfiguration sapiConfiguration3;
        try {
            Parcel a = SapiShareClient.a(new ShareModel(ShareEvent.SYNC_REQ), false);
            Parcel obtain = Parcel.obtain();
            if (this.a.transact(0, a, obtain, 0)) {
                SapiShareClient.b(obtain);
            }
            if (this.c.b.b) {
                HashMap hashMap = new HashMap();
                sapiConfiguration3 = SapiShareClient.i;
                hashMap.put("cuid", SapiUtils.getClientId(sapiConfiguration3.context));
                hashMap.put(Config.DEVICE_PART, Build.MODEL);
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                if (currentAccount != null) {
                    hashMap.put("isLogin", "true");
                    hashMap.put("uid", currentAccount.uid);
                    hashMap.put(m.b.c, currentAccount.app);
                } else {
                    hashMap.put("isLogin", "false");
                }
                com.baidu.sapi2.utils.t.a("share_silent_account_success", hashMap);
            }
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
            sapiContext = SapiShareClient.j;
            if (sapiContext.getShareAccounts().size() < 5) {
                h hVar = this.c;
                hVar.b.c.post(hVar.a);
                return;
            }
        }
        this.c.b.d.quit();
    }
}
