package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes.dex */
public class b extends ReplacementSpan {
    private int dtQ;
    private int eXM;
    private int eXO;
    private int eXQ;
    private int eXR;
    private boolean eXS;
    private String identify;
    private int mMarginLeft;
    private int mMarginRight;
    private int mTextColorId;
    private Paint mTextPaint;
    private int mTextSize;
    private float[] eXN = new float[8];
    private RectF eXP = new RectF();
    private boolean eXT = false;
    private int eXU = 0;

    public b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.eXM = i;
        if (i2 > 0) {
            qD(i2);
        }
        this.eXO = i3;
        this.mTextSize = i4;
        this.mTextColorId = i5;
        this.dtQ = i6;
        this.eXR = i7;
        this.mTextPaint = new Paint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setStyle(Paint.Style.STROKE);
        this.mTextPaint.setTextSize(this.mTextSize);
    }

    public void qA(int i) {
        this.mMarginLeft = i;
    }

    public void setMarginRight(int i) {
        this.mMarginRight = i;
    }

    public void jA(boolean z) {
        this.eXT = z;
    }

    public void qB(int i) {
        this.eXU = i;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.eXQ = ((int) this.mTextPaint.measureText(charSequence, i, i2)) + (this.dtQ * 2);
        return this.eXQ + this.mMarginLeft + this.mMarginRight;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        int dimenPixelSize;
        int color;
        int color2;
        this.mTextPaint.setColor(ap.getColor(this.eXO));
        if (this.eXS) {
            this.mTextPaint.setStyle(Paint.Style.FILL);
        } else {
            this.mTextPaint.setStyle(Paint.Style.STROKE);
        }
        if (this.eXT) {
            this.eXP.left = this.mMarginLeft + f;
            this.eXP.top = (i4 - this.eXR) + this.eXU;
            this.eXP.right = this.eXQ + f + this.mMarginLeft;
            this.eXP.bottom = this.eXU + i4;
        } else {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (!com.baidu.tbadk.core.elementsMaven.view.a.k(charSequence)) {
                dimenPixelSize = 0 + UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            } else {
                com.baidu.tbadk.core.elementsMaven.view.a.a(fontMetricsInt, (int) paint.getTextSize());
                dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            }
            int i6 = dimenPixelSize + fontMetricsInt.ascent + i4;
            this.eXP.left = this.mMarginLeft + f;
            this.eXP.top = i6;
            this.eXP.right = this.eXQ + f + this.mMarginLeft;
            this.eXP.bottom = i6 + this.eXR;
        }
        if (this.identify != null) {
            if (" 吧主".equals(this.identify)) {
                color = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.CAM_X0302);
                color2 = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.CAM_X0302);
            } else if (" 小吧主".equals(this.identify)) {
                color = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.CAM_X0302);
                color2 = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.CAM_X0302);
            } else if (" 楼主".equals(this.identify)) {
                color = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.CAM_X0302);
                color2 = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.CAM_X0302);
            } else {
                color = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.CAM_X0302);
                color2 = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.CAM_X0302);
            }
            this.mTextPaint.setShader(new LinearGradient(this.eXP.left, this.eXP.top, this.eXP.right, this.eXP.bottom, color, color2, Shader.TileMode.CLAMP));
        }
        Path path = new Path();
        path.addRoundRect(this.eXP, this.eXN, Path.Direction.CW);
        canvas.drawPath(path, this.mTextPaint);
        this.mTextPaint.setShader(null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if ((skinType == 1 || skinType == 4) && this.identify != null) {
            this.mTextPaint.setColor(com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.mask));
            if (this.eXS) {
                this.mTextPaint.setStyle(Paint.Style.FILL);
            } else {
                this.mTextPaint.setStyle(Paint.Style.STROKE);
            }
            Path path2 = new Path();
            path2.addRoundRect(this.eXP, this.eXN, Path.Direction.CW);
            canvas.drawPath(path2, this.mTextPaint);
        }
        Paint.FontMetricsInt fontMetricsInt2 = this.mTextPaint.getFontMetricsInt();
        if (this.mTextColorId != 0) {
            this.mTextPaint.setColor(ap.getColor(this.mTextColorId));
        } else {
            this.mTextPaint.setColor(com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.CAM_X0201));
        }
        this.mTextPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(charSequence, i, i2, this.dtQ + f + this.mMarginLeft, (int) ((this.eXP.centerY() + ((fontMetricsInt2.bottom - fontMetricsInt2.top) / 2)) - fontMetricsInt2.bottom), this.mTextPaint);
    }

    public void jB(boolean z) {
        if (this.mTextPaint != null) {
            this.eXS = z;
            if (z) {
                this.mTextPaint.setStyle(Paint.Style.FILL);
            } else {
                this.mTextPaint.setStyle(Paint.Style.STROKE);
            }
        }
    }

    public void qC(int i) {
        Arrays.fill(this.eXN, i);
    }

    public void qD(int i) {
        float[] aH = com.baidu.tbadk.core.elementsMaven.a.aH(i);
        if (!Arrays.equals(this.eXN, aH)) {
            this.eXN = aH;
        }
    }

    public void Cv(String str) {
        this.identify = str;
    }
}
