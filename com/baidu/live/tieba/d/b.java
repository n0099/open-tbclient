package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes2.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a atn;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes2.dex */
    public interface a {
        void aY(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0090b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private final class C0090b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean ato;

        private C0090b() {
            this.ato = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.ato = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.atn != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.ato && scaleFactor > 1.0f) {
                    this.ato = true;
                    b.this.atn.aY(true);
                } else if (!this.ato && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.ato = true;
                    b.this.atn.aY(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.ato = true;
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
