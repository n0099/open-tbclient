package com.baidu.nadcore.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.nadcore.widget.IAdImageView;
import com.baidu.tieba.ic1;
import com.baidu.tieba.nc1;
import com.baidu.tieba.yb1;
/* loaded from: classes3.dex */
public class AdImageView extends AppCompatImageView implements IAdImageView {
    public final nc1 a;
    public IAdImageView.ImageScaleType b;
    public final Path c;

    public AdImageView(@NonNull Context context) {
        this(context, null);
    }

    public void r(String str) {
        A(str, true);
    }

    public void setImageScaleType(IAdImageView.ImageScaleType imageScaleType) {
        if (imageScaleType != null) {
            if (this.b != imageScaleType) {
                this.b = imageScaleType;
                requestLayout();
                invalidate();
                return;
            }
            return;
        }
        throw null;
    }

    public void setPlaceHolderDrawable(Drawable drawable) {
        this.a.b = drawable;
    }

    public AdImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void A(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            setImageBitmap(null);
        } else {
            yb1.a().a(str, this, z);
        }
    }

    public void setBorder(float f, @ColorInt int i) {
        nc1.a aVar = this.a.d;
        if (aVar == null) {
            aVar = new nc1.a();
        }
        aVar.c = f;
        aVar.d = i;
        this.a.d = aVar;
    }

    public AdImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new nc1();
        this.c = new Path();
        B(attributeSet);
    }

    public void b(String str, int i, int i2) {
        yb1.a().b(str, this, i, i2);
    }

    public final void B(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, ic1.AdImageView);
        int resourceId = obtainStyledAttributes.getResourceId(5, 0);
        if (resourceId != 0) {
            this.a.a = resourceId;
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(4, 0);
        if (resourceId2 != 0) {
            this.a.c = resourceId2;
        }
        nc1.a aVar = new nc1.a();
        if (obtainStyledAttributes.getBoolean(3, false)) {
            aVar.a = true;
        } else {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize > 0) {
                float floatValue = Integer.valueOf(dimensionPixelSize).floatValue();
                aVar.b = new float[]{floatValue, floatValue, floatValue, floatValue};
            } else {
                aVar.b = new float[]{obtainStyledAttributes.getDimensionPixelSize(8, 0), obtainStyledAttributes.getDimensionPixelSize(11, 0), obtainStyledAttributes.getDimensionPixelSize(7, 0), obtainStyledAttributes.getDimensionPixelSize(10, 0)};
            }
        }
        this.a.d = aVar;
        int i = obtainStyledAttributes.getInt(6, -1);
        if (i >= 0) {
            setScaleType(IAdImageView.l0[i]);
        }
        obtainStyledAttributes.recycle();
    }

    @NonNull
    public nc1 getConfig() {
        return this.a;
    }

    public IAdImageView.ImageScaleType getImageScaleType() {
        return this.b;
    }

    public void setCircle() {
        nc1.a aVar = this.a.d;
        if (aVar == null) {
            aVar = new nc1.a();
        }
        aVar.a = true;
        this.a.d = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        nc1.a aVar = getConfig().d;
        if (aVar == null) {
            super.onDraw(canvas);
            return;
        }
        int width = getWidth();
        int height = getHeight();
        if (aVar.a) {
            this.c.addCircle(width / 2.0f, height / 2.0f, Math.min(width, height) / 2, Path.Direction.CCW);
            canvas.clipPath(this.c);
            super.onDraw(canvas);
            return;
        }
        float[] fArr = aVar.b;
        if (fArr == null) {
            super.onDraw(canvas);
            return;
        }
        float max = Math.max(fArr[0], fArr[2]) + Math.max(fArr[1], fArr[3]);
        float max2 = Math.max(fArr[0], fArr[1]) + Math.max(fArr[2], fArr[3]);
        float f = width;
        if (f >= max) {
            float f2 = height;
            if (f2 > max2) {
                this.c.moveTo(fArr[0], 0.0f);
                this.c.lineTo(f - fArr[1], 0.0f);
                this.c.quadTo(f, 0.0f, f, fArr[1]);
                this.c.lineTo(f, f2 - fArr[3]);
                this.c.quadTo(f, f2, f - fArr[3], f2);
                this.c.lineTo(fArr[2], f2);
                this.c.quadTo(0.0f, f2, 0.0f, f2 - fArr[2]);
                this.c.lineTo(0.0f, fArr[0]);
                this.c.quadTo(0.0f, 0.0f, fArr[0], 0.0f);
                canvas.clipPath(this.c);
            }
        }
        super.onDraw(canvas);
    }

    public void setRadius(float f, float f2, float f3, float f4) {
        nc1.a aVar = this.a.d;
        if (aVar == null) {
            aVar = new nc1.a();
        }
        aVar.a = false;
        aVar.b = new float[]{f, f2, f3, f4};
        this.a.d = aVar;
    }
}
