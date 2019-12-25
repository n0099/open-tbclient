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
/* loaded from: classes9.dex */
public class LoadingProgressBar extends View {
    private float awI;
    private float awJ;
    private Paint.Cap bbV;
    private int bdX;
    private final RectF cbF;
    private final Rect cbG;
    private final Paint cbH;
    private final Paint cbI;
    private final Paint cbJ;
    private float cbK;
    private int cbL;
    private float cbM;
    private float cbN;
    private int cbO;
    private int cbP;
    private int cbQ;
    private int cbR;
    private boolean cbS;
    private b cbT;
    private int cbU;
    private int mMax;
    private int mProgress;
    private float mRadius;
    private int mStyle;

    /* loaded from: classes9.dex */
    public interface b {
    }

    public LoadingProgressBar(Context context) {
        this(context, null);
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbF = new RectF();
        this.cbG = new Rect();
        this.cbH = new Paint(1);
        this.cbI = new Paint(1);
        this.cbJ = new TextPaint(1);
        this.bbV = Paint.Cap.ROUND;
        this.mMax = 100;
        this.bdX = 45;
        this.cbK = 4.0f;
        this.cbL = -90;
        this.cbM = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.cbN = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.cbO = getResources().getColor(a.C0312a.aiapps_white);
        this.cbS = false;
        this.cbT = new a();
        this.cbU = 2;
        this.mStyle = 2;
        lB();
    }

    private void lB() {
        this.cbP = getResources().getColor(a.C0312a.aiapps_progress_background_color);
        this.cbQ = getResources().getColor(a.C0312a.aiapps_progress_start_color);
        this.cbR = getResources().getColor(a.C0312a.aiapps_progress_end_color);
        this.cbJ.setTextAlign(Paint.Align.CENTER);
        this.cbJ.setTextSize(this.cbN);
        this.cbH.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cbH.setStrokeWidth(this.cbM);
        this.cbH.setColor(this.cbQ);
        this.cbH.setStrokeCap(this.bbV);
        this.cbI.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cbI.setStrokeWidth(this.cbM);
        this.cbI.setColor(this.cbP);
        this.cbI.setStrokeCap(this.bbV);
    }

    private void ahm() {
        Shader shader = null;
        if (this.cbQ != this.cbR) {
            switch (this.cbU) {
                case 0:
                    shader = new LinearGradient(this.cbF.left, this.cbF.top, this.cbF.left, this.cbF.bottom, this.cbQ, this.cbR, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.awI, this.awJ);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.awI, this.awJ, this.mRadius, this.cbQ, this.cbR, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.bbV == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.cbM / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.awI, this.awJ, new int[]{this.cbQ, this.cbR}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.awI, this.awJ);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.cbH.setShader(shader);
            return;
        }
        this.cbH.setShader(null);
        this.cbH.setColor(this.cbQ);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.cbL, this.awI, this.awJ);
        t(canvas);
        canvas.restore();
    }

    private void t(Canvas canvas) {
        switch (this.mStyle) {
            case 1:
                v(canvas);
                return;
            case 2:
                w(canvas);
                return;
            default:
                u(canvas);
                return;
        }
    }

    private void u(Canvas canvas) {
        float f = (float) (6.283185307179586d / this.bdX);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.cbK;
        int i = (int) ((this.mProgress / this.mMax) * this.bdX);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bdX) {
                float f4 = i3 * (-f);
                float cos = this.awI + (((float) Math.cos(f4)) * f3);
                float sin = this.awJ - (((float) Math.sin(f4)) * f3);
                float cos2 = this.awI + (((float) Math.cos(f4)) * f2);
                float sin2 = this.awJ - (((float) Math.sin(f4)) * f2);
                if (this.cbS) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.cbI);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cbI);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cbH);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void v(Canvas canvas) {
        if (this.cbS) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cbF, f, 360.0f - f, true, this.cbI);
        } else {
            canvas.drawArc(this.cbF, 0.0f, 360.0f, true, this.cbI);
        }
        canvas.drawArc(this.cbF, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.cbH);
    }

    private void w(Canvas canvas) {
        if (this.cbS) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cbF, f, 360.0f - f, false, this.cbI);
        } else {
            canvas.drawArc(this.cbF, 0.0f, 360.0f, false, this.cbI);
        }
        canvas.drawArc(this.cbF, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.cbH);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.awI = i / 2.0f;
        this.awJ = i2 / 2.0f;
        this.mRadius = Math.min(this.awI, this.awJ);
        this.cbF.top = this.awJ - this.mRadius;
        this.cbF.bottom = this.awJ + this.mRadius;
        this.cbF.left = this.awI - this.mRadius;
        this.cbF.right = this.awI + this.mRadius;
        ahm();
        this.cbF.inset(this.cbM / 2.0f, this.cbM / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.cbT = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.cbM = f;
        this.cbF.inset(this.cbM / 2.0f, this.cbM / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.cbN = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.cbQ = i;
        ahm();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.cbR = i;
        ahm();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.cbO = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.cbP = i;
        this.cbI.setColor(this.cbP);
        invalidate();
    }

    public void setLineCount(int i) {
        this.bdX = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.cbK = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.cbH.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cbI.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.cbU = i;
        ahm();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.bbV = cap;
        this.cbH.setStrokeCap(cap);
        this.cbI.setStrokeCap(cap);
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
        return this.cbL;
    }

    public void setStartDegree(int i) {
        this.cbL = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.cbS = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.swan.facade.requred.webview.LoadingProgressBar.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: E */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: hj */
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

    /* loaded from: classes9.dex */
    private static final class a implements b {
        private a() {
        }
    }
}
