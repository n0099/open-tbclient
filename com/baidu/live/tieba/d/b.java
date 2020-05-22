package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes3.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a aZF;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes3.dex */
    public interface a {
        void bZ(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0177b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private final class C0177b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean aZG;

        private C0177b() {
            this.aZG = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.aZG = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.aZF != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.aZG && scaleFactor > 1.0f) {
                    this.aZG = true;
                    b.this.aZF.bZ(true);
                } else if (!this.aZG && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.aZG = true;
                    b.this.aZF.bZ(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.aZG = true;
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
