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
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes.dex */
public class b extends Drawable implements Cloneable {
    private LinearGradient bCd;
    private Paint blw;
    private int dmQ;
    private Paint mBorderPaint;
    private RectF mBorderRect;
    private int mOffsetX;
    private int mOffsetY;
    private RectF mRect;
    private int mShadowRadius;
    private View mView;
    private int eHq = 0;
    private float mAlpha = 1.0f;
    private int mBorderColor = 0;
    private float mBorderWidth = 0.0f;
    private int eHr = 1;
    private float[] eHs = new float[8];
    private float[] eHt = new float[8];
    private int[] eHu = {0};
    private float[] eHv = {0.0f, 1.0f};
    private float[] eHw = {0.0f, 1.0f};
    private String eHx = VerticalTranslateLayout.BOTTOM;
    private Path mPath = new Path();
    private Path eHy = new Path();
    private Path eHz = new Path();
    private View.OnLayoutChangeListener eHA = new View.OnLayoutChangeListener() { // from class: com.baidu.tbadk.core.elementsMaven.b.1
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(final View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            float[] boB = b.this.boB();
            if (b.this.eHr == 1) {
                boB[0] = (b.this.eHB & 1) == 1 ? boB[0] : 0.0f;
                boB[1] = (b.this.eHB & 16) == 16 ? boB[1] : 0.0f;
                boB[2] = (b.this.eHB & 256) == 256 ? boB[2] : 0.0f;
                boB[3] = (b.this.eHB & 4096) == 4096 ? boB[3] : 0.0f;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin -= (int) boB[0];
                marginLayoutParams.topMargin -= (int) boB[1];
                marginLayoutParams.rightMargin -= (int) boB[2];
                marginLayoutParams.bottomMargin -= (int) boB[3];
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
    private int eHB = 4369;
    private Paint mShadowPaint = new Paint();

    private b() {
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dmQ);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.blw = new Paint();
        this.blw.setAntiAlias(true);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
    }

    public static b boy() {
        return new b();
    }

    public b oK(int i) {
        if (this.eHr != i) {
            this.eHr = i;
        }
        return this;
    }

    public b oL(int i) {
        if (this.eHB != i) {
            this.eHB = i;
        }
        return this;
    }

    private void boz() {
        System.arraycopy(this.eHs, 0, this.eHt, 0, Math.min(this.eHt.length, 8));
        switch (this.eHq) {
            case 1:
                for (int i = 4; i < 8; i++) {
                    this.eHt[i] = 0.0f;
                }
                return;
            case 2:
                break;
            default:
                return;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.eHt[i2] = 0.0f;
        }
    }

    public b oM(int i) {
        if (this.eHq != i) {
            this.eHq = i;
            boz();
        }
        return this;
    }

    public b z(float[] fArr) {
        if (!Arrays.equals(this.eHs, fArr)) {
            System.arraycopy(fArr, 0, this.eHs, 0, Math.min(fArr.length, 8));
            boz();
        }
        return this;
    }

    public b oN(int i) {
        if (this.dmQ != i) {
            this.dmQ = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dmQ);
        }
        return this;
    }

    public b oO(int i) {
        if (this.mShadowRadius != i) {
            this.mShadowRadius = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dmQ);
        }
        return this;
    }

