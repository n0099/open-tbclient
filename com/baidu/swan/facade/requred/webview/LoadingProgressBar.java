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
    private Paint.Cap bTl;
    private int bVj;
    private float bik;
    private float bil;
    private final RectF cUh;
    private final Rect cUi;
    private final Paint cUj;
    private final Paint cUk;
    private final Paint cUl;
    private float cUm;
    private int cUn;
    private float cUo;
    private float cUp;
    private int cUq;
    private int cUr;
    private int cUs;
    private int cUt;
    private boolean cUu;
    private b cUv;
    private int cUw;
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
        this.cUh = new RectF();
        this.cUi = new Rect();
        this.cUj = new Paint(1);
        this.cUk = new Paint(1);
        this.cUl = new TextPaint(1);
        this.bTl = Paint.Cap.ROUND;
        this.mMax = 100;
        this.bVj = 45;
        this.cUm = 4.0f;
        this.cUn = -90;
        this.cUo = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.cUp = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.cUq = getResources().getColor(a.C0421a.aiapps_white);
        this.cUu = false;
        this.cUv = new a();
        this.cUw = 2;
        this.mStyle = 2;
        qP();
    }

    private void qP() {
        this.cUr = getResources().getColor(a.C0421a.aiapps_progress_background_color);
        this.cUs = getResources().getColor(a.C0421a.aiapps_progress_start_color);
        this.cUt = getResources().getColor(a.C0421a.aiapps_progress_end_color);
        this.cUl.setTextAlign(Paint.Align.CENTER);
        this.cUl.setTextSize(this.cUp);
        this.cUj.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cUj.setStrokeWidth(this.cUo);
        this.cUj.setColor(this.cUs);
        this.cUj.setStrokeCap(this.bTl);
        this.cUk.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cUk.setStrokeWidth(this.cUo);
        this.cUk.setColor(this.cUr);
        this.cUk.setStrokeCap(this.bTl);
    }

    private void awU() {
        Shader shader = null;
        if (this.cUs != this.cUt) {
            switch (this.cUw) {
                case 0:
                    shader = new LinearGradient(this.cUh.left, this.cUh.top, this.cUh.left, this.cUh.bottom, this.cUs, this.cUt, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.bik, this.bil);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.bik, this.bil, this.mRadius, this.cUs, this.cUt, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.bTl == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.cUo / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.bik, this.bil, new int[]{this.cUs, this.cUt}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.bik, this.bil);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.cUj.setShader(shader);
            return;
        }
        this.cUj.setShader(null);
        this.cUj.setColor(this.cUs);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.cUn, this.bik, this.bil);
        u(canvas);
        canvas.restore();
    }

    private void u(Canvas canvas) {
        switch (this.mStyle) {
            case 1:
                w(canvas);
                return;
            case 2:
                x(canvas);
                return;
            default:
                v(canvas);
                return;
        }
    }

    private void v(Canvas canvas) {
        float f = (float) (6.283185307179586d / this.bVj);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.cUm;
        int i = (int) ((this.mProgress / this.mMax) * this.bVj);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bVj) {
                float f4 = i3 * (-f);
                float cos = this.bik + (((float) Math.cos(f4)) * f3);
                float sin = this.bil - (((float) Math.sin(f4)) * f3);
                float cos2 = this.bik + (((float) Math.cos(f4)) * f2);
                float sin2 = this.bil - (((float) Math.sin(f4)) * f2);
                if (this.cUu) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.cUk);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cUk);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.cUj);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void w(Canvas canvas) {
        if (this.cUu) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cUh, f, 360.0f - f, true, this.cUk);
        } else {
            canvas.drawArc(this.cUh, 0.0f, 360.0f, true, this.cUk);
        }
        canvas.drawArc(this.cUh, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.cUj);
    }

    private void x(Canvas canvas) {
        if (this.cUu) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.cUh, f, 360.0f - f, false, this.cUk);
        } else {
            canvas.drawArc(this.cUh, 0.0f, 360.0f, false, this.cUk);
        }
        canvas.drawArc(this.cUh, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.cUj);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bik = i / 2.0f;
        this.bil = i2 / 2.0f;
        this.mRadius = Math.min(this.bik, this.bil);
        this.cUh.top = this.bil - this.mRadius;
        this.cUh.bottom = this.bil + this.mRadius;
        this.cUh.left = this.bik - this.mRadius;
        this.cUh.right = this.bik + this.mRadius;
        awU();
        this.cUh.inset(this.cUo / 2.0f, this.cUo / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.cUv = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.cUo = f;
        this.cUh.inset(this.cUo / 2.0f, this.cUo / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.cUp = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.cUs = i;
        awU();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.cUt = i;
        awU();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.cUq = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.cUr = i;
        this.cUk.setColor(this.cUr);
        invalidate();
    }

    public void setLineCount(int i) {
        this.bVj = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.cUm = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.cUj.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.cUk.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.cUw = i;
        awU();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.bTl = cap;
        this.cUj.setStrokeCap(cap);
        this.cUk.setStrokeCap(cap);
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
        return this.cUn;
    }

    public void setStartDegree(int i) {
        this.cUn = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.cUu = z;
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
            /* renamed from: il */
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
