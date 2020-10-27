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
    private Paint.Cap cwJ;
    private int cyH;
    private final RectF dEF;
    private final Rect dEG;
    private final Paint dEH;
    private final Paint dEI;
    private final Paint dEJ;
    private float dEK;
    private int dEL;
    private float dEM;
    private float dEN;
    private int dEO;
    private int dEP;
    private int dEQ;
    private int dER;
    private boolean dES;
    private b dET;
    private int dEU;
    private float dEV;
    private float dEW;
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
        this.dEF = new RectF();
        this.dEG = new Rect();
        this.dEH = new Paint(1);
        this.dEI = new Paint(1);
        this.dEJ = new TextPaint(1);
        this.cwJ = Paint.Cap.ROUND;
        this.mMax = 100;
        this.cyH = 45;
        this.dEK = 4.0f;
        this.dEL = -90;
        this.dEM = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.dEN = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.dEO = getResources().getColor(a.C0499a.aiapps_white);
        this.dES = false;
        this.dET = new a();
        this.dEU = 2;
        this.mStyle = 2;
        sw();
    }

    private void sw() {
        this.dEP = getResources().getColor(a.C0499a.aiapps_progress_background_color);
        this.dEQ = getResources().getColor(a.C0499a.aiapps_progress_start_color);
        this.dER = getResources().getColor(a.C0499a.aiapps_progress_end_color);
        this.dEJ.setTextAlign(Paint.Align.CENTER);
        this.dEJ.setTextSize(this.dEN);
        this.dEH.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dEH.setStrokeWidth(this.dEM);
        this.dEH.setColor(this.dEQ);
        this.dEH.setStrokeCap(this.cwJ);
        this.dEI.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dEI.setStrokeWidth(this.dEM);
        this.dEI.setColor(this.dEP);
        this.dEI.setStrokeCap(this.cwJ);
    }

    private void aNf() {
        Shader shader = null;
        if (this.dEQ != this.dER) {
            switch (this.dEU) {
                case 0:
                    shader = new LinearGradient(this.dEF.left, this.dEF.top, this.dEF.left, this.dEF.bottom, this.dEQ, this.dER, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.dEV, this.dEW);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.dEV, this.dEW, this.mRadius, this.dEQ, this.dER, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.cwJ == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.dEM / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.dEV, this.dEW, new int[]{this.dEQ, this.dER}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.dEV, this.dEW);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.dEH.setShader(shader);
            return;
        }
        this.dEH.setShader(null);
        this.dEH.setColor(this.dEQ);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.dEL, this.dEV, this.dEW);
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
        float f = (float) (6.283185307179586d / this.cyH);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.dEK;
        int i = (int) ((this.mProgress / this.mMax) * this.cyH);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cyH) {
                float f4 = i3 * (-f);
                float cos = this.dEV + (((float) Math.cos(f4)) * f3);
                float sin = this.dEW - (((float) Math.sin(f4)) * f3);
                float cos2 = this.dEV + (((float) Math.cos(f4)) * f2);
                float sin2 = this.dEW - (((float) Math.sin(f4)) * f2);
                if (this.dES) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.dEI);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dEI);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dEH);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void y(Canvas canvas) {
        if (this.dES) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dEF, f, 360.0f - f, true, this.dEI);
        } else {
            canvas.drawArc(this.dEF, 0.0f, 360.0f, true, this.dEI);
        }
        canvas.drawArc(this.dEF, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.dEH);
    }

    private void z(Canvas canvas) {
        if (this.dES) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dEF, f, 360.0f - f, false, this.dEI);
        } else {
            canvas.drawArc(this.dEF, 0.0f, 360.0f, false, this.dEI);
        }
        canvas.drawArc(this.dEF, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.dEH);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dEV = i / 2.0f;
        this.dEW = i2 / 2.0f;
        this.mRadius = Math.min(this.dEV, this.dEW);
        this.dEF.top = this.dEW - this.mRadius;
        this.dEF.bottom = this.dEW + this.mRadius;
        this.dEF.left = this.dEV - this.mRadius;
        this.dEF.right = this.dEV + this.mRadius;
        aNf();
        this.dEF.inset(this.dEM / 2.0f, this.dEM / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.dET = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.dEM = f;
        this.dEF.inset(this.dEM / 2.0f, this.dEM / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.dEN = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.dEQ = i;
        aNf();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.dER = i;
        aNf();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.dEO = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.dEP = i;
        this.dEI.setColor(this.dEP);
        invalidate();
    }

    public void setLineCount(int i) {
        this.cyH = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.dEK = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.dEH.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dEI.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.dEU = i;
        aNf();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.cwJ = cap;
        this.dEH.setStrokeCap(cap);
        this.dEI.setStrokeCap(cap);
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
        return this.dEL;
    }

    public void setStartDegree(int i) {
        this.dEL = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.dES = z;
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
            /* renamed from: lz */
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
