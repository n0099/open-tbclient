package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes.dex */
public class b extends ReplacementSpan {
    private Paint bjo;
    private int dDL;
    private int dzM;
    private int fhm;
    private int fho;
    private int fhq;
    private int fhr;
    private boolean fhs;
    private String identify;
    private int mMarginLeft;
    private int mMarginRight;
    private int mTextSize;
    private float[] fhn = new float[8];
    private RectF fhp = new RectF();
    private boolean fht = false;
    private int fhu = 0;

    public b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.fhm = i;
        if (i2 > 0) {
            qO(i2);
        }
        this.fho = i3;
        this.mTextSize = i4;
        this.dDL = i5;
        this.dzM = i6;
        this.fhr = i7;
        this.bjo = new Paint();
        this.bjo.setAntiAlias(true);
        this.bjo.setStyle(Paint.Style.STROKE);
        this.bjo.setTextSize(this.mTextSize);
    }

    public void qL(int i) {
        this.mMarginLeft = i;
    }

    public void setMarginRight(int i) {
        this.mMarginRight = i;
    }

    public void jW(boolean z) {
        this.fht = z;
    }

    public void qM(int i) {
        this.fhu = i;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.fhq = ((int) this.bjo.measureText(charSequence, i, i2)) + (this.dzM * 2);
        return this.fhq + this.mMarginLeft + this.mMarginRight;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        int dimenPixelSize;
        int color;
        int color2;
        this.bjo.setColor(ao.getColor(this.fho));
        if (this.fhs) {
            this.bjo.setStyle(Paint.Style.FILL);
        } else {
            this.bjo.setStyle(Paint.Style.STROKE);
        }
        if (this.fht) {
            this.fhp.left = this.mMarginLeft + f;
            this.fhp.top = (i4 - this.fhr) + this.fhu;
            this.fhp.right = this.fhq + f + this.mMarginLeft;
            this.fhp.bottom = this.fhu + i4;
        } else {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (!com.baidu.tbadk.core.elementsMaven.view.a.k(charSequence)) {
                dimenPixelSize = 0 + UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            } else {
                com.baidu.tbadk.core.elementsMaven.view.a.a(fontMetricsInt, (int) paint.getTextSize());
                dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            }
            int i6 = dimenPixelSize + fontMetricsInt.ascent + i4;
            this.fhp.left = this.mMarginLeft + f;
            this.fhp.top = i6;
            this.fhp.right = this.fhq + f + this.mMarginLeft;
            this.fhp.bottom = i6 + this.fhr;
        }
        if (this.identify != null) {
            if (" 吧主".equals(this.identify)) {
                color = com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.CAM_X0302);
                color2 = com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.CAM_X0302);
            } else if (" 小吧主".equals(this.identify)) {
                color = com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.CAM_X0302);
                color2 = com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.CAM_X0302);
            } else if (" 楼主".equals(this.identify)) {
                color = com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.CAM_X0302);
                color2 = com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.CAM_X0302);
            } else {
                color = com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.CAM_X0302);
                color2 = com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.CAM_X0302);
            }
            this.bjo.setShader(new LinearGradient(this.fhp.left, this.fhp.top, this.fhp.right, this.fhp.bottom, color, color2, Shader.TileMode.CLAMP));
        }
        Path path = new Path();
        path.addRoundRect(this.fhp, this.fhn, Path.Direction.CW);
        canvas.drawPath(path, this.bjo);
        this.bjo.setShader(null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if ((skinType == 1 || skinType == 4) && this.identify != null) {
            this.bjo.setColor(com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.mask));
            if (this.fhs) {
                this.bjo.setStyle(Paint.Style.FILL);
            } else {
                this.bjo.setStyle(Paint.Style.STROKE);
            }
            Path path2 = new Path();
            path2.addRoundRect(this.fhp, this.fhn, Path.Direction.CW);
            canvas.drawPath(path2, this.bjo);
        }
        Paint.FontMetricsInt fontMetricsInt2 = this.bjo.getFontMetricsInt();
        if (this.dDL != 0) {
            this.bjo.setColor(ao.getColor(this.dDL));
        } else {
            this.bjo.setColor(com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.CAM_X0201));
        }
        this.bjo.setStyle(Paint.Style.FILL);
        canvas.drawText(charSequence, i, i2, this.dzM + f + this.mMarginLeft, (int) ((this.fhp.centerY() + ((fontMetricsInt2.bottom - fontMetricsInt2.top) / 2)) - fontMetricsInt2.bottom), this.bjo);
    }

    public void jX(boolean z) {
        if (this.bjo != null) {
            this.fhs = z;
            if (z) {
                this.bjo.setStyle(Paint.Style.FILL);
            } else {
                this.bjo.setStyle(Paint.Style.STROKE);
            }
        }
    }

    public void qN(int i) {
        Arrays.fill(this.fhn, i);
    }

    public void qO(int i) {
        float[] aI = com.baidu.tbadk.core.elementsMaven.a.aI(i);
        if (!Arrays.equals(this.fhn, aI)) {
            this.fhn = aI;
        }
    }

    public void Ct(String str) {
        this.identify = str;
    }
}
