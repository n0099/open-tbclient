package com.baidu.mobads.g;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class n implements Runnable {
    final /* synthetic */ g.c a;
    final /* synthetic */ Handler b;
    final /* synthetic */ g c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(g gVar, g.c cVar, Handler handler) {
        this.c = gVar;
        this.a = cVar;
        this.b = handler;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, IF, IGET, INVOKE, INVOKE, CONST_STR, IGET, INVOKE, INVOKE, SGET, IGET, INVOKE, CONST_STR, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // java.lang.Runnable
    public void run() {
        IXAdLogger iXAdLogger;
        SharedPreferences l;
        IXAdLogger iXAdLogger2;
        IXAdLogger iXAdLogger3;
        SharedPreferences l2;
        try {
            synchronized (g.class) {
                this.c.b(this.a, this.b);
            }
        } catch (Throwable th) {
            try {
                iXAdLogger2 = this.c.m;
                iXAdLogger2.e("XAdApkLoader", "Load APK Failed: " + th.toString());
                this.c.b(false);
                try {
                    l2 = this.c.l();
                    SharedPreferences.Editor edit = l2.edit();
                    edit.putString("previousProxyVersion", this.c.a());
                    if (Build.VERSION.SDK_INT >= 9) {
                        edit.apply();
                    } else {
                        edit.commit();
                    }
                } catch (Throwable th2) {
                    iXAdLogger3 = this.c.m;
                    iXAdLogger3.e("XAdApkLoader", th2);
                }
            } finally {
                try {
                    l = this.c.l();
                    SharedPreferences.Editor edit2 = l.edit();
                    edit2.putString("previousProxyVersion", this.c.a());
                    if (Build.VERSION.SDK_INT >= 9) {
                        edit2.apply();
                    } else {
                        edit2.commit();
                    }
                } catch (Throwable th3) {
                    iXAdLogger = this.c.m;
                    iXAdLogger.e("XAdApkLoader", th3);
                }
            }
        }
    }
}
