package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes6.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a alE;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes6.dex */
    public interface a {
        void aH(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0074b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private final class C0074b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean alF;

        private C0074b() {
            this.alF = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.alF = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.alE != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.alF && scaleFactor > 1.0f) {
                    this.alF = true;
                    b.this.alE.aH(true);
                } else if (!this.alF && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.alF = true;
                    b.this.alE.aH(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.alF = true;
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
