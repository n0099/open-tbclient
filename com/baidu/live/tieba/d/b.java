package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes11.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a bIa;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes11.dex */
    public interface a {
        void cZ(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0219b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private final class C0219b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bIb;

        private C0219b() {
            this.bIb = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bIb = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.bIa != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bIb && scaleFactor > 1.0f) {
                    this.bIb = true;
                    b.this.bIa.cZ(true);
                } else if (!this.bIb && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bIb = true;
                    b.this.bIa.cZ(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bIb = true;
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
