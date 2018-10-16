package cn.jiguang.d.i;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class g implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ boolean b;
    final /* synthetic */ f mK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, Context context, boolean z) {
        this.mK = fVar;
        this.a = context;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar;
        h hVar;
        try {
            eVar = this.mK.mH;
            eVar.a(this.a, this.b);
            hVar = this.mK.mI;
            hVar.a(this.a, this.b);
        } catch (Throwable th) {
        }
    }
}
