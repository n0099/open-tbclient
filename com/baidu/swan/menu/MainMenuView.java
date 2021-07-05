package com.baidu.swan.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.k.g;
import d.a.q0.k.o;
import java.util.List;
/* loaded from: classes4.dex */
public class MainMenuView extends BaseMenuView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout j;
    public View k;
    public View l;
    public RecyclerView m;
    public MenuContentAdapter n;
    public RecyclerView o;
    public MenuContentAdapter p;
    public List<List<o>> q;
    public View r;
    public boolean s;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MainMenuView(@NonNull Context context) {
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

    private void setMenuHeader(View view) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, view) == null) || view == null || view == (view2 = this.k)) {
            return;
        }
        if (view2 != null) {
            this.j.removeView(view2);
        }
        this.k = view;
        this.j.addView(view, 0);
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<List<o>> list = this.q;
            return list != null && list.size() > 1;
        }
        return invokeV.booleanValue;
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.l.setVisibility(0);
            this.o.setVisibility(0);
            if (this.n == null) {
                MenuContentAdapter menuContentAdapter = new MenuContentAdapter(getContext());
                this.n = menuContentAdapter;
                this.m.setAdapter(menuContentAdapter);
            }
            this.n.g(this.q.subList(0, 1), this.s, i2);
            if (this.p == null) {
                MenuContentAdapter menuContentAdapter2 = new MenuContentAdapter(getContext());
                this.p = menuContentAdapter2;
                this.o.setAdapter(menuContentAdapter2);
            }
            this.p.g(this.q.subList(1, 2), this.s, i2);
        }
    }

    public final void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.l.setVisibility(8);
            this.o.setVisibility(8);
            if (this.n == null) {
                MenuContentAdapter menuContentAdapter = new MenuContentAdapter(getContext());
                this.n = menuContentAdapter;
                this.m.setAdapter(menuContentAdapter);
            }
            this.n.g(this.q, this.s, i2);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MenuContentAdapter menuContentAdapter = this.n;
            if (menuContentAdapter != null) {
                menuContentAdapter.notifyDataSetChanged();
            }
            MenuContentAdapter menuContentAdapter2 = this.p;
            if (menuContentAdapter2 != null) {
                menuContentAdapter2.notifyDataSetChanged();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            RecyclerView recyclerView = this.m;
            if (recyclerView != null) {
                recyclerView.scrollToPosition(0);
            }
            if (this.o != null) {
                this.m.scrollToPosition(0);
            }
        }
    }

    @Nullable
    public View getCoverView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.r : (View) invokeV.objValue;
    }

    public void h(List<List<o>> list, View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            setMode();
            setMenuHeader(view);
            i(list, z, i2);
        }
    }

    public final void i(List<List<o>> list, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.q = list;
            this.s = z;
            if (z && list.size() > 1) {
                d(i2);
            } else {
                e(i2);
            }
        }
    }

    public void setCoverView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            this.r = view;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
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
        LinearLayout linearLayout = new LinearLayout(context, attributeSet, i2);
        this.j = linearLayout;
        linearLayout.setOrientation(1);
        RecyclerView recyclerView = new RecyclerView(context, attributeSet, i2);
        this.m = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.m.setPadding(0, (int) this.f12005e.getResources().getDimension(g.aiapp_menu_gridview_padding_top), 0, 0);
        this.j.addView(this.m, layoutParams);
        View view = new View(context);
        this.l = view;
        view.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.j.addView(this.l, layoutParams2);
        RecyclerView recyclerView2 = new RecyclerView(context, attributeSet, i2);
        this.o = recyclerView2;
        recyclerView2.setVisibility(8);
        this.o.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.j.addView(this.o, new LinearLayout.LayoutParams(-1, -2));
        c(this.j, new FrameLayout.LayoutParams(-1, -2));
    }
}
