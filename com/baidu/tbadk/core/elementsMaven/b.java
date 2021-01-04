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
    private LinearGradient bLY;
    private Paint bjn;
    private int cMO;
    private int cMP;
    private int dzP;
    private Paint mBorderPaint;
    private RectF mBorderRect;
    private RectF mRect;
    private int mShadowRadius;
    private View mView;
    private int eYz = 0;
    private float mAlpha = 1.0f;
    private int mBorderColor = 0;
    private float mBorderWidth = 0.0f;
    private int eYA = 1;
    private float[] eYB = new float[8];
    private float[] eYC = new float[8];
    private int[] eYD = {0};
    private float[] eYE = {0.0f, 1.0f};
    private float[] eYF = {0.0f, 1.0f};
    private String eYG = "bottom";
    private Path mPath = new Path();
    private Path eYH = new Path();
    private Path eYI = new Path();
    private View.OnLayoutChangeListener eYJ = new View.OnLayoutChangeListener() { // from class: com.baidu.tbadk.core.elementsMaven.b.1
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(final View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (view.getBackground() instanceof b) {
                b bVar = (b) view.getBackground();
                b.this.mShadowRadius = bVar.mShadowRadius;
                b.this.cMO = bVar.cMO;
                b.this.cMP = bVar.cMP;
                b.this.eYC = bVar.eYC;
            }
            float[] buw = b.this.buw();
            if (b.this.eYA == 1) {
                buw[0] = (b.this.eYK & 1) == 1 ? buw[0] : 0.0f;
                buw[1] = (b.this.eYK & 16) == 16 ? buw[1] : 0.0f;
                buw[2] = (b.this.eYK & 256) == 256 ? buw[2] : 0.0f;
                buw[3] = (b.this.eYK & 4096) == 4096 ? buw[3] : 0.0f;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin -= (int) buw[0];
                marginLayoutParams.topMargin -= (int) buw[1];
                marginLayoutParams.rightMargin -= (int) buw[2];
                marginLayoutParams.bottomMargin -= (int) buw[3];
                marginLayoutParams.width = (i3 - i) + ((int) buw[0]) + ((int) buw[2]);
                marginLayoutParams.height = ((int) buw[3]) + (i4 - i2) + ((int) buw[1]);
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
    private int eYK = 4369;
    private Paint mShadowPaint = new Paint();

    private b() {
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cMO, this.cMP, this.dzP);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.bjn = new Paint();
        this.bjn.setAntiAlias(true);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
    }

    public static b but() {
        return new b();
    }

    public b pt(int i) {
        if (this.eYA != i) {
            this.eYA = i;
        }
        return this;
    }

    public b pu(int i) {
        if (this.eYK != i) {
            this.eYK = i;
        }
        return this;
    }

    private void buu() {
        System.arraycopy(this.eYB, 0, this.eYC, 0, Math.min(this.eYC.length, 8));
        switch (this.eYz) {
            case 1:
                for (int i = 4; i < 8; i++) {
                    this.eYC[i] = 0.0f;
                }
                return;
            case 2:
                break;
            default:
                return;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.eYC[i2] = 0.0f;
        }
    }

    public b pv(int i) {
        if (this.eYz != i) {
            this.eYz = i;
            buu();
        }
        return this;
    }

    public b x(float[] fArr) {
        if (!Arrays.equals(this.eYB, fArr)) {
            System.arraycopy(fArr, 0, this.eYB, 0, Math.min(fArr.length, 8));
            buu();
        }
        return this;
    }

    public b pw(int i) {
        if (this.dzP != i) {
            this.dzP = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cMO, this.cMP, this.dzP);
        }
        return this;
    }

    public b px(int i) {
        if (this.mShadowRadius != i) {
            this.mShadowRadius = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cMO, this.cMP, this.dzP);
        }
        return this;
    }

    public b py(int i) {
        if (this.cMO != i) {
            this.cMO = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cMO, this.cMP, this.dzP);
        }
        return this;
    }

    public b pz(int i) {
        if (this.cMO != i) {
            this.cMP = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cMO, this.cMP, this.dzP);
        }
        return this;
    }

    public b pA(int i) {
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

    public b pB(int i) {
        if (this.eYD.length != 1 || this.eYD[0] != i) {
            this.eYD = new int[1];
            this.eYD[0] = i;
        }
        return this;
    }

    public b k(int[] iArr) {
        if (!Arrays.equals(this.eYD, iArr)) {
            this.eYD = iArr;
        }
        return this;
    }

    public b y(float[] fArr) {
        if (!Arrays.equals(this.eYE, fArr)) {
            this.eYE = fArr;
        }
        return this;
    }

    public b Bx(String str) {
        if (!this.eYG.equals(str)) {
            this.eYG = str;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int length = this.eYC.length;
        for (int i = 0; i < length; i++) {
            if (this.eYC[i] > 0.0f && this.eYC[i] < 1.0f) {
                this.eYC[i] = this.eYC[i] * rect.height();
            }
        }
        float[] buw = buw();
        this.mRect = new RectF(rect.left + buw[0], rect.top + buw[1], rect.right - buw[2], rect.bottom - buw[3]);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, this.eYC, Path.Direction.CW);
        this.eYF = (float[]) this.eYE.clone();
        float[] fArr = (float[]) this.eYC.clone();
        if (this.eYD != null && this.eYD.length > 1 && buv()) {
            d(fArr, this.eYF);
        }
        this.eYH.reset();
        this.eYH.addRoundRect(this.mRect, fArr, Path.Direction.CW);
        float f = 0.5f * this.mBorderWidth;
        float[] fArr2 = (float[]) this.eYC.clone();
        for (int i2 = 0; i2 < fArr2.length; i2++) {
            fArr2[i2] = fArr2[i2] - this.mBorderWidth;
            if (fArr2[i2] < 0.0f) {
                fArr2[i2] = 0.0f;
            }
        }
        this.mBorderRect = new RectF(this.mRect.left + f, this.mRect.top + f, this.mRect.right - f, this.mRect.bottom - f);
        this.eYI.reset();
        this.eYI.addRoundRect(this.mBorderRect, fArr2, Path.Direction.CW);
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

    private boolean buv() {
        if (this.eYE == null || this.eYE.length < 1) {
            return false;
        }
        return this.eYE[this.eYE.length + (-1)] < 1.0f;
    }

    private void d(float[] fArr, float[] fArr2) {
        String str = this.eYG;
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
                this.mRect.bottom = this.mRect.top + (this.mRect.height() * this.eYE[this.eYE.length - 1]);
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
                break;
            case 1:
                this.mRect.top = this.mRect.bottom - (this.mRect.height() * this.eYE[this.eYE.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                break;
            case 2:
                this.mRect.left = this.mRect.right - (this.mRect.width() * this.eYE[this.eYE.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
                break;
            case 3:
                this.mRect.right = this.mRect.left + (this.mRect.width() * this.eYE[this.eYE.length - 1]);
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                break;
        }
        fArr2[fArr2.length - 1] = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] buw() {
        float[] fArr = new float[4];
        if (this.eYA == 1) {
            fArr[0] = (this.eYK & 1) == 1 ? this.mShadowRadius - this.cMO : -this.eYC[0];
            fArr[1] = (this.eYK & 16) == 16 ? this.mShadowRadius - this.cMP : -this.eYC[2];
            fArr[2] = (this.eYK & 256) == 256 ? this.mShadowRadius + this.cMO : -this.eYC[4];
            fArr[3] = (this.eYK & 4096) == 4096 ? this.mShadowRadius + this.cMP : -this.eYC[6];
        } else if (this.eYA == 2) {
            Arrays.fill(fArr, this.mShadowRadius);
        }
        return fArr;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int[] bux = bux();
        if (bux != null) {
            if (bux.length == 1) {
                this.bjn.setColor(bux[0]);
            } else {
                PointF a2 = a(this.mRect, this.eYG);
                PointF b2 = b(this.mRect, this.eYG);
                this.bLY = new LinearGradient(a2.x, a2.y, b2.x, b2.y, bux, this.eYF, Shader.TileMode.CLAMP);
                this.bjn.setShader(this.bLY);
            }
        }
        this.mBorderPaint.setColor(com.baidu.tieba.tbadkCore.c.m(this.mBorderColor, this.mAlpha));
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        if (this.eYA == 1) {
            drawShadow(canvas);
            canvas.drawPath(this.eYH, this.bjn);
            K(canvas);
        } else if (this.eYA == 2) {
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.bjn);
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), (Math.min(this.mRect.width(), this.mRect.height()) / 2.0f) - (this.mBorderWidth * 0.5f), this.mBorderPaint);
        } else {
            canvas.drawRect(this.mRect, this.bjn);
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
        if (this.mShadowRadius != 0 || this.cMO != 0 || this.cMP != 0) {
            canvas.drawPath(this.mPath, this.mShadowPaint);
        }
    }

    public void K(Canvas canvas) {
        if (this.mBorderWidth != 0.0f && this.mBorderColor != 0) {
            canvas.drawPath(this.eYI, this.mBorderPaint);
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
        this.mView.removeOnLayoutChangeListener(this.eYJ);
        this.mView.addOnLayoutChangeListener(this.eYJ);
        return this;
    }

    public void release() {
        if (this.mView != null) {
            this.mView.removeOnLayoutChangeListener(this.eYJ);
            this.mView.setLayerType(0, null);
            this.mView = null;
        }
    }

    private int[] bux() {
        if (this.eYD == null) {
            return this.eYD;
        }
        int length = this.eYD.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = com.baidu.tieba.tbadkCore.c.m(this.eYD[i], this.mAlpha);
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
        return bVar == null ? this : bVar.pt(this.eYA).pu(this.eYK).pv(this.eYz).x((float[]) this.eYB.clone()).pw(this.dzP).px(this.mShadowRadius).py(this.cMO).pz(this.cMP).k((int[]) this.eYD.clone()).y((float[]) this.eYE.clone()).Bx(this.eYG).pA(this.mBorderColor).ac(this.mBorderWidth).ad(this.mAlpha);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return hashCode() == bVar.hashCode() && this.eYz == bVar.eYz && this.mShadowRadius == bVar.mShadowRadius && this.dzP == bVar.dzP && this.eYA == bVar.eYA && this.cMO == bVar.cMO && this.cMP == bVar.cMP && this.eYK == bVar.eYK && Arrays.equals(this.eYB, bVar.eYB) && Arrays.equals(this.eYC, bVar.eYC) && Arrays.equals(this.eYD, bVar.eYD) && Arrays.equals(this.eYE, bVar.eYE) && this.eYG.equals(bVar.eYG) && this.mBorderColor == bVar.mBorderColor && this.mBorderWidth == bVar.mBorderWidth && this.mAlpha == bVar.mAlpha;
    }

    public int hashCode() {
        return (((((((Objects.hash(Integer.valueOf(this.eYz), Integer.valueOf(this.mShadowRadius), Integer.valueOf(this.dzP), Integer.valueOf(this.eYA), Integer.valueOf(this.cMO), Integer.valueOf(this.cMP), this.eYG, Integer.valueOf(this.eYK), Integer.valueOf(this.mBorderColor), Float.valueOf(this.mBorderWidth), Float.valueOf(this.mAlpha)) * 31) + Arrays.hashCode(this.eYB)) * 31) + Arrays.hashCode(this.eYC)) * 31) + Arrays.hashCode(this.eYD)) * 31) + Arrays.hashCode(this.eYE);
    }

    public GradientDrawable buy() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(this.eYC);
        return gradientDrawable;
    }
}
