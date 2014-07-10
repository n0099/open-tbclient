package com.baidu.android.nebula.c;

import com.baidu.android.common.logging.Log;
/* loaded from: classes.dex */
public class a implements Runnable {
    private d a;
    private e b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(e eVar, d dVar) {
        this.a = null;
        this.b = null;
        this.a = dVar;
        this.b = eVar;
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
