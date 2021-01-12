package com.baidu.live.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class TbViewTagDrawer {
    public static final int DEFAULT_PADDING = 16;
    private int extraHeight;
    private int extraWidth;
    private int tagBGColor;
    private int tagDisX;
    private int tagDisY;
    private int tagTextColor;
    private int tagTextSize;
    protected final View view;
    protected final Paint tagPaint = new Paint();
    protected final Paint tagBGPaint = new Paint();

    private Context getContext() {
        return (this.view == null || this.view.getContext() == null) ? TbadkCoreApplication.getInst().getContext() : this.view.getContext();
    }

    public TbViewTagDrawer(View view) {
        this.tagDisY = 16;
        this.tagDisX = 16;
        this.tagTextColor = -1;
        this.tagBGColor = 1711276032;
        this.tagTextSize = 20;
        this.extraHeight = 16;
        this.extraWidth = 32;
        this.view = view;
        this.tagBGColor = getContext().getResources().getColor(a.c.sdk_black_alpha40);
        this.tagBGPaint.setColor(this.tagBGColor);
        this.tagBGPaint.setAntiAlias(true);
        this.tagTextSize = (int) getContext().getResources().getDimension(a.d.sdk_tbfontsize26);
        this.tagTextColor = getContext().getResources().getColor(a.c.sdk_cp_cont_i);
        this.tagPaint.setColor(this.tagTextColor);
        this.tagPaint.setTextSize(this.tagTextSize);
        this.tagPaint.setAntiAlias(true);
        this.tagDisY = BdUtilHelper.getDimens(getContext(), a.d.sdk_tbds20);
        this.tagDisX = BdUtilHelper.getDimens(getContext(), a.d.sdk_tbds20);
        this.extraHeight = BdUtilHelper.getDimens(getContext(), a.d.sdk_ds16);
        this.extraWidth = BdUtilHelper.getDimens(getContext(), a.d.sdk_tbds40);
    }

    public void drawBottomRightTag(Canvas canvas, String str) {
        if (canvas != null && this.view != null && !TextUtils.isEmpty(str)) {
            int save = canvas.save();
            this.view.getPaddingLeft();
            int paddingRight = this.view.getPaddingRight();
            this.view.getPaddingTop();
            int paddingBottom = this.view.getPaddingBottom();
            int left = this.view.getLeft();
            int right = this.view.getRight();
            int top = this.view.getTop();
            int bottom = this.view.getBottom();
            float measureText = this.tagPaint.measureText(str);
            float f = this.extraWidth + measureText;
            float f2 = this.tagTextSize + this.extraHeight;
            canvas.translate((((right - left) - paddingRight) - f) - this.tagDisX, (((bottom - top) - paddingBottom) - f2) - this.tagDisY);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, this.tagBGPaint);
            Paint.FontMetrics fontMetrics = this.tagPaint.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.tagPaint);
            canvas.restoreToCount(save);
        }
    }

    private void invalidate() {
        if (this.view != null) {
            this.view.invalidate();
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        this.tagDisX = i;
        this.tagDisY = i2;
        invalidate();
    }

    public void setTagBGColor(int i) {
        this.tagBGColor = i;
        this.tagBGPaint.setColor(i);
        invalidate();
    }

    public void setTagTextColor(int i) {
        this.tagTextColor = i;
        this.tagPaint.setColor(i);
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.tagTextSize = i;
        this.tagPaint.setTextSize(i);
        invalidate();
    }

    public float getTagHeight(String str) {
        return BdUtilHelper.measureText(this.tagPaint, str).height() + this.extraHeight;
    }

    public float getTagWidth(String str) {
        return BdUtilHelper.measureTextWidth(this.tagPaint, str) + this.extraWidth;
    }

    public void setExtraWH(int i, int i2) {
        this.extraWidth = i;
        this.extraHeight = i2;
    }
}
