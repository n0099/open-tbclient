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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes.dex */
public class b extends ReplacementSpan {
    private Paint bhF;
    private int dBe;
    private int dxi;
    private int feT;
    private int feV;
    private int feX;
    private int feY;
    private boolean feZ;
    private String identify;
    private int mMarginLeft;
    private int mMarginRight;
    private int mTextSize;
    private float[] feU = new float[8];
    private RectF feW = new RectF();
    private boolean ffa = false;
    private int ffb = 0;

    public b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.feT = i;
        if (i2 > 0) {
            pm(i2);
        }
        this.feV = i3;
        this.mTextSize = i4;
        this.dBe = i5;
        this.dxi = i6;
        this.feY = i7;
        this.bhF = new Paint();
        this.bhF.setAntiAlias(true);
        this.bhF.setStyle(Paint.Style.STROKE);
        this.bhF.setTextSize(this.mTextSize);
    }

    public void pj(int i) {
        this.mMarginLeft = i;
    }

    public void setMarginRight(int i) {
        this.mMarginRight = i;
    }

    public void jV(boolean z) {
        this.ffa = z;
    }

    public void pk(int i) {
        this.ffb = i;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.feX = ((int) this.bhF.measureText(charSequence, i, i2)) + (this.dxi * 2);
        return this.feX + this.mMarginLeft + this.mMarginRight;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        int dimenPixelSize;
        int color;
        int color2;
        this.bhF.setColor(ap.getColor(this.feV));
        if (this.feZ) {
            this.bhF.setStyle(Paint.Style.FILL);
        } else {
            this.bhF.setStyle(Paint.Style.STROKE);
        }
        if (this.ffa) {
            this.feW.left = this.mMarginLeft + f;
            this.feW.top = (i4 - this.feY) + this.ffb;
            this.feW.right = this.feX + f + this.mMarginLeft;
            this.feW.bottom = this.ffb + i4;
        } else {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (!com.baidu.tbadk.core.elementsMaven.view.a.k(charSequence)) {
                dimenPixelSize = 0 + UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            } else {
                com.baidu.tbadk.core.elementsMaven.view.a.a(fontMetricsInt, (int) paint.getTextSize());
                dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            }
            int i6 = dimenPixelSize + fontMetricsInt.ascent + i4;
            this.feW.left = this.mMarginLeft + f;
            this.feW.top = i6;
            this.feW.right = this.feX + f + this.mMarginLeft;
            this.feW.bottom = i6 + this.feY;
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
            this.bhF.setShader(new LinearGradient(this.feW.left, this.feW.top, this.feW.right, this.feW.bottom, color, color2, Shader.TileMode.CLAMP));
        }
        Path path = new Path();
        path.addRoundRect(this.feW, this.feU, Path.Direction.CW);
        canvas.drawPath(path, this.bhF);
        this.bhF.setShader(null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if ((skinType == 1 || skinType == 4) && this.identify != null) {
            this.bhF.setColor(com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.mask));
            if (this.feZ) {
                this.bhF.setStyle(Paint.Style.FILL);
            } else {
                this.bhF.setStyle(Paint.Style.STROKE);
            }
            Path path2 = new Path();
            path2.addRoundRect(this.feW, this.feU, Path.Direction.CW);
            canvas.drawPath(path2, this.bhF);
        }
        Paint.FontMetricsInt fontMetricsInt2 = this.bhF.getFontMetricsInt();
        if (this.dBe != 0) {
            this.bhF.setColor(ap.getColor(this.dBe));
        } else {
            this.bhF.setColor(com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.CAM_X0201));
        }
        this.bhF.setStyle(Paint.Style.FILL);
        canvas.drawText(charSequence, i, i2, this.dxi + f + this.mMarginLeft, (int) ((this.feW.centerY() + ((fontMetricsInt2.bottom - fontMetricsInt2.top) / 2)) - fontMetricsInt2.bottom), this.bhF);
    }

    public void jW(boolean z) {
        if (this.bhF != null) {
            this.feZ = z;
            if (z) {
                this.bhF.setStyle(Paint.Style.FILL);
            } else {
                this.bhF.setStyle(Paint.Style.STROKE);
            }
        }
    }

    public void pl(int i) {
        Arrays.fill(this.feU, i);
    }

    public void pm(int i) {
        float[] aI = com.baidu.tbadk.core.elementsMaven.a.aI(i);
        if (!Arrays.equals(this.feU, aI)) {
            this.feU = aI;
        }
    }

    public void By(String str) {
        this.identify = str;
    }
}
