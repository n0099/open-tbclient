package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes10.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a bDo;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes10.dex */
    public interface a {
        void cV(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0210b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private final class C0210b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bDp;

        private C0210b() {
            this.bDp = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bDp = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.bDo != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bDp && scaleFactor > 1.0f) {
                    this.bDp = true;
                    b.this.bDo.cV(true);
                } else if (!this.bDp && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bDp = true;
                    b.this.bDo.cV(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bDp = true;
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
