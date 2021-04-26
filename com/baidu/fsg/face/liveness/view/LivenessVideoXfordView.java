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
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class LivenessVideoXfordView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final float f6322a = 230.0f;

    /* renamed from: b  reason: collision with root package name */
    public static final float f6323b = 20.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f6324c;

    /* renamed from: d  reason: collision with root package name */
    public float f6325d;

    /* renamed from: e  reason: collision with root package name */
    public int f6326e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f6327f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f6328g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f6329h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f6330i;
    public Paint j;
    public Xfermode k;
    public RectF l;
    public RectF m;
    public VideoXfordViewState n;
    public int o;
    public int p;
    public Handler q;
    public Runnable r;
    public int s;
    public Handler t;
    public Runnable u;
    public int v;
    public a w;

    /* loaded from: classes2.dex */
    public enum VideoXfordViewState {
        FAILURE,
        SUCCESSING,
        SUCCESSED
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public LivenessVideoXfordView(@NonNull Context context) {
        super(context);
        this.f6324c = 230.0f;
        this.f6325d = 20.0f;
        a();
    }

    public static /* synthetic */ int d(LivenessVideoXfordView livenessVideoXfordView) {
        int i2 = livenessVideoXfordView.s;
        livenessVideoXfordView.s = i2 + 1;
        return i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.l;
        if (rectF == null || rectF.width() == 0.0f) {
            return;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f6327f);
        RectF rectF2 = this.l;
        canvas.drawCircle(getWidth() / 2, rectF2.top + (rectF2.height() / 2.0f), this.o, this.f6328g);
        canvas.restoreToCount(saveLayer);
        VideoXfordViewState videoXfordViewState = this.n;
        if (videoXfordViewState == VideoXfordViewState.FAILURE) {
            if (this.p >= 0) {
                this.f6330i.setAlpha(255);
                RectF rectF3 = this.l;
                canvas.drawCircle(getWidth() / 2, rectF3.top + (rectF3.height() / 2.0f), this.m.width() / 2.0f, this.f6330i);
                this.j.setAlpha(220 - (this.p * 11));
                RectF rectF4 = this.l;
                canvas.drawCircle(getWidth() / 2, rectF4.top + (rectF4.height() / 2.0f), (this.m.width() / 2.0f) + ((int) ((getHeight() - this.l.width()) * this.p * 0.025d)), this.j);
            }
        } else if (videoXfordViewState == VideoXfordViewState.SUCCESSING) {
            canvas.drawArc(this.m, this.f6324c, this.f6325d, false, this.f6329h);
            canvas.drawArc(this.m, (this.f6324c + 180.0f) % 360.0f, this.f6325d, false, this.f6329h);
        } else if (videoXfordViewState == VideoXfordViewState.SUCCESSED) {
            RectF rectF5 = this.l;
            canvas.drawCircle(getWidth() / 2, rectF5.top + (rectF5.height() / 2.0f), this.m.width() / 2.0f, this.f6329h);
        }
    }

    public void release() {
        Handler handler = this.t;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.t = null;
        }
        Handler handler2 = this.q;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.q = null;
        }
    }

    public void setFocusViewRect(Rect rect) {
        if (rect == null) {
            return;
        }
        this.l = new RectF(rect);
        int i2 = rect.left;
        int i3 = this.f6326e;
        this.m = new RectF(i2 - i3, rect.top - i3, rect.right + i3, rect.bottom + i3);
        this.o = rect.width() / 2;
        invalidate();
    }

    public void updateXfordViewState(VideoXfordViewState videoXfordViewState, a aVar) {
        if (this.n == videoXfordViewState) {
            return;
        }
        this.n = videoXfordViewState;
        if (videoXfordViewState == VideoXfordViewState.FAILURE) {
            this.s = 0;
            this.t.removeCallbacksAndMessages(null);
            b();
        } else if (videoXfordViewState == VideoXfordViewState.SUCCESSING) {
            this.w = aVar;
            this.f6324c = 20.0f;
            this.f6325d = 20.0f;
            this.q.removeCallbacksAndMessages(null);
            c();
        } else if (videoXfordViewState == VideoXfordViewState.SUCCESSED) {
            this.q.removeCallbacksAndMessages(null);
            d();
        }
    }

    private void d() {
        invalidate();
    }

    private void c() {
        this.t.removeCallbacksAndMessages(null);
        this.t.post(this.u);
    }

    private void a() {
        this.f6326e = getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_xfordview_circle_gap);
        Paint paint = new Paint();
        this.f6327f = paint;
        paint.setColor(Color.rgb(255, 255, 255));
        this.f6327f.setStyle(Paint.Style.FILL);
        this.f6327f.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f6328g = paint2;
        paint2.setColor(Color.argb(0, 0, 0, 0));
        this.f6328g.setStyle(Paint.Style.FILL);
        this.f6328g.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f6329h = paint3;
        paint3.setColor(Color.rgb(103, 155, (int) GDiffPatcher.COPY_INT_UBYTE));
        this.f6329h.setStyle(Paint.Style.STROKE);
        this.f6329h.setStrokeWidth(12.0f);
        this.f6329h.setAntiAlias(true);
        Paint paint4 = new Paint();
        this.f6330i = paint4;
        paint4.setColor(Color.rgb((int) GDiffPatcher.COPY_USHORT_INT, 90, 92));
        this.f6330i.setStyle(Paint.Style.STROKE);
        this.f6330i.setStrokeWidth(12.0f);
        this.f6330i.setAntiAlias(true);
        Paint paint5 = new Paint();
        this.j = paint5;
        paint5.setColor(Color.rgb((int) GDiffPatcher.COPY_USHORT_INT, 90, 92));
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setStrokeWidth(4.0f);
        this.j.setAntiAlias(true);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.k = porterDuffXfermode;
        this.f6328g.setXfermode(porterDuffXfermode);
        this.q = new Handler(Looper.getMainLooper());
        this.r = new Runnable() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoXfordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (LivenessVideoXfordView.this.s >= 20) {
                    LivenessVideoXfordView.this.s = 0;
                    LivenessVideoXfordView livenessVideoXfordView = LivenessVideoXfordView.this;
                    livenessVideoXfordView.p = livenessVideoXfordView.s;
                    LivenessVideoXfordView.this.invalidate();
                    LivenessVideoXfordView.this.q.postDelayed(LivenessVideoXfordView.this.r, 120L);
                    return;
                }
                LivenessVideoXfordView livenessVideoXfordView2 = LivenessVideoXfordView.this;
                livenessVideoXfordView2.p = livenessVideoXfordView2.s;
                LivenessVideoXfordView.d(LivenessVideoXfordView.this);
                LivenessVideoXfordView.this.invalidate();
                LivenessVideoXfordView.this.q.postDelayed(LivenessVideoXfordView.this.r, 120L);
            }
        };
        this.t = new Handler(Looper.getMainLooper());
        this.u = new Runnable() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoXfordView.2
            @Override // java.lang.Runnable
            public void run() {
                LivenessVideoXfordView livenessVideoXfordView;
                LivenessVideoXfordView livenessVideoXfordView2;
                if (LivenessVideoXfordView.this.v >= 160) {
                    LivenessVideoXfordView.this.v = 0;
                    if (LivenessVideoXfordView.this.w != null) {
                        LivenessVideoXfordView.this.w.a();
                        return;
                    }
                    return;
                }
                LivenessVideoXfordView.this.v += 2;
                LivenessVideoXfordView.this.f6325d = livenessVideoXfordView.v + 20.0f;
                LivenessVideoXfordView.this.f6324c = ((livenessVideoXfordView2.v * 1) + 230.0f) % 360.0f;
                LivenessVideoXfordView.this.invalidate();
                LivenessVideoXfordView.this.t.postDelayed(LivenessVideoXfordView.this.u, 3L);
            }
        };
        updateXfordViewState(VideoXfordViewState.FAILURE, null);
    }

    private void b() {
        this.q.removeCallbacksAndMessages(null);
        this.q.post(this.r);
    }

    public LivenessVideoXfordView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6324c = 230.0f;
        this.f6325d = 20.0f;
        a();
    }
}
