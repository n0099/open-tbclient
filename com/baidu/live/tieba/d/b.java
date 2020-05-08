package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes3.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a aSr;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes3.dex */
    public interface a {
        void bP(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0144b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private final class C0144b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean aSs;

        private C0144b() {
            this.aSs = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.aSs = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.aSr != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.aSs && scaleFactor > 1.0f) {
                    this.aSs = true;
                    b.this.aSr.bP(true);
                } else if (!this.aSs && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.aSs = true;
                    b.this.aSr.bP(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.aSs = true;
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
