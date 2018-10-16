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
    final /* synthetic */ l md;

    public n(l lVar, Context context, String str, Bundle bundle, int i) {
        this.md = lVar;
        this.b = str;
        this.c = bundle;
        this.e = context;
        this.d = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        if (this.d == 1) {
            l.a(this.md, this.b, this.c);
        } else if (cn.jiguang.d.b.a.c()) {
            this.md.e(this.e, this.b, this.c);
        } else {
            z = this.md.e;
            if (z) {
                l.a(this.md, this.b, this.c);
            }
        }
    }
}
