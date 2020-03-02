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
    private float aBJ;
    private float aBK;
    private Paint.Cap bhb;
    private int bjc;
    private final RectF cfX;
    private final Rect cfY;
    private final Paint cfZ;
    private final Paint cga;
    private final Paint cgb;
    private float cgc;
    private int cgd;
    private float cge;
    private float cgf;
    private int cgg;
    private int cgh;
    private int cgi;
    private int cgj;
    private boolean cgk;
    private b cgl;
    private int cgm;
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
        this.cfX = new RectF();
        this.cfY = new Rect();
        this.cfZ = new Paint(1);
        this.cga = new Paint(1);
        this.cgb = new TextPaint(1);
        this.bhb = Paint.Cap.ROUND;
        this.mMax = 100;
        this.bjc = 45;
        this.cgc = 4.0f;
        this.cgd = -90;
        this.cge = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.cgf = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.cgg = getResources().getColor(a.C0324a.aiapps_white);
        this.cgk = false;
        this.cgl = new a();
        this.cgm = 2;
        this.mStyle = 2;
        lQ();
    }

    private void lQ() {
        this.cgh = getResources().getColor(a.C0324a.aiapps_progress_background_color);
        this.cgi = getResources().getColor(a.C0324a.aiapps_progress_start_color);
        this.cgj = getResources().getColor(a.C0324a.aiapps_progress_end_color);
        this.cgb.setTextAlign(Paint.Align.CENTER);
        this.cgb.setTextSize(this.cgf);
        this.cfZ.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cfZ.setStrokeWidth(this.cge);
        this.cfZ.setColor(this.cgi);
        this.cfZ.setStrokeCap(this.bhb);
        this.cga.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cga.setStrokeWidth(this.cge);
        this.cga.setColor(this.cgh);
        this.cga.setStrokeCap(this.bhb);
    }

    private void ajV() {
        Shader shader = null;
        if (this.cgi != this.cgj) {
            switch (this.cgm) {
                case 0:
                    shader = new LinearGradient(this.cfX.left, this.cfX.top, this.cfX.left, this.cfX.bottom, this.cgi, this.cgj, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.aBJ, this.aBK);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.aBJ, this.aBK, this.mRadius, this.cgi, this.cgj, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.bhb == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.cge / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.aBJ, this.aBK, new int[]{this.cgi, this.cgj}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.aBJ, this.aBK);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.cfZ.setShader(shader);
            return;
        }
        this.cfZ.setShader(null);
        this.cfZ.setColor(this.cgi);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.cgd, this.aBJ, this.aBK);
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
        float f = (float) (6.283185307179586d / this.bjc);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.cgc;
        int i = (int) ((this.mProgress / this.mMax) * this.bjc);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bjc) {
                float f4 = i3 * (-f);
                float cos = this.aBJ + (((float) Math.cos(f4)) * f3);
                float sin = this.aBK - (((float) Math.sin(f4)) * f3);
                float cos2 = this.aBJ + (((float) Math.cos(f4)) * f2);
                float sin2 = this.aBK - (((float) Math.sin(f4)) * f2);
                if (this.cgk) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.cga);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cga);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cfZ);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void v(Canvas canvas) {
        if (this.cgk) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cfX, f, 360.0f - f, true, this.cga);
        } else {
            canvas.drawArc(this.cfX, 0.0f, 360.0f, true, this.cga);
        }
        canvas.drawArc(this.cfX, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.cfZ);
    }

    private void w(Canvas canvas) {
        if (this.cgk) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cfX, f, 360.0f - f, false, this.cga);
        } else {
            canvas.drawArc(this.cfX, 0.0f, 360.0f, false, this.cga);
        }
        canvas.drawArc(this.cfX, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.cfZ);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.aBJ = i / 2.0f;
        this.aBK = i2 / 2.0f;
        this.mRadius = Math.min(this.aBJ, this.aBK);
        this.cfX.top = this.aBK - this.mRadius;
        this.cfX.bottom = this.aBK + this.mRadius;
        this.cfX.left = this.aBJ - this.mRadius;
        this.cfX.right = this.aBJ + this.mRadius;
        ajV();
        this.cfX.inset(this.cge / 2.0f, this.cge / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.cgl = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.cge = f;
        this.cfX.inset(this.cge / 2.0f, this.cge / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.cgf = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.cgi = i;
        ajV();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.cgj = i;
        ajV();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.cgg = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.cgh = i;
        this.cga.setColor(this.cgh);
        invalidate();
    }

    public void setLineCount(int i) {
        this.bjc = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.cgc = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.cfZ.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cga.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.cgm = i;
        ajV();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.bhb = cap;
        this.cfZ.setStrokeCap(cap);
        this.cga.setStrokeCap(cap);
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
        return this.cgd;
    }

    public void setStartDegree(int i) {
        this.cgd = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.cgk = z;
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
