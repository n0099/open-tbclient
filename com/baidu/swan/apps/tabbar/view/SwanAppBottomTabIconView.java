package com.baidu.swan.apps.tabbar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f;
import b.a.p0.a.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SwanAppBottomTabIconView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f44288e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f44289f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f44290g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44291h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f44292i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppBottomTabIconView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        LayoutInflater.from(context).inflate(g.aiapps_bottom_tab_icon, (ViewGroup) this, true);
        this.f44288e = (ImageView) findViewById(f.bottom_tab_icon);
        this.f44289f = (TextView) findViewById(f.bottom_tab_text);
        this.f44290g = (ImageView) findViewById(f.bottom_tab_red_dot);
        this.f44291h = (TextView) findViewById(f.bottom_tab_badge);
    }

    public boolean ismIsSelect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f44292i : invokeV.booleanValue;
    }

    public void setBadgeText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f44291h.setText(str);
        }
    }

    public void setBadgeVisibleState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.f44291h.setVisibility(0);
            } else {
                this.f44291h.setVisibility(8);
            }
        }
    }

    public void setIconView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f44288e.setImageDrawable(getResources().getDrawable(i2));
        }
    }

    public void setRedDotVisibleState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.f44290g.setVisibility(0);
            } else {
                this.f44290g.setVisibility(8);
            }
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f44289f.setTextColor(i2);
        }
    }

    public void setTextView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f44289f.setText(str);
        }
    }

    public void setmIsSelect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f44292i = z;
        }
    }

    public void setIconView(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bitmap) == null) {
            this.f44288e.setImageBitmap(bitmap);
        }
    }

    public void setIconView(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, drawable) == null) {
            this.f44288e.setImageDrawable(drawable);
        }
    }
}
