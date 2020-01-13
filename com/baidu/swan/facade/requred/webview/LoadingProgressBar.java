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
/* loaded from: classes10.dex */
public class LoadingProgressBar extends View {
    private float axs;
    private float axt;
    private Paint.Cap bcL;
    private int beN;
    private final RectF cbR;
    private final Rect cbS;
    private final Paint cbT;
    private final Paint cbU;
    private final Paint cbV;
    private float cbW;
    private int cbX;
    private float cbY;
    private float cbZ;
    private int cca;
    private int ccb;
    private int ccc;
    private int ccd;
    private boolean cce;
    private b ccf;
    private int ccg;
    private int mMax;
    private int mProgress;
    private float mRadius;
    private int mStyle;

    /* loaded from: classes10.dex */
    public interface b {
    }

    public LoadingProgressBar(Context context) {
        this(context, null);
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbR = new RectF();
        this.cbS = new Rect();
        this.cbT = new Paint(1);
        this.cbU = new Paint(1);
        this.cbV = new TextPaint(1);
        this.bcL = Paint.Cap.ROUND;
        this.mMax = 100;
        this.beN = 45;
        this.cbW = 4.0f;
        this.cbX = -90;
        this.cbY = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.cbZ = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.cca = getResources().getColor(a.C0314a.aiapps_white);
        this.cce = false;
        this.ccf = new a();
        this.ccg = 2;
        this.mStyle = 2;
        lB();
    }

    private void lB() {
        this.ccb = getResources().getColor(a.C0314a.aiapps_progress_background_color);
        this.ccc = getResources().getColor(a.C0314a.aiapps_progress_start_color);
        this.ccd = getResources().getColor(a.C0314a.aiapps_progress_end_color);
        this.cbV.setTextAlign(Paint.Align.CENTER);
        this.cbV.setTextSize(this.cbZ);
        this.cbT.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cbT.setStrokeWidth(this.cbY);
        this.cbT.setColor(this.ccc);
        this.cbT.setStrokeCap(this.bcL);
        this.cbU.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cbU.setStrokeWidth(this.cbY);
        this.cbU.setColor(this.ccb);
        this.cbU.setStrokeCap(this.bcL);
    }

    private void ahF() {
        Shader shader = null;
        if (this.ccc != this.ccd) {
            switch (this.ccg) {
                case 0:
                    shader = new LinearGradient(this.cbR.left, this.cbR.top, this.cbR.left, this.cbR.bottom, this.ccc, this.ccd, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.axs, this.axt);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.axs, this.axt, this.mRadius, this.ccc, this.ccd, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.bcL == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.cbY / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.axs, this.axt, new int[]{this.ccc, this.ccd}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.axs, this.axt);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.cbT.setShader(shader);
            return;
        }
        this.cbT.setShader(null);
        this.cbT.setColor(this.ccc);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.cbX, this.axs, this.axt);
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
        float f = (float) (6.283185307179586d / this.beN);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.cbW;
        int i = (int) ((this.mProgress / this.mMax) * this.beN);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.beN) {
                float f4 = i3 * (-f);
                float cos = this.axs + (((float) Math.cos(f4)) * f3);
                float sin = this.axt - (((float) Math.sin(f4)) * f3);
                float cos2 = this.axs + (((float) Math.cos(f4)) * f2);
                float sin2 = this.axt - (((float) Math.sin(f4)) * f2);
                if (this.cce) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.cbU);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cbU);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cbT);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void v(Canvas canvas) {
        if (this.cce) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cbR, f, 360.0f - f, true, this.cbU);
        } else {
            canvas.drawArc(this.cbR, 0.0f, 360.0f, true, this.cbU);
        }
        canvas.drawArc(this.cbR, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.cbT);
    }

    private void w(Canvas canvas) {
        if (this.cce) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cbR, f, 360.0f - f, false, this.cbU);
        } else {
            canvas.drawArc(this.cbR, 0.0f, 360.0f, false, this.cbU);
        }
        canvas.drawArc(this.cbR, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.cbT);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.axs = i / 2.0f;
        this.axt = i2 / 2.0f;
        this.mRadius = Math.min(this.axs, this.axt);
        this.cbR.top = this.axt - this.mRadius;
        this.cbR.bottom = this.axt + this.mRadius;
        this.cbR.left = this.axs - this.mRadius;
        this.cbR.right = this.axs + this.mRadius;
        ahF();
        this.cbR.inset(this.cbY / 2.0f, this.cbY / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.ccf = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.cbY = f;
        this.cbR.inset(this.cbY / 2.0f, this.cbY / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.cbZ = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.ccc = i;
        ahF();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.ccd = i;
        ahF();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.cca = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.ccb = i;
        this.cbU.setColor(this.ccb);
        invalidate();
    }

    public void setLineCount(int i) {
        this.beN = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.cbW = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.cbT.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cbU.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.ccg = i;
        ahF();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.bcL = cap;
        this.cbT.setStrokeCap(cap);
        this.cbU.setStrokeCap(cap);
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
        return this.cbX;
    }

    public void setStartDegree(int i) {
        this.cbX = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.cce = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    private static final class a implements b {
        private a() {
        }
    }
}
