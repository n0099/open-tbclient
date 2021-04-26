package com.baidu.swan.facade.requred.webview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class LoadingProgressBar extends View {

    /* renamed from: e  reason: collision with root package name */
    public final RectF f12305e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f12306f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f12307g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f12308h;

    /* renamed from: i  reason: collision with root package name */
    public Paint.Cap f12309i;
    public int j;
    public int k;
    public float l;
    public int m;
    public float n;
    public float o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public int t;
    public int u;
    public float v;
    public float w;
    public float x;
    public int y;

    /* loaded from: classes3.dex */
    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public int f12310e;

        /* loaded from: classes3.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f12310e);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f12310e = parcel.readInt();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
    }

    public LoadingProgressBar(Context context) {
        this(context, null);
    }

    public final void a(Canvas canvas) {
        int i2 = this.k;
        float f2 = (float) (6.283185307179586d / i2);
        float f3 = this.v;
        float f4 = f3 - this.l;
        int i3 = (int) ((this.y / this.j) * i2);
        for (int i4 = 0; i4 < this.k; i4++) {
            double d2 = i4 * (-f2);
            float cos = (((float) Math.cos(d2)) * f4) + this.w;
            float sin = this.x - (((float) Math.sin(d2)) * f4);
            float cos2 = this.w + (((float) Math.cos(d2)) * f3);
            float sin2 = this.x - (((float) Math.sin(d2)) * f3);
            if (!this.s) {
                canvas.drawLine(cos, sin, cos2, sin2, this.f12307g);
            } else if (i4 >= i3) {
                canvas.drawLine(cos, sin, cos2, sin2, this.f12307g);
            }
            if (i4 < i3) {
                canvas.drawLine(cos, sin, cos2, sin2, this.f12306f);
            }
        }
    }

    public final void b(Canvas canvas) {
        int i2 = this.u;
        if (i2 == 1) {
            d(canvas);
        } else if (i2 != 2) {
            a(canvas);
        } else {
            c(canvas);
        }
    }

    public final void c(Canvas canvas) {
        if (this.s) {
            float f2 = (this.y * 360.0f) / this.j;
            canvas.drawArc(this.f12305e, f2, 360.0f - f2, false, this.f12307g);
        } else {
            canvas.drawArc(this.f12305e, 0.0f, 360.0f, false, this.f12307g);
        }
        canvas.drawArc(this.f12305e, 0.0f, (this.y * 360.0f) / this.j, false, this.f12306f);
    }

    public final void d(Canvas canvas) {
        if (this.s) {
            float f2 = (this.y * 360.0f) / this.j;
            canvas.drawArc(this.f12305e, f2, 360.0f - f2, true, this.f12307g);
        } else {
            canvas.drawArc(this.f12305e, 0.0f, 360.0f, true, this.f12307g);
        }
        canvas.drawArc(this.f12305e, 0.0f, (this.y * 360.0f) / this.j, true, this.f12306f);
    }

    public final void e() {
        this.p = getResources().getColor(d.a.h0.d.a.aiapps_progress_background_color);
        this.q = getResources().getColor(d.a.h0.d.a.aiapps_progress_start_color);
        this.r = getResources().getColor(d.a.h0.d.a.aiapps_progress_end_color);
        this.f12308h.setTextAlign(Paint.Align.CENTER);
        this.f12308h.setTextSize(this.o);
        this.f12306f.setStyle(this.u == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f12306f.setStrokeWidth(this.n);
        this.f12306f.setColor(this.q);
        this.f12306f.setStrokeCap(this.f12309i);
        this.f12307g.setStyle(this.u == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f12307g.setStrokeWidth(this.n);
        this.f12307g.setColor(this.p);
        this.f12307g.setStrokeCap(this.f12309i);
    }

    public final void f() {
        Shader shader = null;
        if (this.q != this.r) {
            int i2 = this.t;
            if (i2 == 0) {
                RectF rectF = this.f12305e;
                float f2 = rectF.left;
                shader = new LinearGradient(f2, rectF.top, f2, rectF.bottom, this.q, this.r, Shader.TileMode.CLAMP);
                Matrix matrix = new Matrix();
                matrix.setRotate(90.0f, this.w, this.x);
                shader.setLocalMatrix(matrix);
            } else if (i2 == 1) {
                shader = new RadialGradient(this.w, this.x, this.v, this.q, this.r, Shader.TileMode.CLAMP);
            } else if (i2 == 2) {
                float f3 = (float) (-((this.f12309i == Paint.Cap.BUTT && this.u == 2) ? 0.0d : Math.toDegrees((float) (((this.n / 3.141592653589793d) * 2.0d) / this.v))));
                shader = new SweepGradient(this.w, this.x, new int[]{this.q, this.r}, new float[]{0.0f, 1.0f});
                Matrix matrix2 = new Matrix();
                matrix2.setRotate(f3, this.w, this.x);
                shader.setLocalMatrix(matrix2);
            }
            this.f12306f.setShader(shader);
            return;
        }
        this.f12306f.setShader(null);
        this.f12306f.setColor(this.q);
    }

    public int getMax() {
        return this.j;
    }

    public int getProgress() {
        return this.y;
    }

    public int getStartDegree() {
        return this.m;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.m, this.w, this.x);
        b(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.f12310e);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f12310e = this.y;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        float f2 = i2 / 2.0f;
        this.w = f2;
        float f3 = i3 / 2.0f;
        this.x = f3;
        float min = Math.min(f2, f3);
        this.v = min;
        RectF rectF = this.f12305e;
        float f4 = this.x;
        rectF.top = f4 - min;
        rectF.bottom = f4 + min;
        float f5 = this.w;
        rectF.left = f5 - min;
        rectF.right = f5 + min;
        f();
        RectF rectF2 = this.f12305e;
        float f6 = this.n;
        rectF2.inset(f6 / 2.0f, f6 / 2.0f);
    }

    public void setCap(Paint.Cap cap) {
        this.f12309i = cap;
        this.f12306f.setStrokeCap(cap);
        this.f12307g.setStrokeCap(cap);
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.s = z;
        invalidate();
    }

    public void setLineCount(int i2) {
        this.k = i2;
        invalidate();
    }

    public void setLineWidth(float f2) {
        this.l = f2;
        invalidate();
    }

    public void setMax(int i2) {
        this.j = i2;
        invalidate();
    }

    public void setProgress(int i2) {
        this.y = i2;
        invalidate();
    }

    public void setProgressBackgroundColor(int i2) {
        this.p = i2;
        this.f12307g.setColor(i2);
        invalidate();
    }

    public void setProgressEndColor(int i2) {
        this.r = i2;
        f();
        invalidate();
    }

    public void setProgressFormatter(b bVar) {
        invalidate();
    }

    public void setProgressStartColor(int i2) {
        this.q = i2;
        f();
        invalidate();
    }

    public void setProgressStrokeWidth(float f2) {
        this.n = f2;
        this.f12305e.inset(f2 / 2.0f, f2 / 2.0f);
        invalidate();
    }

    public void setProgressTextColor(int i2) {
        invalidate();
    }

    public void setProgressTextSize(float f2) {
        this.o = f2;
        invalidate();
    }

    public void setShader(int i2) {
        this.t = i2;
        f();
        invalidate();
    }

    public void setStartDegree(int i2) {
        this.m = i2;
        invalidate();
    }

    public void setStyle(int i2) {
        this.u = i2;
        this.f12306f.setStyle(i2 == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f12307g.setStyle(this.u == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12305e = new RectF();
        new Rect();
        this.f12306f = new Paint(1);
        this.f12307g = new Paint(1);
        this.f12308h = new TextPaint(1);
        this.f12309i = Paint.Cap.ROUND;
        this.j = 100;
        this.k = 45;
        this.l = 4.0f;
        this.m = -90;
        this.n = getResources().getDimension(d.a.h0.d.b.aiapps_dimen_dp_2);
        this.o = getResources().getDimension(d.a.h0.d.b.aiapps_dimen_dp_12);
        getResources().getColor(d.a.h0.d.a.aiapps_white);
        this.s = false;
        this.t = 2;
        this.u = 2;
        e();
    }
}
