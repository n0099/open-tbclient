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
    private float aBI;
    private float aBJ;
    private Paint.Cap bha;
    private int bjb;
    private final RectF cfW;
    private final Rect cfX;
    private final Paint cfY;
    private final Paint cfZ;
    private final Paint cga;
    private float cgb;
    private int cgc;
    private float cgd;
    private float cge;
    private int cgf;
    private int cgg;
    private int cgh;
    private int cgi;
    private boolean cgj;
    private b cgk;
    private int cgl;
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
        this.cfW = new RectF();
        this.cfX = new Rect();
        this.cfY = new Paint(1);
        this.cfZ = new Paint(1);
        this.cga = new TextPaint(1);
        this.bha = Paint.Cap.ROUND;
        this.mMax = 100;
        this.bjb = 45;
        this.cgb = 4.0f;
        this.cgc = -90;
        this.cgd = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.cge = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.cgf = getResources().getColor(a.C0324a.aiapps_white);
        this.cgj = false;
        this.cgk = new a();
        this.cgl = 2;
        this.mStyle = 2;
        lQ();
    }

    private void lQ() {
        this.cgg = getResources().getColor(a.C0324a.aiapps_progress_background_color);
        this.cgh = getResources().getColor(a.C0324a.aiapps_progress_start_color);
        this.cgi = getResources().getColor(a.C0324a.aiapps_progress_end_color);
        this.cga.setTextAlign(Paint.Align.CENTER);
        this.cga.setTextSize(this.cge);
        this.cfY.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cfY.setStrokeWidth(this.cgd);
        this.cfY.setColor(this.cgh);
        this.cfY.setStrokeCap(this.bha);
        this.cfZ.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cfZ.setStrokeWidth(this.cgd);
        this.cfZ.setColor(this.cgg);
        this.cfZ.setStrokeCap(this.bha);
    }

    private void ajT() {
        Shader shader = null;
        if (this.cgh != this.cgi) {
            switch (this.cgl) {
                case 0:
                    shader = new LinearGradient(this.cfW.left, this.cfW.top, this.cfW.left, this.cfW.bottom, this.cgh, this.cgi, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.aBI, this.aBJ);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.aBI, this.aBJ, this.mRadius, this.cgh, this.cgi, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.bha == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.cgd / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.aBI, this.aBJ, new int[]{this.cgh, this.cgi}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.aBI, this.aBJ);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.cfY.setShader(shader);
            return;
        }
        this.cfY.setShader(null);
        this.cfY.setColor(this.cgh);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.cgc, this.aBI, this.aBJ);
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
        float f = (float) (6.283185307179586d / this.bjb);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.cgb;
        int i = (int) ((this.mProgress / this.mMax) * this.bjb);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bjb) {
                float f4 = i3 * (-f);
                float cos = this.aBI + (((float) Math.cos(f4)) * f3);
                float sin = this.aBJ - (((float) Math.sin(f4)) * f3);
                float cos2 = this.aBI + (((float) Math.cos(f4)) * f2);
                float sin2 = this.aBJ - (((float) Math.sin(f4)) * f2);
                if (this.cgj) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.cfZ);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cfZ);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cfY);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void v(Canvas canvas) {
        if (this.cgj) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cfW, f, 360.0f - f, true, this.cfZ);
        } else {
            canvas.drawArc(this.cfW, 0.0f, 360.0f, true, this.cfZ);
        }
        canvas.drawArc(this.cfW, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.cfY);
    }

    private void w(Canvas canvas) {
        if (this.cgj) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cfW, f, 360.0f - f, false, this.cfZ);
        } else {
            canvas.drawArc(this.cfW, 0.0f, 360.0f, false, this.cfZ);
        }
        canvas.drawArc(this.cfW, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.cfY);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.aBI = i / 2.0f;
        this.aBJ = i2 / 2.0f;
        this.mRadius = Math.min(this.aBI, this.aBJ);
        this.cfW.top = this.aBJ - this.mRadius;
        this.cfW.bottom = this.aBJ + this.mRadius;
        this.cfW.left = this.aBI - this.mRadius;
        this.cfW.right = this.aBI + this.mRadius;
        ajT();
        this.cfW.inset(this.cgd / 2.0f, this.cgd / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.cgk = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.cgd = f;
        this.cfW.inset(this.cgd / 2.0f, this.cgd / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.cge = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.cgh = i;
        ajT();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.cgi = i;
        ajT();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.cgf = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.cgg = i;
        this.cfZ.setColor(this.cgg);
        invalidate();
    }

    public void setLineCount(int i) {
        this.bjb = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.cgb = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.cfY.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cfZ.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.cgl = i;
        ajT();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.bha = cap;
        this.cfY.setStrokeCap(cap);
        this.cfZ.setStrokeCap(cap);
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
        return this.cgc;
    }

    public void setStartDegree(int i) {
        this.cgc = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.cgj = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
            /* renamed from: hA */
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
