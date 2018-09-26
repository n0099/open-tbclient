package cn.jiguang.d.d;

import android.content.Context;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class n implements Runnable {
    private String b;
    private Bundle c;
    private int d;
    private Context e;
    final /* synthetic */ l ly;

    public n(l lVar, Context context, String str, Bundle bundle, int i) {
        this.ly = lVar;
        this.b = str;
        this.c = bundle;
        this.e = context;
        this.d = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        if (this.d == 1) {
            l.a(this.ly, this.b, this.c);
        } else if (cn.jiguang.d.b.a.c()) {
            this.ly.e(this.e, this.b, this.c);
        } else {
            z = this.ly.e;
            if (z) {
                l.a(this.ly, this.b, this.c);
            }
        }
    }
}
