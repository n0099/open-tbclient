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
/* loaded from: classes20.dex */
public class LoadingProgressBar extends View {
    private Paint.Cap bZL;
    private float bok;
    private float bol;
    private int cbJ;
    private final RectF dhV;
    private final Rect dhW;
    private final Paint dhX;
    private final Paint dhY;
    private final Paint dhZ;
    private float dia;
    private int dib;
    private float dic;
    private float die;
    private int dif;
    private int dig;
    private int dih;
    private int dii;
    private boolean dij;
    private b dik;
    private int dil;
    private int mMax;
    private int mProgress;
    private float mRadius;
    private int mStyle;

    /* loaded from: classes20.dex */
    public interface b {
    }

    public LoadingProgressBar(Context context) {
        this(context, null);
    }

    public LoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhV = new RectF();
        this.dhW = new Rect();
        this.dhX = new Paint(1);
        this.dhY = new Paint(1);
        this.dhZ = new TextPaint(1);
        this.bZL = Paint.Cap.ROUND;
        this.mMax = 100;
        this.cbJ = 45;
        this.dia = 4.0f;
        this.dib = -90;
        this.dic = getResources().getDimension(a.b.aiapps_dimen_dp_2);
        this.die = getResources().getDimension(a.b.aiapps_dimen_dp_12);
        this.dif = getResources().getColor(a.C0473a.aiapps_white);
        this.dij = false;
        this.dik = new a();
        this.dil = 2;
        this.mStyle = 2;
        sr();
    }

    private void sr() {
        this.dig = getResources().getColor(a.C0473a.aiapps_progress_background_color);
        this.dih = getResources().getColor(a.C0473a.aiapps_progress_start_color);
        this.dii = getResources().getColor(a.C0473a.aiapps_progress_end_color);
        this.dhZ.setTextAlign(Paint.Align.CENTER);
        this.dhZ.setTextSize(this.die);
        this.dhX.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dhX.setStrokeWidth(this.dic);
        this.dhX.setColor(this.dih);
        this.dhX.setStrokeCap(this.bZL);
        this.dhY.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dhY.setStrokeWidth(this.dic);
        this.dhY.setColor(this.dig);
        this.dhY.setStrokeCap(this.bZL);
    }

    private void aHS() {
        Shader shader = null;
        if (this.dih != this.dii) {
            switch (this.dil) {
                case 0:
                    shader = new LinearGradient(this.dhV.left, this.dhV.top, this.dhV.left, this.dhV.bottom, this.dih, this.dii, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0f, this.bok, this.bol);
                    shader.setLocalMatrix(matrix);
                    break;
                case 1:
                    shader = new RadialGradient(this.bok, this.bol, this.mRadius, this.dih, this.dii, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    float f = (float) (-((this.bZL == Paint.Cap.BUTT && this.mStyle == 2) ? 0.0d : Math.toDegrees((float) (((this.dic / 3.141592653589793d) * 2.0d) / this.mRadius))));
                    shader = new SweepGradient(this.bok, this.bol, new int[]{this.dih, this.dii}, new float[]{0.0f, 1.0f});
                    Matrix matrix2 = new Matrix();
                    matrix2.setRotate(f, this.bok, this.bol);
                    shader.setLocalMatrix(matrix2);
                    break;
            }
            this.dhX.setShader(shader);
            return;
        }
        this.dhX.setShader(null);
        this.dhX.setColor(this.dih);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.dib, this.bok, this.bol);
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
        float f = (float) (6.283185307179586d / this.cbJ);
        float f2 = this.mRadius;
        float f3 = this.mRadius - this.dia;
        int i = (int) ((this.mProgress / this.mMax) * this.cbJ);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cbJ) {
                float f4 = i3 * (-f);
                float cos = this.bok + (((float) Math.cos(f4)) * f3);
                float sin = this.bol - (((float) Math.sin(f4)) * f3);
                float cos2 = this.bok + (((float) Math.cos(f4)) * f2);
                float sin2 = this.bol - (((float) Math.sin(f4)) * f2);
                if (this.dij) {
                    if (i3 >= i) {
                        canvas.drawLine(cos, sin, cos2, sin2, this.dhY);
                    }
                } else {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dhY);
                }
                if (i3 < i) {
                    canvas.drawLine(cos, sin, cos2, sin2, this.dhX);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void y(Canvas canvas) {
        if (this.dij) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dhV, f, 360.0f - f, true, this.dhY);
        } else {
            canvas.drawArc(this.dhV, 0.0f, 360.0f, true, this.dhY);
        }
        canvas.drawArc(this.dhV, 0.0f, (this.mProgress * 360.0f) / this.mMax, true, this.dhX);
    }

    private void z(Canvas canvas) {
        if (this.dij) {
            float f = (this.mProgress * 360.0f) / this.mMax;
            canvas.drawArc(this.dhV, f, 360.0f - f, false, this.dhY);
        } else {
            canvas.drawArc(this.dhV, 0.0f, 360.0f, false, this.dhY);
        }
        canvas.drawArc(this.dhV, 0.0f, (this.mProgress * 360.0f) / this.mMax, false, this.dhX);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bok = i / 2.0f;
        this.bol = i2 / 2.0f;
        this.mRadius = Math.min(this.bok, this.bol);
        this.dhV.top = this.bol - this.mRadius;
        this.dhV.bottom = this.bol + this.mRadius;
        this.dhV.left = this.bok - this.mRadius;
        this.dhV.right = this.bok + this.mRadius;
        aHS();
        this.dhV.inset(this.dic / 2.0f, this.dic / 2.0f);
    }

    public void setProgressFormatter(b bVar) {
        this.dik = bVar;
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.dic = f;
        this.dhV.inset(this.dic / 2.0f, this.dic / 2.0f);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.die = f;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.dih = i;
        aHS();
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.dii = i;
        aHS();
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.dif = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.dig = i;
        this.dhY.setColor(this.dig);
        invalidate();
    }

    public void setLineCount(int i) {
        this.cbJ = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.dia = f;
        invalidate();
    }

    public void setStyle(int i) {
        this.mStyle = i;
        this.dhX.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.dhY.setStyle(this.mStyle == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }

    public void setShader(int i) {
        this.dil = i;
        aHS();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.bZL = cap;
        this.dhX.setStrokeCap(cap);
        this.dhY.setStrokeCap(cap);
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
        return this.dib;
    }

    public void setStartDegree(int i) {
        this.dib = i;
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.dij = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
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
            /* renamed from: kG */
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

    /* loaded from: classes20.dex */
    private static final class a implements b {
        private a() {
        }
    }
}
