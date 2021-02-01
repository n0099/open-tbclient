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
/* loaded from: classes3.dex */
public class LoadingProgressBar extends View {
    private Paint.Cap cKk;
    private int cMi;
    private final RectF dWd;
    private final Rect dWe;
    private final Paint dWf;
    private final Paint dWg;
    private final Paint dWh;
    private int dWi;
    private float dWj;
    private int dWk;
    private float dWl;
    private float dWm;
    private int dWn;
    private int dWo;
    private int dWp;
    private int dWq;
    private boolean dWr;
    private b dWs;
    private int dWt;
    private float dWu;
    private float dWv;
    private int mProgress;
    private float mRadius;
    private int mStyle;

    /* loaded from: classes3.dex */
    public interface b {
    }

    public LoadingProgressBar(Context context) {
        this(context, null);
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dWd = new RectF();
        this.dWe = new Rect();
        this.dWf = new Paint(1);
        this.dWg = new Paint(1);
        this.dWh = new TextPaint(1);
        this.cKk = Paint.Cap.ROUND;
        this.dWi = 100;
        this.cMi = 45;
        this.dWj = 4.0f;
        this.dWk = -90;
        this.dWl = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.dWm = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.dWn = getResources().getColor(a.C0494a.aiapps_white);
        this.dWr = false;
        this.dWs = new a();
        this.dWt = 2;
        this.mStyle = 2;
        rX();
    }

    private void rX() {
        this.dWo = getResources().getColor(a.C0494a.aiapps_progress_background_color);
        this.dWp = getResources().getColor(a.C0494a.aiapps_progress_start_color);
        this.dWq = getResources().getColor(a.C0494a.aiapps_progress_end_color);
        this.dWh.setTextAlign(Paint.Align.CENTER);
        this.dWh.setTextSize(this.dWm);
        this.dWf.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dWf.setStrokeWidth(this.dWl);
        this.dWf.setColor(this.dWp);
        this.dWf.setStrokeCap(this.cKk);
        this.dWg.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dWg.setStrokeWidth(this.dWl);
        this.dWg.setColor(this.dWo);
        this.dWg.setStrokeCap(this.cKk);
    }

    private void aQW() {
        Shader shader = null;
        if (this.dWp != this.dWq) {
            switch (this.dWt) {
                case 0:
                    shader = new LinearGradient(this.dWd.left, this.dWd.top, this.dWd.left, this.dWd.bottom, this.dWp, this.dWq, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.dWu, this.dWv);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.dWu, this.dWv, this.mRadius, this.dWp, this.dWq, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.cKk == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.dWl / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.dWu, this.dWv, new int[]{this.dWp, this.dWq}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.dWu, this.dWv);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.dWf.setShader(shader);
            return;
        }
        this.dWf.setShader(null);
        this.dWf.setColor(this.dWp);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.dWk, this.dWu, this.dWv);
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
        float f = (float) (6.283185307179586d / this.cMi);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.dWj;
        int i = (int) ((this.mProgress / this.dWi) * this.cMi);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cMi) {
                float f4 = i3 * (-f);
                float cos = this.dWu + (((float) Math.cos(f4)) * f3);
                float sin = this.dWv - (((float) Math.sin(f4)) * f3);
                float cos2 = this.dWu + (((float) Math.cos(f4)) * f2);
                float sin2 = this.dWv - (((float) Math.sin(f4)) * f2);
                if (this.dWr) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.dWg);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dWg);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dWf);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void F(Canvas canvas) {
        if (this.dWr) {
            float f = (this.mProgress * 360.0f) / this.dWi;
            canvas.drawArc(this.dWd, f, 360.0f - f, true, this.dWg);
        } else {
            canvas.drawArc(this.dWd, 0.0f, 360.0f, true, this.dWg);
        }
        canvas.drawArc(this.dWd, 0.0f, (this.mProgress * 360.0f) / this.dWi, true, this.dWf);
    }

    private void G(Canvas canvas) {
        if (this.dWr) {
            float f = (this.mProgress * 360.0f) / this.dWi;
            canvas.drawArc(this.dWd, f, 360.0f - f, false, this.dWg);
        } else {
            canvas.drawArc(this.dWd, 0.0f, 360.0f, false, this.dWg);
        }
        canvas.drawArc(this.dWd, 0.0f, (this.mProgress * 360.0f) / this.dWi, false, this.dWf);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dWu = i / 2.0f;
        this.dWv = i2 / 2.0f;
        this.mRadius = Math.min(this.dWu, this.dWv);
        this.dWd.top = this.dWv - this.mRadius;
        this.dWd.bottom = this.dWv + this.mRadius;
        this.dWd.left = this.dWu - this.mRadius;
        this.dWd.right = this.dWu + this.mRadius;
        aQW();
        this.dWd.inset(this.dWl / 2.0f, this.dWl / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.dWs = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.dWl = f;
        this.dWd.inset(this.dWl / 2.0f, this.dWl / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.dWm = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.dWp = i;
        aQW();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.dWq = i;
        aQW();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.dWn = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.dWo = i;
        this.dWg.setColor(this.dWo);
        invalidate();
    }

    public void setLineCount(int i) {
        this.cMi = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.dWj = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.dWf.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dWg.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.dWt = i;
        aQW();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.cKk = cap;
        this.dWf.setStrokeCap(cap);
        this.dWg.setStrokeCap(cap);
        invalidate();
    }

    public void setProgress(int i) {
        this.mProgress = i;
        invalidate();
    }

    public void setMax(int i) {
        this.dWi = i;
        invalidate();
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getMax() {
        return this.dWi;
    }

    public int getStartDegree() {
        return this.dWk;
    }

    public void setStartDegree(int i) {
        this.dWk = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.dWr = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
            /* renamed from: kI */
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

    /* loaded from: classes3.dex */
    private static final class a implements b {
        private a() {
        }
    }
}
