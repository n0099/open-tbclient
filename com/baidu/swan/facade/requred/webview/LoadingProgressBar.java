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
    private Paint.Cap cAS;
    private int cCQ;
    private final RectF dIP;
    private final Rect dIQ;
    private final Paint dIR;
    private final Paint dIS;
    private final Paint dIT;
    private float dIU;
    private int dIV;
    private float dIW;
    private float dIX;
    private int dIY;
    private int dIZ;
    private int dJa;
    private int dJb;
    private boolean dJc;
    private b dJd;
    private int dJe;
    private float dJf;
    private float dJg;
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
        this.dIP = new RectF();
        this.dIQ = new Rect();
        this.dIR = new Paint(1);
        this.dIS = new Paint(1);
        this.dIT = new TextPaint(1);
        this.cAS = Paint.Cap.ROUND;
        this.mMax = 100;
        this.cCQ = 45;
        this.dIU = 4.0f;
        this.dIV = -90;
        this.dIW = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.dIX = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.dIY = getResources().getColor(a.C0509a.aiapps_white);
        this.dJc = false;
        this.dJd = new a();
        this.dJe = 2;
        this.mStyle = 2;
        sw();
    }

    private void sw() {
        this.dIZ = getResources().getColor(a.C0509a.aiapps_progress_background_color);
        this.dJa = getResources().getColor(a.C0509a.aiapps_progress_start_color);
        this.dJb = getResources().getColor(a.C0509a.aiapps_progress_end_color);
        this.dIT.setTextAlign(Paint.Align.CENTER);
        this.dIT.setTextSize(this.dIX);
        this.dIR.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dIR.setStrokeWidth(this.dIW);
        this.dIR.setColor(this.dJa);
        this.dIR.setStrokeCap(this.cAS);
        this.dIS.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dIS.setStrokeWidth(this.dIW);
        this.dIS.setColor(this.dIZ);
        this.dIS.setStrokeCap(this.cAS);
    }

    private void aOX() {
        Shader shader = null;
        if (this.dJa != this.dJb) {
            switch (this.dJe) {
                case 0:
                    shader = new LinearGradient(this.dIP.left, this.dIP.top, this.dIP.left, this.dIP.bottom, this.dJa, this.dJb, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.dJf, this.dJg);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.dJf, this.dJg, this.mRadius, this.dJa, this.dJb, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.cAS == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.dIW / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.dJf, this.dJg, new int[]{this.dJa, this.dJb}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.dJf, this.dJg);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.dIR.setShader(shader);
            return;
        }
        this.dIR.setShader(null);
        this.dIR.setColor(this.dJa);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.dIV, this.dJf, this.dJg);
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
        float f = (float) (6.283185307179586d / this.cCQ);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.dIU;
        int i = (int) ((this.mProgress / this.mMax) * this.cCQ);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cCQ) {
                float f4 = i3 * (-f);
                float cos = this.dJf + (((float) Math.cos(f4)) * f3);
                float sin = this.dJg - (((float) Math.sin(f4)) * f3);
                float cos2 = this.dJf + (((float) Math.cos(f4)) * f2);
                float sin2 = this.dJg - (((float) Math.sin(f4)) * f2);
                if (this.dJc) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.dIS);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dIS);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dIR);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void y(Canvas canvas) {
        if (this.dJc) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dIP, f, 360.0f - f, true, this.dIS);
        } else {
            canvas.drawArc(this.dIP, 0.0f, 360.0f, true, this.dIS);
        }
        canvas.drawArc(this.dIP, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.dIR);
    }

    private void z(Canvas canvas) {
        if (this.dJc) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dIP, f, 360.0f - f, false, this.dIS);
        } else {
            canvas.drawArc(this.dIP, 0.0f, 360.0f, false, this.dIS);
        }
        canvas.drawArc(this.dIP, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.dIR);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dJf = i / 2.0f;
        this.dJg = i2 / 2.0f;
        this.mRadius = Math.min(this.dJf, this.dJg);
        this.dIP.top = this.dJg - this.mRadius;
        this.dIP.bottom = this.dJg + this.mRadius;
        this.dIP.left = this.dJf - this.mRadius;
        this.dIP.right = this.dJf + this.mRadius;
        aOX();
        this.dIP.inset(this.dIW / 2.0f, this.dIW / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.dJd = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.dIW = f;
        this.dIP.inset(this.dIW / 2.0f, this.dIW / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.dIX = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.dJa = i;
        aOX();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.dJb = i;
        aOX();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.dIY = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.dIZ = i;
        this.dIS.setColor(this.dIZ);
        invalidate();
    }

    public void setLineCount(int i) {
        this.cCQ = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.dIU = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.dIR.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dIS.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.dJe = i;
        aOX();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.cAS = cap;
        this.dIR.setStrokeCap(cap);
        this.dIS.setStrokeCap(cap);
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
        return this.dIV;
    }

    public void setStartDegree(int i) {
        this.dIV = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.dJc = z;
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
            /* renamed from: lF */
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
