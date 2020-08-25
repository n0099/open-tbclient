package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes7.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a bkQ;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes7.dex */
    public interface a {
        void cp(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0193b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private final class C0193b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bkR;

        private C0193b() {
            this.bkR = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bkR = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.bkQ != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bkR && scaleFactor > 1.0f) {
                    this.bkR = true;
                    b.this.bkQ.cp(true);
                } else if (!this.bkR && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bkR = true;
                    b.this.bkQ.cp(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bkR = true;
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
