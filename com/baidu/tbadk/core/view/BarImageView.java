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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kk;
/* loaded from: classes3.dex */
public class BarImageView extends TbClipImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A0;
    public int B0;
    public boolean C0;
    public boolean D0;
    public boolean E0;
    public Bitmap F0;
    public Bitmap G0;
    public Bitmap H0;
    public Canvas I0;
    public PaintFlagsDrawFilter J0;
    public PorterDuffXfermode K0;
    public PorterDuffXfermode L0;
    public int w0;
    public int x0;
    public Path y0;
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

    private int getStrokeColorResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.B0 : invokeV.intValue;
    }

    public final void R(Canvas canvas, int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, Integer.valueOf(i), Float.valueOf(f)}) == null) {
            this.z0.reset();
            float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
            float f2 = i / 2;
            this.z0.moveTo(f2, strokeWith);
            float f3 = i - strokeWith;
            float f4 = f3 - f;
            float f5 = f + strokeWith;
            this.z0.cubicTo(f4, strokeWith, f3, f5, f3, f2);
            this.z0.cubicTo(f3, f4, f4, f3, f2, f3);
            this.z0.cubicTo(f5, f3, strokeWith, f4, strokeWith, f2);
            this.z0.cubicTo(strokeWith, f5, f5, strokeWith, f2, strokeWith);
            this.z0.close();
            float strokeWidth = this.e.d.getStrokeWidth();
            this.e.d.setStyle(Paint.Style.STROKE);
            this.e.d.setStrokeWidth(getStrokeWith() + 0.5f);
            this.e.d.setColor(SkinManager.getColor(getStrokeColorResId()));
            canvas.drawPath(this.z0, this.e.d);
            this.e.d.setStrokeWidth(strokeWidth);
        }
    }

    public final Bitmap S(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawPath(this.y0, z ? this.e.d : this.e.c);
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public int getStrokeWith() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.A0 : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            kk kkVar = this.e;
            if (kkVar != null && kkVar.c != null) {
                if (!this.C0) {
                    super.onDraw(canvas);
                    return;
                }
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                float f5 = (measuredWidth * 14) / 130;
                this.y0.reset();
                float f6 = measuredWidth;
                float f7 = (f6 + 0.0f) / 2.0f;
                float f8 = measuredHeight;
                float f9 = (f8 + 0.0f) / 2.0f;
                this.y0.moveTo(f7, 0.0f);
                float f10 = f6 - f5;
                this.y0.cubicTo(f10, 0.0f, f6, f5, f6, f9);
                this.y0.cubicTo(f6, f10, f10, f6, f7, f8);
                this.y0.cubicTo(f5, f6, 0.0f, f10, 0.0f, f9);
                this.y0.cubicTo(0.0f, f5, f5, 0.0f, f7, 0.0f);
                this.y0.close();
                this.e.d.setStyle(Paint.Style.FILL);
                this.e.d.setColor(SkinManager.getColor(this.B0));
                this.H0 = S(measuredWidth, measuredHeight, true);
                this.y0.reset();
                float strokeWith = getStrokeWith();
                float f11 = measuredWidth / 2;
                this.y0.moveTo(f11, strokeWith);
                float f12 = f6 - strokeWith;
                float f13 = f12 - f5;
                float f14 = strokeWith + f5;
                this.y0.cubicTo(f13, strokeWith, f12, f14, f12, f11);
                this.y0.cubicTo(f12, f13, f13, f12, f11, f12);
                this.y0.cubicTo(f14, f12, strokeWith, f13, strokeWith, f11);
                this.y0.cubicTo(strokeWith, f14, f14, strokeWith, f11, strokeWith);
                this.y0.close();
                if (this.J0 == null) {
                    this.J0 = new PaintFlagsDrawFilter(0, 3);
                }
                canvas.setDrawFilter(this.J0);
                if (this.F0 == null) {
                    this.F0 = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                }
                if (this.I0 == null) {
                    this.I0 = new Canvas(this.F0);
                }
                this.e.d.setStyle(Paint.Style.STROKE);
                super.onDraw(this.I0);
                this.G0 = S(measuredWidth, measuredHeight, false);
                if (this.E0) {
                    f = f8;
                    f4 = 0.0f;
                    f2 = f6;
                    f3 = f5;
                    int saveLayer = canvas.saveLayer(0.0f, 0.0f, f6, f, null, 31);
                    this.e.d.setStyle(Paint.Style.FILL);
                    this.e.d.setColor(SkinManager.getColor(this.B0));
                    canvas.drawBitmap(this.G0, 0.0f, 0.0f, this.e.d);
                    this.e.d.setXfermode(this.L0);
                    canvas.drawBitmap(this.H0, 0.0f, 0.0f, this.e.d);
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
                canvas.drawBitmap(this.G0, f4, f4, this.e.c);
                this.e.c.setXfermode(this.K0);
                canvas.drawBitmap(this.F0, f4, f4, this.e.c);
                this.e.c.setXfermode(null);
                if (saveLayer2 >= 1 && saveLayer2 <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveLayer2);
                }
                if (this.D0) {
                    R(canvas, measuredWidth, f3);
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
            this.D0 = z;
        }
    }

    public void setShowOuterBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.E0 = z;
        }
    }

    public void setShowOval(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.C0 = z;
        }
    }

    public void setStrokeColorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.B0 = i;
        }
    }

    public void setStrokeWith(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.A0 = i;
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            setDrawerType(0);
            setGifIconSupport(false);
            setDrawBorder(true);
            setDefaultResource(this.w0);
            setDefaultBgResource(this.x0);
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
        this.w0 = SkinManager.getColor(R.color.CAM_X0209);
        this.x0 = R.drawable.pic_use_header_28_n;
        this.y0 = new Path();
        this.z0 = new Path();
        this.A0 = 0;
        this.B0 = 0;
        this.C0 = false;
        this.D0 = false;
        this.E0 = true;
        this.K0 = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.L0 = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        w();
    }
}
