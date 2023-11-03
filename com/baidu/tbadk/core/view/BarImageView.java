package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.qf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BarImageView extends TbClipImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public Path c;
    public Path d;
    public int e;
    public int f;
    public boolean g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public Bitmap l;
    public Bitmap m;
    public Bitmap n;
    public Canvas o;
    public PaintFlagsDrawFilter p;
    public PorterDuffXfermode q;
    public PorterDuffXfermode r;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BarImageView(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BarImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = SkinManager.getColor(R.color.CAM_X0209);
        this.b = R.drawable.pic_use_header_28_n;
        this.c = new Path();
        this.d = new Path();
        this.e = 0;
        this.f = 0;
        this.i = false;
        this.j = false;
        this.k = true;
        this.q = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.r = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        init();
    }

    private int getStrokeColorResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public int getStrokeWith() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setDrawerType(0);
            setGifIconSupport(false);
            setDrawBorder(true);
            setDefaultResource(this.a);
            setDefaultBgResource(this.b);
        }
    }

    public final void c(Canvas canvas, int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, Integer.valueOf(i), Float.valueOf(f)}) == null) {
            this.d.reset();
            float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
            float f2 = i / 2;
            this.d.moveTo(f2, strokeWith);
            float f3 = i - strokeWith;
            float f4 = f3 - f;
            float f5 = f + strokeWith;
            this.d.cubicTo(f4, strokeWith, f3, f5, f3, f2);
            this.d.cubicTo(f3, f4, f4, f3, f2, f3);
            this.d.cubicTo(f5, f3, strokeWith, f4, strokeWith, f2);
            this.d.cubicTo(strokeWith, f5, f5, strokeWith, f2, strokeWith);
            this.d.close();
            float strokeWidth = this.mDrawer.d.getStrokeWidth();
            this.mDrawer.d.setStyle(Paint.Style.STROKE);
            this.mDrawer.d.setStrokeWidth(getStrokeWith() + 0.5f);
            this.mDrawer.d.setColor(SkinManager.getColor(getStrokeColorResId()));
            if (this.g) {
                this.mDrawer.d.setColor(this.h);
            }
            canvas.drawPath(this.d, this.mDrawer.d);
            this.mDrawer.d.setStrokeWidth(strokeWidth);
        }
    }

    public final Bitmap d(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Paint paint;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Path path = this.c;
            if (z) {
                paint = this.mDrawer.d;
            } else {
                paint = this.mDrawer.c;
            }
            canvas.drawPath(path, paint);
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            qf qfVar = this.mDrawer;
            if (qfVar != null && qfVar.c != null) {
                if (!this.i) {
                    super.onDraw(canvas);
                    return;
                }
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                float f5 = (measuredWidth * 14) / 130;
                this.c.reset();
                float f6 = measuredWidth;
                float f7 = (f6 + 0.0f) / 2.0f;
                float f8 = measuredHeight;
                float f9 = (f8 + 0.0f) / 2.0f;
                this.c.moveTo(f7, 0.0f);
                float f10 = f6 - f5;
                this.c.cubicTo(f10, 0.0f, f6, f5, f6, f9);
                this.c.cubicTo(f6, f10, f10, f6, f7, f8);
                this.c.cubicTo(f5, f6, 0.0f, f10, 0.0f, f9);
                this.c.cubicTo(0.0f, f5, f5, 0.0f, f7, 0.0f);
                this.c.close();
                this.mDrawer.d.setStyle(Paint.Style.FILL);
                this.mDrawer.d.setColor(SkinManager.getColor(this.f));
                if (this.g) {
                    this.mDrawer.d.setColor(this.h);
                }
                this.n = d(measuredWidth, measuredHeight, true);
                this.c.reset();
                float strokeWith = getStrokeWith();
                float f11 = measuredWidth / 2;
                this.c.moveTo(f11, strokeWith);
                float f12 = f6 - strokeWith;
                float f13 = f12 - f5;
                float f14 = strokeWith + f5;
                this.c.cubicTo(f13, strokeWith, f12, f14, f12, f11);
                this.c.cubicTo(f12, f13, f13, f12, f11, f12);
                this.c.cubicTo(f14, f12, strokeWith, f13, strokeWith, f11);
                this.c.cubicTo(strokeWith, f14, f14, strokeWith, f11, strokeWith);
                this.c.close();
                if (this.p == null) {
                    this.p = new PaintFlagsDrawFilter(0, 3);
                }
                canvas.setDrawFilter(this.p);
                if (this.l == null) {
                    this.l = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                }
                if (this.o == null) {
                    this.o = new Canvas(this.l);
                }
                this.mDrawer.d.setStyle(Paint.Style.STROKE);
                super.onDraw(this.o);
                this.m = d(measuredWidth, measuredHeight, false);
                if (this.k) {
                    f = f8;
                    f4 = 0.0f;
                    f2 = f6;
                    f3 = f5;
                    int saveLayer = canvas.saveLayer(0.0f, 0.0f, f6, f, null, 31);
                    this.mDrawer.d.setStyle(Paint.Style.FILL);
                    this.mDrawer.d.setColor(SkinManager.getColor(this.f));
                    if (this.g) {
                        this.mDrawer.d.setColor(this.h);
                    }
                    canvas.drawBitmap(this.m, 0.0f, 0.0f, this.mDrawer.d);
                    this.mDrawer.d.setXfermode(this.r);
                    canvas.drawBitmap(this.n, 0.0f, 0.0f, this.mDrawer.d);
                    this.mDrawer.d.setXfermode(null);
                    if (saveLayer >= 1 && saveLayer <= canvas.getSaveCount()) {
                        canvas.restoreToCount(saveLayer);
                    }
                } else {
                    f = f8;
                    f2 = f6;
                    f3 = f5;
                    f4 = 0.0f;
                }
                int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, f2, f, null, 31);
                canvas.drawBitmap(this.m, f4, f4, this.mDrawer.c);
                this.mDrawer.c.setXfermode(this.q);
                canvas.drawBitmap(this.l, f4, f4, this.mDrawer.c);
                this.mDrawer.c.setXfermode(null);
                if (saveLayer2 >= 1 && saveLayer2 <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveLayer2);
                }
                if (this.j) {
                    c(canvas, measuredWidth, f3);
                    return;
                }
                return;
            }
            super.onDraw(canvas);
        }
    }

    public void setShowInnerBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.j = z;
        }
    }

    public void setShowOuterBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.k = z;
        }
    }

    public void setShowOval(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.i = z;
        }
    }

    public void setStrokeColorInt(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.h = i;
        }
    }

    public void setStrokeColorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f = i;
        }
    }

    public void setStrokeWith(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.e = i;
        }
    }

    public void setUseStrokeColorInt(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.g = z;
        }
    }
}
