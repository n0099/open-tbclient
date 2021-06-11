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
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
/* loaded from: classes2.dex */
public class LivenessXfordView extends FrameLayout {
    public static final String PROGRESS_PROPERTY = "progress";

    /* renamed from: a  reason: collision with root package name */
    public static final int f6130a = 12;
    public AnimatorSet A;
    public float B;
    public float C;

    /* renamed from: b  reason: collision with root package name */
    public float f6131b;

    /* renamed from: c  reason: collision with root package name */
    public Xfermode f6132c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f6133d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f6134e;

    /* renamed from: f  reason: collision with root package name */
    public int f6135f;

    /* renamed from: g  reason: collision with root package name */
    public int f6136g;

    /* renamed from: h  reason: collision with root package name */
    public float f6137h;

    /* renamed from: i  reason: collision with root package name */
    public float f6138i;
    public Handler j;
    public Runnable k;
    public float l;
    public boolean m;
    public Rect n;
    public Rect o;
    public Rect p;
    public float progress;
    public Paint q;
    public Paint r;
    public Paint s;
    public Paint t;
    public Paint u;
    public Paint v;
    public Paint w;
    public Paint x;
    public boolean y;
    public boolean z;

    public LivenessXfordView(@NonNull Context context) {
        super(context);
        this.f6131b = -90.0f;
        this.m = true;
        this.z = true;
        a();
    }

    public void debugDraw(Rect rect, Rect rect2, Rect rect3) {
        this.o = rect;
        this.p = rect2;
        this.n = rect3;
        invalidate();
    }

