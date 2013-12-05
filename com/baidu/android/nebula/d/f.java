package com.baidu.android.nebula.d;

import com.baidu.android.common.logging.Log;
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private c f684a;
    private a b;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(a aVar, c cVar) {
        this.f684a = null;
        this.b = null;
        this.f684a = cVar;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f684a.e()) {
            return;
        }
        try {
            this.b.b(this.f684a);
        } catch (Exception e) {
            Log.e("HttpServer", "Deal Request Exception", e);
            this.b.a(this.f684a, e);
        }
    }
}
