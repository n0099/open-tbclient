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
    private float aBY;
    private float aBZ;
    private Paint.Cap bhp;
    private int bjq;
    private final RectF cgj;
    private final Rect cgk;
    private final Paint cgl;
    private final Paint cgm;
    private final Paint cgn;
    private float cgo;
    private int cgp;
    private float cgq;
    private float cgr;
    private int cgs;
    private int cgt;
    private int cgu;
    private int cgv;
    private boolean cgw;
    private b cgx;
    private int cgy;
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
        this.cgj = new RectF();
        this.cgk = new Rect();
        this.cgl = new Paint(1);
        this.cgm = new Paint(1);
        this.cgn = new TextPaint(1);
        this.bhp = Paint.Cap.ROUND;
        this.mMax = 100;
        this.bjq = 45;
        this.cgo = 4.0f;
        this.cgp = -90;
        this.cgq = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.cgr = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.cgs = getResources().getColor(a.C0324a.aiapps_white);
        this.cgw = false;
        this.cgx = new a();
        this.cgy = 2;
        this.mStyle = 2;
        lQ();
    }

    private void lQ() {
        this.cgt = getResources().getColor(a.C0324a.aiapps_progress_background_color);
        this.cgu = getResources().getColor(a.C0324a.aiapps_progress_start_color);
        this.cgv = getResources().getColor(a.C0324a.aiapps_progress_end_color);
        this.cgn.setTextAlign(Paint.Align.CENTER);
        this.cgn.setTextSize(this.cgr);
        this.cgl.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cgl.setStrokeWidth(this.cgq);
        this.cgl.setColor(this.cgu);
        this.cgl.setStrokeCap(this.bhp);
        this.cgm.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cgm.setStrokeWidth(this.cgq);
        this.cgm.setColor(this.cgt);
        this.cgm.setStrokeCap(this.bhp);
    }

    private void ajY() {
        Shader shader = null;
        if (this.cgu != this.cgv) {
            switch (this.cgy) {
                case 0:
                    shader = new LinearGradient(this.cgj.left, this.cgj.top, this.cgj.left, this.cgj.bottom, this.cgu, this.cgv, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.aBY, this.aBZ);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.aBY, this.aBZ, this.mRadius, this.cgu, this.cgv, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.bhp == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.cgq / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.aBY, this.aBZ, new int[]{this.cgu, this.cgv}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.aBY, this.aBZ);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.cgl.setShader(shader);
            return;
        }
        this.cgl.setShader(null);
        this.cgl.setColor(this.cgu);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.cgp, this.aBY, this.aBZ);
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
        float f = (float) (6.283185307179586d / this.bjq);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.cgo;
        int i = (int) ((this.mProgress / this.mMax) * this.bjq);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bjq) {
                float f4 = i3 * (-f);
                float cos = this.aBY + (((float) Math.cos(f4)) * f3);
                float sin = this.aBZ - (((float) Math.sin(f4)) * f3);
                float cos2 = this.aBY + (((float) Math.cos(f4)) * f2);
                float sin2 = this.aBZ - (((float) Math.sin(f4)) * f2);
                if (this.cgw) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.cgm);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cgm);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cgl);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void v(Canvas canvas) {
        if (this.cgw) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cgj, f, 360.0f - f, true, this.cgm);
        } else {
            canvas.drawArc(this.cgj, 0.0f, 360.0f, true, this.cgm);
        }
        canvas.drawArc(this.cgj, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.cgl);
    }

    private void w(Canvas canvas) {
        if (this.cgw) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cgj, f, 360.0f - f, false, this.cgm);
        } else {
            canvas.drawArc(this.cgj, 0.0f, 360.0f, false, this.cgm);
        }
        canvas.drawArc(this.cgj, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.cgl);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.aBY = i / 2.0f;
        this.aBZ = i2 / 2.0f;
        this.mRadius = Math.min(this.aBY, this.aBZ);
        this.cgj.top = this.aBZ - this.mRadius;
        this.cgj.bottom = this.aBZ + this.mRadius;
        this.cgj.left = this.aBY - this.mRadius;
        this.cgj.right = this.aBY + this.mRadius;
        ajY();
        this.cgj.inset(this.cgq / 2.0f, this.cgq / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.cgx = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.cgq = f;
        this.cgj.inset(this.cgq / 2.0f, this.cgq / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.cgr = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.cgu = i;
        ajY();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.cgv = i;
        ajY();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.cgs = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.cgt = i;
        this.cgm.setColor(this.cgt);
        invalidate();
    }

    public void setLineCount(int i) {
        this.bjq = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.cgo = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.cgl.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cgm.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.cgy = i;
        ajY();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.bhp = cap;
        this.cgl.setStrokeCap(cap);
        this.cgm.setStrokeCap(cap);
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
        return this.cgp;
    }

    public void setStartDegree(int i) {
        this.cgp = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.cgw = z;
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
