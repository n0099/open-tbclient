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
/* loaded from: classes11.dex */
public class LoadingProgressBar extends View {
    private Paint.Cap bOx;
    private int bQv;
    private float bcY;
    private float bcZ;
    private final Paint cPA;
    private final Paint cPB;
    private float cPC;
    private int cPD;
    private float cPE;
    private float cPF;
    private int cPG;
    private int cPH;
    private int cPI;
    private int cPJ;
    private boolean cPK;
    private b cPL;
    private int cPM;
    private final RectF cPx;
    private final Rect cPy;
    private final Paint cPz;
    private int mMax;
    private int mProgress;
    private float mRadius;
    private int mStyle;

    /* loaded from: classes11.dex */
    public interface b {
    }

    public LoadingProgressBar(Context context) {
        this(context, null);
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cPx = new RectF();
        this.cPy = new Rect();
        this.cPz = new Paint(1);
        this.cPA = new Paint(1);
        this.cPB = new TextPaint(1);
        this.bOx = Paint.Cap.ROUND;
        this.mMax = 100;
        this.bQv = 45;
        this.cPC = 4.0f;
        this.cPD = -90;
        this.cPE = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.cPF = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.cPG = getResources().getColor(a.C0415a.aiapps_white);
        this.cPK = false;
        this.cPL = new a();
        this.cPM = 2;
        this.mStyle = 2;
        qy();
    }

    private void qy() {
        this.cPH = getResources().getColor(a.C0415a.aiapps_progress_background_color);
        this.cPI = getResources().getColor(a.C0415a.aiapps_progress_start_color);
        this.cPJ = getResources().getColor(a.C0415a.aiapps_progress_end_color);
        this.cPB.setTextAlign(Paint.Align.CENTER);
        this.cPB.setTextSize(this.cPF);
        this.cPz.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cPz.setStrokeWidth(this.cPE);
        this.cPz.setColor(this.cPI);
        this.cPz.setStrokeCap(this.bOx);
        this.cPA.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cPA.setStrokeWidth(this.cPE);
        this.cPA.setColor(this.cPH);
        this.cPA.setStrokeCap(this.bOx);
    }

    private void avO() {
        Shader shader = null;
        if (this.cPI != this.cPJ) {
            switch (this.cPM) {
                case 0:
                    shader = new LinearGradient(this.cPx.left, this.cPx.top, this.cPx.left, this.cPx.bottom, this.cPI, this.cPJ, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.bcY, this.bcZ);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.bcY, this.bcZ, this.mRadius, this.cPI, this.cPJ, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.bOx == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.cPE / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.bcY, this.bcZ, new int[]{this.cPI, this.cPJ}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.bcY, this.bcZ);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.cPz.setShader(shader);
            return;
        }
        this.cPz.setShader(null);
        this.cPz.setColor(this.cPI);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.cPD, this.bcY, this.bcZ);
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
        float f = (float) (6.283185307179586d / this.bQv);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.cPC;
        int i = (int) ((this.mProgress / this.mMax) * this.bQv);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bQv) {
                float f4 = i3 * (-f);
                float cos = this.bcY + (((float) Math.cos(f4)) * f3);
                float sin = this.bcZ - (((float) Math.sin(f4)) * f3);
                float cos2 = this.bcY + (((float) Math.cos(f4)) * f2);
                float sin2 = this.bcZ - (((float) Math.sin(f4)) * f2);
                if (this.cPK) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.cPA);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cPA);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cPz);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void w(Canvas canvas) {
        if (this.cPK) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cPx, f, 360.0f - f, true, this.cPA);
        } else {
            canvas.drawArc(this.cPx, 0.0f, 360.0f, true, this.cPA);
        }
        canvas.drawArc(this.cPx, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.cPz);
    }

    private void x(Canvas canvas) {
        if (this.cPK) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cPx, f, 360.0f - f, false, this.cPA);
        } else {
            canvas.drawArc(this.cPx, 0.0f, 360.0f, false, this.cPA);
        }
        canvas.drawArc(this.cPx, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.cPz);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bcY = i / 2.0f;
        this.bcZ = i2 / 2.0f;
        this.mRadius = Math.min(this.bcY, this.bcZ);
        this.cPx.top = this.bcZ - this.mRadius;
        this.cPx.bottom = this.bcZ + this.mRadius;
        this.cPx.left = this.bcY - this.mRadius;
        this.cPx.right = this.bcY + this.mRadius;
        avO();
        this.cPx.inset(this.cPE / 2.0f, this.cPE / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.cPL = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.cPE = f;
        this.cPx.inset(this.cPE / 2.0f, this.cPE / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.cPF = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.cPI = i;
        avO();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.cPJ = i;
        avO();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.cPG = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.cPH = i;
        this.cPA.setColor(this.cPH);
        invalidate();
    }

    public void setLineCount(int i) {
        this.bQv = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.cPC = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.cPz.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cPA.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.cPM = i;
        avO();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.bOx = cap;
        this.cPz.setStrokeCap(cap);
        this.cPA.setStrokeCap(cap);
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
        return this.cPD;
    }

    public void setStartDegree(int i) {
        this.cPD = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.cPK = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.swan.facade.requred.webview.LoadingProgressBar.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: x */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: hY */
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

    /* loaded from: classes11.dex */
    private static final class a implements b {
        private a() {
        }
    }
}
