package com.baidu.swan.apps.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.c2.a.b;
import c.a.p0.a.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes9.dex */
public class SwanAppRoundedImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BORDER = 2;
    public static final int DEFAULT_BORDER_COLOR = -16777216;
    public static final int DEFAULT_RADIUS = 20;
    public static final String TAG = "SwanAppRoundedImageView";
    public static final ImageView.ScaleType[] l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f40173e;

    /* renamed from: f  reason: collision with root package name */
    public int f40174f;

    /* renamed from: g  reason: collision with root package name */
    public int f40175g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40176h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f40177i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f40178j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView.ScaleType f40179k;

    /* loaded from: classes9.dex */
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
        this.f40173e = 20;
        this.f40174f = 2;
        this.f40175g = -16777216;
    }

    public int getBorder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40174f : invokeV.intValue;
    }

    public int getBorderColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f40175g : invokeV.intValue;
    }

    public int getCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40173e : invokeV.intValue;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40179k : (ImageView.ScaleType) invokeV.objValue;
    }

    public boolean isRoundBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40176h : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, drawable) == null) {
            setBackgroundDrawable(drawable);
        }
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, drawable) == null) {
            if (this.f40176h && drawable != null) {
                this.f40178j = b.b(drawable, this.f40179k, this.f40173e, this.f40174f, this.f40175g);
            } else {
                this.f40178j = drawable;
            }
            super.setBackgroundDrawable(this.f40178j);
        }
    }

    public void setBorderColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f40175g == i2) {
            return;
        }
        this.f40175g = i2;
        Drawable drawable = this.f40177i;
        if (drawable instanceof b) {
            ((b) drawable).d(i2);
        }
        if (this.f40176h) {
            Drawable drawable2 = this.f40178j;
            if (drawable2 instanceof b) {
                ((b) drawable2).d(i2);
            }
        }
        if (this.f40174f > 0) {
            invalidate();
        }
    }

    public void setBorderWidth(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f40174f == i2) {
            return;
        }
        this.f40174f = i2;
        Drawable drawable = this.f40177i;
        if (drawable instanceof b) {
            ((b) drawable).e(i2);
        }
        if (this.f40176h) {
            Drawable drawable2 = this.f40178j;
            if (drawable2 instanceof b) {
                ((b) drawable2).e(i2);
            }
        }
        invalidate();
    }

    public void setCornerRadius(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.f40173e == i2) {
            return;
        }
        this.f40173e = i2;
        Drawable drawable = this.f40177i;
        if (drawable instanceof b) {
            ((b) drawable).f(i2);
        }
        if (this.f40176h) {
            Drawable drawable2 = this.f40178j;
            if (drawable2 instanceof b) {
                ((b) drawable2).f(i2);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bitmap) == null) {
            if (bitmap != null) {
                b bVar = new b(bitmap, this.f40173e, this.f40174f, this.f40175g);
                this.f40177i = bVar;
                ImageView.ScaleType scaleType = this.f40179k;
                if (scaleType != null) {
                    bVar.h(scaleType);
                }
            } else {
                this.f40177i = null;
            }
            super.setImageDrawable(this.f40177i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, drawable) == null) {
            if (drawable != null) {
                this.f40177i = b.b(drawable, this.f40179k, this.f40173e, this.f40174f, this.f40175g);
            } else {
                this.f40177i = null;
            }
            super.setImageDrawable(this.f40177i);
        }
    }

    public void setRoundBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || this.f40176h == z) {
            return;
        }
        this.f40176h = z;
        if (z) {
            Drawable drawable = this.f40178j;
            if (drawable instanceof b) {
                ((b) drawable).h(this.f40179k);
                ((b) this.f40178j).f(this.f40173e);
                ((b) this.f40178j).e(this.f40174f);
                ((b) this.f40178j).d(this.f40175g);
            } else {
                setBackgroundDrawable(drawable);
            }
        } else {
            Drawable drawable2 = this.f40178j;
            if (drawable2 instanceof b) {
                ((b) drawable2).e(0);
                ((b) this.f40178j).f(0.0f);
            }
        }
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, scaleType) == null) || scaleType == null || this.f40179k == scaleType) {
            return;
        }
        this.f40179k = scaleType;
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
        Drawable drawable = this.f40177i;
        if ((drawable instanceof b) && ((b) drawable).c() != scaleType) {
            ((b) this.f40177i).h(scaleType);
        }
        Drawable drawable2 = this.f40178j;
        if ((drawable2 instanceof b) && ((b) drawable2).c() != scaleType) {
            ((b) this.f40178j).h(scaleType);
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
        this.f40173e = obtainStyledAttributes.getDimensionPixelSize(j.RoundedImageView_corner_radius, -1);
        this.f40174f = obtainStyledAttributes.getDimensionPixelSize(j.RoundedImageView_border_width, -1);
        if (this.f40173e < 0) {
            this.f40173e = 20;
        }
        if (this.f40174f < 0) {
            this.f40174f = 2;
        }
        this.f40175g = obtainStyledAttributes.getColor(j.RoundedImageView_border_color, -16777216);
        this.f40176h = obtainStyledAttributes.getBoolean(j.RoundedImageView_round_background, false);
        obtainStyledAttributes.recycle();
    }
}
