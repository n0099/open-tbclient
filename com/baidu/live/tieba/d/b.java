package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes3.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a ayq;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes3.dex */
    public interface a {
        void bk(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0097b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private final class C0097b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean ayr;

        private C0097b() {
            this.ayr = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.ayr = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.ayq != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.ayr && scaleFactor > 1.0f) {
                    this.ayr = true;
                    b.this.ayq.bk(true);
                } else if (!this.ayr && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.ayr = true;
                    b.this.ayq.bk(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.ayr = true;
        }
    }

    @Override // com.baidu.live.tieba.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.mScaleGestureDetector.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
