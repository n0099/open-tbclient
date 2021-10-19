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
import c.a.q0.s.w.b.a;
import c.a.q0.s.w.b.e;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class CoverFlowLocalView<T extends c.a.q0.s.w.b.a> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ListViewPager f47548e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f47549f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.w.b.c f47550g;

    /* renamed from: h  reason: collision with root package name */
    public View f47551h;

    /* renamed from: i  reason: collision with root package name */
    public CoverFlowLocalAdapter<T> f47552i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.s.w.a f47553j;
    public CoverFlowLocalView<T>.b k;
    public boolean l;
    public boolean m;
    public boolean n;
    public c.a.q0.s.w.b.d<T> o;
    public CoverFlowLocalView<T>.d p;
    public CoverFlowLocalView<T>.c q;
    public boolean r;
    public long s;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes6.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CoverFlowLocalView f47554a;

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
            this.f47554a = coverFlowLocalView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                this.f47554a.r();
            }
        }

        public /* synthetic */ b(CoverFlowLocalView coverFlowLocalView, a aVar) {
            this(coverFlowLocalView);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverFlowLocalView f47555e;

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
            this.f47555e = coverFlowLocalView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f47555e.f47548e == null || this.f47555e.f47552i == null) {
                return;
            }
            if (i2 != 0) {
                if (i2 == 1 && !this.f47555e.m) {
                    this.f47555e.stopMarqueen();
                    this.f47555e.m();
                }
            } else if (this.f47555e.n) {
                this.f47555e.n();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v29, resolved type: c.a.q0.s.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f47555e.f47549f == null || this.f47555e.f47552i == null) {
                return;
            }
            if (this.f47555e.f47552i.getCount() == 1 && i2 == 0 && this.f47555e.o != null) {
                this.f47555e.o.a(1, this.f47555e.f47552i.getItem(i2));
            }
            if (this.f47555e.f47549f.getVisibility() != 0 || this.f47555e.l) {
                return;
            }
            if (this.f47555e.r) {
                int count = this.f47555e.f47552i.getCount();
                if (i2 == 0) {
                    this.f47555e.f47549f.setPosition((count - 3) + f2);
                    return;
                } else if (i2 == count - 1) {
                    this.f47555e.f47549f.setPosition(f2);
                    return;
                } else {
                    this.f47555e.f47549f.setPosition((i2 - 1) + f2);
                    return;
                }
            }
            this.f47555e.f47549f.setPosition(i2 + f2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: c.a.q0.s.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f47555e.f47552i == null) {
                return;
            }
            int count = this.f47555e.f47552i.getCount();
            if (i2 < 0 || i2 >= count) {
                return;
            }
            if (this.f47555e.l) {
                this.f47555e.setIndicatorSelected(i2);
            }
            if (this.f47555e.o == null) {
                return;
            }
            this.f47555e.o.a(i2, this.f47555e.f47552i.getItem(i2));
        }

        public /* synthetic */ c(CoverFlowLocalView coverFlowLocalView, a aVar) {
            this(coverFlowLocalView);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverFlowLocalView f47556e;

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
            this.f47556e = coverFlowLocalView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            c.a.q0.s.w.b.a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47556e.o == null || !(view.getTag() instanceof Integer) || (item = this.f47556e.f47552i.getItem((intValue = ((Integer) view.getTag()).intValue()))) == null) {
                return;
            }
            this.f47556e.o.b(intValue, item.b());
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
        this.f47551h = null;
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
                int count = this.f47552i.getCount();
                if (i2 == 0) {
                    this.f47549f.setPosition(0.0f);
                    return;
                } else if (i2 == count - 1) {
                    this.f47549f.setPosition(i2);
                    return;
                } else {
                    this.f47549f.setPosition(i2 - 1);
                    return;
                }
            }
            this.f47549f.setPosition(i2);
        }
    }

    public void checkAndStartMarqueen() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.k.hasMessages(1)) {
            return;
        }
        startMarqueen();
    }

    public void clearData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f47552i.clear();
        }
    }

    public T getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.f47552i;
            if (coverFlowLocalAdapter == null) {
                return null;
            }
            return coverFlowLocalAdapter.getItem(i2);
        }
        return (T) invokeI.objValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.f47552i;
            if (coverFlowLocalAdapter == null || !this.r || (count = coverFlowLocalAdapter.getCount()) <= 1) {
                return false;
            }
            int currentItem = this.f47548e.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f47548e.setCurrentItem(i2, false);
                this.f47548e.invalidate();
            } else if (currentItem > i2) {
                this.f47548e.setCurrentItem(1, false);
                this.f47548e.invalidate();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && m()) {
            resetMarqueen();
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            q(context);
            p(context);
            setCoverFlowFactory(new c.a.q0.s.w.b.b());
            addView(this.f47548e);
            addView(this.f47549f);
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = new CoverFlowLocalAdapter<>(context);
            this.f47552i = coverFlowLocalAdapter;
            coverFlowLocalAdapter.setOnClickListener(this.p);
            this.f47548e.setAdapter(this.f47552i);
            this.f47548e.setOnPageChangeListener(this.q);
        }
    }

    public void onChangeSkinType() {
        c.a.q0.s.w.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f47552i.onChangeSkinType();
            IndicatorView indicatorView = this.f47549f;
            if (indicatorView == null || (cVar = this.f47550g) == null) {
                return;
            }
            indicatorView.setDrawable(SkinManager.getDrawable(cVar.a()));
            this.f47549f.setSelector(SkinManager.getDrawable(this.f47550g.b()));
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            IndicatorView indicatorView = new IndicatorView(context);
            this.f47549f = indicatorView;
            indicatorView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.f47548e = new ListViewPager(context);
        }
    }

    public final void r() {
        CoverFlowLocalAdapter<T> coverFlowLocalAdapter;
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f47548e == null || (coverFlowLocalAdapter = this.f47552i) == null || (count = coverFlowLocalAdapter.getCount()) <= 1) {
            return;
        }
        int currentItem = this.f47548e.getCurrentItem();
        int i2 = count - 2;
        if (currentItem < 1) {
            this.f47548e.setCurrentItem(i2, false);
        } else if (currentItem > i2) {
            this.f47548e.setCurrentItem(1, false);
        } else {
            this.f47548e.setCurrentItem(currentItem + 1);
        }
        this.f47548e.invalidate();
    }

    public void resetMarqueen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.k.removeMessages(1);
            this.k.sendEmptyMessageDelayed(1, this.s);
        }
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.n = z;
        }
    }

    public void setCallback(c.a.q0.s.w.b.d<T> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            this.o = dVar;
        }
    }

    public void setCanRepeat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.r = z;
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.f47552i;
            if (coverFlowLocalAdapter != null) {
                coverFlowLocalAdapter.setCanRepeat(z);
            }
        }
    }

    public void setCoverFlowFactory(c.a.q0.s.w.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f47553j = aVar;
        c.a.q0.s.w.b.c a2 = aVar.a();
        this.f47550g = a2;
        a2.i(this.f47549f);
        aVar.c().b(this.f47548e);
        View b2 = aVar.b();
        this.f47551h = b2;
        if (b2 != null) {
            removeAllViews();
            addView(this.f47548e);
            addView(this.f47551h);
            addView(this.f47549f);
        }
    }

    public void setData(List<T> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f47552i.setData(list, this.f47553j);
        int size = list.size();
        if (size > 1) {
            this.f47549f.setVisibility(0);
            this.f47549f.setCount(size);
            this.f47548e.setCurrentItem(0, false);
            this.f47549f.setPosition(0.0f);
            if (this.n) {
                startMarqueen();
                return;
            }
            return;
        }
        this.f47549f.setVisibility(8);
        this.f47549f.setCount(size);
        this.f47548e.setCurrentItem(0, false);
        this.f47549f.setPosition(0.0f);
        stopMarqueen();
    }

    public void setDisableParentEvent(boolean z) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (listViewPager = this.f47548e) == null) {
            return;
        }
        listViewPager.setDisableParentEvent(z);
    }

    public void setIndicatorNoOffet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.l = z;
        }
    }

    public void setIndicatorVisible(int i2) {
        IndicatorView indicatorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (indicatorView = this.f47549f) == null) {
            return;
        }
        indicatorView.setVisibility(i2);
    }

    public void setIsAutoPlayDragging(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.m = z;
        }
    }

    public void setMarqueenTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) {
            this.s = j2;
            resetMarqueen();
        }
    }

    public void setPageMargin(int i2) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (listViewPager = this.f47548e) == null) {
            return;
        }
        listViewPager.setPageMargin(i2);
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, cVar) == null) || (listViewPager = this.f47548e) == null) {
            return;
        }
        listViewPager.setSwipeControlInterface(cVar);
    }

    public void startMarqueen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            resetMarqueen();
        }
    }

    public void stopMarqueen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.k.removeMessages(1);
        }
    }

    public void updateViewPager(e eVar) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, eVar) == null) || eVar == null || (listViewPager = this.f47548e) == null) {
            return;
        }
        eVar.b(listViewPager);
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
        this.f47551h = null;
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
        this.f47551h = null;
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
