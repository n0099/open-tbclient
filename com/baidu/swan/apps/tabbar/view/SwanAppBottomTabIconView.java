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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SwanAppBottomTabIconView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f38057e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f38058f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f38059g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f38060h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f38061i;

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
        LayoutInflater.from(context).inflate(R.layout.aiapps_bottom_tab_icon, (ViewGroup) this, true);
        this.f38057e = (ImageView) findViewById(R.id.bottom_tab_icon);
        this.f38058f = (TextView) findViewById(R.id.bottom_tab_text);
        this.f38059g = (ImageView) findViewById(R.id.bottom_tab_red_dot);
        this.f38060h = (TextView) findViewById(R.id.bottom_tab_badge);
    }

    public boolean ismIsSelect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38061i : invokeV.booleanValue;
    }

    public void setBadgeText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f38060h.setText(str);
        }
    }

    public void setBadgeVisibleState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.f38060h.setVisibility(0);
            } else {
                this.f38060h.setVisibility(8);
            }
        }
    }

    public void setIconView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f38057e.setImageDrawable(getResources().getDrawable(i2));
        }
    }

    public void setRedDotVisibleState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.f38059g.setVisibility(0);
            } else {
                this.f38059g.setVisibility(8);
            }
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f38058f.setTextColor(i2);
        }
    }

    public void setTextView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f38058f.setText(str);
        }
    }

    public void setmIsSelect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f38061i = z;
        }
    }

    public void setIconView(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bitmap) == null) {
            this.f38057e.setImageBitmap(bitmap);
        }
    }

    public void setIconView(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, drawable) == null) {
            this.f38057e.setImageDrawable(drawable);
        }
    }
}
