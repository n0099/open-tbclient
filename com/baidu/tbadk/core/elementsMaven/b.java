package com.baidu.tbadk.core.elementsMaven;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes.dex */
public class b extends Drawable implements Cloneable {
    private LinearGradient bHm;
    private Paint bew;
    private int cIc;
    private int cId;
    private int dvd;
    private Paint mBorderPaint;
    private RectF mBorderRect;
    private RectF mRect;
    private int mShadowRadius;
    private View mView;
    private int eTO = 0;
    private float mAlpha = 1.0f;
    private int mBorderColor = 0;
    private float mBorderWidth = 0.0f;
    private int eTP = 1;
    private float[] eTQ = new float[8];
    private float[] eTR = new float[8];
    private int[] eTS = {0};
    private float[] eTT = {0.0f, 1.0f};
    private float[] eTU = {0.0f, 1.0f};
    private String eTV = "bottom";
    private Path mPath = new Path();
    private Path eTW = new Path();
    private Path eTX = new Path();
    private View.OnLayoutChangeListener eTY = new View.OnLayoutChangeListener() { // from class: com.baidu.tbadk.core.elementsMaven.b.1
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(final View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (view.getBackground() instanceof b) {
                b bVar = (b) view.getBackground();
                b.this.mShadowRadius = bVar.mShadowRadius;
                b.this.cIc = bVar.cIc;
                b.this.cId = bVar.cId;
                b.this.eTR = bVar.eTR;
            }
            float[] bqD = b.this.bqD();
            if (b.this.eTP == 1) {
                bqD[0] = (b.this.eTZ & 1) == 1 ? bqD[0] : 0.0f;
                bqD[1] = (b.this.eTZ & 16) == 16 ? bqD[1] : 0.0f;
                bqD[2] = (b.this.eTZ & 256) == 256 ? bqD[2] : 0.0f;
                bqD[3] = (b.this.eTZ & 4096) == 4096 ? bqD[3] : 0.0f;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin -= (int) bqD[0];
                marginLayoutParams.topMargin -= (int) bqD[1];
                marginLayoutParams.rightMargin -= (int) bqD[2];
                marginLayoutParams.bottomMargin -= (int) bqD[3];
                marginLayoutParams.width = (i3 - i) + ((int) bqD[0]) + ((int) bqD[2]);
                marginLayoutParams.height = ((int) bqD[3]) + (i4 - i2) + ((int) bqD[1]);
                view.post(new Runnable() { // from class: com.baidu.tbadk.core.elementsMaven.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setLayoutParams(marginLayoutParams);
                    }
                });
            }
            view.removeOnLayoutChangeListener(this);
        }
    };
    private int eTZ = 4369;
    private Paint mShadowPaint = new Paint();

    private b() {
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cIc, this.cId, this.dvd);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.bew = new Paint();
        this.bew.setAntiAlias(true);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
    }

    public static b bqA() {
        return new b();
    }

    public b nM(int i) {
        if (this.eTP != i) {
            this.eTP = i;
        }
        return this;
    }

    public b nN(int i) {
        if (this.eTZ != i) {
            this.eTZ = i;
        }
        return this;
    }

    private void bqB() {
        System.arraycopy(this.eTQ, 0, this.eTR, 0, Math.min(this.eTR.length, 8));
        switch (this.eTO) {
            case 1:
                for (int i = 4; i < 8; i++) {
                    this.eTR[i] = 0.0f;
                }
                return;
            case 2:
                break;
            default:
                return;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.eTR[i2] = 0.0f;
        }
    }

    public b nO(int i) {
        if (this.eTO != i) {
            this.eTO = i;
            bqB();
        }
        return this;
    }

    public b x(float[] fArr) {
        if (!Arrays.equals(this.eTQ, fArr)) {
            System.arraycopy(fArr, 0, this.eTQ, 0, Math.min(fArr.length, 8));
            bqB();
        }
        return this;
    }

    public b nP(int i) {
        if (this.dvd != i) {
            this.dvd = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cIc, this.cId, this.dvd);
        }
        return this;
    }

    public b nQ(int i) {
        if (this.mShadowRadius != i) {
            this.mShadowRadius = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cIc, this.cId, this.dvd);
        }
        return this;
    }

    public b nR(int i) {
        if (this.cIc != i) {
            this.cIc = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cIc, this.cId, this.dvd);
        }
        return this;
    }

    public b nS(int i) {
        if (this.cIc != i) {
            this.cId = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cIc, this.cId, this.dvd);
        }
        return this;
    }

    public b nT(int i) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
        }
        return this;
    }

    public b ac(float f) {
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
        }
        return this;
    }

    public b nU(int i) {
        if (this.eTS.length != 1 || this.eTS[0] != i) {
            this.eTS = new int[1];
            this.eTS[0] = i;
        }
        return this;
    }

    public b k(int[] iArr) {
        if (!Arrays.equals(this.eTS, iArr)) {
            this.eTS = iArr;
        }
        return this;
    }

    public b y(float[] fArr) {
        if (!Arrays.equals(this.eTT, fArr)) {
            this.eTT = fArr;
        }
        return this;
    }

    public b Al(String str) {
        if (!this.eTV.equals(str)) {
            this.eTV = str;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int length = this.eTR.length;
        for (int i = 0; i < length; i++) {
            if (this.eTR[i] > 0.0f && this.eTR[i] < 1.0f) {
                this.eTR[i] = this.eTR[i] * rect.height();
            }
        }
        float[] bqD = bqD();
        this.mRect = new RectF(rect.left + bqD[0], rect.top + bqD[1], rect.right - bqD[2], rect.bottom - bqD[3]);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, this.eTR, Path.Direction.CW);
        this.eTU = (float[]) this.eTT.clone();
        float[] fArr = (float[]) this.eTR.clone();
        if (this.eTS != null && this.eTS.length > 1 && bqC()) {
            d(fArr, this.eTU);
        }
        this.eTW.reset();
        this.eTW.addRoundRect(this.mRect, fArr, Path.Direction.CW);
        float f = 0.5f * this.mBorderWidth;
        float[] fArr2 = (float[]) this.eTR.clone();
        for (int i2 = 0; i2 < fArr2.length; i2++) {
            fArr2[i2] = fArr2[i2] - this.mBorderWidth;
            if (fArr2[i2] < 0.0f) {
                fArr2[i2] = 0.0f;
            }
        }
        this.mBorderRect = new RectF(this.mRect.left + f, this.mRect.top + f, this.mRect.right - f, this.mRect.bottom - f);
        this.eTX.reset();
        this.eTX.addRoundRect(this.mBorderRect, fArr2, Path.Direction.CW);
    }

    private PointF a(RectF rectF, String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals("bottom")) {
                    c = 1;
                    break;
                }
                break;
            case 115029:
                if (str.equals(VerticalTranslateLayout.TOP)) {
                    c = 0;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c = 3;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(HorizontalTranslateLayout.DIRECTION_RIGHT)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new PointF(rectF.width() / 2.0f, rectF.top);
            case 1:
                return new PointF(rectF.width() / 2.0f, rectF.bottom);
            case 2:
                return new PointF(rectF.right, rectF.height() / 2.0f);
            case 3:
                return new PointF(rectF.left, rectF.height() / 2.0f);
            default:
                return new PointF();
        }
    }

    private PointF b(RectF rectF, String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals("bottom")) {
                    c = 1;
                    break;
                }
                break;
            case 115029:
                if (str.equals(VerticalTranslateLayout.TOP)) {
                    c = 0;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c = 3;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(HorizontalTranslateLayout.DIRECTION_RIGHT)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new PointF(rectF.width() / 2.0f, rectF.bottom);
            case 1:
                return new PointF(rectF.width() / 2.0f, rectF.top);
            case 2:
                return new PointF(rectF.left, rectF.height() / 2.0f);
            case 3:
                return new PointF(rectF.right, rectF.height() / 2.0f);
            default:
                return new PointF();
        }
    }

    private boolean bqC() {
        if (this.eTT == null || this.eTT.length < 1) {
            return false;
        }
        return this.eTT[this.eTT.length + (-1)] < 1.0f;
    }

    private void d(float[] fArr, float[] fArr2) {
        String str = this.eTV;
        char c = 65535;
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals("bottom")) {
                    c = 1;
                    break;
                }
                break;
            case 115029:
                if (str.equals(VerticalTranslateLayout.TOP)) {
                    c = 0;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c = 3;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(HorizontalTranslateLayout.DIRECTION_RIGHT)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.mRect.bottom = this.mRect.top + (this.mRect.height() * this.eTT[this.eTT.length - 1]);
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
                break;
            case 1:
                this.mRect.top = this.mRect.bottom - (this.mRect.height() * this.eTT[this.eTT.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                break;
            case 2:
                this.mRect.left = this.mRect.right - (this.mRect.width() * this.eTT[this.eTT.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
                break;
            case 3:
                this.mRect.right = this.mRect.left + (this.mRect.width() * this.eTT[this.eTT.length - 1]);
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                break;
        }
        fArr2[fArr2.length - 1] = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] bqD() {
        float[] fArr = new float[4];
        if (this.eTP == 1) {
            fArr[0] = (this.eTZ & 1) == 1 ? this.mShadowRadius - this.cIc : -this.eTR[0];
            fArr[1] = (this.eTZ & 16) == 16 ? this.mShadowRadius - this.cId : -this.eTR[2];
            fArr[2] = (this.eTZ & 256) == 256 ? this.mShadowRadius + this.cIc : -this.eTR[4];
            fArr[3] = (this.eTZ & 4096) == 4096 ? this.mShadowRadius + this.cId : -this.eTR[6];
        } else if (this.eTP == 2) {
            Arrays.fill(fArr, this.mShadowRadius);
        }
        return fArr;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int[] bqE = bqE();
        if (bqE != null) {
            if (bqE.length == 1) {
                this.bew.setColor(bqE[0]);
            } else {
                PointF a2 = a(this.mRect, this.eTV);
                PointF b2 = b(this.mRect, this.eTV);
                this.bHm = new LinearGradient(a2.x, a2.y, b2.x, b2.y, bqE, this.eTU, Shader.TileMode.CLAMP);
                this.bew.setShader(this.bHm);
            }
        }
        this.mBorderPaint.setColor(com.baidu.tieba.tbadkCore.c.m(this.mBorderColor, this.mAlpha));
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        if (this.eTP == 1) {
            drawShadow(canvas);
            canvas.drawPath(this.eTW, this.bew);
            K(canvas);
        } else if (this.eTP == 2) {
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.bew);
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), (Math.min(this.mRect.width(), this.mRect.height()) / 2.0f) - (this.mBorderWidth * 0.5f), this.mBorderPaint);
        } else {
            canvas.drawRect(this.mRect, this.bew);
        }
    }

    public b ad(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.mAlpha != f) {
            this.mAlpha = f;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.mShadowPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mShadowPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void drawShadow(Canvas canvas) {
        if (this.mShadowRadius != 0 || this.cIc != 0 || this.cId != 0) {
            canvas.drawPath(this.mPath, this.mShadowPaint);
        }
    }

    public void K(Canvas canvas) {
        if (this.mBorderWidth != 0.0f && this.mBorderColor != 0) {
            canvas.drawPath(this.eTX, this.mBorderPaint);
        }
    }

    public b bu(View view) {
        if (view == null) {
            return null;
        }
        this.mView = view;
        if (equals(this.mView.getBackground())) {
            return null;
        }
        this.mView.removeOnLayoutChangeListener(this.eTY);
        this.mView.addOnLayoutChangeListener(this.eTY);
        return this;
    }

    public void release() {
        if (this.mView != null) {
            this.mView.removeOnLayoutChangeListener(this.eTY);
            this.mView.setLayerType(0, null);
            this.mView = null;
        }
    }

    private int[] bqE() {
        if (this.eTS == null) {
            return this.eTS;
        }
        int length = this.eTS.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = com.baidu.tieba.tbadkCore.c.m(this.eTS[i], this.mAlpha);
        }
        return iArr;
    }

    public Object clone() {
        b bVar;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            bVar = null;
        }
        return bVar == null ? this : bVar.nM(this.eTP).nN(this.eTZ).nO(this.eTO).x((float[]) this.eTQ.clone()).nP(this.dvd).nQ(this.mShadowRadius).nR(this.cIc).nS(this.cId).k((int[]) this.eTS.clone()).y((float[]) this.eTT.clone()).Al(this.eTV).nT(this.mBorderColor).ac(this.mBorderWidth).ad(this.mAlpha);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return hashCode() == bVar.hashCode() && this.eTO == bVar.eTO && this.mShadowRadius == bVar.mShadowRadius && this.dvd == bVar.dvd && this.eTP == bVar.eTP && this.cIc == bVar.cIc && this.cId == bVar.cId && this.eTZ == bVar.eTZ && Arrays.equals(this.eTQ, bVar.eTQ) && Arrays.equals(this.eTR, bVar.eTR) && Arrays.equals(this.eTS, bVar.eTS) && Arrays.equals(this.eTT, bVar.eTT) && this.eTV.equals(bVar.eTV) && this.mBorderColor == bVar.mBorderColor && this.mBorderWidth == bVar.mBorderWidth && this.mAlpha == bVar.mAlpha;
    }

    public int hashCode() {
        return (((((((Objects.hash(Integer.valueOf(this.eTO), Integer.valueOf(this.mShadowRadius), Integer.valueOf(this.dvd), Integer.valueOf(this.eTP), Integer.valueOf(this.cIc), Integer.valueOf(this.cId), this.eTV, Integer.valueOf(this.eTZ), Integer.valueOf(this.mBorderColor), Float.valueOf(this.mBorderWidth), Float.valueOf(this.mAlpha)) * 31) + Arrays.hashCode(this.eTQ)) * 31) + Arrays.hashCode(this.eTR)) * 31) + Arrays.hashCode(this.eTS)) * 31) + Arrays.hashCode(this.eTT);
    }

    public GradientDrawable bqF() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(this.eTR);
        return gradientDrawable;
    }
}
