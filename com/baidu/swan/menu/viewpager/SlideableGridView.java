package com.baidu.swan.menu.viewpager;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.r0.n.g;
import c.a.r0.n.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SlideableGridView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f41339e;

    /* renamed from: f  reason: collision with root package name */
    public a f41340f;

    /* renamed from: g  reason: collision with root package name */
    public int f41341g;

    /* renamed from: h  reason: collision with root package name */
    public int f41342h;

    /* renamed from: i  reason: collision with root package name */
    public int f41343i;

    /* renamed from: j  reason: collision with root package name */
    public int f41344j;

    /* renamed from: k  reason: collision with root package name */
    public ViewPager f41345k;
    public PointPageIndicator mIndicator;
    public int[] mIndicatorHeight;

    /* loaded from: classes11.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract int a(int i2);

        public abstract View b(int i2, int i3, View view, ViewGroup viewGroup);

        public abstract int c();

        public abstract int d(int i2);

        public abstract void e(int i2, int i3, View view);

        public abstract void f(SlideableGridView slideableGridView);
    }

    /* loaded from: classes11.dex */
    public class b extends PagerAdapterImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public Context f41346c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SlideableGridView f41347d;

        public b(SlideableGridView slideableGridView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slideableGridView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41347d = slideableGridView;
            this.f41346c = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = this.f41347d.f41340f;
                if (aVar != null) {
                    return aVar.c();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return -2;
            }
            return invokeL.intValue;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        public void onConfigItem(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) {
                ((GridPageView) view).configItem(this.f41347d.f41340f.a(i2), i2);
            }
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        public View onInstantiateItem(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
                GridPageView gridPageView = new GridPageView(this.f41346c);
                gridPageView.setGridItemAdapter(this.f41347d.f41340f);
                SlideableGridView slideableGridView = this.f41347d;
                gridPageView.setPadding(slideableGridView.f41341g, slideableGridView.f41343i, slideableGridView.f41342h, slideableGridView.f41344j);
                return gridPageView;
            }
            return (View) invokeLI.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SlideableGridView f41348e;

        public c(SlideableGridView slideableGridView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slideableGridView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41348e = slideableGridView;
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f41348e.mIndicator.setCurrentPosition(i2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlideableGridView(Context context) {
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

    public void addIndicator(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.mIndicator = new PointPageIndicator(context).setPointDrawableResId(h.aiapp_menu_slide_indicator_normal, h.aiapp_menu_slide_indicator_selected).setPointMargin((int) getResources().getDimension(g.common_grid_indicator_margin));
            this.mIndicatorHeight[0] = (int) getResources().getDimension(g.common_grid_indicator_height);
            this.mIndicatorHeight[1] = (int) getResources().getDimension(g.common_grid_indicator_height2);
            addView(this.mIndicator, createIndicatorParams());
        }
    }

    public void addViewPager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            ViewPager createViewPager = createViewPager(context);
            this.f41345k = createViewPager;
            createViewPager.setOffscreenPageLimit(0);
            this.f41345k.setOnPageChangeListener(new c(this));
            this.f41345k.setOverScrollMode(2);
            addView(this.f41345k, createViewPagerParams());
        }
    }

    public void adjustLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a aVar = this.f41340f;
            int c2 = aVar == null ? 0 : aVar.c();
            boolean z = c2 > 1;
            int i2 = !z ? this.mIndicatorHeight[0] : this.mIndicatorHeight[1];
            this.mIndicator.setPointCount(c2);
            this.mIndicator.setVisibility(z ? 0 : 4);
            this.mIndicator.getLayoutParams().height = i2;
        }
    }

    public int createIndicatorHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (int) getResources().getDimension(g.common_grid_indicator_height) : invokeV.intValue;
    }

    public LinearLayout.LayoutParams createIndicatorParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new LinearLayout.LayoutParams(createIndicatorWidth(), createIndicatorHeight()) : (LinearLayout.LayoutParams) invokeV.objValue;
    }

    public int createIndicatorWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public ViewPager createViewPager(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) ? new WrapContentHeightViewPager(context) : (ViewPager) invokeL.objValue;
    }

    public int createViewPagerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return -2;
        }
        return invokeV.intValue;
    }

    public LinearLayout.LayoutParams createViewPagerParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new LinearLayout.LayoutParams(createViewPagerWidth(), createViewPagerHeight()) : (LinearLayout.LayoutParams) invokeV.objValue;
    }

    public int createViewPagerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public a getGridItemAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f41340f : (a) invokeV.objValue;
    }

    public PointPageIndicator getPageindicator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mIndicator : (PointPageIndicator) invokeV.objValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            setOrientation(1);
            addViewPager(context);
            addIndicator(context);
        }
    }

    public void setCurrentPage(int i2) {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (viewPager = this.f41345k) == null || this.mIndicator == null) {
            return;
        }
        viewPager.setCurrentItem(i2);
        this.mIndicator.setCurrentPosition(i2);
    }

    public void setGridItemAdapter(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.f41340f = aVar;
            if (aVar != null) {
                aVar.f(this);
                b bVar = this.f41339e;
                if (bVar == null) {
                    b bVar2 = new b(this, getContext());
                    this.f41339e = bVar2;
                    this.f41345k.setAdapter(bVar2);
                } else {
                    bVar.notifyDataSetChanged();
                }
                this.mIndicator.setPointCount(aVar.c());
            } else {
                b bVar3 = this.f41339e;
                if (bVar3 != null) {
                    bVar3.notifyDataSetChanged();
                }
            }
            adjustLayout();
        }
    }

    public void setGridViewPading(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048591, this, i2, i3, i4, i5) == null) {
            this.f41341g = i2;
            this.f41342h = i4;
            this.f41343i = i3;
            this.f41344j = i5;
        }
    }

    public void setIndicatorColor(int i2, int i3) {
        PointPageIndicator pointPageIndicator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) || (pointPageIndicator = this.mIndicator) == null) {
            return;
        }
        pointPageIndicator.setPointDrawableResId(i2, i3);
    }

    public void setPageIndicatorHeight(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) {
            int[] iArr = this.mIndicatorHeight;
            iArr[0] = i2;
            iArr[1] = i3;
            requestLayout();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlideableGridView(Context context, AttributeSet attributeSet) {
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
    @TargetApi(11)
    public SlideableGridView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f41345k = null;
        this.mIndicator = null;
        this.mIndicatorHeight = new int[2];
        init(context);
    }
}
