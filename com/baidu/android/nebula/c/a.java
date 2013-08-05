package com.baidu.android.nebula.c;

import com.baidu.android.common.logging.Log;
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private d f539a;
    private e b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(e eVar, d dVar) {
        this.f539a = null;
        this.b = null;
        this.f539a = dVar;
        this.b = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f539a.e()) {
            return;
        }
        try {
            this.b.b(this.f539a);
        } catch (Exception e) {
            Log.e("HttpServer", "Deal Request Exception", e);
            this.b.a(this.f539a, e);
        }
    }
}
