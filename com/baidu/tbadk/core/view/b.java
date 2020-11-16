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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes.dex */
public class b extends ReplacementSpan {
    private int dmN;
    private int eQB;
    private int eQC;
    private boolean eQD;
    private int eQx;
    private int eQz;
    private String identify;
    private int mMarginLeft;
    private int mMarginRight;
    private int mTextColorId;
    private Paint mTextPaint;
    private int mTextSize;
    private float[] eQy = new float[8];
    private RectF eQA = new RectF();

    public b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.eQx = i;
        if (i2 > 0) {
            qc(i2);
        }
        this.eQz = i3;
        this.mTextSize = i4;
        this.mTextColorId = i5;
        this.dmN = i6;
        this.eQC = i7;
        this.mTextPaint = new Paint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setStyle(Paint.Style.STROKE);
        this.mTextPaint.setTextSize(this.mTextSize);
    }

    public void qa(int i) {
        this.mMarginLeft = i;
    }

    public void setMarginRight(int i) {
        this.mMarginRight = i;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.eQB = ((int) this.mTextPaint.measureText(charSequence, i, i2)) + (this.dmN * 2);
        return this.eQB + this.mMarginLeft + this.mMarginRight;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        int color;
        int color2;
        this.mTextPaint.setColor(ap.getColor(this.eQz));
        if (this.eQD) {
            this.mTextPaint.setStyle(Paint.Style.FILL);
        } else {
            this.mTextPaint.setStyle(Paint.Style.STROKE);
        }
        int i6 = ((i5 - this.eQC) / 2) + i3;
        this.eQA.left = this.mMarginLeft + f;
        this.eQA.top = i6;
        this.eQA.right = this.eQB + f + this.mMarginLeft;
        this.eQA.bottom = i6 + this.eQC;
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
            this.mTextPaint.setShader(new LinearGradient(this.eQA.left, this.eQA.top, this.eQA.right, this.eQA.bottom, color, color2, Shader.TileMode.CLAMP));
        }
        Path path = new Path();
        path.addRoundRect(this.eQA, this.eQy, Path.Direction.CW);
        canvas.drawPath(path, this.mTextPaint);
        this.mTextPaint.setShader(null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if ((skinType == 1 || skinType == 4) && this.identify != null) {
            this.mTextPaint.setColor(com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.mask));
            if (this.eQD) {
                this.mTextPaint.setStyle(Paint.Style.FILL);
            } else {
                this.mTextPaint.setStyle(Paint.Style.STROKE);
            }
            Path path2 = new Path();
            path2.addRoundRect(this.eQA, this.eQy, Path.Direction.CW);
            canvas.drawPath(path2, this.mTextPaint);
        }
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        if (this.mTextColorId != 0) {
            this.mTextPaint.setColor(ap.getColor(this.mTextColorId));
        } else {
            this.mTextPaint.setColor(com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.CAM_X0201));
        }
        this.mTextPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(charSequence, i, i2, this.dmN + f + this.mMarginLeft, (int) ((this.eQA.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.mTextPaint);
    }

    public void jl(boolean z) {
        if (this.mTextPaint != null) {
            this.eQD = z;
            if (z) {
                this.mTextPaint.setStyle(Paint.Style.FILL);
            } else {
                this.mTextPaint.setStyle(Paint.Style.STROKE);
            }
        }
    }

    public void qb(int i) {
        Arrays.fill(this.eQy, i);
    }

    public void qc(int i) {
        float[] aD = com.baidu.tbadk.core.elementsMaven.a.aD(i);
        if (!Arrays.equals(this.eQy, aD)) {
            this.eQy = aD;
        }
    }

    public void BN(String str) {
        this.identify = str;
    }
}
