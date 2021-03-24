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
    public final RectF f12753e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f12754f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f12755g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f12756h;
    public Paint.Cap i;
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
        public int f12757e;

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
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f12757e);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f12757e = parcel.readInt();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
    }

    public LoadingProgressBar(Context context) {
        this(context, null);
    }

    public final void a(Canvas canvas) {
        int i = this.k;
        double d2 = i;
        Double.isNaN(d2);
        float f2 = (float) (6.283185307179586d / d2);
        float f3 = this.v;
        float f4 = f3 - this.l;
        int i2 = (int) ((this.y / this.j) * i);
        for (int i3 = 0; i3 < this.k; i3++) {
            double d3 = i3 * (-f2);
            float cos = (((float) Math.cos(d3)) * f4) + this.w;
            float sin = this.x - (((float) Math.sin(d3)) * f4);
            float cos2 = this.w + (((float) Math.cos(d3)) * f3);
            float sin2 = this.x - (((float) Math.sin(d3)) * f3);
            if (!this.s) {
                canvas.drawLine(cos, sin, cos2, sin2, this.f12755g);
            } else if (i3 >= i2) {
                canvas.drawLine(cos, sin, cos2, sin2, this.f12755g);
            }
            if (i3 < i2) {
                canvas.drawLine(cos, sin, cos2, sin2, this.f12754f);
            }
        }
    }

    public final void b(Canvas canvas) {
        int i = this.u;
        if (i == 1) {
            d(canvas);
        } else if (i != 2) {
            a(canvas);
        } else {
            c(canvas);
        }
    }

    public final void c(Canvas canvas) {
        if (this.s) {
            float f2 = (this.y * 360.0f) / this.j;
            canvas.drawArc(this.f12753e, f2, 360.0f - f2, false, this.f12755g);
        } else {
            canvas.drawArc(this.f12753e, 0.0f, 360.0f, false, this.f12755g);
        }
        canvas.drawArc(this.f12753e, 0.0f, (this.y * 360.0f) / this.j, false, this.f12754f);
    }

    public final void d(Canvas canvas) {
        if (this.s) {
            float f2 = (this.y * 360.0f) / this.j;
            canvas.drawArc(this.f12753e, f2, 360.0f - f2, true, this.f12755g);
        } else {
            canvas.drawArc(this.f12753e, 0.0f, 360.0f, true, this.f12755g);
        }
        canvas.drawArc(this.f12753e, 0.0f, (this.y * 360.0f) / this.j, true, this.f12754f);
    }

    public final void e() {
        this.p = getResources().getColor(d.b.g0.d.a.aiapps_progress_background_color);
        this.q = getResources().getColor(d.b.g0.d.a.aiapps_progress_start_color);
        this.r = getResources().getColor(d.b.g0.d.a.aiapps_progress_end_color);
        this.f12756h.setTextAlign(Paint.Align.CENTER);
        this.f12756h.setTextSize(this.o);
        this.f12754f.setStyle(this.u == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f12754f.setStrokeWidth(this.n);
        this.f12754f.setColor(this.q);
        this.f12754f.setStrokeCap(this.i);
        this.f12755g.setStyle(this.u == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f12755g.setStrokeWidth(this.n);
        this.f12755g.setColor(this.p);
        this.f12755g.setStrokeCap(this.i);
    }

    public final void f() {
        double d2;
        double d3;
        Shader shader = null;
        if (this.q != this.r) {
            int i = this.t;
            if (i == 0) {
                RectF rectF = this.f12753e;
                float f2 = rectF.left;
                shader = new LinearGradient(f2, rectF.top, f2, rectF.bottom, this.q, this.r, Shader.TileMode.CLAMP);
                Matrix matrix = new Matrix();
                matrix.setRotate(90.0f, this.w, this.x);
                shader.setLocalMatrix(matrix);
            } else if (i == 1) {
                shader = new RadialGradient(this.w, this.x, this.v, this.q, this.r, Shader.TileMode.CLAMP);
            } else if (i == 2) {
                Double.isNaN(this.n);
                Double.isNaN(this.v);
                float f3 = (float) (-((this.i == Paint.Cap.BUTT && this.u == 2) ? 0.0d : Math.toDegrees((float) (((d2 / 3.141592653589793d) * 2.0d) / d3))));
                shader = new SweepGradient(this.w, this.x, new int[]{this.q, this.r}, new float[]{0.0f, 1.0f});
                Matrix matrix2 = new Matrix();
                matrix2.setRotate(f3, this.w, this.x);
                shader.setLocalMatrix(matrix2);
            }
            this.f12754f.setShader(shader);
            return;
        }
        this.f12754f.setShader(null);
        this.f12754f.setColor(this.q);
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
        setProgress(savedState.f12757e);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f12757e = this.y;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f2 = i / 2.0f;
        this.w = f2;
        float f3 = i2 / 2.0f;
        this.x = f3;
        float min = Math.min(f2, f3);
        this.v = min;
        RectF rectF = this.f12753e;
        float f4 = this.x;
        rectF.top = f4 - min;
        rectF.bottom = f4 + min;
        float f5 = this.w;
        rectF.left = f5 - min;
        rectF.right = f5 + min;
        f();
        RectF rectF2 = this.f12753e;
        float f6 = this.n;
        rectF2.inset(f6 / 2.0f, f6 / 2.0f);
    }

    public void setCap(Paint.Cap cap) {
        this.i = cap;
        this.f12754f.setStrokeCap(cap);
        this.f12755g.setStrokeCap(cap);
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.s = z;
        invalidate();
    }

    public void setLineCount(int i) {
        this.k = i;
        invalidate();
    }

    public void setLineWidth(float f2) {
        this.l = f2;
        invalidate();
    }

    public void setMax(int i) {
        this.j = i;
        invalidate();
    }

    public void setProgress(int i) {
        this.y = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.p = i;
        this.f12755g.setColor(i);
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.r = i;
        f();
        invalidate();
    }

    public void setProgressFormatter(b bVar) {
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.q = i;
        f();
        invalidate();
    }

    public void setProgressStrokeWidth(float f2) {
        this.n = f2;
        this.f12753e.inset(f2 / 2.0f, f2 / 2.0f);
        invalidate();
    }

    public void setProgressTextColor(int i) {
        invalidate();
    }

    public void setProgressTextSize(float f2) {
        this.o = f2;
        invalidate();
    }

    public void setShader(int i) {
        this.t = i;
        f();
        invalidate();
    }

    public void setStartDegree(int i) {
        this.m = i;
        invalidate();
    }

    public void setStyle(int i) {
        this.u = i;
        this.f12754f.setStyle(i == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f12755g.setStyle(this.u == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12753e = new RectF();
        new Rect();
        this.f12754f = new Paint(1);
        this.f12755g = new Paint(1);
        this.f12756h = new TextPaint(1);
        this.i = Paint.Cap.ROUND;
        this.j = 100;
        this.k = 45;
        this.l = 4.0f;
        this.m = -90;
        this.n = getResources().getDimension(d.b.g0.d.b.aiapps_dimen_dp_2);
        this.o = getResources().getDimension(d.b.g0.d.b.aiapps_dimen_dp_12);
        getResources().getColor(d.b.g0.d.a.aiapps_white);
        this.s = false;
        this.t = 2;
        this.u = 2;
        e();
    }
}
