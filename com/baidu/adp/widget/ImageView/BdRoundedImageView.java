package com.baidu.adp.widget.ImageView;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.vm;
/* loaded from: classes.dex */
public class BdRoundedImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public static final ImageView.ScaleType[] i;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public ColorStateList c;
    public boolean d;
    public boolean e;
    public Drawable f;
    public Drawable g;
    public ImageView.ScaleType h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(725333791, "Lcom/baidu/adp/widget/ImageView/BdRoundedImageView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(725333791, "Lcom/baidu/adp/widget/ImageView/BdRoundedImageView$a;");
                    return;
                }
            }
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(335949948, "Lcom/baidu/adp/widget/ImageView/BdRoundedImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(335949948, "Lcom/baidu/adp/widget/ImageView/BdRoundedImageView;");
                return;
            }
        }
        i = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdRoundedImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0;
        this.c = ColorStateList.valueOf(0);
        this.d = false;
        this.e = false;
    }

    public final void a(Drawable drawable, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, drawable, z) == null) || drawable == null) {
            return;
        }
        int i2 = 0;
        if (drawable instanceof vm) {
            vm vmVar = (vm) drawable;
            vmVar.g(this.h);
            vmVar.e((this.d || !z) ? this.a : 0.0f);
            if (this.d || !z) {
                i2 = this.b;
            }
            vmVar.d(i2);
            vmVar.c(this.c);
            vmVar.f(this.e);
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            while (i2 < numberOfLayers) {
                a(layerDrawable.getDrawable(i2), z);
                i2++;
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a(this.g, true);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a(this.f, false);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.drawableStateChanged();
            invalidate();
        }
    }

    public int getBorderColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c.getDefaultColor() : invokeV.intValue;
    }

    public ColorStateList getBorderColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : (ColorStateList) invokeV.objValue;
    }

    public int getBorderWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : invokeV.intValue;
    }

    public int getCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : invokeV.intValue;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h : (ImageView.ScaleType) invokeV.objValue;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            this.g = vm.b(drawable);
            b();
            super.setBackgroundDrawable(this.g);
        }
    }

    public void setBorderColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            setBorderColors(ColorStateList.valueOf(i2));
        }
    }

    public void setBorderColors(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, colorStateList) == null) || this.c.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.c = colorStateList;
        c();
        b();
        if (this.b > 0) {
            invalidate();
        }
    }

    public void setBorderWidth(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || this.b == i2) {
            return;
        }
        this.b = i2;
        c();
        b();
        invalidate();
    }

    public void setCornerRadius(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || this.a == i2) {
            return;
        }
        this.a = i2;
        c();
        b();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bitmap) == null) {
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f = new vm(bitmap);
                c();
            } else {
                this.f = null;
            }
            super.setImageDrawable(this.f);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, drawable) == null) {
            if (drawable != null) {
                this.f = vm.b(drawable);
                c();
            } else {
                this.f = null;
            }
            super.setImageDrawable(this.f);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            super.setImageResource(i2);
            setImageDrawable(getDrawable());
        }
    }

    public void setOval(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.e = z;
            c();
            b();
            invalidate();
        }
    }

    public void setRoundBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || this.d == z) {
            return;
        }
        this.d = z;
        b();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, scaleType) == null) {
            if (scaleType != null) {
                if (this.h != scaleType) {
                    this.h = scaleType;
                    switch (a.a[scaleType.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            super.setScaleType(ImageView.ScaleType.FIT_XY);
                            break;
                        default:
                            super.setScaleType(scaleType);
                            break;
                    }
                    c();
                    b();
                    invalidate();
                    return;
                }
                return;
            }
            throw null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdRoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0;
        this.c = ColorStateList.valueOf(0);
        this.d = false;
        this.e = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843037, R.attr.obfuscated_res_0x7f0400e4, R.attr.obfuscated_res_0x7f0400e5, R.attr.obfuscated_res_0x7f040199, R.attr.obfuscated_res_0x7f040316, R.attr.obfuscated_res_0x7f040555}, i2, 0);
        int i5 = obtainStyledAttributes.getInt(0, -1);
        if (i5 >= 0) {
            setScaleType(i[i5]);
        }
        this.a = obtainStyledAttributes.getDimensionPixelSize(3, -1);
        this.b = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        if (this.a < 0) {
            this.a = 0;
        }
        if (this.b < 0) {
            this.b = 0;
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(1);
        this.c = colorStateList;
        if (colorStateList == null) {
            this.c = ColorStateList.valueOf(0);
        }
        this.d = obtainStyledAttributes.getBoolean(5, false);
        this.e = obtainStyledAttributes.getBoolean(4, false);
        c();
        b();
        obtainStyledAttributes.recycle();
    }
}
