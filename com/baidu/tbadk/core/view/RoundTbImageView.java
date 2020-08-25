package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class RoundTbImageView extends TbClipImageView {
    private float epI;
    private float epJ;
    private int height;
    private int mDefaultBgId;
    private int mDefaultId;
    private int mMaskColor;
    private Paint mPaint;
    private int width;

    public RoundTbImageView(Context context) {
        this(context, null, 0);
    }

    public RoundTbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundTbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaskColor = 0;
        this.mDefaultId = R.drawable.transparent_bg;
        this.mDefaultBgId = R.color.cp_bg_line_j;
        init();
    }

    private void init() {
        setDrawerType(1);
        setIsRound(true);
        setConrers(15);
        setGifIconSupport(false);
        setDrawBorder(false);
        setBorderSurroundContent(false);
        setDefaultBgResource(this.mDefaultBgId);
        setDefaultResource(this.mDefaultId);
        setAutoChangeStyle(true);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        setPlaceHolder(1);
        this.mPaint = new Paint();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void startLogPerf() {
        if (!this.canLogPerf) {
            this.canLogPerf = true;
        } else if (this.eXr != null && this.eXr.eRI) {
            this.eXr.bui();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null && this.mMaskColor != 0) {
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawCircle(this.epI, this.epJ, this.epI, this.mPaint);
        }
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
        this.epI = this.width / 2.0f;
        this.epJ = this.height / 2.0f;
    }
}
