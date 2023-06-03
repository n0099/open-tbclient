package com.baidu.searchbox.ui;

import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import com.baidu.android.util.devices.DeviceUtil;
/* loaded from: classes4.dex */
public class ColorDrawableEx extends ColorDrawable {
    public ColorDrawableEx() {
    }

    public ColorDrawableEx(int i) {
        super(i);
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (DeviceUtil.OSInfo.hasHoneycomb()) {
            super.draw(canvas);
            return;
        }
        canvas.save();
        canvas.clipRect(getBounds());
        super.draw(canvas);
        canvas.restore();
    }
}
