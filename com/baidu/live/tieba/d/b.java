package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes2.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a atZ;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes2.dex */
    public interface a {
        void bc(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0091b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private final class C0091b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean aua;

        private C0091b() {
            this.aua = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.aua = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.atZ != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.aua && scaleFactor > 1.0f) {
                    this.aua = true;
                    b.this.atZ.bc(true);
                } else if (!this.aua && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.aua = true;
                    b.this.atZ.bc(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.aua = true;
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
