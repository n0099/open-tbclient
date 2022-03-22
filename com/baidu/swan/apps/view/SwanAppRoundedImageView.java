package com.baidu.swan.apps.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.s1.a.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class SwanAppRoundedImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final ImageView.ScaleType[] f29335h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f29336b;

    /* renamed from: c  reason: collision with root package name */
    public int f29337c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29338d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f29339e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f29340f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView.ScaleType f29341g;

    /* loaded from: classes4.dex */
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
        f29335h = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
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
        this.f29336b = 2;
        this.f29337c = -16777216;
    }

    public int getBorder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29336b : invokeV.intValue;
    }

    public int getBorderColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29337c : invokeV.intValue;
    }

    public int getCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29341g : (ImageView.ScaleType) invokeV.objValue;
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
            if (this.f29338d && drawable != null) {
                this.f29340f = b.b(drawable, this.f29341g, this.a, this.f29336b, this.f29337c);
            } else {
                this.f29340f = drawable;
            }
            super.setBackgroundDrawable(this.f29340f);
        }
    }

    public void setBorderColor(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.f29337c == i) {
            return;
        }
        this.f29337c = i;
        Drawable drawable = this.f29339e;
        if (drawable instanceof b) {
            ((b) drawable).d(i);
        }
        if (this.f29338d) {
            Drawable drawable2 = this.f29340f;
            if (drawable2 instanceof b) {
                ((b) drawable2).d(i);
            }
        }
        if (this.f29336b > 0) {
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || this.f29336b == i) {
            return;
        }
        this.f29336b = i;
        Drawable drawable = this.f29339e;
        if (drawable instanceof b) {
            ((b) drawable).e(i);
        }
        if (this.f29338d) {
            Drawable drawable2 = this.f29340f;
            if (drawable2 instanceof b) {
                ((b) drawable2).e(i);
            }
        }
        invalidate();
    }

    public void setCornerRadius(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || this.a == i) {
            return;
        }
        this.a = i;
        Drawable drawable = this.f29339e;
        if (drawable instanceof b) {
            ((b) drawable).f(i);
        }
        if (this.f29338d) {
            Drawable drawable2 = this.f29340f;
            if (drawable2 instanceof b) {
                ((b) drawable2).f(i);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bitmap) == null) {
            if (bitmap != null) {
                b bVar = new b(bitmap, this.a, this.f29336b, this.f29337c);
                this.f29339e = bVar;
                ImageView.ScaleType scaleType = this.f29341g;
                if (scaleType != null) {
                    bVar.h(scaleType);
                }
            } else {
                this.f29339e = null;
            }
            super.setImageDrawable(this.f29339e);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) {
            if (drawable != null) {
                this.f29339e = b.b(drawable, this.f29341g, this.a, this.f29336b, this.f29337c);
            } else {
                this.f29339e = null;
            }
            super.setImageDrawable(this.f29339e);
        }
    }

    public void setRoundBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.f29338d == z) {
            return;
        }
        this.f29338d = z;
        if (z) {
            Drawable drawable = this.f29340f;
            if (drawable instanceof b) {
                ((b) drawable).h(this.f29341g);
                ((b) this.f29340f).f(this.a);
                ((b) this.f29340f).e(this.f29336b);
                ((b) this.f29340f).d(this.f29337c);
            } else {
                setBackgroundDrawable(drawable);
            }
        } else {
            Drawable drawable2 = this.f29340f;
            if (drawable2 instanceof b) {
                ((b) drawable2).e(0);
                ((b) this.f29340f).f(0.0f);
            }
        }
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, scaleType) == null) || scaleType == null || this.f29341g == scaleType) {
            return;
        }
        this.f29341g = scaleType;
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
        Drawable drawable = this.f29339e;
        if ((drawable instanceof b) && ((b) drawable).c() != scaleType) {
            ((b) this.f29339e).h(scaleType);
        }
        Drawable drawable2 = this.f29340f;
        if ((drawable2 instanceof b) && ((b) drawable2).c() != scaleType) {
            ((b) this.f29340f).h(scaleType);
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843037, R.attr.obfuscated_res_0x7f0400e1, R.attr.obfuscated_res_0x7f0400e2, R.attr.obfuscated_res_0x7f040193, R.attr.obfuscated_res_0x7f040512}, i, 0);
        int i4 = obtainStyledAttributes.getInt(0, -1);
        if (i4 >= 0) {
            setScaleType(f29335h[i4]);
        }
        this.a = obtainStyledAttributes.getDimensionPixelSize(3, -1);
        this.f29336b = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        if (this.a < 0) {
            this.a = 20;
        }
        if (this.f29336b < 0) {
            this.f29336b = 2;
        }
        this.f29337c = obtainStyledAttributes.getColor(1, -16777216);
        this.f29338d = obtainStyledAttributes.getBoolean(4, false);
        obtainStyledAttributes.recycle();
    }
}
