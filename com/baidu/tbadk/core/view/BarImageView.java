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
import c.a.d.g.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class BarImageView extends TbClipImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int Q;
    public int R;
    public Path S;
    public Path T;
    public int U;
    public int V;
    public boolean W;
    public boolean a0;
    public boolean b0;
    public Bitmap c0;
    public Bitmap d0;
    public Bitmap e0;
    public Canvas f0;
    public PaintFlagsDrawFilter g0;
    public PorterDuffXfermode h0;
    public PorterDuffXfermode i0;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.V : invokeV.intValue;
    }

    public int getStrokeWith() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.U : invokeV.intValue;
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setDrawerType(0);
            setGifIconSupport(false);
            setDrawBorder(true);
            setDefaultResource(this.Q);
            setDefaultBgResource(this.R);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            a aVar = this.mDrawer;
            if (aVar != null && aVar.f3204b != null) {
                if (!this.W) {
                    super.onDraw(canvas);
                    return;
                }
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                float f6 = (measuredWidth * 14) / 130;
                this.S.reset();
                float f7 = measuredWidth;
                float f8 = (f7 + 0.0f) / 2.0f;
                float f9 = measuredHeight;
                float f10 = (f9 + 0.0f) / 2.0f;
                this.S.moveTo(f8, 0.0f);
                float f11 = f7 - f6;
                this.S.cubicTo(f11, 0.0f, f7, f6, f7, f10);
                this.S.cubicTo(f7, f11, f11, f7, f8, f9);
                this.S.cubicTo(f6, f7, 0.0f, f11, 0.0f, f10);
                this.S.cubicTo(0.0f, f6, f6, 0.0f, f8, 0.0f);
                this.S.close();
                this.mDrawer.f3205c.setStyle(Paint.Style.FILL);
                this.mDrawer.f3205c.setColor(SkinManager.getColor(this.V));
                this.e0 = u(measuredWidth, measuredHeight, true);
                this.S.reset();
                float strokeWith = getStrokeWith();
                float f12 = measuredWidth / 2;
                this.S.moveTo(f12, strokeWith);
                float f13 = f7 - strokeWith;
                float f14 = f13 - f6;
                float f15 = strokeWith + f6;
                this.S.cubicTo(f14, strokeWith, f13, f15, f13, f12);
                this.S.cubicTo(f13, f14, f14, f13, f12, f13);
                this.S.cubicTo(f15, f13, strokeWith, f14, strokeWith, f12);
                this.S.cubicTo(strokeWith, f15, f15, strokeWith, f12, strokeWith);
                this.S.close();
                if (this.g0 == null) {
                    this.g0 = new PaintFlagsDrawFilter(0, 3);
                }
                canvas.setDrawFilter(this.g0);
                if (this.c0 == null) {
                    this.c0 = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                }
                if (this.f0 == null) {
                    this.f0 = new Canvas(this.c0);
                }
                this.mDrawer.f3205c.setStyle(Paint.Style.STROKE);
                super.onDraw(this.f0);
                this.d0 = u(measuredWidth, measuredHeight, false);
                if (this.b0) {
                    f2 = f9;
                    f5 = 0.0f;
                    f3 = f7;
                    f4 = f6;
                    int saveLayer = canvas.saveLayer(0.0f, 0.0f, f7, f2, null, 31);
                    this.mDrawer.f3205c.setStyle(Paint.Style.FILL);
                    this.mDrawer.f3205c.setColor(SkinManager.getColor(this.V));
                    canvas.drawBitmap(this.d0, 0.0f, 0.0f, this.mDrawer.f3205c);
                    this.mDrawer.f3205c.setXfermode(this.i0);
                    canvas.drawBitmap(this.e0, 0.0f, 0.0f, this.mDrawer.f3205c);
                    this.mDrawer.f3205c.setXfermode(null);
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
                canvas.drawBitmap(this.d0, f5, f5, this.mDrawer.f3204b);
                this.mDrawer.f3204b.setXfermode(this.h0);
                canvas.drawBitmap(this.c0, f5, f5, this.mDrawer.f3204b);
                this.mDrawer.f3204b.setXfermode(null);
                if (saveLayer2 >= 1 && saveLayer2 <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveLayer2);
                }
                if (this.a0) {
                    t(canvas, measuredWidth, f4);
                    return;
                }
                return;
            }
            super.onDraw(canvas);
        }
    }

    public void setShowInnerBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.a0 = z;
        }
    }

    public void setShowOuterBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.b0 = z;
        }
    }

    public void setShowOval(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.W = z;
        }
    }

    public void setStrokeColorResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.V = i2;
        }
    }

    public void setStrokeWith(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.U = i2;
        }
    }

    public final void t(Canvas canvas, int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{canvas, Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            this.T.reset();
            float strokeWith = ((getStrokeWith() * 3.0f) / 2.0f) - 0.5f;
            float f3 = i2 / 2;
            this.T.moveTo(f3, strokeWith);
            float f4 = i2 - strokeWith;
            float f5 = f4 - f2;
            float f6 = f2 + strokeWith;
            this.T.cubicTo(f5, strokeWith, f4, f6, f4, f3);
            this.T.cubicTo(f4, f5, f5, f4, f3, f4);
            this.T.cubicTo(f6, f4, strokeWith, f5, strokeWith, f3);
            this.T.cubicTo(strokeWith, f6, f6, strokeWith, f3, strokeWith);
            this.T.close();
            float strokeWidth = this.mDrawer.f3205c.getStrokeWidth();
            this.mDrawer.f3205c.setStyle(Paint.Style.STROKE);
            this.mDrawer.f3205c.setStrokeWidth(getStrokeWith() + 0.5f);
            this.mDrawer.f3205c.setColor(SkinManager.getColor(getStrokeColorResId()));
            canvas.drawPath(this.T, this.mDrawer.f3205c);
            this.mDrawer.f3205c.setStrokeWidth(strokeWidth);
        }
    }

    public final Bitmap u(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawPath(this.S, z ? this.mDrawer.f3205c : this.mDrawer.f3204b);
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
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
        this.Q = SkinManager.getColor(R.color.CAM_X0209);
        this.R = R.drawable.pic_use_header_28_n;
        this.S = new Path();
        this.T = new Path();
        this.U = 0;
        this.V = 0;
        this.W = false;
        this.a0 = false;
        this.b0 = true;
        this.h0 = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.i0 = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        init();
    }
}
