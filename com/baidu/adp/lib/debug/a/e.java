package com.baidu.adp.lib.debug.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
/* loaded from: classes.dex */
public final class e extends a {
    private g a;
    private WindowManager b;

    public e(Context context) {
        this.a = null;
        this.b = null;
        this.a = new g(this, context);
        this.b = (WindowManager) context.getSystemService("window");
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public final void c() {
        super.c();
        try {
            this.b.removeView(this.a);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public final void b() {
        super.b();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
        layoutParams.gravity = 51;
        layoutParams.height = 1;
        layoutParams.width = 1;
        try {
            this.b.removeView(this.a);
        } catch (Exception e) {
        }
        this.b.addView(this.a, layoutParams);
        new Handler(Looper.getMainLooper()).post(new f(this));
    }
}
