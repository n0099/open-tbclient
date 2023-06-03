package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.baidu.android.util.devices.DeviceUtil;
/* loaded from: classes4.dex */
public class CircularImageView extends MaskedImageView {
    public static final int DIVIINDG = 1;
    public static final int IMAGE_COLOR = -16777216;
    public boolean mRemoveDividing;

    public CircularImageView(Context context) {
        super(context);
        this.mRemoveDividing = false;
    }

    public void setIsRemoveDividing(boolean z) {
        this.mRemoveDividing = z;
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRemoveDividing = false;
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRemoveDividing = false;
    }

    @Override // com.baidu.searchbox.ui.MaskedImageView
    public Bitmap createMask() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint(1);
            paint.setColor(-16777216);
            int i = 0;
            if (this.mRemoveDividing) {
                i = DeviceUtil.ScreenInfo.dp2px(UIRuntime.getAppContext(), 1.0f);
            }
            canvas.drawOval(new RectF(getPaddingLeft() + i, getPaddingTop() + i, (getWidth() - getPaddingRight()) - i, (getHeight() - getPaddingBottom()) - i), paint);
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }
}