    public b oP(int i) {
        if (this.mOffsetX != i) {
            this.mOffsetX = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dmQ);
        }
        return this;
    }

    public b oQ(int i) {
        if (this.mOffsetX != i) {
            this.mOffsetY = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dmQ);
        }
        return this;
    }

    public b oR(int i) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
        }
        return this;
    }

    public b aa(float f) {
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
        }
        return this;
    }

    public b oS(int i) {
        if (this.eHu.length != 1 || this.eHu[0] != i) {
            this.eHu = new int[1];
            this.eHu[0] = i;
        }
        return this;
    }

    public b j(int[] iArr) {
        if (!Arrays.equals(this.eHu, iArr)) {
            this.eHu = iArr;
        }
        return this;
    }

    public b A(float[] fArr) {
        if (!Arrays.equals(this.eHv, fArr)) {
            this.eHv = fArr;
        }
        return this;
    }

    public b AR(String str) {
        if (!this.eHx.equals(str)) {
            this.eHx = str;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int length = this.eHt.length;
        for (int i = 0; i < length; i++) {
            if (this.eHt[i] > 0.0f && this.eHt[i] < 1.0f) {
                this.eHt[i] = this.eHt[i] * rect.height();
            }
        }
        float[] boB = boB();
        this.mRect = new RectF(rect.left + boB[0], rect.top + boB[1], rect.right - boB[2], rect.bottom - boB[3]);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, this.eHt, Path.Direction.CW);
        this.eHw = (float[]) this.eHv.clone();
        float[] fArr = (float[]) this.eHt.clone();
        if (this.eHu != null && this.eHu.length > 1 && boA()) {
            d(fArr, this.eHw);
        }
        this.eHy.reset();
        this.eHy.addRoundRect(this.mRect, fArr, Path.Direction.CW);
        float f = 0.5f * this.mBorderWidth;
        float[] fArr2 = (float[]) this.eHt.clone();
        for (int i2 = 0; i2 < fArr2.length; i2++) {
            fArr2[i2] = fArr2[i2] - this.mBorderWidth;
            if (fArr2[i2] < 0.0f) {
                fArr2[i2] = 0.0f;
            }
        }
        this.mBorderRect = new RectF(this.mRect.left + f, this.mRect.top + f, this.mRect.right - f, this.mRect.bottom - f);
        this.eHz.reset();
        this.eHz.addRoundRect(this.mBorderRect, fArr2, Path.Direction.CW);
    }

    private PointF a(RectF rectF, String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals(VerticalTranslateLayout.BOTTOM)) {
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
                if (str.equals(VerticalTranslateLayout.BOTTOM)) {
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

    private boolean boA() {
        if (this.eHv == null || this.eHv.length < 1) {
            return false;
        }
        return this.eHv[this.eHv.length + (-1)] < 1.0f;
    }

    private void d(float[] fArr, float[] fArr2) {
        String str = this.eHx;
        char c = 65535;
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals(VerticalTranslateLayout.BOTTOM)) {
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
                this.mRect.bottom = this.mRect.top + (this.mRect.height() * this.eHv[this.eHv.length - 1]);
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
                break;
            case 1:
                this.mRect.top = this.mRect.bottom - (this.mRect.height() * this.eHv[this.eHv.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                break;
            case 2:
                this.mRect.left = this.mRect.right - (this.mRect.width() * this.eHv[this.eHv.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
                break;
            case 3:
                this.mRect.right = this.mRect.left + (this.mRect.width() * this.eHv[this.eHv.length - 1]);
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                break;
        }
        fArr2[fArr2.length - 1] = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] boB() {
        float[] fArr = new float[4];
        if (this.eHr == 1) {
            fArr[0] = (this.eHB & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.eHt[0];
            fArr[1] = (this.eHB & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.eHt[2];
            fArr[2] = (this.eHB & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.eHt[4];
            fArr[3] = (this.eHB & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.eHt[6];
        } else if (this.eHr == 2) {
            Arrays.fill(fArr, this.mShadowRadius);
        }
        return fArr;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int[] boC = boC();
        if (boC != null) {
            if (boC.length == 1) {
                this.blw.setColor(boC[0]);
            } else {
                PointF a2 = a(this.mRect, this.eHx);
                PointF b = b(this.mRect, this.eHx);
                this.bCd = new LinearGradient(a2.x, a2.y, b.x, b.y, boC, this.eHw, Shader.TileMode.CLAMP);
                this.blw.setShader(this.bCd);
            }
        }
        this.mBorderPaint.setColor(com.baidu.tieba.tbadkCore.c.m(this.mBorderColor, this.mAlpha));
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        if (this.eHr == 1) {
            drawShadow(canvas);
            canvas.drawPath(this.eHy, this.blw);
            D(canvas);
        } else if (this.eHr == 2) {
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.blw);
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), (Math.min(this.mRect.width(), this.mRect.height()) / 2.0f) - (this.mBorderWidth * 0.5f), this.mBorderPaint);
        } else {
            canvas.drawRect(this.mRect, this.blw);
        }
    }

    public b ab(@FloatRange(from = 0.0d, to = 1.0d) float f) {
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

    public void D(Canvas canvas) {
        if (this.mBorderWidth != 0.0f && this.mBorderColor != 0) {
            canvas.drawPath(this.eHz, this.mBorderPaint);
        }
    }

    public void release() {
        if (this.mView != null) {
            this.mView.removeOnLayoutChangeListener(this.eHA);
            this.mView.setLayerType(0, null);
            this.mView = null;
        }
    }

    private int[] boC() {
        if (this.eHu == null) {
            return this.eHu;
        }
        int length = this.eHu.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = com.baidu.tieba.tbadkCore.c.m(this.eHu[i], this.mAlpha);
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
        return bVar == null ? this : bVar.oK(this.eHr).oL(this.eHB).oM(this.eHq).z((float[]) this.eHs.clone()).oN(this.dmQ).oO(this.mShadowRadius).oP(this.mOffsetX).oQ(this.mOffsetY).j((int[]) this.eHu.clone()).A((float[]) this.eHv.clone()).AR(this.eHx).oR(this.mBorderColor).aa(this.mBorderWidth).ab(this.mAlpha);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return hashCode() == bVar.hashCode() && this.eHq == bVar.eHq && this.mShadowRadius == bVar.mShadowRadius && this.dmQ == bVar.dmQ && this.eHr == bVar.eHr && this.mOffsetX == bVar.mOffsetX && this.mOffsetY == bVar.mOffsetY && this.eHB == bVar.eHB && Arrays.equals(this.eHs, bVar.eHs) && Arrays.equals(this.eHt, bVar.eHt) && Arrays.equals(this.eHu, bVar.eHu) && Arrays.equals(this.eHv, bVar.eHv) && this.eHx.equals(bVar.eHx) && this.mBorderColor == bVar.mBorderColor && this.mBorderWidth == bVar.mBorderWidth && this.mAlpha == bVar.mAlpha;
    }

    public int hashCode() {
        return (((((((Objects.hash(Integer.valueOf(this.eHq), Integer.valueOf(this.mShadowRadius), Integer.valueOf(this.dmQ), Integer.valueOf(this.eHr), Integer.valueOf(this.mOffsetX), Integer.valueOf(this.mOffsetY), this.eHx, Integer.valueOf(this.eHB), Integer.valueOf(this.mBorderColor), Float.valueOf(this.mBorderWidth), Float.valueOf(this.mAlpha)) * 31) + Arrays.hashCode(this.eHs)) * 31) + Arrays.hashCode(this.eHt)) * 31) + Arrays.hashCode(this.eHu)) * 31) + Arrays.hashCode(this.eHv);
    }

    public GradientDrawable boD() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(this.eHt);
        return gradientDrawable;
    }
}
