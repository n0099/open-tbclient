package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends ReplacementSpan {
    private int dox;
    private int eRA;
    private int eRB;
    private int eRw;
    private int eRx;
    private int eRy;
    private String identify;
    private int mMarginLeft;
    private int mMarginRight;
    private int mTextColorId;
    private int mTextSize;
    private RectF eRz = new RectF();
    private Paint mTextPaint = new Paint();

    public b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.eRw = i;
        this.eRx = i2;
        this.eRy = i3;
        this.mTextSize = i4;
        this.mTextColorId = i5;
        this.dox = i6;
        this.eRB = i7;
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setStyle(Paint.Style.STROKE);
        this.mTextPaint.setTextSize(this.mTextSize);
    }

    public void pD(int i) {
        this.mMarginLeft = i;
    }

    public void setMarginRight(int i) {
        this.mMarginRight = i;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.eRA = ((int) this.mTextPaint.measureText(charSequence, i, i2)) + (this.dox * 2);
        return this.eRA + this.mMarginLeft + this.mMarginRight;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        int color;
        int color2;
        this.mTextPaint.setColor(ap.getColor(this.eRy));
        int i6 = ((i5 - this.eRB) / 2) + i3;
        this.eRz.left = this.mMarginLeft + f;
        this.eRz.top = i6;
        this.eRz.right = this.eRA + f + this.mMarginLeft;
        this.eRz.bottom = i6 + this.eRB;
        if (this.identify != null) {
            if (" 吧主".equals(this.identify)) {
                color = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.ba_zhu_start);
                color2 = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.ba_zhu_end);
            } else if (" 小吧主".equals(this.identify)) {
                color = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.xiao_ba_zhu_start);
                color2 = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.xiao_ba_zhu_end);
            } else if (" 楼主".equals(this.identify)) {
                color = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.floor_host_start);
                color2 = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.floor_host_end);
            } else {
                color = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.floor_host_end);
                color2 = com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.floor_host_end);
            }
            this.mTextPaint.setShader(new LinearGradient(this.eRz.left, this.eRz.top, this.eRz.right, this.eRz.bottom, color, color2, Shader.TileMode.CLAMP));
        }
        canvas.drawRoundRect(this.eRz, this.eRx, this.eRx, this.mTextPaint);
        this.mTextPaint.setShader(null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if ((skinType == 1 || skinType == 4) && this.identify != null) {
            this.mTextPaint.setColor(com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.mask));
            canvas.drawRoundRect(this.eRz, this.eRx, this.eRx, this.mTextPaint);
        }
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        if (this.identify != null) {
            this.mTextPaint.setColor(com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.cp_bg_line_d));
        } else {
            this.mTextPaint.setColor(ap.getColor(this.mTextColorId));
        }
        canvas.drawText(charSequence, i, i2, this.dox + f + this.mMarginLeft, (int) ((this.eRz.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.mTextPaint);
    }

    public void jk(boolean z) {
        if (this.mTextPaint != null) {
            if (z) {
                this.mTextPaint.setStyle(Paint.Style.FILL);
            } else {
                this.mTextPaint.setStyle(Paint.Style.STROKE);
            }
        }
    }

    public void pE(int i) {
        this.eRx = i;
    }

    public void Co(String str) {
        this.identify = str;
    }
}
