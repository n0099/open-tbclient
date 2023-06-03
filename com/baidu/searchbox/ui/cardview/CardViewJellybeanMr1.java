package com.baidu.searchbox.ui.cardview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.baidu.searchbox.ui.cardview.RoundRectDrawableWithShadow;
/* loaded from: classes4.dex */
public class CardViewJellybeanMr1 extends CardViewGingerbread {
    @Override // com.baidu.searchbox.ui.cardview.CardViewGingerbread, com.baidu.searchbox.ui.cardview.CardViewImpl
    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectDrawableWithShadow.RoundRectHelper() { // from class: com.baidu.searchbox.ui.cardview.CardViewJellybeanMr1.1
            @Override // com.baidu.searchbox.ui.cardview.RoundRectDrawableWithShadow.RoundRectHelper
            public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
                canvas.drawRoundRect(rectF, f, f, paint);
            }
        };
    }
}
