package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.sapi2.result.OneKeyLoginResult;
import java.util.List;
/* loaded from: classes17.dex */
public class LrcView extends FrameLayout {
    private static int A = 12;
    private static int B;

    /* renamed from: a  reason: collision with root package name */
    boolean f1772a;
    boolean b;
    boolean c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    int l;
    Runnable m;
    private int n;
    private int o;
    private List<String> p;
    private int q;
    private a r;
    private Paint s;
    private Paint t;
    private Paint u;
    private float[] v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* loaded from: classes17.dex */
    public interface a {
        void a();
    }

    static /* synthetic */ int d(LrcView lrcView) {
        int i = lrcView.q;
        lrcView.q = i + 1;
        return i;
    }

    public LrcView(@NonNull Context context) {
        super(context);
        this.f1772a = false;
        this.b = false;
        this.c = false;
        this.d = 255;
        this.e = 127;
        this.y = 72;
        this.z = 54;
        this.m = new Runnable() { // from class: com.baidu.fsg.face.liveness.view.LrcView.1
            @Override // java.lang.Runnable
            public void run() {
                if (LrcView.this.q >= LrcView.this.p.size() - 1) {
                    if (LrcView.this.r != null) {
                        LrcView.this.r.a();
                        return;
                    }
                    return;
                }
                LrcView.this.b = false;
                LrcView.d(LrcView.this);
                LrcView.this.toInvalidate();
                LrcView.this.f1772a = false;
            }
        };
        a();
    }

