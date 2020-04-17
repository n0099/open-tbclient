package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes3.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a aSm;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes3.dex */
    public interface a {
        void bP(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0123b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private final class C0123b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean aSn;

        private C0123b() {
            this.aSn = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.aSn = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.aSm != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.aSn && scaleFactor > 1.0f) {
                    this.aSn = true;
                    b.this.aSm.bP(true);
                } else if (!this.aSn && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.aSn = true;
                    b.this.aSm.bP(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.aSn = true;
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
