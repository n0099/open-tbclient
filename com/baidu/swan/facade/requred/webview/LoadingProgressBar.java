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
/* loaded from: classes3.dex */
public class LoadingProgressBar extends View {
    private Paint.Cap cLK;
    private int cNI;
    private final RectF dXE;
    private final Rect dXF;
    private final Paint dXG;
    private final Paint dXH;
    private final Paint dXI;
    private int dXJ;
    private float dXK;
    private int dXL;
    private float dXM;
    private float dXN;
    private int dXO;
    private int dXP;
    private int dXQ;
    private int dXR;
    private boolean dXS;
    private b dXT;
    private int dXU;
    private float dXV;
    private float dXW;
    private int mProgress;
    private float mRadius;
    private int mStyle;

    /* loaded from: classes3.dex */
    public interface b {
    }

    public LoadingProgressBar(Context context) {
        this(context, null);
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dXE = new RectF();
        this.dXF = new Rect();
        this.dXG = new Paint(1);
        this.dXH = new Paint(1);
        this.dXI = new TextPaint(1);
        this.cLK = Paint.Cap.ROUND;
        this.dXJ = 100;
        this.cNI = 45;
        this.dXK = 4.0f;
        this.dXL = -90;
        this.dXM = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.dXN = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.dXO = getResources().getColor(a.C0500a.aiapps_white);
        this.dXS = false;
        this.dXT = new a();
        this.dXU = 2;
        this.mStyle = 2;
        rX();
    }

    private void rX() {
        this.dXP = getResources().getColor(a.C0500a.aiapps_progress_background_color);
        this.dXQ = getResources().getColor(a.C0500a.aiapps_progress_start_color);
        this.dXR = getResources().getColor(a.C0500a.aiapps_progress_end_color);
        this.dXI.setTextAlign(Paint.Align.CENTER);
        this.dXI.setTextSize(this.dXN);
        this.dXG.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dXG.setStrokeWidth(this.dXM);
        this.dXG.setColor(this.dXQ);
        this.dXG.setStrokeCap(this.cLK);
        this.dXH.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dXH.setStrokeWidth(this.dXM);
        this.dXH.setColor(this.dXP);
        this.dXH.setStrokeCap(this.cLK);
    }

    private void aQZ() {
        Shader shader = null;
        if (this.dXQ != this.dXR) {
            switch (this.dXU) {
                case 0:
                    shader = new LinearGradient(this.dXE.left, this.dXE.top, this.dXE.left, this.dXE.bottom, this.dXQ, this.dXR, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.dXV, this.dXW);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.dXV, this.dXW, this.mRadius, this.dXQ, this.dXR, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.cLK == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.dXM / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.dXV, this.dXW, new int[]{this.dXQ, this.dXR}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.dXV, this.dXW);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.dXG.setShader(shader);
            return;
        }
        this.dXG.setShader(null);
        this.dXG.setColor(this.dXQ);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.dXL, this.dXV, this.dXW);
        D(canvas);
        canvas.restore();
    }

    private void D(Canvas canvas) {
        switch (this.mStyle) {
            case 1:
                F(canvas);
                return;
            case 2:
                G(canvas);
                return;
            default:
                E(canvas);
                return;
        }
    }

    private void E(Canvas canvas) {
        float f = (float) (6.283185307179586d / this.cNI);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.dXK;
        int i = (int) ((this.mProgress / this.dXJ) * this.cNI);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cNI) {
                float f4 = i3 * (-f);
                float cos = this.dXV + (((float) Math.cos(f4)) * f3);
                float sin = this.dXW - (((float) Math.sin(f4)) * f3);
                float cos2 = this.dXV + (((float) Math.cos(f4)) * f2);
                float sin2 = this.dXW - (((float) Math.sin(f4)) * f2);
                if (this.dXS) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.dXH);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dXH);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dXG);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void F(Canvas canvas) {
        if (this.dXS) {
            float f = (this.mProgress * 360.0f) / this.dXJ;
            canvas.drawArc(this.dXE, f, 360.0f - f, true, this.dXH);
        } else {
            canvas.drawArc(this.dXE, 0.0f, 360.0f, true, this.dXH);
        }
        canvas.drawArc(this.dXE, 0.0f, (this.mProgress * 360.0f) / this.dXJ, true, this.dXG);
    }

    private void G(Canvas canvas) {
        if (this.dXS) {
            float f = (this.mProgress * 360.0f) / this.dXJ;
            canvas.drawArc(this.dXE, f, 360.0f - f, false, this.dXH);
        } else {
            canvas.drawArc(this.dXE, 0.0f, 360.0f, false, this.dXH);
        }
        canvas.drawArc(this.dXE, 0.0f, (this.mProgress * 360.0f) / this.dXJ, false, this.dXG);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dXV = i / 2.0f;
        this.dXW = i2 / 2.0f;
        this.mRadius = Math.min(this.dXV, this.dXW);
        this.dXE.top = this.dXW - this.mRadius;
        this.dXE.bottom = this.dXW + this.mRadius;
        this.dXE.left = this.dXV - this.mRadius;
        this.dXE.right = this.dXV + this.mRadius;
        aQZ();
        this.dXE.inset(this.dXM / 2.0f, this.dXM / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.dXT = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.dXM = f;
        this.dXE.inset(this.dXM / 2.0f, this.dXM / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.dXN = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.dXQ = i;
        aQZ();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.dXR = i;
        aQZ();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.dXO = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.dXP = i;
        this.dXH.setColor(this.dXP);
        invalidate();
    }

    public void setLineCount(int i) {
        this.cNI = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.dXK = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.dXG.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dXH.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.dXU = i;
        aQZ();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.cLK = cap;
        this.dXG.setStrokeCap(cap);
        this.dXH.setStrokeCap(cap);
        invalidate();
    }

    public void setProgress(int i) {
        this.mProgress = i;
        invalidate();
    }

    public void setMax(int i) {
        this.dXJ = i;
        invalidate();
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getMax() {
        return this.dXJ;
    }

    public int getStartDegree() {
        return this.dXL;
    }

    public void setStartDegree(int i) {
        this.dXL = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.dXS = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.swan.facade.requred.webview.LoadingProgressBar.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: B */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: kJ */
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

    /* loaded from: classes3.dex */
    private static final class a implements b {
        private a() {
        }
    }
}
