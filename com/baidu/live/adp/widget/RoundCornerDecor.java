package com.baidu.live.adp.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
/* loaded from: classes10.dex */
public interface RoundCornerDecor {
    void draw(Canvas canvas);

    void setBounds(int i, int i2, int i3, int i4);

    void setColorFilterForSkin(ColorFilter colorFilter);

    void setRadius(int i);
}
