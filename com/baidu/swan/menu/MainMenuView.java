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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a74;
import java.util.List;
/* loaded from: classes2.dex */
public class MainMenuView extends BaseMenuView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout f;
    public View g;
    public View h;
    public RecyclerView i;
    public MenuContentAdapter j;
    public RecyclerView k;
    public MenuContentAdapter l;
    public List<List<a74>> m;
    public View n;
    public boolean o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MainMenuView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void setMenuHeader(View view2) {
        View view3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, view2) == null) || view2 == null || view2 == (view3 = this.g)) {
            return;
        }
        if (view3 != null) {
            this.f.removeView(view3);
        }
        this.g = view2;
        this.f.addView(view2, 0);
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<List<a74>> list = this.m;
            return list != null && list.size() > 1;
        }
        return invokeV.booleanValue;
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.h.setVisibility(0);
            this.k.setVisibility(0);
            if (this.j == null) {
                MenuContentAdapter menuContentAdapter = new MenuContentAdapter(getContext());
                this.j = menuContentAdapter;
                this.i.setAdapter(menuContentAdapter);
            }
            this.j.g(this.m.subList(0, 1), this.o, i);
            if (this.l == null) {
                MenuContentAdapter menuContentAdapter2 = new MenuContentAdapter(getContext());
                this.l = menuContentAdapter2;
                this.k.setAdapter(menuContentAdapter2);
            }
            this.l.g(this.m.subList(1, 2), this.o, i);
        }
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.h.setVisibility(8);
            this.k.setVisibility(8);
            if (this.j == null) {
                MenuContentAdapter menuContentAdapter = new MenuContentAdapter(getContext());
                this.j = menuContentAdapter;
                this.i.setAdapter(menuContentAdapter);
            }
            this.j.g(this.m, this.o, i);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MenuContentAdapter menuContentAdapter = this.j;
            if (menuContentAdapter != null) {
                menuContentAdapter.notifyDataSetChanged();
            }
            MenuContentAdapter menuContentAdapter2 = this.l;
            if (menuContentAdapter2 != null) {
                menuContentAdapter2.notifyDataSetChanged();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            RecyclerView recyclerView = this.i;
            if (recyclerView != null) {
                recyclerView.scrollToPosition(0);
            }
            if (this.k != null) {
                this.i.scrollToPosition(0);
            }
        }
    }

    public final void g(List<List<a74>> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.m = list;
            this.o = z;
            if (z && list.size() > 1) {
                c(i);
            } else {
                d(i);
            }
        }
    }

    @Nullable
    public View getCoverView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public void setCoverView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            this.n = view2;
        }
    }

    public void update(List<List<a74>> list, View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{list, view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            setMode();
            setMenuHeader(view2);
            g(list, z, i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        LinearLayout linearLayout = new LinearLayout(context, attributeSet, i);
        this.f = linearLayout;
        linearLayout.setOrientation(1);
        RecyclerView recyclerView = new RecyclerView(context, attributeSet, i);
        this.i = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.i.setPadding(0, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0700e0), 0, 0);
        this.f.addView(this.i, layoutParams);
        View view2 = new View(context);
        this.h = view2;
        view2.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c9);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.f.addView(this.h, layoutParams2);
        RecyclerView recyclerView2 = new RecyclerView(context, attributeSet, i);
        this.k = recyclerView2;
        recyclerView2.setVisibility(8);
        this.k.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.f.addView(this.k, new LinearLayout.LayoutParams(-1, -2));
        b(this.f, new FrameLayout.LayoutParams(-1, -2));
    }
}
