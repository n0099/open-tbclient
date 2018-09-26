package cn.jiguang.d.d;

import android.content.Context;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class w implements Runnable {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String e;
        try {
            e = s.e(this.a);
            File[] b = cn.jiguang.d.h.f.b(e, true);
            if (b == null || b.length <= 0) {
                return;
            }
            for (File file : b) {
                s.d(this.a, file);
            }
        } catch (Throwable th) {
        }
    }
}
