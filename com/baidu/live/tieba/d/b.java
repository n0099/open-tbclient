package com.baidu.live.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes10.dex */
public class b extends com.baidu.live.tieba.d.a {
    private a bIy;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes10.dex */
    public interface a {
        void dd(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0218b());
    }

    /* renamed from: com.baidu.live.tieba.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private final class C0218b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bIz;

        private C0218b() {
            this.bIz = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bIz = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.bIy != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bIz && scaleFactor > 1.0f) {
                    this.bIz = true;
                    b.this.bIy.dd(true);
                } else if (!this.bIz && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bIz = true;
                    b.this.bIy.dd(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bIz = true;
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
