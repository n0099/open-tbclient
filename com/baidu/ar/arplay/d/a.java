package com.baidu.ar.arplay.d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.baidu.ar.arplay.core.filter.ARPFilter;
/* loaded from: classes3.dex */
public class a extends WebView {
    private C0074a gl;
    private boolean gm;

    /* renamed from: com.baidu.ar.arplay.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0074a {
        public int dL;
        public boolean gp;
        public String gq;
        public int height;
        public String url;
        public int width;
    }

    public a(Context context) {
        super(context);
        this.gm = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.gl == null || canvas == null || !this.gm) {
            return;
        }
        final c p = d.aW().p(this.gl.dL);
        if (p == null) {
            Log.e("GLWebView", "HtmlTextureHolder is null: mTextureId: " + this.gl.dL);
            return;
        }
        Canvas lockCanvas = p.lockCanvas();
        if (lockCanvas != null) {
            float width = lockCanvas.getWidth() / canvas.getWidth();
            lockCanvas.scale(width, width);
            lockCanvas.translate(-getScrollX(), -getScrollY());
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.draw(lockCanvas);
        }
        p.aV();
        ARPFilter.getInstance().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arplay.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (p != null) {
                    p.update();
                    a.this.gm = false;
                }
            }
        });
    }

    public C0074a getWebViewData() {
        return this.gl;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setIsNeedRender(boolean z) {
        this.gm = z;
    }

    public void setWebViewData(C0074a c0074a) {
        this.gl = c0074a;
    }
}
