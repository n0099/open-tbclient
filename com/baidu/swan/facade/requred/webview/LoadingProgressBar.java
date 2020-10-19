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
/* loaded from: classes16.dex */
public class LoadingProgressBar extends View {
    private Paint.Cap cog;
    private int cqg;
    private final RectF dwi;
    private final Rect dwj;
    private final Paint dwk;
    private final Paint dwl;
    private final Paint dwm;
    private float dwn;
    private int dwo;
    private float dwp;
    private float dwq;
    private int dwr;
    private int dws;
    private int dwt;
    private int dwu;
    private boolean dwv;
    private b dww;
    private int dwx;
    private float dwy;
    private float dwz;
    private int mMax;
    private int mProgress;
    private float mRadius;
    private int mStyle;

    /* loaded from: classes16.dex */
    public interface b {
    }

    public LoadingProgressBar(Context context) {
        this(context, null);
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dwi = new RectF();
        this.dwj = new Rect();
        this.dwk = new Paint(1);
        this.dwl = new Paint(1);
        this.dwm = new TextPaint(1);
        this.cog = Paint.Cap.ROUND;
        this.mMax = 100;
        this.cqg = 45;
        this.dwn = 4.0f;
        this.dwo = -90;
        this.dwp = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.dwq = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.dwr = getResources().getColor(a.C0485a.aiapps_white);
        this.dwv = false;
        this.dww = new a();
        this.dwx = 2;
        this.mStyle = 2;
        sw();
    }

    private void sw() {
        this.dws = getResources().getColor(a.C0485a.aiapps_progress_background_color);
        this.dwt = getResources().getColor(a.C0485a.aiapps_progress_start_color);
        this.dwu = getResources().getColor(a.C0485a.aiapps_progress_end_color);
        this.dwm.setTextAlign(Paint.Align.CENTER);
        this.dwm.setTextSize(this.dwq);
        this.dwk.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dwk.setStrokeWidth(this.dwp);
        this.dwk.setColor(this.dwt);
        this.dwk.setStrokeCap(this.cog);
        this.dwl.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dwl.setStrokeWidth(this.dwp);
        this.dwl.setColor(this.dws);
        this.dwl.setStrokeCap(this.cog);
    }

    private void aLl() {
        Shader shader = null;
        if (this.dwt != this.dwu) {
            switch (this.dwx) {
                case 0:
                    shader = new LinearGradient(this.dwi.left, this.dwi.top, this.dwi.left, this.dwi.bottom, this.dwt, this.dwu, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.dwy, this.dwz);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.dwy, this.dwz, this.mRadius, this.dwt, this.dwu, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.cog == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.dwp / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.dwy, this.dwz, new int[]{this.dwt, this.dwu}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.dwy, this.dwz);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.dwk.setShader(shader);
            return;
        }
        this.dwk.setShader(null);
        this.dwk.setColor(this.dwt);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.dwo, this.dwy, this.dwz);
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
        float f = (float) (6.283185307179586d / this.cqg);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.dwn;
        int i = (int) ((this.mProgress / this.mMax) * this.cqg);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cqg) {
                float f4 = i3 * (-f);
                float cos = this.dwy + (((float) Math.cos(f4)) * f3);
                float sin = this.dwz - (((float) Math.sin(f4)) * f3);
                float cos2 = this.dwy + (((float) Math.cos(f4)) * f2);
                float sin2 = this.dwz - (((float) Math.sin(f4)) * f2);
                if (this.dwv) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.dwl);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dwl);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dwk);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void y(Canvas canvas) {
        if (this.dwv) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dwi, f, 360.0f - f, true, this.dwl);
        } else {
            canvas.drawArc(this.dwi, 0.0f, 360.0f, true, this.dwl);
        }
        canvas.drawArc(this.dwi, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.dwk);
    }

    private void z(Canvas canvas) {
        if (this.dwv) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dwi, f, 360.0f - f, false, this.dwl);
        } else {
            canvas.drawArc(this.dwi, 0.0f, 360.0f, false, this.dwl);
        }
        canvas.drawArc(this.dwi, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.dwk);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dwy = i / 2.0f;
        this.dwz = i2 / 2.0f;
        this.mRadius = Math.min(this.dwy, this.dwz);
        this.dwi.top = this.dwz - this.mRadius;
        this.dwi.bottom = this.dwz + this.mRadius;
        this.dwi.left = this.dwy - this.mRadius;
        this.dwi.right = this.dwy + this.mRadius;
        aLl();
        this.dwi.inset(this.dwp / 2.0f, this.dwp / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.dww = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.dwp = f;
        this.dwi.inset(this.dwp / 2.0f, this.dwp / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.dwq = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.dwt = i;
        aLl();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.dwu = i;
        aLl();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.dwr = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.dws = i;
        this.dwl.setColor(this.dws);
        invalidate();
    }

    public void setLineCount(int i) {
        this.cqg = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.dwn = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.dwk.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dwl.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.dwx = i;
        aLl();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.cog = cap;
        this.dwk.setStrokeCap(cap);
        this.dwl.setStrokeCap(cap);
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
        return this.dwo;
    }

    public void setStartDegree(int i) {
        this.dwo = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.dwv = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
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
            /* renamed from: lo */
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

    /* loaded from: classes16.dex */
    private static final class a implements b {
        private a() {
        }
    }
}
