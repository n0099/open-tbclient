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
    private float aVK;
    private float aVL;
    private Paint.Cap bFF;
    private int bHD;
    private boolean cFA;
    private b cFB;
    private int cFC;
    private final RectF cFn;
    private final Rect cFo;
    private final Paint cFp;
    private final Paint cFq;
    private final Paint cFr;
    private float cFs;
    private int cFt;
    private float cFu;
    private float cFv;
    private int cFw;
    private int cFx;
    private int cFy;
    private int cFz;
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
        this.cFn = new RectF();
        this.cFo = new Rect();
        this.cFp = new Paint(1);
        this.cFq = new Paint(1);
        this.cFr = new TextPaint(1);
        this.bFF = Paint.Cap.ROUND;
        this.mMax = 100;
        this.bHD = 45;
        this.cFs = 4.0f;
        this.cFt = -90;
        this.cFu = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.cFv = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.cFw = getResources().getColor(a.C0375a.aiapps_white);
        this.cFA = false;
        this.cFB = new a();
        this.cFC = 2;
        this.mStyle = 2;
        qs();
    }

    private void qs() {
        this.cFx = getResources().getColor(a.C0375a.aiapps_progress_background_color);
        this.cFy = getResources().getColor(a.C0375a.aiapps_progress_start_color);
        this.cFz = getResources().getColor(a.C0375a.aiapps_progress_end_color);
        this.cFr.setTextAlign(Paint.Align.CENTER);
        this.cFr.setTextSize(this.cFv);
        this.cFp.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cFp.setStrokeWidth(this.cFu);
        this.cFp.setColor(this.cFy);
        this.cFp.setStrokeCap(this.bFF);
        this.cFq.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cFq.setStrokeWidth(this.cFu);
        this.cFq.setColor(this.cFx);
        this.cFq.setStrokeCap(this.bFF);
    }

    private void asf() {
        Shader shader = null;
        if (this.cFy != this.cFz) {
            switch (this.cFC) {
                case 0:
                    shader = new LinearGradient(this.cFn.left, this.cFn.top, this.cFn.left, this.cFn.bottom, this.cFy, this.cFz, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.aVK, this.aVL);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.aVK, this.aVL, this.mRadius, this.cFy, this.cFz, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.bFF == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.cFu / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.aVK, this.aVL, new int[]{this.cFy, this.cFz}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.aVK, this.aVL);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.cFp.setShader(shader);
            return;
        }
        this.cFp.setShader(null);
        this.cFp.setColor(this.cFy);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.cFt, this.aVK, this.aVL);
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
        float f = (float) (6.283185307179586d / this.bHD);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.cFs;
        int i = (int) ((this.mProgress / this.mMax) * this.bHD);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bHD) {
                float f4 = i3 * (-f);
                float cos = this.aVK + (((float) Math.cos(f4)) * f3);
                float sin = this.aVL - (((float) Math.sin(f4)) * f3);
                float cos2 = this.aVK + (((float) Math.cos(f4)) * f2);
                float sin2 = this.aVL - (((float) Math.sin(f4)) * f2);
                if (this.cFA) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.cFq);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cFq);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cFp);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void v(Canvas canvas) {
        if (this.cFA) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cFn, f, 360.0f - f, true, this.cFq);
        } else {
            canvas.drawArc(this.cFn, 0.0f, 360.0f, true, this.cFq);
        }
        canvas.drawArc(this.cFn, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.cFp);
    }

    private void w(Canvas canvas) {
        if (this.cFA) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cFn, f, 360.0f - f, false, this.cFq);
        } else {
            canvas.drawArc(this.cFn, 0.0f, 360.0f, false, this.cFq);
        }
        canvas.drawArc(this.cFn, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.cFp);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.aVK = i / 2.0f;
        this.aVL = i2 / 2.0f;
        this.mRadius = Math.min(this.aVK, this.aVL);
        this.cFn.top = this.aVL - this.mRadius;
        this.cFn.bottom = this.aVL + this.mRadius;
        this.cFn.left = this.aVK - this.mRadius;
        this.cFn.right = this.aVK + this.mRadius;
        asf();
        this.cFn.inset(this.cFu / 2.0f, this.cFu / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.cFB = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.cFu = f;
        this.cFn.inset(this.cFu / 2.0f, this.cFu / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.cFv = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.cFy = i;
        asf();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.cFz = i;
        asf();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.cFw = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.cFx = i;
        this.cFq.setColor(this.cFx);
        invalidate();
    }

    public void setLineCount(int i) {
        this.bHD = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.cFs = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.cFp.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cFq.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.cFC = i;
        asf();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.bFF = cap;
        this.cFp.setStrokeCap(cap);
        this.cFq.setStrokeCap(cap);
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
        return this.cFt;
    }

    public void setStartDegree(int i) {
        this.cFt = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.cFA = z;
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
