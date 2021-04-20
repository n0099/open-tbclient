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
    public boolean f6180a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6181b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6182c;

    /* renamed from: d  reason: collision with root package name */
    public int f6183d;

    /* renamed from: e  reason: collision with root package name */
    public int f6184e;

    /* renamed from: f  reason: collision with root package name */
    public int f6185f;

    /* renamed from: g  reason: collision with root package name */
    public int f6186g;

    /* renamed from: h  reason: collision with root package name */
    public int f6187h;
    public int i;
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
        this.f6180a = false;
        this.f6181b = false;
        this.f6182c = false;
        this.f6183d = 255;
        this.f6184e = 127;
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
                lrcView.f6181b = false;
                LrcView.d(lrcView);
                LrcView.this.toInvalidate();
                LrcView.this.f6180a = false;
            }
        };
        a();
    }

    public static /* synthetic */ int d(LrcView lrcView) {
        int i = lrcView.q;
        lrcView.q = i + 1;
        return i;
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
        if (this.f6182c) {
            return;
        }
        if (this.f6181b && !this.f6180a) {
            this.f6180a = true;
            int i = this.q;
            if (i == 0) {
                getHandler().postDelayed(this.m, 200L);
                return;
            }
            List<String> list2 = this.p;
            if (list2 != null && i >= 0 && i <= list2.size()) {
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
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.n = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.o = measuredHeight;
        float[] fArr = this.v;
        int i3 = this.n;
        int i4 = this.x;
        int i5 = this.w;
        fArr[0] = ((i3 / 2) - i4) - (i5 * 2);
        fArr[1] = measuredHeight / 2;
        fArr[2] = i3 / 2;
        fArr[3] = measuredHeight / 2;
        fArr[4] = (i3 / 2) + i4 + (i5 * 2);
        fArr[5] = measuredHeight / 2;
    }

    public void setLrcFinishInterface(a aVar) {
        this.r = aVar;
    }

    public void setLrcList(List<String> list) {
        this.p = list;
    }

    public void stopLrc() {
        this.f6182c = true;
        this.r = null;
    }

    public void toInvalidate() {
        this.f6185f = 0;
        this.f6186g = 0;
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
        this.f6180a = false;
        this.f6181b = false;
        this.f6182c = false;
        this.f6183d = 255;
        this.f6184e = 127;
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
                lrcView.f6181b = false;
                LrcView.d(lrcView);
                LrcView.this.toInvalidate();
                LrcView.this.f6180a = false;
            }
        };
        a();
    }

    private void a(Canvas canvas, List<String> list) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        for (int i7 = 0; i7 < list.size(); i7++) {
            int i8 = this.q;
            if (i8 == 0) {
                if (i7 == 0) {
                    int i9 = this.f6185f;
                    if (i9 < 108) {
                        this.f6185f = i9 + 2;
                    } else if (i9 >= 108 && i9 <= 144) {
                        this.f6185f = i9 + 2;
                    } else {
                        this.f6181b = true;
                    }
                    this.u.setColor(Color.argb(111, 255, 255, 255));
                    float[] fArr = this.v;
                    canvas.drawCircle(fArr[0], fArr[1], this.w, this.u);
                    float[] fArr2 = this.v;
                    canvas.drawCircle(fArr2[2], fArr2[3], this.w, this.u);
                    float[] fArr3 = this.v;
                    canvas.drawCircle(fArr3[4], fArr3[5], this.w, this.u);
                    int i10 = this.f6185f;
                    if (i10 >= 144) {
                        this.u.setColor(Color.argb(255, 255, 255, 255));
                        float[] fArr4 = this.v;
                        canvas.drawCircle(fArr4[0], fArr4[1], this.w, this.u);
                        float[] fArr5 = this.v;
                        canvas.drawCircle(fArr5[2], fArr5[3], this.w, this.u);
                        float[] fArr6 = this.v;
                        canvas.drawCircle(fArr6[4], fArr6[5], this.w, this.u);
                    } else if (i10 >= 108) {
                        this.u.setColor(Color.argb(255, 255, 255, 255));
                        float[] fArr7 = this.v;
                        canvas.drawCircle(fArr7[0], fArr7[1], this.w, this.u);
                        float[] fArr8 = this.v;
                        canvas.drawCircle(fArr8[2], fArr8[3], this.w, this.u);
                        this.u.setAlpha(((int) (((this.f6185f - 108) / 36.0f) * 144.0f)) + 111);
                        float[] fArr9 = this.v;
                        canvas.drawCircle(fArr9[4], fArr9[5], this.w, this.u);
                    } else if (i10 >= 72) {
                        this.u.setColor(Color.argb(255, 255, 255, 255));
                        float[] fArr10 = this.v;
                        canvas.drawCircle(fArr10[0], fArr10[1], this.w, this.u);
                        this.u.setAlpha(((int) (((this.f6185f - 72) / 36.0f) * 144.0f)) + 111);
                        float[] fArr11 = this.v;
                        canvas.drawCircle(fArr11[2], fArr11[3], this.w, this.u);
                    } else if (i10 >= 36) {
                        this.u.setAlpha(((int) (((i10 - 36) / 36.0f) * 144.0f)) + 111);
                        this.u.setColor(Color.argb(255, 255, 255, 255));
                        float[] fArr12 = this.v;
                        canvas.drawCircle(fArr12[0], fArr12[1], this.w, this.u);
                    }
                } else if (i7 == 1) {
                    if (this.f6187h <= A) {
                        this.s.setTextSize(this.z);
                        this.s.setAlpha(this.f6184e);
                        int i11 = B;
                        int i12 = A;
                        canvas.drawText(list.get(1), this.n / 2, (this.o / 2) + i11 + ((i11 * (i12 - this.f6187h)) / i12), this.s);
                        this.f6187h++;
                    } else {
                        this.s.setTextSize(this.z);
                        this.s.setAlpha(this.f6184e);
                        canvas.drawText(list.get(1), this.n / 2, (this.o / 2) + B, this.s);
                    }
                } else if (i7 == 2) {
                    if (this.i <= A) {
                        this.s.setTextSize(this.z);
                        this.s.setAlpha(this.f6184e);
                        int i13 = A;
                        canvas.drawText(list.get(2), this.n / 2, (this.o / 2) + 300 + ((B * (i13 - this.i)) / i13), this.s);
                        this.i++;
                    } else {
                        this.s.setTextSize(this.z);
                        this.s.setAlpha(this.f6184e);
                        canvas.drawText(list.get(2), this.n / 2, (this.o / 2) + (B * 2), this.s);
                    }
                }
            } else if (i8 == 1) {
                if (i7 == 1) {
                    if (this.j < A) {
                        this.s.setTextSize(this.z + i5);
                        this.s.setAlpha(this.f6184e + ((int) (((this.f6183d - i6) * this.j) / A)));
                        int i14 = A;
                        canvas.drawText(list.get(i7), this.n / 2, (this.o / 2) + ((int) ((B * (i14 - this.j)) / i14)), this.s);
                        this.j++;
                    } else {
                        this.f6181b = true;
                        this.s.setTextSize(this.y);
                        this.s.setAlpha(this.f6183d);
                        canvas.drawText(list.get(i7), this.n / 2, this.o / 2, this.s);
                    }
                } else if (i7 == 2) {
                    int i15 = this.k;
                    if (i15 < A) {
                        this.k = i15 + 1;
                    } else {
                        this.f6181b = true;
                    }
                    this.s.setTextSize(this.z);
                    this.s.setAlpha(this.f6184e);
                    int i16 = B;
                    int i17 = A;
                    canvas.drawText(list.get(i7), this.n / 2, (this.o / 2) + i16 + ((int) ((i16 * (i17 - this.k)) / i17)), this.s);
                }
            } else if (i7 == i8) {
                if (this.f6185f < A) {
                    this.s.setTextSize(this.z + i3);
                    this.s.setAlpha(this.f6184e + ((int) (((this.f6183d - i4) * this.f6185f) / A)));
                    int i18 = A;
                    canvas.drawText(list.get(i7), this.n / 2, (this.o / 2) + ((int) ((B * (i18 - this.f6185f)) / i18)), this.s);
                    this.f6185f++;
                } else {
                    this.f6181b = true;
                    this.s.setTextSize(this.y);
                    this.s.setAlpha(this.f6183d);
                    canvas.drawText(list.get(i7), this.n / 2, this.o / 2, this.s);
                }
            } else if (i7 == i8 - 1) {
                if (this.f6186g < A) {
                    this.s.setTextSize(this.y - i);
                    this.s.setAlpha(this.f6183d - ((int) (((i2 - this.f6184e) * this.f6186g) / A)));
                    canvas.drawText(list.get(i7), this.n / 2, (this.o / 2) - ((int) (((B * this.f6186g) * 1.0d) / A)), this.s);
                    this.f6186g++;
                } else {
                    this.s.setTextSize(this.z);
                    this.s.setAlpha(this.f6184e);
                    canvas.drawText(list.get(i7), this.n / 2, (this.o / 2) - B, this.s);
                }
            } else if (i7 == i8 + 1) {
                if (this.l < A) {
                    this.s.setTextSize(this.z);
                    this.s.setAlpha(this.f6184e);
                    int i19 = B;
                    canvas.drawText(list.get(i7), this.n / 2, ((this.o / 2) + (i19 * 2)) - ((int) (((i19 * this.l) * 1.0d) / A)), this.s);
                    this.l++;
                } else {
                    this.s.setTextSize(this.z);
                    this.s.setAlpha(this.f6184e);
                    canvas.drawText(list.get(i7), this.n / 2, (this.o / 2) + B, this.s);
                }
            }
        }
    }
}
