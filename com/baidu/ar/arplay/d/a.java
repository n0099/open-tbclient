package com.baidu.ar.arplay.d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.baidu.ar.arplay.core.engine.ARPEngine;
/* loaded from: classes6.dex */
public class a extends WebView {
    private C0071a fZ;
    private boolean ga;

    /* renamed from: com.baidu.ar.arplay.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0071a {
        public int dM;
        public boolean gd;
        public String ge;
        public int height;
        public String url;
        public int width;
    }

    public a(Context context) {
        super(context);
        this.ga = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.fZ == null || canvas == null || !this.ga) {
            return;
        }
        final c p = d.bp().p(this.fZ.dM);
        if (p == null) {
            Log.e("GLWebView", "HtmlTextureHolder is null: mTextureId: " + this.fZ.dM);
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
        p.bo();
        ARPEngine.getInstance().getARPRenderer().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arplay.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (p != null) {
                    p.update();
                    a.this.ga = false;
                }
            }
        });
    }

    public C0071a getWebViewData() {
        return this.fZ;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setIsNeedRender(boolean z) {
        this.ga = z;
    }

    public void setWebViewData(C0071a c0071a) {
        this.fZ = c0071a;
    }
}
