package com.baidu.adp.lib.debug.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
/* loaded from: classes.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private g f141a;
    private WindowManager b;

    public e(Context context) {
        this.f141a = null;
        this.b = null;
        this.f141a = new g(this, context);
        this.b = (WindowManager) context.getSystemService("window");
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public void c() {
        super.c();
        try {
            this.b.removeView(this.f141a);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public void b() {
        super.b();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
        layoutParams.gravity = 51;
        layoutParams.height = 1;
        layoutParams.width = 1;
        try {
            this.b.removeView(this.f141a);
        } catch (Exception e) {
        }
        this.b.addView(this.f141a, layoutParams);
        new Handler(Looper.getMainLooper()).post(new f(this));
    }
}
