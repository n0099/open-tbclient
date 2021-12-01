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
import c.a.p0.a.c;
import c.a.p0.a.c2.b.e.a;
import c.a.p0.a.c2.b.e.b;
import c.a.p0.a.d;
import c.a.p0.a.e;
import c.a.p0.a.f;
import c.a.p0.a.g;
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
/* loaded from: classes9.dex */
public class CommonOverflowMenuView extends LinearLayout implements a.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f39761e;

    /* renamed from: f  reason: collision with root package name */
    public int f39762f;

    /* renamed from: g  reason: collision with root package name */
    public int f39763g;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f39764h;

    /* renamed from: i  reason: collision with root package name */
    public List<ImageView> f39765i;

    /* renamed from: j  reason: collision with root package name */
    public List<TextView> f39766j;

    /* renamed from: k  reason: collision with root package name */
    public HashMap<c.a.p0.a.c2.b.e.b, ImageView> f39767k;
    public boolean l;
    public View m;
    public LinearLayout n;
    public SwanAppScrollView o;
    public SparseArray<View> p;
    public Object q;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.c2.b.e.b f39768e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommonOverflowMenuView f39769f;

        public a(CommonOverflowMenuView commonOverflowMenuView, c.a.p0.a.c2.b.e.b bVar) {
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
            this.f39769f = commonOverflowMenuView;
            this.f39768e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f39769f.c(this.f39768e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c.a.p0.a.j2.a {
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
        this.f39761e = e.aiapps_discovery_home_menu_item_selector;
        this.f39762f = c.aiapps_home_menu_separator_color;
        this.f39763g = 1;
        this.f39765i = new ArrayList();
        this.f39766j = new ArrayList();
        this.f39767k = new HashMap<>();
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

    public final void c(c.a.p0.a.c2.b.e.b bVar) {
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
            this.f39764h = AppCompatResources.getColorStateList(getContext(), c.aiapps_discovery_home_menu_text_color);
            setBackground(getResources().getDrawable(e.aiapps_discovery_feedback_menu_bg));
            for (ImageView imageView : this.f39765i) {
                imageView.setBackgroundColor(getResources().getColor(this.f39762f));
            }
            for (TextView textView : this.f39766j) {
                textView.setTextColor(this.f39764h);
            }
            for (Map.Entry<c.a.p0.a.c2.b.e.b, ImageView> entry : this.f39767k.entrySet()) {
                entry.getValue().setImageDrawable(entry.getKey().b());
            }
        }
    }

    public int getItemBgRes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39761e : invokeV.intValue;
    }

    public LinearLayout getLinearContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (LinearLayout) invokeV.objValue;
    }

    public View getMenuItemView(Context context, c.a.p0.a.c2.b.e.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, bVar)) == null) {
            View inflate = LayoutInflater.from(context).inflate(g.aiapps_pulldown_item, (ViewGroup) this.n, false);
            inflate.findViewById(f.item).setBackgroundResource(this.f39761e);
            ImageView imageView = (ImageView) inflate.findViewById(f.left_img);
            this.f39767k.put(bVar, imageView);
            imageView.setImageDrawable(bVar.b());
            TextView textView = (TextView) inflate.findViewById(f.right_txt);
            this.f39766j.add(textView);
            textView.setText(bVar.e());
            textView.setTextColor(this.f39764h);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f39764h : (ColorStateList) invokeV.objValue;
    }

    public void layoutMenu(List<c.a.p0.a.c2.b.e.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || this.l) {
            return;
        }
        this.n.removeAllViews();
        this.p.clear();
        Context context = getContext();
        if (this.f39763g < 0) {
            this.f39763g = context.getResources().getDimensionPixelSize(d.aiapps_pulldown_divider_height);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f39763g);
        int i2 = 0;
        for (c.a.p0.a.c2.b.e.b bVar : list) {
            View menuItemView = getMenuItemView(context, bVar);
            if (bVar.g()) {
                menuItemView.setOnClickListener(new a(this, bVar));
            }
            this.n.addView(menuItemView);
            this.p.append(bVar.c(), menuItemView);
            if (i2 < list.size() - 1) {
                ImageView imageView = new ImageView(context);
                this.f39765i.add(imageView);
                imageView.setBackgroundColor(getResources().getColor(this.f39762f));
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
            c.a.p0.a.c1.a.M().f(this.q, new b(this));
            d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            c.a.p0.a.c1.a.M().g(this.q);
        }
    }

    public void onMenuItemUpdated(c.a.p0.a.c2.b.e.b bVar) {
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
            this.f39761e = i2;
        }
    }

    public void setItemDivider(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            this.f39762f = i2;
            this.f39763g = i3;
        }
    }

    public void setItemTextColor(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f39764h = AppCompatResources.getColorStateList(getContext(), i2);
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
        this.f39761e = e.aiapps_discovery_home_menu_item_selector;
        this.f39762f = c.aiapps_home_menu_separator_color;
        this.f39763g = 1;
        this.f39765i = new ArrayList();
        this.f39766j = new ArrayList();
        this.f39767k = new HashMap<>();
        this.l = false;
        this.p = new SparseArray<>();
        this.q = new Object();
        b(context);
    }
}
