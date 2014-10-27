package com.baidu.adp.lib.debug.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
/* loaded from: classes.dex */
public class e extends a {
    private h gn;
    private WindowManager go;
    private g gp = null;

    public e(Context context) {
        this.gn = null;
        this.go = null;
        this.gn = new h(this, context);
        this.go = (WindowManager) context.getSystemService("window");
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public void stop() {
        super.stop();
        try {
            this.go.removeView(this.gn);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public void start() {
        super.start();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
        layoutParams.gravity = 51;
        layoutParams.height = 1;
        layoutParams.width = 1;
        try {
            this.go.removeView(this.gn);
        } catch (Exception e) {
        }
        this.go.addView(this.gn, layoutParams);
        new Handler(Looper.getMainLooper()).post(new f(this));
    }

    public void a(g gVar) {
        if (this.gp == null) {
            this.gp = gVar;
        }
    }
}
