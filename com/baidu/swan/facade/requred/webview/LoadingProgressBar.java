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
    private float aVF;
    private float aVG;
    private Paint.Cap bFA;
    private int bHy;
    private final RectF cFh;
    private final Rect cFi;
    private final Paint cFj;
    private final Paint cFk;
    private final Paint cFl;
    private float cFm;
    private int cFn;
    private float cFo;
    private float cFp;
    private int cFq;
    private int cFr;
    private int cFs;
    private int cFt;
    private boolean cFu;
    private b cFv;
    private int cFw;
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
        this.cFh = new RectF();
        this.cFi = new Rect();
        this.cFj = new Paint(1);
        this.cFk = new Paint(1);
        this.cFl = new TextPaint(1);
        this.bFA = Paint.Cap.ROUND;
        this.mMax = 100;
        this.bHy = 45;
        this.cFm = 4.0f;
        this.cFn = -90;
        this.cFo = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.cFp = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.cFq = getResources().getColor(a.C0354a.aiapps_white);
        this.cFu = false;
        this.cFv = new a();
        this.cFw = 2;
        this.mStyle = 2;
        qs();
    }

    private void qs() {
        this.cFr = getResources().getColor(a.C0354a.aiapps_progress_background_color);
        this.cFs = getResources().getColor(a.C0354a.aiapps_progress_start_color);
        this.cFt = getResources().getColor(a.C0354a.aiapps_progress_end_color);
        this.cFl.setTextAlign(Paint.Align.CENTER);
        this.cFl.setTextSize(this.cFp);
        this.cFj.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cFj.setStrokeWidth(this.cFo);
        this.cFj.setColor(this.cFs);
        this.cFj.setStrokeCap(this.bFA);
        this.cFk.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cFk.setStrokeWidth(this.cFo);
        this.cFk.setColor(this.cFr);
        this.cFk.setStrokeCap(this.bFA);
    }

    private void asg() {
        Shader shader = null;
        if (this.cFs != this.cFt) {
            switch (this.cFw) {
                case 0:
                    shader = new LinearGradient(this.cFh.left, this.cFh.top, this.cFh.left, this.cFh.bottom, this.cFs, this.cFt, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.aVF, this.aVG);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.aVF, this.aVG, this.mRadius, this.cFs, this.cFt, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.bFA == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.cFo / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.aVF, this.aVG, new int[]{this.cFs, this.cFt}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.aVF, this.aVG);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.cFj.setShader(shader);
            return;
        }
        this.cFj.setShader(null);
        this.cFj.setColor(this.cFs);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.cFn, this.aVF, this.aVG);
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
        float f = (float) (6.283185307179586d / this.bHy);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.cFm;
        int i = (int) ((this.mProgress / this.mMax) * this.bHy);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bHy) {
                float f4 = i3 * (-f);
                float cos = this.aVF + (((float) Math.cos(f4)) * f3);
                float sin = this.aVG - (((float) Math.sin(f4)) * f3);
                float cos2 = this.aVF + (((float) Math.cos(f4)) * f2);
                float sin2 = this.aVG - (((float) Math.sin(f4)) * f2);
                if (this.cFu) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.cFk);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cFk);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cFj);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void v(Canvas canvas) {
        if (this.cFu) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cFh, f, 360.0f - f, true, this.cFk);
        } else {
            canvas.drawArc(this.cFh, 0.0f, 360.0f, true, this.cFk);
        }
        canvas.drawArc(this.cFh, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.cFj);
    }

    private void w(Canvas canvas) {
        if (this.cFu) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cFh, f, 360.0f - f, false, this.cFk);
        } else {
            canvas.drawArc(this.cFh, 0.0f, 360.0f, false, this.cFk);
        }
        canvas.drawArc(this.cFh, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.cFj);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.aVF = i / 2.0f;
        this.aVG = i2 / 2.0f;
        this.mRadius = Math.min(this.aVF, this.aVG);
        this.cFh.top = this.aVG - this.mRadius;
        this.cFh.bottom = this.aVG + this.mRadius;
        this.cFh.left = this.aVF - this.mRadius;
        this.cFh.right = this.aVF + this.mRadius;
        asg();
        this.cFh.inset(this.cFo / 2.0f, this.cFo / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.cFv = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.cFo = f;
        this.cFh.inset(this.cFo / 2.0f, this.cFo / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.cFp = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.cFs = i;
        asg();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.cFt = i;
        asg();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.cFq = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.cFr = i;
        this.cFk.setColor(this.cFr);
        invalidate();
    }

    public void setLineCount(int i) {
        this.bHy = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.cFm = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.cFj.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cFk.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.cFw = i;
        asg();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.bFA = cap;
        this.cFj.setStrokeCap(cap);
        this.cFk.setStrokeCap(cap);
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
        return this.cFn;
    }

    public void setStartDegree(int i) {
        this.cFn = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.cFu = z;
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
            /* renamed from: hH */
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
