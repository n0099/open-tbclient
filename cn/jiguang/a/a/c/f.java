package cn.jiguang.a.a.c;

import android.content.Context;
import cn.jiguang.d.d.aa;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f extends Thread implements cn.jiguang.api.j {
    final /* synthetic */ e kQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.kQ = eVar;
    }

    @Override // cn.jiguang.api.j
    public final void a(int i) {
        if (i == 0) {
            e.a(cn.jiguang.d.a.X(null));
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        JSONObject U;
        try {
            Context X = cn.jiguang.d.a.X(null);
            if (X == null) {
                return;
            }
            e eVar = this.kQ;
            U = e.U(X);
            if (U != null) {
                aa.a(X, U, this);
            }
        } catch (Throwable th) {
        }
    }
}
