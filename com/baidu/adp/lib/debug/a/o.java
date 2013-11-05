package com.baidu.adp.lib.debug.a;

import android.content.Context;
import java.io.IOException;
/* loaded from: classes.dex */
public class o extends a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private d f458a;
    private l b;

    public o(Context context) {
        this.f458a = new d(context);
        this.b = new l(context);
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public void c() {
        super.c();
        this.f458a.c();
        this.b.c();
    }

    @Override // java.lang.Runnable
    public void run() {
        super.b();
        while (true) {
            try {
                com.baidu.adp.lib.debug.b.b(this.f458a.d());
                com.baidu.adp.lib.debug.b.a(this.b.d());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!a()) {
                return;
            }
            Thread.sleep(300L);
        }
    }
}
