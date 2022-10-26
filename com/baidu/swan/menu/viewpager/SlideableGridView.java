package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SlideableGridView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public a b;
    public int c;
    public int d;
    public int e;
    public int f;
    public ViewPager g;
    public PointPageIndicator h;
    public int[] i;

    /* loaded from: classes3.dex */
    public abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract int a(int i);

        public abstract View b(int i, int i2, View view2, ViewGroup viewGroup);

        public abstract int c();

        public abstract int d(int i);

        public abstract void e(int i, int i2, View view2);

        public abstract void f(SlideableGridView slideableGridView);
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return -2;
        }
        return invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public class b extends PagerAdapterImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context c;
        public final /* synthetic */ SlideableGridView d;

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                return -2;
            }
            return invokeL.intValue;
        }

        public b(SlideableGridView slideableGridView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slideableGridView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = slideableGridView;
            this.c = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        public void b(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
                ((GridPageView) view2).a(this.d.b.a(i), i);
            }
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        public View c(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) {
                GridPageView gridPageView = new GridPageView(this.c);
                gridPageView.setGridItemAdapter(this.d.b);
                SlideableGridView slideableGridView = this.d;
                gridPageView.setPadding(slideableGridView.c, slideableGridView.e, slideableGridView.d, slideableGridView.f);
                return gridPageView;
            }
            return (View) invokeLI.objValue;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                a aVar = this.d.b;
                if (aVar != null) {
                    return aVar.c();
                }
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SlideableGridView a;

        public c(SlideableGridView slideableGridView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slideableGridView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = slideableGridView;
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.h.b(i);
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

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            ViewPager g = g(context);
            this.g = g;
            g.setOffscreenPageLimit(0);
            this.g.setOnPageChangeListener(new c(this));
            this.g.setOverScrollMode(2);
            addView(this.g, i());
        }
    }

    public void setGridItemAdapter(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.b = aVar;
            if (aVar != null) {
                aVar.f(this);
                b bVar = this.a;
                if (bVar == null) {
                    b bVar2 = new b(this, getContext());
                    this.a = bVar2;
                    this.g.setAdapter(bVar2);
                } else {
                    bVar.notifyDataSetChanged();
                }
                this.h.c(aVar.c());
            } else {
                b bVar3 = this.a;
                if (bVar3 != null) {
                    bVar3.notifyDataSetChanged();
                }
            }
            c();
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
    public SlideableGridView(Context context, AttributeSet attributeSet, int i) {
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
        this.g = null;
        this.h = null;
        this.i = new int[2];
        k(context);
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            PointPageIndicator e = new PointPageIndicator(context).e(R.drawable.obfuscated_res_0x7f0800fc, R.drawable.obfuscated_res_0x7f0800fd);
            e.f((int) getResources().getDimension(R.dimen.common_grid_indicator_margin));
            this.h = e;
            this.i[0] = (int) getResources().getDimension(R.dimen.common_grid_indicator_height);
            this.i[1] = (int) getResources().getDimension(R.dimen.common_grid_indicator_height2);
            addView(this.h, e());
        }
    }

    public void c() {
        int c2;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a aVar = this.b;
            int i2 = 0;
            if (aVar == null) {
                c2 = 0;
            } else {
                c2 = aVar.c();
            }
            if (c2 > 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                i = this.i[0];
            } else {
                i = this.i[1];
            }
            this.h.c(c2);
            PointPageIndicator pointPageIndicator = this.h;
            if (!z) {
                i2 = 4;
            }
            pointPageIndicator.setVisibility(i2);
            this.h.getLayoutParams().height = i;
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (int) getResources().getDimension(R.dimen.common_grid_indicator_height);
        }
        return invokeV.intValue;
    }

    public LinearLayout.LayoutParams e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new LinearLayout.LayoutParams(f(), d());
        }
        return (LinearLayout.LayoutParams) invokeV.objValue;
    }

    public a getGridItemAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (a) invokeV.objValue;
    }

    public PointPageIndicator getPageindicator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (PointPageIndicator) invokeV.objValue;
    }

    public LinearLayout.LayoutParams i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return new LinearLayout.LayoutParams(j(), h());
        }
        return (LinearLayout.LayoutParams) invokeV.objValue;
    }

    public ViewPager g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            return new WrapContentHeightViewPager(context);
        }
        return (ViewPager) invokeL.objValue;
    }

    public void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            setOrientation(1);
            b(context);
            a(context);
        }
    }

    public void setCurrentPage(int i) {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i) == null) && (viewPager = this.g) != null && this.h != null) {
            viewPager.setCurrentItem(i);
            this.h.b(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048591, this, i, i2, i3, i4) == null) {
            this.c = i;
            this.d = i3;
            this.e = i2;
            this.f = i4;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        PointPageIndicator pointPageIndicator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) && (pointPageIndicator = this.h) != null) {
            pointPageIndicator.e(i, i2);
        }
    }

    public void setPageIndicatorHeight(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            int[] iArr = this.i;
            iArr[0] = i;
            iArr[1] = i2;
            requestLayout();
        }
    }
}
