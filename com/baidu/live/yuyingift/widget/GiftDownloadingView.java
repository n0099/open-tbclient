package com.baidu.live.yuyingift.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class GiftDownloadingView extends View {
    protected Paint backgroundPaint;
    protected int currentProgress;
    protected Paint foregroundPaint;
    private RectF oval;
    private int padding;
    private float strokeWidth;

    public GiftDownloadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.strokeWidth = 5.0f;
        initVariable();
    }

    protected void initVariable() {
        this.padding = BdUtilHelper.dip2px(getContext(), 2.0f);
        this.strokeWidth = BdUtilHelper.dip2px(getContext(), 2.0f);
        this.oval = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.foregroundPaint = new Paint();
        this.foregroundPaint.setAntiAlias(true);
        this.foregroundPaint.setDither(true);
        this.foregroundPaint.setStyle(Paint.Style.STROKE);
        this.foregroundPaint.setStrokeCap(Paint.Cap.ROUND);
        this.foregroundPaint.setStrokeWidth(this.strokeWidth);
        this.foregroundPaint.setColor(Color.parseColor("#96979E"));
        this.backgroundPaint = new Paint();
        this.backgroundPaint.setAntiAlias(true);
        this.backgroundPaint.setDither(true);
        this.backgroundPaint.setStyle(Paint.Style.FILL);
        this.backgroundPaint.setStrokeCap(Paint.Cap.ROUND);
        this.backgroundPaint.setStrokeWidth(this.strokeWidth);
        this.backgroundPaint.setColor(Color.parseColor("#2D303E"));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.currentProgress >= 0) {
            this.oval.left = this.strokeWidth + this.padding;
            this.oval.top = this.strokeWidth + this.padding;
            this.oval.right = (getWidth() - this.strokeWidth) - this.padding;
            this.oval.bottom = (getHeight() - this.strokeWidth) - this.padding;
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth() / 2, getHeight() / 2), this.backgroundPaint);
            canvas.drawArc(this.oval, -90.0f, 360.0f * (this.currentProgress / 100.0f), false, this.foregroundPaint);
        }
    }

    public void setProgress(int i) {
        this.currentProgress = i;
        if (this.currentProgress >= 0 && this.currentProgress < 100) {
            setVisibility(0);
            if (this.currentProgress == 0) {
                this.foregroundPaint.reset();
                this.backgroundPaint.reset();
                this.foregroundPaint.setColor(0);
                this.backgroundPaint.setColor(0);
                setBackgroundResource(a.e.yuyin_live_gift_panel_item_script_download);
            } else {
                setBackgroundResource(0);
                initVariable();
            }
            postInvalidate();
            return;
        }
        setBackgroundResource(0);
        setVisibility(8);
    }
}
