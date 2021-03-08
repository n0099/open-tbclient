package com.baidu.live.tieba.view.fresco;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
/* loaded from: classes10.dex */
public class SimpleDraweeView extends com.facebook.drawee.view.SimpleDraweeView {
    public SimpleDraweeView(Context context) {
        super(context);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (getDrawable() != null) {
            getDrawable().setVisible(true, false);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
