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
    private C0074a fM;
    private boolean fN;

    /* renamed from: com.baidu.ar.arplay.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0074a {
        public int dz;
        public boolean fQ;
        public String fR;
        public int height;
        public String url;
        public int width;
    }

    public a(Context context) {
        super(context);
        this.fN = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.fM == null || canvas == null || !this.fN) {
            return;
        }
        final c n = d.bs().n(this.fM.dz);
        if (n == null) {
            Log.e("GLWebView", "HtmlTextureHolder is null: mTextureId: " + this.fM.dz);
            return;
        }
        Canvas lockCanvas = n.lockCanvas();
        if (lockCanvas != null) {
            float width = lockCanvas.getWidth() / canvas.getWidth();
            lockCanvas.scale(width, width);
            lockCanvas.translate(-getScrollX(), -getScrollY());
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.draw(lockCanvas);
        }
        n.br();
        ARPFilter.getInstance().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arplay.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (n != null) {
                    n.update();
                    a.this.fN = false;
                }
            }
        });
    }

    public C0074a getWebViewData() {
        return this.fM;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setIsNeedRender(boolean z) {
        this.fN = z;
    }

    public void setWebViewData(C0074a c0074a) {
        this.fM = c0074a;
    }
}
