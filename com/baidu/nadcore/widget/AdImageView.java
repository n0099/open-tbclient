package com.baidu.nadcore.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.l0.a;
import c.a.b0.l0.n;
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

    /* renamed from: e  reason: collision with root package name */
    public final n f35877e;

    /* renamed from: f  reason: collision with root package name */
    public IAdImageView.ImageScaleType f35878f;

    /* renamed from: g  reason: collision with root package name */
    public final Path f35879g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdImageView(@NonNull Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.adCornerRadius, R.attr.borderColor, R.attr.borderColorWidth, R.attr.circleType, R.attr.errorHolder, R.attr.holder, R.attr.imageScaleType, R.attr.leftBottomRadius, R.attr.leftTopRadius, R.attr.loadingHolder, R.attr.rightBottomRadius, R.attr.rightTopRadius});
        int resourceId = obtainStyledAttributes.getResourceId(5, 0);
        if (resourceId != 0) {
            this.f35877e.a = resourceId;
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(4, 0);
        if (resourceId2 != 0) {
            this.f35877e.f1822c = resourceId2;
        }
        n.a aVar = new n.a();
        if (obtainStyledAttributes.getBoolean(3, false)) {
            aVar.a = true;
        } else {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize > 0) {
                float floatValue = Integer.valueOf(dimensionPixelSize).floatValue();
                aVar.f1824b = new float[]{floatValue, floatValue, floatValue, floatValue};
            } else {
                aVar.f1824b = new float[]{obtainStyledAttributes.getDimensionPixelSize(8, 0), obtainStyledAttributes.getDimensionPixelSize(11, 0), obtainStyledAttributes.getDimensionPixelSize(7, 0), obtainStyledAttributes.getDimensionPixelSize(10, 0)};
            }
        }
        this.f35877e.f1823d = aVar;
        int i2 = obtainStyledAttributes.getInt(6, -1);
        if (i2 >= 0) {
            setScaleType(IAdImageView.j0[i2]);
        }
        obtainStyledAttributes.recycle();
    }

    public void displayBlurBackground(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, i3) == null) {
            a.a().a(str, this, i2, i3);
        }
    }

    public void displayImage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                setImageBitmap(null);
            } else {
                a.a().e(str, this);
            }
        }
    }

    @NonNull
    public n getConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f35877e : (n) invokeV.objValue;
    }

    public IAdImageView.ImageScaleType getImageScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f35878f : (IAdImageView.ImageScaleType) invokeV.objValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            n.a aVar = getConfig().f1823d;
            if (aVar == null) {
                super.onDraw(canvas);
                return;
            }
            int width = getWidth();
            int height = getHeight();
            if (aVar.a) {
                this.f35879g.addCircle(width / 2.0f, height / 2.0f, Math.min(width, height) / 2, Path.Direction.CCW);
                canvas.clipPath(this.f35879g);
                super.onDraw(canvas);
                return;
            }
            float[] fArr = aVar.f1824b;
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
                    this.f35879g.moveTo(fArr[0], 0.0f);
                    this.f35879g.lineTo(f2 - fArr[1], 0.0f);
                    this.f35879g.quadTo(f2, 0.0f, f2, fArr[1]);
                    this.f35879g.lineTo(f2, f3 - fArr[3]);
                    this.f35879g.quadTo(f2, f3, f2 - fArr[3], f3);
                    this.f35879g.lineTo(fArr[2], f3);
                    this.f35879g.quadTo(0.0f, f3, 0.0f, f3 - fArr[2]);
                    this.f35879g.lineTo(0.0f, fArr[0]);
                    this.f35879g.quadTo(0.0f, 0.0f, fArr[0], 0.0f);
                    canvas.clipPath(this.f35879g);
                }
            }
            super.onDraw(canvas);
        }
    }

    public void preloadImage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            a.a().c(str);
        }
    }

    @NonNull
    public ImageView rawImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (ImageView) invokeV.objValue;
    }

    public void setBorder(float f2, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            n.a aVar = this.f35877e.f1823d;
            if (aVar == null) {
                aVar = new n.a();
            }
            aVar.f1825c = f2;
            aVar.f1826d = i2;
            this.f35877e.f1823d = aVar;
        }
    }

    public void setCircle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            n.a aVar = this.f35877e.f1823d;
            if (aVar == null) {
                aVar = new n.a();
            }
            aVar.a = true;
            this.f35877e.f1823d = aVar;
        }
    }

    public void setImageScaleType(IAdImageView.ImageScaleType imageScaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, imageScaleType) == null) {
            if (imageScaleType != null) {
                if (this.f35878f != imageScaleType) {
                    this.f35878f = imageScaleType;
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
        if (interceptable == null || interceptable.invokeL(1048587, this, drawable) == null) {
            this.f35877e.f1821b = drawable;
        }
    }

    public void setRadius(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            n.a aVar = this.f35877e.f1823d;
            if (aVar == null) {
                aVar = new n.a();
            }
            aVar.a = false;
            aVar.f1824b = new float[]{f2, f3, f4, f5};
            this.f35877e.f1823d = aVar;
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
    public AdImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f35877e = new n();
        this.f35879g = new Path();
        a(attributeSet);
    }
}
