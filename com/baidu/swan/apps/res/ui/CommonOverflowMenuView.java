package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c;
import d.a.q0.a.e;
import d.a.q0.a.f;
import d.a.q0.a.g;
import d.a.q0.a.z1.b.e.a;
import d.a.q0.a.z1.b.e.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class CommonOverflowMenuView extends LinearLayout implements a.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f11291e;

    /* renamed from: f  reason: collision with root package name */
    public int f11292f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f11293g;

    /* renamed from: h  reason: collision with root package name */
    public List<ImageView> f11294h;

    /* renamed from: i  reason: collision with root package name */
    public List<TextView> f11295i;
    public HashMap<b, ImageView> j;
    public View k;
    public LinearLayout l;
    public SwanAppScrollView m;
    public Object n;

    /* loaded from: classes4.dex */
    public class a implements d.a.q0.a.g2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonOverflowMenuView f11296a;

        public a(CommonOverflowMenuView commonOverflowMenuView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonOverflowMenuView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11296a = commonOverflowMenuView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonOverflowMenuView(Context context) {
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
        this.f11291e = e.aiapps_discovery_home_menu_item_selector;
        this.f11292f = c.aiapps_home_menu_separator_color;
        this.f11294h = new ArrayList();
        this.f11295i = new ArrayList();
        this.j = new HashMap<>();
        new SparseArray();
        this.n = new Object();
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(g.aiapps_menu_scroll_view, (ViewGroup) this, true);
            this.k = inflate;
            this.l = (LinearLayout) inflate.findViewById(f.menu_linear);
            this.m = (SwanAppScrollView) this.k.findViewById(f.menu_scrollview);
            setFocusable(true);
            setFocusableInTouchMode(true);
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f11293g = getResources().getColorStateList(c.aiapps_discovery_home_menu_text_color);
            setBackground(getResources().getDrawable(e.aiapps_discovery_feedback_menu_bg));
            for (ImageView imageView : this.f11294h) {
                imageView.setBackgroundColor(getResources().getColor(this.f11292f));
            }
            for (TextView textView : this.f11295i) {
                textView.setTextColor(this.f11293g);
            }
            for (Map.Entry<b, ImageView> entry : this.j.entrySet()) {
                entry.getValue().setImageDrawable(entry.getKey().b());
            }
        }
    }

    public int getItemBgRes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11291e : invokeV.intValue;
    }

    public LinearLayout getLinearContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (LinearLayout) invokeV.objValue;
    }

    public ColorStateList getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11293g : (ColorStateList) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            d.a.q0.a.c1.a.H().f(this.n, new a(this));
            b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            d.a.q0.a.c1.a.H().g(this.n);
        }
    }

    public void setItemBackground(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f11291e = i2;
        }
    }

    public void setItemDivider(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            this.f11292f = i2;
        }
    }

    public void setItemTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f11293g = getResources().getColorStateList(i2);
        }
    }

    public void setMaxHeightPixel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.m.setMaxHeight(i2);
        }
    }

    public void setMaxHeightRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.m.setMaxHeight(getContext().getResources().getDimensionPixelSize(i2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonOverflowMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11291e = e.aiapps_discovery_home_menu_item_selector;
        this.f11292f = c.aiapps_home_menu_separator_color;
        this.f11294h = new ArrayList();
        this.f11295i = new ArrayList();
        this.j = new HashMap<>();
        new SparseArray();
        this.n = new Object();
        a(context);
    }
}
