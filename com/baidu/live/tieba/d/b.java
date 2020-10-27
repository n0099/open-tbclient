package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a btF;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes4.dex */
    public interface a {
        void cz(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0202b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private final class C0202b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean btG;

        private C0202b() {
            this.btG = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.btG = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.btF != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.btG && scaleFactor > 1.0f) {
                    this.btG = true;
                    b.this.btF.cz(true);
                } else if (!this.btG && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.btG = true;
                    b.this.btF.cz(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.btG = true;
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
