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
import c.a.p0.n.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class MainMenuView extends BaseMenuView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f38566h;

    /* renamed from: i  reason: collision with root package name */
    public View f38567i;

    /* renamed from: j  reason: collision with root package name */
    public View f38568j;
    public RecyclerView k;
    public MenuContentAdapter l;
    public RecyclerView m;
    public MenuContentAdapter n;
    public List<List<g>> o;
    public View p;
    public boolean q;

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
        if (!(interceptable == null || interceptable.invokeL(65539, this, view) == null) || view == null || view == (view2 = this.f38567i)) {
            return;
        }
        if (view2 != null) {
            this.f38566h.removeView(view2);
        }
        this.f38567i = view;
        this.f38566h.addView(view, 0);
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f38568j.setVisibility(0);
            this.m.setVisibility(0);
            if (this.l == null) {
                MenuContentAdapter menuContentAdapter = new MenuContentAdapter(getContext());
                this.l = menuContentAdapter;
                this.k.setAdapter(menuContentAdapter);
            }
            this.l.updateData(this.o.subList(0, 1), this.q, i2);
            if (this.n == null) {
                MenuContentAdapter menuContentAdapter2 = new MenuContentAdapter(getContext());
                this.n = menuContentAdapter2;
                this.m.setAdapter(menuContentAdapter2);
            }
            this.n.updateData(this.o.subList(1, 2), this.q, i2);
        }
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f38568j.setVisibility(8);
            this.m.setVisibility(8);
            if (this.l == null) {
                MenuContentAdapter menuContentAdapter = new MenuContentAdapter(getContext());
                this.l = menuContentAdapter;
                this.k.setAdapter(menuContentAdapter);
            }
            this.l.updateData(this.o, this.q, i2);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MenuContentAdapter menuContentAdapter = this.l;
            if (menuContentAdapter != null) {
                menuContentAdapter.notifyDataSetChanged();
            }
            MenuContentAdapter menuContentAdapter2 = this.n;
            if (menuContentAdapter2 != null) {
                menuContentAdapter2.notifyDataSetChanged();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            RecyclerView recyclerView = this.k;
            if (recyclerView != null) {
                recyclerView.scrollToPosition(0);
            }
            if (this.m != null) {
                this.k.scrollToPosition(0);
            }
        }
    }

    public final void e(List<List<g>> list, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.o = list;
            this.q = z;
            if (z && list.size() > 1) {
                a(i2);
            } else {
                b(i2);
            }
        }
    }

    @Nullable
    public View getCoverView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : (View) invokeV.objValue;
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean isHighMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<List<g>> list = this.o;
            return list != null && list.size() > 1;
        }
        return invokeV.booleanValue;
    }

    public void setCoverView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            this.p = view;
        }
    }

    public void update(List<List<g>> list, View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{list, view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            setMode();
            setMenuHeader(view);
            e(list, z, i2);
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
        this.f38566h = linearLayout;
        linearLayout.setOrientation(1);
        RecyclerView recyclerView = new RecyclerView(context, attributeSet, i2);
        this.k = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.k.setPadding(0, (int) this.mContext.getResources().getDimension(R.dimen.aiapp_menu_gridview_padding_top), 0, 0);
        this.f38566h.addView(this.k, layoutParams);
        View view = new View(context);
        this.f38568j = view;
        view.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.f38566h.addView(this.f38568j, layoutParams2);
        RecyclerView recyclerView2 = new RecyclerView(context, attributeSet, i2);
        this.m = recyclerView2;
        recyclerView2.setVisibility(8);
        this.m.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.f38566h.addView(this.m, new LinearLayout.LayoutParams(-1, -2));
        setContentView(this.f38566h, new FrameLayout.LayoutParams(-1, -2));
    }
}
