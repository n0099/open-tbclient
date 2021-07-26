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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.j;
import d.a.o0.a.z1.a.b;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class SwanAppRoundedImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public static final ImageView.ScaleType[] l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f11608e;

    /* renamed from: f  reason: collision with root package name */
    public int f11609f;

    /* renamed from: g  reason: collision with root package name */
    public int f11610g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11611h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f11612i;
    public Drawable j;
    public ImageView.ScaleType k;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11613a;
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
            f11613a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11613a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11613a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11613a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11613a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11613a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11613a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
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
        l = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11608e = 20;
        this.f11609f = 2;
        this.f11610g = -16777216;
    }

    public int getBorder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11609f : invokeV.intValue;
    }

    public int getBorderColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11610g : invokeV.intValue;
    }

    public int getCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11608e : invokeV.intValue;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (ImageView.ScaleType) invokeV.objValue;
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
            if (this.f11611h && drawable != null) {
                this.j = b.b(drawable, this.k, this.f11608e, this.f11609f, this.f11610g);
            } else {
                this.j = drawable;
            }
            super.setBackgroundDrawable(this.j);
        }
    }

    public void setBorderColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f11610g == i2) {
            return;
        }
        this.f11610g = i2;
        Drawable drawable = this.f11612i;
        if (drawable instanceof b) {
            ((b) drawable).d(i2);
        }
        if (this.f11611h) {
            Drawable drawable2 = this.j;
            if (drawable2 instanceof b) {
                ((b) drawable2).d(i2);
            }
        }
        if (this.f11609f > 0) {
            invalidate();
        }
    }

    public void setBorderWidth(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f11609f == i2) {
            return;
        }
        this.f11609f = i2;
        Drawable drawable = this.f11612i;
        if (drawable instanceof b) {
            ((b) drawable).e(i2);
        }
        if (this.f11611h) {
            Drawable drawable2 = this.j;
            if (drawable2 instanceof b) {
                ((b) drawable2).e(i2);
            }
        }
        invalidate();
    }

    public void setCornerRadius(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f11608e == i2) {
            return;
        }
        this.f11608e = i2;
        Drawable drawable = this.f11612i;
        if (drawable instanceof b) {
            ((b) drawable).f(i2);
        }
        if (this.f11611h) {
            Drawable drawable2 = this.j;
            if (drawable2 instanceof b) {
                ((b) drawable2).f(i2);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bitmap) == null) {
            if (bitmap != null) {
                b bVar = new b(bitmap, this.f11608e, this.f11609f, this.f11610g);
                this.f11612i = bVar;
                ImageView.ScaleType scaleType = this.k;
                if (scaleType != null) {
                    bVar.h(scaleType);
                }
            } else {
                this.f11612i = null;
            }
            super.setImageDrawable(this.f11612i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) {
            if (drawable != null) {
                this.f11612i = b.b(drawable, this.k, this.f11608e, this.f11609f, this.f11610g);
            } else {
                this.f11612i = null;
            }
            super.setImageDrawable(this.f11612i);
        }
    }

    public void setRoundBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.f11611h == z) {
            return;
        }
        this.f11611h = z;
        if (z) {
            Drawable drawable = this.j;
            if (drawable instanceof b) {
                ((b) drawable).h(this.k);
                ((b) this.j).f(this.f11608e);
                ((b) this.j).e(this.f11609f);
                ((b) this.j).d(this.f11610g);
            } else {
                setBackgroundDrawable(drawable);
            }
        } else {
            Drawable drawable2 = this.j;
            if (drawable2 instanceof b) {
                ((b) drawable2).e(0);
                ((b) this.j).f(0.0f);
            }
        }
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, scaleType) == null) || scaleType == null || this.k == scaleType) {
            return;
        }
        this.k = scaleType;
        switch (a.f11613a[scaleType.ordinal()]) {
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
        Drawable drawable = this.f11612i;
        if ((drawable instanceof b) && ((b) drawable).c() != scaleType) {
            ((b) this.f11612i).h(scaleType);
        }
        Drawable drawable2 = this.j;
        if ((drawable2 instanceof b) && ((b) drawable2).c() != scaleType) {
            ((b) this.j).h(scaleType);
        }
        setWillNotCacheDrawing(true);
        requestLayout();
        invalidate();
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
    public SwanAppRoundedImageView(Context context, AttributeSet attributeSet, int i2) {
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.RoundedImageView, i2, 0);
        int i5 = obtainStyledAttributes.getInt(j.RoundedImageView_android_scaleType, -1);
        if (i5 >= 0) {
            setScaleType(l[i5]);
        }
        this.f11608e = obtainStyledAttributes.getDimensionPixelSize(j.RoundedImageView_corner_radius, -1);
        this.f11609f = obtainStyledAttributes.getDimensionPixelSize(j.RoundedImageView_border_width, -1);
        if (this.f11608e < 0) {
            this.f11608e = 20;
        }
        if (this.f11609f < 0) {
            this.f11609f = 2;
        }
        this.f11610g = obtainStyledAttributes.getColor(j.RoundedImageView_border_color, -16777216);
        this.f11611h = obtainStyledAttributes.getBoolean(j.RoundedImageView_round_background, false);
        obtainStyledAttributes.recycle();
    }
}
