package com.baidu.swan.apps.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ok1;
import com.baidu.tieba.p23;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class SwanAppRoundedImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public static final ImageView.ScaleType[] h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public boolean d;
    public Drawable e;
    public Drawable f;
    public ImageView.ScaleType g;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(461648760, "Lcom/baidu/swan/apps/view/SwanAppRoundedImageView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(461648760, "Lcom/baidu/swan/apps/view/SwanAppRoundedImageView$a;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1019473685, "Lcom/baidu/swan/apps/view/SwanAppRoundedImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1019473685, "Lcom/baidu/swan/apps/view/SwanAppRoundedImageView;");
                return;
            }
        }
        h = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppRoundedImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 20;
        this.b = 2;
        this.c = -16777216;
    }

    public void setBorderColor(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.c == i) {
            return;
        }
        this.c = i;
        Drawable drawable = this.e;
        if (drawable instanceof p23) {
            ((p23) drawable).d(i);
        }
        if (this.d) {
            Drawable drawable2 = this.f;
            if (drawable2 instanceof p23) {
                ((p23) drawable2).d(i);
            }
        }
        if (this.b > 0) {
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || this.b == i) {
            return;
        }
        this.b = i;
        Drawable drawable = this.e;
        if (drawable instanceof p23) {
            ((p23) drawable).e(i);
        }
        if (this.d) {
            Drawable drawable2 = this.f;
            if (drawable2 instanceof p23) {
                ((p23) drawable2).e(i);
            }
        }
        invalidate();
    }

    public void setCornerRadius(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || this.a == i) {
            return;
        }
        this.a = i;
        Drawable drawable = this.e;
        if (drawable instanceof p23) {
            ((p23) drawable).f(i);
        }
        if (this.d) {
            Drawable drawable2 = this.f;
            if (drawable2 instanceof p23) {
                ((p23) drawable2).f(i);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwanAppRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ok1.RoundedImageView, i, 0);
        int i4 = obtainStyledAttributes.getInt(0, -1);
        if (i4 >= 0) {
            setScaleType(h[i4]);
        }
        this.a = obtainStyledAttributes.getDimensionPixelSize(3, -1);
        this.b = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        if (this.a < 0) {
            this.a = 20;
        }
        if (this.b < 0) {
            this.b = 2;
        }
        this.c = obtainStyledAttributes.getColor(1, -16777216);
        this.d = obtainStyledAttributes.getBoolean(4, false);
        obtainStyledAttributes.recycle();
    }

    public int getBorder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int getBorderColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public int getCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (ImageView.ScaleType) invokeV.objValue;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, drawable) == null) {
            setBackgroundDrawable(drawable);
        }
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, drawable) == null) {
            if (this.d && drawable != null) {
                this.f = p23.b(drawable, this.g, this.a, this.b, this.c);
            } else {
                this.f = drawable;
            }
            super.setBackgroundDrawable(this.f);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bitmap) == null) {
            if (bitmap != null) {
                p23 p23Var = new p23(bitmap, this.a, this.b, this.c);
                this.e = p23Var;
                ImageView.ScaleType scaleType = this.g;
                if (scaleType != null) {
                    p23Var.h(scaleType);
                }
            } else {
                this.e = null;
            }
            super.setImageDrawable(this.e);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) {
            if (drawable != null) {
                this.e = p23.b(drawable, this.g, this.a, this.b, this.c);
            } else {
                this.e = null;
            }
            super.setImageDrawable(this.e);
        }
    }

    public void setRoundBackground(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048587, this, z) != null) || this.d == z) {
            return;
        }
        this.d = z;
        if (z) {
            Drawable drawable = this.f;
            if (drawable instanceof p23) {
                ((p23) drawable).h(this.g);
                ((p23) this.f).f(this.a);
                ((p23) this.f).e(this.b);
                ((p23) this.f).d(this.c);
            } else {
                setBackgroundDrawable(drawable);
            }
        } else {
            Drawable drawable2 = this.f;
            if (drawable2 instanceof p23) {
                ((p23) drawable2).e(0);
                ((p23) this.f).f(0.0f);
            }
        }
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, scaleType) == null) && scaleType != null && this.g != scaleType) {
            this.g = scaleType;
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
            Drawable drawable = this.e;
            if ((drawable instanceof p23) && ((p23) drawable).c() != scaleType) {
                ((p23) this.e).h(scaleType);
            }
            Drawable drawable2 = this.f;
            if ((drawable2 instanceof p23) && ((p23) drawable2).c() != scaleType) {
                ((p23) this.f).h(scaleType);
            }
            setWillNotCacheDrawing(true);
            requestLayout();
            invalidate();
        }
    }
}
