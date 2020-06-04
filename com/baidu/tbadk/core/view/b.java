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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends ReplacementSpan {
    private int dSl;
    private int dSm;
    private int dSn;
    private int dSp;
    private int dSq;
    private int dSr;
    private String identify;
    private int mTextColorId;
    private int mTextSize;
    private RectF dSo = new RectF();
    private Paint mTextPaint = new Paint();

    public b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.dSl = i;
        this.dSm = i2;
        this.dSn = i3;
        this.mTextSize = i4;
        this.mTextColorId = i5;
        this.dSp = i6;
        this.dSr = i7;
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setStyle(Paint.Style.STROKE);
        this.mTextPaint.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.dSq = ((int) this.mTextPaint.measureText(charSequence, i, i2)) + (this.dSp * 2);
        return this.dSq;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        int color;
        int color2;
        this.mTextPaint.setColor(am.getColor(this.dSn));
        int i6 = ((i5 - this.dSr) / 2) + i3;
        this.dSo.left = f;
        this.dSo.top = i6;
        this.dSo.right = this.dSq + f;
        this.dSo.bottom = i6 + this.dSr;
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
            this.mTextPaint.setShader(new LinearGradient(this.dSo.left, this.dSo.top, this.dSo.right, this.dSo.bottom, color, color2, Shader.TileMode.CLAMP));
        }
        canvas.drawRoundRect(this.dSo, this.dSm, this.dSm, this.mTextPaint);
        this.mTextPaint.setShader(null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if ((skinType == 1 || skinType == 4) && this.identify != null) {
            this.mTextPaint.setColor(com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.mask));
            canvas.drawRoundRect(this.dSo, this.dSm, this.dSm, this.mTextPaint);
        }
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        if (this.identify != null) {
            this.mTextPaint.setColor(com.baidu.tbadk.core.util.e.c.a.getResources().getColor(R.color.cp_bg_line_d));
        } else {
            this.mTextPaint.setColor(am.getColor(this.mTextColorId));
        }
        canvas.drawText(charSequence, i, i2, f + this.dSp, (int) ((this.dSo.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.mTextPaint);
    }

    public void hh(boolean z) {
        if (this.mTextPaint != null) {
            if (z) {
                this.mTextPaint.setStyle(Paint.Style.FILL);
            } else {
                this.mTextPaint.setStyle(Paint.Style.STROKE);
            }
        }
    }

    public void lJ(int i) {
        this.dSm = i;
    }

    public void wO(String str) {
        this.identify = str;
    }
}
