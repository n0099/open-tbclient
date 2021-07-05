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
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.f.a.a;
/* loaded from: classes4.dex */
public class BarImageView extends TbClipImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Path A0;
    public Path B0;
    public int C0;
    public int D0;
    public boolean E0;
    public boolean F0;
    public boolean G0;
    public Bitmap H0;
    public Bitmap I0;
    public Bitmap J0;
    public Canvas K0;
    public PaintFlagsDrawFilter L0;
    public PorterDuffXfermode M0;
    public PorterDuffXfermode N0;
    public int y0;
    public int z0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BarImageView(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.D0 : invokeV.intValue;
    }

    public final void T(Canvas canvas, int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            this.B0.reset();
            float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
            float f3 = i2 / 2;
            this.B0.moveTo(f3, strokeWith);
            float f4 = i2 - strokeWith;
            float f5 = f4 - f2;
            float f6 = f2 + strokeWith;
            this.B0.cubicTo(f5, strokeWith, f4, f6, f4, f3);
            this.B0.cubicTo(f4, f5, f5, f4, f3, f4);
            this.B0.cubicTo(f6, f4, strokeWith, f5, strokeWith, f3);
            this.B0.cubicTo(strokeWith, f6, f6, strokeWith, f3, strokeWith);
            this.B0.close();
            float strokeWidth = this.f2202i.f44573c.getStrokeWidth();
            this.f2202i.f44573c.setStyle(Paint.Style.STROKE);
            this.f2202i.f44573c.setStrokeWidth(getStrokeWith() + 0.5f);
            this.f2202i.f44573c.setColor(SkinManager.getColor(getStrokeColorResId()));
            canvas.drawPath(this.B0, this.f2202i.f44573c);
            this.f2202i.f44573c.setStrokeWidth(strokeWidth);
        }
    }

    public final Bitmap U(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawPath(this.A0, z ? this.f2202i.f44573c : this.f2202i.f44572b);
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public int getStrokeWith() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.C0 : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            a aVar = this.f2202i;
            if (aVar != null && aVar.f44572b != null) {
                if (!this.E0) {
                    super.onDraw(canvas);
                    return;
                }
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                float f6 = (measuredWidth * 14) / IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER;
                this.A0.reset();
                float f7 = measuredWidth;
                float f8 = (f7 + 0.0f) / 2.0f;
                float f9 = measuredHeight;
                float f10 = (f9 + 0.0f) / 2.0f;
                this.A0.moveTo(f8, 0.0f);
                float f11 = f7 - f6;
                this.A0.cubicTo(f11, 0.0f, f7, f6, f7, f10);
                this.A0.cubicTo(f7, f11, f11, f7, f8, f9);
                this.A0.cubicTo(f6, f7, 0.0f, f11, 0.0f, f10);
                this.A0.cubicTo(0.0f, f6, f6, 0.0f, f8, 0.0f);
                this.A0.close();
                this.f2202i.f44573c.setStyle(Paint.Style.FILL);
                this.f2202i.f44573c.setColor(SkinManager.getColor(this.D0));
                this.J0 = U(measuredWidth, measuredHeight, true);
                this.A0.reset();
                float strokeWith = getStrokeWith();
                float f12 = measuredWidth / 2;
                this.A0.moveTo(f12, strokeWith);
                float f13 = f7 - strokeWith;
                float f14 = f13 - f6;
                float f15 = strokeWith + f6;
                this.A0.cubicTo(f14, strokeWith, f13, f15, f13, f12);
                this.A0.cubicTo(f13, f14, f14, f13, f12, f13);
                this.A0.cubicTo(f15, f13, strokeWith, f14, strokeWith, f12);
                this.A0.cubicTo(strokeWith, f15, f15, strokeWith, f12, strokeWith);
                this.A0.close();
                if (this.L0 == null) {
                    this.L0 = new PaintFlagsDrawFilter(0, 3);
                }
                canvas.setDrawFilter(this.L0);
                if (this.H0 == null) {
                    this.H0 = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                }
                if (this.K0 == null) {
                    this.K0 = new Canvas(this.H0);
                }
                this.f2202i.f44573c.setStyle(Paint.Style.STROKE);
                super.onDraw(this.K0);
                this.I0 = U(measuredWidth, measuredHeight, false);
                if (this.G0) {
                    f2 = f9;
                    f5 = 0.0f;
                    f3 = f7;
                    f4 = f6;
                    int saveLayer = canvas.saveLayer(0.0f, 0.0f, f7, f2, null, 31);
                    this.f2202i.f44573c.setStyle(Paint.Style.FILL);
                    this.f2202i.f44573c.setColor(SkinManager.getColor(this.D0));
                    canvas.drawBitmap(this.I0, 0.0f, 0.0f, this.f2202i.f44573c);
                    this.f2202i.f44573c.setXfermode(this.N0);
                    canvas.drawBitmap(this.J0, 0.0f, 0.0f, this.f2202i.f44573c);
                    this.f2202i.f44573c.setXfermode(null);
                    if (saveLayer >= 1 && saveLayer <= canvas.getSaveCount()) {
                        canvas.restoreToCount(saveLayer);
                    }
                } else {
                    f2 = f9;
                    f3 = f7;
                    f4 = f6;
                    f5 = 0.0f;
                }
                int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, f3, f2, null, 31);
                canvas.drawBitmap(this.I0, f5, f5, this.f2202i.f44572b);
                this.f2202i.f44572b.setXfermode(this.M0);
                canvas.drawBitmap(this.H0, f5, f5, this.f2202i.f44572b);
                this.f2202i.f44572b.setXfermode(null);
                if (saveLayer2 >= 1 && saveLayer2 <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveLayer2);
                }
                if (this.F0) {
                    T(canvas, measuredWidth, f4);
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
            this.F0 = z;
        }
    }

    public void setShowOuterBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.G0 = z;
        }
    }

    public void setShowOval(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.E0 = z;
        }
    }

    public void setStrokeColorResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.D0 = i2;
        }
    }

    public void setStrokeWith(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.C0 = i2;
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            setDrawerType(0);
            setGifIconSupport(false);
            setDrawBorder(true);
            setDefaultResource(this.y0);
            setDefaultBgResource(this.z0);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BarImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.y0 = SkinManager.getColor(R.color.CAM_X0209);
        this.z0 = R.drawable.pic_use_header_28_n;
        this.A0 = new Path();
        this.B0 = new Path();
        this.C0 = 0;
        this.D0 = 0;
        this.E0 = false;
        this.F0 = false;
        this.G0 = true;
        this.M0 = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.N0 = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        v();
    }
}
