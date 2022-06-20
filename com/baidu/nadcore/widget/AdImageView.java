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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.IAdImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k31;
import com.repackage.w21;
/* loaded from: classes2.dex */
public class AdImageView extends AppCompatImageView implements IAdImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final k31 a;
    public IAdImageView.ImageScaleType b;
    public final Path c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdImageView(@NonNull Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void f(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, str, i, i2) == null) {
            w21.a().a(str, this, i, i2);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                setImageBitmap(null);
            } else {
                w21.a().e(str, this);
            }
        }
    }

    @NonNull
    public k31 getConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (k31) invokeV.objValue;
    }

    public IAdImageView.ImageScaleType getImageScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (IAdImageView.ImageScaleType) invokeV.objValue;
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            w21.a().c(str);
        }
    }

    public final void m(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04006e, R.attr.obfuscated_res_0x7f0400df, R.attr.obfuscated_res_0x7f0400e0, R.attr.obfuscated_res_0x7f040146, R.attr.obfuscated_res_0x7f040258, R.attr.obfuscated_res_0x7f0402e9, R.attr.obfuscated_res_0x7f0402fc, R.attr.obfuscated_res_0x7f0403d8, R.attr.obfuscated_res_0x7f0403de, R.attr.obfuscated_res_0x7f040434, R.attr.obfuscated_res_0x7f04053f, R.attr.obfuscated_res_0x7f040544});
        int resourceId = obtainStyledAttributes.getResourceId(5, 0);
        if (resourceId != 0) {
            this.a.a = resourceId;
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(4, 0);
        if (resourceId2 != 0) {
            this.a.c = resourceId2;
        }
        k31.a aVar = new k31.a();
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
            setScaleType(IAdImageView.a0[i]);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            k31.a aVar = getConfig().d;
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
    }

    public void setBorder(float f, @ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)}) == null) {
            k31.a aVar = this.a.d;
            if (aVar == null) {
                aVar = new k31.a();
            }
            aVar.c = f;
            aVar.d = i;
            this.a.d = aVar;
        }
    }

    public void setCircle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            k31.a aVar = this.a.d;
            if (aVar == null) {
                aVar = new k31.a();
            }
            aVar.a = true;
            this.a.d = aVar;
        }
    }

    public void setImageScaleType(IAdImageView.ImageScaleType imageScaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, imageScaleType) == null) {
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
    }

    public void setPlaceHolderDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) {
            this.a.b = drawable;
        }
    }

    public void setRadius(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            k31.a aVar = this.a.d;
            if (aVar == null) {
                aVar = new k31.a();
            }
            aVar.a = false;
            aVar.b = new float[]{f, f2, f3, f4};
            this.a.d = aVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public AdImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = new k31();
        this.c = new Path();
        m(attributeSet);
    }
}
