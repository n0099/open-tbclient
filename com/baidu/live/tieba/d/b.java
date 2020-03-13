package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes3.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a ayr;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes3.dex */
    public interface a {
        void bk(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0097b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private final class C0097b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean ays;

        private C0097b() {
            this.ays = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.ays = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.ayr != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.ays && scaleFactor > 1.0f) {
                    this.ays = true;
                    b.this.ayr.bk(true);
                } else if (!this.ays && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.ays = true;
                    b.this.ayr.bk(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.ays = true;
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
