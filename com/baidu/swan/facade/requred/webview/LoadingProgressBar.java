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
/* loaded from: classes6.dex */
public class LoadingProgressBar extends View {
    private Paint.Cap cME;
    private int cOG;
    private final RectF dYJ;
    private final Rect dYK;
    private final Paint dYL;
    private final Paint dYM;
    private final Paint dYN;
    private int dYO;
    private float dYP;
    private int dYQ;
    private float dYR;
    private float dYS;
    private int dYT;
    private int dYU;
    private int dYV;
    private int dYW;
    private boolean dYX;
    private b dYY;
    private int dYZ;
    private float dZa;
    private float dZb;
    private int mProgress;
    private float mRadius;
    private int mStyle;

    /* loaded from: classes6.dex */
    public interface b {
    }

    public LoadingProgressBar(Context context) {
        this(context, null);
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dYJ = new RectF();
        this.dYK = new Rect();
        this.dYL = new Paint(1);
        this.dYM = new Paint(1);
        this.dYN = new TextPaint(1);
        this.cME = Paint.Cap.ROUND;
        this.dYO = 100;
        this.cOG = 45;
        this.dYP = 4.0f;
        this.dYQ = -90;
        this.dYR = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.dYS = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.dYT = getResources().getColor(a.C0514a.aiapps_white);
        this.dYX = false;
        this.dYY = new a();
        this.dYZ = 2;
        this.mStyle = 2;
        sa();
    }

    private void sa() {
        this.dYU = getResources().getColor(a.C0514a.aiapps_progress_background_color);
        this.dYV = getResources().getColor(a.C0514a.aiapps_progress_start_color);
        this.dYW = getResources().getColor(a.C0514a.aiapps_progress_end_color);
        this.dYN.setTextAlign(Paint.Align.CENTER);
        this.dYN.setTextSize(this.dYS);
        this.dYL.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dYL.setStrokeWidth(this.dYR);
        this.dYL.setColor(this.dYV);
        this.dYL.setStrokeCap(this.cME);
        this.dYM.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dYM.setStrokeWidth(this.dYR);
        this.dYM.setColor(this.dYU);
        this.dYM.setStrokeCap(this.cME);
    }

    private void aUw() {
        Shader shader = null;
        if (this.dYV != this.dYW) {
            switch (this.dYZ) {
                case 0:
                    shader = new LinearGradient(this.dYJ.left, this.dYJ.top, this.dYJ.left, this.dYJ.bottom, this.dYV, this.dYW, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.dZa, this.dZb);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.dZa, this.dZb, this.mRadius, this.dYV, this.dYW, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.cME == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.dYR / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.dZa, this.dZb, new int[]{this.dYV, this.dYW}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.dZa, this.dZb);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.dYL.setShader(shader);
            return;
        }
        this.dYL.setShader(null);
        this.dYL.setColor(this.dYV);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.dYQ, this.dZa, this.dZb);
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
        float f = (float) (6.283185307179586d / this.cOG);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.dYP;
        int i = (int) ((this.mProgress / this.dYO) * this.cOG);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cOG) {
                float f4 = i3 * (-f);
                float cos = this.dZa + (((float) Math.cos(f4)) * f3);
                float sin = this.dZb - (((float) Math.sin(f4)) * f3);
                float cos2 = this.dZa + (((float) Math.cos(f4)) * f2);
                float sin2 = this.dZb - (((float) Math.sin(f4)) * f2);
                if (this.dYX) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.dYM);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dYM);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dYL);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void F(Canvas canvas) {
        if (this.dYX) {
            float f = (this.mProgress * 360.0f) / this.dYO;
            canvas.drawArc(this.dYJ, f, 360.0f - f, true, this.dYM);
        } else {
            canvas.drawArc(this.dYJ, 0.0f, 360.0f, true, this.dYM);
        }
        canvas.drawArc(this.dYJ, 0.0f, (this.mProgress * 360.0f) / this.dYO, true, this.dYL);
    }

    private void G(Canvas canvas) {
        if (this.dYX) {
            float f = (this.mProgress * 360.0f) / this.dYO;
            canvas.drawArc(this.dYJ, f, 360.0f - f, false, this.dYM);
        } else {
            canvas.drawArc(this.dYJ, 0.0f, 360.0f, false, this.dYM);
        }
        canvas.drawArc(this.dYJ, 0.0f, (this.mProgress * 360.0f) / this.dYO, false, this.dYL);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dZa = i / 2.0f;
        this.dZb = i2 / 2.0f;
        this.mRadius = Math.min(this.dZa, this.dZb);
        this.dYJ.top = this.dZb - this.mRadius;
        this.dYJ.bottom = this.dZb + this.mRadius;
        this.dYJ.left = this.dZa - this.mRadius;
        this.dYJ.right = this.dZa + this.mRadius;
        aUw();
        this.dYJ.inset(this.dYR / 2.0f, this.dYR / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.dYY = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.dYR = f;
        this.dYJ.inset(this.dYR / 2.0f, this.dYR / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.dYS = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.dYV = i;
        aUw();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.dYW = i;
        aUw();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.dYT = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.dYU = i;
        this.dYM.setColor(this.dYU);
        invalidate();
    }

    public void setLineCount(int i) {
        this.cOG = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.dYP = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.dYL.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dYM.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.dYZ = i;
        aUw();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.cME = cap;
        this.dYL.setStrokeCap(cap);
        this.dYM.setStrokeCap(cap);
        invalidate();
    }

    public void setProgress(int i) {
        this.mProgress = i;
        invalidate();
    }

    public void setMax(int i) {
        this.dYO = i;
        invalidate();
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getMax() {
        return this.dYO;
    }

    public int getStartDegree() {
        return this.dYQ;
    }

    public void setStartDegree(int i) {
        this.dYQ = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.dYX = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
            /* renamed from: ml */
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

    /* loaded from: classes6.dex */
    private static final class a implements b {
        private a() {
        }
    }
}
