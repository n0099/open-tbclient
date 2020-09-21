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
    private Paint.Cap cbQ;
    private int cdQ;
    private final RectF dkc;
    private final Rect dkd;
    private final Paint dke;
    private final Paint dkf;
    private final Paint dkg;
    private float dkh;
    private int dki;
    private float dkj;
    private float dkk;
    private int dkl;
    private int dkm;
    private int dkn;
    private int dko;
    private boolean dkp;
    private b dkq;
    private int dkr;
    private float dks;
    private float dkt;
    private int mMax;
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
        this.dkc = new RectF();
        this.dkd = new Rect();
        this.dke = new Paint(1);
        this.dkf = new Paint(1);
        this.dkg = new TextPaint(1);
        this.cbQ = Paint.Cap.ROUND;
        this.mMax = 100;
        this.cdQ = 45;
        this.dkh = 4.0f;
        this.dki = -90;
        this.dkj = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.dkk = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.dkl = getResources().getColor(a.C0468a.aiapps_white);
        this.dkp = false;
        this.dkq = new a();
        this.dkr = 2;
        this.mStyle = 2;
        sw();
    }

    private void sw() {
        this.dkm = getResources().getColor(a.C0468a.aiapps_progress_background_color);
        this.dkn = getResources().getColor(a.C0468a.aiapps_progress_start_color);
        this.dko = getResources().getColor(a.C0468a.aiapps_progress_end_color);
        this.dkg.setTextAlign(Paint.Align.CENTER);
        this.dkg.setTextSize(this.dkk);
        this.dke.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dke.setStrokeWidth(this.dkj);
        this.dke.setColor(this.dkn);
        this.dke.setStrokeCap(this.cbQ);
        this.dkf.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dkf.setStrokeWidth(this.dkj);
        this.dkf.setColor(this.dkm);
        this.dkf.setStrokeCap(this.cbQ);
    }

    private void aIC() {
        Shader shader = null;
        if (this.dkn != this.dko) {
            switch (this.dkr) {
                case 0:
                    shader = new LinearGradient(this.dkc.left, this.dkc.top, this.dkc.left, this.dkc.bottom, this.dkn, this.dko, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.dks, this.dkt);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.dks, this.dkt, this.mRadius, this.dkn, this.dko, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.cbQ == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.dkj / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.dks, this.dkt, new int[]{this.dkn, this.dko}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.dks, this.dkt);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.dke.setShader(shader);
            return;
        }
        this.dke.setShader(null);
        this.dke.setColor(this.dkn);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.dki, this.dks, this.dkt);
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
        float f = (float) (6.283185307179586d / this.cdQ);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.dkh;
        int i = (int) ((this.mProgress / this.mMax) * this.cdQ);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cdQ) {
                float f4 = i3 * (-f);
                float cos = this.dks + (((float) Math.cos(f4)) * f3);
                float sin = this.dkt - (((float) Math.sin(f4)) * f3);
                float cos2 = this.dks + (((float) Math.cos(f4)) * f2);
                float sin2 = this.dkt - (((float) Math.sin(f4)) * f2);
                if (this.dkp) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.dkf);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dkf);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dke);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void y(Canvas canvas) {
        if (this.dkp) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dkc, f, 360.0f - f, true, this.dkf);
        } else {
            canvas.drawArc(this.dkc, 0.0f, 360.0f, true, this.dkf);
        }
        canvas.drawArc(this.dkc, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.dke);
    }

    private void z(Canvas canvas) {
        if (this.dkp) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dkc, f, 360.0f - f, false, this.dkf);
        } else {
            canvas.drawArc(this.dkc, 0.0f, 360.0f, false, this.dkf);
        }
        canvas.drawArc(this.dkc, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.dke);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dks = i / 2.0f;
        this.dkt = i2 / 2.0f;
        this.mRadius = Math.min(this.dks, this.dkt);
        this.dkc.top = this.dkt - this.mRadius;
        this.dkc.bottom = this.dkt + this.mRadius;
        this.dkc.left = this.dks - this.mRadius;
        this.dkc.right = this.dks + this.mRadius;
        aIC();
        this.dkc.inset(this.dkj / 2.0f, this.dkj / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.dkq = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.dkj = f;
        this.dkc.inset(this.dkj / 2.0f, this.dkj / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.dkk = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.dkn = i;
        aIC();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.dko = i;
        aIC();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.dkl = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.dkm = i;
        this.dkf.setColor(this.dkm);
        invalidate();
    }

    public void setLineCount(int i) {
        this.cdQ = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.dkh = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.dke.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dkf.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.dkr = i;
        aIC();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.cbQ = cap;
        this.dke.setStrokeCap(cap);
        this.dkf.setStrokeCap(cap);
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
        return this.dki;
    }

    public void setStartDegree(int i) {
        this.dki = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.dkp = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
            /* renamed from: kR */
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
