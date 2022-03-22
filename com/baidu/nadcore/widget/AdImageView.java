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
import c.a.a0.l0.a;
import c.a.a0.l0.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.IAdImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AdImageView extends AppCompatImageView implements IAdImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final o a;

    /* renamed from: b  reason: collision with root package name */
    public IAdImageView.ImageScaleType f27736b;

    /* renamed from: c  reason: collision with root package name */
    public final Path f27737c;

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
            a.a().a(str, this, i, i2);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                setImageBitmap(null);
            } else {
                a.a().e(str, this);
            }
        }
    }

    @NonNull
    public o getConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (o) invokeV.objValue;
    }

    public IAdImageView.ImageScaleType getImageScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27736b : (IAdImageView.ImageScaleType) invokeV.objValue;
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            a.a().c(str);
        }
    }

    public final void m(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04006e, R.attr.obfuscated_res_0x7f0400dc, R.attr.obfuscated_res_0x7f0400dd, R.attr.obfuscated_res_0x7f04013f, R.attr.obfuscated_res_0x7f0401e7, R.attr.obfuscated_res_0x7f0402a3, R.attr.obfuscated_res_0x7f0402b7, R.attr.obfuscated_res_0x7f040398, R.attr.obfuscated_res_0x7f04039e, R.attr.obfuscated_res_0x7f0403f0, R.attr.obfuscated_res_0x7f0404fc, R.attr.obfuscated_res_0x7f040501});
        int resourceId = obtainStyledAttributes.getResourceId(5, 0);
        if (resourceId != 0) {
            this.a.a = resourceId;
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(4, 0);
        if (resourceId2 != 0) {
            this.a.f1426c = resourceId2;
        }
        o.a aVar = new o.a();
        if (obtainStyledAttributes.getBoolean(3, false)) {
            aVar.a = true;
        } else {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize > 0) {
                float floatValue = Integer.valueOf(dimensionPixelSize).floatValue();
                aVar.f1428b = new float[]{floatValue, floatValue, floatValue, floatValue};
            } else {
                aVar.f1428b = new float[]{obtainStyledAttributes.getDimensionPixelSize(8, 0), obtainStyledAttributes.getDimensionPixelSize(11, 0), obtainStyledAttributes.getDimensionPixelSize(7, 0), obtainStyledAttributes.getDimensionPixelSize(10, 0)};
            }
        }
        this.a.f1427d = aVar;
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
            o.a aVar = getConfig().f1427d;
            if (aVar == null) {
                super.onDraw(canvas);
                return;
            }
            int width = getWidth();
            int height = getHeight();
            if (aVar.a) {
                this.f27737c.addCircle(width / 2.0f, height / 2.0f, Math.min(width, height) / 2, Path.Direction.CCW);
                canvas.clipPath(this.f27737c);
                super.onDraw(canvas);
                return;
            }
            float[] fArr = aVar.f1428b;
            if (fArr == null) {
                super.onDraw(canvas);
                return;
            }
            float max = Math.max(fArr[0], fArr[2]) + Math.max(fArr[1], fArr[3]);
            float max2 = Math.max(fArr[0], fArr[1]) + Math.max(fArr[2], fArr[3]);
            float f2 = width;
            if (f2 >= max) {
                float f3 = height;
                if (f3 > max2) {
                    this.f27737c.moveTo(fArr[0], 0.0f);
                    this.f27737c.lineTo(f2 - fArr[1], 0.0f);
                    this.f27737c.quadTo(f2, 0.0f, f2, fArr[1]);
                    this.f27737c.lineTo(f2, f3 - fArr[3]);
                    this.f27737c.quadTo(f2, f3, f2 - fArr[3], f3);
                    this.f27737c.lineTo(fArr[2], f3);
                    this.f27737c.quadTo(0.0f, f3, 0.0f, f3 - fArr[2]);
                    this.f27737c.lineTo(0.0f, fArr[0]);
                    this.f27737c.quadTo(0.0f, 0.0f, fArr[0], 0.0f);
                    canvas.clipPath(this.f27737c);
                }
            }
            super.onDraw(canvas);
        }
    }

    public void setBorder(float f2, @ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i)}) == null) {
            o.a aVar = this.a.f1427d;
            if (aVar == null) {
                aVar = new o.a();
            }
            aVar.f1429c = f2;
            aVar.f1430d = i;
            this.a.f1427d = aVar;
        }
    }

    public void setCircle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            o.a aVar = this.a.f1427d;
            if (aVar == null) {
                aVar = new o.a();
            }
            aVar.a = true;
            this.a.f1427d = aVar;
        }
    }

    public void setImageScaleType(IAdImageView.ImageScaleType imageScaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, imageScaleType) == null) {
            if (imageScaleType != null) {
                if (this.f27736b != imageScaleType) {
                    this.f27736b = imageScaleType;
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
            this.a.f1425b = drawable;
        }
    }

    public void setRadius(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            o.a aVar = this.a.f1427d;
            if (aVar == null) {
                aVar = new o.a();
            }
            aVar.a = false;
            aVar.f1428b = new float[]{f2, f3, f4, f5};
            this.a.f1427d = aVar;
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
        this.a = new o();
        this.f27737c = new Path();
        m(attributeSet);
    }
}