    public LrcView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1772a = false;
        this.b = false;
        this.c = false;
        this.d = 255;
        this.e = 127;
        this.y = 72;
        this.z = 54;
        this.m = new Runnable() { // from class: com.baidu.fsg.face.liveness.view.LrcView.1
            @Override // java.lang.Runnable
            public void run() {
                if (LrcView.this.q >= LrcView.this.p.size() - 1) {
                    if (LrcView.this.r != null) {
                        LrcView.this.r.a();
                        return;
                    }
                    return;
                }
                LrcView.this.b = false;
                LrcView.d(LrcView.this);
                LrcView.this.toInvalidate();
                LrcView.this.f1772a = false;
            }
        };
        a();
    }

    private void a() {
        this.y = getResources().getDimensionPixelSize(R.dimen.rim_text_size_24);
        this.z = getResources().getDimensionPixelSize(R.dimen.rim_text_size_18);
        this.s = new Paint();
        this.s.setColor(Color.rgb(255, 255, 255));
        this.s.setTextSize(this.y);
        this.s.setTextAlign(Paint.Align.CENTER);
        this.s.setAntiAlias(true);
        this.t = new Paint();
        this.t.setColor(Color.argb(150, 0, 0, 0));
        this.t.setAntiAlias(true);
        this.v = new float[6];
        this.u = new Paint();
        this.u.setStyle(Paint.Style.FILL);
        this.w = getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrcview_circle_point_radius);
        this.x = getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrcview_circle_point_gap);
        A = this.y - this.z;
        B = getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_text_gap);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.n = getMeasuredWidth();
        this.o = getMeasuredHeight();
        this.v[0] = ((this.n / 2) - this.x) - (this.w * 2);
        this.v[1] = this.o / 2;
        this.v[2] = this.n / 2;
        this.v[3] = this.o / 2;
        this.v[4] = (this.n / 2) + this.x + (this.w * 2);
        this.v[5] = this.o / 2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.n / 2, (this.o / 2) + getScrollY(), this.n / 2, this.t);
        if (this.p != null && this.p.size() != 0) {
            a(canvas, this.p);
            if (!this.c) {
                if (this.b && !this.f1772a) {
                    this.f1772a = true;
                    if (this.q == 0) {
                        getHandler().postDelayed(this.m, 200L);
                        return;
                    } else if (this.p != null && this.q >= 0 && this.q <= this.p.size()) {
                        getHandler().postDelayed(this.m, (long) (this.p.get(this.q).length() * 0.25d * 1000.0d));
                        return;
                    } else {
                        getHandler().postDelayed(this.m, 2000L);
                        return;
                    }
                }
                postInvalidateDelayed(10L);
            }
        }
    }

    private void a(Canvas canvas, List<String> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (this.q == 0) {
                    if (i2 == 0) {
                        if (this.f < 108) {
                            this.f += 2;
                        } else if (this.f >= 108 && this.f <= 144) {
                            this.f += 2;
                        } else {
                            this.b = true;
                        }
                        this.u.setColor(Color.argb(111, 255, 255, 255));
                        canvas.drawCircle(this.v[0], this.v[1], this.w, this.u);
                        canvas.drawCircle(this.v[2], this.v[3], this.w, this.u);
                        canvas.drawCircle(this.v[4], this.v[5], this.w, this.u);
                        if (this.f >= 144) {
                            this.u.setColor(Color.argb(255, 255, 255, 255));
                            canvas.drawCircle(this.v[0], this.v[1], this.w, this.u);
                            canvas.drawCircle(this.v[2], this.v[3], this.w, this.u);
                            canvas.drawCircle(this.v[4], this.v[5], this.w, this.u);
                        } else if (this.f >= 108) {
                            this.u.setColor(Color.argb(255, 255, 255, 255));
                            canvas.drawCircle(this.v[0], this.v[1], this.w, this.u);
                            canvas.drawCircle(this.v[2], this.v[3], this.w, this.u);
                            this.u.setAlpha(((int) (((this.f + OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CHECK_SIGN_FAIL) / 36.0f) * 144.0f)) + 111);
                            canvas.drawCircle(this.v[4], this.v[5], this.w, this.u);
                        } else if (this.f >= 72) {
                            this.u.setColor(Color.argb(255, 255, 255, 255));
                            canvas.drawCircle(this.v[0], this.v[1], this.w, this.u);
                            this.u.setAlpha(((int) (((this.f - 72) / 36.0f) * 144.0f)) + 111);
                            canvas.drawCircle(this.v[2], this.v[3], this.w, this.u);
                        } else if (this.f >= 36) {
                            this.u.setAlpha(((int) (((this.f - 36) / 36.0f) * 144.0f)) + 111);
                            this.u.setColor(Color.argb(255, 255, 255, 255));
                            canvas.drawCircle(this.v[0], this.v[1], this.w, this.u);
                        }
                    } else if (i2 == 1) {
                        if (this.h <= A) {
                            this.s.setTextSize(this.z);
                            this.s.setAlpha(this.e);
                            canvas.drawText(list.get(1), this.n / 2, (this.o / 2) + B + ((B * (A - this.h)) / A), this.s);
                            this.h++;
                        } else {
                            this.s.setTextSize(this.z);
                            this.s.setAlpha(this.e);
                            canvas.drawText(list.get(1), this.n / 2, (this.o / 2) + B, this.s);
                        }
                    } else if (i2 == 2) {
                        if (this.i <= A) {
                            this.s.setTextSize(this.z);
                            this.s.setAlpha(this.e);
                            canvas.drawText(list.get(2), this.n / 2, (this.o / 2) + 300 + ((B * (A - this.i)) / A), this.s);
                            this.i++;
                        } else {
                            this.s.setTextSize(this.z);
                            this.s.setAlpha(this.e);
                            canvas.drawText(list.get(2), this.n / 2, (this.o / 2) + (B * 2), this.s);
                        }
                    }
                } else if (this.q == 1) {
                    if (i2 == 1) {
                        if (this.j < A) {
                            this.s.setTextSize(this.z + this.j);
                            this.s.setAlpha(this.e + ((int) (((this.d - this.e) * this.j) / A)));
                            canvas.drawText(list.get(i2), this.n / 2, (this.o / 2) + ((int) ((B * (A - this.j)) / A)), this.s);
                            this.j++;
                        } else {
                            this.b = true;
                            this.s.setTextSize(this.y);
                            this.s.setAlpha(this.d);
                            canvas.drawText(list.get(i2), this.n / 2, this.o / 2, this.s);
                        }
                    } else if (i2 == 2) {
                        if (this.k < A) {
                            this.k++;
                        } else {
                            this.b = true;
                        }
                        this.s.setTextSize(this.z);
                        this.s.setAlpha(this.e);
                        canvas.drawText(list.get(i2), this.n / 2, (this.o / 2) + B + ((int) ((B * (A - this.k)) / A)), this.s);
                    }
                } else if (i2 == this.q) {
                    if (this.f < A) {
                        this.s.setTextSize(this.z + this.f);
                        this.s.setAlpha(this.e + ((int) (((this.d - this.e) * this.f) / A)));
                        canvas.drawText(list.get(i2), this.n / 2, (this.o / 2) + ((int) ((B * (A - this.f)) / A)), this.s);
                        this.f++;
                    } else {
                        this.b = true;
                        this.s.setTextSize(this.y);
                        this.s.setAlpha(this.d);
                        canvas.drawText(list.get(i2), this.n / 2, this.o / 2, this.s);
                    }
                } else if (i2 == this.q - 1) {
                    if (this.g < A) {
                        this.s.setTextSize(this.y - this.g);
                        this.s.setAlpha(this.d - ((int) (((this.d - this.e) * this.g) / A)));
                        canvas.drawText(list.get(i2), this.n / 2, (this.o / 2) - ((int) (((B * this.g) * 1.0d) / A)), this.s);
                        this.g++;
                    } else {
                        this.s.setTextSize(this.z);
                        this.s.setAlpha(this.e);
                        canvas.drawText(list.get(i2), this.n / 2, (this.o / 2) - B, this.s);
                    }
                } else if (i2 == this.q + 1) {
                    if (this.l < A) {
                        this.s.setTextSize(this.z);
                        int i3 = (int) ((this.e * this.l) / A);
                        this.s.setAlpha(this.e);
                        canvas.drawText(list.get(i2), this.n / 2, ((this.o / 2) + (B * 2)) - ((int) (((B * this.l) * 1.0d) / A)), this.s);
                        this.l++;
                    } else {
                        this.s.setTextSize(this.z);
                        this.s.setAlpha(this.e);
                        canvas.drawText(list.get(i2), this.n / 2, (this.o / 2) + B, this.s);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setLrcList(List<String> list) {
        this.p = list;
    }

    public void toInvalidate() {
        this.f = 0;
        this.g = 0;
        this.l = 0;
        setBackgroundColor(Color.argb(0, 0, 0, 0));
        invalidate();
    }

    public void setLrcFinishInterface(a aVar) {
        this.r = aVar;
    }

    public void stopLrc() {
        this.c = true;
        this.r = null;
    }
}
