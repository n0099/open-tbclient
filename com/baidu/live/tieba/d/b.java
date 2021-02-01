package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes11.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a bGY;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes11.dex */
    public interface a {
        void dd(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0212b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private final class C0212b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bGZ;

        private C0212b() {
            this.bGZ = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bGZ = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.bGY != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bGZ && scaleFactor > 1.0f) {
                    this.bGZ = true;
                    b.this.bGY.dd(true);
                } else if (!this.bGZ && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bGZ = true;
                    b.this.bGY.dd(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bGZ = true;
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
