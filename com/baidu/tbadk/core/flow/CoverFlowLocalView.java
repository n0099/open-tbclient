package com.baidu.tbadk.core.flow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.w.b.a;
import java.util.List;
/* loaded from: classes3.dex */
public class CoverFlowLocalView<T extends d.a.o0.r.w.b.a> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ListViewPager f12325e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f12326f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.r.w.b.c f12327g;

    /* renamed from: h  reason: collision with root package name */
    public View f12328h;

    /* renamed from: i  reason: collision with root package name */
    public CoverFlowLocalAdapter<T> f12329i;
    public d.a.o0.r.w.a j;
    public CoverFlowLocalView<T>.b k;
    public boolean l;
    public boolean m;
    public boolean n;
    public d.a.o0.r.w.b.d<T> o;
    public CoverFlowLocalView<T>.d p;
    public CoverFlowLocalView<T>.c q;
    public boolean r;
    public long s;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CoverFlowLocalView f12330a;

        public b(CoverFlowLocalView coverFlowLocalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowLocalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12330a = coverFlowLocalView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                this.f12330a.s();
            }
        }

        public /* synthetic */ b(CoverFlowLocalView coverFlowLocalView, a aVar) {
            this(coverFlowLocalView);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverFlowLocalView f12331e;

        public c(CoverFlowLocalView coverFlowLocalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowLocalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12331e = coverFlowLocalView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f12331e.f12325e == null || this.f12331e.f12329i == null) {
                return;
            }
            if (i2 != 0) {
                if (i2 == 1 && !this.f12331e.m) {
                    this.f12331e.u();
                    this.f12331e.m();
                }
            } else if (this.f12331e.n) {
                this.f12331e.n();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v29, resolved type: d.a.o0.r.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f12331e.f12326f == null || this.f12331e.f12329i == null) {
                return;
            }
            if (this.f12331e.f12329i.getCount() == 1 && i2 == 0 && this.f12331e.o != null) {
                this.f12331e.o.a(1, this.f12331e.f12329i.b(i2));
            }
            if (this.f12331e.f12326f.getVisibility() != 0 || this.f12331e.l) {
                return;
            }
            if (this.f12331e.r) {
                int count = this.f12331e.f12329i.getCount();
                if (i2 == 0) {
                    this.f12331e.f12326f.setPosition((count - 3) + f2);
                    return;
                } else if (i2 == count - 1) {
                    this.f12331e.f12326f.setPosition(f2);
                    return;
                } else {
                    this.f12331e.f12326f.setPosition((i2 - 1) + f2);
                    return;
                }
            }
            this.f12331e.f12326f.setPosition(i2 + f2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: d.a.o0.r.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f12331e.f12329i == null) {
                return;
            }
            int count = this.f12331e.f12329i.getCount();
            if (i2 < 0 || i2 >= count) {
                return;
            }
            if (this.f12331e.l) {
                this.f12331e.setIndicatorSelected(i2);
            }
            if (this.f12331e.o == null) {
                return;
            }
            this.f12331e.o.a(i2, this.f12331e.f12329i.b(i2));
        }

        public /* synthetic */ c(CoverFlowLocalView coverFlowLocalView, a aVar) {
            this(coverFlowLocalView);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverFlowLocalView f12332e;

        public d(CoverFlowLocalView coverFlowLocalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowLocalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12332e = coverFlowLocalView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            d.a.o0.r.w.b.a b2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12332e.o == null || !(view.getTag() instanceof Integer) || (b2 = this.f12332e.f12329i.b((intValue = ((Integer) view.getTag()).intValue()))) == null) {
                return;
            }
            this.f12332e.o.b(intValue, b2.b());
        }

        public /* synthetic */ d(CoverFlowLocalView coverFlowLocalView, a aVar) {
            this(coverFlowLocalView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowLocalView(Context context) {
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
        this.f12328h = null;
        this.k = new b(this, null);
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d(this, null);
        this.q = new c(this, null);
        this.s = 5000L;
        o(context);
    }

    private boolean getAutoPlayPlayDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.m : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i2) == null) {
            if (this.r) {
                int count = this.f12329i.getCount();
                if (i2 == 0) {
                    this.f12326f.setPosition(0.0f);
                    return;
                } else if (i2 == count - 1) {
                    this.f12326f.setPosition(i2);
                    return;
                } else {
                    this.f12326f.setPosition(i2 - 1);
                    return;
                }
            }
            this.f12326f.setPosition(i2);
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.f12329i;
            if (coverFlowLocalAdapter == null || !this.r || (count = coverFlowLocalAdapter.getCount()) <= 1) {
                return false;
            }
            int currentItem = this.f12325e.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f12325e.setCurrentItem(i2, false);
                this.f12325e.invalidate();
            } else if (currentItem > i2) {
                this.f12325e.setCurrentItem(1, false);
                this.f12325e.invalidate();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && m()) {
            r();
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            q(context);
            p(context);
            setCoverFlowFactory(new d.a.o0.r.w.b.b());
            addView(this.f12325e);
            addView(this.f12326f);
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = new CoverFlowLocalAdapter<>(context);
            this.f12329i = coverFlowLocalAdapter;
            coverFlowLocalAdapter.f(this.p);
            this.f12325e.setAdapter(this.f12329i);
            this.f12325e.setOnPageChangeListener(this.q);
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            IndicatorView indicatorView = new IndicatorView(context);
            this.f12326f = indicatorView;
            indicatorView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.f12325e = new ListViewPager(context);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k.removeMessages(1);
            this.k.sendEmptyMessageDelayed(1, this.s);
        }
    }

    public final void s() {
        CoverFlowLocalAdapter<T> coverFlowLocalAdapter;
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f12325e == null || (coverFlowLocalAdapter = this.f12329i) == null || (count = coverFlowLocalAdapter.getCount()) <= 1) {
            return;
        }
        int currentItem = this.f12325e.getCurrentItem();
        int i2 = count - 2;
        if (currentItem < 1) {
            this.f12325e.setCurrentItem(i2, false);
        } else if (currentItem > i2) {
            this.f12325e.setCurrentItem(1, false);
        } else {
            this.f12325e.setCurrentItem(currentItem + 1);
        }
        this.f12325e.invalidate();
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.n = z;
        }
    }

    public void setCallback(d.a.o0.r.w.b.d<T> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.o = dVar;
        }
    }

    public void setCanRepeat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.r = z;
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.f12329i;
            if (coverFlowLocalAdapter != null) {
                coverFlowLocalAdapter.d(z);
            }
        }
    }

    public void setCoverFlowFactory(d.a.o0.r.w.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null) {
            return;
        }
        this.j = aVar;
        d.a.o0.r.w.b.c a2 = aVar.a();
        this.f12327g = a2;
        a2.i(this.f12326f);
        aVar.c().b(this.f12325e);
        View b2 = aVar.b();
        this.f12328h = b2;
        if (b2 != null) {
            removeAllViews();
            addView(this.f12325e);
            addView(this.f12328h);
            addView(this.f12326f);
        }
    }

    public void setData(List<T> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f12329i.e(list, this.j);
        int size = list.size();
        if (size > 1) {
            this.f12326f.setVisibility(0);
            this.f12326f.setCount(size);
            this.f12325e.setCurrentItem(0, false);
            this.f12326f.setPosition(0.0f);
            if (this.n) {
                t();
                return;
            }
            return;
        }
        this.f12326f.setVisibility(8);
        this.f12326f.setCount(size);
        this.f12325e.setCurrentItem(0, false);
        this.f12326f.setPosition(0.0f);
        u();
    }

    public void setDisableParentEvent(boolean z) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (listViewPager = this.f12325e) == null) {
            return;
        }
        listViewPager.setDisableParentEvent(z);
    }

    public void setIndicatorNoOffet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.l = z;
        }
    }

    public void setIndicatorVisible(int i2) {
        IndicatorView indicatorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (indicatorView = this.f12326f) == null) {
            return;
        }
        indicatorView.setVisibility(i2);
    }

    public void setIsAutoPlayDragging(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.m = z;
        }
    }

    public void setMarqueenTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.s = j;
            r();
        }
    }

    public void setPageMargin(int i2) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (listViewPager = this.f12325e) == null) {
            return;
        }
        listViewPager.setPageMargin(i2);
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) || (listViewPager = this.f12325e) == null) {
            return;
        }
        listViewPager.setSwipeControlInterface(cVar);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            r();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.k.removeMessages(1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f12328h = null;
        this.k = new b(this, null);
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d(this, null);
        this.q = new c(this, null);
        this.s = 5000L;
        o(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowLocalView(Context context, AttributeSet attributeSet) {
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
        this.f12328h = null;
        this.k = new b(this, null);
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d(this, null);
        this.q = new c(this, null);
        this.s = 5000L;
        o(context);
    }
}
