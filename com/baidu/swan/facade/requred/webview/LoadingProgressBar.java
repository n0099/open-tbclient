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
/* loaded from: classes4.dex */
public class LoadingProgressBar extends View {
    private Paint.Cap bUd;
    private int bWb;
    private float biF;
    private float biG;
    private final RectF cYK;
    private final Rect cYL;
    private final Paint cYM;
    private final Paint cYN;
    private final Paint cYO;
    private float cYP;
    private int cYQ;
    private float cYR;
    private float cYS;
    private int cYT;
    private int cYU;
    private int cYV;
    private int cYW;
    private boolean cYX;
    private b cYY;
    private int cYZ;
    private int mMax;
    private int mProgress;
    private float mRadius;
    private int mStyle;

    /* loaded from: classes4.dex */
    public interface b {
    }

    public LoadingProgressBar(Context context) {
        this(context, null);
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cYK = new RectF();
        this.cYL = new Rect();
        this.cYM = new Paint(1);
        this.cYN = new Paint(1);
        this.cYO = new TextPaint(1);
        this.bUd = Paint.Cap.ROUND;
        this.mMax = 100;
        this.bWb = 45;
        this.cYP = 4.0f;
        this.cYQ = -90;
        this.cYR = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.cYS = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.cYT = getResources().getColor(a.C0428a.aiapps_white);
        this.cYX = false;
        this.cYY = new a();
        this.cYZ = 2;
        this.mStyle = 2;
        qS();
    }

    private void qS() {
        this.cYU = getResources().getColor(a.C0428a.aiapps_progress_background_color);
        this.cYV = getResources().getColor(a.C0428a.aiapps_progress_start_color);
        this.cYW = getResources().getColor(a.C0428a.aiapps_progress_end_color);
        this.cYO.setTextAlign(Paint.Align.CENTER);
        this.cYO.setTextSize(this.cYS);
        this.cYM.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cYM.setStrokeWidth(this.cYR);
        this.cYM.setColor(this.cYV);
        this.cYM.setStrokeCap(this.bUd);
        this.cYN.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cYN.setStrokeWidth(this.cYR);
        this.cYN.setColor(this.cYU);
        this.cYN.setStrokeCap(this.bUd);
    }

    private void azI() {
        Shader shader = null;
        if (this.cYV != this.cYW) {
            switch (this.cYZ) {
                case 0:
                    shader = new LinearGradient(this.cYK.left, this.cYK.top, this.cYK.left, this.cYK.bottom, this.cYV, this.cYW, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.biF, this.biG);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.biF, this.biG, this.mRadius, this.cYV, this.cYW, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.bUd == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.cYR / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.biF, this.biG, new int[]{this.cYV, this.cYW}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.biF, this.biG);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.cYM.setShader(shader);
            return;
        }
        this.cYM.setShader(null);
        this.cYM.setColor(this.cYV);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.cYQ, this.biF, this.biG);
        u(canvas);
        canvas.restore();
    }

    private void u(Canvas canvas) {
        switch (this.mStyle) {
            case 1:
                w(canvas);
                return;
            case 2:
                x(canvas);
                return;
            default:
                v(canvas);
                return;
        }
    }

    private void v(Canvas canvas) {
        float f = (float) (6.283185307179586d / this.bWb);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.cYP;
        int i = (int) ((this.mProgress / this.mMax) * this.bWb);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bWb) {
                float f4 = i3 * (-f);
                float cos = this.biF + (((float) Math.cos(f4)) * f3);
                float sin = this.biG - (((float) Math.sin(f4)) * f3);
                float cos2 = this.biF + (((float) Math.cos(f4)) * f2);
                float sin2 = this.biG - (((float) Math.sin(f4)) * f2);
                if (this.cYX) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.cYN);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cYN);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cYM);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void w(Canvas canvas) {
        if (this.cYX) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cYK, f, 360.0f - f, true, this.cYN);
        } else {
            canvas.drawArc(this.cYK, 0.0f, 360.0f, true, this.cYN);
        }
        canvas.drawArc(this.cYK, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.cYM);
    }

    private void x(Canvas canvas) {
        if (this.cYX) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cYK, f, 360.0f - f, false, this.cYN);
        } else {
            canvas.drawArc(this.cYK, 0.0f, 360.0f, false, this.cYN);
        }
        canvas.drawArc(this.cYK, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.cYM);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.biF = i / 2.0f;
        this.biG = i2 / 2.0f;
        this.mRadius = Math.min(this.biF, this.biG);
        this.cYK.top = this.biG - this.mRadius;
        this.cYK.bottom = this.biG + this.mRadius;
        this.cYK.left = this.biF - this.mRadius;
        this.cYK.right = this.biF + this.mRadius;
        azI();
        this.cYK.inset(this.cYR / 2.0f, this.cYR / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.cYY = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.cYR = f;
        this.cYK.inset(this.cYR / 2.0f, this.cYR / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.cYS = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.cYV = i;
        azI();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.cYW = i;
        azI();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.cYT = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.cYU = i;
        this.cYN.setColor(this.cYU);
        invalidate();
    }

    public void setLineCount(int i) {
        this.bWb = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.cYP = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.cYM.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cYN.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.cYZ = i;
        azI();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.bUd = cap;
        this.cYM.setStrokeCap(cap);
        this.cYN.setStrokeCap(cap);
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
        return this.cYQ;
    }

    public void setStartDegree(int i) {
        this.cYQ = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.cYX = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.swan.facade.requred.webview.LoadingProgressBar.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: z */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: iz */
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

    /* loaded from: classes4.dex */
    private static final class a implements b {
        private a() {
        }
    }
}
