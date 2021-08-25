package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import c.a.o0.k.g;
import c.a.o0.k.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SwanAppMenuSlidableGridView extends SlideableGridView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends WrapContentHeightViewPager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppMenuSlidableGridView f47111e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SwanAppMenuSlidableGridView swanAppMenuSlidableGridView, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppMenuSlidableGridView, context};
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
            this.f47111e = swanAppMenuSlidableGridView;
        }

        @Override // androidx.viewpager.widget.ViewPager
        public boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppMenuSlidableGridView(Context context, AttributeSet attributeSet, int i2) {
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
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public void addIndicator(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.mIndicator = new c.a.o0.k.r.a(context).setPointDrawableResId(h.menu_indicator_normal, h.menu_indicator_selected).setPointMargin((int) getResources().getDimension(g.common_grid_indicator_margin));
            this.mIndicatorHeight[0] = (int) getResources().getDimension(g.aiapp_menu_gridview_indicator_height);
            this.mIndicatorHeight[1] = (int) getResources().getDimension(g.aiapp_menu_gridview_indicator_height);
            addView(this.mIndicator, createIndicatorParams());
        }
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public void adjustLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SlideableGridView.a gridItemAdapter = getGridItemAdapter();
            int c2 = gridItemAdapter == null ? 0 : gridItemAdapter.c();
            boolean z = c2 > 1;
            int i2 = !z ? this.mIndicatorHeight[0] : this.mIndicatorHeight[1];
            if (!z) {
                this.mIndicator.setVisibility(8);
                return;
            }
            this.mIndicator.setVisibility(0);
            this.mIndicator.setPointCount(c2);
            this.mIndicator.getLayoutParams().height = i2;
        }
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public int createIndicatorHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (int) getResources().getDimension(g.aiapp_menu_gridview_indicator_height) : invokeV.intValue;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public ViewPager createViewPager(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? new a(this, context) : (ViewPager) invokeL.objValue;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            setOrientation(1);
            addViewPager(context);
            Resources resources = context.getResources();
            addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(g.aiapp_menu_gridview_padding_view_height1)));
            addIndicator(context);
            addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(g.aiapp_menu_gridview_padding_view_height2)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppMenuSlidableGridView(Context context, AttributeSet attributeSet) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppMenuSlidableGridView(Context context) {
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
    }
}
