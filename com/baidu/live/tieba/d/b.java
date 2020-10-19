package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a brz;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes4.dex */
    public interface a {
        void cu(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0201b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private final class C0201b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean brA;

        private C0201b() {
            this.brA = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.brA = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.brz != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.brA && scaleFactor > 1.0f) {
                    this.brA = true;
                    b.this.brz.cu(true);
                } else if (!this.brA && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.brA = true;
                    b.this.brz.cu(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.brA = true;
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
