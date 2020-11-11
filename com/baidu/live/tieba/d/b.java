package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a bzR;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes4.dex */
    public interface a {
        void cG(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0214b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private final class C0214b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bzS;

        private C0214b() {
            this.bzS = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bzS = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.bzR != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bzS && scaleFactor > 1.0f) {
                    this.bzS = true;
                    b.this.bzR.cG(true);
                } else if (!this.bzS && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bzS = true;
                    b.this.bzR.cG(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bzS = true;
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
