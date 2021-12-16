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
import androidx.annotation.ColorRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.c;
import c.a.q0.a.c2.b.e.a;
import c.a.q0.a.c2.b.e.b;
import c.a.q0.a.d;
import c.a.q0.a.e;
import c.a.q0.a.f;
import c.a.q0.a.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class CommonOverflowMenuView extends LinearLayout implements a.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f40250e;

    /* renamed from: f  reason: collision with root package name */
    public int f40251f;

    /* renamed from: g  reason: collision with root package name */
    public int f40252g;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f40253h;

    /* renamed from: i  reason: collision with root package name */
    public List<ImageView> f40254i;

    /* renamed from: j  reason: collision with root package name */
    public List<TextView> f40255j;

    /* renamed from: k  reason: collision with root package name */
    public HashMap<c.a.q0.a.c2.b.e.b, ImageView> f40256k;
    public boolean l;
    public View m;
    public LinearLayout n;
    public SwanAppScrollView o;
    public SparseArray<View> p;
    public Object q;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.c2.b.e.b f40257e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommonOverflowMenuView f40258f;

        public a(CommonOverflowMenuView commonOverflowMenuView, c.a.q0.a.c2.b.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonOverflowMenuView, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40258f = commonOverflowMenuView;
            this.f40257e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f40258f.c(this.f40257e);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements c.a.q0.a.j2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonOverflowMenuView a;

        public b(CommonOverflowMenuView commonOverflowMenuView) {
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
            this.a = commonOverflowMenuView;
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
        this.f40250e = e.aiapps_discovery_home_menu_item_selector;
        this.f40251f = c.aiapps_home_menu_separator_color;
        this.f40252g = 1;
        this.f40254i = new ArrayList();
        this.f40255j = new ArrayList();
        this.f40256k = new HashMap<>();
        this.l = false;
        this.p = new SparseArray<>();
        this.q = new Object();
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(g.aiapps_menu_scroll_view, (ViewGroup) this, true);
            this.m = inflate;
            this.n = (LinearLayout) inflate.findViewById(f.menu_linear);
            this.o = (SwanAppScrollView) this.m.findViewById(f.menu_scrollview);
            setFocusable(true);
            setFocusableInTouchMode(true);
            d();
        }
    }

    public final void c(c.a.q0.a.c2.b.e.b bVar) {
        b.a d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (d2 = bVar.d()) == null) {
            return;
        }
        d2.a(bVar);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f40253h = AppCompatResources.getColorStateList(getContext(), c.aiapps_discovery_home_menu_text_color);
            setBackground(getResources().getDrawable(e.aiapps_discovery_feedback_menu_bg));
            for (ImageView imageView : this.f40254i) {
                imageView.setBackgroundColor(getResources().getColor(this.f40251f));
            }
            for (TextView textView : this.f40255j) {
                textView.setTextColor(this.f40253h);
            }
            for (Map.Entry<c.a.q0.a.c2.b.e.b, ImageView> entry : this.f40256k.entrySet()) {
                entry.getValue().setImageDrawable(entry.getKey().b());
            }
        }
    }

    public int getItemBgRes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40250e : invokeV.intValue;
    }

    public LinearLayout getLinearContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (LinearLayout) invokeV.objValue;
    }

    public View getMenuItemView(Context context, c.a.q0.a.c2.b.e.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, bVar)) == null) {
            View inflate = LayoutInflater.from(context).inflate(g.aiapps_pulldown_item, (ViewGroup) this.n, false);
            inflate.findViewById(f.item).setBackgroundResource(this.f40250e);
            ImageView imageView = (ImageView) inflate.findViewById(f.left_img);
            this.f40256k.put(bVar, imageView);
            imageView.setImageDrawable(bVar.b());
            TextView textView = (TextView) inflate.findViewById(f.right_txt);
            this.f40255j.add(textView);
            textView.setText(bVar.e());
            textView.setTextColor(this.f40253h);
            inflate.setEnabled(bVar.g());
            imageView.setEnabled(bVar.g());
            textView.setEnabled(bVar.g());
            return inflate;
        }
        return (View) invokeLL.objValue;
    }

    public ColorStateList getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f40253h : (ColorStateList) invokeV.objValue;
    }

    public void layoutMenu(List<c.a.q0.a.c2.b.e.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || this.l) {
            return;
        }
        this.n.removeAllViews();
        this.p.clear();
        Context context = getContext();
        if (this.f40252g < 0) {
            this.f40252g = context.getResources().getDimensionPixelSize(d.aiapps_pulldown_divider_height);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f40252g);
        int i2 = 0;
        for (c.a.q0.a.c2.b.e.b bVar : list) {
            View menuItemView = getMenuItemView(context, bVar);
            if (bVar.g()) {
                menuItemView.setOnClickListener(new a(this, bVar));
            }
            this.n.addView(menuItemView);
            this.p.append(bVar.c(), menuItemView);
            if (i2 < list.size() - 1) {
                ImageView imageView = new ImageView(context);
                this.f40254i.add(imageView);
                imageView.setBackgroundColor(getResources().getColor(this.f40251f));
                this.n.addView(imageView, layoutParams);
            }
            i2++;
        }
        this.l = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            c.a.q0.a.c1.a.M().f(this.q, new b(this));
            d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            c.a.q0.a.c1.a.M().g(this.q);
        }
    }

    public void onMenuItemUpdated(c.a.q0.a.c2.b.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
        }
    }

    public void onMenuSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = false;
        }
    }

    public void setItemBackground(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f40250e = i2;
        }
    }

    public void setItemDivider(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            this.f40251f = i2;
            this.f40252g = i3;
        }
    }

    public void setItemTextColor(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f40253h = AppCompatResources.getColorStateList(getContext(), i2);
        }
    }

    public void setMaxHeightPixel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.o.setMaxHeight(i2);
        }
    }

    public void setMaxHeightRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.o.setMaxHeight(getContext().getResources().getDimensionPixelSize(i2));
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
        this.f40250e = e.aiapps_discovery_home_menu_item_selector;
        this.f40251f = c.aiapps_home_menu_separator_color;
        this.f40252g = 1;
        this.f40254i = new ArrayList();
        this.f40255j = new ArrayList();
        this.f40256k = new HashMap<>();
        this.l = false;
        this.p = new SparseArray<>();
        this.q = new Object();
        b(context);
    }
}
