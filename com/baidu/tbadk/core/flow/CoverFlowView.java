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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.w.b.a;
import d.a.r0.r.w.b.e;
import java.util.List;
/* loaded from: classes4.dex */
public class CoverFlowView<T extends d.a.r0.r.w.b.a> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ListViewPager f12316e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f12317f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.r0.r.w.b.c f12318g;

    /* renamed from: h  reason: collision with root package name */
    public View f12319h;

    /* renamed from: i  reason: collision with root package name */
    public CoverFlowAdapter<T> f12320i;
    public d.a.r0.r.w.a j;
    public CoverFlowView<T>.b k;
    public boolean l;
    public boolean m;
    public boolean n;
    public d.a.r0.r.w.b.d<T> o;
    public CoverFlowView<T>.d p;
    public CoverFlowView<T>.c q;
    public long r;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes4.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CoverFlowView f12321a;

        public b(CoverFlowView coverFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12321a = coverFlowView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                this.f12321a.u();
            }
        }

        public /* synthetic */ b(CoverFlowView coverFlowView, a aVar) {
            this(coverFlowView);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverFlowView f12322e;

        public c(CoverFlowView coverFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12322e = coverFlowView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f12322e.f12316e == null || this.f12322e.f12320i == null) {
                return;
            }
            if (i2 != 0) {
                if (i2 == 1 && !this.f12322e.m) {
                    this.f12322e.w();
                    this.f12322e.m();
                }
            } else if (this.f12322e.n) {
                this.f12322e.o();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v25, resolved type: d.a.r0.r.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f12322e.f12317f == null || this.f12322e.f12320i == null) {
                return;
            }
            if (this.f12322e.f12320i.getCount() == 1 && i2 == 0 && this.f12322e.o != null) {
                this.f12322e.o.a(1, this.f12322e.f12320i.i(i2));
            }
            if (this.f12322e.f12317f.getVisibility() != 0 || this.f12322e.l) {
                return;
            }
            int count = this.f12322e.f12320i.getCount();
            if (i2 == 0) {
                this.f12322e.f12317f.setPosition((count - 3) + f2);
            } else if (i2 == count - 1) {
                this.f12322e.f12317f.setPosition(f2);
            } else {
                this.f12322e.f12317f.setPosition((i2 - 1) + f2);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: d.a.r0.r.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f12322e.f12320i == null) {
                return;
            }
            int count = this.f12322e.f12320i.getCount();
            if (i2 < 0 || i2 >= count) {
                return;
            }
            if (this.f12322e.l) {
                this.f12322e.setIndicatorSelected(i2);
            }
            if (this.f12322e.o == null) {
                return;
            }
            this.f12322e.o.a(i2, this.f12322e.f12320i.i(i2));
        }

        public /* synthetic */ c(CoverFlowView coverFlowView, a aVar) {
            this(coverFlowView);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverFlowView f12323e;

        public d(CoverFlowView coverFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12323e = coverFlowView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            d.a.r0.r.w.b.a i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12323e.o == null || !(view.getTag() instanceof Integer) || (i2 = this.f12323e.f12320i.i((intValue = ((Integer) view.getTag()).intValue()))) == null) {
                return;
            }
            this.f12323e.o.b(intValue, i2.b());
        }

        public /* synthetic */ d(CoverFlowView coverFlowView, a aVar) {
            this(coverFlowView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowView(Context context) {
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
        this.f12319h = null;
        this.k = new b(this, null);
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d(this, null);
        this.q = new c(this, null);
        this.r = 5000L;
        p(context);
    }

    private boolean getAutoPlayPlayDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.m : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65551, this, i2) == null) {
            int count = this.f12320i.getCount();
            if (i2 == 0) {
                this.f12317f.setPosition(0.0f);
            } else if (i2 == count - 1) {
                this.f12317f.setPosition(i2);
            } else {
                this.f12317f.setPosition(i2 - 1);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.k.hasMessages(1)) {
            return;
        }
        v();
    }

    public final boolean m() {
        InterceptResult invokeV;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CoverFlowAdapter<T> coverFlowAdapter = this.f12320i;
            if (coverFlowAdapter != null && (count = coverFlowAdapter.getCount()) > 1) {
                int currentItem = this.f12316e.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    this.f12316e.setCurrentItem(i2, false);
                    this.f12316e.invalidate();
                } else if (currentItem > i2) {
                    this.f12316e.setCurrentItem(1, false);
                    this.f12316e.invalidate();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public T n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            CoverFlowAdapter<T> coverFlowAdapter = this.f12320i;
            if (coverFlowAdapter == null) {
                return null;
            }
            return coverFlowAdapter.i(i2);
        }
        return (T) invokeI.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && m()) {
            t();
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            r(context);
            q(context);
            setCoverFlowFactory(new d.a.r0.r.w.b.b());
            addView(this.f12316e);
            addView(this.f12317f);
            CoverFlowAdapter<T> coverFlowAdapter = new CoverFlowAdapter<>(context);
            this.f12320i = coverFlowAdapter;
            coverFlowAdapter.m(this.p);
            this.f12316e.setAdapter(this.f12320i);
            this.f12316e.setOnPageChangeListener(this.q);
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            IndicatorView indicatorView = new IndicatorView(context);
            this.f12317f = indicatorView;
            indicatorView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.f12316e = new ListViewPager(context);
        }
    }

    public void s() {
        d.a.r0.r.w.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f12320i.j();
            IndicatorView indicatorView = this.f12317f;
            if (indicatorView == null || (cVar = this.f12318g) == null) {
                return;
            }
            indicatorView.setDrawable(SkinManager.getDrawable(cVar.a()));
            this.f12317f.setSelector(SkinManager.getDrawable(this.f12318g.b()));
        }
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.n = z;
        }
    }

    public void setCallback(d.a.r0.r.w.b.d<T> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            this.o = dVar;
        }
    }

    public void setCoverFlowFactory(d.a.r0.r.w.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null) {
            return;
        }
        this.j = aVar;
        d.a.r0.r.w.b.c a2 = aVar.a();
        this.f12318g = a2;
        a2.i(this.f12317f);
        aVar.c().b(this.f12316e);
        View b2 = aVar.b();
        this.f12319h = b2;
        if (b2 != null) {
            removeAllViews();
            addView(this.f12316e);
            addView(this.f12319h);
            addView(this.f12317f);
        }
    }

    public void setData(List<T> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f12320i.l(list, this.j);
        int size = list.size();
        if (size > 1) {
            this.f12317f.setVisibility(0);
            this.f12317f.setCount(size);
            this.f12316e.setCurrentItem(1, false);
            this.f12317f.setPosition(0.0f);
            if (this.n) {
                v();
                return;
            }
            return;
        }
        this.f12317f.setVisibility(8);
        this.f12317f.setCount(size);
        this.f12316e.setCurrentItem(1, false);
        this.f12317f.setPosition(0.0f);
        w();
    }

    public void setDisableParentEvent(boolean z) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (listViewPager = this.f12316e) == null) {
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
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (indicatorView = this.f12317f) == null) {
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
            this.r = j;
            t();
        }
    }

    public void setPageMargin(int i2) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (listViewPager = this.f12316e) == null) {
            return;
        }
        listViewPager.setPageMargin(i2);
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) || (listViewPager = this.f12316e) == null) {
            return;
        }
        listViewPager.setSwipeControlInterface(cVar);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.k.removeMessages(1);
            this.k.sendEmptyMessageDelayed(1, this.r);
        }
    }

    public final void u() {
        CoverFlowAdapter<T> coverFlowAdapter;
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.f12316e == null || (coverFlowAdapter = this.f12320i) == null || (count = coverFlowAdapter.getCount()) <= 1) {
            return;
        }
        int currentItem = this.f12316e.getCurrentItem();
        int i2 = count - 2;
        if (currentItem < 1) {
            this.f12316e.setCurrentItem(i2, false);
        } else if (currentItem > i2) {
            this.f12316e.setCurrentItem(1, false);
        } else {
            this.f12316e.setCurrentItem(currentItem + 1);
        }
        this.f12316e.invalidate();
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            t();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.k.removeMessages(1);
        }
    }

    public void x(e eVar) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, eVar) == null) || eVar == null || (listViewPager = this.f12316e) == null) {
            return;
        }
        eVar.b(listViewPager);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f12319h = null;
        this.k = new b(this, null);
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d(this, null);
        this.q = new c(this, null);
        this.r = 5000L;
        p(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowView(Context context, AttributeSet attributeSet) {
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
        this.f12319h = null;
        this.k = new b(this, null);
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d(this, null);
        this.q = new c(this, null);
        this.r = 5000L;
        p(context);
    }
}
