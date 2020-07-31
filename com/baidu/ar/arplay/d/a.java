package com.baidu.ar.arplay.d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.baidu.ar.arplay.core.filter.ARPFilter;
/* loaded from: classes11.dex */
public class a extends WebView {
    private C0078a gx;
    private boolean gy;

    /* renamed from: com.baidu.ar.arplay.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0078a {
        public int dX;
        public boolean gB;
        public String gC;
        public int height;
        public String url;
        public int width;
    }

    public a(Context context) {
        super(context);
        this.gy = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.gx == null || canvas == null || !this.gy) {
            return;
        }
        final c q = d.bk().q(this.gx.dX);
        if (q == null) {
            Log.e("GLWebView", "HtmlTextureHolder is null: mTextureId: " + this.gx.dX);
            return;
        }
        Canvas lockCanvas = q.lockCanvas();
        if (lockCanvas != null) {
            float width = lockCanvas.getWidth() / canvas.getWidth();
            lockCanvas.scale(width, width);
            lockCanvas.translate(-getScrollX(), -getScrollY());
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.draw(lockCanvas);
        }
        q.bj();
        ARPFilter.getInstance().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arplay.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (q != null) {
                    q.update();
                    a.this.gy = false;
                }
            }
        });
    }

    public C0078a getWebViewData() {
        return this.gx;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setIsNeedRender(boolean z) {
        this.gy = z;
    }

    public void setWebViewData(C0078a c0078a) {
        this.gx = c0078a;
    }
}