    public float getProgress() {
        return this.progress * 360.0f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f6133d;
        if (rectF == null || rectF.width() == 0.0f) {
            return;
        }
        if (this.z) {
            RectF rectF2 = this.f6134e;
            float f2 = rectF2.left;
            float f3 = this.l;
            canvas.drawRect(f2, f3, rectF2.right, f3 + rectF2.height(), this.u);
            RectF rectF3 = this.f6134e;
            float f4 = rectF3.left;
            float height = this.l + rectF3.height();
            RectF rectF4 = this.f6134e;
            canvas.drawLine(f4, height, rectF4.right, this.l + rectF4.height(), this.v);
        }
        if (this.y) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.t);
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.q);
        canvas.drawCircle(this.f6137h, this.f6138i, this.f6135f, this.w);
        canvas.restoreToCount(saveLayer);
        canvas.drawCircle(this.f6137h, this.f6138i, this.f6136g, this.s);
        canvas.drawArc(this.f6134e, this.f6131b, this.progress, false, this.r);
        if (this.n != null) {
            this.x.setColor(-16776961);
            canvas.drawRect(this.n, this.x);
        }
        if (this.o != null) {
            this.x.setColor(SupportMenu.CATEGORY_MASK);
            canvas.drawRect(this.o, this.x);
        }
        if (this.p != null) {
            this.x.setColor(-256);
            canvas.drawRect(this.p, this.x);
        }
    }

    public void release() {
        Handler handler = this.j;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.j = null;
        }
    }

    public void setFocusViewRect(Rect rect, Rect rect2) {
        if (rect == null || rect2 == null) {
            return;
        }
        this.f6133d = new RectF(rect);
        RectF rectF = new RectF(rect2);
        this.f6134e = rectF;
        this.B = rectF.top - rectF.height();
        RectF rectF2 = this.f6134e;
        this.C = rectF2.bottom - rectF2.height();
        this.l = this.B;
        RectF rectF3 = this.f6133d;
        this.f6137h = (rectF3.left + rectF3.right) / 2.0f;
        this.f6138i = (rectF3.top + rectF3.bottom) / 2.0f;
        this.f6135f = rect.width() / 2;
        this.f6136g = (rect.width() / 2) + ((rect2.width() - rect.width()) / 2);
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

    public void setMaskVisiable(boolean z) {
        this.y = z;
        invalidate();
    }

    public void setProgress(float f2) {
        this.progress = f2 * 360.0f;
        invalidate();
    }

    public void startAnimForCircleProgress() {
        this.j.removeCallbacksAndMessages(null);
        this.j.post(this.k);
    }

    public void stopXfordViewProgress() {
        AnimatorSet animatorSet = this.A;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void updateXfordViewProgress(float f2, float f3, long j, AnimatorListenerAdapter animatorListenerAdapter) {
        this.A = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "progress", f2, f3);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        if (animatorListenerAdapter != null) {
            this.A.addListener(animatorListenerAdapter);
        }
        this.A.play(ofFloat);
        this.A.start();
    }

    private void a() {
        Paint paint = new Paint();
        this.q = paint;
        paint.setColor(-1);
        this.q.setStyle(Paint.Style.FILL);
        this.q.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.r = paint2;
        paint2.setColor(Color.parseColor("#2EC5FA"));
        this.r.setStyle(Paint.Style.STROKE);
        this.r.setStrokeWidth(12.0f);
        this.r.setAntiAlias(true);
        this.r.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint();
        this.s = paint3;
        paint3.setColor(Color.parseColor("#E9EBF2"));
        this.s.setStyle(Paint.Style.STROKE);
        this.s.setStrokeWidth(12.0f);
        this.s.setAntiAlias(true);
        this.s.setStrokeCap(Paint.Cap.ROUND);
        Paint paint4 = new Paint();
        this.t = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.t.setColor(Color.parseColor("#99000000"));
        this.t.setAntiAlias(true);
        Paint paint5 = new Paint();
        this.u = paint5;
        paint5.setStyle(Paint.Style.FILL);
        this.u.setColor(Color.parseColor("#4DFFFFFF"));
        this.u.setAntiAlias(true);
        Paint paint6 = new Paint();
        this.v = paint6;
        paint6.setStrokeWidth(2.0f);
        this.v.setStyle(Paint.Style.STROKE);
        this.v.setColor(Color.parseColor("#FFFFFF"));
        this.v.setAntiAlias(true);
        Paint paint7 = new Paint();
        this.x = paint7;
        paint7.setStrokeWidth(4.0f);
        this.x.setStyle(Paint.Style.STROKE);
        this.x.setAntiAlias(true);
        Paint paint8 = new Paint();
        this.w = paint8;
        paint8.setColor(0);
        this.r.setAntiAlias(true);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.f6132c = porterDuffXfermode;
        this.w.setXfermode(porterDuffXfermode);
        this.j = new Handler(Looper.getMainLooper());
        this.k = new Runnable() { // from class: com.baidu.fsg.face.liveness.view.LivenessXfordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (LivenessXfordView.this.f6133d == null) {
                    LivenessXfordView.this.j.postDelayed(LivenessXfordView.this.k, 6L);
                    return;
                }
                LivenessXfordView livenessXfordView = LivenessXfordView.this;
                livenessXfordView.l = livenessXfordView.m ? LivenessXfordView.this.l + 3.0f : LivenessXfordView.this.l - 3.0f;
                if (LivenessXfordView.this.l <= LivenessXfordView.this.B) {
                    LivenessXfordView livenessXfordView2 = LivenessXfordView.this;
                    livenessXfordView2.l = livenessXfordView2.B;
                    LivenessXfordView.this.m = true;
                }
                if (LivenessXfordView.this.l >= LivenessXfordView.this.C) {
                    LivenessXfordView livenessXfordView3 = LivenessXfordView.this;
                    livenessXfordView3.l = livenessXfordView3.C;
                    LivenessXfordView.this.m = false;
                }
                LivenessXfordView.this.j.postDelayed(LivenessXfordView.this.k, 6L);
                LivenessXfordView.this.invalidate();
            }
        };
        startAnimForCircleProgress();
    }

    public LivenessXfordView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6131b = -90.0f;
        this.m = true;
        this.z = true;
        a();
    }
}
