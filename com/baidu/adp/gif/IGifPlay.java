package com.baidu.adp.gif;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.Set;
/* loaded from: classes.dex */
public interface IGifPlay {

    /* loaded from: classes.dex */
    public class GifPlayImpl extends Handler implements IGifPlay {
        private final Set<d> a;
        private long b;
        private WeakReference<c> c;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar = this.c.get();
            if (cVar != null && message.what == 4) {
                long uptimeMillis = SystemClock.uptimeMillis();
                int b = cVar.b();
                this.b = uptimeMillis;
                int i = b + 1;
                int i2 = i >= cVar.e() ? 0 : i;
                cVar.a(i2);
                for (d dVar : this.a) {
                    dVar.a(cVar);
                }
                removeMessages(4);
                sendEmptyMessageAtTime(4, cVar.b(i2) + uptimeMillis);
            }
        }
    }
}
