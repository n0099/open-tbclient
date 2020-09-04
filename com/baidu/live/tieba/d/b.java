package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes7.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a bkT;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes7.dex */
    public interface a {
        void cq(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0193b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private final class C0193b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bkU;

        private C0193b() {
            this.bkU = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bkU = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.bkT != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bkU && scaleFactor > 1.0f) {
                    this.bkU = true;
                    b.this.bkT.cq(true);
                } else if (!this.bkU && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bkU = true;
                    b.this.bkT.cq(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bkU = true;
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
