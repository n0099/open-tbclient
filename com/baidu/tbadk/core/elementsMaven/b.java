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
    private LinearGradient bHl;
    private Paint bhF;
    private int cHY;
    private int dtT;
    private Paint mBorderPaint;
    private RectF mBorderRect;
    private int mOffsetY;
    private RectF mRect;
    private int mShadowRadius;
    private View mView;
    private int eOA = 0;
    private float mAlpha = 1.0f;
    private int mBorderColor = 0;
    private float mBorderWidth = 0.0f;
    private int eOB = 1;
    private float[] eOC = new float[8];
    private float[] eOD = new float[8];
    private int[] eOE = {0};
    private float[] eOF = {0.0f, 1.0f};
    private float[] eOG = {0.0f, 1.0f};
    private String eOH = VerticalTranslateLayout.BOTTOM;
    private Path mPath = new Path();
    private Path eOI = new Path();
    private Path eOJ = new Path();
    private View.OnLayoutChangeListener eOK = new View.OnLayoutChangeListener() { // from class: com.baidu.tbadk.core.elementsMaven.b.1
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(final View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (view.getBackground() instanceof b) {
                b bVar = (b) view.getBackground();
                b.this.mShadowRadius = bVar.mShadowRadius;
                b.this.cHY = bVar.cHY;
                b.this.mOffsetY = bVar.mOffsetY;
                b.this.eOD = bVar.eOD;
            }
            float[] brU = b.this.brU();
            if (b.this.eOB == 1) {
                brU[0] = (b.this.eOL & 1) == 1 ? brU[0] : 0.0f;
                brU[1] = (b.this.eOL & 16) == 16 ? brU[1] : 0.0f;
                brU[2] = (b.this.eOL & 256) == 256 ? brU[2] : 0.0f;
                brU[3] = (b.this.eOL & 4096) == 4096 ? brU[3] : 0.0f;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin -= (int) brU[0];
                marginLayoutParams.topMargin -= (int) brU[1];
                marginLayoutParams.rightMargin -= (int) brU[2];
                marginLayoutParams.bottomMargin -= (int) brU[3];
                marginLayoutParams.width = (i3 - i) + ((int) brU[0]) + ((int) brU[2]);
                marginLayoutParams.height = ((int) brU[3]) + (i4 - i2) + ((int) brU[1]);
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
    private int eOL = 4369;
    private Paint mShadowPaint = new Paint();

    private b() {
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cHY, this.mOffsetY, this.dtT);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.bhF = new Paint();
        this.bhF.setAntiAlias(true);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
    }

    public static b brR() {
        return new b();
    }

    public b pi(int i) {
        if (this.eOB != i) {
            this.eOB = i;
        }
        return this;
    }

    public b pj(int i) {
        if (this.eOL != i) {
            this.eOL = i;
        }
        return this;
    }

    private void brS() {
        System.arraycopy(this.eOC, 0, this.eOD, 0, Math.min(this.eOD.length, 8));
        switch (this.eOA) {
            case 1:
                for (int i = 4; i < 8; i++) {
                    this.eOD[i] = 0.0f;
                }
                return;
            case 2:
                break;
            default:
                return;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.eOD[i2] = 0.0f;
        }
    }

    public b pk(int i) {
        if (this.eOA != i) {
            this.eOA = i;
            brS();
        }
        return this;
    }

    public b y(float[] fArr) {
        if (!Arrays.equals(this.eOC, fArr)) {
            System.arraycopy(fArr, 0, this.eOC, 0, Math.min(fArr.length, 8));
            brS();
        }
        return this;
    }

    public b pl(int i) {
        if (this.dtT != i) {
            this.dtT = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cHY, this.mOffsetY, this.dtT);
        }
        return this;
    }

    public b pm(int i) {
        if (this.mShadowRadius != i) {
            this.mShadowRadius = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cHY, this.mOffsetY, this.dtT);
        }
        return this;
    }

    public b po(int i) {
        if (this.cHY != i) {
            this.cHY = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cHY, this.mOffsetY, this.dtT);
        }
        return this;
    }

    public b pp(int i) {
        if (this.cHY != i) {
            this.mOffsetY = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cHY, this.mOffsetY, this.dtT);
        }
        return this;
    }

    public b pq(int i) {
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

    public b pr(int i) {
        if (this.eOE.length != 1 || this.eOE[0] != i) {
            this.eOE = new int[1];
            this.eOE[0] = i;
        }
        return this;
    }

    public b j(int[] iArr) {
        if (!Arrays.equals(this.eOE, iArr)) {
            this.eOE = iArr;
        }
        return this;
    }

    public b z(float[] fArr) {
        if (!Arrays.equals(this.eOF, fArr)) {
            this.eOF = fArr;
        }
        return this;
    }

    public b By(String str) {
        if (!this.eOH.equals(str)) {
            this.eOH = str;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int length = this.eOD.length;
        for (int i = 0; i < length; i++) {
            if (this.eOD[i] > 0.0f && this.eOD[i] < 1.0f) {
                this.eOD[i] = this.eOD[i] * rect.height();
            }
        }
        float[] brU = brU();
        this.mRect = new RectF(rect.left + brU[0], rect.top + brU[1], rect.right - brU[2], rect.bottom - brU[3]);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, this.eOD, Path.Direction.CW);
        this.eOG = (float[]) this.eOF.clone();
        float[] fArr = (float[]) this.eOD.clone();
        if (this.eOE != null && this.eOE.length > 1 && brT()) {
            d(fArr, this.eOG);
        }
        this.eOI.reset();
        this.eOI.addRoundRect(this.mRect, fArr, Path.Direction.CW);
        float f = 0.5f * this.mBorderWidth;
        float[] fArr2 = (float[]) this.eOD.clone();
        for (int i2 = 0; i2 < fArr2.length; i2++) {
            fArr2[i2] = fArr2[i2] - this.mBorderWidth;
            if (fArr2[i2] < 0.0f) {
                fArr2[i2] = 0.0f;
            }
        }
        this.mBorderRect = new RectF(this.mRect.left + f, this.mRect.top + f, this.mRect.right - f, this.mRect.bottom - f);
        this.eOJ.reset();
        this.eOJ.addRoundRect(this.mBorderRect, fArr2, Path.Direction.CW);
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

    private boolean brT() {
        if (this.eOF == null || this.eOF.length < 1) {
            return false;
        }
        return this.eOF[this.eOF.length + (-1)] < 1.0f;
    }

    private void d(float[] fArr, float[] fArr2) {
        String str = this.eOH;
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
                this.mRect.bottom = this.mRect.top + (this.mRect.height() * this.eOF[this.eOF.length - 1]);
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
                break;
            case 1:
                this.mRect.top = this.mRect.bottom - (this.mRect.height() * this.eOF[this.eOF.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                break;
            case 2:
                this.mRect.left = this.mRect.right - (this.mRect.width() * this.eOF[this.eOF.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
                break;
            case 3:
                this.mRect.right = this.mRect.left + (this.mRect.width() * this.eOF[this.eOF.length - 1]);
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                break;
        }
        fArr2[fArr2.length - 1] = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] brU() {
        float[] fArr = new float[4];
        if (this.eOB == 1) {
            fArr[0] = (this.eOL & 1) == 1 ? this.mShadowRadius - this.cHY : -this.eOD[0];
            fArr[1] = (this.eOL & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.eOD[2];
            fArr[2] = (this.eOL & 256) == 256 ? this.mShadowRadius + this.cHY : -this.eOD[4];
            fArr[3] = (this.eOL & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.eOD[6];
        } else if (this.eOB == 2) {
            Arrays.fill(fArr, this.mShadowRadius);
        }
        return fArr;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int[] brV = brV();
        if (brV != null) {
            if (brV.length == 1) {
                this.bhF.setColor(brV[0]);
            } else {
                PointF a2 = a(this.mRect, this.eOH);
                PointF b = b(this.mRect, this.eOH);
                this.bHl = new LinearGradient(a2.x, a2.y, b.x, b.y, brV, this.eOG, Shader.TileMode.CLAMP);
                this.bhF.setShader(this.bHl);
            }
        }
        this.mBorderPaint.setColor(com.baidu.tieba.tbadkCore.c.m(this.mBorderColor, this.mAlpha));
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        if (this.eOB == 1) {
            drawShadow(canvas);
            canvas.drawPath(this.eOI, this.bhF);
            D(canvas);
        } else if (this.eOB == 2) {
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.bhF);
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), (Math.min(this.mRect.width(), this.mRect.height()) / 2.0f) - (this.mBorderWidth * 0.5f), this.mBorderPaint);
        } else {
            canvas.drawRect(this.mRect, this.bhF);
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
        if (this.mShadowRadius != 0 || this.cHY != 0 || this.mOffsetY != 0) {
            canvas.drawPath(this.mPath, this.mShadowPaint);
        }
    }

    public void D(Canvas canvas) {
        if (this.mBorderWidth != 0.0f && this.mBorderColor != 0) {
            canvas.drawPath(this.eOJ, this.mBorderPaint);
        }
    }

    public b bl(View view) {
        if (view == null) {
            return null;
        }
        this.mView = view;
        if (equals(this.mView.getBackground())) {
            return null;
        }
        this.mView.removeOnLayoutChangeListener(this.eOK);
        this.mView.addOnLayoutChangeListener(this.eOK);
        return this;
    }

    public void release() {
        if (this.mView != null) {
            this.mView.removeOnLayoutChangeListener(this.eOK);
            this.mView.setLayerType(0, null);
            this.mView = null;
        }
    }

    private int[] brV() {
        if (this.eOE == null) {
            return this.eOE;
        }
        int length = this.eOE.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = com.baidu.tieba.tbadkCore.c.m(this.eOE[i], this.mAlpha);
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
        return bVar == null ? this : bVar.pi(this.eOB).pj(this.eOL).pk(this.eOA).y((float[]) this.eOC.clone()).pl(this.dtT).pm(this.mShadowRadius).po(this.cHY).pp(this.mOffsetY).j((int[]) this.eOE.clone()).z((float[]) this.eOF.clone()).By(this.eOH).pq(this.mBorderColor).aa(this.mBorderWidth).ab(this.mAlpha);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return hashCode() == bVar.hashCode() && this.eOA == bVar.eOA && this.mShadowRadius == bVar.mShadowRadius && this.dtT == bVar.dtT && this.eOB == bVar.eOB && this.cHY == bVar.cHY && this.mOffsetY == bVar.mOffsetY && this.eOL == bVar.eOL && Arrays.equals(this.eOC, bVar.eOC) && Arrays.equals(this.eOD, bVar.eOD) && Arrays.equals(this.eOE, bVar.eOE) && Arrays.equals(this.eOF, bVar.eOF) && this.eOH.equals(bVar.eOH) && this.mBorderColor == bVar.mBorderColor && this.mBorderWidth == bVar.mBorderWidth && this.mAlpha == bVar.mAlpha;
    }

    public int hashCode() {
        return (((((((Objects.hash(Integer.valueOf(this.eOA), Integer.valueOf(this.mShadowRadius), Integer.valueOf(this.dtT), Integer.valueOf(this.eOB), Integer.valueOf(this.cHY), Integer.valueOf(this.mOffsetY), this.eOH, Integer.valueOf(this.eOL), Integer.valueOf(this.mBorderColor), Float.valueOf(this.mBorderWidth), Float.valueOf(this.mAlpha)) * 31) + Arrays.hashCode(this.eOC)) * 31) + Arrays.hashCode(this.eOD)) * 31) + Arrays.hashCode(this.eOE)) * 31) + Arrays.hashCode(this.eOF);
    }

    public GradientDrawable brW() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(this.eOD);
        return gradientDrawable;
    }
}
