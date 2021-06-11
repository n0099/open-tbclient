package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.sapi2.biometrics.liveness.R;
import java.util.List;
/* loaded from: classes2.dex */
public class LrcView extends FrameLayout {
    public static int A = 12;
    public static int B;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6154a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6155b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6156c;

    /* renamed from: d  reason: collision with root package name */
    public int f6157d;

    /* renamed from: e  reason: collision with root package name */
    public int f6158e;

    /* renamed from: f  reason: collision with root package name */
    public int f6159f;

    /* renamed from: g  reason: collision with root package name */
    public int f6160g;

    /* renamed from: h  reason: collision with root package name */
    public int f6161h;

    /* renamed from: i  reason: collision with root package name */
    public int f6162i;
    public int j;
    public int k;
    public int l;
    public Runnable m;
    public int n;
    public int o;
    public List<String> p;
    public int q;
    public a r;
    public Paint s;
    public Paint t;
    public Paint u;
    public float[] v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public LrcView(@NonNull Context context) {
        super(context);
        this.f6154a = false;
        this.f6155b = false;
        this.f6156c = false;
        this.f6157d = 255;
        this.f6158e = 127;
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
                LrcView lrcView = LrcView.this;
                lrcView.f6155b = false;
                LrcView.d(lrcView);
                LrcView.this.toInvalidate();
                LrcView.this.f6154a = false;
            }
        };
        a();
    }

    public static /* synthetic */ int d(LrcView lrcView) {
        int i2 = lrcView.q;
        lrcView.q = i2 + 1;
        return i2;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.n / 2, (this.o / 2) + getScrollY(), this.n / 2, this.t);
        List<String> list = this.p;
        if (list == null || list.size() == 0) {
            return;
        }
        a(canvas, this.p);
        if (this.f6156c) {
            return;
        }
        if (this.f6155b && !this.f6154a) {
            this.f6154a = true;
            int i2 = this.q;
            if (i2 == 0) {
                getHandler().postDelayed(this.m, 200L);
                return;
            }
            List<String> list2 = this.p;
            if (list2 != null && i2 >= 0 && i2 <= list2.size()) {
                getHandler().postDelayed(this.m, (long) (this.p.get(this.q).length() * 0.25d * 1000.0d));
                return;
            } else {
                getHandler().postDelayed(this.m, 2000L);
                return;
            }
        }
        postInvalidateDelayed(10L);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.n = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.o = measuredHeight;
        float[] fArr = this.v;
        int i4 = this.n;
        int i5 = this.x;
        int i6 = this.w;
        fArr[0] = ((i4 / 2) - i5) - (i6 * 2);
        fArr[1] = measuredHeight / 2;
        fArr[2] = i4 / 2;
        fArr[3] = measuredHeight / 2;
        fArr[4] = (i4 / 2) + i5 + (i6 * 2);
        fArr[5] = measuredHeight / 2;
    }

    public void setLrcFinishInterface(a aVar) {
        this.r = aVar;
    }

    public void setLrcList(List<String> list) {
        this.p = list;
    }

    public void stopLrc() {
        this.f6156c = true;
        this.r = null;
    }

    public void toInvalidate() {
        this.f6159f = 0;
        this.f6160g = 0;
        this.l = 0;
        setBackgroundColor(Color.argb(0, 0, 0, 0));
        invalidate();
    }

    private void a() {
        this.y = getResources().getDimensionPixelSize(R.dimen.rim_text_size_24);
        this.z = getResources().getDimensionPixelSize(R.dimen.rim_text_size_18);
        Paint paint = new Paint();
        this.s = paint;
        paint.setColor(Color.rgb(255, 255, 255));
        this.s.setTextSize(this.y);
        this.s.setTextAlign(Paint.Align.CENTER);
        this.s.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.t = paint2;
        paint2.setColor(Color.argb(150, 0, 0, 0));
        this.t.setAntiAlias(true);
        this.v = new float[6];
        Paint paint3 = new Paint();
        this.u = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.w = getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrcview_circle_point_radius);
        this.x = getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrcview_circle_point_gap);
        A = this.y - this.z;
        B = getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_text_gap);
    }

    public LrcView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6154a = false;
        this.f6155b = false;
        this.f6156c = false;
        this.f6157d = 255;
        this.f6158e = 127;
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
                LrcView lrcView = LrcView.this;
                lrcView.f6155b = false;
                LrcView.d(lrcView);
                LrcView.this.toInvalidate();
                LrcView.this.f6154a = false;
            }
        };
        a();
    }

    private void a(Canvas canvas, List<String> list) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        for (int i8 = 0; i8 < list.size(); i8++) {
            int i9 = this.q;
            if (i9 == 0) {
                if (i8 == 0) {
                    int i10 = this.f6159f;
                    if (i10 < 108) {
                        this.f6159f = i10 + 2;
                    } else if (i10 >= 108 && i10 <= 144) {
                        this.f6159f = i10 + 2;
                    } else {
                        this.f6155b = true;
                    }
                    this.u.setColor(Color.argb(111, 255, 255, 255));
                    float[] fArr = this.v;
                    canvas.drawCircle(fArr[0], fArr[1], this.w, this.u);
                    float[] fArr2 = this.v;
                    canvas.drawCircle(fArr2[2], fArr2[3], this.w, this.u);
                    float[] fArr3 = this.v;
                    canvas.drawCircle(fArr3[4], fArr3[5], this.w, this.u);
                    int i11 = this.f6159f;
                    if (i11 >= 144) {
                        this.u.setColor(Color.argb(255, 255, 255, 255));
                        float[] fArr4 = this.v;
                        canvas.drawCircle(fArr4[0], fArr4[1], this.w, this.u);
                        float[] fArr5 = this.v;
                        canvas.drawCircle(fArr5[2], fArr5[3], this.w, this.u);
                        float[] fArr6 = this.v;
                        canvas.drawCircle(fArr6[4], fArr6[5], this.w, this.u);
                    } else if (i11 >= 108) {
                        this.u.setColor(Color.argb(255, 255, 255, 255));
                        float[] fArr7 = this.v;
                        canvas.drawCircle(fArr7[0], fArr7[1], this.w, this.u);
                        float[] fArr8 = this.v;
                        canvas.drawCircle(fArr8[2], fArr8[3], this.w, this.u);
                        this.u.setAlpha(((int) (((this.f6159f - 108) / 36.0f) * 144.0f)) + 111);
                        float[] fArr9 = this.v;
                        canvas.drawCircle(fArr9[4], fArr9[5], this.w, this.u);
                    } else if (i11 >= 72) {
                        this.u.setColor(Color.argb(255, 255, 255, 255));
                        float[] fArr10 = this.v;
                        canvas.drawCircle(fArr10[0], fArr10[1], this.w, this.u);
                        this.u.setAlpha(((int) (((this.f6159f - 72) / 36.0f) * 144.0f)) + 111);
                        float[] fArr11 = this.v;
                        canvas.drawCircle(fArr11[2], fArr11[3], this.w, this.u);
                    } else if (i11 >= 36) {
                        this.u.setAlpha(((int) (((i11 - 36) / 36.0f) * 144.0f)) + 111);
                        this.u.setColor(Color.argb(255, 255, 255, 255));
                        float[] fArr12 = this.v;
                        canvas.drawCircle(fArr12[0], fArr12[1], this.w, this.u);
                    }
                } else if (i8 == 1) {
                    if (this.f6161h <= A) {
                        this.s.setTextSize(this.z);
                        this.s.setAlpha(this.f6158e);
                        int i12 = B;
                        int i13 = A;
                        canvas.drawText(list.get(1), this.n / 2, (this.o / 2) + i12 + ((i12 * (i13 - this.f6161h)) / i13), this.s);
                        this.f6161h++;
                    } else {
                        this.s.setTextSize(this.z);
                        this.s.setAlpha(this.f6158e);
                        canvas.drawText(list.get(1), this.n / 2, (this.o / 2) + B, this.s);
                    }
                } else if (i8 == 2) {
                    if (this.f6162i <= A) {
                        this.s.setTextSize(this.z);
                        this.s.setAlpha(this.f6158e);
                        int i14 = A;
                        canvas.drawText(list.get(2), this.n / 2, (this.o / 2) + 300 + ((B * (i14 - this.f6162i)) / i14), this.s);
                        this.f6162i++;
                    } else {
                        this.s.setTextSize(this.z);
                        this.s.setAlpha(this.f6158e);
                        canvas.drawText(list.get(2), this.n / 2, (this.o / 2) + (B * 2), this.s);
                    }
                }
            } else if (i9 == 1) {
                if (i8 == 1) {
                    if (this.j < A) {
                        this.s.setTextSize(this.z + i6);
                        this.s.setAlpha(this.f6158e + ((int) (((this.f6157d - i7) * this.j) / A)));
                        int i15 = A;
                        canvas.drawText(list.get(i8), this.n / 2, (this.o / 2) + ((int) ((B * (i15 - this.j)) / i15)), this.s);
                        this.j++;
                    } else {
                        this.f6155b = true;
                        this.s.setTextSize(this.y);
                        this.s.setAlpha(this.f6157d);
                        canvas.drawText(list.get(i8), this.n / 2, this.o / 2, this.s);
                    }
                } else if (i8 == 2) {
                    int i16 = this.k;
                    if (i16 < A) {
                        this.k = i16 + 1;
                    } else {
                        this.f6155b = true;
                    }
                    this.s.setTextSize(this.z);
                    this.s.setAlpha(this.f6158e);
                    int i17 = B;
                    int i18 = A;
                    canvas.drawText(list.get(i8), this.n / 2, (this.o / 2) + i17 + ((int) ((i17 * (i18 - this.k)) / i18)), this.s);
                }
            } else if (i8 == i9) {
                if (this.f6159f < A) {
                    this.s.setTextSize(this.z + i4);
                    this.s.setAlpha(this.f6158e + ((int) (((this.f6157d - i5) * this.f6159f) / A)));
                    int i19 = A;
                    canvas.drawText(list.get(i8), this.n / 2, (this.o / 2) + ((int) ((B * (i19 - this.f6159f)) / i19)), this.s);
                    this.f6159f++;
                } else {
                    this.f6155b = true;
                    this.s.setTextSize(this.y);
                    this.s.setAlpha(this.f6157d);
                    canvas.drawText(list.get(i8), this.n / 2, this.o / 2, this.s);
                }
            } else if (i8 == i9 - 1) {
                if (this.f6160g < A) {
                    this.s.setTextSize(this.y - i2);
                    this.s.setAlpha(this.f6157d - ((int) (((i3 - this.f6158e) * this.f6160g) / A)));
                    canvas.drawText(list.get(i8), this.n / 2, (this.o / 2) - ((int) (((B * this.f6160g) * 1.0d) / A)), this.s);
                    this.f6160g++;
                } else {
                    this.s.setTextSize(this.z);
                    this.s.setAlpha(this.f6158e);
                    canvas.drawText(list.get(i8), this.n / 2, (this.o / 2) - B, this.s);
                }
            } else if (i8 == i9 + 1) {
                if (this.l < A) {
                    this.s.setTextSize(this.z);
                    this.s.setAlpha(this.f6158e);
                    int i20 = B;
                    canvas.drawText(list.get(i8), this.n / 2, ((this.o / 2) + (i20 * 2)) - ((int) (((i20 * this.l) * 1.0d) / A)), this.s);
                    this.l++;
                } else {
                    this.s.setTextSize(this.z);
                    this.s.setAlpha(this.f6158e);
                    canvas.drawText(list.get(i8), this.n / 2, (this.o / 2) + B, this.s);
                }
            }
        }
    }
}
