package com.baidu.swan.menu.viewpager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.k.g;
import d.a.n0.k.h;
/* loaded from: classes3.dex */
public class SlideableGridView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f12062e;

    /* renamed from: f  reason: collision with root package name */
    public a f12063f;

    /* renamed from: g  reason: collision with root package name */
    public int f12064g;

    /* renamed from: h  reason: collision with root package name */
    public int f12065h;

    /* renamed from: i  reason: collision with root package name */
    public int f12066i;
    public int j;
    public ViewPager k;
    public PointPageIndicator l;
    public int[] m;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b extends PagerAdapterImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public Context f12067c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SlideableGridView f12068d;

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
            this.f12068d = slideableGridView;
            this.f12067c = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        public void b(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
                ((GridPageView) view).a(this.f12068d.f12063f.a(i2), i2);
            }
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        public View c(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
                GridPageView gridPageView = new GridPageView(this.f12067c);
                gridPageView.setGridItemAdapter(this.f12068d.f12063f);
                SlideableGridView slideableGridView = this.f12068d;
                gridPageView.setPadding(slideableGridView.f12064g, slideableGridView.f12066i, slideableGridView.f12065h, slideableGridView.j);
                return gridPageView;
            }
            return (View) invokeLI.objValue;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                a aVar = this.f12068d.f12063f;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                return -2;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SlideableGridView f12069e;

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
            this.f12069e = slideableGridView;
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f12069e.l.b(i2);
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

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            PointPageIndicator e2 = new PointPageIndicator(context).e(h.aiapp_menu_slide_indicator_normal, h.aiapp_menu_slide_indicator_selected);
            e2.f((int) getResources().getDimension(g.common_grid_indicator_margin));
            this.l = e2;
            this.m[0] = (int) getResources().getDimension(g.common_grid_indicator_height);
            this.m[1] = (int) getResources().getDimension(g.common_grid_indicator_height2);
            addView(this.l, e());
        }
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            ViewPager g2 = g(context);
            this.k = g2;
            g2.setOffscreenPageLimit(0);
            this.k.setOnPageChangeListener(new c(this));
            this.k.setOverScrollMode(2);
            addView(this.k, i());
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a aVar = this.f12063f;
            int c2 = aVar == null ? 0 : aVar.c();
            boolean z = c2 > 1;
            int i2 = !z ? this.m[0] : this.m[1];
            this.l.c(c2);
            this.l.setVisibility(z ? 0 : 4);
            this.l.getLayoutParams().height = i2;
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (int) getResources().getDimension(g.common_grid_indicator_height) : invokeV.intValue;
    }

    public LinearLayout.LayoutParams e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new LinearLayout.LayoutParams(f(), d()) : (LinearLayout.LayoutParams) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public ViewPager g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) ? new WrapContentHeightViewPager(context) : (ViewPager) invokeL.objValue;
    }

    public a getGridItemAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f12063f : (a) invokeV.objValue;
    }

    public PointPageIndicator getPageindicator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l : (PointPageIndicator) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return -2;
        }
        return invokeV.intValue;
    }

    public LinearLayout.LayoutParams i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new LinearLayout.LayoutParams(j(), h()) : (LinearLayout.LayoutParams) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            setOrientation(1);
            b(context);
            a(context);
        }
    }

    public void setCurrentPage(int i2) {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (viewPager = this.k) == null || this.l == null) {
            return;
        }
        viewPager.setCurrentItem(i2);
        this.l.b(i2);
    }

    public void setGridItemAdapter(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.f12063f = aVar;
            if (aVar != null) {
                aVar.f(this);
                b bVar = this.f12062e;
                if (bVar == null) {
                    b bVar2 = new b(this, getContext());
                    this.f12062e = bVar2;
                    this.k.setAdapter(bVar2);
                } else {
                    bVar.notifyDataSetChanged();
                }
                this.l.c(aVar.c());
            } else {
                b bVar3 = this.f12062e;
                if (bVar3 != null) {
                    bVar3.notifyDataSetChanged();
                }
            }
            c();
        }
    }

    public void setGridViewPading(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048591, this, i2, i3, i4, i5) == null) {
            this.f12064g = i2;
            this.f12065h = i4;
            this.f12066i = i3;
            this.j = i5;
        }
    }

    public void setIndicatorColor(int i2, int i3) {
        PointPageIndicator pointPageIndicator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) || (pointPageIndicator = this.l) == null) {
            return;
        }
        pointPageIndicator.e(i2, i3);
    }

    public void setPageIndicatorHeight(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) {
            int[] iArr = this.m;
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
    @SuppressLint({"NewApi"})
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
        this.k = null;
        this.l = null;
        this.m = new int[2];
        k(context);
    }
}
