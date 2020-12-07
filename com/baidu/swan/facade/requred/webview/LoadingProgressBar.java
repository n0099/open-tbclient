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
/* loaded from: classes8.dex */
public class LoadingProgressBar extends View {
    private Paint.Cap cHO;
    private int cJL;
    private final RectF dPN;
    private final Rect dPO;
    private final Paint dPP;
    private final Paint dPQ;
    private final Paint dPR;
    private float dPS;
    private int dPT;
    private float dPU;
    private float dPV;
    private int dPW;
    private int dPX;
    private int dPY;
    private int dPZ;
    private boolean dQa;
    private b dQb;
    private int dQc;
    private float dQd;
    private float dQe;
    private int mMax;
    private int mProgress;
    private float mRadius;
    private int mStyle;

    /* loaded from: classes8.dex */
    public interface b {
    }

    public LoadingProgressBar(Context context) {
        this(context, null);
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dPN = new RectF();
        this.dPO = new Rect();
        this.dPP = new Paint(1);
        this.dPQ = new Paint(1);
        this.dPR = new TextPaint(1);
        this.cHO = Paint.Cap.ROUND;
        this.mMax = 100;
        this.cJL = 45;
        this.dPS = 4.0f;
        this.dPT = -90;
        this.dPU = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.dPV = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.dPW = getResources().getColor(a.C0521a.aiapps_white);
        this.dQa = false;
        this.dQb = new a();
        this.dQc = 2;
        this.mStyle = 2;
        sz();
    }

    private void sz() {
        this.dPX = getResources().getColor(a.C0521a.aiapps_progress_background_color);
        this.dPY = getResources().getColor(a.C0521a.aiapps_progress_start_color);
        this.dPZ = getResources().getColor(a.C0521a.aiapps_progress_end_color);
        this.dPR.setTextAlign(Paint.Align.CENTER);
        this.dPR.setTextSize(this.dPV);
        this.dPP.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dPP.setStrokeWidth(this.dPU);
        this.dPP.setColor(this.dPY);
        this.dPP.setStrokeCap(this.cHO);
        this.dPQ.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dPQ.setStrokeWidth(this.dPU);
        this.dPQ.setColor(this.dPX);
        this.dPQ.setStrokeCap(this.cHO);
    }

    private void aSc() {
        Shader shader = null;
        if (this.dPY != this.dPZ) {
            switch (this.dQc) {
                case 0:
                    shader = new LinearGradient(this.dPN.left, this.dPN.top, this.dPN.left, this.dPN.bottom, this.dPY, this.dPZ, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.dQd, this.dQe);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.dQd, this.dQe, this.mRadius, this.dPY, this.dPZ, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.cHO == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.dPU / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.dQd, this.dQe, new int[]{this.dPY, this.dPZ}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.dQd, this.dQe);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.dPP.setShader(shader);
            return;
        }
        this.dPP.setShader(null);
        this.dPP.setColor(this.dPY);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.dPT, this.dQd, this.dQe);
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
        float f = (float) (6.283185307179586d / this.cJL);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.dPS;
        int i = (int) ((this.mProgress / this.mMax) * this.cJL);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cJL) {
                float f4 = i3 * (-f);
                float cos = this.dQd + (((float) Math.cos(f4)) * f3);
                float sin = this.dQe - (((float) Math.sin(f4)) * f3);
                float cos2 = this.dQd + (((float) Math.cos(f4)) * f2);
                float sin2 = this.dQe - (((float) Math.sin(f4)) * f2);
                if (this.dQa) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.dPQ);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dPQ);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dPP);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void y(Canvas canvas) {
        if (this.dQa) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dPN, f, 360.0f - f, true, this.dPQ);
        } else {
            canvas.drawArc(this.dPN, 0.0f, 360.0f, true, this.dPQ);
        }
        canvas.drawArc(this.dPN, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.dPP);
    }

    private void z(Canvas canvas) {
        if (this.dQa) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dPN, f, 360.0f - f, false, this.dPQ);
        } else {
            canvas.drawArc(this.dPN, 0.0f, 360.0f, false, this.dPQ);
        }
        canvas.drawArc(this.dPN, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.dPP);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dQd = i / 2.0f;
        this.dQe = i2 / 2.0f;
        this.mRadius = Math.min(this.dQd, this.dQe);
        this.dPN.top = this.dQe - this.mRadius;
        this.dPN.bottom = this.dQe + this.mRadius;
        this.dPN.left = this.dQd - this.mRadius;
        this.dPN.right = this.dQd + this.mRadius;
        aSc();
        this.dPN.inset(this.dPU / 2.0f, this.dPU / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.dQb = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.dPU = f;
        this.dPN.inset(this.dPU / 2.0f, this.dPU / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.dPV = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.dPY = i;
        aSc();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.dPZ = i;
        aSc();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.dPW = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.dPX = i;
        this.dPQ.setColor(this.dPX);
        invalidate();
    }

    public void setLineCount(int i) {
        this.cJL = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.dPS = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.dPP.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dPQ.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.dQc = i;
        aSc();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.cHO = cap;
        this.dPP.setStrokeCap(cap);
        this.dPQ.setStrokeCap(cap);
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
        return this.dPT;
    }

    public void setStartDegree(int i) {
        this.dPT = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.dQa = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
            /* renamed from: md */
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

    /* loaded from: classes8.dex */
    private static final class a implements b {
        private a() {
        }
    }
}
