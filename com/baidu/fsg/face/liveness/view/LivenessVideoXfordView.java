package com.baidu.fsg.face.liveness.view;

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
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes17.dex */
public class LivenessVideoXfordView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final float f1759a = 230.0f;
    private static final float b = 20.0f;
    private float c;
    private float d;
    private int e;
    private Paint f;
    private Paint g;
    private Paint h;
    private Paint i;
    private Paint j;
    private Xfermode k;
    private RectF l;
    private RectF m;
    private VideoXfordViewState n;
    private int o;
    private int p;
    private Handler q;
    private Runnable r;
    private int s;
    private Handler t;
    private Runnable u;
    private int v;
    private a w;

    /* loaded from: classes17.dex */
    public enum VideoXfordViewState {
        FAILURE,
        SUCCESSING,
        SUCCESSED
    }

    /* loaded from: classes17.dex */
    public interface a {
        void a();
    }

    static /* synthetic */ int d(LivenessVideoXfordView livenessVideoXfordView) {
        int i = livenessVideoXfordView.s;
        livenessVideoXfordView.s = i + 1;
        return i;
    }

    public LivenessVideoXfordView(@NonNull Context context) {
        super(context);
        this.c = f1759a;
        this.d = b;
        a();
    }

    public LivenessVideoXfordView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = f1759a;
        this.d = b;
        a();
    }

    private void a() {
        this.e = getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_xfordview_circle_gap);
        this.f = new Paint();
        this.f.setColor(Color.rgb(255, 255, 255));
        this.f.setStyle(Paint.Style.FILL);
        this.f.setAntiAlias(true);
        this.g = new Paint();
        this.g.setColor(Color.argb(0, 0, 0, 0));
        this.g.setStyle(Paint.Style.FILL);
        this.g.setAntiAlias(true);
        this.h = new Paint();
        this.h.setColor(Color.rgb(103, 155, (int) GDiffPatcher.COPY_INT_UBYTE));
        this.h.setStyle(Paint.Style.STROKE);
        this.h.setStrokeWidth(12.0f);
        this.h.setAntiAlias(true);
        this.i = new Paint();
        this.i.setColor(Color.rgb((int) GDiffPatcher.COPY_USHORT_INT, 90, 92));
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setStrokeWidth(12.0f);
        this.i.setAntiAlias(true);
        this.j = new Paint();
        this.j.setColor(Color.rgb((int) GDiffPatcher.COPY_USHORT_INT, 90, 92));
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setStrokeWidth(4.0f);
        this.j.setAntiAlias(true);
        this.k = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.g.setXfermode(this.k);
        this.q = new Handler(Looper.getMainLooper());
        this.r = new Runnable() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoXfordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (LivenessVideoXfordView.this.s >= 20) {
                    LivenessVideoXfordView.this.s = 0;
                    LivenessVideoXfordView.this.p = LivenessVideoXfordView.this.s;
                    LivenessVideoXfordView.this.invalidate();
                    LivenessVideoXfordView.this.q.postDelayed(LivenessVideoXfordView.this.r, 120L);
                    return;
                }
                LivenessVideoXfordView.this.p = LivenessVideoXfordView.this.s;
                LivenessVideoXfordView.d(LivenessVideoXfordView.this);
                LivenessVideoXfordView.this.invalidate();
                LivenessVideoXfordView.this.q.postDelayed(LivenessVideoXfordView.this.r, 120L);
            }
        };
        this.t = new Handler(Looper.getMainLooper());
        this.u = new Runnable() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoXfordView.2
            @Override // java.lang.Runnable
            public void run() {
                if (LivenessVideoXfordView.this.v >= 160) {
                    LivenessVideoXfordView.this.v = 0;
                    if (LivenessVideoXfordView.this.w != null) {
                        LivenessVideoXfordView.this.w.a();
                        return;
                    }
                    return;
                }
                LivenessVideoXfordView.this.v += 2;
                LivenessVideoXfordView.this.d = LivenessVideoXfordView.b + LivenessVideoXfordView.this.v;
                LivenessVideoXfordView.this.c = (LivenessVideoXfordView.f1759a + (LivenessVideoXfordView.this.v * 1)) % 360.0f;
                LivenessVideoXfordView.this.invalidate();
                LivenessVideoXfordView.this.t.postDelayed(LivenessVideoXfordView.this.u, 3L);
            }
        };
        updateXfordViewState(VideoXfordViewState.FAILURE, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.l != null && this.l.width() != 0.0f) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f);
            canvas.drawCircle(getWidth() / 2, this.l.top + (this.l.height() / 2.0f), this.o, this.g);
            canvas.restoreToCount(saveLayer);
            if (this.n == VideoXfordViewState.FAILURE) {
                if (this.p >= 0) {
                    this.i.setAlpha(255);
                    canvas.drawCircle(getWidth() / 2, this.l.top + (this.l.height() / 2.0f), this.m.width() / 2.0f, this.i);
                    this.j.setAlpha(220 - (this.p * 11));
                    canvas.drawCircle(getWidth() / 2, this.l.top + (this.l.height() / 2.0f), ((int) ((getHeight() - this.l.width()) * this.p * 0.025d)) + (this.m.width() / 2.0f), this.j);
                }
            } else if (this.n == VideoXfordViewState.SUCCESSING) {
                canvas.drawArc(this.m, this.c, this.d, false, this.h);
                canvas.drawArc(this.m, (this.c + 180.0f) % 360.0f, this.d, false, this.h);
            } else if (this.n == VideoXfordViewState.SUCCESSED) {
                canvas.drawCircle(getWidth() / 2, this.l.top + (this.l.height() / 2.0f), this.m.width() / 2.0f, this.h);
            }
        }
    }

    public void setFocusViewRect(Rect rect) {
        if (rect != null) {
            this.l = new RectF(rect);
            this.m = new RectF(rect.left - this.e, rect.top - this.e, rect.right + this.e, rect.bottom + this.e);
            this.o = rect.width() / 2;
            invalidate();
        }
    }

    public void updateXfordViewState(VideoXfordViewState videoXfordViewState, a aVar) {
        if (this.n != videoXfordViewState) {
            this.n = videoXfordViewState;
            if (this.n == VideoXfordViewState.FAILURE) {
                this.s = 0;
                this.t.removeCallbacksAndMessages(null);
                b();
            } else if (this.n == VideoXfordViewState.SUCCESSING) {
                this.w = aVar;
                this.c = b;
                this.d = b;
                this.q.removeCallbacksAndMessages(null);
                c();
            } else if (this.n == VideoXfordViewState.SUCCESSED) {
                this.q.removeCallbacksAndMessages(null);
                d();
            }
        }
    }

    private void b() {
        this.q.removeCallbacksAndMessages(null);
        this.q.post(this.r);
    }

    private void c() {
        this.t.removeCallbacksAndMessages(null);
        this.t.post(this.u);
    }

    private void d() {
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void release() {
        if (this.t != null) {
            this.t.removeCallbacksAndMessages(null);
            this.t = null;
        }
        if (this.q != null) {
            this.q.removeCallbacksAndMessages(null);
            this.q = null;
        }
    }
}
