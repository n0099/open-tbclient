package com.baidu.android.nebula.c;

import com.baidu.android.common.logging.Log;
/* loaded from: classes.dex */
public class f implements Runnable {
    private c a;
    private a b;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(a aVar, c cVar) {
        this.a = null;
        this.b = null;
        this.a = cVar;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.e()) {
            return;
        }
        try {
            this.b.b(this.a);
        } catch (Exception e) {
            Log.e("HttpServer", "Deal Request Exception", e);
            this.b.a(this.a, e);
        }
    }
}
