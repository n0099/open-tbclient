package com.baidu.sofire;

import android.content.Context;
import android.content.Intent;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.core.ApkInfo;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: com.baidu.sofire.a$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static class AnonymousClass1 extends Thread {
        final /* synthetic */ Context a;
        final /* synthetic */ Intent b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AnonymousClass1(Context context, Intent intent) {
            this.a = context;
            this.b = intent;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            ApkInfo d;
            int i = 0;
            try {
                String[] e = com.baidu.sofire.b.d.e(this.a);
                new StringBuilder().append(e[0]).append(" : ").append(e[1]);
                com.baidu.sofire.b.d.a(this.a, e[0], e[1], 100028);
                while (true) {
                    Thread.sleep(500L);
                    i++;
                    new StringBuilder().append(i);
                    if (i > 60) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", "152");
                        hashMap.put("1", e[0]);
                        com.baidu.sofire.b.d.a(this.a.getApplicationContext(), "1014115", hashMap);
                        new StringBuilder().append(hashMap.toString());
                        break;
                    }
                    com.baidu.sofire.core.e a = com.baidu.sofire.core.e.a();
                    if (a != null && (d = a.d("com.baidu.techain.x24")) != null) {
                        new StringBuilder().append(d.toString());
                        break;
                    }
                }
                com.baidu.sofire.b.d.a(100028, "onReceiveAwakeMessage", new Callback() { // from class: com.baidu.sofire.a.1.1
                    @Override // com.baidu.sofire.ac.Callback
                    public final Object onEnd(Object... objArr) {
                        return super.onEnd(objArr);
                    }
                }, new Class[]{Context.class, Intent.class}, this.a, this.b);
            } catch (Throwable th) {
                com.baidu.sofire.b.d.a(th);
            }
        }
    }
}
