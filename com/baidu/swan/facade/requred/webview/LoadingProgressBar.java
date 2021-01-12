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
    private Paint.Cap cHS;
    private int cJU;
    private final RectF dTX;
    private final Rect dTY;
    private final Paint dTZ;
    private final Paint dUa;
    private final Paint dUb;
    private int dUc;
    private float dUd;
    private int dUe;
    private float dUf;
    private float dUg;
    private int dUh;
    private int dUi;
    private int dUj;
    private int dUk;
    private boolean dUl;
    private b dUm;
    private int dUn;
    private float dUo;
    private float dUp;
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
        this.dTX = new RectF();
        this.dTY = new Rect();
        this.dTZ = new Paint(1);
        this.dUa = new Paint(1);
        this.dUb = new TextPaint(1);
        this.cHS = Paint.Cap.ROUND;
        this.dUc = 100;
        this.cJU = 45;
        this.dUd = 4.0f;
        this.dUe = -90;
        this.dUf = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.dUg = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.dUh = getResources().getColor(a.C0497a.aiapps_white);
        this.dUl = false;
        this.dUm = new a();
        this.dUn = 2;
        this.mStyle = 2;
        sa();
    }

    private void sa() {
        this.dUi = getResources().getColor(a.C0497a.aiapps_progress_background_color);
        this.dUj = getResources().getColor(a.C0497a.aiapps_progress_start_color);
        this.dUk = getResources().getColor(a.C0497a.aiapps_progress_end_color);
        this.dUb.setTextAlign(Paint.Align.CENTER);
        this.dUb.setTextSize(this.dUg);
        this.dTZ.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dTZ.setStrokeWidth(this.dUf);
        this.dTZ.setColor(this.dUj);
        this.dTZ.setStrokeCap(this.cHS);
        this.dUa.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dUa.setStrokeWidth(this.dUf);
        this.dUa.setColor(this.dUi);
        this.dUa.setStrokeCap(this.cHS);
    }

    private void aQD() {
        Shader shader = null;
        if (this.dUj != this.dUk) {
            switch (this.dUn) {
                case 0:
                    shader = new LinearGradient(this.dTX.left, this.dTX.top, this.dTX.left, this.dTX.bottom, this.dUj, this.dUk, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.dUo, this.dUp);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.dUo, this.dUp, this.mRadius, this.dUj, this.dUk, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.cHS == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.dUf / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.dUo, this.dUp, new int[]{this.dUj, this.dUk}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.dUo, this.dUp);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.dTZ.setShader(shader);
            return;
        }
        this.dTZ.setShader(null);
        this.dTZ.setColor(this.dUj);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.dUe, this.dUo, this.dUp);
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
        float f = (float) (6.283185307179586d / this.cJU);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.dUd;
        int i = (int) ((this.mProgress / this.dUc) * this.cJU);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cJU) {
                float f4 = i3 * (-f);
                float cos = this.dUo + (((float) Math.cos(f4)) * f3);
                float sin = this.dUp - (((float) Math.sin(f4)) * f3);
                float cos2 = this.dUo + (((float) Math.cos(f4)) * f2);
                float sin2 = this.dUp - (((float) Math.sin(f4)) * f2);
                if (this.dUl) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.dUa);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dUa);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dTZ);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void F(Canvas canvas) {
        if (this.dUl) {
            float f = (this.mProgress * 360.0f) / this.dUc;
            canvas.drawArc(this.dTX, f, 360.0f - f, true, this.dUa);
        } else {
            canvas.drawArc(this.dTX, 0.0f, 360.0f, true, this.dUa);
        }
        canvas.drawArc(this.dTX, 0.0f, (this.mProgress * 360.0f) / this.dUc, true, this.dTZ);
    }

    private void G(Canvas canvas) {
        if (this.dUl) {
            float f = (this.mProgress * 360.0f) / this.dUc;
            canvas.drawArc(this.dTX, f, 360.0f - f, false, this.dUa);
        } else {
            canvas.drawArc(this.dTX, 0.0f, 360.0f, false, this.dUa);
        }
        canvas.drawArc(this.dTX, 0.0f, (this.mProgress * 360.0f) / this.dUc, false, this.dTZ);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dUo = i / 2.0f;
        this.dUp = i2 / 2.0f;
        this.mRadius = Math.min(this.dUo, this.dUp);
        this.dTX.top = this.dUp - this.mRadius;
        this.dTX.bottom = this.dUp + this.mRadius;
        this.dTX.left = this.dUo - this.mRadius;
        this.dTX.right = this.dUo + this.mRadius;
        aQD();
        this.dTX.inset(this.dUf / 2.0f, this.dUf / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.dUm = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.dUf = f;
        this.dTX.inset(this.dUf / 2.0f, this.dUf / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.dUg = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.dUj = i;
        aQD();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.dUk = i;
        aQD();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.dUh = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.dUi = i;
        this.dUa.setColor(this.dUi);
        invalidate();
    }

    public void setLineCount(int i) {
        this.cJU = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.dUd = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.dTZ.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dUa.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.dUn = i;
        aQD();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.cHS = cap;
        this.dTZ.setStrokeCap(cap);
        this.dUa.setStrokeCap(cap);
        invalidate();
    }

    public void setProgress(int i) {
        this.mProgress = i;
        invalidate();
    }

    public void setMax(int i) {
        this.dUc = i;
        invalidate();
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getMax() {
        return this.dUc;
    }

    public int getStartDegree() {
        return this.dUe;
    }

    public void setStartDegree(int i) {
        this.dUe = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.dUl = z;
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
            /* renamed from: kF */
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
