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
    private LinearGradient bMw;
    private Paint bjg;
    private int dyL;
    private Paint mBorderPaint;
    private RectF mBorderRect;
    private int mOffsetX;
    private int mOffsetY;
    private RectF mRect;
    private int mShadowRadius;
    private View mView;
    private int eXD = 0;
    private float mAlpha = 1.0f;
    private int mBorderColor = 0;
    private float mBorderWidth = 0.0f;
    private int eXE = 1;
    private float[] eXF = new float[8];
    private float[] eXG = new float[8];
    private int[] eXH = {0};
    private float[] eXI = {0.0f, 1.0f};
    private float[] eXJ = {0.0f, 1.0f};
    private String eXK = "bottom";
    private Path mPath = new Path();
    private Path eXL = new Path();
    private Path eXM = new Path();
    private View.OnLayoutChangeListener eXN = new View.OnLayoutChangeListener() { // from class: com.baidu.tbadk.core.elementsMaven.b.1
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(final View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (view.getBackground() instanceof b) {
                b bVar = (b) view.getBackground();
                b.this.mShadowRadius = bVar.mShadowRadius;
                b.this.mOffsetX = bVar.mOffsetX;
                b.this.mOffsetY = bVar.mOffsetY;
                b.this.eXG = bVar.eXG;
            }
            float[] bqX = b.this.bqX();
            if (b.this.eXE == 1) {
                bqX[0] = (b.this.eXO & 1) == 1 ? bqX[0] : 0.0f;
                bqX[1] = (b.this.eXO & 16) == 16 ? bqX[1] : 0.0f;
                bqX[2] = (b.this.eXO & 256) == 256 ? bqX[2] : 0.0f;
                bqX[3] = (b.this.eXO & 4096) == 4096 ? bqX[3] : 0.0f;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin -= (int) bqX[0];
                marginLayoutParams.topMargin -= (int) bqX[1];
                marginLayoutParams.rightMargin -= (int) bqX[2];
                marginLayoutParams.bottomMargin -= (int) bqX[3];
                marginLayoutParams.width = (i3 - i) + ((int) bqX[0]) + ((int) bqX[2]);
                marginLayoutParams.height = ((int) bqX[3]) + (i4 - i2) + ((int) bqX[1]);
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
    private int eXO = 4369;
    private Paint mShadowPaint = new Paint();

    private b() {
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dyL);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.bjg = new Paint();
        this.bjg.setAntiAlias(true);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
    }

    public static b bqU() {
        return new b();
    }

    public b nQ(int i) {
        if (this.eXE != i) {
            this.eXE = i;
        }
        return this;
    }

    public b nR(int i) {
        if (this.eXO != i) {
            this.eXO = i;
        }
        return this;
    }

    private void bqV() {
        System.arraycopy(this.eXF, 0, this.eXG, 0, Math.min(this.eXG.length, 8));
        switch (this.eXD) {
            case 1:
                for (int i = 4; i < 8; i++) {
                    this.eXG[i] = 0.0f;
                }
                return;
            case 2:
                break;
            default:
                return;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.eXG[i2] = 0.0f;
        }
    }

    public b nS(int i) {
        if (this.eXD != i) {
            this.eXD = i;
            bqV();
        }
        return this;
    }

    public b x(float[] fArr) {
        if (!Arrays.equals(this.eXF, fArr)) {
            System.arraycopy(fArr, 0, this.eXF, 0, Math.min(fArr.length, 8));
            bqV();
        }
        return this;
    }

    public b nT(int i) {
        if (this.dyL != i) {
            this.dyL = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dyL);
        }
        return this;
    }

    public b nU(int i) {
        if (this.mShadowRadius != i) {
            this.mShadowRadius = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dyL);
        }
        return this;
    }

    public b nV(int i) {
        if (this.mOffsetX != i) {
            this.mOffsetX = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dyL);
        }
        return this;
    }

    public b nW(int i) {
        if (this.mOffsetX != i) {
            this.mOffsetY = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dyL);
        }
        return this;
    }

    public b nX(int i) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
        }
        return this;
    }

    public b ah(float f) {
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
        }
        return this;
    }

    public b nY(int i) {
        if (this.eXH.length != 1 || this.eXH[0] != i) {
            this.eXH = new int[1];
            this.eXH[0] = i;
        }
        return this;
    }

    public b k(int[] iArr) {
        if (!Arrays.equals(this.eXH, iArr)) {
            this.eXH = iArr;
        }
        return this;
    }

    public b y(float[] fArr) {
        if (!Arrays.equals(this.eXI, fArr)) {
            this.eXI = fArr;
        }
        return this;
    }

    public b AJ(String str) {
        if (!this.eXK.equals(str)) {
            this.eXK = str;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int length = this.eXG.length;
        for (int i = 0; i < length; i++) {
            if (this.eXG[i] > 0.0f && this.eXG[i] < 1.0f) {
                this.eXG[i] = this.eXG[i] * rect.height();
            }
        }
        float[] bqX = bqX();
        this.mRect = new RectF(rect.left + bqX[0], rect.top + bqX[1], rect.right - bqX[2], rect.bottom - bqX[3]);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, this.eXG, Path.Direction.CW);
        this.eXJ = (float[]) this.eXI.clone();
        float[] fArr = (float[]) this.eXG.clone();
        if (this.eXH != null && this.eXH.length > 1 && bqW()) {
            d(fArr, this.eXJ);
        }
        this.eXL.reset();
        this.eXL.addRoundRect(this.mRect, fArr, Path.Direction.CW);
        float f = 0.5f * this.mBorderWidth;
        float[] fArr2 = (float[]) this.eXG.clone();
        for (int i2 = 0; i2 < fArr2.length; i2++) {
            fArr2[i2] = fArr2[i2] - this.mBorderWidth;
            if (fArr2[i2] < 0.0f) {
                fArr2[i2] = 0.0f;
            }
        }
        this.mBorderRect = new RectF(this.mRect.left + f, this.mRect.top + f, this.mRect.right - f, this.mRect.bottom - f);
        this.eXM.reset();
        this.eXM.addRoundRect(this.mBorderRect, fArr2, Path.Direction.CW);
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

    private boolean bqW() {
        if (this.eXI == null || this.eXI.length < 1) {
            return false;
        }
        return this.eXI[this.eXI.length + (-1)] < 1.0f;
    }

    private void d(float[] fArr, float[] fArr2) {
        String str = this.eXK;
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
                this.mRect.bottom = this.mRect.top + (this.mRect.height() * this.eXI[this.eXI.length - 1]);
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
                break;
            case 1:
                this.mRect.top = this.mRect.bottom - (this.mRect.height() * this.eXI[this.eXI.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                break;
            case 2:
                this.mRect.left = this.mRect.right - (this.mRect.width() * this.eXI[this.eXI.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
                break;
            case 3:
                this.mRect.right = this.mRect.left + (this.mRect.width() * this.eXI[this.eXI.length - 1]);
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                break;
        }
        fArr2[fArr2.length - 1] = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] bqX() {
        float[] fArr = new float[4];
        if (this.eXE == 1) {
            fArr[0] = (this.eXO & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.eXG[0];
            fArr[1] = (this.eXO & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.eXG[2];
            fArr[2] = (this.eXO & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.eXG[4];
            fArr[3] = (this.eXO & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.eXG[6];
        } else if (this.eXE == 2) {
            Arrays.fill(fArr, this.mShadowRadius);
        }
        return fArr;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int[] bqY = bqY();
        if (bqY != null) {
            if (bqY.length == 1) {
                this.bjg.setColor(bqY[0]);
            } else {
                PointF a2 = a(this.mRect, this.eXK);
                PointF b = b(this.mRect, this.eXK);
                this.bMw = new LinearGradient(a2.x, a2.y, b.x, b.y, bqY, this.eXJ, Shader.TileMode.CLAMP);
                this.bjg.setShader(this.bMw);
            }
        }
        this.mBorderPaint.setColor(com.baidu.tieba.tbadkCore.c.l(this.mBorderColor, this.mAlpha));
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        if (this.eXE == 1) {
            drawShadow(canvas);
            canvas.drawPath(this.eXL, this.bjg);
            K(canvas);
        } else if (this.eXE == 2) {
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.bjg);
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), (Math.min(this.mRect.width(), this.mRect.height()) / 2.0f) - (this.mBorderWidth * 0.5f), this.mBorderPaint);
        } else {
            canvas.drawRect(this.mRect, this.bjg);
        }
    }

    public b ai(@FloatRange(from = 0.0d, to = 1.0d) float f) {
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
        if (this.mShadowRadius != 0 || this.mOffsetX != 0 || this.mOffsetY != 0) {
            canvas.drawPath(this.mPath, this.mShadowPaint);
        }
    }

    public void K(Canvas canvas) {
        if (this.mBorderWidth != 0.0f && this.mBorderColor != 0) {
            canvas.drawPath(this.eXM, this.mBorderPaint);
        }
    }

    public b bq(View view) {
        if (view == null) {
            return null;
        }
        this.mView = view;
        if (equals(this.mView.getBackground())) {
            return null;
        }
        this.mView.removeOnLayoutChangeListener(this.eXN);
        this.mView.addOnLayoutChangeListener(this.eXN);
        return this;
    }

    public void release() {
        if (this.mView != null) {
            this.mView.removeOnLayoutChangeListener(this.eXN);
            this.mView.setLayerType(0, null);
            this.mView = null;
        }
    }

    private int[] bqY() {
        if (this.eXH == null) {
            return this.eXH;
        }
        int length = this.eXH.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = com.baidu.tieba.tbadkCore.c.l(this.eXH[i], this.mAlpha);
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
        return bVar == null ? this : bVar.nQ(this.eXE).nR(this.eXO).nS(this.eXD).x((float[]) this.eXF.clone()).nT(this.dyL).nU(this.mShadowRadius).nV(this.mOffsetX).nW(this.mOffsetY).k((int[]) this.eXH.clone()).y((float[]) this.eXI.clone()).AJ(this.eXK).nX(this.mBorderColor).ah(this.mBorderWidth).ai(this.mAlpha);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return hashCode() == bVar.hashCode() && this.eXD == bVar.eXD && this.mShadowRadius == bVar.mShadowRadius && this.dyL == bVar.dyL && this.eXE == bVar.eXE && this.mOffsetX == bVar.mOffsetX && this.mOffsetY == bVar.mOffsetY && this.eXO == bVar.eXO && Arrays.equals(this.eXF, bVar.eXF) && Arrays.equals(this.eXG, bVar.eXG) && Arrays.equals(this.eXH, bVar.eXH) && Arrays.equals(this.eXI, bVar.eXI) && this.eXK.equals(bVar.eXK) && this.mBorderColor == bVar.mBorderColor && this.mBorderWidth == bVar.mBorderWidth && this.mAlpha == bVar.mAlpha;
    }

    public int hashCode() {
        return (((((((Objects.hash(Integer.valueOf(this.eXD), Integer.valueOf(this.mShadowRadius), Integer.valueOf(this.dyL), Integer.valueOf(this.eXE), Integer.valueOf(this.mOffsetX), Integer.valueOf(this.mOffsetY), this.eXK, Integer.valueOf(this.eXO), Integer.valueOf(this.mBorderColor), Float.valueOf(this.mBorderWidth), Float.valueOf(this.mAlpha)) * 31) + Arrays.hashCode(this.eXF)) * 31) + Arrays.hashCode(this.eXG)) * 31) + Arrays.hashCode(this.eXH)) * 31) + Arrays.hashCode(this.eXI);
    }

    public GradientDrawable bqZ() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(this.eXG);
        return gradientDrawable;
    }
}
