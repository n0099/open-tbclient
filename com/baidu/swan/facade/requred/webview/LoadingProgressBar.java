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
/* loaded from: classes16.dex */
public class LoadingProgressBar extends View {
    private Paint.Cap cCC;
    private int cEA;
    private final Paint dKA;
    private final Paint dKB;
    private float dKC;
    private int dKD;
    private float dKE;
    private float dKF;
    private int dKG;
    private int dKH;
    private int dKI;
    private int dKJ;
    private boolean dKK;
    private b dKL;
    private int dKM;
    private float dKN;
    private float dKO;
    private final RectF dKx;
    private final Rect dKy;
    private final Paint dKz;
    private int mMax;
    private int mProgress;
    private float mRadius;
    private int mStyle;

    /* loaded from: classes16.dex */
    public interface b {
    }

    public LoadingProgressBar(Context context) {
        this(context, null);
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dKx = new RectF();
        this.dKy = new Rect();
        this.dKz = new Paint(1);
        this.dKA = new Paint(1);
        this.dKB = new TextPaint(1);
        this.cCC = Paint.Cap.ROUND;
        this.mMax = 100;
        this.cEA = 45;
        this.dKC = 4.0f;
        this.dKD = -90;
        this.dKE = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.dKF = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.dKG = getResources().getColor(a.C0511a.aiapps_white);
        this.dKK = false;
        this.dKL = new a();
        this.dKM = 2;
        this.mStyle = 2;
        sw();
    }

    private void sw() {
        this.dKH = getResources().getColor(a.C0511a.aiapps_progress_background_color);
        this.dKI = getResources().getColor(a.C0511a.aiapps_progress_start_color);
        this.dKJ = getResources().getColor(a.C0511a.aiapps_progress_end_color);
        this.dKB.setTextAlign(Paint.Align.CENTER);
        this.dKB.setTextSize(this.dKF);
        this.dKz.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dKz.setStrokeWidth(this.dKE);
        this.dKz.setColor(this.dKI);
        this.dKz.setStrokeCap(this.cCC);
        this.dKA.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dKA.setStrokeWidth(this.dKE);
        this.dKA.setColor(this.dKH);
        this.dKA.setStrokeCap(this.cCC);
    }

    private void aPF() {
        Shader shader = null;
        if (this.dKI != this.dKJ) {
            switch (this.dKM) {
                case 0:
                    shader = new LinearGradient(this.dKx.left, this.dKx.top, this.dKx.left, this.dKx.bottom, this.dKI, this.dKJ, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.dKN, this.dKO);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.dKN, this.dKO, this.mRadius, this.dKI, this.dKJ, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.cCC == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.dKE / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.dKN, this.dKO, new int[]{this.dKI, this.dKJ}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.dKN, this.dKO);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.dKz.setShader(shader);
            return;
        }
        this.dKz.setShader(null);
        this.dKz.setColor(this.dKI);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.dKD, this.dKN, this.dKO);
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
        float f = (float) (6.283185307179586d / this.cEA);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.dKC;
        int i = (int) ((this.mProgress / this.mMax) * this.cEA);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cEA) {
                float f4 = i3 * (-f);
                float cos = this.dKN + (((float) Math.cos(f4)) * f3);
                float sin = this.dKO - (((float) Math.sin(f4)) * f3);
                float cos2 = this.dKN + (((float) Math.cos(f4)) * f2);
                float sin2 = this.dKO - (((float) Math.sin(f4)) * f2);
                if (this.dKK) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.dKA);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dKA);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dKz);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void y(Canvas canvas) {
        if (this.dKK) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dKx, f, 360.0f - f, true, this.dKA);
        } else {
            canvas.drawArc(this.dKx, 0.0f, 360.0f, true, this.dKA);
        }
        canvas.drawArc(this.dKx, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.dKz);
    }

    private void z(Canvas canvas) {
        if (this.dKK) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dKx, f, 360.0f - f, false, this.dKA);
        } else {
            canvas.drawArc(this.dKx, 0.0f, 360.0f, false, this.dKA);
        }
        canvas.drawArc(this.dKx, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.dKz);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dKN = i / 2.0f;
        this.dKO = i2 / 2.0f;
        this.mRadius = Math.min(this.dKN, this.dKO);
        this.dKx.top = this.dKO - this.mRadius;
        this.dKx.bottom = this.dKO + this.mRadius;
        this.dKx.left = this.dKN - this.mRadius;
        this.dKx.right = this.dKN + this.mRadius;
        aPF();
        this.dKx.inset(this.dKE / 2.0f, this.dKE / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.dKL = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.dKE = f;
        this.dKx.inset(this.dKE / 2.0f, this.dKE / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.dKF = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.dKI = i;
        aPF();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.dKJ = i;
        aPF();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.dKG = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.dKH = i;
        this.dKA.setColor(this.dKH);
        invalidate();
    }

    public void setLineCount(int i) {
        this.cEA = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.dKC = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.dKz.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dKA.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.dKM = i;
        aPF();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.cCC = cap;
        this.dKz.setStrokeCap(cap);
        this.dKA.setStrokeCap(cap);
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
        return this.dKD;
    }

    public void setStartDegree(int i) {
        this.dKD = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.dKK = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
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
            /* renamed from: lJ */
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

    /* loaded from: classes16.dex */
    private static final class a implements b {
        private a() {
        }
    }
}
