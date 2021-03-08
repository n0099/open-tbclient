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
    private Paint bjh;
    private int dCF;
    private int dyJ;
    private int fgs;
    private int fgu;
    private int fgw;
    private int fgx;
    private boolean fgy;
    private String identify;
    private int mMarginLeft;
    private int mMarginRight;
    private int mTextSize;
    private float[] fgt = new float[8];
    private RectF fgv = new RectF();
    private boolean fgz = false;
    private int fgA = 0;

    public b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.fgs = i;
        if (i2 > 0) {
            po(i2);
        }
        this.fgu = i3;
        this.mTextSize = i4;
        this.dCF = i5;
        this.dyJ = i6;
        this.fgx = i7;
        this.bjh = new Paint();
        this.bjh.setAntiAlias(true);
        this.bjh.setStyle(Paint.Style.STROKE);
        this.bjh.setTextSize(this.mTextSize);
    }

    public void pk(int i) {
        this.mMarginLeft = i;
    }

    public void setMarginRight(int i) {
        this.mMarginRight = i;
    }

    public void jV(boolean z) {
        this.fgz = z;
    }

    public void pl(int i) {
        this.fgA = i;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.fgw = ((int) this.bjh.measureText(charSequence, i, i2)) + (this.dyJ * 2);
        return this.fgw + this.mMarginLeft + this.mMarginRight;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        int dimenPixelSize;
        int color;
        int color2;
        this.bjh.setColor(ap.getColor(this.fgu));
        if (this.fgy) {
            this.bjh.setStyle(Paint.Style.FILL);
        } else {
            this.bjh.setStyle(Paint.Style.STROKE);
        }
        if (this.fgz) {
            this.fgv.left = this.mMarginLeft + f;
            this.fgv.top = (i4 - this.fgx) + this.fgA;
            this.fgv.right = this.fgw + f + this.mMarginLeft;
            this.fgv.bottom = this.fgA + i4;
        } else {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (!com.baidu.tbadk.core.elementsMaven.view.a.k(charSequence)) {
                dimenPixelSize = 0 + UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            } else {
                com.baidu.tbadk.core.elementsMaven.view.a.a(fontMetricsInt, (int) paint.getTextSize());
                dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            }
            int i6 = dimenPixelSize + fontMetricsInt.ascent + i4;
            this.fgv.left = this.mMarginLeft + f;
            this.fgv.top = i6;
            this.fgv.right = this.fgw + f + this.mMarginLeft;
            this.fgv.bottom = i6 + this.fgx;
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
            this.bjh.setShader(new LinearGradient(this.fgv.left, this.fgv.top, this.fgv.right, this.fgv.bottom, color, color2, Shader.TileMode.CLAMP));
        }
        Path path = new Path();
        path.addRoundRect(this.fgv, this.fgt, Path.Direction.CW);
        canvas.drawPath(path, this.bjh);
        this.bjh.setShader(null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if ((skinType == 1 || skinType == 4) && this.identify != null) {
            this.bjh.setColor(com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.mask));
            if (this.fgy) {
                this.bjh.setStyle(Paint.Style.FILL);
            } else {
                this.bjh.setStyle(Paint.Style.STROKE);
            }
            Path path2 = new Path();
            path2.addRoundRect(this.fgv, this.fgt, Path.Direction.CW);
            canvas.drawPath(path2, this.bjh);
        }
        Paint.FontMetricsInt fontMetricsInt2 = this.bjh.getFontMetricsInt();
        if (this.dCF != 0) {
            this.bjh.setColor(ap.getColor(this.dCF));
        } else {
            this.bjh.setColor(com.baidu.tbadk.core.util.f.c.a.getResources().getColor(R.color.CAM_X0201));
        }
        this.bjh.setStyle(Paint.Style.FILL);
        canvas.drawText(charSequence, i, i2, this.dyJ + f + this.mMarginLeft, (int) ((this.fgv.centerY() + ((fontMetricsInt2.bottom - fontMetricsInt2.top) / 2)) - fontMetricsInt2.bottom), this.bjh);
    }

    public void jW(boolean z) {
        if (this.bjh != null) {
            this.fgy = z;
            if (z) {
                this.bjh.setStyle(Paint.Style.FILL);
            } else {
                this.bjh.setStyle(Paint.Style.STROKE);
            }
        }
    }

    public void pm(int i) {
        Arrays.fill(this.fgt, i);
    }

    public void po(int i) {
        float[] aI = com.baidu.tbadk.core.elementsMaven.a.aI(i);
        if (!Arrays.equals(this.fgt, aI)) {
            this.fgt = aI;
        }
    }

    public void BF(String str) {
        this.identify = str;
    }
}
