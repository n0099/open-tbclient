package cn.jiguang.d.d;

import android.content.Context;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class m implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ Bundle c;
    final /* synthetic */ l lx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, Context context, String str, Bundle bundle) {
        this.lx = lVar;
        this.a = context;
        this.b = str;
        this.c = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (cn.jiguang.d.a.d(this.a)) {
                String a = l.a(this.a, this.b);
                if (cn.jiguang.d.b.a.c()) {
                    this.lx.e(this.a, a, this.c);
                } else {
                    cn.jiguang.api.e.a("ACTION", new n(this.lx, this.a, a, this.c, 0), new int[0]);
                }
            }
        } catch (Throwable th) {
        }
    }
}
