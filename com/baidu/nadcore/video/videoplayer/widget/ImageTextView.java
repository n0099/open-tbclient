package com.baidu.nadcore.video.videoplayer.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.e0.a.d.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ImageTextView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final int f38244h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f38245e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f38246f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38247g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(644798021, "Lcom/baidu/nadcore/video/videoplayer/widget/ImageTextView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(644798021, "Lcom/baidu/nadcore/video/videoplayer/widget/ImageTextView;");
                return;
            }
        }
        f38244h = b.a(4.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageTextView(Context context) {
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
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            setGravity(17);
            ImageView imageView = new ImageView(getContext());
            this.f38246f = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.f38246f, new LinearLayout.LayoutParams(-2, -2));
            TextView textView = new TextView(getContext());
            this.f38247g = textView;
            textView.setTextColor(-1);
            this.f38247g.setTextSize(12.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, f38244h, 0, 0);
            addView(this.f38247g, layoutParams);
        }
    }

    public void clearTitle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f38247g.setText((CharSequence) null);
        }
    }

    public ImageTextView setIcon(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, drawable)) == null) {
            this.f38246f.setImageDrawable(drawable);
            this.f38246f.setVisibility(0);
            return this;
        }
        return (ImageTextView) invokeL.objValue;
    }

    public void setIconAndTitle(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            if (i2 != 0) {
                if (this.f38245e != i2) {
                    this.f38246f.setImageResource(i2);
                    this.f38246f.setVisibility(0);
                    this.f38245e = i2;
                }
            } else {
                this.f38246f.setImageDrawable(null);
                this.f38246f.setVisibility(8);
            }
            if (i3 != 0) {
                this.f38247g.setText(i3);
                this.f38247g.setVisibility(0);
                return;
            }
            this.f38247g.setText((CharSequence) null);
            this.f38247g.setVisibility(8);
        }
    }

    public ImageTextView setIconBackground(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.f38246f.setBackgroundResource(i2);
            this.f38246f.setVisibility(0);
            return this;
        }
        return (ImageTextView) invokeI.objValue;
    }

    public ImageTextView setIconSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) {
            this.f38246f.setLayoutParams(new LinearLayout.LayoutParams(i2, i3));
            return this;
        }
        return (ImageTextView) invokeII.objValue;
    }

    public ImageTextView setTextColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.f38247g.setTextColor(getResources().getColorStateList(i2));
            return this;
        }
        return (ImageTextView) invokeI.objValue;
    }

    public ImageTextView setTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? setTitle(getContext().getString(i2)) : (ImageTextView) invokeI.objValue;
    }

    public ImageTextView setTitle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (str != null) {
                this.f38247g.setText(str);
                this.f38247g.setVisibility(0);
            } else {
                this.f38247g.setText((CharSequence) null);
                this.f38247g.setVisibility(8);
            }
            return this;
        }
        return (ImageTextView) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }

    public ImageTextView setIcon(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f38246f.setImageResource(i2);
            this.f38246f.setVisibility(0);
            return this;
        }
        return (ImageTextView) invokeI.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageTextView(Context context, AttributeSet attributeSet, int i2) {
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
        a();
    }
}
