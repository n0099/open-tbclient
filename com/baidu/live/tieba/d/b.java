package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a bfg;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes4.dex */
    public interface a {
        void cg(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0186b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private final class C0186b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bfh;

        private C0186b() {
            this.bfh = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bfh = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.bfg != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bfh && scaleFactor > 1.0f) {
                    this.bfh = true;
                    b.this.bfg.cg(true);
                } else if (!this.bfh && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bfh = true;
                    b.this.bfg.cg(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bfh = true;
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
