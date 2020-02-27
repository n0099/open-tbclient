package com.baidu.sapi2.views;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.animation.LinearInterpolator;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes6.dex */
public class RippleSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private SurfaceHolder a;
    private Canvas b;
    private Paint c;
    private boolean d;
    private Path[] e;
    private int f;
    private int g;
    private int h;
    private int i;
    private ValueAnimator j;

    public RippleSurfaceView(Context context) {
        this(context, null);
    }

    @TargetApi(5)
    private void b() {
        this.a = getHolder();
        this.a.addCallback(this);
        setZOrderOnTop(true);
        this.a.setFormat(-3);
        this.e = new Path[]{new Path(), new Path(), new Path()};
        this.c = new Paint();
        this.c.setAntiAlias(true);
        this.c.setColor(Color.parseColor("#3388FF"));
        this.c.setStyle(Paint.Style.STROKE);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setKeepScreenOn(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.d) {
            this.h += 50;
            a(this.h);
            a();
        }
    }

    @TargetApi(11)
    public void setAmplitude(int i) {
        int i2 = i / 100;
        int i3 = i2 >= 5 ? i2 : 5;
        int i4 = i3 <= 100 ? i3 : 100;
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.j = ValueAnimator.ofInt(this.i, i4);
            this.j.setInterpolator(new LinearInterpolator());
            this.j.addUpdateListener(new g(this));
            this.j.setDuration(500L).start();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.d = true;
        new Thread(this).start();
    }

    @Override // android.view.SurfaceHolder.Callback
    @TargetApi(11)
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.d = false;
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
    }

    public RippleSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    private void a(int i) {
        this.e[0] = new Path();
        this.e[1] = new Path();
        this.e[2] = new Path();
        for (int i2 = 0; i2 < 2000; i2++) {
            this.f++;
            double d = i;
            this.g = (int) ((this.i * Math.sin((((this.f * 0.7d) * 3.141592653589793d) / 180.0d) + d)) + 100.0d);
            int i3 = this.f;
            if (i3 == 1) {
                this.e[0].moveTo(i3, this.g);
            }
            this.e[0].lineTo(this.f, this.g);
            this.g = (int) (((this.i - 5) * Math.sin((((this.f * 0.7d) * 3.141592653589793d) / 180.0d) + (d - 0.3d))) + 100.0d);
            int i4 = this.f;
            if (i4 == 1) {
                this.e[1].moveTo(i4, this.g);
            }
            this.e[1].lineTo(this.f, this.g);
            this.g = (int) (((this.i - 10) * Math.sin((((this.f * 0.7d) * 3.141592653589793d) / 180.0d) + (d - 0.6d))) + 100.0d);
            int i5 = this.f;
            if (i5 == 1) {
                this.e[2].moveTo(i5, this.g);
            }
            this.e[2].lineTo(this.f, this.g);
        }
        this.f = 0;
    }

    public RippleSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, IF] complete} */
    private void a() {
        Canvas canvas;
        try {
            try {
                this.b = this.a.lockCanvas();
                if (this.b != null) {
                    this.b.drawColor(-1);
                    for (int i = 0; i < 3; i++) {
                        if (i == 0) {
                            this.c.setAlpha(255);
                            this.c.setStrokeWidth(SapiUtils.dip2px(getContext(), 2.0f));
                            this.b.drawPath(this.e[0], this.c);
                        }
                        if (i == 1) {
                            this.c.setAlpha(102);
                            this.c.setStrokeWidth(SapiUtils.dip2px(getContext(), 1.0f));
                            this.b.drawPath(this.e[1], this.c);
                        }
                        if (i == 2) {
                            this.c.setAlpha(102);
                            this.c.setStrokeWidth(SapiUtils.dip2px(getContext(), 1.0f));
                            this.b.drawPath(this.e[2], this.c);
                        }
                    }
                }
                canvas = this.b;
                if (canvas == null) {
                    return;
                }
            } catch (Exception e) {
                Log.e(e);
                canvas = this.b;
                if (canvas == null) {
                    return;
                }
            }
            this.a.unlockCanvasAndPost(canvas);
        } catch (Throwable th) {
            Canvas canvas2 = this.b;
            if (canvas2 != null) {
                this.a.unlockCanvasAndPost(canvas2);
            }
            throw th;
        }
    }
}
