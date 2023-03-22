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
import com.baidu.tieba.ik;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BarImageView extends TbClipImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Path A0;
    public int B0;
    public int C0;
    public boolean D0;
    public int E0;
    public boolean F0;
    public boolean G0;
    public boolean H0;
    public Bitmap I0;
    public Bitmap J0;
    public Bitmap K0;
    public Canvas L0;
    public PaintFlagsDrawFilter M0;
    public PorterDuffXfermode N0;
    public PorterDuffXfermode O0;
    public int x0;
    public int y0;
    public Path z0;

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
        this.x0 = SkinManager.getColor(R.color.CAM_X0209);
        this.y0 = R.drawable.pic_use_header_28_n;
        this.z0 = new Path();
        this.A0 = new Path();
        this.B0 = 0;
        this.C0 = 0;
        this.F0 = false;
        this.G0 = false;
        this.H0 = true;
        this.N0 = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.O0 = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        x();
    }

    private int getStrokeColorResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return this.C0;
        }
        return invokeV.intValue;
    }

    public int getStrokeWith() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.B0;
        }
        return invokeV.intValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            setDrawerType(0);
            setGifIconSupport(false);
            setDrawBorder(true);
            setDefaultResource(this.x0);
            setDefaultBgResource(this.y0);
        }
    }

    public final void T(Canvas canvas, int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, Integer.valueOf(i), Float.valueOf(f)}) == null) {
            this.A0.reset();
            float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
            float f2 = i / 2;
            this.A0.moveTo(f2, strokeWith);
            float f3 = i - strokeWith;
            float f4 = f3 - f;
            float f5 = f + strokeWith;
            this.A0.cubicTo(f4, strokeWith, f3, f5, f3, f2);
            this.A0.cubicTo(f3, f4, f4, f3, f2, f3);
            this.A0.cubicTo(f5, f3, strokeWith, f4, strokeWith, f2);
            this.A0.cubicTo(strokeWith, f5, f5, strokeWith, f2, strokeWith);
            this.A0.close();
            float strokeWidth = this.e.d.getStrokeWidth();
            this.e.d.setStyle(Paint.Style.STROKE);
            this.e.d.setStrokeWidth(getStrokeWith() + 0.5f);
            this.e.d.setColor(SkinManager.getColor(getStrokeColorResId()));
            if (this.D0) {
                this.e.d.setColor(this.E0);
            }
            canvas.drawPath(this.A0, this.e.d);
            this.e.d.setStrokeWidth(strokeWidth);
        }
    }

    public final Bitmap U(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Paint paint;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Path path = this.z0;
            if (z) {
                paint = this.e.d;
            } else {
                paint = this.e.c;
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
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            ik ikVar = this.e;
            if (ikVar != null && ikVar.c != null) {
                if (!this.F0) {
                    super.onDraw(canvas);
                    return;
                }
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                float f5 = (measuredWidth * 14) / 130;
                this.z0.reset();
                float f6 = measuredWidth;
                float f7 = (f6 + 0.0f) / 2.0f;
                float f8 = measuredHeight;
                float f9 = (f8 + 0.0f) / 2.0f;
                this.z0.moveTo(f7, 0.0f);
                float f10 = f6 - f5;
                this.z0.cubicTo(f10, 0.0f, f6, f5, f6, f9);
                this.z0.cubicTo(f6, f10, f10, f6, f7, f8);
                this.z0.cubicTo(f5, f6, 0.0f, f10, 0.0f, f9);
                this.z0.cubicTo(0.0f, f5, f5, 0.0f, f7, 0.0f);
                this.z0.close();
                this.e.d.setStyle(Paint.Style.FILL);
                this.e.d.setColor(SkinManager.getColor(this.C0));
                if (this.D0) {
                    this.e.d.setColor(this.E0);
                }
                this.K0 = U(measuredWidth, measuredHeight, true);
                this.z0.reset();
                float strokeWith = getStrokeWith();
                float f11 = measuredWidth / 2;
                this.z0.moveTo(f11, strokeWith);
                float f12 = f6 - strokeWith;
                float f13 = f12 - f5;
                float f14 = strokeWith + f5;
                this.z0.cubicTo(f13, strokeWith, f12, f14, f12, f11);
                this.z0.cubicTo(f12, f13, f13, f12, f11, f12);
                this.z0.cubicTo(f14, f12, strokeWith, f13, strokeWith, f11);
                this.z0.cubicTo(strokeWith, f14, f14, strokeWith, f11, strokeWith);
                this.z0.close();
                if (this.M0 == null) {
                    this.M0 = new PaintFlagsDrawFilter(0, 3);
                }
                canvas.setDrawFilter(this.M0);
                if (this.I0 == null) {
                    this.I0 = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                }
                if (this.L0 == null) {
                    this.L0 = new Canvas(this.I0);
                }
                this.e.d.setStyle(Paint.Style.STROKE);
                super.onDraw(this.L0);
                this.J0 = U(measuredWidth, measuredHeight, false);
                if (this.H0) {
                    f = f8;
                    f4 = 0.0f;
                    f2 = f6;
                    f3 = f5;
                    int saveLayer = canvas.saveLayer(0.0f, 0.0f, f6, f, null, 31);
                    this.e.d.setStyle(Paint.Style.FILL);
                    this.e.d.setColor(SkinManager.getColor(this.C0));
                    if (this.D0) {
                        this.e.d.setColor(this.E0);
                    }
                    canvas.drawBitmap(this.J0, 0.0f, 0.0f, this.e.d);
                    this.e.d.setXfermode(this.O0);
                    canvas.drawBitmap(this.K0, 0.0f, 0.0f, this.e.d);
                    this.e.d.setXfermode(null);
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
                canvas.drawBitmap(this.J0, f4, f4, this.e.c);
                this.e.c.setXfermode(this.N0);
                canvas.drawBitmap(this.I0, f4, f4, this.e.c);
                this.e.c.setXfermode(null);
                if (saveLayer2 >= 1 && saveLayer2 <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveLayer2);
                }
                if (this.G0) {
                    T(canvas, measuredWidth, f3);
                    return;
                }
                return;
            }
            super.onDraw(canvas);
        }
    }

    public void setShowInnerBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.G0 = z;
        }
    }

    public void setShowOuterBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.H0 = z;
        }
    }

    public void setShowOval(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.F0 = z;
        }
    }

    public void setStrokeColorInt(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.E0 = i;
        }
    }

    public void setStrokeColorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.C0 = i;
        }
    }

    public void setStrokeWith(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.B0 = i;
        }
    }

    public void setUseStrokeColorInt(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.D0 = z;
        }
    }
}
