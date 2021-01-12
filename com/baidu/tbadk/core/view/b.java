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
    private Paint bex;
    private int dva;
    private int dyZ;
    private int fcE;
    private int fcG;
    private int fcI;
    private int fcJ;
    private boolean fcK;
    private String identify;
    private int mMarginLeft;
    private int mMarginRight;
    private int mTextSize;
    private float[] fcF = new float[8];
    private RectF fcH = new RectF();
    private boolean fcL = false;
    private int fcM = 0;

    public b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.fcE = i;
        if (i2 > 0) {
            ph(i2);
        }
        this.fcG = i3;
        this.mTextSize = i4;
        this.dyZ = i5;
        this.dva = i6;
        this.fcJ = i7;
        this.bex = new Paint();
        this.bex.setAntiAlias(true);
        this.bex.setStyle(Paint.Style.STROKE);
        this.bex.setTextSize(this.mTextSize);
    }

    public void pe(int i) {
        this.mMarginLeft = i;
    }

    public void setMarginRight(int i) {
        this.mMarginRight = i;
    }

    public void jS(boolean z) {
        this.fcL = z;
    }

    public void pf(int i) {
        this.fcM = i;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.fcI = ((int) this.bex.measureText(charSequence, i, i2)) + (this.dva * 2);
        return this.fcI + this.mMarginLeft + this.mMarginRight;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        int dimenPixelSize;
        int color;
        int color2;
        this.bex.setColor(ao.getColor(this.fcG));
        if (this.fcK) {
            this.bex.setStyle(Paint.Style.FILL);
        } else {
            this.bex.setStyle(Paint.Style.STROKE);
        }
        if (this.fcL) {
            this.fcH.left = this.mMarginLeft + f;
            this.fcH.top = (i4 - this.fcJ) + this.fcM;
            this.fcH.right = this.fcI + f + this.mMarginLeft;
            this.fcH.bottom = this.fcM + i4;
        } else {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (!com.baidu.tbadk.core.elementsMaven.view.a.k(charSequence)) {
                dimenPixelSize = 0 + UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            } else {
                com.baidu.tbadk.core.elementsMaven.view.a.a(fontMetricsInt, (int) paint.getTextSize());
                dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            }
            int i6 = dimenPixelSize + fontMetricsInt.ascent + i4;
            this.fcH.left = this.mMarginLeft + f;
            this.fcH.top = i6;
            this.fcH.right = this.fcI + f + this.mMarginLeft;
            this.fcH.bottom = i6 + this.fcJ;
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
            this.bex.setShader(new LinearGradient(this.fcH.left, this.fcH.top, this.fcH.right, this.fcH.bottom, color, color2, Shader.TileMode.CLAMP));
        }
        Path path = new Path();
        path.addRoundRect(this.fcH, this.fcF, Path.Direction.CW);
        canvas.drawPath(path, this.bex);
        this.bex.setShader(null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if ((skinType == 1 || skinType == 4) && this.identify != null) {
            this.bex.setColor(com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.mask));
            if (this.fcK) {
                this.bex.setStyle(Paint.Style.FILL);
            } else {
                this.bex.setStyle(Paint.Style.STROKE);
            }
            Path path2 = new Path();
            path2.addRoundRect(this.fcH, this.fcF, Path.Direction.CW);
            canvas.drawPath(path2, this.bex);
        }
        Paint.FontMetricsInt fontMetricsInt2 = this.bex.getFontMetricsInt();
        if (this.dyZ != 0) {
            this.bex.setColor(ao.getColor(this.dyZ));
        } else {
            this.bex.setColor(com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.CAM_X0201));
        }
        this.bex.setStyle(Paint.Style.FILL);
        canvas.drawText(charSequence, i, i2, this.dva + f + this.mMarginLeft, (int) ((this.fcH.centerY() + ((fontMetricsInt2.bottom - fontMetricsInt2.top) / 2)) - fontMetricsInt2.bottom), this.bex);
    }

    public void jT(boolean z) {
        if (this.bex != null) {
            this.fcK = z;
            if (z) {
                this.bex.setStyle(Paint.Style.FILL);
            } else {
                this.bex.setStyle(Paint.Style.STROKE);
            }
        }
    }

    public void pg(int i) {
        Arrays.fill(this.fcF, i);
    }

    public void ph(int i) {
        float[] aI = com.baidu.tbadk.core.elementsMaven.a.aI(i);
        if (!Arrays.equals(this.fcF, aI)) {
            this.fcF = aI;
        }
    }

    public void Bh(String str) {
        this.identify = str;
    }
}
