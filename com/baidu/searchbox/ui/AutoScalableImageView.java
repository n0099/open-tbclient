package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class AutoScalableImageView extends ImageView {
    public Matrix mDrawMatrix;
    public boolean mHaveFrame;
    public Gravity mImageGravity;
    public boolean mLayoutFlag;
    public Matrix mMatrix;

    /* loaded from: classes4.dex */
    public enum Gravity {
        CENTER,
        CENTER_HORIZONTAL,
        CENTER_VERTICAL
    }

    /* renamed from: com.baidu.searchbox.ui.AutoScalableImageView$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$AutoScalableImageView$Gravity;

        static {
            int[] iArr = new int[Gravity.values().length];
            $SwitchMap$com$baidu$searchbox$ui$AutoScalableImageView$Gravity = iArr;
            try {
                iArr[Gravity.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$AutoScalableImageView$Gravity[Gravity.CENTER_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$AutoScalableImageView$Gravity[Gravity.CENTER_VERTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public AutoScalableImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mDrawMatrix = null;
        this.mHaveFrame = false;
        this.mImageGravity = Gravity.CENTER_HORIZONTAL;
        this.mLayoutFlag = true;
        init();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mDrawMatrix == null) {
            super.onDraw(canvas);
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int saveCount = canvas.getSaveCount();
            canvas.concat(this.mDrawMatrix);
            drawable.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        super.setImageDrawable(drawable);
        if (drawable != drawable2) {
            configureBounds();
        }
    }

    public void setImageDrawableWithoutLayout(Drawable drawable) {
        this.mLayoutFlag = false;
        setImageDrawable(drawable);
        this.mLayoutFlag = true;
    }

    public void setImageGravity(Gravity gravity) {
        this.mImageGravity = gravity;
    }

    public AutoScalableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mDrawMatrix = null;
        this.mHaveFrame = false;
        this.mImageGravity = Gravity.CENTER_HORIZONTAL;
        this.mLayoutFlag = true;
        init();
    }

    public AutoScalableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mDrawMatrix = null;
        this.mHaveFrame = false;
        this.mImageGravity = Gravity.CENTER_HORIZONTAL;
        this.mLayoutFlag = true;
        init();
    }

    private void configureBounds() {
        boolean z;
        float f;
        float f2;
        float f3;
        Drawable drawable = getDrawable();
        if (drawable != null && this.mHaveFrame) {
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight > 0 && intrinsicWidth > 0 && width != 0 && height != 0) {
                if ((intrinsicWidth >= 0 && width != intrinsicWidth) || (intrinsicHeight >= 0 && height != intrinsicHeight)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    this.mDrawMatrix = null;
                    return;
                }
                drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                if (intrinsicWidth * height > width * intrinsicHeight) {
                    f = height / intrinsicHeight;
                    f3 = (width - (intrinsicWidth * f)) * 0.5f;
                    f2 = 0.0f;
                } else {
                    f = width / intrinsicWidth;
                    f2 = (height - (intrinsicHeight * f)) * 0.5f;
                    f3 = 0.0f;
                }
                this.mMatrix.reset();
                this.mMatrix.setScale(f, f);
                int i = AnonymousClass1.$SwitchMap$com$baidu$searchbox$ui$AutoScalableImageView$Gravity[this.mImageGravity.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            this.mDrawMatrix = null;
                            return;
                        }
                        this.mMatrix.postTranslate(0.0f, (int) (f2 + 0.5f));
                        this.mDrawMatrix = this.mMatrix;
                        return;
                    }
                    this.mMatrix.postTranslate((int) (f3 + 0.5f), 0.0f);
                    this.mDrawMatrix = this.mMatrix;
                    return;
                }
                this.mMatrix.postTranslate((int) (f3 + 0.5f), (int) (f2 + 0.5f));
                this.mDrawMatrix = this.mMatrix;
                return;
            }
            this.mDrawMatrix = null;
        }
    }

    private void init() {
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override // android.view.View
    public void requestLayout() {
        if (this.mLayoutFlag) {
            super.requestLayout();
        }
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        this.mHaveFrame = true;
        configureBounds();
        return frame;
    }
}
