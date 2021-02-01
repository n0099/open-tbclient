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
    private LinearGradient bKW;
    private Paint bhE;
    private int dxk;
    private Paint mBorderPaint;
    private RectF mBorderRect;
    private int mOffsetX;
    private int mOffsetY;
    private RectF mRect;
    private int mShadowRadius;
    private View mView;
    private int eWe = 0;
    private float mAlpha = 1.0f;
    private int mBorderColor = 0;
    private float mBorderWidth = 0.0f;
    private int eWf = 1;
    private float[] eWg = new float[8];
    private float[] eWh = new float[8];
    private int[] eWi = {0};
    private float[] eWj = {0.0f, 1.0f};
    private float[] eWk = {0.0f, 1.0f};
    private String eWl = "bottom";
    private Path mPath = new Path();
    private Path eWm = new Path();
    private Path eWn = new Path();
    private View.OnLayoutChangeListener eWo = new View.OnLayoutChangeListener() { // from class: com.baidu.tbadk.core.elementsMaven.b.1
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(final View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (view.getBackground() instanceof b) {
                b bVar = (b) view.getBackground();
                b.this.mShadowRadius = bVar.mShadowRadius;
                b.this.mOffsetX = bVar.mOffsetX;
                b.this.mOffsetY = bVar.mOffsetY;
                b.this.eWh = bVar.eWh;
            }
            float[] bqW = b.this.bqW();
            if (b.this.eWf == 1) {
                bqW[0] = (b.this.eWp & 1) == 1 ? bqW[0] : 0.0f;
                bqW[1] = (b.this.eWp & 16) == 16 ? bqW[1] : 0.0f;
                bqW[2] = (b.this.eWp & 256) == 256 ? bqW[2] : 0.0f;
                bqW[3] = (b.this.eWp & 4096) == 4096 ? bqW[3] : 0.0f;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin -= (int) bqW[0];
                marginLayoutParams.topMargin -= (int) bqW[1];
                marginLayoutParams.rightMargin -= (int) bqW[2];
                marginLayoutParams.bottomMargin -= (int) bqW[3];
                marginLayoutParams.width = (i3 - i) + ((int) bqW[0]) + ((int) bqW[2]);
                marginLayoutParams.height = ((int) bqW[3]) + (i4 - i2) + ((int) bqW[1]);
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
    private int eWp = 4369;
    private Paint mShadowPaint = new Paint();

    private b() {
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dxk);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.bhE = new Paint();
        this.bhE.setAntiAlias(true);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
    }

    public static b bqT() {
        return new b();
    }

    public b nP(int i) {
        if (this.eWf != i) {
            this.eWf = i;
        }
        return this;
    }

    public b nQ(int i) {
        if (this.eWp != i) {
            this.eWp = i;
        }
        return this;
    }

    private void bqU() {
        System.arraycopy(this.eWg, 0, this.eWh, 0, Math.min(this.eWh.length, 8));
        switch (this.eWe) {
            case 1:
                for (int i = 4; i < 8; i++) {
                    this.eWh[i] = 0.0f;
                }
                return;
            case 2:
                break;
            default:
                return;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.eWh[i2] = 0.0f;
        }
    }

    public b nR(int i) {
        if (this.eWe != i) {
            this.eWe = i;
            bqU();
        }
        return this;
    }

    public b x(float[] fArr) {
        if (!Arrays.equals(this.eWg, fArr)) {
            System.arraycopy(fArr, 0, this.eWg, 0, Math.min(fArr.length, 8));
            bqU();
        }
        return this;
    }

    public b nS(int i) {
        if (this.dxk != i) {
            this.dxk = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dxk);
        }
        return this;
    }

    public b nT(int i) {
        if (this.mShadowRadius != i) {
            this.mShadowRadius = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dxk);
        }
        return this;
    }

    public b nU(int i) {
        if (this.mOffsetX != i) {
            this.mOffsetX = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dxk);
        }
        return this;
    }

    public b nV(int i) {
        if (this.mOffsetX != i) {
            this.mOffsetY = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dxk);
        }
        return this;
    }

    public b nW(int i) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
        }
        return this;
    }

    public b ad(float f) {
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
        }
        return this;
    }

    public b nX(int i) {
        if (this.eWi.length != 1 || this.eWi[0] != i) {
            this.eWi = new int[1];
            this.eWi[0] = i;
        }
        return this;
    }

    public b k(int[] iArr) {
        if (!Arrays.equals(this.eWi, iArr)) {
            this.eWi = iArr;
        }
        return this;
    }

    public b y(float[] fArr) {
        if (!Arrays.equals(this.eWj, fArr)) {
            this.eWj = fArr;
        }
        return this;
    }

    public b AC(String str) {
        if (!this.eWl.equals(str)) {
            this.eWl = str;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int length = this.eWh.length;
        for (int i = 0; i < length; i++) {
            if (this.eWh[i] > 0.0f && this.eWh[i] < 1.0f) {
                this.eWh[i] = this.eWh[i] * rect.height();
            }
        }
        float[] bqW = bqW();
        this.mRect = new RectF(rect.left + bqW[0], rect.top + bqW[1], rect.right - bqW[2], rect.bottom - bqW[3]);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, this.eWh, Path.Direction.CW);
        this.eWk = (float[]) this.eWj.clone();
        float[] fArr = (float[]) this.eWh.clone();
        if (this.eWi != null && this.eWi.length > 1 && bqV()) {
            d(fArr, this.eWk);
        }
        this.eWm.reset();
        this.eWm.addRoundRect(this.mRect, fArr, Path.Direction.CW);
        float f = 0.5f * this.mBorderWidth;
        float[] fArr2 = (float[]) this.eWh.clone();
        for (int i2 = 0; i2 < fArr2.length; i2++) {
            fArr2[i2] = fArr2[i2] - this.mBorderWidth;
            if (fArr2[i2] < 0.0f) {
                fArr2[i2] = 0.0f;
            }
        }
        this.mBorderRect = new RectF(this.mRect.left + f, this.mRect.top + f, this.mRect.right - f, this.mRect.bottom - f);
        this.eWn.reset();
        this.eWn.addRoundRect(this.mBorderRect, fArr2, Path.Direction.CW);
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

    private boolean bqV() {
        if (this.eWj == null || this.eWj.length < 1) {
            return false;
        }
        return this.eWj[this.eWj.length + (-1)] < 1.0f;
    }

    private void d(float[] fArr, float[] fArr2) {
        String str = this.eWl;
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
                this.mRect.bottom = this.mRect.top + (this.mRect.height() * this.eWj[this.eWj.length - 1]);
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
                break;
            case 1:
                this.mRect.top = this.mRect.bottom - (this.mRect.height() * this.eWj[this.eWj.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                break;
            case 2:
                this.mRect.left = this.mRect.right - (this.mRect.width() * this.eWj[this.eWj.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
                break;
            case 3:
                this.mRect.right = this.mRect.left + (this.mRect.width() * this.eWj[this.eWj.length - 1]);
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                break;
        }
        fArr2[fArr2.length - 1] = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] bqW() {
        float[] fArr = new float[4];
        if (this.eWf == 1) {
            fArr[0] = (this.eWp & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.eWh[0];
            fArr[1] = (this.eWp & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.eWh[2];
            fArr[2] = (this.eWp & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.eWh[4];
            fArr[3] = (this.eWp & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.eWh[6];
        } else if (this.eWf == 2) {
            Arrays.fill(fArr, this.mShadowRadius);
        }
        return fArr;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int[] bqX = bqX();
        if (bqX != null) {
            if (bqX.length == 1) {
                this.bhE.setColor(bqX[0]);
            } else {
                PointF a2 = a(this.mRect, this.eWl);
                PointF b2 = b(this.mRect, this.eWl);
                this.bKW = new LinearGradient(a2.x, a2.y, b2.x, b2.y, bqX, this.eWk, Shader.TileMode.CLAMP);
                this.bhE.setShader(this.bKW);
            }
        }
        this.mBorderPaint.setColor(com.baidu.tieba.tbadkCore.c.l(this.mBorderColor, this.mAlpha));
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        if (this.eWf == 1) {
            drawShadow(canvas);
            canvas.drawPath(this.eWm, this.bhE);
            K(canvas);
        } else if (this.eWf == 2) {
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.bhE);
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), (Math.min(this.mRect.width(), this.mRect.height()) / 2.0f) - (this.mBorderWidth * 0.5f), this.mBorderPaint);
        } else {
            canvas.drawRect(this.mRect, this.bhE);
        }
    }

    public b ae(@FloatRange(from = 0.0d, to = 1.0d) float f) {
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
            canvas.drawPath(this.eWn, this.mBorderPaint);
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
        this.mView.removeOnLayoutChangeListener(this.eWo);
        this.mView.addOnLayoutChangeListener(this.eWo);
        return this;
    }

    public void release() {
        if (this.mView != null) {
            this.mView.removeOnLayoutChangeListener(this.eWo);
            this.mView.setLayerType(0, null);
            this.mView = null;
        }
    }

    private int[] bqX() {
        if (this.eWi == null) {
            return this.eWi;
        }
        int length = this.eWi.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = com.baidu.tieba.tbadkCore.c.l(this.eWi[i], this.mAlpha);
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
        return bVar == null ? this : bVar.nP(this.eWf).nQ(this.eWp).nR(this.eWe).x((float[]) this.eWg.clone()).nS(this.dxk).nT(this.mShadowRadius).nU(this.mOffsetX).nV(this.mOffsetY).k((int[]) this.eWi.clone()).y((float[]) this.eWj.clone()).AC(this.eWl).nW(this.mBorderColor).ad(this.mBorderWidth).ae(this.mAlpha);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return hashCode() == bVar.hashCode() && this.eWe == bVar.eWe && this.mShadowRadius == bVar.mShadowRadius && this.dxk == bVar.dxk && this.eWf == bVar.eWf && this.mOffsetX == bVar.mOffsetX && this.mOffsetY == bVar.mOffsetY && this.eWp == bVar.eWp && Arrays.equals(this.eWg, bVar.eWg) && Arrays.equals(this.eWh, bVar.eWh) && Arrays.equals(this.eWi, bVar.eWi) && Arrays.equals(this.eWj, bVar.eWj) && this.eWl.equals(bVar.eWl) && this.mBorderColor == bVar.mBorderColor && this.mBorderWidth == bVar.mBorderWidth && this.mAlpha == bVar.mAlpha;
    }

    public int hashCode() {
        return (((((((Objects.hash(Integer.valueOf(this.eWe), Integer.valueOf(this.mShadowRadius), Integer.valueOf(this.dxk), Integer.valueOf(this.eWf), Integer.valueOf(this.mOffsetX), Integer.valueOf(this.mOffsetY), this.eWl, Integer.valueOf(this.eWp), Integer.valueOf(this.mBorderColor), Float.valueOf(this.mBorderWidth), Float.valueOf(this.mAlpha)) * 31) + Arrays.hashCode(this.eWg)) * 31) + Arrays.hashCode(this.eWh)) * 31) + Arrays.hashCode(this.eWi)) * 31) + Arrays.hashCode(this.eWj);
    }

    public GradientDrawable bqY() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(this.eWh);
        return gradientDrawable;
    }
}
