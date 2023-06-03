package com.baidu.searchbox.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import com.baidu.android.util.devices.DeviceUtil;
/* loaded from: classes4.dex */
public class ScaleClipBitmapDrawable extends BitmapDrawable {
    public Gravity mGravity;
    public Matrix mMatrix;
    public Paint mPaint;

    /* loaded from: classes4.dex */
    public enum Gravity {
        CENTER,
        CENTER_HORIZONTAL,
        CENTER_VERTICAL
    }

    /* renamed from: com.baidu.searchbox.ui.ScaleClipBitmapDrawable$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$ScaleClipBitmapDrawable$Gravity;

        static {
            int[] iArr = new int[Gravity.values().length];
            $SwitchMap$com$baidu$searchbox$ui$ScaleClipBitmapDrawable$Gravity = iArr;
            try {
                iArr[Gravity.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$ScaleClipBitmapDrawable$Gravity[Gravity.CENTER_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$ScaleClipBitmapDrawable$Gravity[Gravity.CENTER_VERTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ScaleClipBitmapDrawable(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
        this.mMatrix = new Matrix();
        this.mPaint = new Paint();
        this.mGravity = Gravity.CENTER_HORIZONTAL;
    }

    public ScaleClipBitmapDrawable(Bitmap bitmap) {
        super(bitmap);
        this.mMatrix = new Matrix();
        this.mPaint = new Paint();
        this.mGravity = Gravity.CENTER_HORIZONTAL;
    }

    public static ScaleClipBitmapDrawable newInstance(BitmapDrawable bitmapDrawable) {
        if (bitmapDrawable != null) {
            ScaleClipBitmapDrawable scaleClipBitmapDrawable = new ScaleClipBitmapDrawable(UIRuntime.getAppContext().getResources(), bitmapDrawable.getBitmap());
            scaleClipBitmapDrawable.setDrawableGravity(Gravity.CENTER_HORIZONTAL);
            scaleClipBitmapDrawable.setClipMatrix(DeviceUtil.ScreenInfo.getDisplayWidth(UIRuntime.getAppContext()), DeviceUtil.ScreenInfo.getDisplayHeight(UIRuntime.getAppContext()));
            return scaleClipBitmapDrawable;
        }
        return null;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBitmap() != null) {
            canvas.drawBitmap(getBitmap(), this.mMatrix, this.mPaint);
        } else {
            super.draw(canvas);
        }
    }

    public void setDrawableGravity(Gravity gravity) {
        this.mGravity = gravity;
    }

    public void setClipMatrix(float f, float f2) {
        float intrinsicHeight = getIntrinsicHeight();
        float intrinsicWidth = getIntrinsicWidth();
        if (intrinsicHeight != 0.0f && intrinsicWidth != 0.0f) {
            float max = Math.max(f / intrinsicWidth, f2 / intrinsicHeight);
            if (max < 1.0f) {
                max = 1.0f;
            }
            float f3 = intrinsicWidth * max;
            float f4 = intrinsicHeight * max;
            this.mMatrix.reset();
            this.mMatrix.setScale(max, max);
            int i = AnonymousClass1.$SwitchMap$com$baidu$searchbox$ui$ScaleClipBitmapDrawable$Gravity[this.mGravity.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.mMatrix.postTranslate(0.0f, (f2 - f4) / 2.0f);
                        return;
                    }
                    return;
                }
                this.mMatrix.postTranslate((f - f3) / 2.0f, 0.0f);
                return;
            }
            this.mMatrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
        }
    }
}
