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
    private float aBK;
    private float aBL;
    private Paint.Cap bhc;
    private int bjd;
    private final RectF cfY;
    private final Rect cfZ;
    private final Paint cga;
    private final Paint cgb;
    private final Paint cgc;
    private float cgd;
    private int cge;
    private float cgf;
    private float cgg;
    private int cgh;
    private int cgi;
    private int cgj;
    private int cgk;
    private boolean cgl;
    private b cgm;
    private int cgn;
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
        this.cfY = new RectF();
        this.cfZ = new Rect();
        this.cga = new Paint(1);
        this.cgb = new Paint(1);
        this.cgc = new TextPaint(1);
        this.bhc = Paint.Cap.ROUND;
        this.mMax = 100;
        this.bjd = 45;
        this.cgd = 4.0f;
        this.cge = -90;
        this.cgf = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.cgg = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.cgh = getResources().getColor(a.C0324a.aiapps_white);
        this.cgl = false;
        this.cgm = new a();
        this.cgn = 2;
        this.mStyle = 2;
        lQ();
    }

    private void lQ() {
        this.cgi = getResources().getColor(a.C0324a.aiapps_progress_background_color);
        this.cgj = getResources().getColor(a.C0324a.aiapps_progress_start_color);
        this.cgk = getResources().getColor(a.C0324a.aiapps_progress_end_color);
        this.cgc.setTextAlign(Paint.Align.CENTER);
        this.cgc.setTextSize(this.cgg);
        this.cga.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cga.setStrokeWidth(this.cgf);
        this.cga.setColor(this.cgj);
        this.cga.setStrokeCap(this.bhc);
        this.cgb.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cgb.setStrokeWidth(this.cgf);
        this.cgb.setColor(this.cgi);
        this.cgb.setStrokeCap(this.bhc);
    }

    private void ajV() {
        Shader shader = null;
        if (this.cgj != this.cgk) {
            switch (this.cgn) {
                case 0:
                    shader = new LinearGradient(this.cfY.left, this.cfY.top, this.cfY.left, this.cfY.bottom, this.cgj, this.cgk, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.aBK, this.aBL);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.aBK, this.aBL, this.mRadius, this.cgj, this.cgk, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.bhc == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.cgf / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.aBK, this.aBL, new int[]{this.cgj, this.cgk}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.aBK, this.aBL);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.cga.setShader(shader);
            return;
        }
        this.cga.setShader(null);
        this.cga.setColor(this.cgj);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.cge, this.aBK, this.aBL);
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
        float f = (float) (6.283185307179586d / this.bjd);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.cgd;
        int i = (int) ((this.mProgress / this.mMax) * this.bjd);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bjd) {
                float f4 = i3 * (-f);
                float cos = this.aBK + (((float) Math.cos(f4)) * f3);
                float sin = this.aBL - (((float) Math.sin(f4)) * f3);
                float cos2 = this.aBK + (((float) Math.cos(f4)) * f2);
                float sin2 = this.aBL - (((float) Math.sin(f4)) * f2);
                if (this.cgl) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.cgb);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cgb);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cga);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void v(Canvas canvas) {
        if (this.cgl) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cfY, f, 360.0f - f, true, this.cgb);
        } else {
            canvas.drawArc(this.cfY, 0.0f, 360.0f, true, this.cgb);
        }
        canvas.drawArc(this.cfY, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.cga);
    }

    private void w(Canvas canvas) {
        if (this.cgl) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cfY, f, 360.0f - f, false, this.cgb);
        } else {
            canvas.drawArc(this.cfY, 0.0f, 360.0f, false, this.cgb);
        }
        canvas.drawArc(this.cfY, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.cga);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.aBK = i / 2.0f;
        this.aBL = i2 / 2.0f;
        this.mRadius = Math.min(this.aBK, this.aBL);
        this.cfY.top = this.aBL - this.mRadius;
        this.cfY.bottom = this.aBL + this.mRadius;
        this.cfY.left = this.aBK - this.mRadius;
        this.cfY.right = this.aBK + this.mRadius;
        ajV();
        this.cfY.inset(this.cgf / 2.0f, this.cgf / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.cgm = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.cgf = f;
        this.cfY.inset(this.cgf / 2.0f, this.cgf / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.cgg = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.cgj = i;
        ajV();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.cgk = i;
        ajV();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.cgh = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.cgi = i;
        this.cgb.setColor(this.cgi);
        invalidate();
    }

    public void setLineCount(int i) {
        this.bjd = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.cgd = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.cga.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cgb.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.cgn = i;
        ajV();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.bhc = cap;
        this.cga.setStrokeCap(cap);
        this.cgb.setStrokeCap(cap);
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
        return this.cge;
    }

    public void setStartDegree(int i) {
        this.cge = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.cgl = z;
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
