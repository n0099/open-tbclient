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
import com.baidu.swan.facade.a;
/* loaded from: classes20.dex */
public class LoadingProgressBar extends View {
    private Paint.Cap bZP;
    private float bon;
    private float boo;
    private int cbN;
    private final RectF dhZ;
    private final Rect dia;
    private final Paint dib;
    private final Paint dic;
    private final Paint die;
    private float dif;
    private int dig;
    private float dih;
    private float dii;
    private int dij;
    private int dik;
    private int dil;
    private int dim;
    private boolean din;
    private b dio;
    private int dip;
    private int mMax;
    private int mProgress;
    private float mRadius;
    private int mStyle;

    /* loaded from: classes20.dex */
    public interface b {
    }

    public LoadingProgressBar(Context context) {
        this(context, null);
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhZ = new RectF();
        this.dia = new Rect();
        this.dib = new Paint(1);
        this.dic = new Paint(1);
        this.die = new TextPaint(1);
        this.bZP = Paint.Cap.ROUND;
        this.mMax = 100;
        this.cbN = 45;
        this.dif = 4.0f;
        this.dig = -90;
        this.dih = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.dii = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.dij = getResources().getColor(a.C0473a.aiapps_white);
        this.din = false;
        this.dio = new a();
        this.dip = 2;
        this.mStyle = 2;
        sr();
    }

    private void sr() {
        this.dik = getResources().getColor(a.C0473a.aiapps_progress_background_color);
        this.dil = getResources().getColor(a.C0473a.aiapps_progress_start_color);
        this.dim = getResources().getColor(a.C0473a.aiapps_progress_end_color);
        this.die.setTextAlign(Paint.Align.CENTER);
        this.die.setTextSize(this.dii);
        this.dib.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dib.setStrokeWidth(this.dih);
        this.dib.setColor(this.dil);
        this.dib.setStrokeCap(this.bZP);
        this.dic.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dic.setStrokeWidth(this.dih);
        this.dic.setColor(this.dik);
        this.dic.setStrokeCap(this.bZP);
    }

    private void aHS() {
        Shader shader = null;
        if (this.dil != this.dim) {
            switch (this.dip) {
                case 0:
                    shader = new LinearGradient(this.dhZ.left, this.dhZ.top, this.dhZ.left, this.dhZ.bottom, this.dil, this.dim, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.bon, this.boo);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.bon, this.boo, this.mRadius, this.dil, this.dim, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.bZP == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.dih / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.bon, this.boo, new int[]{this.dil, this.dim}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.bon, this.boo);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.dib.setShader(shader);
            return;
        }
        this.dib.setShader(null);
        this.dib.setColor(this.dil);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.dig, this.bon, this.boo);
        w(canvas);
        canvas.restore();
    }

    private void w(Canvas canvas) {
        switch (this.mStyle) {
            case 1:
                y(canvas);
                return;
            case 2:
                z(canvas);
                return;
            default:
                x(canvas);
                return;
        }
    }

    private void x(Canvas canvas) {
        float f = (float) (6.283185307179586d / this.cbN);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.dif;
        int i = (int) ((this.mProgress / this.mMax) * this.cbN);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cbN) {
                float f4 = i3 * (-f);
                float cos = this.bon + (((float) Math.cos(f4)) * f3);
                float sin = this.boo - (((float) Math.sin(f4)) * f3);
                float cos2 = this.bon + (((float) Math.cos(f4)) * f2);
                float sin2 = this.boo - (((float) Math.sin(f4)) * f2);
                if (this.din) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.dic);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dic);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dib);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void y(Canvas canvas) {
        if (this.din) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dhZ, f, 360.0f - f, true, this.dic);
        } else {
            canvas.drawArc(this.dhZ, 0.0f, 360.0f, true, this.dic);
        }
        canvas.drawArc(this.dhZ, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.dib);
    }

    private void z(Canvas canvas) {
        if (this.din) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dhZ, f, 360.0f - f, false, this.dic);
        } else {
            canvas.drawArc(this.dhZ, 0.0f, 360.0f, false, this.dic);
        }
        canvas.drawArc(this.dhZ, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.dib);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bon = i / 2.0f;
        this.boo = i2 / 2.0f;
        this.mRadius = Math.min(this.bon, this.boo);
        this.dhZ.top = this.boo - this.mRadius;
        this.dhZ.bottom = this.boo + this.mRadius;
        this.dhZ.left = this.bon - this.mRadius;
        this.dhZ.right = this.bon + this.mRadius;
        aHS();
        this.dhZ.inset(this.dih / 2.0f, this.dih / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.dio = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.dih = f;
        this.dhZ.inset(this.dih / 2.0f, this.dih / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.dii = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.dil = i;
        aHS();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.dim = i;
        aHS();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.dij = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.dik = i;
        this.dic.setColor(this.dik);
        invalidate();
    }

    public void setLineCount(int i) {
        this.cbN = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.dif = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.dib.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dic.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.dip = i;
        aHS();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.bZP = cap;
        this.dib.setStrokeCap(cap);
        this.dic.setStrokeCap(cap);
        invalidate();
    }

    public void setProgress(int i) {
        this.mProgress = i;
        invalidate();
    }

    public void setMax(int i) {
        this.mMax = i;
        invalidate();
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getMax() {
        return this.mMax;
    }

    public int getStartDegree() {
        return this.dig;
    }

    public void setStartDegree(int i) {
        this.dig = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.din = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.swan.facade.requred.webview.LoadingProgressBar.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: A */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: kG */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int progress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.progress = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.progress);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.progress = this.mProgress;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.progress);
    }

    /* loaded from: classes20.dex */
    private static final class a implements b {
        private a() {
        }
    }
}
