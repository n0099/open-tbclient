package com.baidu.fsg.face.liveness.view;

import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
/* loaded from: classes17.dex */
public class LivenessXfordView extends FrameLayout {
    public static final String PROGRESS_PROPERTY = "progress";

    /* renamed from: a  reason: collision with root package name */
    private static final int f1762a = 12;
    private AnimatorSet A;
    private float B;
    private float C;
    private float b;
    private Xfermode c;
    private RectF d;
    private RectF e;
    private int f;
    private int g;
    private float h;
    private float i;
    private Handler j;
    private Runnable k;
    private float l;
    private boolean m;
    private Rect n;
    private Rect o;
    private Rect p;
    protected float progress;
    private Paint q;
    private Paint r;
    private Paint s;
    private Paint t;
    private Paint u;
    private Paint v;
    private Paint w;
    private Paint x;
    private boolean y;
    private boolean z;

    public LivenessXfordView(@NonNull Context context) {
        super(context);
        this.b = -90.0f;
        this.m = true;
        this.z = true;
        a();
    }

    public LivenessXfordView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -90.0f;
        this.m = true;
        this.z = true;
        a();
    }

    private void a() {
        this.q = new Paint();
        this.q.setColor(-1);
        this.q.setStyle(Paint.Style.FILL);
        this.q.setAntiAlias(true);
        this.r = new Paint();
        this.r.setColor(Color.parseColor("#2EC5FA"));
        this.r.setStyle(Paint.Style.STROKE);
        this.r.setStrokeWidth(12.0f);
        this.r.setAntiAlias(true);
        this.r.setStrokeCap(Paint.Cap.ROUND);
        this.s = new Paint();
        this.s.setColor(Color.parseColor("#E9EBF2"));
        this.s.setStyle(Paint.Style.STROKE);
        this.s.setStrokeWidth(12.0f);
        this.s.setAntiAlias(true);
        this.s.setStrokeCap(Paint.Cap.ROUND);
        this.t = new Paint();
        this.t.setStyle(Paint.Style.FILL);
        this.t.setColor(Color.parseColor("#99000000"));
        this.t.setAntiAlias(true);
        this.u = new Paint();
        this.u.setStyle(Paint.Style.FILL);
        this.u.setColor(Color.parseColor("#4DFFFFFF"));
        this.u.setAntiAlias(true);
        this.v = new Paint();
        this.v.setStrokeWidth(2.0f);
        this.v.setStyle(Paint.Style.STROKE);
        this.v.setColor(Color.parseColor("#FFFFFF"));
        this.v.setAntiAlias(true);
        this.x = new Paint();
        this.x.setStrokeWidth(4.0f);
        this.x.setStyle(Paint.Style.STROKE);
        this.x.setAntiAlias(true);
        this.w = new Paint();
        this.w.setColor(0);
        this.r.setAntiAlias(true);
        this.c = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.w.setXfermode(this.c);
        this.j = new Handler(Looper.getMainLooper());
        this.k = new Runnable() { // from class: com.baidu.fsg.face.liveness.view.LivenessXfordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (LivenessXfordView.this.d == null) {
                    LivenessXfordView.this.j.postDelayed(LivenessXfordView.this.k, 6L);
                    return;
                }
                LivenessXfordView.this.l = LivenessXfordView.this.m ? LivenessXfordView.this.l + 3.0f : LivenessXfordView.this.l - 3.0f;
                if (LivenessXfordView.this.l <= LivenessXfordView.this.B) {
                    LivenessXfordView.this.l = LivenessXfordView.this.B;
                    LivenessXfordView.this.m = true;
                }
                if (LivenessXfordView.this.l >= LivenessXfordView.this.C) {
                    LivenessXfordView.this.l = LivenessXfordView.this.C;
                    LivenessXfordView.this.m = false;
                }
                LivenessXfordView.this.j.postDelayed(LivenessXfordView.this.k, 6L);
                LivenessXfordView.this.invalidate();
            }
        };
        startAnimForCircleProgress();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.d != null && this.d.width() != 0.0f) {
            if (this.z) {
                canvas.drawRect(this.e.left, this.l, this.e.right, this.e.height() + this.l, this.u);
                canvas.drawLine(this.e.left, this.e.height() + this.l, this.e.right, this.e.height() + this.l, this.v);
            }
            if (this.y) {
                canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.t);
            }
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.q);
            canvas.drawCircle(this.h, this.i, this.f, this.w);
            canvas.restoreToCount(saveLayer);
            canvas.drawCircle(this.h, this.i, this.g, this.s);
            canvas.drawArc(this.e, this.b, this.progress, false, this.r);
            if (this.n != null) {
                this.x.setColor(-16776961);
                canvas.drawRect(this.n, this.x);
            }
            if (this.o != null) {
                this.x.setColor(SupportMenu.CATEGORY_MASK);
                canvas.drawRect(this.o, this.x);
            }
            if (this.p != null) {
                this.x.setColor(InputDeviceCompat.SOURCE_ANY);
                canvas.drawRect(this.p, this.x);
            }
        }
    }

    public void setFocusViewRect(Rect rect, Rect rect2) {
        if (rect != null && rect2 != null) {
            this.d = new RectF(rect);
            this.e = new RectF(rect2);
            this.B = this.e.top - this.e.height();
            this.C = this.e.bottom - this.e.height();
            this.l = this.B;
            this.h = (this.d.left + this.d.right) / 2.0f;
            this.i = (this.d.top + this.d.bottom) / 2.0f;
            this.f = rect.width() / 2;
            this.g = (rect.width() / 2) + ((rect2.width() - rect.width()) / 2);
            invalidate();
        }
    }

    public float getProgress() {
        return this.progress * 360.0f;
    }

    public void setProgress(float f) {
        this.progress = 360.0f * f;
        invalidate();
    }

    public void setMaskVisiable(boolean z) {
        this.y = z;
        invalidate();
    }

    public void setLineVisiable(boolean z) {
        this.z = z;
        if (z) {
            this.l = this.B;
            startAnimForCircleProgress();
        } else {
            this.j.removeCallbacksAndMessages(null);
        }
        invalidate();
    }

    public void updateXfordViewProgress(float f, float f2, long j, AnimatorListenerAdapter animatorListenerAdapter) {
        this.A = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "progress", f, f2);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        if (animatorListenerAdapter != null) {
            this.A.addListener(animatorListenerAdapter);
        }
        this.A.play(ofFloat);
        this.A.start();
    }

    public void stopXfordViewProgress() {
        if (this.A != null) {
            this.A.cancel();
        }
    }

    public void startAnimForCircleProgress() {
        this.j.removeCallbacksAndMessages(null);
        this.j.post(this.k);
    }

    public void debugDraw(Rect rect, Rect rect2, Rect rect3) {
        this.o = rect;
        this.p = rect2;
        this.n = rect3;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void release() {
        if (this.j != null) {
            this.j.removeCallbacksAndMessages(null);
            this.j = null;
        }
    }
}
