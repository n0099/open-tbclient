package com.baidu.swan.menu.viewpager;

import android.annotation.TargetApi;
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
/* loaded from: classes4.dex */
public class SlideableGridView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public a f29687b;

    /* renamed from: c  reason: collision with root package name */
    public int f29688c;

    /* renamed from: d  reason: collision with root package name */
    public int f29689d;

    /* renamed from: e  reason: collision with root package name */
    public int f29690e;

    /* renamed from: f  reason: collision with root package name */
    public int f29691f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager f29692g;

    /* renamed from: h  reason: collision with root package name */
    public PointPageIndicator f29693h;
    public int[] i;

    /* loaded from: classes4.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract int a(int i);

        public abstract View b(int i, int i2, View view, ViewGroup viewGroup);

        public abstract int c();

        public abstract int d(int i);

        public abstract void e(int i, int i2, View view);

        public abstract void f(SlideableGridView slideableGridView);
    }

    /* loaded from: classes4.dex */
    public class b extends PagerAdapterImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public Context f29694c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SlideableGridView f29695d;

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
            this.f29695d = slideableGridView;
            this.f29694c = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        public void b(View view, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view, i) == null) {
                ((GridPageView) view).a(this.f29695d.f29687b.a(i), i);
            }
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        public View c(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) {
                GridPageView gridPageView = new GridPageView(this.f29694c);
                gridPageView.setGridItemAdapter(this.f29695d.f29687b);
                SlideableGridView slideableGridView = this.f29695d;
                gridPageView.setPadding(slideableGridView.f29688c, slideableGridView.f29690e, slideableGridView.f29689d, slideableGridView.f29691f);
                return gridPageView;
            }
            return (View) invokeLI.objValue;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                a aVar = this.f29695d.f29687b;
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

    /* loaded from: classes4.dex */
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
                this.a.f29693h.b(i);
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

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            PointPageIndicator e2 = new PointPageIndicator(context).e(R.drawable.obfuscated_res_0x7f0800fc, R.drawable.obfuscated_res_0x7f0800fd);
            e2.f((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0701ca));
            this.f29693h = e2;
            this.i[0] = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0701c8);
            this.i[1] = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0701c9);
            addView(this.f29693h, e());
        }
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            ViewPager g2 = g(context);
            this.f29692g = g2;
            g2.setOffscreenPageLimit(0);
            this.f29692g.setOnPageChangeListener(new c(this));
            this.f29692g.setOverScrollMode(2);
            addView(this.f29692g, i());
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a aVar = this.f29687b;
            int c2 = aVar == null ? 0 : aVar.c();
            boolean z = c2 > 1;
            int i = !z ? this.i[0] : this.i[1];
            this.f29693h.c(c2);
            this.f29693h.setVisibility(z ? 0 : 4);
            this.f29693h.getLayoutParams().height = i;
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0701c8) : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f29687b : (a) invokeV.objValue;
    }

    public PointPageIndicator getPageindicator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f29693h : (PointPageIndicator) invokeV.objValue;
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

    public void setCurrentPage(int i) {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || (viewPager = this.f29692g) == null || this.f29693h == null) {
            return;
        }
        viewPager.setCurrentItem(i);
        this.f29693h.b(i);
    }

    public void setGridItemAdapter(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.f29687b = aVar;
            if (aVar != null) {
                aVar.f(this);
                b bVar = this.a;
                if (bVar == null) {
                    b bVar2 = new b(this, getContext());
                    this.a = bVar2;
                    this.f29692g.setAdapter(bVar2);
                } else {
                    bVar.notifyDataSetChanged();
                }
                this.f29693h.c(aVar.c());
            } else {
                b bVar3 = this.a;
                if (bVar3 != null) {
                    bVar3.notifyDataSetChanged();
                }
            }
            c();
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048591, this, i, i2, i3, i4) == null) {
            this.f29688c = i;
            this.f29689d = i3;
            this.f29690e = i2;
            this.f29691f = i4;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        PointPageIndicator pointPageIndicator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) || (pointPageIndicator = this.f29693h) == null) {
            return;
        }
        pointPageIndicator.e(i, i2);
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
    @TargetApi(11)
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
        this.f29692g = null;
        this.f29693h = null;
        this.i = new int[2];
        k(context);
    }
}
