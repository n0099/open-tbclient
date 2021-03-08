package com.baidu.live.adp.newwidget.imageview;

import android.graphics.Canvas;
import android.widget.ImageView;
/* loaded from: classes10.dex */
public class NoColorFilterCommonDrawer extends CommonDrawer {
    @Override // com.baidu.live.adp.newwidget.imageview.CommonDrawer, com.baidu.live.adp.newwidget.imageview.AbsDrawer
    public void drawContentReal(Canvas canvas, DisplayImage displayImage, ImageView imageView) {
        this.mPaint.setColorFilter(null);
        super.drawContentReal(canvas, displayImage, imageView);
    }
}
